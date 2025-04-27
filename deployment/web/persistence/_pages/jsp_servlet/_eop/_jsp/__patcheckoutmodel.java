package jsp_servlet._eop._jsp;

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
import com.ehis.util.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;

public final class __patcheckoutmodel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PatCheckoutModel.jsp", 1742278222849L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<!-- <script src=\'../../eOP/js/dchk.js\' language=\'javascript\'></script> -->\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eOP/js/PatCheckout.js\'></script>\n\t<script language=\'javascript\' src=\'../../eOP/js/OPPractitionerComponent.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/CAMenu.js\'></script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<!--  <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  -->\n\t</head>\n\t\n<style>\ntextarea {\n  resize: none;\n}\n</style>\t\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<script>alert(getMessage(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'BL\'));\n\t\t\t\t\twindow.close();\n\t\t\t\t\thistory.go(-1);\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<body onload=\"setTimeout(\'FocusFirstElement()\',300);checkRecordButton();procedureUnitCheck();";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" updDeathRegForm();";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onKeyDown =\'lockKey()\'>   <!--Modified by Sangeetha for ML-MMOH-CRF-0624 --> <!-- Modified by Ajay Hatwate for AAKH-CRF-0179 -->\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<body onload=\"setTimeout(\'FocusFirstElement()\',300);procedureUnitCheck()\" onKeyDown =\'lockKey()\'> \n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t<form name=\"Checkout_form\" id=\"Checkout_form\" action=\'../../servlet/eOP.PatCheckoutServlet\' method=\'post\' target=\"Dummy_frame\">\n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'CHECK_OUT\'>\n\n\t\t\t<table border=\'0\' align=center cellpadding=\'0\' cellspacing=\'0\' width=\'98%\'  >\n\t\t\t\t\t\n\t\t\t\t<tr><td colspan=4>&nbsp;</td></tr>\n\t\t\t\t<tr>\n\t\t\t\t<td    class=\"label\" width=\'25%\'align=\"left\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td   class =\'label\'  width=\'49%\' align=\"left\" nowrap><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b>  </td>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t        <td nowrap><input type=text name=\"practitioner_desc\" id=\"practitioner_desc\"  size=20 maxlength=30 value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onBlur=\"beforeGetPractitioner(practitioner_id,practitioner_desc);\"><input type=hidden name=practitioner_id value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<input type=hidden name=attending_practitioner value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<input type=button class=button value=\'?\' name=Practitioner_lookup_button onClick=\"getPract(practitioner_id,practitioner_desc);\"><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<INPUT TYPE=\'hidden\' name=\'open_to_all_pract\' id=\'open_to_all_pract\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><!-- <input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'> -->\n\t\t\t\t\t\t\t        <td nowrap><input type=text name=\"practitioner_desc\" id=\"practitioner_desc\"  size=20 maxlength=30 value=\"\" onBlur=\"beforeGetPractitionerOP(practitioner_id,practitioner_desc);\" ><input type=hidden name=practitioner_id value=\"\"><input type=hidden name=attending_practitioner ><input type=button class=button value=\'?\' name=Practitioner_lookup_button onClick=\"getPractitionerOP1(this,practitioner_desc);\"><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\t\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].attending_practitioner.value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr style=\'heigth:10px\'></tr>\n\t\t\t\n           \t\t<th class=\'columnheader\' colspan=4 align=\"left\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td   class=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="/";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t\t\t<tr><td ></td></tr>\n\t\t\t\t\t\t\t<tr><td ></td></tr>\n\t\t\t\t\n\t\t\t\n\t\t\t<tr><th  colspan=4 class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td></tr>\n\t\t<!--Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646 Start-->\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'19%\'>\n\t\t\t\t<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' width=\'15%\'>\n\t\t\t\t\t\t<input type=\'radio\' name=\'caseDetails\' id=\'caseDetails\' id=\'trauma\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ></input>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' width=\'15%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' width=\'13%\'>\n\t\t\t\t\t\t<input type=\'radio\' name=\'caseDetails\' id=\'caseDetails\' id=\'oscc\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="></input>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  width=\'19%\'>\n\t\t\t\t<span id=\'osccTypeLabel\' style=\"visibility:hidden\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</span>\n\t\t\t</td>\n\t\t\t<td class=\'fields\' width=\'19%\'>\n\t\t\t\t<select name=\'osccType\' id=\'osccType\' style=\"visibility:hidden\">\n\t\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="--------\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\'osccTypeMandImg\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'19%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'fields\' width=\'15%\'>\n\t\t\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'medical\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ></input>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' width=\'15%\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'13%\'>\n\t\t\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'surgical\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ></input> \n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td colspan=2>&nbsp;</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'19%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'fields\' width=\'15%\'>\n\t\t\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'OandG\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'13%\'>\n\t\t\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'NonEmerg\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" ></input> \n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td colspan=2>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<!--End-->\n\t\t\t<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\"CaseofTrauma\" id=\"CaseofTrauma\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" align=\"left\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onClick=\'chkval(this);\'></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<!--End ML-MMOH-CRF-1409-->\n\t\t\t<tr>       \n\t\t\t<td   class=\"label\" nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<td><input type=\'checkbox\' name=\'medical\' id=\'medical\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="  align=\"left\"  value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onClick=\'chkval(this);\'></td><td   class=\"label\" nowrap>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td><td><input type=\'checkbox\' name=\'surgical\' id=\'surgical\' align=\"left\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="  value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\n\t\t\t<!-- Added by Ajay Hatwate for ML-MMOH-CRf-1653 -->\n\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t <tr>\t\t\n\t      <td class=\'label\' nowrap >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t      <td colspan=\'2\' >\n\t\t\t <select name=\'case_type\' id=\'case_type\' caseTypeDisable>\n\t\t\t <option value=\'\'>--------";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="--------\n\t\t\t  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t </select>\n\t\t\t ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t </td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<!-- End of ML-MMOH-CRF-1653 -->\n\t\t\t\n\t\t\t         <tr> <td  align=\'left\' class=\'label\'  nowrap>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td><td colspan=3><select name= \'circumstance_of_injury\' >\n\t\t\t\t\t<option value=\'\'>-------- ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" --------                 \n                            \n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\n\t\t\t\n            \n\t\t\t<th colspan=4 class=\'COLUMNHEADER\' align=\"left\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n                <tr >\n\t\t\t\n\t\t\t<!--below changes added by Mano against ML-MMOH-CRF-0783-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'did_yn\' id=\'did_yn\' value=\'\' disabled  onClick=\'chkval(this);checkRecordButton();\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="<input type=\'hidden\' name=\'did_hid\' id=\'did_hid\' value=\'N\'><!--End-->\n\t\t\t\n\t\t\t<td   class=\"label\" nowrap>\n\t\t\t<!--Below line modified by Ashwini on 18-Jan-2017 for GDOH-CRF-0123--> \n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" \n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="<!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<td  class=\'FIELDS\' nowrap><input type=\'checkbox\' name=\'bdead\' id=\'bdead\' value=\'Y\' checked ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" onClick=\'chkval(this);checkRecordButton()\'>  <!-- Modified by Sangetha for ML-MMOH-CRF-0628 on 10/may/17-->\n\t\t\t\t\t<input type=\'hidden\' name=\'bdead_yn\' id=\'bdead_yn\' value=\'Y\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<td  class=\'FIELDS\' nowrap><input type=\'checkbox\' name=\'bdead\' id=\'bdead\' value=\'\' ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" onClick=\'chkval(this);checkRecordButton()\'></img><input type=\'hidden\' name=\'bdead_yn\' id=\'bdead_yn\' value=\'N\'>    <!-- Modified by Sangetha for ML-MMOH-CRF-0624 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" onClick=\'chkval(this);\'></img><input type=\'hidden\' name=\'bdead_yn\' id=\'bdead_yn\' value=\'N\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t<td   class=\"label\" align=\"left\" width=\"15%\">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t<td  class=\"label\" align=\"left\" width=\"15%\">";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t<td><input type=\'checkbox\' name=\'mlc\' id=\'mlc\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" onClick=\'chkval(this);\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t<td  class=\'label\' nowrap>\t\t\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n        <td  align=\"left\" class=\"Fields\" nowrap><input type=\'checkbox\' name=\'postmortem\' id=\'postmortem\' value=\'N\' onClick=\'chkval(this);\' disabled><td   class=\"label\" width=\'24%\'>\n\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="<td class=\'Fields\' ><input type=\'checkbox\' name=\'high_risk\' id=\'high_risk\' value=\'N\' onclick=\'chkval(this);\' disabled></td>\n\t\t<input type=\'hidden\' name=\'medical_yn\' id=\'medical_yn\' value=\'N\'>\n\t\t</tr>\n\t\t<tr>\n        <td   class=\'label\' nowrap>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t<td class=\'Fields\'><input type=\'text\'  name=\'deceased_date_time\' id=\'deceased_date_time\' size=\'16\' maxlength=\'16\' onBlur=\'validDateObj(this,\"DMYHM\",localeName);if(document.forms[0].released_date_time.value == \"\" && !document.forms[0].released_date_time.readOnly){document.forms[0].released_date_time.value=document.forms[0].deceased_date_time.value;} if(document.forms[0].released_date_time.value != \"\" && !document.forms[0].released_date_time.readOnly){document.forms[0].released_date_time.value=document.forms[0].deceased_date_time.value;}\'   value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =">\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t\n <img id=\"dec_img\" \n     src=\"../../eCommon/images/CommonCalendar.gif\" \n     onClick=\"deceasedDateTime(\'deceased_date_time\', null, \'hh:mm\')\" \n     ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" \n     style=\"pointer-events: ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="; opacity: ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =";\">\n \n \n    \t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'gifpopdec\'>\n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t<a href=\"javascript:getDeathRegFormAccessionNum(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\', \'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\', \'\');\" id=\'deathRegFormLink\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</a>\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t</td> \n\t\t<input type=\'hidden\' name=\'high_risk_yn\' id=\'high_risk_yn\' value=\'N\'>\n\t\t<td   class=\'label\'  width=\"25%\" nowrap>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\t\t<td class=\'Fields\'align=\"left\" width=\"25%\" ><input type=\'text\'  name=\'released_date_time\' id=\'released_date_time\' size=\'16\' maxlength=\'16\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' onBlur=\'validDateObj(this,\"DMYHM\",localeName);\' ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =">\n\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' \n     id=\'rel_img\' \n     onClick=\"releasedDateTime(\'released_date_time\', null, \'hh:mm\')\" \n     ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =";\">\n\t\t\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'gifpopbody\'></td>\n\t\t<input type=\'hidden\' name=\'surgical_yn\' id=\'surgical_yn\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t\t<input type=\'hidden\' name=\'mlc_yn\' id=\'mlc_yn\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t\t<input type=\'hidden\' name=\'postmortem_yn\' id=\'postmortem_yn\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t\n\t\t</tr>\n<tr><td ></td></tr>\n\t\t\t\t\t\t\t<tr><td ></td></tr>\n\t\t\n\t\t</td>\n        </tr>\n\t\n\n\n\t<th class=\'COLUMNHEADER\' colspan=4 align=\"left\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t<tr>\n\t<td>\n\t\t\n\t\t\t<tr>\n\t\t\t<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->\n\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t<!--End ML-MMOH-CRF-0657-->\n\t\t\t<td  class=\'Fields\'>\n\t\t\t<input type=\'checkbox\' name=\'tocomeback\' id=\'tocomeback\' value=\"Y\" onClick=\'enable_recall()\' ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="></td><td class=label>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" </td><td>\n\n\t\t\t <input type=\'hidden\' name=\'comebackon\' id=\'comebackon\' size=\'10\' maxlength=\'10\'  ></input> \n\t\t\t<!-- <input type=\'hidden\' name=\'comebackon\' id=\'comebackon\' size=\'10\' maxlength=\'10\' onBlur=\"CheckDate(this);CheckDates(this,\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\',null)\" ></input> -->\n\t\t\t\n\t\t\t<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->\n\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t<input type=\"hidden\" name=\"days_unit\" id=\"days_unit\" value =\"\">\n\t\t\t<input \'text\' id=\'dateAgain\' name=\'dat_val\' id=\'dat_val\' value=\'\' size=\'16\' maxlength=\'16\' onblur=\"if(validDateObj(this,\'DMYHM\',localeName)){chkWithSysDt(this);}\" onkeypress=\"return Valid_DT(event)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'dateAgain\',null,\'hh:mm\');\"></img>\n\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t<input type=\'text\' name=\'dat_val\' id=\'dat_val\' onkeypress=\"return call2functions(this,event)\"   onblur=\'OffsetDate(\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\");valid_dat(this);\'  onclick=\'\' size=3 maxlength=3 >\t\t\t\t\t<select name=\'days_unit\' id=\'days_unit\' onchange=\'OffsetDate(\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\")\'>\n\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" </option>\n\t\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" </option>\n\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" </option>\n\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t<!--End ML-MMOH-CRF-0657-->\n\t\t\t<img name=\'mandatory\' id=\'mandatory\' style=\'visibility: hidden\' src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\n\t\t\t<td  align=\"right\"colspan=4 > <input type=button class=button value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" \' name=\'bookingappointment\' onclick=\'appointment(false);\' disabled></td>                                    \n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'   >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t\t\t\t<td  nowrap> \n\t\t\t\t\t<Select name=\'reason\' id=\'reason\' \t><option value=\'\'>---------------";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="---------------</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</select> \n\t\t\t\t\t</td>\t\t\n\t\t\t\t\t<td  class=\'label\'  width=\'25\' valign=top>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\t<td width=\'25%\' align=\'left\' > <textarea name=\'instructionsrecall\' rows=2 cols=30 onblur=\'makeValidString(this);checkMaxLen(this);\'></textarea> </td>\n\t\t\t</tr>                            \n\t\t\t<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->\n\t\t\t<!--Start-->\n\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t<td  class=\'QUERYDATA\'><font color=\'RED\'>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</font>&nbsp;<font color=\'blue\'><a href=\'javascript:onclick=MDSCompliance(document.forms[0].mr_mds_recorded.value)\' style=\'text-decoration:underline\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</a></font></td>\n\t\t\t\t<script>\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\t\n\t\t\t</tr>\t\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t<!--End-->\t\n\t</td>\n<tr><td colspan=4> &nbsp;</td></tr>\n</tr> \n\n</table>\n<table  border=\'0\'cellpadding=\'0\' cellspacing=\'10\' align=center width=\'50%\'  >\n\n<tr><td  class=WHITE></td></tr> \n\n\n\n\t\n<tr>\n\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\t\t\t\n\t\t\t<td width=\'65%\' class=\'fields\'><input type=\'button\' class=\'button\' name=\'view_referral\' id=\'view_referral\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' onClick=\"ViewRefDetails(\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\');\"></td>\n\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t<td class=\'label\'></td>\n\t\t\t<td width=\'13%\' class=\'label\'><input type=\'button\' class=\'Button\' name=\'record\' id=\'record\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" onClick=\"Apply()\" value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' > </td>\n\t\t\t<td width=\'13%\' class=\'label\'><input type=\'button\' class=\'Button\' name=\'cancel\' id=\'cancel\' onClick=\"Closewin()\" value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'></td>\n\t\t\t<td width=\'19%\' class=\'label\'><input type=\'button\' class=\'Button\' name=\'cnl_episode\' id=\'cnl_episode\'  onClick=\"Concldepisode(\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\',\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\')\" value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'></td>\n\t\t\t<td width=\'17%\' class=\'label\'><input type=\'button\' class=\'Button\' name=\'create_wait_list\' id=\'create_wait_list\' onClick=\"WaitList(this)\" value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="></td>\n\t\t\t<td width=\'15%\' class=\'label\'><input type=\'button\' class=\'Button\' name=\'modify_wait_list\' id=\'modify_wait_list\' onClick=\"WaitList(this)\" value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="></td> \n\t\t\t<!-- <td width=\'15%\' class=\'label\'><input type=\'button\' class=\'Button\' name=\'sickLeave\' id=\'sickLeave\' onClick=\"OpenSickLeave()\" value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' disabled></td> -->\n\t\t\t\n\t\t\t<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->\n\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t<td width=\'15%\' class=\'label\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name = \'main_procedure\' id = \'main_procedure\' ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =" value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' onclick=\"callCAMainProcedure();\">\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\n\t\t</tr>\t\n\n\t\t<tr>\n\t\t\t<td ></td>\n\t\t</tr>\n\t</table>\n\t<table id=\'billingLinktable\' cellpadding=0 cellspacing=0 border=\'0\' align=\'center\' style=\"visibility:hidden\" >\n\t<tr>\n\t\t\t<td ></td>\n\t</tr>\n\t<tr>\n\t   <td class=\'label\' nowrap><a href=\"javascript:callbilling();\"  name=\'bl_call\'>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n\t</tr>\n\t</table>\n\t\n\n\t<input type=\"hidden\" name=\"open_to_all_prac_for_clinic_yn\" id=\"open_to_all_prac_for_clinic_yn\"  value =\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" >\n\t<input type=\"hidden\" name=\"practitioner_name1\" id=\"practitioner_name1\"  value =\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" >\n\t\t<input type=\"hidden\" name=\"practitioner_id1\" id=\"practitioner_id1\"  value =\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" >\n\t\t<input type=\"hidden\" name=\"specl_code\" id=\"specl_code\"  value =\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" >\n\t<input type=\"hidden\" name=\"Encounter\" id=\"Encounter\"  value =\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" >\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"  value =\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" >\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\"  value =\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" >\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\"  value =\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" >\n\t<input type=\"hidden\" name=\"i_practitioner_id\" id=\"i_practitioner_id\"  value =\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" >\n\t<input type=\"hidden\" name=\"i_clinic_code\" id=\"i_clinic_code\"  value =\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" >\n\t<input type=\"hidden\" name=\"i_appt_ref_no\" id=\"i_appt_ref_no\"  value =\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t<input type=\"hidden\" name=\"i_appt_date\" id=\"i_appt_date\"  value =\"\">\n\t<input type=\"hidden\" name=\"xxxx\" id=\"xxxx\"  value =\"\">\n\t<input type=\"hidden\" name=\"xx\" id=\"xx\"  value =\"\">\n\t<input type=\"hidden\" name=\"P_patient_id\" id=\"P_patient_id\"  value =\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" >\n\t<input type=\"hidden\" name=\"P_locn_type\" id=\"P_locn_type\"  value =\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" >\n\t<input type=\"hidden\" name=\"P_locn_code\" id=\"P_locn_code\"  value =\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" >\n\t<input type=\'hidden\' name=\'arrive_date_time\' id=\'arrive_date_time\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'>\n\t<input type=\'hidden\' name=\'vital_signs_date_time\' id=\'vital_signs_date_time\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'>\n\t<input type=\"hidden\" name=\"ae_count\" id=\"ae_count\"  value =\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" >\n\t<input type=\"hidden\" name=\"P_practitioner_id\" id=\"P_practitioner_id\"  value =\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" >\n\t<input type=\"hidden\" name=\"pract_assigned_yn\" id=\"pract_assigned_yn\"  value =\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" >\n\t<input type=\"hidden\" name=\"conclude\" id=\"conclude\"  value =\"\">\n\t<input type=\"hidden\" name=\"concludenotes\" id=\"concludenotes\"  value =\"\">\n\t<input type=\"hidden\" name=\"sdate\" id=\"sdate\"  value =\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" >\n\t<input type=\"hidden\" name=\"stime\" id=\"stime\"  value =\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" >\n\t<input type=\"hidden\" name=\"referral_text\" id=\"referral_text\"  value =\'\' >\n\t<input type=\"hidden\" name=\"hcare_setting_type_desc\" id=\"hcare_setting_type_desc\"  value =\'\' >\n\t<input type=\"hidden\" name=\"open_to_all_pract_yn\" id=\"open_to_all_pract_yn\"  value =\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' >\n\t<input type=\"hidden\" name=\"to_hcare_setting_type\" id=\"to_hcare_setting_type\"  value =\'\' > \n\t<input type=\"hidden\" name=\"location1_desc\" id=\"location1_desc\"  value =\'\' >\n\t<input type=\"hidden\" name=\"practitioner_name\" id=\"practitioner_name\"  value =\'\' >\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\"  value =\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" > \n\t<input type=\"hidden\" name=\"diagrecord\" id=\"diagrecord\"  value =\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" > \n\t<input type=\"hidden\" name=\"diagReqd\" id=\"diagReqd\"  value =\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" > \n\t<input type=\"hidden\" name=\"notesrecord\" id=\"notesrecord\"  value =\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" > \n\t<input type=\"hidden\" name=\"notesReqd\" id=\"notesReqd\"  value =\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" > \n\t<input type=\"hidden\" name=\"dispReqd\" id=\"dispReqd\"  value =\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" > \n\t<input type=\'hidden\' name=\"P_ae_brought_dead_yn\" id=\"P_ae_brought_dead_yn\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t<input type=\'hidden\' name=\'visit_adm_type_ind\' id=\'visit_adm_type_ind\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n\t<input type=\"hidden\" name=\"ae_treatment_area_code\" id=\"ae_treatment_area_code\"  value =\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" > \n\t<input type=\"hidden\" name=\"inv_ordered1\" id=\"inv_ordered1\" value=\'\'>\n\t<input type=\"hidden\" name=\"inv_ordered2\" id=\"inv_ordered2\" value=\'\'>\n\t<input type=\"hidden\" name=\"inv_ordered3\" id=\"inv_ordered3\" value=\'\'>\n\t<input type=\"hidden\" name=\"p_queue_date\" id=\"p_queue_date\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t<input type=\"hidden\" name=\"SickLeaveRecordFlag\" id=\"SickLeaveRecordFlag\" value=\"N\">\n\t<input type=\"hidden\" name=\"SickLeaveDetails\" id=\"SickLeaveDetails\" value=\"\">\n\t<input type=\"hidden\" name=\"recall_date\" id=\"recall_date\" value=\"\">\n\t<input type=\"hidden\" name=\"DECEASED_YN\" id=\"DECEASED_YN\" value=\"N\">\n\t<input type=\"hidden\" name=\"referred_to1\" id=\"referred_to1\" value=\"\">\t\t\t\t\n\t<input type=\'hidden\' name=\'referral_source1\' id=\'referral_source1\' value=\'\'>\t\n\t<input type=\"hidden\" name=\"from_fac_id\" id=\"from_fac_id\" value=\"\">\n\t<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" >\n\t<input type=\"hidden\" name=\"install_yn\" id=\"install_yn\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" >\n\t<input type=\"hidden\" name=\"waitlist_category_appl_yn\" id=\"waitlist_category_appl_yn\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" >\n\t<input type=\"hidden\" name=\"waitlist_category_reqd_yn\" id=\"waitlist_category_reqd_yn\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" >\n\t<input type=\"hidden\" name=\"restrict_wl_cat_agst_splty_yn\" id=\"restrict_wl_cat_agst_splty_yn\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" >\t\t\n\t <input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'> \n\t<input type=\'hidden\' name=\'pract_speciality\' id=\'pract_speciality\' value=\'\'>\n\t<input type=\'hidden\' name=\'system_date\' id=\'system_date\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n\t<input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n\t<input type=\'hidden\' name=\'spec_code\' id=\'spec_code\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t<input type=\'hidden\' name=\'episode_visit_num\' id=\'episode_visit_num\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n\t\n\t<input type=\'hidden\' name=\'create_wait_list_yn\' id=\'create_wait_list_yn\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n\t<input type=\'hidden\' name=\'modify_wait_list_yn\' id=\'modify_wait_list_yn\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n\t<input type=\'hidden\' name=\'wait_list_no\' id=\'wait_list_no\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'> \n\t<input type=\'hidden\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>\n\t<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'>\n\t<input type=\'hidden\' name=\'mr_mds_recorded\' id=\'mr_mds_recorded\' value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'><!--Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->\n\t<input type=\'hidden\' name=\'reg_reff_chkout_yn\' id=\'reg_reff_chkout_yn\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n\t<input type=\'hidden\' name=\'cls_pat_chart_on_chkout_yn\' id=\'cls_pat_chart_on_chkout_yn\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\n\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'>\n\t<!-- <input type=\'hidden\' name=\'disposition_date_time1\' id=\'disposition_date_time1\' value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'> -->\n\t<!--Below line modified for this incident [62496] -->\n\t <input type=\'hidden\' name=\'disposition_date_time1\' id=\'disposition_date_time1\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'> \n\n\n    <input type=\'hidden\' name=\'allow_chkout_with_bill_stmt_yn\' id=\'allow_chkout_with_bill_stmt_yn\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n\t<input type=\'hidden\' name=\'settle_outstanding_bills_yn\' id=\'settle_outstanding_bills_yn\' value=\'\'>\n\t<input type=\'hidden\' name=\'p_err_msg\' id=\'p_err_msg\' value=\'\'>\n\t<input type=\'hidden\' name=\'p_error_level\' id=\'p_error_level\' value=\'\'>\n\t<input type=\'hidden\' name=\'p_error_text\' id=\'p_error_text\' value=\'\'>\n\n\t<!--CRF-362 AE bed charge -->\n\t<input type=\'hidden\' name=\'ae_bed_charge_appl_yn\' id=\'ae_bed_charge_appl_yn\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>\n\t<input type=\'hidden\' name=\'charge_net_amt\' id=\'charge_net_amt\' value=\'\'>\n\t<input type=\'hidden\' name=\'patientPayble\' id=\'patientPayble\' value=\'\'>\n\t<input type=\'hidden\' name=\'bed_no\' id=\'bed_no\' value=\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'>\n\t<input type=\'hidden\' name=\'ae_bed_calYN\' id=\'ae_bed_calYN\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'>\n\t<input type=\'hidden\' name=\'modified_date_old\' id=\'modified_date_old\' value=\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n\t<input type=\'hidden\' name=\'customer_id\' id=\'customer_id\' value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'>\n\t<input type=\'hidden\' name=\'qms_interfaced_yn\' id=\'qms_interfaced_yn\' value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'>\n\t<input type=\'hidden\' name=\'room_num\' id=\'room_num\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n\t<input type=\'hidden\' name=\'queue_num\' id=\'queue_num\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n\t<input type=\'hidden\' name=\'multi_speciality_yn\' id=\'multi_speciality_yn\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n\t<!--Below line added for this CRF Bru-HIMS-CRF-133 -->\t\n\t<input type=\'hidden\' name=\'isPatientEncMovement\' id=\'isPatientEncMovement\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n\t<input type=\'hidden\' name=\'Sydate\' id=\'Sydate\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'>\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>\n\t<!--End this CRF Bru-HIMS-CRF-133 -->\n\t<input type=\'hidden\' name=\'rec_diag_not_mdt_absconded\' id=\'rec_diag_not_mdt_absconded\' value=\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'>   <!-- Added by Sangeetha for ML-MMOH-CR-0630-->\n\t<input type=\'hidden\' name=\'rec_diag_not_mdt_bid\' id=\'rec_diag_not_mdt_bid\' value=\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\'>   <!-- Added by Sangeetha for ML-MMOH-CR-0624-->\n\t<input type=\'hidden\' name=\'diag_recording_not_mndt\' id=\'diag_recording_not_mndt\' value=\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'>  <!-- Added by Sangeetha for ML-MMOH-CRF-0547-->\n\n\t<input type=\'hidden\' name=\'enableBIDOnCheckout\' id=\'enableBIDOnCheckout\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>  <!-- Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628-->\n\t<!--Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start-->\n\t<input type=\'hidden\' name=\'isDIDCallNtAroundAppl\' id=\'isDIDCallNtAroundAppl\' value=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'>  \n\t<input type=\'hidden\' name=\'recDiagNotMdtFrDid\' id=\'recDiagNotMdtFrDid\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n\t<input type=\'hidden\' name=\'recDiagNtMdtFrCallNtAround\' id=\'recDiagNtMdtFrCallNtAround\' value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n\t<!--End-->\n\n\t<!--Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646 Start-->\n\t<input type=\'hidden\' name=\'isCaseDtlsRadioBtnAppl\' id=\'isCaseDtlsRadioBtnAppl\' value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\'>\n\t<input type=\'hidden\' name=\'OandG_yn\' id=\'OandG_yn\' value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'>\n\t<input type=\'hidden\' name=\'oscc_yn\' id=\'oscc_yn\' value=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'>\n\t<input type=\'hidden\' name=\'trauma_yn\' id=\'trauma_yn\' value=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'>\n\t<input type=\'hidden\' name=\'non_emerg_yn\' id=\'non_emerg_yn\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\'>\n\t<input type=\'hidden\' name=\'mechInjCatgCode\' id=\'mechInjCatgCode\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\n\t<input type=\'hidden\' name=\'mechInjSubCatgCode\' id=\'mechInjSubCatgCode\' value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'>\n\t<!--End-->\n\n\t<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->\n\t<input type=\'hidden\' name=\'invokeRecallForAE\' id=\'invokeRecallForAE\' value=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'>\n\t<!--End ML-MMOH-CRF-0657-->\n\n\t<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n\t<input type=\'hidden\' name=\'isReconfirmCOTAppl\' id=\'isReconfirmCOTAppl\' value=\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\'>\n\t<input type=\'hidden\' name=\'reconf_cot_param\' id=\'reconf_cot_param\' value=\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\'>\n\t<input type=\'hidden\' name=\'isDeathRegisterFormAppl\' id=\'isDeathRegisterFormAppl\' value=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023 -->\n\t<input type=\'hidden\' name=\'enable_death_reg_form\' id=\'enable_death_reg_form\' value=\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023 -->\n\t<input type=\'hidden\' name=\'death_reg_form_accession_num\' id=\'death_reg_form_accession_num\' value=\'";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023 -->\n\t<input type=\'hidden\' name=\'callback_mode\' id=\'callback_mode\' value=\'Add\'><!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 01-09-2023 -->\n\t<input type=\'hidden\' name=\'caseTypeYn\' id=\'caseTypeYn\' value=\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1653-->\n\t<input type=\'hidden\' name=\'caseTypeMandYn\' id=\'caseTypeMandYn\' value=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1653 -->\n\n\t<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->\n\t<input type=\'hidden\' name=\'mds_chk\' id=\'mds_chk\' value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\'>\n\t\n\t<input type=\'hidden\' name=\'rcmApplicable\' id=\'rcmApplicable\' value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'>\n\n\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t<input type=\"hidden\" name=\"isDeceasedDiagClassDeathRegAppl\" id=\"isDeceasedDiagClassDeathRegAppl\" value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n\t<input type=\"hidden\" name=\"primary_diag_class\" id=\"primary_diag_class\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n\t<input type=\"hidden\" name=\"pri_mand_postmortem_op_yn\" id=\"pri_mand_postmortem_op_yn\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t<input type=\"hidden\" name=\"pri_mand_postmortem_ae_yn\" id=\"pri_mand_postmortem_ae_yn\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n\t<input type=\"hidden\" name=\"pri_mand_non_postmortem_op_yn\" id=\"pri_mand_non_postmortem_op_yn\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n\t<input type=\"hidden\" name=\"pri_mand_non_postmortem_ae_yn\" id=\"pri_mand_non_postmortem_ae_yn\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n\t<input type=\"hidden\" name=\"secondary_diag_class\" id=\"secondary_diag_class\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n\t<input type=\"hidden\" name=\"sec_mand_postmortem_op_yn\" id=\"sec_mand_postmortem_op_yn\" value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n\t<input type=\"hidden\" name=\"sec_mand_postmortem_ae_yn\" id=\"sec_mand_postmortem_ae_yn\" value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n\t<input type=\"hidden\" name=\"sec_mand_non_postmortem_op_yn\" id=\"sec_mand_non_postmortem_op_yn\" value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\">\n\t<input type=\"hidden\" name=\"sec_mand_non_postmortem_ae_yn\" id=\"sec_mand_non_postmortem_ae_yn\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\">\n\t<input type=\"hidden\" name=\"practitioner_type\" id=\"practitioner_type\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n\t<input type=\"hidden\" name=\"date_of_birth\" id=\"date_of_birth\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">\n\t<input type=\"hidden\" name=\"patientgender\" id=\"patientgender\" value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\">\n\n\t<script>\n\t/*Added by Thamizh selvi against ML-MMOH-CRF-0646 Start*/\n\tif(document.forms[0].isCaseDtlsRadioBtnAppl.value == \"true\" && document.forms[0].module_id.value == \"AE\"){\n\t\tif(document.forms[0].trauma_yn.value != \"Y\" && document.forms[0].oscc_yn.value != \"Y\" && document.forms[0].surgical_yn.value != \"Y\" && document.forms[0].OandG_yn.value != \"Y\" && document.forms[0].non_emerg_yn.value != \"Y\"){\n\t\t\tdocument.forms[0].medical.checked\t= true;\n\t\t\tdocument.forms[0].medical_yn.value\t= \"Y\"\n\t\t}\n\t\tonLoadCaseDtlsChk();\n\t}/*End*/\n\t";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t\tdocument.forms[0].cancel.disabled=true;\n\t\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t</script>\n\t";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\n</form>\n<script>\nif (\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\"==\"AE\")\n{\n\tdocument.getElementById(\"cnl_episode\").disabled=true;\n}\nelse\n{\n\t\n\tif(\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\" == \"\")\n\t{\t\t\t\t\t\n\t\tdocument.getElementById(\"cnl_episode\").disabled=true; \t\t\n\t\t   \n\t}\n\telse\n\t{\t\t\t\t\t\n\t\tdocument.getElementById(\"cnl_episode\").disabled=false;\t\t\t\t\n\t}\n}\ndisableRecallDtlsOnAE();\ndisable();\n//Modified by Shanmukh for ML-MMOH-CRF-0626 on 17-Apr-2018\nif(document.forms[0].disposition_type){// Wednesday, March 17, 2010 20090 Venkat s\n\tvar disposition_type=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\';\n\tvar DispositionType=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\';\n\tif(\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"==\"Y\") {\n\t\tdocument.forms[0].disposition_type.value=\'\';\n    }else{\t\t\n\t\t\tif(document.forms[0].customer_id.value!= \'SS\'){\n\t\t\t   if(";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="){  \n\t\t\t     if(disposition_type!=DispositionType){\n\t\t\t\t     document.forms[0].disposition_type.value=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\';\n\t\t\t\t    } \n\t\t\t    }else\n\t\t\t    document.forms[0].disposition_type.value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'; \n\t\t    }  \n\t\t}\n}\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n\t<script>\n\talert(getMessage(\"MANAGE_QUEUE_NOT_ALL_CHECKOUT\",\"OP\"));\n\twindow.close();\n\thistory.go(-1);\n\t</script>\n";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForDefault(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
Connection conn=null;
	PreparedStatement pstmt   =null;		
	PreparedStatement pstmt1   =null;

	PreparedStatement pstmt2  =null;
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013

	Statement stmt_mds        = null;  //Added by Sangeetha for ML-MMOH-CRF-0630
	ResultSet rs_mds          = null;
	ResultSet rset            = null;
	ResultSet rs            = null;
	ResultSet rs1            = null;
	ResultSet rs2            = null;
	
	PreparedStatement prepstmt = null;
	ResultSet rsset = null;
	
	/*Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-646 Start*/
	Boolean isCaseDtlsRadioBtnAppl	= false;
	String OandGYn					= "N";
	String traumaYn					= "N";
	String osccYn					= "N";
	String nonEmergYn				= "N";
	String checkedOandGYn			= "";
	String checkedTraumaYn			= "";
	String checkedOsccYn			= "";
	String checkedNonEmergYn		= "";
	String mechInjCatgCode			= "";
	String mechInjSubCatgCode		= "";
	/*End*/
	String DispositionType          = "";//Added by Shanmukh for ML-MMOH-CRF-0626 on 17-04-2018

	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	Boolean isReconfirmCOTAppl = false;
	String reconf_cot_param = "";
	Boolean isDeathRegisterFormAppl = false;//Added by Ajay Hatwate for AAKH-CRF-0179 on 07/08/2023

	//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
	Boolean isMDSForMainProcAppl = false;
	Boolean rcmApplicable = false;
	String mr_mainproc_recorded = "";

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String pri_mand_postmortem_op_yn = "N";
	String pri_mand_postmortem_ae_yn = "N";
	String pri_mand_non_postmortem_op_yn = "N";
	String pri_mand_non_postmortem_ae_yn = "N";
	String secondary_diag_class = "";
	String sec_mand_postmortem_op_yn = "N";
	String sec_mand_postmortem_ae_yn = "N";
	String sec_mand_non_postmortem_op_yn = "N";
	String sec_mand_non_postmortem_ae_yn = "N";
	String practitioner_type = "";
	String date_of_birth = "";

   try{

	conn=ConnectionManager.getConnection (request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	/*end ML-MMOH-CRF-0354 [IN057191] */
	
	Boolean isLabelChngAppl =eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0123 

	Boolean enableBIDOnCheckout  =eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","ENABLE_BID_ON_CHECKOUT");  //Added by Sangeetha on 05/may/17 for ML-MMOH-CRF-0628

	Boolean isDIDCallNtAroundAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","DID_CALLNOTAROUND_NOT_REQ_DGN"); //Added by Thamizh selvi on 27th Nov 2017 against ML-MM0H-CRF-0783

	isCaseDtlsRadioBtnAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE","SEC_TRIAGE_CASE_DETAILS");//Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-646
	
	Boolean isAutoCompDispTypeAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP","AUTO_COMP_DISP_TYPE"); //Added by Shanmukh on 17-Apr-2018 against ML-MMOH-CRF-0626

	Boolean isDischargeClearanceAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_AE_DISC_CLEAR_YN"); //Added by Ashwini on 22-Oct-2018 for GHL-CRF-0514 

	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	isReconfirmCOTAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "RECONFIRM_CASE_OF_TRAUMA");
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 08-08-2023

	//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
	isMDSForMainProcAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MDS_FOR_MAIN_PROCEDURE");
	
	rcmApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn,"BL","RCM_TRANS_FIELDS_MOH");

	isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		
	String locale=(String)session.getAttribute("LOCALE"); 
	StringBuffer sql               = new StringBuffer();
	StringBuffer sql1              = new StringBuffer();
	String userid                  = (String) session.getValue("login_user");
    String practitioner_name       = "";
	String  service_desc="";
	String open_to_all_prac_for_clinic_yn	= request.getParameter("open_to_all_prac_for_clinic_yn");
	if(open_to_all_prac_for_clinic_yn == null)	
		open_to_all_prac_for_clinic_yn = "";
    String open_to_all_pract_yn	= request.getParameter("open_to_all_pract_yn");
	if(open_to_all_pract_yn == null)	
		open_to_all_pract_yn = "N";

	String treatment_area_code	= request.getParameter("treatment_area_code");
	if(treatment_area_code == null || treatment_area_code.equals("null"))	
		treatment_area_code = "";
    String episode_type="";
	String visit_type_code="";
	String diagrecord="";
	String notesrecord="";
	String diagReqd="N";
	String notesReqd="N";
	String dispReqd="N";
	String OsVal = "";
	String modified_date="";
	String vital_signs_date_time="";
	String arrive_date_time="";
	String close_pat_chart_on_checkout_yn="";
	String fac_id       = (String) session.getValue( "facility_id" ) ;
	String called_from=request.getParameter("called_from");
	String five_level_triage_appl_yn = "N";
	String rec_diag_not_mdt_absconded = "N";   //Added by Sangeetha for ML-MMOH-CRF-0630
	String rec_diag_not_mdt_bid = "N";   //Added by Sangeetha for ML-MMOH-CRF-0624

	/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
	JSONObject aeParamJson		= new JSONObject();
	aeParamJson					= eAE.AECommonBean.getAEParam(conn, fac_id);
	String invokeRecallForAE	= (String)aeParamJson.get("invokeRecallForAE");
	/*End ML-MMOH-CRF-0657*/
	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	reconf_cot_param			= (String)aeParamJson.get("reconfirm_case_of_trauma");

	/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
	String recDiagNotMdtFrDid			= "N";
	String recDiagNtMdtFrCallNtAround	= "N";
	/*End*/

		/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
		String sqlmrparam = " SELECT b.primary_diag_class, b.pri_mand_postmortem_op_yn, b.pri_mand_postmortem_ae_yn, b.pri_mand_non_postmortem_op_yn, b.pri_mand_non_postmortem_ae_yn, b.secondary_diag_class, b.sec_mand_postmortem_op_yn, b.sec_mand_postmortem_ae_yn, b.sec_mand_non_postmortem_op_yn, b.sec_mand_non_postmortem_ae_yn FROM mr_parameter b ";

		prepstmt = conn.prepareStatement(sqlmrparam);
		rsset = prepstmt.executeQuery();
		
		if ((rsset != null) && (rsset.next())) {

			primary_diag_class = rsset.getString("primary_diag_class");
		    if(primary_diag_class == null) primary_diag_class = "";

			pri_mand_postmortem_op_yn = rsset.getString("pri_mand_postmortem_op_yn");
		    if(pri_mand_postmortem_op_yn == null) pri_mand_postmortem_op_yn = "N";

			pri_mand_postmortem_ae_yn = rsset.getString("pri_mand_postmortem_ae_yn");
		    if(pri_mand_postmortem_ae_yn == null) pri_mand_postmortem_ae_yn = "N";

			pri_mand_non_postmortem_op_yn = rsset.getString("pri_mand_non_postmortem_op_yn");
		    if(pri_mand_non_postmortem_op_yn == null) pri_mand_non_postmortem_op_yn = "N";

			pri_mand_non_postmortem_ae_yn = rsset.getString("pri_mand_non_postmortem_ae_yn");
		    if(pri_mand_non_postmortem_ae_yn == null) pri_mand_non_postmortem_ae_yn = "N";

			secondary_diag_class = rsset.getString("secondary_diag_class");
		    if(secondary_diag_class == null) secondary_diag_class = "";

			sec_mand_postmortem_op_yn = rsset.getString("sec_mand_postmortem_op_yn");
		    if(sec_mand_postmortem_op_yn == null) sec_mand_postmortem_op_yn = "N";

			sec_mand_postmortem_ae_yn = rsset.getString("sec_mand_postmortem_ae_yn");
		    if(sec_mand_postmortem_ae_yn == null) sec_mand_postmortem_ae_yn = "N";

			sec_mand_non_postmortem_op_yn = rsset.getString("sec_mand_non_postmortem_op_yn");
		    if(sec_mand_non_postmortem_op_yn == null) sec_mand_non_postmortem_op_yn = "N";

			sec_mand_non_postmortem_ae_yn = rsset.getString("sec_mand_non_postmortem_ae_yn");
		    if(sec_mand_non_postmortem_ae_yn == null) sec_mand_non_postmortem_ae_yn = "N";
		}

		if(prepstmt!=null) prepstmt.close();
		if(rsset!=null) rsset.close();

		/*End ML-MMOH-CRF-1742*/
	
	String caseTypeYn = "";
	String caseTypeMandYn = "";
	String caseType="";
	
	if(called_from == null || called_from.equals("null") ) called_from="";
	
	String sqlqry1	= "select five_level_triage_appl_yn, REC_DIAG_NOT_MDT_ABSCONDED, REC_DIAG_NOT_MDT_BID, REC_DIAG_NOT_MDT_DID_YN, REC_DIAG_MDT_CALLNOTAROUND_YN, case_type_yn, case_type_mand_yn from ae_param where OPERATING_FACILITY_ID='"+fac_id+"'"; //Modified by Sangeetha or ML-MMOH-CRF-0624
	pstmt = conn.prepareStatement(sqlqry1);
	rset = pstmt.executeQuery();
	
	while(rset!=null && rset.next()){
		five_level_triage_appl_yn			=	(rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");

		rec_diag_not_mdt_absconded			=	(rset.getString("rec_diag_not_mdt_absconded")==null || rset.getString("rec_diag_not_mdt_absconded")=="")?"N":rset.getString("rec_diag_not_mdt_absconded");   //Added by Sangeetha for ML-MMOH-CRF-0630

		rec_diag_not_mdt_bid			=	(rset.getString("rec_diag_not_mdt_bid")==null || rset.getString("rec_diag_not_mdt_bid")=="")?"N":rset.getString("rec_diag_not_mdt_bid");   //Added by Sangeetha for ML-MMOH-CRF-0624
		/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
		recDiagNotMdtFrDid				=	(rset.getString("REC_DIAG_NOT_MDT_DID_YN")==null || rset.getString("REC_DIAG_NOT_MDT_DID_YN").equals("")) ? "N" : rset.getString("REC_DIAG_NOT_MDT_DID_YN");
		recDiagNtMdtFrCallNtAround		=	(rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN")==null || rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN")=="") ? "N" : rset.getString("REC_DIAG_MDT_CALLNOTAROUND_YN");
		/*End*/
		/* Added by Ajay Hatwate for ML-MMOH-CRF-1653 */
		caseTypeYn = (rset.getString("case_type_yn")==null || rset.getString("case_type_yn")=="") ? "N" : rset.getString("case_type_yn");
		caseTypeMandYn = (rset.getString("case_type_mand_yn")==null || rset.getString("case_type_mand_yn")=="") ? "N" : rset.getString("case_type_mand_yn");
		/* End of ML-MMOH-CRF-1653 */
	}
	if(pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();

	
	
	
	
	
	    /*Below line added for this CRF Bru-HIMS-CRF-133*/		
		 String isPatientEncMovement = request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		 String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		 //End Bru-HIMS-CRF-133

	String ca_practitioner_id="";
	String ca_pract_type="";
	String mr_mds_recorded = "N";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String allow_chkout_with_bill_stmt_yn  = request.getParameter("allow_chkout_with_bill_stmt_yn");
	if(allow_chkout_with_bill_stmt_yn== null)    allow_chkout_with_bill_stmt_yn = "N";

    String p_episode_id					= request.getParameter("episode_id");
	if(p_episode_id== null)    p_episode_id = "";

	 String bed_no					= request.getParameter("bed_no");
	if(bed_no== null)    bed_no = "";

	String ae_bed_calYN					= request.getParameter("ae_bed_calYN");
	if(ae_bed_calYN== null)    ae_bed_calYN = "";
	


	if(called_from.equals("CA"))
	{
		ca_practitioner_id=(String) session.getValue("ca_practitioner_id") ;
	    if(ca_practitioner_id == null)ca_practitioner_id="";
	}	
	
	String P_encounter_id=request.getParameter("encounterid");
	String P_practitioner_id = request.getParameter("practitionerid");
	if(P_practitioner_id== null)    P_practitioner_id = "";
	if(P_practitioner_id.equals("null"))    P_practitioner_id = "" ;

	String P_locn_code = request.getParameter("locationcode");
	if(P_locn_code==null)   P_locn_code = "" ;
	if(P_locn_code.equals("null"))   P_locn_code = "" ;
	String P_patient_id = (request.getParameter("patientid") == null)?"":request.getParameter("patientid");
	String bl_install_yn=(String) session.getValue( "bl_operational" ) ;	

	String P_locn_type = request.getParameter("locationtype");	
	String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");	

	String p_queue_date="";
	if(P_locn_type==null)   P_locn_type = "" ;
	if(P_locn_type.equals("null"))   P_locn_type = "" ;     
	String P_module_id = request.getParameter("module_id");
	if(P_module_id == null) P_module_id = "OP" ;
	if(P_module_id.equals(""))  P_module_id = "OP" ;	
	
	String p_calling_function    = request.getParameter("p_calling_function");
	p_calling_function           = (p_calling_function==null)?"":p_calling_function;
	
	String P_ae_brought_dead_yn = request.getParameter("ae_brought_dead_yn");

	if(P_ae_brought_dead_yn == null)    P_ae_brought_dead_yn = "N" ;
	String P_ae_treatment_area_code = request.getParameter("ae_treatment_area_code");
	if(P_ae_treatment_area_code == null || P_ae_treatment_area_code.equals("null"))    P_ae_treatment_area_code = "";/*null is checked for String by Rameswar for ML-MMOH-SCF-0446 on 10-Aug-16*/
	if(P_ae_treatment_area_code.equals(" "))    P_ae_treatment_area_code = "";
	String disable_all = ( P_ae_brought_dead_yn.equals("Y")?"disabled":"");
	String patient_class="";
	int mother_cut_off_age=0;
	int mother_max_age=0;
	int mother_min_age=0; 	
	String appt_id="";
	String visit_adm_type_ind="";
	   
	String X_visit_type_desc    ="";
	String X_attend_prac_id     ="";
	String X_episode_id ="";	
	String system_date="";
	String system_time="";
	String systemdatetime="";
	String visit_adm_date_time="";
	String check_out_yn="";
	String oper_stn_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	String episode_visit_num="";
	String specl_code ="";
	String systemdatetime_display = "";
	
	String system_datetime=""; //Added for this incident [62496]

	String qms_interfaced_yn = "";
	String queue_num = "";
	String room_num = "";
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	int mds_chk=0;
	String mode="";
	if(patient_class.equals("EM"))
	mode="EC";
	if(patient_class.equals("OP"))
	mode="OC";
	//End
	if(called_from.equals("CA"))
	 {   
		
		    String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual" ;  
            
			pstmt=conn.prepareStatement(sql_new);
            rs=pstmt.executeQuery();
            rs.next();
	        OsVal=rs.getString(1);
        
			if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {
			   check_out_yn="Y";
			   
            }else
				{
				check_out_yn="N";
				}
	
		
	 }else
	 {
		 check_out_yn="Y";
	 }

	/*Added by Ashwini on 22-Oct-2018 for GHL-CRF-0514*/
	String retVal = "";
	CallableStatement cstmt = null;

	if(P_module_id.equals("AE") && isDischargeClearanceAppl)
	{
		try
		{
			cstmt = conn.prepareCall("{ call bl_ip_details.check_fin_clear_dur_ae_trx(?,?,?,?) }");
			cstmt.setString(1,"AE_CHECK_OUT");
			cstmt.setString(2,fac_id);
			cstmt.setString(3,p_episode_id);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.execute();
			
			retVal = cstmt.getString(4);

				if (retVal == null) retVal = "";	

				if(retVal.equals(""))
				{
					check_out_yn = "Y";
				}
				else
				{				
					check_out_yn = "N";
					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(retVal));
            _bw.write(_wl_block9Bytes, _wl_block9);

				}

				if(cstmt != null) cstmt.close();
		}
		catch(Exception e) {
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	/*End GHL-CRF-0514*/

	String referral_id = "";	
	int patientage=0;
	String patientgender="";
	
	String X_pract_assigned_yn = "N";
	String mlc_yn="";
    String 	mlcchkval="";
	String pract_type="";
  
	String deceased_time="";
	String body_release_deceased_time="";
	String dronly="";
	String ddis="";
	String medical_yn="";
	String surgical_yn="";
	String spec_code="";
	int aecnt=0;
	String create_wait_list_yn="N";
	String modify_wait_list_yn="N";
	String create_wait_dis="disabled";
	String modify_wait_dis="disabled";
	String wait_list_no="";
	String reg_reff_chkout_yn="";
	String disposition_type="";	
	String install_yn="";	
	String waitlist_category_appl_yn="";				 
	String waitlist_category_reqd_yn="";
	String restrict_wl_cat_agst_splty_yn="";
	String customer_id="";
	String mr_mds_recorded_style="";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String diag_recording_not_mndt="N"; //Added by Sangeetha for ML-MMOH-CRF-0547
	customer_id=(String)session.getAttribute("CUSTOMER_ID");
	String enable_death_reg_form = "N";//Added by Ajay Hatwate for AAKH-CRF-0179
	String death_reg_form_accession_num = "";//Added by Ajay Hatwate for AAKH-CRF-0179
	
	String multi_speciality_yn="N";
		try
		{
		  if(check_out_yn.equals("Y"))
		  {

/*
			pstmt=conn.prepareStatement("select install_yn from sm_module where module_id='CA'");
			rs=pstmt.executeQuery();
    		if(rs!=null && rs.next()) {			
				cainstall=rs.getString("install_yn");           
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();				
			if( cainstall.equals("Y"))
			CRF-362 AE bed charges start	
			String sql_ae_bed="SELECT NVL(AE_BED_CHARGE_APPL_YN,'N') ae_bed_charge FROM Bl_parameters Where  operating_facility_id = ?";
			pstmt=conn.prepareStatement(sql_ae_bed);
			pstmt.setString(1,fac_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ae_bed_charge_appl_yn=rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();	
			CRF-362 AE bed charges complete
			pstmt = conn.prepareStatement("select MR_MDS_RECORDED_YN('"+fac_id+"','"+P_encounter_id+"','"+patient_class+"',null,'OC',null) from dual");
			rs=pstmt.executeQuery();
			if(rs != null && rs.next()){
				mr_mds_recorded = rs.getString(1) == null ? "N":rs.getString(1);
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	*/		              
		/*Below query modified for this incident[62496]*/	
		sql.append("SELECT  a.SERVICE_CODE,am_get_desc.am_service(a.SERVICE_CODE,'"+locale+"',2)SERVICE_desc,  TO_CHAR(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.patient_class ,a.LOCN_CODE assign_care_locn_code ,a.LOCN_TYPE assign_care_locn_type  ,a.VISIT_TYPE_CODE adm_type  ,op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type ,DECODE(a.practitioner_id,'*ALL','',a. practitioner_id) prac_id ,a.referral_id  ,CALCULATE_AGE(TO_CHAR(c.DATE_OF_BIRTH,'DD/MM/YYYY'),1)age ,TO_CHAR (c.date_of_birth, 'dd/mm/rrrr') date_of_birth, c.sex,a.arrive_date_time arrive_date_time ,a.vital_signs_date_time vital_signs_date_time,a.VISIT_TYPE_IND visit_adm_type_ind,a.appt_id appt_id  ,a.episode_id episode_id,a.OP_EPISODE_VISIT_NUM episode_visit_num,a.treatment_area_code treatment_area_code  ,(select mlc_yn from pr_encounter where encounter_id='"+P_encounter_id+"' and facility_id='"+fac_id+"') mlc_yn,(select case_type from pr_encounter where encounter_id='"+P_encounter_id+"' and facility_id='"+fac_id+"') case_type    ,TO_CHAR(c.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time  ,a.medical_yn medical_yn  ,a.surgical_yn surgical_yn  ,a.trauma_yn, a.oscc_yn, a.o_and_g_yn, a.non_emerg_yn, a.mech_injury_catg_code, a.mech_injury_subcatg_code, a.SPECIALITY_CODE SPECIALTY_CODE,TO_CHAR(a.queue_date,'dd/mm/yyyy') queue_date,TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sydate,  TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss') systemdate,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name,(select to_char(modified_date,'dd/mm/yyyy hh24:mi:ss') from pr_encounter where encounter_id='"+P_encounter_id+"' and facility_id='"+fac_id+"')modified_date,queue_num,room_num,(select multi_speciality_yn from op_clinic where CLINIC_CODE=a.LOCN_CODE and FACILITY_ID='"+fac_id+"') multi_speciality_yn, (SELECT DIAG_RECORDING_MAND_YN FROM op_clinic WHERE facility_id ='"+fac_id+"' AND clinic_code =a.LOCN_CODE) DIAG_RECORDING_MAND_YN");
	if(isDeathRegisterFormAppl){
		sql.append(", (select death_reg_form_accession_num from pr_encounter where facility_id = '"+fac_id+"' and encounter_id = "+ P_encounter_id +") accession_num ");
	}
	sql.append(" FROM  op_patient_queue a ,mp_patient c WHERE a.facility_id = '"+fac_id+"' AND a.encounter_id = '"+P_encounter_id+"' AND a.patient_id=c.patient_id");   // Modified by Sangeetha for ML-MMOH-CRF-0547
			//Modified above query by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646
			
			
			//sql.append("Select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time,a.patient_class,decode(a.patient_class,'EM','Emergency','OP','OutPatient') Nature, a.LOCN_CODE assign_care_locn_code, a.LOCN_TYPE assign_care_locn_type, ");
			//sql.append(" a.VISIT_TYPE_CODE adm_type,  b.short_desc visit_type, decode(a. practitioner_id,'*ALL','',a. practitioner_id) 	prac_id,a.referral_id,CALCULATE_AGE(TO_CHAR(c.DATE_OF_BIRTH,'DD/MM/YYYY'),1)age,c.sex,a.arrive_date_time arrive_date_time,a.vital_signs_date_time vital_signs_date_time,a.VISIT_TYPE_IND visit_adm_type_ind,a.appt_id appt_id,a.episode_id episode_id,a.OP_EPISODE_VISIT_NUM  episode_visit_num,a.treatment_area_code treatment_area_code,a.mlc_yn mlc_yn,to_char(c.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time,a.medical_yn medical_yn,a.surgical_yn surgical_yn,a.SPECIALITY_CODE SPECIALTY_CODE,to_char(a.queue_date,'dd/mm/yyyy') queue_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sydate, d.practitioner_name from op_patient_queue a, OP_VISIT_TYPE b,mp_patient c, am_practitioner d");
			//sql.append(" where a.facility_id = '"+fac_id+"' and a.encounter_id = '"+P_encounter_id+"' and a.facility_id=b.facility_id and a.visit_type_code = b.visit_type_code and a.patient_id=c.patient_id and a.practitioner_id=d.practitioner_id(+)");			
			pstmt=conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
			{                  
                       
				if(isDeathRegisterFormAppl){
					death_reg_form_accession_num = (rs.getString("accession_num")==null)?"":rs.getString("accession_num");
				}
				X_visit_type_desc = (rs.getString("visit_type") == null)?"":rs.getString("visit_type");
				X_attend_prac_id = (rs.getString("prac_id") == null)?"":rs.getString("prac_id");
				practitioner_name = (rs.getString("practitioner_name") == null)?"":rs.getString("practitioner_name");

				if(X_attend_prac_id == null)
					X_attend_prac_id="";
				
				P_locn_code = rs.getString("assign_care_locn_code") ;
				if(P_locn_code==null)   P_locn_code = "" ;
				P_locn_type = rs.getString("ASSIGN_CARE_LOCN_TYPE") ;
				if(P_locn_type==null)   P_locn_type = "" ;
                 service_desc=rs.getString("service_desc")==null?"":rs.getString("service_desc");
				referral_id = rs.getString("referral_id");
				if(referral_id == null || referral_id.equals("null")) referral_id = "";
				patient_class=(rs.getString("patient_class")== null)?"":rs.getString("patient_class");
				if(patient_class.equals("EM"))
				episode_type="E";	
				else
                episode_type="O";	 
				
				patientage=Integer.parseInt(rs.getString("age"));
				patientgender=(rs.getString("sex") == null)?"":rs.getString("sex");
				date_of_birth = (rs.getString("date_of_birth") == null)?"":rs.getString("date_of_birth");
				arrive_date_time= (rs.getString("arrive_date_time") == null)?"":rs.getString("arrive_date_time");
				vital_signs_date_time=(rs.getString("vital_signs_date_time") == null)?"":rs.getString("vital_signs_date_time");
				visit_adm_type_ind=(rs.getString("visit_adm_type_ind") == null)?"":rs.getString("visit_adm_type_ind");
				appt_id=(rs.getString("appt_id") == null)?"":rs.getString("appt_id");
				X_episode_id=(rs.getString("episode_id") == null)?"":rs.getString("episode_id");
				visit_type_code=(rs.getString("adm_type") == null)?"":rs.getString("adm_type");
				episode_visit_num =(rs.getString("episode_visit_num") == null)?"":rs.getString("episode_visit_num");
				modified_date =(rs.getString("modified_date") == null)?"":rs.getString("modified_date");
				queue_num =(rs.getString("queue_num") == null)?"":rs.getString("queue_num");
				room_num =(rs.getString("room_num") == null)?"":rs.getString("room_num");
				multi_speciality_yn =(rs.getString("multi_speciality_yn") == null)?"N":rs.getString("multi_speciality_yn");
				diag_recording_not_mndt=rs.getString("DIAG_RECORDING_MAND_YN");  //Added by Sangeetha for ML-MMOH-CRF-0547

				qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(P_locn_code,fac_id,conn);
				if(P_ae_treatment_area_code.equals(""))
				{
					P_ae_treatment_area_code=(rs.getString("treatment_area_code") == null)?"":rs.getString("treatment_area_code");
				}
				
				P_practitioner_id=X_attend_prac_id;

				mlc_yn=rs.getString("mlc_yn");
				if(mlc_yn == null) mlc_yn="N";
				
				caseType = rs.getString("case_type");
				if(caseType == null) caseType="";

				deceased_time=rs.getString("deceased_time");
				deceased_time=DateUtils.convertDate(deceased_time,"DMYHM","en",locale);
				if(deceased_time == null) deceased_time="";

				if(!deceased_time.equals(""))
				{
					dronly="";
					ddis="";
					body_release_deceased_time=deceased_time;
				}
				else
				{
					dronly="readOnly";
					ddis="disabled";
				}
				
				medical_yn=rs.getString("medical_yn");
				if(medical_yn == null) medical_yn="N";

				surgical_yn=rs.getString("surgical_yn");
				if(surgical_yn == null) surgical_yn="N";

				/*Added by Thamizh selvi against ML-MMOH-CRF-0645 Start*/
				traumaYn			= checkForDefault(rs.getString("trauma_yn"),"N");
				osccYn				= checkForDefault(rs.getString("oscc_yn"),"N");
				OandGYn				= checkForDefault(rs.getString("o_and_g_yn"),"N");
				nonEmergYn			= checkForDefault(rs.getString("non_emerg_yn"),"N");
				mechInjCatgCode		= checkForNull(rs.getString("mech_injury_catg_code"));
				mechInjSubCatgCode	= checkForNull(rs.getString("mech_injury_subcatg_code"));
				/*End*/

				visit_adm_date_time=rs.getString("visit_adm_date_time");
				if(visit_adm_date_time == null) visit_adm_date_time="";
				spec_code=rs.getString("SPECIALTY_CODE");
				if(spec_code == null) spec_code="";
				p_queue_date=rs.getString("queue_date");
				if(p_queue_date == null) p_queue_date="";
				systemdatetime = rs.getString("sydate");
  			    system_date = systemdatetime.substring(0,10);	
			    system_time = systemdatetime.substring(11,16);

				systemdatetime_display=DateUtils.convertDate(systemdatetime,"DMYHM","en",locale);				
                
				/*Below line added for this incident[62496]*/
                system_datetime	= rs.getString("systemdate");	
               // system_datetime = DateUtils.convertDate(system_datetime,"DMYHMS","en",locale);				
				
			}			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();		
				sql.setLength(0);	

			/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
			String sqlpract = " select pract_type, practitioner_name from AM_PRACTITIONER_LANG_VW where practitioner_id = '"+P_practitioner_id+"' and language_id = '"+locale+"' ";

			prepstmt = conn.prepareStatement(sqlpract);
			rsset = prepstmt.executeQuery();
			
			if ((rsset != null) && (rsset.next())) {
				practitioner_type = rsset.getString("pract_type");
			}

			if(prepstmt!=null) prepstmt.close();
			if(rsset!=null) rsset.close();
			/*End ML-MMOH-CRF-1742*/

				//Modified by Shanmukh for ML-MMOH-CRF-0626 on 17-04-2018
				//Maheshwaran K modified MR_MDS_RECORDED_YN for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
				StringBuffer sqlquery = new StringBuffer(); // sathya sai migrated issue Wednesday, June 09, 2010 Venkat s
				sqlquery.append("Select nvl(a.DISP_REQD_FOR_MDS_YN,'N') DISP_YN, nvl(a.DIAG_REQD_FOR_MDS_YN,'N') DIAG_YN, nvl(a.NOTES_REQD_FOR_MDS_YN,'N') NOTES_YN,a.REG_REFERRAL_ON_CHECKOUT_YN ,a.DISP_TYPE_FOR_CHECKOUT,a.DISP_TYPE_FOR_AUTO_VISIT_COMPL,a.close_pat_chart_on_checkout_yn, (select NVL(b.AE_BED_CHARGE_APPL_YN,'N') ae_bed_charge from Bl_parameters b where b.operating_facility_id='"+fac_id+"') ae_bed_charge, MR_MDS_RECORDED_YN('"+fac_id+"','"+P_encounter_id+"','"+patient_class+"',null,'"+mode+"',null) mr_mds_recorded, d.waitlist_category_appl_yn,d.waitlist_category_reqd_yn, d.restrict_wl_cat_agst_splty_yn,(select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id=?) install_yn ");
				sqlquery.append(", c.ENBL_DEATH_REG_FORM_DECEASED ");//Added by Ajay Hatwate for AAKH-CRF-0179
				if (!patient_class.equals("EM")) {
					sqlquery.append(",AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CREATE_WAIT_LIST_YN') create_wait_list_yn, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','MODIFY_WAIT_LIST_YN') modify_wait_list_yn");
				 }
				if(patientgender.equals("F")) {
					sqlquery.append(",c.nb_mother_cutoff_age mother_cut_off_age, c.nb_mother_upper_age mother_max_age,c.nb_mother_min_age mother_min_age ");
				}
				sqlquery.append(" from OP_PARAM a , mp_param c , oa_param d where  a.operating_facility_id = ? and c.module_id = 'MP' and d.module_id = 'OA'  ");
			    String ae_bed_charge_appl_yn="";

				pstmt=conn.prepareStatement(sqlquery.toString());
				pstmt.setString(1,fac_id);
				pstmt.setString(2,fac_id);
				rs=pstmt.executeQuery();
				if(rs!=null  && rs.next())
				{	
					//Added by Shanmukh for ML-MMOH-CRF-0626 on 17-04-2018
					DispositionType=rs.getString("DISP_TYPE_FOR_AUTO_VISIT_COMPL");              
						if(DispositionType==null)		DispositionType="";
						
						//END
					dispReqd=rs.getString("DISP_YN");
					diagReqd=rs.getString("DIAG_YN");
					notesReqd=rs.getString("NOTES_YN");
		            reg_reff_chkout_yn=rs.getString("REG_REFERRAL_ON_CHECKOUT_YN");
			        disposition_type=rs.getString("DISP_TYPE_FOR_CHECKOUT");
				    ae_bed_charge_appl_yn=rs.getString("ae_bed_charge");		 
					install_yn=rs.getString("install_yn")==null?"N":rs.getString("install_yn");						
					waitlist_category_appl_yn=rs.getString("WAITLIST_CATEGORY_APPL_YN")==null?"N":rs.getString("WAITLIST_CATEGORY_APPL_YN");	 
					waitlist_category_reqd_yn=rs.getString("WAITLIST_CATEGORY_REQD_YN")==null?"N":rs.getString("WAITLIST_CATEGORY_REQD_YN");	
					restrict_wl_cat_agst_splty_yn=	rs.getString("RESTRICT_WL_CAT_AGST_SPLTY_YN")==null?"N":rs.getString("RESTRICT_WL_CAT_AGST_SPLTY_YN");	
					close_pat_chart_on_checkout_yn=rs.getString("close_pat_chart_on_checkout_yn")==null?"N":rs.getString("close_pat_chart_on_checkout_yn");				
					mr_mds_recorded = rs.getString("mr_mds_recorded") == null ? "N":rs.getString("mr_mds_recorded");//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
					if(patientgender.equals("F")) {
						mother_cut_off_age=(rs.getString("mother_cut_off_age")	== null)?Integer.parseInt("0"):							Integer.parseInt(rs.getString("mother_cut_off_age"));
						mother_max_age=(rs.getString("mother_max_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs.getString("mother_max_age"));
						mother_min_age=(rs.getString("mother_min_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs.getString("mother_min_age"));
					}
					if (!patient_class.equals("EM")) {
						create_wait_list_yn = rs.getString("create_wait_list_yn");
						modify_wait_list_yn=rs.getString("modify_wait_list_yn");			
					}
				    if(disposition_type==null)disposition_type="";
				    enable_death_reg_form = rs.getString("ENBL_DEATH_REG_FORM_DECEASED")==null?"N":rs.getString("ENBL_DEATH_REG_FORM_DECEASED");//Added by Ajay Hatwate for AAKH-CRF-0179
				}				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				if(diagReqd.equals("Y"))
				{
					String diagrecqry=" select 1 from  pr_problem where ONSET_FACILITY_ID='"+fac_id+"' and ONSET_ENCOUNTER_ID='"+P_encounter_id+"'";
					pstmt=conn.prepareStatement(diagrecqry);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()) 
					{
						diagrecord=rs.getString("1");  
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
	
				}

				if(notesReqd.equals("Y"))
				{
					String notesrecqry="SELECT 'Y' FROM CA_ENCNTR_NOTE WHERE FACILITY_ID='"+fac_id+"' AND ENCOUNTER_ID='"+ P_encounter_id+"' AND EVENT_STATUS!='9'";
					pstmt=conn.prepareStatement(notesrecqry);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next())	
					{
						notesrecord=rs.getString(1);  //notesRecorded
					} 
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}			
            if (!patient_class.equals("EM")) {									
				  if((!create_wait_list_yn.equals("1")) && (!create_wait_list_yn.equals("2")) && (!create_wait_list_yn.equals("3")) && (!create_wait_list_yn.equals("4"))) {
					  create_wait_list_yn="Y";
				  } else {
					 create_wait_list_yn="N";
				  }
				  if((!modify_wait_list_yn.equals("1")) && (!modify_wait_list_yn.equals("2")) && (!modify_wait_list_yn.equals("3")) && (!modify_wait_list_yn.equals("4"))) {
					 modify_wait_list_yn ="Y";						 
			     } else {
					 modify_wait_list_yn ="N";
				 }					
				 if(create_wait_list_yn.equals("Y") && modify_wait_list_yn.equals("Y")) {
					pstmt = conn.prepareStatement("SELECT wait_list_no FROM pr_wait_list WHERE facility_id = '"+fac_id+"' AND patient_id = '"+P_patient_id+"' AND wait_list_status='O' and specialty_code='"+spec_code+"' AND (preferred_date_time IS NULL OR preferred_date_time  >= SYSDATE) and rownum < 2 ");
					rs=pstmt.executeQuery();					
					if(rs != null) {
						if(rs.next()) {
							wait_list_no=rs.getString(1);							
						  }
					 }
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
	      }
			if(create_wait_list_yn.equals("Y") && wait_list_no.equals(""))
			{
				create_wait_dis="";
				modify_wait_dis="disabled";
				
			}else if((modify_wait_list_yn.equals("Y")) && (!wait_list_no.equals("")))
			{
				create_wait_dis="disabled";
				modify_wait_dis="";
				
			}
		    if(P_module_id.equals("AE"))
  	        {
				create_wait_dis="disabled";
			}
			String msenable="disabled";
			String mscheck1="";
			String mscheck2="";
			String bdeaddis=""; 
	 if(P_module_id.equals("AE")) {
		 msenable="";
		 if(medical_yn.equals("Y"))
			 mscheck1="checked";
		 else
			 mscheck1="";
		 if(surgical_yn.equals("Y"))
			 mscheck2="checked";
		 else
			 mscheck2="";
		if(P_ae_brought_dead_yn.equals("Y")){
			//Added by Sangeetha for ML-MMOH-CRF-0628 on 8/may/17
			 if(enableBIDOnCheckout)
			 bdeaddis="";
			 else
			 bdeaddis="disabled";
		}
		else
			 bdeaddis="disabled";
		
		/*Added by Thamizh selvi against ML-MMOH-CRF-0645 Start*/
		if(traumaYn.equals("Y"))
			checkedTraumaYn		= "checked";
		else
			checkedTraumaYn		= "";
		if(osccYn.equals("Y"))
			checkedOsccYn		= "checked";
		else
			checkedOsccYn		= "";
		if(OandGYn.equals("Y"))
			checkedOandGYn		= "checked";
		else
			checkedOandGYn		= "";
		if(nonEmergYn.equals("Y"))
			checkedNonEmergYn	= "checked";
		else
			checkedNonEmergYn	= "";
		/*End*/
	  }
	  else
	  {
		  msenable="disabled";
		  if(medical_yn.equals("Y"))
			 mscheck1="checked";
		 else
			 mscheck1="";

		 if(surgical_yn.equals("Y"))
			 mscheck2="checked";
		 else
			 mscheck2="";
		bdeaddis="disabled";
	  }
	
	if(mlc_yn.equals("Y"))
	{
		mlcchkval="checked";
	}
	else
	{
		mlcchkval="";
	}
	//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	try
		{
		//String sql_mds="select count(*) as cnt from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y'";
		String sql_mds_code="select MDS_CODE from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y'";  //Added by Sangeetha for ML-MMOH-CRF-0630

		//stmt=conn.createStatement();
		//rset=stmt.executeQuery(sql_mds);
		stmt_mds =conn.createStatement();    //Added by Sangeetha for ML-MMOH-CRF-0630
		rs_mds=stmt_mds.executeQuery(sql_mds_code);

		/*if(rset.next())
			{
			mds_chk=rset.getInt("cnt");
			}*/

        //Added by Sangeetha for ML-MMOH-CRF-0630
		while(rs_mds.next())
			{
			mds_chk++;
			out.println("<script>mds_code_arr[count]='"+rs_mds.getString("MDS_CODE")+"';count++;</script>"); 
			}

		if(stmt_mds!=null) stmt_mds.close();
		if(rs_mds!=null) rs_mds.close();
		}
	catch(Exception e)	
		{
		e.printStackTrace();
		}
	//End	
	
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(P_module_id.equals("AE")){ 
            _bw.write(_wl_block11Bytes, _wl_block11);
if(isDeathRegisterFormAppl  && enable_death_reg_form.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);
 } else { 
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(X_visit_type_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
   
						if(called_from.equals("CA") && patient_class.equals("EM"))
						{
							pstmt=conn.prepareStatement("select PRACT_TYPE from am_practitioner where practitioner_id='"+ca_practitioner_id+"'");
							rs=pstmt.executeQuery();
							if(rs != null && rs.next())
							{
								ca_pract_type=rs.getString("PRACT_TYPE");
							}

							
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						}
						if((!X_attend_prac_id.equals("") && !patient_class.equals("EM"))  || ((called_from.equals("CA") && !patient_class.equals("EM")) || ((called_from.equals("CA") && patient_class.equals("EM")) && (!ca_pract_type.equals("MD") && !ca_pract_type.equals("SG") && !ca_pract_type.equals("PS") && !ca_pract_type.equals("DN")))))
						{

							P_practitioner_id = X_attend_prac_id;
                            
							sql.append("select practitioner_name, am_get_desc.am_pract_type(pract_type,'"+locale+"','1')pract_type_desc from am_practitioner_lang_vw where practitioner_id = '"+X_attend_prac_id+"' and language_id='"+locale+"'");
                            pstmt=conn.prepareStatement(sql.toString());
                            rs = pstmt.executeQuery();                           
                                         
                            if(rs.next() )
                            {					
							  out.println("<td  class='label' width='15%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</td>");
							  
                              out.println("<td class = querydata nowrap width='10%' align='right'><b>"+rs.getString( "practitioner_name" )+"/"+rs.getString( "pract_type_desc" )+"</b>");								
                                out.println(" <input type='hidden' name= 'attending_practitioner' id= 'attending_practitioner'  size='15' maxlength='15' value='"+X_attend_prac_id+"' readonly></td>");
                               
                            }   

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sql.setLength(0);
						}
						else
						{
							X_pract_assigned_yn = "Y";			

							if(P_module_id.equals("AE"))
							{
						
								if(!P_ae_treatment_area_code.equals(""))
								{
									sql.append("SELECT a.open_to_all_pract_yn open_to_all_pract_yn, a.pract_type,a.speciality_code,b.open_to_all_prac_for_clinic_yn open_to_all_prac_for_clinic_yn ,a.primary_resource_class primary_resource_class FROM op_clinic a, AE_TMT_AREA_FOR_CLINIC b WHERE a.facility_id = '"+fac_id+"' AND a.clinic_code ='"+P_locn_code+"' AND a.facility_id = b.facility_id AND b.CLINIC_CODE = a.clinic_code	AND B.TREATMENT_AREA_CODE = '"+P_ae_treatment_area_code+"'");
								}
								else
								{
									sql.append("SELECT a.open_to_all_pract_yn open_to_all_pract_yn, a.pract_type,a.speciality_code,a.primary_resource_class primary_resource_class FROM op_clinic a	WHERE a.facility_id ='"+fac_id+"' 	AND a.clinic_code ='"+P_locn_code+"'");
								}
					
							}
							else
							{

							sql.append("Select open_to_all_pract_yn, pract_type, speciality_code, primary_resource_class from OP_CLINIC where facility_id = '"+fac_id+"' and clinic_code = '"+P_locn_code+"' ");
							}
							pstmt=conn.prepareStatement(sql.toString());
							rs = pstmt.executeQuery();
							if(rs != null && rs.next())
							{

								String open_to_all_pract = (rs.getString("open_to_all_pract_yn") == null)?"N":rs.getString("open_to_all_pract_yn");
								if(open_to_all_pract_yn.equals("N"))
								{
									open_to_all_pract_yn=open_to_all_pract;
								}
					
								if(P_module_id.equals("AE") && open_to_all_prac_for_clinic_yn.equals(""))
								{
								 
									 if(!P_ae_treatment_area_code.equals(""))
									{
										 open_to_all_prac_for_clinic_yn=(rs.getString("open_to_all_prac_for_clinic_yn") == null)?"":rs.getString("open_to_all_prac_for_clinic_yn");
									}     
								
								}
								specl_code = rs.getString("speciality_code");
								 pract_type = rs.getString("pract_type");
									if(pract_type ==null) pract_type="";
								String primary_resource_class = rs.getString("primary_resource_class");
								if(!primary_resource_class.equals("P"))
								{
									pract_type = "";
								}
                                
								if(pract_type == null)  pract_type = ""; 
								out.println("<td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</td>");
         
								if(called_from.equals("CA")){
								out.println("<input type=hidden name=attending_practitioner >"); 
								}

								if(P_module_id.equals("AE"))
								{								
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(X_attend_prac_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(!called_from.equals("CA")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(X_attend_prac_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

									
								}// E.o Module ID = "AE"
								else
								{	
									
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(open_to_all_pract));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block26Bytes, _wl_block26);

								}
								if(called_from.equals("CA") && patient_class.equals("EM"))
								{						

									if(ca_pract_type.equals("MD") || ca_pract_type.equals("SG") || ca_pract_type.equals("PS") || ca_pract_type.equals("DN"))
									{
										
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

									}					

								}						
								out.println("<img src='../../eCommon/images/mandatory.gif'></td>");						
									
							}

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sql.setLength(0);
						}
							
            _bw.write(_wl_block29Bytes, _wl_block29);

						out.println("</tr>");
						out.println("<tr style='heigth:10px'></tr>");
						out.println("<tr style='heigth:10px'></tr>");
						
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

						try
						{	
							out.println("<td  class = 'label' width='15%' align='left'><input type='hidden' name='disposition_date_time' id='disposition_date_time'  value='"+systemdatetime+"'><b>"+systemdatetime_display+"</b></td>"); 
				        	out.println("<td class='label' width='15%' align='left' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</td>");
					      //  out.println("<td ><select name= 'disposition_type' onChange='disableFields(this);dischange(this);BidChange(this);absChange(this)'>");  //Modified by Sangeetha for ML-MMOH-CRF-0624
						if(P_module_id.equals("AE")){
						out.println("<td ><select name= 'disposition_type' onChange='disableFields(this);dischange(this);checkRecordButton()'>"); 
						}else {
						out.println("<td ><select name= 'disposition_type' onChange='disableFields(this);dischange(this)'>"); 
						}

					       out.println("<option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------");
                         /*
						  if(!disposition_type.equals("")){
						 // out.println( "<option value='" +disposition_type+"' > "+disposition_type+);
						  out.println("<option value='"+disposition_type+"' selected>"+disposition_type+"</option>");
						  }
						  */	

						  //Modified by Sangeetha for ML-MMOH-CRF-0628 on 8/may/17
						  //Modified by Shanmukh for ML-MMOH-CRF-0626 on 17-Apr-2018
						  
						  	if(P_ae_brought_dead_yn.equals("Y") && (!enableBIDOnCheckout))
							{	
						           
									sql1.append("Select short_desc, disp_type, deceased_yn, ABSCONDED_YN, CALLNOTAROUND_YN from AM_DISPOSITION_TYPE_LANG_VW where eff_status='E' and (deceased_yn ='Y' and use_at_concl_yn = 'Y') and language_id='"+locale+"'"); //Modified by Sangeetha on 24/01/2017
								
								if(customer_id.equals("SS") && !disposition_type.equals("") ){
									sql1.append(" and disp_type!= '"+disposition_type+"' order by short_desc ");
								}else{
									sql1.append(" order by short_desc ");
								}

							}
							else
							{
				                if(!DispositionType.equals("") && isAutoCompDispTypeAppl){
									
									sql1.append("Select short_desc, disp_type, deceased_yn, ABSCONDED_YN, CALLNOTAROUND_YN from AM_DISPOSITION_TYPE_lang_vw "+" where disp_type not in '"+DispositionType+"' and language_id='"+locale+"' and eff_status='E' and (use_at_concl_yn = 'Y' "); 
									 
								}else{
									sql1.append("Select short_desc, disp_type, deceased_yn, ABSCONDED_YN, CALLNOTAROUND_YN from AM_DISPOSITION_TYPE_lang_vw "+" where language_id='"+locale+"' and eff_status='E' and (use_at_concl_yn = 'Y' "); //Modified by Sangeetha on 9-Jan-17 for ML-MMOH-CRF-0630
									
								}
								if(patientgender.equals("F"))
								{
									if(mother_cut_off_age > 0)
									{
										if(mother_max_age > 0)
										{
											if((patientage >= mother_cut_off_age)&&(patientage <= mother_max_age))
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
										else
										{
											if(patientage >= mother_cut_off_age)
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
									}
									else if(mother_min_age > 0)
									{
										if(mother_max_age > 0)
										{
											if((patientage >= mother_min_age)&&(patientage <= mother_max_age))
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
										else
										{					
											if(patientage >= mother_min_age)
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
									}
									else
									{	
										if(mother_max_age > 0)
										{
											if(patientage <= mother_max_age)
											{
												sql1.append(" or use_at_disch_yn = 'Y' ");
											}
										}
										else
										{
											sql1.append(" or use_at_disch_yn = 'Y' ");
										}
									}		
								}
								//order by added by sathish on Tuesday, April 12, 2011
							if(customer_id.equals("SS") && !disposition_type.equals("")){
								sql1.append(") and disp_type!= '"+disposition_type+"' order by short_desc");
							}else{
								sql1.append(") order by short_desc ");
							}
						}								
	
						pstmt1=conn.prepareStatement(sql1.toString());
						rs1 = pstmt1.executeQuery();         

						if( rs1 != null )
						{
							while( rs1.next() )
							{
								 String disptype = rs1.getString( "disp_type" ) ;
								 String shortdesc = rs1.getString( "short_desc" ) ;
								 out.println( "<option value='" + disptype + "' > "+ shortdesc);
								 out.println("<script>absconded_ind_arr[cnt]='"+rs1.getString("ABSCONDED_YN")+"';</script>");  //Added by Sangeetha on 9-Jan-17 for ML-MMOH-CRF-0630
								 out.println("<script>call_not_around_arr[cnt]='"+rs1.getString("CALLNOTAROUND_YN")+"';</script>");//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
								 out.println("<script>deceased_ind_arr[cnt]='"+rs1.getString("deceased_yn")+"';cnt++;</script>");
							}
						}
			 
						if(rs1 != null) rs1.close();
						if(pstmt1!= null) pstmt1.close();
						sql1.setLength(0);
					
				}catch ( Exception e ){ 
					e.printStackTrace();
				}
								out.println("</select><img src='../../eCommon/images/mandatory.gif'></td>");
								
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(isCaseDtlsRadioBtnAppl && P_module_id.equals("AE")){ 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(traumaYn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(checkedTraumaYn));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(osccYn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(checkedOsccYn));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

						JSONArray osccTypeJsonArr	= new JSONArray();
						osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(conn,locale,"");	
							
						for(int i = 0 ; i < osccTypeJsonArr.size() ; i++) 
						{
							JSONObject osccTypejson		= (JSONObject)osccTypeJsonArr.get(i);
							String injCategoryCode		= (String) osccTypejson.get("injCategoryCode");
							String injSubCategoryCode	= (String) osccTypejson.get("injSubCategoryCode");
							String subCategoryShortDesc	= (String) osccTypejson.get("subCategoryShortDesc");
												
							out.println("<option value="+injCategoryCode+","+injSubCategoryCode+">"+subCategoryShortDesc+"</option>");
									
						}
									
					
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mscheck1));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mscheck2));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(OandGYn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(checkedOandGYn));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(nonEmergYn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(checkedNonEmergYn));
            _bw.write(_wl_block52Bytes, _wl_block52);
 }else{ 
            _bw.write(_wl_block53Bytes, _wl_block53);
if(isReconfirmCOTAppl && P_module_id.equals("AE")){
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(checkedTraumaYn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(traumaYn));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(msenable));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mscheck1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(msenable));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mscheck2));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
 } 
            _bw.write(_wl_block65Bytes, _wl_block65);
 if(caseTypeYn.equals("Y")){ 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

			   StringBuffer sqlCaseType = new StringBuffer();
			   sqlCaseType.append("SELECT case_type_code, short_desc FROM ae_case_type WHERE EFF_STATUS ='E' ORDER BY 2");
			   pstmt = conn.prepareStatement(sqlCaseType.toString());
			   rset = pstmt.executeQuery();
			   while(rset!=null && rset.next())
			   {
				   if(caseType.equals(rset.getString(1))){
				  	out.println("<option value='"+rset.getString(1)+"' selected >"+rset.getString(2)+" ");
				   }else{
					   out.println("<option value='"+rset.getString(1)+"' >"+rset.getString(2)+" ");   
				   }
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null)	rset.close();
			   if((sqlCaseType != null) && (sqlCaseType.length() > 0))
				 {
				   sqlCaseType.delete(0,sqlCaseType.length());
				 } 
			   
            _bw.write(_wl_block69Bytes, _wl_block69);
if(caseTypeMandYn.equals("Y")){ 
            _bw.write(_wl_block70Bytes, _wl_block70);
} 
            _bw.write(_wl_block71Bytes, _wl_block71);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

						pstmt=conn.prepareStatement("Select short_desc, circumstance_of_injury_code from AM_CIRCUM_OF_INJURY_LANG_VW where language_id='"+locale+"' and eff_status = 'E' order by short_desc ");
						rs = pstmt.executeQuery();

						if( rs != null )
						{
							while( rs.next() )
							{
								 String cirofinj = rs.getString( "circumstance_of_injury_code" ) ;
								 String shortdesc = rs.getString( "short_desc" ) ;
								 out.println( "<option value='" + cirofinj + "' > "+ shortdesc);
							}
						}

						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
                        out.println("</td> ");
						
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
 if(isDIDCallNtAroundAppl && P_module_id.equals("AE")){ 
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
 } 
            _bw.write(_wl_block79Bytes, _wl_block79);
if(isLabelChngAppl == false){ 
            _bw.write(_wl_block80Bytes, _wl_block80);
if(!five_level_triage_appl_yn.equals("Y") ){ 
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
}else{ 
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
} 
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{ 
            _bw.write(_wl_block80Bytes, _wl_block80);
if(P_module_id.equals("AE")){ 
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
} else { 
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block85Bytes, _wl_block85);
} 
            _bw.write(_wl_block87Bytes, _wl_block87);
 if(P_ae_brought_dead_yn.equals("Y")){
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bdeaddis));
            _bw.write(_wl_block89Bytes, _wl_block89);
}else{
					 if(P_module_id.equals("AE")){ 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bdeaddis));
            _bw.write(_wl_block91Bytes, _wl_block91);
 } else { 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bdeaddis));
            _bw.write(_wl_block92Bytes, _wl_block92);
}	
            _bw.write(_wl_block86Bytes, _wl_block86);
}	
            _bw.write(_wl_block93Bytes, _wl_block93);
if(siteSpecific){
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
}else {
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(mlcchkval));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(deceased_time));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(dronly));
            _bw.write(_wl_block103Bytes, _wl_block103);
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( ddis ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( "disabled".equals(ddis) ? "none" : "auto" ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( "disabled".equals(ddis) ? "0.5" : "1" ));
            _bw.write(_wl_block107Bytes, _wl_block107);
if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y")){ 
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(X_episode_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(P_locn_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
 }
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(body_release_deceased_time));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(dronly));
            _bw.write(_wl_block115Bytes, _wl_block115);
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf( ddis ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( "disabled".equals(ddis) ? "none" : "auto" ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( "disabled".equals(ddis) ? "0.5" : "1" ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
if(P_module_id.equals("AE") && invokeRecallForAE.equals("Y")){
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
}else{
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block127Bytes, _wl_block127);
if(P_module_id.equals("AE") && invokeRecallForAE.equals("Y")){
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);

					pstmt=conn.prepareStatement("select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl(REASON_FOR_RECALL_YN,'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason");
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							String Value  = rs.getString("contact_reason_code");
							String Label  = rs.getString("contact_reason");
							
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(Value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Label));
            _bw.write(_wl_block140Bytes, _wl_block140);

						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
if(mds_chk!=0)
			{
			if(!mr_mds_recorded.equals("Y")){
				
				mr_mds_recorded_style="disabled";
				
				//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.2
				if(isMDSForMainProcAppl){
					if(mr_mds_recorded.equals("####CNM_PROCEED")){
						mr_mds_recorded_style = "";
					}
				}
			}
			
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
if(mr_mds_recorded.equals("Y"))
					{
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
}
				else{
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

				
				}
            _bw.write(_wl_block149Bytes, _wl_block149);
}
            _bw.write(_wl_block150Bytes, _wl_block150);
								
		if(!referral_id.equals(""))
		{
		
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block153Bytes, _wl_block153);
	
		}
		else
			out.println("<td width='5%' class='label'></td>");						
		
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(mr_mds_recorded_style));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(systemdatetime));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(create_wait_dis));
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(modify_wait_dis));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
if(isMDSForMainProcAppl){

				if(mds_chk!=0)
				{
					if(mr_mds_recorded.equals("Y")){
						mr_mainproc_recorded = "disabled";
					}else{
						if(mr_mds_recorded.endsWith("#")){
							mr_mainproc_recorded = "disabled";
						}else{
							mr_mainproc_recorded = "";
						}
					}
				}else{
					mr_mainproc_recorded = "";
				}
			
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(mr_mainproc_recorded));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")));
            _bw.write(_wl_block166Bytes, _wl_block166);
}
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(X_attend_prac_id));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(specl_code));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(P_locn_code));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(P_locn_code));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(P_locn_code));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(arrive_date_time));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(vital_signs_date_time));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(aecnt));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(X_pract_assigned_yn));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(system_time));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(P_module_id));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(diagrecord));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(diagReqd));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(notesrecord));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(notesReqd));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(dispReqd));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(P_ae_brought_dead_yn));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(visit_adm_type_ind));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(P_ae_treatment_area_code));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(waitlist_category_appl_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(waitlist_category_reqd_yn));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(restrict_wl_cat_agst_splty_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(systemdatetime));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(X_episode_id));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(episode_visit_num));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(modify_wait_list_yn));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(wait_list_no));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(mr_mds_recorded));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(reg_reff_chkout_yn));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(close_pat_chart_on_checkout_yn));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(systemdatetime_display));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(system_datetime));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(ae_bed_charge_appl_yn));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(ae_bed_calYN));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(qms_interfaced_yn));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(rec_diag_not_mdt_absconded));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(rec_diag_not_mdt_bid));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(diag_recording_not_mndt));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(enableBIDOnCheckout));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(isDIDCallNtAroundAppl));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recDiagNotMdtFrDid));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(recDiagNtMdtFrCallNtAround));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(isCaseDtlsRadioBtnAppl));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(OandGYn));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(osccYn));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(traumaYn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(nonEmergYn));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(mechInjCatgCode));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(mechInjSubCatgCode));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(invokeRecallForAE));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(isReconfirmCOTAppl));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(reconf_cot_param));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(isDeathRegisterFormAppl));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(enable_death_reg_form));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(caseTypeYn ));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(caseTypeMandYn ));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(mds_chk ));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(rcmApplicable ));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(isDeceasedDiagClassDeathRegAppl));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(primary_diag_class));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(pri_mand_postmortem_op_yn));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(pri_mand_postmortem_ae_yn));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(pri_mand_non_postmortem_op_yn));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(pri_mand_non_postmortem_ae_yn));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(secondary_diag_class));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(sec_mand_postmortem_op_yn));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(sec_mand_postmortem_ae_yn));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(sec_mand_non_postmortem_op_yn));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(sec_mand_non_postmortem_ae_yn));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(patientgender));
            _bw.write(_wl_block278Bytes, _wl_block278);

		if(called_from.equals("CA"))
		{
		
            _bw.write(_wl_block279Bytes, _wl_block279);

		}
		
            _bw.write(_wl_block280Bytes, _wl_block280);

	if(P_ae_brought_dead_yn.equals("Y"))
	{
		out.println("<script>disableFields();</script>");
	}		

	
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(P_module_id));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(X_episode_id));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(disposition_type));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(DispositionType));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(P_ae_brought_dead_yn));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(isAutoCompDispTypeAppl));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(disposition_type));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(disposition_type));
            _bw.write(_wl_block289Bytes, _wl_block289);

 }else
{
      
            _bw.write(_wl_block290Bytes, _wl_block290);

 }
}catch ( Exception e ){ 
	//out.println(e);
	e.printStackTrace();
	}
finally
{
	try
	{
		if(pstmt !=null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();
		if(pstmt2 != null) pstmt2.close();
		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(rs2 != null) rs2.close();
	}catch(Exception ce){
		//out.println(ce);
		ce.printStackTrace();
		}

	ConnectionManager.returnConnection(conn,request);
}
}catch(Exception e)
{
e.printStackTrace();}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disposition.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.CaseDefinitions.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OandG.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.NonEmergency.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CaseType.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CircumstanceofInjury.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.IntheEventofDeath.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeathInDepartment.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.broughtdead.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DeadOnArrival.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DeadOnArrival.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.broughtdead.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PMRequired.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.highriskbody.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceaseddatetime.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeathRegForm.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BodyReleaseDateTime.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.RecallDetails.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ToComeAgain.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.ComeBack.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.After.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instructions.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MDS.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CriteriaMet.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CriteriaNotMet.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Check.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.ConcludeEpisode.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreateWaitList.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModifyWaitList.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.certificate.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OutstandingBillsSettlement.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }
}
