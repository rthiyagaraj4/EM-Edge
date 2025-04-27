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

public final class __prescriptionslidingscaledetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionSlidingScaleDetail.jsp", 1743130311353L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<!--saved on 27th Oct 2005 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n    <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<!-- <script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script> -->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/PhCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n    <script language=\"JavaScript\" src=\"../../ePH/js/Prescription_1.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\n</head>\n<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- begin\t-->\n\t<!--<script language=\"VBScript\">\n\t\tFunction vbConfirm(msg)\n\t\t   butVal = 32 + 4 + 0 + 0\n\t\t   vbConfirm = MsgBox(msg,butVal,\"Duplicate Drug\")\n\t\tEnd Function\n\t</script>-->\n\t<script language=\"Javascript\">\n\nfunction jsConfirm(msg) {        \nreturn confirm(msg); \n}\n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- end\t-->\n<!-- Variable initialization starts-->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!-- Variable initialization ends-->\n\n<!-- Parameters--Start-->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<!-- Parameters--End-->\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"prescription_detail_form\" id=\"prescription_detail_form\" >\n<!-- Below table for CurrentRx details-->\n<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr>\n\t\t<td   width=\"15%\">\n\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\"javascript:callActiveOrders(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\">\n\t\t</td>\n\t\t<td class=\"CURRTEXT\"   width=\"85%\">&nbsp;</td>\n\t\t<td class=\"label\"   width=\"15%\"><input type=\'button\' class=\'button\' onClick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'Prescription\')\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'></td>\n\t</tr>\n</table>\n<!--CurrentRx table ends-->\n\n<!-- Prescription Writer Table starts-->\n<table cellpadding=0 cellspacing=0 width=\"100%\"   border=\"0\">\n\t<th style=\"font-size:9\"   colspan=\"7\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t<tr>\n\t\t<td class=\"label\" width=\'10%\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n\t\t<!-- Modified for TFS id:7345 start -->\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<td class=\"label\"  colspan=\"6\" ><input type=\"text\" name=\"drug_name\" id=\"drug_name\" size=\"42\"  maxlength=\"42\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" readOnly>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<!-- Modified for TFS id:7345 end -->\n\t\t\t<input type=\"button\" name=\"drug_search\" id=\"drug_search\" value=\"?\" class=\"button\"  onfocus=\"searchDrugName();\" onClick=\"searchDrugName();\" disabled>&nbsp;<img  src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >&nbsp;\n\t\t\t<a href=\"javascript:showOverRideRemarks(document.prescription_detail_form);\"  style=\"visibility:visible\" id=\"dosage_limit\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a>&nbsp;&nbsp;<!-- added for IN073343 -->\n\t\t\t<input type=\"checkbox\" class=\"label\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" style=\"visibility:hidden\" name=\"override_remarks\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onclick=\"checkOverRideRemarks(document.prescription_detail_form)\"  >\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<a href=\"javascript:callOrderAmend(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\" id=\"drug_remarks\" style=\"visibility:visible\" title=\"Drug Remarks\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</a>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<a href=\"javascript:callOrder();\" id=\"drug_remarks\" style=\"visibility:visible\" title=\"Drug Remarks\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 Start-->\t\n\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'>\n\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' id=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' id=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 end-->\t\n\t\t\t<input type=\"hidden\" name=\"checkEnabled\" id=\"checkEnabled\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" > \n\t\t\t&nbsp;&nbsp;<a href=\"javascript:drugindication_remarks();\" id=\"drug_ind_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</a>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\n\t\t\t\t\t\t\t\t &nbsp;<img  src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" width=\'25%\' colspan=\'2\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t&nbsp;&nbsp;<label id=\"trade_name\" style=\"font-weight:bold;visibility:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</label>\n\t\t\t<input type=\"hidden\" name=\"trade_code\" id=\"trade_code\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type=\"hidden\" name=\"trade_name\" id=\"trade_name\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t</td>\n\n\t\t<td class=\"label\"  width=\'25%\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t&nbsp;&nbsp;<label id=\"route_desc\" style=\"font-weight:bold;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>\n\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t</td>\n\t\t<td class=\"label\"   width=\"30%\" colspan=\'2\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t    &nbsp;&nbsp;<label id=\"form_desc\" style=\"font-weight:bold\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</label>\n\t\t\t<input type=\"hidden\" name=\"form_code\" id=\"form_code\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t</td>\n\t\t<td class=\"label\" width=\'15%\'  >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t&nbsp;&nbsp;<input type=\"checkbox\" name=\"chk_sliding_scale\" id=\"chk_sliding_scale\" value=\"E\" checked onClick=\"loadNonSlidingScreen(this,\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\')\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\n\t\t\t</td>\n\t\t<td class=\"label\"  ><a href=\"javascript:viewReasonforRequest(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" id=\"tdm_details\" style=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" style=\"font-size:9\"title=\"TDM Result\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t<td class=\'label\' colspan=\'2\'>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" onclick=\'assignValue1(this);\'>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t<!-- &nbsp;<input type=\'hidden\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\'> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!-- add this td and label for  SKR-CRF-0006[IN029561]-- start -->\n\t\t\t\t\t\t<td class=\'label\'><label style=\'color:red;\' id=\"actionTextval\" >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t </label></td>\n\t\t\t\t\t\t<!-- add this td and label for  SKR-CRF-0006[IN029561]-- end -->\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =";";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</label></td>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t<td class=\"label\"  align=\'center\' ><label id=\'lbl_splapprvl\' style=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_cosign\' style=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</label></td>\n\t\t\t\t\t\t<td  class=\"label\"><a href=\"javascript:viewReasonforRequest(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\');\" id=\"tdm_details\"  style=\"font-size:9;";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"  title=\"TDM Result\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" </a>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" name=\"presBean_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" name=\"presBean_name\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" name=\"ext_prod_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" name=\"patient_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\"encounter_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" name=\"generic_id\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" name=\"generic_name\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" name=\"allergy_yn\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\"limit_ind\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" name=\"current_rx\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\"mono_graph\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" name=\"monograph\">\t\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\"unit_dose\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" name=\"daily_dose\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\"min_daily_dose\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" name=\"min_unit_dose\">\t\n\t<input type=\"hidden\" name=\"dosage_std\" id=\"dosage_std\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t<input type=\"hidden\" name=\"dosage_unit\" id=\"dosage_unit\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\t\t\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" name=\"calling_mode\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" name=\"order_type_code\">\n\t<input type=\"hidden\" name=\"allow_duplicate\" id=\"allow_duplicate\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" name=\"take_home\" id=\"take_home\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name=\"qty_unit\" id=\"qty_unit\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name=\"sliding_scale_yn\" id=\"sliding_scale_yn\" value=\"Y\"> ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" <!-- hardcoded sliding_scale_yn to Y to avoid script error when click on left pad for sldingscale drug and confirm/release -->\n\t<input type=\"hidden\" name=\"ord_set_reqd_or_opt\" id=\"ord_set_reqd_or_opt\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\t\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" name=\"dsg_reason\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" name=\"dup_reason\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" name=\"con_reason\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name=\"int_reason\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" name=\"alg_reason\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" name=\"force_auth_yn\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" name=\"amend_yn\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" name=\"overrided_yn\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" name=\"dose_override\">\n\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" id=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938] -->\n\t<input type=\'hidden\' name=\'totalTaperQtyDisplay\' id=\'totalTaperQtyDisplay\' value=\'N\'>\n\t<input type=\"hidden\" name=\"intr_restric_trn\" id=\"intr_restric_trn\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"><!--Added for  RUT-CRF-0066 -->\n\t<input type=\"hidden\" name=\"intr_msg_content\" id=\"intr_msg_content\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"><!--Added for  RUT-CRF-0066 -->\n\t<input type=\"hidden\" name=\"interaction_exists\" id=\"interaction_exists\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"><!--Added for  RUT-CRF-0066 -->\n\t<input type=\"hidden\" name=\"order_id_copy\" id=\"order_id_copy\" value=\"\"><!--Added for ARYU-SCF-0033-->\n    <input type=\"hidden\" name=\"order_line_no_copy\" id=\"order_line_no_copy\" value=\"\"><!--Added for ARYU-SCF-0033--> \n    <!-- ADDED FOR IN073343  start-->\n    <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" name=\"max_daily_ceeling_dose\"> \n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" name=\"min_daily_ceeling_dose\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" name=\"max_unit_ceeling_dose\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" name=\"min_unit_ceeling_dose\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" name=\"allergy_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" name=\"dose_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" name=\"currentrx_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" name=\"interaction_remarks_code\">\n       <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" name=\"food_interaction_remarks_code\">\n         <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" name=\"lab_interaction_remarks_code\">\n\t <!-- ADDED FOR IN073343  start-->\n\t  <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n      <input type=\"hidden\" name=\"abuse_action\" id=\"abuse_action\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"><!-- Added for AAKH-CRF-140 -->\n\t\t<input type=\"hidden\" name=\"abuse_override\" id=\"abuse_override\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"><!-- Added for AAKH-CRF-140 -->\n\t\t<input type=\"hidden\" name=\"abuse_exists\" id=\"abuse_exists\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"><!-- Added for AAKH-CRF-140 -->\n\t\t<input type=\"hidden\" name=\"abuse_remarks\" id=\"abuse_remarks\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"><!-- Added for AAKH-CRF-140 -->\n\t\t<input type=\"hidden\" name=\"abuse_override_remarks\" id=\"abuse_override_remarks\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"><!-- Added for AAKH-CRF-140 -->\n\t\t<input type=\"hidden\" name=\"abuse_restric_trn\" id=\"abuse_restric_trn\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"><!-- added for aakh-crf-0140 -->\n\t\t<input type=\"hidden\" name=\"drug_indication_mdry\" id=\"drug_indication_mdry\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"><!-- added for jd-crf-0220 -->\n\t\t\n\t\t   \n</form>\n</body>\n<script>\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\tdocument.prescription_detail_form.dosage_limit.style.visibility=\"visible\";\n\t\t\tdocument.prescription_detail_form.override_remarks.style.visibility=\"visible\";\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\tgetFormatId();\n ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\tdocument.prescription_detail_form.dosage_limit.style.visibility=\"hidden\";\t\n\t\t\tdocument.prescription_detail_form.override_remarks.style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\t//out.println(\"alertIntr(\'\"+drug_desc+\"\',\'\"+intr_msg_content+\"\' );\");\n\t\t\t\tout.println(\"alertIntr(\'\"+drug_code+\"\',\'\"+srl_no+\"\',\'\"+patient_id+\"\',\'\"+encounter_id+\"\',\'N\' );\");\n\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\n\t\t\t\t\t\talertAbuse(\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\', \'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\',\'N\');\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\tparent.parent.f_button.document.forms[0].btnDiscOrders.style.display = \"inline\";\n\t\t\tcallDiscCancelOrders(\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\',\'\',\'Y\');\t \n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\t\t\tif(parent.parent.f_button.document.forms[0].btnDiscOrders!=undefined) //TBMC-SCF-0166\n\t\t\tparent.parent.f_button.document.forms[0].btnDiscOrders.style.display = \"none\";\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );
	
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
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date	 		Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

14/08/2020	    IN73343             Shazana												 PHIS-PH-Alpha - Medical Supply, Special Characters issue in SIKARIN
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
05/01/2021	 TFS id:7345 Haribabu	      06/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

try{
	String patient_id				= "";
	String encounter_id				= "";
	String priority					= "";
//	String hr_start_time			= "";
	String drug_code				= "";
	String drug_desc				="";
	String drug_desc_new			="";//Added for TFS id:7345
	String drug_search_by			="";//Added for TFS id:7345
	String srl_no					= "";
	String bsa						= "";
	String order_id				    = "";
	String display_tdm              ="display:none";
	String freq_code		=	""; //  added for Bru-HIMS-CRF-0265 [IN032315] 
	String start_date		=	""; //  added for Bru-HIMS-CRF-0265 [IN032315] 
	String end_date		=	""; //  added for Bru-HIMS-CRF-0265 [IN032315] 

            _bw.write(_wl_block10Bytes, _wl_block10);

	String calling_mode			= request.getParameter("mode") ;
	String mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	if(calling_mode.equals("blank")){
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority") ;
	}
	else{
		drug_code				= request.getParameter("drug_code") ;
		srl_no					= request.getParameter("srl_no") ;
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority") ;
		bsa						= request.getParameter("bsa") ;	
	}
	String patient_class		= request.getParameter("patient_class");
	String drug_db_interface_yn		= request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String drug_db_allergy_check_yn	    = request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");
	String drug_db_duptherapy_yn	    = request.getParameter("drug_db_duptherapy_yn")==null?"":request.getParameter("drug_db_duptherapy_yn");

	String extdrugCode		=	"";
	String srlNo			=	"";
	String allergy_yn		=	"";
	String limit_ind		=	"";
	String current_rx		=	"";
	String generic_id		=	"";
	String generic_name		=	"";
	String daily_dose		=	"";
	String unit_dose		=	"";
	String min_daily_dose	=	"";
	String min_unit_dose	=	"";
	String dosage_std					=	"";
	String dosage_unit					=	"";
	String mono_graph		=	"";
	String order_type_code	=	"";
	String allow_duplicate	=	"";
	String freq_nature		=	"";
	String qty_unit			=	"";
	String Override_Checked = "";
	String Override_Check="";
	String checkEnabled="";
	String sliding_scale_yn="";
	String ord_set_reqd_or_opt="";
	String form_code	   = "";
	String form_desc  	   = "";
	String route_code	   = "";
	String route_desc	   = "";
	String route_color	   = "";
	String amend_yn		   = "";
	String sliding_scale_yn_status = "";
	String dsg_reason = "";
	String dup_reason = "";
	String int_reason = "";
	String con_reason = "";
	String alg_reason = "";
	String		ext_prod_id				=	"";
	String		trade_code ="";
	String		trade_name="";
	String		trade_name_display="";
	String MAR_app_yn = request.getParameter("MAR_app_yn")==null?"Y":request.getParameter("MAR_app_yn");
	String buildMAR_yn = "";
	String buildMAR_enable = "";
	String buildMAR_checked = "";
	String ord_id = "";
	String ord_line_no = "";
	String called_from_amend = request.getParameter("called_from_amend")==null?"":request.getParameter("called_from_amend");
	String force_auth_yn			=	"";
	String ord_auth_reqd_yn			= 	"";
	String ord_authorized_prev_yn	= 	"";
	String ord_spl_appr_reqd_yn		= 	"";
	String ord_cosign_reqd_yn		= 	"";
	String ord_authorized_yn		= 	"";
	String ord_approved_yn			= 	"";
	String ord_cosigned_yn			= 	"";
	String color_auth_rule	= "RED";
	String display_auth_rule	="visibility:hidden";
	String drug_db_allergy_flag = "";
	String drug_db_duptherapy_flag = "";
	String drug_db_interact_check_flag = "";
	String drug_db_contraind_check_flag = "";
	String drug_db_dosage_check_flag = "";
	String dose_override = "";
	String DrugRemarksEntered = ""; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	String buildMAR_rule			= "";  // RUT-CRF-0062 - IN 32186
	String 		DrugIndicationRemarks				=   "";// ML-BRU-CRF-072[Inc:29938] 
	String interaction_exists				=	"", intr_restric_trn="N", intr_msg_content="";
	ArrayList alDrugIntrList = null;
	HashMap hmDrugInteractionDtl = null;

	ArrayList presDetails				=	null;
	HashMap drugDetails					=	null;

	if(bsa==null) 				bsa	=	"";
	if(priority==null)	 priority	=	"";
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	String actionText				=	""; // add for SKR-CRF-0006[IN029561]
	String validate_overide_on_confirm_yn="N";//Added for IN:069887 
	//int take_home					=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
	int take_home					=	(int)bean.getTakeHomeCount();
	int profile_count		= bean.getDrugProfileCount();  //added for Bru-HIMS-CRF-0265 [IN032315]		
	//Added for IN:069887 start
	boolean validate_overide_on_confirm =presBean.isSiteSpecific("PH","VALIDATE_OVERIDE_ON_CONFIRM"); 
	boolean drug_abuse_appl=presBean.isSiteSpecific("PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	String abuse_exists	=	"", abuse_restric_trn="N", abuse_remarks="", abuse_override ="" ,abuse_action="",abuse_type="",abuse_override_remarks="";//added for AAKH-CRF-140
	
	String pre_alloc_appl_yn =CommonBean.checkForNull(bean.getPreAllocApplYN());//Added for TFS id:7345		
	String drug_indication_mdry="";//added for jd-crf-0220
	drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
			if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}
	//Added for IN:069887 end
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
	//ADDED FOR IN073343 start
	String		max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	String allergy_remarks_code = "";
	String dose_remarks_code = "";
	String currentrx_remarks_code = "";
	String interaction_remarks_code = "";
	String food_interaction_remarks_code = "";
	String lab_interaction_remarks_code = "";
	//ADDED FOR IN073343 end
	
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority") ;
		if(!calling_mode.equals("blank")){
			presDetails					= (ArrayList) bean.getpresDetails();
			drug_code				= request.getParameter("drug_code") ;
			srl_no					= request.getParameter("srl_no") ;
			bsa						= request.getParameter("bsa") ;	
			if(order_id==null||order_id.equals("")){
				display_tdm="display:none";
			}
			else{
				display_tdm="display:inline";
			} 
		}
		if(presDetails!=null && presDetails.size()>0){		
			for(int i=0;i<presDetails.size();i++){
				drugDetails		= (HashMap)presDetails.get(i);
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");
				srlNo			= (String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
						ext_prod_id					= (String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
						drug_db_dosage_check_flag = (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");
						drug_db_contraind_check_flag = (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
						drug_db_interact_check_flag = (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");
						drug_db_duptherapy_flag = (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag = (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG")==null?"N":(String) drugDetails.get("DRUG_DB_ALLERGY_FLAG");
				
						drug_desc	   = (String)drugDetails.get("DRUG_DESC");
						drug_desc_new				= (String) drugDetails.get("DRUG_DESC_NEW")==null?"":(String) drugDetails.get("DRUG_DESC_NEW");//Added for TFS id:7345
						drug_search_by				= (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");//Added for TFS id:7345
						generic_id					= (String) drugDetails.get("GENERIC_ID");
						generic_name				= (String) drugDetails.get("GENERIC_NAME");
						allergy_yn					= (String) drugDetails.get("ALLERGY_YN")==null?"":(String) drugDetails.get("ALLERGY_YN");
						limit_ind					= (String) drugDetails.get("LIMIT_IND")==null?"":(String) drugDetails.get("LIMIT_IND");
						current_rx					= (String) drugDetails.get("CURRENT_RX")==null?"":(String) drugDetails.get("CURRENT_RX");
						daily_dose					= (String) drugDetails.get("DAILY_DOSE");
						unit_dose					= (String) drugDetails.get("UNIT_DOSE");
						min_daily_dose				= (String) drugDetails.get("MIN_DAILY_DOSE");
						min_unit_dose				= (String) drugDetails.get("MIN_UNIT_DOSE"); 
						mono_graph					= (String) drugDetails.get("MONO_GRAPH");
						dose_override				= (String) drugDetails.get("DOSE_OVERRIDE");
						order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
						allow_duplicate				= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG");
						if(patient_class.equals("OP"))
							allow_duplicate	   = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
						freq_nature					= (String) drugDetails.get("FREQ_NATURE");
						freq_code					= (String) drugDetails.get("FREQ_CODE")==null?"":(String) drugDetails.get("FREQ_CODE"); // added for Bru-HIMS-CRF-0265 [IN032315] 
						start_date					= (String) drugDetails.get("START_DATE")==null?"":(String) drugDetails.get("START_DATE"); // added for Bru-HIMS-CRF-0265 [IN032315] 
						end_date					= (String) drugDetails.get("END_DATE")==null?"":(String) drugDetails.get("END_DATE"); // added for Bru-HIMS-CRF-0265 [IN032315] 
						ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
						force_auth_yn				= (String) drugDetails.get("FORCE_AUTH_YN"); // THIS IS TO KNOW IF AUTH YN IS DUE TO FORCE AUT OR DUE TO DURATION EXCEEDED
						ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
						ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
						ord_authorized_yn					= (String) drugDetails.get("ORD_AUTHORIZED_YN");
						ord_authorized_prev_yn					= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
						ord_approved_yn				= (String) drugDetails.get("ORD_APPROVED_YN");
						ord_cosigned_yn				= (String) drugDetails.get("ORD_COSIGNED_YN");

						qty_unit			        = CommonBean.checkForNull((String)drugDetails.get("STRENGTH_UOM"));
						sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN")==null?"Y":(String)drugDetails.get("SLIDING_SCALE_YN"); 
						ord_set_reqd_or_opt	   = (String) drugDetails.get("REQD_OR_OPT_IND")==null?"":(String) drugDetails.get("REQD_OR_OPT_IND");

						form_code	    = (String)drugDetails.get("FORM_CODE");         
						form_desc  	    = (String)drugDetails.get("FORM_DESC");     
						route_code	    = (String)drugDetails.get("ROUTE_CODE")==null?"":(String)drugDetails.get("ROUTE_CODE");       
						route_desc	    = (String)drugDetails.get("ROUTE_DESC")==null?"":(String)drugDetails.get("ROUTE_DESC");       
						route_color	    = (String)drugDetails.get("ROUTE_COLOR")==null?"":(String)drugDetails.get("ROUTE_COLOR");   
						if( route_color.equals("")){
							if(route_color.length()==12){
								route_color = "color:"+route_color.substring(0, 6)+";background-color:"+route_color.substring(6, 12)+";";
							}
						}
						actionText = presBean.getActionText(form_code,route_code);	 //add for SKR-CRF-0006[IN029561]					
						
						amend_yn	    = (String)drugDetails.get("AMEND_YN");       
						dosage_std	    = (String)drugDetails.get("DOSAGE_STD");
						dosage_unit		= (String)drugDetails.get("DOSAGE_UNIT");
						dsg_reason		=	(String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");
						dup_reason		=	(String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
						con_reason		=	(String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");
						int_reason		=	(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
						alg_reason		=	(String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
						trade_code = (String) drugDetails.get("TRADE_CODE")==null?"": (String) drugDetails.get("TRADE_CODE");
						trade_name = (String) drugDetails.get("TRADE_NAME")==null?"": (String) drugDetails.get("TRADE_NAME");
						if(trade_code.equals(""))
							trade_name_display="none";
						else
							trade_name_display ="inline";

//RUT-CRF-0062 IN-32186	 Added to get the Build MAR Value based on MAR Rule -- begin
				if(MAR_app_yn.equals("Y")){
						buildMAR_rule = drugDetails.get("BUILD_MAR_RULE").toString();
						buildMAR_yn ="N";
						if(drugDetails.get("BUILDMAR_YN")!=null){
							buildMAR_yn = drugDetails.get("BUILDMAR_YN").toString();
							
							if(buildMAR_yn.equals("Y"))
								buildMAR_checked="checked";
							else
								buildMAR_checked="";
							
							if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD"))
								buildMAR_enable="disabled";
							else	
								buildMAR_enable="";
						}
						else{
							buildMAR_enable="";
							buildMAR_checked="";
							buildMAR_yn ="N";					
						
							if(buildMAR_rule.equals("CD")||buildMAR_rule.equals("UD"))
								buildMAR_enable="disabled";
							
							if(buildMAR_rule.equals("CE")||buildMAR_rule.equals("CD")){
								buildMAR_checked="checked";
								buildMAR_yn ="Y";
							}
						}
					  }
					}
					/* RUT-CRF-0062 IN 32186  Commented to load Build MAR value based on Rule 
					if(drugDetails.get("BUILDMAR_YN")==null){
						drugDetails.put("BUILDMAR_YN",MAR_app_yn);
					} 
					RUT-CRF-0062 IN 32186   -- end */
					DrugRemarksEntered = (String) drugDetails.get("DrugRemarksEntered")==null?"":(String) drugDetails.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
				}
			}
			DrugIndicationRemarks= (String) drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Added for ML-BRU-CRF-072[Inc:29938]
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); ;
			
			if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP") || calling_mode.equals("taper")|| calling_mode.equals("tapered"))
		 SRR20056-CRF-0649.1 */
		 
		 
				if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
					buildMAR_enable ="disabled";
					
				/* Commented RUT-CRF-0062 IN 32186
				 if(buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				*/
			}
			sliding_scale_yn_status = "";                                            
			order_id	   =  "";
			order_id	   = bean.getOorderIdForTDMDtls(patient_id,drug_code);
			display_tdm    ="display:none"; 
			if(order_id==null||order_id.equals("")){
				display_tdm="display:none";
			}else{
				display_tdm="display:inline";
			}				
			HashMap sliding_scale_dtls = bean.getSlidingScaleDetails(drug_code);
			if((amend_yn!=null && amend_yn.equals("Y")) || called_from_amend.equals("Y")) {
				sliding_scale_yn_status = "disabled";
			}

			if(calling_mode.equals("amend")){
				ord_id = (String)drugDetails.get("ORDER_ID");
				ord_line_no = (String)drugDetails.get("ORDER_LINE_NUM");
			}
		/*	if(current_rx.equals("Y") || limit_ind.equals("N") || allergy_yn.equals("Y"))
			{
				Override_Check = "Y";
				drugDetails.put("Override_Check",Override_Check);
			} */
			//Added for IN073343 start
			max_daily_ceeling_dose				= (String) drugDetails.get("MAX_DAILY_CEELING_DOSE");
			min_daily_ceeling_dose				= (String) drugDetails.get("MIN_DAILY_CEELING_DOSE");
			max_unit_ceeling_dose				= (String) drugDetails.get("MAX_UNIT_CEELING_DOSE");
			min_unit_ceeling_dose				= (String) drugDetails.get("MIN_UNIT_CEELING_DOSE");
			allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
			dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
			currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
			interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
			food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
			lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
			//Added for IN073343 end
			
			//added for AAKH-CRF-0140 start
			if(drug_abuse_appl){ 
		    	
		   
		    	abuse_exists	= (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
					 abuse_restric_trn=(String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
					  abuse_override =(String) drugDetails.get("ABUSE_OVERRIDE")==null?"": (String) drugDetails.get("ABUSE_OVERRIDE");
					  abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"U": (String) drugDetails.get("ABUSE_ACTION");
					  abuse_override_remarks=(String) drugDetails.get("abuse_override_remarks")==null?"": (String) drugDetails.get("abuse_override_remarks");
					  System.out.println("abuse_restric_trn 821"+abuse_restric_trn);
		    }
		    else{
		    	abuse_exists	=	"N";// (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
				 abuse_restric_trn="N";// (String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
				 abuse_remarks="";// (String) drugDetails.get("ABUSE_MSG_CONTENT")==null?"N": (String) drugDetails.get("ABUSE_MSG_CONTENT");
				  abuse_override ="";// (String) drugDetails.get("ABUSE_OVERRIDE")==null?"N": (String) drugDetails.get("ABUSE_OVERRIDE");
				  abuse_action="";// (String) drugDetails.get("ABUSE_OVERRIDE")==null?"N": (String) drugDetails.get("ABUSE_OVERRIDE");
				  abuse_override_remarks="";

		    }
			//added for AAKH-CRF-0140 end

			String overrided_yn = "Y";
			if(current_rx.equals("Y") && (((String)drugDetails.get("CURRENTRX_REMARKS"))==null || ((String)drugDetails.get("CURRENTRX_REMARKS")).equals("")))
				overrided_yn = "N";
			if(limit_ind.equals("N") && (((String)drugDetails.get("DOSE_REMARKS"))==null || ((String)drugDetails.get("DOSE_REMARKS")).equals("")))
				overrided_yn = "N";
			if(allergy_yn.equals("Y") && (((String)drugDetails.get("ALLERGY_REMARKS"))==null || ((String)drugDetails.get("ALLERGY_REMARKS")).equals("")))
				overrided_yn = "N";
			if(abuse_exists.equals("Y")&& abuse_action.equals("B") && (((String)drugDetails.get("abuse_override_remarks"))==null || ((String)drugDetails.get("abuse_override_remarks")).equals("")))
				overrided_yn = "N";

			drugDetails.put("OVERRIDED_YN",overrided_yn); 
			
			//		if(drugDetails.containsKey("Override_Check")) {

			//			Override_Check	=(String)drugDetails.get("Override_Check");
					if(drugDetails.containsKey("OVERRIDED_YN")) {
						overrided_yn = (String) drugDetails.get("OVERRIDED_YN");
			//			if(Override_Check.equals("Y") && overrided_yn.equals("Y")){
						if(overrided_yn.equals("Y")){
							Override_Checked="Checked";
							checkEnabled="disabled";
						}
						else{
							Override_Checked="";
							checkEnabled="";
						}
					} 

				interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");
				intr_restric_trn			= (String) drugDetails.get("INTR_RESTRIC_TRN")==null?"N": (String) drugDetails.get("INTR_RESTRIC_TRN");
				if(intr_restric_trn.equals("Y")){
					alDrugIntrList = (ArrayList) drugDetails.get("INTERACTION_DTL");
					for(int intr=0; intr<(alDrugIntrList.size()-2); intr++){
						hmDrugInteractionDtl = (HashMap) alDrugIntrList.get(intr);
						if(((String)hmDrugInteractionDtl.get("restrict_transaction")).equals("Y"))
							intr_msg_content += (String)hmDrugInteractionDtl.get("intr_name")+", ";
					}
					intr_msg_content = intr_msg_content.substring(0, intr_msg_content.length()-1);
				}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_desc_new));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(overrided_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Override_Checked));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkEnabled));
            _bw.write(_wl_block28Bytes, _wl_block28);
			
			if(calling_mode.equals("amend")){

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ord_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ord_line_no));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

			}
			else{

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

			}

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(checkEnabled));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
	 System.out.println("522");if(drug_indication_mdry.equals("Y")){//added for jd-crf-0220
								 
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(trade_name_display));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(route_color));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sliding_scale_yn_status));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

						if(MAR_app_yn.equals("Y")){

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block61Bytes, _wl_block61);

						}
						else{

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

						}

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(actionText));
            _bw.write(_wl_block65Bytes, _wl_block65);
						display_auth_rule = "visibility:hidden";

						if(ord_auth_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:red";
							if(ord_authorized_yn.equals("Y"))
								color_auth_rule = "color:green";
						}

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

						display_auth_rule = "visibility:hidden";
						color_auth_rule = "color:red";
						if(ord_spl_appr_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_approved_yn.equals("Y"))
								color_auth_rule = "color:green";
						}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

						display_auth_rule = "visibility:hidden";
						color_auth_rule = "color:red";
						if(ord_cosign_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_cosigned_yn.equals("Y"))
								color_auth_rule = "color:green";
						}  

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(allow_duplicate));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(take_home));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block102Bytes, _wl_block102);
/*=sliding_scale_yn*/
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(ord_set_reqd_or_opt));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(force_auth_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(overrided_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dose_override));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(intr_restric_trn));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(allergy_remarks_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(dose_remarks_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(currentrx_remarks_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(interaction_remarks_code));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(food_interaction_remarks_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(lab_interaction_remarks_code));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(abuse_action));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(abuse_override));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(abuse_exists));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(abuse_remarks));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(abuse_override_remarks));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(abuse_restric_trn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(drug_indication_mdry));
            _bw.write(_wl_block135Bytes, _wl_block135);
		// To Display reason button 
	//if(((drug_db_interface_yn != null && !drug_db_interface_yn.equals("Y")) || (ext_prod_id != null && ext_prod_id.equals(""))) && ((allergy_yn != null && allergy_yn.equals("Y")) || (current_rx != null && current_rx.equals("Y"))) ){

		if(((allergy_yn != null && allergy_yn.equals("Y"))
 || current_rx.equals("Y") ||
 interaction_exists.equals("Y") 
 || (abuse_exists.equals("Y") && abuse_action.equals("B")))
 && (ext_prod_id== null  ||  ext_prod_id.equals("") 
 || !drug_db_interface_yn.equals("Y")|| drug_db_duptherapy_yn.equals("N")) ) {//Added for Duplicate button issue
	  System.out.println(abuse_exists+"672");

            _bw.write(_wl_block136Bytes, _wl_block136);

		}

            _bw.write(_wl_block137Bytes, _wl_block137);

 if(!(((allergy_yn != null && allergy_yn.equals("Y")) 
		 || current_rx.equals("Y") ||
		  (abuse_exists.equals("Y") && abuse_action.equals("B"))|| 
		  interaction_exists.equals("Y")) && (ext_prod_id== null  ||
		  ext_prod_id.equals("") || !drug_db_interface_yn.equals("Y")|| 
		  drug_db_duptherapy_yn.equals("N")))){
		  	System.out.println(abuse_exists+"682");
 
            _bw.write(_wl_block138Bytes, _wl_block138);

		}
		if((drug_db_interface_yn != null &&!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
			if((amend_yn==null || !amend_yn.equals("Y") ) && interaction_exists.equals("Y") && intr_restric_trn.equals("Y")){
				
            _bw.write(_wl_block139Bytes, _wl_block139);
			}
			
			if((amend_yn==null || !amend_yn.equals("Y")) && (abuse_exists.equals("Y") && abuse_action.equals("B"))){
				System.out.println("2810abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
					
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
	
				}
		
		}
		//added for Bru-HIMS-CRF-0265 [IN032315] -- begin 
		if(profile_count>=1 && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") )) && current_rx.equals("Y") && bean.getCancelDiscConDupOrders().equals("Y") ){ 

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block144Bytes, _wl_block144);

		}
		else{

            _bw.write(_wl_block145Bytes, _wl_block145);

		}
		//added for Bru-HIMS-CRF-0265 [IN032315] -- end 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block146Bytes, _wl_block146);
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SlidingScale.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.splapproval.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
}
