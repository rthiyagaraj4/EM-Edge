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
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptiondetail_2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionDetail_2.jsp", 1709121207834L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--saved on 27th Oct 2005 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<!-- <script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script> -->\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t <script language=\"JavaScript\" src=\"../../eCommon/js/PhCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/Prescription_1.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/Prescription_2.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/PrescriptionTest.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"prescription_amend_detail_form\" id=\"prescription_amend_detail_form\" >\n\t\t\t<!-- Below table for CurrentRx details-->\n\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" name=\"bean_id\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=\"bean_name\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\"presBean_id\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"presBean_name\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  width=\"15%\">\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onClick=\"javascript:callActiveOrders(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\"></td>\n\t\t\t\t\t\t<td class=\"CURRTEXT\"  width=\"70%\">\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\"   width=\"15%\"><input type=\'button\' class=\'button\' onClick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<!--CurrentRx table ends-->\n\t\t\t<br>\n\t\t\t<!-- Prescription Writer Table starts-->\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\"  border=\"0\">\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\"  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"   width=\"25%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=\"label\"   width=\"40%\" colspan=\"3\"><input type=\"text\" name=\"drug_name\" id=\"drug_name\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" disabled size=\"50\"></td>\n\t\t\t\t\t<td class=\"label\"   width=\"5%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t<td class=\"label\"  width=\"30%\"><input type=\"text\" name=\"priority_disp\" id=\"priority_disp\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\"10\" disabled>\n\t\t\t\t\t\t<input type=\"text\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" size=\"10\" disabled>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"   width=\"25%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"label\"   width=\"18%\"><input type=\"text\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" disabled size=\"7\" class=\"NUMBER\">&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" / ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<td class=\"label\"   width=\"18%\"><input type=\"hidden\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<td class=\"label\"   width=\"18%\"><input type=\"text\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<td class=\"label\"  width=\"22%\" colspan=\"2\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;&nbsp;<input type=\"text\" name=\"form_desc\" id=\"form_desc\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" disabled size=\"10\"></td>\n\t\t\t\t\t<td class=\"label\"   width=\"5%\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t<td class=\"data\" id=\"strength\" width=\"30%\"><input type=\"text\" name=\"route_desc\" id=\"route_desc\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" disabled size=\"10\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<td class=\"label\"   width=\"25%\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t<td class=\"label\"   width=\"18%\"><input type=\"text\" name=\"trade_name\" id=\"trade_name\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" disabled size=\"7\" class=\"NUMBER\">\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'trade_code\' id=\'trade_code\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'></td></td>\n\t\t\t\t\t<td class=\"label\" colspan=4>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" disabled></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" ><img src=\"../../eOR/images/Authorization.gif\" id=\"requires_auth_gif\"  style=\"visibility:hidden\" onclick=\"chkAuthorization(\'auth\')\"></img></td>\n\t\t\t\t\t<td class=\"label\"  id=\"auth_yn\" nowrap>&nbsp;</td>\n\t\t\t\t\t<td class=\"label\"><img src=\"../../eOR/images/SpecialApproval.gif\" id=\"spl_approval_gif\"  style=\"visibility:hidden\" onclick=\"chkAuthorization(\'approve\')\"></img></td>\n\t\t\t\t\t<td class=\"label\"  id=\"spl_approval\">&nbsp;</td>\n\t\t\t\t\t<td class=\"label\" ><img src=\"../../eOR/images/Cosign_click.gif\" id=\"cosign_gif\"  style=\"visibility:hidden\" onclick=\"chkAuthorization(\'cosign\')\"></img></td>\n\t\t\t\t\t<td class=\"label\"  id=\"cosign\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t<td  class=\"label\"><input type=\"text\" name=\"dosage\" id=\"dosage\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" disabled size=\"10\">\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t<td class=\"label\"  id=\"dosage_label\" colspan=\"2\">&nbsp;<font color=\'red\' onmouseover=\"displayamendToolTipDataChange(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\" onmouseout=\"disasbleamendToolTipDataChange();\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<td class=\"label\"  id=\"dosage_label\" colspan=\"2\">&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<td class=\"label\"  ><input type=\"text\" name=\"qty_value\" id=\"qty_value\" size=\"3\" maxlength=\"13\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" onKeyPress=\"return allowValidNumber(this,event,8,6);\" onblur=\"validateamendDosageLimit(\'true\');\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="></td>\n\t\t\t\t\t\t<td ><input type=\"text\" name=\"qty_desc_dis\" id=\"qty_desc_dis\" size=\"10\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" disabled><input type=\"hidden\" name=\"qty_desc\" id=\"qty_desc\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t\t\t\t\t\t<input type=\'hidden\' name=\'qty_desc\' id=\'qty_desc\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t<td class=\"label\" ><input type=\"text\" name=\"freq_desc\" id=\"freq_desc\" size=\"20\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" disabled>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  colspan=\"2\" class=\"label\">&nbsp;&nbsp;</td>\n\t<!--\t\t\t\t<td class=\"label\" id=\"recomm_dose\">&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\"data\" align=\"left\">&nbsp;&nbsp;</td>\n\t\t\t\t\t!-->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<td colspan=\"3\"><label  id=\"rec_legend\" style=\"font-size:11;font-weight:bold;color:red; visibility:hidden\" title=\"Recommended Dosage\" >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" </label>\n\t\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\"></label>\n\t\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\"></label></td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<td colspan=\"3\"><label  id=\"rec_legend\" style=\"font-size:11;font-weight:bold;color:red;visibility:hidden\" >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t\t\t</tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t<td class=\"label\" ><input type=\"text\" size=\"1\" maxlength=\"3\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"  ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" onBlur=\"putDecimal(this,2,0);CheckPositiveNumber(this); maxDurnValidation(\'Y\');extDosageCheck(\'Modify\');getChargeDetails(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\');\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" >&nbsp;";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_value\" id=\"tmp_durn_value\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_desc\" id=\"tmp_durn_desc\"  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"durn_desc\" id=\"durn_desc\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t<td class=\"label\"  colspan=\"2\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t<td  class=\"data\" colspan=\'2\'><input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"3\" name=\"absol_qty\" id=\"absol_qty\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="  onBlur=\"ValidateAbs(this);CheckPositiveNumber(this);getChargeDetails(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\',\'ABS_QTY\')\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\"> &nbsp;";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<td class=\"label\"  ><input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"12\"  maxlength=\"12\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" disabled></td>\n\t\t\t\t<td class=\"label\"  colspan=\"2\" nowrap>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&nbsp;&nbsp;<input type=\"text\" name=\"end_date\" id=\"end_date\" size=\"13\"  maxlength=\"13\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" disabled></td>\n\t\t\t\t<td class=\"label\" colspan=\"2\"  style=\"\" ><input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' style=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"dosage_limit\" onclick=\"showAmendOverRideRemarks(prescription_amend_detail_form)\" >\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t\t<td class=\"label\"  ><input type=\"text\" size=\"20\" maxlength=\"20\" name=\"disp_locn_desc\" id=\"disp_locn_desc\" disabled value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">&nbsp;<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"></td>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t<!-- <td class=\"label\" >&nbsp;</td>\n\t\t\t\t<td class=\"label\" ><input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"\"></td> -->\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t<td class=\"label\"  colspan=\"2\">&nbsp;</td>\n\t\t\t\t<td class=\"label\"  colspan=\"2\"><a href=\"javascript:showOrderRemarks(\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\');\" id=\"drug_remarks\" style=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" title=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</a>\n\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 Start-->\n\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'>\n\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 End-->\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"sql_ph_prescription_bl_action_select_lookup\" id=\"sql_ph_prescription_bl_action_select_lookup\" VALUE=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t<tr >\n\t\t\t\t<td colspan=\"6\" >\t\t\t\t\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t<tr id=\'BL_HEADERBAR\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"7\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr id=\'BL_HEADER\' style=\'display:none;\'>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\' id=\'bl_override_excl_incl_ind_lbl\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="?\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\"label\" width=\'40%\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t<td class=\"label\" nowrap width=\'10%\' style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t<td class=\"label\" width=\'14%\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'14%\'style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr id=\'BL_VALUES\' style=\'display:none;\'>\n\t\t\t\t\t\t\t<td align=\'center\' id=\'bl_def_override_excl_incl_ind_gif\'>&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" id=\'td_bl_override_excl_incl_ind\'>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t\t<select name=\"bl_override_excl_incl_ind\" id=\"bl_override_excl_incl_ind\" onchange=\"assignOverrideExclInclInd(this)\"  >\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\t<option value=\"SEL\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =">---";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="---</option>\n\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</option>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="---</option>\n\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" >";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t\t<option value=\"SEL\"selected>---";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="---</option>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_def_override_excl_incl_ind\' id=\'bl_def_override_excl_incl_ind\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_allowed_yn\' id=\'bl_override_allowed_yn\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" >\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_incl_excl_override_reason_desc\' id=\'bl_incl_excl_override_reason_desc\' size=\'40\'  value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' readonly >\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" id=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\');\" disabled><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:hidden;\'></img>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" id=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\');\"><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:visible;\'></img>\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_incl_excl_override_reason_code\' id=\'bl_incl_excl_override_reason_code\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t<td class=\"data\" id=\'gross_charge_amt\' align=\'center\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t   <td class=\"data\"  id=\'gross_charge_amt\' align=\'center\' style=\'display:none;\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t<td class=\"data\" id=\'bl_total_charge_amt\' align=\'center\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"data\" id=\'bl_patient_payable_amt\' align=\'center\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\'center\'id=\'bl_approval_reqd_yn\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<label id=\"tool_tip\" style=\"visibility:hidden\"></label>\n\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<input type=\"hidden\" name=\"route_desc\" id=\"route_desc\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"generic_id\" id=\"generic_id\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"generic_name\" id=\"generic_name\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" name=\"allergy_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" name=\"current_rx\">\n\t\t\t<input type=\"hidden\" name=\"split_dose_yn\" id=\"split_dose_yn\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t<input type=\"hidden\" name=\"strength_per_pres_uom\" id=\"strength_per_pres_uom\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t<input type=\"hidden\" name=\"strength_per_value_pres_uom\" id=\"strength_per_value_pres_uom\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" name=\"min_unit_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" name=\"min_daily_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" name=\"patient_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" name=\"encounter_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" name=\"drug_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" name=\"repeat_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" name=\"interval_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" name=\"durn_type\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" name=\"prescribed_mode\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" name=\"mode\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" name=\"limit_ind\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"daily_dose\" id=\"daily_dose\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"unit_dose\" id=\"unit_dose\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"mono_graph\" id=\"mono_graph\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" name=\"srl_no\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" name=\"patient_class\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" name=\"order_type_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" name=\"form_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" name=\"route_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" name=\"repeat_durn_type\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" name=\"override_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" name=\"alg_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" name=\"dsg_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" name=\"dup_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" name=\"called_from\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" name=\"dup_start_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" name=\"dup_end_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" name=\"dup_drug_desc\">\n\t\t\t<input type=\"hidden\" name=\"dosage_type\" id=\"dosage_type\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t<input type=\"hidden\" name=\"consider_stock_for_pres_yn\" id=\"consider_stock_for_pres_yn\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_pres_without_stock_yn\" id=\"allow_pres_without_stock_yn\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t<input type=\"hidden\" name=\"calc_by_ind\" id=\"calc_by_ind\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t<input type=\"hidden\" name=\"dosage_std\" id=\"dosage_std\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t<input type=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\t\t\n\t\t\t<input type=\"hidden\" name=\"recomm_yn\" id=\"recomm_yn\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" name=\"pres_base_uom\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" name=\"split_chk\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" name=\"freq_nature\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" name=\"ext_prod_id\">\n\t\t\t<input type=\"hidden\" name=\"con_reason\" id=\"con_reason\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t<input type=\"hidden\" name=\"int_reason\" id=\"int_reason\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"dsg_reason_yn\" id=\"dsg_reason_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" name=\"in_formulary_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" name=\"fract_dose_appl_yn\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"taper_disabled\" id=\"taper_disabled\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" name=\"interaction_exists\">\n\t\t\t<!-- added for aakh-crf-0140 start-->\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" name=\"abuse_override\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" name=\"abuse_drug_override_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" name=\"abuse_override_remarks\">\n\t\t\t\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" name=\"abuse_action\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" name=\"abuse_exists\">\n\t\t\t<!-- added for aakh-crf-0140 end-->\n\t\t\t\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" name=\"intr_restric_trn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" name=\"intr_msg_content\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" name=\"interaction_override\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" name=\"interaction_remarks\">\n\t\t\t<input type=\"hidden\" value=\"disabled\" name=\"freq_status\" id=\"freq_status\"><!-- added for ML-BRU-SCF-0725 [IN:038336] -->\n\t\t\t<input type=\"hidden\" value = \"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" name = \"billable_item_yn\"> \n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" name=\"diagnosis_found_yn\"><!-- Added for MMS-DM-CRF-0239 -->\n\t\t\t<input type=\"hidden\" value = \"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" name = \"dosage_unit_uom\"> <!-- added for SKR-SCF-1337 -->  \n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" name=\"all_durn_type_app\" > <!-- ML-MMOH-CRF-1531-->\n\t\t\t<input type=\"hidden\" value=\"\" name=\"def_durn_type\" id=\"def_durn_type\" ><!-- ML-MMOH-CRF-1531-->\n\t\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n\t\t</form>\n\t</body>\n<!-- setting schedule values-->\n";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n<script>\n";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\tshowDiagnosisAlert();\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\tgetFormatIdAmend()\n\t\tcheckWtAndHt(document.prescription_amend_detail_form);\n";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\tgetChargeDetails(\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\');\n";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

29/06/2020  	IN073176           Shazana                          					SKR-SCF-1337
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
29/11/2020  	IN:7980	        	Manickavasagam J                                    ML-BRU-SCF-2069
25/05/2023		IN:44863			Sushant Tambe										MMS-DM-CRF-0239
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

Connection con				= null;//added forml-bru-crf-0469
try{
	String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id"); 
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String in_mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String srl_no			= request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String priority			= request.getParameter("priority")==null?"":request.getParameter("priority");
	String drug_db_interface_yn      =  request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String priority_disp = "";
	String uom_disp = "";
	//String drug_db_dosage_check_yn      =  request.getParameter("drug_db_dosage_check_yn")==null?"":request.getParameter("drug_db_dosage_check_yn");
	//String drug_db_duptherapy_check_yn	= request.getParameter("drug_db_duptherapy_check_yn")==null?"":request.getParameter("drug_db_duptherapy_check_yn");
	//String drug_db_contraind_check_yn	= request.getParameter("drug_db_contraind_check_yn")==null?"":request.getParameter("drug_db_contraind_check_yn");
	//String drug_db_interact_check_yn	= request.getParameter("drug_db_interact_check_yn")==null?"":request.getParameter("drug_db_interact_check_yn");
	//String drug_db_allergy_check_yn= request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");

	if(priority!=null && priority.equals("R"))
		priority_disp	=	"Routine";
	else
		priority_disp	=	"urgent";
	if(priority.equalsIgnoreCase("Routine"))
		priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	else if(priority.equalsIgnoreCase("urgent"))
		priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
	orbean.setLanguageId(locale);
	//corrected for PE By Naveen
	//int take_home					=	bean.getHomeMecdicationYn(encounter_id,facility_id);
     int take_home					=	(int)bean.getTakeHomeCount();

	String order_id			= (String) orbean.getOrderId();
	String order_line_num="";
	String called_from		=	orbean.getCalledFromFunction();
	ArrayList drugData		= (ArrayList) bean.getpresDetails();
	String consider_stock_for_pres_yn	=	"";
	String allow_pres_without_stock_yn	=	"";

	String display			= "display:none";
	String drug_code		= "";
	String drug_desc		= "";
	String route_code		= "";
	String route_desc		= "";
	String freq_code		= "";
	String freq_desc		= "";
	String qty_value		= "";
	String dosage_type		= "";
	String durn_value		= "";
	String renew_durn_value = "";//ML-BRU-SCF-2069
	String durn_desc		= "";
	String split_dose		= "";
	String drug_start_date	= "";
	String drug_end_date	= "";
	String no_refill		= "";
	String form_desc		= "";
	String strength_value	= "";
	String strength_uom		= "";
	String prescribed_mode	= "";
	String qty_legend		= "";
	String scheduled_yn		= "";
	String durn_val_dis		= "";
	String qty_val_dis		= "";
	String durn_type		= "";
	String repeat_value		= "";
	String interval_value	=	"";
	String patient_class	= "";
	String order_type_code	= "";
	String form_code		= "";
	String repeat_durn_type	= "";
	String qty_desc_dis		= "";
	String qty_desc_code	= "";
	String min_daily_dose	= "";
	String min_unit_dose	= "";
	String dup_start_date	= "";
	String dup_end_date		= "";
	String strength_field	=	"";
	String pres_remarks		=	"";
	String srlNo			=	"";
	String  override_yn		=	"N";
	String  generic_id		=	"";
	String calc_by_ind		=	"";
	String dosage_std		=	"";
	String dosage_unit		=	"";
	String recomm_yn		=	"";
	String split_dose_yn	=	"N";
	String pres_base_uom="";
	String ext_prod_id="";
	String fract_dose_round_up_yn = "";
	String strength_per_pres_uom = "";
	String strength_per_value_pres_uom = "";
	String trade_code= "";
	String trade_name = "";
	String	in_formulary_yn	= "";
	String	item_code	= "";
	int dose_decimal = 6;

	ArrayList admin_time	=	new ArrayList();
	ArrayList admin_qty		=	new ArrayList();
	//ArrayList stock_params	=	new ArrayList(2);
	String adtime			=	"";
	String disp_locn_code	=	"";
	String disp_locn_desc	=	"";
	String current_rx		=	"N";
	String allergy_yn		=	"N";
	String limit_ind		=	"Y";
	String stock_uom		=	"";
	String absol_qty		=	"";
	boolean split_chk		=	false;
	String freq_nature		=	"";
	String dup_drug_desc	=	"";
	String dosage_option	=	"";
	String remarks_style	=	"visibility:hidden";
	String order_qty_status	=	"disabled";
	String DrugRemarksEntered			=	""; //Added for Antibiotic Screen using Order Entry Format ICN 29904

	String	dsg_reason		= "";
	String	dup_reason		= "";
	String con_reason = "";
	String int_reason = "";
	String	alg_reason			= "";

	String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");

	String bl_incl_excl_override_reason_code ="";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind = "";
	String bl_override_excl_incl_ind = "";
	String bl_override_allowed_yn = "";
	String trade_display_yn = "", billable_item_yn="", fract_dose_appl_yn="", interaction_exists="", intr_restric_trn="", intr_msg_content="",  interaction_override="", interaction_remarks="", buildMAR_yn="", buildMAR_checked="";
	String abuse_exists	=	"", abuse_restric_trn="N", abuse_msg_content="", abuse_override ="" ;//added for AAKH-CRF-140
	String abuse_drug_override_reason="",abuse_action="";//added for AAKH-CRF-140

	String MAR_app_yn    = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	trade_display_yn = request.getParameter("trade_display_yn")==null?"N":request.getParameter("trade_display_yn");
	String validate_overide_on_confirm_yn="N";//Added for IN:069887  
	String diagnosis_found_yn="";//Added for MMS-DM-CRF-0239
	 con						= ConnectionManager.getConnection(request);//added for ml-bru-crf-0469
	boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
	boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//Added for IN:069887 		
	boolean all_durn_type_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ALL_DURN_TYPE_APP"); //added for ML-MMOH-CRF-1531
	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");
	
	if(called_from.equals("RENEW_ORDER")) {
		mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		strength_field	=	"disabled";	
	}
	//Added for IN:069887 start
		if(validate_overide_on_confirm){
			validate_overide_on_confirm_yn="Y";
		}
		//Added for IN:069887  end
	HashMap drugDetails	=	null;
	if(in_mode!=null && in_mode.equals("amend")){
		if(drugData.size()>0){
			for(int i=0;i<drugData.size();i++){
				drugDetails =(HashMap)drugData.get(i);
				srlNo				= (String) drugDetails.get("SRL_NO");
				if(srlNo.equals(srl_no)){
					drug_code			= (String) drugDetails.get("DRUG_CODE");
					ext_prod_id		=	(String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
					drug_desc			= (String) drugDetails.get("CATALOG_DESC");		
					form_desc			= (String) drugDetails.get("FORM_DESC");	
					generic_id			= (String) drugDetails.get("GENERIC_ID");	
					route_desc			= (String) drugDetails.get("ROUTE_DESC");	
					freq_code			= (String) drugDetails.get("FREQ_CODE");	
					freq_desc			= (String) drugDetails.get("FREQ_DESC");		
					qty_value			= (String) drugDetails.get("QTY_VALUE");		
					
					qty_desc_dis		= (String) drugDetails.get("QTY_DESC");	
					qty_desc_code		= (String) drugDetails.get("QTY_DESC_CODE");	
					durn_value			= (String) drugDetails.get("DURN_VALUE");		
					durn_desc			= (String) drugDetails.get("DURN_DESC");	
					drug_start_date		= (String) drugDetails.get("START_DATE_TIME");
					drug_end_date		= (String) drugDetails.get("END_DATE_TIME");
					if(called_from.equals("RENEW_ORDER")) {
						order_id		= (String) drugDetails.get("ORDER_ID");
						order_line_num	= (String) drugDetails.get("ORDER_LINE_NUM");
					}
					//if(!locale.equals("en")){
					//	drug_start_date		= DateUtils.convertDate(drug_start_date, "DMYHM","en",locale);
					//	drug_end_date		= DateUtils.convertDate(drug_end_date, "DMYHM","en",locale);
					//}
					
					no_refill			= (String) drugDetails.get("NUM_OF_REFILLS");
					if(no_refill ==null || no_refill.equals("0")){
						no_refill="";
					}
					strength_value		= (String) drugDetails.get("STRENGTH");
					strength_uom		= (String) drugDetails.get("STRENGTHUOM");
					prescribed_mode		= (String) drugDetails.get("PRESCRIBED_MODE");
					split_dose			= (String) drugDetails.get("SPLIT_DOSE_PREVIEW");
					split_dose_yn		= (String) drugDetails.get("SPLIT_DOSE_YN");
					durn_type			= (String) drugDetails.get("DURN_TYPE");
					repeat_value		= (String) drugDetails.get("REPEAT_VALUE");
					interval_value		= (String)drugDetails.get("INTERVAL_VALUE");
					durn_type			= (String) drugDetails.get("DURN_TYPE");
					patient_class       = (String) drugDetails.get("PATIENT_CLASS");
					order_type_code		= (String) drugDetails.get("ORDER_TYPE_CODE");
					form_code			= (String) drugDetails.get("FORM_CODE");
					route_code			= (String) drugDetails.get("ROUTE_CODE");
					repeat_durn_type	= (String) drugDetails.get("REPEAT_DURN_TYPE");	
					pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
					fract_dose_round_up_yn =  (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					
					scheduled_yn		= (String) drugDetails.get("SCHEDULED_YN");
					stock_uom			= (String)drugDetails.get("STOCK_UOM_DESC");
					absol_qty			= (String)drugDetails.get("ORDER_QTY");
					dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
					freq_nature			= (String)drugDetails.get("FREQ_NATURE");
					recomm_yn			= ((String)drugDetails.get("RECOMM_YN"));
					calc_by_ind			= (String)drugDetails.get("CALC_BY_IND");
					dosage_std			= (String)drugDetails.get("DOSAGE_STD");
					dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
					trade_code			= (String)drugDetails.get("TRADE_CODE")==null?"":(String)drugDetails.get("TRADE_CODE");
					trade_name			= (String)drugDetails.get("TRADE_NAME")==null?"":(String)drugDetails.get("TRADE_NAME");
					in_formulary_yn		= (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
					item_code		= (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
					DrugRemarksEntered		= (String)drugDetails.get("DrugRemarksEntered")==null?"":(String)drugDetails.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
					
					if(req_diag_pres_found){
						diagnosis_found_yn= (String) drugDetails.get("DIAGNOSIS_FOUND_YN");//Added for MMS-DM-CRF-0239	
					}
					else{
						diagnosis_found_yn="G";//Added for MMS-DM-CRF-0239
					}
					
							
					billable_item_yn  =  (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y": (String)drugDetails.get("BILLABLE_ITEM_YN"); 
					fract_dose_appl_yn = (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					interaction_exists = (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
					//added for AAKH-CRF-140 start
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");
					abuse_drug_override_reason=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason");
					System.out.print("abuse_override prescriptiondetails_2"+abuse_override);
					System.out.print("abuse_drug_override_reason   prescriptiondetails_2"+abuse_drug_override_reason);
					//added for AAKH-CRF-140 end
					intr_restric_trn = (String)drugDetails.get("INTR_RESTRIC_TRN")==null?"":(String)drugDetails.get("INTR_RESTRIC_TRN");
					intr_msg_content = (String)drugDetails.get("INTR_MSG_CONTENT")==null?"":(String)drugDetails.get("INTR_MSG_CONTENT");
					interaction_override = (String)drugDetails.get("INTERACTION_OVERRIDE")==null?"":(String)drugDetails.get("INTERACTION_OVERRIDE");
					if(drugDetails.get("INTERACTION_REMARKS") !=null && !((String)drugDetails.get("INTERACTION_REMARKS")).equals("")){
						interaction_exists="Y";
						interaction_remarks=(String)drugDetails.get("INTERACTION_REMARKS");
					}
					buildMAR_yn	= (String) (drugDetails.get("BUILDMAR_YN") == null?"N":drugDetails.get("BUILDMAR_YN"));
					if(buildMAR_yn.equals("Y") && MAR_app_yn.equals("Y"))
						buildMAR_checked ="Checked";

					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn =(String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code =(String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
						bl_def_override_excl_incl_ind = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");  
						bl_override_excl_incl_ind = (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");    
						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
					}
					consider_stock_for_pres_yn	=	(String)drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
			        allow_pres_without_stock_yn	=	(String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");
					//stock_params		=	bean.validateForStock(patient_class);
					if(freq_nature.equals("P")){
						order_qty_status	=	"";
					}
					if(strength_value==null || strength_value.equals("0")||strength_value.trim().length()==0) {//Added for Bru-HIMS-CRF-400
						strength_value = "0";
						strength_value = Float.parseFloat(strength_value) +"" ;
						strength_uom		=	"";
					}
					if(drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON") !=null && !((String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON")).equals("")){
						limit_ind="N";
						dsg_reason=(String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON");				
					}
					if(drugDetails.get("ALLERGY_OVERRIDE_REASON") !=null && !((String)drugDetails.get("ALLERGY_OVERRIDE_REASON")).equals("")){
						allergy_yn="Y";
						alg_reason=(String)drugDetails.get("ALLERGY_OVERRIDE_REASON");
					}
					if(drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON") !=null && !((String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON")).equals("")){
						current_rx="Y";
						dup_reason = (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON");
					}
					strength_per_pres_uom			=  (String)drugDetails.get("STRENGTH_PER_PRES_UOM");            
					strength_per_value_pres_uom =  (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					con_reason					 =   (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON")==null?"": (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON");
					int_reason					 =   (String)drugDetails.get("INTERACTION_OVERRIDE_REASON")==null?"": (String)drugDetails.get("INTERACTION_OVERRIDE_REASON");
					if(scheduled_yn!=null && scheduled_yn.equals("Y") && !called_from.equals("RENEW_ORDER")){
						durn_val_dis="disabled";
						qty_val_dis="disabled";			
					}
					else{
						durn_val_dis="";
						qty_val_dis="";			
					}
					disp_locn_code = (String) drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc = (String) drugDetails.get("DISP_LOCN_DESC");
					if(prescribed_mode!=null && prescribed_mode.equals("A")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absolute.label","common_labels");
					}
					else if(prescribed_mode!=null && prescribed_mode.equals("Q")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Dose.label", "ph_labels");
					}
					else{
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");				
					}
					if(split_dose!=null && !split_dose.equals("")&& split_dose_yn.equals("Y")){
						qty_legend="Divided Dose";
						StringTokenizer	 vals	=	new StringTokenizer(split_dose,"|");
						adtime = adtime +"<table border=1 cellpadding=0 cellspacing=0 align=center>";
						while(vals.hasMoreTokens()) {
							String code		= (String)vals.nextToken();
							code=code+"=";
							StringTokenizer	 inner_vals	=	new StringTokenizer(code,"=");
							int j=0;
							while(inner_vals.hasMoreTokens()) {
								if(j%2==0){
									String time		= (String)inner_vals.nextToken();
									admin_time.add(time);
									if(!time.trim().equals("")){
										adtime = adtime + "<tr>";
										String att=" class=TIPS";
										adtime = adtime +"<td "+att+">&nbsp;"+time+"&nbsp;</td>";
										//adtime+="</tr>";
									}
								}
								else{
									String qty		= (String)inner_vals.nextToken();
									if(admin_qty.size()!=0 && !admin_qty.contains(qty)) {
										split_chk	=	true;
									}
									admin_qty.add(qty);
									if(!qty.equals("")){
										//adtime+="<td>";
										String att=" class=TIPS";
										adtime = adtime + "<td "+att+">&nbsp;"+qty+"&nbsp;</td>";
										adtime = adtime + "</tr>";
									}
								}
								j++;				
							 }
						}
						adtime =adtime +"</TABLE>";
					}
					break;
				}
			}
		}
	}
	/*	if(current_rx.equals("Y") || allergy_yn.equals("Y") || limit_ind.equals("N")){
			display="";
			override_yn="Y";
		}*/
		if(drug_db_interface_yn.equals("Y")){
			display="display:none";
			override_yn="N";
		}
		else{
			if(current_rx.equals("Y") || allergy_yn.equals("Y") || limit_ind.equals("N") || (abuse_exists.equals("Y")&&abuse_action.equals("B"))){//modified for AAKH-CRF-140
				display="display:inline";
				override_yn="Y";
			}
		}
		// Current Rx 
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
		StringBuffer drug_description	=	new StringBuffer();
		int size						=	active_orders.size();
		HashMap	record					=	new HashMap();
		for(int i=0; i<size; i++)	{
			record					=	(HashMap)active_orders.get(i);
			drug_description.append((String)record.get("drug_desc"));
			drug_description.append(" , ");
		}*/

		if(drugDetails!=null && drugDetails.get("AMENDED_YN")==null) {

// added for ML-BRU-SCF-2069 - start
			renew_durn_value = durn_value;
			if(durn_type.equals("W"))
				renew_durn_value = (Integer.parseInt(durn_value)*7)+"";
			else if(durn_type.equals("L"))
				renew_durn_value = (Integer.parseInt(durn_value)*30)+"";
			else if(durn_type.equals("Y"))
				renew_durn_value = (Integer.parseInt(durn_value)*365)+"";
// added for ML-BRU-SCF-2069 - end
			ArrayList renew_dates	=	(bean.getRenewDates(renew_durn_value,order_id,drug_code));//changed durn_value to renew_durn_value for ML-BRU-SCF-2069
			if(renew_dates.size()==2) {
				drug_start_date	=	(String)renew_dates.get(0);
				drug_end_date	=	(String)renew_dates.get(1);
			}
		}
		if(!locale.equals("en")){
			drug_start_date		= DateUtils.convertDate(drug_start_date, "DMYHM","en",locale);
			drug_end_date		= DateUtils.convertDate(drug_end_date, "DMYHM","en",locale);
		}
		if(called_from.equals("RENEW_ORDER")) {
			//bean.setOldOrder(drug_code,order_id+","+presBean.getLineNo(order_id,drug_code));
			bean.setOldOrder(drug_code , order_id+","+order_line_num);
		}
		if(admin_qty.size()!=0 && split_chk) {
			qty_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SplitDose.label", "ph_labels");
		}
		else if(admin_qty.size()!=0 && !split_chk) {
			qty_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ScheduledDose.label", "ph_labels");
		}
		// Drug Remarks - Start
		String line_no			=	presBean.getLineNo(order_id,drug_code);
		ArrayList drug_remarks	=	bean.getPrescribedRemarks(order_id,line_no);
		if(drug_remarks.size()!=0) { 
			for(int x=0; x<drug_remarks.size(); x++) {	
				if(x==(drug_remarks.size()-1)) {	
					pres_remarks	= pres_remarks + (String)drug_remarks.get(x);
				} 
				else {
					pres_remarks	= pres_remarks + (String)drug_remarks.get(x)+",";
				}
			} 
		} 
		if(!pres_remarks.equals(""))
			remarks_style	="visibility:visible";
		// Drug Remarks - End
		//Start Duplicate- Dates
		ArrayList duplicate_dates	=	presBean.getDuplicateDates(patient_id,drug_code,DateUtils.convertDate(drug_start_date, "DMYHM",locale,"en"));
		if(duplicate_dates.size()==2) {
			dup_start_date	=	(String)duplicate_dates.get(0);
			dup_end_date	=	(String)duplicate_dates.get(1);
		}
		// End Duplicate Dates

		if(presBean.duplicateRecord(dup_start_date,dup_end_date,drug_start_date,DateUtils.convertDate(drug_end_date, "DMYHM",locale,"en"))) {
			dup_drug_desc		=	drug_desc;
		 }
		if(!locale.equals("en")){
			dup_start_date		= DateUtils.convertDate(dup_start_date, "DMYHM","en",locale);
			dup_end_date		= DateUtils.convertDate(dup_end_date, "DMYHM","en",locale);
		}
		// Legend and dosage unit is controlled based on dosage type
		if(dosage_type.equals("A")){
			dosage_option	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Absolute.label", "common_labels");
		}
		else if(dosage_type.equals("S")){
			dosage_option	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");
		}
		else if(dosage_type.equals("Q")){
			dosage_option	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels");
		}
		// stock flags 
		//commented during PE By Naveen added in drug details
		/*if(stock_params.size()==2) {
			consider_stock_for_pres_yn	=	(String)stock_params.get(0);
			allow_pres_without_stock_yn	=	(String)stock_params.get(1);
		}*/
		if(priority.equalsIgnoreCase("Routine") || priority.equalsIgnoreCase("R"))
			priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		else //if(priority.equalsIgnoreCase("urgent"))
			priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(priority_disp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

						uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_uom);
						if(uom_disp == null || uom_disp.equals("null"))
							uom_disp = "";
					 	//added for NMC-JD-CRF-0026  
						if(strength_display_app){
							if(strength_value!=null && strength_value!="" && !strength_value.equals("0.0")){
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(uom_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block33Bytes, _wl_block33);
} else{ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(uom_disp));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
				if(trade_display_yn.equals("Y")){

            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
				}
				else
					trade_code="";

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dosage_option));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
						if(split_dose_yn!=null && split_dose_yn.equals("Y")) {	

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adtime));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(qty_legend));
            _bw.write(_wl_block53Bytes, _wl_block53);
	
						}
						else{	

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(qty_legend));
            _bw.write(_wl_block53Bytes, _wl_block53);

						}	
						if(qty_value != null && qty_value != "" && Float.parseFloat(qty_value) < 1.0)
							qty_value = Float.parseFloat(qty_value)+"";

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(durn_val_dis));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strength_field));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty_desc_dis));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(qty_desc_dis));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);

						if(split_dose_yn.equals("N")){

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

						}
						else{

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

						}

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
 
					String durn_change = "";
					if(freq_nature.equals("O")){
						durn_change = "ReadOnly Disabled";
					}

            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(qty_val_dis));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( durn_change));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(durn_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(order_qty_status));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(drug_start_date));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(drug_end_date));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(display));
            _bw.write(_wl_block88Bytes, _wl_block88);

			//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 

            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(disp_locn_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block91Bytes, _wl_block91);

		/*	} 
			else {*/

            _bw.write(_wl_block92Bytes, _wl_block92);

			//}

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block98Bytes, _wl_block98);

			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") ));
            _bw.write(_wl_block100Bytes, _wl_block100);

			}

            _bw.write(_wl_block101Bytes, _wl_block101);
//added forml-bru-crf-0469
								if(displayGrossAmtYn){ 
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{ 
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
   }	 
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
//added forml-bru-crf-0469	
							if(displayGrossAmtYn){ 
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
}
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);

								String include_selected ="";  
								String exclude_selected =""; 	
								String Select_selected ="";
								if(bl_override_excl_incl_ind.equals("I")){
									include_selected ="selected";
								}
								else if(bl_override_excl_incl_ind.equals("E")){
									exclude_selected ="selected";
								}
								else {
									Select_selected ="selected";
								}

            _bw.write(_wl_block115Bytes, _wl_block115);

								if(bl_override_allowed_yn.equals("I")){

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

								}
								if(bl_override_allowed_yn.equals("E")){

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

								}
								if(bl_override_allowed_yn.equals("B")){

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

								}
								if(bl_override_allowed_yn.equals("")){

            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

								}

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bl_def_override_excl_incl_ind));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bl_override_allowed_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(bl_incl_excl_override_reason_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);

								if(bl_incl_excl_override_reason_desc.equals("")){
									

            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block131Bytes, _wl_block131);

								}
								else{

            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block133Bytes, _wl_block133);

								}

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bl_incl_excl_override_reason_code));
            _bw.write(_wl_block135Bytes, _wl_block135);
//added forml-bru-crf-0469
								if(displayGrossAmtYn){ 
            _bw.write(_wl_block136Bytes, _wl_block136);
	} else{ 
            _bw.write(_wl_block137Bytes, _wl_block137);
} 
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(repeat_value));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(prescribed_mode));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(dup_start_date));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(dup_end_date));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dup_drug_desc));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(consider_stock_for_pres_yn));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(allow_pres_without_stock_yn));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(split_chk));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(fract_dose_appl_yn));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(abuse_override));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(abuse_drug_override_reason));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(abuse_drug_override_reason));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(abuse_action));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(abuse_exists));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(intr_restric_trn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(interaction_override));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(billable_item_yn));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(diagnosis_found_yn));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(presBean.getUOMDesc(dosage_unit)));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(all_durn_type_app));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block202Bytes, _wl_block202);

	if(in_mode!=null && in_mode.equals("amend")){
		Hashtable sch_output	=	null;//Removed new HashTable for BRU-HIMS-crf-400
	 	ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		Hashtable schedule_val	=	null; 
		if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
			schedule_val	=	new Hashtable();
			ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request );
			schedule_bean.setLanguageId(locale);
			schedule_val.put("facility_id", (String)session.getValue("facility_id"));
			schedule_val.put("start_time_day_param", drug_start_date);
			schedule_val.put("module_id", "PH"); 
			schedule_val.put("split_dose_yn", split_dose_yn); 
			schedule_val.put("split_qty",qty_value);
			schedule_val.put("freq_code",  freq_code );
			schedule_val.put("code",drug_code+srl_no);
			sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
			sch_output.put("code",drug_code+srl_no);
			sch_output.put("row_value",srl_no);
			sch_output.put("start_date_time",drug_start_date);
			//bean.setScheduleFrequencyStr(sch_output);
			putObjectInBean(sch_bean_id,schedule_bean,request);
		} 
		/*sch_output.put("code",drug_code+srl_no);
		sch_output.put("row_value",srl_no);
		sch_output.put("start_time_assign","");
		sch_output.put("day_value","7");
		sch_output.put("durationType","D");
		sch_output.put("daySM7","7");
		sch_output.put("daySM6","6");
		sch_output.put("daySM5","5");
		sch_output.put("daySM4","4");
		sch_output.put("daySM3","3");
		sch_output.put("daySM2","2");
		sch_output.put("daySM1","1");
		sch_output.put("error","");
		sch_output.put("repeat",repeat_value);
		sch_output.put("dayDisplay7","Sat");
		sch_output.put("dayDisplay6","Fri"); 
		sch_output.put("dayDisplay5","Thu"); 
		sch_output.put("displayHrs6","6");
		sch_output.put("dayDisplay4","Wed");
		sch_output.put("displayHrs5","5"); 
		sch_output.put("dayDisplay3","Tue"); 
		sch_output.put("displayHrs4","4"); 
		sch_output.put("dayDisplay2","Mon"); 
		sch_output.put("displayHrs3","3"); 
		sch_output.put("dayDisplay1","Sun"); 
		sch_output.put("displayHrs2","2"); 
		sch_output.put("displayHrs1","1");
		sch_output.put("start_day_assign","");	*/		

		if(sch_output!=null) {
			ArrayList values	=	presBean.getFreqDet(order_id,line_no);
			ArrayList freqCharctValues = new ArrayList();
			ArrayList day_list = new ArrayList();
			ArrayList day_names = new ArrayList();
			ArrayList time_list = new ArrayList();
			ArrayList dose_list = new ArrayList();
			ArrayList<String> week_days	= new ArrayList<String>();
			ArrayList tmp_freq_values					= new ArrayList();
			String temp="";
			week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(drug_start_date, "DMYHM",locale, "en")); 
			freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	
			for(int p=0; p<values.size(); p+=4) {
				time_list.add(values.get(p));
				dose_list.add(values.get(p+1));
				day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
			}
			if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
				for(int j=0;j<day_list.size();j++){
					if(!day_list.get(j).equals("")){
						temp = (String)day_list.get(j);
						if (temp == null || temp.equals("")){
							temp = "0";
						}
						if (!temp.equals("0")){
							day_names.add(week_days.get((Integer.parseInt(temp))-1));
						}
					}
				}
			}
			tmp_freq_values.add(freqCharctValues.get(0));
			tmp_freq_values.add(day_list);
			tmp_freq_values.add(day_names);
			tmp_freq_values.add(time_list);
			tmp_freq_values.add(dose_list);
			sch_output.put(drug_code+srl_no,tmp_freq_values);
			bean.setScheduleFrequencyStr(sch_output);
			schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
		}
		/*int incr=0;
		for(int p=0; p<values.size(); p+=3) {
			incr++;
			sch_output.put("time"+(incr),values.get(p));
			sch_output.put("qty"+(incr),values.get(p+1));				
		}
		if(incr<=6) {
			for(int q=(incr+1); q<=6; q++) {
				sch_output.put("time"+(q),"0");
				sch_output.put("qty"+(q),"0");
			}
		}
		bean.setScheduleFrequencyStr(tmp_freq_values);*/
		if(bean.checkSplit(schedule)) {
			drugDetails.put("SPLIT_DOSE_YN","Y");
		} 
		else {
			drugDetails.put("SPLIT_DOSE_YN","N");
		}
	}

            _bw.write(_wl_block203Bytes, _wl_block203);
  //Added for MMS-DM-CRF-0239 start
	if(req_diag_pres_found && diagnosis_found_yn.equals("N")){

            _bw.write(_wl_block204Bytes, _wl_block204);
	}//Added for MMS-DM-CRF-0239 end

	if(!in_mode.equals("blank")){

            _bw.write(_wl_block205Bytes, _wl_block205);
	
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block207Bytes, _wl_block207);

		}
	}
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
	putObjectInBean(presBean_id,presBean,request);
}
catch(Exception e){
	e.printStackTrace();
}
finally{//added forml-bru-crf-0469
	

	if(con != null)
		ConnectionManager.returnConnection(con,request);

}

            _bw.write(_wl_block208Bytes, _wl_block208);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugProfile.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetail.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DurationDetail.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalChargeAmount.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalPayableAmount.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalReqd.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
