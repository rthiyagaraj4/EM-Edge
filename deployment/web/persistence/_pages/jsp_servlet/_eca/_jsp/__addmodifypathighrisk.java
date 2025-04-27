package jsp_servlet._eca._jsp;

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

public final class __addmodifypathighrisk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/addModifyPatHighRisk.jsp", 1738132876729L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCA/js/PatHighRisk.js\' language=\'javascript\'></SCRIPT>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t</head>\n\t<body   class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\'  onload=\'FocusFirstElement()\'>\n\t\t\t<!-- <form name=\'highrisk_form\' id=\'highrisk_form\' action=\'../../servlet/eCA.PatHighRiskServlet?P_patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&P_practitioner_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&P_facility_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&P_locn_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&P_locn_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&P_encounter_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' method=\'post\' target=\'messageFrame\'> commented for CRF-019 - 30460--> \n\t\t\t\n\t\t\t<form name=\'highrisk_form\' id=\'highrisk_form\' action=\'../../servlet/eCA.PatHighRiskServlet?P_patient_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&termSetId=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&termCode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&occurSrlNo=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&srlno=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' method=\'post\' target=\'messageFrame\'> <!-- modified for CRF-019 -30460, 37071 -->\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\"75%\"  align = \'center\'>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n    \t\t\t\t     <td  width=\'75%\' class =\'fields\'>\n    \t\t\t\t     ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t <select name=\'high_risk_code\' id=\'high_risk_code\'>\n\t\t\t\t\t\t <option value=\'\' >&nbsp;&nbsp;----------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="---------&nbsp;&nbsp;</option>\n    \t\t\t\t     ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n    \t\t\t\t    \t\t  </select><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>\n    \t\t\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n    \t\t\t\t   </td> \n\t\t\t\t\t\t   \t\t   </tr>\n\n\t\t\t\t\t\t   <tr>\n\t\t\t\t\t\t   <td class=label width=\'25%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t   <td width=\'75%\' class=\'fields\'>\n\t\t\t\t\t\t\t<textarea name=\"remarks\" rows=\"3\" cols=\"60\" maxlength=\'200\' onKeyPress=\'checkMaxLimit(this,200);\'    onBlur=\"makeValidString(this);checkMaxLimitOnBlur(this,200);\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</textarea>\n\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t   </tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n    \t\t\t\t    <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t \n\t\t\t\t\t\t\t <script language=javascript>\n\n\t\t\t\t\t\t\t </script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n    \t\t\t\t  <tr>\n    \t\t\t\t      <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td><!--validate_date(sys_date,onset); validate_onsetdate(this); -->\n\t\t\t\t\t\t  <td class=\'fields\'  width=\'75%\'>\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'onset\' id=\'onset\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' size=\'10\' maxlength=\'10\'     OnBlur=\'CheckDate(this);isVaidwithSysDate(this,\"DMY\",\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\");calcage(this,ServerDate,onset);reset_date1(this)\' >\n\t\t\t\t\t\t\t\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"document.getElementById(\'formAction\').value = document.getElementById(\'highrisk_form\').action; return showCalendarValidate(\'onset\');\"><img id=\"date_indicator\" src=\'../../eCA/images/mc_history.gif\' style=\"display:none\" height=\'15\'><img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t\t\t(&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;\n\t\t\t\t\t\t\t\t<input type = \"checkbox\" name = \"date_type\" onclick = \"enableDate()\"><input type=\'hidden\' name=\'date_type1\' id=\'date_type1\' value=\'A\'>&nbsp;\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'   \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tOnblur= \'CheckForNumber_L(this,onset);checkDays(this,onset);new_calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\",onset)\'   tabIndex=\'4\'>D&nbsp;\n\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\"2\" \n\t\t\t\t\t\t\t  \tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tOnblur=\'CheckForNumber_L(this,onset);checkMonth(this,onset);new_calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",onset)\'   tabIndex=\'3\'>M&nbsp;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'    \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tOnblur=\'CheckForNumber_L(this,onset);checkYear();new_calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\",onset)\'   tabIndex=\'2\'>Y&nbsp;)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t//alert(document.forms[0].date_type.checked);\n\t\t\t\t\t\t\t\t\tif(document.forms[0].date_type.checked == false)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].b_days.disabled = true;\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].b_months.disabled = true;\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].b_age.disabled = true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t <tr>\n\n    \t\t\t\t      <td  class=\'label\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t\t  <td class =\'label\'>\n\t\t\t\t\t\t<input type=\'text\' name=\'onset\' id=\'onset\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' size=\'10\' maxlength=\'10\' readonly >\n\t\t\t\t\t\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'> </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\t\n    \t\t\t\t      <td  class=\'label\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td><!--check(this); -->\n\n\t\t\t\t\t\t\t<td  class=label class =\'fields\'>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' size=\'10\' maxlength=\'10\'  Onblur=\'CheckDate(this);isBetweenCurrDate(\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\",\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\",this,\"DMY\",\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\");calcage(this,ServerDate1,close);reset_date(this)\'> \n\t\t\t\t\t\t\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"document.getElementById(\'formAction\').value = document.getElementById(\'highrisk_form\').action; return showCalendarValidate(\'close\');\"><!-- <img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'> -->\n\t\t\t\t\t\t   <input type=\'hidden\' name=\'close_date\' id=\'close_date\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'> \n\t\t\t\t\t\t\t\t(&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_days1\" id=\"b_days1\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'  \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t   Onblur=\'CheckForNumber_L(this,close);checkDays(this,close);new_calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\",close)\'   tabIndex=\'4\'>D&nbsp;\n\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_months1\" id=\"b_months1\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' size=\"2\"  \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tOnblur= \'CheckForNumber_L(this,close);checkMonth(this,close);new_calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\",close)\'   tabIndex=\'3\'>M&nbsp;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_age1\" id=\"b_age1\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' \n\t\t\t\t\t\t\t \tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\tOnblur=\'CheckForNumber_L(this,close);new_calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\",close)\'   tabIndex=\'2\'>Y&nbsp;)\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ServerDate1\' id=\'ServerDate1\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t   \n\t\t\t\t\t ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<tr ALIGN = \'RIGHT\'>\t\n\t\t\t\t\t<TD></TD>\n\t\t\t\t\t<td >\n\t\t\t\t\t\t\t <input type=\'button\' name=\'Record\' id=\'Record\' onclick=\"apply()\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' class = \'button\'>&nbsp;\n\t\t\t\t\t\t\t <input type=\'button\' name=\'clear\' id=\'clear\' onclick=\"clearform()\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' class = \'button\'>&nbsp;\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" \n\t\t\t\t\t\t\t <input type=\'button\' name=\'cancel\' id=\'cancel\' onclick=\"cancel1()\" value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' class = \'button\'>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" \n\t\t\t\t\t </td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t\t  \t\t\t\n\n\t\t\t</table> \n\t\t<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'text7\' id=\'text7\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'text8\' id=\'text8\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'text9\' id=\'text9\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'text10\' id=\'text10\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t<input type=\'hidden\' name=\'Clinic_Code\' id=\'Clinic_Code\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t<input type=\'hidden\' name=\'Location_Type\' id=\'Location_Type\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'> <!-- //CHL-CRF [IN035950]-->\n\t\t\n\t\t<!-- //Added by marwan-EDGE work to hold the form action value, to reset it before form submission-->\n\t\t<input type=\'hidden\' name=\'formAction\' id=\'formAction\' value=\'\'> \n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

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
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?             created
14/12/2012	    IN030460 			Karthi L	  	CRF-019 Update PR_Diagnosis table when we modify any patient high risk data when the close date 
02/01/2013	  	IN037071 			Karthi L	  	to control update same high risk condition when try to close one.
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
---------------------------------------------------------------------------------------------------------------
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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement stmt=null;
	ResultSet rset=null ;
	String dat="";
	String highriskcode="";
	String highriskdesc="";
	String onsetdate="";
	String onsetdate1="";
	String fnval="insert";
	String ID="";
	String sel="";
	String remarks="";
	String closedate="";
	String srlno="";

	String agey="";
	String agem="";
	String aged="";

	//java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String facilityId = (String) session.getValue( "facility_id" ) ;
	//String fid=p.getProperty( "login_user" ) ;

//	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= "";

	currentdate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

	onsetdate1=currentdate;
	closedate=currentdate;
	

	highriskcode=request.getParameter("high_risk_code");
	srlno = request.getParameter("srl_no");

	String patient_id = request.getParameter("Patient_Id");
	String encounter_id = request.getParameter("Encounter_Id");
	String practitioner_id = request.getParameter("Practitioner_Id");
	String clinic_code = request.getParameter("Clinic_Code");
	String locn_type = request.getParameter("Location_Type");
	String dob = request.getParameter("dob");
	int ocr_srl_no = 0; // added for CRF-019 -30460
	String trm_set_id = ""; // added for CRF-019 -30460
	String trm_code = ""; // added for CRF-019 -30460
	
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget");//CHL-CRF [IN035950]

	try
	{
	con=ConnectionManager.getConnection(request);
	if(highriskcode!=null )
	{
		fnval="modify";
		//pstmt=con.prepareStatement("Select short_desc, to_char(onset_date,'dd/mm/yyyy') d, to_char(close_date,'dd/mm/yyyy') d1, remarks from pr_high_risk_condition_vw where high_risk_code = ? and srl_no = ? and patient_id = ?");

	//	pstmt=con.prepareStatement("Select MR_GET_DESC.MR_HIGH_RISK(a.high_risk_code,?,'2') short_desc , to_char(a.onset_date,'dd/mm/yyyy') d, to_char(a.close_date,'dd/mm/yyyy') d1, a.remarks,occur_srl_no, from PR_HIGH_RISK_CONDITION a Where a.high_risk_code = ? and a.srl_no = ? and a.patient_id = ? "); commented for CRF-019 -30460
		pstmt=con.prepareStatement("Select MR_GET_DESC.MR_HIGH_RISK(a.high_risk_code,?,'2') short_desc , to_char(a.onset_date,'dd/mm/yyyy') d, to_char(a.close_date,'dd/mm/yyyy') d1, a.remarks,a.occur_srl_no, a.term_set_id, a.term_code from PR_HIGH_RISK_CONDITION a Where a.high_risk_code = ? and a.srl_no = ? and a.patient_id = ? "); // added for CRF-019 -30460
		pstmt.setString(1,locale);
		pstmt.setString(2,highriskcode);
		pstmt.setString(3,srlno);
		pstmt.setString(4,patient_id);

		rset=pstmt.executeQuery();
		rset.next();
		highriskdesc=rset.getString("short_desc");
		onsetdate=rset.getString("d");
		remarks=rset.getString("remarks")==null?"":rset.getString("remarks");
		ocr_srl_no = rset.getInt("occur_srl_no"); // added for CRF-019 -30460
		trm_set_id = rset.getString("term_set_id")==null?"":rset.getString("term_set_id"); // added for CRF-019 -30460
		trm_code = rset.getString("term_code")==null?"":rset.getString("term_code"); // added for CRF-019 -30460
		
		if(!onsetdate.equals("&nbsp;") )
			onsetdate = com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);

		if(rset!=null)	rset.close();
		if(pstmt!=null)	pstmt.close();

		
	}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trm_set_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(trm_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ocr_srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srlno));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' width=15 size=15 value='"+highriskdesc+"' readonly>");
    				     	out.println("<img src='../../eCommon/images/mandatory.gif'align='center'>");
    				    	out.println("<input type='hidden' name='high_risk_code' id='high_risk_code' value='"+highriskcode+"'>");

    				     }
    				     else
							 {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

							//stmt=con.prepareStatement("Select high_risk_code, short_desc from mr_high_risk where eff_status='E' order by short_desc");
							
							stmt=con.prepareStatement("Select high_risk_code, short_desc from mr_high_risk_lang_vw where eff_status='E' and language_id = ? order by short_desc");
							stmt.setString(1,locale);
							rset=stmt.executeQuery();
							if(rset!=null)
							{
							   while(rset.next())
							   {
								dat=rset.getString("short_desc");
								ID=rset.getString("high_risk_code");
								if(ID.equals(highriskcode))
								  sel="selected";
								else
									sel="";
								out.println("<option value='"+ID+ "' "+sel+">"+dat+"</option>");

							    }
            _bw.write(_wl_block23Bytes, _wl_block23);
}
    				    	
								if(rset!=null)rset.close();
								if(stmt!=null)stmt.close();
							}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block26Bytes, _wl_block26);

/*
						stmt=con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
    				    rset=stmt.executeQuery();
    				    rset.next();
						*/
    				    currentdate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    				     
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block28Bytes, _wl_block28);
 if (!fnval.equals("modify")){  
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(onsetdate1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(onsetdate1));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(onsetdate1));
            _bw.write(_wl_block42Bytes, _wl_block42);
 } 
            _bw.write(_wl_block43Bytes, _wl_block43);
 if (fnval.equals("modify")) { 
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(closedate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(closedate));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block61Bytes, _wl_block61);

					       	}
					    	
								if(rset!=null)	rset.close();
								if(stmt!=null)	stmt.close();
								
							
							} catch(Exception e){
									e.printStackTrace() ;
							}
							  finally
							  {	
								 if(con!=null) ConnectionManager.returnConnection(con,request);
							  }
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block64Bytes, _wl_block64);
 if("".equals(p_called_from_widget)){
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block66Bytes, _wl_block66);
 }
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(closedate));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(p_called_from_widget));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighRiskConditions.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Last.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CloseDate.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Before.label", java.lang.String .class,"key"));
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
}
