package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import webbeans.eCommon.MessageManager;
import java.util.*;
import com.ehis.util.*;

public final class __createfilecomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/CreateFileComponent.jsp", 1742535856689L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../js/FileComponent.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tfunction allowAlphaNumeric(event){\n\t\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\treturn true ;\n\t}\n//added by N Munisekhar against  [IN:045249] \n\n//Modified by Sangeetha for GDOH-CRF_0103\n     \tfunction removeSpec(objSpec)\n\t     {  \n                var data = objSpec.value;\n                for (var i = 0; i < data.length; i++)\n                {  \n\t\t\t\t if (!(((data.charCodeAt(i)>=48) && (data.charCodeAt(i)<=57))||((data.charCodeAt(i)>=65) && (data.charCodeAt(i)<=90))||((data.charCodeAt(i)>=97) && (data.charCodeAt(i)<=122))))\n                    {    \n\t\t\t\t\tdata=data.replace(/[!`@#$%^&*()+=\\-\\[\\]\';,.\\/{}|\\s\":<>\\\\?~_]/g,\'\');\n                    objSpec.value =data;                    \n\t\t\t\t\treturn false; \n                    } \n                }\n\t\t\t\treturn true;\n         }\n\t\n\tfunction changeCase(Obj)\n\t{\n\t\tObj.value =Obj.value.toUpperCase();\n\t}\n</script>\n<!--\tgetCreateFileComponentValues(),doSubmit(),doClose() & doReturn() are moved to FileComponent.js-->\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey();\' style=\'background-color:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";\'> \n<form name=\"createFileComponent\" id=\"createFileComponent\">\n<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'1\' align=center>\n    <tr>\n    <td width=\'50%\'>&nbsp;</td>\n    <td width=\'50%\'>&nbsp;</td>\n    </tr>    \t\n\t<tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<tr>\n    <td width=\'50%\'>&nbsp;</td>\n    <td width=\'50%\'>&nbsp;</td>\n    </tr>\n\t<tr>\n    <td width=\'50%\'>&nbsp;</td>\n    <td width=\'50%\'>&nbsp;</td>\n    </tr><td class=\'label\' align=\'center\' colspan=\'2\' id =\'mrSectionId\'></td>\n\t<script>\n\tdocument.getElementById(\'mrSectionId\').innerHTML=getMessage(\'MR_SECTION_NOT_DEFINED\',\'MP\');\t\n\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</tr><tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr>\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  <!-- <td width=\'50%\' colspan=2 class=\'data\' align=center><font align=center>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></td> -->\n\t\t\t   <td width=\'50%\' colspan=2 class=\'data\' align=center id=\'errmsg\'><font align=center></font></td>\n\t\t\t\t<script>var msg=getMessage(\"FILE_TYPE_NOT_APPL\",\"MP\");\n\t\t\t\tdocument.getElementById(\'errmsg\').innerHTML=msg;</script> \n\t\t</tr>\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t<tr>\t\t\t\t\n\t\t\t<td colspan=2 align=center><input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="    \' onclick=\'doClose();\'></td>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<td class=\"label\" align=\"left\" width=\"40%\" nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td>\n   <td width=\"60%\" align=\"left\" nowrap><select name=\'fs_locn_code\' id=\'fs_locn_code\'   onchange=\'getCreateFileComponentValues_dummy();\'   onmousewheel=\'return false;\'><option value=\'\'>--------";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="-------</option> \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<OPTION VALUE=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</select>&nbsp;<img src=\'../images/mandatory.gif\'></img></td>\n        ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<td class=\"label\" align=\"left\" width=\"40%\" nowrap>&nbsp;</td><td width=\"60%\" align=\"left\" nowrap>&nbsp;</td>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\n    </tr>\n\t<!-- <tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr> -->\n\t<tr>\n    <td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td> \n    <td width=\'50%\' class=label align=left>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<!-- MR Section&nbsp;</td><td class=label align=left><b><font id=\'mr_section\' class=\'label\'></font></b>\n\t</td> \n    </tr>-->\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n    <tr>\n    <td align=\'center\' class=\'label\' width=\'50%\'id = id1 colspan=2>\n\t</td>\n    </tr>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\t\n\t<tr>\n    <td align=\'left\' class=\'label\' width=\'50%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</td>\n\t<td><select name=\'file_type\' id=\'file_type\' ><option value=\'\'>--------";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="-------</option>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n            <OPTION VALUE=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'selected>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n            ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<OPTION VALUE=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\n\t\t<script>\n\t\tif(document.forms[0].fs_locn_code)\n\t\t\t\t{\n\t\tif(document.forms[0].fs_locn_code.value !=\"\")\n\t\tdocument.forms[0].file_type.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t}\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</select>&nbsp;<img src=\'../images/mandatory.gif\'></img>\n\t</td>\n    </tr>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td><tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\t\n\t<tr>    \n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="   <td width=\'50%\' colspan=2 class=\'data\' id=\'msg1\'><font align=center></font></td> \n\t\t\t\t<script>\n\t\t\t\tdocument.getElementById(\'msg1\').innerHTML=getMessage(\"FILE_NO_REQD_YN\",\"MP\");\n\t\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td width=\'50%\' colspan=2>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<td width=\'50%\' align=left class=label>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td><td class=label align=left><input type=text id=\'txt1\' name=old_file_no size=\'15\' maxlength=\'20\' onKeyPress=\'return allowAlphaNumeric(event)\' onBlur=\'changeCase(this);return removeSpec(this)\'>\n\t\t\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\t\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<td width=\'50%\' colspan=2>&nbsp;</td>\n\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n    </tr>\n\t\n\t<!-- Added by Sangeetha for GDOH-CRF-0103 on 6-feb-17 -->\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t<tr>\n\t<td width=\'50%\' align=left class=label>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td><td class=label align=left><input type=text id=\'altFile\' name=alt_file_no size=\'15\' maxlength=\'24\' onKeyPress=\'return allowAlphaNumeric(event)\' onBlur=\'changeCase(this);return removeSpec(this)\'>\n\t</tr>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<tr><td width=\'50%\'>&nbsp;</td><td width=\'50%\'>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t<tr>\n    <td width=\'50%\' align=right><input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' onclick=\'doSubmit();\'></td>\n    <td width=\'50%\'><input type=\'Button\' class=\'Button\' name=\'cancel\' id=\'cancel\' value=\' ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" \' onclick=\'parent.parent.document.getElementById(\"dialog_tag\").close();\'></td>\n    </tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<tr><td colspan=\'2\'></td></tr>\n\t\t<tr><td colspan=\'2\'></td></tr>\n\t\t<tr>\n\t    <td width=\'50%\' align=center colspan=\'2\'><input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onclick=\'doSubmit();\'></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</table>\n\n<input type=\'hidden\' name=facility_id id=facility_id value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\n<input type=\'hidden\' name=p_encounter_id id=p_encounter_id value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type=\'hidden\' name=p_patient_class id=p_patient_class value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=p_encounter_date_time id=p_encounter_date_time value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\n<input type=\'hidden\' name=p_patient_id id=p_patient_id value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=\'hidden\' name=p_single_or_multi_files_ind id=p_single_or_multi_files_ind value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n<input type=\'hidden\' name=p_separate_file_no_yn id=p_separate_file_no_yn value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<input type=\'hidden\' name=p_location_code id=p_location_code value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\n<input type=\'hidden\' name=p_pat_ser_grp_code id=p_pat_ser_grp_code value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n<input type=\'hidden\' name=p_mr_section_type id=p_mr_section_type value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n<input type=\'hidden\' name=p_mr_section_code id=p_mr_section_code value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\n\n<input type=\'hidden\' name=p_called_from id=p_called_from value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n<input type=\'hidden\' name=recCnt id=recCnt value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\n<input type=\'hidden\' name=\'file_no\' id=\'file_no\'>\n<input type=\'hidden\' name=\'error_value\' id=\'error_value\'>\n<input type=\'hidden\' name=\'install_yn\' id=\'install_yn\' value=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\n<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n<input type=\'hidden\' name=\'multi_files_in_same_fs_locn_yn\' id=\'multi_files_in_same_fs_locn_yn\' value=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n<!-- Added for MMS-QH-CRF-0148 -->\n<input type=\'hidden\' name=\'sitespecific_autocreatepatfile\' id=\'sitespecific_autocreatepatfile\' value=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n <!-- Added for MMS-QH-CRF-0148 -- TO submit the request if it has only single record -->\n <script> \n var tempAutoFileReq = document.forms[0].sitespecific_autocreatepatfile.value;\n if (tempAutoFileReq == \"true\")\n { \n\t if (document.forms[0].fs_locn_code && document.forms[0].fs_locn_code.length == 2)\n\t {\n\t\tdocument.forms[0].fs_locn_code.selectedIndex = 1;\n\t\tif(document.forms[0].file_type)\n\t\t{\n\t\t\tif(document.forms[0].file_type.length == 2)\n\t\t\t{\n\t\t\t\tdocument.forms[0].file_type.selectedIndex = 1;\n\t\t\t\tdoSubmit();\n\t\t\t}\n\t\t}else\n\t\t{ \n\t\t\tdoSubmit();\n\t\t}\n\t }\n  }\n</script>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection con = null;
	String p_single_or_multi_files_ind = ""; 
	String p_separate_file_no_yn =	"";

	PreparedStatement pstmt=null;
    ResultSet rset = null;
	PreparedStatement pstmt1=null;
    ResultSet rset1 = null;
	String sql = "";
	String dflt_fs_locn_code="";
	String sel="";
	String called_from ="";
	String location_code="";
	String p_patient_id ="";
	String p_pat_ser_grp_code ="";
	String p_mr_section_type ="";
	String p_mr_section_code = "";
	String p_encounter_id ="";
	String p_patient_class ="";
	String p_encounter_date_time = "";
	String facility_id = (String)session.getAttribute("facility_id");
    called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");

	p_pat_ser_grp_code = request.getParameter("p_pat_ser_grp_code")==null?"":request.getParameter("p_pat_ser_grp_code");

	p_mr_section_type = request.getParameter("p_mr_section_type")==null?"":request.getParameter("p_mr_section_type");
	p_mr_section_code = request.getParameter("p_mr_section_code")==null?"":request.getParameter("p_mr_section_code");

	p_encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");        
	p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");       
	p_encounter_date_time = request.getParameter("p_encounter_date_time")==null?"":request.getParameter("p_encounter_date_time");
Properties p			=	 (java.util.Properties) session.getValue( "jdbc" );



	String proceed_yn = "Y";
	String install_yn = "N";
	String fs_locn_code = "" ;
	String site_id = "";
	String prompt_for_old_file_no_yn = "";
	String sql_temp = "";
	StringBuffer str_sql = new StringBuffer();
	String file_type_appl_yn = "";
	String multi_files_in_same_fs_locn_yn = "";
	String filetypecodetemp = "";
	String file_type_code="";
	int show_buttons = 0;
	int recCnt = 0;
    int cnt=0;
	Boolean SiteSpecific_AutoCreatePatFile = false;
	Boolean SiteSpecific_AltFileNumber     = false;
	try 
	{
		con = ConnectionManager.getConnection(request);
		SiteSpecific_AutoCreatePatFile = CommonBean.isSiteSpecific(con, "MP","AUTO_CREATE_PAT_FILE_AND_REQ"); //Added for MMS-QH-CRF-0148
		SiteSpecific_AltFileNumber     = CommonBean.isSiteSpecific(con, "MR","ALTERNATE_FILE_NUMBER");   //Added by Sangeetha for GDOH-CRF-0103
		
		/* Select single or multi files indicator, separate file no and file type applicable from mp_param */
		
		try {
		sql = "select single_or_multi_files_ind,separate_file_no_yn,FILE_TYPE_APPL_YN,multi_files_in_same_fs_locn_yn from mp_param";
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next())
		{
			p_single_or_multi_files_ind = rset.getString(1)==null?"":rset.getString(1);
			p_separate_file_no_yn = rset.getString(2)==null?"":rset.getString(2);
			file_type_appl_yn = rset.getString("FILE_TYPE_APPL_YN")==null?"":rset.getString("FILE_TYPE_APPL_YN");
			multi_files_in_same_fs_locn_yn = rset.getString("multi_files_in_same_fs_locn_yn")==null?"N":rset.getString("multi_files_in_same_fs_locn_yn");
		}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(p_single_or_multi_files_ind.equals("S") && p_separate_file_no_yn.equals("N"))
		{}
	else
		{
	if (called_from.equals("MP"))/*This portion will execute only when called from =MP*/
	{
	try {
	sql_temp = "SELECT SITE_ID FROM SM_SITE_PARAM";
	pstmt = con.prepareStatement(sql_temp);
	rset = pstmt.executeQuery();
	if (rset!=null)
		{
		while(rset.next())
			site_id = rset.getString(1)==null?"":rset.getString(1);
		}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
	}
	catch (Exception e)
		{
			e.printStackTrace();
		}
	try 
		{	/* Code for displaying the mr section [Display only]*/
/*	str_sql.append("SELECT A.MR_SECTION_CODE FROM MR_SEC_FOR_PAT_SER_GRP A, MP_PAT_SER_FACILITY B WHERE A.PAT_SER_GRP_CODE = B.PAT_SER_GRP_CODE AND A.FACILITY_ID = '"+facility_id+"' AND B.SITE_OR_FACILITY_ID = DECODE(B.SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"') AND B.PAT_SER_GRP_CODE = '"+p_pat_ser_grp_code+"' AND B.MAX_SRL_NO = (Select MIN(MAX_SRL_NO) from MP_PAT_SER_FACILITY WHERE PAT_SER_GRP_CODE = '"+p_pat_ser_grp_code+"' AND SITE_OR_FACILITY_ID = DECODE(SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"'))");
*/
	str_sql.append("SELECT DECODE(SITE_OR_FACILITY, 'F', MR_SECTION_CODE, (select mr_section_code FROM MR_SEC_FOR_PAT_SER_GRP where (pat_ser_grp_code = '"+p_pat_ser_grp_code+"' OR pat_ser_grp_code = (select associated_pat_ser_grp_code from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"')) and FACILITY_ID = '"+facility_id+"')) mr_section_code from MP_PAT_SER_FACILITY WHERE SITE_OR_FACILITY_ID = DECODE(SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"') AND (pat_ser_grp_code = '"+p_pat_ser_grp_code+"' OR pat_ser_grp_code = (select associated_pat_ser_grp_code from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"')) AND MAX_SRL_NO = (Select MIN(MAX_SRL_NO) from MP_PAT_SER_FACILITY WHERE (pat_ser_grp_code = '"+p_pat_ser_grp_code+"' OR pat_ser_grp_code = (select associated_pat_ser_grp_code from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"')) AND SITE_OR_FACILITY_ID = DECODE(SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"'))");
	
	
	pstmt = con.prepareStatement(str_sql.toString());
	str_sql.setLength(0);
	rset = pstmt.executeQuery();
	if (rset!=null)
		{
		
		while(rset.next())
			p_mr_section_code = rset.getString(1)==null?"":rset.getString(1);
		
			
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	} catch(Exception e)
		{
			e.printStackTrace();
		}

	if(p_mr_section_code.equals(""))
		{
		  proceed_yn = "N";
		}
	}//for called from MP
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(proceed_yn.equals("N")){
            _bw.write(_wl_block11Bytes, _wl_block11);

	show_buttons=2;
	}
            _bw.write(_wl_block12Bytes, _wl_block12);
if(proceed_yn.equals("Y")){
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(file_type_appl_yn.equals("N") && p_single_or_multi_files_ind.equals("M") && p_separate_file_no_yn.equals("N"))/*it is handling one exception*/
		{ show_buttons=1;
            _bw.write(_wl_block14Bytes, _wl_block14);
	//Map hashtable1 = MessageManager.getMessage(con, "FILE_TYPE_NOT_APPL");
		//	String st2 = (String)hashtable1.get("message");               
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
  }else{ 
            _bw.write(_wl_block13Bytes, _wl_block13);

	
		try {
		pstmt1 = con.prepareStatement("select install_yn from sm_module where module_id = 'FM'");
		rset1 = pstmt1.executeQuery();
		if(rset1!=null)
		{
			while(rset1.next())
			{
				install_yn = rset1.getString(1)==null?"":rset1.getString(1);
				
			}
		}
		if (rset1!=null) rset1.close();
		if (pstmt1!=null) pstmt1.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(install_yn.equals("Y"))/* If FM is installed display file storage location and mr section */
		{
			try{/*Statement to get the number of records in file storage location*/
				pstmt = con.prepareStatement("select count(1) from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y'");
                pstmt.setString(1, facility_id);
                rset = pstmt.executeQuery();
                if (rset.next())
                {
                    recCnt = rset.getInt(1);
					
                }
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
		
			pstmt = con.prepareStatement("select dflt_fs_locn_code from fm_parameter where facility_id = ?");
                pstmt.setString(1,facility_id);
                 rset = pstmt.executeQuery();
                if (rset.next())
                {
                    dflt_fs_locn_code = rset.getString(1);
                }
		        if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			
			}catch(Exception e){ 
				e.printStackTrace();
			}
		if (recCnt > 0) {/*Display list box only*/
		

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		if(p_mr_section_type.equals("D"))
		{
			if(called_from.equals("OP")||called_from.equals("AE")||called_from.equals("DC"))
			{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select a.mr_location_code fs_locn_code,b.short_desc from op_clinic a,fm_storage_locn b where a.facility_id=b.facility_id and a.mr_location_code=b.fs_locn_code and a.facility_id = ? and a.clinic_code = ? and a.eff_status='E' and b.eff_status='E' order by b.short_desc");
			}
			if(called_from.equals("IP"))
			{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select a.fs_locn_code,b.short_desc from ip_nursing_unit a,fm_storage_locn b where a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and a.facility_id = ? and a.nursing_unit_code=? and a.eff_status='E' and b.eff_status='E' order by b.short_desc");
			}
		}
		else if(p_mr_section_type.equals("C"))
		{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select fs_locn_code,short_desc from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y' and eff_status='E' and locn_identity='D' and mr_locn_yn = 'Y' order by short_desc");
	  	}    
		else if(p_mr_section_type.equals(""))
		{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select fs_locn_code,short_desc from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y' and eff_status='E' and mr_locn_yn = 'Y' order by short_desc");
		 }     

                pstmt.setString(1, facility_id);
				if(p_mr_section_type.equals("D"))
				{
					if(called_from.equals("OP")||called_from.equals("AE")||called_from.equals("DC")||called_from.equals("IP"))
					{
						pstmt.setString(2, location_code);
					}
				}
                rset=pstmt.executeQuery();
                
                if( rset != null )
                {
                   while( rset.next() )
                    {
                        fs_locn_code = rset.getString( "fs_locn_code" )==null?"":rset.getString("fs_locn_code");
                        String shortdesc=rset.getString("short_desc")==null?"":rset.getString("short_desc");
						 if (fs_locn_code.equals(dflt_fs_locn_code)) sel = "selected";
                        else sel = "";                      
            
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( fs_locn_code ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( shortdesc ));
                                
                    }
				}
            
            _bw.write(_wl_block24Bytes, _wl_block24);
} else
			{
			
            _bw.write(_wl_block25Bytes, _wl_block25);

			}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
 
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		
		if(p_single_or_multi_files_ind.equals("S") && p_separate_file_no_yn.equals("N"))
		{
            _bw.write(_wl_block27Bytes, _wl_block27);
}
		/*else if(!((called_from.equals("OP")||called_from.equals("MP")||called_from.equals("IP")||called_from.equals("AE")||called_from.equals("DC"))))
		{
		String strsql = "select b.short_name mr_section, a.mr_section_code from fm_storage_locn a, mr_section b where a.facility_id = b.facility_id and a.fs_locn_code ='"+fs_locn_code+"' and a.mr_section_code = b.mr_section_code";
	    
		
		pstmt=con.prepareStatement(strsql);

	    rset = pstmt.executeQuery();	
			
					if(rset!=null)
                    {
                        while(rset.next())
                        {
    						//mr_section_code_desc = rset.getString("mr_section")==null?"":rset.getString("mr_section");//This value is not displayed on load. Only on change of fs locatin from the other jsp.
						}
					}*/
	
            _bw.write(_wl_block28Bytes, _wl_block28);
	//} 
            _bw.write(_wl_block13Bytes, _wl_block13);
 }else{ /* Else part of install_yn for FM */
	
            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block30Bytes, _wl_block30);

	if(file_type_appl_yn.equals("Y"))/* Show the file type window */
	{
	
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

		
	if(install_yn.equals("Y")){
		
		if(pstmt!=null)pstmt.close();  
		if(rset!=null)rset.close();  

		if(called_from.equals("OP")){
			str_sql.setLength(0);
			str_sql.append("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '");
			str_sql.append(facility_id);
			str_sql.append("'  and a.clinic_code = '");
			str_sql.append(location_code);
			str_sql.append("'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_op='Y' ");
			pstmt = con.prepareStatement(str_sql.toString());
			str_sql.setLength(0);
//			pstmt = con.prepareStatement("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '"+facility_id+"'  and a.clinic_code = '"+location_code+"'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_op='Y' ");
		}else if(called_from.equals("AE")){
			if(pstmt!=null) pstmt.close();
			str_sql.setLength(0);
			str_sql.append("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '");
			str_sql.append(facility_id);
			str_sql.append("'  and a.clinic_code = '");
			str_sql.append(location_code);
			str_sql.append("'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_em='Y' ");			
			pstmt = con.prepareStatement(str_sql.toString());
			str_sql.setLength(0);
//			pstmt = con.prepareStatement("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '"+facility_id+"'  and a.clinic_code = '"+location_code+"'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_em='Y' ");
		}
		else if(called_from.equals("IP"))
		{
			if(pstmt!=null) pstmt.close();
			str_sql.setLength(0);
			str_sql.append("select dflt_file_type_code, b.short_desc from ip_nursing_unit a, mr_file_type b where a.facility_id = '");
			str_sql.append(facility_id);
			str_sql.append("' and a.nursing_unit_code = '");
			str_sql.append(location_code);
			str_sql.append("' and a.dflt_file_type_code = b.file_type_code(+) and (b.appl_to_ip='Y' OR b.appl_to_dc='Y')");
			pstmt = con.prepareStatement(str_sql.toString());
			str_sql.setLength(0);
//			pstmt = con.prepareStatement("select dflt_file_type_code, b.short_desc from ip_nursing_unit a, mr_file_type b where a.facility_id = '"+facility_id+"' and a.nursing_unit_code = '"+location_code+"' and a.dflt_file_type_code = b.file_type_code(+) and (b.appl_to_ip='Y' OR b.appl_to_dc='Y')");
		}
		try
		{
		rset=pstmt.executeQuery();
		
		if(rset!=null && rset.next())
					{					
						filetypecodetemp = rset.getString("dflt_file_type_code")==null?"":rset.getString("dflt_file_type_code");
					
						//filetypedesctemp = rset.getString("short_desc")==null?"":rset.getString("short_desc");

						
					
					}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
			{
				e.printStackTrace();
			}

	/*	StringBuffer tempsql = new StringBuffer("select short_desc, file_type_code from mr_file_type where facility_id = '");
		tempsql.append(facility_id);
		tempsql.append("' and eff_status = 'E' ");
		if(called_from.equals("OP")){tempsql.append(" and appl_to_op='Y' ");}
		if(called_from.equals("AE")){tempsql.append(" and appl_to_em='Y' ");}
		if(called_from.equals("IP")){tempsql.append(" and (appl_to_ip='Y' or appl_to_dc='Y') ") ;}
		tempsql.append(" order by short_desc "); */
		StringBuffer tempsql = new StringBuffer("Select b.short_desc, a.file_type_code from fm_file_type_for_fsl a, mr_file_type b where a.facility_id = '");
		tempsql.append(facility_id);
		tempsql.append("' and a.fs_locn_code = '");
		tempsql.append(dflt_fs_locn_code);
				tempsql.append("' and a.facility_id = b.facility_id and a.file_type_code = b.file_type_code and a.eff_status=b.eff_status  and a.eff_status='E'");
				if(called_from.equals("OP")){tempsql.append(" and b.appl_to_op='Y' ");}
				if(called_from.equals("AE")){tempsql.append(" and b.appl_to_em='Y' ");}
				if(called_from.equals("IP")){tempsql.append(" and (b.appl_to_ip='Y' or b.appl_to_dc='Y') ");}
				tempsql.append(" order by short_desc ");
		
		pstmt = con.prepareStatement(tempsql.toString());
		rset=pstmt.executeQuery();
		if(rset!=null)
		{
			while(rset.next())
			{
					
						 file_type_code = rset.getString( "file_type_code" )==null?"":rset.getString("file_type_code"); 
                       String short_desc	=rset.getString("short_desc")==null?"":rset.getString("short_desc");
			if(file_type_code.equals(filetypecodetemp)) {
            
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
          
			}else {
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
 }		
			cnt++;
			} 
			
			if(cnt==1)
			{
			
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
		
		}
	}/*End of install_yn = 'N' for file type population */
	
            _bw.write(_wl_block42Bytes, _wl_block42);
 }else {
            _bw.write(_wl_block43Bytes, _wl_block43);
 } 
            _bw.write(_wl_block44Bytes, _wl_block44);
 /* Code to get old file number */
		if (called_from.equals("MP"))
		{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		try {
		StringBuffer strsql3 = new StringBuffer("select prompt_for_old_file_no_yn from mr_section where facility_id = '");
		strsql3.append(facility_id);
		strsql3.append("' and mr_section_code='");
		strsql3.append(p_mr_section_code);
		strsql3.append("'");

		pstmt=con.prepareStatement(strsql3.toString());
		strsql3.setLength(0);
		rset = pstmt.executeQuery();
		if (rset!=null)
		{
			while(rset.next())
			{
				prompt_for_old_file_no_yn = rset.getString(1)==null?"":rset.getString(1);
				
			}
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
			{
			    e.printStackTrace();
			}
		}/* end of MP specific search for old file */
		else if (called_from.equals("OP")||called_from.equals("IP")||called_from.equals("AE"))
		{
		
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		try {
		StringBuffer strsql4 = new StringBuffer("select prompt_for_old_file_no_yn from mr_section where facility_id = '");
		strsql4.append(facility_id);
		strsql4.append("' and mr_section_code='");
		strsql4.append(p_mr_section_code);
		strsql4.append("'");
			
		pstmt=con.prepareStatement(strsql4.toString());
		strsql4.setLength(0);
		rset = pstmt.executeQuery();
		if (rset!=null)
		{
			while(rset.next())
			{
				prompt_for_old_file_no_yn = rset.getString(1)==null?"":rset.getString(1);
			}
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
			{
			  e.printStackTrace();
			}		
	
		}/*End of old file no search for OP and IP */ 
            _bw.write(_wl_block12Bytes, _wl_block12);
	if(p_single_or_multi_files_ind.equals("S") && p_separate_file_no_yn.equals("N"))
		{
			if((file_type_appl_yn.equals("N"))&&(install_yn.equals("N"))) {
			//Map hashtable = MessageManager.getMessage(con, "FILE_NO_REQD_YN");
			//String st1 = (String)hashtable.get("message");               
			
            _bw.write(_wl_block45Bytes, _wl_block45);
 }else { 
            _bw.write(_wl_block46Bytes, _wl_block46);
 } 
            _bw.write(_wl_block47Bytes, _wl_block47);
}else
		{if (prompt_for_old_file_no_yn.equals("Y"))
		{	
			
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{ 
            _bw.write(_wl_block50Bytes, _wl_block50);
 }/* End of old file no */
		}
	}
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(SiteSpecific_AltFileNumber){ 
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
 
		} //end of SiteSpecific_AltFileNumber
		}
	}/* End of outer try */
	catch (Exception e)
	{
		e.printStackTrace();
	}
	 finally
    {
        ConnectionManager.returnConnection(con,request);
    }		

            _bw.write(_wl_block54Bytes, _wl_block54);
 if (show_buttons==0){
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
 } else if(show_buttons==2){
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(p_encounter_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(p_encounter_date_time));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(p_single_or_multi_files_ind));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_separate_file_no_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(p_pat_ser_grp_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(p_mr_section_type));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(p_mr_section_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(recCnt));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(multi_files_in_same_fs_locn_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(SiteSpecific_AutoCreatePatFile));
            _bw.write(_wl_block77Bytes, _wl_block77);
            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CreatePatientFile.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FileStorageLocn.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filetype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OldFileNo.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AltFileNo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
}
