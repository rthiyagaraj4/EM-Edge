package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import webbeans.eCommon.ConnectionManager;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tdmresultreportingsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/TDMResultReportingSearch.jsp", 1709120034000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date validation-->\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultReporting.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"populateLocnOrdType(\'location_type\',\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\',\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\');populateLocnOrdType(\'locn\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');populateSourceLocation(document.result_reporting_search.source_location_type);defaultOrderCategory();resubmit();\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\'result_reporting_search\' id=\'result_reporting_search\' target=\'messageFrame\' >\n<table cellpadding=0 cellspacing=0 border=0 width=\"98%\" align=center>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<input type=hidden name=\'practitioner_type\' id=\'practitioner_type\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td>&nbsp;<SELECT name=\'location_type\' id=\'location_type\' onChange=\'populateLocation(this)\'>\n\t\t\t\t<option value=\'\'>All</option>\n\t\t\t\t<option value=\'C\'>Clinic</option>\n\t\t\t\t<option value=\'W\'>Nursing Unit</option>\n\t\t</td>\n\t\t<td class=label align=\'right\' id=\'id_locn\' >&nbsp;Location</td>\n\t\t<td>&nbsp;<SELECT name=\"locn\" id=\"locn\">\n\t\t\t\t\t<option value=\'\'>All</option>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</select>\n\t\t<input type=hidden name=\'order_category\' id=\'order_category\' value=\'NC\'>\n\t\t</td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td colspan=6></td>\n\t\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'Departmental Service\' >\n\t</tr>\n\t<tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<td class=label align=\'right\'>Priority</td>\n\t\t<td>&nbsp;<SELECT name=\"priority\" id=\"priority\" >\n\t\t\t\t<option value=\'\'>All</option>\n\t\t\t\t<option value=\'R\'>Routine</option>\n\t\t\t\t<option value=\'S\'>Stat</option>\n\t\t\t\t<option value=\'U\'>Urgent</option>\n\t\t\t</SELECT>\n\t\t\t<input type=hidden name=\'single_multi\' id=\'single_multi\' value=\'S\'>\n\t\t</td>\n\t\t<td class=label align=\'right\'></td>\n\t\t<td>&nbsp;</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n        <td class=label align=\'right\' id=\'id_locn\' >Order Category</td>\n\t\t<TD>&nbsp;<Select name=\"locn\" id=\"locn\" onChange=\"populateLocnOrdType(\'locn\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\"><option value=\'\'>&nbsp;&nbsp;&nbsp;---All---&nbsp;&nbsp;&nbsp;</option></Select>&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<input type=hidden name=\'order_category\' id=\'order_category\' value=\'\'>\n\t\t</TD>\n\t\t<td class=label align=\'right\'>Order Type</td>\n\t\t<TD>&nbsp;<select name=order_type><option value=\'\'>All&nbsp;&nbsp;&nbsp;&nbsp;</option></Select><input type=hidden name=\'single_multi\' id=\'single_multi\' value=\'M\'></TD>\n\t\t<td id=\'performing_locn_lbl_show\' class=\'label\' align=\'right\' nowrap>&nbsp;</td>\n\t\t<td id=\'performing_locn_show\' align=\'left\'>&nbsp;</td>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t</tr>\n\n\t<tr>\n\t\t<td class=label align=\'right\'>Priority</td>\n\t\t<td>&nbsp;<SELECT name=\"priority\" id=\"priority\">\n\t\t\t\t<option value=\'\' >All</option>\n\t\t\t\t<option value=\'R\' >Routine</option>\n\t\t\t\t<option value=\'S\' >Stat</option>\n\t\t\t\t<option value=\'U\' >Urgent</option>\n\t\t\t</SELECT>\n\t\t\t<Script>document.getElementById(\"priority\").value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'</Script>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<td class=\'label\' align=\'right\'>Period From</td>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<td align=\'left\'>&nbsp;<input type=\"text\" name=\"date_from\" id=\"date_from\" value=\"\" size=\"10\" maxlength=\"10\" onBlur=\"CheckDate(this)\" onKeyPress=\'return OrAllowDateFormat()\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_from\');\" style=\'cursor:pointer\'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<td align=\'left\'>&nbsp;<input type=\"text\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" size=\"10\" maxlength=\"10\" onBlur=\"CheckDate(this)\" onKeyPress=\'return OrAllowDateFormat()\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_from\');\" style=\'cursor:pointer\'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<td class=\'label\' align=\'right\'>To</td><td align=\'left\'>&nbsp;<input type=text name=\'date_to\' id=\'date_to\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' size=\"10\" maxlength=\"10\" onBlur=\"checkDateRange(this,\'result_reporting_search\')\" onKeyPress=\'return OrAllowDateFormat()\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_to\');\" style=\'cursor:pointer\'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<tr>\n\t\t<td class=label align=\'right\'>Patient ID</td>\n\t\t<td>&nbsp;<input type=\'text\' width=\'16%\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' nowrap onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\'ChangeUpperCase(this);\'  maxlength=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ><input align=\'right\' type=button name=search value=\'?\'  class=button tabIndex=\"4\" onClick=\"callPatientSearch()\"></td> ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<td class=label align=\'right\'>Order ID</td>\n\t\t<td>&nbsp;<input type=text name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' maxlength=15 onBlur=\'ChangeUpperCase(this)\'></td>\n\t\t<td class=label align=\'right\'>Encounter ID</td>\n\t\t<td>&nbsp;<input type=text name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onBlur=\"OrCheckNumber1(this)\" maxlength=12 onKeyPress=\'return OrAllowPositiveNumber()\' colspan=3><input type=\'hidden\' name=\'patient_id_found\' id=\'patient_id_found\' value=\'no\'></td>\n\t</tr>\n\t<tr>\n\t<td class=label align=\'right\'>Catalog</td>\n\t\t<td>&nbsp;<input type=text name=\'catalog\' id=\'catalog\' value=\'\' size=\"22\" maxlength=\"40\" ></td>\n\t\t<td class=label align=\'right\'>Search Criteria</td>\n\t\t<td>&nbsp;<SELECT name=\"search_criteria\" id=\"search_criteria\">\n\t\t\t\t<option value=\'S\'>Starts With</option>\n\t\t\t\t<option value=\'C\'>Contains</option>\n\t\t\t\t<option value=\'E\'>Ends With</option>\n\t\t\t</SELECT>\n\t\t</td><td class=label align=\'right\'>Task Status</td>\n\t\t<td id=\'task_status_show\'>&nbsp;<SELECT name=\"task_status\" id=\"task_status\">\n\t\t<option value=\'Z\'>All</option>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<option value=\'X\'>External Orders</option>\n\t\t<option value=\'R\'>Acknolwedge the Results</option>\n\t\t</SELECT></td>\n\n\t</tr>\n \t<TR>\n \t\t<TD class=label align=\'right\'>Source</TD>\n\t\t<td class=label  colspan=\'3\'>&nbsp;<SELECT name=\"source_location_type\" id=\"source_location_type\" onChange=\'populateSourceLocation(this)\'>\n\t\t\t<option value=\'\'>All</option>\n\t\t\t<option value=\'C\'>Clinic</option>\n\t\t\t<option value=\'N\'>Nursing Unit</option>\n\t\t</SELECT>&nbsp;<SELECT name=\"source_locn\" id=\"source_locn\"  >\n\t\t\t\t\t<option value=\"\">All&nbsp;&nbsp;&nbsp;</option>\n\t\t\t</SELECT>&nbsp;\n\t\t</td><td class=label align=\'right\'>Group By</td>\n\t\t<td>&nbsp;<SELECT name=\"group_by\" id=\"group_by\">\n            <option value=\"D\">Date/Time </option>\n            <option value=\"P\">Patient ID </option>\n        \t<option value=\"C\">Order Category </option>\n        \t<option value=\"T\">Order Type </option>\n        \t<option value=\"L\">Location </option>\n        \t<option value=\"U\">Priority </option>\n        \t<option value=\"O\">Orderable </option>\n\t\t</SELECT></td>\n     </TR>\n     <tr>\n        <td id=\'specimen_no_lbl_show\' class=\'label\' align=\'right\' nowrap>&nbsp;</td>\n\t\t<td id=\'specimen_no_show\' align=\'left\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n        <TD colspan=\'2\'>&nbsp;<Input name=\'view_by\' id=\'view_by\' type=\'hidden\' value=\'H\'></TD>\n\t\t<td colspan=\'2\'></td>\n     </tr>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<tr>\n\t\t<td colspan=6 align=right>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<tr>\n\t<td class=label align=\'right\'>Catalog</td>\n\t\t<td>&nbsp;<input type=text name=\'catalog\' id=\'catalog\' value=\'\' size=\"22\" maxlength=\"40\" ></td>\n\t\t<td class=label align=\'right\'>Search Criteria</td>\n\t\t<td>&nbsp;<SELECT name=\"search_criteria\" id=\"search_criteria\">\n\t\t\t\t<option value=\'S\'>Starts With</option>\n\t\t\t\t<option value=\'C\'>Contains</option>\n\t\t\t\t<option value=\'E\'>Ends With</option>\n\t\t\t</SELECT>\n\t\t</td>\n\t\t<td class=label align=\'right\'>Task Status</td>\n\t\t<td id=\'task_status_show\'>&nbsp;<SELECT name=\"task_status\" id=\"task_status\">\n\t\t<option value=\'Z\'>All</option>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<option value=\'X\'>External Orders</option>\n\t\t<option value=\'R\'>Acknolwedge the Results</option>\n\t\t</SELECT></td>\n\t</tr>\n\t<tr>\n\t   <TD class=label align=\'right\'>Source</TD>\n\t\t<td class=label  colspan=\'3\'>&nbsp;<SELECT name=\"source_location_type\" id=\"source_location_type\" onChange=\'populateSourceLocation(this)\'>\n\t\t\t<option value=\'\'>All</option>\n\t\t\t<option value=\'C\'>Clinic</option>\n\t\t\t<option value=\'N\'>Nursing Unit</option>\n\t\t</SELECT>&nbsp;<SELECT name=\"source_locn\" id=\"source_locn\"  >\n\t\t\t\t\t<option value=\"\">All&nbsp;&nbsp;&nbsp;</option>\n\t\t\t</SELECT>&nbsp;\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<TD class=\'label\' colspan=\'2\'>&nbsp;<Input name=\'view_by\' id=\'view_by\' type=\'hidden\' value=\'H\'></TD>\n\t</tr>\n\t<tr>\n        <td class=label align=\'right\'>Group By</td>\n\t\t<td>&nbsp;<SELECT name=\"group_by\" id=\"group_by\">\n            <option value=\"P\">Patient ID </option>\n        \t<option value=\"C\">Order Category </option>\n        \t<option value=\"T\">Order Type </option>\n        \t<option value=\"L\">Location </option>\n        \t<option value=\"D\">Date/Time </option>\n        \t<option value=\"U\">Priority </option>\n        \t<option value=\"O\">Orderable </option>\n\t\t</SELECT></td>\n\t\t<td id=\'specimen_no_lbl_show\' class=\'label\' align=\'right\' nowrap>&nbsp;</td>\n\t\t<td id=\'specimen_no_show\' align=\'left\'>&nbsp;</td>\n        <td colspan=\'2\' align=right>\n\t\t<input type=\'hidden\' name=\'patient_id_found\' id=\'patient_id_found\' value=\'yes\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'\'>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<input type=button class=button name=\'search\' id=\'search\' value=\'Search\'  onClick=\'populateValues()\'>&nbsp;<input type=button name=\'clear\' id=\'clear\' class=button value=\'Clear\' onClick=\'clearValues()\'>&nbsp;&nbsp;</td>\n\t</tr>\n\n</table>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<Input type=\"hidden\" name=\"isRDInstalled_yn\" id=\"isRDInstalled_yn\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<Input type=\"hidden\" name=\"isLabInstalled_yn\" id=\"isLabInstalled_yn\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<Input type=\"hidden\" name=\"bean_id1\" id=\"bean_id1\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<Input type=\"hidden\" name=\"bean_name1\" id=\"bean_name1\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<Input type=\"hidden\" name=\"CancelFlag\" id=\"CancelFlag\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<Input type=\"hidden\" name=\"from_ca\" id=\"from_ca\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<Input type=\"hidden\" name=\'default_order_category\' id=\'default_order_category\' value=\'\'>\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultReporting" ;
	String bean_name = "eOR.ResultReportingBean";

	String bean_id1 = "Or_PatientValidate";
	String bean_name1 = "eOR.PatientValidate";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String option_id			= request.getParameter("option_id");

	String isLabInstalled_yn = "",isRDInstalled_yn = "";

	if(option_id == null){option_id = "";}

	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");

	//String from_ca = request.getParameter("CA");
	String from_ca = "";

	if (from_ca == null) from_ca = "";

	patient_id = (patient_id == null) ? "" : patient_id;
	encounter_id = (encounter_id == null) ? "" : encounter_id;

	//When it comes after clikling the cancel button  in the reult Entry
	String CancelFlag			= request.getParameter("CanelFlag");
	String can_location_type	= request.getParameter("can_location_type");
	String can_location			= request.getParameter("can_location");
	String can_order_category	= request.getParameter("can_order_category");
	String can_single_multi		= request.getParameter("can_single_multi");
	String can_priority			= request.getParameter("can_priority");
	String can_date_from		= request.getParameter("can_date_from");
	String can_date_to			= request.getParameter("can_date_to");
	String can_patient_id		= request.getParameter("can_patient_id");
	String can_order_id			= request.getParameter("can_order_id");
	String can_encounter_id		= request.getParameter("can_encounter_id");
	String can_patient_id_found	= request.getParameter("can_patient_id_found");
	String can_order_type		= request.getParameter("can_order_type");
	String can_performing_location_code = request.getParameter("can_performing_location_code");

	CancelFlag					= (CancelFlag == null) ? "" : CancelFlag;

	can_location_type 		= (can_location_type == null) ? "" : can_location_type;
	can_location 			= (can_location == null) ? "" : can_location;
	can_order_category 		= (can_order_category == null) ? "" : can_order_category;
	can_single_multi 		= (can_single_multi == null) ? "" : can_single_multi;
	can_priority 			= (can_priority == null) ? "" : can_priority;
	can_date_from 			= (can_date_from == null) ? "" : can_date_from;
	can_date_to 			= (can_date_to == null) ? "" : can_date_to;
	can_patient_id 			= (can_patient_id == null) ? "" : can_patient_id;
	can_order_id 			= (can_order_id == null) ? "" : can_order_id;
	can_encounter_id 		= (can_encounter_id == null) ? "" : can_encounter_id;
	can_patient_id_found 	= (can_patient_id_found == null) ? "" : can_patient_id_found;
	can_order_type 			= (can_order_type == null) ? "" : can_order_type;
	can_performing_location_code = (can_performing_location_code == null) ? "" : can_performing_location_code;

	boolean pract_type_is_NS = false;

	if(resp_id== null)resp_id = "";

	if(practitioner_type == null)
		practitioner_type = "";
	else
	{
		//if(practitioner_type.equals("NS"))
		//	pract_type_is_NS = true;
	}

/* Mandatory checks end */
            _bw.write(_wl_block1Bytes, _wl_block1);
if (from_ca.equals("Y")) {
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(can_order_category));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(can_order_category));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
} else {
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(can_order_category));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(can_order_category));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	/* Initialize Function specific start */
	//ResultReportingBean bean = (ResultReportingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name, request ) ;

	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;

	int patient_id_length = bean.getPatientIdLength();

	//String curr_sys_date = bean.getSysDate();
	String curr_sys_date = "";
	//String curr_week_date  = "";
	String last_week_date  = "";
	try{
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		//curr_week_date =  (String)sysdate.get(1);
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
		//out.println("<script>alert('last_week_date="+last_week_date+"')</script>");
	}
	} catch (Exception e) {
		//out.println("<script>alert('here:"+e.getMessage()+"')</script>");//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	ArrayList location=new ArrayList();
	String[] order_category = new String[2];
	//ArrayList orderType = new ArrayList();
	try{
		//out.println("practitioner_id="+practitioner_id+", resp_id="+resp_id+", facility_id="+facility_id+"<br>");
		order_category	= bean.getOrdercategory(practitioner_id, resp_id);
		//out.println("order_category[0]="+order_category[0]+", order_category[1]="+order_category[1]);

		if(pract_type_is_NS)
			location = bean.getLocation(facility_id, practitioner_id, "");

	//	orderType = bean.getOrderType(order_category[0], practitioner_id, resp_id);
	}catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}


try{
	//String isLabInstalled_yn = "";
	//if(order_category[0].equals("LB")){
		isLabInstalled_yn = (String) bean.isModuleInstalled(facility_id,"RL");
		/*if((isLabInstalled_yn.trim()).equals("Y")){
			out.println("<script>alert(getOrMessage('LAB_MODULE_INSTALLED')); document.location.href='../../eCommon/html/blank.html'</script>");
		}*/
	//}

	//if(order_category[0].equals("RD")){
		isRDInstalled_yn = (String) bean.isModuleInstalled(facility_id,"RD");
		/*if((isRDInstalled_yn.trim()).equals("Y")){
			out.println("<script>alert(getOrMessage('RADIOLOGY_MODULE_INSTALLED')); document.location.href='../../eCommon/html/blank.html'</script>");
		}*/
	//}
}catch(Exception e){
}

/* Initialize Function specific end */

            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block12Bytes, _wl_block12);

if (pract_type_is_NS)
{
            _bw.write(_wl_block13Bytes, _wl_block13);

				for(int i=0; i<location.size(); i++){
					String[] location_i = new String[2];
					location_i = (String[])location.get(i);
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(location_i[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(location_i[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

if (pract_type_is_NS)
{
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(can_order_category));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(can_priority));
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block26Bytes, _wl_block26);
if (from_ca.equals("Y")) {
            _bw.write(_wl_block27Bytes, _wl_block27);
} else {
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_from:last_week_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_to:last_week_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block32Bytes, _wl_block32);

	//out.println("patient_id="+patient_id+", encounter_id="+encounter_id);

	if(CancelFlag.trim().equalsIgnoreCase("Y"))	 {
		if(!option_id.trim().equalsIgnoreCase("TASK_ORDER_REPORT")){
			patient_id="" ;
			encounter_id="";
		}
	}

	if(patient_id==null || patient_id.equals("null") || patient_id.equals(""))
	{
		patient_id="";
		encounter_id="";
	
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( can_patient_id ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(can_order_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(can_encounter_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block39Bytes, _wl_block39);
            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block41Bytes, _wl_block41);

	}else{
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block43Bytes, _wl_block43);
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block46Bytes, _wl_block46);

	}
	
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isRDInstalled_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(isLabInstalled_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean_id1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean_name1));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(CancelFlag));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_ca));
            _bw.write(_wl_block58Bytes, _wl_block58);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
