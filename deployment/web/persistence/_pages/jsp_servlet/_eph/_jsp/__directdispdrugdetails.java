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
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispdrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispDrugDetails.jsp", 1736503474118L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DirectDispensing.js\"></script>   \n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"javascript\"\t src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"prescription_detail_form\" id=\"prescription_detail_form\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t\t<!-- Below table for CurrentRx details-->\n\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\"5%\"  >\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \'  onClick=\"javascript:callActiveOrders(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<td   style=\"font-family:verdana;font-size:8pt;COLOR:navy;\" onload=\"setfldFocus(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" width=\"5%\" class=\"CURRTEXTSL\" align=\"left\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t                                        <td align=\"left\" style=\"color:navy;\" class=\"CURRTEXTSL\"><input type=\"text\" class=\'CURRTEXTSL\' name=\"barcode_id\" width=\"10%\" style=\"text-align:right;\" onkeydown=\"if (event.keyCode==13) {SearchDrugBasedOnBarcode(document.prescription_detail_form.barcode_id,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');}\" maxlength=\"100\" size=80 ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" autofocus></td>\n\t\t\t                    <!--Modified for IN073611 increased size and maxlength from 50 to 100 -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t<td class=\"CURRTEXTSL\"  width=\"80%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t <!-- added for AAKH-CRF-0117-->\n\t\t\t\t\t\t\t\t<td class= \"CURRTEXTSL\" width=\"5%\" style=\"font-size:9\" nowrap> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" <!-- nowrap added for AAKH-CRF-0117--> <input type =\"text\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\"approval_no\" maxlength=\"20\" align=\"left\" onKeyPress=\"return KeyPressSpecCharsForApprovalNo(event)\" onBlur=\"CheckForSpecCharApprovalno(this,\'H\');\" /><!-- modified AAKH-CRF-0117 -->\n\t\t\t\t\t\t\t\t</td> <!-- AAKH-CRF-0117 -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<td class=\"label\"  width=\"20%\" ><input type=\"button\" name=\"allergies\" id=\"allergies\" class=\"BUTTON\" value =\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onClick=\'callAllergies(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")\'>&nbsp;<!-- Allergies button is added for RUT-CRF-0065.1 [IN:43255] -->\n\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' onClick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'Prescription\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'></td>  <!-- encounter_id added for AAKH-CRF-0088.2 -->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<!--CurrentRx table ends-->\n\t\t\t\t\t\t<!-- Prescription Writer Table starts-->\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t\t\t\t<th colspan=\"6\" style=\"font-size:9\" align=\"left\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t</th> \n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\"12%\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"35%\" colspan=\"3\"><input type=\"text\" name=\"drug_name\" id=\"drug_name\" size=\"42\"  maxlength=\"42\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" ><input type=\"button\" name=\"drug_search\" id=\"drug_search\" value=\"?\" class=\"button\"   onClick=\"searchDrugName(document.prescription_detail_form.drug_name);\" >&nbsp;<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\"   colspan=\"3\"><input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' name=\"dosage_limit\"  id=\"dosage_limit\" style=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onclick=\"showOverRideRemarks(document.prescription_detail_form)\" >&nbsp;<input type=\"checkbox\"  name=\"override_chk\" id=\"override_chk\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="  onClick=\"showOverRideRemarks(document.prescription_detail_form)\"  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  style=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"></td><!-- Added for IN:072715  -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  onClick=\'updateValue(this)\'  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></td>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\"   colspan=\"3\"></td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\"12%\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td> \n\t\t\t\t\t\t\t\t\t\t<!-- <td class=\"data\" id=\"strength\" width=\"18%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td> commented on 8/10/09-->\n\t\t\t\t\t\t\t\t\t\t<td class=\"data\" id=\"strength\" width=\"18%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td> \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"22%\" colspan=\"2\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;&nbsp;<label id=\"form\" style=\"font-weight:bold\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</label></td> \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\"35%\" colspan=\'3\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;&nbsp;<select name=\"route_code\" id=\"route_code\" onChange=\"getFormatId(this);getActionText(this,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\"  > <!-- add getActionText function for SKR-CRF-0006[IN029561]-->\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" \n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="---&nbsp;&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t&nbsp;<label  id=\"actionTextval\"  style=\'color:red;\' > ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" </label><!-- add for SKR-CRF-0006[IN029561]-->\n\t\t\t\t\t\t\t\t\t\t<!-- Added for  ML-BRU-CRF-072[Inc:29938] start-->\n\t\t\t\t\t\t\t\t\t\t<br><a href=\"javascript:drugindication_remarks();\" id=\"drug_ind_remarks\" style=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" title=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a><!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<th colspan=\"6\" style=\"font-size:9\" align=\"left\" >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" </th>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="  </td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\"2\"><select name=\"dosage\" id=\"dosage\" onChange=\"dosageChange(this);ExternalDosageCheck();\" >\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=2 ><input type=\"text\" name=\"qty_value\" id=\"qty_value\" size=\"3\" maxlength=\"7\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" onBlur=\"lookForChange(this);ExternalDosageCheck();\" onKeyPress=\"return allowValidNumber(this,event,6,6);\">\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  ><input type=\"text\" name=\"qty_value\" id=\"qty_value\" size=\"3\" maxlength=\"7\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" onBlur=\"freqChange(frequency,\'Y\');ExternalDosageCheck();\" onKeyPress=\"return allowValidNumber(this,event,6,6);\">\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<select name=\"qty_desc\" id=\"qty_desc\" style=\"width:110;\" onchange=\"lookForChange(document.prescription_detail_form.qty_value)\">\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\t<option VALUE=\"\">---";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="---</option>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  name=\"dosage_label\" id=\"dosage_label\" colspan=\"2\" >&nbsp;";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td> \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan =\"6\"><select name=\"frequency\" id=\"frequency\" onChange=\"freqChange(this,\'Y\');ExternalDosageCheck();removeRefill(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" style=\"width:300px;\"><!-- Modified for IN:069886 -->\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\t\n\t\t\t\t\t\t\t\t\t\t\t<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t\t</select>&nbsp;<input name=\"dis_split_dose\" id=\"dis_split_dose\" type=\"button\" class=\"button\" value= \'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" \'   style=\"visibility:visible\" name=\"split_dose\" onClick=\"DisplaySchedule()\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"3\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"label\"  nowrap><a href=\"javascript:callPRNDetails();\" name=\"prn_remarks\" id=\"prn_remarks\" style=\"visibility:hidden\" title=\"PRN Remarks\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a><img align=\"center\" style=\"visibility:hidden\"  id=\"prn_remarks_image\" src=\"../../eCommon/images/mandatory.gif\"></img></td>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\"   colspan=\"2\"><a href=\"javascript:setRecommendDosage();\" id=\"rec_legend\" style=\"visibility:hidden\" title=\"Recommended Dosage\"onclick=\"changeschedule();\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="  </a>\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"rec_value\" name=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\"></label>\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\"></label></td> \n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\"   colspan=\"2\"><label id=\"rec_legend\" style=\"font-size:11;font-weight:bold;color:red;visibility:hidden\"  >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" </label>\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"rec_value\" name=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red;\"></label>\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\"></label></td>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" ><input type=\"text\" size=\"1\" maxlength=\"3\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"  onBlur=\"validateDuration(this);putDecimal(this,2,0);CheckPositiveNumber(this);ExternalDosageCheck();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onChange=\"removeRefill(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\');\" >&nbsp;<!-- maxlength=\"11\" changed to maxlength=\"3\" for ML-BRU-SCF-0396 [IN034906]  --><select name=\"durn_desc\" id=\"durn_desc\" onChange=\"durationConversn(this,\'form\');removeRefill(\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\');\"><!-- Modified for IN:069886 -->\n\t\t\t\t\t\t\t\t\t\t<option>-";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="-</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_value\" id=\"tmp_durn_value\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_desc\" id=\"tmp_durn_desc\"  value=\"D\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td><label name=\"ord_qty_lbl\" id=\"ord_qty_lbl\" style=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =";color:red;font-weight:bold;\" >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</label></td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"data\"><input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"3\" name=\"absol_qty\" id=\"absol_qty\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" onBlur=\"ValidateAbs(this);CheckPositiveNumber(this);\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" style=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"data\"  ><label name=\"ord_qty_uom\" id=\"ord_qty_uom\" style=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</label></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" ><input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"16\"  maxlength=\"16\" onblur=\"chkBackFutureDate(this);\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" ><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\"   id=Calendar ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" onclick=\"if(document.prescription_detail_form.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_detail_form.start_date.focus();return false;\" ></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  colspan=\"2\" nowrap>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&nbsp;&nbsp;<input type=\"text\" name=\"end_date\" id=\"end_date\" size=\"16\"  maxlength=\"13\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" disabled></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"2\"  style=\"\" ><input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" \' style=\"visibility:visible\" name=\"allow_refill\" onClick=\"loadRefillDetails(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\" ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\' ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" \'  id=\"allocate\" style=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"onclick=\"loadallocatedetail(\'allocate\',\'ONCLICK\');\" ><input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'  id=\"Batch\" style=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" onclick=\"callBatchSearch()\" >\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"6\" class=\"CURRTEXTSL\">\n\t\t\t\t\t\t\t\t\t\t\t<marquee  scrollamount=\"4\" ><font  style=\"font-weight:bold;color:black\" size=1>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</font></marquee>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tExternalDosageCheck(\'ONLOAD\');\t\t\t\t      \n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t<script>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"100%\" id=\"t\"></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"\t\t\tname=\"drug_code\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"\t\t\tname=\"srl_no\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"\t\t\tname=\"form_code\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"\t\tname=\"strength_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" name=\"strength_uom_desc\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"\t\tname=\"pres_base_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"name=\"pres_base_uom_desc\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"\t\tname=\"dosage_type\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"\t\tname=\"tab_qty_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"\tname=\"strength_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\"\t\t\t\t\t\tname=\"freq_value\" id=\"freq_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\"\tname=\"interval_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\"\t\tname=\"repeat_value\">\t\t\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"  name=\"repeat_durn_type\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\"\t\t\t\t\t    name=\"calcualted_durn_value\" id=\"calcualted_durn_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"\tname=\"max_durn_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" name=\"chk_for_max_durn_action\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"\t\tname=\"calling_mode\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" name=\"max_refills_for_pres\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" name=\"max_durn_for_refill_pres\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"\tname=\"order_type_code\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"\t\t\tname=\"back_date\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"\t\tname=\"future_date\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"\t\t\tname=\"rowVal\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"\tname=\"ord_auth_reqd_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" name=\"ord_spl_appr_reqd_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" name=\"ord_cosign_reqd_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"\t\tname=\"split_dose_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" name=\"split_dose_yn_val\">\t\t\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"\t\tname=\"scheduled_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"\t\t\tname=\"authroize_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"\t\tname=\"approval_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"\t\t\tname=\"cosign_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"\tname=\"approval_yn_val\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"\t\tname=\"authroize_yn_val\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"\t\tname=\"cosign_yn_val\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" name=\"admin_time\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\"  name=\"admin_qty\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" name=\"allergy_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"  name=\"limit_ind\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" name=\"current_rx\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" name=\"mono_graph\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" name=\"monograph\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" name=\"generic_id\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"name=\"generic_name\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_durn_desc\" id=\"in_durn_desc\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_durn_value\" id=\"in_durn_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_dispensed_qty\" id=\"in_dispensed_qty\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_dispensed_uom\" id=\"in_dispensed_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_bms_qty\" id=\"in_bms_qty\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_strength_value\" id=\"in_strength_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_strength_uom\" id=\"in_strength_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_pres_qty_value\" id=\"in_pres_qty_value\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_pres_qty_uom\" id=\"in_pres_qty_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_total_strength\" id=\"in_total_strength\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"in_total_strength_uom\" id=\"in_total_strength_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\"\t\t name=\"dflt_qty_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"\t\t name=\"qty_desc_code\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\"   name=\"allergy_override\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"\t\t name=\"dose_override\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" name=\"currentrx_override\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\"\t\t name=\"sch_over_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\"\t\t\t name=\"unit_dose\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"\t\t name=\"daily_dose\">\n\t\t\t\t\t<input type=\"hidden\" value=\"\"\t\t\t\t\t\t name=\"conv_factor\" id=\"conv_factor\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" name=\"strength_per_pres_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" name=\"strength_per_value_pres_uom\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"\t\tname=\"qty_reqd_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" name=\"consider_stock_for_pres_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"\t\tname=\"source\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" name=\"refill_cont_order_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"\tname=\"consent_reqd_yn\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"\tname=\"min_daily_dose\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"\t\tname=\"min_unit_dose\">\t\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"\t\t\tname=\"freq_code\">\n\t\t\t\t\t<!-- Added for IN:070451 start -->\n\t\t\t\t<input type=\"hidden\" name=\"max_daily_ceeling_dose\" id=\"max_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_daily_ceeling_dose\" id=\"min_daily_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"max_unit_ceeling_dose\" id=\"max_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"min_unit_ceeling_dose\" id=\"min_unit_ceeling_dose\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dose_unit_desc\" id=\"dose_unit_desc\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dose_unit_desc1\" id=\"dose_unit_desc1\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t\t<!-- Added for IN:070451 end  -->\n\t\t\t\t<!-- Added for IN:072715 start -->\n\t\t\t\t<input type=\"hidden\"  name=\"allergy_remarks_code\" id=\"allergy_remarks_code\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n       \t\t\t\t<input type=\"hidden\"  name=\"dose_remarks_code\" id=\"dose_remarks_code\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n       \t\t\t\t<input type=\"hidden\"  name=\"currentrx_remarks_code\" id=\"currentrx_remarks_code\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n       \t\t\t\t<input type=\"hidden\" name=\"interaction_remarks_code\" id=\"interaction_remarks_code\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n       \t\t\t\t<input type=\"hidden\" name=\"food_interaction_remarks_code\" id=\"food_interaction_remarks_code\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" >\n       \t\t\t\t<input type=\"hidden\" name=\"lab_interaction_remarks_code\" id=\"lab_interaction_remarks_code\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n       \t\t\t\t<!-- Added for IN:072715 end -->\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" name=\"disease_interaction_remarks\"><!-- MMS-DM-CRF-0229 -->\n                   <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" name=\"disease_interaction_remarks_code\"><!-- MMS-DM-CRF-0229 -->\n\t\t\t<!-- Added for IN:073485 START -->\n       \t\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" name=\"override_select_appl\">\n                         <input type=\"hidden\" value=\'N\' name=\"override_rem_mand\" id=\"override_rem_mand\">\n       \t\t\t<!-- Added for IN:073485 end -->\n\t\t\t\t\t<label id=\"tool_tip\" style=\"visibility:hidden\"></label>\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"init_qty\" id=\"init_qty\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"prn_dose\" id=\"prn_dose\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"no_refill\" id=\"no_refill\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"refill_start_date\" id=\"refill_start_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"refill_end_date\" id=\"refill_end_date\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ph_version\" id=\"ph_version\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stock_uom\" id=\"stock_uom\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"calc_by_ind\" id=\"calc_by_ind\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dosage_std\" id=\"dosage_std\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"recomm_yn\" id=\"recomm_yn\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"allow_duplicate\" id=\"allow_duplicate\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"take_home\" id=\"take_home\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"allow_without_diag\" id=\"allow_without_diag\"\t\tvalue=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"prn_remarks_flag\" id=\"prn_remarks_flag\"\t\tvalue=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"\t\t\t    value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\"\t\t\t    value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_product_id\" id=\"external_product_id\"     value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\"  value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason\" id=\"external_dosage_override_reason\" value=";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason\" id=\"external_duplicate_override_reason\" value=";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason\" id=\"external_interaction_override_reason\" value=";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason\" id=\"external_contra_override_reason\" value=";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason\" id=\"external_Alergy_override_reason\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_dose_check_flag\" id=\"drug_db_dose_check_flag\" value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"recomm_dosage_by\" id=\"recomm_dosage_by\" VALUE=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\"> <!-- Added for ML-MMOH-CRF-0978 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"trade_code\" id=\"trade_code\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" name=\"def_freq_found\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" name=\"DurnDescDetails\">\n\t\t\t\t\t<input type=\"hidden\" value=\"N\" name=\"sliding_scale_yn\" id=\"sliding_scale_yn\">\n\t\t\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938] -->\n\t\t\t\t\t<input type=\'hidden\' name=\'wt_mand_yn\' id=\'wt_mand_yn\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t<input type=\'hidden\' name=\'ht_mand_yn\' id=\'ht_mand_yn\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t<input type=\'hidden\' name=\'weight_rec_appl_age_group_check_flag\' id=\'weight_rec_appl_age_group_check_flag\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"intr_restric_trn\" id=\"intr_restric_trn\" value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\"><!--// added for FD-RUT-CRF-0066.1 [IN036975] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"intr_msg_content\" id=\"intr_msg_content\" value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"><!--// added for FD-RUT-CRF-0066.1 [IN036975] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"interaction_override\" id=\"interaction_override\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\"><!--// added for FD-RUT-CRF-0066.1 [IN036975]-->\n\t\t\t\t\t<input type=\"hidden\" name=\"interaction_exists\" id=\"interaction_exists\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\"><!--// added for FD-RUT-CRF-0066.1 [IN036975] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"recom_value\" id=\"recom_value\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"><!--// addedn for  ML-MMOH-CRF-0978 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"default_recm_dose_yn\" id=\"default_recm_dose_yn\" value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\"><!--// addedn for  ML-MMOH-CRF-0978 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_yn\" id=\"amend_yn\" value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"><!--// addedn for  ML-MMOH-CRF-0978 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"default_freq_not_found\" id=\"default_freq_not_found\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\"><!--// added for GHL-CRF-0508 -->\n\t\t\t\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n\t\t\t\t\n";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t\t\t<script>\n";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t\t\t\t\tdocument.prescription_detail_form.drug_name.focus();\n";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t\t\t\t\tduplicateWarning();\n\t\t\t\t\t\t\tfreqChange(document.prescription_detail_form.frequency,\"N\");\n";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n//added for for GHL-CRF-0508 start \n      ";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t\t\t\t\t\t\talert(getMessage(\"PH_NORMAL_RX_DEFAULT_FREQ_NOT_FOUND\",\'PH\')); \n           ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n//commented for GHL-CRF-0508 end \n\t\t\t\t\t\t\tfreqChange(document.prescription_detail_form.frequency,\"N\");\n";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t\t\t\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\');\n";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\t\n\t\t\t\t\t\t\tpopulateQtyDesc(\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\t\t\t \n\t\t\t\t\t\tpopulateEndDate();\t\t\t\n\t\t\t\t\t\tgetFormatId();  \n\n";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\t\t\t\t\t\t\tdocument.prescription_detail_form.dosage_limit.style.visibility=\"visible\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.dosage_limit.style.display=\"inline\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.override_chk.style.visibility=\"visible\";\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\t\n\t\t\t\t\t\tdocument.prescription_detail_form.start_date.disabled=true;\t\n\t\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t\t// setfocus(document.prescription_detail_form.qty_value);\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\'==\'O\'){\n\t\t\t\t\t\t\tdocument.prescription_detail_form.in_durn_desc.value=\"\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.in_durn_value.value=\"\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.durn_desc.value=\"D\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.durn_value.value=\"1\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.durn_value.disabled=true;\n\t\t\t\t\t\t\tdocument.prescription_detail_form.durn_desc.disabled=true;\n\t\t\t\t\t\t\tdocument.prescription_detail_form.calcualted_durn_value.value=\"1\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n\t\t\t\t\t\t\tdocument.prescription_detail_form.no_refill.value=\"\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.refill_start_date.value=\"\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.refill_end_date.value=\"\";\n\t\t\t\t\t\t}\n";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tstoreSchedule();//no:2\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(document.prescription_detail_form.freq_nature.value==\"P\"){\n\t\t\t\t\t\tvar man_rem_on_prn_freq_yn = parent.parent.parent.f_header.document.dir_disp_header_form.man_rem_on_prn_freq_yn.value;\n\t\t\t\t\t\tdocument.getElementById(\"prn_remarks\").style.visibility\t= \"visible\";\n\t\t\t\t\t\tif(man_rem_on_prn_freq_yn==\'Y\'){\n\t\t\t\t\t\t\tdocument.getElementById(\"prn_remarks_image\").style.visibility\t= \"visible\";\n\t\t\t\t\t\t }\n\t\t\t\t\t\tdocument.getElementById(\"dis_split_dose\").style.visibility\t= \"hidden\";\n\t\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n\n\t\t\t\t\t}\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\n\t\t\t\t\t<script>freqChange(document.prescription_detail_form.frequency,\'N\');</script>\n";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t\t<script>\n\t\t\t\t\t//dosageChange(document.prescription_detail_form.dosage);\n\t\t\t\t\tcheckWtAndHt(prescription_detail_form);\n\t\t\t\t\tlookForChange(document.prescription_detail_form.qty_value,\'N\'); //no:3over\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//document.prescription_detail_form.allocate.click();\n\t\t\t\t\t\tassignDurnTypeList(\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'); \n\t\t\t\t\t\treloadDurnTypeList(\'N\', \'ONLOAD\'); //no:4 over//\'ONLOAD added for AAKH-SCF-0189 [IN:054663]\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t\t\t<script>selectCorrectDurationDesc(\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\',\'N\');</script>\n";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//loadallocatedetail(\'allocate\',\"ONLOAD\");//commented for AAKH-SCF-0189 [IN:054663] - to avoid multiple loading of allocatedetails jsp\n\t\t\t\t\t\tstoreSchedule();//no:5\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tdosageChange(document.prescription_detail_form.dosage, \'ONLOAD\');//code added  for SKR-CRF-PHIS-003[IN028182] //ONLOAD added for AAKH-SCF-0189 [IN:054663] - to avoid multiple loading of allocatedetails jsp\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t\t\t\t\t\t<script>alertIntr(\'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\', \'";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\t\t\t\t\t<script>loadallocatedetail(\'allocate\',\"ONLOAD\");//added for AAKH-SCF-0189 [IN:054663]\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n\t\t\t\t\t<script>alert(getMessage(\"PAT_DIAG_REQD\",\"PH\"));</script>\n";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 =" \n<script>\n\tdocument.prescription_detail_form.barcode_id.focus(); \n\t</script>\n\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
10/08/2020	    IN73611             Shazana												 MMS-DM-CRF-0174.4
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
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
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE"); 
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			//Variable initialization starts-->
			String patient_id				= "";
			String encounter_id				= "";
			String priority					= "";
			String hr_start_time			= "";
			String drug_code				= "";
			String srl_no					= "";
			String bsa						= "";
			String weight                   = ""; // Added for ML-MMOH-CRF-0978
			String	allergic_yn             = "";
			String weight_rec_appl_age_group_check_flag = "";//added for Bru-HIMS-CRF-079 IN[029945]
			String wt_mand_yn="", ht_mand_yn=""; //added for Bru-HIMS-CRF-079 IN[029945]
			String barcodeDisable = ""; // Added for MMS-DM-CRF-0112.1 [IN:065216]
			String barcode_yn =""; // Added for MMS-DM-CRF-0112.1 [IN:065216]
			//Variable initialization ends-->
			//Parameters--Start-->

			try{
				String calling_mode				= request.getParameter("mode") ;
				String dis					    = "";
				String dis1						= "display:none";
				String dir_bean_id				= "DirectDispensingBean" ;
				String dir_bean_name			= "ePH.DirectDispensingBean";
				DirectDispensingBean dir_bean	= (DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request) ;
				String facility_id					= (String) session.getValue("facility_id");
				//dir_bean.setLanguageId(locale);

				String pract_name               = dir_bean.getPractionerName();
			   //code added for external data base checks 

				//String drug_db_interface_yn			=	"N";
			        boolean default_recm_dose_yn=dir_bean.isSiteSpecific("PH", "DEFAULT_RECOM_DOSE_YN"); // Added for ML-MMOH-CRF-0978
					boolean default_freq_not_found =dir_bean.isSiteSpecific("PH","DEFAULT_FREQUENCY_NOT_FOUND");//added for GHL-CRF-0508
				  boolean approval_no_flag = dir_bean.isSiteSpecific("PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117 
				  boolean over_ride_remarks_select_appl=dir_bean.isSiteSpecific("PH","PH_OVERRIDE_REASON_SELECT_APPL");//Added for IN:072715 
				  //Added for IN:073485 start
				  String override_select_appl="N";
					if(over_ride_remarks_select_appl){
						override_select_appl="Y";
					}
					//Added for IN:073485 end
					//Added for IN:069887 start
					boolean validate_overide_on_confirm =dir_bean.isSiteSpecific("PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
					String validate_overide_on_confirm_yn="N";
					if(validate_overide_on_confirm){
						validate_overide_on_confirm_yn="Y";
					}
					//Added for IN:069887 end
				String drug_db_dosecheck_yn			=	"N";
				String drug_db_duptherapy_yn		=	"N";
				String drug_db_interact_check_yn	=	"N";
				String drug_db_contraind_check_yn	=	"N";
				String drug_db_allergy_check_yn		=	"N";
			   //ends here
				if(calling_mode.equals("blank")){
					patient_id				= dir_bean.getPatientID();	
					encounter_id			= dir_bean.getEncounterID();
					if(encounter_id==null){
					   encounter_id="";
					}
					priority				= request.getParameter("priority") ;
					hr_start_time			= request.getParameter("start_date") ;
					allergic_yn				= request.getParameter("allergic_yn") ;
					dis						= "display:none";
					dis1 					= "visibility:hidden";
					if(allergic_yn==null)
						allergic_yn="";		
				}
				else{
					drug_code				= request.getParameter("drug_code") ;
					srl_no					= request.getParameter("srl_no") ;
					//out.println("drug_code="+drug_code+",srl_no="+srl_no);
					patient_id				= request.getParameter("patient_id") ;
					encounter_id			= request.getParameter("encounter_id") ;
					if(encounter_id==null){
					   encounter_id="";
					}
					priority				= request.getParameter("priority") ;
					hr_start_time			= request.getParameter("start_date") ;
					bsa						= request.getParameter("bsa") ;	
					weight = (String)request.getParameter("weight")==null?"1":(String)request.getParameter("weight") ;// Added for ML-MMOH-CRF-0978
					if(weight.equals(""))
						weight = "1"; // Added for ML-MMOH-CRF-0978
					dis1 					= "visibility:hidden";
				  //code added for external data base checks 
				   // drug_db_interface_yn			=	request.getParameter("drug_db_interface_yn") ;       
					drug_db_dosecheck_yn			=	request.getParameter("drug_db_dosecheck_yn") ;       
					drug_db_duptherapy_yn			=	request.getParameter("drug_db_duptherapy_yn") ;	     
					drug_db_interact_check_yn		=	request.getParameter("drug_db_interact_check_yn") ;	 
					drug_db_contraind_check_yn		=	request.getParameter("drug_db_contraind_check_yn") ; 
					drug_db_allergy_check_yn		=	request.getParameter("drug_db_allergy_check_yn") ;  
					//ends here
				}
				String patient_class		= dir_bean.getPatientClass();
				if(patient_class.equals("")||patient_class==null){
					patient_class="XT";
				}
				String dispense_location_code=dir_bean.getDispLocnCode();
				String store_code			= dir_bean.getStoreCode(dispense_location_code);
				String allow_without_diag	= request.getParameter("allow_without_diag");
				if(allow_without_diag==null) 
					allow_without_diag	=	"Y";
				if(bsa==null) 
					bsa	=	"";
				if(priority==null)	 
					priority	=	"";
				//Parameters--End-->
				//Variable Declaration starts-->
				ArrayList presDetails					=	null;
				HashMap drugDetails						=	null;
				String	extdrugCode						=	"";
				String	srlNo							=	"";
				String	allow_duplicate					=	"";
				String	drug_desc						=	"";
				String	generic_id						=	"";
				String	generic_name					=	"";
				String	form_code						=	"";
				String	form_desc						=	"";
				String	route_code						=	"";
				String	pres_base_uom					=	"";
				String	pres_base_uom_desc				=	"";
				String	strength_value					=	"";
				String	strength_uom					=	"";
				String	strength_uom_desc				=	"";
				String	strength_per_pres_uom			=   "";
				String	strength_per_value_pres_uom		= 	"";
				String	ord_auth_reqd_yn				= 	"";
				String	ord_spl_appr_reqd_yn			= 	"";
				String	ord_cosign_reqd_yn				= 	"";
				String	auth_yn_val						= 	"";
				String	approval_yn_val					= 	"";
				String	cosign_yn_val					= 	"";
				String	auth_yn							= 	"";
				String	approval_yn						= 	"";
				String	cosign_yn						= 	"";
				String	consent_reqd_yn					= 	"";
				String	limit_ind						= 	"";
				String	daily_dose						= 	"";
				String	unit_dose						= 	"";
				String	min_daily_dose					= 	"";
				String	min_unit_dose					= 	"";
				String	mono_graph						= 	"";
				String	qty_value						=   "";
				String	tab_qty_value					= 	"";
				String	freq_code						= 	"";
				String	durn_value						= 	"";
				String	durn_desc						= 	"";
				boolean modify_durn_desc				=	false;
				String	consider_stock_for_pres_yn		= 	"";
				String	qty_desc_code					= 	"";
				String	item_code						= 	"";
				String	chk_for_max_durn_action			= 	"";
				String	qty_reqd_yn						= 	"";
				String	max_durn_value					= 	"";
				String	allergy_yn						= 	"";
				String	refill_cont_order_yn			= 	"";
				String	start_date						= 	"";
				String	end_date						= 	"";
				String	dosage_type						= 	"";
				String	scheduled_yn					= 	"";
				String	ori_dosage_type					=   "";
				String	repeat_durn_type				= 	"";
				String	max_refills_for_pres			= 	"";
				String	order_type_code					= 	"";
				String	back_date						= 	"";
				String	future_date						= 	"";
				String	split_dose_yn					= 	"";
				String	rowVal							= 	"";
				String	max_durn_for_refill_pres		= 	"";
				String	no_refill						= 	"";
				String	refill_start_date				= 	"";
				String	refill_end_date					= 	"";
				String	admin_time						= 	"";
				String	admin_qty						= 	"";
				String	repeat_value					=   "";
				String	freq_nature						= 	"";
				String	allergy_override				= 	"";
				String	dose_override					= 	"";
				String	currentrx_override				= 	"";
				String	current_rx						= 	"";
				String	dflt_qty_uom					= 	"";
				String	tappered_over					= 	"";
				String	sch_over_yn						= 	"";
				String	disp_locn_code					= 	"";
				String	amend_yn						= 	"";
				String	stock_uom						= 	"";
				String	absol_qty						= 	"";
				String	prn_dose						= 	"";
				String dosage_option					=	"";
				String dosage_legend					=	"";
				String qty_option						=	"";
				String freq_option						=	"";				
				String duration_option					=	"";
				HashMap chkValuescheduleFrequency		=	null;
				ArrayList frequencyValues				=	null;
				String calendar_status					=	"";
				String route_option						=	"";
				HashMap taperDateParams					=	null;
				String schedule_status					=	"";	
				String absol_qty_status					=	"";
				String refill_status					=	"disabled";
				String qty_legend_style					=	"visibility:hidden";
				String interval_value					=	"";
				String calc_by_ind						=	"";
				String dosage_std						=	"";
				String dosage_unit						=	"";
				String recomm_yn						=	"";
				String orig_current_rx					=	"";
				String prn_remarks						=	"";
				String Disable_recc_dose				=   "";
				String split_dose_yn_val				=   "N";
				String override_chk						=	"N";
				String override_checked					=	"";
				String override_chk_disabled			=	"";
				String external_product_id				=	"";
				ArrayList exProd						=	new ArrayList();
				ArrayList drugDesc						=	new ArrayList();
				String loading_ext_prod_id				=	"";
				String perform_external_database_checks_yn	=	"";	
				String external_dosage_override_reason		=   "";	
				String external_duplicate_override_reason	=   "";
				String external_interaction_override_reason	=   "";
				String external_contra_override_reason		=   ""; 
				String external_alergy_override_reason		=   ""; 
				String fract_dose_round_up_yn				=   "";
				String drug_db_dosage_check_flag			=   "N";
				String trade_code							=	"";
				String physical_inv_item_yn                 =   "";
				boolean def_freq_found						=	false;
				boolean def_freq_not_found                   =   false; //added for GHL-CRF-0508
				Hashtable DurnDescDetails					=   new Hashtable();	
				String actionText							=	""; // add for SKR-CRF-0006[IN029561]
				String default_dosage_by					=	""; //add this for SKR-CRF-PHIS-003[IN028182]
				String recomm_dosage_by                     =""; // Added for ML-MMOH-CRF-0978           
				String 		DrugIndicationRemarks				=   "";// ML-BRU-CRF-072[Inc:29938] 
				String 		default_route_yn				=   "";// Added for  RUT-SCF-0237 [IN:038115]
				String interaction_exists				=	"", intr_restric_trn="N", intr_msg_content="", interaction_override ="", severity_level="" ;  // added for FD-RUT-CRF-0066.1 [IN036975]
				//Added for IN:070451 start
				String      max_daily_ceeling_dose	    =   "";
				String		min_daily_ceeling_dose	    =   "";
				String		max_unit_ceeling_dose	    =   "";
				String		min_unit_ceeling_dose	    =   "";
				String dose_unit_desc = ""; 
				String dose_unit_desc1 = "";
				
				//Added for IN:070451 end	
				//Added for IN:072715 start
				String allergy_remarks_code				= "";
				String dose_remarks_code				= "";
				String currentrx_remarks_code			= "";
				String interaction_remarks_code	    =   "";
				String food_interaction_remarks_code	    =   "";
				String lab_interaction_remarks_code	    =   "";
				String		disease_interaction_remarks	    =   "";//Added for MMS-DM-CRF-0299
	            String		disease_interaction_remarks_code	    =   "";//Added for MMS-DM-CRF-0229
				//Added for IN:072715 end
				//Object Initialization starts-->
				//String or_bean_name				= "eOR.OrderEntryBean";
				//String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
				//OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request);
				//orbean.setLanguageId(locale);

				ArrayList diagnosis				=  dir_bean.checkDiagnosis(patient_id);
				int diag_size					= (diagnosis).size();  
				String mode						=  CommonRepository.getCommonKeyValue( "MODE_INSERT" );
				int take_home					=  0;	//bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
				String ph_version				=	(String)PhLicenceRights.getKey();
				barcode_yn              = dir_bean.getBarCodeflg(facility_id, dir_bean.getDispLocnCode());// Added for MMS-DM-CRF-0112.1 [IN:065216] -Start
				if(calling_mode.equalsIgnoreCase("modify") && barcode_yn.equalsIgnoreCase("Y"))
					barcodeDisable ="disabled";
				String gender ="";
				String date_of_birth ="";
				if(barcode_yn.equalsIgnoreCase("Y")){
				 ArrayList pat_details	=   dir_bean.getPatientDetails1(patient_id);
				 if(pat_details.size()>=3){
					 gender	=	(String)pat_details.get(2);
					 gender	=	gender.substring(0,1).toUpperCase();
					 date_of_birth	=	(String)pat_details.get(3);
				 }	
				} // Added for MMS-DM-CRF-0112.1 [IN:065216] - End
				//Object initialization ends-->
				//Drug Attributes starts-->
				if(!calling_mode.equals("blank")){
					presDetails					= (ArrayList) dir_bean.getpresDetails();
					chkValuescheduleFrequency	= dir_bean.getscheduleFrequency();		
					start_date					= hr_start_time;
				}

				String ex_bean_id   = "@ExternalProductLinkBean";
				String ex_bean_name = "ePH.ExternalProductLinkBean";
				ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
				beanex.setLanguageId(locale);
				String approval_no = "";//AAKH-CRF-0117
				if(presDetails!=null && presDetails.size()>0){
					for(int i=0;i<presDetails.size();i++){
						drugDetails					= (HashMap)presDetails.get(i);
						extdrugCode					= (String)drugDetails.get("DRUG_CODE");
						srlNo						= (String)drugDetails.get("SRL_NO");
						external_product_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
						drug_desc					= (String) drugDetails.get("DRUG_DESC");
						drug_db_dosage_check_flag	= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
						if(external_product_id!=null&& !external_product_id.equals("")) {
						   drugDesc.add(drug_desc);
						   exProd.add(external_product_id);
						}
						approval_no = "";//AAKH-CRF-0117	
						//out.println((HashMap)drugDetails.get("SEL_BATCHES")==null?"":(HashMap)drugDetails.get("SEL_BATCHES"));
						if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){

							perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
							loading_ext_prod_id					= external_product_id;
							allow_duplicate						= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG")==null?"":(String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
							if(patient_class.equals("OP") || patient_class.equals("EM") || patient_class.equals("XT"))
								allow_duplicate						= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP")==null?"":(String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
							external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
							external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
							external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
							external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
			
							physical_inv_item_yn        = (String)drugDetails.get("PHY_INV_ITEM_YN");
					
							generic_id					= (String) drugDetails.get("GENERIC_ID");
							generic_name				= (String) drugDetails.get("GENERIC_NAME");

							form_code					= (String) drugDetails.get("FORM_CODE");
							form_desc					= (String) drugDetails.get("FORM_DESC");
							amend_yn					= (String)drugDetails.get("AMEND_YN");
							default_route_yn			= (String)drugDetails.get("DEFAULT_ROUTE_YN")==null?"":(String)drugDetails.get("DEFAULT_ROUTE_YN"); 
							if(amend_yn.equals("Y")||default_route_yn.equals("Y")) //if condition Added for RUT-SCF-0237 [IN:038115]
								route_code					= (String) drugDetails.get("ROUTE_CODE");
							pres_base_uom				= (String) drugDetails.get("PRES_BASE_UOM");
							pres_base_uom_desc			= (String) drugDetails.get("PRES_BASE_UOM_DESC");
							strength_value				= (String) drugDetails.get("STRENGTH_VALUE");
							strength_uom				= (String) drugDetails.get("STRENGTH_UOM");
							strength_uom_desc			= (String) drugDetails.get("STRENGTH_UOM_DESC");
							strength_per_pres_uom		= (String) drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom	= (String) drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
							ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
							ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
							auth_yn_val					= (String) drugDetails.get("AUTH_YN_VAL");
							approval_yn_val				= (String) drugDetails.get("APPROVAL_YN_VAL");
							cosign_yn_val				= (String) drugDetails.get("COSIGN_YN_VAL");
							auth_yn						= (String) drugDetails.get("AUTH_YN");
							approval_yn					= (String) drugDetails.get("APPROVAL_YN");
							cosign_yn					= (String) drugDetails.get("COSIGN_YN");
							consent_reqd_yn				= (String) drugDetails.get("CONSENT_REQD_YN");
							limit_ind					= (String) drugDetails.get("LIMIT_IND");
							daily_dose					= (String) drugDetails.get("DAILY_DOSE");
							unit_dose					= (String) drugDetails.get("UNIT_DOSE");
							dosage_std					= (String)drugDetails.get("DOSAGE_STD");    // Added for ML-MMOH-CRF-0978
							min_daily_dose				= (String) drugDetails.get("MIN_DAILY_DOSE");
							min_unit_dose				= (String) drugDetails.get("MIN_UNIT_DOSE"); 
							mono_graph					= (String) drugDetails.get("MONO_GRAPH");
							qty_value					= (String) drugDetails.get("QTY_VALUE");
							//Added for IN:070451 start
							max_daily_ceeling_dose		= drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
							min_daily_ceeling_dose		= drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
							max_unit_ceeling_dose		= drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
							min_unit_ceeling_dose		= drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
							String dosage_uom			= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
							if(!dosage_uom.equals("")){ 
						   dose_unit_desc      = dir_bean.getUomDisplay((String)session.getValue("facility_id"),dosage_uom); 
						   dose_unit_desc1 =dose_unit_desc;
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = dir_bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_uom.split("/")[0]));
	 						 dose_unit_desc1 =dose_unit_desc;
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_uom.split("/")[1]);
	 						} 
							}
					
							//Added for IN:070451 end
							//Added for IN:072715 start
					 		allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					 		dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
							currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
							interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
							food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
							lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
							disease_interaction_remarks_code =(String) drugDetails.get("DISEASE_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("DISEASE_INTERACTION_REMARKS_CODE");//Added for MMS-DM-CRF-0229
					        disease_interaction_remarks =(String) drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":(String) drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
							//Added for IN:072715 end
							if(qty_value!=null && !qty_value.equals("") && Float.parseFloat(qty_value) <1)
								qty_value = Float.parseFloat(qty_value) +"" ;
							tab_qty_value				= (String) drugDetails.get("TAB_QTY_VALUE");
							freq_code					= (String) drugDetails.get("FREQ_CODE");
							//durn_value				= (String) drugDetails.get("DURN_VALUE");
							durn_desc					= (String) drugDetails.get("DURN_DESC");					
							durn_value		            =	((String)drugDetails.get("DURN_VALUE")).equals("0")?"1":(String)drugDetails.get("DURN_VALUE");
							
							recomm_yn					= ((String)drugDetails.get("RECOMM_YN"));
							consider_stock_for_pres_yn	= (String) drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
							qty_desc_code				= (String) drugDetails.get("QTY_DESC_CODE");
							item_code					= (String) drugDetails.get("ITEM_CODE");
							chk_for_max_durn_action		= (String) drugDetails.get("CHK_FOR_MAX_DURN_ACTION");
							qty_reqd_yn					= (String) drugDetails.get("QTY_REQD_YN");
							max_durn_value				= (String) drugDetails.get("MAX_DURN_VALUE");
							allergy_yn					= (String) drugDetails.get("ALLERGY_YN");
							refill_cont_order_yn		= (String) drugDetails.get("REFILL_CONT_ORDER_YN");
							start_date					= (String) drugDetails.get("START_DATE");
							//end_date					= (String) drugDetails.get("END_DATE");
							
							end_date		            =	((String)drugDetails.get("END_DATE"))==null?"":(String)drugDetails.get("END_DATE");
						
							dosage_type					= (String) drugDetails.get("DOSAGE_TYPE");
							scheduled_yn				= (String) drugDetails.get("SCHEDULED_YN");
							ori_dosage_type				= (String) drugDetails.get("ORI_DOSAGE_TYPE");
												
							repeat_durn_type			= (String) drugDetails.get("REPEAT_DURN_TYPE");
							max_refills_for_pres		= (String) drugDetails.get("MAX_REFILLS_FOR_PRES");
							order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
							back_date					= (String) drugDetails.get("BACK_DATE");
							future_date					= (String) drugDetails.get("FUTURE_DATE");
							split_dose_yn				= (String) drugDetails.get("SPLIT_DOSE_YN");
							split_dose_yn_val			= CommonBean.checkForNull(((String) drugDetails.get("SPLIT_DOSE_YN_VAL")),"N");
							rowVal						= (String) drugDetails.get("rowVal");
							max_durn_for_refill_pres	= (String) drugDetails.get("MAX_DURN_FOR_REFILL_PRES");
							no_refill					= (String) drugDetails.get("NO_REFILL");
							refill_start_date			= (String) drugDetails.get("REFILL_START_DATE");
							refill_end_date				= (String) drugDetails.get("REFILL_END_DATE");
							admin_time					= (String) drugDetails.get("ADMIN_TIME");
							admin_qty					= (String) drugDetails.get("ADMIN_QTY");
							repeat_value				= (String) drugDetails.get("REPEAT_VALUE");
							freq_nature		            =		((String)drugDetails.get("FREQ_NATURE"))==null?"":(String)drugDetails.get("FREQ_NATURE");
			
							allergy_override			= (String) drugDetails.get("ALLERGY_OVERRIDE");
							dose_override				= (String) drugDetails.get("DOSE_OVERRIDE");
							currentrx_override			= (String) drugDetails.get("CURRENTRX_OVERRIDE");
							current_rx					= (String) drugDetails.get("CURRENT_RX");
							fract_dose_round_up_yn      = (String) drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
							
							if(current_rx.equals("Y") && !drugDetails.containsKey("ORIG_CURRENT_RX")) {
								drugDetails.put("ORIG_CURRENT_RX","Y");							
							}
							if( drugDetails.containsKey("ORIG_CURRENT_RX") && ((String)drugDetails.get("ORIG_CURRENT_RX")).equals("Y") ) {
								orig_current_rx	=	(String)drugDetails.get("ORIG_CURRENT_RX");
							}

							dflt_qty_uom				= (String) drugDetails.get("DFLT_QTY_UOM");
							tappered_over				= (String)drugDetails.get("TAPPERED_OVER");
							sch_over_yn					= (String)drugDetails.get("SCH_OVER_YN");
							disp_locn_code				= (String)drugDetails.get("DISP_LOCN_CODE");
							stock_uom					= (String)drugDetails.get("STOCK_UOM_DESC");
							absol_qty					= (String)drugDetails.get("ABSOL_QTY"); 
							prn_dose					= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
							//priority					= (String)drugDetails.get("PRIORITY");	
							interval_value				= (String)drugDetails.get("INTERVAL_VALUE");
							calc_by_ind					= (String)drugDetails.get("CALC_BY_IND");
							dosage_std					= (String)drugDetails.get("DOSAGE_STD");
							dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
							trade_code				    = (String)drugDetails.get("TRADE_CODE");
							//added for AAKH-CRF-0117 - start
							approval_no					= (String)drugDetails.get("approval_no");
							if(approval_no==null)
								approval_no = "";
							//added for AAKH-CRF-0117 - end
							default_dosage_by			= (String)drugDetails.get("DEFAULT_DOSAGE_BY")==null?"":(String)drugDetails.get("DEFAULT_DOSAGE_BY");//add this for SKR-CRF-PHIS-003[IN028182]
							recomm_dosage_by			= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY"); // Added for ML-MMOH-CRF-0978 -Start
							if(recomm_dosage_by.equals("B"))
								recomm_dosage_by = "Q";   // Added for ML-MMOH-CRF-0978 -End
							DrugIndicationRemarks				= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Newly Added   For ML-BRU-CRF-072[Inc:29938]
							weight_rec_appl_age_group_check_flag =  drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG")== null?"":(String) drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG"); //added for Bru-HIMS-CRF-079 IN[029945]
							wt_mand_yn =  drugDetails.get("WT_MAND_YN")== null?"":(String) drugDetails.get("WT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
							ht_mand_yn =  drugDetails.get("HT_MAND_YN")== null?"":(String) drugDetails.get("HT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
							if(!DrugIndicationRemarks.equals(""))
								DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); ;
							interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");// added for FD-RUT-CRF-0066.1 [IN036975] -Start
							intr_restric_trn			= (String) drugDetails.get("INTR_RESTRIC_TRN")==null?"N": (String) drugDetails.get("INTR_RESTRIC_TRN");
							severity_level				= (String) drugDetails.get("SEVERITY_LEVEL")==null?"": (String) drugDetails.get("SEVERITY_LEVEL");
							intr_msg_content			= (String) drugDetails.get("INTR_MSG_CONTENT")==null?"": (String) drugDetails.get("INTR_MSG_CONTENT"); // added for FD-RUT-CRF-0066.1 [IN036975] -end

							if(amend_yn.equals("Y")){
								if(drugDetails.containsKey("override_chk")){

									 override_chk		= (String) drugDetails.get("override_chk");
									 if(override_chk.equals("Y")){
										override_checked		="checked";
										override_chk_disabled	="disabled";
									 }
								}
							}
							if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
								prn_dose	=	"1";
							}						
							if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
								strength_value = Float.parseFloat(strength_value) +"" ;
				
							if(strength_value.equals("0"))
								strength_value			=	"";

							if(limit_ind==null)
									limit_ind	=	"Y";
					
							if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
								frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
							}	
							//out.println("==chkValuescheduleFrequency=="+chkValuescheduleFrequency);						
							if(freq_nature.equals("P") && absol_qty==null) {
								absol_qty		=	prn_dose;	
							}
							if(absol_qty==null || absol_qty.equals("0"))
								absol_qty		=	"1";

							if(calling_mode.equals("taper")){
								taperDateParams	=(HashMap)dir_bean.populateTaperDates(end_date,durn_value,repeat_durn_type);
								if(taperDateParams.size()>0){
									start_date	=(String) taperDateParams.get("taper_start_date");
									end_date	=(String) taperDateParams.get("taper_end_date");
								}
							}
							break;
						}
					}
					HashMap drug_Interactions				= null;
					String drug_db_interact_check_flag	= "N";
					String drug_db_duptherapy_flag		= "N";
					String drug_db_contraind_check_flag	= "N";
					String dup_drug_det					= "";
					String drug_alergy_det                = "";
					String drug_db_alergy_check_flag	    = "N";
					//Added for FBD Tuning - Start
					if(perform_external_database_checks_yn.equals("Y") && exProd.size()>0){
						if(drug_db_duptherapy_yn.equals("Y")||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
							HashMap tempDetails= null;
							HashMap drugDBCheckResult= null;
							ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
							drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, loading_ext_prod_id, patient_id, "", exProd ,drugDesc, null, "Y", start_date, end_date); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(loading_ext_prod_id,srl_no,drugDBCheckResult);

							if(drug_db_allergy_check_yn.equals("Y")){
							   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
								   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
								   if(allergy_alert!=null && !allergy_alert.equals(""))
										drug_db_alergy_check_flag="Y";
							   } 
							   else {  
									tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
									if(tempDetails!=null && tempDetails.size()>0){
										 drug_db_alergy_check_flag="Y";
									}
								} 
							}

							if(drug_db_interact_check_yn.equals("Y")){
								tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
								if(tempDetails!=null && tempDetails.size()>0){
									 drug_db_interact_check_flag="Y";
								}
								else									
									 drug_db_interact_check_flag="N";
							}

							if(drug_db_duptherapy_yn.equals("Y")){ 
							   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
							   if(dup_drug_det!=null && !dup_drug_det.equals(""))
									drug_db_duptherapy_flag="Y";
							   else{
									drug_db_duptherapy_flag="N";
							   }
							}
							if(drug_db_contraind_check_yn.equals("Y")){
								if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // addign start for IN066787- Performance
							             tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

						         if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
							          drug_db_contraind_check_flag="Y";
						        }
							}else{//Adding end for IN066787- Performance
								tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								if(tempDetails!=null && tempDetails.containsKey(loading_ext_prod_id)){
									drug_db_contraind_check_flag="Y";
								}		
								else
									drug_db_contraind_check_flag="N";
							}
						}
					}
						//Commented for FBD Tuning - End
						/* //Commented for FBD Tuning - Start
						//setting druug codes in external product link bean
						if(exProd.size()>0)
							beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
						}	
						//code for drug interaction check
						if(perform_external_database_checks_yn.equals("Y")){
							if(drug_db_interact_check_yn.equals("Y")){
								  if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
									   beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
											drug_Interactions		= beanex.getInteractions();//get Interactions
											if(drug_Interactions.size()>0){							
											   drug_db_interact_check_flag="Y";
											}
								  }
							}
							if(drug_db_duptherapy_yn.equals("Y")){ 
								dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result
								if(!dup_drug_det.equals("")&&dup_drug_det!=null)
									drug_db_duptherapy_flag="Y";
							}

							if(drug_db_contraind_check_yn.equals("Y")){
								ArrayList ex_prod_ids =new ArrayList();
								ex_prod_ids.add(loading_ext_prod_id);

								  boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
								  HashMap contra_indications =(HashMap)beanex.getContraIndications();
								  if(contra_indications.containsKey(external_product_id)){
									 drug_db_contraind_check_flag="Y";
								  }					  
							} 
							
							if(drug_db_allergy_check_yn.equals("Y")){
							   ArrayList ex_prod_ids =new ArrayList();
							   ex_prod_ids.add(loading_ext_prod_id);
							   beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result


								HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
								  if(drug_alergies.containsKey(external_product_id)){
									 drug_db_alergy_check_flag="Y";
								  }	
							*/ //Commented for FBD Tuning - End
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN",drug_db_alergy_check_flag);
					}
					//delete frequency on reset/without confirm
					if(frequencyValues!=null && frequencyValues.size()>0 && scheduled_yn.equals("N")) {
						dir_bean.getclearscheduleFrequency(drug_code+srl_no);
						frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
						//frequencyValues			=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
					}

					// enable/disable calendar gif
					if(start_date==null || start_date.equals(""))
						calendar_status	=	"disabled";	
						/*ArrayList	active_orders		=	dir_bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
						StringBuffer drug_description	=	new StringBuffer();
						int size						=	active_orders.size();
						HashMap	record					=	new HashMap();

							for(int i=0; i<size; i++)	{
								record					=	(HashMap)active_orders.get(i);
								drug_description.append((String)record.get("drug_desc"));
								drug_description.append(" , ");
							}*/	
						// load applicable routes
						//Code Added CRF - 0034 Start
						if(!calling_mode.equals("blank")) {	
							if(route_code==null || route_code.equals ("") ) //added for RUT-SCF-0237 [IN:038115]
								route_option= route_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
							else
								actionText = dir_bean.getActionText(form_code,route_code); //add for SKR-CRF-0006[IN029561]
							ArrayList routes				=	dir_bean.getRoutes(form_code); 
							for(int l=0; l<routes.size(); l+=3) { 
								String backgrndColor="FFFFFF";
								String fntColor="000000";
								String route_color = (String)routes.get(l+2);
								if(route_color!= null && route_color!= ""){
									if(route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
								}
								//Code Added CRF -0034 End
								if( ((String)routes.get(l)).equals(route_code)) {  
									route_option	+="<option style='color:"+fntColor+";background-color:"+backgrndColor+";' value='"+(String)routes.get(l)+"' selected>"+(String)routes.get(l+1)+"</option>";  //style Added CRF -0034
								} 
								else {	
									route_option	+="<option value='"+(String)routes.get(l)+"' style='color:"+fntColor+";background-color:"+backgrndColor+";'>"+(String)routes.get(l+1)+"</option>"; //style Added CRF -0034
								}	
							}
						}
							
					
						// Legend and dosage unit is controlled based on dosage type
						if(dosage_type.equals("A")){ 
							dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");
							dosage_option	=	"<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absolute.label","common_labels")+"</option>";
						}
						else if(dosage_type.equals("S")){ 
							dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Strength.label","common_labels");
							dosage_option	= "<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
						}
						else if(dosage_type.equals("Q")){  
							dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Dose.label","ph_labels");
							if(ori_dosage_type.equals("S")){
								dosage_option	=	"<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Strength.label","common_labels")+"</option><option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels")+"</option>";
							}
							else{
								dosage_option	=	"<option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels")+"</option>";
							}		
						}

						// Get the unit dose for scheduled
						if(!calling_mode.equals("blank") && split_dose_yn.equals("N")) {
							ArrayList schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
							if(schedule.size() > 0) {
								 /*HashMap detail	=	(HashMap)schedule.get(0);
								 qty_value		=	(String)detail.get("admin_qty");*/
								 ArrayList dose_list		= (ArrayList)schedule.get(4);
								 if(dose_list.size()>0) {
									qty_value		= (String)dose_list.get(0);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
								 }
								 else {
									 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										 qty_value="1";
								 }
							}
						}
						//out.println("Qty Value="+qty_value);
						// Default Strength uom
						if(dosage_type.equals("S")){
							qty_option	=	"<option value='"+strength_uom+"' selected>"+strength_uom_desc+"</option>";
						}
						boolean dup_found	=	false;
						// Load Frequency
						
						if(!calling_mode.equals("blank")) {	
							HashMap freqValues	=	(HashMap)dir_bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
							if(orig_current_rx.equals("Y") && allow_duplicate.equals("N")) { // && (patient_class.equals("IP") || take_home>0)
								dup_found	=	true;
							}
							ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
							ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
							ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
							if(freqValues.size()>0 && (dup_found) && amend_yn.equals("Y")){ 
								if(allow_duplicate.equals("N")){
									ArrayList stat_freqs	=	dir_bean.loadStatFreqs();			
									for(int i=0;i<stat_freqs.size();i+=2){
										if(freq_code.equals((String) stat_freqs.get(i))){
											freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
											freq_code	    = ((String) stat_freqs.get(i));
										}
										else{
											freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"' >"+((String) stat_freqs.get(i+1))+"</option>";
										}
										freq_nature	    = "O";
										//def_freq_found = true;
									}
								}
								else{
									for(int i=0;i<freqCode.size();i++){
										if( dup_found  && !amend_yn.equals("Y")) {
											if( ((String) FreqNature.get(i)).equals("O")) {//dir_bean.getFreqNature(((String) freqCode.get(i))))
												freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
												freq_nature	    = "O";
												freq_code	    = ((String) freqCode.get(i));
												def_freq_found  = true;
											}
										}
										else {
											if(((String) freqCode.get(i)).equals(freq_code)) {
												freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
												def_freq_found  = true;
											} 
											else {
												freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
											}
										}
									}
								} 
							}
							else if(freqValues.size()>0 ){ 
								def_freq_not_found = true;//Added for GHL-CRF-0508
								for(int i=0;i<freqCode.size();i++){
									if( dup_found && !amend_yn.equals("Y")) {
										if( ((String) FreqNature.get(i)).equals("O")) {//(dir_bean.getFreqNature(((String) freqCode.get(i))))
											freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
											freq_nature	=	"O";
											freq_code	=((String) freqCode.get(i));
											def_freq_found = true;
										}
									} 
									else {
										if(((String) freqCode.get(i)).equals(freq_code)) {
											freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
											def_freq_found = true;
											def_freq_not_found= false;
										} 
										else {
											//Added for GHL-CRF-0508 start
											if(default_freq_not_found){
				 							if(def_freq_not_found){ 
				 							    freq_option  += "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
				 							   def_freq_not_found = false;
				 							}	
										}
											//Added for GHL-CRF-0508 end	
										freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
										}
									}
								}
							}
							else if(dup_found) {
								ArrayList stat_freqs	=	dir_bean.loadStatFreqs();					
								for(int i=0;i<stat_freqs.size();i+=2){
									freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
									freq_nature	=	"O";
									freq_code	=((String) stat_freqs.get(i));
								}
							} 
							
							if(freq_option.equals("")) {
								ArrayList stat_freqs	=	dir_bean.loadStatFreqs();					
						
								for(int i=0;i<stat_freqs.size();i+=2){
									freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
									freq_nature	=	"O";
									freq_code	=((String) stat_freqs.get(i));
								}
							}
						}
						
						// Duration values
						modify_durn_desc=false;
						if(!calling_mode.equals("blank")) {	
							durn_desc=durn_desc.substring(0,1);
							DurnDescDetails	= (Hashtable)dir_bean.loadDurnDesc();
							Enumeration keys_des		= DurnDescDetails.keys();
							String	durn_code			= "";
							if(durn_desc.equals(repeat_durn_type)){	
								while(keys_des.hasMoreElements()){
									durn_code		= (String)keys_des.nextElement();
									duration_option	+= "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
								}
							}
							else{		
								modify_durn_desc=true;			
							}
						}

						if(dosage_type.equals("A")) {
							//schedule_status		=	"disabled";
							absol_qty_status	=	"enabled";
						} 
						else {
							if(!freq_nature.equals("P"))
								absol_qty			=	"";
						}

						if(scheduled_yn.equals("N")) {
							schedule_status		=	"disabled";
						}

						// enable/disable refill button
						if(refill_cont_order_yn!=null && refill_cont_order_yn.equals("Y")){
							refill_status="";
						}

						// enable/disable order quantity legend
						if(dosage_type.equals("A") || freq_nature.equals("P")) {
							qty_legend_style	=	"visibility:visible";
						}
						if(split_dose_yn.equals("N") && (!dosage_type.equals(recomm_dosage_by)) && default_recm_dose_yn){  // Added for ML-MMOH-CRF-0978 - Start
							 Disable_recc_dose="disabled";
						} // Added for ML-MMOH-CRF-0978 - End
						else if(split_dose_yn.equals("Y")){
							Disable_recc_dose="disabled";
						}
						if(priority.equalsIgnoreCase("R"))
							priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
						else if(priority.equalsIgnoreCase("U"))
							priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
						//Drug Attributes ends-->

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dir_bean_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dir_bean_name ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(barcode_yn.equalsIgnoreCase("Y")){// if else condition Added for MMS-DM-CRF-0112.1 [IN:065216]  - Start 
									if(!((allow_without_diag.equals("Y")) ||(allow_without_diag.equals("N") && diag_size!=0) || patient_class.equals("XT"))){
										barcodeDisable ="disabled";
									}
								
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(barcode_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(barcodeDisable));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
} // if else condition Added for MMS-DM-CRF-0112.1 [IN:065216]  - End 
								if(approval_no_flag){ //AAKH-CRF-0117
								
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(approval_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

						if((allow_without_diag.equals("Y")) ||(allow_without_diag.equals("N") && diag_size!=0) || patient_class.equals("XT")){
							String recom_value = "";  // Added for ML-MMOH-CRF-0978 - Start
							if(calc_by_ind.equals("A")) {	
								recom_value	= dosage_std;
							} 
							else if(calc_by_ind.equals("W")) {
								 recom_value	=	String.valueOf(Integer.parseInt(weight)*Integer.parseInt(dosage_std));
							}
							else if(calc_by_ind.equals("B")) {
								 recom_value	=	String.valueOf(Integer.parseInt(bsa)*Integer.parseInt(dosage_std));
							} 
							
						  if(dosage_unit.length()>=1){ 
							  dosage_unit                 = dir_bean.getUOMDesc(dosage_unit.split("/")[0])==null?"":dir_bean.getUOMDesc(dosage_unit.split("/")[0]);
						  }  
						  // Added for ML-MMOH-CRF-0978 - End
							if(allergic_yn.equals("N")||allergic_yn.equals("")){

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);

										if(!calling_mode.equals("blank")) {	
											
										if(over_ride_remarks_select_appl){

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(override_chk));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(override_checked));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(override_chk_disabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block43Bytes, _wl_block43);
} else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(override_chk));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(override_checked));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(override_chk_disabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block45Bytes, _wl_block45);

										}}
										else{

            _bw.write(_wl_block46Bytes, _wl_block46);

										}

            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dir_bean.getUomDisplay(facility_id,strength_uom)));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
 
										if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

										} 

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(route_option));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(actionText));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

										if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

										}	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dosage_option));
            _bw.write(_wl_block67Bytes, _wl_block67);

										if(split_dose_yn.equals("Y")){

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block69Bytes, _wl_block69);

										}
										else{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block71Bytes, _wl_block71);

										}

            _bw.write(_wl_block72Bytes, _wl_block72);
 		
										if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
	
										}	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty_option));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(dosage_legend));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dir_bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dir_bean_name));
            _bw.write(_wl_block78Bytes, _wl_block78);
 
										if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
	
										}	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(freq_option));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(schedule_status));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

										if(split_dose_yn.equals("N")){

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Disable_recc_dose));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

										}
										else{

            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

										}

            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dir_bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dir_bean_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dir_bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dir_bean_name));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(duration_option));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(absol_qty_status));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(calendar_status));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(max_refills_for_pres));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(refill_status));
            _bw.write(_wl_block112Bytes, _wl_block112);

										if(physical_inv_item_yn.equals("N")){

            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block117Bytes, _wl_block117);

										}

            _bw.write(_wl_block118Bytes, _wl_block118);
		
									if(current_rx.equals("Y") && allow_duplicate.equals("N") ) { //&& (patient_class.equals("IP")||  take_home>0)
										ArrayList curr_info		=	dir_bean.getDuplicateDrugs(patient_id,generic_id);
										HashMap  dup_info		=	null;
										String dup_drug_info	=	"";
										if(curr_info.size()>=1) {
											dup_info	  =	(HashMap)curr_info.get(0);
											dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+";\n";
											dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
										}
										else{
											dup_drug_info = "Patient is Currently On "+generic_name+" Medication";
										}

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(dup_drug_info));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
	
								}

            _bw.write(_wl_block122Bytes, _wl_block122);

							}
						//Prescription Writer Table ends-->
						//Added for SKR-SCF-0647[Inc 35263]-Start
						HashMap remarks_prn					= (HashMap)dir_bean.getPRNRemarks(drug_code);
						String  remarks_text                = "";
						String  remarks_code				= "";
						if(remarks_prn!=null){
							if(remarks_prn.containsKey("remarks_dtl"))
								remarks_text				    = (String)remarks_prn.get("remarks_dtl")==null?"":(String)remarks_prn.get("remarks_dtl");
							if(remarks_prn.containsKey("remarks_code"))
								remarks_code					    = (String)remarks_prn.get("remarks_code")==null?"":(String)remarks_prn.get("remarks_code");
						}//Added for SKR-SCF-0647[Inc 35263]-End
						//Below || && !remarks_text.equals("") Added for SKR-SCF-0647[Inc 35263] 
						if(!prn_remarks.equals("") || !remarks_text.equals(""))
							prn_remarks	=	"true";
						else
							prn_remarks	=	"false";

					if(!calling_mode.equals("blank")&& perform_external_database_checks_yn.equals("Y")){		  
						if(drug_db_dosecheck_yn.equals("Y")){

            _bw.write(_wl_block123Bytes, _wl_block123);

						}

            _bw.write(_wl_block124Bytes, _wl_block124);

							//out.println("viewMedicationAlert('"+patient_id+"','"+loading_ext_prod_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dosage_check_flag+"','ONLOAD','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','"+external_duplicate_override_reason+"','"+external_interaction_override_reason+"','"+external_contra_override_reason+"','"+java.net.URLEncoder.encode(pract_name)+"','"+external_alergy_override_reason+"','"+drug_db_dosecheck_yn+"')");

            _bw.write(_wl_block125Bytes, _wl_block125);

					}

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(pres_base_uom_desc));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tab_qty_value));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(repeat_value));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(max_refills_for_pres));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(max_durn_for_refill_pres));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(rowVal));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(ord_auth_reqd_yn));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(ord_spl_appr_reqd_yn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(ord_cosign_reqd_yn));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(split_dose_yn_val));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(auth_yn));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(approval_yn));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(cosign_yn));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(approval_yn_val));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(auth_yn_val));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(cosign_yn_val));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(admin_time));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(admin_qty));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(dflt_qty_uom));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(allergy_override));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dose_override));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(currentrx_override));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(sch_over_yn));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(qty_reqd_yn));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(consider_stock_for_pres_yn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(refill_cont_order_yn));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(consent_reqd_yn));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(allergy_remarks_code));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(dose_remarks_code));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(currentrx_remarks_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(interaction_remarks_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(food_interaction_remarks_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(lab_interaction_remarks_code));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(disease_interaction_remarks));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(disease_interaction_remarks_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(override_select_appl));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(prn_dose));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(no_refill));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(refill_start_date));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(refill_end_date));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ph_version));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(allow_duplicate));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(take_home));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(allow_without_diag));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(prn_remarks));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason)));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(external_contra_override_reason));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf( recomm_dosage_by ));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(def_freq_found));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(wt_mand_yn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(ht_mand_yn));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(weight_rec_appl_age_group_check_flag));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(intr_restric_trn));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(interaction_override));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recom_value));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(default_recm_dose_yn));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(default_freq_not_found));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block248Bytes, _wl_block248);

					//  duplicate check based on atc -- starts
					if(current_rx.equals("Y")) {
						String atc_level_1	=	"";
						String atc_level_2	=	"";
						String atc_level_3	=	"";
						String provide_taper =	"";
						ArrayList atc_values =  new ArrayList();
						HashMap drug_detail	 =	null;
						if(presDetails!=null && presDetails.size()>0){
							
							for(int i=0;i<presDetails.size();i++){			
								drug_detail=(HashMap) presDetails.get(i);
								atc_level_1	=	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
								atc_level_2	=	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
								atc_level_3	=	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
								drug_desc	=	(String)drug_detail.get("DRUG_DESC");

							if(drug_detail.get("PROVIDE_TAPER")!=null)
								 provide_taper	= (String)drug_detail.get("PROVIDE_TAPER");

							if( (!provide_taper.equals("Y")) && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") )  ) {
								if(atc_values.contains(atc_level_1)) {
									out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_1)-1)+" at ATC Classification Level 1'); </script>");
								} 
								else  if(atc_values.contains(atc_level_2)) {
									out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_2)-2)+" at ATC Classification Level 2'); </script>");
								}
								else if(atc_values.contains(atc_level_3)) {
									out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_3)-3)+" at ATC Classification Level 3') </script>");
								} 
								else {
									atc_values.add(drug_desc);
									if(!(atc_level_1==null || atc_level_1.equals("")))
										atc_values.add(atc_level_1);
									if(!(atc_level_2==null || atc_level_2.equals("")))
										atc_values.add(atc_level_2);
									if(!(atc_level_3==null || atc_level_3.equals("")))
										atc_values.add(atc_level_3);
								}
							}
						}
					}
				}
				//  duplicate check based on atc -- ends

            _bw.write(_wl_block249Bytes, _wl_block249);
 
					if(calling_mode.equals("blank")){ 

            _bw.write(_wl_block250Bytes, _wl_block250);
	
					}
					else {
					//if no default frequency(order catalog) matches with the applicable frequency list with respect to patient class
						if(!amend_yn.equals("Y") && orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	//&& (patient_class.equals("IP") || take_home>0)

            _bw.write(_wl_block251Bytes, _wl_block251);

						}
						else if(!def_freq_found && !amend_yn.equals("Y")){

            _bw.write(_wl_block252Bytes, _wl_block252);
 if(!default_freq_not_found){
            _bw.write(_wl_block253Bytes, _wl_block253);
 } 
            _bw.write(_wl_block254Bytes, _wl_block254);

						}

            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block256Bytes, _wl_block256);

						if(!dosage_type.equals("S")) {	

            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block256Bytes, _wl_block256);
			
						}

            _bw.write(_wl_block258Bytes, _wl_block258);
						// To Display reason button 
						if((allergy_yn.equals("Y") || limit_ind.equals("N") || current_rx.equals("Y") || interaction_exists.equals("Y")) && !perform_external_database_checks_yn.equals("Y")){ // interaction_exists check  added for FD-RUT-CRF-0066.1 [IN036975]  && !perform_external_database_checks_yn.equals("Y") Added for 69759

            _bw.write(_wl_block259Bytes, _wl_block259);

						}
						// If tappered Disable Refill Button 
						if(tappered_over!=null && tappered_over.equals("Y")){

            _bw.write(_wl_block260Bytes, _wl_block260);

						}
					}	
					if( calling_mode.equals("taper")){

            _bw.write(_wl_block261Bytes, _wl_block261);

					}	
					if(calling_mode.equals("modify") || calling_mode.equals("taper")) {	

            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block263Bytes, _wl_block263);
		
						//HashMap data		=	null;
						String att			=	null;
						String adm_time		=	"";
						String adm_qty		=	"";
						String total_qty	=   "";
						ArrayList dose_list	=	null;
						if(frequencyValues!=null && frequencyValues.size()>0){
							
							/*adm_time+="<tr>";					
							for(int i=0;i<frequencyValues.size();i++){
								data=(HashMap)frequencyValues.get(i);
								att="align=center class=TIP";
								adm_time+="<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
							}
							adm_time+="</tr>";

							adm_qty+="<tr>";
							for(int i=0;i<frequencyValues.size();i++){
								att="align=center class=TIP";
								data=(HashMap)frequencyValues.get(i);
								adm_qty+="<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
								total_qty=(String) data.get("admin_qty");
							}
							adm_qty+="</tr>";*/
							dose_list	= (ArrayList)frequencyValues.get(4);
							for(int tqI=0;tqI<dose_list.size();tqI++){						
								total_qty	=	(String)dose_list.get(tqI);
								if(total_qty.equals("")||total_qty.equals("0")||total_qty==null)
									total_qty="1";
							}

							boolean split_chk	=	dir_bean.checkSplit(frequencyValues);	
							String tooltiptable = (String)dir_bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
							adm_time = tooltiptable;	
							//out.println("alert('one')");	out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"')");  //no:1;
						}	
					}	

            _bw.write(_wl_block264Bytes, _wl_block264);

				if(!calling_mode.equals("blank")){

            _bw.write(_wl_block265Bytes, _wl_block265);

				}

            _bw.write(_wl_block266Bytes, _wl_block266);

				if(orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	//&& (patient_class.equals("IP") || take_home>0)

            _bw.write(_wl_block267Bytes, _wl_block267);
		
				}  

            _bw.write(_wl_block268Bytes, _wl_block268);

				if(!calling_mode.equals("blank")){

            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block270Bytes, _wl_block270);
 
					if(modify_durn_desc){ 

            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(durn_desc));
            _bw.write(_wl_block272Bytes, _wl_block272);

					}

            _bw.write(_wl_block273Bytes, _wl_block273);

					if(!ori_dosage_type.equals(default_dosage_by) && !amend_yn.equals("Y") &&  !calling_mode.equals("taper") && !calling_mode.equals("tapered")){

            _bw.write(_wl_block274Bytes, _wl_block274);

						}
					}
					if((amend_yn==null || !amend_yn.equals("Y") ) && interaction_exists.equals("Y")){// && (intr_restric_trn.equals("Y") || severity_level.equals("H"))){ // added for FD-RUT-CRF-0066.1 [IN036975]

            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block272Bytes, _wl_block272);

					}

            _bw.write(_wl_block277Bytes, _wl_block277);

				}
				else{

            _bw.write(_wl_block278Bytes, _wl_block278);

				}
				putObjectInBean(dir_bean_id,dir_bean,request); 
				putObjectInBean(ex_bean_id,beanex,request); 
				//putObjectInBean(or_bean_id,orbean,request); 
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(barcode_yn.equalsIgnoreCase("Y") && !barcodeDisable.equals("disabled")){ // Added for MMS-DM-CRF-0112.1 [IN:065216] - Start

            _bw.write(_wl_block279Bytes, _wl_block279);
} // Added for MMS-DM-CRF-0112.1 [IN:065216] - End 
            _bw.write(_wl_block280Bytes, _wl_block280);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BarCode.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugProfile.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetail.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dosage/DurationDetail.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Refill.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Allocate.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Batch.label", java.lang.String .class,"key"));
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
}
