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
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eDS.DSCommonBean;
import eDS.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealcensusqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealCensusQueryResult.jsp", 1742472460000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\'javascript\' src=\'../../eDS/js/MealCensus.js\'></script>\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n<!-- Modified Against ML-MMOH-CRF-1063 Starts Here -->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- Modified Against ML-MMOH-CRF-1063 Ends Here -->\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<!-- Modified Against ML-MMOH-CRF-1063 Starts Here -->\n<table id=\'PatCriteriaTbl\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th><a id = \'m01\' href=\"javascript:callOrderBy(\'PI\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\"onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'patId\' value=\"m01\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t<th><a id = \'m02\' href=\"javascript:callOrderBy(\'PN\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'patNamId\' value=\"m02\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t<th><a id = \'m03\' href=\"javascript:callOrderBy(\'BD\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'bedId\' value=\"m03\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t<th><a id = \'m04\' href=\"javascript:callOrderBy(\'MT\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'mealTypeId\' value=\"m04\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t<!-- ML-MMOH-CRF-0902 -->\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<th><a id = \'m05\' href=\"javascript:callOrderBy(\'ME\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'menuTypeId\' value=\"m05\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<!-- ML-MMOH-CRF-0902 -->\n\t\t\t\t<th><a id = \'m06\' href=\"javascript:callOrderBy(\'DT\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'dietTypeId\' value=\"m06\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t<th><a id = \'m07\' href=\"javascript:callOrderBy(\'MC\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'mealClsId\' value=\"m07\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t\t<th><a id = \'m08\' href=\"javascript:callOrderBy(\'MN\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>\n\t\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t\t<span id=\'menuId\' value=\"m08\"></span>\n\t\t\t\t</div>\n\t\t\t\t</th>\n\t\t\t<!-- Modified Against ML-MMOH-CRF-1063 Ends Here -->\n\t\t\t\t<th></th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<input type=\"hidden\" name=\"encounterHdn";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"encounterHdn";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"mealTypeHdn";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"mealTypeHdn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"servingDate";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"servingDate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<!--Added Against ML-MMOH-CRF-1063 Starts Here -->\n\t<input type=\"hidden\" name=\"isMenuType";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"isMenuType";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"reOrder\" id=\"reOrder\" id =\"reOrder\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"orderBy\" id=\"orderBy\" id= \"orderBy\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"anchorID\" id=\"anchorID\" id =\"anchorID\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" name=\"kitchenCode\" id=\"kitchenCode\" id =\"kitchenCode\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"servDate\" id=\"servDate\" id =\"servDate\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<!--Added Against ML-MMOH-CRF-1063 Ends Here -->\n    <td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' nowrap>\n\t<input type=\'button\' value=\'+\' name=\'detail_Record_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'detail_Record_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onclick=\'showDetailRecord(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\");\'></td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</table>\n</center>\n</form>\n<!--Added Against ML-MMOH-CRF-1063 Starts Here -->\n<script>\n\t\tvar anchorID = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' + \'\';\n        var str = anchorID !== \'\' ? document.getElementById(\'PatCriteriaTbl\').querySelector(\"#\"+anchorID):\'\';\n\t\tvar con = str.toString();\n\t\tvar ch1 = con.split(\",\");\n\t\tvar res = ch1[0].substring(24,26);\n\t\tvar isMenuType = document.forms[0].isMenuType1 !== undefined ? document.forms[0].isMenuType1.value : \"false\";\n\t\t\nif(isMenuType==\"true\" && anchorID !== \'\'){\n\t  if(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'==\'1\')\n\t  {   \n       var ch = \"\";\n       ch = document.getElementById(\'PatCriteriaTbl\').querySelector(\"#\"+anchorID).style.color= \'pink\';\n\t\tif(res == \"PI\"){\t\t   \n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t}else if(res == \"PN\"){\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t\t\n\t\t}else if (res == \"BD\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";         \n\t\t}else if (res == \"MT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";           \n\t\t}\n\t\telse if (res == \"ME\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";   \n\t\t}else if (res == \"DT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MC\"){\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MN\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";            \n\t\t}\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'==\'2\')\n\t{\t\t\n\t\tch = document.getElementById(\'PatCriteriaTbl\').querySelector(\"#\"+anchorID).style.color=\'yellow\';\n\t\tif(res == \"PI\"){\t\t   \n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t}else if(res == \"PN\"){\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t\t\n\t\t}else if (res == \"BD\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";         \n\t\t}else if (res == \"MT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";           \n\t\t}else if (res == \"ME\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";   \n\t\t}else if (res == \"DT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MC\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MN\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t}\n\t}\t\n}\nelse{\n\t  if(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'==\'1\')\n\t  {   \n       var ch = \"\";\n       ch = document.getElementById(\'PatCriteriaTbl\').querySelector(\"#\" + anchorID).style.color= \'pink\';\n\t\tif(res == \"PI\"){\t\t   \n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t}else if(res == \"PN\"){\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t\t\n\t\t}else if (res == \"BD\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";         \n\t\t}else if (res == \"MT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";           \n\t\t}else if (res == \"DT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MC\"){\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MN\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";            \n\t\t}\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'==\'2\')\n\t{\t\t\n\t\tch = document.getElementById(\'PatCriteriaTbl\').querySelector(\"#\"+anchorID).style.color=\'yellow\';\n\t\tif(res == \"PI\"){\t\t   \n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t}else if(res == \"PN\"){\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";\n\t\t\t\n\t\t}else if (res == \"BD\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";         \n\t\t}else if (res == \"MT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";           \n\t\t}else if (res == \"DT\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MC\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \";            \n\t\t}else if (res == \"MN\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#menuId\").innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patId\").innerHTML= \" \";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#patNamId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#bedId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#dietTypeId\").innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').querySelector(\"#mealClsId\").innerHTML= \" \";\n\t\t}\n\t}\t\n}\n</script>\n<!--Added Against ML-MMOH-CRF-1063 Ends Here -->\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE");
   String facility_id = (String)session.getAttribute("facility_id");
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String kitchenCode = checkForNull(request.getParameter("kitchen_code"));
	String wardCode =checkForNull(request.getParameter("ward_code"));
	String servDate =checkForNull(request.getParameter("serv_Date"));
	String servingDate	=  com.ehis.util.DateUtils.convertDate(servDate,"DMY", locale, "en");
	//Added Against ML-MMOH-CRF-1063 Starts Here
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	System.err.println("reOrder-->"+reOrder+"  orderBy-->"+orderBy+"  anchorID-->"+anchorID);
	System.err.println("kitchenCode-->"+kitchenCode+"--->wardCode-->"+wardCode+"--->servDate-->"+servDate);
	//Added Against ML-MMOH-CRF-1063 Ends Here
	String encounter_Id = "";
	String assign_Bed_Num = "";
	String patient_Id= "";
	String patient_Name = "";
	String meal_Type = "";
	String mealtype_desc = "";
	String diettype_desc= "";
	String mealclass_desc = "";
	String menu_desc = "";
	boolean isMenuType =false;//ML-MMOH-CRF-0902
	//ML-MMOH-CRF-0902
	String menu_Type_Desc ="";
	//ML-MMOH-CRF-0902
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);
	//ML-MMOH-CRF-0902
        isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//ML-MMOH-CRF-0902
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{
		System.err.println("72- orderBy->"+orderBy+"wardCode==>"+wardCode);
		String strsql = "select count(*) total "+
						"from Ds_Epsd_Meal_Plan_Hdr mealplanhdr,Ds_Meal_Type_Lang_Vw mealType,Ds_Diet_Type_Lang_Vw dietType,"+
						"Ds_Meal_Class_Lang_Vw mealClass,Ds_Menu_Lang_Vw menu,pr_encounter  prencounter,mp_patient mpatient "+
						"where mealplanhdr.meal_Type = mealType.meal_Type and mealplanhdr.diet_Type = dietType.diet_Type "+
						"and mealplanhdr.meal_Class = mealClass.meal_Class and mealplanhdr.menu_Code = menu.menu_Code "+
						"and mealplanhdr.operating_facility_Id  = '"+facility_id+"' and mealplanhdr.kitchen_Code  = '"+kitchenCode+"' "+
						"and mpatient.patient_id =   prencounter.patient_id and prencounter.encounter_id = mealplanhdr.encounter_id ";//57812
												
						System.err.println("80- wardCode->"+wardCode);
						if(wardCode.equals("") || wardCode==null){
						strsql+="and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						}else{
						strsql+="and prencounter.ASSIGN_CARE_LOCN_CODE = '"+wardCode+"' "+						
						"and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						System.err.println("90- ELSE strsql->"+strsql);
						}//57812

						
		String strsql1 = "select mealplanhdr.encounter_Id, prencounter.assign_Bed_Num, prencounter.patient_Id, "+
						"mpatient.patient_Name,mealplanhdr.meal_Type,mealType.short_Desc mealtype_desc, "+
						"dietType.short_Desc diettype_desc, mealClass.short_Desc mealclass_desc,menu.short_Desc menu_desc, "+
						"ds_get_desc.ds_menu_type(menu_type,'"+locale+"','2') menu_type_desc "+
						"from Ds_Epsd_Meal_Plan_Hdr mealplanhdr,Ds_Meal_Type_Lang_Vw mealType,Ds_Diet_Type_Lang_Vw dietType,"+
						"Ds_Meal_Class_Lang_Vw mealClass,Ds_Menu_Lang_Vw menu,pr_encounter  prencounter,mp_patient mpatient "+
						"where mealplanhdr.meal_Type = mealType.meal_Type and mealplanhdr.diet_Type = dietType.diet_Type "+
						"and mealplanhdr.meal_Class = mealClass.meal_Class and mealplanhdr.menu_Code = menu.menu_Code "+
						"and mealplanhdr.operating_facility_Id  = '"+facility_id+"' and mealplanhdr.kitchen_Code  = '"+kitchenCode+"' "+
						"and mpatient.patient_id =   prencounter.patient_id and prencounter.encounter_id = mealplanhdr.encounter_id ";
						//57812 & ML-MMOH-CRF-0902
						if(wardCode.equals("") || wardCode==null){
						strsql1+="and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						}else{
						strsql1+="and prencounter.ASSIGN_CARE_LOCN_CODE = '"+wardCode+"' "+
						"and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						}//57812
						
			//Added Against ML-MMOH-CRF-1063 Starts Here
			if (orderBy.equals("PI")){
					if(reOrder.equals("1")){
							strsql1= strsql1+" order by patient_id desc ";
							
					}else{
							strsql1 =strsql1+" order by patient_id  ";
						
					}
			   }else if (orderBy.equals("PN")){
					if(reOrder.equals("1")){
						     strsql1 =strsql1+" order by lower(trim(patient_Name)) desc ";
					}else{
							strsql1= strsql1+" order by lower(trim(patient_Name)) ";
					}
			   }else if (orderBy.equals("BD")){
					if(reOrder.equals("1")){
							 strsql1 =strsql1+" order by assign_Bed_Num desc ";
					}else{
							 strsql1= strsql1+" order by assign_Bed_Num ";
					}
			  }else if (orderBy.equals("MT")){
					if(reOrder.equals("1")){
							 strsql1 =strsql1+" order by meal_Type desc ";
					}else{
							 strsql1 =strsql1+" order by meal_Type ";//Modified for ICN-64265
					}
			  }else if(orderBy.equals("ME")){
					if(isMenuType){
				if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by menu_type_desc desc ";
					}else{
						   strsql1 =strsql1+" order by menu_type_desc ";
				    }
					}
			  }
			  else if(orderBy.equals("DT")){
				       if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by diettype_desc desc ";
					}else{
						   strsql1 =strsql1+" order by diettype_desc ";						  
					}
			  } 
			  else if(orderBy.equals("MC")){
		              if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by mealclass_desc desc ";
					}else{
						   strsql1 =strsql1+" order by mealclass_desc ";
					}
			  }
			  else if(orderBy.equals("MN")){
		              if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by menu_desc desc ";
					}else{
						   strsql1 =strsql1+" order by menu_desc ";
					}
			  }else
			  {
				   System.err.println("132 orderBy==>"+orderBy);
				   strsql1 =strsql1+" order by prencounter.assign_Bed_Num,prencounter.patient_id";
			  }
			//Added Against ML-MMOH-CRF-1063 Ends Here						
		// System.out.println("SQL: " + strsql) ;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");//GDOH-SCF-0160
			
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	
	

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/MealCensusQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&kitchen_code="+kitchenCode+"&ward_code="+wardCode+"&serv_Date="+servDate +"&reOrder="+reOrder +"&anchorID="+anchorID +"&orderBy="+orderBy +"'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealCensusQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&kitchen_code="+kitchenCode+"&ward_code="+wardCode+"&serv_Date="+servDate +"&reOrder="+reOrder +"&anchorID="+anchorID + "&orderBy="+orderBy +"'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(isMenuType) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wardCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

    if ( start != 1 )
    for( int j=1; j<start; i++,j++ )
    rset.next() ;
	String classValue= " ";
	int rowId=1; //IN:39948 
    while ( rset.next() && i<=end  )
	{
		if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;  
        else
            classValue = "QRYODD" ;  
    out.println("<tr>");

   encounter_Id = rset.getString("encounter_Id");

	if(rset.getString("assign_Bed_Num") ==  null){
		assign_Bed_Num = "&nbsp;";
	}
	else assign_Bed_Num=rset.getString("assign_Bed_Num");
    patient_Id= rset.getString("patient_Id");
    patient_Name = rset.getString("patient_Name");
    meal_Type = rset.getString("meal_Type");
    mealtype_desc = rset.getString("mealtype_desc");
    diettype_desc= rset.getString("diettype_desc");
    mealclass_desc = rset.getString("mealclass_desc");
    menu_desc = rset.getString("menu_desc");
	//ML-MMOH-CRF-0902 starts here
	if(isMenuType){
    		menu_Type_Desc = checkForNull(rset.getString("menu_type_desc"));
	}
	else{
    		menu_Type_Desc = "";
	}
	//ML-MMOH-CRF-0902 ends here
    out.println("<td class='" + classValue+"' nowrap>"+patient_Id+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+patient_Name+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+assign_Bed_Num+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealtype_desc+"</td>");	
	if(isMenuType){ 
	out.println("<td class='" + classValue+"' nowrap>"+menu_Type_Desc+"&nbsp;</td>");//ML-MMOH-CRF-0902	
	}
    out.println("<td class='" + classValue+"' nowrap>"+diettype_desc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealclass_desc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+menu_desc+"</td>");
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(meal_Type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isMenuType));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(servDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowId ));
            _bw.write(_wl_block41Bytes, _wl_block41);

	out.println("</tr>");
	rowId++;
	i++;
} 
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	if(conn!=null)	ConnectionManager.returnConnection(conn,request);
}catch(Exception e){
	e.printStackTrace();
	System.err.println("236->MealCensusQueryResult.jsp===>"+e.getMessage());
}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( anchorID ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealType.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Menu.Label", java.lang.String .class,"key"));
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
}
