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
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ormultipatientordersresultingmainresultvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORMultiPatientOrdersResultingMainResultValues.jsp", 1736222688000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head><title>MultiPatientOrdersResultingHdr</title>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/ORMultiPatientOrdersResultingReport.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script><!-- used for date validation-->\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction checkValid(obj,event,val1,val2) \n{\n\tif (event.keyCode == 13) \n\t{\n\t\tevent.keyCode = \"\";\n\t\treturn;\n\t} \n\telse \n\t{\n\t\treturn allowValidNumber(obj,event,val1,val2);\n\t}\n}\n\n\nfunction validateDateWithTime(obj)\n{\n\tif(!doDateTimeChk(obj))\n\t{\n\t\tif(obj.value!=\'\')\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\nfunction doDateTimeChk(obj)\n{\n\tif(obj.value.indexOf(\'.\') !=-1 || obj.value.indexOf(\'-\') !=-1)\n\t{\n\t\tretval= false\n\t}\n\telse\n\t{\n\t\tvar comp=obj\n\t\tobj=obj.value\n\t\tvar dttime = obj.split(\" \");\n\t\tvar dt\n\t\tvar time\n\t\tvar retval=true\n\t\tif(dttime.length>1)\n\t\t{\n\t\t\tdt=dttime[0]\n\t\t\ttime=dttime[1]\n\t\t\tif(!checkDt(dt) )\n\t\t\t{\n\t\t\t\tretval= false\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(time==null || time==\"\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\t\t\tretval= false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(!chkTime(time))\n\t\t\t\t\t{\n\t\t\t\t\t\t\tretval= false\n\t\t\t\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tretval= false\n\t\t}\n\t}\n\treturn retval\n}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollFrame();callScrollLeft();\' onResize=\'alignDivs()\'>\n<form name=\"multiPatientORMainResultValues\" id=\"multiPatientORMainResultValues\">\n\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t<table border=\'0\' width=\'100%\' id=\'dataTitleTable\' >\n\t\t<TR>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td class=\"COLUMNHEADER\" style=\"width: 240px;\" nowrap>\n\t\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td >\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</TR>\n\t\t<TR>\n\t\t\t<td colspan=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">&nbsp;\n\t\t\t</td >\n\t\t</TR>\n\t</table>\n</div>\n<div id=\"prevNext\" style=\'postion:relative\'>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\' >\n\t<tr align=\'right\' width=\'10%\'>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<td class=\'WHITE\' width=\'89%\'>&nbsp;</td>\n\t\t<td width=\'11%\'>\n\t\t<A HREF=\'javascript:onClick=submitPage(\"Previous\");\' text-decoration=\'none\' class=\"gridLink\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</A>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<td class=\'WHITE\' width=\'94%\'>&nbsp;</td>\n\t\t<td width=\'6%\'>\n\t\t<A HREF=\'javascript:onClick=submitPage(\"Next\");\' text-decoration=\'none\' class=\"gridLink\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</tr>\n</table>\n</div>\n<table width=\"100%\" border=0 id=\'dataTable\' style=\"border-bottom:#ffffff\">\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<TR>\n\t\t\t<TD class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" colspan=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">&nbsp;&nbsp;</TD>\n\t\t</TR>\n\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" value=\" id=\"order_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" value=\" id=\"order_line_num";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" value=\"\">\n\t\t<input TYPE=\"hidden\" name=\"srv_status";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"srv_status";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value=\"Normal\">\n\t\t<input TYPE=\"hidden\" name=\"rslt_type";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"rslt_type";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" value=\"\">\n\t\t<TR VALIGN=\"BOTTOM\" style=\"height: 25px;\">\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<input type=\"hidden\" name=\"srv_stat";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"srv_stat";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"N\">\n\t\t\t<TD class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" style=\"width:240px;\" nowrap valign=\"center\">\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<input type=\"text\" name=\"date_hour_type";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"date_hour_type";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=\"\" size=\"14\" maxlength=\"16\" onBlur=\"validDateObj1(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');changeColorIfDiff(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');setHeaderValue1(this,\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\" onChange=\"changeColorIfDiff(this,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\"  onKeyPress=\'return OrAllowDateHourFormat()\'> <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_hour_type";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',null,\'hh:mm\');\" style=\'cursor:pointer\'> \n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<input type=\"text\" name=\"date_type";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"date_type";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\"\" size=\"10\" maxlength=\"10\"  onBlur=\"CheckDate(this);changeColorIfDiff(this,\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\" onKeyPress=\'return OrAllowDateFormat()\'> <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_type";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\" style=\'cursor:pointer\'> \n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<input type=\"text\" name=\"number_type";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"number_type";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\"\" onKeyPress=\"return checkValid(this,window.event,";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =",";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =")\" onBlur=\"check_NumericResult(this,\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\')\" maxLength=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t\t\t<input type=\"hidden\" name=\"num_crit_low_points";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"num_crit_low_points";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\"hidden\" name=\"num_crit_high_points";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"num_crit_high_points";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t<input type=\"hidden\" name=\"num_crit_low";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"num_crit_low";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\"hidden\" name=\"num_crit_high";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"num_crit_high";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\" name=\"max_digits";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"max_digits";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t<input type=\"hidden\" name=\"min_digits";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"min_digits";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\"dec_digits";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"dec_digits";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<input type=\"checkbox\" name=\"check_type";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"check_type";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"\" onClick=\"setHeaderCheckBoxValue(this,\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<TEXTAREA ROWS=\"3\" COLS=\"25\" name=\"long_text_type";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"long_text";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" onBlur=\"check_MaxLimit(this,2000,\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\"></TEXTAREA>\n\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t<SELECT name=\"list_type";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"list_type";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" onChange=\"changeColorIfDiff(this,\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\')\">\n\t\t\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" ---</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t<SCRIPT>loadListValues(\'list_type";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\')</script>\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t<input type=\"text\" name=\"time_type";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"time_type";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" value=\"\" size=\"10\" maxlength=\"5\" onkeypress=\"return CheckForSpecChars(event)\" onChange=\"setHeaderValue1(this,\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\');\" onBlur=\"changeColorIfDiff(this,\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\');check_Time(this,\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<input type=\"text\" name=\"short_text_type";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"short_text_type";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" value=\"\" size=\"30\" maxlength=\"200\" onBlur=\"changeColorIfDiff(this,\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t</TD>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t</TR>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\n\t<!--<TR style=\"display: none;\">\n\t\t<TD class=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">&nbsp;&nbsp;</TD>\n\t</TR>\n\t<TR style=\"display: none;\">\n\t\t<TD class=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">&nbsp;&nbsp;</TD>\n\t</TR>-->\n</table>\n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\"hidden\" name=\"to\" id=\"to\" value=";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =">\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" >\n<input type=\"hidden\" name=\"result_format\" id=\"result_format\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<input type=\"hidden\" name=\"main_result_type\" id=\"main_result_type\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\"hidden\" name=\"total_values\" id=\"total_values\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\'hidden\' name=\'localeName\' id=\'localeName\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n<script>\n\tif(parent.multiPatientOrdersResultingMainResultData!= null)\n\t{\n\t\tparent.multiPatientOrdersResultingMainResultData.document.body.scroll=\"no\";\n\t\tparent.multiPatientOrdersResultingMainResultData.document.body.onscroll= \"\";\n\t}\n\tsetTimeout(\"alignUnitsAndData()\",200);\n\tsetTimeout(\"alignHeight()\",300);\n</script>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n<script>\nloadParamValues();\n</script>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );
	
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

int row_count=0;

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/* Mandatory checks start */

	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";

	//int total_records_count = Integer.parseInt(request.getParameter("total_records_count"));
	int discrete_count = Integer.parseInt(request.getParameter("discrete_count"));

	String result_type = "";
	String max_digits = "";
	String min_digits = "";
	String dec_digits = "";
	String classval = "";
	String unit_of_msr = "";
	String num_crit_low_points = "0";
	String num_crit_high_points = "0";
	String num_crit_low = "0";
	String num_crit_high = "0";

//	String discrete_desc = request.getParameter("discrete_desc");
	int max_length = 0;

	int row_disp=OrRepository.DISPLAY_MIN_RECORDS;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;
	String dispMode="";
	String temp_disp = "";

	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;	
	bean.setLanguageId(localeName);
	eOR.Common.MultiRecordBean MultiRecordSet= new eOR.Common.MultiRecordBean();

	String from= "", to ="" ;

	dispMode			=	request.getParameter("dispMode") ;
	from				=	request.getParameter("from") ;
	to					=	request.getParameter("to") ;
	
	temp_disp = dispMode;

	if (from == null || from=="null" || from.equals("null"))
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp - 1;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null"))dispMode="";

	if(dispMode.equals(""))
	{
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count			=  MultiRecordSet.getSize("DB");
//		System.out.println("in result 1, row count is...."+row_count);
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start);
		to   = ""+(end);
	}
	else
	{
//		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if(dispMode.equals("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	
	String result_format = request.getParameter("result_format");
	String main_result_type = request.getParameter("main_result_type");

	ArrayList discrete_measures_list = (ArrayList)bean.getDiscreteMeasures(result_format,main_result_type);
	String[] record = null;


            _bw.write(_wl_block9Bytes, _wl_block9);

		int count=0;
		String descrete_msr_desc = "";
		String mandatory = "";
		//StringTokenizer st = new StringTokenizer(discrete_desc,":::");
		for(int j=0;j<discrete_count;j++)
		{
			//descrete_msr_desc = st.nextToken();
			//descrete_msr_desc = descrete_msr_desc.replaceAll("hash","#");
			//descrete_msr_desc = descrete_msr_desc.replaceAll("ampersand","&");
			record = (String[])discrete_measures_list.get(j);
			descrete_msr_desc = record[1];
			//mandatory = request.getParameter("mandatory"+count);
			//unit_of_msr = request.getParameter("unit_of_msr"+count);
			mandatory = record[7];
			unit_of_msr = record[6];
			if(unit_of_msr==null || unit_of_msr.equals(""))
				unit_of_msr = "";
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(descrete_msr_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

				if(unit_of_msr!=null && !unit_of_msr.equals(""))
					out.println("("+unit_of_msr+")");;
				
				if(mandatory!= null && !mandatory.equals("")&& mandatory.equals("Y"))
				{
				
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
				
            _bw.write(_wl_block13Bytes, _wl_block13);

		count++;
		}
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);

	if ( (!(start <= 1)) && (start < row_count)){
	
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	
            _bw.write(_wl_block19Bytes, _wl_block19);


	for(int i=fm_disp;i<=to_disp;i++)
	{
		if(i % 2 == 0 )
		{
			classval	=	"CACHARTQRYEVEN";
			
		}
		else
		{
			classval	=	"CACHARTQRYEVEN";
		}
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(discrete_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);

		for(int j=0;j<discrete_count;j++)
		{
			record = (String[])discrete_measures_list.get(j);
			//result_type = request.getParameter("result_type"+j);
			result_type = bean.checkForNull(record[2]);
	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block34Bytes, _wl_block34);

			if(result_type.equals("E"))
			{
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}
			else if(result_type.equals("D"))
			{

			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);

			}
			else if(result_type.equals("N") || result_type.equals("I"))
			{
				//max_digits = request.getParameter("max_digits"+j);
				//min_digits = request.getParameter("min_digits"+j);
				//dec_digits = request.getParameter("dec_digits"+j);

				max_digits = bean.checkForNull(record[3]);
				min_digits = bean.checkForNull(record[4]);
				dec_digits = bean.checkForNull(record[5]);

				/*if(max_digits==null || max_digits.equals(""))
					max_digits = "1";

				if(min_digits==null || min_digits.equals(""))
					min_digits = "0";
				
				if(dec_digits==null || dec_digits.equals(""))
					dec_digits = "0";

				if(dec_digits.equals("0"))
					max_length = Integer.parseInt(max_digits) + Integer.parseInt(dec_digits);
				else
					max_length = Integer.parseInt(max_digits) + Integer.parseInt(dec_digits) + 1;*/
				if(result_type.trim().equalsIgnoreCase("N") ||result_type.trim().equalsIgnoreCase("I"))
				{
					max_length = 1;
					if(max_digits==null || max_digits.trim().equals(""))
						max_digits = "20";
					if(dec_digits.equals("") || dec_digits.equals("0")) 
					{
						max_length = Integer.parseInt(max_digits);
						dec_digits = "0";
					} 
					else 
					{
						max_length = Integer.parseInt(max_digits) + 1;										
					}
				}
				
				num_crit_low_points		= bean.checkForNull(record[8]);
				num_crit_high_points	= bean.checkForNull(record[9]);
				num_crit_low			= bean.checkForNull(record[10]);
				num_crit_high			= bean.checkForNull(record[11]);
			
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(max_digits));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dec_digits));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(max_length));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(num_crit_low_points));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(num_crit_high_points));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(num_crit_low));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(num_crit_high));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(max_digits));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(min_digits));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dec_digits));
            _bw.write(_wl_block70Bytes, _wl_block70);

			}
			else if(result_type.equals("C"))
			{
			
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block74Bytes, _wl_block74);

			}
			else if(result_type.equals("F"))
			{	
			
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block78Bytes, _wl_block78);

			}
			else if (result_type.equals("L"))
			{
			
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block84Bytes, _wl_block84);

			}
			else if (result_type.equals("T"))
			{
			
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block74Bytes, _wl_block74);

			}
			else if (result_type.equals("H"))
			{
			
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block74Bytes, _wl_block74);

			}
			
            _bw.write(_wl_block93Bytes, _wl_block93);

		}
		
            _bw.write(_wl_block94Bytes, _wl_block94);

	}
	
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(discrete_count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(discrete_count));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(from));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(to));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(result_format));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(main_result_type));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(discrete_count));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block107Bytes, _wl_block107);

if(temp_disp==null || temp_disp.equals("null") || temp_disp.equals(""))
{
	out.println("<script>loadHiddenParams();</script>");
}

            _bw.write(_wl_block108Bytes, _wl_block108);

	// set it back persistence
	//putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
}
