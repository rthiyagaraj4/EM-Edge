package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispdruglist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispDrugList.jsp", 1724069097482L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DirectDispensing.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t </head>\n\n\t<!-- <body>  -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"prescription_form\" id=\"prescription_form\" >\n\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" id=\"Selected_drugs\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t\t\t<th colspan=\"8\" align=\"left\" class=\"ORDERDESC\" style=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t<tr title=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" style=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dt";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" id=\"dt";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\" onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\"  title=\'Tapered\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"external_dosage_override_reason";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"      value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"   value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"external_interaction_override_reason";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"external_contra_override_reason";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"external_alergy_override_reason";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"external_alergy_override_reason";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" colspan=\"\" NOWRAP width=\"64%\" id=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onClick=\"defaultDrug(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'modify\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\" onmouseover=\"changeCursor(this);changeCol(this);\" onmouseout=\"realCol(this,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" title=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><font class=\"HYPERLINK\" size=\'1\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20  width=20 onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\') \">\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td><td style=\"background-color:red;font-weight:bold;font-size:11;cursor:pointer;height:20\" NOWRAP  colspan=\"3\" title=\"Available Qty:&nbsp;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"><marquee scrollamount=\"3\"><font style=\"font-weight:bold;color:white\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =":&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></marquee></td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\"><font class=\"HYPERLINK\" size=\'1\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20  width=20 onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" colspan=\"\"  width=\"5%\"  title=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" colspan=\"\"  width=\"5%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"SHIFTTOTAL\" colspan=\"\" NOWRAP width=\"5%\" title=\"External Override Reason\" onmouseover=\"changeCursor(this);\" onclick=\"viewMedicationAlert(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',\'PRESPAD\',\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\')\">&nbsp;\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img id=\'external_img";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' style=\"visibility:visible\"src=\'../../ePH/images/exceed1.gif\'></img>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img id=\'external_img";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' style=\"visibility:hidden\"src=\'../../ePH/images/exceed1.gif\'></img>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" width=\"5%\">&nbsp;<img id=\'external_img";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' style=\"visibility:hidden\"src=\'../../ePH/images/exceed1.gif\'></img></td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"ALLERGY\" colspan=\"\" NOWRAP width=\"5%\" title=\"Allergy Drug\"  onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\" onmouseover=\"changeCursor(this);\">&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" colspan=\"\" NOWRAP width=\"5%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT2\" colspan=\"\" NOWRAP width=\"5%\" title=\"Exceed Dosage Limit\" onmouseover=\"changeCursor(this);\" onclick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\');\">&nbsp;";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;</td> <!-- dose_unit_desc and dosage_std  added for 0864 --><!-- Modified for IN:070451  -->\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" width=\"5%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\" colspan=\"\" NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' onmouseover=\"changeCursor(this);\" onclick=\"showInractionDtl(\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\');\" id=\'td_drugIntraction";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" width=\"5%\" id=\'td_drugIntraction";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"CURRENTRX\" colspan=\"\" NOWRAP width=\"5%\" title=\"Duplicate Medication\"  onmouseover=\"changeCursor(this);\" onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\">&nbsp;";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" colspan=\"\" NOWRAP width=\"64%\" onClick=\"defaultDrug(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\');\" id=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"  onmouseover=\"changeCursor(this);changeCol(this);\" onmouseout=\"realCol(this,\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');\"><font CLASS=\"HYPERLINK\" size=\'1\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="  \n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" colspan=\"\"  width=\"3%\"  title=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" colspan=\"\"  width=\"3%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" onmouseover=\"changeCursor(this);changeCol(this);\" onmouseout=\"realCol(this,\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" size=\'1\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"SHIFTTOTAL\" colspan=\"\" NOWRAP width=\"5%\" title=\"External Override Reason\" onmouseover=\"changeCursor(this);\" onclick=\"viewMedicationAlert(\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img id=\'external_img";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<img id=\'external_img";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;</td>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' style=\"visibility:hidden\"src=\'../../ePH/images/exceed1.gif\'></td>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"ALLERGY\" colspan=\"\" NOWRAP width=\"5%\"title=\"Allergy Drug\"  onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT2\" colspan=\"\" NOWRAP width=\"5%\" title=\"Exceed Dosage Limit\" onmouseover=\"changeCursor(this);\" onclick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&nbsp;</td> <!-- dose_unit_desc and dosage_std added for 0864 --><!-- Modified for IN:070451  -->\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\" colspan=\"\" NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"CURRENTRX\" colspan=\"\" NOWRAP width=\"5%\"title=\"Duplicate Medication\"  onmouseover=\"changeCursor(this);\" onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'wt_mand_yn";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' id=\'wt_mand_yn";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ht_mand_yn";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' id=\'ht_mand_yn";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'weight_rec_appl_age_group_check_flag";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'weight_rec_appl_age_group_check_flag";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945] -->\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'recomm_yn_flag_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\'recomm_yn_flag_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t<input type=\"hidden\" name=\"sliding_scale_yn\" id=\"sliding_scale_yn\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t<input type=\"hidden\" name=\"recomm_yn_flag\" id=\"recomm_yn_flag\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t</form>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t</body>\n\t\t<script>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\trecommendDosage(\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');//prescription_form,\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\tdefaultDrug(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\');\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t</script>\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n</html>\n\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

try{
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String dir_bean_id		= "DirectDispensingBean" ;
	String dir_bean_name	= "ePH.DirectDispensingBean";
	DirectDispensingBean dir_bean =(DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request);

	String classValue		= "";
	String prev_order_code	= "";
	String patient_id		= dir_bean.getPatientID();
	String encounter_id		= "";
	String patient_class	= "";

	 if(patient_id!=null && !patient_id.equals("")){		
		encounter_id     = dir_bean.getEncounterID();
		if(encounter_id==null){
			encounter_id="";
		}
		patient_class    = dir_bean.getPatientClass();		  
	 }
	String facility_id		= (String)session.getValue("facility_id");
	ArrayList	presDetails	=(ArrayList) dir_bean.getpresDetails();

	String sch_bean_id		= "OrScheduleFreq" ;
	String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
	presBean.setLanguageId(locale);

            _bw.write(_wl_block5Bytes, _wl_block5);

				String adr_count	        = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
				ArrayList displayList		=	null;
				HashMap drugDetails			=	null;
				Hashtable schedule_val		=	null;
				Hashtable sch_output		=	null;	

				String grp_order_type_code	=	null;
				String order_type_code		=	null;
				String drug_code			=	null; 
				String srl_no				=	null; 
				String drug_desc			=	null; 
				String generic_id			=	null; 
				String generic_name			=	null; 
				String taper_yn				=	null; 
				String allergy_yn			=	null; 
				String qty_value			=	null; 
				String qty_desc				=	null; 
				String or_qty_desc			=	null; 
				String freq_desc			=	null; 
				String durn_value			=	null; 
				String or_durn_desc			=   null; 
				String limit_ind			=	null; 
				String mono_graph			=	null; 
				String daily_dose			=	null; 
				String unit_dose			=	null; 
				String dosage_std           =   null; // Added for ML-MMOH-CRF-0978
				String min_daily_dose		=	null; 
				String min_unit_dose		=	null; 
				String freq_nature			=	null;
				String current_rx			=	null;
				String allergy_override		=	null; 
				String dose_override		=	null; 
				String currentrx_override	=	null; 
				String sch_over_yn			=	null; 
				String ext_prod_id			=	null;
				String start_date			=	null;
				String end_date				=	null;
				String provide_taper		=	null;
				String no_refill			=   null;
				String stock_available_yn	=   null;
				String available_stock		=   null;
				String allow_pres_without_stock_yn = null;
				String scheduled_yn			=	null;
				String order_type_desc		=	null;
				String amend_yn				=	null;
				String rowVal				=	null;
				String split_dose_yn		=	null;
				String dosage_type			=	null;
				String tmp_srl_no			=	null;
				String tmp_drug_code		=	null;
				String dosage_unit			=	"";
				String dose_unit_desc       =   ""; //added for ML-MMOH-SCF-0864
				String stock_uom			=	"";	
				String dis					=   "";	
				String recomm_yn			=	"";
				String taper_up				=	"";
				String sliding_scale_yn		=   "";
				String form_code			=	"";	
				String uom_code				=	"";
				String uom_desc				=	"";
				String dflt_yn				=	"";
				String allocatedd_yn        =   "";
				String freq_code			=	null;	
				boolean recomm_yn_flag		=	false;	
				String perform_external_database_checks_yn	= "N";
				String drug_db_interact_check_flag			= "N";
				String drug_db_duptherapy_flag				= "N";
				String drug_db_contraind_check_flag			= "N";
				String drug_db_dosage_check_flag			= "N";
				String drug_db_alergy_check_flag			= "N";
				
				boolean show_external_override_gif			= false;
				String external_dosage_override_reason		=   "";	
				String external_duplicate_override_reason	=   "";
				String external_interaction_override_reason	=   "";
				String external_contra_override_reason		=   ""; 
				String external_alergy_override_reason		=   ""; 
				String pract_name							= dir_bean.getPractionerName();
				String external_checks_overrided			= "N";
				//Added for IN:070451 start
				String      max_daily_ceeling_dose	    =   "";
				String		min_daily_ceeling_dose	    =   "";
				String		max_unit_ceeling_dose	    =   "";
				String		min_unit_ceeling_dose	    =   "";
				String dose_unit_desc1       =   "";
				//Added for IN:070451 end
				String interaction_exists="", drugIntraction_override="", drugIntraction_override_gif="";  // added for FD-RUT-CRF-0066.1 [IN036975]

				String param_bean_id				= "@DrugInterfaceControlBean";
				String param_bean_name				= "ePH.DrugInterfaceControlBean";
				DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
				String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
				
				param_bean.clear();
				
				int drug_adr_count					= 0;
				String adr_gif						="";
				ArrayList prescriptionDetails		=null;
				int codeCount_1						= 0;
				int codeCount_2						= 0;
				HashMap ext_drugData				=null;
				String ext_drug_code				=null;
				String ext_srl_no					=null;
				int drug_index						=0;
				String temp_freq_nature				="";
				String deft_mode					="modify";
				String weight_rec_appl_age_group_check_flag = "";
				String wt_mand_yn="", ht_mand_yn=""; //added for Bru-HIMS-CRF-079 IN[029945]
			
				if(presDetails.size()>0){
					classValue="SELECTEDRUGS1";
					ArrayList ordergrp	=(ArrayList) dir_bean.ordsortList();
					ArrayList grp		=(ArrayList)dir_bean.sortList();

					//  duplicate check based on atc -- starts
					String atc_level_1	=	"";
					String atc_level_2	=	"";
					String atc_level_3	=	"";
					ArrayList atc_values =  new ArrayList();
					HashMap drug_detail	 =	null;
					if(presDetails.size()>0){
						for(int i=0;i<presDetails.size();i++){			
							drug_detail=(HashMap) presDetails.get(i);

							atc_level_1	=	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
							atc_level_2	=	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
							atc_level_3	=	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
							drug_desc	=	(String)drug_detail.get("DRUG_DESC");										
							
							//out.println((HashMap)drug_detail.get("SEL_BATCHES")==null?"":(HashMap)drug_detail.get("SEL_BATCHES"));
						   provide_taper	=	"";

							if(drug_detail.get("PROVIDE_TAPER")!=null)
								 provide_taper	= (String)drug_detail.get("PROVIDE_TAPER");

							if( (!provide_taper.equals("Y")) && (drug_detail.get("ALERT_YN")==null && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") ) ) ) {
								if(atc_values.contains(atc_level_1)) {
									drug_detail.put("CURRENT_RX","Y");
									drug_detail.put("ALERT_YN","Level 1:");
									//out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_1)-1)+" at ATC Classification Level 1'); return;</script>");
								} 
								else  if(atc_values.contains(atc_level_2)) {
									drug_detail.put("CURRENT_RX","Y");
									drug_detail.put("ALERT_YN","Level 2:");
									//out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_2)-2)+" at ATC Classification Level 2'); return; </script>");
								} 
								else if(atc_values.contains(atc_level_3)) {
									drug_detail.put("CURRENT_RX","Y");
									drug_detail.put("ALERT_YN","Level 3:");
									//out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_3)-3)+" at ATC Classification Level 3') return; </script>");
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
					//  duplicate check based on atc -- ends
					for(int k=0;k<ordergrp.size();k++){
						grp_order_type_code	=(String) ordergrp.get(k);
							for(int i=0;i<grp.size();i++){
								displayList=(ArrayList) dir_bean.getDisplayList((String)grp.get(i));
								for(int j=0;j<displayList.size();j++){
									drugDetails = new HashMap();
									drugDetails=(HashMap) displayList.get(j);

									order_type_code	= (String)drugDetails.get("ORDER_TYPE_CODE");
									allocatedd_yn   = (String)drugDetails.get("ALLOCATEDD_YN");
									if(grp_order_type_code.equals(order_type_code)){											
										perform_external_database_checks_yn		= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
										drug_db_duptherapy_flag					= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
										drug_db_interact_check_flag				= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
										drug_db_contraind_check_flag			= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
										drug_db_dosage_check_flag				= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
										drug_db_alergy_check_flag               = (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN");
										external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
										external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
										external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
										external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
										external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
										if(drug_db_duptherapy_flag.equals("Y")||drug_db_interact_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")||drug_db_dosage_check_flag.equals("Y")||drug_db_alergy_check_flag.equals("Y")){
											show_external_override_gif=true;
											if((drug_db_duptherapy_flag.equals("Y")&&external_duplicate_override_reason.equals(""))||(drug_db_interact_check_flag.equals("Y")&&external_interaction_override_reason.equals(""))||(drug_db_contraind_check_flag.equals("Y")&&external_contra_override_reason.equals(""))||(drug_db_dosage_check_flag.equals("Y")&& external_dosage_override_reason.equals(""))||(drug_db_alergy_check_flag.equals("Y")&& external_alergy_override_reason.equals(""))){
												// external_img="<img id='external_img+<%srl_no>'src='../../ePH/images/exceed1.gif'></img>";
												external_checks_overrided="N";
											}
											else{
												external_checks_overrided="Y";
											}
										}
										else{
											show_external_override_gif=false;
											external_checks_overrided="Y";
										}

										sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN") ; 
										drug_code			= (String)drugDetails.get("DRUG_CODE");
										srl_no				= (String)drugDetails.get("SRL_NO");
										drug_desc			= (String)drugDetails.get("DRUG_DESC");				
										String	drug_desc1=java.net.URLEncoder.encode(drug_desc,"UTF-8");
										generic_id			= (String)drugDetails.get("GENERIC_ID");
										generic_name		= (String)drugDetails.get("GENERIC_NAME");
										taper_yn			= (String)drugDetails.get("TAPER_DOSE_YN");
										allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
										qty_value			= (String)drugDetails.get("QTY_VALUE");
										qty_desc			= (String)drugDetails.get("QTY_DESC");
										or_qty_desc			= (String)drugDetails.get("OR_QTY_DESC");				
										freq_code			= (String)drugDetails.get("FREQ_CODE");
										freq_desc			= (String)drugDetails.get("FREQ_DESC");
										durn_value			= (String)drugDetails.get("DURN_VALUE");
										or_durn_desc		= (String)drugDetails.get("OR_DURN_DESC");
										limit_ind			= (String)drugDetails.get("LIMIT_IND");
										mono_graph			= (String)drugDetails.get("MONO_GRAPH");
										daily_dose			= (String)drugDetails.get("DAILY_DOSE");
										unit_dose			= (String)drugDetails.get("UNIT_DOSE");
										min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE");
										min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE");
										dosage_std          = (String)drugDetails.get("DOSAGE_STD"); // Added for ML-MMOH-CRF-0978
										freq_nature			= (String)drugDetails.get("FREQ_NATURE");
										current_rx			= (String)drugDetails.get("CURRENT_RX");
										allergy_override	= (String)drugDetails.get("ALLERGY_OVERRIDE");
										dose_override		= (String)drugDetails.get("DOSE_OVERRIDE");
										currentrx_override	= (String)drugDetails.get("CURRENTRX_OVERRIDE");
										sch_over_yn			= (String)drugDetails.get("SCH_OVER_YN");
										ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
										start_date			= (String)drugDetails.get("START_DATE");
										end_date			= (String)drugDetails.get("END_DATE");				
										stock_uom			= (String)drugDetails.get("STOCK_UOM_DESC");
										form_code			= (String) drugDetails.get("FORM_CODE");
										recomm_yn			= ((String)drugDetails.get("RECOMM_YN")).trim();
										//Added for IN:070451 start
										max_daily_ceeling_dose		= drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
										min_daily_ceeling_dose		= drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
										max_unit_ceeling_dose		= drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
										min_unit_ceeling_dose		= drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
										//Added for IN:070451 end
										if(recomm_yn.equals("Y")){					
											recomm_yn_flag = true;				
										}
										weight_rec_appl_age_group_check_flag =  drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG")== null?"":(String) drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG");
										wt_mand_yn =  drugDetails.get("wt_mand_yn")== null?"":(String) drugDetails.get("wt_mand_yn");//added for Bru-HIMS-CRF-079 IN[029945]
										ht_mand_yn =  drugDetails.get("ht_mand_yn")== null?"":(String) drugDetails.get("ht_mand_yn");//added for Bru-HIMS-CRF-079 IN[029945]

										//if(weight_rec_appl_age_group_check_flag.equals("Y")){ //commented for Bru-HIMS-CRF-079 IN[029945]
										if(wt_mand_yn.equals("Y") || ht_mand_yn.equals("Y")){//added for Bru-HIMS-CRF-079 IN[029945]
											recomm_yn_flag = true;	
										}

										provide_taper	=	"";
										if(drugDetails.get("PROVIDE_TAPER")!=null){
											provide_taper	= (String)drugDetails.get("PROVIDE_TAPER");	
										}
										no_refill			= (String)drugDetails.get("NO_REFILL");
										//licen				= (String)drugDetails.get("LICENCE");
										stock_available_yn	= (String)drugDetails.get("STOCK_AVAILABLE_YN");
										available_stock		= (String)drugDetails.get("AVAILABLE_STOCK");
										allow_pres_without_stock_yn = (String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");	
										scheduled_yn		= (String)drugDetails.get("SCHEDULED_YN");
										order_type_desc		= (String)drugDetails.get("ORDER_TYPE_DESC");
										amend_yn			= (String)drugDetails.get("AMEND_YN");
										allocatedd_yn		= (String)drugDetails.get("ALLOCATEDD_YN");
										rowVal				= (String)drugDetails.get("rowVal");
										split_dose_yn		= (String)drugDetails.get("SPLIT_DOSE_YN");
										dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
										taper_up			= (String)drugDetails.get("TAPER_UP");
										interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS"); // added for FD-RUT-CRF-0066.1 [IN036975]
										drugIntraction_override	= drugDetails.get("DRUGINTRACTION_OVERRIDE")==null?"":(String)drugDetails.get("DRUGINTRACTION_OVERRIDE"); // added for FD-RUT-CRF-0066.1 [IN036975]

										if( Integer.parseInt(adr_count)>0){
											drug_adr_count = bean.getADRCount(patient_id,drug_code);
											if(drug_adr_count>0){
												adr_gif="<img src='../../ePH/images/ADR.gif' height=20  width=15></img>";
											}
											else{
												adr_gif="&nbsp;";
											}
										}

										if(allocatedd_yn.equals("Y")){
											dis="display";
										}
										else{
											dis="display:none";					
										}
										//HashMap sliding_scale_dtls = bean.getSlidingScaleDetails(drug_code);
										dosage_unit			=	(String)drugDetails.get("DOSAGE_UNIT");
										if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0864 - Start
											   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit);
											   dose_unit_desc1= dose_unit_desc;		//Added for IN:070451
												System.out.println("dose_unit_desc--11>"+dose_unit_desc);
												if(dose_unit_desc==null || dose_unit_desc=="" ) {
												  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
												  dose_unit_desc1= dose_unit_desc;		//Added for IN:070451
											     if(dosage_unit.split("/").length>=2)
												   dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
												
												} 

											}// Added for ML-MMOH-SCF-0863 - End
							
										if(dosage_unit == null) 
											dosage_unit="";
										if(dose_unit_desc == null) 
											dose_unit_desc="";

										// control the child drug in tapering(was not considered as a tapered when the last child drug defaulted form the pad)
										prescriptionDetails=(ArrayList)bean.getpresDetails();
										//	prescriptionDetails=(ArrayList) dir_bean.getpresDetails();
										codeCount_1=0;
										codeCount_2=0;
										for(int count=0;count<prescriptionDetails.size();count++){
											ext_drugData=(HashMap) prescriptionDetails.get(count);
											ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
											ext_srl_no=(String) ext_drugData.get("SRL_NO");
											temp_freq_nature = (String) ext_drugData.get("FREQ_NATURE")==null?"": (String) ext_drugData.get("FREQ_NATURE");

											if( !(temp_freq_nature.equals("P") || temp_freq_nature.equals("O")) && (Float.parseFloat(srl_no) != (Float.parseFloat(ext_srl_no)))){
												if(drug_code.equals(ext_drug_code)){
													codeCount_1++;
												}
											}
											if(drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no))
												drug_index = count;
										}
										if(codeCount_1>=1){
											for(int count=drug_index;count<prescriptionDetails.size();count++){
												ext_drugData=(HashMap) prescriptionDetails.get(count);
												ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
												if(drug_code.equals(ext_drug_code)){
													codeCount_2++;
												}
											}
										}
										if(codeCount_1>=1 && codeCount_2==1 ){
											deft_mode="tapered";
										}
										else 
											deft_mode = "modify";

										String tapergif				= "";
										String allergy_override_gif	="";
										String overdose_override_gif="";
										String currrx_override_gif	="";
										ArrayList schedule			=	null;
										String freq_str				=	"";
										String tooltip				=	drug_desc+"/"+generic_name;
										//HashMap detail				=	null;
										//if the drug is scheduled  - store the values in or bean
										schedule_val				=	new Hashtable();
										if(!presBean.checkPreScheduled(freq_code).equals("0")) {
											schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
											if(schedule.size()==0 && scheduled_yn.equals("Y")) {
												ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject(sch_bean_id,sch_bean_name,request);
												/*if(sliding_scale_dtls.size()>0 && sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN")!=null && ((String)sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN")).equals("Y") ) {
													qty_value	=	(String)drugDetails.get("STRENGTH_VALUE");
												}*/
												schedule_bean.setLanguageId(locale);
												schedule_val.put("facility_id", facility_id);
												schedule_val.put("start_time_day_param", start_date);
												schedule_val.put("module_id", "PH"); 
												schedule_val.put("split_dose_yn", split_dose_yn); 
												schedule_val.put("split_qty",qty_value);	
												//out.println("===split_qty=="+qty_value);
												schedule_val.put("freq_code",  freq_code );
												schedule_val.put("code",drug_code+srl_no);
												sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
												sch_output.put("code",drug_code+srl_no);
												sch_output.put("row_value",rowVal);
												
												dir_bean.setScheduleFrequencyStr(sch_output);
												drugDetails.put("SCH_OVER_YN","Y");
												putObjectInBean(sch_bean_id,schedule_bean,request);
											}
										}

										if(split_dose_yn.equals("Y")) {
											schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
											
										boolean split_chk	=	bean.checkSplit(schedule);
										
										/* for(int n=0; n<schedule.size(); n++) { //commented by Abdul for Multi Frequency CRF
											detail	=	(HashMap)schedule.get(n);
											freq_str = freq_str + detail.get("admin_time")+"-";
											freq_str = freq_str + detail.get("admin_qty")+" "+qty_desc;
											if(n==(schedule.size()-1))
												freq_str = freq_str +" ";
											else
												freq_str = freq_str +", ";
										}	*/
										if(schedule.size()>0) {
											ArrayList time_list		= (ArrayList)schedule.get(3);					
											ArrayList dose_list		= (ArrayList)schedule.get(4);					
											for(int n=0;n<dose_list.size();n++){
												freq_str = freq_str + (String)time_list.get(n)+"-";
												freq_str = freq_str + (String)dose_list.get(n)+" "+qty_desc;
												if(n==(dose_list.size()-1))
													freq_str = freq_str +" ";
												else
													freq_str = freq_str +", ";
											}
										}
										if(dosage_type.equals("A"))
											tooltip			=tooltip + " - for "+durn_value+" "+or_durn_desc;
										else if(schedule.size() > 0 && split_chk) 
											tooltip			=tooltip + " -"+qty_value+" "+or_qty_desc+" (Divided) for "+durn_value+" "+or_durn_desc;
										else if(schedule.size() > 0) 
											tooltip			=tooltip + " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
										else 
											tooltip			=tooltip + " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
									} 
									else {
										if(dosage_type.equals("A"))
											tooltip			=tooltip + " - "+freq_desc+" for "+durn_value+" "+or_durn_desc;
										else {
											schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
											if(schedule.size() > 0) {
												/* detail	=	(HashMap)schedule.get(0); //commented by Abdul for Multi Frequency CRF
												qty_value		=	(String)detail.get("admin_qty");*/
												ArrayList dose_list		= (ArrayList)schedule.get(4);
												if(dose_list.size()>0){
													qty_value		= (String)dose_list.get(0);
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														qty_value="1";
												 }
												 else{
													 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														 qty_value="1";
												 }
											}
											tooltip	=tooltip + " - "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
										}
									}
									/*** Tool tip ends***/
									if(patient_class.equals("IP") && dosage_type.equals("A")) {
										ArrayList QtyDescDetails		= (ArrayList)presBean.loadQtyDetails(form_code);
									
										for(int p=0; p<QtyDescDetails.size(); p+=3) {
											uom_code	= (String)QtyDescDetails.get(p);
											uom_desc	= (String)QtyDescDetails.get(p+1);
											dflt_yn		= (String)QtyDescDetails.get(p+2);

											if(dflt_yn.equals("Y")) {
												drugDetails.put("QTY_DESC",uom_code);
												drugDetails.put("OR_QTY_DESC",uom_desc);
											}
										}
									}
									String dispDesc="";
									if(drug_desc.length()>11)
										dispDesc=drug_desc.substring(0,11)+"...";
									else
										dispDesc=drug_desc;
									if(j==(displayList.size())-1){
										if(freq_nature!=null && (freq_nature.equals("O")|| freq_nature.equals("P") ) ){
											taper_yn="N";
											taper_up = "N";
										}
										if( (provide_taper.equals("Y"))  && (no_refill.equals("") || no_refill.equals("0")) )	{
											if(taper_up!=null && taper_up.equals("Y"))
												tapergif="<img src='../../ePH/images/uparrow.gif' onclick=defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"'); title='Taper Dose' ></img>";
											else if(taper_yn!=null && taper_yn.equals("Y"))
												tapergif="<img src='../../ePH/images/downarrow.gif' onclick=defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"'); title='Taper Dose' ></img>";
										}
										else {
											tapergif="";
										}
									}
									else{
										tapergif="";
									}
									if(allergy_override!=null && allergy_override.equals("N"))
										allergy_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";
									else
										allergy_override_gif="&nbsp;";

									if(dose_override!=null && dose_override.equals("N"))
										overdose_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
									else
										overdose_override_gif="&nbsp;";

									if(currentrx_override!=null && currentrx_override.equals("N"))
										currrx_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";
									else
										currrx_override_gif="&nbsp;";
									if(drugIntraction_override!=null && drugIntraction_override.equals("N")){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start
										drugIntraction_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
									}
									else{
										drugIntraction_override_gif="&nbsp;";
									} // added for FD-RUT-CRF-0066.1 [IN036975] -End
									
									if(!(prev_order_code.equals(order_type_code))){

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_type_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);

										prev_order_code=order_type_code;
									}
									if(stock_available_yn.equals("N")){
										if(allow_pres_without_stock_yn.equals("N")){
											tapergif="";						
										}
									}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block14Bytes, _wl_block14);

										if(j==0){
											if(amend_yn.equals("Y")){
												classValue="AMENDEDDRUGS";
											}
											else{
												classValue="SELECTEDRUGS1";
												if(tmp_srl_no==null){
													tmp_srl_no		=	srl_no;
													tmp_drug_code	=	drug_code;
												}
											}
										}
										else{
											if(deft_mode.equals("tapered"))
												classValue="TAPERDRUGS";
											else if(amend_yn.equals("N")){
												classValue="SELECTEDRUGS";
												if(tmp_srl_no==null){
													tmp_srl_no		=	srl_no;
													tmp_drug_code	=	drug_code;
												}
											}
										}
										if(j==(displayList.size())-1){

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block16Bytes, _wl_block16);

										}
										else{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block16Bytes, _wl_block16);

										}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(external_dosage_override_reason));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(external_contra_override_reason));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block14Bytes, _wl_block14);

										if(stock_available_yn.equals("N")){
											if(allow_pres_without_stock_yn.equals("N")){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
 
												if (!ext_prod_id.equals("")	) {	

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_desc1));
            _bw.write(_wl_block40Bytes, _wl_block40);

												}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(available_stock));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(available_stock));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block46Bytes, _wl_block46);

											}
											else{
												classValue="NOSTOCKWARN";
												if(sch_over_yn.equals("N") ){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
 
													if (!ext_prod_id.equals("")	) {	

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_desc1));
            _bw.write(_wl_block40Bytes, _wl_block40);

													}

            _bw.write(_wl_block50Bytes, _wl_block50);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);

													if (!ext_prod_id.equals("")&&perform_external_database_checks_yn.equals("Y")) {

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_desc1));
            _bw.write(_wl_block40Bytes, _wl_block40);

													}

            _bw.write(_wl_block50Bytes, _wl_block50);

													if(drug_adr_count>0){

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(adr_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);
	
													}
													else{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);

													}	
												}
												if(show_external_override_gif){

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_alergy_check_flag));
            _bw.write(_wl_block59Bytes, _wl_block59);

													if(external_checks_overrided.equals("N")){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block61Bytes, _wl_block61);

													}
													else{

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block63Bytes, _wl_block63);

													}

            _bw.write(_wl_block64Bytes, _wl_block64);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block66Bytes, _wl_block66);

												}
												if(allergy_yn!=null && allergy_yn.equals("Y")){

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);

												}
												//if(limit_ind!=null && limit_ind.equals("N") && dose_override!=null && dose_override.equals("N")&& perform_external_database_checks_yn.equals("N")){
												if(limit_ind!=null && limit_ind.equals("N") && perform_external_database_checks_yn.equals("N")){

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(mono_graph)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(overdose_override_gif));
            _bw.write(_wl_block72Bytes, _wl_block72);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);

												}
												if( interaction_exists.equals("Y") ){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(drugIntraction_override_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block79Bytes, _wl_block79);

												} // added for FD-RUT-CRF-0066.1 [IN036975] - End
												if(current_rx!=null && current_rx.equals("Y")&&perform_external_database_checks_yn.equals("N")){

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);

												}
											}
										}
										else{
											if(sch_over_yn.equals("N") ){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);

												if (!ext_prod_id.equals("")	) {

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_desc1));
            _bw.write(_wl_block40Bytes, _wl_block40);

												}

            _bw.write(_wl_block86Bytes, _wl_block86);

												if(drug_adr_count>0){

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(adr_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
 
												}
											}
											else{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block92Bytes, _wl_block92);

												if (!ext_prod_id.equals("")&&perform_external_database_checks_yn.equals("Y")) {

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_desc1));
            _bw.write(_wl_block40Bytes, _wl_block40);

												}

            _bw.write(_wl_block86Bytes, _wl_block86);
                  
												if(drug_adr_count>0){

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(adr_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);
					
												}
												else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);

												}				
											}
											if(show_external_override_gif){

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_db_alergy_check_flag));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(external_checks_overrided.equals("N")){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block61Bytes, _wl_block61);

											}
											else{

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block63Bytes, _wl_block63);

											}

            _bw.write(_wl_block97Bytes, _wl_block97);

										}
										else{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block99Bytes, _wl_block99);

										}
										if(allergy_yn!=null && allergy_yn.equals("Y")&&perform_external_database_checks_yn.equals("N")){

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

										}
										else{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);

										}					
										//if(limit_ind!=null && limit_ind.equals("N") && dose_override!=null && dose_override.equals("N")&&perform_external_database_checks_yn.equals("N")){
										if(limit_ind!=null && limit_ind.equals("N") && perform_external_database_checks_yn.equals("N")){

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(mono_graph)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(overdose_override_gif));
            _bw.write(_wl_block102Bytes, _wl_block102);

										}
										else{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);

										}
										if( interaction_exists.equals("Y") ){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start

            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(drugIntraction_override_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

										}
										else{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block79Bytes, _wl_block79);

										} // added for FD-RUT-CRF-0066.1 [IN036975] -End
										if(current_rx!=null && current_rx.equals("Y")&& perform_external_database_checks_yn.equals("N")){

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block54Bytes, _wl_block54);

										}	
										else{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);

										}
									}

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(wt_mand_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(ht_mand_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(weight_rec_appl_age_group_check_flag));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(recomm_yn_flag));
            _bw.write(_wl_block114Bytes, _wl_block114);

								}
							}
						}
					}

            _bw.write(_wl_block115Bytes, _wl_block115);

			}// top if

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(recomm_yn_flag));
            _bw.write(_wl_block120Bytes, _wl_block120);
 
		putObjectInBean(dir_bean_id,dir_bean,request);
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);

            _bw.write(_wl_block121Bytes, _wl_block121);

		if(tmp_srl_no!=null ){
			if(recomm_yn_flag){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(tmp_drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block123Bytes, _wl_block123);

			}
			else{

            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(tmp_drug_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block125Bytes, _wl_block125);

			}
		}

            _bw.write(_wl_block126Bytes, _wl_block126);

	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block127Bytes, _wl_block127);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InsufficientStock-AvailableQuantity.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
}
