package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifymedicalteam extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addModifyMedicalTeam.jsp", 1720001607915L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script language=\'javascript\' src=\'../../eFM/js/checkSystemDate.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\'../../eAM/js/MedicalTeam.js\'></script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n<script>\n\n function focusTxt()\n\t {\n\t \tfacilityteam_form.teamid.focus();\n\t }\n\t \n\tfunction ObjChkYN(Obj)\n\t{\n\tif(Obj.checked == true)\n\t\tObj.value=\'Y\';\n\telse\n\t\tObj.value=\'N\';\n\t\n\t}\n</script>\t \n\n</head>\n<body onLoad=\'FocusFirstElement();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n<br><br><br><br>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'facilityteam_form\' id=\'facilityteam_form\' action=\'../../servlet/eAM.MedicalTeamServlet\' method=\'post\' target=\'messageFrame\'>\n<div>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'70%\' align=\'center\'>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\n</tr>\n\t\t<tr>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t     <td  class=\'label\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t     <td class=\'fields\' align=\'left\'>\n\t\t     ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t     &nbsp;&nbsp;<select name=\'facility_id\' id=\'facility_id\' >\n\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="----- </option>\n\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t&nbsp;&nbsp;<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><input type=\'text\' readOnly name=\'35\' name=\'facility_desc\' id=\'facility_desc\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" size=\"70\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t <td colspan=\'2\'>&nbsp;</td>\n\t\t\t </tr>\n\t\t\t<tr>\n\t\t\t<td colspan=\'5\'>&nbsp;</td>\n</tr>\t\t\t \n<tr>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\n\t\t<td class=\'fields\'>&nbsp;\n\t\t<input type=\'text\' name=\'teamid\' id=\'teamid\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=\'6\' maxlength=\'6\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onKeyPress=\"return CheckForSpecChars(event)\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n\n</tr>\n\n<tr>\n\t\t <td class=\'label\'>&nbsp;</td>\n\t\t<td    class=label>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td class=\'fields\'>&nbsp;\n\t\t<input type=\'text\' onBlur=\"makeValidString(this)\" name=\'long_desc\' id=\'long_desc\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\n\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td    class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td class=\'fields\'>&nbsp;\n\t\t\t<input type=\'text\' onBlur=\"makeValidString(this)\" name=\'short_desc\' id=\'short_desc\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td class=\'fields\'>&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<input type=\'hidden\' name=\'specialty\' id=\'specialty\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><select disabled name=\'specialty1\' id=\'specialty1\'><option value=\'\'>----- ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="----- \n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<select name=\'specialty\' id=\'specialty\'><option value=\'\'> ----- ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="-----\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</select>\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n\n<tr>\n\t\t\t<td class=\"label\"></td>\n\t\t\t<td align=\'left\' class=\'label\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td class=\"fields\">\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t&nbsp;<input type=\"checkbox\" name=\"appl_for_op_yn\" id=\"appl_for_op_yn\" value=\'N\' onClick=\'ObjChkYN(this)\'>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t&nbsp;<input type=\"checkbox\" name=\"appl_for_op_yn1\" id=\"appl_for_op_yn1\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" onClick=\'ObjChkYN(this)\' disabled><input type=\'hidden\' name=\'appl_for_op_yn\' id=\'appl_for_op_yn\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;&nbsp;\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<input type=\"checkbox\" name=\"appl_for_ip_yn\" id=\"appl_for_ip_yn\" value=\'N\' onClick=\'ObjChkYN(this)\'>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<input type=\"checkbox\" name=\"appl_for_ip_yn1\" id=\"appl_for_ip_yn1\"  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" onClick=\'ObjChkYN(this)\' disabled><input type=\'hidden\' name=\'appl_for_ip_yn\' id=\'appl_for_ip_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t</td><td>&nbsp;</td><td>&nbsp;</td>\n</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t<td class=\"label\"></td>\n\t\t\t<td align=\'left\' class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t&nbsp;<input type=\"checkbox\" name=\"appl_for_mr_yn\" id=\"appl_for_mr_yn\" value=\'N\' onClick=\'ObjChkYN(this)\'>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t&nbsp;<input type=\"checkbox\" name=\"appl_for_medical_report_yn1\" id=\"appl_for_medical_report_yn1\" value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" onClick=\'ObjChkYN(this)\' disabled><input type=\'hidden\' name=\'appl_for_mr_yn\' id=\'appl_for_mr_yn\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n\n\n\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr><td>&nbsp;</td>\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td><td class=\'fields\' colspan=\'2\' nowrap>&nbsp;&nbsp;<input type=\'text\' maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\'  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onBlur=\"DateCompare_from(\'from\',this,sys_date_val);\"><input type=\'hidden\' name=\'greg_from_date_hd\' id=\'greg_from_date_hd\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"><img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].from_date.focus();return showCalendar(\'from_date\');\" tabindex=-1><input type=\'hidden\' name=\'greg_from_date\' id=\'greg_from_date\' value=\'\'> - <input type=\'text\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\"DateCompare_from(\'To\',this,sys_date_val);DateCompare3(from_date,this);\"><input type=\'hidden\' name=\'greg_to_date_hd\' id=\'greg_to_date_hd\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"><img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].to_date.focus();return showCalendar(\'to_date\');\" tabindex=-1><input type=\'hidden\' name=\'greg_to_date\' id=\'greg_to_date\' value=\'\'></td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<td class=\'label\' align=right nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" readonly> - <input type=\'text\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' readonly>&nbsp;</td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t<td>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t<td class=\'fields\'>&nbsp;<input type=\"checkbox\" name=\"eff_status\" id=\"eff_status\" value=\'E\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =">\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td colspan=\'4\' class=\'bodycolorfilled\' >&nbsp;</td>\n</tr>\n\t<input type=\"hidden\" name=\"sys_date_val\" id=\"sys_date_val\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n</table>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement pstmt1 = null;
   ResultSet rs	= null;
   PreparedStatement pstmt=null;
   
   Statement splstmt =null;
   ResultSet splrs	= null;
   ResultSet rset1 = null;
String globaluser="";
String sys_date_val="";

String locale = (String)session.getAttribute("LOCALE");


java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
globaluser = (String)p.getProperty("login_user");

   ResultSet rset=null;
   String facility_id ="";
   String facilityId = (String)session.getValue("facility_id");

facility_id=request.getParameter("facility_id");
if(facility_id == null) facility_id="";
else
facilityId=facility_id;
   String longdesc="";
   String shortdesc="";
   
   String chk1 = "CHECKED";
   String speciality_code="";

   String effstatus="E";
   String codeTextAttribute="";
   String otherTextAttribute="";
   
   String eventFunctionForCase="";
  
   String teamid = "";
   String EFF_DATE_FROM = "";
   String EFF_DATE_TO = "";
   boolean newteam=false;
   String sql="";
   String appl_for_op_yn="",appl_for_ip_yn="",appl_for_mr_yn=""; // added by mujafar for ML-MMOH-CRF-0716
   String specialty_query_code="";
   String op_checked_yn = "",mr_checked_yn=""; // added by mujafar for ML-MMOH-CRF-0716
   String ip_checked_yn = "";
   String EFF_DATE_FROM_DISP="";
	String EFF_DATE_TO_DISP="";

  teamid=request.getParameter("teamid");
		if(teamid == null) teamid = "";

String facility_desc = request.getParameter("facility_desc");
	if(facility_desc == null) facility_desc="";
	Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	
try{
	
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	
	
	String sys_date="select to_char(sysdate,'dd/mm/yyyy') from dual ";
	rset = stmt.executeQuery(sys_date);
	if(rset !=null && rset.next())
	{
		sys_date_val=rset.getString(1);

	}
	if(rset !=null) rset.close();
	String splqry="Select  Speciality_Code,Short_Desc from AM_SPECIALITY where Eff_Status = 'E' order by Short_Desc ";
	splstmt=conn.createStatement();		

	if(teamid.equals(""))
	 {
		teamid="";
		longdesc="";
		shortdesc="";
		codeTextAttribute="";
		otherTextAttribute="";

		newteam=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	 }
	 else
	 {
	 	

     	   try{

		sql =  "select to_char(EFF_DATE_FROM,'dd/mm/yyyy')EFF_DATE_FROM,to_char(EFF_DATE_TO,'dd/mm/yyyy')EFF_DATE_TO,TEAM_ID,LONG_DESC,SHORT_DESC,SERVICE_CODE,EFF_STATUS,speciality_code,appl_for_op_yn,appl_for_ip_yn,appl_for_mr_yn   from am_medical_team where facility_id =? and team_id=?"; // modified by mujafar for ML-MMOH-CRF-0716
		
		
		pstmt1   = conn.prepareStatement(sql);
		pstmt1.setString	(	1,	facility_id		);
		pstmt1.setString	(	2,	teamid		);

		rset		 = pstmt1.executeQuery();
				
			if(rset.next())
			{
				EFF_DATE_FROM =rset.getString("EFF_DATE_FROM");
				EFF_DATE_TO = rset.getString("EFF_DATE_TO");
				if(EFF_DATE_TO==null) EFF_DATE_TO ="";
				if(EFF_DATE_FROM==null) EFF_DATE_FROM ="";

				 EFF_DATE_FROM_DISP=DateUtils.convertDate(EFF_DATE_FROM,"DMY","en",locale);
				 EFF_DATE_TO_DISP=DateUtils.convertDate(EFF_DATE_TO,"DMY","en",locale);

				teamid		= rset.getString("TEAM_ID");
				longdesc	= rset.getString("long_desc");
				shortdesc	= rset.getString("short_desc");
				effstatus	= rset.getString("eff_status");
				speciality_code=rset.getString("speciality_code");
				if(speciality_code == null) speciality_code="";
				appl_for_op_yn=rset.getString("appl_for_op_yn");
				appl_for_ip_yn=rset.getString("appl_for_ip_yn");
				appl_for_mr_yn = rset.getString("appl_for_mr_yn"); // added by mujafar for ML-MMOH-CRF-0716
				if(appl_for_op_yn.equals("Y"))	op_checked_yn="Checked"; 
				else op_checked_yn = "Unchecked";
				if(appl_for_ip_yn.equals("Y"))	ip_checked_yn="Checked"; 
				else ip_checked_yn = "Unchecked"; 
				if(appl_for_mr_yn.equals("Y"))	mr_checked_yn="Checked";  // added by mujafar for ML-MMOH-CRF-0716
				else mr_checked_yn = "Unchecked";
			}
			if(effstatus.equals("D"))
			   {
				chk1 = "";
				otherTextAttribute="READONLY";
			   }
			   else
				   otherTextAttribute="";
	
	     }
		 catch(Exception e){e.printStackTrace();}
		codeTextAttribute="READONLY";
		newteam=false;
		eventFunctionForCase="";
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(newteam) { 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

				String dat="",id="",en="";
				pstmt=conn.prepareStatement("Select facility_name,facility_id  from sm_facility_for_user_vw where appl_user_id =? and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)");
				pstmt.setString	(	1,	globaluser		);
				rset1=pstmt.executeQuery();
				if(rset1!=null)
				{
				   while(rset1.next())
				   {
				   dat=rset1.getString("Facility_Name");
				   id=rset1.getString("Facility_Id");
				   if(id.equals(facilityId))
					en="selected";
				    else
					en="";

				 out.println("<option value='"+id+ "' "+en+">"+dat);

				   }
				}
				out.print("</select>");
			} else {
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(teamid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

			if(effstatus.equals("D"))
			{ 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 } else {
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 }
            _bw.write(_wl_block31Bytes, _wl_block31);
 splrs = splstmt.executeQuery(splqry); 
			while(splrs.next())
			{
			specialty_query_code= splrs.getString(1);
			if(specialty_query_code.equals(speciality_code))
				out.println("<option selected value='"+splrs.getString(1)+"'>"+splrs.getString(2)+"</option>");
			else
				out.println("<option  value='"+splrs.getString(1)+"'>"+splrs.getString(2)+"</option>");
			}
			
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(newteam) { 
            _bw.write(_wl_block34Bytes, _wl_block34);
 } else { 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(appl_for_op_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(op_checked_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(appl_for_op_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
 } 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(newteam) { 
            _bw.write(_wl_block41Bytes, _wl_block41);
 } else { 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(appl_for_ip_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ip_checked_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(appl_for_ip_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
 } 
            _bw.write(_wl_block44Bytes, _wl_block44);

			if(isMedicalTeamApplicable)
			{ // added by mujafar for ML-MMOH-CRF-0716
			
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
if(newteam) 
			{
			
            _bw.write(_wl_block46Bytes, _wl_block46);
 } else { 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(appl_for_mr_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mr_checked_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(appl_for_mr_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);

			}
			
            _bw.write(_wl_block49Bytes, _wl_block49);

			
			}
			
            _bw.write(_wl_block50Bytes, _wl_block50);
if(effstatus.equals("E"))
			{ 

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(EFF_DATE_FROM_DISP));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(EFF_DATE_FROM));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(EFF_DATE_TO_DISP));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(EFF_DATE_TO));
            _bw.write(_wl_block56Bytes, _wl_block56);

			}
			else 
			{

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(EFF_DATE_FROM));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EFF_DATE_TO));
            _bw.write(_wl_block59Bytes, _wl_block59);
			
			}

            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(chk1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sys_date_val));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block64Bytes, _wl_block64);
	if(newteam)
	{

            _bw.write(_wl_block65Bytes, _wl_block65);
  }
  	else
	{

            _bw.write(_wl_block66Bytes, _wl_block66);

	}

}
catch(Exception e) 
{
e.printStackTrace();
}
finally
	{
	try
	{
	if(rset!=null)    	rset.close();
	if(rs!=null)    	rs.close();	
	if(splrs!=null)     splrs.close();
	if(rset1!=null)     rset1.close();
	if(pstmt!=null)		pstmt.close();
	if(pstmt1!=null)		pstmt1.close();
   	if(stmt!=null)  	stmt.close();
	if(splstmt!=null)   splstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	ConnectionManager.returnConnection(conn,request);
}	

            _bw.write(_wl_block67Bytes, _wl_block67);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ApplicableForOutpatients.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ApplicableForInpatients.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ApplicableForMedicalReport.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ApplicablePeriodFrom.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ApplicablePeriodFrom.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
