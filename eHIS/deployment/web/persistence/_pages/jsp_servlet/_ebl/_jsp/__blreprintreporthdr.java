package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Calendar;
import eBL.BLReportIdMapper;
import java.util.*;
import com.ehis.util.*;

public final class __blreprintreporthdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReprintReportHdr.jsp", 1737916763610L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!--\nSr No        Version           TFS/Incident        SCF/CRF    \t\t\tDeveloper Name\n----------------------------------------------------------------------------------------------\n1            V210405             16612     \t \tNMC-JD-SCF-0167-TF\t\tMohana Priya K\n2            V210624             17147     \t\tPMG2021-COMN-CRF-0077\t\tMuthkumarN\n-->\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t\t<HEAD>\n\t\t\t<TITLE>\n\t\t\tInterim Bill Generation\n\t\t\t</TITLE>\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../js/BLReprintReport.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\t\n\t\t\t<script language=\"javascript\" src=\"../../eBL/js/AutoFillSearchCriteria.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<script>\n\t $(document).ready(function(){\n\t\t \n\t\t \n\t\t \tvar locale=$(\'#locale\').val();\n    \t\t\n\t\t \tvar siteSpec=$(\'#site_spec\').val();\n\t\t $(\'#reset\').click(function(){\n\t\t\t resetSrchCriteria();\n         });\n\t\t \n\t\t $(\'#episode_type\').click(function(){\n\t\t\t if($(\'#episode_type\').val()==\'**\' || $(\'#episode_type\').val()==\'R\'){\t\t\t\t \n\t\t\t\t $(\'#episode_id\').val(\'\'); \n\t\t\t\t $(\'#episode_id\').prop(\'disabled\', true);\n\t\t\t\t $(\'#episode_idbut\').prop(\'disabled\', true);\t\t\t \n\t\t\t }else{\n\t\t\t\t $(\'#episode_id\').prop(\'disabled\', false); \n\t\t\t\t $(\'#episode_idbut\').prop(\'disabled\', false);\t\n\t\t\t }\n         });\n\t\t \n\t\t\n\t\t $(\'#to_bill_date\').blur(function(){\n\t\t\t\n\t\t\t var bool =  checkDateBL(document.forms[0].to_bill_date);\n\t\t\t\t\n\t\t\t\tif(!bool){\n\t\t\t\t\t $(\'#to_bill_date\').val($(\'#todaysDate\').val());\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif($(\"#to_bill_date\").val()!=\'\'){\n\t\t\t\t\t \n\t\t\t\t\tvar fromLesserThanCurrentDt=isBeforeNow($(\"#to_bill_date\").val(), \'DMY\',$(\"#locale\").val());\t\n\t\t\t\t\t\n\t\t\t\t \t var  lesserThanCurrentDt=isBeforeNow($(\"#from_bill_date\").val(), \'DMY\',$(\"#locale\").val());\t\t\t \n\t\t\t\t\t var  toGrtThanFromDt= isAfter( $(\"#to_bill_date\").val(), $(\"#from_bill_date\").val(), \'DMY\',$(\"#locale\").val());\n\t\t\t\t\t  \n\t\t\t\t\t if(fromLesserThanCurrentDt == false){\n\t\t\t\t\t\t alert(\"To Date Cannot be greater than Current Date\");\n\t\t\t\t\t\t\n\t\t\t\t\t\t  $(\"#to_bill_date\").val($(\'#todaysDate\').val());\n\t\t\t\t\t }\n\t\t\t\t\t else if(lesserThanCurrentDt==false){\n\t\t\t\t\t  alert(\"From Date Cannot be greater than Current Date\");\n\t\t\t\t\t  $(\"#from_bill_date\").val($(\'#todaysDate\').val());\n\t\t\t\t\t  }\n\t\t\t\t\t  else if(toGrtThanFromDt==false){\n\t\t\t\t\t\tif($(\"#to_bill_date\").val()!=\'\' ){\n\t\t\t\t\t\t\t\n\t\t\t\t\t \t alert(\"To Date Cannot be lesser than From Date\");\n\t\t\t\t\t  \t$(\"#to_bill_date\").val($(\'#from_bill_date\').val());\n\t\t\t\t\t  }\n\t\t\t\t\t }\n\t\t\t\t\t \n\t\t\t\t\t }\n\t\t\t\t/*else{\n\t\t\t\t\t$(\"#to_bill_date\").val($(\"#todaysDate\").val());\n\t\t\t\t}*/\n\t\t\t});\n\t\t\t\t\n\t\t$(\'#from_bill_date\').blur(function(){\n\t\t\n\t\t\tvar bool =  checkDateBL(document.forms[0].from_bill_date);\n\t\t\n\t\t\tif(!bool){\n\t\t\t\t $(\'#from_bill_date\').val($(\'#todaysDate\').val());\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\tif($(\"#from_bill_date\").val()!=\'\' ){\n\t\t\t\tvar fromLesserThanCurrentDt=true;\n\t\t\t\tvar  lesserThanCurrentDt=true;\n\t\t\t\tvar  toGrtThanFromDt=true;\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tfromLesserThanCurrentDt=isBeforeNow($(\"#from_bill_date\").val(), \'DMY\',$(\"#locale\").val());\n\t\t\t\tif($(\"#to_bill_date\").val()!=\'\'){\n\t\t\t\tlesserThanCurrentDt=isBeforeNow($(\"#to_bill_date\").val(), \'DMY\',$(\"#locale\").val());\n\t\t\t\ttoGrtThanFromDt=isAfter( $(\"#to_bill_date\").val(), $(\"#from_bill_date\").val(), \'DMY\',$(\"#locale\").val());\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(fromLesserThanCurrentDt == false){\n\t\t\t\t\talert(\"From Date Cannot be greater than Current Date\");\n\t\t\t\t\t$(\"#from_bill_date\").val($(\'#todaysDate\').val());\n\t\t\t\t}\n\t\t\t\telse if(lesserThanCurrentDt==false){\n\t\t\t\t  alert(\"To Date Cannot be greater than Current Date\");\n\t\t\t\t  $(\"#to_bill_date\").val($(\'#todaysDate\').val());\n\t\t\t\t  }\n\t\t\t\t  else if(toGrtThanFromDt==false){\n\t\t\t\t\t\tif( $(\"#from_bill_date\").val()!=\'\'){\n\t\t\t\t \t\t alert(\"From Date Cannot be greater than To Date\");\n\t\t\t\t\t\t $(\"#from_bill_date\").val($(\"#to_bill_date\").val());\n\t\t\t\t\t\t }\n\t\t\t\t }\n\t\t\t\t \n\t\t\t\t }\n\t\t\t/*else{\n\t\t\t\t$(\"#from_bill_date\").val($(\"#todaysDate30\").val());\n\t\t\t}*/\n\t\t});\n\t\t \n        \n         fnAutoFillLoadCriteria(\'EBL_REPRINT_REPORT\');\n         \n\t\t  //V210405 starts\n         if (siteSpec == \'true\') {\n        \t if($(\'#language_option\').val()==\'E\'){\n \t\t\t\t$(\'#language_option\').val(\'E\');\n \t\t\t\t}\n \t\t\telse {\n \t\t\t\t$(\'#language_option\').val(\'A\');\n \t\t\t\t}\n \t\t\t}\n       //V210405 ends\n\n         if($(\'#dtlPrint\').val()==\'Y\'){\n        \t $(\'#dtlPrint\').prop(\'checked\', true);\n         }\n         \n         if($(\'#outStdOnly\').val()==\'Y\'){\n        \t $(\'#outStdOnly\').prop(\'checked\', true);\n         }\n         if($(\'#consolidatedBillSettlement\').val()==\'Y\'){\n        \t $(\'#consolidatedBillSettlement\').prop(\'checked\', true);\n         }\n \t\t if($(\'#episode_type\').val()==\'**\' || $(\'#episode_type\').val()==\'R\'){\t\t\t\t \n\t\t\t $(\'#episode_id\').val(\'\'); \n\t\t\t $(\'#episode_id\').prop(\'disabled\', true);\n\t\t\t $(\'#episode_idbut\').prop(\'disabled\', true);\t\t\t \n\t\t }else{\n\t\t\t $(\'#episode_id\').prop(\'disabled\', false); \n\t\t\t $(\'#episode_idbut\').prop(\'disabled\', false);\t\n\t\t }        \n        \n \t\t/* if($(\'#from_bill_date\').val() == \'\'){\n \t\t\t$(\'#from_bill_date\').val($(\'#todaysDate\').val());\n \t\t }\n \t\t if($(\'#to_bill_date\').val() == \'\'){\n  \t\t\t$(\'#to_bill_date\').val($(\'#todaysDate\').val());\n  \t\t }*/\n  \t\t \n  \t\t \n\t\t/*if (siteSpec == \'true\') {\n\t\t\t\t\t\t\t\tif (locale == \'en\') {\n\t\t\t\t\t\t\t\t\t$(\'#language_option\').val(\'E\');\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\telse {\n\t\t\t\t\t\t\t\t\t$(\'#language_option\').val(\'A\');\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}  */ //Commented against V210405\n\n\n\t\t\t\t\t\t});   \n\t</script>\n\t\n\t</HEAD> \n\t\t\t<BODY onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"onSelect=\"codeArrestThruSelect();\">\n\t\t\t<FORM name=\'BLReprintReport\' id=\'BLReprintReport\' method=\'\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t\t\t<TABLE border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'20%\' class=\'COLUMNHEADER\' nowrap colspan=\"8\">\n      \t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n      \t\t\t</td>\n      \t\t</tr>\n\t\t\t <TR>\n\t\t\t\t\n\t\t\t   <td width=\'17%\'  class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t\t   \t<td width=\'17%\'>\n\t\t\t\t<Select id=\"episode_type\" name=\"episode_type\" id=\"episode_type\">\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<option value=\"**\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" selected>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t  \t\t\n\t\t\t\t</select>\n\t\t\t\t</td>\t\n\t\t\t\t<td width=\"17%\" class=\"label\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td width=\"17%\" class=\'fields\'>\n\t\t\t\t\t<input type=\"text\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" maxlength=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" \n\t\t\t\t\t\tonKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" onblur=\"if(this.value!=\'\'){ChangeUpperCase( this ); callPatValidation(this);defaultEncounter(\'patId\');} \">\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"PatientIdLookup();defaultEncounter();\"  tabindex=\'2\' />\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width=\"16%\" class=\"label\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td width=\"16%\" class=\'fields\'>\n\t\t\t\t\t<input type=\"text\" name=\"episode_id\" id=\"episode_id\" id=\"episode_id\"  maxlength=\"30\"   size=\"12\"  onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'hdnEpisode_id\' id=\'hdnEpisode_id\' id=\'hdnEpisode_id\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' id=\"episode_idbut\" name=\"episode_idbut\" id=\"episode_idbut\" value=\'?\' onClick=\"callEpisodeDialog()\"  tabindex=\'2\' /> \t\t \t\t\t\t\t\n\t\t\t\t</td>  \t\t\t\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t <tr>\n\t\t\t \t\t\t\t\n\t\t\t\t <td width=\"17%\" class=\"label\" width=\"25%\">\n\t\t\t\t \t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t </td>\t\n\t\t\t\t<td width=\"17%\" class=\"fields\" width=\"25%\">\n\t\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"from_bill_number\" id=\"from_bill_number\" id=\'from_bill_number\' SIZE=\"15\"  MAXLENGTH=\'40\' VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onBlur=\"if(this.value != \'\' ){ billNoLkup(this,document.forms[0].from_bill_number_code,\'Y\');billNoFromToValidation(\'FROM\'); } else{ clearCode(from_bill_number_code);}\">&nbsp;<input type=\'button\' class=\'button\' name=\"frombillbut\" id=\"frombillbut\" value=\'?\' onClick=\'billNoLkup(document.forms[0].from_bill_number,document.forms[0].from_bill_number_code);billNoFromToValidation(\"FROM\");\' >\n\t\t\t\t\t<input type= \'hidden\' name=\"from_bill_number_code\" id=\"from_bill_number_code\"  id=\'from_bill_number_code\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t</td>\t\t\n\t\t\t\t<td width=\"17%\" class=\"label\" width=\"25%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</td>\t\n\t\t\t\t<td width=\"17%\" class=\"fields\" width=\"25%\">\n\t\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"to_bill_number\" id=\"to_bill_number\" id=\'to_bill_number\' SIZE=\"15\"  MAXLENGTH=\'40\'\tVALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onBlur=\"if(this.value != \'\' ){ billNoLkup(this,document.forms[0].to_bill_number_code,\'Y\');billNoFromToValidation(\'TO\');} else{ clearCode(to_bill_number_code);}\">&nbsp;<input type=\'button\' class=\'button\' name=\"tobillbut\" id=\"tobillbut\" value=\'?\' onClick=\'billNoLkup(document.forms[0].to_bill_number,document.forms[0].to_bill_number_code);billNoFromToValidation(\"TO\");\' >\n\t\t\t\t\t<input type= \'hidden\' name=\"to_bill_number_code\" id=\"to_bill_number_code\"  id=\"to_bill_number_code\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\t\n\t\t\t\t</td>\t\n\t\t\t\t<td width=\"16%\" class=\"label\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<input type=\"text\" name=\"visit_id\" id=\"visit_id\" id=\"visit_id\"  maxlength=\"4\"  onBlur=\"\" size=\"4\"  onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\">&nbsp;&nbsp;\n\t\t\t\t  </td>\n\t\t\t\t  \n\t\t\t\t  <td width=\"16%\" class=\"label\" >\n\t\t\t\t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\n\t\t\t\t\t<input type=\"text\" name=\"payer_group\" id=\"payer_group\" id=\"payer_group\" size=\'2\' onKeyPress=\"\" onblur=\"payergrouplookup(payer_group,\'BLUR\')\" >\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"payergroupbtn\" id=\"payergroupbtn\" value=\'?\' onClick=\"payergrouplookup(payer_group,\'BTN\')\" >\t\t\t\t\t\n\t\t\t \n\t\t\t<input type=\'hidden\' name=\'payerdesc\' id=\'payerdesc\' id=\'payerdesc\' value=\'\'>\n\t\t\t\t\n\t\t\t\t</td>\n\n\t\t\t\t\n\t\t\t </tr>\n\t\t\t\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<td width=\'17%\' class=\'label\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="    </td>\n\t\t\t<td width=\'17%\' class=\"fields\"><input type=\'text\' name=\'from_bill_date\' id=\'from_bill_date\' id=\'from_bill_date\'  SIZE=\'10\' maxlength=\'30\' VALUE=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  ><img name=\'from_bill_date_cal\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'from_bill_date\');\" onBlur=\'return checkDateBL(document.forms[0].from_bill_date)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t<td width=\"17%\"  class=\'label\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" </td>\n\t\t\t<td width=\'17%\' class=\"fields\"><input type=\'text\' name=\'to_bill_date\' id=\'to_bill_date\' id=\'to_bill_date\' SIZE=\'10\' maxlength=\'30\'  VALUE=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ><img name=\'to_bill_date_cal\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'to_bill_date\');\" onBlur=\'return checkDateBL(document.forms[0].to_bill_date)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<td width=\'17%\' class=\'label\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="    </td>\n\t\t\t\t<td width=\'17%\' class=\"fields\"><input type=\'text\' name=\'from_bill_date\' id=\'from_bill_date\' id=\'from_bill_date\'  SIZE=\'10\' maxlength=\'30\' VALUE=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'  ><img name=\'from_bill_date_cal\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'from_bill_date\');\" onBlur=\'return checkDateBL(document.forms[0].from_bill_date)\'></td>\n\t\t\t\t<td width=\"17%\"  class=\'label\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </td>\n\t\t\t\t<td width=\'17%\' class=\"fields\"><input type=\'text\' name=\'to_bill_date\' id=\'to_bill_date\' id=\'to_bill_date\' SIZE=\'10\' maxlength=\'30\'  VALUE=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' ><img name=\'to_bill_date_cal\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'to_bill_date\');\" onBlur=\'return checkDateBL(document.forms[0].to_bill_date)\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<td width=\'16%\'  class=\'label\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\t\t\n\t\t\t\t\t<td width=\'16%\'><select id=\"bill_type\" name=\'bill_type\' id=\'bill_type\' >\n\t\t\t\t\t\t<option value=\"**\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t<option value=\"T\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t\t\t\t\t<option value=\"D\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t\t\t\t\t<option value=\"A\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option>\n\t\t\t\t\t\t<option value=\"O\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t\t<!-- Added by Karthik on 3/3/2015 This External Bill Code is only for Temporary Reference -->\n\t\t\t\t\t\t<option value=\"E\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</select>\n\t\t\t\t</td>\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\'16%\'  class=\'label\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\t\n\t\t\t\n\t\t\t<td width=\'16%\'><select name=\'payer_type\' id=\'payer_type\' id=\'payer_type\' >\n\t\t\t\t\t\t\n\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option> <!-- added against 0038.4-->\t\t\t\t\n\t\t\t\t\t <option value=\'C\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option> <!-- added against 0038.4-->\n\t\t\t\t\t\t <option value=\'R\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option> <!-- added against 0038.4-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t</option>\n\t\t\t\t\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t\n\t\t\t\t\n\t\t\t\t<td width=\"16%\" class=\"label\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t<td width=\'16%\'><input type=\'text\' name=\'cust_desc\' id=\'cust_desc\' value=\'\' size=\'5\' onblur=\"custLookUp(cust_desc,\'BLUR\')\" >&nbsp;<input type=\'button\' name=\'cust_button\' id=\'cust_button\' class=\'button\' value=\'?\' onclick=\"custLookUp(cust_desc,\'BTN\')\">\n\t\t\t\t\t<input type=\'hidden\' name=\'cust_code\' id=\'cust_code\' id=\'cust_code\' value=\'\' > \n\t\t\t\t</td>\n\t\t\t\t\t\n\t<td class=\"label\"  width=\'17%\' >\n\t\t\t\n\t\t\t\t<input type=\"checkbox\" name=\"zerobill\" id=\"zerobill\" id=\'zerobill\' checked=\"checked\"  /> \n\t\t\t\t&nbsp; ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="  <!--added against MOHE-CRF-0039-->       \t\t\t\t\n\t\t\t</td>\n\t\t\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t</TR>\n\t\t\t<TR>\t\t\n\t\t\t\t \n\t\t\t<td class=\"label\" width=\'17%\' >\n\t\t\t\t<input type=\"checkbox\" name=\"dtlPrint\" id=\"dtlPrint\" id=\'dtlPrint\'   /> \n\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t\n\t\t\t<td class=\"label\" width=\'17%\' >\n\t\t\t\t<input type=\"checkbox\" name=\"outStdOnly\" id=\"outStdOnly\" id=\'outStdOnly\'  /> \n\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\"label\"  width=\'17%\' >\n\t\t\t\t<input type=\"checkbox\" name=\"saveSearchCriteria\" id=\"saveSearchCriteria\" id=\'saveSearchCriteria\' checked /> \n\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\t\t\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\n\t\t\t\t<td class=\"label\"  width=\'17%\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t<select name=\'language_option\' id=\'language_option\' id=\'language_option\' onChange=\'reportOption(this)\' >\n\t\t\t\t\t<option value=\'A\'>Arabic</option>\n\t\t\t\t\t<option value=\'E\'>English</option>\n\t\t\t\t</select>\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\n\t\t\t<td class=\"label\"  width=\'17%\' >\n\t\t\t\n\t\t\t\t<input type=\"checkbox\" name=\"consolidatedBillSettlement\" id=\"consolidatedBillSettlement\"  style=\"visibility:visible;\" /> \n\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\t\t\t\t\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<td class=\"label\"  width=\'17%\' >\n\t\t\t\n\t\t\t\t<input type=\"checkbox\" name=\"consolidatedBillSettlement\" id=\'consolidatedBillSettlement\' style=\"visibility:hidden;\"   /> \n\t\t\t\t\t\t\t\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\n\t\t\t<td  class=\"label\" width=\'16%\' >\n\t\t\t\t<input type=\'button\' class=\'button\'  onclick=\'search()\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"  name=\'search_but\' id=\'search_but\' >&nbsp;\n\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'resetSrchCriteria()\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"  name=\'reset_but\'  id=\'reset_but\' >\n\t\t\t</td>\n\t\t\t<td  class=\"label\" width=\'16%\' >\n\t\t\t</td>\n\t\t\t</TR>\n\t\t\t</tr>\n\t\t\t</TABLE>\n\t\t\t<table>\n\t\t\t<tr></tr>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\n\t\t\t<td class=\"label\" width=\'40%\'>\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td> <!--added against MOHE-CRF-0039--> \n\t\t\t\n\t\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t</TR>\n\t\t</table>\n\t\t<input type= hidden name=\"locale\" id=\"locale\"  id=\'locale\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type= hidden name=\"facility_id\" id=\"facility_id\"  id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\t\t\n\t\t<input type= hidden name=\"patient_id1\" id=\"patient_id1\"  value=\'\'>\t\t\n\t\t<!--<input type= hidden name=\"demo_version\" id=\"demo_version\" id=\'demo_version\' value=\'\'> //removed demo_version against V210624-->\n\t\t<input type= hidden name=\"site_id\" id=\"site_id\" id=\'site_id\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\t\t\n\t\t\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\"\">\n\t\t<input type=\'hidden\' name=\'log_rep_success_mes\' id=\'log_rep_success_mes\' value=\'\'>\n\t\t\n\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"   id=\"p_report_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"    value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t   value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t<input type=\"hidden\" name=\"L_EPISODE_TYPE\" id=\"L_EPISODE_TYPE\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_REPORT_TYPE\" id=\"L_REPORT_TYPE\"\t   value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"L_PAYER\" id=\"L_PAYER\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_FROM_BILL_NO\" id=\"L_FROM_BILL_NO\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_TO_BILL_NO\" id=\"L_TO_BILL_NO\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_FR0M_BILL_DATE\" id=\"L_FR0M_BILL_DATE\"\t   value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"L_TO_BILL_DATE\" id=\"L_TO_BILL_DATE\"\t   value=\"\">\t\n\t\t<input type=\"hidden\" name=\"P_FACILITY_ID\" id=\"P_FACILITY_ID\"\t   value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type=\"hidden\" name=\"L_SERV_CLASS_YN\" id=\"L_SERV_CLASS_YN\"\t   value=\"\">\n\t\t\n\t\t<input type=\"hidden\" name=\"p_session_id\" id=\"p_session_id\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"p_pgm_date\" id=\"p_pgm_date\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"p_pgm_id\" id=\"p_pgm_id\"\t   value=\"\">\n\t\t<input type=\'hidden\' name=\'todaysDate\' id=\'todaysDate\' id=\'todaysDate\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t<input type=\'hidden\' name=\'todaysDate30\' id=\'todaysDate30\' id=\'todaysDate30\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t<input type=\'hidden\' name=\'site_spec\' id=\'site_spec\' id=\'site_spec\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t<!--<input type=\"hidden\" name=\"P_LANG_ID_LOC\" id=\"P_LANG_ID_LOC\"\t   value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>-->\n\t\t<input type=\'hidden\' name=\'strLoggedUser\' id=\'strLoggedUser\' id=\'strLoggedUser\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> <!-- Added V20180720-Subha/ML-MMOH-CRF-1173 -->\n\t\t<input type=\'hidden\' name=\'siteSpecAuditReportYN\' id=\'siteSpecAuditReportYN\' id=\'siteSpecAuditReportYN\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"> <!-- Added V20180727-Subha/ML-MMOH-CRF-1173 -->\n\t\t<input type=\'hidden\' name=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\t\t\t\n\t</FORM>\t\t\n\t</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

public String subtractDays(Date date, int days) {
    GregorianCalendar cal = new GregorianCalendar();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    cal.setTime(date);
    cal.add(Calendar.DATE, -days);             
    return dateFormat.format(cal.getTime());
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Connection con1 = null;
	Connection con2 = null;//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	ResultSet rs1=null; ResultSet rs=null;
	ResultSet rs2=null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	String locale="";
	String p_facility_id="";
	String bill_number="";
	String payer_type=""; 
	String patient_id1="";
	String bill_number_code="";
	String payer=""; 
	String strPatientId="";
	String nursing_unit_code=""; String payer_code="";
	String p_module_id		= "BL" ;
	String p_report_id		= "BLRBLPRT" ;
	String p_user_name		= (String) session.getValue( "login_user" );
	String PatIDLen = "";
	String todaysDate= "";
	String todaysDate30 ="";
	//String demo_version="";//Commented against V210624
	String site_id="";
	Calendar cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Boolean siteSpec=false;
	//Added V20180720-Subha/ML-MMOH-CRF-1173/Starts
	boolean siteSpecAuditReport = false; 
	String strLoggedUser = (String) session.getValue("login_user");	
	if (strLoggedUser==null) strLoggedUser = "";
	String siteSpecAuditReportYN = "";
	//Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "";
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try{			HttpSession httpSession = request.getSession(false);
		
		con	=	ConnectionManager.getConnection(request);	
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		payer=request.getParameter("payer");
		if(payer==null || payer.equals("")) payer="";
		bill_number=request.getParameter("bill_number");
		if(bill_number==null || bill_number.equals("")) bill_number="";
		bill_number_code=request.getParameter("bill_number_code");
		if(bill_number_code==null || bill_number_code.equals("")) bill_number_code="";
		
		todaysDate = dateFormat.format(cal.getTime());		
		todaysDate30 = subtractDays(cal.getTime(),29);
		
		
		try{
			
			siteSpec= eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "ARABIC_REPORT_PRINT");
			
			if(siteSpec)
			{
				if(!("en".equalsIgnoreCase(locale)))
				{
				p_report_id="BLRBLPRT_ALMOAR";
				}
				else
				{
					p_report_id="BLRBLPRT";
				}
			}
			else
			{
				p_report_id="BLRBLPRT";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in site spec "+e);
		}
		
	  }catch(Exception eX){	
		out.println("Error= "+eX);}
	
	//Added V180201-Subha/KDAH-SCF-0472
	try {
		p_report_id = BLReportIdMapper.getBlReprintMethod(con, p_report_id, p_facility_id);
		System.out.println("Report ID " + p_report_id);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in BLReprintReportHdr.jsp for reportID "+ e);
		}

	//Added V20180720-Subha/ML-MMOH-CRF-1173/Starts
	try{
		siteSpecAuditReport= eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "REPRINT_BILL_AUDIT_TRAIL_RPRT");
		System.out.println("siteSpecAuditReport: "+siteSpecAuditReport);
		if(siteSpecAuditReport) {
			siteSpecAuditReportYN = "Y";
		}else {
			siteSpecAuditReportYN = "N";
		}
	}catch(Exception exx) {
		exx.printStackTrace();
		System.err.println("Exception in site spec "+exx);
	}
	//Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
		con2	=	ConnectionManager.getConnection(request);
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con2, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in AddModifyInsUpldImgHdr.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}finally{
			if(con2!=null) {
				ConnectionManager.returnConnection(con2, request);
			}
		}
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

            _bw.write(_wl_block6Bytes, _wl_block6);

			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				try{
					con	=	ConnectionManager.getConnection(request);	
					String site_id_sql = "select customer_id from sm_site_param ";

					Statement stmt = con.createStatement();
					 rs2 = stmt.executeQuery(site_id_sql);	

						if(rs2.next())
						{
						   site_id  =  rs2.getString(1);	
						}

					if(rs!=null)   rs2.close();
					if(stmt!=null) stmt.close();
				
				}
				catch(Exception eX)
				{	
					//out.println("Error= "+eX);	
					eX.printStackTrace();		
				}

				/* Commented against V210624
					try{ 
						con1	=	ConnectionManager.getConnection(request);	
						String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";
						
						Statement stmt2 = con1.createStatement();
						ResultSet rs3 = stmt2.executeQuery(demo_identifier_sql);	

						if(rs3.next())
						{
							demo_version  =  rs3.getString(1);	
							System.out.println("demo_identifier" +demo_version);
						}

						if(rs2!=null)   rs3.close();
						if(stmt2!=null) stmt2.close();
						con1.close();
					}
					catch(Exception eX)
					{	
						out.println("Error 1= "+eX);			
					}
				finally{
					if(con1!=null) {
						ConnectionManager.returnConnection(con1, request);
					}
				}*/

				//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
				//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) &&("N".equals(demo_version))){ 
				if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){ //removed demo_version against V210624
				
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);
	
			try{		
				 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
				 pstmt1=con.prepareStatement(sqlLen);
				 rs=pstmt1.executeQuery();
				 while(rs.next() && rs!=null)
				{
			     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
				}
				 pstmt1 = null;
				 rs = null;
				pstmt1 = con.prepareStatement( " SELECT  PATIENT_CLASS,SHORT_DESC  FROM AM_PATIENT_CLASS");
				rs = pstmt1.executeQuery();	
				System.out.println("RESULT SET :"+rs);			
				
				
			while(rs.next())
			{				
				String patientClass  =  rs.getString(1);
				String epi_type=!patientClass.substring(0, 1).equalsIgnoreCase("X")?patientClass.substring(0, 1):"R";
				String patClassShortDesc  =  rs.getString(2);						
				
				out.println("Inside while loop >> patClassShortDesc :"+patClassShortDesc);
				if(epi_type.equals("I"))
				{
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(epi_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( patClassShortDesc ));
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
				else{
			
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(epi_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( patClassShortDesc ));
            _bw.write(_wl_block17Bytes, _wl_block17);
} out.println("short desc >> patClassShortDesc :"+patClassShortDesc.substring(0, 2)); 
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			}catch(Exception e) {
				System.out.println("currency="+e.toString());
				}
			finally{
			rs.close(); 
			pstmt1.close();
			if(con!=null ) {
				ConnectionManager.returnConnection(con, request);
			}
			}
			
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bill_number));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bill_number_code));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bill_number));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bill_number_code));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
	
			//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))&&("Y".equals(demo_version))){ 
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){//removed demo_version against V210624
		
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(todaysDate30 ));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(todaysDate ));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
				else {
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(todaysDate30 ));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(todaysDate ));
            _bw.write(_wl_block39Bytes, _wl_block39);
 } 
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

		
			if(siteSpec){
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
}
				//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
				//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN) ) &&("Y".equals(demo_version))){
				if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))) {//removed demo_version against V210624				
			
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
} 
		else{
			
            _bw.write(_wl_block61Bytes, _wl_block61);
} 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block64Bytes, _wl_block64);

			//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))&&("Y".equals(demo_version))){
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){ 
			//removed demo_version against V210624
		
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(site_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(todaysDate ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(todaysDate30 ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(siteSpec ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strLoggedUser ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(siteSpecAuditReportYN ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(site3TierAlmoFeatureYN ));
            _bw.write(_wl_block81Bytes, _wl_block81);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SearchCriteria.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FromBillNumber.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ToBillNumber.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FromBillDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ToBillDate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FromBillDate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ToBillDate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillType.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.InterimBill.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DischargeBill.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UnderchargeAdvice.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VisitBill.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ExternalBill.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BOTH.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_CODE.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Include_Zero_Bill.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DetailedBillPrint.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OutstandingOnly.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SetDefaultValue.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.consolidatedBillSettlement.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NOTE.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
