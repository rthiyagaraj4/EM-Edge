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

public final class __prescriptioncompdosagedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionCompDosageDetail.jsp", 1709121203037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n   <!--  <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/PhCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionComp.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<!-- Variable initialization starts-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t\t<form name=\"prescription_compdetail_form\" id=\"prescription_compdetail_form\" >\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"1\">\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" > ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" ></td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"1\" ></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"3%\" >\n\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t\t<tr>\n                                  <td NOWRAP width=\"12\" class=\"label\" id=\"ADR_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"ADR_img_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" src=\'../../ePH/images/ADR.gif\'   title=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></img>\n\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\"visibility:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onclick=\"displayDosageCheckResult(";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\"><img style=\"visibility:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"external_img";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"ALLERGY\" id=\"allergy_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"><img style=\"visibility:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"allergy_img";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"DOSELIMIT\" id=\"dosage_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ><img style=\"visibility:hidden\" id=\"dosage_img";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"CURRENTRX\" id=\"currentrx_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"currentrx_img";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" src=\'../../ePH/images/exceed1.gif\' ></img></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"34%\">&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"drug_name";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"drug_name";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\"42\"  maxlength=\"42\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" disabled onblur=\"deleteDrug(this,";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =")\" >\n\t\t\t\t\t\t\t<input type=\"button\" name=\"drug_search";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"drug_search";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=\"?\" class=\"button\"  onfocus=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =",";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =")\" onClick=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\" disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"5%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"strength";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"10%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"form";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"20%\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"absol_qty";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"absol_qty";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  size=\"6\" maxlength=\"6\" onblur=\"CheckNum(this);extdosechk();\"  onKeyPress=\"return allowValidNumber(this,event,6,0);\" class=\"number\">&nbsp;\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"qty";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"6%\" >\n\t\t\t\t\t\t\t<A  id=\"remarks_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" HREF onMouseOver=\"changeCursor(this);\" onClick=\"callOrderAmend(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</A>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"18%\">\n\t\t\t\t\t\t\t<input style=\"visibility:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" type=\"button\" class=\"button\" width=\"8%\" value=\"Override\" id=\"dosage_limit";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" onclick=\"showOverrideReason(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\" > \n\t\t\t\t\t\t\t<input style=\"visibility:";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" type=\"checkbox\" width=\"2%\" id=\"chk_ovr";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onclick=\"default_override_rsn(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\" > \n\t\t\t\t\t\t\t<A title=\"TDM Result\" style=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"tdmRsltAmnd_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" HREF onMouseOver=\"changeCursor(this);\" onClick=\"viewReasonforRequest(tdmOrderIdAmnd";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =".value)\"> ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</A>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ALLERGY_DESC";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"ALLERGY_DESC";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"EXCEED_DOSE_DESC";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"EXCEED_DOSE_DESC";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"DUP_DRUG_DESC";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"DUP_DRUG_DESC";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"drug_code";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"\t value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"strength_uom";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_remarks";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"pres_remarks";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"tdmOrderIdAmnd";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"tdmOrderIdAmnd";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"srl_no";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_prod_id_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"external_prod_id_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"external_dosage_override_reason";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"external_interaction_override_reason";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"external_contra_override_reason";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"external_db_dose_check_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t<tr>\n\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"3%\" >\n\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t  <td NOWRAP width=\"12\" class=\"label\" id=\"ADR_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"ADR_img_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'></img>\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"SHIFTTOTAL\" id=\"external_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"external_img";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"ALLERGY\" id=\"allergy_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"allergy_img";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"DOSELIMIT\" id=\"dosage_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"dosage_img";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td NOWRAP width=\"12\" class=\"CURRENTRX\" id=\"currentrx_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"currentrx_img";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"34%\">&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"drug_name";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" size=\"42\"  maxlength=\"42\" value=\"\" disabled onblur=\"deleteDrug(this,";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =")\" ><input type=\"button\" name=\"drug_search";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" value=\"?\" class=\"button\"  disabled  onClick=\"searchDrug(prescription_compdetail_form,\'D\', drug_name";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =")\"></td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"5%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"strength";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">&nbsp;</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"10%\">\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"form";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">&nbsp;</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"16%\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"absol_qty";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" value=\"\" disabled size=\"6\" maxlength=\"6\" onblur=\"CheckNum(this);extdosechk();\" onKeyPress=\"return allowValidNumber(this,event,6,0);\" class=\"number\">&nbsp;\n\t\t\t\t\t\t\t<b><label style=\"font-size:7pt\" class=\"label\" id=\"qty";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">&nbsp;</label></b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\"  width=\"8%\" >\n\t\t\t\t\t\t\t<A style=\"visibility:hidden\" id=\"remarks_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" HREF onMouseOver=\"changeCursor(this);\" onClick=\"getRemarks(\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\')\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</A>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"QRYEVENSMALL\" width=\"14%\">\n\t\t\t\t\t\t\t<input style=\"visibility:hidden\" type=\"button\" class=\"button\" width=\"8%\" value=\"Override\" id=\"dosage_limit";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" onclick=\"overRideRemarks(drug_code";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =".value,\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\')\">&nbsp;<input disabled style=\"visibility:hidden\" type=\"checkbox\" width=\"2%\" id=\"chk_ovr";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" onclick=\"\"> \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ALLERGY_DESC";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" value=\"\">\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"\t value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"strength_uom";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"external_Alergy_override_reason";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" value=\"\">\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t<tr height=\"4\">\n\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADERCENTER\" colspan=\"12\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr height=\"8\">\n\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"15%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t<input type=\"text\" name=\"dosage\" id=\"dosage\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" onBlur=\"CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" size=\"2\"  maxlength=\"3\" style=\"text-align:right\">&nbsp;\n\t\t\t\t\t<label  class=\"label\" id=\"qty_uom\">";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</label>\n\t\t\t\t</td> \n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t<select name=\"frequency\" id=\"frequency\" ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" onChange=\"ValidateDosage(); setSchedule();extdosechk();\">\n\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =" ---&nbsp;&nbsp;&nbsp; </option>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" Selected >";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</option>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t<input type=\"button\" name=\"btn_schedule\" id=\"btn_schedule\" value=\"Schedule\" disabled class=\"button\" onClick=\"DisplaySchedule()\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\'10%\' id=\"dosage_label\" nowrap>&nbsp;</td>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"admixture\" id=\"admixture\"  value=\"Y\" CHECKED DISABLED>&nbsp;&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"buildMAR_yn\" id=\"buildMAR_yn\"  value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" disabled ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" >\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr height=\"8\">\n\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t\t<td class=\"label\" width=\"15%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"5%\" nowrap class=\'label\'>\n\t\t\t\t\t<input type=\"text\" size=\"1\" maxlength=\"11\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"  onBlur=\"validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" >&nbsp;\n\t\t\t\t\t<label id=\"durn_desc\" class=\"label\"></label>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"10%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"10%\">\n\t\t\t\t\t<input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"14\"  maxlength=\"16\" onBlur=\"populateEndDate();\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =" >\n\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\"  ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="  id=Calendar  onclick=\"if(document.prescription_compdetail_form.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_compdetail_form.start_date.focus();return false;\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"10%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"end_date\" id=\"end_date\"  value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"  size=\"14\"  maxlength=\"13\" value=\"\" disabled>\n\t\t\t\t</td>\n\t\t\t</tr> \n\t\t\t<tr height=\"8\"><td colspan=\"12\"></td></tr>\n\t\t</table>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t<table  border=\"2\" bordercolor=\"black\" width=\"100%\">\n\t\t\t\t<tr> \n\t\t\t\t    \n\t\t\t\t    \n\t\t\t\t\t<td NOWRAP width=\"15\" class=\"ALLERGY\">\n\t\t\t\t\t\t<img src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td NOWRAP  style=\"font-size:7pt\" class=\"label\" border=\"0\" bordercolor=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP width=\"15\" class=\"DOSELIMIT\"  border=\"1\" bordercolor=\"black\">\n\t\t\t\t\t\t<img src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP  style=\"font-size:7pt\" class=\"label\" border=\"0\" bordercolor=\"label\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP width=\"15\" class=\"CURRENTRX\"\n\t\t\t\t\tborder=\"1\" bordercolor=\"black\">\n\t\t\t\t\t\t<img src=\'../../ePH/images/exceed1.gif\' ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  NOWRAP style=\"font-size:7pt\" class=\"label\" border=\"0\" bordercolor=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t</td> \n\t\t\t\t</tr> \n\t\t\t\t<tr height=\"8\">\n\t\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t<input type=\"hidden\" name=\"no_of_drugs\" id=\"no_of_drugs\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n    \n\t\t\t\t\n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"prescription_compdetail_form1\" id=\"prescription_compdetail_form1\" >\n\t\t\t<!-- Prescription Writer Table starts-->\t\t\t\t\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADERCENTER\" colspan=\"12\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr height=\"2\"><td colspan=\"12\"></td></tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"40%\" nowrap>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"dosage\" id=\"dosage\" value=\"\"  onBlur=\"parent.f_compound_detail.document.prescription_compdetail_form.dosage.value=this.value;CheckNum(this);chkBlank();setSchedule(this.value);autoschedule1();\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" size=\"2\"  maxlength=\"3\" style=\"text-align:right\">&nbsp;\n\t\t\t\t\t\t\t<select name=\"uom\" id=\"uom\" onChange=\"\">\n\t\t\t\t\t\t\t\t<option value=\"\">-- ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" --</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t\t\t<select name=\"frequency\" id=\"frequency\" onChange=\"parent.f_compound_detail.document.prescription_compdetail_form.frequency.value=this.value; ValidateDosage();setSchedule();extdosechk();\">\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp; --- ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"5%\">\n\t\t\t\t\t\t\t<input type=\"button\" name=\"btn_schedule\" id=\"btn_schedule\" value=\"Schedule\" disabled class=\"button\" onClick=\"DisplaySchedule()\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\'10%\' id=\"dosage_label\" nowrap>&nbsp;</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"20%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"admixture\" id=\"admixture\"  value=\"Y\" CHECKED DISABLED>&nbsp;&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"buildMAR_yn\" id=\"buildMAR_yn\"  value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =" onclick=\'assignCheckValue(this);\'>\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr height=\"4\">\n\t\t\t\t\t\t<td colspan=\"12\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\"10%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"15%\" nowrap>\n\t\t\t\t\t\t\t<input type=\"text\" size=\"1\" maxlength=\"11\" name=\"durn_value\" id=\"durn_value\" class=\"NUMBER\"  value=\"\"  onBlur=\"parent.f_compound_detail.document.prescription_compdetail_form.durn_value.value=this.value;validateDuration(this);CheckPositiveNumber(this);populateEndDate();extdosechk();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" >&nbsp;\n\t\t\t\t\t\t\t<label id=\"durn_desc\" class=\"label\"></label>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"10%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"10%\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"start_date\" id=\"start_date\" size=\"14\"  maxlength=\"16\" onBlur=\"parent.f_compound_detail.document.prescription_compdetail_form.start_date.value=this.value;populateEndDate();\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" >\n\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\"   id=Calendar  onclick=\"if(document.prescription_compdetail_form1.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_compdetail_form1.start_date.focus();return false;\" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\" width=\"10%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"end_date\" id=\"end_date\" size=\"14\"  maxlength=\"13\" value=\"\" disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr height=\"4\"><td colspan=\"12\"></td></tr>\n\t\t\t\t</table>\n\n\t\t\t\t<br>\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n<!-- Prescription Writer Table ends-->\t\n\t\t<label id=\"tool_tip\" style=\"visibility:hidden\"></label>\n\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\"  align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"100%\" id=\"t\"  ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t</form>\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t</body>\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t<script>\n\t\t\t\tmakeScheduleLink(\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\');\t\n\t\t\t</script>\n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\n\t\t<script>\n\n\t\t\t//extdosechk();\n\t\t\tfor(i=1;i<=4;i++){\n//\t\t\t\teval(\"document.getElementById(\"external_img\")\"+i).style.visibility=\"hidden\";\n//\t\t\t\teval(\"document.getElementById(\"external_img\")\"+i).style.visibility=\"visible\";\n\t\t\t}\n\t\t</script>\n\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t<script>\n\t\t\t\tsetSchedule();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t<script>\n\n\t\tpopulateDurationDesc(parent.f_compound_detail.document.prescription_compdetail_form.frequency)\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		 request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

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
	String external_prod_id					=  "";
	String interaction_override_reason		=  "";
	String contraind_override_reason		=  "";

    String allergy_override_reason_flag			=  "N";	
	String duplicate_drug_override_reason_flag	=  "N";
	String interaction_override_reason_flag		=  "N";
	String contraind_override_reason_flag		=  "N";
	String adr_display_yn						="hidden";
	String ext_image_display					="hidden";

	String drug_desc = "",freq_code = "",qty_value = "",qty_unit = "",durn_vlaue = "",order_qty = "",order_uom = "",start_date	= "",end_date = "",order_id	= "",temp = "", form_desc = "",strength_value = "",strength_uom	= "", pres_remarks = "", allergy_override_reason	= "",dosage_limit_override_reason		= "", duplicate_drug_override_reason	= "",allergy_flag = "hidden",doselimit_flag	= "hidden",currentrx_flag	= "hidden",over_ride_flag	= "hidden",no_of_drugs	= "", order_line_num = "",repeat_value = "", amnd_drg_code = "",disableflag	= "", tdmOrderIdAmnd = "",display_tdm = "", buildMAR_yn="", buildMAR_ynCheck="",ext_over_ride_flag	= "hidden";

	String allergy_yn			= "N";
	String allergy_rsn_flag		= "hidden";
	String currentrx_yn			= "N";
	String currentrx_rsn_flag	= "hidden";
	String limit_ind			= "N";

	HashMap chkValuescheduleFrequency		=	null;
    ArrayList frequencyValues				=	null;
	HashMap drugReasons						=   null;
	int tem									=   0;
	//String ex_bean_id						= "@ExternalProductLinkBean"+patient_id+encounter_id;
    String ex_bean_id						= "@ExternalProductLinkBean";
	String ex_bean_name						= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex			= (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

	String dup_drug_det						= "";
	HashMap drug_Interactions				= null;
	ArrayList exProd						= new ArrayList();
	ArrayList drugDesc						= new ArrayList();

	String drug_db_contraind_check_flag		=	"N";
	String drug_db_interact_check_flag		=	"N";
	String drug_db_duptherapy_flag			=	"N";
	String drug_db_dose_check_flag			=	"N"; 
	String drug_db_allergy_flag				=	"N";

	ArrayList prescriptionDetails	=	new ArrayList();

	HashMap ext_drugData	=	null;
	String ext_drug_code	=	null;

	HashMap freq_vals              = new HashMap();
    String freq_interval_value          = "";
	String freq_repeat_value            = "";
	String freq_frequency			   = "";
	HashMap drugDosageResult	   = new HashMap();
    ArrayList dosageCheckParams    = new ArrayList();
	String presc_base_uom		   = "";
	if(calling_mode.equals("amend") || calling_mode.equals("RENEW_ORDER") ){

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

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

				comp_drugs=iv_bean.getCompDrugDtls(order_id,act_patient_class); // RUT-CRF-0062 Added actual patient class to get the Build MAR Rule
				if(comp_drugs != null){
					no_of_drugs = comp_drugs.size()+"";

				 HashMap drug_data=new HashMap();
                 for(int i=0;i<comp_drugs.size();i++){
					drug_data	=	(HashMap)comp_drugs.get(i);					
					external_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID");
					if(!external_prod_id.equals("")){
					    exProd.add(external_prod_id);
						drugDesc.add((String)drug_data.get("DRUG_DESC"));
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

						if(buildMAR_yn.equals("Y"))
							buildMAR_ynCheck="checked";
						else{
							buildMAR_ynCheck="";
							buildMAR_yn = "N";
						}

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
							allergy_flag	="hidden";
							doselimit_flag	="hidden";
							currentrx_flag	="hidden";
							over_ride_flag	="hidden";
							ext_over_ride_flag = "hidden";

							drugReasons=iv_bean.getDrugReasons(order_id,(i+1)+"","");
							allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");

							dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");



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
//				beanex.storeDrugIds(patient_id,"",new ArrayList(),new ArrayList());//Store Drug ids
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

				if(drug_db_dosecheck_yn.equals("Y")){
					drugDosageResult = new HashMap();
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
					if(!weight.equals("") && !bsa.equals("")){
					drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);

						if(drugDosageResult != null && drugDosageResult.size() > 0){
							drug_db_dose_check_flag = "Y";						
						}
					}
				}
				*/
						if(drug_db_dosecheck_yn.equals("Y")){
							dosageCheckParams        = new ArrayList();
							dosageCheckParams.add(patient_id);
							dosageCheckParams.add(external_prod_id);
							dosageCheckParams.add(weight);
							dosageCheckParams.add(bsa);
							dosageCheckParams.add(qty_value);//dose
							dosageCheckParams.add(presc_base_uom);//pres_base_uom
							dosageCheckParams.add(freq_frequency);
							dosageCheckParams.add(durn_vlaue);
						}

							String storeIDs = "N";
							if(exProd.size()>0 ){
								for(i=0;i<exProd.size();i++){
									if(exProd.get(i).equals(external_prod_id)) {
										drugDesc.remove(i);
										exProd.remove(i);
										break;
									}
								}
							}
							if(exProd.size()>0)
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
								tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								if(tempDetails!=null && tempDetails.containsKey(external_prod_id)){
									drug_db_contraind_check_flag="Y";
								}		
							}
						}
				if(drug_db_duptherapy_flag.equals("Y")){
					currentrx_flag="hidden";
					over_ride_flag="hidden";
					currentrx_rsn_flag = "hidden";
				}else if(currentrx_yn.equals("Y")){
					currentrx_flag="visible";
					if(!duplicate_drug_override_reason.equals("")){
						currentrx_rsn_flag = "hidden";
					}else{
						currentrx_rsn_flag = "visible";
					}
				}else if(currentrx_yn.equals("N")){
					currentrx_rsn_flag = "hidden";
				}


				if(drug_db_allergy_flag.equals("Y")){
					allergy_flag="hidden";
					over_ride_flag="hidden";
					allergy_rsn_flag = "hidden";
				}else if(allergy_yn.equals("Y")){
					allergy_flag="visible";	
					if(!allergy_override_reason.equals("")){
						allergy_rsn_flag = "hidden";
					}else{
						allergy_rsn_flag = "visible";
					}
				}else if(allergy_yn.equals("N")){
					allergy_rsn_flag = "hidden";
				}

				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
				drug_dtls.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

				if(drug_db_allergy_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_dose_check_flag.equals("Y")){ 
					ext_image_display	=	"visible";
				}else{
					ext_image_display	=	"hidden";
				}

				if(((drug_db_allergy_flag.equals("Y") && (allergy_override_reason.equals(""))) || (drug_db_duptherapy_flag.equals("Y") && (duplicate_drug_override_reason.equals("")))) || ((drug_db_interact_check_flag.equals("Y")) && interaction_override_reason.equals("")) || ((drug_db_contraind_check_flag.equals("Y")) && contraind_override_reason.equals("")) || ((drug_db_dose_check_flag.equals("Y")) && dosage_limit_override_reason.equals(""))){
					ext_over_ride_flag	=	"visible";

				}
				if(allergy_flag.equals("visible") || doselimit_flag.equals("visible") || currentrx_flag.equals("visible")){
					over_ride_flag="visible";
				}
			

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(adr_display_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ext_image_display));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ext_over_ride_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(allergy_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy_rsn_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(doselimit_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currentrx_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentrx_rsn_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_uom ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(over_ride_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(currentrx_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(over_ride_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(duplicate_drug_override_reason));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tdmOrderIdAmnd));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( srl_no ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(external_prod_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dosage_limit_override_reason));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(duplicate_drug_override_reason));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(interaction_override_reason));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(contraind_override_reason));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(allergy_override_reason));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_db_dose_check_flag));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block98Bytes, _wl_block98);
 
					tem=i+2; 

						prescriptionDetails	=	(ArrayList)iv_bean.getDrugDetails();
						for(int j=0;j<prescriptionDetails.size();j++){
						 ext_drugData	=(HashMap) prescriptionDetails.get(j);
						 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");

							if( drug_code.equals(ext_drug_code) ){
								if(!allergy_override_reason.equals("") ) {
									ext_drugData.put("ALLERGY_REMARKS",allergy_override_reason);
									ext_drugData.put("ALLERGY_OVERRIDE","Y");
								}

								if(!dosage_limit_override_reason.equals("")) {
									ext_drugData.put("DOSE_REMARKS",dosage_limit_override_reason);
									ext_drugData.put("DOSE_OVERRIDE","Y");
								}

								if(!duplicate_drug_override_reason.equals("")) {
									ext_drugData.put("CURRENTRX_REMARKS",duplicate_drug_override_reason);
									ext_drugData.put("CURRENTRX_OVERRIDE","Y");
								}
								break;
							}
					  }
				 }

			 }

			if(tem<= 4){
				for(int t=tem;t<=4;t++){ 

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(t));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(t));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(t));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(t));
            _bw.write(_wl_block103Bytes, _wl_block103);
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
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(t));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(t));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(t));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(t));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(t));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(t));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(t));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(t));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(t));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(t));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(t));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(t));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(t));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(t));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(t));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(t));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(t));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(t));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(t));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(t));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(t));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(t));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(t));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(t));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(t));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(t));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(t));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(t));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(t));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(t));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(t));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(t));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(t));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(t));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(t));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(t));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(t));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(t));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(t));
            _bw.write(_wl_block134Bytes, _wl_block134);
 
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


            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

						for(int i=0; i<frequency.size(); i+=2) {
							temp=(String)frequency.get(i);
							if(temp.equals(freq_code)){    

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)frequency.get(i)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)frequency.get(i+1)));
            _bw.write(_wl_block146Bytes, _wl_block146);
	
							}
							else{

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)frequency.get(i)));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf((String)frequency.get(i+1)));
            _bw.write(_wl_block146Bytes, _wl_block146);
	
							}
						}	

            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(buildMAR_ynCheck));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(durn_vlaue));
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(disableflag));
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block159Bytes, _wl_block159);

		if(!drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

		}

            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(no_of_drugs));
            _bw.write(_wl_block165Bytes, _wl_block165);
 
	}
	else{
		drug_code				= request.getParameter("drug_code") ;
		srl_no					= request.getParameter("srl_no") ;
		patient_id				= request.getParameter("patient_id") ;
		encounter_id			= request.getParameter("encounter_id") ;
		priority				= request.getParameter("priority")==null?"":request.getParameter("priority") ;
		start_time				= request.getParameter("start_date") ;
		bsa						= request.getParameter("bsa")==null?"":request.getParameter("bsa") ;	
		String MAR_app_yn				=  request.getParameter("MAR_app_yn")==null?"N":request.getParameter("MAR_app_yn");
		if(MAR_app_yn.equals("Y")){
			buildMAR_ynCheck="checked";
			buildMAR_yn = "Y";
		}
		else{
			buildMAR_ynCheck="";
			buildMAR_yn = "N";
		}
		if(patient_class.equals("IP") && MAR_app_yn.equals("Y"))
			buildMAR_ynCheck = buildMAR_ynCheck+" disabled";

            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
 
								for(int i=0; i<frequency.size(); i+=2) {

            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf((String)frequency.get(i)));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf((String)frequency.get(i+1)));
            _bw.write(_wl_block146Bytes, _wl_block146);

								}

            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(buildMAR_ynCheck));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

			}

            _bw.write(_wl_block180Bytes, _wl_block180);

		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(param_bean_id,param_bean,request);

            _bw.write(_wl_block181Bytes, _wl_block181);
 
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


            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(adm_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adm_qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(total_qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(frequencyValues.size()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(split_chk));
            _bw.write(_wl_block183Bytes, _wl_block183);

		}

            _bw.write(_wl_block184Bytes, _wl_block184);

	}
	else{
		if(!order_id.equals("") &&  order_id != null ){

            _bw.write(_wl_block185Bytes, _wl_block185);

		}
	}


            _bw.write(_wl_block186Bytes, _wl_block186);
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDetails.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Allergic.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BeyondDoseLimit.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateDrug.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDetails.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
