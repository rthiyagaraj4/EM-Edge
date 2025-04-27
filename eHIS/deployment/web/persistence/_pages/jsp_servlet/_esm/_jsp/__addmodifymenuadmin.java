package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifymenuadmin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AddModifyMenuAdmin.jsp", 1714396833476L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eSM/js/Menuadmin.js\'></script>\n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t<script>\n\n\t\tfunction validate_from_date(obj)\n\t\t{\n\t\t\tif(document.forms[0].function_name.value==\"insert\")\n\t\t\t{\n\t\t\t\tif(obj.value.length>0)\n\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\tDateValidation(obj);\n\t\t\t\tif(document.forms[0].eff_date_from.value!=\"\" && document.forms[0].eff_date_to.value!=\"\")\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tif(!(isBefore(document.forms[0].eff_date_from.value,document.forms[0].eff_date_to.value,\"DMY\",localeName)))\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\t\t\tdocument.forms[0].eff_date_to.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].eff_date_to.select();\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\n\t\t\t}\n\t\t\t}\n\t\t\telse if(document.forms[0].function_name.value==\"modify\")\n\t\t\t{\n\t\t\t\tif(document.forms[0].eff_date_from.value==\"\")\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\t\tif(obj.value.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\t\t\tDateValidation(obj);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t \n\t\t\t\t\tif(obj.value.length<=0)\n\t\t\t\t\t{ \n\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"FROM_DATE_CANNOT_BE_BLANK\",\"SM\"));\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\t\tDateValidation(obj);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfunction validate_to_date(obj)\n\t\t{\n\t\t\tif(document.forms[0].function_name.value==\"insert\")\n\t\t\t{\n\t\n\t\t\t\tif(document.forms[0].eff_date_from.value!=\"\" && document.forms[0].eff_date_to.value!=\"\")\n\t\t\t\t{\n\t\t\n\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\tif(DateValidation(obj)){\n\t\t\t\t\tif(!(isBefore(document.forms[0].eff_date_from.value,document.forms[0].eff_date_to.value,\"DMY\",localeName)))\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(obj.value.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\t\t\tDateValidation(obj)\n\n\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(document.forms[0].function_name.value==\"modify\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif(document.forms[0].eff_date_from.value==\"\")\n\t\t\t\t{\n\t\t\t\t\tif(obj.value.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\t\tDateValidation(obj);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t\t\tif(DateValidation(obj)){\t\t\t\t\tif(!(isBefore(document.forms[0].eff_date_from.value,document.forms[0].eff_date_to.value,\"DMY\",localeName)))\n\t\t\t\t\t{\n\t\t\t\t\t\talert( getMessage(\'TO_DT_GR_EQ_FM_DT\',\'SM\') );\n\t\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tfunction func1(obj)\n\t\t{\n\t\t\tvar val=obj.value;\n\t\t\tvar arr=val.split(\"~\");\n\t\t\tvar id1 = arr[0];\n\t\t\tvar id2 = arr[1];\n\t\t\tvar id3 = arr[2];\n\t\t\tdocument.forms[0].datefrom.value=id2;\n\t\t\tdocument.forms[0].dateto.value=id3;\n\t\t}\n\t\tfunction DateValidation(obj){\n\t\t\t\tcurdate = document.Menuadmin_Form.cur_date;\n\t\t\t\tvar msg=\"\";\n\t\t\t\tif(obj.name==\"eff_date_from\")\n\t\t\t\t msg = getMessage(\"FROM_DATE_LESS_SYSDATE\",\"SM\");\n\t\t\t\tif(obj.name==\"eff_date_to\")\n\t\t\t\tmsg = getMessage(\"TO_DATE_LESS_SYSDATE\",\"SM\");\n\t\t\t\t\n\t\t\t\tif(!(isAfter(obj.value,curdate.value,\"DMY\",localeName))) {\n\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.select();\n\t\t\t\t\t\n\t\t\t\t\talert(msg);\n\t\t\t\t\treturn false;\n\t\t\t\t}else {\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t}\n\n\n\t\tfunction doDateCheck1(from,to,messageFrame,val) \n\t\t{\n\t\tvar fromarray; var toarray;\n\t\tvar fromdate = from.value ;\n\t\tvar todate = to.value ;\n\t\tif(fromdate.length > 0 && todate.length > 0 ) \n\t\t{\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) \n\t\t\t{\n\t\t\t\t{\n\t\t\t\tif(val==\"1\")  \n\t\t\t\t{\n\t\t\t\t\tto.select();\n\t\t\t\tto.focus();\n\t\t\t\t}\n\t\t\t\telse if(val==\"2\") \n\t\t\t\t{\n\t\t\t\t\tfrom.select();\n\t\t\t\t\tfrom.focus();\n\t\t\t\t}\n\t\t\t\telse if(val==\"3\")\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tto.select();\n\t\t\t\t\tto.focus();\n\t\t\t\t}\n\t\t\t\telse if(val==\"4\")\n\t\t\t\t{\n\t\t\t\t\tto.select();\n\t\t\t\t\tto.focus();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) return true;\n\t}\t\nreturn true;\n}\nasync function populateName(obj,target,target_id)\n{\n\tvar sql=\"\";\n\t\n\tvar retVal\t\t\t= new String();\n\tvar argumentArray\t= new Array() ;\n\tvar dataNameArray\t= new Array() ;\n\tvar dataValueArray\t= new Array() ;\n\tvar dataTypeArray\t= new Array() ;\n\n\t\tvar tit\t\t\t\t= getLabel(\"Common.name.label\",\"common\");\n\t\tsql=\"select appl_user_id code,appl_user_name description from sm_appl_user where eff_status=\'E\' and upper(appl_user_id) like upper(?) and upper(appl_user_name)  like upper(?) \"\n\n\n\n\targumentArray[0]\t= sql;\n\targumentArray[1]\t= dataNameArray ;\n\targumentArray[2]\t= dataValueArray ;\n\targumentArray[3]\t= dataTypeArray ;\n\targumentArray[4]\t= \"1,2\";\n\targumentArray[5]\t=target.value;\n\targumentArray[6]\t= DESC_LINK;\n\targumentArray[7]\t= DESC_CODE;\n\n\n\tretVal = await CommonLookup( tit, argumentArray );\n\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\ttarget.value=arr[1];\n\t\ttarget_id.value=arr[0];\n\t\t\n\t}\n\telse\n\t{\n\t\ttarget.value=\"\";\n\t\ttarget_id.value=\"\";\n\t}\n}\n\t\t\t\t\n\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'  onload=\'FocusFirstElement()\'>\n\t<form name=\'Menuadmin_Form\' id=\'Menuadmin_Form\' method=\'post\' action=\'../../servlet/eSM.MenuadminServlet\' target=\'messageFrame\' >\n\t\t<br><br><br><br><br><br><BR><BR><BR>\n\t\t<table border=0 cellspacing=0 cellpadding=0 width=\'80%\' align=center>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 width+\"25%\">&nbsp;</td><td width=\'25%\'></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=3 nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<input type=\'text\' name=\'menu_admin_id_desc\' id=\'menu_admin_id_desc\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  size=\'70\' maxlength=\'30\' onblur=\'if(this.value!=\"\") populateName(this,menu_admin_id_desc,menu_admin_id)\'><input type=\'hidden\' name=\'menu_admin_id\' id=\'menu_admin_id\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"><input type=\'button\' class=\'button\' value=\'?\' onClick=\'populateName(this,menu_admin_id_desc,menu_admin_id)\' >\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  size=\'70\' maxlength=\'30\' readOnly><input type=\'hidden\' name=\'menu_admin_id\' id=\'menu_admin_id\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 width=\"25%\">&nbsp;</td><td width=\'25%\'></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label width=\'25%\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=3>\n\t\t\t\t\t<select name=\'resp_group_id\' id=\'resp_group_id\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 width=\"25%\">&nbsp;</td><td width=\'25%\'></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=text id=\'eff_date_from\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" name=\'eff_date_from\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' size=10 maxlength=10 onblur=\'if (!this.readOnly) {validate_from_date(this);}\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ><img  src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onClick=\"document.getElementById(\'eff_date_from\').focus();return showCalendar(\'eff_date_from\');\" style=\"cursor=\'hand\'\"></td>\n\n\n\t\t\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=text id=\'eff_date_to\' name=\'eff_date_to\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=10 maxlength=10  onblur=\'validate_to_date(this)\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  ><img  src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onClick=\"document.getElementById(\'eff_date_to\').focus();return showCalendar(\'eff_date_to\');\" style=\"cursor=\'hand\'\"></td>\n\n\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 width=\"25%\">&nbsp;</td><td width=\'25%\'></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=3><input type=checkbox name=\'eff_status\' id=\'eff_status\' value=\'E\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="   >&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 width=\"25%\">&nbsp;</td><td width=\'25%\'></td><td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type=\'hidden\' name=\'to_date11\' id=\'to_date11\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=\'hidden\' name=\'datefrom\' id=\'datefrom\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'dateto\' id=\'dateto\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'menu_admin_id1\' id=\'menu_admin_id1\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=\'hidden\' name=\'resp_group_id1\' id=\'resp_group_id1\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=\'hidden\' name=\'old_eff_date_from\' id=\'old_eff_date_from\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=\'hidden\' name=\'old_eff_date_to\' id=\'old_eff_date_to\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	        request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con=null;
			Statement stmt = null;
			Statement stmt_resp = null;
			try{
			con = ConnectionManager.getConnection(request);

			
			ResultSet rs =null;
			String menu_admin_id="";
			String menu_admin_name="";
			String resp_group_id="";
			String diffdate = "0";
			String redOnly = "";
			String disableFld="";
			String old_eff_date_from="";
			String old_eff_date_to="";
			String eff_date_from="";
			String eff_date_to="";
			
			String eff_status="";

			String chk_val="checked";
			
			String disabled="";
			String disableCalender="";
			String other_read_only="";
			String fn_val="insert";
			String to_date = "";

			

			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;

			String sql_date="Select to_char( sysdate,'dd/mm/yyyy') to_date from dual";
			stmt	=	con.createStatement();
			rs		=	stmt.executeQuery(sql_date);
			if(rs!=null)
			{
				if(rs.next())
				{
					to_date = rs.getString("to_date");
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			
			menu_admin_id=request.getParameter("menu_admin_id");
			menu_admin_name= request.getParameter("menu_admin_name");
			if(menu_admin_name ==null) menu_admin_name="";
			

			if(menu_admin_id!=null)
			{
				
				disabled="disabled";
				fn_val="modify";
				String sql="select resp_group_id,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1,trunc(sysdate)-trunc(eff_date_from) diffdate,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1, eff_status  from sm_menu_admin where menu_admin_id='"+menu_admin_id+"'";
				stmt	=	con.createStatement();
				rs		=	stmt.executeQuery(sql);
				if(rs!=null)
				{
					if(rs.next())
					{
						resp_group_id=rs.getString("resp_group_id");
						
						eff_date_from=rs.getString("eff_date_from1");
						if( eff_date_from==null ) 
						{
							eff_date_from="";
							old_eff_date_from="";
						}else
							eff_date_from = DateUtils.convertDate(eff_date_from,"DMY","en",localeName);
						old_eff_date_from=eff_date_from;

						
						eff_date_to=rs.getString("eff_date_to1");
						if( eff_date_to==null ) 
						{
							eff_date_to="";
							old_eff_date_to="";
						}else
							eff_date_to = DateUtils.convertDate(eff_date_to,"DMY","en",localeName);
						old_eff_date_to=eff_date_to;
						diffdate = rs.getString("diffdate");
						
						if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";
						
						
						eff_status=rs.getString("eff_status");
						
						if(eff_status.equals("D"))
						{
							other_read_only="readonly";
							chk_val="";
							disableCalender = "disabled";
						}
					}
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			else
			{
				menu_admin_id="";
			}

		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(menu_admin_name.equals("")) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(menu_admin_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(menu_admin_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
 }  else { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(menu_admin_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(menu_admin_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(other_read_only));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

						try{
							String sql_resp="Select resp_group_id, resp_group_name  from sm_resp_grp where eff_status='E' order by 2";
							String id = "";
							String dat = "";
							String sel = "";
							stmt_resp=con.createStatement();
							ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									if(id.equals(resp_group_id))
										sel="selected";
									
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block23Bytes, _wl_block23);

									sel = "";
								}
							}
							if(rs_resp!=null)rs_resp.close();
							if(stmt_resp!=null)stmt_resp.close();
						}
						catch( Exception e){out.println(e);}
						
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

				if (Integer.parseInt(diffdate)>0 )
				{
				redOnly = "readonly";
				disableFld = "disabled";
				}
			else
				{
				redOnly = "";
				disableFld = "";
				}
               if(eff_status.equals("D"))
						{
				          redOnly = "readonly";
						}
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(redOnly));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eff_date_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(other_read_only));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disableCalender));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eff_date_to));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(other_read_only));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disableCalender));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fn_val));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(menu_admin_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(resp_group_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(old_eff_date_from));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(old_eff_date_to));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dateFormat.format( new java.util.Date() ) ));
            _bw.write(_wl_block44Bytes, _wl_block44);

}catch(Exception e){out.println(e);}
			finally {
				
						ConnectionManager.returnConnection(con,request);
					}							

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ResponsibilityGroup.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
