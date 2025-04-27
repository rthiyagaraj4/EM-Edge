package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __frequencyaddmodifyutility extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/FrequencyAddModifyUtility.jsp", 1729845080000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<script>\n\nfunction numDotOnly()\n{\n\t if(((event.keyCode>=48)&&(event.keyCode<=57))||(event.keyCode==46))\n\t {\n\t\tevent.keyCode=event.keyCode;\n\t }\n\t \n\t else\n\t {\n\t   event.keyCode=0;\n\t  \n\t }\n}\n\n</script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\'javascript\' src=\'../../eOR/js/ScheduleFrquency.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onLoad=\'window.parent.chkDefIntl()\' OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\"scheduleFreqencyAddMod\" id=\"scheduleFreqencyAddMod\" action=\"\" method=\"post\" >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<input type=\"hidden\" name=\"repeat\" id=\"repeat\"\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table border=\"0\" id=\"headerTab\" cellpadding=3 cellspacing=0 width=\"100%\" class=\"grid\">\n\t<tr>\n\t\t<td colspan=\"7\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" - (";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\n\t\t</td>\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td colspan=\"2\" class=\"gridData\"  style=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</B>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<td colspan=\"5\" class=\"gridData\"  style=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\t\t\t\n\t</tr>\n\t<tr>\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<td width=\"5%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<td width=\"5%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td width=\"5%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t\t<td width=\"10%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t<td width=\"15%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t<td width=\"10%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\t\n\t\t<td width=\"55%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\t\n\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<tr>\n\t\t<td width=\"5%\" class=\"\"  style=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">&nbsp;&nbsp;</td>\n\t\t<td>\n\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onclick=\"pasteSchdDetails()\">\n\t\t</td>\n\t</tr>\n\t<tr>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<td width=\"5%\" class=\"\"  style=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"><b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</b></td>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td width=\"5%\" class=\"gridData\"><input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"chk";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<td width=\"5%\" class=\"gridData\"><label name=\"Repeat";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="<input type=\"hidden\" name=\"repeat";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"repeat";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></td>\n\t\t\t<td width=\"5%\" class=\"gridData\">\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<input type=\"hidden\" name=\"admin_day";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"admin_day";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" value=\"0\">\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<select name=\"admin_day";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" onchange = \"changeScheduleDates(this,\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\">\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" \n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\tselected\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\t\t\t>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\t\t\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</select>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<td width=\"10%\" class=\"gridData\">Sliding Scale\n\t\t\t\t\t<input type=\"hidden\" name=\"qty";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"qty";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t    </td>\t\t\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t <td width=\"10%\" class=\"gridData\"><input type=\"text\" size=\"8\" maxlength=\'7\' class=\"NUMBER\" onBlur=\'parent.OrIsValidDecimal(this);parent.chkQty(this,\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\");formatNumber(this)\' onKeyPress=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' name=\"qty";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'  ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" onPaste=\'return checkNumbers(this);\'></td><!---OnPaste is inserted in the field,which is used to avoid the values to be pasted,//Issue No:27384 by Maheshwaran.K as on 21/06/2011-->\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t<td width=\"15%\" class=\"gridData\"><label name=\"uom";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t<td width=\"10%\" class=\"gridData\"><input type=\"text\" size=\"5\" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" onBlur=\"parent.timeChk(this);parent.defaultStartTime();changeScheduleDates(admin_day";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =",\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\tstoretime(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\',this,\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\',\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\');";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"  maxlength=\"5\" name=\"time";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"  value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"></td>\n\t\t\t\t<td width=\"55%\" class=\"gridData\" id=\"dispalySchedule";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t<a href=\"#\" onclick=\"showScheduleDates(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\')\">Schedule</a>\n\t\t\t\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t<table class=\'gridComponentHolder\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t</td>\t\n\t\t\t</tr>\t\n\t\t\t\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\t<tr><td colspan=\"5\">\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t</td></tr>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n</table>\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"><!-- Added by Ambiga.M on 2/4/2010 for 18855 -->\n<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\"hidden\" name=\"durationType\" id=\"durationType\"\tvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\"hidden\" name=\"chkDaysUpdate\" id=\"chkDaysUpdate\"\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\"hidden\" name=\"start_time_round_p\" id=\"start_time_round_p\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\"hidden\" name=\"start_time_assign_p\" id=\"start_time_assign_p\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\"hidden\" name=\"code\" id=\"code\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_id_caller\" id=\"bean_id_caller\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_name_caller\" id=\"bean_name_caller\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<INPUT TYPE=\"hidden\" name=\"freq_code\" id=\"freq_code\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<INPUT TYPE=\"hidden\" name=\"freqLegend\" id=\"freqLegend\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<INPUT TYPE=\"hidden\" name=\"Interval_value\" id=\"Interval_value\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<!-- For PH Only -->\n<INPUT TYPE=\"hidden\" name=\"max_qty\" id=\"max_qty\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<INPUT TYPE=\"hidden\" name=\"chk_max\" id=\"chk_max\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<INPUT TYPE=\"hidden\" name=\"unit_qty\" id=\"unit_qty\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<INPUT TYPE=\"hidden\" name=\"chk_unit\" id=\"chk_unit\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n<INPUT TYPE=\"hidden\" name=\"split_dose_yn\" id=\"split_dose_yn\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<INPUT TYPE=\"hidden\" name=\"split_qty\" id=\"split_qty\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n <!-- For Order Entry Only -->\n<INPUT TYPE=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<INPUT TYPE=\"hidden\" name=\"future_order_date\" id=\"future_order_date\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n<INPUT TYPE=\"hidden\" name=\"past_order_date\" id=\"past_order_date\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n<!-- Start Time Param passed by order entry function -->\n<INPUT TYPE=\"hidden\" name=\"start_day_param\" id=\"start_day_param\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n<INPUT TYPE=\"hidden\" name=\"start_time_param\" id=\"start_time_param\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n<INPUT TYPE=\"hidden\" name=\"start_day_param_request\" id=\"start_day_param_request\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n<INPUT TYPE=\"hidden\" name=\"start_time_param_request\" id=\"start_time_param_request\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<INPUT TYPE=\"hidden\" name=\"today\" id=\"today\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n<INPUT TYPE=\"hidden\" name=\"todayTime\" id=\"todayTime\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n<INPUT TYPE=\"hidden\" name=\"todayDate\" id=\"todayDate\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n<INPUT TYPE=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n<INPUT TYPE=\"hidden\" name=\"row_value\" id=\"row_value\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n<INPUT TYPE=\"hidden\" name=\"loadFlag\" id=\"loadFlag\"  value=\"YES\">\n<INPUT TYPE=\"hidden\" name=\"dummmyDate\" id=\"dummmyDate\"  value=\"\">\n<input type=\"hidden\" name=\"start_day_assign\" id=\"start_day_assign\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\"hidden\" name=\"start_time_assign\" id=\"start_time_assign\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n<input type=\"hidden\" name=\"pr_duration\" id=\"pr_duration\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<input type=\"hidden\" name=\"pr_duration_type\" id=\"pr_duration_type\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n<input type=\"hidden\" name=\"isSchdApplicable\" id=\"isSchdApplicable\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n<input type=\"hidden\" name=\"catalog_code\" id=\"catalog_code\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n</form>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n</body>\n</html>\n\n\n\n\n\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


private String decodeLocal(String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}

	//Duration Type
	if(objVal.trim().equalsIgnoreCase("N"))		
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		return	returntext;
	}

	if(objVal.trim().equalsIgnoreCase("C"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Closest.label","am_labels");
		return	returntext;
	}

	if(objVal.trim().equalsIgnoreCase("P"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		return	returntext;
	}
	//start_time_round_p
	if(objVal.trim().equalsIgnoreCase("TM"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.10thminute.label","am_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("FM"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.5thminute.label","am_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("QH"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QuarterHour.label","or_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("H"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Hourly.label","am_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("M"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels");
		return	returntext;
	}
	else
	return "";
}

private int isAfterTime(String fromObj,String toObj)
{
	int retVal = 0;
	fromObj = fromObj.trim();
	toObj = toObj.trim();

	if(fromObj.indexOf(":") != -1 && toObj.indexOf(":") != -1 )
	{
		String tempobj1[] = fromObj.split(":");
		String tempobj2[] = toObj.split(":");
		int temp1 = Integer.parseInt(tempobj1[0]);
		int temp2 = Integer.parseInt(tempobj2[0]);
		int temp3 = Integer.parseInt(tempobj1[1]);
		int temp4 = Integer.parseInt(tempobj2[1]);	

		if(temp1 > temp2)
		{
			retVal = -1;		
		}
		else if(temp1 < temp2)
		{
			retVal = 1;
		}
		else if(temp1 == temp2)
		{
			if(temp3 > temp4 )
			{
				retVal = -1;		
			}
			else if(temp3 < temp4)
			{
				retVal = 1;
			}
			else
				retVal = 0;
		}
	}
	return retVal;
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

/* Mandatory checks start */
	String bean_id	= "OrScheduleFreq" ;
	String bean_name= "eOR.ScheduleFrequencyCompBean";

	OrderEntryBean beanEntry				= (OrderEntryBean)getBeanObject( "orderentrybean", "eOR.OrderEntryBean", request ) ;
	

	String bean_id1= request.getParameter("bean_id");
	String bean_name1= request.getParameter("bean_name");
	String catalog_code= request.getParameter("catalog_code");
	String mode		=  "1" ;
	String uom_code		=  "" ;
	String strDose = "";
	String Interval_value			= "";
	
	boolean isSchdApplicable = true;
	HashMap schdMap = null;


	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	String qtyDisabled		    =  ""; //Disable in modify mode

/* Mandatory checks end */

	/* Initialize Function specific start */	
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		beanEntry				= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;
		beanEntry.setLanguageId(localeName);
		 qtyDisabled		=  "disabled";
	}

	ScheduleFrequencyCompBean bean = (ScheduleFrequencyCompBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

	/******Caller Bean name and id*******/
	String bean_id_P			= request.getParameter("bean_id");
	String bean_name_P			= request.getParameter("bean_name");	
	
	/**************/
try
{

	/*Parameters Passed*/
	String freq_code			=bean.checkForNull( request.getParameter("freq_code"));
	String freq_code_temp			=bean.checkForNull( request.getParameter("freq_code"));
	String facility_id			=bean.checkForNull( request.getParameter("facility_id"));
	String durationType_P		= bean.checkForNull(request.getParameter("interval_durn_type"));
	String pr_duration		= bean.checkForNull(request.getParameter("pr_duration"));
	
	if(pr_duration == null || pr_duration.equals("") || pr_duration.equals("null"))
		pr_duration = "1";
	
	String pr_duration_type		= bean.checkForNull(request.getParameter("pr_duration_type")); 	
	/*Added by Uma on 11/26/2009 for IN003477*/
	String schd_from		= bean.checkForNull(request.getParameter("schd_from"));
	
	if(schd_from.equalsIgnoreCase("header"))
	{
		 durationType_P		= bean.checkForNull(request.getParameter("hdr_interval_durn_type"));
		 pr_duration_type	= bean.checkForNull(request.getParameter("hdr_pr_duration_type")); 	
		 freq_code			= bean.checkForNull( request.getParameter("hdr_freq_code"));
		  pr_duration			=request.getParameter("hdr_duration_value")==null?"1":request.getParameter("hdr_duration_value");
		 if(pr_duration == null || pr_duration.equals(""))
			pr_duration = "1";
		 
	}
	/*Ends Here for IN003477*/

	String code					= bean.checkForNull(request.getParameter("code"));
	String row_value			=bean.checkForNull( request.getParameter("row_value"));
	String module_id			= bean.checkForNull(request.getParameter("module_id"));
	String order_category		= bean.checkForNull(request.getParameter("order_category"));
	String visit_adm_date		= bean.checkForNull(request.getParameter("visit_adm_date")); 	
	String future_order_date	= bean.checkForNull(request.getParameter("future_order_date"));	
 	String past_order_date		= bean.checkForNull(request.getParameter("past_order_date"));
	
	int	   indxTime				= 0;
    String start_day_param		= "";
    String start_day_param_request= "";
    String start_time_param		= "";  
    String start_time_param_request	= "";  

	//Taking values for start day and time
	String start_time_day_param	= bean.checkForNull(request.getParameter("start_time_day_param"));
		
	if(start_time_day_param!=null && !start_time_day_param.trim().equals(""))
	{
	    indxTime				= start_time_day_param.indexOf(" ");
	    start_day_param			= start_time_day_param.substring(0,indxTime);
	    start_day_param_request	= start_time_day_param.substring(0,indxTime);
	    start_time_param		= start_time_day_param.substring(indxTime+1);			
	    start_time_param_request= start_time_day_param.substring(indxTime+1);			
	}
	//For Ph
	String max_qty				= bean.checkForNull(request.getParameter("max_qty"));
	String chk_max				= bean.checkForNull(request.getParameter("chk_max"));
	String unit_qty				= bean.checkForNull(request.getParameter("unit_qty"));
	String chk_unit				= bean.checkForNull(request.getParameter("chk_unit"));
	String split_dose_yn		= bean.checkForNull(request.getParameter("split_dose_yn"));
	String split_qty			= bean.checkForNull(request.getParameter("split_qty"));
	String uom_desc				= bean.checkForNull(request.getParameter("uom_desc"));
   	String fract_value_yn				= bean.checkForNull(request.getParameter("fract_value_yn"));
   	String sliding_scale_yn				= bean.checkForNull(request.getParameter("sliding_scale_yn"));
	
	 mode						= bean.checkForNull(request.getParameter( "mode" ),"1");

	/******Today date and time form database or bean*********/
	String start_day_assign     = "";
	String start_time_assign	= "";

	/*******Fields to Diable the diable / hide and show depending on module and the mode passed*******/
	String freqLegendStyle		= "";
	String daysDisabled         =  ""; //Show when duration type is Week
	String timeDisabled         =  ""; //Disable in modify mode	
	String StartTimeEnabled		=  ""; // Disable in modify mode
	String startTimeStyle	    =  ""; // To show table for start time --Not shown in modify mode
	String startTimeDayStyle   	= "display:none"; //Show only in case where admin_day_time is D;
	String daysTabStyle			 = ""; //To Show the DAYS TABLE
	String qtyTabStyle			 = "display:none" ;	//To Show the  QTY TABLE


	/********GET TODAYS DAY,TIME AND DAY NO IN SM_DAY_OF_WEEK ************/
	HashMap today_date_time	  = bean.getDay();
	String  today			  = (String)today_date_time.get("day_no");
	String  todayTime		  = (String)today_date_time.get("day_time");
	String  todayDate		  = (String)today_date_time.get("day_date");
      todayDate=com.ehis.util.DateUtils.convertDate(todayDate,"DMY","en",localeName);

	//Values passed either form database or by bean
	String dt					 = ""; //time
	String dq					 = "";//qty
	//int repeat					 = 0;

	// Cahnges Made by Sridhar Reddy for SRR20056-CRF-0274
	ArrayList<Integer> durationList = new ArrayList<Integer>();
	ArrayList day_list	= new ArrayList();
	ArrayList day_names	= new ArrayList();
	ArrayList time_list	= new ArrayList();
	ArrayList dose_list	= new ArrayList();
	ArrayList temp_list	= new ArrayList();
	ArrayList final_list	= new ArrayList();
	HashMap hdr_data =  new 	HashMap();
	String fract_allow_yn	 = "";
	// End SRR20056-CRF-0274

	if(mode!=null && mode.trim().equals("2"))
	{
		 daysDisabled       =  "disabled";
		 timeDisabled       =  "disabled";
		 qtyDisabled		=  "disabled";
		 startTimeStyle		=  "display:none";
		 StartTimeEnabled   =  "disabled";
	}

	if(module_id!=null && module_id.trim().equalsIgnoreCase("PH"))
	{
		startTimeStyle		=  "display:none";
		dq					=	split_qty ;
		if(split_dose_yn!=null && split_dose_yn.trim().equalsIgnoreCase("N"))
		{
			qtyDisabled		=  "disabled";
		}
	}

	if(order_category!=null && order_category.trim().equalsIgnoreCase("PH")&&(mode!=null) && mode.trim().equals("2"))
	{
		sliding_scale_yn=(String)bean.getSlidingScaleYN(code,row_value);
	}

	if(!uom_desc.equals(""))
	{
		uom_desc = (String)bean.getUomDesc(uom_desc);
	}	
	/*********BEAN OF CALLER FUNCTION IS INSTANTIATED AND VALUES FOR FREQ LOADED ****/
	
	Object beanCaller			 =  getBeanObject(bean_id_P,bean_name_P,request);
	SceduleFreqeuncyInterface rec= (SceduleFreqeuncyInterface)beanCaller ;
	ArrayList str = new ArrayList();

	if(schd_from.equalsIgnoreCase("header"))
	{
		str = bean.load(freq_code,facility_id);
	}
	else
	{
		str =rec.getScheduleFrequencyStr(code,row_value);
	}

	String freqLegend			= "";	
    StringBuffer timeLegend=new StringBuffer();
	//String admin_day_or_time	= "";

	/***To Show time Table ********/

	//StringBuffer hrsHtml= new  StringBuffer();
	/***To Show Qtye Table ********/
	//StringBuffer qtyHtml=new StringBuffer();
    StringBuffer daysHtml=new StringBuffer();
	//String daysHtmlUpdate		= "";
	String chkDaysUpdate		= "|"; //To Concanete the Days Checked values passed from bean or DataCase and used by javascript on laod to chech the  chkeck boxes	
	//String daysSelected			= "";
	//Values retrieved form am_frequency depending on freq code passed
	String freqLegend_P			 = "";
	String repeatValue_P	     = "0";
	String start_time_round_p	 = "";
	String start_time_assign_p	 = "";

	//int counter					 = 0;
	if(module_id!=null && module_id.trim().equalsIgnoreCase("PH") ||( module_id.trim().equalsIgnoreCase("OR") &&  order_category!=null && order_category.trim().equals("PH")))
		qtyTabStyle = "";


	/**Queried from dataBase and build HTML TO shows days check Box onstructed**/
	HashMap	  days					= (HashMap)bean.getComboOptions("day");
	ArrayList daysArray				= (ArrayList)days.get("value");
	ArrayList daysInsertArray		= (ArrayList)days.get("Description");

	Iterator  iterateDays			= daysArray.iterator() ;
	Iterator  iteratedaysInsert		= daysInsertArray.iterator() ;
	daysHtml.append("");

	int i =0;

	while(iterateDays.hasNext() && iteratedaysInsert.hasNext() )
	{
		i++;
		//String day		   =	(String)
		iterateDays.next() ;
		//String daySMInsert = (String)
		iteratedaysInsert.next() ;
	}
	//To get no of Repeats,start time assign/round and freq Legend ....for a particulay freq_code
	 ArrayList  freqValues	= null ;

	 freqValues				= bean.getFreqValues(freq_code);


	 if(freqValues.size()>0)
	{
		 String durn_desc			= (String)freqValues.get(4);
		 String for_text			= (String)freqValues.get(5);
		 Interval_value			= (String)freqValues.get(6);
		 String durn_desc_type			= (String)freqValues.get(7);
		 durationType_P			= (String)freqValues.get(1)==null?"":(String)freqValues.get(1);
		
		 repeatValue_P			= (String)freqValues.get(0)==null?"0":(String)freqValues.get(0);	 
		
		freqLegend_P			=  repeatValue_P+" "+(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RepeatsPer.label","am_labels")+durn_desc+" "+for_text+" "+(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Every.label","common_labels")+" "+Interval_value+" "+durn_desc_type;
		
		 freqLegend				    = freqLegend_P;
		 
		 start_time_round_p	= (String)freqValues.get(2);
		 start_time_assign_p	= (String)freqValues.get(3);
	}
   
   	 //In case of hours and Minutes take only minutes show only mintues part
	if(durationType_P!=null && (durationType_P.trim().equalsIgnoreCase("H") || durationType_P.trim().equalsIgnoreCase("M")) )
	{
		todayTime = todayTime.trim() ;
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(repeatValue_P));
            _bw.write(_wl_block10Bytes, _wl_block10);

	 ArrayList rs          = null ;
	 ArrayList dateList = null;
	 ArrayList dayList = null;
	 HashMap dataMap = null;
	 if(str == null || str.size() <= 0 )
	 rs = bean.load(freq_code,facility_id);	//Get the Values for TIME AND DAYS feilds form am_frequncy if bean does not pass the values
	 else
	 rs = str ;	 //VALUES RETRIEVED FORM CALLING  FUNCTION	--BEAN

	// int k= 0;
	 String TimeRoundedto=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TimeRoundedto.label","or_labels")+" ";
  
	if(rs != null && rs.size() > 0)
	{// records fetched  --from dataBase/Or during subsequent modification

		hdr_data = (HashMap)rs.get(0);
		day_list	= (ArrayList)rs.get(1);
		day_names	= (ArrayList)rs.get(2);
		time_list	= (ArrayList)rs.get(3);
		dose_list	= (ArrayList)rs.get(4);
		if(dose_list.size() > 0)
		{	 
			for(int k=0;k<Integer.parseInt(repeatValue_P);k++)
			{		
				strDose = (String)dose_list.get(k);
				
				if(strDose.equals(""))
					dose_list.add(k,split_qty);
			}	
		 }
	start_day_assign  = bean.checkForNull((String)hdr_data.get("start_date_time"));
	hdr_data.put("durationType",durationType_P);
/*	hdr_data.put();
	hdr_data.put();*/

	if(start_day_assign.equals(""))
	{
		hdr_data.put("start_date_time",start_day_param);
		start_day_assign = start_day_param;
	}

	//This is just to remove the last character "|" concanted
	chkDaysUpdate = chkDaysUpdate.substring(0,chkDaysUpdate.length()-1);
	timeLegend.append(TimeRoundedto+decodeLocal(start_time_assign_p,pageContext)+ " "+decodeLocal(start_time_round_p,pageContext));
	
  }
  else
  {//NO RECORDS FETCHED	FORM DATABASE -- FOR FIRST TIME CLIENT VISIT

		if(durationType_P!=null && !durationType_P.equalsIgnoreCase("W"))
		{
			daysTabStyle		 = "display:none";
			freqLegendStyle		 ="";
			startTimeDayStyle = "";
		}
		else
		{
			startTimeDayStyle = "";
		}	   
		timeLegend.append(TimeRoundedto+decodeLocal(start_time_assign_p,pageContext)+ " "+decodeLocal(start_time_round_p,pageContext));
	
		/**Builds Time's Html***/
		for(int m= 1; m <= Integer.parseInt(repeatValue_P); m++)
		{
			if(bean_name1.equals("eOR.OrderEntryBean"))
			{
				dt="";
				if(beanEntry.getTempvalue("time"+m+catalog_code+freq_code)!=null)
					dt=beanEntry.getTempvalue("time"+m+catalog_code+freq_code);
			}	         
		}
  }	//End of Else

if(fract_value_yn.equals("Y"))
{
	fract_allow_yn = "return allowValidFreqNumber(this,event,8,4);";
}
else
{
	fract_allow_yn = "return allowValidFreqNumber(this,event,4,0);";
}

if(durationType_P.equals("W"))
{
	durationList.clear(); 
	for(int z = 1;z<=7;z++) 
		durationList.add(z);
}
else if(durationType_P.equals("L"))
{
	durationList.clear(); 
	for(int y = 1;y<=30;y++) 
		durationList.add(y);
}

hdr_data = (HashMap)rs.get(0);
day_list	= (ArrayList)rs.get(1);
day_names	= (ArrayList)rs.get(2);
time_list	= (ArrayList)rs.get(3);
dose_list	= (ArrayList)rs.get(4);

if((schd_from.equalsIgnoreCase("header"))&&(freq_code_temp.equals(freq_code)))
{
	ArrayList scdstr = rec.getScheduleFrequencyStr(code,row_value);
    if(scdstr!=null)
	{
		temp_list	= (ArrayList)scdstr.get(4);
		for(int dl=0;dl<dose_list.size();dl++)
		{
			dose_list.get(dl);
			
			if((temp_list.size())>(dl))
			{ 
				final_list.add(dl,temp_list.get(dl));			
			}
			else
			{
				final_list.add(dl,dose_list.get(dl));
			}
		}
		dose_list = final_list;
	}
}

 if(uom_desc.equals(""))
{
	uom_code = hdr_data.get("uom_code") == null ? "":(String)hdr_data.get("uom_code");		
	if(!uom_code.equals(""))
	{
		uom_desc = (String)bean.getUomDesc(uom_code);
	}
}

if(start_day_param.equals(""))
	start_day_param = start_day_param;

if(start_time_param.equals(""))
	start_time_param = start_time_param;

if(pr_duration == null || pr_duration.equals(""))
{
	pr_duration = "1";	
}

HashMap paramMap = new HashMap();
paramMap.put("start_day_param",start_day_param);
paramMap.put("duration",pr_duration);
paramMap.put("duration_type",pr_duration_type);
paramMap.put("durationType",durationType_P);
paramMap.put("repeat",repeatValue_P);
paramMap.put("Interval_value",Interval_value.equals("")?"1":Interval_value);
paramMap.put("start_time_param",start_time_param);
paramMap.put("start_time_param",start_time_param);
if(day_list.size()==0)
{
	Connection con = null;
	try 
	{  
		con	= ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		
		String sqlQuery = "SELECT a.admin_day_or_time, a.admin_day,TO_CHAR (admin_time, 'HH24:MI') admin_time     FROM am_frequency_admin_day_time a WHERE a.freq_code = ? AND admin_facility_id =nvl((select  admin_facility_id from am_frequency_admin_day_time where   freq_code = a.freq_code and admin_facility_id = ? and rownum=1),'*A') ORDER BY to_number(ADMIN_DAY), admin_time ";
		if(time_list.size()==0){		
		pstmt =	con.prepareStatement(sqlQuery);
		pstmt.setString(1,freq_code);
		pstmt.setString(2,facility_id);
		rs1 = pstmt.executeQuery();
	
		while(rs1.next())
		{
			time_list.add(rs1.getString("admin_time"));
			day_list.add("1");
			durationList.add(1);
			dose_list.add(1);
		
		}

		if(rs1 != null)rs1.close();
		if(pstmt != null)pstmt.close();
	}
 }
 catch(Exception ex)
 {
	ex.printStackTrace(); 
 }
 finally
 {
	if(con!=null)
			ConnectionManager.returnConnection(con,request);
 }

}
ArrayList paramList = new ArrayList();
paramList.add(paramMap);
paramList.add(day_list);		

if(day_list.size() > 0)
{
	HashMap dates_map = (HashMap)beanEntry.getScheduleDates(paramMap,day_list,time_list);
	if(dates_map!= null && dates_map.size() > 0)
	{
		rec.setScheduleDates(dates_map);
		schdMap =(HashMap) rec.getScheduleDates();
	}
}

if(sliding_scale_yn.equalsIgnoreCase("Y")) 
{
	uom_desc = "";

}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(freqLegend));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(timeLegend.toString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		/*String freqTiming = "";
		String currDate=com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);	
		if(time_list!=null && time_list.size()>0 )		
			freqTiming=(String)time_list.get(0);
		String freq_time_calc=currDate+" "+freqTiming;
		String freq_date="";
		ArrayList dateList1=new ArrayList();
	
		if(schdMap!= null && schdMap.size() > 0)
		{			
			for(int x=1; x<=Integer.parseInt(repeatValue_P); x++)
			{			
				dataMap = (HashMap)schdMap.get(x);
				dateList = (ArrayList)dataMap.get("DATES");
				if(dateList!=null && dateList.size() > 0)
				{
					for(int y=0; y < dateList.size(); y++)	
					{
						dateList1.add(dateList.get(y));
					}
				}
			}
		}		
		Object dateArr[]=dateList1.toArray();
		String minSchdate="";
		if(dateArr.length>0)
		{
		 minSchdate=(String)dateArr[0];
			for(int z=0; z < dateArr.length; z++)	
			{	if(!minSchdate.equalsIgnoreCase((String)dateArr[z]))
				{
					if(com.ehis.util.DateUtils.isAfter(minSchdate,(String)dateArr[z],"DMY", localeName))
						minSchdate=(String)dateArr[z];
				}
			}
		}
	
		if(!(minSchdate.equals("") && start_day_param_request.equals("")))
		{
			freq_date=minSchdate;
			if(com.ehis.util.DateUtils.isAfter(currDate,start_day_param_request,"DMY", localeName)  && com.ehis.util.DateUtils.isAfter(freq_date,start_day_param_request,"DMY", localeName))
			{
				if(!freq_date.equalsIgnoreCase(start_day_param_request))
				{
					start_day_param=freq_date;
					start_time_param="00:00";
				}
			}
		}*/			 
		
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start_day_param));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start_time_param));
            _bw.write(_wl_block19Bytes, _wl_block19);

		if(mode.equalsIgnoreCase("1") && !(sliding_scale_yn.equalsIgnoreCase("Y")))
		{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block21Bytes, _wl_block21);

		}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

		if(!durationType_P.equals("D"))
		{

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

		}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

	if(mode.equalsIgnoreCase("1") && !(sliding_scale_yn.equalsIgnoreCase("Y")))
	{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PasteDetails.label","or_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);

		if(mode.equalsIgnoreCase("1"))
		{
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

		}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
	
	}	
	//ArrayList dateList = null;
	//ArrayList dayList = null;
	//HashMap dataMap = null;
	if(schdMap!= null && schdMap.size() > 0)
	{			
		for(int x=1; x<=Integer.parseInt(repeatValue_P); x++)
		{			
			dataMap = (HashMap)schdMap.get(x);
			dateList = (ArrayList)dataMap.get("DATES");
			dayList = (ArrayList)dataMap.get("DAYS");			

            _bw.write(_wl_block38Bytes, _wl_block38);

			if(mode.equalsIgnoreCase("1") && !(sliding_scale_yn.equalsIgnoreCase("Y")))
			{

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(x));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(x));
            _bw.write(_wl_block41Bytes, _wl_block41);

			}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(x));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(x));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(x));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(x));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(x));
            _bw.write(_wl_block47Bytes, _wl_block47);

			if(durationType_P.equals("D"))
			{

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(x));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(x));
            _bw.write(_wl_block50Bytes, _wl_block50);

			}
			else 
			{

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(x));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(x));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(daysDisabled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(x));
            _bw.write(_wl_block54Bytes, _wl_block54);

				for(int dayNum : durationList) 
				{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(dayNum));
            _bw.write(_wl_block56Bytes, _wl_block56);

					if(Integer.parseInt(((String)day_list.get(x-1))) == dayNum )
					{

            _bw.write(_wl_block57Bytes, _wl_block57);

					}

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dayNum));
            _bw.write(_wl_block59Bytes, _wl_block59);

				}

            _bw.write(_wl_block60Bytes, _wl_block60);

			}

            _bw.write(_wl_block61Bytes, _wl_block61);

			if(sliding_scale_yn.equalsIgnoreCase("Y")) 
			{
				String dose_qty_list = (String)dose_list.get(x-1).toString();
				if(!(dose_qty_list.equals("")))
				{
				   if(dose_qty_list.indexOf(".")== 0)
					dose_qty_list = "0"+dose_qty_list;
				}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(x));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(x));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dose_qty_list));
            _bw.write(_wl_block65Bytes, _wl_block65);
	
			}
			else
			{
				String dose_qty_list = (String)dose_list.get(x-1).toString();
				if(!(dose_qty_list.equals("")))
				{
				   if(dose_qty_list.indexOf(".")== 0)
					dose_qty_list = "0"+dose_qty_list;
				}

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(fract_value_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(fract_allow_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(x));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dose_qty_list));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(qtyDisabled));
            _bw.write(_wl_block70Bytes, _wl_block70);
				
			}

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(x));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(timeDisabled));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(x));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(x));
            _bw.write(_wl_block75Bytes, _wl_block75);

			if(bean_name1.equals("eOR.OrderEntryBean"))
			{

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(x));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(x));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf((String)time_list.get(x-1)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(x));
            _bw.write(_wl_block10Bytes, _wl_block10);

						
					if(dateList != null && dateList.size() > 5)
					{

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean_id_P));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bean_name_P));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(x));
            _bw.write(_wl_block84Bytes, _wl_block84);
	
					}
					else
					{ 
						String dateSytle = "style='height:18px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;color: #000000;font-weight:normal;	text-align:left;	padding-left:10px;padding-right:10px;vertical-align:middle;'";
						String daySytle = "style='height:18px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;color: #990000;font-weight:bold;	text-align:center;padding-left:10px;padding-right:10px;vertical-align:middle;'";
						StringBuffer dispalySchd = new StringBuffer();
						StringBuffer weekName = new StringBuffer();

						for(int n =0;n<dateList.size();n++)
						{ 
							dispalySchd.append("<td "+dateSytle+">"+dateList.get(n)+"</td>");	
							weekName.append("<td "+daySytle+">"+dayList.get(n)+"</td>");					
						} 

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dispalySchd.toString()));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(weekName.toString()));
            _bw.write(_wl_block87Bytes, _wl_block87);
		
					}						

            _bw.write(_wl_block88Bytes, _wl_block88);
	
	
		}	
	}
	else
	{
	
		isSchdApplicable = false;

            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

	}


            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(durationType_P));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(chkDaysUpdate));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(start_time_round_p));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(start_time_assign_p));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(request.getParameter("code")));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bean_id_P));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bean_name_P));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(freqLegend));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(Interval_value));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(max_qty));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(chk_max));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(unit_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(chk_unit));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(split_qty));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(future_order_date));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(past_order_date));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(start_day_param));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(start_time_param));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(start_day_param_request));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(start_time_param_request));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(today));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(todayTime));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(todayDate));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(request.getParameter("row_value")));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(start_day_param));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(start_time_assign));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(pr_duration));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(pr_duration_type));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(isSchdApplicable));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block10Bytes, _wl_block10);

if(bean_name1.equals("eOR.OrderEntryBean"))
{

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(bean_id1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(bean_name1));
            _bw.write(_wl_block10Bytes, _wl_block10);

}
}
catch(Exception e)
{
	 e.printStackTrace();
}

            _bw.write(_wl_block130Bytes, _wl_block130);

 	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block131Bytes, _wl_block131);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Repeat.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.UOM.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Copy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NOSCHEDULE.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
