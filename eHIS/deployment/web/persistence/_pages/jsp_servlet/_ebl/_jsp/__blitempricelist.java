package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __blitempricelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLItemPriceList.jsp", 1742751779450L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n <base target=\"_self\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\'../js/BLAmount.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\'../js/PkgDef.js\'></script> \n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/BLItemPriceList.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n<script>\nvar facility_id = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\';\nfunction disable(bool,err_mess) {\n\tif(err_mess==\"\")\n\t{\n\t\tif (bool == true)\n\t\t{\n\t\t\tvar process_label=getLabel(\"Common.processing.label\",\"common\");\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+process_label;\n\t\t}\n\t}\n\telse\n\t{\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+err_mess;\n\t}\n}\n\nfunction funFromItemCode() {\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.ItemCodeTitle.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,80%\");               \n\tvar cashcntrcode=getLabel(\"eBL.ItemCode.label\",\"BL\");\n\tcashcntrcode=encodeURIComponent(cashcntrcode);\n\tvar desc=getLabel(\"eBL.Description.label\",\"BL\");\n\tdesc=encodeURIComponent(desc);\n\tvar column_descriptions = cashcntrcode+\",\"+desc;\n\tvar locale=document.forms[0].locale.value;\n\t\n\tvar sql = escape(\"select a.item_code ITM_CODE,short_desc ITM_DESC from bl_st_item a,mm_item_lang_vw b where nvl(status,\'z\')<>\'c\' and a.item_code=b.item_code and language_id=\'\"+locale+\"\' and operating_facility_id=\'\"+facility_id+\"\'\");\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].FromItemCode.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\tvar arr=new Array();\n\tif(retVal == null) retVal=\'\';\n\tif (retVal != null || retVal!=\'\')\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\n\t\t\tdocument.forms[0].FromItemCode.value = arr[0];\n\t\t\tdocument.getElementById(\'FromItem_desc\').innerText= arr[1];\n\t\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].FromItemCode.value = \'\';\n\t\t\tdocument.getElementById(\'FromItem_desc\').innerText= \'\';\n\t\t}\n\t}\n}\n\nfunction funToItemCode() {\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.ItemCodeTitle.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,80%\");               \n\tvar cashcntrcode=getLabel(\"eBL.ItemCode.label\",\"BL\");\n\tcashcntrcode=encodeURIComponent(cashcntrcode);\n\tvar desc=getLabel(\"eBL.Description.label\",\"BL\");\n\tdesc=encodeURIComponent(desc);\n\tvar column_descriptions = cashcntrcode+\",\"+desc;\n\tvar locale=document.forms[0].locale.value;\n\tvar sql = escape(\"select a.item_code ITM_CODE,short_desc ITM_DESC from bl_st_item a,mm_item_lang_vw b where nvl(status,\'z\')<>\'c\' and a.item_code=b.item_code and language_id=\'\"+locale+\"\' and operating_facility_id=\'\"+facility_id+\"\'\");\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].ToItemCode.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\tvar arr=new Array();\n\tif(retVal == null) retVal=\'\';\n\tif (retVal != null || retVal!=\'\')\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\n\t\t\tdocument.forms[0].ToItemCode.value = arr[0];\n\t\t\tdocument.getElementById(\'ToItem_desc\').innerText= arr[1];\n\t\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].ToIteamCode.value = \'\';\n\t\t\tdocument.getElementById(\'ToIteam_desc\').innerText= \'\';\n\t\t}\n\t}\n}\n\nfunction funToItemCode() {\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.ItemCodeTitle.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,80%\");               \n\tvar cashcntrcode=getLabel(\"eBL.ItemCode.label\",\"BL\");\n\tcashcntrcode=encodeURIComponent(cashcntrcode);\n\tvar desc=getLabel(\"eBL.Description.label\",\"BL\");\n\tdesc=encodeURIComponent(desc);\n\tvar column_descriptions = cashcntrcode+\",\"+desc;\n\tvar locale=document.forms[0].locale.value;\n\tvar sql = escape(\"select a.item_code ITM_CODE,short_desc ITM_DESC from bl_st_item a,mm_item_lang_vw b where nvl(status,\'z\')<>\'c\' and a.item_code=b.item_code and language_id=\'\"+locale+\"\' and operating_facility_id=\'\"+facility_id+\"\'\");\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].ToItemCode.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\tvar arr=new Array();\n\tif(retVal == null) retVal=\'\';\n\tif (retVal != null || retVal!=\'\')\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\n\t\t\tdocument.forms[0].ToItemCode.value = arr[0];\n\t\t\tdocument.getElementById(\'ToItem_desc\').innerText= arr[1];\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].ToIteamCode.value = \'\';\n\t\t\tdocument.getElementById(\'ToIteam_desc\').innerText= \'\';\n\t\t}\n\t}\n}\n\nfunction funFromCreatAmendedBy() {\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.Users.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,80%\");               \n\tvar column_descriptions = escape(\"Cash Counter Code,Description\"); \n\tvar cashcntrcode=getLabel(\"eBL.CreatedAmendedCode.label\",\"BL\");\n\tcashcntrcode=encodeURIComponent(cashcntrcode);\n\tvar desc=getLabel(\"eBL.CreatedAmendedName.label\",\"BL\");\n\tdesc=encodeURIComponent(desc);\n\tvar column_descriptions = cashcntrcode+\",\"+desc;\n\n\tvar locale=document.forms[0].locale.value;\n\tvar sql = escape(\"select user_id CODE,username NAME from sy_user where facility_id=\'\"+facility_id+\"\' and user_id in(select bl_user_id from bl_user where nvl(status,\'N\') != \'S\' and operating_facility_id=\'\"+facility_id+\"\') and nvl(status,\'N\') != \'S\'\");\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].frmamendedBy_code.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\tvar arr=new Array();\n\tif(retVal == null) retVal=\'\';\n\tif (retVal != null || retVal!=\'\')\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\n\t\t\tdocument.forms[0].frmamendedBy_code.value = arr[0];\n\t\t\tdocument.getElementById(\'frmamendedBy_desc\').innerText= arr[1];\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].frmamendedBy_code.value = \'\';\n\t\t\tdocument.getElementById(\'frmamendedBy_desc\').innerText= \'\';\n\t\t}\n\t}\n}\n\t\nfunction funToCreatAmendedBy() {\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.Users.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,80%\");               \n\tvar cashcntrcode=getLabel(\"eBL.CreatedAmendedCode.label\",\"BL\");\n\tcashcntrcode=encodeURIComponent(cashcntrcode);\n\tvar desc=getLabel(\"eBL.CreatedAmendedName.label\",\"BL\");\n\tdesc=encodeURIComponent(desc);\n\tvar column_descriptions = cashcntrcode+\",\"+desc;\n\tvar locale=document.forms[0].locale.value;\n\tvar sql = escape(\"select user_id CODE,username NAME from sy_user where facility_id=\'\"+facility_id+\"\' and user_id in(select bl_user_id from bl_user where nvl(status,\'N\') != \'S\' and operating_facility_id=\'\"+facility_id+\"\') and nvl(status,\'N\') != \'S\'\");\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].toamendedBy_code.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\tvar arr=new Array();\n\tif(retVal == null) retVal=\'\';\n\tif (retVal != null || retVal!=\'\')\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\n\t\t\tdocument.forms[0].toamendedBy_code.value = arr[0];\n\t\t\tdocument.getElementById(\'toamendedBy_desc\').innerText= arr[1];\n\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].toamendedBy_code.value = \'\';\n\t\t\tdocument.getElementById(\'toamendedBy_desc\').innerText= \'\';\n\t\t}\n\t}\n}\n\t\nfunction check_item() {\n\tif(document.forms[0].trdnamchk.checked) {\n\t\tdocument.forms[0].trdnamchk.value = \'Y\';\n\t}\n\telse {\n\t\tdocument.forms[0].trdnamchk.value = \'N\';\n\t}\n}\nfunction call_date_less_equal_chk(obj) {\t\n\tif(!(obj.value==\"\"))\n\t{\n\t\tvar locale=document.forms[0].locale.value;\n\t\tvar sysdate=getCurrentDate(\'DMY\',locale);\n\t\t\n\t\tif(chkDtLessEqualThanSysDateNew(obj,sysdate))\n\t\t{\t\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\t\n\t\treturn false;\n\t}\n}\n\nfunction call_date_less_equal_chk1(obj) {\n\tif(!(obj.value==\"\"))\n\t{\n\t\tvar locale=document.forms[0].locale.value;\n\t\tvar sysdate=getCurrentDate(\'DMY\',locale);\n\t\t\n\t\tif(chkDtLessEqualThanSysDateNew(obj,sysdate))\n\t\t{\t\n\t\t\t//alert(getMessage(\"BL6015\",\'BL\'));\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\t\n\t\treturn false;\n\t}\n}\n\nfunction chkDtLessEqualThanSysDateNew(entered_date,sys_date) {\n\tvar locale=document.forms[0].locale.value;\n\t\n\tif(entered_date.value!=\"\")\n\t{\n\t\t//CHANDED FROM DMY TO DMYHM 08/01/2021\n\t\tif((validDate(entered_date.value,\'DMYHM\',locale)))\n\t\t{\n\t\t\tvar enteredDate = entered_date.value ;\n\t\t\tvar sysDate = sys_date.value;\n\t\t\t//CHANDED FROM DMY TO DMYHM 08/01/2021\n\t\t\tif(isBeforeNow(enteredDate,\'DMYHM\',locale))\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9114\",\'BL\'));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_FMT\",\"SM\"));\n\t\t\tentered_date.select();\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n\nfunction toFromDateChk(obj) {\n\tif(!(obj.value==\"\"))\n\t{\t\n\t\tvar sysdate=getCurrentDate(\'DMY\',locale);\n\t\tvar effFromDt = document.forms[0].FromdAmendedDate.value;\n\t\tvar effToDt = document.forms[0].TodAmendedDate.value;\n\t\tif(checkDateBL(obj))\n\t\t{\n\t\t\tvar locale=document.forms[0].locale.value;\t\t\t\n\t\t\tif((!isBefore(effFromDt,effToDt,\'DMY\',locale)))\n\t\t\t{\t\t\n\t\t\t\talert(getMessage(\"BL1539\",\'BL\'));\n\t\t\t\tobj.select();\n\t\t\t}\n\t\t\te";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="lse\n\t\t\t{\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}\n\nfunction checkDateBL(entered_date) {\n\tvar locale=document.forms[0].locale.value;\n\tif(entered_date.value!=\"\")\n\t{\n\t\tif(validDate(entered_date.value,\'DMY\',locale))\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\talert(getMessage(\"INVALID_DATE_FMT\",\"SM\"));\n\t\t\tentered_date.select();\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\n<body  onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\">\n\t<form name=\'report_form\' id=\'report_form\' action=\'../../servlet/eBL.BLCashierReportServlet\' method=\'post\' target=\'dummyFrame\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\n\t<tr>\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\t\n\t\t\t\t<td nowrap class=\'fields\'>\n\t\t\t\t\t<select name=\'itemprice\' id=\'itemprice\' style=\"width: 300px; \">\t\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' selected>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</select>\n\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td   class=\'fields\'>\n\t\t\t\t<select name=\'item_type\' id=\'item_type\' onchange=\'\'>\n\t\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t   <option value=\'Y\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t  </select>\n\t\t\t</td>\n\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<td nowrap class=\'fields\'>\n\t\t\t\t<select name=\'itemstatus\' id=\'itemstatus\' style=\"width: 120px;\">\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</select>\n\t\t\t</td>\t\t\t\n\t</tr>\n\t<tr>\n\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td nowrap><input type=\"checkbox\"  id =\"trdnamchk\" name=\"trdnamchk\" id=\"trdnamchk\"  value=\"N\"\tonclick=\"check_item()\" ></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t    <td nowrap class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'FromItemCode\' id=\'FromItemCode\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\"funFromItemCode()\">\n\t\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funFromItemCode()\">\n\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t    <td  nowrap class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'ToItemCode\' id=\'ToItemCode\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\"funToItemCode()\">\n\t\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funToItemCode()\">\n\t\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t    <td nowrap class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'frmamendedBy_code\' id=\'frmamendedBy_code\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\"funFromCreatAmendedBy()\">\n\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funFromCreatAmendedBy()\">\n\t\t\t\t\t\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t    <td nowrap class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'toamendedBy_code\' id=\'toamendedBy_code\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\"funToCreatAmendedBy()\">\n\t\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funToCreatAmendedBy()\">\n\t\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td  nowrap class=\'label\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t    <td nowrap class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'FromdAmendedDate\' id=\'FromdAmendedDate\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\'call_date_less_equal_chk(document.forms[0].FromdAmendedDate)\'>\n\t\t\t\t<!--\n\t\t\t\tBelow in show calendar hh:mm added for both From and To  AmendedDate\n\t\t\t\t-->\n\t\t\t\t<img onclick=\"return showCalendar(\'FromdAmendedDate\',\'dd/mm/yyyy\' ,\'hh:mm\');\" src=\"../../eCommon/images/CommonCalendar.gif\">\n\t\t\t\t</td>\n\t\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t    <td  class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'TodAmendedDate\' id=\'TodAmendedDate\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\'call_date_less_equal_chk1(document.forms[0].TodAmendedDate)\'>\n\t\t\t\t<img onclick=\"return showCalendar(\'TodAmendedDate\',\'dd/mm/yyyy\',\'hh:mm\');\" src=\"../../eCommon/images/CommonCalendar.gif\">\n\n\t\t</tr>\n\t\t</tr>\n\t</table>\n<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type= hidden name=\"facility_id\" id=\"facility_id\"  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type= hidden name=\"log_rep_success_mes\" id=\"log_rep_success_mes\"  value=\'\'>\n<input type= hidden name=\"login_user\" id=\"login_user\"  value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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

/*
Sr No           Version        Incident              SCF/CRF					Developer Name
1               V201125								MOHE-CRF-0050.3-US-004 		   Palani Narayanan
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	HttpSession httpSession = request.getSession(false);
	String facility_id = "";	
	String locale			= (String)session.getAttribute("LOCALE");
	String login_user	= (String) session.getValue( "login_user" );
	String module_id=request.getParameter("module_id");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
	}
	catch(Exception eX)
	{
		out.println("Error= "+eX);
		eX.printStackTrace();
	}
	
Connection con = null;
PreparedStatement pstmt = null;
Statement stmt = null;
ResultSet rs = null;
con = ConnectionManager.getConnection(request); 
LinkedHashMap<String,String> itemPriceMap = new LinkedHashMap<String,String>();
LinkedHashMap<String,String> itemStatusMap = new LinkedHashMap<String,String>();
try{		
		String itmPrsLst  =  	BlRepository.getBlKeyValue("ITEAM_PRICE_LIST");
		pstmt = con.prepareStatement(itmPrsLst);
		pstmt.setString(1,login_user);
		rs = pstmt.executeQuery();
		
		if(rs!=null){
			while(rs.next()){
				itemPriceMap.put(rs.getString("id"),rs.getString("name"));				
			}	
		}
		
		pstmt = null;
		rs = null;
		String itemStatus  =  BlRepository.getBlKeyValue("ITEAM_PRICE_LIST_STATUS");
		pstmt = con.prepareStatement(itemStatus);
		pstmt.setString(1,module_id);
		pstmt.setString(2,locale);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				itemStatusMap.put(rs.getString("LIST_ELMT_VALUE"),rs.getString("List_Element"));
			}	
		}
		pstmt = null;
		rs = null;		
	}
	catch(Exception e)
	{
		out.println("Exception @ sys_date_wht_sec"+e);
		e.printStackTrace();
	}	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
		String facilityId		= (String) session.getValue( "facility_id" ) ;
 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				for (Iterator iterator = itemPriceMap.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
						if(type.equals(facilityId)){
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(itemPriceMap.get(type) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
						else{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(itemPriceMap.get(type) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
					}
				
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

				for (Iterator iterator = itemStatusMap.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					if(type.equals("A")){
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(itemStatusMap.get(type) ));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
					else{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(itemStatusMap.get(type) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
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
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FacilityId.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ItemType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Drugs.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Consumables.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Status.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TradeNameorBatch.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FromItemCode.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ToItemCode.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.frmCreateAmendBy.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.toCreateAmendBy.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.frmCreateAmendDate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.toCreateAmendDate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
