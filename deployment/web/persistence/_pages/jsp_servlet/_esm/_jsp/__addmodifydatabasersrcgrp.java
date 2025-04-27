package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifydatabasersrcgrp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AddModifyDatabaseRsrcgrp.jsp", 1713174869912L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<HTML>\n<HEAD>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eSM/js/DatabaseRsrcgrp.js\' language=\'javascript\'></script>\n\t<TITLE>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</TITLE>\n\t\n\n<SCRIPT language = \"JavaScript\">\n   function enableReuseOption(obj)\n\t{\n\t//document.forms[0].ORA_PWD_REUSE_TIME.value=\"\";\n//\tif(document.forms[0].changes.value==\'C\')\n   // obj.value=\'R\';\n\tif(obj.value==\'R\')\n\t{\n\tdocument.forms[0].ORA_PWD_REUSE_TIME.style.visibility=\'visible\';\n\tdocument.forms[0].changes.style.visibility=\'visible\';\n\tdocument.getElementById(\'reuseafterhide\').style.visibility=\'visible\';\n\t//Maheshwaran K added for Password Validation as on 18/07/2012\n\tdocument.forms[0].mand_img.style.visibility=\'visible\';\n\t\n\t}else\n\t{\n\tdocument.forms[0].ORA_PWD_REUSE_TIME.style.visibility=\'hidden\';\n\tdocument.forms[0].ORA_PWD_REUSE_TIME.value=\'\';\n\tdocument.forms[0].changes.style.visibility=\'hidden\';\n\tdocument.getElementById(\'reuseafterhide\').style.visibility=\'hidden\';\n\t//Maheshwaran K added for Password Validation as on 18/07/2012\n\tdocument.forms[0].mand_img.style.visibility=\'hidden\';\n\t}\n\t\t\n\t\t\n\t}\n\t\n\tfunction ExpVal()\n\t{\t\n\t\t//document.DBResourceGrp_form.changes.value = \'D\';\n\t\t//document.DBResourceGrp_form.changes.disabled = false;//Maheshwaran K changed\n\n\t\tif(document.DBResourceGrp_form.elements[2].checked)\n\t\t{\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_LIFE_TIME.value = \"\";\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.value = \"\";\t\t\t\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_LIFE_TIME.readOnly  = true;\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.readOnly = true;\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_LIFE_TIME.disabled  = true;\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled = true;\t\n\t\t\tdocument.DBResourceGrp_form.changes.disabled=false;\n\t\t\tdocument.DBResourceGrp_form.password_expiry_alert_days.disabled=true;\n\t\t\tdocument.DBResourceGrp_form.password_expiry_alert_days.value=\"\";\n\t\t\t\n\t\t\tdocument.DBResourceGrp_form.img_password_expiry_alert_days.style.visibility=\'hidden\';\n\t\t\t\n\t\t\t\n\t\t}\t\n\t\t\n\t\tif(document.DBResourceGrp_form.elements[3].checked){\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_LIFE_TIME.readOnly = false;\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_LIFE_TIME.disabled = false;\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.readOnly = false;\t\t\t\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled = false;\n\t\t\tdocument.DBResourceGrp_form.password_expiry_alert_days.disabled=false;\n\t\t\tdocument.DBResourceGrp_form.img_password_expiry_alert_days.style.visibility=\'visible\';\n\t\t\tdocument.DBResourceGrp_form.password_expiry_alert_days.value=\"14\";\n\t\t}\t\t\t\t\n\t\t\n\t\t\n\t\tif(document.DBResourceGrp_form.prohibitReuse.value==\'R\')\n\t\t{\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = false;\t\t\n\t\t\t//document.DBResourceGrp_form.changes.disabled=false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value\t= \"\";\t\t\n\t\t\t//document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = true;\t\t\n\t\t\t//document.DBResourceGrp_form.changes.disabled=true;\n\t\t}\n\t\tif(document.DBResourceGrp_form.changes.checked)\n\t\t{\t\t\n\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = false;\t\t\n\t\t\t//document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = true;\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value= \"\";\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;\t\t\n\t\t}\n\t\t\n\t\t\t\t\n\n\t\tif(document.DBResourceGrp_form.prohibitReuse.value==\'P\')\n\t\t{\t\t\t\t\n\t\t\t//document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.readOnly = true;\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.readOnly  = true;\t\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.readOnly = false;\n\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.readOnly  = false;\t\n\t\t}\n\t}\n\t\n\tfunction ExpVal1(Obj)\n\t{\n\tvar val = Obj.name;\n\t\n\t\n\t\tif(val== \"TimesOutAfter\")\n\t\t{\t\t\t\t\n\t\t\tdocument.DBResourceGrp_form.NeverTimesOut.checked  = false;\t\t\t\n\t\t\tdocument.DBResourceGrp_form.TimesOutAfter.checked  = true;\n\t\t\t\n\t\t\t\n\t\t}\t\n\n\t\telse if(val ==\"NeverTimesOut\")\n\t\t{\t\t\t\t\n\t\t\tdocument.DBResourceGrp_form.ExpPeriodVal.value = \t\t\tdocument.DBResourceGrp_form.TimesOutAfter.checked  = false\n\t\t\tdocument.DBResourceGrp_form.NeverTimesOut.checked  = true;\n\t\t}\n\t}\t\n\t\n\tfunction ExpVal2()\n\t\t{\n\t\t\tif(document.DBResourceGrp_form.reuseAfter.checked==true)\n\t\t\t{\t\n\t\t\n\t\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = false;\t\t\n\t\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;\t\t\n\t\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value = \"\";\t\t\t\t\t\t\n\t\t\t\tdocument.DBResourceGrp_form.changes.disabled =false;\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value = \"\";\t\n\t\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;\t\n\t\t\t\t//document.DBResourceGrp_form.changes.disabled =true;\t\t\t\n\t\t\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = true;\t\t\n\t\t\t}\n\n\t\t}\t\n\n\tfunction ExpVal3()\n\t\t{\n\t\t\tif(document.DBResourceGrp_form.changes.value==\'C\')\n\t\t\t{\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t}\n\t\t}\n\n\tfunction CheckForNumber(obj) \n\t{\n\t\tif (obj.value.length > 0 )\n\t\t{\n\t\t\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)\n\t\t\t{\t\t\n\t\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif (obj.value.substr(0,1) >= 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\t\n\t\n\t\n\tfunction DisabFunc()\n\t{\n\t\t\n\t\t//document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.disabled = false;\n\t\t//document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled = false;\n\t\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;\t\t\n\t}\n\nfunction CheckPositiveNumber1(obj)\n\t\t{\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {\t\t\n\t}\n\telse {\n  \t\tif ( obj.value.length > 0 ) {\n  \t\t\talert(getMessage(\'VALUE_SHOULD_BE_GR_ZERO\',\'Common\'));\n  \t\t\tobj.select();\n  \t\t\tobj.focus();\n  \t\t}\n  \t}\n}\nfunction CheckSpecialChar(obj)\n{\n\tvar fieldval = obj.value;\n\tvar fieldlen = fieldval.length;\n\tvar to_check = true;\n\tvar SpChar = new Array();\n\n\tSpChar[0] = \'~\';\n\tSpChar[1] = \'`\';\n\tSpChar[2] = \'!\';\n\tSpChar[3] = \'@\';\n\tSpChar[4] = \'#\';\n\tSpChar[5] = \'$\';\n\tSpChar[6] = \'%\';\n\tSpChar[7] = \'^\';\n\tSpChar[8] = \'&\';\n\tSpChar[9] = \'*\';\n\tSpChar[10] = \'(\';\n\tSpChar[11] = \')\';\n\tSpChar[12] = \'-\';\n\tSpChar[13] = \'+\';\n\tSpChar[14] = \'=\';\n\tSpChar[15] = \'|\';\n\tSpChar[16] = \'\\\\\';\n\tSpChar[17] = \'[\';\n\tSpChar[18] = \']\';\n\tSpChar[19] = \'{\';\n\tSpChar[20] = \'}\';\n\tSpChar[21] = \':\';\n\tSpChar[22] = \';\';\n\tSpChar[23] = \'\"\';\n\tSpChar[24] = \'<\';\n\tSpChar[25] = \'>\';\n\tSpChar[26] = \'?\';\n\tSpChar[27] = \'/\';\n\tSpChar[28] = \'\\\'\';\n\tSpChar[29] = \'\';\n\tSpChar[30] = \',\';\n\tSpChar[31] = \'.\';\n\n\tif (fieldval.substr(0,1) == \'_\'  ) \n\t{\n\t\tto_check = false;\n\t}\n\n\tfor (var i=0;i<fieldlen;i++)\n\t{\n\n\t\tif (fieldval.substr(i,1) == \' \' || fieldval.substr(i,1) == null)\n\t\t{\n\t\t\tto_check = false;\n\t\t}\n\n\t\tfor (var j=0;j<=31;j++)\n\t\t{\n\t\t\tif (fieldval.substr(i,1) == SpChar[j])\n\t\t\t{\n\t\t\t\tto_check = false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif (to_check == false)\n\t{\n\t\talert(getMessage(\'SPECIAL_CHARCTERS_NOT_ALLOWED\',\'SM\'));\n\t\tobj.select();\n\t\tobj.focus();\n\t\tobj.value=\'\';\n\t}\n}\n\nfunction enabdisbpasswdlock()\n{\n\tif (parseInt(document.DBResourceGrp_form.ORA_FAILED_LOGIN_ATTEMPTS.value.substring(0,1)) > 0 )\n\t{\n\t\tdocument.DBResourceGrp_form.ORA_PWD_LOCK_TIME.disabled=false;\n\t}\n\telse\n\t{\n\t\tdocument.DBResourceGrp_form.ORA_PWD_LOCK_TIME.value=\"\";\n\t\tdocument.DBResourceGrp_form.ORA_PWD_LOCK_TIME.disabled=true;\n\t}\n\n}\n\nfunction enabdisblifegrace()\n{\n\tif (parseInt(document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.value.substring(0,1)) > 0 )\n\t{\n\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled=false;\n\t}\n\telse\n\t{\n\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.value=\"\";\n\t\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled=true;\n\t}\n\n}\nfunction CheckForSpecCharsforID(event){\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n</HEAD>\n\n<BODY  onload=\'FocusFirstElement();enableReuseOption(document.forms[0].prohibitReuse)\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<FORM name=\'DBResourceGrp_form\' id=\'DBResourceGrp_form\' ACTION=\'../../servlet/eSM.DatabaseRsrcgrpServlet\' method=\'post\' target=\'messageFrame\'>\n<BR><BR><BR><BR><BR><BR><BR>\n\n<table width=\'95%\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' border=\'0\'>\n<tr>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\n</tr>\n<tr>\n\t\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'fields\'>\n\t\t<input type=\"text\" name=\"ORA_RSRC_GROUP_ID\" id=\"ORA_RSRC_GROUP_ID\" maxlength=\'20\' onBlur=\"ChangeUpperCase(this)\" onKeyUp=\"CheckForNumber(this);\" onKeyPress=\"return CheckForSpecCharsforID(event)\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t</td>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'fields\'><input type=\"text\" onBlur=\'makeValidQueryCriteria(this)\' name=\"ORA_RSRC_GROUP_NAME\" id=\"ORA_RSRC_GROUP_NAME\" maxlength=\'30\' size = \'10\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\n</tr>\n<tr><td colspan=\'4\' class=\'label\'>&nbsp;</td></tr>\n\n<tr><th colspan=\'4\' align=\'left\' width=\'100%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th></tr>\n<tr>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n</tr>\n<tr>\t\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'fields\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<input type=\"radio\" name=\"ExpPeriod1\" id=\"ExpPeriod1\"  value=\"none\" onClick=\"ExpVal()\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<input type=\"radio\" name=\"ExpPeriod1\" id=\"ExpPeriod1\"  value=\"days\"  onClick=\"ExpVal()\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n\t<input type=\"text\" name=\"ORA_PWD_LIFE_TIME\" id=\"ORA_PWD_LIFE_TIME\"  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" size=\'3\'  onBlur=\"CheckPositiveNumber1(this)\" onKeyUp=\"enabdisblifegrace()\" onKeyPress=\"return(ChkNumberInput(this,event,0))\" maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >&nbsp;<span >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span></td>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t<td class=\'fields\'>\n\t<input type=\"text\" name=\"ORA_PWD_GRACE_TIME\" id=\"ORA_PWD_GRACE_TIME\" size=\'3\' onBlur=\"CheckPositiveNumber1(this)\" onKeyPress=\"return(ChkNumberInput(this,event,0))\" maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;</td>\n</tr>\n\n\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t<td class=\'fields\'>\n\t\t\n\n    <SELECT name=\"prohibitReuse\" id=\"prohibitReuse\" onChange=\'enableReuseOption(this)\'>\n\t \n\t  <option value=\'P\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t  <option  value=\'R\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t </select>\n\t</td>\n\t<input type=\"hidden\" name=\"ORA_PWD_REUSE_MAX\" id=\"ORA_PWD_REUSE_MAX\" size=\'3\' value=\'2147483646\'  onBlur=\"CheckPositiveNumber1(this)\" maxlength=\'3\'>\n\t</td>\n\t\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\n<script>\n//Maheshwaran K has modified the Option value to display the Reuse Option for Password Validation as on 18/07/2012\ndocument.forms[0].prohibitReuse.options[1].selected=true</script>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<script>document.forms[0].prohibitReuse.options[1].selected=true</script>\n\t\t\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\n\t<td class=\'label\'  >\n\n<label id=\'reuseafterhide\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</label></td><td>\n\t<input type=\"text\" style=\'visibility:hidden\' name=ORA_PWD_REUSE_TIME size=\'3\' maxlength=\'3\' colspan=1 value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onBlur=\"putDecimal(this,3,0);CheckPositiveNumber1(this)\" onKeyPress=\"return(ChkNumberInput(this,event,0))\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >\n\t<!--Maheshwaran K added for Password validation as on 18/07/2012-->\n\t<img name =\'mand_img\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>&nbsp;\n\t<!--End-->\n\n\t<select name=changes style=\'visibility:hidden\' onChange=\'ExpVal3()\'>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<option value=\'D\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t</select>\n</td>\n\n</tr>\n\n\n\n<tr >\n\t<td colspan=\'4\' class=\'label\'>&nbsp;</td>\n</tr>\n\n<TR>\t\n\t<td class=\'label\'   width=\'20%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t<td class=\'fields\' width=\'25%\' ><input type=\"text\" name=\"ORA_FAILED_LOGIN_ATTEMPTS\" id=\"ORA_FAILED_LOGIN_ATTEMPTS\" size=\'3\' onBlur=\"putDecimal(this,3,0);CheckPositiveNumber1(this)\" onKeyPress=\"return(ChkNumberInput(this,event,0))\" onKeyUp=\"enabdisbpasswdlock()\" maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"></td>\n\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t<td class=\'fields\' width=\'35%\'><input type=\"text\" name=\"ORA_PWD_LOCK_TIME\" id=\"ORA_PWD_LOCK_TIME\" size = \'3\' onBlur=\"CheckPositiveNumber1(this)\" onKeyPress=\"return(ChkNumberInput(this,event,0))\" MAXLENGTH=\'3\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n</tr>\n<tr>\n\t<td colspan=\'4\' width=\'100%\' class=\'label\'>&nbsp;</td>\n</tr>\n<TR>\t\n\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t<td class=\'fields\' width=\'35%\'><input type=\"text\" name=\"password_expiry_alert_days\" id=\"password_expiry_alert_days\" size = \'3\' onBlur=\"CheckPositiveNumber1(this)\" onKeyPress=\"return(ChkNumberInput(this,event,0))\" MAXLENGTH=\'3\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' name=\"img_password_expiry_alert_days\" style=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></img></td>\n\t\n</tr>\n<tr>\n\t<td colspan=\'4\' width=\'100%\' class=\'label\'>&nbsp;</td>\n</tr>\n</table>\t\n\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t<input type=\'hidden\' name=\'ExpPeriodVal\' id=\'ExpPeriodVal\'>\n\t\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\t<SCRIPT>\n\t\n\tdocument.DBResourceGrp_form.ORA_RSRC_GROUP_ID.value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\t\n\tdocument.DBResourceGrp_form.ORA_RSRC_GROUP_ID.readOnly= true;\n\tdocument.DBResourceGrp_form.ORA_RSRC_GROUP_NAME.value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"; \n\tdocument.DBResourceGrp_form.ORA_PWD_GRACE_TIME.value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";  \n\tdocument.DBResourceGrp_form.ORA_PWD_LIFE_TIME.value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";   \n\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";  \n\tdocument.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";   \n\tdocument.DBResourceGrp_form.ORA_FAILED_LOGIN_ATTEMPTS.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"; \n\tdocument.DBResourceGrp_form.ORA_PWD_LOCK_TIME.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";  \n\t</SCRIPT>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\n\t<SCRIPT>\n//\t\tdocument.DBResourceGrp_form.elements[2].checked = true; \n\t</SCRIPT>\t\t\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\n\t<SCRIPT>\n//\t\tdocument.DBResourceGrp_form.elements[3].checked = true; \n\t</SCRIPT>\t\t\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\n\t<SCRIPT>\t\t\n//\t\tdocument.DBResourceGrp_form.elements[13].checked = true; \n\t</SCRIPT>\t\t\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\n\t<SCRIPT>\t\t\n//\t\tdocument.DBResourceGrp_form.elements[15].checked = true; \n\t</SCRIPT>\t\t\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\n\n\n\n<input type=hidden name=\'change_type\' id=\'change_type\' value=\'\'>\n\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n<script>\nDisabFunc();\n</script>\n</HTML>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

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
	PreparedStatement pstmt= null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null;

	String ora_pwd_grace_time="";
	String ora_pwd_life_time="";
	String ora_pwd_reuse_time="";
	String ora_pwd_reuse_max="";
	String ora_failed_login_attempts="";
	String ora_pwd_lock_time="";
	String ora_idle_time="";
	String ora_private_sga_unit="";
	String ora_rsrc_group_name="" ;
	String disp="";
	String p_reuse_time="";
	String p_reuse_max_time="";
	String PASSWORD_EXPIRY_ALERT_DAYS="";

	String operation = request.getParameter("operation");	
	if(operation==null) operation="";
	String ora_rsrc_group_id   = request.getParameter("ora_rsrc_group_id");
	if(ora_rsrc_group_id==null) ora_rsrc_group_id="";

	if(!(operation.equals("insert")))
	{
	
	  String sql ="SELECT ora_rsrc_group_id,ora_rsrc_group_name,ora_pwd_grace_time,nvl(ora_pwd_life_time,null)ora_pwd_life_time,ora_pwd_reuse_time,ora_pwd_reuse_max,ora_failed_login_attempts,ora_pwd_lock_time,ora_idle_time,ora_sessions_per_user,ora_connect_time ,ora_private_sga	,ora_private_sga_unit,ora_cpu_per_session,ora_cpu_per_call,ora_ir_per_session,ora_ir_per_call,PASSWORD_EXPIRY_ALERT_DAYS from SM_ORA_RSRC_GRP where ora_rsrc_group_id =? ";
	  
	  System.err.println("AddModifyDatabaseRsrcgrp.jsp====>"+sql);
	  
		pstmt = con.prepareStatement( sql );
		pstmt.setString	(	1,	ora_rsrc_group_id		);
		rs    = pstmt.executeQuery() ;
		
		if(rs!=null)
		{
		 if(rs.next())
		  {
			ora_rsrc_group_id = rs.getString ("ora_rsrc_group_id");
			if(ora_rsrc_group_id == null ) ora_rsrc_group_id = "";

			ora_rsrc_group_name = rs.getString ("ora_rsrc_group_name");
			if(ora_rsrc_group_name == null ) ora_rsrc_group_name = "";

			ora_pwd_grace_time  = rs.getString ("ora_pwd_grace_time");
			if(ora_pwd_grace_time == null ) ora_pwd_grace_time = "";

			ora_pwd_life_time   = rs.getString ("ora_pwd_life_time");
			if(ora_pwd_life_time == null ) ora_pwd_life_time = "";

			ora_pwd_reuse_time  = rs.getString ("ora_pwd_reuse_time");
			if(ora_pwd_reuse_time == null ) ora_pwd_reuse_time = "";

			ora_pwd_reuse_max   = rs.getString ("ora_pwd_reuse_max");
			if(ora_pwd_reuse_max == null ) ora_pwd_reuse_max = "";

			ora_failed_login_attempts = rs.getString ("ora_failed_login_attempts");
			if(ora_failed_login_attempts == null ) ora_failed_login_attempts = "";

			ora_pwd_lock_time  = rs.getString ("ora_pwd_lock_time");
			if(ora_pwd_lock_time == null ) ora_pwd_lock_time = "";
			
			PASSWORD_EXPIRY_ALERT_DAYS  = rs.getString ("PASSWORD_EXPIRY_ALERT_DAYS");
			if(PASSWORD_EXPIRY_ALERT_DAYS == null ) PASSWORD_EXPIRY_ALERT_DAYS = "";
			}
	}	
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ora_rsrc_group_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ora_rsrc_group_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		String ednone = "";
		String eddays = "";
		String imgvis = "visibility:hidden";

		//if (ora_pwd_life_time!=null && !ora_pwd_life_time.equals(""))
		if (PASSWORD_EXPIRY_ALERT_DAYS!=null && !PASSWORD_EXPIRY_ALERT_DAYS.equals(""))	
		{
			ednone = "";
			disp="";
			eddays = "checked";
			imgvis = "visibility:visible";
		}
		else
		{
			ednone = "checked";
			disp="disabled";
			eddays = "";
		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ednone));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(eddays));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ora_pwd_life_time));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ora_pwd_grace_time));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disp));
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
if ((ora_pwd_reuse_time.equals("") && !ora_pwd_reuse_max.equals("") ) || (ora_pwd_reuse_time==null && ora_pwd_reuse_max!=null ))
	{p_reuse_max_time = ora_pwd_reuse_max;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
	else if ((!ora_pwd_reuse_time.equals("") && ora_pwd_reuse_max.equals("") ) || (ora_pwd_reuse_time!=null && ora_pwd_reuse_max==null ))
	{
		p_reuse_max_time = ora_pwd_reuse_time;
            _bw.write(_wl_block32Bytes, _wl_block32);
}


            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_reuse_max_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(p_reuse_time));
            _bw.write(_wl_block37Bytes, _wl_block37);


	String d_checked="";
	String c_checked="";

	if (ora_pwd_reuse_max!=null && !ora_pwd_reuse_max.equals(""))
	{
		c_checked="selected";
		d_checked="";
	}
	else
	{
		c_checked="";
		d_checked="selected";
	}


            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(d_checked));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(c_checked));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ora_failed_login_attempts));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ora_pwd_lock_time));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PASSWORD_EXPIRY_ALERT_DAYS));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(imgvis));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block51Bytes, _wl_block51);

	if(!(operation.equals("insert")))
	{

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ora_rsrc_group_id ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ora_rsrc_group_name ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ora_pwd_grace_time ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(ora_pwd_life_time ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(p_reuse_max_time));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ora_pwd_reuse_max ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ora_failed_login_attempts ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(ora_pwd_lock_time ));
            _bw.write(_wl_block60Bytes, _wl_block60);

	if(ora_private_sga_unit.equals("KB"))
	{

            _bw.write(_wl_block61Bytes, _wl_block61);
	}	
	else
	{

            _bw.write(_wl_block61Bytes, _wl_block61);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	}	

            _bw.write(_wl_block62Bytes, _wl_block62);

	if ((ora_pwd_grace_time != "")||(ora_pwd_life_time != ""))
	{

            _bw.write(_wl_block63Bytes, _wl_block63);
	
	}
	else
	{

            _bw.write(_wl_block64Bytes, _wl_block64);
	
	}

	if ((ora_idle_time != ""))
	{

            _bw.write(_wl_block65Bytes, _wl_block65);
	
	}
	else
	{

            _bw.write(_wl_block66Bytes, _wl_block66);
	
	}

            _bw.write(_wl_block67Bytes, _wl_block67);

}catch(Exception e){out.println(e);
e.printStackTrace();}
			finally {
				if(pstmt != null) pstmt.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.DatabaseResourceGroup.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PasswordControl.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ExpirationPeriod.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.none.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.GraceTime.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ReuseOption.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ProhibitReuse.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Reuse.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Reuse.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.After.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Changes.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.FailedLoginAttempts.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PasswordLockPeriod.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PasswordExpiryAlert.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
}
