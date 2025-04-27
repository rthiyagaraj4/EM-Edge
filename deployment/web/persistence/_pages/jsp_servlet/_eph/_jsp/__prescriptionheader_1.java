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
import eCommon.Common.*;
import java.math.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptionheader_1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionHeader_1.jsp", 1738073581401L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" <!-- java.math.* Added for ML-MMOH-CRF-1004 -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/Prescription_1.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<!-- <script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PregnancyCategory.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- Added for INC#70594 -->\n\t\t\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\tparent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value=\"Y\";\n\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\tparent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value=\"N\";\n\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"prescription_header_form\" id=\"prescription_header_form\">\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"99%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr >\n\t\t\t\t\t<td class=\"label\" width=\'15%\' onmouseover=\'dispPrevRecs(this);\' onmouseout=\'hidePrevRecs();\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t&nbsp;&nbsp;<input type=\"text\" name=\"height\" id=\"height\" size=\"5\"  maxlength=\"8\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" class=\"NUMBER\" onchange=\"validateBSA();\" onblur=\"checkweight_rec_appl(this);checkDecimal(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'); \" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\"  oncopy=\"return false\" onpaste=\"return false\" title=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">&nbsp;<b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></td>\n\t\t\t\t\t<!-- added oncopy=\"return false\" onpaste=\"return false\" for [IN:037181]-->\n\t\t\t\t\t<td class=\"label\" width=\'13%\' onmouseover=\'dispPrevRecs(this);\' onmouseout=\'hidePrevRecs();\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;&nbsp;<input type=\"text\" name=\"weight\" id=\"weight\" size=\"5\"  maxlength=\"8\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onChange=\"validateBSA();\"  onblur=\"checkweight_rec_appl(this);checkDecimal(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\" class=\"NUMBER\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" oncopy=\"return false\" onpaste=\"return false\"  title=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td>\t<!-- added oncopy=\"return false\" onpaste=\"return false\" for [IN:037181]-->\n\t\t\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t  <td class=\"label\" width=\'9%\' onmouseover=\'dispPrevRecs(this);\' onmouseout=\'hidePrevRecs();\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;&nbsp;<label id=\"bsa_lbl\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></label><input type=\"hidden\" name=\"bsa\" id=\"bsa\" size=\"5\"  maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> m&sup2;</td>\n\t\t\t\t\t<td class=\"label\" width=\'12%\' onmouseover=\'dispPrevRecs(this);\' onmouseout=\'hidePrevRecs();\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;<label id=\"bmi_lbl\"><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></label><input type=\"hidden\" name=\"bmi\" id=\"bmi\" size=\"5\"  maxlength=\"5\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"> kg/m&sup2;</td>\n\t\t\t\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<td class=\"label\" width=\'12%\' onmouseover=\'dispPrevRecs(this);\' onmouseout=\'hidePrevRecs();\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td>\n\t\t\t\t\t<td class=\"label\" width=\'7%\' onmouseover=\'dispPrevRecs(this);\' onmouseout=\'hidePrevRecs();\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<td class=\"label\" width=\"16%\"  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<select name=\"priority\" id=\"priority\" onchange=\"disablePriority(this,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'); defDispLocnForIV(); setPriorityforMI(this);\">\n\t\t\t\t\t\t\t<option value=\"R\" selected>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t\t\t\t\t<option value=\"U\" >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_prescription\" id=\"external_prescription\" value=\"false\">\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t<select name=\"priority\" id=\"priority\" onchange=\'defDispLocnForIV(); setPriorityforMI(this);\'><option value=\"R\" selected>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option></select>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_prescription\" id=\"external_prescription\" value=\"true\">\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added for BRU-HIMS-CRF-403 [IN:044541]  -start-->\n\t\t\t\t\t<td class=\"label\" width=\'15%\' style=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'tdPrescripionHdrDuration\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" &nbsp;&nbsp;<input type=\"text\" size=\"1\" maxlength=\"3\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"\"  onKeyPress=\"return allowValidNumber(this,event,3,0);\" onchange=\'updateDefDuration();\'>&nbsp;\n\t\t\t\t\t\t<select name=\"durn_desc\" id=\"durn_desc\" onChange=\"updateDefDuration();\">\n\t\t\t\t\t\t<option value=\"D\" selected>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option> \n\t\t\t\t\t\t<option value=\"W\" >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option>\n\t\t\t\t\t\t<option value=\"L\" >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t\t<option value=\"Y\" >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td> <!--Added for BRU-HIMS-CRF-403 [IN:044541] --End -->\n\t\t\t\t\t<td class=\"label\" width=\'20%\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;&nbsp;<input type=\"text\" name=\"sys_date\" id=\"sys_date\" size=\"10\"  maxlength=\"17\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onBlur=\"chkBackFutureOrderDate(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');\">&nbsp;<img SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'Calendar\' onclick=\"showCalendar(\'sys_date\',null,\'hh:mm\');\" > \n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"80%\"   border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"Y\" name=\"presel_order_category_yn\" id=\"presel_order_category_yn\">\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\"   nowrap>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\"15%\" >&nbsp;&nbsp;<select name=\"order_type\" id=\"order_type\" onchange=\"getDrugClass(this);\"><option value=\"\">---";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="---</option>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</option>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t</select>&nbsp;<img   src=\"../../eCommon/images/mandatory.gif\"  id=\"order_type_man\" style=\"visibility:hidden\"></img></td>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tdocument.prescription_header_form.order_type.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t<script>document.prescription_header_form.order_type.disabled=true;</script>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" value=\"N\" name=\"presel_order_category_yn\" id=\"presel_order_category_yn\">\n\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"15%\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t<td class=\"label\"  width=\"15%\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t\t\t\t<td width=\"5%\"><input type=\"checkbox\" id=\"take_home_medication_op_chk\" name=\"take_home_medication_op_chk\" id=\"take_home_medication_op_chk\" onclick=\"assignValueOP(this);defDispLocnForIV()\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" ></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t\t\t<td width=\"5%\"><input type=\"checkbox\" name=\"take_home_medication\" id=\"take_home_medication\" onclick=\"assignValue(this);defDispLocnForIV()\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<td class=\"label\"   width=\"20%\" ><div id=\'divHomeLeave\'  style=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"home_leave_yn_chk\" id=\"home_leave_yn_chk\" value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' onclick=\"assignHomeLeave(this)\" title=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" : ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t\t\t\t\t<br>(";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" - ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" )</div>\n\t\t\t\t\t\t</td><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t\t\t\t\t<td class=\"label\" width=\"15%\" nowrap><label style=\'font-size:11;font-weight:bold;color:red;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =";\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</label><input type=\"hidden\" name=\"allergic_yn\" id=\"allergic_yn\" value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"*\"><a href=\"javascript:callOrderRemarks();\" title=\"Clinical Comments\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =".</a>&nbsp;\n\n ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="   \n\t\t\t\t\t\t\t <a href=\"javascript:callADRdetails(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\');\" >&nbsp;&nbsp;";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<label onClick=\"javascript:callDiagText(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\',\'Header\');\" style=\"visibility:hidden\" id=\"diag_text\" title=\"Diag Text\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</label></td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t<td class=\"label\"  nowrap width=\'10%\'><a href=\"javascript:showPregnancyRemarks(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\');\" title=\"Pregnancy Remarks \">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" </a></td>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" value=\"NO\" name=\"order_type\" id=\"order_type\">\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table cellpadding=\"1\" cellspacing=0 width=\"100%\" align=\"center\" border=\"0\" id=\"tab\">\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t<td width=\'10%\' id=\"nonivrx\" class=\"CASECONDSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'nonivrx\')\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</a></td>\n\t\t\t\t\t\t\t<td class=\"white\" width=\'80%\' id=\"dummy\"></td>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t<td width=\'10%\' id=\"nonivrx\" class=\"CASECONDSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'nonivrx\')\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</a></td>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"comprx\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'comprx\')\">&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</a></td> \n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"ivrx\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'ivrx\')\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="  </a></td>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t<td class=\"white\" width=\'70%\' id=\"dummy\"></td>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"oncology_regimen\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap  ><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'oncology_regimen\')\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</a> </td>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"oncology_regimen\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap  ><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'oncology_regimen\')\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"tpn_regimen\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap  ><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'tpn_regimen\')\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"tdm\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap  ><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'tdm\')\" id=\"tdm_link\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</a> </td>\n\t\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t\t<td width=\'10%\' id=\"NPBRequest\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap  >\n\t\t\t\t\t\t\t\t\t<a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'NPBRequest\')\" id=\"NPBRequest_link\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</a> \n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t<td width=\'10%\' id=\"medicalItem\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_BUTTONS\')\" nowrap  ><a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" href=\"javascript:change_tab_buttons(\'medicalItem\')\" id=\"medicalItem_link\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t<td class=\"white\" width=\'*\' id=\"dummy\"></td>\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"presBean_id\" id=\"presBean_id\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t<input type=\"hidden\" name=\"presBean_name\" id=\"presBean_name\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t<input type=\"hidden\" name=\"height_unit\" id=\"height_unit\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t<input type=\"hidden\" name=\"weight_unit\" id=\"weight_unit\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t<input type=\"hidden\" name=\"calculated_date\" id=\"calculated_date\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t<input type=\"hidden\" name=\"visit_date\" id=\"visit_date\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_sys_date\" id=\"ref_sys_date\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_code_yn\" id=\"order_type_code_yn\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_class\" id=\"drug_class\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t<input type=\"hidden\" name=\"disc_cancel_flag\" id=\"disc_cancel_flag\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"><!-- added for ML-BRU-SCF-2080-->\n\t\t\t\n\t\t<!-- Added for ML-MMOH-SCF-0362 To get ouptatiend set up for deycare patient start -->\t\n\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" <!--value is changed from patient_class to act_patient_class SRR20056-SCF-7622 with Spira incident No : 27687-->\n\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t <!-- Added for ML-MMOH-SCF-0362 To get ouptatiend set up for deycare patient end -->\n\t\t\t<input type=\"hidden\" name=\"order_remarks\" id=\"order_remarks\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t<input type=\"hidden\" name=\"actual_patient_class\" id=\"actual_patient_class\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" name=\"attend_pract_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" name=\"facility_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" name=\"resp_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" name=\"back_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" name=\"future_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" name=\"licence\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" name=\"servide_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" name=\"service_search_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" name=\"problem_ind\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" name=\"version_no\">\n\t\t\t<input type=\"hidden\"  name=\"QueryString\" id=\"QueryString\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" name=\"ph_default_tab\">\n\t\t\t<input type=\"hidden\" name=\"take_medication_yn_chk\" id=\"take_medication_yn_chk\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_without_wt\" id=\"allow_without_wt\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_without_diag\" id=\"allow_without_diag\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t<input type=\"hidden\" name=\"diag_for_medn_order_by\" id=\"diag_for_medn_order_by\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_age\" id=\"patient_age\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t<input type=\"hidden\" name=\"date_of_birth\" id=\"date_of_birth\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"> <!-- Added for MMS-KH-CRF-0016 -->\t\t\t\n\t\t\t<input type=\"hidden\" name=\"diag_size\" id=\"diag_size\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t<input type=\"hidden\" name=\"diag_text_size\" id=\"diag_text_size\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t<input type=\"hidden\" name=\"sliding_scale\" id=\"sliding_scale\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"num\" id=\"num\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"> \n\t\t\t<input type=\"hidden\" name=\"height_min_value\" id=\"height_min_value\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\"> \n\t\t\t<input type=\"hidden\" name=\"height_max_value\" id=\"height_max_value\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"> \n\t\t\t<input type=\"hidden\" name=\"weight_min_value\" id=\"weight_min_value\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"> \n\t\t\t<input type=\"hidden\" name=\"weight_max_value\" id=\"weight_max_value\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t<input type=\"hidden\" name=\"height_min_digits\" id=\"height_min_digits\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"> \n\t\t\t<input type=\"hidden\" name=\"height_max_digits\" id=\"height_max_digits\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"> \n\t\t\t<input type=\"hidden\" name=\"weight_min_digits\" id=\"weight_min_digits\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\"> \n\t\t\t<input type=\"hidden\" name=\"weight_max_digits\" id=\"weight_max_digits\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t<input type=\"hidden\" name=\"iv_prep_default\" id=\"iv_prep_default\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_set_code\" id=\"order_set_code\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"bl_disp_charge_dtl_in_rx_yn\" id=\"bl_disp_charge_dtl_in_rx_yn\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_price_type_in_drug_lkp\" id=\"disp_price_type_in_drug_lkp\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_charge_dtl_in_drug_lkp_yn\" id=\"disp_charge_dtl_in_drug_lkp_yn\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t<input type=\"hidden\" name=\"dc_mar_appl_yn\" id=\"dc_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t<input type=\"hidden\" name=\"em_mar_appl_yn\" id=\"em_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t<input type=\"hidden\" name=\"ip_mar_appl_yn\" id=\"ip_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t<input type=\"hidden\" name=\"op_mar_appl_yn\" id=\"op_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t<input type=\"hidden\" name=\"disch_med_mar_appl_yn\" id=\"disch_med_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t<input type=\"hidden\" name=\"split_based_priority_yn\" id=\"split_based_priority_yn\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t<input type=\"hidden\" name=\"split_based_drug_class_yn\" id=\"split_based_drug_class_yn\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t<input type=\"hidden\" name=\"max_durn_for_ip_pres\" id=\"max_durn_for_ip_pres\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t<input type=\"hidden\" name=\"chk_for_ip_max_durn_action\" id=\"chk_for_ip_max_durn_action\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t<input type=\"hidden\" name=\"max_durn_for_op_pres\" id=\"max_durn_for_op_pres\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t<input type=\"hidden\" name=\"chk_for_op_max_durn_action\" id=\"chk_for_op_max_durn_action\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t<input type=\"hidden\" name=\"max_durn_for_dm_pres\" id=\"max_durn_for_dm_pres\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t<input type=\"hidden\" name=\"chk_for_dm_max_durn_action\" id=\"chk_for_dm_max_durn_action\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t<input type=\"hidden\" name=\"trade_display_yn\" id=\"trade_display_yn\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"> \n\t\t\t<input type=\"hidden\" name=\"narcotic_aprvl_form_req_yn\" id=\"narcotic_aprvl_form_req_yn\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"> \n\t\t\t<input type=\"hidden\" name=\"print_narcotic_form_by_default\" id=\"print_narcotic_form_by_default\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"> \n\t\t\t<!--External Drug Interface Controls -->\t   \n\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"> \n\t\t\t<input type=\"hidden\" name=\"drug_db_product_id\" id=\"drug_db_product_id\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"> \n\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"> \n\t\t\t<input type=\"hidden\" name=\"drug_db_duptherapy_yn\" id=\"drug_db_duptherapy_yn\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"> \n\t\t\t<input type=\"hidden\" name=\"drug_db_interact_check_yn\" id=\"drug_db_interact_check_yn\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_db_contraind_check_yn\" id=\"drug_db_contraind_check_yn\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_db_allergy_check_yn\" id=\"drug_db_allergy_check_yn\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t<input type=\"hidden\" name=\"adr_count\" id=\"adr_count\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\t\t<input type=\"hidden\" name=\"consumable_bean_id\" id=\"consumable_bean_id\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t<input type=\"hidden\" name=\"consumable_bean_name\" id=\"consumable_bean_name\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t<input type=\"hidden\" name=\"MAR\" id=\"MAR\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t\t\t<input type=\"hidden\" name=\"MItemsOnly\" id=\"MItemsOnly\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t\t\t<input type=\"hidden\" name=\"man_rem_on_prn_freq_yn\" id=\"man_rem_on_prn_freq_yn\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t\t\t<input type=\"hidden\" name=\"max_length_prn_reason\" id=\"max_length_prn_reason\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t\t\t<input type=\"hidden\" name=\"rx_qty_by_pres_base_uom_yn\" id=\"rx_qty_by_pres_base_uom_yn\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t\t\t<input type=\"hidden\" name=\"weight_rec_appl_age_group_check_flag\" id=\"weight_rec_appl_age_group_check_flag\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"wt_mand_yn\" id=\"wt_mand_yn\" value=\"\"> <!-- added for Bru-HIMS-CRF-079 IN[029945]  -->\n\t\t\t<input type=\"hidden\" name=\"ht_mand_yn\" id=\"ht_mand_yn\" value=\"\"> <!--  added for Bru-HIMS-CRF-079 IN[029945]  -->\n\t\t\t<input type=\"hidden\" name=\"atc_allergy_alert_level\" id=\"atc_allergy_alert_level\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t\t\t<input type=\"hidden\" name=\"NBPRequestApplYN\" id=\"NBPRequestApplYN\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_interaction_check_yn\" id=\"drug_interaction_check_yn\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t\t<!-- <input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"R\"> -->\n\t\t\t<input type=\"hidden\" name=\"home_leave_yn_val\" id=\"home_leave_yn_val\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\"><!-- added for Bru-HIMS-CRF-093[29960] -->\n\t\t\t<input type=\"hidden\" name=\"home_leave_fm\" id=\"home_leave_fm\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t\t<input type=\"hidden\" name=\"home_leave_to\" id=\"home_leave_to\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\"><!-- adding end for Bru-HIMS-CRF-093[29960] -->\n\t\t\t<input type=\"hidden\" name=\"print_mar_label_yn\" id=\"print_mar_label_yn\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->\n\t\t\t<input type=\"hidden\" name=\"buildMAR_yn\" id=\"buildMAR_yn\" value=\"N\"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->\n\t\t\t<input type=\"hidden\" name=\"trimester\" id=\"trimester\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"><!--added for CRF RUT-CRF-0063[29601] -->\n\t\t\t<input type=\"hidden\" name=\"lmp_date\" id=\"lmp_date\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\"><!--added for CRF RUT-CRF-0063[29601] -->\n\t\t\t<input type=\"hidden\" name=\"pregnency_yn\" id=\"pregnency_yn\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\"><!--added for CRF RUT-CRF-0063[29601] -->\n\t\t\t<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"><!--added for ML-BRU-SCF-0958 [IN:042045] -->\n\t\t\t<input type=\"hidden\" name=\"allergy_conf_reqd_yn\" id=\"allergy_conf_reqd_yn\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"><!--added for ML-BRU-SCF-0958 [IN:042045] -->\n\t\t\t<input type=\"hidden\" name=\"excludeADRAllergyAlert_yn\" id=\"excludeADRAllergyAlert_yn\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"><!--Added for HSA-SCF-0011 [IN:042444] -->\n\t\t\t<input type=\"hidden\" name=\"witness_for_verbal_order_yn\" id=\"witness_for_verbal_order_yn\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\"><!-- Added for AAKH-CRF-0023[IN:038259] -->\n\t\t\t<input type=\"hidden\" name=\"login_user_prac_id\" id=\"login_user_prac_id\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\"><!-- Added for AAKH-CRF-0023[IN:038259] -->\n\t\t\t<input type=\"hidden\" name=\"dispPrescripionDuration\" id=\"dispPrescripionDuration\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\"><!-- Added for BRU-HIMS-CRF-403 [IN:044541] -->\n\t\t\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\"><!-- Added for HSA-CRF-0152 [IN:048469] -->\n\t\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\"><!-- Added for HSA-CRF-0152 [IN:048469] -->\n\t\t\t<input type=\"hidden\" name=\"called_from_verbal_order\" id=\"called_from_verbal_order\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\"><!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete start -->\n\t\t\t<input type=\"hidden\" name=\"default_prev_drug_sel\" id=\"default_prev_drug_sel\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n\t\t\t<input type=\"hidden\" name=\"preview_rx_yn\" id=\"preview_rx_yn\" value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\"><!-- //added for ML-MMOH-CRF-0341 [IN:057179] -->\n\t\t\t<input type=\"hidden\" name=\"allow_priv_to_order_yn\" id=\"allow_priv_to_order_yn\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_seach_autocomplete_yn\" id=\"drug_seach_autocomplete_yn\" value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\"><!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end -->\n\t\t\t<input type=\"hidden\" name=\"disp_prev_vital_signs_yn\" id=\"disp_prev_vital_signs_yn\" value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\"><!--added for ML-MMOH-CRF-0346 [IN:057185]-->\n\t\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"><!--added for JD-CRF-198-->\n\t\t\t<input type=\"hidden\" name=\"alternateOrder\" id=\"alternateOrder\" value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\"><!--added for JD-CRF-198-->\n\t\t\t<input type=\"hidden\" name=\"currentStage\" id=\"currentStage\" value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n\t\t\t<input type=\"hidden\" name=\"split_drug_based_auth_yn\" id=\"split_drug_based_auth_yn\" value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\"><!-- Added for ml-mmoh-cef-0864 -->\n\t\t        <input type=\"hidden\" name=\"allow_alt_for_med_item\" id=\"allow_alt_for_med_item\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"><!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\n\t\t        <input type=\"hidden\" name=\"reconciliation_req_yn\" id=\"reconciliation_req_yn\" value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\"><!-- added for mms-kh-crf-0016 -->\n\t\t          <input type=\"hidden\" name=\"reconciliation_done_yn\" id=\"reconciliation_done_yn\" value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\"><!-- added for IN070786 -->\n\t\t          ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="  <!-- Added for NMC-JD-CRF-0063 -->\n\t\t          <input type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t          ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t        <input type=\"hidden\" name=\"take_home_medication_ckk_val\" id=\"take_home_medication_ckk_val\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\"><!-- added for NMC-JD-CRF-0063 --> \n\t\t         <input type=\"hidden\" name=\"take_home_medication_op\" id=\"take_home_medication_op\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\"><!-- added for NMC-JD-CRF-0063 -->\n\t\t         <input type=\"hidden\" name=\"drug_indication_mdry\" id=\"drug_indication_mdry\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"><!-- Added for JD-CRF-0220 -->\n\t\t\t<div name=\"divPrevHtWtDtls\" id=\"divPrevHtWtDtls\" style=\"position:absolute; width:30%; height:60px; display:none;\" bgcolor=\"blue\"> <!-- div part added for ML-MMOH-CRF-0346 [IN:057185]-->\n";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t\t\t<table id=\"tabPrevHtWtDtls\" cellpadding=0 cellspacing=0 border=\"1\" align=\"center\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th style=\'font-size:9;\' width=\'20%\'>";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</th>\n\t\t\t\t\t\t\t<th style=\'font-size:9;\' width=\'20%\'>";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</th>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" style=\'font-size:10;\' nowrap>";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" style=\'font-size:10;\' nowrap>";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="&nbsp;";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" style=\'font-size:10;\' nowrap>";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t\n\t\t</form>\n";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\t\t\t<script>document.prescription_header_form.sys_date.disabled=true;</script>\n";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t<script>document.prescription_header_form.sys_date.disabled=false;</script>\n";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t<script>document.prescription_header_form.order_type_man.style.visibility=\"visible\";</script>\n";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t<script>\n\t\t\t//alert(\"iv_prep_default in hdr 1 :\"+iv_prep_default);\n\t\t\tsetPriorityforMI(document.prescription_header_form.priority); //added for IN26242 --02/02/2011-- priya\n\t\t\tloadOtherFrames(\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\');\n\t\t</script>\n\t</body>\n";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n</html>\n\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
08/11/2019  IN070606                Manickavasagam J                         MMS-KH-CRF-0029[IN070606]
12/2/2020	6041					Shazana       										NMC-JD-CRF-0063	
23/12/2020	11525					Shazana												NMC-JD-CRF-0063
05/01/2021	 TFS id:7345            Haribabu	      04/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
3/1/2021	15131					Shazana												NMC-JD-CRF-0063	
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
03/10/2023	  	50818  			    Himanshu 						GHL-SCF-1738 					GHL-SCF-1738 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try{
	String licence=(String)(PhLicenceRights.getKey());
	String version_no="";
	version_no= (String) PhVersionNo.getVersion();
	String function_id= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String MAR = "";
	if(function_id.equals("MEDICATION_ADMIN")){
		String MAR_bean_id	= "MedicationAdministrationFTBean";
		String MAR_bean_name= "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean MARBeanObj	= (MedicationAdministrationFTBean)getBeanObject( MAR_bean_id, MAR_bean_name , request);
		MAR=MARBeanObj.getFunctionT();
	}
	String facility_id		= (String) session.getValue("facility_id");
	String iv_prep_default		= request.getParameter("iv_prep_default");
	String function_from        = request.getParameter("function_from")==null?"":request.getParameter("function_from"); //added for JD-CRF-198 
	String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id"); //added for JD-CRF-198 
	if(iv_prep_default == null)  
		iv_prep_default="";
	String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_class	= request.getParameter("patient_class");
  //Added for ML-MMOH-SCF-0362 To get ouptatiend set up for deycare patient
	String new_patient_class="";
	String act_patient_class= request.getParameter("patient_class");
	String bed_num	= request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
	String room_num= request.getParameter("room_num")==null?"":request.getParameter("room_num");
	String episode_id= request.getParameter("episode_id")==null?"":request.getParameter("episode_id"); //added for HSA-CRF-0152 [IN:048469]
	String ammend_called_from= request.getParameter("ammend_called_from")==null?"":request.getParameter("ammend_called_from");//added for  JD-CRF-0198 [IN:058599]

	String visit_adm_date= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date"); //added for HSA-CRF-0152 [IN:048469]
	/*if(encounter_id.equals("null"))
		encounter_id="";*/
	if(encounter_id.equals("") || encounter_id.equals("null")){
		act_patient_class = "XT";
		patient_class= "XT"; // added for IN21446 - 18/05/2010 - priya
	}
	if(patient_class.trim().equals("DC")) 
		patient_class="IP";
	if(patient_class.trim().equals("EM")) 
		patient_class="OP";

	String location_type	= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	if(location_type.equals("E"))//added for ML-BRU-SCF-1313 [IN:048840] for Precudural Unit Patients
		location_type ="C";
	String location_code	= request.getParameter("location_code");
	String ph_default_tab	= request.getParameter("ph_default_tab");
	//intake parameters end
	//declaration
	String leg_value_1				= "";
	String leg_uom_1				= "";
	String leg_value_2				= "";
	String leg_uom_2				= "";
	float bsa						= 0f;
	String bsa_str					= "";
	String visit_date				= "";
	String sys_date					= "";
	String calculated_date			= "";
	String order_type_code_yn		= "";
	String take_medication_yn_chk	= "";
	String take_medication_yn_dis	= "";
	String take_medication_yn_val	= "";
	//adding start for Bru-HIMS-CRF-093 [IN:029960]
	String home_leave_yn_val	= "";
	String home_leave_disp	= "";
	int homeleave_rec				= 0;
	int homeleave_chk				= 0;
	//adding end for Bru-HIMS-CRF-093 [IN:029960]
	int medication_rec				= 0;
	String pract_id					= "";
	String resp_id					= "";
	String pract_reln_id			= "";
	String pract_name				= "";
	String attend_pract_id			= "";
	String order_remarks			= "";
	String or_bean_id				= "";
	String man_rem_on_prn_freq_yn	= "";
	boolean MItemsOnly				= false;
	String narcotic_aprvl_form_req_yn	    = "";
	String print_narcotic_form_by_default	= "";
	String rx_qty_by_pres_base_uom_yn	    = "";
	String back_date				= "";
	String future_date				= "";
	String servide_code				= "";
	String service_search_yn		= "N";
	String allow_without_wt			=	"";
	String allow_without_diag		=	"";
	String patient_age				=	"";
	String date_of_birth			=	"";
	String gender				    =	"";
	String patient_name             =   ""; // Added for MMS-KH-CRF-0016
	String atc_allergy_alert_level   =	"N";
	String drug_interaction_check_yn   =	"N";
	String dispPrescripionDuration   =	"", prescripionDurationDisplay="visibility:hidden"; //Added for BRU-HIMS-CRF-403 [IN:044541]
	String pract_type   =	""; //added for ML-BRU-SCF-0958 [IN:042045]
	String generic_id="";//added for  JD-CRF-0198 [IN:058599]
	String alternateOrder="N";//added for  JD-CRF-0198 [IN:058599]
	String currentStage="";//added for  JD-CRF-0198 [IN:058599]
	String take_home_medication_op    = "";//added for NMC-JD-CRF-0063
	String take_home_medication_ip = "N";//added for NMC-JD-CRF-0063
	String take_home_medication_ckk_val ="N";//added for NMC-JD-CRF-0063
	//end
	//getting the reqd values from OR bean
	String or_bean_name				= "eOR.OrderEntryBean";
	or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
	orbean.setLanguageId(locale);

	resp_id							= (String) orbean.getResponsibilityId();
	pract_id						= (String) orbean.getPractitionerId();
	pract_type						= (String) orbean.getPractitionerType(); //added for ML-BRU-SCF-0958 [IN:042045]
	pract_name						= (String) orbean.getPractitionerName();
	attend_pract_id					= (String) orbean.getAttendPractitionerId();
	String login_user_prac_id		= (String)orbean.getLoginPractId();	// Added for AAKH-CRF-0023[IN:038259]
	servide_code					= (String) orbean.getServiceCode();
	service_search_yn				= (String) orbean.getRestrictYn();
	pract_reln_id				= (String) orbean.getRelationshipId();
	ArrayList OrderIDArr			=	orbean.getCopyOrderDetails();
	ArrayList exist_orders			=	new ArrayList();
	
	String record[]= new String[10];
	if(OrderIDArr!=null){
		for(int i=0;i<OrderIDArr.size(); i++) {
			record	=	((String[])OrderIDArr.get(i));
			exist_orders.add(record[0]);
			exist_orders.add(record[1]);
			exist_orders.add(record[2]);
		}
	}
	//getting the reqd values from PH bean
	String mode					= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name			= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request );
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	presBean.setLanguageId(locale);
	String reconciliation_done_yn=CommonBean.checkForNull((String)bean.reconciliationDoneyn(patient_id,encounter_id));//added for IN070786
	boolean default_dose_type_yn = presBean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
	boolean op_take_home_medication = presBean.isSiteSpecific("PH", "OP_TAKE_HOME_MEDICATION");//Added for NMC-JD-CRF-0063
	boolean allergy_conf_reqd_yn=false;//added for RUT-CRF-0064.1 [IN:041799] -Start
	boolean disc_cancel_flag =presBean.isSiteSpecific("PH","DISCONTINUE_CANCEL_YN");//added for ML-BRU-SCF-2080
	bean.defaultDispLocnSelectAppl(); //Added for TFS-16341-Start
	if(function_from.equals("ALTERNATE_ORDER")){//added for  JD-CRF-0198 [IN:058599]
		bean.setAmend_alternate_yn("Y");
		String	bean_id_1					=	"DispMedicationBean" ;
		String	bean_name_1					=	"ePH.DispMedicationBean";
		DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
		alternateOrder = "Y";
		
		currentStage=bean_1.getDispStatusType(bean_1.getOrStatus_1());
		bean.setAlterAmendReason(bean_1.getAlternateAmendReason());
		take_medication_yn_dis	= "disabled";
	}//added for  JD-CRF-0198 [IN:058599]
	bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029[IN070606]
	if(!encounter_id.equals(""))
		allergy_conf_reqd_yn = bean.getAllergyConfDtls(patient_id, encounter_id); //added for RUT-CRF-0064.1 [IN:041799] -End

	String NBPRequestApplYN = presBean.getNBPRequestAppl(resp_id, pract_reln_id, encounter_id, patient_id);
	String excludeADRAllergyAlert_yn = bean.getExcludeADRAllergyAlert();//Added for HSA-SCF-0011 [IN:042444]
	bean.setLanguageId(locale);
	bean.setActPatientClass_frm_Hdr(act_patient_class); //added while fixing  IN26267 --02/02/2011-- priya (to calc charge details of copied drugs from prev order)
	bean.setPreAllocApplYN();//Added for TFS id:7345
	if(exist_orders.size() > 0 ) {
		bean.setExitingOrders(exist_orders);
	}
    int adr_count =(int)bean.getADRCount(patient_id,"%");
	bean.setStockInstalledYN();//added for performance; ML-MMOH-SCF-00684
	//getting the External Drug Interface Controls 
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
// pregnancy Category Bean

    String pregn_bean_id = "PregnancyCategory" ;
	String pregn_bean_name = "ePH.PregnancyCategoryBean";
	PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;

	/*String drug_bean_id = "@DrugSearchBean"+patient_id+encounter_id;
	String drug_bean_name = "ePH.DrugSearchBean";
	DrugSearchBean drug_bean = (DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ;
    drug_bean.setPractitionerId(pract_id);
    */
	String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
	String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);    
	String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
	String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
	String overlap_period_for_op        =   param_bean.getOverlapPeriodForOP(facility_id);//CRF-20085.1
	String overlap_period_for_ip        =   param_bean.getOverlapPeriodForIP(facility_id);//CRF-20085.1

	bean.setOverlapPeriodForOP(overlap_period_for_op);//CRF-20085.1
	bean.setOverlapPeriodForIP(overlap_period_for_ip);//CRF-20085.1

	param_bean.clear();
				
	String regimen_yn				=  "N";
	String tpn_yn					=  "N";
	String indicator_desc			=  "";
	String problem_ind				=  "";
	String rec_date					=  "";
	String bmi_str					=  "";
	String allergyvisiblity			=  "visibility:hidden";
	String allergic_yn				=  "N";
	String height_min_value			= "";
	String height_max_value			= "";
	String weight_min_value			= "";
	String weight_max_value			= "";
	String height_min_digits		= "";
	String height_max_digits		= "";
	String height_dec_digits		= "";
	String weight_dec_digits		= "";
	String weight_min_digits		= "";
	String weight_max_digits		= "";
	String comp_rx_appl_yn			= "N";
	String iv_rx_appl_yn			= "N";
	String oncology_rx_appl_yn		= "N";
	String tpn_rx_appl_yn			= "N";
	String tdm_appl_yn				= "N";	
	String bl_disp_charge_dtl_in_rx_yn		= "";
	String disp_charge_dtl_in_drug_lkp_yn	= "";
	String disp_price_type_in_drug_lkp	= "";
	String dc_mar_appl_yn				= "";
	String em_mar_appl_yn				= "";
	String ip_mar_appl_yn				= "";
	String op_mar_appl_yn				= "";
	String disch_med_mar_appl_yn		= "";
	String split_based_priority_yn		= "";
	String split_based_drug_class_yn	= "";
	String split_drug_based_auth_yn    ="";//added for ml-mmoh-crf-0864
	String max_durn_for_ip_pres			= "";
	String chk_for_ip_max_durn_action	= "";
	String max_durn_for_op_pres			= "";
	String chk_for_op_max_durn_action	= "";
	String max_durn_for_dm_pres			= "";
	String chk_for_dm_max_durn_action	= "";
	String trade_display_yn				= "";
	String max_length_prn_reason		= "";	
	String bl_install_yn				= (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
	String leave_fm                     ="";
	String leave_to                     ="", print_mar_label_yn="";
	String witness_for_verbal_order_yn	= ""; 	// Added for AAKH-CRF-0023[IN:038259]
	String diag_for_medn_order_by="P"; //MMS-SCF-0325 [IN:048069]
	HashMap temp = new HashMap();
        String tempstartString = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempendString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempsysString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String called_from_verbal_order =bean.getCalled_from_verbal_order(); //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
	String default_prev_drug_sel ="", allow_priv_to_order_yn=""; //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
	String preview_rx_yn ="";//added for ML-MMOH-CRF-0341 [IN:057179]
	String disp_prev_vital_signs_yn ="N";//Added for ML-MMOH-CRF-0346 [I<I></I>N:057185]
	LinkedHashMap hmPrev_vital_signs = null;//Added for ML-MMOH-CRF-0346 [IN:057185]
	int index = 0;
	String reconciliation_yn="N";//added for mms-kh-crf-0016
	String reconciliation_req_yn="N";//added for mms-kh-crf-0016
	String reconciliation_req_yn_button="N";//ADDEDE FOR IN070786
	int prev_drug_count=0;//added for mms-kh-crf-0016
	String drug_indication_mdry="";//added for jd-crf-0220
	//code added during PE By Naveen
    bean.getProfileCount(patient_id);
	if(bl_install_yn.equals("Y")){
         bean.setBLDecimalFormatString(presBean.getDecimalFormatString());
	}

	HashMap discr_values	=	presBean.getHgtWgtDtls(patient_id);
	if(discr_values.containsKey("HEIGHT_MIN_VALUE")) {	
		height_min_value	=	(String)discr_values.get("HEIGHT_MIN_VALUE");
		height_max_value	=	(String)discr_values.get("HEIGHT_MAX_VALUE");
		height_min_digits	=	(String)discr_values.get("HEIGHT_MIN_DIGITS");
		height_max_digits	=	(String)discr_values.get("HEIGHT_MAX_DIGITS");
		height_dec_digits	=	(String)discr_values.get("HEIGHT_DEC_DIGITS");
	}
	if(discr_values.containsKey("WEIGHT_MIN_VALUE")) {	
		weight_min_value	=	(String)discr_values.get("WEIGHT_MIN_VALUE");
		weight_max_value	=	(String)discr_values.get("WEIGHT_MAX_VALUE");
		weight_min_digits	=	(String)discr_values.get("WEIGHT_MIN_DIGITS");
		weight_max_digits	=	(String)discr_values.get("WEIGHT_MAX_DIGITS");
		weight_dec_digits	=	(String)discr_values.get("WEIGHT_DEC_DIGITS");
	}

	HashMap appl_orders	=	bean.getApplicableOrders(facility_id);

	if(appl_orders != null){
		comp_rx_appl_yn		=	(String)appl_orders.get("COMP_RX_APPL_YN")==null?"N":(String)appl_orders.get("COMP_RX_APPL_YN");
		iv_rx_appl_yn		=	(String)appl_orders.get("IV_RX_APPL_YN")==null?"N":(String)appl_orders.get("IV_RX_APPL_YN");
		oncology_rx_appl_yn	=	(String)appl_orders.get("ONCOLOGY_RX_APPL_YN")==null?"N":(String)appl_orders.get("ONCOLOGY_RX_APPL_YN");
		tpn_rx_appl_yn		=	(String)appl_orders.get("TPN_RX_APPL_YN")==null?"N":(String)appl_orders.get("TPN_RX_APPL_YN");
		tdm_appl_yn			=	(String)appl_orders.get("TDM_APPL_YN")==null?"N":(String)appl_orders.get("TDM_APPL_YN");
		man_rem_on_prn_freq_yn =(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN"); 
	}
	//added for JD-CRF-198 - start
		if(function_from.equals("ALTERNATE_ORDER")){
		comp_rx_appl_yn = "";
		iv_rx_appl_yn = "";
		oncology_rx_appl_yn = "";
		tpn_rx_appl_yn="";
		tdm_appl_yn="";
		bean.setParentOrderIdForAltOrder(order_id);
		}
	//added for JD-CRF-198 - end
	int num = bean.loadallergydetail(patient_id);
	  //num=1;
	if(num>0){
		allergyvisiblity="visibility:visible";
		allergic_yn = "Y";
	}
	if(version_no.equals("3")){
		String oncology_bean_id				= "@OncologyRegimenBean"+patient_id+encounter_id;
		String oncology_bean_name			= "ePH.OncologyRegimenBean";
		OncologyRegimenBean oncology_bean	= (OncologyRegimenBean)getBeanObject( oncology_bean_id, oncology_bean_name, request );
		oncology_bean.setLanguageId(locale);

		HashMap	regimenValues				= (HashMap)oncology_bean.getRegimenValues(servide_code);
		if(regimenValues!=null){
			 regimen_yn						=	(String)regimenValues.get("regimen_yn");
			 tpn_yn							=	(String)regimenValues.get("tpn_yn");
			 indicator_desc					=	(String)regimenValues.get("indicator_desc");
			 problem_ind					=	(String)regimenValues.get("problem_ind");
			
			 if(regimen_yn==null) regimen_yn  = "N";
			 if(tpn_yn==null) tpn_yn  	= "N";
			 if(indicator_desc==null) indicator_desc  = "";
		}
		putObjectInBean(oncology_bean_id,oncology_bean,request);
	}
	//getting the height/uom and weight/uom values from prescription bean:
	HashMap HeaderHtWtValues		=(HashMap) presBean.loadHeaderHtWtValues(facility_id,patient_id,encounter_id,act_patient_class);
	if( HeaderHtWtValues.size()>1 ){
		 if(HeaderHtWtValues.containsKey("HEIGHT")){
			leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
			leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		if(HeaderHtWtValues.containsKey("WEIGHT")){
			leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
			leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		/* if(leg_uom_1==null) 
			leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Cms.label", "ph_labels");
		if(leg_uom_2==null) 
			leg_uom_2=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Kgs.label", "common_labels");
		 */
		 bsa_str			= (String.valueOf(bsa));
		
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)>0 && !leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)>0  ) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0")) 
			bmi_str= "";
	}
	else

	{
	HashMap discr_values_default	=	presBean.getHgtWgtDtlsDefault(patient_id);
    System.out.println("discr_values_default"+discr_values_default);
if(discr_values_default.containsKey("HEIGHT")) {	
	leg_uom_1	=	(String)discr_values_default.get("HEIGHT");

}
if(discr_values_default.containsKey("WEIGHT")) {	
	leg_uom_2	=	(String)discr_values_default.get("WEIGHT");
	
}
}
	double enc_id=0;	
	if(!patient_class.equals("XT")){
		enc_id=Double.parseDouble(encounter_id);
		visit_date		=	presBean.getVisitDate(enc_id,facility_id);
	}
	ArrayList param_vals	=	bean.getParameterValues();
	System.err.println(param_vals);
	if(param_vals!=null && param_vals.size()!=0) {
		int iCount=0;
		allow_without_diag				=	(String)param_vals.get(iCount++); //0
		allow_without_wt				=	(String)param_vals.get(iCount++);
		bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(iCount++);
		disp_charge_dtl_in_drug_lkp_yn	=	(String)param_vals.get(iCount++);
		disp_price_type_in_drug_lkp		=	(String)param_vals.get(iCount++);
		dc_mar_appl_yn					=	(String)param_vals.get(iCount++);
		em_mar_appl_yn					=	(String)param_vals.get(iCount++);
		ip_mar_appl_yn					=	(String)param_vals.get(iCount++);
		op_mar_appl_yn					=	(String)param_vals.get(iCount++);
		disch_med_mar_appl_yn			=	(String)param_vals.get(iCount++);
		split_based_priority_yn			=	(String)param_vals.get(iCount++);//10
		split_based_drug_class_yn		=	(String)param_vals.get(iCount++);
		narcotic_aprvl_form_req_yn		=	(String)param_vals.get(iCount++);
		print_narcotic_form_by_default	=	(String)param_vals.get(iCount++);
		rx_qty_by_pres_base_uom_yn		=	(String)param_vals.get(iCount++);
		atc_allergy_alert_level			=   (String)param_vals.get(iCount++);//15
		iCount++; //added for added for CRF MMS-QH-CRF-0068 [IN:037980] (allow_without_diag_dd)//16
		print_mar_label_yn			=   (String)param_vals.get(iCount++); //Added for MMS-QH-CRF-0080 [IN:038064] //17
		iCount++; // added for  MMS-QH-CRF-0080 [IN:038064] //18
		dispPrescripionDuration	=	(String)param_vals.get(iCount++);//19
		diag_for_medn_order_by=(String)param_vals.get(iCount++);//20 //MMS-SCF-0325 [IN:048069]
		default_prev_drug_sel			=   (String)param_vals.get(iCount++); //21 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		preview_rx_yn					=	(String)param_vals.get(iCount++);//22//added for ML-MMOH-CRF-0341 [IN:057179]
		disp_prev_vital_signs_yn	=	(String)param_vals.get(iCount++);//23 //Added for ML-MMOH-CRF-0346 [IN:057185]
		//drug_indication_mdry=(String)param_vals.get(iCount++);//added for jd-crf-0220 commented for amend
		drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
				System.out.println("drug_indication_mdry prescriptionheader_1"+drug_indication_mdry);
		max_length_prn_reason			=   (String)param_vals.get(iCount++); //24
		max_durn_for_ip_pres		=	(String)param_vals.get(iCount++); //25
		chk_for_ip_max_durn_action	=	(String)param_vals.get(iCount++);//26
		max_durn_for_op_pres		=	(String)param_vals.get(iCount++);//27
		chk_for_op_max_durn_action	=	(String)param_vals.get(iCount++); //28
		max_durn_for_dm_pres		=	(String)param_vals.get(iCount++);
		chk_for_dm_max_durn_action	=	(String)param_vals.get(iCount++);
		trade_display_yn			=	(String)param_vals.get(iCount++);
		drug_interaction_check_yn	=	(String)param_vals.get(iCount++);//32
		iCount++;//added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		allow_priv_to_order_yn	=	(String)param_vals.get(iCount++);//34 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		split_drug_based_auth_yn        =(String)param_vals.get(iCount++);//35//added for ml-mmoh-crf-0864
		reconciliation_yn=(String)param_vals.get(iCount++);//36 added for mms-kh-crf-0016
				
	} 
	witness_for_verbal_order_yn = bean.getWitnessForVerbalOrder();		// Added for AAKH-CRF-0023[IN:038259]
	order_remarks	= (String)bean.getPresRemarks();
	if("Y".equals(disp_prev_vital_signs_yn) && !("XT".equals(act_patient_class)))//added for ML-MMOH-CRF-0346 [IN:057185]
		hmPrev_vital_signs	=(LinkedHashMap) presBean.loadPrevHtWtValues(facility_id, patient_id,encounter_id, act_patient_class);
	else 
		disp_prev_vital_signs_yn="N";

	HashMap patient_details	=	bean.getPatientDetails_1(patient_id);
	if(patient_details!=null && patient_details.size()!=0) {
		patient_age	=	(String)patient_details.get("age");
		date_of_birth	=	(String)patient_details.get("date_of_birth");
		gender	=	(String)patient_details.get("sex");
		gender	=	gender.substring(0,1).toUpperCase();
		patient_name = CommonBean.checkForNull((String)patient_details.get("patient_name")); // Added for MMS-KH-CRF-0016
	}
	//check for recorded diagnosis
	ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);
	int diag_size	=	(diagnosis).size();

	//getting system date
	//sys_date=(String) DateUtils.getCurrentDate("DMYHM",locale); //Commented for IN031192 - Leap year_CA_Pharmacy order_Thai login
	sys_date=(String) presBean.getSysdate();  //Added for IN031192 - Leap year_CA_Pharmacy order_Thai login
	String pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for CRF RUT-CRF-0063[29601]--start
	String lmp_date                 =presBean.getLMPDate(patient_id);
	double preg_week                =Math.ceil(presBean.getCalPregStage(sys_date,lmp_date));
	String trimester                =presBean.getTrimster(preg_week);
	bean.setPregnencyYN(pregnency_yn);
	bean.setPregTrimester(trimester);//added for CRF RUT-CRF-0063[29601] --end
	bean.setCalledFrom("");
	//getting back date of order date/time
	HashMap BackDates=(HashMap) presBean.getBackDate(sys_date);
	if(BackDates.size()>0){
		back_date			= (String) BackDates.get("BACK_DATE");
		future_date			= (String) BackDates.get("FUTURE_DATE");
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -Start
	if(!locale.equals("en")){
		sys_date =	com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM","en",locale);
		back_date			= com.ehis.util.DateUtils.convertDate(back_date,"DMYHM","en",locale);
		future_date			= com.ehis.util.DateUtils.convertDate(future_date,"DMYHM","en",locale);
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -End
	bean.setOrderDate(sys_date); //Moved from above for IN031192 - Leap year_CA_Pharmacy order_Thai login
	//adding start for Bru-HIMS-CRF-093 [IN:029960]
	HashMap homeleave_vals	=	presBean.getHomeLeaveDates(encounter_id,facility_id);
	ArrayList takeHomeDates = new ArrayList();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	if(homeleave_vals!=null && homeleave_vals.size()>0){
		leave_fm = (String)homeleave_vals.get("LEAVE_FR_DATE");
		leave_to = (String)homeleave_vals.get("LEAVE_TO_DATE");
		tempstartString  = leave_fm.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempendString  = leave_to.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempsysString = (String) presBean.getSysdate().substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_fm);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_to);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		bean.setTakeHomeDates(takeHomeDates);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	homeleave_chk = presBean.getHomeLeaveCHK(tempsysString,tempstartString,tempendString);//adding end for Bru-HIMS-CRF-093 [IN:029960]//Modified for Bru-HIMS-CRF-093-DD1[IN047223]
	bean.setPatient_class_tkHome(patient_class);//added for NMC-JD-CRF-0063
	//validation for Home Medication
	if(patient_class!=null && patient_class.equals("OP")){
		take_medication_yn_chk	= "";
		take_medication_yn_dis	= "disabled";
		take_medication_yn_val	= "N";
		if(op_take_home_medication){//added for NMC-JD-CRF-0063 START
			take_home_medication_op = "Y";
			take_medication_yn_dis	= "";	
		}else{
			take_home_medication_op = "N";
		}
		bean.setTakeHomeMedicationOp(take_home_medication_op);
		//System.out.println("bean.getTake_home_medication_op() : "+bean.getTake_home_medication_op());//COMMENT FOR NMC-JD-CRF-0063
	}
	else{
		if(!patient_class.equals("XT")){			
			medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		//added for mms-kh-crf-0016 start
			if(reconciliation_yn.equals("Y") && act_patient_class.equals("IP")){
				prev_drug_count=bean.getPreviousdrugData(facility_id,act_patient_class,bed_num,room_num,patient_id,encounter_id,location_type,location_code,medication_rec,patient_class);
					reconciliation_req_yn_button="Y";//added for IN070786
				if(prev_drug_count==0)reconciliation_req_yn="Y";
				else reconciliation_req_yn="N";
			}
			else{
				reconciliation_req_yn="N";
			}
			//added for mms-kh-crf-0016 end
		}
		
		if(patient_class.equals("") || patient_class==null){//NMC-JD-CRF-0063[15131] 
			patient_class = bean.getPrEncounterPatientClass(patient_id, encounter_id); 
				if ( patient_class != null && ( patient_class.equals("O") || patient_class.equals("E") ) ) {
					take_medication_yn_chk = "";
					take_medication_yn_dis = "disabled";
					take_medication_yn_val = "N";
					if (op_take_home_medication) {//added for NMC-JD-CRF-0063 START
						take_home_medication_op = "Y";
						take_medication_yn_dis = "";
					} else {
						take_home_medication_op = "N";
					}
					bean.setTakeHomeMedicationOp(take_home_medication_op);
				}
				if(patient_class.equals("O"))//NMC-JD-CRF-0063[13355]
					patient_class="OP";//end
			}//END
		
		//System.err.println("reconciliation_req_yn in header"+reconciliation_req_yn);
		bean.setReconciliation_yn(reconciliation_req_yn_button);//MODIFIED FROM reconciliation_req_yn  TO reconciliation_req_yn_button TO IN070786
		if(medication_rec>0){
			take_medication_yn_chk	= "checked";
			take_medication_yn_dis	= "";
			take_medication_yn_val	= "Y";
			patient_class="OP";
		}
		else{
			take_medication_yn_chk	= "";
			take_medication_yn_dis	= "";
			take_medication_yn_val	= "N";
		}
	}
	if(patient_class.equals("IP")){			//adding start for Bru-HIMS-CRF-093 [IN:029960]
		homeleave_rec=(int)presBean.getHomeLeaveYn(encounter_id,facility_id);
	}
	if(homeleave_rec>0 && homeleave_chk>0 ){
		home_leave_yn_val	= "Y";
	}
	else
		home_leave_yn_val	= "N"; //adding end for Bru-HIMS-CRF-093 [IN:029960]
	if(patient_class.equals("IP") && home_leave_yn_val.equals("Y")) //adding start for Bru-HIMS-CRF-093 [IN:029960] 
		home_leave_disp = "";
	else
		home_leave_disp = "display:none;";
	//getting the last modified order remarks
	//Intialize the bean with default values
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
	//String key	= (orbean.getPatientId()+orbean.getEncounterId());
	String key	= (orbean.getPatientId()+encounter_id);
	// Unique key to keep the Value in the Bean
	java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
	//added for NMC-JD-CRF-0063
	if(previousValues!=null){
		if(patient_class!=null && patient_class.equals("OP")){
			if(op_take_home_medication){
				take_medication_yn_dis	= "disabled";
				if(bean.getOpHomeMedicationVal()!=null){//Added for NMC-JD-CRF-0063 START [11525]
					if(bean.getOpHomeMedicationVal().equals("Y"))
						take_medication_yn_chk	= "checked";
				}
			}
		}
	}
	if(previousValues==null || previousValues.equals("")){
		bean.setOpHomeMedicationVal(null);    //END
	}//END
	ArrayList ordeCatalogCode = new ArrayList();
	String consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
	String consumable_bean_name				= "ePH.ConsumableOrderBean";
	if(iv_prep_default==null || iv_prep_default.equals("")){
		String cn_order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH", pract_type); // pract_type added for ML-BRU-SCF-0958 [IN:042045]
		if(cn_order_catalog_code==null)
			cn_order_catalog_code="";
		//cn_order_catalog_code 		= "N02BE01000T1001C#1#PH,N02BE01000T1001C#2#PH,MYITEM1#1#MS";
		//order_set_code = "DRND";

		ConsumableOrderBean consumable_bean		= (ConsumableOrderBean)getBeanObject( consumable_bean_id,consumable_bean_name , request );
		consumable_bean.setLanguageId(locale);
		consumable_bean.clear();
		consumable_bean.setOrderDate(sys_date);	// Added for Bru-HIMS-CRF-385 [IN:041644]
		StringTokenizer catalogdetail;
		if(!order_set_code.equals("") && !cn_order_catalog_code.equals("")){
			consumable_bean.setLocationCode(location_code);
			consumable_bean.setLocationType(location_type);
			consumable_bean.setPatientId(patient_id);
			consumable_bean.setEncounterId(encounter_id);
			consumable_bean.setPatientClass(patient_class);
			consumable_bean.setActPatientClass(act_patient_class);
			consumable_bean.setCalledFrom("RX");
			String order_set_occur_num = "";
			String drug_yn ="";
			int count;
			String temp_dat ="";
			StringTokenizer token = new StringTokenizer(cn_order_catalog_code, ",");
			while(token.hasMoreTokens()){
				count =0;
				catalogdetail = new StringTokenizer(token.nextToken(), "#");
				while(catalogdetail.hasMoreTokens()){
					count++;
					temp_dat = catalogdetail.nextToken();
					ordeCatalogCode.add(temp_dat);
				}
				if(count == 1){/*=== Code added for IN20379 to make MS items display in Medical Items tab when selected from Addtnl Search --05-04-2010-- priya ===*/
					drug_yn = presBean.getDrugYN(temp_dat);
					if(drug_yn!=null && !(drug_yn.equals(""))){
						if(drug_yn.equals("N")){
							ordeCatalogCode.add("1");
							ordeCatalogCode.add("MS");
						}
						else{
							ordeCatalogCode.add("1");
							ordeCatalogCode.add("DRUG");
						}
					}
				} 
			}
			if(ordeCatalogCode != null && ordeCatalogCode.size()>0)	{	
				MItemsOnly = true;
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					if((i+2)<= (ordeCatalogCode.size()-1)) // condition added for IN20379 --05-04-2010-- priya--
					if(((String)ordeCatalogCode.get(i+2)).equals("MS")){
						order_set_occur_num = (String)ordeCatalogCode.get(i+1);
						consumable_bean.loadItemDetail((String)ordeCatalogCode.get(i),order_set_code,order_set_occur_num,  "", "", bl_install_yn, bl_disp_charge_dtl_in_rx_yn, take_medication_yn_val, "R",  pract_id, resp_id,"0"); //modified By Himanshu  added 0 in last param for GHL-SCF-1738 -->
					}
					else{
						MItemsOnly = false;
						continue;
					}
				}
			}
		}
//Code added for IN20339 to make MS items displayed in Medical Items tab --31/03/2010-- priya 
		else if(order_set_code.equals("") && !cn_order_catalog_code.equals("")){
			consumable_bean.setLocationCode(location_code);
			consumable_bean.setLocationType(location_type);
			consumable_bean.setPatientId(patient_id);
			consumable_bean.setEncounterId(encounter_id);
			consumable_bean.setPatientClass(patient_class);
			consumable_bean.setActPatientClass(act_patient_class);
			StringTokenizer token_codes = new StringTokenizer(cn_order_catalog_code, ",");
			String hash_key ="";
			String temp_token = "";
			cn_order_catalog_code ="";
			while(token_codes.hasMoreTokens()){
				temp_token = token_codes.nextToken();
				hash_key ="h2"+temp_token;
				cn_order_catalog_code = cn_order_catalog_code+temp_token+"#1#"+previousValues.get(hash_key);
				if(token_codes.hasMoreTokens()){
					cn_order_catalog_code = cn_order_catalog_code+",";
				}
			}
			StringTokenizer token = new StringTokenizer(cn_order_catalog_code, ",");
			while(token.hasMoreTokens()){
				catalogdetail = new StringTokenizer(token.nextToken(), "#");
				while(catalogdetail.hasMoreTokens()){
					ordeCatalogCode.add(catalogdetail.nextToken());
				}
			}
			if(ordeCatalogCode != null && ordeCatalogCode.size()>0)	{	
				MItemsOnly = true;
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					if((i+2)<ordeCatalogCode.size() && ((String)ordeCatalogCode.get(i+2)).equals("MS")){
						//order_set_occur_num = (String)ordeCatalogCode.get(i+1);
						consumable_bean.loadItemDetail((String)ordeCatalogCode.get(i),"","",  "", "", bl_install_yn, bl_disp_charge_dtl_in_rx_yn, take_medication_yn_val, "R",  pract_id, resp_id,"0"); //modified By Himanshu  added 0 in last param for GHL-SCF-1738-->
					}
					else{
						MItemsOnly = false;
						continue;
					}
				}
			}
		}
		putObjectInBean(consumable_bean_id,consumable_bean,request);
	}
	String or_order_type_code_yn="";
	String or_order_type_value="";
	HashMap OrderType=(HashMap) presBean.populateOrderType(patient_class);
	if(OrderType.size()>0){
		or_order_type_code_yn=(String) OrderType.get("ORDER_TYPE_CODE_YN");
		if(or_order_type_code_yn==null) 
			or_order_type_code_yn="N";
	}
	if(or_order_type_code_yn.equals("Y")){
		or_order_type_value=(String) orbean.getOrderTypeValue();
	}
	else{
		or_order_type_value="";
	}
	/*order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH")==null?"":orbean.getOrderCatalogCode(previousValues,"PH");
	ordeCatalogCode = new ArrayList();
	if(!order_catalog_code.equals("")){
		StringTokenizer token = new StringTokenizer(order_catalog_code, ",");
		while(token.hasMoreTokens()){
			ordeCatalogCode.add(token.nextToken());
		}
	}*/
	ArrayList details = (ArrayList) bean.getpresDetails();
	if(details!=null && details.size()>0){

            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else{

            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	ArrayList	ht_wt_uom	=	presBean.getHTWTUOM(patient_id);
	if(ht_wt_uom!=null && ht_wt_uom.size() > 1) {
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		if(leg_value_1==null || leg_value_1.equals("")) {
			if (leg_uom_1 == null || leg_uom_1.equals(""))
				leg_uom_1	=	(String)ht_wt_uom.get(0);	
			if( ht_wt_uom.size() > 2) {
				leg_value_1 =	(String)ht_wt_uom.get(2);	
			}
		}
		if(leg_value_2==null || leg_value_2.equals("")) {
			if (leg_uom_2 == null || leg_uom_2.equals(""))
			leg_uom_2	=	(String)ht_wt_uom.get(1);	
			if( ht_wt_uom.size() > 4) {
				leg_value_2 =	(String)ht_wt_uom.get(3);
				rec_date	=	(String)ht_wt_uom.get(4);
			}
		}
		if((leg_value_2==null || leg_value_2.equals("")) &&( leg_uom_1==null || leg_uom_1.equals("")))
			rec_date = "";
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		bsa_str			= (String.valueOf(bsa));
		if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0"))
			bmi_str= "";
		if(!bsa_str.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
			bsa_str= BigDecimal.valueOf(Double.valueOf(bsa_str)).setScale(2, BigDecimal.ROUND_UP).toString();
		} // Added for ML-MMOH-CRF-1004 - End
	}
	//added for ml-mmoh-scf-0862 start
	HashMap discr_values_default	=	presBean.getHgtWgtDtlsDefault(patient_id);
	System.out.println("discr_values_default"+discr_values_default);
	if(discr_values_default.containsKey("HEIGHT")) {	
		leg_uom_1	=	(String)discr_values_default.get("HEIGHT");
	
	}
	if(discr_values_default.containsKey("WEIGHT")) {	
		leg_uom_2	=	(String)discr_values_default.get("WEIGHT");
		
	}

	
	if(leg_uom_1==null  || leg_uom_1 == ""  || leg_uom_1.equals(" ")) 
		leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.cm.label", "ph_labels");
	if(leg_uom_2==null  || leg_uom_2 == "" || leg_uom_2.equals(" ")) 
		leg_uom_2=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.kg.label", "ph_labels");
		//added for ml-mmoh-scf-0862  end
		//added for ml-mmoh-scf-0915 start
	
		if(leg_value_1!=null  &&  !leg_value_1.equals("")  && !leg_value_1.equals(" ") && Float.parseFloat(leg_value_1)>0 && Float.parseFloat(leg_value_1)<1 ) 
			{
			
				//leg_value_1="0"+leg_value_1 ;
			leg_value_1=""+Float.parseFloat(leg_value_1);
				
		
			}
		if(leg_value_2!=null  &&  !leg_value_2.equals("")  && !leg_value_2.equals(" ") && Float.parseFloat(leg_value_2)>0 && Float.parseFloat(leg_value_2)<1 ) 
		{
		
			//leg_value_2="0"+leg_value_2 ;
			leg_value_2=""+Float.parseFloat(leg_value_2);
	
		}
		//added for ml-mmoh-scf-0915 end
				
	if(( dispPrescripionDuration.equalsIgnoreCase("Y") && (patient_class.equalsIgnoreCase("OP") || take_medication_yn_val.equalsIgnoreCase("Y") )))//Added for BRU-HIMS-CRF-403 [IN:044541] 
		prescripionDurationDisplay = "visibility:visible;";

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(leg_value_1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height_max_digits));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(height_min_digits));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(height_dec_digits));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rec_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(leg_uom_1));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(leg_value_2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weight_max_digits));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(weight_min_digits));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(weight_dec_digits));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rec_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(leg_uom_2));
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(default_dose_type_yn){ // if condition Added for ML-MMOH-CRF-1004 and else for existing -Start 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block29Bytes, _wl_block29);
} else{ 
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block32Bytes, _wl_block32);
} // if condition Added for ML-MMOH-CRF-1004 and else for existing -End 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

					if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

					}
					else{

            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

					}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(prescripionDurationDisplay));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block52Bytes, _wl_block52);

					if(OrderType.size()>0){
						order_type_code_yn=(String) OrderType.get("ORDER_TYPE_CODE_YN");
						if(order_type_code_yn==null) order_type_code_yn="N";
							ArrayList OrderTypeCode=(ArrayList) OrderType.get("OrderTypeCode");
							ArrayList OrderTypeDesc=(ArrayList) OrderType.get("OrderTypeDesc");
							if(order_type_code_yn.equals("Y")){

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

								for(int i=0;i<OrderTypeCode.size();i++){

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf((String) OrderTypeCode.get(i)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((String) OrderTypeDesc.get(i)));
            _bw.write(_wl_block58Bytes, _wl_block58);

								}//for

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(or_order_type_value));
            _bw.write(_wl_block60Bytes, _wl_block60);

								if(!or_order_type_value.equals("")){

            _bw.write(_wl_block61Bytes, _wl_block61);

								}
							}
						}
						else{

            _bw.write(_wl_block62Bytes, _wl_block62);

						}

            _bw.write(_wl_block63Bytes, _wl_block63);

						//added for NMC-JD-CRF-0063 start
						if(take_home_medication_op.equals("Y")){ 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(take_medication_yn_chk));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(take_medication_yn_dis));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(take_medication_yn_val));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{ 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(take_medication_yn_chk));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(take_medication_yn_dis));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(take_medication_yn_val));
            _bw.write(_wl_block68Bytes, _wl_block68);
} //end
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(home_leave_disp));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(home_leave_yn_val));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(leave_fm));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(leave_to));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(leave_fm));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(leave_to));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(allergyvisiblity));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(allergic_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
                     
						if(adr_count >0){
 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

						}

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

						HashMap maternityMap= pregn_bean.getPregnancyRemarks(patient_id);
						String lmpValue = maternityMap.get("LMP").toString();
						String gestationValue = maternityMap.get("GESTATION").toString();
						String eddValue = maternityMap.get("EDD").toString();
						String asOnDateValue = maternityMap.get("ASONDATE").toString();
						if (!((lmpValue.equals(""))&&(gestationValue.equals(""))&&(eddValue.equals("")))){

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(lmpValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(gestationValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(eddValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(asOnDateValue));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

						}
						if(order_type_code_yn.equals("N")){

            _bw.write(_wl_block91Bytes, _wl_block91);

						}

            _bw.write(_wl_block92Bytes, _wl_block92);

					if(version_no.equals("1") ){
						if((allow_without_diag.equals("Y")) ||((allow_without_diag.equals("N")) && (diag_size!=0))){

            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

						}
					}
					else if(version_no.equals("2") ){
						if((allow_without_diag.equals("Y")) ||((allow_without_diag.equals("N")) && (diag_size!=0)) ){

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

							if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){
								if(comp_rx_appl_yn.equals("Y") ){

            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

								}
								if(iv_rx_appl_yn.equals("Y")){

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

								}
							}

            _bw.write(_wl_block101Bytes, _wl_block101);
  
						}
					}
					else if(version_no.equals("3") ){
						if((allow_without_diag.equals("Y")) ||((allow_without_diag.equals("N")) && (diag_size!=0)) ) {

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

							if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){
								if(comp_rx_appl_yn.equals("Y") && MAR.length()==0){

            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

								}
								if(iv_rx_appl_yn.equals("Y") && MAR.length()==0 ){

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

								}  
								if(oncology_rx_appl_yn.equals("Y")){
									if(regimen_yn.equalsIgnoreCase("Y") && MAR.length()==0) { 
										if(indicator_desc.equals("Oncology")){

            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

										}
										else if(indicator_desc.equals("TB")){

            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
										}
										else if(indicator_desc.equals("Psycho")){

            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
	
										}
									}
								}
								if(tpn_rx_appl_yn.equals("Y")&&(patient_class.equals("IP")||patient_class.equals("DC"))){
									if(tpn_yn.equalsIgnoreCase("Y") && MAR.length()==0) {

            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

									}
								}
								if(tdm_appl_yn.equals("Y") && MAR.length()==0){

            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

								}
							}
							if(function_id.equals("PH") && NBPRequestApplYN.equals("A")){ //moved into this if block(version_no =3) for AAKH-SCF-0008 [IN:037381]

            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

							}
						}
					}	
					if(MAR.length()==0  && !function_from.equals("ALTERNATE_ORDER") ){ //function_from.equals("ALTERNATE_ORDER") added for JD-CRF-198       

            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

					}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(leg_uom_1));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(leg_uom_2));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(calculated_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(order_type_code_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(disc_cancel_flag));
            _bw.write(_wl_block130Bytes, _wl_block130);
            _bw.write(_wl_block131Bytes, _wl_block131);
if( take_medication_yn_val == "Y") 
			    {
				new_patient_class="IP";
				 
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(new_patient_class));
            _bw.write(_wl_block133Bytes, _wl_block133);
}
			else{
				 
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block134Bytes, _wl_block134);

			}
			 
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(order_remarks));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(attend_pract_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(licence));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(servide_code));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(service_search_yn));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(problem_ind));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(ph_default_tab));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(take_medication_yn_chk));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(allow_without_wt));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(allow_without_diag));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(diag_for_medn_order_by));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(diag_size));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(bean.getDiagText()==null?"0":(bean.getDiagText()).size()));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(num));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(height_min_value));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(height_max_value));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(weight_min_value));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(weight_max_value));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(height_min_digits));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(height_max_digits));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(weight_min_digits));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(weight_max_digits));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(iv_prep_default));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(bl_disp_charge_dtl_in_rx_yn));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(disp_price_type_in_drug_lkp));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(disp_charge_dtl_in_drug_lkp_yn));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(dc_mar_appl_yn));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(em_mar_appl_yn));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(ip_mar_appl_yn));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(op_mar_appl_yn));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(disch_med_mar_appl_yn));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(split_based_priority_yn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(split_based_drug_class_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(max_durn_for_ip_pres));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(chk_for_ip_max_durn_action));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(max_durn_for_op_pres));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(chk_for_op_max_durn_action));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(max_durn_for_dm_pres));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(chk_for_dm_max_durn_action));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(trade_display_yn));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(narcotic_aprvl_form_req_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(print_narcotic_form_by_default));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(drug_db_product_id));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(drug_db_duptherapy_yn));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(drug_db_interact_check_yn));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(drug_db_contraind_check_yn));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(drug_db_allergy_check_yn));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(adr_count));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(consumable_bean_id));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(consumable_bean_name));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(MAR));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(MItemsOnly));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(man_rem_on_prn_freq_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(max_length_prn_reason));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(rx_qty_by_pres_base_uom_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(atc_allergy_alert_level));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(NBPRequestApplYN));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(drug_interaction_check_yn));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(home_leave_yn_val));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(leave_fm));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(leave_to));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(print_mar_label_yn));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(bean.getPregTrimester()));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(lmp_date));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(pregnency_yn));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(allergy_conf_reqd_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(excludeADRAllergyAlert_yn));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(witness_for_verbal_order_yn));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(login_user_prac_id));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(dispPrescripionDuration));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(called_from_verbal_order));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(default_prev_drug_sel));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(preview_rx_yn));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(allow_priv_to_order_yn));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(bean.getDrugSeachAutocomplete_yn()));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(disp_prev_vital_signs_yn));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(alternateOrder));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(currentStage));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(split_drug_based_auth_yn));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(bean.getAllowAltForMedItem()));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(reconciliation_req_yn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(reconciliation_done_yn));
            _bw.write(_wl_block238Bytes, _wl_block238);
 if(take_home_medication_op.equals("Y")){ 
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(take_home_medication_ip));
            _bw.write(_wl_block240Bytes, _wl_block240);
} 
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(take_home_medication_ckk_val));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(take_home_medication_op));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(drug_indication_mdry));
            _bw.write(_wl_block244Bytes, _wl_block244);

				if(hmPrev_vital_signs!=null && hmPrev_vital_signs.size()>0){

            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);

						Set <String> hshKeys = new HashSet<String>();
						hshKeys = hmPrev_vital_signs.keySet();
						for(String keyRec:hshKeys){
							HeaderHtWtValues = (HashMap)hmPrev_vital_signs.get(keyRec);
							leg_value_1="";
							leg_uom_1="";
							leg_value_2="";
							leg_uom_2="";
							bsa_str="";
							bmi_str="";
							if(HeaderHtWtValues.containsKey("HEIGHT")){
								leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
								leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
							}
							if(HeaderHtWtValues.containsKey("WEIGHT")){
								leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
								leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
							}
							bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
							bsa_str			= (String.valueOf(bsa));
							
							if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)>0 && !leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)>0  ) {
								bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
								index	=	bmi_str.indexOf(".");
								if(bmi_str.length()>=(index+3) ) {
									bmi_str	=(bmi_str.substring(0,index+3));
								}
							}
							if(bsa_str.equals("0.0")) 
								bsa_str= "";
							if(bmi_str.equals("0.0")) 
								bmi_str= "";

            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(keyRec));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(leg_value_1));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(leg_uom_1));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(leg_value_2));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(leg_uom_2));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(bsa_str));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(bmi_str));
            _bw.write(_wl_block252Bytes, _wl_block252);

						}
					}

            _bw.write(_wl_block253Bytes, _wl_block253);

		if(back_date.equals("0") && future_date.equals("0") ){

            _bw.write(_wl_block254Bytes, _wl_block254);

		}
		else{

            _bw.write(_wl_block255Bytes, _wl_block255);

		}
		if(order_type_code_yn!=null && order_type_code_yn.equals("Y")){

            _bw.write(_wl_block256Bytes, _wl_block256);

		}

            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block258Bytes, _wl_block258);
 
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block259Bytes, _wl_block259);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Day(s).label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WEEKS.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MONTHS.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.years.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TakeHomeMedication.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeMedication.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.HomeLeaveMedication.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LeaveFrom.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.KnownCaseofAllergy.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ADR.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PregnancyRemarks.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CompoundingRx.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVRx.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CompoundingRx.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVRx.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Oncology.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TB.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Psycho.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TPNRegimen.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NPBRequest.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalItem.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
}
