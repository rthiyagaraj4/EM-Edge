package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __addmodifypatallegy extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/addModifyPatAllegy.jsp", 1709115437639L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n    <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/PatAllergy.js\'></script>\n\t<script language=\'javascript\' src=\'../../ePH/js/DrugNameCommonLookup.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<head> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\nfunction rfresh( )\n{\n  var objVal=document.forms[0].allergyclass.options.value;\n  location.href=\'addModifyPatAllegy.jsp?Patient_Id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Practitioner_Id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&P_facility_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Clinic_Code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&P_locn_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&Encounter_Id\t=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&location_type=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&aclass=\'+objVal+\"&Dob=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n}\n</script>\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload =\"FocusFirstElement()\">\n<form name=\'PatientAllergy_form\' id=\'PatientAllergy_form\'  action=\'../../servlet/eCA.PatAllergyServlet\' method=\'post\' target=\'messageFrame\'>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'90%\'  height=\'80%\' align =\'center\'>\n<tr>\n\t\t<td height=\'10%\' class=\'columnHeader\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td id=disMar class=\'columnHeader\'><font color=red></font></td>\n</tr>\n<tr>\n\t\t<td  width=\'25%\' class=label nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'fields\' width=\'65%\' colspan=\'1\'>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<select name=\'allergyclass\' id=\'allergyclass\' onChange=\'rfresh()\'>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<tr id=\"tr_allergic_to\">\n\t\t\t<td width=\'30%\'  class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td  class=\'fields\' width=\'60%\' colspan=\'2\' >\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t   <input type=\"text\" name=\'allergicto\' id=\'allergicto\'  value=\'\' maxlength=\'30\' onBlur=\"makeValidString(this);\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<select name=\'allergicto\' id=\'allergicto\'>\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t   </td></tr>\n\t\t\t   ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<input type=\'hidden\' name=\'drug_name\' id=\'drug_name\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\'hidden\' name=\'drug_code\' id=\'drug_code\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<tr>\n\t\t\t<td  width=\'30%\'  class=\'label\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t<td width=\'60%\'   class=\'fields\'><input type=\'text\' name=\'generic_name\' id=\'generic_name\' readOnly value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=\'30\' maxlength=\'30\' ><input type=\"button\" class=\"BUTTON\" name=\"drug_search\" id=\"drug_search\" value=\"?\" onClick=\"callGenericSearch(generic_name)\"><img   src=\'../../eCommon/images/mandatory.gif\'><input type=\'hidden\' name=\'generic_id\' id=\'generic_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<tr>\n\t\t\t<td width=\'30%\'  class=\'label\' >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t<td  class=\'fields\' width=\'60%\'  colspan=\'2\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<select name=\'allergydesc\' id=\'allergydesc\'  onchange=\'chekdup(this)\'> \n\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t<b></b>\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\n    \t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t<select name=\'allergydesc2\' id=\'allergydesc2\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\tonchange=\'chekdup(this)\' >\n\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</select>\n\t\t\t\t\t\t<!--<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>-->\n\t\t\t\t\t\t<b></b>\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<select name=\'allergydesc3\' id=\'allergydesc3\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" onchange=\'chekdup(this)\' >\n\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</select>\n\t\t\t\t\t\t<!--<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td></tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t\t \t\n\t\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t<td><textarea name=\"remarks\" rows=\"3\" cols=\"60\" onKeyPress=\'checkMaxLimit(this,200);\'    onBlur=\"makeValidString(this);checkMaxLimit(this,200)\" >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" </textarea></td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'30%\'  class=\'label\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<td width=\'60%\' colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'onset\' id=\'onset\' size=\'10\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="  Onblur=\'CheckDate(this);isVaidwithSysDate(this,\"DMY\",\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\");calci(b_age,\"DMY\",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\",onset);calcage(this,ServerDate,onset)\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<td width=\'60%\' colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'onset\' id=\'onset\' size=\'10\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="  >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'onset\');\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t\t\t\t(";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'\n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tonBlur= \'CheckForNumber_L(this,onset);checkDays(this,onset);calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\",onset);\'   tabIndex=\'4\'>D\n\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' size=\"2\"\n\t\t\t\t\t\t\t \tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t \tonBlur=\'CheckForNumber_L(this,onset);checkMonth(this,onset);calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\",onset)\'   tabIndex=\'3\'>M\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'  \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tonBlur=\'CheckForNumber_L(this,onset);calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\",onset)\'   tabIndex=\'2\'>Y)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</td></tr>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<td width=\'30%\'  class=\'label\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t\t\t<td width=\'60%\' class=\'fields\' nowrap><input type=\'text\' name=\'close\' id=\'close\' value=\'\' size=\'10\' maxlength=\'10\' Onblur=\'CheckDate(this);return isBetweenCurrDate(\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\",\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\",this,\"DMY\",\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\");calcage(this,ServerDate1,close);calci1(b_age1,\"DMY\",\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\",close)\' ><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'close\');\" ><input type=\'hidden\' name=\'close_date\' id=\'close_date\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' >\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t   <input type=\'hidden\' name=\'close_date\' id=\'close_date\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'> \n\t\t\t\t\t\t\t\t(";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_days1\" id=\"b_days1\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'  \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tonBlur= \'CheckForNumber_L(this,close);checkDays(this,close);calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\",close)\'   tabIndex=\'4\'>D\n\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_months1\" id=\"b_months1\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' size=\"2\"  \n\t\t\t\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\t\t\t\tonBlur= \'CheckForNumber_L(this,close);checkMonth(this,close);calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\",close);\'   tabIndex=\'3\'>M\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"b_age1\" id=\"b_age1\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'\n\t\t\t\t\t\t\t    onKeyPress=\'return(ChkNumberInput(this,event,0))\'\tonBlur=\'CheckForNumber_L(this,close);calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\",close);\'   tabIndex=\'2\'>Y)\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ServerDate1\' id=\'ServerDate1\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\n\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t<!--</tr></table>  -->\n\t\t\t</td></tr>\n\t\t</table>\n\t</div>\n  \t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\'  value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n  \t\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t\t<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t\t<input type=\'hidden\' name=\'Clinic_Code\' id=\'Clinic_Code\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t<input type=\'hidden\' name=\'Location_Type\' id=\'Location_Type\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t<input type=\'hidden\' name=\'srlno\' id=\'srlno\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t\t<input type=\"hidden\" name=\"help_function_id\" id=\"help_function_id\" value=\"RECORD_PATIENT_ALLERGY\">\n\t\t<input type=\"hidden\" name=\"tmpfld2\" id=\"tmpfld2\" value=\"\">\n\t\t<input type=\"hidden\" name=\"Dob\" id=\"Dob\" value =\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n<!-- SS -->\n\t\t\t\t\t\t<input type=hidden name=errorRemarks value=\'\'>\n<!-- SE -->\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<input type=\"hidden\" name=\"allergicto\" id=\"allergicto\" value=\"\">\n\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n    </form>\n    </body>\n    </html>\n    \n   ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block1Bytes, _wl_block1);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String sStyle =(String)session.getAttribute("PREFERRED_STYLE") ;

	if(sStyle == null || sStyle.equals("") )
		sStyle = "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con		=	null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement stmt=null;

	ResultSet rset=null ; 
	
	String drug_name	=	"",		generic_id		=	"";
	String drug_code	=	"",		generic_name	= 	"";	
	
	try
	{
	
	con = ConnectionManager.getConnection(request);

   	String currentdate1 		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String Dob = (request.getParameter("Dob")==null?"": request.getParameter("Dob"));
		
	String dis2="disabled";
	String dis3="disabled";
	String agey="";
	String agem="";
	String aged="";
	String sqlqry="";
    String aitem="";
    String aclass="";
    String atypecode="";
    String  locn_type="";
    String alclass="";
    String allergicto="";
	
    String allergydesc="";
	String closedate = currentdate1;
	String onsetdate = currentdate1;
	String remarks="";
	String fnval="insert";
	String srlno="";
	String ID="";
	String dat="";
	String ID1="";
	String dat1="";
	String val1="";
	String id1="";
	String rdonly="";
 	String sel1="";
	String sel2="";
	String id[]={};
	String val[]={};

	int count = 0;
	
    pstmt=con.prepareStatement("select count(1) count from sm_module where module_id = 'PH' and install_yn = 'Y'");
    
	rset=pstmt.executeQuery();

		if(rset!=null)
		{
			if(rset.next())
				count=rset.getInt("count");
		}
            if (count!=0)
			{
				String id2[]={"","D","F","G","I","T"};
				id = id2;
				String val2[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Drug.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Food.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inhalant.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Topical.label","common_labels")};
				val=val2;		    
			}
			else
			{
				String id2[]={"","F","G","I","T"};
				id = id2;
				String val2[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Food.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inhalant.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Topical.label","common_labels")};
				val=val2;
			}
   
   String facilityId = (String) session.getValue( "facility_id" ) ;
   String adesc=request.getParameter("aclass");
   if(adesc == null) adesc="";
   
	aitem		=		request.getParameter("allergyitem");
	aclass		=		request.getParameter("allergyclass");
	atypecode	=		request.getParameter("allergytcode");
	srlno		=		request.getParameter("srl_no");

	String patient_id = request.getParameter("Patient_Id");
	String encounter_id = request.getParameter("Encounter_Id");
	if (encounter_id ==null )
		encounter_id = request.getParameter("encounter_id");

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String clinic_code = request.getParameter("Clinic_Code");
	locn_type = request.getParameter("location_type");
	if (locn_type==null)
	  locn_type="";

try
{
	if(aclass != null )
	{
		fnval="modify";
			
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

		pstmt=con.prepareStatement("select a.ALLERGY_CLASS, a.ALLERGIC_ITEM,a.ALLERGY_TYPE_CODE,(MR_GET_DESC.MR_ALLERGY_TYPE(a.ALLERGY_TYPE_CODE,?,'2')|| ', '||MR_GET_DESC.MR_ALLERGY_TYPE(a.ALLERGY_TYPE_CODE2,?,'2')|| ', '||MR_GET_DESC.MR_ALLERGY_TYPE(a.ALLERGY_TYPE_CODE3,?,'2')) short_desc, to_char(a.onset_date,'dd/mm/yyyy') d, a.remarks  from pr_allergy a  where a.ALLERGIC_ITEM=?  and   a.ALLERGY_CLASS =? and  a.ALLERGY_TYPE_CODE=? and srl_no=?");
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,aitem);
		pstmt.setString(5,aclass);
		pstmt.setString(6,atypecode);
		pstmt.setString(7,srlno);
		rset=pstmt.executeQuery();
		if(rset!=null)
			{
			while(rset.next())
				{
				alclass=rset.getString("ALLERGY_CLASS");
				allergicto=rset.getString("ALLERGIC_ITEM");
				allergydesc=rset.getString("short_desc");
				onsetdate=rset.getString("d");
				remarks=rset.getString("remarks");

				 if(onsetdate == null) 
					 onsetdate = "";
				 else
		 			rdonly="readonly";

				 onsetdate = com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);

				 if(remarks == null) remarks = "";
				}
			}
		if(rset!=null)rset.close();
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
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			if (fnval == "modify")
			{
				for(int i=0; i<id.length; i++)
  				{
  					if(id[i].equals(alclass))
  					val1=val[i];
  					id1=id[i];
  				}
			
				out.print("<input type='text' name='allergyclass' id='allergyclass' value='"+val1+"' readonly>");
      			out.print("<input type='hidden' name='allergy_class' id='allergy_class' value='"+id1+"'>");
				out.print("<img src='../../eCommon/images/mandatory.gif'>");
  			}
  			else
  			{
				String sel="";
  				
            _bw.write(_wl_block19Bytes, _wl_block19);

				for(int i=0; i<id.length; i++)
				{
					if(id[i].equals(adesc))
							sel="selected";

						val1=val[i];
						id1=id[i];
						out.print("<option value='"+id1+"' " +sel+ ">"+val1);
						sel="";
  				}
				
            _bw.write(_wl_block20Bytes, _wl_block20);
}
		if(!(adesc.equals("D")))
		{
			
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

				if(fnval.equals("modify"))
				{
					out.println("<input type='text' name='allergicto' id='allergicto' width=30 size=30 value='"+allergicto+"' readonly>");
					out.println("<img src='../../eCommon/images/mandatory.gif'></td>");
				}
				else
				{
				   if (!adesc.equals("D") )
					  
            _bw.write(_wl_block23Bytes, _wl_block23);

				   else
					{
						
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 
							stmt=con.prepareStatement("SELECT short_name, generic_drug_code generic_code from  ph_generic_drug    where eff_status='E' order by short_name "); 
							rset=stmt.executeQuery();
						
							if(rset!=null)
							{
								while(rset.next())
								{
									dat=rset.getString("short_name");
									ID=rset.getString("generic_code");
							
									if(dat.equals(allergicto))
										sel1="selected";
									else
										sel1="";
										out.println("<option value='"+ID+"' "+sel1+">"+dat+"</option>");
									}
									
            _bw.write(_wl_block26Bytes, _wl_block26);

								}
								
								if(rset!=null)rset.close();
							}
							
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
	}						
	else
	{
	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block33Bytes, _wl_block33);

	}	
	
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
if(fnval.equals("modify"))
			 {
				out.println("<input type='text' name='allergydesc' id='allergydesc'   value='"+allergydesc+"' readonly>");
				out.println("<img src='../../eCommon/images/mandatory.gif'>");
			 }
			else
			{
				
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);


				 //sqlqry="SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				 sqlqry="SELECT  short_desc, allergy_type_code from mr_allergy_type_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ? order by short_desc";
				pstmt1=con.prepareStatement(sqlqry);
				pstmt1.setString(1,adesc);
				pstmt1.setString(2,adesc);
				pstmt1.setString(3,locale);
				rset=pstmt1.executeQuery();

				if(rset!=null)
				{
					while(rset.next())
					{
						dat1=rset.getString("short_desc");
						ID1=rset.getString("allergy_type_code");
						if(ID1.equals(allergydesc))
						  sel2="selected";
						else
							sel2="";
						out.println("<option value='"+ID1+ "' "+sel2+">"+dat1+"</option>");}
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);

				

					if (rset!=null) rset.close();
					if (stmt!=null) stmt.close();

					
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dis2));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);


				// sqlqry="SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				sqlqry="SELECT  short_desc, allergy_type_code from mr_allergy_type_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ? order by short_desc";
				pstmt1=con.prepareStatement(sqlqry);
				pstmt1.setString(1,adesc);
				pstmt1.setString(2,adesc);
				pstmt1.setString(3,locale);
				rset=pstmt1.executeQuery();

				if(rset!=null)
				{
					while(rset.next())
					{
						dat1=rset.getString("short_desc");
						ID1=rset.getString("allergy_type_code");
						if(ID1.equals(allergydesc))
						  sel2="selected";
						else
							sel2="";
						out.println("<option value='"+ID1+ "' "+sel2+">"+dat1+"</option>");}
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

				

					if (rset!=null) rset.close();
					if (stmt!=null) stmt.close();

					
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);


				 //sqlqry="SELECT short_desc, allergy_type_code from mr_allergy_type where eff_status='E' and nvl(allergy_class,?)=? order by short_desc";
				sqlqry="SELECT  short_desc, allergy_type_code from mr_allergy_type_LANG_VW where eff_status='E' and nvl(allergy_class,?)=? AND LANGUAGE_ID = ? order by short_desc";
				pstmt1=con.prepareStatement(sqlqry);
				pstmt1.setString(1,adesc);
				pstmt1.setString(2,adesc);
				pstmt1.setString(3,locale);
				rset=pstmt1.executeQuery();

				if(rset!=null)
				{
					while(rset.next())
					{
						dat1=rset.getString("short_desc");
						ID1=rset.getString("allergy_type_code");
						if(ID1.equals(allergydesc))
						  sel2="selected";
						else
							sel2="";
						out.println("<option value='"+ID1+ "' "+sel2+">"+dat1+"</option>");}
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

				

					if (rset!=null) rset.close();
					if (stmt!=null) stmt.close();

					
            _bw.write(_wl_block48Bytes, _wl_block48);
}
					
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(currentdate1));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
if (!(fnval == "modify")){ 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block58Bytes, _wl_block58);
 } else { 
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
if (!(fnval == "modify")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block70Bytes, _wl_block70);
	} 
            _bw.write(_wl_block71Bytes, _wl_block71);
 if (fnval.equals("modify")) { 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(onsetdate));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(currentdate1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(closedate));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(closedate));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(closedate));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
			} catch  (Exception e) {
				// out.print("Exception in addModifyPatAllegy.jsp"+e.toString());//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
            
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(srlno));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block96Bytes, _wl_block96);

		if(adesc.equals("D"))
		{
	
            _bw.write(_wl_block97Bytes, _wl_block97);

		}
	
            _bw.write(_wl_block98Bytes, _wl_block98);
 
			if (rset!=null) rset.close();
			if (stmt!=null) stmt.close();
			if (pstmt!=null) pstmt.close();
			if (pstmt1!=null) pstmt1.close();
   } 
   catch(Exception e)
	{
		//out.println("Exception in addModifyPatAllegy.jsp"+e.toString());//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
		
	}
   finally
   {
		if (con!=null) ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllergyAssessment.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergyType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllergicTo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergicDesc.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OnsetDateTime.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Last.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CloseDate.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Before.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
