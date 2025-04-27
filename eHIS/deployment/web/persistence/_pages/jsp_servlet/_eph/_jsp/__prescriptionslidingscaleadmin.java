package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptionslidingscaleadmin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionSlidingScaleAdmin.jsp", 1709121259114L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--saved on 27th Oct 2005 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script LANGUAGE=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/PhCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>   \n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n\t</HEAD>\n\t<!-- <BODY> -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script language=\"JavaScript\" src=\"../../ePH/js/Prescription_2.js\"></script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script language=\"JavaScript\" src=\"../../ePH/js/Prescription_1.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<form name=\"prescription_detail_form\" id=\"prescription_detail_form\">\n\t\t\t<input type=\"hidden\" name=\"tmp_durn_value\" id=\"tmp_durn_value\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_desc\" id=\"tmp_durn_desc\"  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\t\n\t\t\t\t\t\t<!-- <input type=\"hidden\" name=\"durn_desc\" id=\"durn_desc\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" > -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"durn_unit\" id=\"durn_unit\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" > <!--priya -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"freq_chng_durn_desc\" id=\"freq_chng_durn_desc\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t<input type=\"hidden\" name=\"qty_value\" id=\"qty_value\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\"3\" maxlength=\"6\" style=\"text-align:right\" onchange=\"lookForChange(this);\" onKeyPress=\"return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =");\">\n\t\t\t<input type=\"hidden\" name=\"qty_unit\" id=\"qty_unit\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t\t<input type=\"hidden\" name=\"qty_desc\" id=\"qty_desc\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<th  colspan=\"11\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></th>\n\t\t\t\t<tr>\n\t\t\t\t<!--\t<td  class=\"label\" width=\"9%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  class=\"label\" width=\"17%\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"qty_value\" id=\"qty_value\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =");\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"qty_unit\" id=\"qty_unit\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"qty_desc\" id=\"qty_desc\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" ><!-- This is to default the unit on click of schedule button-->\n\t\t\t\t\t\t<!-- <label><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b></label> -->\n\t\t\t\t\t<!-- </td> -->\n\t\t\t\t\t<td class=\"label\" width=\"13%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t<td width=\"22%\" colspan =4>\n\t\t\t\t\t\t<select name=\"frequency\" id=\"frequency\" onChange=\"freqChange(this,\'Y\',\'Y\');getChargeDetails(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');assignHomeDurationsliding();\" style=\"width:465;\"><!-- Added assignHomeDurationsliding() for INC#49425 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t<input type=\"button\" name=\"btnSchedule\" id=\"btnSchedule\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\"dis_split_dose\" class=\"button\" onClick=\"DisplaySchedule()\" style=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t    <td class=\"label\" >\n\t\t\t\t\t\t<label id=\"lgd_ord_qty\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</label>\n\t\t\t\t\t</td>\n\t\t\t\t    <td class=\"field\" >\n\t\t\t\t\t\t<input type=\"text\" name=\"absol_qty\" id=\"absol_qty\" style=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" size=\"3\" maxlength=\"3\" class=\'NUMBER\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onBlur=\"ValidateAbs(this);CheckPositiveNumber(this);freqChange(frequency,\'Y\',\'Y\');getChargeDetails(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'ABS_QTY\');\">&nbsp;\n\t\t\t\t\t\t<label id=\"lgd_qty_uom\" style=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</label>\n\t\t\t\t\t\t<a href=\"javascript:callPRNDetails();\" id=\"prn_remarks\" style=\"visibility:hidden\" title=\"PRN Remarks\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a>\n\t\t\t\t\t\t<img align=\"center\" style=\"visibility:hidden\"  id=\"prn_remarks_image\" src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td  class=\'label\' colspan=\"2\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"durn_value\" id=\"durn_value\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" maxlength=\"3\" size=\"2\" style=\"text-align:right\" onBlur=\"validateDuration(this,\'\',\'Y\');durationConversn(document.prescription_detail_form.durn_desc);populateEndDate();getChargeDetails(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');assignHomeDurationsliding();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'));\" onchange=\'extDosageCheck();\'><!-- Added \tassignHomeDurationsliding() for INC#49425 -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- <select name=\"durn_desc\" id=\"durn_desc\" onChange=\"maxDurnValidation();durationConversn(this);\"> //this code is commented. because this calls prescription_2.js methods. but that js never included in this jsp -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<select name=\"durn_desc\" id=\"durn_desc\" onChange=\"validateDuration(document.prescription_detail_form.durn_value,\'\',\'Y\');durationConversn(this);populateEndDate();getChargeDetails(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');assignHomeDurationsliding();\"><!-- Added assignHomeDurationsliding() for INC#49425 -->\n\t\t\t\t\t\t<!-- validateAllDates(); -->\n\t\t\t\t\t\t\t<option>-";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="-</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td class=\"label\"  id=\"dosage_label\">&nbsp;</td>\n\t\t\t\t</tr>\n            <tr>\n                <td class=\'label\' >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"start_date\" id=\"start_date\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" size=\"13\" maxlength=\"16\"  onblur=\"chkBackFutureDate(this);assignHomeDurationsliding();\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="><img SRC=\"../../eCommon/images/CommonCalendar.gif\" name=\'stateDateImg\'  onclick=\"if(document.prescription_detail_form.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_detail_form.start_date.focus();return false;\" ><!-- Added \tassignHomeDurationsliding() for INC#49425 -->\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"28%\" class=\'label\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"end_date\" id=\"end_date\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" size=\"13\" maxlength=\"16\" tabindex=\'5\' readonly onblur=\"validateEndDate(this,\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="><img SRC=\"../../eCommon/images/CommonCalendar.gif\"  name=\'endDateImg\' onclick=\"if(document.prescription_detail_form.end_date.disabled){return false;};showCalendar(\'end_date\',null,\'hh:mm\');document.prescription_detail_form.end_date.focus();return false;\" > \n\t\t\t\t\t</td>\t\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\"  >\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t<select name=\"disp_locn_code\" id=\"disp_locn_code\">\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" selected>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"20\" maxlength=\"20\" name=\"disp_locn_desc\" id=\"disp_locn_desc\" disabled value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t<!-- \t<td class=\"label\"   >&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" ><input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"></td> -->\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n          </tr>\n\n\t\t\t</table>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"sql_ph_prescription_bl_action_select_lookup\" id=\"sql_ph_prescription_bl_action_select_lookup\" VALUE=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\n\t\t\t\t<tr id=\'BL_HEADERBAR\' style=\'display:none;\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"7\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'BL_HEADER\' style=\'display:none;\'>\n\t\t\t\t\t <td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" width=\'9%\' id=\'bl_override_excl_incl_ind_lbl\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t<td  class=\"label\" width=\'40%\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t<td  class=\"label\" width=\'30%\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t<td class=\"label\" nowrap width=\'10%\' style=\'TEXT-ALIGN:center;\'> ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t<td class=\"label\" nowrap width=\'13%\' style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\"  width=\'20%\'style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'BL_VALUES\' style=\'display:none;\'>\n\t\t\t\t\t <td align=\'center\' id=\'bl_def_override_excl_incl_ind_gif\'>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" id=\'td_bl_override_excl_incl_ind\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n\t\t\t\t<input type = \"hidden\" name = \"bl_override_excl_incl_ind_amend_load\" value = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n                      <select name=\"bl_override_excl_incl_ind\" id=\"bl_override_excl_incl_ind\" onchange=\"assignOverrideExclInclInd(this)\"  >\n\t\t\t\t\t\t  <!--  <option value=\"SEL\">---";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="---</option> --> \n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t     <option value=\"SEL\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">---";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="---</option>\n\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</option>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="---</option>\n\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t    <option value=\"SEL\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="---</option>\n\t\t\t\t\t\t\t    <option value=\"I\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</option>\n\t\t\t\t\t\t\t    <option value=\"E\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</option>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t      <option value=\"SEL\"selected>---";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="---</option>\n\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_def_override_excl_incl_ind\' id=\'bl_def_override_excl_incl_ind\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_allowed_yn\' id=\'bl_override_allowed_yn\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t\t\t<td class=\"label\" nowrap>\n\t\t\t\t\t\t<input type=\'text\' name=\'bl_incl_excl_override_reason_desc\' id=\'bl_incl_excl_override_reason_desc\' size=\'40\'  value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' readonly >\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" id=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\');\" disabled><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:hidden;\'></img>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" id=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\');\"><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:visible;\'></img>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_incl_excl_override_reason_code\' id=\'bl_incl_excl_override_reason_code\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t<td class=\"data\" id=\'gross_charge_amt\' align=\'center\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t   <td class=\"data\"  id=\'gross_charge_amt\' align=\'center\' style=\'display:none;\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t<td class=\"data\" id=\'bl_total_charge_amt\' align=\'center\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"data\" id=\'bl_patient_payable_amt\' align=\'center\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\'center\'id=\'bl_approval_reqd_yn\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" name=\"presBean_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" name=\"presBean_name\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" name=\"ext_prod_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"   name=\"back_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" name=\"future_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" name=\"freq_nature\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" name=\"freq_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" name=\"interval_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" name=\"repeat_durn_type\">\n\t\t\t<input type=\"hidden\" value=\"N\" name=\"allow_refill\" id=\"allow_refill\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" name=\"bean_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" name=\"bean_name\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" name=\"mode\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" name=\"source\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" name=\"patient_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" name=\"encounter_id\">\t\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" name=\"drug_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"    name=\"srl_no\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"    name=\"rowVal\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" name=\"scheduled_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"    name=\"facility_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\"    name=\"daily_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\"    name=\"unit_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"    name=\"split_dose_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" name=\"split_dose_yn_val\">\n\t\t\t<input type=\"hidden\" value=\"N\"    name=\"qty_reqd_yn\" id=\"qty_reqd_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"    name=\"sch_over_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" name=\"calling_mode\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" name=\"repeat_value\">\n\t\t\t<input type=\"hidden\" value=\"\"  name=\"split_dose\" id=\"split_dose\">\n\t\t\t<input type=\"hidden\" value=\"\"  name=\"admin_time\" id=\"admin_time\">\n\t\t\t<input type=\"hidden\" value=\"\"  name=\"admin_qty\" id=\"admin_qty\">\n\t\t\t<input type=\"hidden\" name=\"taper_disable\" id=\"taper_disable\" value=\"\"><!-- Added for IN 044131 -->\n\t\t\t<input type=\"hidden\" value=\"Y\" name=\"sliding_scale_yn\" id=\"sliding_scale_yn\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" name=\"refill_cont_order_yn\">\n\t\t\t<input type=\"hidden\" value=\"Q\" name=\"dosage\" id=\"dosage\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"calcualted_durn_value\" id=\"calcualted_durn_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" name=\"dosage_type\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" name=\"generic_id\">\n\t\t\t<input type=\"hidden\" name=\"init_qty\" id=\"init_qty\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t<input type=\"hidden\" name=\"prn_dose\" id=\"prn_dose\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t<input type=\"hidden\" name=\"prn_yn\" id=\"prn_yn\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\t\n\t\t\t<input type=\"hidden\" name=\"prn_remarks_flag\" id=\"prn_remarks_flag\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\t\n\t\t\t<label id=\"ord_qty_lbl\"></label>\n\t\t\t<label id=\"ord_qty_uom\"></label>\t\t\n\t\t\t<input type=\"hidden\" name=\"allow_duplicate\" id=\"allow_duplicate\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" name=\"dsg_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" name=\"dup_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" name=\"con_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" name=\"int_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" name=\"alg_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" name=\"fract_dose_appl_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" name=\"fract_dose_round_up_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" name=\"in_formulary_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" name=\"calc_def_dosage_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" name=\"def_freq_found\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" name=\"order_type_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" name=\"form_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" name=\"route_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" name=\"DurnDescDetails\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" name=\"max_durn_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" name=\"chk_for_max_durn_action\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" name=\"force_auth_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" name=\"amend_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" name=\"billable_item_yn\">\n\t\t\t<input type=\'hidden\' name=\'totalTaperQtyDisplay\' id=\'totalTaperQtyDisplay\' value=\'N\'>\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" name=\"strength_per_pres_uom\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" name=\"strength_per_value_pres_uom\">\n\t\t\t<input type=\"hidden\" name=\"take_home_start_date\" id=\"take_home_start_date\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"><!--Added for INC#49425-->\n\t\t\t<input type=\"hidden\" name=\"take_home_end_date\" id=\"take_home_end_date\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\"><!--Added for INC#49425-->\n\t\t\t<input type=\"hidden\" name=\"pregnency_yn\" id=\"pregnency_yn\" value=\"\"><!--Added for INC#49425-->\n\t\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"\"><!--Added for INC#49425-->\n\t\t\t<input type=\"hidden\" name=\"chk_missing_sch_yn\" id=\"chk_missing_sch_yn\" value=\"N\"><!--ADDED for ARYU-SCF-0033-->\n\t\t\t<input type=\"hidden\" value=\"\" name=\"preg_remarks\" id=\"preg_remarks\" ><!--Added for ARYU-SCF-0033-->\n\t\t\t<input type=\"hidden\" value=\"\" name=\"preg_effect\" id=\"preg_effect\"><!--Added for ARYU-SCF-0033-->\n\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<script>\n\t\t\t\n\t\t\tassignDurnTypeList(\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'); \n\t\t\t//reloadDurnTypeList(\'Y\'); //here commented by rawther for for scf 7732\n\t\t\t//dfltDurnDesc(\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'); //Commented for SKR-SCF-0099 [IN:029037] -Reopend(when thr is no dflt freq setup & max durn exceeds the frq durn)\n\t\t//\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\');\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\tdisableItems();\n";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"PH_NORMAL_RX_DEFAULT_FREQ_NOT_FOUND\",\'PH\'));\n\t\t\t\t\t\tfreqChange(document.prescription_detail_form.frequency,\"Y\",\'Y\');\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t           //     freqChange(document.prescription_detail_form.frequency,\"Y\",\'Y\');  //commented for IN22255 --23/06/2010 --priya\n\t\t\t\t//\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'); //Commented for SKR-SCF-0099 [IN:029037] -Reopend\n\t\t\t\t//\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\');\n\t\t\t\t\tpopulateEndDate();\n\t\t\t\t\t//getFormatId();  //commeted for SKR-SCF-0140\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\tif(document.prescription_detail_form.freq_nature.value==\"P\"){\n\t\t\t\t\tdocument.getElementById(\"prn_remarks\").style.visibility\t= \"visible\";\n\t\t\t\t\tdocument.getElementById(\"prn_remarks_image\").style.visibility\t= \"visible\";\n\t\t\t\t\tdocument.getElementById(\"dis_split_dose\").style.visibility\t= \"hidden\";\n\t\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"6\" class=\"CURRTEXT\">\n\t\t\t\t\t\t<marquee  scrollamount=\"4\" ><font  style=\"font-weight:bold;color:black\" size=1>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</font></marquee>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\"freqChange(document.prescription_detail_form.frequency,\'\',\'Y\');\",200);\n\t\t\t\t</script>\t\n";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t<script>\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\tfreqChange(document.prescription_detail_form.frequency,\'Y\',\'Y\')\t;\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\tcalulateDurnValue(\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\',\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\',\"sliding\");\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t</script>\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n</html>\n\n";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
14/5/2020		IN072851			Shazana			14/7/2020	Manickam				TBMC-SCF-0176
--------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		String drug_code			=   request.getParameter("drug_code");
		String srl_no				=   request.getParameter("srl_no");
		String mode				    =   request.getParameter("mode");
		String calledFrm = "";
		//calledFrm = request.getParameter("called_from_amend")==null?"":(String)request.getParameter("called_from_amend");
		if(calledFrm.equals("Y")){

            _bw.write(_wl_block10Bytes, _wl_block10);

		}else{

            _bw.write(_wl_block11Bytes, _wl_block11);
}
		String patient_id			= request.getParameter("patient_id") ;
		String encounter_id			= request.getParameter("encounter_id") ;
		String patient_class		= request.getParameter("patient_class");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
		String drug_db_interface_yn = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");

		String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionBean_1";
		String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
		String facility_id	= "";
		facility_id	= (String) session.getValue("facility_id");

		String extdrugCode	   ="";
		String srlNo		   ="";
		String freq_code	   ="";
		String durn_type	   =""; //priya
		String durn_value	   ="";
		String start_date	   ="";
		String end_date		   ="";
		String qty_value	   ="";
		ArrayList	code	   =new ArrayList();
		ArrayList	desc	   =new ArrayList();								
		String qty_unit		   ="";	
		String qty_desc	       = "";	
		ArrayList arr_list	   = null;
		String disp_locn_code  = "";
		String disp_locn_desc  = "";
		String back_date	   = "";
		String future_date	   ="";
		String freq_nature	   ="";
		String repeat_durn_type= "";
		String freq_chng_durn_desc= "";
		String freq_value	   = "";
		String interval_value  = "";
		String sch_over_yn	   = "";
		String daily_dose	   = "";
		String unit_dose	   = "";
		String repeat_value	   = "";
		String scheduled_yn	   = "";
		String refill_cont_order_yn	="";
		String generic_id			="";	
		String dosage_type		= "";
		String split_dose_yn	= "";
		String allow_duplicate	= "";
		String stock_uom		= "";
		String stock_Details_uom= "";
		String absol_qty		= "";
		String current_rx		= "";
		String generic_name	    = "";		
		String	 prn_dose		= 	"";
		String prn_yn			="";
		HashMap prn_remarks		=	new HashMap();
		String prn_remarks_code	=	"";
		String prn_remarks_dtl	=	"";
		String orig_current_rx	= "";
		String freq_option	    = "";
		String dsg_reason       = "";
		String dup_reason       = "";
		String int_reason       = "";
		String con_reason       = "";
		String alg_reason       = "";
		String ext_prod_id		=	"";
		String selected_disp	= "";
		String fract_dose_appl_yn     = "";
		String fract_dose_round_up_yn = "";
		String in_formulary_yn        = "";
		String calc_def_dosage_yn     = "";
		String form_code              = "";
		String route_code             = "";
		String order_type_code		  =	"";
		String max_durn_value		  =	"";
		String chk_for_max_durn_action= "";
		boolean	entered				  =	false;
		String bl_incl_excl_override_reason_code ="";
		String bl_incl_excl_override_reason_desc = "";
		String bl_def_override_excl_incl_ind     = "";
		String bl_override_excl_incl_ind         = "";
		String bl_override_allowed_yn            = "";
		boolean def_freq_found                   = false;
		int dose_decimal = 6;
		String called_from_amend = request.getParameter("called_from_amend")==null?"":request.getParameter("called_from_amend");
		HashMap drugDetails         =  null;
		Hashtable DurnDescDetails	=  new Hashtable();
		String duration_option		=  "";
		String freq_durn_type		=  "D";
		String freq_durn_value		=  "";
		String force_auth_yn		=  "";
		String amend_yn		        =  "";
		String include_selected     =  "";
	    String exclude_selected     =  "";
	    String Select_selected      =  "";
		String billable_item_yn	   = "";
		String order_id			= "";
		String ord_line_no			=	"";
		String		strength_per_pres_uom		=   "";
		String		strength_per_value_pres_uom	= 	"";
		String start_date1 = null;//Added for INC#49425 --start
		String end_date1 = null;
		String sys_date = null;	
		String tempstartdate1="";
		String tempenddate1 = "";//Added for INC#49425--end
		boolean displayGrossAmtYn = presBean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
		String def_dosage_type = ""; //added for TBMC-SCF-0176

		PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id, bean_name,request);
		bean.setLanguageId(locale);
		bean.setSlidingScaleFreq();
		//ArrayList freq_dtls    = presBean.getFreqValues(); //unused
		ArrayList presDetails  = (ArrayList) bean.getpresDetails();
//corrected for PE By Naveen
		//int take_home					=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
		int take_home					=	(int)bean.getTakeHomeCount();
		prn_yn						    = bean.getchkforPRN();

		if(presDetails!=null && presDetails.size()>0){		
			for(int i=0;i<presDetails.size();i++){
				drugDetails		= (HashMap)presDetails.get(i);
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");
				srlNo			= (String)drugDetails.get("SRL_NO");
				if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
					ext_prod_id	   = "";
					freq_code	   = CommonBean.checkForNull((String)drugDetails.get("FREQ_CODE"));
					durn_type	   = CommonBean.checkForNull((String)drugDetails.get("DURN_TYPE"));
					durn_value	   = CommonBean.checkForNull((String)drugDetails.get("DURN_VALUE"));
					if(durn_value.equals("") || durn_value.equals("0"))
						durn_value="1";

					start_date	= drugDetails.get("START_DATE")==null?(String)drugDetails.get("START_DATE_TIME"):(String)drugDetails.get("START_DATE");
					end_date	= drugDetails.get("END_DATE")==null?(String)drugDetails.get("END_DATE_TIME"):(String)drugDetails.get("END_DATE");
					start_date	= start_date==null?"":start_date;
					end_date	= end_date==null?"":end_date;
					billable_item_yn = drugDetails.get("BILLABLE_ITEM_YN")==null?"Y":(String)drugDetails.get("BILLABLE_ITEM_YN");
//					qty_value	   = CommonBean.checkForNull((String)drugDetails.get("QTY_VALUE"));
//qty_value was strength value now its changed to quantity value when sliding scale drug is placed
					//qty_value	   = CommonBean.checkForNull((String)drugDetails.get("TAB_QTY_VALUE"));
					qty_value	   = (String)drugDetails.get("TAB_QTY_VALUE")==null?"1":(String)drugDetails.get("TAB_QTY_VALUE");
					//System.err.println("qty_value==184===>"+qty_value);
					if(qty_value.equals("") || qty_value.equals("0")) //TBMC-SCF-0167
						qty_value = "1";
//					dosage_type		= (String) drugDetails.get("DOSAGE_TYPE");
//value of dosage_type is hard coded to Quantity - its considered that if it is a sliding scale drug then dosage_type should go as Q

					dosage_type = "A";
					def_dosage_type               =(String) drugDetails.get("DOSAGE_TYPE")==null?"":(String) drugDetails.get("DOSAGE_TYPE");//added for TBMC-SCF-0176
					if(dosage_type.equals("S")){
						qty_unit			   = CommonBean.checkForNull((String)drugDetails.get("STRENGTH_UOM"));
						qty_desc			   = CommonBean.checkForNull((String)drugDetails.get("STRENGTH_UOM_DESC"));
					}
					else{
						qty_unit			   = CommonBean.checkForNull((String)drugDetails.get("PRES_BASE_UOM"));
						qty_desc			   = CommonBean.checkForNull((String)drugDetails.get("PRES_BASE_UOM_DESC"));
					}
					strength_per_pres_uom		= (String) drugDetails.get("STRENGTH_PER_PRES_UOM");
					strength_per_value_pres_uom	= (String) drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");

					form_code	       = (String) drugDetails.get("FORM_CODE");
					route_code	       = (String) drugDetails.get("ROUTE_CODE");
					back_date	       = CommonBean.checkForNull((String)drugDetails.get("BACK_DATE"));
					future_date	       = CommonBean.checkForNull((String)drugDetails.get("FUTURE_DATE"));
					freq_nature	       = CommonBean.checkForNull((String)drugDetails.get("FREQ_NATURE"));
					//repeat_durn_type= CommonBean.checkForNull((String)drugDetails.get("DURN_TYPE"));
					repeat_durn_type   = CommonBean.checkForNull((String)drugDetails.get("REPEAT_DURN_TYPE"));
					freq_chng_durn_desc= CommonBean.checkForNull((String)drugDetails.get("freq_chng_durn_desc"));
					freq_value	       = CommonBean.checkForNull((String)drugDetails.get("FREQ_VALUE"));
					interval_value     = CommonBean.checkForNull((String)drugDetails.get("INTERVAL_VALUE"));
					sch_over_yn	       = CommonBean.checkForNull((String)drugDetails.get("SCH_OVER_YN"));
					daily_dose	       = CommonBean.checkForNull((String) drugDetails.get("DAILY_DOSE"));
					unit_dose	       = CommonBean.checkForNull((String) drugDetails.get("UNIT_DOSE"));
					repeat_value	   = CommonBean.checkForNull((String) drugDetails.get("REPEAT_VALUE"));
					scheduled_yn	   = CommonBean.checkForNull((String) drugDetails.get("SCHEDULED_YN"));
					refill_cont_order_yn		= (String) drugDetails.get("REFILL_CONT_ORDER_YN");
					max_durn_value				= CommonBean.checkForNull((String) drugDetails.get("MAX_DURN_VALUE"));
					chk_for_max_durn_action		= CommonBean.checkForNull((String) drugDetails.get("CHK_FOR_MAX_DURN_ACTION"));
					generic_id				    = (String) drugDetails.get("GENERIC_ID");
					split_dose_yn	   = (String) drugDetails.get("SPLIT_DOSE_YN");
					allow_duplicate	   = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG");
					if(patient_class.equals("OP"))
						allow_duplicate	   = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
					stock_uom		   = (String)drugDetails.get("STOCK_UOM");
				    stock_Details_uom  = bean.getUomDisplay(facility_id,stock_uom); //21/10/09 created
					disp_locn_code	   = (String) drugDetails.get("DISP_LOCN_CODE")==null?"":(String) 						drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc	   = (String) drugDetails.get("DISP_LOCN_DESC");
					order_id	   = (String) drugDetails.get("ORDER_ID")==null?"":(String) drugDetails.get("ORDER_ID");
					ord_line_no	   = (String) drugDetails.get("ORDER_LINE_NUM")==null?"":(String) drugDetails.get("ORDER_LINE_NUM");
					
					if(called_from_amend.equals("Y")){
						absol_qty		= (String)drugDetails.get("ORDER_QTY"); 
					}
					else{
						if(request.getParameter("order_idC") != null && !(request.getParameter("order_idC").equals("")) && !request.getParameter("order_idC").equals("undefined") && !(request.getParameter("order_idC").equals("null")) && drugDetails.containsKey("PRES_QTY_VALUE")){
							absol_qty		= (String)drugDetails.get("PRES_QTY_VALUE"); 
						}
						else{
							absol_qty		= (String)drugDetails.get("ABSOL_QTY"); 

						}
					}

					prn_dose					= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
					current_rx		= ((String)drugDetails.get("CURRENT_RX"))==null?"":(String)drugDetails.get("CURRENT_RX");
					generic_name				= (String) drugDetails.get("GENERIC_NAME");
					prn_remarks					=	bean.getPRNRemarks((String)drugDetails.get("DRUG_CODE"));
					if(prn_remarks != null){
						prn_remarks_code			=	(String)prn_remarks.get("prn_remarks_dtl");
						prn_remarks_dtl				=	(String)prn_remarks.get("prn_remarks_code");
					}
					order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
					calc_def_dosage_yn          = (String) drugDetails.get("CALC_DEF_DOSAGE_YN")==null?"":(String) drugDetails.get("CALC_DEF_DOSAGE_YN");
					in_formulary_yn				= (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");
					fract_dose_appl_yn          = (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					fract_dose_round_up_yn      = (String) drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;
					force_auth_yn				= (String) drugDetails.get("FORCE_AUTH_YN")==null?"":(String) drugDetails.get("FORCE_AUTH_YN"); // THIS IS TO KNOW IF AUTH YN IS DUE TO FORCE AUT OR DUE TO DURATION EXCEEDED //added for IN22255 --22/06/2010 --priya

					dsg_reason		=	(String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");
					dup_reason		=	(String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
					con_reason		=	(String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");
					int_reason		=	(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
					alg_reason		=	(String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
					freq_durn_type	=   (String)drugDetails.get("FREQ_DURN_TYPE");
					freq_durn_value	=   (String)drugDetails.get("FREQ_DURN_VALUE");
					amend_yn	    =   CommonBean.checkForNull((String)drugDetails.get("AMEND_YN"),"N"); 
					if(!called_from_amend.equals("Y")){
						if(current_rx.equals("Y") && !drugDetails.containsKey("ORIG_CURRENT_RX")) {
							drugDetails.put("ORIG_CURRENT_RX","Y");							
						}
						if( drugDetails.containsKey("ORIG_CURRENT_RX") && ((String)drugDetails.get("ORIG_CURRENT_RX")).equals("Y") ) {
							orig_current_rx	=	(String)drugDetails.get("ORIG_CURRENT_RX");
						}
					}
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn =(String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code =(String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
						bl_def_override_excl_incl_ind = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");  
						bl_override_excl_incl_ind = (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");  

						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
						//if(!bl_override_allowed_yn.equals("Y"))
							//bl_override_allowed_yn = "disabled";
					}
				}
			}
		}

		if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
			prn_dose	=	"1";
		}
		if(freq_nature.equals("P") && (absol_qty==null)) {
			absol_qty		=	prn_dose;	
		}

		if(absol_qty==null)
			absol_qty			=	"1";

		HashMap freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,"SlidingScale",patient_class); //passed mode as "SlidingScale" for IN21609 --07/06/2010 -- priya
		boolean dup_found	=	false;

		if(orig_current_rx.equals("Y") && allow_duplicate.equals("N")) { // && (patient_class.equals("IP") || take_home>0)
				dup_found	=	true;
		}

		
		if(freqValues.size()>0){
			ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
			ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
			ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
			if(!amend_yn.equals("Y") && freq_nature.equals("P")){ //added for TBMC-SCF-0166 - start
				if(freqValues!=null && freqValues.size()>0){
					freq_code     = 	(String)freqCode.get(0);
					freq_nature   =    (String)FreqNature.get(0);
					 freq_durn_type = bean.getFreqDurnType(freq_code);//TBMC-SCF-0167
						
					if(freq_nature.equals("I") || freq_nature.equals("O"))
						scheduled_yn = "N";
					else
						scheduled_yn = "Y";
					//TBMC-SCF-0167
					if(freq_durn_type==null || freq_durn_type.equals(""))
						freq_durn_type = durn_type ;
					else
						 durn_type = freq_durn_type ; 

					drugDetails.put("FREQ_NATURE",freq_nature);
					drugDetails.put("FREQ_CODE",freq_code);
					drugDetails.put("SCHEDULED_YN",scheduled_yn);
					//TBMC-SCF-0167 - start
					drugDetails.put("DOSAGE_TYPE",dosage_type); 
					drugDetails.put("DURN_TYPE",freq_durn_type);
					drugDetails.put("FREQ_DURN_TYPE",freq_durn_type);
					drugDetails.put("REPEAT_DURN_TYPE",freq_durn_type);
					drugDetails.put("DEF_DOSAGE_TYPE",def_dosage_type);//ADDED FOR TBMC-SCF-0176
					//TBMC-SCF-0167 - end
				}
			} //added for TBMC-SCF-0166 - end
			drugDetails.put("DEF_DOSAGE_TYPE",def_dosage_type);//ADDED FOR TBMC-SCF-0176
			for(int i=0;i<freqCode.size();i++){
				if( dup_found ) {
					if( ((String) FreqNature.get(i)).equals("O")) {//(bean.getFreqNature(((String) freqCode.get(i))))
						freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
						freq_nature	=	"O";
						freq_code	=((String) freqCode.get(i));
						def_freq_found = true;
					}
				} 
				else {
					//if( !(bean.getFreqNature(((String) freqCode.get(i)))).equals("P")) {
					if(((String) freqCode.get(i)).equals(freq_code)) {
						freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
						def_freq_found = true;
					}
					else {
						freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
					}
					//}
				}
			}
		}
		else if(dup_found) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();					
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				freq_nature	=	"O";
				freq_code	=((String) stat_freqs.get(i));
				def_freq_found = true;
			}
		} 
		if(freq_option.equals("")) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();					

			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				def_freq_found = true;
				freq_nature	=	"O";
				freq_code	=((String) stat_freqs.get(i));
			}
		} 
		HashMap chkValuescheduleFrequency	=	null;
		ArrayList frequencyValues			=	null;
		chkValuescheduleFrequency			= bean.getscheduleFrequency();
		if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
			frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
		}
		if(bean.getTakeHomeDates()!=null && bean.getTakeHomeDates().size()>0){// Added  for INC#49425--start
			start_date1 = (String)bean.getTakeHomeDates().get(0);
			end_date1=(String)bean.getTakeHomeDates().get(1);
			tempstartdate1 = start_date1;
			tempenddate1 = end_date1;
			sys_date=(String) presBean.getSysdate();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date stdate =sdf.parse(start_date1);
			java.util.Date sydate  = sdf.parse(sys_date);
			if(stdate.compareTo(sydate)<0){
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
				tempstartdate1 = formatter.format(sydate);
				String tempendString  = end_date1.substring(0, 10);
				String systempString =tempstartdate1.substring(11, tempstartdate1.length());
				tempenddate1 = tempendString.concat(" "+systempString);
			}
			else if(stdate.compareTo(sydate)>0){
				String tempendString = end_date1.substring(0, 10);
				String systempString =start_date1.substring(11, start_date1.length());
				tempenddate1 = tempendString.concat(" "+systempString);
			}
			
			String checked_yn = bean.getHome_leave_checked();
			if(checked_yn==null)
				checked_yn = "";
			if(checked_yn.equalsIgnoreCase("Y")){
				if(presDetails!=null && presDetails.size()>0 && (!amend_yn.equals("Y"))){
					start_date = tempstartdate1;
					end_date = tempenddate1;
				}
			}
		}//Added for INC#49425--end
		//Added for ICN28477 - Start
		Hashtable sch_output	=	null;
		Hashtable schedule_val	=	null;
		HashMap temp_freq_chars =	null;
		if(freq_nature!=null && !freq_nature.equals("P") && !freq_nature.equals("O")  && freq_code!=null && !freq_code.equals("") && scheduled_yn.equals("Y")){ //if condition added for SKR-SCF-0099 IN29037
			if(chkValuescheduleFrequency==null || frequencyValues == null ){
				String sch_bean_id		= "OrScheduleFreq" ;
				String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		 
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);

				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code+srl_no);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",srl_no);
				sch_output.put("start_date_time",start_date);

				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null) {
				ArrayList values	=	presBean.getFreqDet(order_id,ord_line_no);
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				frequencyValues	= new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale, "en")); 
				freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
					day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
				}
				
				if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals("")){
							String temp = (String)day_list.get(j);

							if (temp == null || temp.equals(""))
								temp = "0";
							if (!temp.equals("0"))
								day_names.add(week_days.get((Integer.parseInt(temp))-1));
						}
					}
				}
				if(freqCharctValues !=null)
					frequencyValues.add(freqCharctValues.get(0));
				else
					frequencyValues.add("");
				frequencyValues.add(day_list);
				frequencyValues.add(day_names);
				frequencyValues.add(time_list);
				frequencyValues.add(dose_list);
				sch_output.put(drug_code+srl_no,frequencyValues);

				bean.setScheduleFrequencyStr(sch_output);
			}
		}
		//Added for ICN28477 - END


		selected_disp				=	bean.getDispLocation(srlNo);
		String legend_style	=	"display:none;color:red;font-weight:bold;";
		String oth_style	=	"display:none";
		String sch_style	=	"";

		if(freq_nature.equals("P"))
			sch_style		=	"display:none";

//		if(freq_nature.equals("P") && !absol_qty.equals("")) {
		if(!absol_qty.equals("")) {
				legend_style	=	"display:inline;color:red;font-weight:bold;";
				oth_style		=	"display:inline";
/*=================================================================================================================*/
//added for IN26583 --17/02/2011-- priya
			if(((int)(Float.parseFloat(absol_qty)/1)) == Float.parseFloat(absol_qty))
			{
				absol_qty = ((int)(Float.parseFloat(absol_qty)/1))+"";
			}

/*=================================================================================================================*/
				
		}
		if(freq_nature.equals("O"))
			sch_style		=	"display:none";

		if(!prn_remarks_dtl.equals("")) {
			prn_remarks_dtl	=	"true";
		}
		else{
			prn_remarks_dtl	=	"false";
		}
		String amend_mode_disable = "";
		if(mode.equals("amend")){
			amend_mode_disable = "disabled";
		}

		if( !mode.equals("blank") ) {
			DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
			Enumeration keys_des		= DurnDescDetails.keys();
			String	durn_code			= "";
			while(keys_des.hasMoreElements()){
				durn_code		= (String)keys_des.nextElement();
				if(durn_type.equals(durn_code))
					duration_option	= duration_option + "<option value='"+durn_code+"' selected>"+((String)DurnDescDetails.get(durn_code))+"</option> ";
				else
					duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
			}
		}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(freq_durn_value));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(freq_durn_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(qty_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(freq_option));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sch_style));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(oth_style));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(oth_style));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(stock_Details_uom));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(duration_option));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(amend_mode_disable));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(amend_mode_disable));
            _bw.write(_wl_block52Bytes, _wl_block52);

					if(current_rx != null && current_rx.equals("Y") && allow_duplicate != null && allow_duplicate.equals("N") ) { //&& (patient_class.equals("IP")||  take_home>0)

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block54Bytes, _wl_block54);

					}
					else {	

            _bw.write(_wl_block2Bytes, _wl_block2);
 
								//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 	

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

		// Dispense Location is displayed in list or text based on the no of values
	    // the below code for list box For External Prescription
									if(bean.getExternalpatient_id()!=null && !bean.getExternalpatient_id().equals("")) {
										ArrayList ExternalPresDispCodes = new ArrayList();
										ExternalPresDispCodes			= bean.getExternalPresDispCodes();
										ArrayList ExternalPresDispDesc	= new ArrayList();
										ExternalPresDispDesc			= bean.getExternalPresDispDesc();

            _bw.write(_wl_block57Bytes, _wl_block57);
		
										for(int k=0; k<ExternalPresDispCodes.size(); k++) { 
											if(selected_disp.equals((String)ExternalPresDispCodes.get(k)) ) {

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)ExternalPresDispCodes.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)ExternalPresDispDesc.get(k)));
            _bw.write(_wl_block60Bytes, _wl_block60);

											}
											else if(selected_disp.equals("") && !entered){	
												entered	=	true;

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)ExternalPresDispCodes.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)ExternalPresDispDesc.get(k)));
            _bw.write(_wl_block60Bytes, _wl_block60);

											}
											else {	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)ExternalPresDispCodes.get(k)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)ExternalPresDispDesc.get(k)));
            _bw.write(_wl_block60Bytes, _wl_block60);

											}
										}	

            _bw.write(_wl_block61Bytes, _wl_block61);
  
									}
									else if(code.size() > 1 ) {

            _bw.write(_wl_block57Bytes, _wl_block57);
		
										for(int k=0; k<code.size(); k++) { 
											if(selected_disp.equals((String)code.get(k)) ) {

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)code.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)desc.get(k)));
            _bw.write(_wl_block60Bytes, _wl_block60);

											}
											else	if(selected_disp.equals("") && !entered){	
												entered	=	true;

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)code.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)desc.get(k)));
            _bw.write(_wl_block60Bytes, _wl_block60);

											}
											else {

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)code.get(k)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)desc.get(k)));
            _bw.write(_wl_block60Bytes, _wl_block60);

											}
										}	

            _bw.write(_wl_block61Bytes, _wl_block61);
  // below code for text box
									}
									else { 

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disp_locn_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
	
									}

            _bw.write(_wl_block64Bytes, _wl_block64);
	
							/*}
							else {	*/

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block66Bytes, _wl_block66);

							//}	


			}	

            _bw.write(_wl_block67Bytes, _wl_block67);

			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") ));
            _bw.write(_wl_block69Bytes, _wl_block69);

			}

            _bw.write(_wl_block70Bytes, _wl_block70);
//added for ml-bru-crf-0469
					if(displayGrossAmtYn){ 
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{ 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
   }	 
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
//added for ml-bru-crf-0469
						if(displayGrossAmtYn){ 
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}else{
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
//added for ml-bru-crf-0469
						if(displayGrossAmtYn){ 
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
     
					include_selected ="";  
					exclude_selected =""; 	
					Select_selected  ="";


				   if(bl_override_excl_incl_ind.equals("I")){
						include_selected ="selected";
					}else if(bl_override_excl_incl_ind.equals("E")){
						exclude_selected ="selected";
					}else {
						Select_selected ="selected";
					}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bl_override_excl_incl_ind));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
if(bl_override_allowed_yn.equals("I")){
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
}if(bl_override_allowed_yn.equals("E")){
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
}if(bl_override_allowed_yn.equals("B")){
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
}
            _bw.write(_wl_block102Bytes, _wl_block102);
if(bl_override_allowed_yn.equals(""))
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bl_def_override_excl_incl_ind));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bl_override_allowed_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bl_incl_excl_override_reason_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);

					if(bl_incl_excl_override_reason_desc.equals("")){

            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block109Bytes, _wl_block109);

					}
					else{

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block111Bytes, _wl_block111);

					} 

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bl_incl_excl_override_reason_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
	//added for ml-bru-crf-0469
					if(displayGrossAmtYn){ 
            _bw.write(_wl_block114Bytes, _wl_block114);
	} else{ 
            _bw.write(_wl_block115Bytes, _wl_block115);
} 
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(freq_value));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf((String)session.getValue("facility_id")));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(sch_over_yn));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(repeat_value));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(refill_cont_order_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(prn_dose));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(prn_yn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(prn_remarks));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(allow_duplicate));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(fract_dose_appl_yn));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(calc_def_dosage_yn));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(def_freq_found));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(force_auth_yn));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(billable_item_yn));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(start_date1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(end_date1));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block177Bytes, _wl_block177);
 
				if(mode.equals("blank")){

            _bw.write(_wl_block178Bytes, _wl_block178);
 
				}
				else { 
			//if no default frequency(order catalog) matches with the applicable frequency list with respect to patient class
					if(!def_freq_found){

            _bw.write(_wl_block179Bytes, _wl_block179);

					}

            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block182Bytes, _wl_block182);
	
				}
				HashMap data		=	null;
				String att			=	null;
				String adm_time		=	"";
				String adm_qty		=	"";
				float total_qty	=   0.0f;
				ArrayList dose_list = new ArrayList();
				if(frequencyValues!=null && frequencyValues.size()>0 && def_freq_found){
					//if(def_freq_found){
/*						adm_time+="<tr>";					
						for(int i=0;i<frequencyValues.size();i++){
							data=(HashMap)frequencyValues.get(i);
							att="  class=TIP";
							adm_time+="<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
						}
						adm_time+="</tr>";
						adm_qty+="<tr>";
						for(int i=0;i<frequencyValues.size();i++){
							att="  class=TIP";
							data=(HashMap)frequencyValues.get(i);
							adm_qty+="<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
							total_qty=(String) data.get("admin_qty");
						}
						adm_qty+="</tr>";*/

						dose_list	= (ArrayList)frequencyValues.get(4);
						for(int tqI=0;tqI<dose_list.size();tqI++){
							total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
						//	final_qty	=	(String)dose_list.get(tqI);
						}

						String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"Sliding");
						adm_time = tooltiptable;

						boolean split_chk	=	bean.checkSplit(frequencyValues);	
						
						// adm_qty is made "" coz for sliding scale drug, we need to display the qty only time should be displayed, once this is confirmed we can remove adm_qty from above code aswell
						adm_qty="";
						out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','onLoad')");
					//}
				}
				else{
					out.println("getChargeDetails('"+in_formulary_yn+"')");
					if(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))
						out.println("extDosageCheck('onLoad')");
				}

            _bw.write(_wl_block183Bytes, _wl_block183);

			String drug_db_duptherapy_flag      = (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
			if(current_rx != null && (current_rx.equals("Y") ||  drug_db_duptherapy_flag.equals("Y")) && allow_duplicate != null && allow_duplicate.equals("N") ) { //&& (patient_class.equals("IP")||  take_home>0)
				ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
				HashMap  dup_info		=	null;
				String dup_drug_info	=	"";

				if(curr_info.size()>=1) {
					dup_info	  =	(HashMap)curr_info.get(0);
					dup_drug_info =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PatientisCurrentlyOn.label", "ph_labels")+ " "+generic_name+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Medicationtill.label", "ph_labels")+"  "+dup_info.get("end_date")+";\n";
					dup_drug_info +=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Hasbeenprescribedby.label", "ph_labels")+" "+dup_info.get("practitioner_name")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.from.label", "common_labels")+" "+dup_info.get("location");
				}

            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(dup_drug_info));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block186Bytes, _wl_block186);

			}
			if(dup_found){

            _bw.write(_wl_block187Bytes, _wl_block187);

			}

            _bw.write(_wl_block188Bytes, _wl_block188);
			if(!amend_yn.equals("Y")){//Added for INC#49425--start
				if(!dup_found){//TBMC-SCF-0167

            _bw.write(_wl_block189Bytes, _wl_block189);
}
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(start_date1));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(end_date1));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tempstartdate1));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tempenddate1));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block192Bytes, _wl_block192);

			}//Added for IN047223--end

            _bw.write(_wl_block193Bytes, _wl_block193);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(presBean_id,presBean,request);

            _bw.write(_wl_block194Bytes, _wl_block194);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideIncl/Excl.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
}
