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
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __responsibility_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/Responsibility_Form.jsp", 1713776933900L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<head>\n   \t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n   \t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n   \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n   \t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n   \t<script src=\'../../eSM/js/Responsibility.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n\t<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n  </head>\n\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'  onLoad=\"FocusFirstElement();\"> \n\t<form name=\'responsibility_form\' id=\'responsibility_form\' method=\'post\' target=\'messageFrame\' >\n\n\t\t\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t  <script>\n\t\t\t\t\t \n\t\t\t\t\t   alert(getMessage(\"MENUADMIN_CANNOT_CREATE_RESP\",\"SM\"));\n\t\t\t\t\t   parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t   parent.frames[0].document.forms[0].create.disabled=true;\n\t\t\t\t\t  </script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t\n\t\t\t<br>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'auto\' align=\'center\'>\n\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td colspan=\'2\' class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'resp_id\' id=\'resp_id\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=\'20\' onBlur=\"makeValidString(this);this.value=this.value.toUpperCase()\" maxlength=\'20\' onKeyPress=\"return CheckForSpecChars(event)\"  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t<td colspan=\'2\' class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\'resp_name\' id=\'resp_name\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  onBlur=\"makeValidString(this)\" size=\'30\' maxlength=\'60\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t <tr>\n\t\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t<select name=\'resp_group_id\' id=\'resp_group_id\'  onChange=\"clearMenu()\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="> \n\t\t\t\t\t\t\t\t<option value=\'\'>--------------";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="-----------</option>\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' selected>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t </td>\n\t\t\t\t\t\t\t <td width=\'25%\'></td>\n\t\t\t\t\t\t\t <td width=\'25%\'></td>\n\t\t\t\t\t   </tr>\n\t\t  <tr>\n\t\t  <td>&nbsp;</td>\n\t\t\t\t <td class=label>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t\t\t <td  class=\'fields\'>\n\t\t\t\t <input type=\'text\' name=\'menu_id_desc\' id=\'menu_id_desc\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"   size=\'30\' maxlength=\'30\'\n\t\t\t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="readonly ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" onBlur=\'hideUserdesktop(this,menu_id);populateMenuBlur(this,menu_id_desc,menu_id)\'><input type=\'hidden\' name=\'menu_id\' id=\'menu_id\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"><input type=\'button\' class=\'button\' value=\'?\'  onClick=\'populateMenu(this,menu_id_desc,menu_id)\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n\t\t\t\t &nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\n\t\t\t\t  <td>&nbsp;</td>\n\t\t\t\t  <td>&nbsp;</td>\n\t\t\t\t  </tr>\n\t  <tr class=\"label\">\n      </tr>\t \n        <tr>\n\t\t<td>&nbsp;</td>\n        <td class=label>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\n\t\t\t\t <td  class=\'fields\'>\n\t\t\t\t <input type=\'text\' name=\'dektop_id_desc\' id=\'dektop_id_desc\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"   size=\'30\' maxlength=\'30\'   onblur=\'populateDesktopBlur(this,dektop_id_desc,desktop_code);desktop_code_valid();\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ><input type=\'hidden\' name=\'desktop_code\' id=\'desktop_code\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ><input type=\'button\' name=\'dektop_id_desc1\' id=\'dektop_id_desc1\' value=\"?\"   size=\'30\' maxlength=\'30\'   onClick=\'populateDesktop(this,dektop_id_desc,desktop_code);desktop_code_valid()\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" >\n\n\t\t\t\t &nbsp;</td>\n\t\t\t\t  </tr>\n     <tr class=\"label\">\n  </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t\t\t <td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t <select name=\'ora_role_id\' id=\'ora_role_id\'  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\t\t\t\t\t\t\t\t<option value=\'\'>--------------";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t </select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t </td>\n\t\t\t\t\t\t\t <td width=\'25%\'></td>\n\t\t\t\t\t\t\t <td width=\'25%\'></td>\n\t\t\t\t\t   </tr>\n\t\t\t\t\n\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<textarea name=\'remarks\' id=\'remarks\' rows=\'4\' onBlur=\"makeValidString(this)\" cols=\'45\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" onkeypress=\'checkMaxLimit(this,200)\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</textarea>&nbsp;&nbsp;</td>\n\t\t\t\t<td width=\'25%\'>&nbsp;&nbsp;</td>\t\n\t\t\t</tr>\t\t\n\t\t\t\n\t\t\t\t<tr >\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' id=\'eff_date_from1\' name=\'eff_date_from1\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" size=\'10\' maxlength=\'10\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" onblur=\'if (!this.readOnly) {validate_from_date(this);}\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" name=\"fromDate1\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="  onClick=\"document.getElementById(\'eff_date_from1\').focus();return showCalendar(\'eff_date_from1\',null,null,true);\" style=\"cursor=\'hand\'\">\n\t\t\t\t\t<input type=\'text\'  name=\'eff_date_to1\' id=\'eff_date_to1\'  size=\'10\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"  ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" onblur=\'validate_to_date(this);\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" name=\"ToDate1\" src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" onClick=\"document.getElementById(\'eff_date_to1\').focus();return showCalendar(\'eff_date_to1\',null,null,true);\"></td>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t</tr>\n\t\t\t    \t\t\n\t\t\t<tr>\n\t\t\t\t<td width=\'25%\'></td>\t\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t\t\t<td colspan=\'2\' class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' size=\'1\' maxlength=\'1\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" onClick=\"change()\"></td>\n\t\t\t\t\t<td width=\'25%\'></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\t\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t\t<input type=\'hidden\' name=\'Medadmin\' id=\'Medadmin\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\n\t\t  ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n\t\t ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n\t\t\t<input type=\'hidden\' name=\'eff_date_from\' id=\'eff_date_from\' >\n\t\t\t<input type=\'hidden\' name=\'menuid\' id=\'menuid\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t<!--input type=\'hidden\' name=\'desk_code1\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'-->\n\t\t\t<input type=\'hidden\' name=\'desk_code1\' id=\'desk_code1\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'menuid_t\' id=\'menuid_t\' >\n\t\t\t<input type=\'hidden\' name=\'resp_group_id1\' id=\'resp_group_id1\' >\n\t\t\t<input type=\'hidden\' name=\'ora_role_id1\' id=\'ora_role_id1\' >\n\t\t\t<input type=\'hidden\' name=\'Role_id\' id=\'Role_id\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'eff_date_to\' id=\'eff_date_to\' >\n\t\t\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' >\n\n\t\t\t<input type=\'hidden\' name=\'old_eff_date_from\' id=\'old_eff_date_from\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t<input type=\'hidden\' name=\'old_eff_date_to\' id=\'old_eff_date_to\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flagg\' id=\'flagg\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'desktop_summary_type\' id=\'desktop_summary_type\' value=\'N\'>\n\n\t\t\t</form>\n\t\t\t</body>\n\t\t\t</html>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

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
		String locale	  = (String)session.getAttribute("LOCALE");
    	String Log_user   = (String) session.getAttribute("login_user"); 
		String Role_id ="";
		int Medadmin=0;
		String responsibility_id= (String) session.getAttribute("responsibility_id");
		String qmenuid= request.getParameter("menuid");
		if(qmenuid == null) qmenuid="";
		String desktopcode1= request.getParameter("desktop_code1");
		if(desktopcode1 == null) desktopcode1 ="";
		if(desktopcode1.equals(" ")) desktopcode1="";
			//desktopcode1=desktopcode1.trim();

		String qmenuname= request.getParameter("menuname");
		if(qmenuname == null) qmenuname ="";
		String sys_defined_yn= request.getParameter("sys_defined_yn");
		if(sys_defined_yn == null) sys_defined_yn="Y";
	
	
		 String  responsibilityID="";
		 String responsibilityName="";
 		 String menuid="";
		 String menuName="";
		 String menuname1="";
		 String remark="";
		 String effdatefrom="";
		 String effdateto="";
   
		 String old_eff_date_from="";
		 String old_eff_date_to="";
		 String eff_date_from="";
		 String eff_date_to="";
		 String diffdate = "0";
		 String redOnly = "";
		 String disableFld="";
		 String effstatus	="";
		 String resp_group_id	="";
		 String ora_role_id	="";

		 String id	="";
		 String dat	="";
		 String ListDisable	="";

		 StringBuffer str1=new StringBuffer();
		 String sql="";

		 String disable_resp="";
		 String chkBoxEffStatusAttribute="";

		 String eventFunctionForCase="";
		 String textAttribute="";
		 String disabledAttribute="";
		 String disableOnEnableFalse="";
		 String disable_others="";
		 String disable_others1="";
		 String desk_code="";
		 String desk_name="";
		 String d_code="";
		 String root_menu="";
		 String dev_tool="";
		 String userde="";

		
	
		Connection conn=null;
		Statement stmt=null;
		Statement stmt1=null;
		try{
			conn = ConnectionManager.getConnection(request);
			ResultSet rset=null;
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
			boolean newResponsibility=false;
	
            _bw.write(_wl_block8Bytes, _wl_block8);

		stmt=conn.createStatement();
	/*	String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
		ResultSet rs=stmt.executeQuery(sqlRole);
		if (rs !=null){
			while (rs.next()){
						Role_id=rs.getString(1);
				}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}	

  	if(Role_id.equals("MEDADMIN"))	
			{
				
			}*/
		responsibilityID=request.getParameter("resp_id");
		if(responsibilityID==null){
		try{
			responsibilityID="";
			responsibilityName="";

			String sql1 = "select menu_id,menu_name from sm_menu_hdr where adhoc_menu_yn='N' and ROOT_MENU_YN='Y' order by menu_name";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql1);
			if(str1.length() > 0) str1.delete(0,str1.length());
			str1.append("<select name='menu_id' id='menu_id'>");
			 str1.append("<option value=''>----------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------------------</option>"); 
			while(rset.next()){

					menuid=rset.getString("menu_id");
					menuName=rset.getString("menu_name");
					str1.append("<option value='"+menuid+"'>"+menuName);

				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				str1.append("</select>");
				str1.setLength(0);

				remark="";
				effdatefrom="";
				effdateto="";
				effstatus="E";
				chkBoxEffStatusAttribute="checked";

			}catch(Exception e){
				
			}
			
			newResponsibility=true;
			
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
			textAttribute="";
			disabledAttribute="";
		}else{
				newResponsibility=false;
				textAttribute="READONLY";

                   
			 try{

				 sql = "select resp_id,resp_name,menu_id,resp_group_id ,ora_role_id, desktop_code  ,remarks,eff_date_from,trunc(sysdate)-trunc(eff_date_from) diffdate,eff_date_to,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1,eff_status from sm_resp  where resp_id='"+responsibilityID+"'" ;

				 stmt = conn.createStatement();
				 rset = stmt.executeQuery(sql);
				 rset.next();
				 responsibilityID=rset.getString("resp_id");

				 responsibilityName=rset.getString("resp_name");

				 qmenuid=rset.getString("menu_id");
				 if (qmenuid==null) qmenuid="";
				 d_code=rset.getString("desktop_code");
				 if (d_code==null) d_code="";

				 resp_group_id=rset.getString("resp_group_id");
				 if (resp_group_id==null) resp_group_id="";
				 ora_role_id=rset.getString("ora_role_id");
				 if (ora_role_id==null) ora_role_id="";

				 remark=rset.getString("remarks");

				 if(remark==null){

					remark="";
				 }

				 if(rset.getDate("eff_date_from") != null ){
						 java.util.Date date = rset.getDate("eff_date_from");
						 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
						 effdatefrom = formatter.format(date);
						 effdatefrom=DateUtils.convertDate(effdatefrom,"DMY","en",locale);
						 date = null;
						 formatter = null;
						 
					}else {
						effdatefrom="";
					}

				if ( rset.getDate("eff_date_to") != null){
						 java.util.Date date1 = rset.getDate("eff_date_to");
						 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
						 effdateto = formatter.format(date1);
					     effdateto=DateUtils.convertDate(effdateto,"DMY","en",locale);	 
						 date1 = null;
						 formatter = null;
					}else {
						effdateto="";
					}

							eff_date_from=rset.getString("eff_date_from1");
							if( eff_date_from==null ) 
							{
								eff_date_from="";
								old_eff_date_from="";
							}
							old_eff_date_from=eff_date_from;

							
							eff_date_to=rset.getString("eff_date_to1");
							if( eff_date_to==null ) 
							{
								eff_date_to="";
								old_eff_date_to="";
							}
							old_eff_date_to=eff_date_to;
							
							diffdate = rset.getString("diffdate");
							
							if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";
							

				effstatus=rset.getString("eff_status");

					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				if(effstatus.equals("D")){


					chkBoxEffStatusAttribute="";
					disabledAttribute="READONLY";
					disableOnEnableFalse="disabled";
					ListDisable="disabled";
					
				}else{

					chkBoxEffStatusAttribute="checked";

				}
				
               if(sys_defined_yn.equals("Y"))
                  ListDisable="disabled";
               
		   	
				if(!qmenuid.equals("")){

				sql="Select menu_id,menu_name,root_menu_yn, dev_tool from sm_menu_hdr where  root_menu_yn='Y' and menu_id ='"+qmenuid+"'";
					stmt = conn.createStatement();
					rset = stmt.executeQuery(sql);
					while(rset.next()){
						
						menuname1=rset.getString("menu_name");
						root_menu=rset.getString("root_menu_yn");
						dev_tool=rset.getString("dev_tool");
						}

					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
		}else{
					menuname1="";
				}


			if(!dev_tool.equals("J"))
			{
				userde="disabled";
			}
			else{
			}


	    //sql="select desktop_code , desktop_name  from sm_desktop_setup where desktop_code='"+d_code+"' ";

				if(!d_code.equals("")){

                    sql="select DESKTOP_SUMMARY_ID desktop_code, DESKTOP_SUMMARY_NAME desktop_name from SM_DESKTOP_SUM_HDR where DESKTOP_SUMMARY_ID='"+d_code+"' ";

					

					stmt = conn.createStatement();
					rset = stmt.executeQuery(sql);
					
					while(rset.next()){
						
						//desk_code=rset.getString("desktop_code");
						desktopcode1=rset.getString("desktop_code");
						desk_name=rset.getString("desktop_name");


						}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}else{
					desktopcode1="";
					desk_name="";
				}


			}catch(Exception e){
				out.println(e.toString());
			}

		

	
				if(responsibilityID!="")
				{

				//if(Role_id.equals("MEDADMIN"))
				//	{
						if(resp_group_id!="")
						{
							disable_resp="disabled";
						}
					//}
				}

		}


		
	/*	String sql_m="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and trunc (sysdate) >= nvl (trunc (eff_date_from), sysdate - 1) and trunc (sysdate) <= nvl (trunc (eff_date_to), sysdate + 1) ";
		stmt1=conn.createStatement();
		rset=stmt1.executeQuery(sql_m);
		if (rset !=null){
			while (rset.next()){
						Medadmin=Integer.parseInt(rset.getString(1));
				}
		if(rset!=null) rset.close();
		if(stmt1!=null) stmt1.close();
		}*/
		
	//if(!Role_id.equals("MEDADMIN"))
	//{
	/*	if(Medadmin==0 )
		{ 
		if(responsibilityID.equals(""))
			{
		
		
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
	else 
			{
				disable_others="readonly";
				disable_others1="disabled";
			}
		}*/
	//	}
   

	try{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(responsibilityID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textAttribute));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disabledAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(responsibilityName));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disabledAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_resp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others1));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 
								 String sqlresp="select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E'  order by resp_group_name ";
								 stmt = conn.createStatement();
								 ResultSet rsresp = stmt.executeQuery(sqlresp);
								  while(rsresp.next()){
								id=rsresp.getString("resp_group_id");
								dat=rsresp.getString("resp_group_name");

								if(id.equals(resp_group_id))
									  {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
								else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
								 }
									if(rsresp!=null) rsresp.close();
									if(stmt!=null) stmt.close();
								  
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(menuname1));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(!(menuname1.equals("")) && (sys_defined_yn.equals("Y")))
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(qmenuid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(desk_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(userde));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(desktopcode1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(userde));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ListDisable));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others1));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 
								 String sql1="select  ORA_ROLE_ID,  ORA_ROLE_ID ora_role from sm_ora_role where  ora_role_id not in ('MEDSTARTUP','MEDADMIN') order by  ORA_ROLE_ID";
								 stmt = conn.createStatement();
								 ResultSet rsrole = stmt.executeQuery(sql1);
								while(rsrole.next()){
								id=rsrole.getString("ORA_ROLE_ID");
								dat=rsrole.getString("ora_role");

								if(id.equals(ora_role_id))
									{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
								  }
									if(rsrole!=null) rsrole.close();
									if(stmt!=null) stmt.close();
								  
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(disabledAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(remark));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

					if (Integer.parseInt(diffdate)>0)
					{
					redOnly = "readonly";
					disableFld = "disabled";
					}
				else
					{
					redOnly = "";
					disableFld = "";
					}
					
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(redOnly));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(effdatefrom));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(disabledAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disableOnEnableFalse));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disableFld));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(effdateto));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disabledAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disableOnEnableFalse));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chkBoxEffStatusAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_others1));
            _bw.write(_wl_block61Bytes, _wl_block61);
  if(newResponsibility){
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(Medadmin));
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{ 
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(menuid));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(desk_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(desktopcode1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Role_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(dateFormat.format( new java.util.Date() ) ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(old_eff_date_from));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(old_eff_date_to));
            _bw.write(_wl_block72Bytes, _wl_block72);

			
				}catch(Exception e){out.println("Error "+e);}
				
				}catch(Exception e){out.println(e);}
			finally {
				ConnectionManager.returnConnection(conn,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ResponsibilityGroup.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.menu.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.user.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Desktop.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
