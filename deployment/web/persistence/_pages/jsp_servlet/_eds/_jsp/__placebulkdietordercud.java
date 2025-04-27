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
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.util.ArrayList;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __placebulkdietordercud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/PlaceBulkDietOrderCUD.jsp", 1743595362398L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<link rel=\'StyleSheet1\' href=\'../../eCommon/html/body.css\' type=\'text/css\'/>\n\t<style type=\"text/css\">\n\t/*@import url(../../eDS/css/css2/themes/winxp/skin.css);*/\n\t@import url(../../eDS/css/skin.css);\n\t</style>\n\t\n\t<script language=\"JavaScript\" src=\"../../framework/js/PopupWindow.js\" type=\"text/javascript\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/navbar.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/simpletreemenu.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../framework/js/hashtable.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/PlaceBulkDietOrder.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n\t<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n\t<script language=\"javascript\" src=\"../../eDS/js/PlaceDietOrderPHIS.js\"></script>\n\t<!--ML-MMOH-CRF-427 starts-->\n\t\t\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/css/jquery-ui.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/timepicker.css\"/>  \n  \n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =".js\"></script>\n\t<!--ML-MMOH-CRF-427 ends-->\t\n\t<!-- ML-MMOH-CRF-428 starts -->\n\t<script src=\"../../eDS/js/Moment.js\"></script>\n\t<script src=\"../../eDS/js/MomentRange.js\"></script>\n\t<!-- ML-MMOH-CRF-428 ends -->\n\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\n\t<input type=\"hidden\" name=\"enableDrugYN\" id=\"enableDrugYN\" id=\"enableDrugYN\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\t<!--MMS-KH-CRF-0029.1-->\n\n\t<script type=\"text/javascript\">\n\t_NavBar_pageID = \"Home\"; /* disable the current page from the menu */\n\n\tvar profileSL;\n\tvar mealTypesArr = new Array();\n// \tparent.patientsObj =eval(\'(\' + parent.jsonObj + \')\');\n\tparent.patientsObj =parent.jsonObj;\n\t\n\tfunction hide(){\n\t\tdocument.getElementById(\"police_response1\").style.display = \'none\';\n\t\tdocument.getElementById(\"contentsForAssignDietType\").style.display = \'none\';\n\t\tdocument.getElementById(\"attendentListLayer\").style.display = \'inline\';\n\t\tdocument.getElementById(\"dietlistContentLayer\").style.display = \'none\';\n\t\tdocument.getElementById(\"attendent\").style.display = \'inline\';\n\t\tdocument.getElementById(\"pateint\").style.display = \'none\';\n\t\tdocument.getElementById(\"addAttendent\").style.display = \'inline\';\n\t\tdocument.getElementById(\"dietOrders\").style.display = \'none\';\n\t\tdocument.getElementById(\"dietselect\").style.display = \'none\';\n\t\tgetAttendDitypes();\n\t}\n\tfunction show(){\n\t\t document.getElementById(\"police_response1\").style.display = \'inline\';\n\t\t document.getElementById(\"contentsForAssignDietType\").style.display = \'inline\';\n\t\t document.getElementById(\"attendentListLayer\").style.display = \'none\';\n\t\t document.getElementById(\"dietlistContentLayer\").style.display = \'inline\';\n\t\t document.getElementById(\"attendent\").style.display = \'none\';\n\t\t document.getElementById(\"pateint\").style.display = \'inline\';\n\t\t document.getElementById(\"addAttendent\").style.display = \'none\';\n\t\t document.getElementById(\"dietOrders\").style.display = \'inline\';\n\t\t document.getElementById(\"dietselect\").style.display = \'inline\';\n\t}\n\n\tfunction checkStatus(status,object)\n\t{\t\n\t\tif(object)\n\t\t{\n\t\tfor(var i=0;i<object.length;i++)\n\t\t{\n\t\t\tif(status!=\"\")\n\t\t\t{\n\t\t\tif(object[i].value==status)\n\t\t\t{\n\t\t\t\tvar obj = document.all(object[i].value);\n\t\t\t\tif (obj) {\n\t\t\t\t\tif (obj.length > 1) {\n\t\t\t\t\t\tfor (var j = 0; j < obj.length; j++) {\n\t\t\t\t\t\t\tobj[j].style.display = \"inline\";\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\tobj.style.display = \"inline\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar obj = document.all(object[i].value);\n\t\t\t\tif (obj) {\n\t\t\t\t\tif (obj.length > 1) {\n\t\t\t\t\t\tfor (var k = 0; k < obj.length; k++) {\n\t\t\t\t\t\t\tobj[k].style.display = \"none\";\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\tobj.style.display = \"none\";\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar obj = document.all(object[i].value);\n\t\t\t\tif (obj) {\n\t\t\t\t\tif (obj.length > 1) {\n\t\t\t\t\t\tfor (var iter = 0; iter < obj.length; iter++) {\n\t\t\t\t\t\t\tobj[iter].style.display = \"inline\";\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\tobj.style.display = \"inline\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t }\n\t}\n\n\t// Added Start for AMRI-SCF-0385 [IN056722]\n\tfunction restrictSpecialChars(event){\n\t\tvar strCheck = \'~!@#$%^&*()+=`{}|[];:_-,/\\\\?<>\"\\\'\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  \n\t\tif (strCheck.indexOf(key) != -1) \n\t\t{\n\t\t\twindow.event.keyCode = 27;\n\t\t\treturn false;  \n\t\t}\n\t\treturn true;\n\t\t}\n// Added End for AMRI-SCF-0385 [IN056722]\n    </script>\n</head>\n\n<!-- <body onmouseup=\"disabledField();\" onload=\"fecthMealContents();getSysDate();\"> -->\n<body onload=\"onloadPage();getSysDate();fetchDietType(this.value);\">\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script><!--Added Against ML-MMOH-CRF-0672-->\n\t<form id=\"input\" name=\"PlaceDietOrderForm\" id=\"PlaceDietOrderForm\"  action=\"../../servlet/eDS.PlaceDietOrderServlet\" target=\"messageFrame\" onsubmit=\"checkNull();\">\n\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t<tr>\n\t<td>\n\t<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" bordercolor=\"#9999FF\" height=\"100%\">\n\t<TR>\n\t<td colspan=\"3\" style=\"background-color:grey\"><br/><font size=\"4\"><b>Group Order</b><br/></font>\n\t<br/>\n\t<br/>\n\t</td></tr>\n\t<tr>\n\t<div style=\"overflow-y: scroll;overflow-x: scroll;\">\n\t<td valign=\"top\" width=\"20%\">\n\t<br/>\n\t<br/>\n\t\n\t<div style=\"height:90%; overflow:auto;\">\n\t\t<table width=\"100%\" border=\"1\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" id=\"patientList\">\n\t\t\t<tr>\n\t\t\t\t<th colspan=\"4\" align=\"center\" >Selected Patients</th>\n\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<th>Encounter ID</th>\n\t\t\t\t<th>Patient ID</th>\n\t\t\t\t<th>Special FoodItems&nbsp;&nbsp;<input type=\"checkbox\" name=\"chk_spl_checkAll\" id=\"chk_spl_checkAll\" id=\"spl_checkAll\" onclick=\"checkAll_Spl()\"/></th>\n\t\t\t\t<th>Food Dislikes\t<input type=\"checkbox\" name=\"chk_dislike_checkAll\" id=\"chk_dislike_checkAll\" id=\"dislike_checkAll\" onclick=\"checkAll_Dislikes()\"/></th>\n\t\t\t</tr>\n\t\t</table>\t\n\t </div>\n\t</td>\n\t</div>\n\t<td width=\"60%\" valign=\"top\">\n\t<div overflow=\"auto\">\n\t<br/>\n\t<left>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<br />\n\t<table width=\"100%\">\n\t<tr>\n\t\t<td align=\"center\" valign=\"top\" colspan=\"2\">\n\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr>\n\t\t<td>\n\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\" id=\"pateint\" style=\"display:inline;\">\n\t\t<tr>\n\t\t<th align=\"left\" valign=\"top\" colspan=\"6\" width=\"50%\">\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</th>\n\t</tr>\n\t\t\t\t\t\t\t\t\n\t<!--ML-MMOH-CRF-0684 Starts-->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr>\n\t\t\t<td class =\"label\" align =\"right\">\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td>\n\t\t   <select name=\"menu_type\" id=\"menu_type\" id = \"menu_type\">\n\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t  <option value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" selected>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t  </option>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t </option>\n\t\t   ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</select><img id=\"dietCatImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\n\t\t </select>\n\t\t</td>\n\t </tr>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<!--ML-MMOH-CRF-0684 Ends-->\n\t<tr>\n\t\t<td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<td nowrap>\n\t\t<!-- \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"dietCategory\" id=\"dietCategory\" onchange=\"return fecthDietType(this.value);fecthDietTypeToMealClass();\"> -->\n\t\t<select name=\"dietCategory\" id=\"dietCategory\" onchange=\"checkExclusions_select(this);return fetchDietType(this.value);fecthDietTypeToMealClass();onloadItems();\">\t\n\t\t<option>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" selected>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</option>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t<td nowrap>\n\t\t\t<!--orginal starts\n\t\t\t\t<input type=\"text\" name=\"dateFrom\" id=\"dateFrom\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this)\">\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateFrom\');\">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t<input type=\"hidden\" name=\"testDate\" id=\"testDate\" size=\"8\" />\n\t\t\t\torignal ends\n\t\t\t\t-->\n\t\t\t\t<input type=\"text\" name=\"dateFrom\" id=\"dateFrom\" id=\"dateFrom\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this)\" onchange=\"onloadItems();checkExclusions(this);\">\n\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\t\t\t\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg\' id=\'datepickerimg\' onclick=\"grayOutCalendar(\'dateFrom\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\">\t\n\t\t\t\t<img id=\"fromDateImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateFrom\');\">\n\t\t\t\t<img id=\"fromDateImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\n\t\t\t\t<!--ML-MMOH-CRF-0427 US3 ends-->\n\t\t\t\t<input type=\"hidden\" name=\"testDate\" id=\"testDate\" size=\"8\" />\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t<td>\n\t\t\t\t\t<!--\n\t\t\t\t\t<input type=\"text\" name=\"dateTo\" id=\"dateTo\" id=\"dateTo\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this)\">\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateTo\');\">\n\t\t\t\t\t<input type=\'hidden\' name=\'dateTo.pattern\' id=\'dateTo.pattern\' value=\'dd/MM/yyyy\'>-->\n\t\t\t\t\t<input type=\"text\" name=\"dateTo\" id=\"dateTo\" id=\"dateTo\" class=\'chkFormChange\' size=\"10\" maxlength=\"10\" value=\"\" onchange=\"onloadItems();checkExclusions(this);\">\n\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg\' id=\'datepickerimg\' onclick=\"grayOutCalendar(\'dateTo\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\">\n\t\t\t\t\t<img id=\"dateToImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateTo\');\">\n\t\t\t\t\t<img id=\"dateToImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'dateTo.pattern\' id=\'dateTo.pattern\' value=\'dd/MM/yyyy\'>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t<td nowrap>\n\t\t\t\t<select name=\"mealClass\" id=\"mealClass\" onchange=\"checkExclusions_select(this);fecthDietTypeToMealClass();onloadItems();\">\n\t\t\t\t\t<option>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"right\" class=\"label\" nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t<td nowrap>\n\t\t\t\t\t<select name=\"dietType\" id=\"dietType\" onKeyUp=\"diettype_Autocomplete();\" onClick=\"Select()\" onchange=\"checkExclusions_select(this);fecthDietTypeToMealClass();onloadItems();\"><!--Modified against ML-MMOH-CRF-0674-->\n\t\t\t\t\t\t<option>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<tr id=\"police_response1\" style=\"display:inline;\">\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t<select name=\"feedType\" id=\"feedType\">\n\t\t\t\t\t<option>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t<select name=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" indexed=\"10\">\n\t\t\t\t\t<option>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t\t\t<!--ML-MMOH-CRF-0412 STARTS-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t<select name=\"texture_of_diet\" id=\"texture_of_diet\" indexed=\"10\">\n\t\t\t\t\t<option>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap></td>\n\t\t\t\t\t<td></td>\n\t\t\t\t</tr>\n\t\t\t\t<!--ML-MMOH-CRF-0412 ENDS-->\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t<td><textarea name=\"feedingInstructions\" onkeypress=\"restrictSpecialChars(event)\"></textarea></td> <!-- Added for AMRI-SCF-0385 [IN056722] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>\n\t\t\t\t\t<!-- Modified Against Start ML-MMOH-CRF-0668 [IN:062263] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t<!-- Modified Against End ML-MMOH-CRF-0668 [IN:062263] -->\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<td><textarea name=\"prepInstr\"  cols=\'35\' onblur=\"textAreaLimit(this,4000);\"onkeypress=\"restrictSpecialChars(event)\"></textarea></td><!-- Added for AMRI-SCF-0385 [IN056722] -->\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\" id=\"attendent\" style=\"display:none;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th align=\"left\" valign=\"top\" colspan=\"2\" width=\"45%\"><fmtmessage key=\"eOT.patientAttendantTitle.Label\" bundle=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" /></th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"attendentFromDate\" id=\"attendentFromDate\" maxlength=\"10\" onBlur=\'isValidDate(this)\' size=\"10\" >\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'attendentFromDate\');\">\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"attendentToDate\" id=\"attendentToDate\" size=\"10\" maxlength=\"10\" onBlur=\'isValidDate(this)\' >\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'attendentToDate\');\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'attendentToDate.pattern\' id=\'attendentToDate.pattern\' value=\'dd/MM/yyyy\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td nowrap>\n\t\t\t\t\t\t<select name=\"attendentMealClass\" id=\"attendentMealClass\">\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td nowrap>\n\t\t\t\t\t\t<select name=\"attendentDiet\" id=\"attendentDiet\">\n\t\t\t\t\t\t\t<option>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\"2\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr id=\"contentsForAssignDietType\" style=\"display:inline;\">\n\t\t\t<TD>\n\t\t\t\t<div id=\"listContentLayer1\" style=\"display:block;visibility:visible;overflow-n: scroll;height:20;width:450;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t\t\t<TABLE width=\"100%\" id=\"Able1\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TH colspan=\"3\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t</TH>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TABLE>\n\t\t\t\t\t<div id=\"listContentLayer\" style=\"display:block;visibility:visible;overflow-y: scroll;height:98;width:450;border: 0px outset #9999FF\" align=\"center\">\n\t\t\t\t\t\t<TABLE width=\"100%\" id=\"Able\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</TD>\n\t\t\t<TD>\n\t\t\t<div id=\"NilByMounth\" style=\"display:block;visibility:visible;height:116;width:250;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t<TABLE class=\"webglobeBoxBorder\" width=\"100%\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t\t<TR>\n\t\t\t\t\t<TH colspan=\"2\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t</TH>\n\t\t\t\t</TR>\n\t\t\t\t<TR>\n\t\t\t\t\t<TD class=\"label\" NOWRAP>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t</TD>\n\t\t\t\t\t<!-- <TD>\n\t\t\t\t\t\t<input type=\"text\" name=\"from\" id=\"from\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this);\" >\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'from\');\">\n\t\t\t\t\t</TD> -->\n\t\t\t\t\t<TD>\n\t\t\t\t\t<!--MMS-QH-CRF-0078.1-US003 58572-->\n\t\t\t\t\t\t<input type=\"text\" name=\"from\" id=\"from\" id=\"from\" size=\"16\" value=\"\" onblur=\"if(this.value!=\'\') validateDate(this,this.value)\">\n\t\t\t\t\t\t<!--img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'from\',\'%d/%m/%Y %H:%M\',\'24\',true,\'from\');\"/-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return grayOutCalendarDateTime(\'from\',\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\');\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\n\t\t\t\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'from\',\'%d/%m/%Y %H:%M\',\'24\',true,\'from\');\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 ends-->\t\t\t\t\t\t\t\n\t\t\t\t\t</TD>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</TR>\n\t\t\t\t<TR>\n\t\t\t\t\t<TD class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD>\n\t\t\t\t\t\t<!-- <input type=\"text\" name=\"to\" id=\"to\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this);\" >\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'to\');\"> -->\n\t\t\t\t\t\t<!--MMS-QH-CRF-0078.1-US003 58572-->\n\t\t\t\t\t\t<input type=\"text\" name=\"to\" id=\"to\" id=\"to\" size=\"16\" value=\"\" onblur=\"if(this.value!=\'\') validateToDate(this,this.value)\" >\n\t\t\t\t\t\t<!--img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'to\',\'%d/%m/%Y %H:%M\',\'24\',true,\'to\');\"/-->\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 Starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return grayOutCalendarDateTime(\'to\',\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'to\',\'%d/%m/%Y %H:%M\',\'24\',true,\'to\');\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 ends-->\t\t\t\t\t\t\t\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t</div>\n\t\t\t</TD>\n\t\t</tr>\n\t</table>\n<br/>\n<br/>\n<div id=\"attendentListLayer\" style=\"display:none;visibility:visible;overflow-y: scroll;height:100;width:100%;border: 1px outset #9999FF\" align=\"center\">\n\t<table width=\"100%\" summary=\"asd\">\n\t\t<tr>\n\t\t<td>\n\t\t<table width=\"100%\" summary=\"asd\" id=\"attendentListTable\">\n\t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</th>\n\t\t\t\t<th colspan=\"2\"></th>\n\t\t\t</tr>\n\t\t</table>\n\t\t</Td>\n\t\t</tr>\n\t</table>\n</div>\n<br/>\n<table align=\"right\" id=\"addAttendent\" style=\"display:none;\">\n\t<tr>\n\t\t<td align=\"right\" class=\"data\">\n\t\t\t<a href=\"javascript:callBlank()\" onclick=\"return checkDates();\"><br>+ ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</a>\n\t\t</td>\n\t</tr>\n</table>\n</div>\n<br/>\n<br/>\n<br/>\n<br/>\n<br/>\n<br/>\n<br/>\n<br/>\n<br/>\n<br/>\t\t\t\t\t\t\t\n</td>\n<td valign=\"top\" align=\"left\" width=\"20%\"  >\n\t<div style=\"width:110%;overflow-n:border: 1px ;scroll;height:70;width:100%;\">\n\t\t<table id=\"tableData\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"left\">\n\t\t<tr align=\"left\">\n\t\t\t<td style=\"text-align: left\" class=\"label\" id=\"as\" colspan=\"2\" NOWRAP>\n\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" :\n\t\t\t</td>\n\t\t\t<td style=\"text-align: left\" class=\"label\" id=\"as\" colspan=\"2\" NOWRAP>\n\t\t\t<input type=\"text\" name=\"dateForMenu\" id=\"dateForMenu\" id=\"dateForMenu\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this),getDayRefNo(this.value);\">\n\t\t\t\t<!--\n\t\t\t\t<input type=\"text\" name=\"dateForMenu\" id=\"dateForMenu\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this),getDayRefNo(this.value);\">\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateForMenu\');\">\n\t\t\t\t\t-->\n\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\t\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\t\t\t\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg_1\' id=\'datepickerimg_1\' onclick=\"grayOutCalendar(\'dateForMenu\',\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\')\">\n\t\t\t\t\t<!--img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'dateForMeanu\',\'%d/%m/%Y %H:%M\',\'24\',true,\'to\');\"/-->\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateForMenu\');\">\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t\t\n\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\t\t\t\t\t\t\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td style=\"text-align: left\" class=\"label\" colspan=\"2\" NOWRAP>\n\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" :\n\t\t\t</td>\n\t\t\t<td style=\"text-align: left\" class=\"label\" id=\"as\" colspan=\"2\" NOWRAP >\n\t\t\t\t<select name=\"dayRef\" id=\"dayRef\" onchange=\"setdayRef(this)\" disabled=\"disabled\">\n\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t</option>\n\t\t\t\t</select>\n\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" class=\"button\" onClick=\"getMenuForDayRef();\" />\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td>&nbsp;&nbsp;&nbsp;<td></tr>\n\t\t<tbody id=\"dispGTC\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\">\n\t\t</tbody>\n\t</table>\n\t</div>\n\t<table>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t<div id=\"SideMenu\" style=\"visibility:visible;overflow-y: scroll\"></div>\n\t\t\t<div id=\"html-section\" title=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' style=\"width:100%;overflow-y: scroll;height:350;width:100%;\">\n\t\t\t<table border=\"1\">\n\t\t\t<tbody id=\"treemenu3\" align=\"left\" BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t<tbody id=\"treemenu4\" align=\"left\" BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t<tr>\n\t\t\t<td>\n\t\t\t<br/>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t<div id=\"spFoodItems\" style=\"width:100%;overflow-y: scroll;height:60;width:100%;\">\n\t\t\t<table border=\"1\">\n\t\t\t\t<tbody id=\"FoodItems\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"data\" ></tbody>\n\t\t\t\t<tbody id=\"FoodItems1\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td id=\"splFoodItem_flow_text\" align=\"right\" class=\"label\" colspan=\"9\"\n\t\t\t\t\tonclick=\"return spFoodItemsModalWindow(this,\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\',\'\');\" align=\"right\" class=\"label\" colspan=\"9\" disabled>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div id=\"foodDislikes\" style=\"width:100%;overflow-y: scroll;height:45;width:100%;\">\n\t\t\t<table border=\"0\">\n\t\t\t\t<tbody id=\"DislikesFoodItems\"></tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td id=\"foodItem_dislike_flow_text\" onclick=\"return foodDislikesModelWindow(this);\" align=\"right\" class=\"label\" colspan=\"2\" disabled>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div id=\"mealTypeExclusions\" style=\"width:100%;overflow-y: scroll;height:105;width:100%;\">\n\t\t\t<table border=\"0\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td id=\"exclusions_flow_text\" onclick=\"return openExclusionsWindow(this);\" align=\"right\" class=\"label\" colspan=\"2\" >\n\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tbody id=\"exclusions\"></tbody>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t</table>\n\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t</td>\n\t\t</tr>\n\t</table>\n</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n\t\t<input type=\"hidden\" name=\"GEN_MEALPLAN_FOR_NBM_PAT_YN\" id=\"GEN_MEALPLAN_FOR_NBM_PAT_YN\" id=\"GEN_MEALPLAN_FOR_NBM_PAT_YN\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" /><!-- MMS-QH-CRF-0078.1-US003-->\n\t\t<input type=\"hidden\" name=\"profileFlag\" id=\"profileFlag\" id=\"profileFlag\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" /><!--ML-MMOH-CRF-0427-->\n\t\t<input type=\"hidden\" name=\"restrict_date_inpatients_yn\" id=\"restrict_date_inpatients_yn\" id=\"restrict_date_inpatients_yn\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" /><!--ML-MMOH-CRF-0427-->\n\t\t<input type=\"hidden\" name=\"maximum_days_allowed\" id=\"maximum_days_allowed\" id=\"maximum_days_allowed\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" /><!--ML-MMOH-CRF-0427-->\n\t\t<input type=\"hidden\" name=\"IRREGULAR_DIET_ORD_YN\" id=\"IRREGULAR_DIET_ORD_YN\" id=\"IRREGULAR_DIET_ORD_YN\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" /><!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"IRREGULAR_MEAL_ORD_MESSAGE\" id=\"IRREGULAR_MEAL_ORD_MESSAGE\" id=\"IRREGULAR_MEAL_ORD_MESSAGE\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" /> <!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"irregular_meal_code\" id=\"irregular_meal_code\" id=\"irregular_meal_code\" value=\"\" /> <!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"dietTypesStatus\" id=\"dietTypesStatus\" id=\"dietTypesStatus\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"/> <!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"patientClass\" id=\"patientClass\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" /><!--ML-MMOH-CRF-0820-->\n\t\t\t<!-- Added against ML-MMOH-CRF-0674 Starts Here-->\n\t\t<INPUT type=\"hidden\" name=\"diettype_auto\" id=\"diettype_auto\" id=\"diettype_auto\" value=\"\">\n\t\t<INPUT type=\"hidden\" name=\"auto_flag\" id=\"auto_flag\" id=\"auto_flag\" value=\"false\">\n\t\t<!-- Added against ML-MMOH-CRF-0674 Ends Here-->\n\t\t\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t<input type=\"hidden\" name=\"kitchenCode\" id=\"kitchenCode\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t<input type=\"hidden\" name=\"profileSL\" id=\"profileSL\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"profileSL1\" id=\"profileSL1\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" />\n\t\t<input type=\"hidden\" name=\"addedFacilityId\" id=\"addedFacilityId\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" />\n\t\t<input type=\"hidden\" name=\"Patient_ID\" id=\"Patient_ID\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" />\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t<input type=\"hidden\" name=\"locationType\" id=\"locationType\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" />\n\t\t<input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" />\n\t\t<input type=\"hidden\" name=\"addedById\" id=\"addedById\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" />\n\t\t<input type=\"hidden\" name=\"addedAtWsNo\" id=\"addedAtWsNo\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" />\n\t\t<input type =\"hidden\" name=\"defalutDietType\" id=\"defalutDietType\" />\n\t\t<input type =\"hidden\" name=\"defalutMealType\" id=\"defalutMealType\" />\n\t\t<input type =\"hidden\" name=\"dietTypesStatus\" id=\"dietTypesStatus\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"/>\n\t\t<input type=\"hidden\" name=\"mealTotalCalorie\" id=\"mealTotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"datepattrn1\" id=\"datepattrn1\" value=\"dd/MM/yyyy\"/>\n\t\t<input type=\"hidden\" name=\"isNEW\" id=\"isNEW\" />\n\t\t<input type=\"hidden\" name=\"orderID\" id=\"orderID\" />\n\t\t<input type=\"hidden\" name=\"ageGroupCode1\" id=\"ageGroupCode1\"  />\n\t\t<input type=\"hidden\" name=\"ageGroupArr\" id=\"ageGroupArr\"  />\n\t\t<input type=\"hidden\" name=\"nFITotalCalorie\" id=\"nFITotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"splFITotalCalorie\" id=\"splFITotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"mealTotalCalorie\" id=\"mealTotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"dieticianReferral\" id=\"dieticianReferral\" value=\"\">\n\t\t<INPUT type=\"hidden\" name=\"isAttendantAge\" id=\"isAttendantAge\" id=\"isAttendantAge\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t<!-- Added Against ML-MMOH-CRF-0671[IN:062266] -->\n\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t<INPUT type=\"hidden\" name=\"feedingInstructions\" id=\"feedingInstructions\" id=\"feedingInstructions\" value=\"\">\n\t\t\t<INPUT type=\"hidden\" name=\"feedType\" id=\"feedType\" id=\"feedType\" value=\"\">\n\t\t\t<INPUT type=\"hidden\" name=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" value=\"\">\n\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t<INPUT type=\"hidden\" name=\"isMenuType\" id=\"isMenuType\" id=\"isMenuType\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"><!--ML-MMOH-CRF-0684-->\n\t\t<INPUT type=\"hidden\" name=\"isAlaCarte\" id=\"isAlaCarte\" id=\"isAlaCarte\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\"> <!-- Added Against ML-MMOH-CRF-1123-US3 -->\n\t\t<script type=\"text/javascript\" src=\"../../eDS/js/setupmenu.js\"></script>\n\t\t<INPUT type=\"hidden\" name=\"encounter\" id=\"encounter\" value=\"\">\t\t<!--MMS-KH-CRF-0029.1-->\n\t\t<INPUT type=\"hidden\" name=\"remarkDrugAlert\" id=\"remarkDrugAlert\" value=\"\">\t<!--MMS-KH-CRF-0029.1-->\n\t\t<script type=\"text/javascript\">\n\n\t\tvar menu = new NavBar(\"SideMenu\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\', \"html-section\"); // look in the HTML code for a DIV with ID=\"html-section\"\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\', \"NutriEntSup\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\', \"spFoodItems\");<!-- Modified Against PMG2017-COMN-CRF-0012 [IN066074] -->\n\t\t//new NavSection(menu, \'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\', \"spFoodItems\");//5th Dec17\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\', \"foodDislikes\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\', \"Others\");\n\t\t//new NavSection(menu, \'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\', \"mealTypeExclusions\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\', \"mealTypeExclusions\",\"exc\");\n\t\tmenu.generate(true);\n\t\tmenu.sync(true);\n\t\t//$(\"#exc\")[0].onclick();\t\t//Commented for MMS-KH-CRF-0029.1\n\n\t\tif(document.getElementById(\"defalutMealType\").value){\n\t\t\tdocument.getElementById(\"mealClass\").value = document.getElementById(\"defalutMealType\").value;\n\t\t}\n\n/* \t\tif(document.getElementById(\"profileSL1\") != null && document.getElementById(\"profileSL1\") != \"\"){\n\t\t\tcheckStatus(\"\",document.all(\"status\"));\n\t\t\tdocument.getElementById(\"status\").value=\"\";\n\t\t} */\n\n\t\tfunction setdayRef(obj){\n\t\t\tdocument.getElementById(\"dayRef\").value=obj.value;\n\t\t}\n\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</form>\n</body>\n<script>\n\n\t\tvar encounter_ID = [];\n\t\tvar newRow = \"\";\n\t\tvar isLos_gt7=\"\"+";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =";//Added Against ML-MMOH-CRF-0672 \n\t\tfunction onloadPage(){\n\t\tfor(i=0;i<parent.patientsObj.patients.length;i++) {\n\t\t\tobj=parent.patientsObj.patients[i].patient;\n\t\t\tnewRow = document.all(\"patientList\").insertRow();\n\t\t\tnewRow.setAttribute(\"id\",\"patientRow\"+obj.encounterId);\n\t\t\tvar cell1=newRow.insertCell(0);\n\t\t\tcell1.innerHTML=\"<a id=\'delete\"+obj.encounterId+\"\' href = javascript:deletePatient(\'\"+obj.encounterId+\"\');><img src=\'../../eCommon/images/RRnwd.gif\'></img></a>\"+\"     \"+obj.encounterId;\n\t\t\tvar cell2=newRow.insertCell(1);\n\t\t\tcell2.innerHTML=\"<a href=\'javascript:selectPatient();\'>\"+obj.patientId+\"<div id=\'rem_\"+obj.encounterId+\"\' style=\'visibility:hidden\'>&nbsp;<a href=\'#\' onclick=\'return Remarks1(\"+obj.encounterId+\");\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147_0 ="<img id=\'MenuImage\"+obj.encounterId+\"\' src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img></div></a>\";\t//Added against MMS-KH-CRF-0029.1\n\t\t\tvar cell3=newRow.insertCell(2);\n\t\t\tcell3.textAlign=\"center\";\n\t\t\t//cell3.innerHTML=\"<p align=\'center\'><input type=\'checkbox\' name=\'chk_spl_\"+obj.encounterId+\"\' id=\'chk_spl_\"+obj.encounterId+\"\' id=\'spl_\"+obj.encounterId+\"\' onclick=\'check_SplFoodItems(\'\"+obj.encounterId+\"\')/></p>\";\n\t\t\t//Added Against ML-MMOH-CRF-0672 starts Here\n\t\t\tvar diffDays=obj.diffDays;\n\t\t\tif(isLos_gt7 ==\"true\" && isLos_gt7!=\"\" && diffDays > 7 && diffDays!=\"\")\n\t\t\t\tcell3.innerHTML=\"<p align=\'center\'><input type=\'checkbox\' name=\'chk_spl_\"+obj.encounterId+\"\' id=\'chk_spl_\"+obj.encounterId+\"\' id=\'spl_\"+obj.encounterId+\"\' onclick=\'check_SplFoodItems(\"+obj.encounterId+\")\'/><img  name=\'chk_spl_image\"+obj.encounterId+\"\' id=\'spl_image\"+obj.encounterId+\"\' src=\'../../eDS/css/food_item_los.jpg\' OnMouseOver=\'Tip(losToolTip(),JUMPHORZ,true)\' onmouseout=\'UnTip()\'></img></p>\";\n\t\t\telse\n\t\t\t\tcell3.innerHTML=\"<p align=\'center\'><input type=\'checkbox\' name=\'chk_spl_\"+obj.encounterId+\"\' id=\'chk_spl_\"+obj.encounterId+\"\' id=\'spl_\"+obj.encounterId+\"\' onclick=\'check_SplFoodItems(\"+obj.encounterId+\")\'/></p>\";\n\t\t\t//Added Against ML-MMOH-CRF-0672 Ends Here\n\t\t\tvar cell4=newRow.insertCell(3);\n\t\t\tcell4.innerHTML=\"<p align=\'center\'><input type=\'checkbox\' name=\'chk_dislike_\"+obj.encounterId+\"\' id=\'chk_dislike_\"+obj.encounterId+\"\' id=\'dislike_\'\"+obj.encounterId+\"\' onclick=\'check_FoodDislikes(\"+obj.encounterId+\",this)\'/></p>\";\n\t\t\n\t\t\tencounter_ID.push(obj.encounterId);\t//Added against MMS-KH-CRF-0029.1\n\t\t}\n\t\t}\n\t\t\n\t\t//Added against MMS-KH-CRF-0029.1 Starts Here\t\n\t\t\n\t\tfunction encounter_IDs()\n\t\t{\n\t\treturn encounter_ID;\t\n\t\t}\n\t\t\n\t\tfunction onloadItems(){\n\t\t\tvar deleteEncounter = [];\n\t\t\tvar enabledrugfoodYN = document.getElementById(\"enableDrugYN\").value;\t\t\n\t\t\tif(enabledrugfoodYN==\"Y\")\n\t\t\t{\n\t\t\tremark_yn = groupOrder(); \n\t\t\tdocument.getElementById(\"remarkDrugAlert\").value = remark_yn;\n\t\t\tvar remark_alert_yn = document.getElementById(\"remarkDrugAlert\").value;\n\t\t\tvar warning = remark_alert_yn.split(\",\");\n\t\tfor(i=0;i<parent.patientsObj.patients.length;i++) {\n\t\t\tobj=parent.patientsObj.patients[i].patient;\n\t\t\tvar retValLen = warning.length/2;\n\t\t\tvar count =0;\n\t\t\tvar drug_patient=[];\n\t\t\tvar countInc =1;\n\t\t\tfor(var k=1;k<=retValLen;k++){\n\t\t\tfor(var j=count;j<=countInc;j++)\n\t\t\t\t{\n\t\t\t\tdrug_patient.push(warning[j]);\t\n\t\t\t\t}\n\t\t\tif(trim(drug_patient[0])==\"N\" && trim(drug_patient[1])==obj.patientId)\n\t\t\t{\t\n\t\t\t\tdocument.getElementById(\"rem_\"+obj.encounterId).style.visibility = \'visible\';\t\n\t\t\t\tdocument.getElementById(\"MenuImage\"+obj.encounterId).style.visibility = \'visible\';\t\n\t\t\t}\n\t\t\telse if(trim(drug_patient[0])==\"Y\" && trim(drug_patient[1])==obj.patientId)\n\t\t\t{\n\t\t\t\tdeleteEncounter.push(obj.encounterId);\n\t\t\t}\n\t\t\tcount=count+2;\n\t\t\tcountInc = countInc+2;\n\t\t\tdrug_patient = [];\n\t\t\t}\n\t\t\t}\n\t\t\tdeleteDrugPatient(deleteEncounter);\n\t\t\t}}\n\t\t\n\t\tfunction deleteDrugPatient(encounterId) {\n\t\t\tvar outputArray = [];\n\t\t\tvar count = 0;\n\t\t\tvar start = false;\n\t\t\tfor (var m = 0; m < encounterId.length; m++) {\n\t\t\tfor(var k=0; k < outputArray.length; k++) {\n\t\t\tif(encounterId[m] == outputArray[k] ) {\n\t\t\tstart = true;\n\t\t\t}\n\t\t\t}\n\t\t\tcount++;\n\t\t\tif(count == 1 && start == false) {\n\t\t\toutputArray.push(encounterId[m]);\n\t\t\t}\n\t\t\tstart=false;\n\t\t\tcount=0;\n\t\t\t}\n\t\t\tvar uniqueEncounter =outputArray;\n\t\t\tfor(var j=0;j<uniqueEncounter.length;j++)\n\t\t\t{\n\t\t\t\tencounterId = uniqueEncounter[j];\n\t\t\tobj=parent.patientsObj.patients;\n\t\t\tvar flag=false;\n\t\t\tvar flag_spl=false;\n\t\t\tvar flag_dislike=false;\n\t\t\t\n\t\t\tif(obj.length==1) {\n\t\t\t\talert(getMessage(\"DS_SEL_PAT\",\"DS\")); //\"Atleast one patient should be selected\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tdocument.getElementById(\"chk_spl_\"+encounterId).checked=false; \n\t\t\tdocument.getElementById(\"chk_dislike_\"+encounterId).checked=false;\n\t\t\tif(isLos_gt7 ==\"true\" && isLos_gt7!=\"\" && diffDays > 7 && diffDays!=\"\")\n\t\t\t{\n\t\t\t\tvar splimageobj=document.getElementById(\"spl_image\"+encounterId);\n\t\t\tif(splimageobj != null && splimageobj != undefined && splimageobj !=\"\" && splimageobj !=\"null\" && splimageobj !=\"undefined\")\n\t\t\t\tdocument.getElementById(\"spl_image\"+encounterId).onmouseover=null;\n\t\t\t}\n\t\t\tif(splJSONObj.items !=null) {\n\t\t\t\tif((parseInt(jsonPatientArr_Spl.length) ==1) && parseInt(splJSONObj.items.length)!=0 ) {\n\t\t\t\t\tif(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\talert(\"Special Food Items is selected. Atleast one Special Food Item Check box should be selected\");\n\t\t\t\t\t\tdocument.getElementById(\"chk_spl_\"+encounterId).checked=true;\n\t\t\t\t\t\tflag=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse {\n\t\t\t\tif(parseInt(jsonPatientArr_Spl.length) ==1) {\n\t\t\t\t\tif(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\tdocument.getElementById(\"splFoodItem_flow_text\").disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\tdocument.getElementById(\"chk_spl_\"+encounterId).checked=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(dislikeJSONObj.items !=null) {\n\t\t\t\tif((parseInt(jsonPatientArr_Dislikes.length) ==1) && parseInt(dislikeJSONObj.items.length)!=0 ) {\n\t\t\t\t\tif(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\talert(\"Food Dislikes are selected. Atleast one Food Dislikes Check box should be selected\");\n\t\t\t\t\t\tdocument.getElementById(\"chk_dislike_\"+encounterId).checked=true;\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse {\n\t\t\t\tif(parseInt(jsonPatientArr_Dislikes.length) ==1) {\n\t\t\t\t\tif(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\tdocument.getElementById(\"foodItem_dislike_flow_text\").disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\tdocument.getElementById(\"chk_dislike_\"+encounterId).checked=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(flag==true)\t\t\t return; \n\t\t\t\n\t\t\tjsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);\n\t\t\t\n\t\t\tfor(var i=0;i<obj.length;i++) {\n\t\t\t\tvar encId=obj[i].patient.encounterId;\n\t\t\t\tchk=document.getElementById(\"chk_dislike_\"+encId);\n\t\t\t\tif(chk) {\n\t\t\t\t\tif(chk.checked==true) {\n\t\t\t\t\t\tjsonPatientArr_Dislikes.push({patient:obj[i].patient});\n\t\t\t\t\t\tdocument.getElementById(\"foodItem_dislike_flow_text\").disabled=false;\n\t\t\t\t\t\tflag_dislike=true;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tdocument.getElementById(\"chk_dislike_checkAll\").checked=false;\n\t\t\t\t\t}\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (flag_dislike==false)  document.getElementById(\"foodItem_dislike_flow_text\").disabled=true;\n\t\t\t\n\t\t\tjsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length)\n\t\t\t\n\t\t\tfor(var i=0;i<obj.length;i++) {\n\t\t\t\tvar encId=obj[i].patient.encounterId;\n\t\t\t\tchk=document.getElementById(\"chk_spl_\"+encId);\n\t\t\t\tif(chk) {\n\t\t\t\t\tif(chk.checked==true) {\n\t\t\t\t\t\tjsonPatientArr_Spl.push({patient:obj[i].patient});\n\t\t\t\t\t\tdocument.getElementById(\"splFoodItem_flow_text\").disabled=false;\n\t\t\t\t\t\tflag_spl=true;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tdocument.getElementById(\"chk_spl_checkAll\").checked=false;\n\t\t\t\t\t}\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t\tif (flag_spl==false)  document.getElementById(\"splFoodItem_flow_text\").disabled=true;\n\t\t\tfor(var i=0;i<obj.length;i++) {\n\t\t\t\tvar testObj=new Object();\n\t\t\t\ttestObj=obj[i];\n\t\t\t\tif(testObj.patient.encounterId==encounterId) {\n\t\t\t\t\tobj.splice(i,1);\n\t\t\t\tdocument.getElementById(\"delete\"+encounterId).href=\"#\";\n\t\t\t\tdocument.getElementById(\"patientRow\"+encounterId).disabled=true;\n\t\t\t}\n\t\t}\t\t\n\t\t}}\n\t\n\t//Added against MMS-KH-CRF-0029.1 Ends Here\t\n\t\n\t\tfunction selectPatient() {\n\t\t\t\n\t\t}\n\t\t\n\tfunction deletePatient(encounterId) {\n\t\t\tobj=parent.patientsObj.patients;\n\t\t\tvar flag=false;\n\t\t\tvar flag_spl=false;\n\t\t\tvar flag_dislike=false;\n\t\t\t\n\t\t\tif(obj.length==1) {\n\t\t\t\talert(getMessage(\"DS_SEL_PAT\",\"DS\")); //\"Atleast one patient should be selected\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tdocument.getElementById(\"chk_spl_\"+encounterId).checked=false; \n\t\t\tdocument.getElementById(\"chk_dislike_\"+encounterId).checked=false;\n\t\t\t//Added Against ML-MMOH-CRF-0672 starts Here \n\t\t\tif(isLos_gt7 ==\"true\" && isLos_gt7!=\"\" && diffDays > 7 && diffDays!=\"\")\n\t\t\t{\n\t\t\t\tvar splimageobj=document.getElementById(\"spl_image\"+encounterId);\n\t\t\tif(splimageobj != null && splimageobj != undefined && splimageobj !=\"\" && splimageobj !=\"null\" && splimageobj !=\"undefined\")\n\t\t\t\tdocument.getElementById(\"spl_image\"+encounterId).onmouseover=null;\n\t\t\t}\n\t\t\t//Added Against ML-MMOH-CRF-0672 Ends Here\n\t\t\tif(splJSONObj.items !=null) {\n\t\t\t\tif((parseInt(jsonPatientArr_Spl.length) ==1) && parseInt(splJSONObj.items.length)!=0 ) {\n\t\t\t\t\tif(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\talert(\"Special Food Items is selected. Atleast one Special Food Item Check box should be selected\");\n\t\t\t\t\t\tdocument.getElementById(\"chk_spl_\"+encounterId).checked=true;\n\t\t\t\t\t\tflag=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse {\n\t\t\t\tif(parseInt(jsonPatientArr_Spl.length) ==1) {\n\t\t\t\t\tif(jsonPatientArr_Spl[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\tdocument.getElementById(\"splFoodItem_flow_text\").disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\tdocument.getElementById(\"chk_spl_\"+encounterId).checked=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(dislikeJSONObj.items !=null) {\n\t\t\t\tif((parseInt(jsonPatientArr_Dislikes.length) ==1) && parseInt(dislikeJSONObj.items.length)!=0 ) {\n\t\t\t\t\tif(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\talert(\"Food Dislikes are selected. Atleast one Food Dislikes Check box should be selected\");\n\t\t\t\t\t\tdocument.getElementById(\"chk_dislike_\"+encounterId).checked=true;\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse {\n\t\t\t\tif(parseInt(jsonPatientArr_Dislikes.length) ==1) {\n\t\t\t\t\tif(jsonPatientArr_Dislikes[0].patient.encounterId == encounterId) {\n\t\t\t\t\t\tdocument.getElementById(\"foodItem_dislike_flow_text\").disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\tdocument.getElementById(\"chk_dislike_\"+encounterId).checked=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(flag==true)\t\t\t return; \n\t\t\t\n\t\t\tjsonPatientArr_Dislikes.splice(0,jsonPatientArr_Dislikes.length);\n\t\t\t\n\t\t\tfor(var i=0;i<obj.length;i++) {\n\t\t\t\tvar encId=obj[i].patient.encounterId;\n\t\t\t\tchk=document.getElementById(\"chk_dislike_\"+encId);\n\t\t\t\tif(chk) {\n\t\t\t\t\tif(chk.checked==true) {\n\t\t\t\t\t\tjsonPatientArr_Dislikes.push({patient:obj[i].patient});\n\t\t\t\t\t\tdocument.getElementById(\"foodItem_dislike_flow_text\").disabled=false;\n\t\t\t\t\t\tflag_dislike=true;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tdocument.getElementById(\"chk_dislike_checkAll\").checked=false;\n\t\t\t\t\t}\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (flag_dislike==false)  document.getElementById(\"foodItem_dislike_flow_text\").disabled=true;\n\t\t\t\n\t\t\tjsonPatientArr_Spl.splice(0,jsonPatientArr_Spl.length)\n\t\t\t\n\t\t\tfor(var i=0;i<obj.length;i++) {\n\t\t\t\tvar encId=obj[i].patient.encounterId;\n\t\t\t\tchk=document.getElementById(\"chk_spl_\"+encId);\n\t\t\t\tif(chk) {\n\t\t\t\t\tif(chk.checked==true) {\n\t\t\t\t\t\tjsonPatientArr_Spl.push({patient:obj[i].patient});\n\t\t\t\t\t\tdocument.getElementById(\"splFoodItem_flow_text\").disabled=false;\n\t\t\t\t\t\tflag_spl=true;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tdocument.getElementById(\"chk_spl_checkAll\").checked=false;\n\t\t\t\t\t}\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tif (flag_spl==false)  document.getElementById(\"splFoodItem_flow_text\").disabled=true;\n\t\t\t\n\t\t\tfor(v";
    private final static byte[]  _wl_block147_0Bytes = _getBytes( _wl_block147_0 );

    private final static java.lang.String  _wl_block147_1 ="ar i=0;i<obj.length;i++) {\n\t\t\t\tvar testObj=new Object();\n\t\t\t\ttestObj=obj[i];\n\t\t\t\tif(testObj.patient.encounterId==encounterId) {\n\t\t\t\t\tobj.splice(i,1);\n\t\t\t\tdocument.getElementById(\"delete\"+encounterId).href=\"#\";\n\t\t\t\tdocument.getElementById(\"patientRow\"+encounterId).disabled=true;\n\t\t\t}\n\t\t}\t\t\n\t}\n\t\n//Added against MMS-KH-CRF-0029.1 Starts Here\t\nvar remarks = \"\";\nasync function Remarks1(obj){\t\n\tvar remarkHdr = \"\";\n\tif(document.getElementById(\"rem_\"+obj).value != \"null\" &&  document.getElementById(\"rem_\"+obj).value != \"\" && remarks == \"\"){\n\t\tremarkHdr = document.getElementById(\"rem_\"+obj).value;\n\t}\n\tif(remarks != null || remarks == undefined){\n\t\tif(remarkHdr != \"\"){\n\t\t remarks = document.getElementById(\"rem_\"+obj).value;\n\t\t}\n\t\telse{\n\t\t remarkHdr = document.getElementById(\"rem_\"+obj).value;\n\t\t}\n\t}\n\telse{\n\t\tremarkHdr = \"\";\n\t}\n\tvar dialogUrl1 = \"../../eDS/jsp/Remarks.jsp?&remarkHdr=\"+encodeURIComponent(document.getElementById(\"rem_\"+obj).value);\n\tvar dialogArguments = remarks;\n\tvar dialogFeatures = \"dialogHeight:13;dialogWidth:28;status:no;scroll:yes\";\n\treturnRemarks = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);\n\tif(returnRemarks != null){\n\t\tdocument.getElementById(\"rem_\"+obj).value = returnRemarks;\n\t\tdocument.getElementById(\"MenuImage\"+obj).style.visibility = \'hidden\';\n\t}\n\tif(returnRemarks == undefined){\n\t\treturnRemarks = dialogArguments;\n\t}\n} \n\n//Added against MMS-KH-CRF-0029.1 Ends Here\t\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block147_1Bytes = _getBytes( _wl_block147_1 );
 
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
            _bw.write(_wl_block5Bytes, _wl_block5);
 
        //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";		

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		String strloggeduser	=  (String) httpSession.getValue("login_user");
		String strclientip ="";
		strclientip=p.getProperty("client_ip_address");

		String facility_id	= (String)session.getAttribute("facility_id");
		String language_Id  = (String)session.getAttribute("LOCALE");
		String ward_Code = request.getParameter("locationCode");
		String location_type = request.getParameter("locationType");
		String encounterId=	request.getParameter("encounterIds");
		String patientId=	request.getParameter("patientIds");
     	String patientClass=	request.getParameter("patientClass_bulk");//ML-MMOH-CRF-0820	
		String enableDrugYN="";	//MMS-KH-CRF-0029.1
		String restrict_date_inpatients_yn="",maximum_days_allowed="";//ML-MMOH-CRF-0427
		boolean profileFlag=true;//ML-MMOH-CRF-0427
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		Connection conn = null;
		conn = ConnectionManager.getConnection(request);
		//Added Against ML-MMOH-SCF-1874 Starts
		boolean isEnteral = false;
		isEnteral = CommonBean.isSiteSpecific(conn,"DS","DS_DIET_ENTERAL");
		
		//Added by Santhosh for ML-MMOH-SCF-2331 
		boolean isSpecialDiet = false;
		isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
	
		//Added Against ML-MMOH-SCF-1874 Ends
		//ML-MMOH-CRF-0684
		boolean isMenuType =false;
        	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");		
		//ML-MMOH-CRF-0684
		//KDAH-CRF-0349-US5 Start 
		boolean isDtCat_MlCls =false;
        	isDtCat_MlCls = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");		
		//KDAH-CRF-0349-US5 End
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
		String kitchen_Code =  "";
		String prfSL = "";
		String acceptDietForIndMealYn = "";
		String GEN_MEALPLAN_FOR_NBM_PAT_YN="";//MMS-QH-CRF-0078.1-US003
		String IRREGULAR_DIET_ORD_YN="",IRREGULAR_MEAL_ORD_MESSAGE="";//ML-MMOH-CRF-409
		//Added Against Start ML-MMOH-CRF-0671 and 0668
		boolean isAttendantAge = false;
		isAttendantAge = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
		//Added Against End ML-MMOH-CRF-0671 and 0668
		
		//Added Against ML-MMOH-CRF-0672 Starts Here
	 	boolean isLos_gt=false;
		isLos_gt = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
		//Added Against ML-MMOH-CRF-0672 Ends Here		
		
		try{
			String sql_ward_Code = "select ward_Code, kitchen_Code from Ds_Wards_For_Kitchen where operating_Facility_Id ='"+facility_id+"' and ward_Code ='"+ward_Code+"'";
			String profileSL_query = "SELECT NVL(MAX(PROFILE_SL),0) FROM DS_EPSD_DIET_PROFILE_HDR WHERE ENCOUNTER_ID ='"+encounterId+"'";
			String acceptMealDiet_query = "select ACCEPT_DIET_FOR_IND_MEAL_YN,GEN_MEALPLAN_FOR_NBM_PAT_YN,restrict_date_inpatients_yn,nvl(maximum_days_allowed,'1') maximum_days_allowed,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";//ML-MMOH-CRF-0427 and  MMS-QH-CRF-0078.1-US003 and ML-MMOH-CRF-409
			pstmt = conn.prepareStatement(sql_ward_Code);
			pstmt1 = conn.prepareStatement(profileSL_query);
			pstmt2 = conn.prepareStatement(acceptMealDiet_query);
			rs	= pstmt.executeQuery();
// 			rs1	= pstmt1.executeQuery();
			rs2	= pstmt2.executeQuery();
			
			while(rs != null && rs.next()){
				ward_Code=rs.getString(1);
				kitchen_Code=rs.getString(2);
			}
			while(rs1 != null && rs1.next()){
				prfSL = rs1.getString(1);
			}
			if(rs2 != null && rs2.next()){
				acceptDietForIndMealYn = rs2.getString(1);
				GEN_MEALPLAN_FOR_NBM_PAT_YN=checkForNull(rs2.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN"));//MMS-QH-CRF-0078.1-US003
				//ML-MMOH-CRF-0427
				restrict_date_inpatients_yn=checkForNull(rs2.getString("restrict_date_inpatients_yn"));
				maximum_days_allowed=checkForNull(rs2.getString("maximum_days_allowed"));
				maximum_days_allowed=""+(Integer.parseInt(maximum_days_allowed)-1);
				//ML-MMOH-CRF-0427
				//ML-MMOH-CRF-409 Starts
				IRREGULAR_DIET_ORD_YN=checkForNull(rs2.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP"));
				IRREGULAR_MEAL_ORD_MESSAGE=checkForNull(rs2.getString("IRREGULAR_MEAL_ORD_MESSAGE"));
				//ML-MMOH-CRF-409 Ends
			}
			
			//ML-MMOH-CRF-0427
			if(restrict_date_inpatients_yn.equals("Y")){
				profileFlag=true;
			}
			else
			{
				profileFlag=false;
			}
			//ML-MMOH-CRF-0427
			//MMS-KH-CRF-0029.1-US008 Start
			String enableDrugFood="select ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
				pstmt3=conn.prepareStatement(enableDrugFood);					
				rs3=pstmt3.executeQuery();
				while(rs3 != null && rs3.next()){
					enableDrugYN=checkForNull(rs3.getString(1));
				}
				if(rs3!=null) rs3.close();
				if(pstmt3!=null) pstmt3.close();
			//MMS-KH-CRF-0029.1-US008 Ends
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(enableDrugYN));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(isMenuType){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

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
			 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(MenuTypecode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(MenuTypedescription));
            _bw.write(_wl_block18Bytes, _wl_block18);

			 }
			else
			 {								
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(MenuTypecode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(MenuTypedescription));
            _bw.write(_wl_block20Bytes, _wl_block20);

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
		 
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

			try{
				conn = ConnectionManager.getConnection(request);
				String dietCategoryCode = "";
				String description =  "";
				//String sql_diet_Category = "select diet_Category_Code,description from Ds_Diet_Category_Lang_Vw where language_Id ='"+language_Id+"'";
				String sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,'"+language_Id+"', 1) description from Ds_Diet_Category";
				pstmt = conn.prepareStatement(sql_diet_Category);
				rs	= pstmt.executeQuery();
				while(rs != null && rs.next()){
				dietCategoryCode=rs.getString(1);
				description=rs.getString(2);
				if(isSpecialDiet){
					if(!dietCategoryCode.equals("SD01")){	
					if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
						if(alaCarte.equalsIgnoreCase("AC")){
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }else{
						
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(description));
            _bw.write(_wl_block30Bytes, _wl_block30);
 }}
					else if(dietCategoryCode.equals("THEU") && isDtCat_MlCls){
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(description));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
					} //End of dietCategoryCode
				} else if(isEnteral){//Added Against ML-MMOH-CRF-1123-US3 Starts Here	//Added if condition Against ML-MMOH-SCF-1874
				if(!dietCategoryCode.equals("ENTE")){	
				if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
					if(alaCarte.equalsIgnoreCase("AC")){
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block35Bytes, _wl_block35);
 }else{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(description));
            _bw.write(_wl_block37Bytes, _wl_block37);
 }}
				//Added Against ML-MMOH-CRF-1123-US3 Ends Here
				else if(dietCategoryCode.equals("THEU") && isDtCat_MlCls){
		
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(description));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
		} //End of dietCategoryCode
		} //End of Enteral	
			
			else{
		if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
					if(alaCarte.equalsIgnoreCase("AC")){
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block35Bytes, _wl_block35);
 }else{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(description));
            _bw.write(_wl_block37Bytes, _wl_block37);
 }}
				//Added Against ML-MMOH-CRF-1123-US3 Ends Here
				else if(dietCategoryCode.equals("THEU") && isDtCat_MlCls){
		
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(description));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
		}	
				}//End of While Loop
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
			 
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

						if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
					
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block47Bytes, _wl_block47);
		
					}else{
				
            _bw.write(_wl_block48Bytes, _wl_block48);
	
					}
				
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block52Bytes, _wl_block52);
	
					}else{
				
            _bw.write(_wl_block53Bytes, _wl_block53);
	
					}
				
            _bw.write(_wl_block54Bytes, _wl_block54);
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

						try{
							conn = ConnectionManager.getConnection(request);
							String mealClass = "";
							String description =  "";
							//String sql_meal_Class = "select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id like '"+language_Id+"' and eff_Status ='E'";
							String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";
							pstmt = conn.prepareStatement(sql_meal_Class);
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
							mealClass=rs.getString(1);
							description=rs.getString(2);
							if(mealClass.equals("GE") && isDtCat_MlCls){
					 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(description));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(description));
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
					 
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(!isAttendantAge){
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

						try{
							conn = ConnectionManager.getConnection(request);
							String feedType = "";
							String description =  "";
							//String sql_feed_Type = "select feed_Type, short_Desc from Ds_Feed_Type_Lang_Vw where eff_Status='E' and language_Id='"+language_Id+"'";
							String sql_feed_Type = "select feed_Type, ds_get_desc.ds_feed_type(feed_Type,'"+language_Id+"', 2)  short_Desc from Ds_Feed_Type where eff_Status='E'";
							pstmt = conn.prepareStatement(sql_feed_Type) ;
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
								feedType=rs.getString(1);
								description=rs.getString(2);
					 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(feedType));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(description));
            _bw.write(_wl_block35Bytes, _wl_block35);

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
					 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

							try{
								conn = ConnectionManager.getConnection(request);
								String instrCode = "";
								String description =  "";
								//String sql_Delivery_Instr = "select substr(long_Desc,1,30), instr_Code from Ds_Delivery_Instr_Lang_Vw where eff_Status ='E' and language_Id = '"+language_Id+"'";
								String sql_Delivery_Instr = "select substr(ds_get_desc.ds_delivery_instr(instr_Code,'"+language_Id+"', 1) ,1,30), instr_Code from Ds_Delivery_Instr  where eff_Status ='E'";
								pstmt = conn.prepareStatement(sql_Delivery_Instr) ;
								rs	= pstmt.executeQuery();
								while(rs != null && rs.next()){
									description=rs.getString(1);
									instrCode=rs.getString(2);
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(instrCode));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(description));
            _bw.write(_wl_block37Bytes, _wl_block37);

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
					
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

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
					 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(texture_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(texture_description));
            _bw.write(_wl_block34Bytes, _wl_block34);

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
					 
            _bw.write(_wl_block70Bytes, _wl_block70);
if(!isAttendantAge){
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
if(isAttendantAge){
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
}else{
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

							String attendentmealClass = "";
							String attendentdescription = "";
							try{
									conn = ConnectionManager.getConnection(request);

									//String sql_meal_Class = "select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id like '"+language_Id+"' and eff_Status ='E'";
									String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";
									pstmt = conn.prepareStatement(sql_meal_Class);
									rs	= pstmt.executeQuery();
									while(rs != null && rs.next()){
										attendentmealClass=rs.getString(1);
										attendentdescription=rs.getString(2);
								 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(attendentmealClass));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(attendentdescription));
            _bw.write(_wl_block82Bytes, _wl_block82);

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
								 
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

								if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
						
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block90Bytes, _wl_block90);

						}else{
						
            _bw.write(_wl_block91Bytes, _wl_block91);

						
						}
						
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

								if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
						
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block90Bytes, _wl_block90);

						}else{
						
            _bw.write(_wl_block95Bytes, _wl_block95);

						}
						
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block102Bytes, _wl_block102);
	
				}else{
				
            _bw.write(_wl_block103Bytes, _wl_block103);
	
				}
				
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(GEN_MEALPLAN_FOR_NBM_PAT_YN));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(profileFlag));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(restrict_date_inpatients_yn));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(IRREGULAR_DIET_ORD_YN));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(IRREGULAR_MEAL_ORD_MESSAGE));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(acceptDietForIndMealYn));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block120Bytes, _wl_block120);
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(kitchen_Code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(prfSL));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block126Bytes, _wl_block126);
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(ward_Code));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(acceptDietForIndMealYn));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(isAttendantAge));
            _bw.write(_wl_block133Bytes, _wl_block133);
if(isAttendantAge){
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(isMenuType));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isAlaCarte));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(isLos_gt));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147_0Bytes, _wl_block147_0);
            _bw.write(_wl_block147_1Bytes, _wl_block147_1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.patientOptionTitle.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietCategory.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FeedType.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.deliveryInstruction.Label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.TextureOfDiet.Label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.feedingInstruction.Label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Remarks.Label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.preparatoryInstruction.Label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.assign.Label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.nilBYMounth.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.aaaAttendent.Label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.date.Label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.dietCycles.Label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.meals.Label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.meals.Label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.nutriEntSupp.Label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SpclFoodItems.Label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.SpecialFoodItem.Label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.foodDislikes.Label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.mealExclusions.Label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.mealExclusions.Label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
