package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __drugmastermain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugMasterMain.jsp", 1727760053164L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DrugMaster.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/PhCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t</head>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body  onKeyDown=\"lockKey()\" topmargin=\"0\" onMouseDown = \'CodeArrest()\' >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t<form name=\"drugMasterMainForm\" id=\"drugMasterMainForm\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<td align=\"left\">&nbsp;&nbsp;<input type=\"text\" name=\"drug_code\" id=\"drug_code\" maxlength=\"20\" size=\"20\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onBlur=\"this.value=this.value.toUpperCase();parent.validateCode(this)\" onKeyPress=\"return CheckForSpecChars(event)\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></td>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<td align=\"left\">&nbsp;&nbsp;<input type=\"text\" name=\"drug_code\" id=\"drug_code\" maxlength=\"20\" size=\"20\" READONLY value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></td>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;<input type=\"checkbox\" name=\"in_formulary_yn\" id=\"in_formulary_yn\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onClick=\"parent.validateItemCode(this);parent.assignValue(this);\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n\t\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"audit_log\" id=\"audit_log\" VALUE=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'   onClick=\"parent.viewauditlogdetails(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\" style=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\t&nbsp;</td>\n\t\t\t\t\t</td>\n\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;<input type=\"checkbox\" name=\"link_to_existing_item\" id=\"link_to_existing_item\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"parent.assignValue(this);parent.checkItemCode(this);\"></td>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;&nbsp;<input type=\"text\" name=\"item_code\" id=\"item_code\" maxlength=\"20\" size=\"20\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><input type=\"button\" class=\"button\" value=\"?\" name=\"item_code_lookup\" id=\"item_code_lookup\" onClick=\"parent.searchItem(document.drugMasterMainForm.item_code)\">&nbsp;\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"item_mand\" style=\"visibility:hidden\"></td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;<input type=\"text\" name=\"drug_desc\" id=\"drug_desc\" maxlength=\"60\" size=\"66\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></td> <!-- Removed Colspan for MMS-DM-CRF-0177 -->\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t   <td align=\"left\">&nbsp;&nbsp;<input type=\"text\" name=\"drug_desc\" id=\"drug_desc\" maxlength=\"60\" size=\"66\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n                \t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;&nbsp;<select name=\"drug_search_by\" id=\"drug_search_by\"  onchange=\"validateDrugSearchBy(this)\" >\n\t\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t\t\t<option value=\"T\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t\t\t</select></td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n \t\t\t\t\t <!-- Added For MMS-DM-CRF-0177 -->\n\t\t\t\t</tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"generic_name\" id=\"generic_name\" maxlength=\"40\" size=\"40\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"><input type=\"button\" class=\"button\" name=\"gnbtn\" id=\"gnbtn\" value=\"?\"  onclick=\"parent.searchGenericName(this);\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"generic_id\" id=\"generic_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></td>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;<input type=\"checkbox\" name=\"compound_drug_yn\" id=\"compound_drug_yn\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onclick=\"parent.assignValue(this);parent.validateAlternateAndStrength(this);\" ></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;\n\t\t\t\t\t\t<select name=\"form_code\" id=\"form_code\"\n\t\t\t\t\t\tonChange=\"parent.populateRoute(document.drugMasterMainForm)\"\t><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" selected>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Code Changed for CRF -0034 Route Selection  -->\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;\n\t\t\t\t\t\t<select name=\"route_code\" id=\"route_code\" style=\'color:";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =";background-color:";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\t\t\t<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- Code Started for Prompt Alert for Preferred Drug  -->\n\t\t\t\t<tr>\n\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" </td>\n\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"prompt_alert_for_preferred_drug\" id=\"prompt_alert_for_preferred_drug\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" onClick=\"parent.promptAlertForDrug(this);\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"left\" class=\"label\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" </td>\n\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"default_route_yn\" id=\"default_route_yn\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- Code ended for Prompt Alert for Preferred Drug  -->\n\t\t\t\t\n\t\t\t</table>\n\t\t\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\" name=\"short_desc\" id=\"short_desc\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_select25\" id=\"sql_ph_drug_select25\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<input type=\"hidden\" name=\"stock_yn\" id=\"stock_yn\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t<input type=\"hidden\" name=\"ip_yn\" id=\"ip_yn\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t<input type=\"hidden\" name=\"or_yn\" id=\"or_yn\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_route_code\" id=\"bean_route_code\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_item_code_link\" id=\"drug_item_code_link\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_code_and_item\" id=\"drug_code_and_item\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_select14\" id=\"sql_ph_drug_select14\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_search_select21\" id=\"sql_ph_drug_search_select21\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_search_select22\" id=\"sql_ph_drug_search_select22\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_search_select23\" id=\"sql_ph_drug_search_select23\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_search_select24\" id=\"sql_ph_drug_search_select24\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_search_select25\" id=\"sql_ph_drug_search_select25\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_ph_drug_search_select26\" id=\"sql_ph_drug_search_select26\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_or_ph_select1\" id=\"sql_or_ph_select1\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_or_ph_select2\" id=\"sql_or_ph_select2\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"sql_or_ph_select3\" id=\"sql_or_ph_select3\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_inventory\" id=\"allow_inventory\" value=\"Y\">\n\t\t\t<input type=\"hidden\" name=\"drug_class\" id=\"drug_class\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"drug_to_item_mapping\" id=\"drug_to_item_mapping\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name=\"current_form\" id=\"current_form\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"last_link\" id=\"last_link\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"form_modify\" id=\"form_modify\" value=\"N\">\n\t\t\t<input type=\"hidden\" name=\"content_in_pres_base_uom_ref\" id=\"content_in_pres_base_uom_ref\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"scheduled_drug_yn_man\" id=\"scheduled_drug_yn_man\" value=\"N\">\n\t\t\t<input type=\"hidden\" name=\"schedule_man\" id=\"schedule_man\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"drug_cat_code\" id=\"drug_cat_code\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\"hidden\" name=\"pres_base_uom_ref\" id=\"pres_base_uom_ref\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name=\"stock_uom_code\" id=\"stock_uom_code\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"stock_uom_desc\" id=\"stock_uom_desc\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"pres_base_uom_desc_ref\" id=\"pres_base_uom_desc_ref\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\"hidden\" name=\"base_unit_code\" id=\"base_unit_code\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"base_unit_desc\" id=\"base_unit_desc\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"base_unit_status\" id=\"base_unit_status\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"stock_uom_ref\" id=\"stock_uom_ref\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<input type=\"hidden\" name=\"content_in_pres_base_uom_man\" id=\"content_in_pres_base_uom_man\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"prn_doses_pres_prd_fill_man\" id=\"prn_doses_pres_prd_fill_man\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"prn_doses_cont_daily_fill_man\" id=\"prn_doses_cont_daily_fill_man\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"multi_strength_status\" id=\"multi_strength_status\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"disp_auth_reqd_yn\" id=\"disp_auth_reqd_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"link\" id=\"link\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"retval\" id=\"retval\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"count_flag\" id=\"count_flag\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"or_status\" id=\"or_status\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t<input type=\"hidden\" name=\"toolbarQueryString\" id=\"toolbarQueryString\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"refill_yn\" id=\"refill_yn\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t<input type=\"hidden\" name=\"licenceRights\" id=\"licenceRights\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\"hidden\" name=\"strength_uom\" id=\"strength_uom\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t<input type=\"hidden\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=\"hidden\" name=\"item_image_path\" id=\"item_image_path\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<input type=\"hidden\" name=\"fntColor\" id=\"fntColor\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"><!-- added for CRF RUT-CRF-0034.1[IN:037389] -->\n\t\t\t<input type=\"hidden\" name=\"backgrndColor\" id=\"backgrndColor\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"><!-- added for CRF RUT-CRF-0034.1[IN:037389] -->\n\t\t\t<input type=\"hidden\" name=\"reissue_count\" id=\"reissue_count\" value=\"\"><!--Added for Bru-HIMS-CRF-405[Inc : 44830] -->\n\t\t\t<input type=\"hidden\" name=\"reissue_type\" id=\"reissue_type\" value=\"\"><!--Added for Bru-HIMS-CRF-405[Inc : 44830] -->\n\t\t\t<input type=\"hidden\" name=\"expiry_alert_days\" id=\"expiry_alert_days\" value=\"\"><!-- Added for TH-KW-CRF-0008 -->\n\t\t <input type=\"hidden\" name=\"mm_short_desc\" id=\"mm_short_desc\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\"hidden\" name=\"mm_long_desc\" id=\"mm_long_desc\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t<input type=\"hidden\" name=\"pre_alloc_appl_yn\" id=\"pre_alloc_appl_yn\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> <!-- Added for MMS-DM-CRF-0177 -->\n\t\t</form>\n\t\t<script>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\t\t\t\tparent.populateRoute(document.drugMasterMainForm);\n\t\t\t\tparent.defaultRouteValue();\n\t\t\t\tparent.getMainDrugClass(document.drugMasterMainForm.generic_id.value);\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\tparent.validateLinkItem();\n\t\t\t\tparent.checkItemCode(document.drugMasterMainForm.link_to_existing_item);\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\tparent.setFocus(document.drugMasterMainForm);\n\t\t\tparent.loadButtons(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\');\n\t\t</script>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );
	
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

  public String getCheckStatus(String value)	{
		 if(value.equals("Y"))
			 return "checked";
		 else
			 return "";
	 }
	 public String getCheckValue(String value)	{
		 if(value.equals(""))
			 return "N";
		 else
			 return value;
	 }
	 public String getValue(String value)	{
		 if(value==null || value.equals(""))
			return "";
		 else
			return value;
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

/*
-------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------
14/12/2020   IN8219         Prabha	 	   15/12/2020	Manickavasagam J   MMS-DM-CRF-0177
22/12/2021	TFS-25851       Prabha										   SKR-SCF-1641
-------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale			= (String)session.getAttribute("LOCALE");
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

		/* Mandatory checks start */
		String mode				= request.getParameter( "mode" ) ;
		String drug_code		= request.getParameter( "drug_code" );
		String req_str			= request.getQueryString();
		if(drug_code==null)	drug_code	=	"";
		//out.println(drug_code);
		String bean_id = "DrugMasterBean" ;
		String bean_name = "ePH.DrugMasterBean";
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_DRUG";
		String pkey_value		="";
		String promptAlertDrug = "N";
		String alert_for_preferred_drug_status = "";

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		/* Mandatory checks end */

		/* Initialize Function specific start */
		DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setMode( mode ) ;
		/* Initialize Function specific end */

		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
        log_bean.setLanguageId(locale);
		/* Variable Declarations start */
		HashMap	initialValues						=	null;
		ArrayList	formCode						=	null;
		ArrayList	formDesc						=	null;
		ArrayList	drugMasterMain					=	null;
		ArrayList	prescribing_det					=	null;
		ArrayList	dispensing_det					=	null;

		ArrayList tmpl_values_1 = new ArrayList();
		tmpl_values_1=	 (ArrayList) bean.getSlidingScaleChkdTmpls(drug_code);
		bean.setSlidingScaleChkdValues(tmpl_values_1);

		String		drug_desc						=	"";
		String		in_formulary_status				=	"";
		String		in_formulary					=	"";
		String		link_to_existing_item_status	=	"";
		String		link_to_existing_item			=	"";
		String		item_code						=	"";
		//String		item_desc						=	"";
		String		generic_id						=	"";
		String		generic_name					=	"";
		String		compound_status					=	"";
		String		compound						=	"";
		String		form_code						=	"";
		String		bean_form_code					=	"";
		//String		bean_form_desc					=	"";
		String		form_desc						=	"";
		String		route_code						=	"";
		//String		route_desc						=	"";
		String		drug_code_rule					=	"";
		String		drug_code_and_item				=	"";
		String		drug_item_code_link				=	"";
		String		drug_to_item_mapping			=   "";
		String		drug_code_status				=	"";
		String		drug_desc_status				=	"";
		String		stock_yn						=	"";
		String		ip_yn							=	"";
		String		or_yn							=	"";
		String		base_unit_ref					=	"";
		String		stock_uom_ref					=	"";
		String		pres_base_uom_desc_ref			=	"";
		String		pres_cat_code					=	"";
		String		refill_yn						=	"";
		String strength_value	="";
		String strength_uom		="";
		String item_image_path		="";
		String route_color="";	// added for CRF RUT-CRF-0034.1[IN:037389]-start
		String fntColor="";
		String backgrndColor="";	// added for CRF RUT-CRF-0034.1[IN:037389]-end
		boolean		or_status						=   false;
		String      default_route_yn                =	"Y";// Code Added For CRF 0034
		String      default_route_yn_chk            =   "Checked";
		String mm_short_desc = "";//added for for SKR-SCF-1312
		String mm_long_desc	= "";//added for SKR-SCF-1312
				
		//Added for MMS-DM-CRF-0177
		
		boolean drug_search = false;
	    drug_search = bean.isSite(request,"PH","PRE_ALLOC_APPL"); 
		String drug_search_by = "G";
		String drug_search_generic = "";
		String drug_search_trade = "";
		String pre_alloc_appl_yn="N";
				if(drug_search)
				{
					pre_alloc_appl_yn="Y";
				}
		//Added for MMS-DM-CRF-0177
				
		String sql_ph_drug_select14			=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT14");
		String sql_ph_drug_select25			=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT25");
		String sql_ph_drug_search_select21	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT21");
		String sql_ph_drug_search_select22	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT22");
		String sql_ph_drug_search_select23	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT23");
		String sql_ph_drug_search_select24	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT24");
		String sql_ph_drug_search_select25	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT25");
		String sql_ph_drug_search_select26	=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT26");
		String sql_or_ph_select1			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT1");
		String sql_or_ph_select2			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT2");
		String sql_or_ph_select3			=PhRepository.getPhKeyValue("SQL_OR_PH_SELECT3");

		//Check the version
		String licenceRights = PhLicenceRights.getKey();
		bean.setVersion(licenceRights);
		

		initialValues					=	bean.loadIntialValues();
		item_image_path = (String)initialValues.get("item_image_path")==null?"":(String)initialValues.get("item_image_path");

		/* Variable Declartions end*/
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{
			formCode						=	(ArrayList)initialValues.get("formCode");
			formDesc						=	(ArrayList)initialValues.get("formDesc");
			in_formulary_status				=	getCheckStatus("Y");
			in_formulary					=	getCheckValue("Y");
			link_to_existing_item_status	=	getCheckStatus("Y");
			link_to_existing_item			=	getCheckValue("Y");
			default_route_yn_chk			=	getCheckStatus("Y");
			refill_yn						=	bean.getRefillYN();
			drug_search_by                  =   getValue("G"); //Added for MMS-DM-CRF-0177
			
		}
		else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{

			formCode				=	(ArrayList)initialValues.get("formCode");
			formDesc				=	(ArrayList)initialValues.get("formDesc");

			
			if( bean.loadDrugMasterValues(drug_code) )	{
				drugMasterMain					=	bean.getDrugmastermain();
				drug_code						=	getValue((String) drugMasterMain.get(0));
				or_status						=	bean.getDrugStatusInOR(drug_code);
				drug_desc						=	getValue((String) drugMasterMain.get(1));
				in_formulary_status				=	getCheckStatus((String)drugMasterMain.get(2));
				in_formulary					=	getCheckValue((String)drugMasterMain.get(2));
				link_to_existing_item_status	=	getCheckStatus((String)drugMasterMain.get(3));
				link_to_existing_item			=	getCheckValue((String)drugMasterMain.get(3));
				item_code						=	getValue((String) drugMasterMain.get(4));
				//item_desc						=	getValue((String) drugMasterMain.get(5));
				generic_id						=	getValue((String) drugMasterMain.get(6));
				generic_name					=	getValue((String) drugMasterMain.get(7));
				compound_status					=	getCheckStatus((String)drugMasterMain.get(9));

				compound						=	getCheckValue((String)drugMasterMain.get(9));
				bean_form_code					=	getValue((String) drugMasterMain.get(10));
				//bean_form_desc					=	getValue((String) drugMasterMain.get(11));
				route_code						=	getValue((String) drugMasterMain.get(12));
				route_color						=	getValue((String) drugMasterMain.get(16));	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}
				else{
		           	fntColor= "";
					backgrndColor= "";
				}	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				//route_desc						=	getValue((String) drugMasterMain.get(13));
				promptAlertDrug					=	getValue((String) drugMasterMain.get(14));
				alert_for_preferred_drug_status	=	getCheckStatus((String) drugMasterMain.get(14));
				default_route_yn                =   getValue((String) drugMasterMain.get(15));
				drug_search_by						=	getValue((String) drugMasterMain.get(17)); //Drug_Search_By Added for MMS-DM-CRF-0177
                default_route_yn_chk            =	getCheckStatus(default_route_yn);

				refill_yn						=	bean.getRefillYN();

				prescribing_det					=	bean.getPrescription();
				base_unit_ref					=	getValue((String)prescribing_det.get(0));
				strength_value				=	(String)prescribing_det.get(2);
				strength_uom				=	(String)prescribing_det.get(3);
				pres_cat_code					=	getValue((String)prescribing_det.get(6));
				stock_uom_ref					=	getValue((String)prescribing_det.get(9)); //Added for ICN 28393 
				prescribing_det					=	null;
				prescribing_det					=	bean.loadBaseUnit(bean_form_code);
				//COMMENTED FOR SKR-SCF-1312 START
				ArrayList	desclist	 		= bean.getDescFromMM(drug_code, locale);  
				if(desclist.size()>0 && desclist!=null){ //Modified for SKR-SCF-1641
					mm_short_desc=(String)desclist.get(0);
					mm_long_desc = (String)desclist.get(1);
				}
				System.out.println("mm_short_desc: "+mm_short_desc); 
				//SKR-SCF-1312 end				
				for(int i=0;i<prescribing_det.size();i+=3){

				   if(((String)prescribing_det.get(i)).equals( base_unit_ref ))	{
						pres_base_uom_desc_ref		=		(String)prescribing_det.get(i+1);
						bean.setPrescribingDesc(pres_base_uom_desc_ref);
				   }
				}

				dispensing_det					=	bean.getDispensing();
				//stock_uom_ref					=	getValue((String)dispensing_det.get(2)); //commented for ICN 28393 
			}
			else	{
				String Drug_Msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NorecordsforDrugCode.label","ph_labels")+drug_code;
				out.println("<script>alert('"+Drug_Msg+"') ;</script>");
			}
		}

		drug_code_rule					=	bean.getDrugCodeGenRule();
		drug_code_and_item				=	bean.getDrugCodeAndItem();
		drug_item_code_link				=	bean.getDrugItemCodeLink();
		drug_to_item_mapping			=	bean.getDrugDrugItemMapping();
		stock_yn						=	bean.getStockModuleYN();
		ip_yn							=	bean.getIPModuleYN();
		or_yn							=	bean.getORModuleYN();
		if(drug_code_rule.equals("G")) {
			drug_code_status		= "disabled";
			drug_desc_status		= "disabled";
		}

		if( (drug_code_and_item.equals("S")) && stock_yn.equals("Y") ) {
			drug_code_status	=	"readOnly";
			drug_desc_status	= "readOnly";
		}
 /*-------------------------code added for showing audit log---------------------------*/
		//primary_key_1  ------>DRUG_CODE
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add(drug_code);      
		
		String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
		pkey_value   ="";
		if(display_audit_log_button_yn.equals("Y")){
			audit_log_visible= "visibility:visible";
			pkey_value       = (String)log_bean.getpk_value();
		}
		else{
			audit_log_visible= "visibility:hidden";
			log_bean.clear();
		}
		
		//Added for MMS-DM-CRF-0177
		
		if(drug_search_by.equals("G"))
		{
			drug_search_generic = "selected";
		}
		else if(drug_search_by.equals("T"))
		{
			drug_search_trade = "selected";
		}
		
		//Added for MMS-DM-CRF-0177
		
		//	out.println("pkey_value="+pkey_value);
		//	out.println("display_audit_log_button_yn="+display_audit_log_button_yn);
		/*--------------------------------------ends here---------------------------------------*/

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))	{	

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(drug_code_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
	
					}
					else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{	

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}	

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(in_formulary_status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(in_formulary));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(table_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pkey_value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(audit_log_visible));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(link_to_existing_item_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(link_to_existing_item));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block27Bytes, _wl_block27);

					if(stock_yn.equals("Y"))	{	

            _bw.write(_wl_block28Bytes, _wl_block28);

					}

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_desc_status));
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
					else{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_desc_status));
            _bw.write(_wl_block32Bytes, _wl_block32);

				   }
					System.out.println("DrugMasterMain.jsp - drug_desc: "+drug_desc); 
					
				 /* Added For MMS-DM-CRF-0177 */
                   if(drug_search){

            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_search_generic));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_search_trade));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
					} 

            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(compound_status));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(compound));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

						for(int i=0; i<formCode.size(); i++){

							form_code	=	(String)formCode.get(i);
							form_desc	=	(String)formDesc.get(i);
							if(bean_form_code.equals(form_code))	{

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);

							}
							else{	

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
		
							}
						}

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(alert_for_preferred_drug_status));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(promptAlertDrug));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(default_route_yn_chk));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(default_route_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(sql_ph_drug_select25));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(stock_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ip_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(or_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(drug_item_code_link));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(drug_code_and_item));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(sql_ph_drug_select14));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sql_ph_drug_search_select21));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(sql_ph_drug_search_select22));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(sql_ph_drug_search_select23));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(sql_ph_drug_search_select24));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sql_ph_drug_search_select25));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sql_ph_drug_search_select26));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sql_or_ph_select1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(sql_or_ph_select2));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(sql_or_ph_select3));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(drug_to_item_mapping));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pres_cat_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(base_unit_ref));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(pres_base_uom_desc_ref));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(stock_uom_ref));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(or_status));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(refill_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(licenceRights));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(item_image_path));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mm_short_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(mm_long_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(pre_alloc_appl_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { 

            _bw.write(_wl_block99Bytes, _wl_block99);

			}
			if(!mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {	

            _bw.write(_wl_block100Bytes, _wl_block100);

			}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(req_str));
            _bw.write(_wl_block102Bytes, _wl_block102);

	putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InFormulary.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditLog.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Linktoanexistingitem.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDescription.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugSearchBy.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Generic.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Generic&TradeName.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Compound.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PromptAlertForPreferredDrug.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DefaultRoute.label", java.lang.String .class,"key"));
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
}
