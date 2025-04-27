package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __scheduleappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ScheduleAppointment.jsp", 1733836616896L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>     \n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\' </link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eOA/js/Validate.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'> </script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tvar NamePrefixArray = new Array(); \n\tvar NamePrefixLocArray = new Array();\n\tvar PrefixSexArray = new Array();\t\n\tvar NameSuffixArray = new Array();\t\n\tvar NameSuffixLocArray = new Array();\t\n\tvar SuffixSexArray = new Array();\t\n</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_OPER_STN_FOR_USER\',\'Common\'));\n\t\t\t\t\tlocation.href=\'../../eCommon/jsp/home.jsp\';\n\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>alert(getMessage(\'SCH_NOT_ALLOW\',\'OA\'));\n\t\t\t\tparent.frames[0].document.location.href=\'../../eCommon/jsp/home.jsp?called_from=CA\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body  onLoad=\"disp_data();focuschk();Disable_oprv();\" OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'schedule_appointment\' id=\'schedule_appointment\'>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" valign=\'top\' id=\'rule_table\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'10\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\n\t\t\t\t</tr>\n\t\t\t\n\t\t\t\t\t<td align=\'left\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=\'fields\' ><input type= \'text\' name=\'patient_id\' id=\'patient_id\'  size=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  maxlength=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onKeyPress=\'return CheckForSpecChars(event)\' value=\"\" onBlur=\"searchPatient(document.getElementById(\'patient_id\'),\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\" tabIndex=\'1\'><input type=\'button\' name=\'searchPatientButton\' id=\'searchPatientButton\' value=\'?\' class=\"BUTTON\" onClick=\"patqry()\" tabIndex=\"-1\" ></td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\'gender\' id=\'gender\'><option value=\'\'>----";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="----</option><option value=\'M\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option><option value=\'F\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option></select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\n\t\t\t\t\t<td colspan=2>&nbsp;</td>\n\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'firstnameprompt\' id=\'firstnameprompt\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'secondnameprompt\' id=\'secondnameprompt\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'thirdnameprompt\' id=\'thirdnameprompt\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'familynameprompt\' id=\'familynameprompt\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'familynameprompt\' id=\'familynameprompt\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'name_suffix_reqd_yn\' id=\'name_suffix_reqd_yn\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'names_in_oth_lang_yn\' id=\'names_in_oth_lang_yn\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_prompt\' id=\'name_prefix_prompt\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t\t\t\t<td  class=\'fields\' >\n\t\t\t\t\t\t\t\t<Select name=\'name_prefix\' id=\'name_prefix\' onchange=\'prefixToGenderDflt(this)\'>\n\t\t\t\t\t\t\t\t\t<Option value=\"\">------";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="------</option>\n\t\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tprefix_length = NamePrefixArray.length;\n\t\t\t\t\t\t\t\t\t\tfor(i = 0; i < prefix_length; i++) {\n\t\t\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\tname_pfx = unescape(NamePrefixArray[i]);\n\t\t\t\t\t\t\t\t\t\t\topt.text = name_pfx;\n\t\t\t\t\t\t\t\t\t\t\topt.value = name_pfx; \n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix.options.add(opt);\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t</select>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'first_name\' id=\'first_name\' size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' value =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'second_name\' id=\'second_name\'  size=\'20\' maxlength=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'third_name\' id=\'third_name\' size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'family_name\' id=\'family_name\'  size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'name_suffix_prompt\' id=\'name_suffix_prompt\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t\t\t\t<td  class=\'fields\' >\n\t\t\t\t\t\t\t\t<Select name=\'name_suffix\' id=\'name_suffix\' onchange=\'suffixToGenderDflt(this)\'>\n\t\t\t\t\t\t\t\t\t<Option value=\"\">------";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="------</option>\n\t\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tsuffix_length = NameSuffixArray.length;\n\t\t\t\t\t\t\t\t\t\tfor(i = 0; i < suffix_length; i++) {\n\t\t\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\tname_sfx = unescape(NameSuffixArray[i]);\n\t\t\t\t\t\t\t\t\t\t\topt.text = name_sfx;\n\t\t\t\t\t\t\t\t\t\t\topt.value = name_sfx; \n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix.options.add(opt);\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t</select>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<input type=\'hidden\' name=\'name_prefix_oth_lang_prompt\' id=\'name_prefix_oth_lang_prompt\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'first_name_oth_lang_prompt\' id=\'first_name_oth_lang_prompt\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'second_name_oth_lang_prompt\' id=\'second_name_oth_lang_prompt\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'third_name_oth_lang_prompt\' id=\'third_name_oth_lang_prompt\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap><input type=\'hidden\' name=\'family_name_oth_lang_prompt\' id=\'family_name_oth_lang_prompt\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<input type=\'hidden\' name=\'name_suffix_oth_lang_prompt\' id=\'name_suffix_oth_lang_prompt\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t<td  class=\'fields\' >\n\t\t\t\t\t\t\t\t<!--modified by N Munisekhar on 28-Jan-2013 against RUT-SCF-0216 [IN:037457] -->\n\t\t\t\t\t\t\t\t\t\t<Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'prefixToGenderDflt(this)\' >\n\t\t\t\t\t\t\t\t\t    <!--End of RUT-SCF-0216 [IN:037457] -->\n\t\t\t\t\t\t\t\t\t\t\t<Option value=\"\">------";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="------</option>\n\t\t\t\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tprefix_loc_length = NamePrefixLocArray.length;\n\t\t\t\t\t\t\t\t\t\t\t\tfor(i = 0; i < prefix_loc_length; i++) {\n\t\t\t\t\t\t\t\t\t\t\t\t\tloc_name_pfx = unescape(NamePrefixLocArray[i]);\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(loc_name_pfx!=\'\') {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\topt.text = loc_name_pfx;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\topt.value = loc_name_pfx; \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.options.add(opt);\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t</select>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'first_name_oth_lang\' id=\'first_name_oth_lang\' size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'></td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'second_name_oth_lang\' id=\'second_name_oth_lang\'  size=\'20\' maxlength=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'third_name_oth_lang\' id=\'third_name_oth_lang\' size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'family_name_oth_lang\' id=\'family_name_oth_lang\'  size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t\t<td><input type= \'text\' name=\'family_name_oth_lang\' id=\'family_name_oth_lang\'  size=\'20\'  maxlength=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t<td  class=\'fields\' >\n\t\t\t\t\t\t\t\t<!--modified by N Munisekhar on 28-Jan-2013 against RUT-SCF-0216 [IN:037457] -->\n\t\t\t\t\t\t\t\t\t<Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'suffixToGenderDflt(this)\' >\n\t\t\t\t\t\t\t\t\t<!-- End of RUT-SCF-0216 [IN:037457]-->\n\t\t\t\t\t\t\t\t\t\t\t<Option value=\"\">------";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="------</option>\n\t\t\t\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tsuffix_loc_length = NameSuffixLocArray.length;\n\t\t\t\t\t\t\t\t\t\t\t\tfor(i = 0; i < suffix_loc_length; i++) {\n\t\t\t\t\t\t\t\t\t\t\t\t\tloc_name_sfx = unescape(NameSuffixLocArray[i]);\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(loc_name_sfx!=\'\') {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\topt.text = loc_name_sfx;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\topt.value = loc_name_sfx; \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth_lang.options.add(opt);\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t</select>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t<tr>\n\n\n\n\t\t\t\t\t<td align=\'left\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t<td><input type= \'text\' name=\'contact_no\' id=\'contact_no\' size=\'20\' maxlength=\'20\' value =\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'contact_no_gif\' style=\'visibility:visible\'></img>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'nationality_desc\' id=\'nationality_desc\' size=\'20\' maxlength=\'20\'  onblur=\'get_Nationality(this);\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" ><input type=\'button\' name=\'nationality_button\' id=\'nationality_button\' value=\'?\' class=\'button\' onclick=\'get_Nationality(this);\' ><input type=\'hidden\' name=\'nationality_code\' id=\'nationality_code\' value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"></td>\n\n\t\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'language_desc\' id=\'language_desc\' size=\'20\' maxlength=\'20\'  onblur=\'searchLanguage(this);\'value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"><input type=\'button\' name=\'language_button\' id=\'language_button\' value=\'?\' class=\'button\' onclick=\'searchLanguage(this);\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="<img id = \'lang_mand\' src = \'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="<input type=\'hidden\' name=\'language_code\' id=\'language_code\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"></td>\n\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td  >\n\t\t\t\t\t<input type=\'button\'  name=\'view_history\' id=\'view_history\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="&nbsp;";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' onclick=\'displayPatientDetails()\' class=\'BUTTON\'>\n\t\t\t\t\t<input type=\'button\'  name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' class=\'BUTTON\' onclick=\'clearValues()\'></td> \n\n\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'SCHEDULE_APPOINTMENT\'>\n\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" valign=\'top\'>\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t<table  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" valign=\'top\' border=\'0\'>\n\t\t<tr>\n\t\t\t<td  class=\'label\' width=\'23%\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t<td  class=fields nowrap>\n\t\t\t\t<select name=\'speciality\' id=\'speciality\' tabindex=0 onchange = \'enaable_ear(this)\'><option value=\'\'>----- ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" -----\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' selected>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t</select>\n\t\t\t\t<td class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap align=\'left\' width=\'50%\'><input type=\'checkbox\' name=\'disp_next\' id=\'disp_next\'  tabindex=8 disabled>&nbsp;&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="<input type=\'checkbox\' name=\'tr_rule_applicable\' id=\'tr_rule_applicable\' onclick=\'CheckRule(this,\"Y\")\'>&nbsp;&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="<input type=\'checkbox\' name=\'rd_appt_yn\' id=\'rd_appt_yn\' ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="  onclick=\'radRuleAppl(this)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t<SELECT name=\'location_type\' id=\'location_type\' tabindex=0 onChange=\"javascript:populateLocations(this)\">\n\t\t\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" ---\n\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' selected> ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'> ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\t\t\t\t\t\t\t\n\t\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t\t\t\t\t\t<td class=\'label\'><input type=\'text\' size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' onblur=\"ena_loc_lookup(this);\"><input type=\"hidden\" name=\"clinic\" id=\"clinic\" value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' ><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"open_loc_lookup();\" class=\'button\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'onblur=\"ena_loc_lookup(this);\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"clinic\" id=\"clinic\" value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t\t\t\t<td class=\'label\'><input type=\'text\' size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' ><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"open_loc_lookup();\" class=\'button\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n\t\t\t\t\t<td class=\'label\'><input type=\'text\'  size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'><input type=\'button\'  name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" onClick=\"open_loc_lookup();\" class=\'button\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t<tr id=\'resource_part\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t\t\t<td  class=\"fields\">\n\t\t\t\t\t<select name=\'position\' id=\'position\'>\n\t\t\t\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\'><input type=\'button\' name=\'addtl_splty_button\' id=\'addtl_splty_button\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' onClick=\"addtnl_splty()\" class=\'BUTTON\'></td>\n\t\t\t\t<td  class=\"fields\"><input type=\'text\' name=\"addtl_splty_text\" id=\"addtl_splty_text\" size=\'30\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" readonly/></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t<tr>\n\t\t\t<td  nowrap class=\"label\">";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t\t\t<td  class=\"fields\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t<input type=text name=\'no_dwm\' id=\'no_dwm\' tabindex=0  style=\'text-align:right\' size=\'2\' maxlength=\'3\'  onblur=\"CheckNum(this);calucalte_enddate(1);\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" onKeyPress=\'return allowValidNumber(this,event,3,0)\'></input>\n\t\t\t\t\t<select name=\'dwm_desc\' id=\'dwm_desc\' tabindex=0  onChange=\"calucalte_enddate(1);\">\n\t\t\t\t\t\t<option name=\'day\' value=\'D\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</option>\n\t\t\t\t\t\t<option name=\'day\' value=\'W\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</option>\n\t\t\t\t\t\t<option name=\'day\' value=\'M\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</option>\n\t\t\t\t\t</select> \n\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t<input type=text name=\'no_dwm\' id=\'no_dwm\' tabindex=0  style=\'text-align:right\' size=\'2\' maxlength=\'3\' disabled onblur=\"CheckNum(this);calucalte_enddate(1);\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" onKeyPress=\'return allowValidNumber(this,event,3,0)\'></input>\n\t\t\t\t\t\t<select name=\'dwm_desc\' id=\'dwm_desc\' tabindex=0  disabled onChange=\"calucalte_enddate(1);\">\n\t\t\t\t\t\t<option name=\'day\' value=\'D\'>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t<td  class=\"label\" nowrap id=\'pref_per\'>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\t\t\t<td  class=\"label\"  nowrap ><input type=hidden name=\'prefdate_curr\' id=\'prefdate_curr\'  value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t<input type=\"hidden\" name=\"hddSpeciality\" id=\"hddSpeciality\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t<input type=\"hidden\" name=\"fromTracker\" id=\"fromTracker\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t<span id=\'prevDateBtn\'><img id=\'prevDateDiasbled\' name=\'prevDateDiasbled\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/PrevDisable.PNG\" tabindex=0 /><img id=\'prevDate\' name=\'prevDate\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/Prev.PNG\"  onClick=\"invokeRule(this)\" /></span><input id=\"date_of_expiry\" tabindex=0 type=text name=\'prefdate1\' id=\'prefdate1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" Onblur=\"DateCompare_from(\'from\',this);validate_date_from(this,prefenddate1);\"><img id=\'frm_img\' style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" tabindex=0 onClick=\"return showCalendar(\'date_of_expiry\',null);\" ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" >&nbsp;<span id=\'date_of_expiry2_span\'>-&nbsp;\n\t\t\t\t\t<input id=\"date_of_expiry2\" tabindex=0 type=text name=\'prefenddate1\' id=\'prefenddate1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =" Onblur=\'DateCompare_from(\"To\",this);validate_date_to(this,prefdate1);\'><img id=\'to_img\' style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" tabindex=0 onClick=\"return showCalendar(\'date_of_expiry2\',null);\" ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" ></span><span id=\'nextDateBtn\'><img id=\'nextDateDiasbled\' name=\'nextDateDiasbled\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/NextDisable.PNG\" tabindex=0 /><img id=\'nextDate\' name=\'nextDate\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/Next.PNG\"  onClick=\"invokeRule(this)\" /></span><span id=\'timeID\' style=\"visibility:hidden\"><input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' value=\'\'  size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\" ><img id=\'prevTimePlusDisabled\' name=\'prevTimePlusDisabled\' style=\"cursor:pointer;vertical-align:top;display:none\" src=\"../../eCommon/images/UpArrowDisable.PNG\" tabindex=0 /><img id=\'prevTimeMinusDisabled\' name=\'prevTimeMinusDisabled\' style=\"cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none\" src=\"../../eCommon/images/DownArrowDisable.PNG\" tabindex=0 /><img id=\'prevTimePlus\' name=\'prevTimePlus\' onClick=\"invokeRule(this)\"style=\"cursor:pointer;vertical-align:top;display:none\" src=\"../../eCommon/images/UpArrow.PNG\" tabindex=0 /><img id=\'prevTimeMinus\' name=\'prevTimeMinus\' onClick=\"invokeRule(this)\" style=\"cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none\" src=\"../../eCommon/images/DownArrow.PNG\" tabindex=0 /> - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\'   size=\'3\' maxlength=\'5\'  value=\'\' onBlur=\'CheckTime(this,\"TO\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"><span id=\'nextTimeBtn\'><img id=\'nextTimePlusDisabled\' name=\'nextTimePlusDisabled\' style=\"cursor:pointer;vertical-align:top;\" src=\"../../eCommon/images/UpArrowDisable.PNG\" tabindex=0 style=\"display:none\"/><img id=\'nextTimeMinusDisabled\' name=\'nextTimeMinusDisabled\' style=\"cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none\" src=\"../../eCommon/images/DownArrowDisable.PNG\" tabindex=0 /><img id=\'nextTimePlus\' name=\'nextTimePlus\' onClick=\"invokeRule(this)\"style=\"cursor:pointer;vertical-align:top;display:none\" src=\"../../eCommon/images/UpArrow.PNG\" tabindex=0 /><img id=\'nextTimeMinus\' name=\'nextTimeMinus\' onClick=\"invokeRule(this)\" style=\"cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none\" src=\"../../eCommon/images/DownArrow.PNG\" tabindex=0 /></span><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></span>\n\t\t\t\t\t<input type=\'hidden\' name=\'prefdate\' id=\'prefdate\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'prefenddate\' id=\'prefenddate\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' >\n\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t<span id=\'prevDateBtn\' ><img id=\'prevDateDiasbled\' name=\'prevDateDiasbled\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/PrevDisable.PNG\" tabindex=0 style=\"display:none\"/><img id=\'prevDate\' name=\'prevDate\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/Prev.PNG\"  onClick=\"invokeRule(this)\" /></span><input id=\"date_of_expiry\" tabindex=0 type=text name=\'prefdate1\' id=\'prefdate1\' disabled size=\'10\' maxlength=\'10\'  value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" Onblur=\"DateCompare_from(\'from\',this);validate_date_from(this,prefenddate1);\"><img  id=\'frm_img\' style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" disabled onClick=\"return showCalendar(\'date_of_expiry\',null);\">&nbsp;<span id=\'date_of_expiry2_span\'>-&nbsp;\n\t\t\t\t\t\t<input id=\"date_of_expiry2\" tabindex=0 type=text name=\'prefenddate1\' id=\'prefenddate1\' disabled size=\'10\' maxlength=\'10\'  value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"  Onblur=\'DateCompare_from(\"To\",this);validate_date_to(this,prefdate1);\'><img id=\'to_img\' style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" disabled onClick=\"return showCalendar(\'date_of_expiry2\',null);\" ></span><span id=\'nextDateBtn\'><img id=\'nextDateDiasbled\' name=\'nextDateDiasbled\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/NextDisable.PNG\" tabindex=0 /><img id=\'nextDate\' name=\'nextDate\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/Next.PNG\"  onClick=\"invokeRule(this)\" /><input type=\'button\' name=\'prevTime\' id=\'prevTime\' value=\'Prev Time\' onClick=\'invokeRule(this)\' class=\'BUTTON\' disabled /></span><span id=\'timeID\' style=\"visibility:hidden\"><input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' value=\'\'  size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\" > - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\'   size=\'3\' maxlength=\'5\'  value=\'\' onBlur=\'CheckTime(this,\"TO\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img><span id=\'nextTimeBtn\' style=\"display:none\"><input type=\'button\' name=\'nextTime\' id=\'nextTime\' value=\'Next Time\' onClick=\'invokeRule(this)\' class=\'BUTTON\' disabled /></span></span>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t<span id=\'prevDateBtn\' style=\"display:none\"><img id=\'prevDateDiasbled\' name=\'prevDateDiasbled\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/PrevDisable.PNG\" tabindex=0 /><img id=\'prevDate\' name=\'prevDate\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/Prev.PNG\"  onClick=\"invokeRule(this)\" /></span><input id=\"date_of_expiry\" tabindex=0 type=text name=\'prefdate1\' id=\'prefdate1\' size=\'10\' maxlength=\'10\'  value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" Onblur=\"DateCompare_from(\'from\',this);validate_date_from(this,prefenddate1);\"><img id=\'frm_img\'  style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" tabindex=0   onClick=\"return showCalendar(\'date_of_expiry\',null);\">&nbsp;<span id=\'date_of_expiry2_span\'>-&nbsp;\n\t\t\t\t\t\t<input id=\"date_of_expiry2\" tabindex=0 type=text name=\'prefenddate1\' id=\'prefenddate1\' size=\'10\' maxlength=\'10\'  value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\"  Onblur=\'DateCompare_from(\"To\",this);validate_date_to(this,prefdate1);\'><img id=\'to_img\' style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" tabindex=0 onClick=\"return showCalendar(\'date_of_expiry2\',null);\" ></span><span id=\'nextDateBtn\'><img id=\'nextDateDiasbled\' name=\'nextDateDiasbled\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/NextDisable.PNG\" tabindex=0 /><img id=\'nextDate\' name=\'nextDate\' style=\"cursor:pointer;display:none\" src=\"../../eCommon/images/Next.PNG\"  onClick=\"invokeRule(this)\" /></span><span id=\'prevTimeBtn\' style=\"display:none\"><input type=\'button\' name=\'prevTime\' id=\'prevTime\' value=\'Prev Time\' onClick=\'invokeRule(this)\' class=\'BUTTON\' disabled /></span><span id=\'timeID\' style=\"visibility:hidden\"><input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' value=\'\'  size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\" > - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\'   size=\'3\' maxlength=\'5\'  value=\'\' onBlur=\'CheckTime(this,\"TO\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img><span id=\'nextTimeBtn\' style=\"display:none\"><input type=\'button\' name=\'nextTime\' id=\'nextTime\' value=\'Next Time\' onClick=\'invokeRule(this)\' class=\'BUTTON\' disabled /></span></span>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'prefdate\' id=\'prefdate\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t </td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t\t\t<td  class=\"fields\" >\n\t\t\t\t<Select name=\"visittype\" id=\"visittype\" tabindex=0><Option value=\"\">----- ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t</Select>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</td>\n\t\t\t\t<td class=label ><input type=text name=\'or_catalogue_desc\' id=\'or_catalogue_desc\' size=30 onblur=\"clear_vals()\"><input type=\'button\' class=\'button\' value=\'?\' ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" name=\'search_or\' onClick=\"callORSearch();\"   tabindex=0><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'ordCatImg\' style=\"visibility:hidden\"></img>\n\t\t\t\t</td>\n\t\t\t\t<input type=\"hidden\" name=\"or_catalogue_code\" id=\"or_catalogue_code\" value=";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =">\n\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t</tr>\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\n\t\t\n\t\t<tr>\n\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</td>\n\t\t<td class=\"fields\"><select name=\"term_set_id\" id=\"term_set_id\" onchange=\'visibleProcCode(this);\'>\n\t\t\t\t\t\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =" -----</option>\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\t\n\t\t\t\t\t\t\t   </select>\n\t\t</td>\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t<td  class=\"label\" nowrap><label id=\"change_lookup_to\">";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</label></td>\n\t\t<td  class=\"label\" ><input type=\"text\" name=\"linking_desc\" id=\"linking_desc\" size=\'50\' maxlength=\'50\' onblur=\"getProcedurecode(linking_desc,linking_code)\" disabled><input type=\"hidden\" name=\"linking_code\" id=\"linking_code\" value=\"\"><input type=\'button\' name=\'link_lokup_btn\' id=\'link_lokup_btn\' value=\'?\' onclick=\"getProcedurecode(linking_desc,linking_code)\" disabled><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'PractProcImg\' style=\"visibility:hidden\"></img></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\t\t\n\t\t<tr>\n\t\t\t<td class=\'button\' colspan=4 align=\'right\'><input type=\'button\' tabindex=11 name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' onClick=\"fetchResult1();\" class=\'BUTTON\'>\n\t\t\t<input type=\'button\' tabindex=12 name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' onClick=\'clearFields()\' class=\'BUTTON\'>\n\t\t\t<!-- \tremoved module_id.equals(\"OA\") || -->\n\t\t\t<!-- \tADDED callingMode.equals(\"CA\") || -->\n\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t<input type=";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =" tabindex=12 name=\'CreateWlist\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' onClick=\'showCreate()\' class=\'BUTTON\'  >\n\n\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t<input type=\'button\' tabindex=13 name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' onClick=\'exitval()\' class=\'BUTTON\'>\n\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t</tr>\n\t</table>\n</table>\n<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" >\n<input type=\'hidden\' name=\'hidden_from_date\' id=\'hidden_from_date\' value=";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 =" >\n<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" >\n<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =" >\t\t\t\t\n<input type=\'hidden\' name=\'p_from\' id=\'p_from\'  value=\"\" >\n<input type=\'hidden\' name=\'p_to\' id=\'p_to\'  value=\"\" >\n<input type=\'hidden\' name=\'clinic1\' id=\'clinic1\' value=\"\" >\n<input type=\'hidden\' name=\'practitioner1\' id=\'practitioner1\' value=\"\" >\n<input type=\'hidden\' name=\'practitioner_type1\' id=\'practitioner_type1\' value=\"\" >\n<input type=\'hidden\' name=\'speciality1\' id=\'speciality1\' value=\"\"  >\n<input type=\'hidden\' name=\'visittype1\' id=\'visittype1\' value=\"\" > \n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" > \n<input type=\'hidden\' name=\'prefenddate2\' id=\'prefenddate2\' value=\"\" > \n<input type=\'hidden\' name=\'call_date_yn\' id=\'call_date_yn\' value=\"N\" > \n<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\"\" > \n<input type=\'hidden\' name=\'start_sch_date\' id=\'start_sch_date\' value=\"\" > \n<input type=\'hidden\' name=\'callingMode\' id=\'callingMode\' value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" > \n<input type=\'hidden\' name=\'from_AE\' id=\'from_AE\' value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" > \n<input type=\'hidden\' name=\'passed_clinic\' id=\'passed_clinic\' value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" > \n<input type=\'hidden\' name=\'from_wait_list\' id=\'from_wait_list\' value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" > \n<input type=\'hidden\' name=\'waitListNo\' id=\'waitListNo\' value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" >\n<input type=\'hidden\' name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n<input type=\'hidden\' name=\'specialty_codema1\' id=\'specialty_codema1\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n<input type=\'hidden\' name=\'spe_or_value\' id=\'spe_or_value\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n<input type=\"hidden\" name=\"speciality_op\" id=\"speciality_op\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n<input type=\"hidden\" name=\"speclty_Cd\" id=\"speclty_Cd\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n<input type=\"hidden\" name=\"resource_class\" id=\"resource_class\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\t\t\t\t\t\n<input type=\"hidden\" name=\"care_locn_ind\" id=\"care_locn_ind\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\t\n<input type=\"hidden\" name=\"i_clinic_code\" id=\"i_clinic_code\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n<input type=\"hidden\" name=\"op_practitioner\" id=\"op_practitioner\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n<input type=\"hidden\" name=\"req_id\" id=\"req_id\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n<input type=\"hidden\" name=\"install_yn_val\" id=\"install_yn_val\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n<input type=\"hidden\" name=\"from_OR\" id=\"from_OR\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n<input type=\"hidden\" name=\'create_wait_list_yn\' id=\'create_wait_list_yn\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'>\n<input type=\"hidden\" name=\'visit_flag_OP\' id=\'visit_flag_OP\' value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'>\n<input type=\"hidden\" name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'>\n<input type=\"hidden\" name=\'loc_type_OP\' id=\'loc_type_OP\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n<input type=\"hidden\" name=\'tt_pract_name\' id=\'tt_pract_name\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>\n<input type=\"hidden\" name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'>\n<input type=\"hidden\" name=\'dwm_desc_old\' id=\'dwm_desc_old\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'>\n<input type=\"hidden\" name=\'from_page_new\' id=\'from_page_new\' value=\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n<input type=\"hidden\" name=\'from_facility_id\' id=\'from_facility_id\' value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'>\n<input type=\"hidden\" name=\'from_encounter_id\' id=\'from_encounter_id\' value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'>\n<input type=\"hidden\" name=\'web_request_yn\' id=\'web_request_yn\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n<input type=\"hidden\" name=\'direct_ip_practid\' id=\'direct_ip_practid\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n<input type=\"hidden\" name=\'calledFrom\' id=\'calledFrom\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n<input type=\"hidden\" name=\'addtl_splty\' id=\'addtl_splty\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n<input type=\"hidden\" name=\'or_cat_desc\' id=\'or_cat_desc\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n<input type=\"hidden\" name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n<input type=\"hidden\" name=\'rd_oa_integration_yn\' id=\'rd_oa_integration_yn\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n<input type=\"hidden\" name=\'first_name_accept_yn\' id=\'first_name_accept_yn\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n<input type=\"hidden\" name=\'first_name_order\' id=\'first_name_order\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n<input type=\"hidden\" name=\'first_name_prompt\' id=\'first_name_prompt\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n<input type=\"hidden\" name=\'first_name_length\' id=\'first_name_length\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\n<input type=\"hidden\" name=\'second_name_accept_yn\' id=\'second_name_accept_yn\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n<input type=\"hidden\" name=\'second_name_order\' id=\'second_name_order\' value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n<input type=\"hidden\" name=\'second_name_prompt\' id=\'second_name_prompt\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n<input type=\"hidden\" name=\'second_name_length\' id=\'second_name_length\' value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\n<input type=\"hidden\" name=\'third_name_accept_yn\' id=\'third_name_accept_yn\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n<input type=\"hidden\" name=\'third_name_order\' id=\'third_name_order\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n<input type=\"hidden\" name=\'third_name_prompt\' id=\'third_name_prompt\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n<input type=\"hidden\" name=\'third_name_length\' id=\'third_name_length\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\n<input type=\"hidden\" name=\'family_name_accept_yn\' id=\'family_name_accept_yn\' value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n<input type=\"hidden\" name=\'family_name_order\' id=\'family_name_order\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n<input type=\"hidden\" name=\'family_name_prompt\' id=\'family_name_prompt\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n<input type=\"hidden\" name=\'family_name_length\' id=\'family_name_length\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n<input type=\"hidden\" name=\'per_chk_cancld_past_appts\' id=\'per_chk_cancld_past_appts\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">\n<input type=\"hidden\" name=\'per_chk_cancld_fut_appts\' id=\'per_chk_cancld_fut_appts\' value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n<input type=\"hidden\" name=\'per_chk_past_resch_appts\' id=\'per_chk_past_resch_appts\' value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n<input type=\"hidden\" name=\'per_chk_fut_resch_appts\' id=\'per_chk_fut_resch_appts\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n<input type=\"hidden\" name=\'no_of_cancld_appts_for_alert\' id=\'no_of_cancld_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n<input type=\"hidden\" name=\'no_of_resch_appts_for_alert\' id=\'no_of_resch_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n<input type=\"hidden\" name=\'mob_num_req_yn\' id=\'mob_num_req_yn\' value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n<input type=\"hidden\" name=\'no_of_fut_appts_for_alert\' id=\'no_of_fut_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n<input type=\"hidden\" name=\'per_chk_for_fut_appts_alert\' id=\'per_chk_for_fut_appts_alert\' value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n\n<input type=\"hidden\" name=\'sys_time\' id=\'sys_time\' value=\"\">\n<input type=\"hidden\" name=\'apptrefno\' id=\'apptrefno\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n<input type=\"hidden\" name=\'isAlertApplicableforBookAppt\' id=\'isAlertApplicableforBookAppt\' value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\"> <!-- added by mujafar for GHL-CRF-0527 -->\n</form>\n";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
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
	//String or_operational="N";
	String order_id=request.getParameter("order_id");	
	if(order_id ==null) order_id="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null) order_line_num="";
	String quer_date_end_param=request.getParameter("quer_date_end");
	if(quer_date_end_param ==null) quer_date_end_param ="";
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");
	String specialty_codema1=request.getParameter("specialty_codema")==null?"":request.getParameter("specialty_codema");	
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");	
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	String disRdApp ="";
	//String specialty_codenew=request.getParameter("specialty_code");
	String callingMode = request.getParameter("callingMode");
	if(callingMode==null) callingMode="";
	session.putValue("callingMode_new",callingMode);
	String apptrefno = request.getParameter("apptrefno");
	if(apptrefno == null) apptrefno ="";
	if(callingMode.equals("RSCAPPT")){
		session.putValue("apptrefno",apptrefno);
	}else{
		session.removeAttribute("apptrefno");
	}
	String module_id = request.getParameter("module_id");
	if(module_id == null) module_id ="";
	String from_AE=request.getParameter("from_AE");
	if(from_AE==null) from_AE="N";		
	String op_practitioner = request.getParameter("practitioner_id");
	String web_request_yn = request.getParameter("web_request_yn")==null?"N":request.getParameter("web_request_yn");
	if (op_practitioner==null) op_practitioner="";
	String speclty_Cd="";
	String disablePract = "";
	String code_val="";
	String from_wait_list=request.getParameter("from_wait_list");
	if(from_wait_list==null) from_wait_list="N";
	String waitListNo=request.getParameter("waitListNo");
	if(waitListNo==null) waitListNo="";
	String care_locn_ind=request.getParameter("care_locn_ind");
	String from_page=request.getParameter("from_page")	;
	if(from_page==null) from_page="";

	String resource_class=request.getParameter("resource_class");
	if(care_locn_ind==null) care_locn_ind="";
	String visit_flag_OP=request.getParameter("visit_flag_OP");
	if(visit_flag_OP==null) visit_flag_OP="N";	
	if(module_id.equals("CA")){
		care_locn_ind ="";
	}
	//out.println("<script>alert('from_wait_list :"+from_wait_list+"')</script>");
	//out.println("<script>alert('waitListNo :"+waitListNo+"')</script>");
	if(resource_class==null) resource_class="";
	String ca_mode="";
	String is_ca=request.getParameter("CA");
	String direct_ip=request.getParameter("DirectIP");
	if(direct_ip==null) direct_ip="N";
	String direct_ip_practid= request.getParameter("i_practitioner_id");
	if(direct_ip_practid==null) direct_ip_practid="";
	
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	
String primary_resource_class=""; //Added By Saanthaakumar Against CRF 34318	Bru-HIMS-CRF-0135
// Added by Jithesh on 18-Nov-03 to handle from  CA
	if(is_ca!=null && is_ca.equals("Y")){
		ca_mode="ca_mode";
		session.putValue("ca_mode","Y");
	}else{
		session.putValue("ca_mode","N");
	}
	if(from_wait_list.equals("Y")){
		ca_mode="ca_mode";
		session.putValue("ca_mode","Y");
		session.putValue("from_wait_list","Y");
		session.putValue("waitListNo",waitListNo);
	}else{
		session.putValue("from_wait_list","N");
	}
	String from_OR=request.getParameter("from_OR");
	if(from_OR ==null) from_OR="N";
	String ca_patient_id=request.getParameter("patient_id");
	if(ca_patient_id==null) ca_patient_id="";
	session.putValue("ca_patient_id_new",ca_patient_id);
	String i_clinic_code=request.getParameter("i_clinic_code");
	if(i_clinic_code==null) i_clinic_code="";
	String req_id=request.getParameter("request_id");
	if(req_id==null) req_id="";
	String appt_date=request.getParameter("appt_date");
	if(appt_date ==null) appt_date="";
	String locale=(String)session.getAttribute("LOCALE");
	String loc_type_OP= request.getParameter("loc_type");
	if(loc_type_OP ==null) loc_type_OP="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null || no_dwm.equals("undefined") ) no_dwm="";
	String visittype=request.getParameter("visittype");
	if(visittype ==null) visittype="";
	String dwm_desc=request.getParameter("dwm_desc");
	if(dwm_desc ==null) dwm_desc="";
	String from_facility_id= request.getParameter("from_facility_id");
	if(from_facility_id ==null) from_facility_id="";
	String from_encounter_id= request.getParameter("from_encounter_id");
	if(from_encounter_id ==null) from_encounter_id="";
	String referral_id= request.getParameter("referral_id");
	if(referral_id ==null) referral_id="";	
	session.setAttribute("referral_id_app",referral_id);
	String calledFrom= request.getParameter("calledFrom");
	if(calledFrom ==null) calledFrom="";
	//Added by S.Sathish for IN021901 on Friday, June 11, 2010 starts here
	String locn_code = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
	String locnDesc = request.getParameter("locnDesc")==null?"":request.getParameter("locnDesc");
	String resourceId = request.getParameter("resourceId")==null?"":request.getParameter("resourceId");
	String resourceDesc = request.getParameter("resourceDesc")==null?"":request.getParameter("resourceDesc");	
    String locn_disable="";	
	if(!locn_code.equals("") && !locnDesc.equals(""))
		locn_disable="";
    else
	   locn_disable="disabled";
//Ends here 
	
	Connection con =null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt_ter=null;
	Statement stmt = null;
	Statement stmt1=null;
	Statement stmt3=null;
	Statement stmt5=null;
	Statement stmt7=null;
	Statement stmt8=null;
	Statement stmt9=null;
	Statement stmt11=null;
	ResultSet rs=null;
	ResultSet rs_ter=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	ResultSet rs5=null;
	ResultSet rs7=null;
	ResultSet rs8=null;
	ResultSet rs9=null;
	ResultSet rs11=null;
	ResultSet rs_or=null;
	StringBuffer sql4=new StringBuffer();
	String install_yn_val="";
	boolean allow_inside=true;

	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String splty_desc="";
	String splty_code="";
	Boolean isAlertApplicableforBookAppt=false; //Added by Mujafar  for GHL-CRF-0527
	
	try{
		
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		stmt5=con.createStatement();
		stmt8=con.createStatement();
		Properties p=(Properties)session.getValue("jdbc");
		String facilityid=(String)session.getValue("facility_id");
		String globaluser = (String)p.getProperty("login_user");

		install_yn_val=request.getParameter("install_yn_val");
		
		if(install_yn_val ==null) install_yn_val="";
		isAlertApplicableforBookAppt = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALRT_DISP_APPL_BOOK_APPT");//Added by Mujafar  for GHL-CRF-0527


		if(install_yn_val.equals("")){
			String sql="select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR' ";

			rs=stmt.executeQuery(sql);
			if(rs !=null ){
				while (rs.next()){
					install_yn_val=rs.getString("Operational_yn");
				}
			}
		}
		// Added for Rutnin CRF
		String rule_appl_yn="N";
		String rd_oa_integration_yn="N";
		String per_chk_cancld_past_appts="0";
		String per_chk_cancld_fut_appts="0";
		String per_chk_past_resch_appts="0";
		String per_chk_fut_resch_appts="0";
		String no_of_cancld_appts_for_alert="0";
		String no_of_resch_appts_for_alert="0";
		String per_chk_for_no_show_alert="0";
		String no_of_noshow_appts_for_alert="0";
		String mob_num_req_yn="N";
		String lang_req_yn ="N";
		String no_of_fut_appts_for_alert="0";
		String per_chk_for_fut_appts_alert="0";
		String patient_id_length="";
		String pat_name_as_multipart_yn="";
		String name_prefix_accept_yn="";
		String name_prefix_reqd_yn="";
		String name_prefix_length="";
		String name_prefix_prompt="";
		String first_name_accept_yn="";
		String first_name_reqd_yn="";
		String first_name_order="";
		String first_name_prompt="";
		String first_name_length="";
		String second_name_accept_yn="";
		String second_name_reqd_yn="";
		String second_name_order="";
		String second_name_prompt="";
		String second_name_length="";
		String third_name_accept_yn="";
		String third_name_reqd_yn="";
		String third_name_order="";
		String third_name_prompt="";
		String third_name_length="";
		String family_name_accept_yn="";
		String family_name_reqd_yn="";
		String family_name_order="";
		String family_name_prompt="";
		String family_name_length="";
		String name_suffix_accept_yn="";
		String name_suffix_reqd_yn="";
		//String name_prefix_length="";
		String name_suffix_prompt="";
		
		String names_in_oth_lang_yn="";
		String name_prefix_loc_lang_prompt="";
		String first_name_loc_lang_prompt="";
		String second_name_loc_lang_prompt="";
		String third_name_loc_lang_prompt="";
		String family_name_loc_lang_prompt="";
		String name_suffix_loc_lang_prompt="";
		
		
		String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
		String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
		String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
		String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
		String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
		String first_name_oth_lang_temp	= checkForNull(request.getParameter("first_name_oth_lang_temp"));
		String second_name_oth_lang_temp	= checkForNull(request.getParameter("second_name_oth_lang_temp"));
		String third_name_oth_lang_temp	= checkForNull(request.getParameter("third_name_oth_lang_temp"));
		String family_name_oth_lang_temp	= checkForNull(request.getParameter("family_name_oth_lang_temp"));
		//String gender_temp		= checkForNull(request.getParameter("gender_temp"));
		String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
		String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
		String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
		String nat_desc_temp	="";
		String lang_desc_temp	="";
		
		if(!ca_patient_id.equals("")){
		// added by N Munisekhar on 04-May-2012 against [IN:039768]

		if(ca_patient_id.equals("dummy_patinetID")){
			patient_id_temp = "";
			}
			else{
			patient_id_temp = ca_patient_id;
			}
		}
		String sql="select RULE_APPL_YN, PER_CHK_CANCLD_PAST_APPTS,PER_CHK_CANCLD_FUT_APPTS,PER_CHK_PAST_RESCH_APPTS,PER_CHK_FUT_RESCH_APPTS,NO_OF_CANCLD_APPTS_FOR_ALERT,NO_OF_RESCH_APPTS_FOR_ALERT,PER_CHK_FOR_NO_SHOW_ALERT,NO_OF_NOSHOW_APPTS_FOR_ALERT,MOB_NUM_REQ_YN,LANGUAGE_REQ_YN,NO_OF_FUT_APPTS_FOR_ALERT,PER_CHK_FOR_FUT_APPTS_ALERT,rd_oa_integration_yn from oa_param ";
		rs=stmt.executeQuery(sql);
		if(rs !=null ){
			while (rs.next()){
				rd_oa_integration_yn=rs.getString("rd_oa_integration_yn")==null?"N":rs.getString("rd_oa_integration_yn");
				rule_appl_yn=rs.getString("RULE_APPL_YN")==null?"N":rs.getString("RULE_APPL_YN");
				per_chk_cancld_past_appts=rs.getString("per_chk_cancld_past_appts")==null?"0":rs.getString("per_chk_cancld_past_appts");
				per_chk_cancld_fut_appts=rs.getString("per_chk_cancld_fut_appts")==null?"0":rs.getString("per_chk_cancld_fut_appts");
				per_chk_past_resch_appts=rs.getString("per_chk_past_resch_appts")==null?"0":rs.getString("per_chk_past_resch_appts");;
				per_chk_fut_resch_appts=rs.getString("per_chk_fut_resch_appts")==null?"0":rs.getString("per_chk_fut_resch_appts");
				no_of_cancld_appts_for_alert=rs.getString("no_of_cancld_appts_for_alert")==null?"0":rs.getString("no_of_cancld_appts_for_alert");
				no_of_resch_appts_for_alert=rs.getString("no_of_resch_appts_for_alert")==null?"0":rs.getString("no_of_resch_appts_for_alert");;
				per_chk_for_no_show_alert=rs.getString("per_chk_for_no_show_alert")==null?"0":rs.getString("per_chk_for_no_show_alert");
				no_of_noshow_appts_for_alert=rs.getString("no_of_noshow_appts_for_alert")==null?"0":rs.getString("no_of_noshow_appts_for_alert");
				mob_num_req_yn=rs.getString("mob_num_req_yn")==null?"N":rs.getString("mob_num_req_yn");
				lang_req_yn=rs.getString("LANGUAGE_REQ_YN")==null?"N":rs.getString("LANGUAGE_REQ_YN");
				no_of_fut_appts_for_alert=rs.getString("NO_OF_FUT_APPTS_FOR_ALERT")==null?"0":rs.getString("NO_OF_FUT_APPTS_FOR_ALERT");
				per_chk_for_fut_appts_alert=rs.getString("PER_CHK_FOR_FUT_APPTS_ALERT")==null?"0":rs.getString("PER_CHK_FOR_FUT_APPTS_ALERT");

			}
		}
		if(rule_appl_yn.equals("Y")){
			sql="Select patient_id_length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn,NAME_PREFIX_ACCEPT_YN,NAME_PREFIX_REQD_YN,NAME_PREFIX_LENGTH,NAME_PREFIX_PROMPT,FIRST_NAME_ACCEPT_YN, FIRST_NAME_REQD_YN, FIRST_NAME_ORDER, FIRST_NAME_PROMPT, SECOND_NAME_ACCEPT_YN, SECOND_NAME_REQD_YN, SECOND_NAME_ORDER, SECOND_NAME_PROMPT, THIRD_NAME_ACCEPT_YN, THIRD_NAME_REQD_YN, THIRD_NAME_ORDER, THIRD_NAME_PROMPT, FAMILY_NAME_ACCEPT_YN, FAMILY_NAME_REQD_YN, FAMILY_NAME_ORDER, FAMILY_NAME_PROMPT, FAMILY_NAME_PREFIX_YN, FAMILY_NO_PROMPT,FAMILY_NAME_LENGTH, FIRST_NAME_LENGTH, SECOND_NAME_LENGTH, THIRD_NAME_LENGTH,NAME_SUFFIX_ACCEPT_YN,NAME_SUFFIX_REQD_YN,NAME_SUFFIX_PROMPT,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_LOC_LANG_PROMPT,FIRST_NAME_LOC_LANG_PROMPT,SECOND_NAME_LOC_LANG_PROMPT,THIRD_NAME_LOC_LANG_PROMPT,FAMILY_NAME_LOC_LANG_PROMPT,NAME_SUFFIX_LOC_LANG_PROMPT from mp_param where module_id='MP'";
			rs=stmt.executeQuery(sql);
			if(rs !=null ){
				while (rs.next()){
					patient_id_length=rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
					pat_name_as_multipart_yn=rs.getString("pat_name_as_multipart_yn")==null?"":rs.getString("pat_name_as_multipart_yn");
					
					name_prefix_accept_yn=rs.getString("name_prefix_accept_yn")==null?"":rs.getString("name_prefix_accept_yn");
					name_prefix_reqd_yn=rs.getString("NAME_PREFIX_REQD_YN")==null?"":rs.getString("NAME_PREFIX_REQD_YN");
					name_prefix_length=rs.getString("name_prefix_length")==null?"":rs.getString("name_prefix_length");
					name_prefix_prompt=rs.getString("name_prefix_prompt")==null?"":rs.getString("name_prefix_prompt");
					
					first_name_accept_yn=rs.getString("FIRST_NAME_ACCEPT_YN")==null?"":rs.getString("FIRST_NAME_ACCEPT_YN");
					first_name_reqd_yn=rs.getString("FIRST_NAME_REQD_YN")==null?"":rs.getString("FIRST_NAME_REQD_YN");
					first_name_order=rs.getString("FIRST_NAME_ORDER")==null?"0":rs.getString("FIRST_NAME_ORDER"); //incident 35325
					first_name_prompt=rs.getString("FIRST_NAME_PROMPT")==null?"":rs.getString("FIRST_NAME_PROMPT");
					first_name_length=rs.getString("FIRST_NAME_LENGTH")==null?"":rs.getString("FIRST_NAME_LENGTH");

					second_name_accept_yn=rs.getString("SECOND_NAME_ACCEPT_YN")==null?"":rs.getString("SECOND_NAME_ACCEPT_YN");
					second_name_reqd_yn=rs.getString("SECOND_NAME_REQD_YN")==null?"":rs.getString("SECOND_NAME_REQD_YN");
					second_name_order=rs.getString("SECOND_NAME_ORDER")==null?"0":rs.getString("SECOND_NAME_ORDER"); //incident 35325
					second_name_prompt=rs.getString("SECOND_NAME_PROMPT")==null?"":rs.getString("SECOND_NAME_PROMPT");
					second_name_length=rs.getString("SECOND_NAME_LENGTH")==null?"":rs.getString("SECOND_NAME_LENGTH");

					third_name_accept_yn=rs.getString("THIRD_NAME_ACCEPT_YN")==null?"":rs.getString("THIRD_NAME_ACCEPT_YN");
					third_name_reqd_yn=rs.getString("THIRD_NAME_REQD_YN")==null?"":rs.getString("THIRD_NAME_REQD_YN");
					third_name_order=rs.getString("THIRD_NAME_ORDER")==null?"0":rs.getString("THIRD_NAME_ORDER"); //incident35325
					third_name_prompt=rs.getString("THIRD_NAME_PROMPT")==null?"":rs.getString("THIRD_NAME_PROMPT");
					third_name_length=rs.getString("THIRD_NAME_LENGTH")==null?"":rs.getString("THIRD_NAME_LENGTH");

					family_name_accept_yn=rs.getString("FAMILY_NAME_ACCEPT_YN")==null?"":rs.getString("FAMILY_NAME_ACCEPT_YN");
					family_name_reqd_yn=rs.getString("FAMILY_NAME_REQD_YN")==null?"":rs.getString("FAMILY_NAME_REQD_YN");
					family_name_order=rs.getString("FAMILY_NAME_ORDER")==null?"":rs.getString("FAMILY_NAME_ORDER");
					family_name_prompt=rs.getString("FAMILY_NAME_PROMPT")==null?"":rs.getString("FAMILY_NAME_PROMPT");
					family_name_length=rs.getString("FAMILY_NAME_LENGTH")==null?"":rs.getString("FAMILY_NAME_LENGTH");
					
					name_suffix_accept_yn=rs.getString("name_suffix_accept_yn")==null?"":rs.getString("name_suffix_accept_yn");
					name_suffix_reqd_yn=rs.getString("name_suffix_reqd_yn")==null?"":rs.getString("name_suffix_reqd_yn");
					//name_prefix_length=rs.getString("name_prefix_length")==null?"":rs.getString("name_prefix_length");
					name_suffix_prompt=rs.getString("name_suffix_prompt")==null?"":rs.getString("name_suffix_prompt");
					
					names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn")==null?"N":rs.getString("names_in_oth_lang_yn");
					name_prefix_loc_lang_prompt=rs.getString("name_prefix_loc_lang_prompt")==null?"":rs.getString("name_prefix_loc_lang_prompt");
					first_name_loc_lang_prompt=rs.getString("first_name_loc_lang_prompt")==null?"":rs.getString("first_name_loc_lang_prompt");
					second_name_loc_lang_prompt=rs.getString("second_name_loc_lang_prompt")==null?"":rs.getString("second_name_loc_lang_prompt");
					third_name_loc_lang_prompt=rs.getString("third_name_loc_lang_prompt")==null?"":rs.getString("third_name_loc_lang_prompt");
					family_name_loc_lang_prompt=rs.getString("family_name_loc_lang_prompt")==null?"":rs.getString("family_name_loc_lang_prompt");
					name_suffix_loc_lang_prompt=rs.getString("name_suffix_loc_lang_prompt")==null?"":rs.getString("name_suffix_loc_lang_prompt");
				}
			}
			String lan_natSQL="select (select long_desc description from mp_country_lang_vw where COUNTRY_CODE='"+nationality_code_temp+"' and language_id='"+locale+"')country_desc,(Select LONG_DESC description from MP_LANGUAGE_LANG_VW where  MP_LANGUAGE_ID='"+language_code_temp+"' and language_id='"+locale+"')lang_desc from dual";
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(lan_natSQL);
			if(rs!=null && rs.next()){
				nat_desc_temp=rs.getString("country_desc")==null?"":rs.getString("country_desc");
				lang_desc_temp=rs.getString("lang_desc")==null?"":rs.getString("lang_desc");
			}
		}
		
	/*	
		//Added for OP Checkout
		if (!op_practitioner.equals("")){
			disablePract = "disabled";
		}
		//End of addition
*/
		String clinic_code="";
		String short_desc="";
		String visit_type_code="";
		String speciality_codes="";
		String book_appt_yn ="";                  
		String pref_from_date="";   
		String create_wait_list_yn ="";   
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id ==null) oper_stn_id="";
		String or_cat_desc="";		
		book_appt_yn=request.getParameter("book_appt_yn");
		if(book_appt_yn ==null) book_appt_yn="";

		create_wait_list_yn=request.getParameter("create_wait_list_yn");
		if(create_wait_list_yn ==null) create_wait_list_yn="";

		



		if (callingMode.equals("OR") || callingMode.equals("OH") || callingMode.equals("RD")){
			if(!order_catalog_code.equals("null")){
				String order_cat_or="select short_desc from OR_ORDER_CATALOG_LANG_VW where ORDER_CATALOG_CODE='"+order_catalog_code+"' and language_id='"+locale+"'"	;
				rs_or = stmt.executeQuery(order_cat_or);
				if(rs_or !=null && rs_or.next()){
					or_cat_desc=rs_or.getString("short_desc");
				}
			}
		}
        if (rs_or!=null) rs_or.close();

		if(oper_stn_id.equals("")){


			String sql2="SELECT a.oper_stn_id,a.book_appt_yn,a.CREATE_WAIT_LIST_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			stmt1=con.createStatement();							
			rs2=stmt1.executeQuery(sql2);
			if (rs2!=null && rs2.next()){
				oper_stn_id=rs2.getString("oper_stn_id");
				book_appt_yn=rs2.getString("book_appt_yn"); 	
				create_wait_list_yn=rs2.getString("CREATE_WAIT_LIST_YN"); 	
			}else{					
				allow_inside=false;
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
		}else{
		
			allow_inside=true;
		}
		
		if(rs1 !=null) rs1.close();
		if(allow_inside){
			if(book_appt_yn.equals("N")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
			String  sql3="Select clinic_code, to_char(sysdate,'dd/mm/yyyy') sys_date from op_clinic a, am_locn_for_oper_stn b where  a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'";

			
			stmt3=con.createStatement();
			rs3=stmt3.executeQuery(sql3);
			int check=0;
			while(rs3.next()){
				pref_from_date=rs3.getString("sys_date");
				if(check == 0)
					clinic_code="'"+rs3.getString("clinic_code")+"'";
				else
					clinic_code=clinic_code+",'"+rs3.getString("clinic_code")+"'";
				check++;
			}
			clinic_code="("+clinic_code+")";
			String clinic_code_main = clinic_code;
			String clnc_code=checkForNull(request.getParameter("clinic_code"));
			String chk_status="";
			if(!callingMode.equals("MR")){ 
				speclty_Cd=request.getParameter("specialty_code");	
				
			}else if( module_id.equals("OA") && callingMode.equals("MR") || callingMode.equals("OH")){
				speclty_Cd=specialty_codema1;
				chk_status="Y";
			}
			if(speclty_Cd ==null) speclty_Cd="";
			String ref_id=(String) session.getValue("ref_id");
			if(ref_id==null) ref_id="";
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		if(rule_appl_yn.equals("Y")){
		
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

						int colCount=6;
						if(name_prefix_accept_yn.equals("Y")){
							colCount--;
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(name_prefix_prompt));
            _bw.write(_wl_block23Bytes, _wl_block23);

						}
						if(pat_name_as_multipart_yn.equals("Y")){
							for(int order=1;order<=4;++order){
								if(order==Integer.parseInt(first_name_order)){
									if(first_name_accept_yn.equals("Y")){
									
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(first_name_prompt));
if(first_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
									}
								}else if(order==Integer.parseInt(second_name_order)){
									if(second_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(second_name_prompt));
if(second_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
									}
								}else if(order==Integer.parseInt(third_name_order)){
									if(third_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(third_name_prompt));
if(third_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
									}
								}else if(order==Integer.parseInt(family_name_order)){
									if(family_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(family_name_prompt));
if(family_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
									}
								}
							}						
						}else{
							if(family_name_accept_yn.equals("Y")){
							
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(family_name_prompt));
if(family_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
								}
						}
						if(name_suffix_accept_yn.equals("Y")){
							colCount--;
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(name_suffix_prompt));
            _bw.write(_wl_block23Bytes, _wl_block23);

							
							out.println("</script>");
							ArrayList nameSuffixArrayList = new ArrayList();
							nameSuffixArrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_name_suffix2",p);
							out.println("<script>");
							int a = 0;
							for(int i=0;i<nameSuffixArrayList.size();i+=3) 
							{
								out.print("NameSuffixArray["+a+"]=escape(\""+(String)nameSuffixArrayList.get(i)+"\");");
								out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)nameSuffixArrayList.get(i+1)+"\");");
								out.print("SuffixSexArray["+a+"]=escape(\""+(String)nameSuffixArrayList.get(i+2)+"\");");				
								a++;
							}
							out.println("</script>");
						}						
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(name_prefix_reqd_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(first_name_reqd_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(second_name_reqd_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(third_name_reqd_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(family_name_reqd_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(name_suffix_reqd_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);

						if(name_prefix_accept_yn.equals("Y")){
							ArrayList namePrefixArrayList = new ArrayList();
							namePrefixArrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
							//System.out.println("namePrefixArrayList :"+namePrefixArrayList.toString());
							int a = 0;
							out.println("<script>");
							for(int i=0;i<namePrefixArrayList.size();i+=3) 
							{								
								out.print("NamePrefixArray["+a+"]=escape(\""+(String)namePrefixArrayList.get(i)+"\");");
								out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)namePrefixArrayList.get(i+1)+"\");");								
								out.print("PrefixSexArray["+a+"]=escape(\""+(String)namePrefixArrayList.get(i+2)+"\");");				
								a++;
							}
							out.println("</script>");							
						
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(name_prefix_prompt));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
if(name_prefix_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
}
					
            _bw.write(_wl_block45Bytes, _wl_block45);

						if(pat_name_as_multipart_yn.equals("Y")){
							for(int order=1;order<=4;++order){
								if(order==Integer.parseInt(first_name_order)){
									if(first_name_accept_yn.equals("Y")){
									
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(first_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(first_name_temp));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
									}
								}else if(order==Integer.parseInt(second_name_order)){
									if(second_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(second_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(second_name_temp));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
									}
								}else if(order==Integer.parseInt(third_name_order)){
									if(third_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(third_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(third_name_temp));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
									}
								}else if(order==Integer.parseInt(family_name_order)){
									if(family_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
									}
								}
							}
						}else{
							if(family_name_accept_yn.equals("Y")){
								
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
									}
						}						
					
            _bw.write(_wl_block52Bytes, _wl_block52);

						if(name_suffix_accept_yn.equals("Y")){							
						
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(name_suffix_prompt));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if(name_suffix_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
}
						

					
            _bw.write(_wl_block56Bytes, _wl_block56);

					if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block57Bytes, _wl_block57);

								int colCount1=6;
								if(name_prefix_accept_yn.equals("Y")){
									colCount1--;
									
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(name_prefix_loc_lang_prompt));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(name_prefix_loc_lang_prompt));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}
								if(pat_name_as_multipart_yn.equals("Y")){
									for(int order=1;order<=4;++order){
										if(order==Integer.parseInt(first_name_order)){
											if(first_name_accept_yn.equals("Y")){
											
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(first_name_loc_lang_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(first_name_loc_lang_prompt));
if(first_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
											}
										}else if(order==Integer.parseInt(second_name_order)){
											if(second_name_accept_yn.equals("Y")){
										
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(second_name_loc_lang_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(second_name_loc_lang_prompt));
if(second_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
											}
										}else if(order==Integer.parseInt(third_name_order)){
											if(third_name_accept_yn.equals("Y")){
										
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(third_name_loc_lang_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(third_name_loc_lang_prompt));
if(third_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
											}
										}else if(order==Integer.parseInt(family_name_order)){
											if(family_name_accept_yn.equals("Y")){
										
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(family_name_loc_lang_prompt));
if(family_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
											}
										}
									}								
								}else{
									if(family_name_accept_yn.equals("Y")){
										
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(family_name_loc_lang_prompt));
if(family_name_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
											}
								}
								if(name_suffix_accept_yn.equals("Y")){
									colCount--;
									
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(name_suffix_loc_lang_prompt));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(name_suffix_loc_lang_prompt));
            _bw.write(_wl_block60Bytes, _wl_block60);
					
									
								}						
							
            _bw.write(_wl_block67Bytes, _wl_block67);

								if(name_prefix_accept_yn.equals("Y")){
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
if(name_prefix_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
}
								if(pat_name_as_multipart_yn.equals("Y")){
									for(int order=1;order<=4;++order){
										if(order==Integer.parseInt(first_name_order)){
											if(first_name_accept_yn.equals("Y")){
											
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(first_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(first_name_oth_lang_temp));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
											}
										}else if(order==Integer.parseInt(second_name_order)){
											if(second_name_accept_yn.equals("Y")){
											
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(second_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(second_name_oth_lang_temp));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
											}
										}else if(order==Integer.parseInt(third_name_order)){
											if(third_name_accept_yn.equals("Y")){
											
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(third_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(third_name_oth_lang_temp));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
											}
										}else if(order==Integer.parseInt(family_name_order)){
											if(family_name_accept_yn.equals("Y")){
											
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(family_name_oth_lang_temp));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
											}
										}
									}
								}else{
									if(family_name_accept_yn.equals("Y")){
										
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(family_name_oth_lang_temp));
            _bw.write(_wl_block77Bytes, _wl_block77);
}else{
										}
								}								
								if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
if(name_suffix_reqd_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
}
							
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(contact_no_temp));
            _bw.write(_wl_block83Bytes, _wl_block83);
if(mob_num_req_yn.equals("Y")){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(nat_desc_temp));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(nationality_code_temp));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(lang_desc_temp));
            _bw.write(_wl_block90Bytes, _wl_block90);
if(lang_req_yn.equals("Y")){
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(language_code_temp));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

					//THIS IS FOR POPULATING SPECIALITY-DROP-DOWN
					String ORspe="";
					StringBuffer sql6=new StringBuffer();
					if(direct_ip.equals("N")){
						sql6.append("select am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) short_desc, speciality_code from am_speciality where  eff_status='E' and speciality_code ");
						if(callingMode.equals("OP") || callingMode.equals("IP")||callingMode.equals("RSCAPPT")){
							sql6.append("='"+speclty_Cd+"' ");
						}else{
							sql6.append(" in (select speciality_code from op_clinic where facility_id='"+facilityid+"' and clinic_code in "+clinic_code_main+") ");
						}
						sql6.append(" order by short_desc");
						if(!(clinic_code_main.equals("()"))){
							stmt7=con.createStatement();
							rs7=stmt7.executeQuery(sql6.toString());
		
							while(rs7.next()){
								short_desc=rs7.getString("short_desc");
								speciality_codes=rs7.getString("speciality_code");
								if(callingMode.equals("OP") || callingMode.equals("IP") || module_id.equals("OA")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT")){
									if(speciality_codes.equals(speclty_Cd)){
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(speciality_codes));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(speciality_codes));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
								}else if(chk_status.equals("Y")){
									if(speclty_Cd.equals(speciality_codes)){
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(speciality_codes));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(speciality_codes));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
									}else{
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(speciality_codes));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
							}							
						}//if
					}
					sql6=null;
					if(callingMode.equals("OR")){
						ORspe="select am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) short_desc, speciality_code from am_speciality where speciality_code !='"+specialty_codema1+"' and eff_status='E'";
						stmt11=con.createStatement();
						rs11=stmt11.executeQuery(ORspe);
						if(rs11.next()){
							//spect_OR=rs11.getString("short_desc");
							code_val=rs11.getString("speciality_code");
						}
					}
				
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
if(rule_appl_yn.equals("Y")){
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
}
            _bw.write(_wl_block108Bytes, _wl_block108);
if(rd_oa_integration_yn.equals("Y")){ //Below line modified for this incident  [IN:038362]
						if(callingMode.equals("OP_RV") || callingMode.equals("OP") ||  callingMode.equals("OR")) disRdApp="disabled";
						String radChk = "";
						if(rd_appt_yn.equals("Y")) radChk="checked"; /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/ 
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(disRdApp));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(radChk));
            _bw.write(_wl_block112Bytes, _wl_block112);
}
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
 
			
			/*
				Below a.PRIMARY_RESOURCE_CLASS is added for query to getprimary resource type for clinic
				By Sudhakar
			*/
				sql4.append(" select a.open_to_all_pract_yn, a.long_desc, a.clinic_code,a.PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw a, am_os_user_locn_access_vw b where a.facility_id='"+facilityid+"' and a.language_id = '"+locale+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+globaluser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type");
				if(direct_ip.equals("N")){	
					if(callingMode.equals("OP") || callingMode.equals("IP") || callingMode.equals("OR") || module_id.equals("OA") || callingMode.equals("MR")|| callingMode.equals("OH") || callingMode.equals("OP_RV")||callingMode.equals("RSCAPPT") ){
						sql4.append(" and a.CARE_LOCN_TYPE_IND=Nvl('"+care_locn_ind+"',CARE_LOCN_TYPE_IND) and a.speciality_code = nvl('"+speclty_Cd+"', a.speciality_code) ");
						sql4.append(" and a.clinic_code = nvl('"+clnc_code+"',a.clinic_code) ");
					}
				}else{
					sql4.append(" and a.clinic_code = '"+clnc_code+"' ");
				}
				sql4.append(" order by a.long_desc");

			
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

					if(loc_type_OP.equals("")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y')  order by short_desc");
					}else if(loc_type_OP.equals("C")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type ='"+loc_type_OP+"'  order by short_desc");
					}else if(loc_type_OP.equals("E")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type ='"+loc_type_OP+"' order by short_desc");
					}else if(loc_type_OP.equals("CE")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E') order by short_desc");
					}
					while(rs5.next()){
						if(care_locn_ind.equals(rs5.getString("locn_type"))){
							if(!callingMode.equals("CA")){
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(rs5.getString("locn_type")));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(rs5.getString("short_desc")));
            _bw.write(_wl_block119Bytes, _wl_block119);
}else {
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(rs5.getString("locn_type")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rs5.getString("short_desc")));
            _bw.write(_wl_block119Bytes, _wl_block119);
}
            _bw.write(_wl_block121Bytes, _wl_block121);
}else if(loc_type_OP.equals("C")) {
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rs5.getString("locn_type")));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(rs5.getString("short_desc")));
            _bw.write(_wl_block121Bytes, _wl_block121);
}else if(loc_type_OP.equals("E")) {
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rs5.getString("locn_type")));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(rs5.getString("short_desc")));
            _bw.write(_wl_block121Bytes, _wl_block121);
}else if(loc_type_OP.equals("CE")) {
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rs5.getString("locn_type")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(rs5.getString("short_desc")));
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rs5.getString("CARE_LOCN_TYPE_IND")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rs5.getString("short_desc")));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block124Bytes, _wl_block124);

				if(rs5 !=null)rs5.close();
				if(callingMode.equals("OP") || callingMode.equals("IP") ||callingMode.equals("OR") || module_id.equals("OA") || callingMode.equals("MR") || callingMode.equals("OH") || callingMode.equals("OP_RV")||callingMode.equals("RSCAPPT")){
					rs5=stmt5.executeQuery(sql4.toString());
					sql4=null;
					//int count_rec=1;
					String clinic_code_frmQuer="";
					short_desc="";
					clinic_code="";
					

					if(rs5.next()){
						primary_resource_class=rs5.getString("primary_resource_class");
						short_desc=rs5.getString("long_desc");
						clinic_code_frmQuer=rs5.getString("clinic_code");
						clinic_code=rs5.getString("open_to_all_pract_yn")+'$'+clinic_code_frmQuer;
						if(i_clinic_code.equals("") && web_request_yn.equals("Y")){
							clinic_code="";
							short_desc="";
						}
						if(clnc_code.equals("") &&  module_id.equals("OA")){
							short_desc="";
							clinic_code_frmQuer="";
							clinic_code="";
						}
						if(clnc_code.equals("") &&  callingMode.equals("OP")){
							short_desc="";
							clinic_code_frmQuer="";
							clinic_code="";
						}
						 
						if(ref_id.equals("N")){ /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{ /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
					}else{ /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block132Bytes, _wl_block132);
}
				}else { /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(locn_disable));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(locnDesc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(locn_disable));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block137Bytes, _wl_block137);

			String tt_pract_name="";
			if(from_wait_list.equals("N") ){ 				
			String sql77="";
			if(callingMode.equals("OP") || module_id.equals("OA") || callingMode.equals("MR")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT") ){
			//	resource_class="P";			
			if(!module_id.equals("OA"))resource_class="P"; 		
				  if(resource_class.equals("P")){
						sql77="select am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) long_name from am_practitioner where  practitioner_id='"+op_practitioner+"'"; 							
				   }else if(resource_class.equals("R")){
						sql77="select am_get_desc.am_facility_room(OPERATING_FACILITY_ID,ROOM_NUM,'"+locale+"',1) long_name from am_facility_room where operating_facility_id = '"+facilityid+"' and room_num='"+op_practitioner+"' ";
					}else if(resource_class.equals("O")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+op_practitioner+"' and resource_class='O' ";
					}else if(resource_class.equals("E")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+op_practitioner+"' and resource_class='E' ";					
					}
					//Below Changes Done By Saanthaakumar Against CRF 34318	Bru-HIMS-CRF-0135 &&  CRF-PAS-Bru-HIMS-CRF-0135/01 ? OP Checkout - Book Appointment [IN:039854] 
					if(callingMode.equals("OP") && !primary_resource_class.equals("P")){
						op_practitioner = "";
					}
					if((resource_class.equals("P"))&& (primary_resource_class.equals("P"))){
						rs8=stmt8.executeQuery(sql77);
						if(rs8 !=null && rs8.next()){
							tt_pract_name=rs8.getString("long_name");
							 }
						 else
						 tt_pract_name="";
				    }
				resource_class="";
			}
		
            _bw.write(_wl_block138Bytes, _wl_block138);
            {java.lang.String __page ="OAResourcelookupframe.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from_page"), weblogic.utils.StringUtils.valueOf("schedule_appt")},{ weblogic.utils.StringUtils.valueOf("pract_value"), weblogic.utils.StringUtils.valueOf(tt_pract_name
                        )},{ weblogic.utils.StringUtils.valueOf("resourceId"), weblogic.utils.StringUtils.valueOf(resourceId
                        )},{ weblogic.utils.StringUtils.valueOf("resourceDesc"), weblogic.utils.StringUtils.valueOf(resourceDesc
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block140Bytes, _wl_block140);
}else{
				if(!direct_ip_practid.equals("")){						
					String sql77="";
					if(resource_class.equals("P")){
						sql77="select am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) long_name from am_practitioner where practitioner_id='"+direct_ip_practid+"'";
					}else if(resource_class.equals("R")){
						sql77="select am_get_desc.am_facility_room(OPERATING_FACILITY_ID,ROOM_NUM,'"+locale+"',1) long_name from am_facility_room where operating_facility_id = '"+facilityid+"' and room_num='"+direct_ip_practid+"' ";
					}else if(resource_class.equals("O")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+direct_ip_practid+"' and resource_class='O' ";
					}else if(resource_class.equals("E")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+direct_ip_practid+"' and resource_class='E' ";
					
					}
					rs8=stmt8.executeQuery(sql77);
					rs8.next();
					tt_pract_name=rs8.getString("long_name");
				}
				
			
            _bw.write(_wl_block108Bytes, _wl_block108);
            {java.lang.String __page ="../../eOA/jsp/OAResourcelookupframe.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from_page"), weblogic.utils.StringUtils.valueOf("schedule_appt_diff")},{ weblogic.utils.StringUtils.valueOf("pract_value"), weblogic.utils.StringUtils.valueOf(tt_pract_name
                        )},{ weblogic.utils.StringUtils.valueOf("pract_id"), weblogic.utils.StringUtils.valueOf(direct_ip_practid
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block140Bytes, _wl_block140);
}//end of else
            _bw.write(_wl_block141Bytes, _wl_block141);
if(customer_id.equals("SRR")||customer_id.equals("RTN")){
				String position_code="";
				String position_desc="";
				String positionSQL="select position_code,position_desc from am_position_lang_vw where language_id=? and eff_status='E' order by 2";
				pstmt = con.prepareStatement(positionSQL);
				pstmt.setString(1,locale);
				if(rs!=null)rs.close();
				rs=pstmt.executeQuery();
				
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

					while(rs!=null && rs.next()){
						position_code=rs.getString("position_code");
						position_desc=rs.getString("position_desc");
						if(position.equals(position_code)){
														
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block144Bytes, _wl_block144);

						}else{
							
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block144Bytes, _wl_block144);

						}
					}
					if(!addtl_splty.equals("")){
						if(pstmt!=null){
							pstmt.close();
						}
						if(rs!=null){
							rs.close();
						}
						StringTokenizer splty_token=null;
						StringBuffer addtl_spl=new StringBuffer("");
						String addtl_splty_1="";
						String addtl_splty_2="";
						if(!addtl_splty.equals("")){
							splty_token=new StringTokenizer(addtl_splty,",");
							if(splty_token.hasMoreTokens()){
								addtl_splty_1=splty_token.nextToken();
							}
							if(splty_token.hasMoreTokens()){
								addtl_splty_2=splty_token.nextToken();
							}
						}
						addtl_spl.append("select speciality_code,short_desc from am_speciality where speciality_code in('"+addtl_splty_1+"'");
						if(!addtl_splty_2.equals("")){
							addtl_spl.append(",'"+addtl_splty_2+"')");
						}else{
							addtl_spl.append(")");
						}
						
						pstmt = con.prepareStatement(addtl_spl.toString());
						rs=pstmt.executeQuery();
						int k=0;
						while(rs!=null && rs.next()){
							if(k==0){
								splty_desc=rs.getString("short_desc");
								splty_code=rs.getString("speciality_code");
							}else{
								splty_desc=splty_desc+","+rs.getString("short_desc");
								splty_code=splty_code+","+rs.getString("speciality_code");
							}
							k++;
						}
					}
				
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(splty_desc));
            _bw.write(_wl_block147Bytes, _wl_block147);

				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
			}
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

				if(from_wait_list.equals("N")){
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
}else{
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
}
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(pref_from_date ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(speclty_Cd));
            _bw.write(_wl_block160Bytes, _wl_block160);
	// added by jitesh for tracking entry from OP
				if(rs8 !=null)rs8.close();
				String quer_date="";

				String quer_date_end="";
				String disable="";
				if(callingMode.equals("OP") || module_id.equals("OA")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT") ){
					quer_date=request.getParameter("recall_date") ==null?"":request.getParameter("recall_date");
					pref_from_date=quer_date;
					//THIS IS FOR GETTING end date based on start date from OP
					
					rs8=stmt8.executeQuery("select to_char(to_date('"+quer_date+"','dd/mm/yyyy') + 29,'dd/mm/yyyy')dat_val from dual");
					rs8.next();
					quer_date_end=rs8.getString("dat_val")==null?"":rs8.getString("dat_val");
				}
				if(callingMode.equals("OR")){
					quer_date=request.getParameter("recall_date") ==null?"":request.getParameter("recall_date");
					quer_date_end=quer_date;
					pref_from_date=quer_date;
				}
				if(callingMode.equals("MR")){
					quer_date=appt_date;
					quer_date_end=appt_date;
				}
				if(direct_ip.equals("Y")){
					quer_date=request.getParameter("recall_date")==null?"":request.getParameter("recall_date");
				}
				if(callingMode.equals("OP_RV")){
					quer_date=pref_from_date;
					quer_date_end=pref_from_date;
					disable = "disabled";
				}

				if(!quer_date_end_param.equals("")){
					quer_date_end=quer_date_end_param;
				}

				String quer_date_display =DateUtils.convertDate(quer_date,"DMY","en",locale);
			
				String quer_date_end_display =DateUtils.convertDate(quer_date_end,"DMY","en",locale);
			
            _bw.write(_wl_block140Bytes, _wl_block140);
 // To handle IP entry
				if(callingMode.equals("IP")){
					callingMode="OP";
					from_AE="Y";
				}
				session.putValue("CallMode",callingMode);
				
			
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block160Bytes, _wl_block160);
  // Below Condition Changed Against Incident [IN:039954] By SaanthaakumarG
				if(!from_wait_list.equals("")){
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(quer_date_display));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(quer_date_end_display));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(quer_date));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(quer_date_end));
            _bw.write(_wl_block168Bytes, _wl_block168);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
if(!quer_date.equals("")) {
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(quer_date_display));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(quer_date_display));
            _bw.write(_wl_block171Bytes, _wl_block171);
}else{
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(quer_date_display));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(quer_date_display));
            _bw.write(_wl_block174Bytes, _wl_block174);
}
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(quer_date));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(quer_date_end));
            _bw.write(_wl_block168Bytes, _wl_block168);
}
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

					StringBuffer sql10=new StringBuffer();
					sql10.append("select short_desc,visit_type_code from op_visit_type_lang_vw where facility_id='"+facilityid+"' and eff_status='E' and language_id='"+locale+"'");
					sql10.append(" order by short_desc");
					stmt9=con.createStatement();
					rs9=stmt9.executeQuery(sql10.toString());
					sql10=null;
					while(rs9.next()){
						short_desc=rs9.getString("short_desc");
						visit_type_code=rs9.getString("visit_type_code");
						if(visit_type_code.equals(visittype)){
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
}else {
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
					}				
				
            _bw.write(_wl_block178Bytes, _wl_block178);

			if(install_yn_val.equals("Y")){
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(disablePract));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block182Bytes, _wl_block182);
}else {
            _bw.write(_wl_block183Bytes, _wl_block183);
}
            _bw.write(_wl_block184Bytes, _wl_block184);

			if(rule_appl_yn.equals("Y")){
				StringBuffer termset_list_values=new StringBuffer();
				String TERM_SET_QRY="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN='Y' AND EFF_STATUS='E' ORDER BY TERM_SET_DESC ASC";
				pstmt_ter=con.prepareStatement(TERM_SET_QRY);
				rs_ter=pstmt_ter.executeQuery();
				while(rs_ter.next()){
					termset_list_values.append("<option value='"+rs_ter.getString("TERM_SET_ID")+"'>"+rs_ter.getString("TERM_SET_DESC")+"</option><br>");
				}
				pstmt_ter.close();
				rs_ter.close();
			
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(termset_list_values.toString()));
            _bw.write(_wl_block188Bytes, _wl_block188);
/*Below line changed for this SCF[ML-BRU-SCF-0692]*/
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
}
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);
				
			
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf((callingMode.equals("IP") || callingMode.equals("OR") || callingMode.equals("CA") ||  callingMode.equals("MR") || callingMode.equals("OP_RV") || module_id.equals("CA") || create_wait_list_yn.equals("N") || from_wait_list.equals("Y") || callingMode.equals("OH")||callingMode.equals("RSCAPPT") )?"hidden":"button"));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);
//removed module_id.equals("OA")||
				if(callingMode.equals("OP") || callingMode.equals("IP")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT")){
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(pref_from_date ));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(ca_mode ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(ca_patient_id ));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(from_AE));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(clnc_code));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(from_wait_list));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(specialty_codema1));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(code_val));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(speclty_Cd));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(speclty_Cd));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(care_locn_ind));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(i_clinic_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(op_practitioner));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(loc_type_OP));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(tt_pract_name));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(dwm_desc));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(web_request_yn));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(direct_ip_practid));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(or_cat_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(rd_oa_integration_yn));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(first_name_accept_yn));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(first_name_order));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(first_name_length));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(second_name_accept_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(second_name_order));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(second_name_length));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(third_name_accept_yn));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(third_name_order));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(third_name_length));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(family_name_accept_yn));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(family_name_order));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(per_chk_cancld_past_appts));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(per_chk_cancld_fut_appts));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(per_chk_past_resch_appts));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(per_chk_fut_resch_appts));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(no_of_cancld_appts_for_alert));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(no_of_resch_appts_for_alert));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(mob_num_req_yn));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(no_of_fut_appts_for_alert));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(per_chk_for_fut_appts_alert));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(isAlertApplicableforBookAppt));
            _bw.write(_wl_block270Bytes, _wl_block270);

}
	if(rs !=null)rs.close();
	if(rs1 !=null) rs1.close();
	if(rs2 !=null) rs2.close();
	if(rs3 !=null) rs3.close();
	if(rs5!=null) rs5.close();
	if(rs7!=null) rs7.close();
	if(rs8!=null) rs8.close();
	if(rs9!=null) rs9.close();
	if(rs11!=null) rs11.close();
	if(rs_or !=null) rs_or.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt3 !=null) stmt3.close();
	if(stmt5 !=null) stmt5.close();
	if(stmt7 !=null) stmt7.close();
	if(stmt8 !=null) stmt8.close();
	if(stmt9 !=null) stmt9.close();
	if(stmt11 !=null) stmt11.close();

}catch(Exception e ){
	e.printStackTrace();
}finally{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block271Bytes, _wl_block271);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.History.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ScheduleCriteria.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.DisplayEarliestSch.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.PractUnSpecified.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.RadAppt.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Additional.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ShowSchAfter.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.preferredperiod.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TerminologySet.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcedureCode.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreateWaitList.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
