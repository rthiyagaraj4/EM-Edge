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

public final class __prescriptioncompdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionCompDetail.jsp", 1732680040221L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<!-- Modified for IN:072715  -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n   <!--  <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/PhCommon.js\"></script>-->\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionComp.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script> <!-- Added for RollForward from SRR - SRR20056-SCF-9368 [IN:057068]-->\n\t\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/DateUtils.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  <!-- Added for RollForward from SRR - SRR20056-SCF-9368 [IN:057068]-->\n\t\t\n\t</head>\n\n<!-- Variable initialization starts-->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"prescription_compdetail_form\" id=\"prescription_compdetail_form\" >\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"1\">\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" > ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" ></td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" ></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"3%\" >\n\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t\t<tr>\n                                  <td NOWRAP width=\"12\" class=\"label\" id=\"ADR_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"ADR_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"ADR_img_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" name=\"ADR_img_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" src=\'../../ePH/images/ADR.gif\'   title=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'></img>\n\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"external_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" style=\"visibility:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onclick=\"displayDosageCheckResult(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =")\"><img style=\"visibility:";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"external_img";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"ALLERGY\" id=\"allergy_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\"allergy_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\" onmouseover=\"changeCursor(this);\" ><img style=\"visibility:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"allergy_img";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" name=\"allergy_img";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"DOSELIMIT\" id=\"dosage_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" name=\"dosage_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ><img style=\"visibility:hidden\" id=\"dosage_img";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" name=\"dosage_img";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"CURRENTRX\" id=\"currentrx_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" name=\"currentrx_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"><img style=\"visibility:";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"currentrx_img";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" name=\"currentrx_img";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"34%\">&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"drug_name";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"drug_name";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" size=\"42\"  maxlength=\"42\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" disabled onblur=\"deleteDrug(this,";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =")\" >\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"button\" name=\"drug_search";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"drug_search";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" value=\"?\" class=\"button\"   onClick=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =",";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =")\" disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"5%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"strength";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" name=\"strength";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">&nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"10%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"form";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" name=\"form";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"20%\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"absol_qty";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"absol_qty";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  size=\"6\" maxlength=\"6\" onblur=\"CheckNum(this);extdosechk();\"  onKeyPress=\"return allowValidNumber(this,event,6,0);\" class=\"number\">&nbsp;\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"qty";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" name=\"qty";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"6%\" >\n\t\t\t\t\t\t\t<a href=\"javascript:callOrderAmend(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');\" id=\"remarks_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" name=\"remarks_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" HREF onMouseOver=\"changeCursor(this);\" title=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</A>\n\t\t\t\t\t\t\t<!-- added for [IN:039576]-start -->\n\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' name=\'DrugRemarksMandImg_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'DrugRemarksMandatory_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' value=\'N\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'DrugRemarksEntered_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">&nbsp;&nbsp;\n\t\t\t\t\t\t\t<!-- added for [IN:039576]-end -->\n\t\t\t\t\t\t\t<a href=\"javascript:drugindication_remarks(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\');\" id=\"drug_ind_remarks_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" name=\"drug_ind_remarks_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</a>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"DrugIndicationRemarks_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"><!--Added for ML-BRU-CRF-072[Inc:29938] -->\n\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"18%\">\n\t\t\t\t\t\t\t<input style=\"visibility:";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" type=\"button\" class=\"button\" width=\"8%\" value=\"Override\" id=\"dosage_limit";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\"dosage_limit";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" onclick=\"showOverrideReason(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\')\" > <!--drug_db_dosecheck_yn added for ML-MMOH-CRF-1408 -->\n\t\t\t\t\t\t<!-- Modified for IN:072715 START -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t<input style=\"visibility:";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" type=\"checkbox\" width=\"2%\" id=\"chk_ovr";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" name=\"chk_ovr";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\')\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" onclick=\"default_override_rsn(\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t<!-- Modified for IN:072715 end -->\n\t\t\t\t\t\t\t<A title=\"TDM Result\" style=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"tdmRsltAmnd_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\"tdmRsltAmnd_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" HREF onMouseOver=\"changeCursor(this);\" onClick=\"viewReasonforRequest(tdmOrderIdAmnd";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =".value)\"> ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</A>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\"text\" name=\"drug_class";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"drug_class";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ALLERGY_DESC";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"ALLERGY_DESC";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"EXCEED_DOSE_DESC";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"EXCEED_DOSE_DESC";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"DUP_DRUG_DESC";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"DUP_DRUG_DESC";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\t\t\n\t\t\t\t\t\t<!-- Added for IN:072715 start -->\t\t\n      \t\t\t\t\t <input type=\"hidden\"  name=\"allergy_remarks_code";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" id=\"allergy_remarks_code";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" value=\"\">\n       \t\t\t\t\t <input type=\"hidden\"  name=\"dose_remarks_code";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"dose_remarks_code";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" value=\"\">\n      \t\t\t\t\t <input type=\"hidden\"  name=\"currentrx_remarks_code";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"currentrx_remarks_code";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" value=\"\">\n      \t\t\t\t\t <!-- Added for IN:072715 end -->\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"drug_code";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"\t value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"strength_uom";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_remarks";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"pres_remarks";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"tdmOrderIdAmnd";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"tdmOrderIdAmnd";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"srl_no";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_prod_id_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"external_prod_id_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"external_dosage_override_reason";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" id=\"external_interaction_override_reason";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" id=\"external_contra_override_reason";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" id=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" id=\"external_db_dose_check_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" id=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"3%\" >\n\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t  <td NOWRAP width=\"12\" class=\"label\" id=\"ADR_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"ADR_img_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'></img>\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"external_img";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" name=\"external_img";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"ALLERGY\" id=\"allergy_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"allergy_img";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"DOSELIMIT\" id=\"dosage_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"dosage_img";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"CURRENTRX\" id=\"currentrx_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"currentrx_img";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"34%\">&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"drug_name";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"  name=\"drug_name";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" size=\"42\"  maxlength=\"42\" value=\"\" disabled onblur=\"deleteDrug(this,";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" name=\"drug_search";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" value=\"?\" class=\"button\"  disabled  onClick=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =")\"></td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"5%\"> \n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"strength";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">&nbsp;</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"10%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"form";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">&nbsp;</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"16%\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"absol_qty";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" name=\"absol_qty";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" value=\"\" disabled size=\"6\" maxlength=\"6\" onblur=\"CheckNum(this);extdosechk();\" onKeyPress=\"return allowValidNumber(this,event,6,0);\" class=\"number\">&nbsp;\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"qty";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">&nbsp;</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"8%\" >\n\t\t\t\t\t\t\t<A style=\"visibility:hidden\" id=\"remarks_";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"  name=\"remarks_";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" onMouseOver=\"changeCursor(this);\" HREF=\"javascript:getRemarks(\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\',\'Y\')\">";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t\t\t\t\t<!-- added for [IN:039576]-end -->\n\t\t\t\t\t\t\t<a style=\"visibility:hidden\" href=\"javascript:drugindication_remarks(\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"><!--Added for ML-BRU-CRF-072[Inc:29938] -->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"14%\">\n\t\t\t\t\t\t\t<input style=\"visibility:hidden\" type=\"button\" class=\"button\" width=\"8%\" value=\"Override\" id=\"dosage_limit";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" onclick=\"overRideRemarks(drug_code";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =".value,\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\')\">&nbsp;<input disabled style=\"visibility:hidden\" type=\"checkbox\" width=\"2%\" id=\"chk_ovr";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" onclick=\"\"> \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_class";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ALLERGY_DESC";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" value=\"\">\n\t\t\t\t\t\t<!-- Added for IN:072715 start -->\t\t\n      \t\t\t\t\t <input type=\"hidden\"  name=\"allergy_remarks_code";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" value=\"\">\n      \t\t\t\t\t <!-- Added for IN:072715 end -->\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\"\t value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" value=\"\">\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t<tr height=\"4\">\n\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADERCENTER\" colspan=\"12\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr height=\"8\">\n\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"15%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t<input type=\"text\" name=\"dosage\" id=\"dosage\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =" onBlur=\"CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" size=\"2\"  maxlength=\"3\" style=\"text-align:right\">&nbsp;\n\t\t\t\t\t<label  class=\"label\" id=\"qty_uom\" name=\"qty_uom\">";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</label>\n\t\t\t\t</td> \n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t<select name=\"frequency\" id=\"frequency\" ";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 =" onChange=\"ValidateDosage(); setSchedule(dosage.value);extdosechk();\" style=\"width:200;\">\n\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =" ---&nbsp;&nbsp;&nbsp; </option>\n";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" Selected >";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="</option>\n";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t<input type=\"button\" name=\"btn_schedule\" id=\"btn_schedule\" value=\"Schedule\" disabled class=\"button\" onClick=\"DisplaySchedule()\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"  id=\"dosage_label\" nowrap>&nbsp;</td>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"admixture\" id=\"admixture\"  value=\"Y\" CHECKED DISABLED>&nbsp;&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t<!-- RUT-CRF-0062 [IN029600] buildMAR_ynEnable flag added to enable / disable based on Build MAR Rule -->\t\n\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"buildMAR_yn\" id=\"buildMAR_yn\"  value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =" ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 =" >\t\n\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr height=\"8\">\n\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t\t<td class=\"label\" width=\"15%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"5%\" nowrap class=\'label\'>\n\t\t\t\t\t<input type=\"text\" size=\"1\" maxlength=\"11\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\"  onBlur=\"validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" >&nbsp;\n\t\t\t\t\t<label id=\"durn_desc\" class=\"label\"></label>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"20%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"20%\">\n\t\t\t\t\t<input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"14\"  maxlength=\"16\" onBlur=\"if(CheckDateLeap(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\')) populateEndDate();\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" > <!-- Changed from onBlur=\"populateEndDate();\" to onBlur=\"if(CheckDateLeap(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\')) populateEndDate();\" RollForward from SRR - SRR20056-SCF-9368 [IN:057068]-->\n\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\"  ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="  id=\'Calendar\' name=\'Calendar\' onclick=\"if(document.prescription_compdetail_form.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_compdetail_form.start_date.focus();return false;\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"20%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"end_date\" id=\"end_date\"  value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\"  size=\"14\"  maxlength=\"13\" value=\"\" disabled>\n\t\t\t\t</td>\n\t\t\t</tr> \n\t\t\t<tr height=\"8\"><td colspan=\"12\"></td></tr>\n\t\t</table>\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t<table  border=\"2\" bordercolor=\"black\" width=\"100%\">\n\t\t\t\t<tr> \n\t\t\t\t\t<td NOWRAP width=\"15\" class=\"ALLERGY\">\n\t\t\t\t\t\t<img src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td NOWRAP  style=\"font-size:7pt\" class=\"label\" border=\"0\" bordercolor=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP width=\"15\" class=\"DOSELIMIT\"  border=\"1\" bordercolor=\"black\">\n\t\t\t\t\t\t<img src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP  style=\"font-size:7pt\" class=\"label\" border=\"0\" bordercolor=\"label\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP width=\"15\" class=\"CURRENTRX\"\n\t\t\t\t\tborder=\"1\" bordercolor=\"black\">\n\t\t\t\t\t\t<img src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP style=\"font-size:7pt\" class=\"label\" border=\"0\" bordercolor=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t</td> \n\t\t\t\t</tr> \n\t\t\t\t<tr height=\"8\">\n\t\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t<input type=\"hidden\" name=\"no_of_drugs\" id=\"no_of_drugs\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"prescription_compdetail_form\" id=\"prescription_compdetail_form\" >\n\t\t\t<!-- Prescription Writer Table starts-->\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'12%\'>&nbsp;";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</td>\n\t\t\t\t\t\t<td class=\'label\' width=\'8%\'><label for=\"r1\"><input type=\'radio\' name=\'pres_by\' id=\'pres_by\' value=\'S\' id=\"r1\" onClick=\'changePrescribingBy(this)\' checked>";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</label></td>\n\t\t\t\t\t\t<td class=\'label\' width=\'6%\'><label for=\"r2\"><input type=\'radio\' name=\'pres_by\' id=\'pres_by\' value=\'R\' id=\"r2\" onClick=\'changePrescribingBy(this)\'>";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</label></td>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'><label for=\"r3\"><input type=\'radio\' name=\'pres_by\' id=\'pres_by\' value=\'P\' id=\"r3\" onClick=\'changePrescribingBy(this)\'>";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="%</label></td>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =" &nbsp;<input type=\'text\' value=\"\" name=\'final_prod_qty\' id=\'final_prod_qty\' size=\'5\' maxlength=\'3\' onKeyPress=\"return allowValidNumber(this,event,3,0);\" onBlur=\"percentageRatioCalculation(\'NX\');\" disabled>&nbsp;<select name=\'final_prod_qty_uom\' id=\'final_prod_qty_uom\' onChange=\"changeFinalProductQtyUOM(this);\" disabled><option value=\"\">-- ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 =" --</option>\n";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\" id=\'mandImage1\' name=\'mandImage1\' align=\"center\" style=\"display:none;\"></td>\n\t\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<div id=\"bar\" style=\"overflow: auto; height: 88px; width: 100%;\">\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" >";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" >";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" id=\"perc_rat_header\" name=\"perc_rat_header\" style=\"display:\" >";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" id=\"req_qty_header\" name=\"req_qty_header\" style=\"display:\" >";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" id=\"absol_qty_header\" name=\"absol_qty_header\">";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" ></td>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" ></td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"5%\" >\n\t\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=\"0\">\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t   \t<td NOWRAP width=\"12\" class=\"label\" id=\"ADR_";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"ADR_img_";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\' ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t    \n\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external_";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" style=\"visibility:hidden\" onclick=\"displayDosageCheckResult(";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 =")\">\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"external_img";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" src=\'../../ePH/images/exceed1.gif\'  ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"ALLERGY\" id=\"allergy_";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" style=\"visibility:hidden\"  onclick=\"showAllergyDetails(generic_id";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\',encodeURIComponent(generic_name";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 =".value),encodeURIComponent(drug_name";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =".value));\" onmouseover=\"changeCursor(this);\" >\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"allergy_img";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"DOSELIMIT\" id=\"dosage_";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"dosage_img";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" src=\'../../ePH/images/exceed1.gif\'  ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"CURRENTRX\" id=\"currentrx_";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"currentrx_img";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"38%\" nowrap>\t\t\n\t\t\t\t\t\t\t\t<label for=\"baseDrugId";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" id=\"lblBaseDrugId";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\" name=\"lblBaseDrugId";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" style=\'display:none;\'><input type=\'radio\' name=\'baseDrug\' id=\'baseDrug\' id=\'baseDrugId";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\' onClick=\"selectBaseDrug(this)\" value=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'/>";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="</label>\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"drug_name";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" size=\"42\"  maxlength=\"42\" value=\"\" onblur=\"deleteDrug(this,";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =")\" onChange=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 =")\" ><!-- added for SKR-SCF-1391 -->\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="<!-- commented for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t<input type=\"button\" name=\"drug_search";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" value=\"?\" class=\"button\"  onClick=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 =")\">&nbsp;&nbsp; <!-- REMOVED onFocus for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t<img style=\"visibility:hidden;cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20 id=\"drug_info_";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\"  width=20 onClick=\"loadDrugInfo(document.prescription_compdetail_form,";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 =")\">\n\t\t\t\t\t\t\t\t<img style=\"visibility:hidden;cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(drug_code";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 =".value);\" id=\"edl_info_";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" name=\"edl_info_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td NOWRAP class=\"label\"  width=\"9%\">\n\t\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"strength";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\"></label></b>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\"  width=\"10%\">\n\t\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"form";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\"></label></b>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" id=\"perc_rat_col";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" name=\"perc_rat_col";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" style=\"display:;width: 9%;\">\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"percent_ratio";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" id=\"percent_ratio";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" value=\"\" size=2 onKeyPress=\"return percentageRatioValidation(this)\" onBlur=\"percentageRatioCalculation(\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\',\'PR\')\"><label class=\'label\' id=perc";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 =" name=perc";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 =" style=\"display:none;font-size:7pt\">%</label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" id=\"req_qty_col";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" name=\"req_qty_col";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" style=\"display:none;\" nowrap>\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"req_qty";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\" id=\"req_qty";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" value=\"\" size=1  maxlength=\"6\" disabled style=\"text-align:right;\"><div class=\'label\' id=\'req_qty_uom";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\' name=\'req_qty_uom";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\' style=\"display:none;font-size:7pt\"></div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\"  width=\"15%\" nowrap>\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"absol_qty";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\" value=\"\" size=\"3\" maxlength=\"6\" onblur=\"CheckNum(this);extdosechk();calculateOrderQuantiyInStrengthMode(\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\')\" onKeyPress=\"return allowValidNumber(this,event,6,0);\" class=\"number\">\n\t\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"qty";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\"></label></b>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\"  width=\"6%\" nowrap>\n\t\t\t\t\t\t\t\t<A style=\"visibility:visible\" id=\"remarks_";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</A>\n\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-start -->\n\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg_";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory_";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' value=\'N\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered_";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t\t\t\t\t\t\t\t<!-- added for [IN:039576]-end -->\n\t\t\t\t\t\t\t\t<a style=\"visibility:hidden\" href=\"javascript:drugindication_remarks(\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="</a>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks_";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\"><!--Added for ML-BRU-CRF-072[Inc:29938] -->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"label\" width=\"16%\" nowrap>\n\t\t\t\t\t\t\t\t<input style=\"visibility:hidden\" type=\"button\" class=\"button\" width=\"6%\" value=\"Override\" id=\"dosage_limit";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\"  name=\"dosage_limit";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\')\" > \n\t\t\t\t\t\t\t<!-- Modified for IN:072715 START -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\n\t\t\t\t\t\t\t\t<input style=\"visibility:hidden\" type=\"checkbox\" width=\"2%\" id=\"chk_ovr";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\')\" >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n\t\t\t\t\t\t\t\t<!-- Modified for IN:072715 START -->\n\t\t\t\t\t\t\t\t<A title=\"TDM Result\" style=\"visibility:hidden\" id=\"tdmRslt_";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" name=\"tdmRslt_";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" HREF onMouseOver=\"changeCursor(this);\" onClick=\"viewReasonforRequest(tdmOrderId";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</A>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_class";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\"\t\tvalue=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\"\tvalue=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom_need";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\" id=\"strength_uom_need";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\"\tvalue=\"\"><!-- //added for CRF--0749 INC-13640 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tdmOrderId";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" id=\"tdmOrderId";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\"\t\tvalue=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ALLERGY_DESC";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"EXCEED_DOSE_DESC";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"DUP_DRUG_DESC";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" value=\"\">\t\n\t\t\t\t\t\t\t<!-- Added for IN:072715 start -->\t\t\n      \t\t\t\t\t <input type=\"hidden\"  name=\"allergy_remarks_code";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" value=\"\">\n      \t\t\t\t\t <!-- Added for IN:072715 end -->\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" id=\"pres_base_uom";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom_need";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" id=\"pres_base_uom_need";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\" value=\"\"><!-- //added for CRF--0749 INC-13640 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_prod_id_";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" value=\"\">\n\t\t\t\t\t\t\t<!-- <input type=\"hidden\" name=\"external_override_reason_";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" id=\"external_override_reason_";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" value=\"\"> -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\" value=\"N\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" value=\"N\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" value=\"N\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" value=\"N\">\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"equvalentUOM_conversion_value";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\" id=\"equvalentUOM_conversion_value";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"equvalentUOM_conversion_factor";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" id=\"equvalentUOM_conversion_factor";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"contentInPresBaseUOM";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" id=\"contentInPresBaseUOM";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"orderQty";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" id=\"orderQty";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"orderQtyUOM";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" id=\"orderQtyUOM";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Perform_ext_db_checks_YN";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" id=\"Perform_ext_db_checks_YN";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" value=\"N\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"generic_id";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\" id=\"generic_id";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"generic_name";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\" id=\"generic_name";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\"\tvalue=\"\">\n\t\t\t\t\t\t\t<!-- added for ML-MMOH-CRF-1408 start-->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"max_daily_celing_dose";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\" id=\"max_daily_celing_dose";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"min_daily_ceiling_dose";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" id=\"min_daily_ceiling_dose";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"max_unit_ceiling_dose";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" id=\"max_unit_ceiling_dose";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"min_unit_ceiling_dose";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" id=\"min_unit_ceiling_dose";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\"\tvalue=\"\">\n\t\t\t\t\t\t\t<!-- added for ML-MMOH-CRF-1408 end-->\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!-- <tr><td colspan=\"12\">------------------------------</td></tr> -->\n";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\n\t\t\t\t\t <tr height=\"4\">\n\t\t\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t\t\t</tr> \n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<hr>\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr><td class=\"label\" width=\'30%\' id=\'ratiofooter\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\"label\" width=\'20%\'><div class=\"label\" id=\'ratiolabel\' name=\'ratiolabel\' style=\"display:none\">";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 =":&nbsp;</div></td>\n\t\t\t\t\t\t<td class=\"label\" width=\'13%\'>";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="</td>\n\t\t\t\t\t\t<td><input type=\'text\' value=\"\" name=\'txt_total_quantity\' id=\'txt_total_quantity\' size=7 style=\"text-align:right\" disabled>&nbsp;<div class=\'label\' id=\'txt_total_quantity_uom\' name=\'txt_total_quantity_uom\' style=\"display:none\"></div></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADERCENTER\" colspan=\"12\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr height=\"2\"><td colspan=\"12\"></td></tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"40%\" nowrap>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"dosage\" id=\"dosage\" value=\"\"  onBlur=\"CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" size=\"2\"  maxlength=\"3\" style=\"text-align:right\">&nbsp;<select name=\"uom\" id=\"uom\" onChange=\"\">\n\t\t\t\t\t\t\t\t<option value=\"\">-- ";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 =" --</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"5\">\n\t\t\t\t\t\t\t<select name=\"frequency\" id=\"frequency\" onChange=\"ValidateDosage();setSchedule();extdosechk();\" style=\"width:460;\">\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp; --- ";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<input type=\"button\" name=\"btn_schedule\" id=\"btn_schedule\" value=\"Schedule\" disabled class=\"button\" onClick=\"DisplaySchedule()\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\'10%\' id=\"dosage_label\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr height=\"4\">\n\t\t\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\"7%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"18%\" nowrap>\n\t\t\t\t\t\t\t<input type=\"text\" size=\"1\" maxlength=\"11\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"\"  onBlur=\"validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" >&nbsp;<!--<label id=\"durn_desc\" class=\"label\"></label>--><select name=\"durn_type_desc\" id=\"durn_type_desc\" onChange=\'validateDuration(durn_value);populateEndDate();extdosechk();\'></select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"10%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"20%\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"14\"  maxlength=\"16\" onBlur=\"if(CheckDateLeap(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" >  <!-- Changed from onBlur=\"populateEndDate();\" to onBlur=\"if(CheckDateLeap(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\')) populateEndDate();\" RollForward from SRR - SRR20056-SCF-9368 [IN:057068]--> \n\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\"   id=\'Calendar\'  name=\'Calendar\'  onclick=\"if(document.prescription_compdetail_form.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_compdetail_form.start_date.focus();return false;\" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"end_date\" id=\"end_date\" size=\"14\"  maxlength=\"13\" value=\"\" disabled>\n\t\t\t\t\t\t\t<td class=\"label\" colspan=2>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"admixture\" id=\"admixture\"  value=\"Y\" CHECKED DISABLED>&nbsp;&nbsp;";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\n<!-- RUT-CRF-0062 [IN029600] buildMAR_ynEnable flag added to enable / disable based on Build MAR Rule -->\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"buildMAR_yn\" id=\"buildMAR_yn\"  value=\"";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 =" onclick=\'assignCheckValue(this);\'>\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr height=\"4\"><td colspan=\"12\"></td></tr>\n\t\t\t\t</table>\n\n\t\t\t\t<br>\n";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\n<!-- Prescription Writer Table ends-->\n    \n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\t\tvalue=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\"> \n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\n\t\t\t<input type=\"hidden\" name=\"qty_value\" id=\"qty_value\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\">\n\t\t\t<input type=\"hidden\" name=\"durn_type\" id=\"durn_type\"\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\"\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"qty_desc_code\" id=\"qty_desc_code\"\t\tvalue=\"\"><!-- Added in January 2014 for CIMS dosage check -->\n\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\"\t\t\tvalue=\"\"><!-- Added in January 2014 for CIMS dosage check -->\n\t\t\t<input type=\"hidden\" name=\"repeat_durn_type\" id=\"repeat_durn_type\"\tvalue=\"\"><!-- Added in January 2014 for CIMS dosage check -->\n\t\t\t<input type=\"hidden\" name=\"sched_medn_yn\" id=\"sched_medn_yn\"\t\tvalue=\"N\">\n\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\"\tvalue=\"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\"\tvalue=\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\"><!--added for ML-MMOH-CRF-1408 -->\n\t\t\t<input type=\'hidden\' name=\'ext_disp_appl_yn\' id=\'ext_disp_appl_yn\' value=\'";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\'><!--added for NMC-JD-CRF-0046 -->\n\t\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" name=\"validate_overide_on_confirm_yn\"><!-- Added for IN:069887  -->\n\t\t\t\n\t\t\t<label id=\"tool_tip\" style=\"visibility:hidden\"></label>\n\n\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=\'0\' cellspacing=\'0\' border=\"0\" width=\"auto\" height=\"100%\"  align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"100%\" id=\"t\"  ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t</form>\n";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\n\t</body>\n";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\n\t\t\t<script>\n\t\t\t\tmakeScheduleLink(\'";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\');\t\n\t\t\t</script>\n";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\n\t\t<script>\n\t\t\t//extdosechk();\n\t\t\tfor(i=1;i<=4;i++){\n//\t\t\t\teval(\"document.getElementById(\"external_img\")\"+i).style.visibility=\"hidden\";\n//\t\t\t\teval(\"document.getElementById(\"external_img\")\"+i).style.visibility=\"visible\";\n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\n\t\t\t<script>\n\t\t\t\tsetSchedule();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\n\t<script>\n\t\tpopulateDurationDesc(document.getElementById(\'frequency\'));\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
16/4/2020		IN072917			Shazana												SKR-SCF-1317
10/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
03/07/2020  IN:072715       Haribabu  25/06/2020     Manickavasagam     MMS-DM-CRF-0165
20/07/2020      IN:073424		   Prabha												SKR-SCF-1391      
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{
	String patient_id						= request.getParameter("patient_id") ;
	String encounter_id						= request.getParameter("encounter_id");
	String adr_count						= request.getParameter("adr_count");	
	String priority							= "";
	String start_time						= "";
	String drug_code						= "";
	String srl_no							= "";
	String bsa								= "";
	String weight							= "0";
  	String iv_bean_id						= "IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name						= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean				= (IVPrescriptionBean)getBeanObject( iv_bean_id,iv_bean_name, request) ;

	//Start of NMC-JD-CRF-0046
	String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
	String iv_prep_yn		= "";
	//End of NMC-JD-CRF-0046
	//Added for IN:072715 start
	Connection con			= null; 
	con				= ConnectionManager.getConnection(request);
	boolean over_ride_remarks_select_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");
	//Added for IN:069887 start
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
	String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}
	//Added for IN:069887 end
	if(con != null)
		ConnectionManager.returnConnection(con,request);
	//Added for IN:072715 end
    iv_bean.setLanguageId(locale);
    String facility_id						=  (String)session.getValue("facility_id");
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
    String param_bean_name					= "ePH.DrugInterfaceControlBean";
    DrugInterfaceControlBean param_bean		= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
    String drug_db_interface_yn				=	param_bean.getDrugDBInterface_yn(facility_id);  
	String drug_db_dosecheck_yn			    =	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn			=   param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn		=   param_bean.getDrugDBInteract_check_yn(facility_id);
	String drug_db_contraind_check_yn		=   param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn			=   param_bean.getDrugDBAllergy_check_yn(facility_id);
	param_bean.clear();

	String or_bean_name						= "eOR.OrderEntryBean";
	String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
	orbean.setLanguageId(locale);

	String pract_id							= (String) orbean.getPractitionerId();
	String servide_code						= (String) orbean.getServiceCode();
	String resp_id							= (String) orbean.getResponsibilityId();   
	ArrayList frequency						=  iv_bean.loadFrequency();   
	String calling_mode						=  request.getParameter("mode") ;
	String patient_class					=  request.getParameter("patient_class")==null?"": request.getParameter("patient_class");
	String act_patient_class				=  request.getParameter("act_patient_class");
	String atc_allergy_alert_level				=  request.getParameter("atc_allergy_alert_level")==null?"N":request.getParameter("atc_allergy_alert_level");
	iv_bean.setATCAllergyLevel(atc_allergy_alert_level);
	String external_prod_id					=  "";
	String interaction_override_reason		=  "";
	String contraind_override_reason		=  "";
	String DrugRemarksEntered			=	"";//added for [IN:039576]

    String allergy_override_reason_flag			=  "N";	
	String duplicate_drug_override_reason_flag	=  "N";
	String interaction_override_reason_flag		=  "N";
	String contraind_override_reason_flag		=  "N";
	String adr_display_yn						="hidden";
	String ext_image_display					="hidden";

	String drug_desc = "",freq_code = "",qty_value = "",qty_unit = "",durn_vlaue = "",order_qty = "",order_uom = "",start_date	= "",end_date = "",order_id	= "",temp = "", form_desc = "",strength_value = "",strength_uom	= "", pres_remarks = "", allergy_override_reason	= "",dosage_limit_override_reason		= "", duplicate_drug_override_reason	= "",allergy_flag = "hidden",doselimit_flag	= "hidden",currentrx_flag	= "hidden",over_ride_flag	= "hidden",no_of_drugs	= "", order_line_num = "",repeat_value = "", amnd_drg_code = "",disableflag	= "", tdmOrderIdAmnd = "",display_tdm = "", buildMAR_yn="", buildMAR_ynCheck="",ext_over_ride_flag	= "hidden";
// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin	
	String buildMAR_ynEnable =""; 
	String buildMAR_rule =""; 
// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end	
	String allergy_yn						= "N";
	String allergy_rsn_flag					= "hidden";
	String currentrx_yn						= "N";
	String currentrx_rsn_flag				= "hidden";
	String limit_ind						= "N";
	String height							= "0"; //ML-MMOH-CRF-1408
	//Added for IN:072715 start
	String allergy_remarks_code="",dose_remarks_code="",currentrx_remarks_code="";
	//Added for IN:072715 end
	HashMap chkValuescheduleFrequency		= null;
    ArrayList frequencyValues				= null;
	HashMap drugReasons						= null;
	int tem									=   0;
	//String ex_bean_id						= "@ExternalProductLinkBean"+patient_id+encounter_id;
    String ex_bean_id						= "@ExternalProductLinkBean";
	String ex_bean_name						= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex			= (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

	String dup_drug_det						= "";
	HashMap drug_Interactions				= null;
	ArrayList exProd						= new ArrayList();
	ArrayList drugDesc						= new ArrayList();

	String drug_db_contraind_check_flag		= "N";
	String drug_db_interact_check_flag		= "N";
	String drug_db_duptherapy_flag			= "N";
	String drug_db_dose_check_flag			= "N"; 
	String drug_db_allergy_flag				= "N";

	ArrayList prescriptionDetails			= new ArrayList();

	HashMap ext_drugData					= null;
	String ext_drug_code					= null;

	HashMap freq_vals						= new HashMap();
    String freq_interval_value				= "";
	String freq_repeat_value				= "";
	String freq_frequency					= "";
	HashMap drugDosageResult				= null;
    ArrayList dosageCheckParams				= null;
    ArrayList AllUOMs						= new ArrayList();
	String presc_base_uom					= "";
	String generic_id="", generic_name ="", DrugIndicationRemarks="";
	iv_bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));
	
	//Start of NMC-JD-CRF-0046
	String ext_disp_appl_yn="";
	ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type, location_code, take_home_medication, priority, iv_prep_yn, "", patient_id, encounter_id);
	if(ord_disp_location !=null && ord_disp_location.size()>0)
	{
	String  disp_loc = (String)ord_disp_location.get(0);
	ext_disp_appl_yn = iv_bean.getExtDispYN(disp_loc);
	}
	//End of NMC-JD-CRF-0046	
	
	if(calling_mode.equals("amend") || calling_mode.equals("RENEW_ORDER") ){

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				if(calling_mode.equals("RENEW_ORDER")){
					 disableflag="disabled";
				}
				priority				= request.getParameter("priority") ;
				start_time				= request.getParameter("start_date") ;
				srl_no					= request.getParameter("srl_no") ;
				order_id                = request.getParameter("order_id") ;
				weight					= request.getParameter("weight");
				bsa						= request.getParameter("bsa");
				if((weight == null) || weight.equals("")){weight = "0";}
				if((bsa == null) || (bsa.equals("")))   {bsa = "0";}

				ArrayList comp_drugs    = new ArrayList();
				HashMap drug_dtls       = new HashMap();

				String act_pat_class	= request.getParameter("act_pat_class")==null?act_patient_class:request.getParameter("act_pat_class");  // RUT-CRF-0062
				comp_drugs=iv_bean.getCompDrugDtls(order_id,act_pat_class); // RUT-CRF-0062 Added actual patient class to get the Build MAR Rule
				if(comp_drugs != null){
					no_of_drugs = comp_drugs.size()+"";

				 HashMap drug_data=new HashMap();
                 for(int i=0;i<comp_drugs.size();i++){
					drug_data	=	(HashMap)comp_drugs.get(i);					
					drugDesc.add((String)drug_data.get("DRUG_DESC"));
					external_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID");

					if(!external_prod_id.equals("")){
					     exProd.add(external_prod_id);
					}
				 }
				 /*
				 if(exProd.size()>0)
					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids*/
				external_prod_id="";
				for(int i=0;i<comp_drugs.size();i++){
	  				ext_image_display				="hidden";
					drug_db_contraind_check_flag	=	"N";
					drug_db_interact_check_flag		=	"N";
					drug_db_duptherapy_flag			=	"N";
					drug_db_dose_check_flag			=	"N"; 
					drug_db_allergy_flag				=	"N";
					allergy_yn						=	"N";
					allergy_rsn_flag				= "hidden";
					currentrx_yn					=   "N";
					currentrx_rsn_flag				=  "hidden";
					external_prod_id				= "";
					freq_vals		                = new HashMap();
					freq_interval_value		        = "";
					freq_repeat_value	            = "";		
					freq_frequency					= "";
					DrugIndicationRemarks					= "";//Added for ML-BRU-CRF-072[Inc:29938]
					drug_dtls=(HashMap)comp_drugs.get(i);

					if(drug_dtls != null){
						drug_code       =(String)drug_dtls.get("ORDER_CATALOG_CODE"); 
						iv_bean.setDrugDetails(drug_code+",",pract_id,resp_id,"","","","");  //CRF-0062 
						  
						drug_desc       =(String)drug_dtls.get("CATALOG_DESC");
						freq_code       =(String)drug_dtls.get("FREQ_CODE");
						qty_value       =(String)drug_dtls.get("QTY_VALUE");
						qty_unit        =(String)drug_dtls.get("QTY_UNIT");
						durn_vlaue      =(String)drug_dtls.get("DURN_VALUE");
						order_qty       =(String)drug_dtls.get("ORDER_QTY");
						order_uom       =(String)drug_dtls.get("ORDER_UOM");
						start_date      =(String)drug_dtls.get("START_DATE_TIME");
						srl_no			=(String)drug_dtls.get("ORDER_LINE_NUM");
						end_date        =(String)drug_dtls.get("END_DATE_TIME");
						buildMAR_yn     =(String)drug_dtls.get("BUILDMAR_YN");
						allergy_yn		=(String)drug_dtls.get("ALLERGY_YN");
						currentrx_yn	=(String)drug_dtls.get("CURRENT_RX");
						presc_base_uom	=(String)drug_dtls.get("PRES_BASE_UOM");
						generic_id			= drug_dtls.get("GENERIC_ID")==null?"":(String)drug_dtls.get("GENERIC_ID");
						generic_name		= drug_dtls.get("GENERIC_NAME")==null?"":(String)drug_dtls.get("GENERIC_NAME");
						DrugIndicationRemarks	= (String)drug_dtls.get("DRUG_INDICATION");// Added for ML-BRU-CRF-072[Inc:29938]
						if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); 

						/*   RUT-CRF-0062 [IN029600] Commented and Added to get Build MAR Rule CRF 0062 -- begin
						if(buildMAR_yn.equals("Y"))
							buildMAR_ynCheck="checked";
						else{
							buildMAR_ynCheck="";
							buildMAR_yn = "N";
						}
						*/
						if(i==0)  {               // To load the build MAR based on the first drug
							buildMAR_rule	=drug_dtls.get("BUILD_MAR_RULE").toString();
						}
						buildMAR_yn="N";
						if(buildMAR_rule==null){
							buildMAR_rule="";
						}
						if(buildMAR_rule.equals("CE")){
							buildMAR_ynCheck ="checked";		
							buildMAR_ynEnable="";
							buildMAR_yn="Y";
						}
						else if(buildMAR_rule.equals("UE")){
							buildMAR_ynCheck ="";		
							buildMAR_ynEnable="";
						}
						else if(buildMAR_rule.equals("CD")){
							buildMAR_ynCheck ="checked";		
							buildMAR_ynEnable="disabled";
							buildMAR_yn="Y";
						}
						else if(buildMAR_rule.equals("UD")){
							buildMAR_ynCheck ="";		
							buildMAR_ynEnable="disabled";
						}
						
						if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
						{
							buildMAR_ynEnable="disabled";
							buildMAR_ynCheck="";
							buildMAR_yn="N";
						}
						
						iv_bean.setBuildMAR_yn(buildMAR_yn);
						//}
						
						//RUT-CRF-0062 [IN029600] Commented and Added to get Build MAR Rule CRF 0062 -- end
						if(calling_mode.equals("RENEW_ORDER")){
							start_date=iv_bean.comp_date_time(end_date,order_id,1+"");
						}
						form_desc       =(String)drug_dtls.get("FORM_DESC");
						strength_value  =(String)drug_dtls.get("STRENGTH_VALUE");
						strength_uom    =(String)drug_dtls.get("STRENGTH_UOM");
						if(strength_uom == null) strength_uom="";               

						external_prod_id				=	(String)drug_dtls.get("EXTERNAL_PRODUCT_ID");	

						freq_vals					 = (HashMap)iv_bean.freqValidate(freq_code);
				        freq_interval_value          = (String)freq_vals.get("interval_value");
						freq_repeat_value            = (String)freq_vals.get("repeat_value");
						if(!freq_interval_value.equals("") && !freq_repeat_value.equals("")){
							freq_frequency				= (int)Math.ceil( Integer.parseInt(freq_repeat_value) / Integer.parseInt(freq_interval_value))+"";
						}
						// if(drug_db_interface_yn.equals("Y") ){
							allergy_override_reason			=	(String)drug_dtls.get("ALLERGY_OVERRIDE_REASON");

							dosage_limit_override_reason	=	(String)drug_dtls.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							duplicate_drug_override_reason	=	(String)drug_dtls.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							//Added for IN:072715 start
							allergy_remarks_code	=	(String)drug_dtls.get("ALLERGY_REMARKS_CODE")==null?"":(String)drug_dtls.get("ALLERGY_REMARKS_CODE");
							dose_remarks_code	=	(String)drug_dtls.get("DOSE_REMARKS_CODE")==null?"":(String)drug_dtls.get("DOSE_REMARKS_CODE");
							currentrx_remarks_code	=	(String)drug_dtls.get("CURRENTRX_REMARKS_CODE")==null?"":(String)drug_dtls.get("CURRENTRX_REMARKS_CODE");
							//Added for IN:072715 end
							interaction_override_reason		=	(String)drug_dtls.get("INTERACTION_OVERRIDE_REASON");
							contraind_override_reason		=	(String)drug_dtls.get("CONTRAIND_OVERRIDE_REASON");
							if(!allergy_override_reason.equals("")){
								allergy_override_reason_flag="Y";
								allergy_rsn_flag = "hidden";
							}
							else{
								allergy_override_reason_flag="N";		
								allergy_rsn_flag = "visible";
							}
							if(!duplicate_drug_override_reason.equals("")){
								duplicate_drug_override_reason_flag="Y";
								currentrx_rsn_flag = "hidden";
							}
							else{
								duplicate_drug_override_reason_flag="N";
								currentrx_rsn_flag = "visible";
							}
							if(!interaction_override_reason.equals("")){
								interaction_override_reason_flag="Y";
							}
							else{
								interaction_override_reason_flag="N";		
							}
							if(!contraind_override_reason.equals("")){
								contraind_override_reason_flag="Y";
							}
							else{
								contraind_override_reason_flag="N";
							}

							if(!allergy_override_reason.equals("") || !duplicate_drug_override_reason.equals("") || !interaction_override_reason.equals("") || !contraind_override_reason.equals("")){
								ext_image_display					="visible";
							}else{
								ext_image_display					="hidden";
							}
						//}
						//else{               

							drugReasons=new HashMap();
							allergy_override_reason			="";
							dosage_limit_override_reason	="";
							duplicate_drug_override_reason	="";
							//Added for IN:072715 start
							allergy_remarks_code="";
							dose_remarks_code="";
							currentrx_remarks_code="";
							//Added for IN:072715 end
							allergy_flag	="hidden";
							doselimit_flag	="hidden";
							currentrx_flag	="hidden";
							over_ride_flag	="hidden";
							ext_over_ride_flag = "hidden";

							drugReasons=iv_bean.getDrugReasons(order_id,(i+1)+"","");
							allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");

							dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							//Added for IN:072715 start
							allergy_remarks_code	=	(String)drugReasons.get("ALLERGY_REMARKS_CODE")==null?"":(String)drugReasons.get("ALLERGY_REMARKS_CODE");
							dose_remarks_code	=	(String)drugReasons.get("DOSE_REMARKS_CODE")==null?"":(String)drugReasons.get("DOSE_REMARKS_CODE");
							currentrx_remarks_code	=	(String)drugReasons.get("CURRENTRX_REMARKS_CODE")==null?"":(String)drugReasons.get("CURRENTRX_REMARKS_CODE");
							//Added for IN:072715 end
							if(!allergy_override_reason.equals(""))
								allergy_flag="visible";
							if(drug_db_interface_yn.equals("N") && !dosage_limit_override_reason.equals(""))
								doselimit_flag="visible";
							if(!duplicate_drug_override_reason.equals(""))
								currentrx_flag="visible";
							if((!allergy_override_reason.equals("")) || !dosage_limit_override_reason.equals("") || (!duplicate_drug_override_reason.equals(""))) 
								over_ride_flag="visible";

							if(doselimit_flag.equals("hidden")){
								limit_ind = "Y";		
								over_ride_flag="hidden";
							}
						//}
						// TDM
						tdmOrderIdAmnd = "";
						display_tdm = "display:none";
						tdmOrderIdAmnd			= iv_bean.getOrderIdForTDMDtls(patient_id,drug_code);

						if(tdmOrderIdAmnd==null ||tdmOrderIdAmnd.equals("")){
							display_tdm="display:none";
						}
						else{
							display_tdm="display:inline";
						} 
					}
					//  newly added code for ammending -> Remarks 
				  
					pres_remarks ="";
					ArrayList drug_remarks	=	iv_bean.getPrescribedRemarks(order_id,(i+1)+"");
				   
					if(drug_remarks.size()!=0) { 
						for(int x=0; x<drug_remarks.size(); x++) {	
							if(x==(drug_remarks.size()-1)) {	
								pres_remarks	= pres_remarks +	(String)drug_remarks.get(x);
							}
							else {
								pres_remarks	= pres_remarks +	(String)drug_remarks.get(x)+",";
							}
						} 
					} 
					/* if(!pres_remarks.equals(""))
						remarks_style	="visibility:visible";
					 else
						remarks_style	="visibility:hidden";
					*/
					// ---- Ends here 
				   if(Integer.parseInt(adr_count)>0){
						int  drug_adr_count = iv_bean.getADRCount(patient_id,drug_code); 
						if(drug_adr_count>0){

							adr_display_yn="visible";
						}else{
							adr_display_yn="hidden";
						}
					}
				
					if(drug_db_interface_yn.equals("Y") && !external_prod_id.equals("")){
						//beanex.storeDrugIds(patient_id,"",new ArrayList(),new ArrayList());//Store Drug ids
						/*
						beanex.removeSelectedDrugonAmend(external_prod_id);
						if(drug_db_duptherapy_yn.equals("Y")){ 
						   dup_drug_det			= beanex.isDuplicateTherapy(external_prod_id);//get dupluicate theraphy result
						   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
							   drug_db_duptherapy_flag="Y";
							   ext_image_display	  ="visible";
							   currentrx_flag		  ="hidden";
							   currentrx_yn			  = "N";
						}

						if(drug_db_interact_check_yn.equals("Y")){
						   beanex.getDDInteractions(external_prod_id);//Store interactions
							   drug_Interactions		= beanex.getInteractions();//get Interactions

							if(drug_Interactions.size()>0){							
								 drug_db_interact_check_flag="Y";
							}
						}

						if(drug_db_contraind_check_yn.equals("Y")){
							  ArrayList ex_prod_ids =new ArrayList();
							  ex_prod_ids.add(external_prod_id);
							  boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
							  HashMap contra_indications =(HashMap)beanex.getContraIndications();
							  if(contra_indications.containsKey(external_prod_id)){
								 drug_db_contraind_check_flag="Y";
							  }				  
						}

						if(drug_db_allergy_check_yn.equals("Y")){
							ArrayList ex_prod_ids =new ArrayList();
							ex_prod_ids.add(external_prod_id);
							beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
							beanex.DrugAlergyCheck(exProd,patient_id);//get drug alergy result
							HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
							if(drug_alergies.containsKey(external_prod_id)){
								drug_db_allergy_flag	= "Y";
								allergy_yn			= "N";
							}	
						}
						
						*/
						if(drug_db_dosecheck_yn.equals("Y")){
							//drugDosageResult = new HashMap();
							//	weight = "65";
							//	bsa = "10";
							dosageCheckParams        = new ArrayList();
							dosageCheckParams.add(patient_id);
							dosageCheckParams.add(external_prod_id);
							dosageCheckParams.add(weight);
							dosageCheckParams.add(bsa);
							dosageCheckParams.add(qty_value);//dose
							dosageCheckParams.add(presc_base_uom);//pres_base_uom
							dosageCheckParams.add(freq_frequency);
							dosageCheckParams.add(durn_vlaue);
							//Store Drug ids
							/*if(!weight.equals("") && !bsa.equals("")){
								drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);

								if(drugDosageResult != null && drugDosageResult.size() > 0){
									drug_db_dose_check_flag = "Y";						
								}
							}*/
						}
						if(exProd.size()>0 ){
							for(i=0;i<exProd.size();i++){
								if(exProd.get(i).equals(external_prod_id)) {
									drugDesc.remove(i);
									exProd.remove(i);
									break;
								}
							}
						}

						String storeIDs = "N";
						if(exProd.size()>0 )
							storeIDs = "Y";
							
						HashMap tempDetails= null;
						ArrayList reqChecks = new ArrayList();
						reqChecks.add(drug_db_dosecheck_yn); //Dosage Check 
						reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
						reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
						reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
						reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
						HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, start_date, end_date); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
						if(drugDBCheckResult!=null)
							beanex.setExternalDBCheckResult(external_prod_id,srl_no,drugDBCheckResult);

						if(drug_db_dosecheck_yn.equals("Y")){
							tempDetails = (HashMap)drugDBCheckResult.get("DOSECHECK");
							if(tempDetails != null && tempDetails.size() > 0){
								drug_db_dose_check_flag = "Y";						
							}
						}

						if(drug_db_allergy_check_yn.equals("Y")){
						   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
							   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
							   if(allergy_alert!=null && !allergy_alert.equals(""))
									drug_db_allergy_flag="Y";
									allergy_yn			= "N";
						   } 
						   else {  
								tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
								if(tempDetails!=null && tempDetails.size()>0){
									 drug_db_allergy_flag="Y";
									allergy_yn			= "N";
								}
							} 
						}

						if(drug_db_interact_check_yn.equals("Y")){
							tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
							if(tempDetails!=null && tempDetails.size()>0){
								 drug_db_interact_check_flag="Y";
							}
						}

						if(drug_db_duptherapy_yn.equals("Y")){ 
						   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
						   if(dup_drug_det!=null && !dup_drug_det.equals(""))
								drug_db_duptherapy_flag="Y";
						}
						if(drug_db_contraind_check_yn.equals("Y")){
							if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ //adding start for IN066787- Performance
								 tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */
								if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
										 drug_db_contraind_check_flag="Y";
									}
								}else{//Adding end for IN066787- Performance
										tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								  if(tempDetails!=null && tempDetails.containsKey(external_prod_id)){
									   drug_db_contraind_check_flag="Y";
								}		
								  else
									   drug_db_contraind_check_flag="N";
							}	
						}
					}
					if(drug_db_duptherapy_flag.equals("Y")){
						currentrx_flag="hidden";
						over_ride_flag="hidden";
						currentrx_rsn_flag = "hidden";
					}
					else if(currentrx_yn.equals("Y")){
						currentrx_flag="visible";
						if(!duplicate_drug_override_reason.equals("")){
							currentrx_rsn_flag = "hidden";
						}else{
							currentrx_rsn_flag = "visible";
						}
					}
					else if(currentrx_yn.equals("N")){
						currentrx_rsn_flag = "hidden";
					}

					if(drug_db_allergy_flag.equals("Y")){
						allergy_flag="hidden";
						over_ride_flag="hidden";
						allergy_rsn_flag = "hidden";
					}
					else if(allergy_yn.equals("Y")){
						allergy_flag="visible";	
						if(!allergy_override_reason.equals("")){
							allergy_rsn_flag = "hidden";
						}
						else{
							allergy_rsn_flag = "visible";
						}
					}
					else if(allergy_yn.equals("N")){
						allergy_rsn_flag = "hidden";
					}

					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
					drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

					if(drug_db_allergy_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_dose_check_flag.equals("Y")){ 
						ext_image_display	=	"visible";
					}
					else{
						ext_image_display	=	"hidden";
					}

					if(((drug_db_allergy_flag.equals("Y") && (allergy_override_reason.equals(""))) || (drug_db_duptherapy_flag.equals("Y") && (duplicate_drug_override_reason.equals("")))) || ((drug_db_interact_check_flag.equals("Y")) && interaction_override_reason.equals("")) || ((drug_db_contraind_check_flag.equals("Y")) && contraind_override_reason.equals("")) || ((drug_db_dose_check_flag.equals("Y")) && dosage_limit_override_reason.equals(""))){
						ext_over_ride_flag	=	"visible";
					}
					if(allergy_flag.equals("visible") || doselimit_flag.equals("visible") || currentrx_flag.equals("visible")){
						over_ride_flag="visible";
					}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(adr_display_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ext_image_display));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ext_over_ride_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(allergy_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(allergy_rsn_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doselimit_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(currentrx_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(currentrx_rsn_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_uom ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(over_ride_flag));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(currentrx_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(over_ride_flag));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(currentrx_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
}else{ 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(over_ride_flag));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block88Bytes, _wl_block88);
} 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(duplicate_drug_override_reason));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tdmOrderIdAmnd));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( srl_no ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(external_prod_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dosage_limit_override_reason));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(duplicate_drug_override_reason));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(interaction_override_reason));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(contraind_override_reason));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(allergy_override_reason));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_db_dose_check_flag));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block142Bytes, _wl_block142);
 
					tem=i+2; 

					prescriptionDetails	=	(ArrayList)iv_bean.getDrugDetails();
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData	=(HashMap) prescriptionDetails.get(j);
						ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
						if( drug_code.equals(ext_drug_code) ){
							if(!allergy_override_reason.equals("") ) {
								ext_drugData.put("ALLERGY_REMARKS",allergy_override_reason);
								ext_drugData.put("ALLERGY_OVERRIDE","Y");
								ext_drugData.put("ALLERGY_REMARKS_CODE",allergy_remarks_code);//Added for IN:072715 
							}

							if(!dosage_limit_override_reason.equals("")) {
								ext_drugData.put("DOSE_REMARKS",dosage_limit_override_reason);
								ext_drugData.put("DOSE_OVERRIDE","Y");
								ext_drugData.put("DOSE_REMARKS_CODE",dose_remarks_code);//Added for IN:072715 
							}

							if(!duplicate_drug_override_reason.equals("")) {
								ext_drugData.put("CURRENTRX_REMARKS",duplicate_drug_override_reason);
								ext_drugData.put("CURRENTRX_OVERRIDE","Y");
								ext_drugData.put("CURRENTRX_REMARKS_CODE",currentrx_remarks_code);//Added for IN:072715 
							}
							break;
						}
					}
				}
			}
			if(tem<= 4){
				for(int t=tem;t<=4;t++){ 

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(t));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(t));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(t));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(t));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(t));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(t));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(t));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(t));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(t));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(t));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(t));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(t));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(t));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(t));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(t));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(t));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(t));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(t));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(t));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(t));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(t));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(t));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(t));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(t));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(t));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(t));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(t));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(t));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(t));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(t));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(t));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(t));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(t));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(t));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(t));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(t));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(t));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(t));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(t));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(t));
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(t));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(t));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(t));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(t));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(t));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(t));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(t));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(t));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(t));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(t));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(t));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(t));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(t));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(t));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(t));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(t));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(t));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(t));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(t));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(t));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(t));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(t));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(t));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(t));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(t));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(t));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(t));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(t));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(t));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(t));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(t));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(t));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(t));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(t));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(t));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(t));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(t));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(t));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(t));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(t));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(t));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(t));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(t));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(t));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(t));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(t));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(t));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(t));
            _bw.write(_wl_block185Bytes, _wl_block185);
 
				}
			}

			drug_dtls=(HashMap)comp_drugs.get(0);
			if(drug_dtls != null){
				amnd_drg_code			= (String)drug_dtls.get("ORDER_CATALOG_CODE"); 
				repeat_value			= (String) drug_dtls.get("REPEAT_VALUE");
				if(repeat_value == null) repeat_value ="1";
			}	
			srl_no           ="1";

			Hashtable sch_output1	=	new Hashtable();
			sch_output1.put("code",amnd_drg_code);
			sch_output1.put("row_value",srl_no);
			sch_output1.put("repeat",repeat_value);
			order_line_num="1";

			ArrayList values	=	iv_bean.getFreqDet(order_id,order_line_num);
			int incr=0;

			for(int p=0; p<values.size(); p+=3) {
				incr++;
				sch_output1.put("time"+(incr),values.get(p));
				sch_output1.put("qty"+(incr),values.get(p+1));				
			}

			if(incr<=6) {
				for(int q=(incr+1); q<=6; q++) {
					sch_output1.put("time"+(q),"");
					sch_output1.put("qty"+(q),"");
				}
			}
			
			iv_bean.setScheduleFrequencyStr(sch_output1);
		
			chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();

			if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
				frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(amnd_drg_code);
			}

            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

						for(int i=0; i<frequency.size(); i+=2) {
							temp=(String)frequency.get(i);
							if(temp.equals(freq_code)){    

            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf((String)frequency.get(i)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf((String)frequency.get(i+1)));
            _bw.write(_wl_block197Bytes, _wl_block197);
	
							}
							else{

            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf((String)frequency.get(i)));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf((String)frequency.get(i+1)));
            _bw.write(_wl_block197Bytes, _wl_block197);
	
							}
						}	

            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
 				
					if(!ext_disp_appl_yn.equals(""))
					{
	
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(buildMAR_ynCheck));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(buildMAR_ynEnable));
            _bw.write(_wl_block204Bytes, _wl_block204);

					}
	
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(durn_vlaue));
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block214Bytes, _wl_block214);

		if(!drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);

		}

            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(no_of_drugs));
            _bw.write(_wl_block220Bytes, _wl_block220);
 
	}
	else{
		drug_code				= request.getParameter("drug_code") ;
		srl_no					= request.getParameter("srl_no") ;
		priority				= request.getParameter("priority")==null?"":request.getParameter("priority") ;
		start_time				= request.getParameter("start_date") ;
		bsa					= request.getParameter("bsa")==null?"":request.getParameter("bsa") ;
		weight					= request.getParameter("weight")==null?"0":request.getParameter("weight") ; // ML-MMOH-CRF-1408
		height					= request.getParameter("height")==null?"0":request.getParameter("height") ; // ML-MMOH-CRF-1408
		String MAR_app_yn				=  request.getParameter("MAR_app_yn")==null?"N":request.getParameter("MAR_app_yn");
		iv_bean.setWeight(weight); // ML-MMOH-CRF-1408
		iv_bean.setBSA(bsa);// ML-MMOH-CRF-1408

System.err.println("weight======>"+weight+"==bsa===>"+bsa+"==height==>"+height);
		//RUT-CRF-0062 [IN029600] Build MAR will be loaded  based on the first drug selected. (PrescriptionCompValidate.jsp)  - begin
		/*if(MAR_app_yn.equals("Y")){
			buildMAR_ynCheck="checked";
			buildMAR_yn = "Y";
		}
		else{
			buildMAR_ynCheck="";
			buildMAR_yn = "N";
		}
		*/
		
		if(!MAR_app_yn.equals("Y")){
			buildMAR_ynEnable="disabled";
			buildMAR_yn = "N";
		}
			
		//RUT-CRF-0062 [IN029600] Build MAR will be loaded  based on the first drug selected.   - end
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP") && MAR_app_yn.equals("Y"))
			buildMAR_ynCheck = buildMAR_ynCheck+" disabled";
		 SRR20056-CRF-0649.1 */
		AllUOMs=iv_bean.getAllUOMs();

            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);

							for(int uomsize=0;uomsize<AllUOMs.size();uomsize+=2){

            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(AllUOMs.get(uomsize)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(AllUOMs.get(uomsize+1)));
            _bw.write(_wl_block197Bytes, _wl_block197);

							}

            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);

					for(int i=1; i<=10; i++){

            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(i));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(i));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(i));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(i));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(i));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(i));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(i));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(i));
            _bw.write(_wl_block255Bytes, _wl_block255);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(i));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block259Bytes, _wl_block259);
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(i));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(i));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(i));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(i));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(i));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(i));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(i));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(i));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(i));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(i));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(i));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(i));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(i));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(i));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(i));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(i));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(i));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(i));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(i));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(i));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block293Bytes, _wl_block293);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block295Bytes, _wl_block295);
}else{ 
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block295Bytes, _wl_block295);
} 
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(i));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(i));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(i));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(i));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(i));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(i));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(i));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(i));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(i));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(i));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(i));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(i));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(i));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(i));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(i));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(i));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(i));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(i));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(i));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(i));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(i));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(i));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(i));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(i));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(i));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(i));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(i));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(i));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(i));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(i));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(i));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(i));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(i));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(i));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(i));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(i));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(i));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(i));
            _bw.write(_wl_block351Bytes, _wl_block351);

					}

            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block353Bytes, _wl_block353);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block354Bytes, _wl_block354);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block355Bytes, _wl_block355);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block356Bytes, _wl_block356);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block357Bytes, _wl_block357);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
 
								for(int i=0; i<frequency.size(); i+=2) {

            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf((String)frequency.get(i)));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf((String)frequency.get(i+1)));
            _bw.write(_wl_block197Bytes, _wl_block197);

								}

            _bw.write(_wl_block360Bytes, _wl_block360);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(buildMAR_ynCheck));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(buildMAR_ynEnable));
            _bw.write(_wl_block368Bytes, _wl_block368);

			}

            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(iv_bean_id));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(iv_bean_name));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(ext_disp_appl_yn));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(validate_overide_on_confirm_yn));
            _bw.write(_wl_block383Bytes, _wl_block383);

		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(param_bean_id,param_bean,request);

            _bw.write(_wl_block384Bytes, _wl_block384);
 
	if(calling_mode.equals("amend") || calling_mode.equals("RENEW_ORDER") ){
		HashMap data		=	null;
		String att			=	null;
		String adm_time		=	"";
		String adm_qty		=	"";
		String total_qty	=   "";

		if(frequencyValues!=null && frequencyValues.size()>0){
			
			adm_time = adm_time + "<tr>";					
			for(int i=0;i<frequencyValues.size();i++){
				data=(HashMap)frequencyValues.get(i);
				att="align=center class=TIP1";
				adm_time = adm_time + "<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
			}
			adm_time = adm_time + "</tr>";

			adm_qty = adm_qty + "<tr>";
			for(int i=0;i<frequencyValues.size();i++){
				att="align=center class=TIP1";
				data=(HashMap)frequencyValues.get(i);
				adm_qty = adm_qty + "<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
				total_qty=(String) data.get("admin_qty");
			}
			adm_qty = adm_qty + "</tr>";
			boolean split_chk	=	iv_bean.checkSplit(frequencyValues);	

            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(adm_time));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(adm_qty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(total_qty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(frequencyValues.size()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(split_chk));
            _bw.write(_wl_block386Bytes, _wl_block386);

		}

            _bw.write(_wl_block387Bytes, _wl_block387);

	}
	else{
		if(!order_id.equals("") &&  order_id != null ){

            _bw.write(_wl_block388Bytes, _wl_block388);

		}
	}

            _bw.write(_wl_block389Bytes, _wl_block389);
 }catch(Exception exception) {
       exception.printStackTrace();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Alerts.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drugs.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDetails.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Allergic.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BeyondDoseLimit.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateDrug.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribingBy.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Ratio.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Percentage.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReqdFinalProductQty.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Alerts.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drugs.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Ratio.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReqQty.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Base.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Ratio.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalQuantity.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDetails.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
