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
import java.util.*;
import com.ehis.util.*;

public final class __copyorderssearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/CopyOrdersSearch.jsp", 1734325930000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<link rel=\"stylesheet\" type=\"text/css\"\thref=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\"\tsrc=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ExistingOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  onload=\"FocusFirstElement();populateCopyOrdersSearchValues(\'patient_class\');populateCopyLocation(document.copy_orders_search.location_type);fillDefaultVals(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');populateCopyValues(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');populateCopyOrdersSearchValues(\'ord_cat\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"copy_orders_search\" id=\"copy_orders_search\" target=\"messageFrame\" >\n\n<table cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"100%\" align=\"center\">\n\n\n\t<tr>\n\t\t<TD class=\"label\" width=\"23%\" nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TD>\n \t\t<TD class=\"fields\" width=\"23%\"  ><Select name=\"patient_class\" id=\"patient_class\"><Option value=\"\">--- ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ---</Option></Select></TD>\n\n       <td class=\"label\" width=\"23%\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\"fields\" width=\"31%\"  ><!--ADDED NEW LOOK UP  --> <input type=\"text\" name=\"practitioner_desc\" id=\"practitioner_desc\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" size=\"14\" maxlength=\"40\" onFocus=\"\"  readonly >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<input type=\"button\" name=\"practitioner_button\" id=\"practitioner_button\" class=\"button\"   value=\"?\" onClick=\"show_practitioner_window(document.getElementById(\'practitioner_desc\'))\">\n\t\t<input type=\"hidden\" name=\"practitioner\" id=\"practitioner\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=\"30\" maxlength=\"40\" >\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t</tr>\n\t\n\n\t\t<tr>\n\n\t\t <td class=\"label\" width=\"23%\" nowrap >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=\"fields\" width=\"23%\"><SELECT name=\"order_category\" id=\"order_category\" onChange=\"populateCopyOrdersSearchValues(\'ord_cat\');clearFields(\'CopyOrders\');\">  <!--onChange=\'populateOrderTyoes(this)\'-->\n\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ---</Option>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\n\t\t<option value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</Option>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</SELECT></td>\n\t\t<td class=\"label\" width=\"23%\"  nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td class=\"fields\" width=\"31%\"><input type=\'hidden\' name=\'order_type\' id=\'order_type\' value=\"\"><input type=\'text\' width=\'16%\' name=\'order_type_desc\' id=\'order_type_desc\' value=\"\" onBlur=\"populateordertypeSearch(order_type_desc,order_type,\'CopyOrders\');\"  maxlength=\'\' ><input type=\"button\" name=\"ordertypesearch\" id=\"ordertypesearch\" value=\'?\'  class=\"button\" tabIndex=\"4\" onClick=\"callordertypeSearch(order_type_desc,order_type,\'CopyOrders\');\"><!-- <SELECT name=\"order_type\" id=\"order_type\" onchange=\"populateCopyOrdersSearchValues(\'order_type\')\"> -->\n\t\t\t\t<!--  <option value=\"\">--- ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ---</Option> -->\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<!-- \t\t</SELECT> --></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\"  width=\"23%\" nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t<td class=\"fields\" width=\"23%\"><input type=\'hidden\' name=\'activity_type\' id=\'activity_type\' value=\"\"><input type=\'text\' width=\'16%\' name=\'activity_type_desc\' id=\'activity_type_desc\' value=\"\" onBlur=\"populateActivitySearch(activity_type_desc,activity_type,\'CopyOrders\');\"  maxlength=\'\' ><input type=\"button\" name=search value=\'?\'  class=\"button\" tabIndex=\"4\" onClick=\"callActivitySearch(activity_type_desc,activity_type,\'CopyOrders\');\"></td>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" <!-- onClick=\"showAllDiagnosisWindow(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\"-->\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<td class=\"label\" width=\"23%\" nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<td  class=\"fields\" width=\"31%\"><input type=\"text\" name=\"catalog\" id=\"catalog\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=\"20\" maxlength=\"40\"></td>\n\t</tr>\n\n\t<tr>\n\n\t\t<td class=\"label\" width=\"23%\" nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t<td class=\"fields\" width=\"23%\"><input type=\"text\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\"10\" maxlength=\"10\" onBlur=\"chckDate(this)\" onKeyPress=\"return OrAllowDateFormat()\" nowrap><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_from\');\" style=\'cursor:pointer\' nowrap></img>-<input type=\"text\" name=\"date_to\" id=\"date_to\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" size=\"10\" maxlength=\"10\" onBlur=\"checkDateRange(this,\'copy_orders_search\',\'DMY\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\" onKeyPress=\"return OrAllowDateFormat()\" nowrap><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_to\');\" style=\'cursor:pointer\' nowrap><img src=\"../../eCommon/images/mandatory.gif\"></img></td> \n\n\t\t<TD class=label width=\"23%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</TD>\n\t\t<td class=\"fields\" width=\"31%\"><SELECT name=\"location_type\" id=\"location_type\" onChange=\'populateCopyLocation(this)\'>\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t</SELECT><input type=\'text\' name=\'locn_code\' id=\'locn_code\' value=\"\" onBlur=\'populateMvLoaction(locn_code,locn)\'  size=\"10\" maxlength=\'\' disabled><input type=button id=\'location_lookup\' name=search value=\'?\'  class=button onClick=\"populateMoveLoaction(locn_code,locn)\" disabled><input type=\"hidden\" name=\"locn\" id=\"locn\" value=\"\">\n\t\t</td>\n\n\n\t\t\n\t</TR>\n\t\t\n\t\t<tr>\n\n        <td  class=\"label\"  nowrap width=\"23%\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t<td class=\"fields\"  nowrap id=\'patient_id_td\' width=\"23%\"><input type=\"text\"  name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"ChangeUpperCase(this)\"  size=\"20\" maxlength=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ><input align=\"right\" type=\"button\" name=\"search\" id=\"search\" value=\"?\"  class=\"button\" tabIndex=\"4\" onClick=\"callPatientSearch()\">\n\t\t</td>\n\n\n\n\t\t\t<td class=\"label\"  nowrap width=\"23%\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<td class=\"fields\" width=\"31%\"><input type=\"text\" name=\"encounter_id\" id=\"encounter_id\" value=\"\" size=\"12\" maxlength=\"12\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\">\n\t\t</td>\n\t</tr>\n\n \t\n\t<tr>\n\t\t<td class=label  nowrap width=\"23%\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t<td width=\"23%\"><SELECT name=\"search_criteria\" id=\"search_criteria\">\n\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t</SELECT>\n\t\t</td>\n\t\t<!-- IN052649 Start -->\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\t\t<td   align=\"right\" colspan=\'2\'>\n\t\t<input type=\"hidden\" name=\"OrderingSpecialityCopyPreviousOrder\" id=\"OrderingSpecialityCopyPreviousOrder\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"\">\n\t\t<input type=\"button\" class=\"button\" name=\"search\" id=\"search\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"  onClick=\'populateCopyValues()\'><input type=\"button\" name=\"clear\" id=\"clear\" class=\"button\" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' onClick=\'clearCopySearchValues()\'></td>   <!--onClick=\'populateValues()\' onClick=\'clearValues()\'-->\n\t\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<td class=label  nowrap width=\"23%\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td>\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"15%\">\n\t\t\t\t\t\t<Select name=\'OrderingSpecialityCopyPreviousOrder\' id=\'OrderingSpecialityCopyPreviousOrder\' onChange=\"specialityOnChange();\">\t\n\t\t\t\t\t\t\t<Option value=\'A\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</Option>\n\t\t\t\t\t\t\t<Option value=\'P\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</Option>\n\t\t\t\t\t\t\t<Option value=\'E\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</Option>\n\t\t\t\t\t\t</Select>\n\t\t\t\t\t\t<input type=\'text\' name=\'speciality_desc\' id=\'speciality_desc\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" onBlur=\'populateSpecialityOnBlur(speciality_code,speciality_desc)\'  size=\'13\' maxlength=\'20\'>\n\t\t\t\t\t\t<input type=button id=\'speciality_lookup\' name=search value=\'?\'  class=button onClick=\"populateSpeciality(speciality_code,speciality_desc)\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"7%\" align=\"right\">\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"search\" id=\"search\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' onClick=\'clearCopySearchValues()\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\t\t\n\t\t</td>\t\t\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<!-- IN052649 End -->\n\t</tr>\n\n</table>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n<img src=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' width=\'100%\' height=\'15\'/> \n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n<input type=\"hidden\" name=\"prac_sql\" id=\"prac_sql\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\"hidden\" name=\"order_type_sql\" id=\"order_type_sql\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\"hidden\" name=\"activity_sql\" id=\"activity_sql\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"clinic_sql\" id=\"clinic_sql\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"nursing_sql\" id=\"nursing_sql\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\n<input type=hidden name=\'encntr_id\' id=\'encntr_id\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n<input type=hidden name=\'cur_encounter_id\' id=\'cur_encounter_id\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'> <!--[IN029659]-->\n<input type=hidden name=\'cur_patient_class\' id=\'cur_patient_class\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'> <!--[IN029659]-->\n<input type=hidden name=\'pract_reln_id\' id=\'pract_reln_id\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\n<input type=hidden name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n<input type=hidden name=\'pat_class\' id=\'pat_class\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n<input type=hidden name=\'p_called_from_ca\' id=\'p_called_from_ca\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=hidden name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=hidden name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=hidden name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=hidden name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\'hidden\' name=\'view_by\' id=\'view_by\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'><!-- IN042045 -->\n\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n<input type=\"hidden\" name=\"temp_last_month_date\" id=\"temp_last_month_date\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\"hidden\" name=\"temp_curr_sys_date\" id=\"temp_curr_sys_date\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\"hidden\" name=\"querystring\" id=\"querystring\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\n<!-- IN052649 Start -->\n<input type=\"hidden\" name=\"primarySpecialityCode\" id=\"primarySpecialityCode\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\"hidden\" name=\"PrimarySpecialityDesc\" id=\"PrimarySpecialityDesc\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\"hidden\" name=\"currentEncSpecialityCode\" id=\"currentEncSpecialityCode\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\"hidden\" name=\"currentEncSpecialityDesc\" id=\"currentEncSpecialityDesc\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\"hidden\" name=\"speciality_sql\" id=\"speciality_sql\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderSpec\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderMI\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderOT\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderCN\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderLB\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderTR\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderPC\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderPH\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderNC\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderDS\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderRX\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderRD\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderCS\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"> <!-- 26826 -->\n<input type=\"hidden\" name =\"dxChkBfrPlaceOrderOH\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"> <!-- 26826 -->\n<!-- IN052649 End -->\n<!-- 44884 Start. -->\n\t<input type=\"hidden\" name =\"practitionerRel\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSMI\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSOT\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSCN\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSLB\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSTR\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSPC\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSPH\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSNC\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSDS\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSRX\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSRD\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSCS\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\t\t\t\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSOH\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFMI\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFOT\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFCN\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFLB\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFTR\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFPC\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFPH\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFNC\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFDS\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFRX\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFRD\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFCS\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\t\t\t\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFOH\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<!-- 44884 End. -->\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

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

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/11/2011    IN029659       Chowminya G    Incident No: IN029659 - < System allows to place the new orders using Copy Previous Order function- CRF Linked Issue> 
13/08/2013	  IN042045		 Chowminya G	System should not allow to copy for the drugs for which Verbal Order Applicable is not selected																														
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
19/03/2015  IN052649		Ramesh G										Previous orders - Default filter to be filtered by All or by specialty	 
27/07/2022	26826			Ramesh G										MMS-DM-CRF-0197 
31/05/2023		44884		Krishna		31/05/2023		Ramesh G 	MO-CRF-20183

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.ExistingOrder bean= null;{
                bean=(eOR.ExistingOrder)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.ExistingOrder();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	/* Mandatory checks start */
	String mode	   			= "1";// request.getParameter( "mode" ) ;

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id 				= request.getParameter( "function_id" ) ;
	String patient_id 				= request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id");
	String patient_class 			= request.getParameter("patient_class");
	String pract_reln_id			= (String)request.getParameter("relationship_id");

	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String view_by					= request.getParameter("view_by");
	String order_type_desc		= request.getParameter("order_type_desc");
	String practitioner_type					= request.getParameter("practitioner_type");//IN042045
	bean.setLanguageId(localeName);

	bean_id					= (bean_id == null) ? "":bean_id.trim();
	bean_name				= (bean_name == null) ? "":bean_name.trim();
 	patient_id				= (patient_id == null) ? "":patient_id.trim();
 	function_id				= (function_id == null) ? "":function_id.trim();
 	encounter_id			= (encounter_id == null) ? "":encounter_id.trim();
 	patient_class			= (patient_class == null) ? "":patient_class.trim();
 	pract_reln_id			= (pract_reln_id == null) ? "":pract_reln_id.trim();
 	view_by					= (view_by == null) ? "L" : view_by.trim();
 	order_type_desc		= (order_type_desc == null) ? "" : order_type_desc.trim();

	//String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
	//String bean_name = "eOR.ExistingOrder";

	String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id");
	String cur_encounter_id 	= encounter_id; //--[IN029659]
	String cur_patient_class 	= patient_class; //--[IN029659]
	resp_id					= (resp_id == null) ? "":resp_id.trim();
	practitioner_id			= (practitioner_id == null) ? "":practitioner_id.trim();
	facility_id				= (facility_id == null) ? "":facility_id;

//	out.println(">"+practitioner_id+"<<br>");
//	out.println(">"+resp_id+"<");
	ArrayList Category_Data = new ArrayList();
	//ArrayList OrderType_Data = new ArrayList();
/* Mandatory checks end */

	/*String[] allsess_vals = (String[])session.getValueNames();
	for(int i=0; i<allsess_vals.length; i++)
		out.println(allsess_vals[i]+" = ");*/


	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	// ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;



	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//bean.clear() ;
	//bean.setMode( mode ) ;

	//String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("Sex"),"");
	String age						= bean.checkForNull(request.getParameter("Age"),"");
	String dob						= bean.checkForNull(request.getParameter("Dob"),"");
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");

	String date_from				= bean.checkForNull(request.getParameter("date_from"),"");
	String date_to					= bean.checkForNull(request.getParameter("date_to"),"");
	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	String order_type				= bean.checkForNull(request.getParameter("order_type"),"");
	String catalog					= bean.checkForNull(request.getParameter("catalog"),"");
	String clear					= bean.checkForNull(request.getParameter("clear"),"");
	Properties properties			= (Properties) session.getValue( "jdbc" );
//out.println("<script>alert('querystring="+request.getQueryString()+"')</script>");
	String pract_namefrom_db		= "";
	boolean canChangePractId		= true;
	int patient_id_length			= bean.getPatientIdLength(properties);
	String pract_idfrom_db			= "";
    String[] diag_code = bean.getDiagCode(properties);

    String curr_sys_date = "";
	//String curr_week_date  = "";
	//String last_week_date  = "";
	String last_month_date	= "";
	String copy_prev_order_from_date = (String) bean.getCopyPrevOrderFromDate(facility_id);
	if(!"0".equals(copy_prev_order_from_date)){
		date_from = copy_prev_order_from_date ;
	}
	try{
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){

	//	curr_week_date =  (String)sysdate.get(0);
	//	last_week_date =  (String)sysdate.get(1);
	//	curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	//	last_month_date = (String)sysdate.get(3);
		curr_sys_date	= (String)sysdate.get(0);
		last_month_date = (String)sysdate.get(4);

		//out.println("<script>alert('last_week_date="+last_week_date+"')</script>");
	}
	} catch (Exception e) {
		out.println("<script>alert('here:"+e.getMessage()+"')</script>");
	}
     curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
    last_month_date = com.ehis.util.DateUtils.convertDate(last_month_date,"DMY","en",localeName);

    String  temp_last_month_date=last_month_date;
    String temp_curr_sys_date=curr_sys_date;
    //IN052649 Start.
	ArrayList orderingSpecialityDtl = (ArrayList)bean.getOrderingSpecialityType(facility_id,practitioner_id,cur_encounter_id);
	String	orderingspecialitycopypreviousorder=(String)orderingSpecialityDtl.get(0);
	String primarySpecialityCode = (String)orderingSpecialityDtl.get(1);
	String PrimarySpecialityDesc = (String)orderingSpecialityDtl.get(2);
	String currentEncSpecialityCode = (String)orderingSpecialityDtl.get(3);
	String currentEncSpecialityDesc = (String)orderingSpecialityDtl.get(4);
	String specialityCode ="";
	String specialityDesc ="";
	if("A".equals(orderingspecialitycopypreviousorder)){
		specialityCode ="";
		specialityDesc ="";
	}else if("P".equals(orderingspecialitycopypreviousorder)){
		specialityCode =primarySpecialityCode;
		specialityDesc =PrimarySpecialityDesc;
	}else if("E".equals(orderingspecialitycopypreviousorder)){
		specialityCode =currentEncSpecialityCode;
		specialityDesc =currentEncSpecialityDesc;
	}
	//IN052649 End.
/* Initialize Function specific end */
//26826 Start
HashMap  dxChkBfrPlaceOrderMap=new HashMap();
try{	
	dxChkBfrPlaceOrderMap = bean.allowedNewOrders(patient_id,encounter_id,patient_class,facility_id,"");
}catch(Exception e)
{
	e.printStackTrace();				
}
// 26826  End.
// 44884 Start
	String practitionerRel=bean.getPractitionerRelation(practitioner_id,patient_id);
	HashMap restrictedNewOrdersSF=bean.restrictedNewOrdersSF(practitioner_id,practitionerRel,"");

//  44884 End.

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clear));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pract_namefrom_db));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(canChangePractId){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pract_idfrom_db));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			try{
				Category_Data = bean.getAllOrderCategory(properties);
				String[] record = null;

				for(int i=0; i<Category_Data.size(); i++){
					record = (String [])Category_Data.get(i);

					

		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
			}catch(Exception e){
				out.println(e);
			}
		
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

			/*try{
				String ord_cat = "";
				String[] record = null;
				OrderType_Data = bean.getOrderTypeData(properties, ord_cat);

				for(int i=0; i<OrderType_Data.size(); i++){
					record = (String [])OrderType_Data.get(i);
           */
		
            _bw.write(_wl_block27Bytes, _wl_block27);

				/*}
			}catch(Exception e){
				out.println("here : "+e);
			}*/
		
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(diag_code[0]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(diag_code[1]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(catalog));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((date_from.equals("")?last_month_date:date_from)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((date_to.equals(""))?curr_sys_date:date_to));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
if("N".equals(orderingspecialitycopypreviousorder)){ 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(orderingspecialitycopypreviousorder ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block55Bytes, _wl_block55);
}else{
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
if(orderingspecialitycopypreviousorder.equals("A")) {out.println("selected");}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
if(orderingspecialitycopypreviousorder.equals("P")) {out.println("selected");}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(orderingspecialitycopypreviousorder.equals("E")) {out.println("selected");}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(specialityDesc ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(specialityCode ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block64Bytes, _wl_block64);
} 
            _bw.write(_wl_block65Bytes, _wl_block65);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRAC_LOOKUP")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(cur_encounter_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(cur_patient_class));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(age));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block90Bytes, _wl_block90);
//=bean.getFunctionId()
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(temp_last_month_date ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(temp_curr_sys_date ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(primarySpecialityCode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(PrimarySpecialityDesc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(currentEncSpecialityCode));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(currentEncSpecialityDesc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_AM_SPECIALITY_LOOKUP")));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderSpec")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderMI")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOT")));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCN")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderLB")));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderTR")));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPC")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPH")));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderNC")));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderDS")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRX")));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRD")));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCS")));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOH")));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bean.checkForNull(practitionerRel,"N")));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSMI"),"N")));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOT"),"N")));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCN"),"N")));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSLB"),"N")));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSTR"),"N")));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPC"),"N")));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPH"),"N")));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSNC"),"N")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSDS"),"N")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRX"),"N")));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRD"),"N")));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCS"),"N")));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOH"),"N")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFMI"),"N")));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOT"),"N")));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCN"),"N")));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFLB"),"N")));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFTR"),"N")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPC"),"N")));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPH"),"N")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFNC"),"N")));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFDS"),"N")));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRX"),"N")));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRD"),"N")));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCS"),"N")));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOH"),"N")));
            _bw.write(_wl_block141Bytes, _wl_block141);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPractitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderCategory.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ActivityType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.catalog.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SearchCriteria.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.primaryspeciality.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.encounterspeciality.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
