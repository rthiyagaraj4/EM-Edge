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

public final class __prescriptionamenddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionAmendDetail.jsp", 1742386532081L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n \t\t<!--<script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script> -->\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script> \n\t\t <!--<script language=\"JavaScript\" src=\"../../eCommon/js/PhCommon.js\"></script>-->\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n  \t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/Prescription_2.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"prescription_amend_detail_form\" id=\"prescription_amend_detail_form\" >\n\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" name=\"bean_id\"  id=\"bean_id\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" name=\"bean_name\" id=\"bean_name\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=\"presBean_id\" id=\"presBean_id\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\"presBean_name\" id=\"presBean_name\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td  width=\"15%\">\n\t\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onClick=\"javascript:callActiveOrders(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\"></td>\n\t\t\t\t\t<td class=\"CURRTEXT\"  width=\"85%\">&nbsp;\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\"  width=\"15%\"><input type=\'button\' class=\'button\' onClick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'Prescription\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'></td>\n\t\t\t\t\t <!-- ,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' Added for AAKH-CRF-0088.2/04 IN[62870] -->\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"  width=\"12%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t<td class=\"data\"  width=\"40%\" colspan=\"3\"><input type=\"text\" name=\"drug_name\" id=\"drug_name\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" disabled size=\"50\"><img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\">\n\t\t\t\t\t\t\t\t<!--    added for CRF RUT-CRF-0063[29601]--start -->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" name=\"preg_alert\" value=\"\" src=\"../../ePH/images/Pregnancy.bmp\" height=\'20\'  width=\'20\'                      onClick=\"chkPregnencyAlertForAmend();\"></img>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n               <!--    added for CRF RUT-CRF-0063[29601]--end --></td>\n\t\t\t\t\t<td class=\"label\"  width=\"5%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t<td class=\"label\"  width=\"30%\"><input type=\"text\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" size=\"10\" disabled>&nbsp;&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"  width=\"12%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"data\"  width=\"18%\"><input type=\"text\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" disabled size=\"7\" class=\"NUMBER\">&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" / ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<td class=\"label\"   width=\"18%\"><input type=\"hidden\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<td class=\"data\"  width=\"18%\"><input type=\"text\" name=\"strength_value\" id=\"strength_value\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<!--  added for NMC-JD-CRF-0026 end -->\n\t\t\t\t\t<td class=\"label\"  width=\"32%\" colspan=\"2\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;&nbsp;<input type=\"text\" name=\"form_desc\" id=\"form_desc\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" disabled size=\"10\"></td>\n\t\t\t\t\t<td class=\"label\"  width=\"5%\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\"data\" id=\"strength\" width=\"30%\">\n\t\t\t\t\t\t&nbsp;&nbsp;<select name=\'route\' id=\'route\' onchange=\"routeChange(this);getActionText(this,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="> <!-- add getActionText function for SKR-CRF-0006[IN029561]-->\n\t\t\t\t\t\t<!-- Code Added for CRF 0034 Start -->\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t<option style= \'color:";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =";background-color:";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =";\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' selected>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n<!-- Code Added for CRF 0034 End -->\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<td class=\"label\"  width=\"22%\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t<td class=\"data\"  width=\"18%\"><input type=\"text\" name=\"trade_name\" id=\"trade_name\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" disabled size=\"7\" class=\"NUMBER\">\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;<!--added for alignment issue for SKR-CRF-0006 ICN 29561 -->\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'trade_code\' id=\'trade_code\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" colspan=\'3\'> &nbsp;</td>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- added this label  for SKR-CRF-0006[IN029561] -->\n\t\t\t\t\t\t<td class=\'label\' >&nbsp;<label style=\'color:red;\' id=\"actionTextval\"   > ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="   </label></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\"label\">\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="  onclick=\'assignValue(this);\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =">\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;\n\t\t\t\t    \t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\"N\" disabled >\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<!-- &nbsp;<input type=\'hidden\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\'> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'allow_alternate_yn\' id=\'allow_alternate_yn\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="  disabled >\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\t\t\t\t </td>\n\t\t\t\t\t<!--<td class=\"label\" >&nbsp;&nbsp;<img src=\"../../eOR/images/Authorization.gif\" id=\"requires_auth_gif\"   style=\"visibility:hidden\" onclick=\"chkAuthorization(\'auth\')\"></img></td> -->\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<td  class=\"label\"><label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =";";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</label></td>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<td class=\"label\"  align=\'center\' colspan=\'2\'><label id=\'lbl_splapprvl\' style=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_cosign\' style=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</label></td>\n\t\t\t\t\t <td class=\"fields\" ><a href=\"javascript:viewReasonforRequest(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" id=\"tdm_details\" style=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" style=\"font-size:9\"title=\"TDM result\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t<td  class=\"label\">&nbsp;&nbsp;<select name=\"dosage\" id=\"dosage\" onChange=\"dosageChange(this);\" style=\"width:100;\"  disabled>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;---";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="---&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\"  colspan=\"2\" id=\"dosage_label\">&nbsp;<font color=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' onmouseover=\"displayamendToolTipDataChange(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\');\" onmouseout=\"disasbleamendToolTipDataChange();\" >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t<td class=\"label\" >&nbsp;&nbsp;<input type=\"text\" name=\"qty_value\" id=\"qty_value\" size=\"3\" maxlength=\"13\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" onKeyPress=\"return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =");\" onblur=\"lookForChange(this);\" ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="  ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="></td>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t<td class=\"label\"  >&nbsp;&nbsp;<input type=\"text\" name=\"qty_value\" id=\"qty_value\" size=\"10\" maxlength=\"13\" class=\"NUMBER\" ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =");\" onblur=\"changedoseoverridevalue();\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="  value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =">\n\t\t\t\t\t\t</td>\t   <!--removed call to freqChange(freq_desc,\'Y\'); on blur --priya  for IN18928 -- 22/02/2010 -->\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t<td class=\'fields\'>\t\t\n\t\t\t\t\t\t<select name=\"qty_desc\" id=\"qty_desc\" style=\"width:110;\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr NOWRAP>\n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t\t\t\t<td class=\"label\" COLSPAN=5 >&nbsp;&nbsp;<select name=\"freq_desc\" id=\"freq_desc\" onChange=\"freqChange(this,\'Y\',\'ChangeFreq\')\" style=\"width:480;\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="><!-- modified for SKR-SCF-1302-->\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t<option>&nbsp;&nbsp;---";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t<input id=\"dis_split_dose\" type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'  style=\"visibility:visible\" name=\"split_dose\" onClick=\"DisplaySchedule()\" ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =">\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TR>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<td  class=\"fields\" COLSPAN=2  style=\'TEXT-ALIGN:right;\'>\n\t\t\t\t\t\t<a href=\"javascript:callPRNDetails();\" id=\"prn_remarks\" style=\"visibility:hidden\" title=\"PRN Remarks\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</a><img  style=\"visibility:hidden\"  id=\"prn_remarks_image\" src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t<td class=\'fields\' colspan=\"3\"><a href=\"javascript:setRecommendDosage();\" id=\"rec_legend\" style=\"visibility:hidden\" title=\"Recommended Dosage\" onclick=\"changeschedule();\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</a>\n\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\"></label>\n\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\"></label></td>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t<td colspan=\"3\"><label  id=\"rec_legend\" style=\"font-size:11;font-weight:bold;color:red;visibility:hidden\" >";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</label>\n\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red\"></label>\n\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\"></label></td>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\t\t\t\t\t<td class=\"label\" >&nbsp;&nbsp;<input type=\"text\" size=\"1\" maxlength=\"3\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"  ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" onblur=\"extDosageCheck(\'Modify\');durationConversn(document.prescription_amend_detail_form.durn_desc);getChargeDetails(\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\');\"  onchange=\"maxDurnValidation();assignHomeDuration();checkDuplicateDrug();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\"  ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" >&nbsp;&nbsp;\n\t\t\t\t\t\t<select name=\"durn_desc\" id=\"durn_desc\" onChange=\"maxDurnValidation();durationConversn(this);getChargeDetails(\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =">\n\t\t\t\t\t\t<!-- validateAllDates(); -->\n\t\t\t\t\t\t\t<option>-";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="-</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_value\" id=\"tmp_durn_value\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_desc\" id=\"tmp_durn_desc\"  value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\"  ><label id=\"ord_qty_lbl\" style=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</label></td>\n\t\t\t\t\t<td  class=\"data\" >&nbsp;<input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"5\" name=\"absol_qty\" id=\"absol_qty\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" style=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" onBlur=\"ValidateAbs(this);CheckPositiveNumber(this);getChargeDetails(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\',\'ABS_QTY\'); ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =">&nbsp;<label id=\"ord_qty_uom\" style=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</label></td> ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t<td  class=\'label\' align=\'right\' style=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t\t\t\t\t\t<label id=\"tot_tap_qty_lbl\" style=\"color:red;font-weight:bold;font-size:9;\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</label>&nbsp;&nbsp;\n\t\t\t\t\t<input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"3\" name=\"totTapperQty\" id=\"totTapperQty\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" onchange=\"ValidateAbs(this);getTotalTaperQty(\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\',\'TAPER_QTY\');\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" > &nbsp;&nbsp;<label id=\"taper_qty_uom\"  style=\"font-size:9;\">";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</label></td>\n\t\t\t\t\t<input type=\'hidden\' name=\'prevTotalTaperQty\' id=\'prevTotalTaperQty\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'totalTaperQtyDisplay\' id=\'totalTaperQtyDisplay\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t\t\t\t\t<td  class=\'label\' align=\'right\' style=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>    <!--Added for RUT-CRF-0088 [IN036978]-start  -->\n\t\t\t\t\t\t\t\t<label id=\"tot_tap_qty_lbl\" style=\"color:red;font-weight:bold;font-size:9;\" >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t\t</label>&nbsp;&nbsp;\n\t\t\t\t\t<input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"3\" name=\"totalTapper\" id=\"totalTapper\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</label></td>\n\t\t\t\t<!--Added for RUT-CRF-0088 [IN036978]-end  -->\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\t<td class=\"label\">&nbsp;&nbsp;<input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"13\"  maxlength=\"13\"  value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" disabled></td>\n\t\t\t\t\t<td class=\"label\" colspan=\"2\" nowrap>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="&nbsp;&nbsp;<input type=\"text\" name=\"end_date\" id=\"end_date\" size=\"13\"  maxlength=\"13\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" disabled></td>\n\t\t\t\t\t<td class=\"label\" colspan=\"2\"  style=\"\" >&nbsp;&nbsp;<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'  style=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"dosage_limit\" onclick=\"showAmendOverRideRemarks(prescription_amend_detail_form)\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'override_remarks\' id=\'override_remarks\' value=\'N\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t\t\t\t\t\t<td class=\"label\" >&nbsp;&nbsp;<input type=\"text\" size=\"20\" maxlength=\"20\" name=\"disp_locn_desc\" id=\"disp_locn_desc\" disabled value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">&nbsp;<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"></td>\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t<!-- \t<td class=\"label\"  >&nbsp;</td>\n\t\t\t\t\t\t<td class=\"label\"  ><input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"\"></td> -->\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t<td class=\"label\"  >&nbsp;</td>\n\t\t\t\t\t<td class=\"label\"  >&nbsp;&nbsp;<a href=\"javascript:callOrderAmend();\" id=\"drug_remarks\"  title=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</a>\n\t\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 start-->\n\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 End -->\n\t\t\t\t\t<!--Added for  ML-BRU-CRF-072[Inc:29938] start-->\n\t\t\t\t\t<td class=\"label\" colspan=\"2\">\n\t\t\t\t\t<a href=\"javascript:drugindication_remarksAmend();\" id=\"drug_ind_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\t\n\t\t\t\t\t\t\t\t &nbsp;<img  src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--Added for  ML-BRU-CRF-072[Inc:29938] end-->\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"sql_ph_prescription_bl_action_select_lookup\" id=\"sql_ph_prescription_bl_action_select_lookup\" VALUE=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t<tr >\n\t\t\t\t\t<td colspan=\"6\" >\t\t\t\t\n\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\n\t\t\t\t\t\t\t<tr align=\"left\" id=\'BL_HEADERBAR\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADER\' colspan=\"7\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr id=\'BL_HEADER\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'13%\'>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'11%\' id=\'bl_override_excl_incl_ind_lbl\'>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'27%\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'40%\'>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'13%\' style=\'TEXT-ALIGN:right;\'> ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'15%\' style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'13%\'style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" nowrap width=\'10%\'>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\t</td>\n \t\t\n \t\t\t\t\t\t\t\t<!-- Added for MMS-DM-CRF-0263.2 start -->\n \t\t\t\t\t\t\t\t<td id=\'bl_diagnosis_1\' align=\'center\'>\n \t\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" id=\"bl_diagnosis_h\">&nbsp;\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t\t<!-- Added for MMS-DM-CRF-0263.2 end -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr id=\'BL_VALUES\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t <td align=\'center\' id=\'bl_def_override_excl_incl_ind_gif\'>&nbsp;\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" id=\'td_bl_override_excl_incl_ind\'>\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t<select name=\"bl_override_excl_incl_ind\" id=\"bl_override_excl_incl_ind\" onchange=\"assignOverrideExclInclInd(this)\"  >\n\t\t\t\t\t\t\t<!--<option value=\"SEL\">---";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="---</option> --> \n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t\t     <option value=\"SEL\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =">---";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="---</option>\n\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =">";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="---</option>\n\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 =" >";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t\t    <option value=\"SEL\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="---</option>\n\t\t\t\t\t\t\t    <option value=\"I\" ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</option>\n\t\t\t\t\t\t\t    <option value=\"E\" ";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t\t      <option value=\"SEL\"selected>---";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="---</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_def_override_excl_incl_ind\' id=\'bl_def_override_excl_incl_ind\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_allowed_yn\' id=\'bl_override_allowed_yn\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>\n\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_incl_excl_override_reason_desc\' id=\'bl_incl_excl_override_reason_desc\' size=\'40\'  value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' readonly >\n";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" id=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\');\" disabled><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:hidden;\'></img>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" id=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\');\"><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:visible;\'></img>\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_incl_excl_override_reason_code\' id=\'bl_incl_excl_override_reason_code\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t\t\t<td class=\"data\" id=\'gross_charge_amt\' align=\'center\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t   <td class=\"data\"  id=\'gross_charge_amt\' align=\'center\' style=\'display:none;\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t\t\t\t\t<td class=\"data\" id=\'bl_total_charge_amt\' align=\'right\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" id=\'bl_patient_payable_amt\' align=\'right\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td align=\'center\'id=\'bl_approval_reqd_yn\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"data\" id=\'bl_package_trx_yn\' align=\'center\'> <!--Added for MMS-DM-CRF-0247.7-->\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!--Added for MMS-DM-CRF-0263.2 start-->\n\t\t\t\t\t\t\t\t<td id=\'bl_diagnosis_1\' align=\'center\'>\n\t\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" id=\"bl_diagnosis_v\">&nbsp;\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!--Added for MMS-DM-CRF-0263.2 end-->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t<br>\n\t\t\t<table  border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr><td class=\"white\"  ><label style=\"color:red;font-size:11;font-weight:bold\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</label></td></tr>\n\t\t\t</table>\n\n\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t\t<input type=\"hidden\" name=\"generic_id\" id=\"generic_id\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"generic_name\" id=\"generic_name\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" name=\"allergy_yn\" id=\"allergy_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" name=\"current_rx\"  id=\"current_rx\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" name=\"order_line_num\"  id=\"order_line_num\"><!--Added for the ICN:34834-->\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" name=\"min_unit_dose\" id=\"min_unit_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" name=\"min_daily_dose\" id=\"min_daily_dose\">\n\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" name=\"patient_id\" id=\"patient_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" name=\"encounter_id\" id=\"encounter_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" name=\"drug_code\" id=\"drug_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" name=\"ext_prod_id\" id=\"ext_prod_id\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" name=\"repeat_value\" id=\"repeat_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" name=\"durn_type\" id=\"durn_type\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" name=\"prescribed_mode\" id=\"prescribed_mode\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" name=\"mode\" id=\"mode\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" name=\"limit_ind\" id=\"limit_ind\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" name=\"daily_dose\" id=\"daily_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" name=\"unit_dose\" id=\"unit_dose\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" name=\"mono_graph\" id=\"mono_graph\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" name=\"temp_mono_graph\" id=\"temp_mono_graph\"><!-- Modified for IN:071108 -->\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" name=\"srl_no\" id=\"srl_no\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" name=\"patient_class\" id=\"patient_class\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" name=\"order_type_code\" id=\"order_type_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" name=\"form_code\"  id=\"form_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" name=\"route_code\" id=\"route_code\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" name=\"repeat_durn_type\" id=\"repeat_durn_type\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" name=\"override_yn\" id=\"override_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" name=\"alg_reason\"  id=\"alg_reason\">\n\t\t\t<input type=\"hidden\" value=\"\" name=\"dsg_reason_yn\" id=\"dsg_reason_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" name=\"dsg_reason\" id=\"dsg_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" name=\"dup_reason\" id=\"dup_reason\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" name=\"called_from\" id=\"called_from\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" name=\"dup_start_date\" id=\"dup_start_date\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" name=\"dup_end_date\" id=\"dup_end_date\">\n\t\t\t<input type=\"hidden\" name=\"dosage_type\" id=\"dosage_type\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t\t<input type=\"hidden\" name=\"consider_stock_for_pres_yn\" id=\"consider_stock_for_pres_yn\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_pres_without_stock_yn\" id=\"allow_pres_without_stock_yn\" value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn\" id=\"fract_dose_round_up_yn\" value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\" name=\"in_formulary_yn\">\n\t\t\t<input type=\"hidden\" name=\"strength_per_pres_uom\" id=\"strength_per_pres_uom\" value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t\t\t<input type=\"hidden\" name=\"strength_per_value_pres_uom\" id=\"strength_per_value_pres_uom\" value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t\t<input type=\"hidden\" name=\"con_reason\" id=\"con_reason\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t<input type=\"hidden\" name=\"int_reason\" id=\"int_reason\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" name=\"fract_dose_appl_yn\" id=\"fract_dose_appl_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\" name=\"taper_disabled\" id=\"taper_disabled\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" name=\"interaction_exists\" id=\"interaction_exists\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" name=\"intr_restric_trn\" id=\"intr_restric_trn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" name=\"intr_msg_content\" id=\"intr_msg_content\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" name=\"interaction_override\" id=\"interaction_override\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" name=\"interaction_remarks\" id=\"interaction_remarks\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" name=\"freq_status\" id=\"freq_status\"><!-- added for ML-BRU-SCF-0725 [IN:038336] -->\n\t\t\t<input type=\"hidden\" name=\"take_home_start_date\" id=\"take_home_start_date\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"><!--Added  for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t\t<input type=\"hidden\" name=\"take_home_end_date\" id=\"take_home_end_date\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\"><!--Added  for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t\t<!-- Added for IN:071108 start -->\n       \t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" name=\"max_daily_ceeling_dose\" id=\"max_daily_ceeling_dose\">\n       \t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" name=\"min_daily_ceeling_dose\" id=\"min_daily_ceeling_dose\">\n      \t \t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" name=\"max_unit_ceeling_dose\" id=\"max_unit_ceeling_dose\">\n       \t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" name=\"min_unit_ceeling_dose\"  id=\"min_unit_ceeling_dose\">\n       \t\t<!-- Added for IN:071108 end -->\n       \t\t\n       \t\t <!-- Added for IN:072715 start -->\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" name=\"allergy_remarks_code\" id=\"allergy_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" name=\"dose_remarks_code\" id=\"dose_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" name=\"currentrx_remarks_code\" id=\"currentrx_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" name=\"interaction_remarks_code\" id=\"interaction_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" name=\"food_interaction_remarks_code\"  id=\"food_interaction_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" name=\"lab_interaction_remarks_code\" id=\"lab_interaction_remarks_code\">\n       <!-- Added for IN:072715 end -->\n       \t\t\n";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t<input type=\"hidden\" name=\"dflt_qty_uom\" id=\"dflt_qty_uom\" value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t<input type=\"hidden\" name=\"dflt_qty_uom\" id=\"dflt_qty_uom\" value=\"\">\n";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t\t<input type=\"hidden\" name=\"strength_uom\" id=\"strength_uom\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" name=\"strength_uom_desc\" id=\"strength_uom_desc\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" name=\"tab_qty_value\" id=\"tab_qty_value\">\n\t\t\t<input type=\"hidden\" name=\"calling_mode\" id=\"calling_mode\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">\n\t\t\t<input type=\"hidden\" name=\"split_dose_yn\" id=\"split_dose_yn\" value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" name=\"scheduled_yn\">\n\t\t\t<input type=\"hidden\" name=\"admin_time\" id=\"admin_time\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"admin_qty\" id=\"admin_qty\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"init_qty\" id=\"init_qty\" value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n\t\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\" value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t\t\t<input type=\"hidden\" name=\"prn_dose\" id=\"prn_dose\" value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" name=\"interval_value\" id=\"interval_value\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\" name=\"pres_base_uom\" id=\"pres_base_uom\">\n\t\t\t<input type=\"hidden\" name=\"pres_remarks\" id=\"pres_remarks\" value=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\">\n\t\t\t<input type=\"hidden\" name=\"taper_yn\" id=\"taper_yn\" value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t\t\t<input type=\"hidden\" name=\"calc_by_ind\" id=\"calc_by_ind\" value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n\t\t\t<input type=\"hidden\" name=\"dosage_std\" id=\"dosage_std\" value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n\t\t\t<input type=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">\t\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" name=\"dosage_unit_uom\" id=\"dosage_unit_uom\">\t<!-- code added for ml-mmoh-crf-0978-->\n\t\t\t<input type=\"hidden\" name=\"recomm_yn\" id=\"recomm_yn\" value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t\t\t<input type=\"hidden\" name=\"prev_freq_nature\" id=\"prev_freq_nature\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"prn_yn\" id=\"prn_yn\" id=\"prn_yn\" id=\"prn_yn\" value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" name=\"man_rem_on_prn_freq_yn\" id=\"man_rem_on_prn_freq_yn\">\t\n\t\t\t<input type=\"hidden\" name=\"prn_remarks_flag\" id=\"prn_remarks_flag\" value=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\" name=\"ord_auth_reqd_yn\" id=\"ord_auth_reqd_yn\">\n\t\t\t<input type=\"hidden\" name=\"force_auth_yn\" id=\"force_auth_yn\" value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\"><!-- added for ML-MMOH-SCF-0498 -->\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\" name=\"authroize_yn_val\" id=\"authroize_yn_val\">\n\t\t\t<input type=\"hidden\" name=\"ord_authorized_yn_durn\" id=\"ord_authorized_yn_durn\" value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\"><!-- Added for mo-scf-5533 -->\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" name=\"ord_authorized_prev_yn\" id=\"ord_authorized_prev_yn\">\t\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\" name=\"ord_spl_appr_reqd_yn\" id=\"ord_spl_appr_reqd_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" name=\"ord_cosign_reqd_yn\" id=\"ord_cosign_reqd_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" name=\"ord_approved_yn\" id=\"ord_approved_yn\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" name=\"ord_cosigned_yn\" id=\"ord_cosigned_yn\">\n\t\t\t<input type = \"hidden\" value = \"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" name = \"qty_desc_dis\"  id = \"qty_desc_dis\">\n\t\t\t<input type=\"hidden\" value = \"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\" name = \"billable_item_yn\"  id = \"billable_item_yn\"> \n\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->\n\t\t\t<input type=\"hidden\" name=\"drug_indication_mdry\" id=\"drug_indication_mdry\" value=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\"><!-- added for jd-crf-0220 -->\n\t\t\t<input type=\"hidden\" name=\"calc_dosg_by_freq_durn_yn\" id=\"calc_dosg_by_freq_durn_yn\" value=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\"><!-- added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595] -->\n<!-- \t\t</form>\n\t</body> -->\n<!-- setting schedule values--> \n";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\n<!-- setting schedule values ends-->\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\" name=\"freq_durn_type\" id=\"freq_durn_type\">\t\n\t\t\t<!--  added for CRF RUT-CRF-0063[29601]--start -->\n\t\t<input type=\"hidden\" name=\"pregnency_yn\" id=\"pregnency_yn\" value=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" name=\"preg_effect\" id=\"preg_effect\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" name=\"pregnency_cat\" id=\"pregnency_cat\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" name=\"pregnency_cat_desc\" id=\"pregnency_cat_desc\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" name=\"preg_remarks\" id=\"preg_remarks\" >\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" name=\"preg_category_code\" id=\"preg_category_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" name=\"drug_desc\" id=\"drug_desc\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\" name=\"preg_warn_req_yn\" id=\"preg_warn_req_yn\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" name=\"trimester\" id=\"trimester\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" name=\"all_durn_type_app\"  id=\"all_durn_type_app\" > <!-- ML-MMOH-CRF-1531-->\n\t\t<input type=\"hidden\" value=\"\" name=\"def_durn_type\" id=\"def_durn_type\" ><!-- ML-MMOH-CRF-1531-->\n\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" name=\"validate_overide_on_confirm_yn\" id=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n\t\t<!--added for aakh-crf-0140 start-->\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" name=\"ABUSE_OVERRIDE\" id=\"ABUSE_OVERRIDE\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" name=\"abuse_exists\" id=\"abuse_exists\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\" name=\"abuse_action\" id=\"abuse_action\">\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" name=\"abuse_drug_override_reason\" id=\"abuse_drug_override_reason\">\n\t\t   <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\" name=\"abuse_override_remarks\" id=\"abuse_override_remarks\">\n\t\t<!-- added for aakh-crf-0140 end -->\n\t\t\t<!--  added for CRF RUT-CRF-0063[29601]--end -->\n\t\t</form>\n\t</body>\n</html>\n<script> \n\t\tassignDurnTypeList(\'";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\'); \n\t\tif((\'";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\' != \'O\') && (\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\' !=\'P\')){\n\t\t\tmakeScheduleLink(\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\',\'onLoad\');\n\t\t}\n\t// if freq_nature = \'O\' and  if freq_nature = \'P\'  code moved from here to below to make durn_desc disabled for PRN and Stat orders on reloading the drug --- 19/07/2010-- priya --while fixing IN22686\n";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\t\t\tmaxDurnValidation();\n\t\t\tgetFormatIdAmend();\n";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n\t\t\t\tpopulateQtyDesc(\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\');\n";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\t\n\t\t\treloadDurnTypeList(); //commented for IN20397 --30-03-2010-- priya //uncommented for reloading durntypelist ---08/07/2010-- priya\n\t\t\tif(\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\'==\'O\'){\n\t\t\t\t/*document.prescription_amend_detail_form.in_durn_desc.value=\"\";\n\t\t\t\tdocument.prescription_amend_detail_form.in_durn_value.value=\"\";*/\n\t\t\t\tdocument.prescription_amend_detail_form.durn_desc.value=\"D\";\n\t\t\t\tdocument.prescription_amend_detail_form.durn_value.value=\"1\";\n\t\t\t\tdocument.prescription_amend_detail_form.durn_value.disabled=true;\n\t\t\t\tdocument.prescription_amend_detail_form.durn_desc.disabled=true;\n\t\t\t\t/*document.prescription_amend_detail_form.calcualted_durn_value.value=\"1\";\n\t\t\t\tdocument.prescription_amend_detail_form.allow_refill.disabled=true;\n\t\t\t\tdocument.prescription_amend_detail_form.no_refill.value=\"\";\n\t\t\t\tdocument.prescription_amend_detail_form.refill_start_date.value=\"\";\n\t\t\t\tdocument.prescription_amend_detail_form.refill_end_date.value=\"\";*/\n\t\t\t}\n\t\t\tif(document.prescription_amend_detail_form.freq_nature.value==\"P\"){\n\t\t\t\tdocument.prescription_amend_detail_form.durn_desc.value=\"D\"; //added for IN20397 --30-03-2010-- priya\n\t\t\t\tdocument.prescription_amend_detail_form.durn_desc.disabled=true;  //added for IN20397 --30-03-2010-- priya\n\t\t\t\tdocument.getElementById(\"prn_remarks\").style.visibility\t= \"visible\";\n\t\t\t\t//document.getElementById(\"prn_remarks_image\").style.visibility\t= \"visible\";\n\t\t\t\tif(document.prescription_amend_detail_form.man_rem_on_prn_freq_yn.value == \'Y\'){\n\t\t\t\t\tdocument.getElementById(\"prn_remarks_image\").style.visibility\t= \"visible\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tdocument.getElementById(\"prn_remarks_image\").style.visibility\t= \"hidden\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"dis_split_dose\").style.visibility\t= \"hidden\";\n\t\t\t}\n";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t\t\t\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n\t\t\tpopulateAmendEndDate();\n\t\t\tcheckWtAndHt(document.prescription_amend_detail_form);\n\t\t\t//lookForChange(document.prescription_amend_detail_form.qty_value)\n\t\t\tsetPrevFreqNature(\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t\t\t\tgetChargeDetails(\'";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\',\'ON_LOAD\',\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\tparent.f_button.document.prescription_button.modify_drug.disabled=true;\n";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t\tif(document.prescription_amend_detail_form.split_dose!=undefined)\n\t\t\tdocument.prescription_amend_detail_form.split_dose.disabled=true;\n";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t\tif(document.prescription_amend_detail_form.qty_value.value!=\"\"){\n\t\t\tdocument.prescription_amend_detail_form.qty_value.value =Math.abs(document.prescription_amend_detail_form.qty_value.value);\n\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );
	
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

/*

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
07/08/2019      IN:071108		    B Haribabu                                          ML-MMOH-CRF-1408
09/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
10/06/2020              IN:072715              Haribabu                                   MMS-DM-CRF-0165 
13/10/2020              IN:073110              Manickavasagam J             ML-MMOH-CRF-1531
06/11/2020      IN:069887          Haribabu                 Manickavasagam J            MO-CRF-20152
06/11/2020      IN7506             Prabha	   06/11/2020   Manickavasagam J           PH-Application accepts number of days which is not related to frequency
25/08/2023	IN49131				Sushant Tambe										ML-MMOH-SCF-2514
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con				= null;//added for ml-bru-crf-0469
try{
	String uom_disp = "";
	String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id"); 
	String encounter_id		= request.getParameter("encounter_id");
	String in_mode			= request.getParameter("mode");
	String srl_no			= request.getParameter("srl_no")==null?"1":request.getParameter("srl_no");
	String priorityCode		= request.getParameter("priority");
	String drug_cd			= request.getParameter("drug_code");//Added for RUT-CRF-0088 [IN036978]  
	String priority			= "";

	String drug_db_interface_yn      =  request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	//String drug_db_dosage_check_yn      =  request.getParameter("drug_db_dosage_check_yn")==null?"":request.getParameter("drug_db_dosage_check_yn");
	//String drug_db_duptherapy_check_yn	= request.getParameter("drug_db_duptherapy_check_yn")==null?"":request.getParameter("drug_db_duptherapy_check_yn");
	//String drug_db_contraind_check_yn	= request.getParameter("drug_db_contraind_check_yn")==null?"":request.getParameter("drug_db_contraind_check_yn");
	//String drug_db_interact_check_yn	= request.getParameter("drug_db_interact_check_yn")==null?"":request.getParameter("drug_db_interact_check_yn");
	//String drug_db_allergy_check_yn= request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");

	String drug_db_allergy_flag		=  "";	
	String drug_db_duptherapy_flag		= "";	
	String drug_db_dosage_check_flag		= "";	
	String drug_db_interact_check_flag		= "";	

	if(priorityCode!=null && priorityCode.equals("R"))
		priority	=	"Routine";
	else
		priority	=	"urgent";
     
	 if(priority.equalsIgnoreCase("Routine"))
		priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	else if(priority.equalsIgnoreCase("urgent"))
		priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

	String mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
	orbean.setLanguageId(locale);
	
	String auth_amend_pres_yn="";//added for ml-mmoh-crf-0863
	presBean.setDisp_locn_code("");//added for ml-mmoh-crf-0863
//	presBean.setOrder_ststus("");//added for ml-mmoh-crf-0863
	String called_amend_from=bean.getCalledFromAmend();
	/* DispBean.setDispLocnCode("RPAEPH");
	DispBean.setLoginFacilityId("RP");
	DispBean.setLoginById("ALPHA");
	System.out.println("locnDetailsForMod"+locnDetailsForMod); */
	//DispBean
//corrected for PE By Naveen
	//int take_home					=	bean.getHomeMecdicationYn(encounter_id,facility_id);
	int take_home					=	(int)bean.getTakeHomeCount();
	String order_id			= (String) orbean.getOrderId();
	System.out.println(order_id+"order_id");
	String pract_type						= (String) orbean.getPractitionerType(); //added for ML-BRU-SCF-0958 [IN:042045]
	//String order_line_num   =   bean.getOrderLineNumber();//Added for ICN:34834
	String order_line_num   =   "";//Added for ICN:34834
	String called_from		=	orbean.getCalledFromFunction();
	String prn_yn					= "N";
	String man_rem_on_prn_freq_yn	="";

	ArrayList drugData		= (ArrayList) bean.getpresDetails();

//	prn_yn						= bean.getchkforPRN();
//commented during PE By Naveen
	//man_rem_on_prn_freq_yn		= bean.getchkforPRN();
	String consider_stock_for_pres_yn	=	"";
	String allow_pres_without_stock_yn	=	"";
	String trade_display_yn	=	request.getParameter("trade_display_yn")==null?"":request.getParameter("trade_display_yn");
	String display			= "display:none";
	String drug_code		= "";
	String drug_desc		= "";
	String route_code		= "";
	String route_color = ""; //Added for	RUT-CRF-0034 ICN  29927
	String backgrndColor="";//Added for	RUT-CRF-0034 ICN  29927
	String fntColor="";//Added for	RUT-CRF-0034 ICN  29927
	String freq_code		= "";
	String freq_durn_type	= "D";
	String freq_durn_value	= "";
	String tap_lvl_qty	= "";//Added for RUT-CRF-0088 [IN036978]
	String extsrlno	= "";//Added for RUT-CRF-0088 [IN036978]
	float totTapperQty	= 0.0f;//Added for RUT-CRF-0088 [IN036978]  -->

	String qty_value		= "";
	String dosage_type		= "";
	String durn_value		= "";
	String split_dose		= "";
	String drug_start_date	= "";
	String drug_end_date	= "";
	String display_auth_rule	="visibility:hidden";
	String color_auth_rule	= "RED";
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
	String patient_class	= "";
	String order_type_code	= "";
	String form_code		= "";
	String repeat_durn_type	= "";
	String qty_desc_dis		= "";

	String min_daily_dose	= "";
	String min_unit_dose	= "";
    String unit_dose        = ""; 
	String daily_dose		= "";
	String mono_graph		= "";

	String dup_start_date	= "";
	String dup_end_date		= "";
	String strength_field	= "";
	String pres_remarks		= "";
	String srlNo			= "";
	String  override_yn		= "N";
	String  generic_id		= "";
	String freq_option		= "";	
	String strength_uom_desc = "";
	String duration_option	= "";
	String	ori_dosage_type	= "";
	String	in_formulary_yn	= "";
	String	item_code	= "";
	//added for SRR20056-SCF-7882 -29157 - Start
	String	buildMAR_yn	= ""; 
	String	buildMAR_checked	= ""; 
	String	buildMAR_enable	= "";
	String MAR_app_yn    = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	String	buildMAR_rule	= "";  // RUT-CRF-0062 [IN029600]
	//added for SRR20056-SCF-7882 -29157 - End
	String 	DrugIndicationRemarks				=   "";//Added for  ML-BRU-CRF-072[Inc:29938]
	ArrayList admin_time	=	new ArrayList();
	ArrayList admin_qty		=	new ArrayList();
	//ArrayList stock_params	=	new ArrayList(2);
	Hashtable DurnDescDetails	=   new Hashtable();
	HashMap taperDetails					=	null;//Added for RUT-CRF-0088 [IN036978]
	HashMap taperdrugDetails				=	new HashMap();//Added for RUT-CRF-0088 [IN036978]

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
	String dosage_option	=	"";
	
	String qty_option		=	"";
	String strength_desc	=	"";
	String schedule_status	=	"";
	String	tab_qty_value	= 	"";
	String split_dose_yn	=	"N";
	String	prn_dose		= 	"";
	String absol_qty_status	=	"";
	String qty_legend_style	=	"visibility:hidden";
	String interval_value	=	"";
	String pres_base_uom	=	"";
	boolean administered	=	false;
	ArrayList refill_orders	=	new ArrayList();
	String freq_status		=	"";
	String flag				=	"";
	String taper_yn			=	"";
	String amended_yn		=	"";
	String calc_by_ind		=	"";
	String dosage_std		=	"";
	String dosage_unit		=	"";
	String recomm_yn		=	"";
	String child_order		=	"";
	String no_of_refills	=	"";
	String tdm_order_id		=	"";
	String display_tdm		=	"display:none";
	HashMap	 prn_remarks			= new HashMap();
	String prn_remarks_code			= "";
	String prn_remarks_dtl			= "";
	String color					= "";
	String qty_desc_code			= "";
	String ext_prod_id				= "";
	String fract_dose_round_up_yn	= "";
	String strength_per_pres_uom	= "";
	String strength_per_value_pres_uom = "";
	String ord_auth_reqd_yn			= "";
	String force_auth_yn			="";//added for ML-MMOH-SCF-0498 chithra
	String ord_authorized_yn		= "";
	String ord_authorized_prev_yn	= "";
	String	ord_spl_appr_reqd_yn		= 	"";
	String	ord_cosign_reqd_yn			= 	"";
	String	ord_approved_yn				= 	"";
	String	ord_cosigned_yn				= 	"";
	String ord_authorized_yn_durn			= "";//added for mo-scf-5533
	String	dsg_reason			= "";
	String	dup_reason			= "";
	String con_reason			= "";
	String int_reason			= "";
	String	alg_reason			= "";
	String trade_code			= "";
	String trade_name			="";
	String fract_dose_appl_yn	= "";
	int dose_decimal			= 6;
	String allow_duplicate		="";
	String DrugRemarksEntered			=	""; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	String abuse_override ="" ;//added for AAKH-CRF-140
	String abuse_drug_override_reason="";//added for AAKH-CRF-140
	String abuse_action="U",abuse_exists="";//added for AAKH-CRF-140
			String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
		
	String bl_incl_excl_override_reason_code	="";
	String bl_incl_excl_override_reason_desc	= "";
	String bl_def_override_excl_incl_ind		= "";
	String bl_override_excl_incl_ind			= "";
	String bl_override_allowed_yn				= "";
	String bl_diagnosis						="";
	String bl_diagnosis_1						="";
	ArrayList routesforform						= null;
	ArrayList tmp_freq_values					= new ArrayList();

	float total_qty		= 0.0f;
	String final_qty	= "";
	String adm_time		= "";
	String adm_qty		= "";
	String tooltiptable = "";
	ArrayList dose_list = new ArrayList();
	String include_selected ="";
	String exclude_selected ="";
	String Select_selected ="";
	String billable_item_yn = "";
	String actionText						=	""; // add for SKR-CRF-0006[IN029561]
	String taper_disabled	="";
	String taperQty_display	="";
	String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
	String calc_dosg_by_freq_durn_yn = ""; //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
	String interaction_exists=	"", intr_restric_trn="N", intr_msg_content="", interaction_override ="", interaction_remarks="";
		
	String pregnency_yn				=	"";//  added for CRF RUT-CRF-0063[29601]--start 
	String pregnency_cat ="";
	String preg_effect   ="";
	String preg_category_code="";
	String preg_warn_req_yn="";
	String pregnency_cat_desc ="";
	String 		preg_remarks				=   "";// added for CRF RUT-CRF-0063[29601]--end
	String start_date1 = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
	String end_date1 = null;
	String sys_date = null;
	String tempstartString = null;
	String tempendString  = null;
	String systempString =null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
	String home_leave_med="";//Added for ML-BRU-SCF-1407 [IN 050482]
	String disp_by_alt_form_param = "";
	//Added for IN:071108 start
	String		max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	String ext_disp_appl_yn = ""; //Added For NMC-JD-CRF-0046
     //Added for IN:071108 end
     
     //Added for IN:072715 start
	String		allergy_remarks_code	    =   "";
	String		dose_remarks_code	    =   "";
	String		currentrx_remarks_code	    =   "";
	String		interaction_remarks_code	    =   "";
	String		food_interaction_remarks_code	    =   "";
	String		lab_interaction_remarks_code	    =   "";
	String drug_indication_mdry="";//added for jd-crf-0220
	drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
	System.out.println("prescriptionamenddetailsdrug_indication_mdry"+drug_indication_mdry);
	//Added for IN:072715 end
     
	//		String order_ststus="";//added for ml-mmoh-crf-0863
			String temp_mono_graph="";
			 con						= ConnectionManager.getConnection(request);//added for ml-bru-crf-0469
			boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
			boolean item_type_site_app = CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP"); //added for GHL-CRF-0549
			 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
			 boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
				
			 String validate_overide_on_confirm_yn="N";//Added for IN:069887
			 boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//Added for IN:069887 
			 
			// added for ML-MMOH-CRF-1914 start
				boolean drugDosageLimitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "PH_BEY_DOSE_PENCIL_ICON_PRN"); 
			boolean amend_order_site = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "JOB_QUEUE_REPORT"); //Added for ML-MMOH-CRF-2115 - start
		System.out.println("drugDosageLimitAppl::"+drugDosageLimitAppl);
		String 		visable_dose_for_prn="";
				if(drugDosageLimitAppl){
					visable_dose_for_prn="validateDosageLimit('hideSchedLink');";
				}
				else
				{
					visable_dose_for_prn="";
				}
				// added for ML-MMOH-CRF-1914 end
			 
			//Added for IN:069887 start
				if(validate_overide_on_confirm){
					validate_overide_on_confirm_yn="Y";
				}
				//Added for IN:069887  end
				
			//item_type_site_app = true;
			boolean all_durn_type_app = CommonBean.isSiteSpecific(con, "PH", "ALL_DURN_TYPE_APP"); //added for ML-MMOH-CRF-1531

		if(item_type_site_app){
		disp_by_alt_form_param     = bean.getParamDispByAltForm();
		System.err.println("disp_by_alt_form_param======>"+disp_by_alt_form_param);
		}
	if(called_from.equals("RENEW_ORDER")) {
		mode					= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		strength_field			=	"disabled";	
	}
	else if(called_from.equals("AMEND_ORDER")) {
		mode					= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
	}
	HashMap drugDetails	=	null;
	HashMap nextDrugDetails	=	null;
	String nextDrugCode="";
	String	extdrugCode			=	null;//Added for RUT-CRF-0088 [IN036978]
	String drugs_code = null;//Added for RUT-CRF-0088 [IN036978]
	String allow_alternate_yn = ""; //added for GHL-CRF-0549
	String allow_alternate_checked = ""; //added for GHL-CRF-0549
	String diagnosis_found_yn="";//added for mms-dm-crf-0204
			if(drugData.size()>0){//Added for RUT-CRF-0088 [IN036978]-start  -->
		drugDetails =(HashMap)drugData.get(0);
		drugs_code = (String)drugDetails.get("DRUG_CODE");
	}
	if(drug_cd!=null)
		drugs_code = drug_cd; //Added for RUT-CRF-0088 [IN036978]-end 
			
	if(in_mode!=null && in_mode.equals("amend")){
		if(drugData.size()>0){
			for(int i=0;i<drugData.size();i++){
				drugDetails =(HashMap)drugData.get(i);
				System.out.println("---------------->drugDetails"+drugDetails);
				order_line_num     =(String) drugDetails.get("ORDER_LINE_NUM");
				srlNo				= (String) drugDetails.get("SRL_NO");
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");//Added for RUT-CRF-0088 [IN036978]
				tdm_order_id		=  "";
				display_tdm			=  "display:none";
				if((i+1) <drugData.size()){
					nextDrugDetails = (HashMap)drugData.get(i);
					nextDrugCode = (String) drugDetails.get("DRUG_CODE");
				}
				if(extdrugCode.equals(drugs_code) && srlNo.equals(srl_no)){//Modified for RUT-CRF-0088 [IN036978]
					drug_code			= (String) drugDetails.get("DRUG_CODE");
					tdm_order_id		= bean.getOorderIdForTDMDtls(patient_id,drug_code);
					taperdrugDetails = drugDetails;//Added for RUT-CRF-0088 [IN036978]
					if(tdm_order_id==null||tdm_order_id.equals("")){
						display_tdm="display:none";
					}
					else{
						display_tdm="display";
					} 
                    man_rem_on_prn_freq_yn =(String) drugDetails.get("MANDATORY_REM_ON_PRN_FREQ_YN");
					
					drug_desc			= (String) drugDetails.get("CATALOG_DESC");	
					ext_prod_id		=	(String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
					form_desc			= (String) drugDetails.get("FORM_DESC");	
					generic_id			= (String) drugDetails.get("GENERIC_ID");	
					route_code			= (String) drugDetails.get("ROUTE_CODE");
					form_code			= (String) drugDetails.get("FORM_CODE");
					freq_code			= (String) drugDetails.get("FREQ_CODE");	
					//added for SRR20056-SCF-7882 -29157 -start
					
					ext_disp_appl_yn=(String) drugDetails.get("EXT_DISP_APPL_YN")==null?"":(String) drugDetails.get("EXT_DISP_APPL_YN");//Added for NMC-JD-CRF-0046
					
					buildMAR_yn	= (String) (drugDetails.get("BUILDMAR_YN") == null?"N":drugDetails.get("BUILDMAR_YN"));
			//GHL-CRF-0549  Start.
					allow_alternate_yn = (String) (drugDetails.get("ALLOW_ALTERNATE_YN") == null?"N":drugDetails.get("ALLOW_ALTERNATE_YN"));
					if(allow_alternate_yn.equals("Y"))
						allow_alternate_checked="checked";
			//GHL-CRF-0549 End.
					if(buildMAR_yn.equals("Y"))
						buildMAR_checked ="Checked";
					buildMAR_rule=drugDetails.get("BUILD_MAR_RULE")==null?"":drugDetails.get("BUILD_MAR_RULE").toString();// RUT-CRF-0062 [IN029600]  -- begin
					// Build MAR Rule will be applied only to set the Enable / Disable Property 
					buildMAR_rule=(buildMAR_rule==null)?"":buildMAR_rule;	
					if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
						buildMAR_enable="";
					}
					else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
						buildMAR_enable="disabled";
					}// RUT-CRF-0062 [IN029600]   -- end
					//if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
					//	buildMAR_enable ="disabled";
					//added for SRR20056-SCF-7882 -29157 -end

					routesforform		= presBean.getRoutes(form_code); 
					prn_remarks			=	bean.getPRNRemarks(drug_code);

					if(prn_remarks != null){
					prn_remarks_code		=prn_remarks.get("prn_remarks_code")==null?"":(String)prn_remarks.get("prn_remarks_code");
					prn_remarks_dtl			=prn_remarks.get("prn_remarks_dtl")==null?"":(String)prn_remarks.get("prn_remarks_dtl");
					}
					/*if(!prn_remarks_dtl.equals("")) {
						prn_remarks_dtl	=	"true";
					}
					else {
						prn_remarks_dtl	=	"false";
					}*/
					//order_ststus       =(String)drugDetails.get("ORDER_STATUS")==null?"N":(String)drugDetails.get("ORDER_STATUS");//added for ml-mmoh-crf-0863
				//	presBean.setOrder_ststus(order_ststus);//added for ml-mmoh-crf-0863
					qty_value			= (String) drugDetails.get("QTY_VALUE");		
					qty_desc_dis		= (String) drugDetails.get("QTY_DESC");	
					qty_desc_code		= (String) drugDetails.get("QTY_DESC_CODE");	
					strength_uom_desc	= (String) drugDetails.get("STRENGTH_DESC");
					durn_value			= (String) drugDetails.get("DURN_VALUE");		
					
					drug_start_date		= (String) drugDetails.get("START_DATE_TIME");
					drug_end_date		= (String) drugDetails.get("END_DATE_TIME");
					no_refill			= (String) drugDetails.get("NUM_OF_REFILLS");
					if(no_refill ==null || no_refill.equals("0")){
						no_refill="";
					}
					strength_value		= (String) drugDetails.get("STRENGTH_VALUE");
					strength_uom		= (String) drugDetails.get("STRENGTHUOM");
					if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
						strength_value = Float.parseFloat(strength_value) +"" ;
					prescribed_mode		= (String) drugDetails.get("PRESCRIBED_MODE");
					split_dose			= (String) drugDetails.get("SPLIT_DOSE_PREVIEW");

					durn_type			= (String) drugDetails.get("DURN_TYPE");
					repeat_value		= (String) drugDetails.get("REPEAT_VALUE");
					patient_class       = (String) drugDetails.get("PATIENT_CLASS");
					order_type_code		= (String) drugDetails.get("ORDER_TYPE_CODE");
					repeat_durn_type	= (String) drugDetails.get("REPEAT_DURN_TYPE");
					//repeat_durn_type	= (String) drugDetails.get("FREQ_DURN_TYPE");
					scheduled_yn		= (String) drugDetails.get("SCHEDULED_YN");
					stock_uom			= (String)drugDetails.get("STOCK_UOM_DESC");
					absol_qty			= (String)drugDetails.get("ORDER_QTY");

					dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
					ori_dosage_type		= (String) drugDetails.get("ORI_DOSAGE_TYPE");
					freq_nature			= (String)drugDetails.get("FREQ_NATURE");
					fract_dose_appl_yn = (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;

					fract_dose_round_up_yn =  (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					tab_qty_value		= (String) drugDetails.get("TAB_QTY_VALUE");
					prn_dose			= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
					interval_value		= (String)drugDetails.get("INTERVAL_VALUE");
					pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
					flag				= (String)drugDetails.get("FLAG");
					taper_yn			= (String)drugDetails.get("TAPERED_YN")==null?"N":(String)drugDetails.get("TAPERED_YN");
					
					System.err.println("flag     "+flag);
					System.err.println("taper_yn     "+taper_yn);
					if(amend_order_site ){ //Added for ML-MMOH-CRF-2115 - start	
					String taperSeqNo = presBean.getTaperSeqNo(order_id,1);
					String taperCount = presBean.getTaperSeqNo(order_id,2);				
						if(!taperSeqNo.equals("0")){
						
							if (patient_class.equals("IP")) {
								System.err.println("Inside IP");
								System.err.println("taperSeqNo "+taperSeqNo);
								System.err.println("taperCount "+taperCount);
							    if (taperCount.equals(taperSeqNo)) {
							        taper_yn = "N";
							    } else {
							        flag = "N";
							    }
							} else if (patient_class.equals("OP")) {
							    if (taperCount.equals(order_line_num)) {
							        taper_yn = "N";
							    } else {
							        flag = "N";
							    }
							}
						}
					} //Added for ML-MMOH-CRF-2115 - end
					
					tap_lvl_qty			=  drugDetails.get("TAP_LVL_QTY")==null?"":drugDetails.get("TAP_LVL_QTY").toString(); //Added for RUT-CRF-0088 [IN036978] 
					totTapperQty		=  Float.parseFloat(drugDetails.get("TOTTAPPERQTY")==null?"0":(String) drugDetails.get("TOTTAPPERQTY"));//Added for RUT-CRF-0088 [IN036978]  
					//if(totalTaperQtyDisplay.equals("Y")){ //Commented for 43600 - RUT-CRF-0088 - to restrict Tapered drug values change
					if(taper_yn.equals("Y")){//&& nextDrugCode.equals(drug_code)) //Commented for 43600 - RUT-CRF-0088 - to restrict Tapered drug values change load from DispMedication
						taper_disabled="disabled";
						schedule_status ="disabled";
						freq_status ="disabled";
					}
					else
						taper_disabled="";
					//}
					calc_dosg_by_freq_durn_yn  = (String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN")==null?"":(String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN"); //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]

					amended_yn			= (String)drugDetails.get("AMENDED_YN");
					calc_by_ind			= (String)drugDetails.get("CALC_BY_IND");
					dosage_std			= (String)drugDetails.get("DOSAGE_STD");
					dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT");
					recomm_yn			= ((String)drugDetails.get("RECOMM_YN"));
					ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
					force_auth_yn	=	(String) drugDetails.get("FORCE_AUTH_YN");//added for ML-MMOH-SCF-0498
					ord_authorized_yn					= (String) drugDetails.get("ORD_AUTHORIZED_YN");
					ord_authorized_prev_yn					= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
					ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
					ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
					ord_approved_yn				= (String) drugDetails.get("ORD_APPROVED_YN");
					ord_cosigned_yn				= (String) drugDetails.get("ORD_COSIGNED_YN");
					ord_authorized_yn_durn=(String)drugDetails.get("ORD_AUTHORIZED_YN_DURN")==null?"N":(String) drugDetails.get("ORD_AUTHORIZED_YN_DURN");//added for mo-scf-5533//null handled ML-MMOH-SCF-1312
					min_daily_dose	= (String)drugDetails.get("MIN_DAILY_DOSE");
					min_unit_dose	= (String)drugDetails.get("MIN_UNIT_DOSE");
					unit_dose        = (String)drugDetails.get("UNIT_DOSE"); 
					daily_dose		= (String)drugDetails.get("DAILY_DOSE");
					//Added for IN:071108 start
					max_daily_ceeling_dose				= (String) drugDetails.get("MAX_DAILY_CEELING_DOSE");
					min_daily_ceeling_dose				= (String) drugDetails.get("MIN_DAILY_CEELING_DOSE");
					max_unit_ceeling_dose				= (String) drugDetails.get("MAX_UNIT_CEELING_DOSE");
					min_unit_ceeling_dose				= (String) drugDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:071108 end
					
					//Added for IN:072715 start
					allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
					food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
					lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
					 String bl_diagnosis2				= (String) drugDetails.get("BL_DIAGNOSIS")==null?"":(String) drugDetails.get("BL_DIAGNOSIS");
					 System.out.println("bl_diagnosis2----------------558---------------------->"+bl_diagnosis2);
					//Added for IN:072715 end
					//added for aakh-crf-0140 start
					if(drug_abuse_appl){
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");
					System.out.println("abuse_override"+abuse_override);
					abuse_drug_override_reason=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason");
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
					
				}
				else{
					abuse_override="";
					abuse_drug_override_reason="";
					abuse_action="";
					abuse_exists="";
					
				}
				System.out.print("abuse_override  prescription amenddetails"+abuse_override);
					System.out.print("abuse_drug_override_reason  prescription amenddetails"+abuse_drug_override_reason);
					System.out.print("abuse_action  prescription amenddetails"+abuse_action);
					System.out.print("abuse_exists  prescription amenddetails"+abuse_exists);
					//added for aakh-crf-0140 end
					mono_graph		= (String)drugDetails.get("MONO_GRAPH");
					temp_mono_graph=mono_graph.replaceAll(" ","%20");
					temp_mono_graph = java.net.URLEncoder.encode(temp_mono_graph,"UTF-8");
					temp_mono_graph=temp_mono_graph.replaceAll("%2520","%20");
					
					trade_code		= (String)drugDetails.get("TRADE_CODE")==null?"":(String)drugDetails.get("TRADE_CODE");
					trade_name		= (String)drugDetails.get("TRADE_NAME")==null?"":(String)drugDetails.get("TRADE_NAME");
					in_formulary_yn		= (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
					item_code		= (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");

					strength_per_pres_uom			=  (String)drugDetails.get("STRENGTH_PER_PRES_UOM");            
					strength_per_value_pres_uom =  (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					con_reason					 =   (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON")==null?"": (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON");                  
					int_reason					 =   (String)drugDetails.get("INTERACTION_OVERRIDE_REASON")==null?"": (String)drugDetails.get("INTERACTION_OVERRIDE_REASON");                       
					DrugRemarksEntered = (String)drugDetails.get("DrugRemarksEntered")==null?"": (String)drugDetails.get("DrugRemarksEntered");  //Added for Antibiotic Screen using Order Entry Format ICN 29904 
					DrugIndicationRemarks				= (String) drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]
					if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8");
					freq_durn_type	= (String)drugDetails.get("FREQ_DURN_TYPE");
					freq_durn_value	= (String)drugDetails.get("FREQ_DURN_VALUE");
					billable_item_yn  =  (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y": (String)drugDetails.get("BILLABLE_ITEM_YN"); 
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn =(String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code =(String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
						  bl_override_excl_incl_ind= (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");  //priya 10/03/2010
						bl_def_override_excl_incl_ind = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");    //priya 10/03/2010

						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
					}
					drug_db_allergy_flag		=  (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_ALLERGY_FLAG");	
					drug_db_duptherapy_flag		=  (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");	
					
					drug_db_dosage_check_flag		=  (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");	
					drug_db_interact_check_flag		=  (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");	
                    
					consider_stock_for_pres_yn	=	(String)drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
		            allow_pres_without_stock_yn	=	(String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");
					pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for CRF RUT-CRF-0063[29601]-start
	                String lmp_date                 =presBean.getLMPDate(patient_id);
	                double preg_week                =presBean.getCalPregStage(drug_start_date,lmp_date);
		            preg_week=Math.ceil(preg_week);
	                String trimester                =presBean.getTrimster(preg_week);
	                bean.setPregnencyYN(pregnency_yn);
	                bean.setPregTrimester(trimester);//added for CRF RUT-CRF-0063[29601]-end 
					pregnency_cat  = (String)drugDetails.get("PREG_CATEGORY_GROUP_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_GROUP_CODE");
					preg_effect  = (String)drugDetails.get("PREG_EFFECT")==null?"":(String)drugDetails.get("PREG_EFFECT");
					preg_effect=java.net.URLEncoder.encode(preg_effect,"UTF-8");//code added for IN040512
					preg_category_code  = (String)drugDetails.get("PREG_CATEGORY_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_CODE");
                    preg_warn_req_yn  = (String)drugDetails.get("PREG_WARN_REQ_YN")==null?"":(String)drugDetails.get("PREG_WARN_REQ_YN");
					pregnency_cat_desc  = (String)drugDetails.get("CATEGORY_GROUP_DESC")==null?"":(String)drugDetails.get("CATEGORY_GROUP_DESC");
					preg_remarks = (String) drugDetails.get("PREG_DRUG_REMARKS")==null?"":(String)drugDetails.get("PREG_DRUG_REMARKS");
					if(called_from.equals("RENEW_ORDER")) //Added for Bru-HIMS-CRF-400 [IN:044502]
						order_id = (String) drugDetails.get("ORDER_ID")==null?"":(String)drugDetails.get("ORDER_ID");
					if(!preg_remarks.equals(""))
						preg_remarks = java.net.URLEncoder.encode(preg_remarks,"UTF-8"); ;
					//adding end for CRF RUT-CRF-0063[29601]
			
					if(taper_yn==null)
						taper_yn		=	"N";

					//stock_params		=	bean.validateForStock(patient_class);
					administered		=	presBean.checkAdministered(patient_id,encounter_id,drug_code,order_id);
					refill_orders		=	bean.checkRefillOrder(order_id);
					if(refill_orders.size()>0) {
						child_order			=	(String)refill_orders.get(0);
						no_of_refills		=	(String)refill_orders.get(1);
					}

					if(strength_value.equals("0")) {
						strength_value		=	"";
						strength_desc		=	"";
					}
					else {
						strength_desc		=	(String) drugDetails.get("STRENGTH_UOM");
					}

					// enable/ disable frequency based on administered status
					if(administered || flag.equals("N") || pract_type.equals("NS") || child_order.equals("Y")) {
						freq_status	=	"disabled";
					}
					allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
					current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
					limit_ind = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
					interaction_exists = (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
					intr_restric_trn = (String)drugDetails.get("INTR_RESTRIC_TRN")==null?"":(String)drugDetails.get("INTR_RESTRIC_TRN");
					intr_msg_content = (String)drugDetails.get("INTR_MSG_CONTENT")==null?"":(String)drugDetails.get("INTR_MSG_CONTENT");
					interaction_override = (String)drugDetails.get("INTERACTION_OVERRIDE")==null?"":(String)drugDetails.get("INTERACTION_OVERRIDE");
					home_leave_med = drugDetails.get("HOME_LEAVE")==null?"":(String) drugDetails.get("HOME_LEAVE");//Added for ML-BRU-SCF-1407 [IN 050482]
					diagnosis_found_yn= (String) drugDetails.get("DIAGNOSIS_FOUND_YN");
					System.out.println("1004 diagnosis_found_yn"+diagnosis_found_yn);
			
							if(drugDetails.get("DOSE_REMARKS") !=null && !((String)drugDetails.get("DOSE_REMARKS")).equals("")){
						if(!(freq_nature.equals("P")||(freq_nature.equals("O")))){
							limit_ind="N";
							dsg_reason=(String)drugDetails.get("DOSE_REMARKS");		
							drugDetails.put("DOSE_OVERRIDE", "Y");      
						}
					}
					if(drugDetails.get("ALLERGY_REMARKS") !=null && !((String)drugDetails.get("ALLERGY_REMARKS")).equals("")){
						allergy_yn="Y";
						alg_reason=(String)drugDetails.get("ALLERGY_REMARKS");
					}
					if(drugDetails.get("INTERACTION_REMARKS") !=null && !((String)drugDetails.get("INTERACTION_REMARKS")).equals("")){
						interaction_exists="Y";
						interaction_remarks=(String)drugDetails.get("INTERACTION_REMARKS");
					}
					if(drugDetails.get("CURRENTRX_REMARKS") !=null && !((String)drugDetails.get("CURRENTRX_REMARKS")).equals("")){
						current_rx	=	"Y";
						dup_reason	=	(String)drugDetails.get("CURRENTRX_REMARKS");
					}

					if(drug_db_interface_yn.equals("Y") && drug_db_allergy_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals(""))// drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						allergy_yn = "N";	
					if(drug_db_interface_yn.equals("Y") && drug_db_duptherapy_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals(""))// drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						current_rx = "N";
					if(drug_db_interface_yn.equals("Y") && drug_db_dosage_check_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals(""))// drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						limit_ind = "Y";
					if(drug_db_interface_yn.equals("Y") && drug_db_interact_check_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals("")) // drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						interaction_exists = "N";	

					drugDetails.put("ALLERGY_YN",allergy_yn);
					drugDetails.put("CURRENT_RX",current_rx);
					drugDetails.put("LIMIT_IND",limit_ind);
					drugDetails.put("INTERACTION_EXISTS",interaction_exists);

					 allow_duplicate		= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG")==null?"N":(String) drugDetails.get("ALLOW_DUPLICATE_DRUG");

					if(dup_reason.equals("") && current_rx.equals("Y"))
						drugDetails.put("CURRENTRX_OVERRIDE","N");
					else
						drugDetails.put("CURRENTRX_OVERRIDE","Y");
					
					if(scheduled_yn!=null && scheduled_yn.equals("Y") && !called_from.equals("RENEW_ORDER")){
						durn_val_dis	=	"";
						qty_val_dis		=	"";			
					}
					else {
						durn_val_dis	=	"";
						qty_val_dis		=	"";			
					}

					disp_locn_code = (String) drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc = (String) drugDetails.get("DISP_LOCN_DESC");

					if(prescribed_mode!=null && prescribed_mode.equals("A")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absolute.label","common_labels");
						color="";
					}
					else if(prescribed_mode!=null && prescribed_mode.equals("Q")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Dose.label", "ph_labels");
						color="";
					}
					else{
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");				
						color="";
					}
					
					if(prn_dose.equals("") || prn_dose.equals("0")) {
						prn_dose	=	"1";
					}
					if(bean.getTakeHomeDates()!=null && bean.getTakeHomeDates().size()>0){  	//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
						start_date1 = (String)bean.getTakeHomeDates().get(0);
						end_date1=(String)bean.getTakeHomeDates().get(1);
						//sys_date=(String) presBean.getSysdate();
						//tempstartString  = start_date1.substring(0, 10);
						//tempendString  = end_date1.substring(0, 10);
						//systempString =sys_date.substring(11, sys_date.length());
						//start_date1 = tempstartString.concat(" "+systempString);
						//end_date1 = tempendString.concat(" "+systempString);
					}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end

					if(split_dose!=null && !(split_dose.equals(""))&& scheduled_yn.equals("Y")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DividedDose.label", "ph_labels");
						color="red";
						split_dose = " "+split_dose;	
//						StringTokenizer	 vals	=	new StringTokenizer(split_dose,"|");
						StringTokenizer	 vals	=	new StringTokenizer(split_dose,";");
						adtime = adtime + "<table border=1 cellpadding=0 cellspacing=0 align=center>";
						ArrayList day_list = new ArrayList();
						ArrayList day_names = new ArrayList();
						ArrayList time_list = new ArrayList();
								  dose_list = new ArrayList();
                        ArrayList admin_qtyc = new ArrayList();  

						while(vals.hasMoreTokens()) {

							String code		= (String)vals.nextToken();
							//String code1		= code;
//							code=code+"=";
							code=code+"-";							
					   //    code1=code1+"=";
							//StringTokenizer	 inner_vals1	=	new StringTokenizer(code1,"=");
							StringTokenizer	 inner_vals	=	new StringTokenizer(code,"-");
							int j=0;
							int n=0;
							while(inner_vals.hasMoreTokens()) {
								  String temp_token = (String)inner_vals.nextToken();

								  if(temp_token.startsWith(" Day")){
									  day_list.add(temp_token.substring(5,temp_token.length()-1));
								  }
								  day_names.add(temp_token);	
  								  time_list.add(temp_token);	


                               /*  if(!(n%2==0)){

									String qty		= (String)inner_vals1.nextToken();
									if(admin_qtyc.size()!=0 && !admin_qtyc.contains(qty)) {
										split_chk	=	true;
									}
									admin_qtyc.add(qty);
								}*/
								n++;	


//   								  dose_list.add(temp_token.substring());	

							/*	if(j%2==0){  temp_token.startsWith("Day") || 
									String time		= (String)inner_vals.nextToken();
									admin_time.add(time);
									if(!time.trim().equals("")){
										adtime = adtime+"<tr>";
										String att=" class=TIPS";
										adtime = adtime + "<td "+att+">&nbsp;"+time+"&nbsp;</td>";
									}
								}
								else{
									String qty		= (String)inner_vals.nextToken();

									if(admin_qty.size()!=0 && !admin_qty.contains(qty)) {
										split_chk	=	true;
									}
									admin_qty.add(qty);
									if(!qty.equals("")){
										String att=" class=TIPS";
										adtime = adtime+"<td "+att+">&nbsp;"+qty+"&nbsp;</td>";
										adtime = adtime +"</tr>";
									}
								}
								j++;				
							*/		
							}
						}
						//Code for checking split dose 17/03/2010
						vals	=	new StringTokenizer(split_dose,";"); //added on 14/04/2010--priya (split_dose_yn was wrongly updated in or_order_line_ph


						while(vals.hasMoreTokens()) {
							String code1		= (String)vals.nextToken();
							//	code1=code1+"-";  // logic modified for IN20711 15/04/2010 -- priya
							StringTokenizer	 inner_vals	=	new StringTokenizer(code1,"-");
							int num=0;
							while(inner_vals.hasMoreTokens()) {
								String qty		= (String)inner_vals.nextToken();
								if(!(num%2==0)){
									if(admin_qtyc.size()!=0 && !admin_qtyc.contains(qty)) {
										split_chk	=	true;
									}
									admin_qtyc.add(qty);
								}
								num++;				
							}
						}
						adtime = adtime + "</TABLE>";
					}
					break;
				}
			}
		}
	}
/*	if(drug_db_interface_yn.equals("Y")){
			display="display:none";
			override_yn="N";
	}
	else{*/
		
		if(current_rx.equals("Y") || allergy_yn.equals("Y") || limit_ind.equals("N") || interaction_exists.equals("Y")|| (abuse_override.equals("Y") ||( abuse_exists.equals("Y")) && abuse_action.equals("B")) ){
			display="display";
			override_yn="Y";
		}
	//}
//Commented during PE By Naveen
	/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
	StringBuffer drug_description	=	new StringBuffer();
	int size						=	active_orders.size();
	HashMap	record					=	new HashMap();

	for(int i=0; i<size; i++)	{
		record					=	(HashMap)active_orders.get(i);
		drug_description.append((String)record.get("drug_desc"));
		drug_description.append(" , ");
	}*/
	float tempqty = 0.0f;//Added for RUT-CRF-0088 [IN036978]-start
		if(totTapperQty==0){ 
			for(int i=0;i<drugData.size();i++){
				taperDetails		= (HashMap)drugData.get(i);
				extsrlno			= (String)taperDetails.get("DRUG_CODE");
				if(extsrlno.equals(drugs_code)){
					tempqty				=  Float.parseFloat(taperDetails.get("ORDER_QTY")==null?"0":(String) taperDetails.get("ORDER_QTY"));
				}
				totTapperQty = totTapperQty+tempqty;
			}
			taperdrugDetails.put("TOTTAPPERQTY", totTapperQty+"");
		}//Added for RUT-CRF-0088 [IN036978]-end
		if(called_from.equals("RENEW_ORDER")) {
			//bean.setOldOrder(drug_code,order_id+","+presBean.getLineNo(order_id,drug_code)); //Commented for Bru-HIMS-CRF-400 [IN:044502]
			bean.setOldOrder(drug_code , order_id+","+order_line_num ); //Added for Bru-HIMS-CRF-400 [IN:044502]
		}

	if(admin_qty.size()!=0 && split_chk) {
		qty_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SplitDose.label", "ph_labels");
		color="red";
	}
	else if(admin_qty.size()!=0 && !split_chk) {
		qty_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ScheduledDose.label", "ph_labels");
		color="red";
	}
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
// Drug Remarks - End
// Legend and dosage unit is controlled based on dosage type
		if(dosage_type.equals("A")){
				dosage_option	=	"<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Absolute.label", "common_labels")+"</option>";
		}
		else if(dosage_type.equals("S")){
				dosage_option	=	"<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
		}
		else if(dosage_type.equals("Q")){
			if(ori_dosage_type.equals("S")){
				dosage_option	=	"<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
			}
			else{
				dosage_option	=	"<option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
			}
		}
	/* stock flags 
	//commented during PE By Naveen added in drug details
	if(stock_params.size()==2) {
		consider_stock_for_pres_yn	=	(String)stock_params.get(0);
		allow_pres_without_stock_yn	=	(String)stock_params.get(1);		
	}
	*/
  
     boolean dup_found			=	false;

	if((current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N") && (patient_class.equals("IP") || take_home>0) ) {
			dup_found	=	true;
		}

	// Default Strength uom
	if(dosage_type.equals("S")){
		qty_option	=	"<option value='"+strength_uom+"' selected>"+qty_desc_dis+"</option>";
	} 
	// Load Frequency
	if( in_mode!=null && in_mode.equals("amend") ) {
		HashMap freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,in_mode,patient_class);
		if(freqValues.size()>0){
			ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
			ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
			ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
		/*	if(priorityCode != null && priorityCode.equals("U")) { //Commented for SKR-SCF-1302 
				for(int i=0;i<freqCode.size();i++){
					if(((String) FreqNature.get(i)).equals("O")) {//(bean.getFreqNature(((String) freqCode.get(i))))
							if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	=	"O";
						}
						else{
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  >"+(   (String) freqDesc.get(i))+"</option>";
						}
					}
				}
			}*/ 
			//else{
				for(int i=0;i<freqCode.size();i++){
					if( dup_found){
						if( ((String) FreqNature.get(i)).equals("O")) { //(bean.getFreqNature(((String) freqCode.get(i))))
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
						}
					}
					else{
						if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							freq_nature = (String) FreqNature.get(i);// bean.getFreqNature(freq_code);
						} 
						else {
							freq_option		= freq_option + "<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			//}
		}
		if(freq_option.equals("")) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();					
			for(int i=0;i<stat_freqs.size();i+=2){
				if(((String) stat_freqs.get(i)).equals(freq_code)) {
					freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
					freq_nature	=	"O";
					freq_code	=((String) stat_freqs.get(i));
				}else{
					freq_option		= freq_option + "<option value='"+((String) stat_freqs.get(i))+"'>"+((String) stat_freqs.get(i+1))+"</option>";
				}
			}
		}
	}

	if(scheduled_yn.equals("N")) {
		schedule_status		=	"disabled";
	}
	//split flag

   if(split_chk){
	   split_dose_yn	=	"Y";
   } 
	// enable/disable order quantity legend
	if(dosage_type.equals("A") || freq_nature.equals("P")) {
		qty_legend_style	=	"visibility:visible";
		absol_qty_status	=	"enabled";
	} 
	else if(!freq_nature.equals("P") && (!totalTaperQtyDisplay.equals("Y")&& !taper_yn.equals("Y"))) {
		absol_qty			=	"";
	}

	if( totalTaperQtyDisplay.equals("Y")&& taper_yn.equals("Y")){
		taperQty_display="visibility:visible";
		qty_legend_style	=	"visibility:hidden"; //added for RUT-SCF-0155 [IN:033595]
	}
	else
		taperQty_display = "visibility:hidden";
	// Duration values

	if( in_mode!=null && in_mode.equals("amend") ) {
		DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
		Enumeration keys_des		= DurnDescDetails.keys();
		String	durn_code			= "";
		while(keys_des.hasMoreElements()){
			durn_code		= (String)keys_des.nextElement();

			duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
		}
	}
	if(freq_nature.equals("P")){
		prn_yn = "Y";
	}
	if( home_leave_med.equals("Y")){//Added if condition for ML-BRU-SCF-1407 [IN 050482]
		buildMAR_checked="";
		buildMAR_enable="disabled";
	}
	if(ext_disp_appl_yn.equals("Y")) //nmc-jd-crf-0046
	{
		buildMAR_yn ="N";
	}
	presBean.setDisp_locn_code(disp_locn_code);//added for ml-mmoh-crf-0863
	auth_amend_pres_yn = presBean.getAuthAmendPres(disp_locn_code);//added for ml-mmoh-crf-0863
	//System.out.println(order_ststus+"order_ststus auth_amend_pres_yn"+auth_amend_pres_yn);

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
                   
				if(freq_nature.equals("O")) //SKR-SCF-1302
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
				else
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels"); 
					if(pregnency_yn.equals("Y") && !preg_effect.equals("") ){

            _bw.write(_wl_block26Bytes, _wl_block26);

					}

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_desc);
						if(uom_disp == null || uom_disp.equals("null"))
							uom_disp = "";
						// added for NMC-JD-CRF-0026 start
						if(strength_display_app){
							if(strength_value!=null && strength_value!="" && !strength_value.equals("0.0")){
					
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(uom_disp));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block36Bytes, _wl_block36);
} else{
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(uom_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
					
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block43Bytes, _wl_block43);

							if(routesforform!=null && routesforform.size()>1)
								for(int i=0;i<routesforform.size();i+=3){
									backgrndColor="FFFFFF";
									fntColor="000000";
									route_color = (String)routesforform.get(i+2);
									if(route_color!= null && !route_color.equals("") && route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
									if(route_code.equals(routesforform.get(i))){

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(routesforform.get(i)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(routesforform.get(i+1)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										actionText = presBean.getActionText(form_code,route_code);	 //add for SKR-CRF-0006[IN029561]
									}
									else{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(routesforform.get(i)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(routesforform.get(i+1)));
            _bw.write(_wl_block48Bytes, _wl_block48);

									}
								}

            _bw.write(_wl_block50Bytes, _wl_block50);

				if(trade_display_yn.equals("Y")){

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
				}
				else{
					trade_code="";

            _bw.write(_wl_block54Bytes, _wl_block54);

				}

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(actionText));
            _bw.write(_wl_block57Bytes, _wl_block57);

//added for SRR20056-SCF-7882 -29157 - Start
						if(MAR_app_yn.equals("Y")){
							if(!ext_disp_appl_yn.equals("Y")){    //Added For NMC-JD-CRF-0046

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block63Bytes, _wl_block63);

						} 
						else{    //Added For NMC-JD-CRF-0046

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
	}
					}
						else{

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

						}
//added for SRR20056-SCF-7882 -29157 - end

            _bw.write(_wl_block68Bytes, _wl_block68);

							if(item_type_site_app && disp_by_alt_form_param.equals("Y")){ //GHL-CRF-549

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(allow_alternate_checked));
            _bw.write(_wl_block70Bytes, _wl_block70);

							}							

            _bw.write(_wl_block71Bytes, _wl_block71);

						display_auth_rule = "visibility:hidden";
						if(ord_auth_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:red";
							if(ord_authorized_yn.equals("Y"))
								color_auth_rule = "color:green";
							//if condtion added for ml-mmoh-crf-0863
							if(auth_amend_pres_yn.equals("Y") && called_amend_from.equals("PH") )
								color_auth_rule = "color:green";
							
						}
						//added for mo-scf-5533
						if(ord_auth_reqd_yn.equals("Y") && ord_authorized_yn_durn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:green";
						}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_spl_appr_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_approved_yn.equals("Y"))
								color_auth_rule = "color:green";
						} 

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_cosign_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_cosigned_yn.equals("Y"))
								color_auth_rule = "color:green";
						}

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(tdm_order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

							if( in_mode!=null && !in_mode.equals("amend") ) { 

            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
	
							}

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dosage_option));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(color));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(adtime));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(qty_legend));
            _bw.write(_wl_block88Bytes, _wl_block88);


				/*	if(qty_value != null && qty_value != "" && Float.parseFloat(qty_value) < 1)
							qty_value = Float.parseFloat(qty_value)+""; */ //commented for IN25920 --28/01/2011-- priya
	
					if(split_dose_yn.equals("Y")){

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(durn_val_dis));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(strength_field));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block94Bytes, _wl_block94);

					}
					else{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(durn_val_dis));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strength_field));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block98Bytes, _wl_block98);

					}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block63Bytes, _wl_block63);

							if( in_mode!=null && !in_mode.equals("amend") ) {

            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
	
							}	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qty_option));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block102Bytes, _wl_block102);
 
						if( in_mode!=null && !in_mode.equals("amend") ) { 

            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
	
						}

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(freq_option));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(schedule_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

					if(split_dose_yn.equals("N")){

            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

					}
					else{

            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

					}

            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(qty_val_dis));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(duration_option));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(freq_durn_value));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(freq_durn_type));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(visable_dose_for_prn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(absol_qty_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block130Bytes, _wl_block130);
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(taperQty_display));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(totalTaperQtyDisplay));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(taperQty_display));
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf((int)totTapperQty));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(drug_start_date));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(drug_end_date));
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(display));
            _bw.write(_wl_block147Bytes, _wl_block147);
 	
					//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 

            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(disp_locn_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
	
					/*}
					else {	*/

            _bw.write(_wl_block152Bytes, _wl_block152);
	
					//}

            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
	if(drug_indication_mdry.equals("Y")){
								 
            _bw.write(_wl_block157Bytes, _wl_block157);
} 
            _bw.write(_wl_block158Bytes, _wl_block158);

					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") ));
            _bw.write(_wl_block160Bytes, _wl_block160);

					}

            _bw.write(_wl_block161Bytes, _wl_block161);
//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ 
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
} else { 
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
} 
            _bw.write(_wl_block165Bytes, _wl_block165);
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ 
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
} else{ 
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
}  
            _bw.write(_wl_block173Bytes, _wl_block173);
//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ 
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
}  
            _bw.write(_wl_block175Bytes, _wl_block175);
            _bw.write(_wl_block176Bytes, _wl_block176);
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
     
							include_selected ="";  
							exclude_selected =""; 	
							Select_selected ="";
							if(bl_override_excl_incl_ind.equals("I")){
								include_selected ="selected";
							}
							else if(bl_override_excl_incl_ind.equals("E")){
								exclude_selected ="selected";
							}
							else {
								Select_selected ="selected";
							}

            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

							if(bl_override_allowed_yn.equals("I")){

            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
							if(bl_override_allowed_yn.equals("E")){

            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
							if(bl_override_allowed_yn.equals("B")){

            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

								}
								if(bl_override_allowed_yn.equals(""))

            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(bl_def_override_excl_incl_ind));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(bl_override_allowed_yn));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(bl_incl_excl_override_reason_desc));
            _bw.write(_wl_block197Bytes, _wl_block197);

									if(bl_incl_excl_override_reason_desc.equals("")){
										

            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block199Bytes, _wl_block199);

									}
									else{

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block201Bytes, _wl_block201);

									}

            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(bl_incl_excl_override_reason_code));
            _bw.write(_wl_block203Bytes, _wl_block203);
	//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ 
            _bw.write(_wl_block204Bytes, _wl_block204);
	} else{ 
            _bw.write(_wl_block205Bytes, _wl_block205);
} 
            _bw.write(_wl_block206Bytes, _wl_block206);
		
// Display Message if the drug is under administration/tappered
			String message	=	"";		
			if(administered) {
				//message	=	"Note: This Medication is under Administration. Dosage cannot be modified.";
				message	=	bean.getMessage(locale,"MEDN_UNDER_ADMIN_DOSE_CANNOT_MODIFY","PH");
			}
			else if(flag.equals("N")) {
				//message	=	"Note: Future Prescriptions Contains this drug. Dosage cannot be modified.";
				message	=	bean.getMessage(locale,"FUTURE_RX_DOSE_CANNOT_MODIFY","PH");
			}
			else if(child_order.equals("Y")){
				//message	=	"Note: Future Refill Exists. Dosage cannot be modified.";
				message	=	bean.getMessage(locale,"FUTURE_REFILL_DOSE_CANNOT_MODIFY","PH");
			}
			else if((!child_order.equals("N"))&&(!no_of_refills.equals(""))) {
				message		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NoofRefill.label", "ph_labels")+" : "+no_of_refills; 
			}

            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(message));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(repeat_value));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(prescribed_mode));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(temp_mono_graph));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(dup_start_date));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(dup_end_date));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(consider_stock_for_pres_yn));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(allow_pres_without_stock_yn));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(fract_dose_appl_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(taper_disabled));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(intr_restric_trn));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(interaction_override));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(freq_status));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(start_date1));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(end_date1));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(allergy_remarks_code));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(dose_remarks_code));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(currentrx_remarks_code));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(interaction_remarks_code));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(food_interaction_remarks_code));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(lab_interaction_remarks_code));
            _bw.write(_wl_block270Bytes, _wl_block270);

			if(amended_yn!=null && amended_yn.equals("Y") && (dosage_type.equals("Q")|| dosage_type.equals("A"))) {

            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block272Bytes, _wl_block272);
	
			}
			else {

            _bw.write(_wl_block273Bytes, _wl_block273);
	
			}	

            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(strength_desc));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(tab_qty_value));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(in_mode));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(prn_dose));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(taper_yn));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(presBean.getUOMDesc(dosage_unit)));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(prn_yn));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(man_rem_on_prn_freq_yn));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(prn_remarks));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(ord_auth_reqd_yn));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(force_auth_yn ));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(ord_authorized_yn));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(ord_authorized_yn_durn));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(ord_authorized_prev_yn));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(ord_spl_appr_reqd_yn));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(ord_cosign_reqd_yn));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(ord_approved_yn));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(ord_cosigned_yn));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(qty_desc_dis));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(billable_item_yn));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(drug_indication_mdry));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(calc_dosg_by_freq_durn_yn));
            _bw.write(_wl_block304Bytes, _wl_block304);
		
		if(in_mode!=null && in_mode.equals("amend")){
			ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null;
			HashMap temp_freq_chars =	null;
		//			freq_durn_type	=  "D"; // Commented for IN18922 -- 19/02/2010 -- priya 
			 if(schedule != null && schedule.size()>0){
				temp_freq_chars = (HashMap)schedule.get(0);
				freq_durn_type	= (String)temp_freq_chars.get("durationType");
			 }

			 if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
	 
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
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

				freq_durn_type	= (String)sch_output.get("durationType");

	//			bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null) {
				ArrayList values	=	presBean.getFreqDet(order_id,line_no);
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
						 dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
					// date conversion done for IN22002 --11/06/2010-- priya
				week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(drug_start_date, "DMYHM",locale, "en")); 
				 freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	

					//	  day_list  = (ArrayList)freqCharctValues.get(1);
					//	  day_names = (ArrayList)freqCharctValues.get(2);
					//	  time_list = (ArrayList)freqCharctValues.get(3);
					//	  dose_list = (ArrayList)freqCharctValues.get(4);
							
		
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
//					time_list.add(values.get(p+2));
					day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
				}

				if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals("")){
							String temp = (String)day_list.get(j);
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

				for(int tqI=0;tqI<dose_list.size();tqI++){
					total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
					final_qty	=	(String)dose_list.get(tqI);
				}
				tooltiptable = (String)bean.getTooltipStringFrFreq(tmp_freq_values,"toolTip");
				adm_time = tooltiptable;
				split_chk	=	bean.checkSplit(tmp_freq_values);	
				if(split_chk){
					final_qty		=	String.valueOf(total_qty);
				}
		/*		int incr=0;
				for(int p=0; p<values.size(); p+=4) {
					incr++;
					sch_output.put("time"+(incr),values.get(p));
					sch_output.put("qty"+(incr),values.get(p+1));				
					sch_output.put("admin_day"+(incr+1),values.get(p+3));
				}
				if(incr<=6) {
					for(int q=(incr+1); q<=6; q++) {
						sch_output.put("time"+(q),"");
						sch_output.put("qty"+(q),"");
					}
				}*/
				bean.setScheduleFrequencyStr(sch_output);
				schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			}

			if(tooltiptable.equals("") && schedule.size()>0){
				if(schedule.size()>0){
					dose_list = (ArrayList)schedule.get(4);
				}
				for(int tqI=0;tqI<dose_list.size();tqI++){
					total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
					final_qty	=	(String)dose_list.get(tqI);
				}

				tooltiptable = (String)bean.getTooltipStringFrFreq(schedule,"toolTip");
				adm_time = tooltiptable;

				split_chk	=	bean.checkSplit(schedule);	
				if(split_chk){
					final_qty		=	String.valueOf(total_qty);
				}
			}
		}
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
 
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(freq_durn_type));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(pregnency_yn));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(preg_effect));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(pregnency_cat));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(pregnency_cat_desc));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(preg_remarks));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(preg_category_code));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(preg_warn_req_yn));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(bean.getPregTrimester()));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(all_durn_type_app));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(abuse_override));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(abuse_exists));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(abuse_action));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(abuse_drug_override_reason));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(abuse_drug_override_reason));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(adm_time));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(adm_qty));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(final_qty));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tmp_freq_values.size()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(split_chk));
            _bw.write(_wl_block326Bytes, _wl_block326);
 
		if( in_mode!=null && in_mode.equals("amend") ) { 

            _bw.write(_wl_block327Bytes, _wl_block327);

			if(!dosage_type.equals("S")) {	

            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block329Bytes, _wl_block329);
			
			} 

            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block331Bytes, _wl_block331);

			if(durn_type.equals(repeat_durn_type)){

            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block329Bytes, _wl_block329);

			}
			else if(!durn_type.equals(repeat_durn_type)){

            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block329Bytes, _wl_block329);

			}

            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block329Bytes, _wl_block329);
	
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(bl_override_excl_incl_ind));
            _bw.write(_wl_block329Bytes, _wl_block329);

			}
		}
		if(!freq_status.equals("")){//Added for ML-BRU-SCF-0725 [IN:038336] to avoid amending the Administered drugs

            _bw.write(_wl_block336Bytes, _wl_block336);

		}
		if(scheduled_yn.equals("N")){//added for ML-BRu-SCF-1887 
            _bw.write(_wl_block337Bytes, _wl_block337);
		}
		//Below code added for IN25596 reopen --24/12/2010-- priya

            _bw.write(_wl_block338Bytes, _wl_block338);

	}
	catch(Exception e){
		e.printStackTrace();
	}
finally{//added for ml-bru-crf-0469
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);

}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllowAlternate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.splapproval.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DurationDetail.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IncludedinInsurance.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideIncl/Excl.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalServiceAmount.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalPayableAmount.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PackageService.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }
}
