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

public final class __prescriptionform_1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionForm_1.jsp", 1741152472538L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--saved on 27th Oct 2005 --> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n    <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/Prescription_1.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<form name=\"prescription_form\" id=\"prescription_form\" >\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type=\"hidden\" name=\"weight\" id=\"weight\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=\"hidden\" name=\"bsa\" id=\"bsa\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\"hidden\" name=\"sliding_scale_yn\" id=\"sliding_scale_yn\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" name=\"bean_id\" id=\"bean_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" name=\"bean_name\" id=\"bean_name\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\"mode\" id=\"mode\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"presBean_id\" id=\"presBean_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"presBean_name\" id=\"presBean_name\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" id=\"Selected_drugs\">\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"9\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td><!-- added for aakh-crf-0140 -->\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<tr  style=\"background-color: lightgoldenrodyellow;\" title=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\'row";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dt";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"dt";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_qty";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"order_qty";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">  <!-- Added for RUT-CRF-0088 [IN036978]-->\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\" onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--AAKH-CRF-0091-->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\"  title=\'\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\"  title=\'Tapered\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<!-- Modified for TFS id:7345 start -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  NOWRAP width=\"64%\" id=\'drug_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\"defaultDrug(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\" onmouseover=\"changeCursor(this);changeCol(this);\" onmouseout=\"realCol(this,\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" title=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"><font class=\"HYPERLINK\" size=\'1\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font>  <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font>  <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20  width=20 onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');return false;\">\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td><td style=\"background-color:red;font-weight:bold;font-size:11;cursor:pointer;height:20\" NOWRAP  colspan=\"3\" title=\"Available Qty:&nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"><marquee scrollamount=\"3\"><font style=\"font-weight:bold;color:white\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =":&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</font></marquee></td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" width=\"5%\" id=\'td_dosage_override";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\"><font class=\"HYPERLINK\" size=\'1\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font> <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\') \">\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</font> <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="                                    \n                                         <td class=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="   width=\"3%\"  title=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' >&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;</td>\n\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n                                          <td class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"   width=\"3%\">&nbsp;</td>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"SHIFTTOTAL\" width=\"5%\" title=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\"ext_ddb_override_indc";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" onClick=\"extDosageCheckFromPad(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\',\'PAD\');\" onmouseover=\"changeCursor1(this);\">\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t\t\t<img name=\'ext_ddb_override_img";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'visibility:hidden;\' ></img>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'visibility:visible;\' ></img>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  NOWRAP width=\"5%\" id=\"ext_ddb_override_indc";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\',\'PAD\');\" onmouseover=\"changeCursor1(this);\"><img name=\'ext_ddb_override_img";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'visibility:hidden;\' ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"ALLERGY\" id=\"allergy";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"  NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'  onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');\" onmouseover=\"changeCursor(this);\"  >&nbsp;";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"  NOWRAP width=\"5%\" id=\"allergy";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT\"  NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' onmouseover=\"changeCursor(this);\" onclick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\" id=\'td_dosage_override";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>&nbsp;";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="&nbsp;</td> <!-- dose_unit_desc Added for ML-MMOH-SCF-0633 [IN:063271] --><!-- Modified for IN:070451 end, Added dose_unit_desc1 for IN:071108 --><!-- Modified for IN:073769-->\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\"  NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' onmouseover=\"changeCursor(this);\" onclick=\"showInractionDtl(\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\');\" id=\'td_drugIntraction";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" width=\"5%\" id=\'td_drugIntraction";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\" style=\"BACKGROUND-COLOR:purple;\" NOWRAP width=\"5%\" title=\'Drug Abuse\' onmouseover=\"changeCursor(this);\" onclick=\"showAbuseDtl(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\');\" id=\'td_abuseaction";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" width=\"5%\" id=\'td_abuseaction";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"CURRENTRX\" id=\"currentrx";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' onmouseover=\"changeCursor(this);\" onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\">&nbsp;";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"  NOWRAP width=\"5%\" id=\"currentrx";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"  NOWRAP width=\"64%\" onClick=\"defaultDrug(\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\');\" id=\'drug_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'  onmouseover=\"changeCursor(this);changeCol(this);\" onmouseout=\"realCol(this,\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\');\"><font CLASS=\"HYPERLINK\" size=\'1\' >";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</font><!--parent_stat_yn,stat_yn AAKH-CRF-0091-->\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' onmouseover=\"changeCursor(this);changeCol(this);\" onmouseout=\"realCol(this,\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\');\"> <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->\n\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" size=\'1\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=20  width=20 onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="                                    \n\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="   width=\"3%\" id=\'ADR\'  title=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\"   id=\'ADR\'  width=\"3%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"SHIFTTOTAL\" width=\"5%\" title=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<img name=\'ext_ddb_override_img";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'visibility:hidden;\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'visibility:visible;\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"  onmouseover=\"changeCursor1(this);\" onClick=\"extDosageCheckFromPad(\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\',\'PAD\');\"><img name=\'ext_ddb_override_img";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"ALLERGY\"  id=\"allergy";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" NOWRAP width=\"5%\"title=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\');\" onmouseover=\"changeCursor(this);\">&nbsp;";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" NOWRAP width=\"5%\"  id=\"allergy";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT\"  NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' onmouseover=\"changeCursor(this);\"   onclick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="&nbsp;</td> <!-- dose_unit_desc Added for ML-MMOH-SCF-0633 [IN:063271] --><!-- Modified for IN:070451, Added dose_unit_desc1 for IN:071108  --><!-- Modified for IN:073769-->\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" nowrap width=\"5%\" id=\'td_dosage_override";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\"  NOWRAP width=\"5%\" title=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" nowrap width=\"5%\" id=\'td_drugIntraction";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\" style=\"BACKGROUND-COLOR:purple;\" NOWRAP width=\"5%\" title=\'drugAbuse\' onmouseover=\"changeCursor(this);\" onclick=\"showAbuseDtl(\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="&nbsp;</td>\n\n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"CURRENTRX\" id=\"currentrx";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'  onmouseover=\"changeCursor(this);\" onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" nowrap width=\"5%\" id=\'currentrx";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'amend_yn_";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' id=\'amend_yn_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'wt_mand_yn";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' id=\'wt_mand_yn";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ht_mand_yn";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' id=\'ht_mand_yn";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'weight_rec_appl_age_group_check_flag";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' id=\'weight_rec_appl_age_group_check_flag";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"> <!--added for Bru-HIMS-CRF-079 IN[029945] -->\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'recomm_yn_flag_";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' id=\'recomm_yn_flag_";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\textDosageCheckFromPad(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\',\'PADLOAD\');\n\t\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n<!-- moved      <input type=\'hidden\' name=\'amend_yn_";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"> from here to line 990 -06/01/2011- priya (to prevent script error on click of taper for first drug)-->\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'drug_class\' id=\'drug_class\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"parent_stat_yn\" id=\"parent_stat_yn\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"> \t\t<!--AAKH-CRF-0091-->\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_yn\" id=\"stat_yn\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\t\t\t\t\t\t<!--AAKH-CRF-0091-->\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\t\t\t\n\t\t</form>\n\t</body>\n\t<script>\n\tasync function toHoldShowModal(){\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\trecommendDosage(\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'); \n//prescription_form, removed for Bru-HIMS-CRF-079\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\tawait defaultDrug(\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\');  //<!--\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'_AAKH-CRF-0091-->\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\tawait getBLErrorDrugs();\n\t\t\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n}\ntoHoldShowModal();\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

/*

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 	07/02/2017				manickyam						AAKH-CRF-0091 [IN061197] 
26/07/2019      IN070451		    B Haribabu  26/07/2019       Manickam               ML-MMOH-CRF-1408
07/08/2019      IN:071108		    B Haribabu                                          ML-MMOH-CRF-1408
15/07/2020     IN073431		    	    Manickavasagam J                                    MMS-KH-SCF-0080
24/08/2020      IN073769		   B Haribabu                                           PHIS-PH-Alpha - Exceed Dosage Limit Icon not opening in CA place order
05/01/2021	 TFS id:7345           Haribabu	      05/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
13/05/2021  	TFS id:-16701	     Manickavasagam J                                    RBU-GHL-CRF-0004
22-05-2022                           prathyusha                                         AAKH-CRF-0140
--------------------------------------------------------------------------------------------------------------
*/

	HttpSession xx = request.getSession(false);
	Properties jdbc_props = (Properties)xx.getValue("jdbc");
	String classValue		= ""; 
	String prev_order_code	= "";
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bed_num			= request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
	String room_num			= request.getParameter("room_num")==null?"":request.getParameter("room_num");
	String weight			= request.getParameter("weight")==null?"0":request.getParameter("weight");
	String bsa				= request.getParameter("bsa")==null?"0":request.getParameter("bsa");
	String patient_class	= request.getParameter("patient_class");
	String drug_code_sliding = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String srl_no_sliding   = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String facility_id		= (String)session.getValue("facility_id");
	String bl_install_yn	= request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String drug_db_interface_yn	        = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String drug_db_allergy_check_yn	    = request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");
	String drug_db_duptherapy_yn	    = request.getParameter("drug_db_duptherapy_yn")==null?"":request.getParameter("drug_db_duptherapy_yn");
	String bl_disp_charge_dtl_in_rx_yn  = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	String conf_drug_code	    = request.getParameter("conf_drug_code")==null?"":request.getParameter("conf_drug_code");
	String conf_srl_no  = request.getParameter("conf_srl_no")==null?"":request.getParameter("conf_srl_no");
	String alternateDisable = "";//added for  JD-CRF-0198 [IN:058599]
	
	//String mode				= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;	
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	bean.setCalExtDBYN("Y");//Added for TFS id:-16701
	ArrayList	presDetails	=(ArrayList) bean.getpresDetails();
	String sch_bean_id		= "OrScheduleFreq" ;
	String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
	String order_set_code	= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	if(bean.getAmend_alternate_yn().equals("Y"))//added for  JD-CRF-0198 [IN:058599]
		 alternateDisable = "disabled";

            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		bean.setLanguageId(locale);
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{
  	String grp_order_type_code	=	null;
	ArrayList displayList		=	null;
	HashMap drugDetails			=	null; 
	String order_type_code		=	null;
	String drug_code			=	null; 
	String srl_no				=	null; 
	String drug_desc			=	null; 
	String drug_name_1			=   "";
	String generic_id			=	null; 
	String generic_name			=	null; 
	String taper_yn				=	null; 
	String allergy_yn			=	null; 
	String qty_value			=	null; 
	String qty_desc				=	null; 
	String qty_desc_code		=	null; 
	String or_qty_desc			=	null; 
	String freq_desc			=	null; 
	String durn_value			=	null; 
	String or_durn_desc			=	null; 
	String freq_chng_durn_desc  =   null;
	String limit_ind			=	null; 
	String mono_graph			=	null; 
	String daily_dose			=	null; 
	String unit_dose			=	null; 
	String min_daily_dose		=	null; 
	String min_unit_dose		=	null; 
	String dosage_std			=	null;
	String freq_nature			=	null;
	String current_rx			=	null;
	String allergy_override		=	null; 
	String dose_override		=	null; 
	String currentrx_override	=	null; 
	String sch_over_yn			=	null; 
	String ext_prod_id			=	null;
	String start_date			=	null;
	String end_date				=	null;
	String provide_taper		=	"";	
	String no_refill			=	null;
	String stock_available_yn	=	null;
	String available_stock		=	null;
	String allow_pres_without_stock_yn = null;
	String scheduled_yn			=	null;
	String order_type_desc		=	null;
	String amend_yn				=	null;
	String rowVal				=	null;
	String split_dose_yn		=	null;
	String dosage_type			=	null;
	String tmp_srl_no			=	null;
	String tmp_drug_code		=	null;
	String freq_code			=	null;
	Hashtable schedule_val		=	null;
	Hashtable sch_output		=	null;
	String dosage_unit			=	"";
	String dose_unit_desc       =   ""; // Added for ML-MMOH-SCF-0633 [IN:063271]
	String stock_uom			=	"";
	String repeat_value			=   "";
	//code added for recommended dosage...on 4/5/2004
	boolean recomm_yn_flag		=	false;
	String recomm_yn			=	"";
	String taper_up				=	"";
	String sliding_scale_yn		=   "";
	String form_code			=	"";	
	String uom_code				=	"";
	String uom_desc				=	"";
	String dflt_yn				=	"";
	ArrayList prescriptionDetails = null;
	HashMap ext_drugData		  =	null;
	String ext_drug_code	=	null;
	String ext_srl_no		=	null;
	int drug_index          =   0;
	int codeCount_1		    =   0;
	int codeCount_2		    =   0;
	String deft_mode           =   "modify";
	String temp_freq_nature    =   "";
	String drug_db_dosage_check_flag    = "";
	String drug_db_duptherapy_flag		= "";
	String drug_db_contraind_check_flag	= "";
	String drug_db_interact_check_flag	= "";
	String drug_db_allergy_flag			= "";
	String ext_checks					= "";
	String ext_checks_overrided			= "";
	//String ext_override_reason="";
	String dsg_reason					= "";	
	String dup_reason		="";	
	String con_reason="";
	String int_reason="";
	String alg_reason="";
	String weight_rec_appl_age_group_check_flag = "";
	String wt_mand_yn="", ht_mand_yn=""; //added for Bru-HIMS-CRF-079 IN[029945]
	int drug_adr_count = 0;
	String adr_gif="";
	String copied_drug_yn="";
	String drug_class="";
	String current_rx_tapered="";
	String tmp_sliding_scale_yn="N";
    String duplicate_check_at_atc_yn=""; //added for skr-scf-0143 IN 29184
    String interaction_exists="", drugIntraction_override="", drugIntraction_override_gif="";
    	String abuse_exists="",abuse_action=""; //added for aakh-crf-0140
//	String new_srl_no = request.getParameter("new_srl_no")==null?"":request.getParameter("new_srl_no");
	String repeat_durn_type="";//Added for RUT-CRF-0088 [IN036978]
	String conv_factor="";//Added for RUT-CRF-0088 [IN036978]
	String order_qty = "";//Added for RUT-CRF-0088 [IN036978]
	String freq_chng_durn_value= "";//Added for RUT-CRF-0088 [IN036978]
	String pres_base_uom="";//Added for RUT-CRF-0088 [IN036978]
	String datechanged_yn="";//Added for ML-BRU-SCF-1423 [IN:050857]
	String stat_yn = ""; //Added forAAKH-CRF-0091	
	String parent_stat_yn =""; //Added forAAKH-CRF-0091
	String route_code	  = "";//AAKH-SCF-0340
	//Added for IN:070451 start
	String      max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	//Added for IN:070451 end
	String dose_unit_desc1       =   "";//Added for IN:071108
	String		pre_alloc_appl_yn =bean.getPreAllocApplYN();//Added for TFS id:7345
	String		drug_desc_new					=	"";//Added for TFS id:7345
	String		drug_search_by					=	"";//Added for TFS id:7345
	String abuse_override="N";//added for aakh-crf-0140

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bsa));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( deft_mode ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block21Bytes, _wl_block21);

	if(presDetails!=null && presDetails.size()>0){
		String curr_code = (String)(((HashMap) presDetails.get(presDetails.size()-1)).get("DRUG_CODE"));
		classValue="SELECTEDRUGS";

            _bw.write(_wl_block22Bytes, _wl_block22);

		ArrayList ordergrp	=(ArrayList) bean.ordsortList();
		ArrayList grp		=(ArrayList) bean.sortList();
		String atc_level_1	=	"";
		String atc_level_2	=	"";
		String atc_level_3	=	"";
		String atc_level_4		=	"";  // added for the incedent no : 27465 
		String atc_level_5		=	"";  // added for the incedent no : 27465 
		String temp_generic_id = "";
		String temp_drug_code="";
		String ATC_dup_drug_code="";     // added for the incedent no : 27465 
		//String temp_drug_code1="";
		//String tappered_over="";
		ArrayList atc_dup_drug_code= null;
		ArrayList atc_values =  new ArrayList();
		HashMap drug_detail	 =	null;
		String patient_stock_yn = "N";//added for ghl-crf-0482

		for(int i=0;i<presDetails.size();i++){
			current_rx_tapered = "";
			drug_detail=(HashMap) presDetails.get(i);
			duplicate_check_at_atc_yn       = (String) drug_detail.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
			if(!drug_code_sliding.equals("") && drug_code_sliding.equals((String)drug_detail.get("DRUG_CODE")) && srl_no_sliding.equals((String)drug_detail.get("SRL_NO"))){
				drug_detail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND","");
				drug_detail.put("BL_OVERRIDE_EXCL_INCL_IND","");

				drug_detail.put("BL_TOTAL_CHARGE_AMT","");   //added on 15dec-09
				drug_detail.put("BL_PATIENT_PAYABLE_AMT",""); //added on 15dec-09
				drug_detail.put("BL_DECIMAL_FORMAT_STRING",bean.getBLDecimalFormatString()); // priya --added for IN19010 --24/02/2010
				//tmp_sliding_scale_yn =drugDetails.get("SLIDING_SCALE_YN")==null?"":(String)drugDetails.get("SLIDING_SCALE_YN") ; //hanga
			}
			ext_prod_id			= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
			drug_db_duptherapy_flag		=  (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
			copied_drug_yn		=  (String)drug_detail.get("COPIED_DRUG_YN")==null?"":(String)drug_detail.get("COPIED_DRUG_YN");
			current_rx_tapered = drug_detail.get("CURRENT_RX")==null?"":(String)drug_detail.get("CURRENT_RX");// moved out from the below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -start
			amend_yn			= drug_detail.get("AMEND_YN")==null?"":(String)drug_detail.get("AMEND_YN");
			if( current_rx_tapered.equals("Y") && !drug_detail.containsKey("ORIG_CURRENT_RX")) {
				drug_detail.put("ORIG_CURRENT_RX","Y");							
			}
			else if( !current_rx_tapered.equals("Y") && !amend_yn.equals("Y")){ //else if block added for Bru-HIMS-CRF-265 [IN:032315] // && !amend_yn.equals("Y") added for [IN:044495]
				drug_detail.put("ORIG_CURRENT_RX","N");		
			}// moved out from below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -end
			//	if((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
			//if(!drug_db_duptherapy_yn.equals("Y") ) { //commented this if codition for the incident no : 27465 
			if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){ //if condition added for skr-scf-0143 IN 29184
				atc_level_1	=	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
				atc_level_2	=	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
				atc_level_3	=	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
				atc_level_4	    =	(String)drug_detail.get("ATC_CLASS_LEV4_CODE");
				atc_level_5	    =	(String)drug_detail.get("ATC_CLASS_LEV5_CODE");
				drug_desc	=	(String)drug_detail.get("DRUG_DESC");
				drug_desc_new				= (String) drug_detail.get("DRUG_DESC_NEW")==null?"":(String) drug_detail.get("DRUG_DESC_NEW");
				drug_search_by				= (String) drug_detail.get("DRUG_SEARCH_BY")==null?"":(String) drug_detail.get("DRUG_SEARCH_BY");
				drug_name_1=drug_desc;
				drug_name_1=drug_name_1.replaceAll(" ","%20");
				drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
				drug_name_1=drug_name_1.replaceAll("%2520","%20");

				temp_generic_id	=	(String)drug_detail.get("GENERIC_ID");
				temp_drug_code = (String)drug_detail.get("DRUG_CODE");
				provide_taper	=	"";

				if(drug_detail.get("TAPPERED_OVER")!=null)
					provide_taper	= (String)drug_detail.get("TAPPERED_OVER");			
				if( (!provide_taper.equals("Y")) && (drug_detail.get("ALERT_YN")==null && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("")))) {
					atc_dup_drug_code = new ArrayList();
					atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE");
					if(atc_dup_drug_code == null)
						atc_dup_drug_code = new ArrayList();
					if(!atc_values.contains(temp_drug_code)){ // ie. only while tapering, same drug will be allowed, and if its tapering need not chk for duplicate
						if(atc_values.contains(temp_generic_id)){
							drug_detail.put("CURRENT_RX","Y");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							drug_detail.put("ALERT_YN","Generic :");

						}
						else if(atc_values.contains(atc_level_4)){    // added else if condition for the incedent no : 27465 
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 4:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incedent no : 27465 
						}
						// commented below  coditions for the incident no : 27465
						/*else if(atc_values.contains(atc_level_1)){ 
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 1:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
						}
						else  if(atc_values.contains(atc_level_2)){
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 2:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
						}
						else if(atc_values.contains(atc_level_3)){
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							drug_detail.put("ALERT_YN","Level 3:");
						} */
						else{
							atc_values.add(drug_desc);
							atc_values.add(temp_drug_code);
							atc_values.add(temp_generic_id);
							if(!(atc_level_1==null || atc_level_1.equals("")))
								atc_values.add(atc_level_1);
							if(!(atc_level_2==null || atc_level_2.equals("")))
								atc_values.add(atc_level_2);
							if(!(atc_level_3==null || atc_level_3.equals("")))
								atc_values.add(atc_level_3);
							if(!(atc_level_4==null || atc_level_4.equals(""))){ // added condition for the incedent no : 27465 
								atc_values.add(atc_level_4);
							}
							if(!(atc_level_5==null || atc_level_5.equals(""))){ // added for the incedent no : 27465 
								atc_values.add(atc_level_5);
							}
						}
					}
					else{
					//if condition added for SKR-SCF-1597
					if(atc_values.contains(atc_level_4) && atc_values.contains(temp_drug_code)){
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 4:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
					}else
						drug_detail.put("CURRENT_RX","N");
						//drug_detail.put("TAPPERED_OVER","Y"); //Commented for 30030
					}
				}else{ //SKR-SCF-1482 - start
					if(current_rx_tapered.equals("Y")){
						atc_values.add(drug_desc);
						atc_values.add(temp_drug_code);
						atc_values.add(temp_generic_id);
						if(!(atc_level_1==null || atc_level_1.equals("")))
							atc_values.add(atc_level_1);
						if(!(atc_level_2==null || atc_level_2.equals("")))
							atc_values.add(atc_level_2);
						if(!(atc_level_3==null || atc_level_3.equals("")))
							atc_values.add(atc_level_3);
						if(!(atc_level_4==null || atc_level_4.equals(""))){ 
							atc_values.add(atc_level_4);
						}
						if(!(atc_level_5==null || atc_level_5.equals(""))){ 										
							atc_values.add(atc_level_5);
						}
					}
				//SKR-SCF-1482 - end	
				
				}
			} //end if duplicate_check_at_atc_yn 
			//}
/*ext check starts
			ArrayList exProd				= new ArrayList();
			ArrayList drugDesc				= new ArrayList();
			for(int i=0;i<prescriptionDetails.size();i++){
				drug_detail				=(HashMap) prescriptionDetails.get(i);
				ext_db_drug_code				=(String) drug_detail.get("EXTERNAL_PRODUCT_ID");
				ext_drug_code	= (String) drug_detail.get("DRUG_CODE");
				ext_srl_no				=(String) drug_detail.get("SRL_NO");

				if(!exProd.contains(ext_db_drug_code)){
					drugDesc.add((String)drug_detail.get("DRUG_DESC"));
					if(!ext_db_drug_code.equals("")){
					   exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
					}
				}
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					drug_detail.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
				}
			}

			if(exProd.size()>0)
				ext_beanObj.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids

			if(drug_db_allergy_check_yn.equals("Y")){
				ArrayList ex_prod_ids =new ArrayList();
				ex_prod_ids.add(ext_prod_id);

				ext_beanObj.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				HashMap drug_alergies =(HashMap)ext_beanObj.getDrugAlergies();

				if(drug_alergies.containsKey(ext_prod_id)){
					drug_db_allergy_flag="Y";
				}	
			}ext check ends*/
		}
		for(int k=0;k<ordergrp.size();k++){
			grp_order_type_code	=(String) ordergrp.get(k);
			if(grp_order_type_code == null)
				grp_order_type_code="";
			for(int i=0;i<grp.size();i++){
				displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));
				for(int j=0;j<displayList.size();j++){
					drugDetails = new HashMap();
					drugDetails=(HashMap) displayList.get(j);
					order_type_code	= (String)drugDetails.get("ORDER_TYPE_CODE")==null?"":(String)drugDetails.get("ORDER_TYPE_CODE");
					recomm_yn_flag = false;
					if(grp_order_type_code.equals(order_type_code)){
						sliding_scale_yn	= drugDetails.get("SLIDING_SCALE_YN")==null?"":(String)drugDetails.get("SLIDING_SCALE_YN") ; 
						
						drug_code			= drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
						srl_no				= drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");
						drug_desc			= drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");
						drug_desc_new				= (String) drugDetails.get("DRUG_DESC_NEW")==null?"":(String) drugDetails.get("DRUG_DESC_NEW");//Added for TFS id:7345
						drug_search_by				= (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");//Added for TFS id:7345
						drug_name_1=drug_desc;
						drug_name_1=drug_name_1.replaceAll(" ","%20");
						drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
						drug_name_1=drug_name_1.replaceAll("%2520","%20");
						generic_id			= drugDetails.get("GENERIC_ID")==null?"":(String)drugDetails.get("GENERIC_ID");
						generic_name		= drugDetails.get("GENERIC_NAME")==null?"":(String)drugDetails.get("GENERIC_NAME");
						taper_yn			= drugDetails.get("TAPER_DOSE_YN")==null?"":(String)drugDetails.get("TAPER_DOSE_YN");
						allergy_yn			= drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
						qty_value			= drugDetails.get("QTY_VALUE")==null?"":(String)drugDetails.get("QTY_VALUE");
						qty_desc			= drugDetails.get("QTY_DESC")==null?"":(String)drugDetails.get("QTY_DESC");
						qty_desc_code		= drugDetails.get("QTY_DESC_CODE")==null?"":(String)drugDetails.get("QTY_DESC_CODE");
						or_qty_desc			= drugDetails.get("OR_QTY_DESC")==null?"":(String)drugDetails.get("OR_QTY_DESC");
						freq_code			= drugDetails.get("FREQ_CODE")==null?"":(String)drugDetails.get("FREQ_CODE");
						freq_desc			= drugDetails.get("FREQ_DESC")==null?"":(String)drugDetails.get("FREQ_DESC");
						pres_base_uom		= (String) drugDetails.get("PRES_BASE_UOM");   //Added for RUT-CRF-0088 [IN036978]
						stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn");  //Added for AAKH-CRF-0091
					//	freq_desc = java.net.URLEncoder.encode(freq_desc,"UTF-8");
					/*	freq_desc			= freq_desc.replaceAll("%26","&");
						freq_desc			= freq_desc.replaceAll("%40","@");
						freq_desc			= freq_desc.replaceAll("%20"," "); */
			
						durn_value			= drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
						repeat_value		= drugDetails.get("REPEAT_VALUE")==null?"":(String)drugDetails.get("REPEAT_VALUE");
						or_durn_desc		= drugDetails.get("OR_DURN_DESC")==null?"":(String)drugDetails.get("OR_DURN_DESC");
						freq_chng_durn_desc = drugDetails.get("freq_chng_durn_desc")==null?"":(String)drugDetails.get("freq_chng_durn_desc");
						
						//Added for SRR20056-SCF7552 - Start
						if(freq_chng_durn_desc == null || freq_chng_durn_desc.equals(""))
							freq_chng_durn_desc= drugDetails.get("DURN_TYPE")==null?"":(String)drugDetails.get("DURN_TYPE") ;
						//Added for SRR20056-SCF7552 - End
						or_durn_desc		= presBean.getDurationType(freq_chng_durn_desc);
						limit_ind			= drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
						mono_graph			= drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
						daily_dose			= drugDetails.get("DAILY_DOSE")==null?"":(String)drugDetails.get("DAILY_DOSE");
						unit_dose			= drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
						min_daily_dose		= drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
						min_unit_dose		= drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
						dosage_std			= drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");;
						freq_nature			= drugDetails.get("FREQ_NATURE")==null?"":(String)drugDetails.get("FREQ_NATURE");
						current_rx			= drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");	
						allergy_override	= drugDetails.get("ALLERGY_OVERRIDE")==null?"":(String)drugDetails.get("ALLERGY_OVERRIDE");
						dose_override		= drugDetails.get("DOSE_OVERRIDE")==null?"":(String)drugDetails.get("DOSE_OVERRIDE");
						currentrx_override	= drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
						amend_yn			= drugDetails.get("AMEND_YN")==null?"":(String)drugDetails.get("AMEND_YN");
						sch_over_yn			= drugDetails.get("SCH_OVER_YN")==null?"":(String)drugDetails.get("SCH_OVER_YN");
						ext_prod_id			= drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"": (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
						start_date			= drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE");
						end_date			= drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");
						patient_stock_yn	= drugDetails.get("patient_stock_yn")==null?"N":(String)drugDetails.get("patient_stock_yn");//added for ghl-crf-0482
						current_rx_tapered = drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");//Added for ARYU-SCF-0138
						//Added for IN:070451 start
						abuse_override=drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");//added for aakh-crf-0140
						max_daily_ceeling_dose		= drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
						min_daily_ceeling_dose		= drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
						max_unit_ceeling_dose		= drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
						min_unit_ceeling_dose		= drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
						//Added for IN:070451 end
						if(stat_yn.equals("Y")){ //added for AAKH-SCF-0340 
							if(start_date!=null && !start_date.equals("")){ // && end_date!=null && end_date.equals("") removed for MMS-MD-SCF-0092 
								end_date = bean.populateEndDate("",start_date,"1","D");
								drugDetails.put("END_DATE",end_date);
							}
						}

						stock_uom			= drugDetails.get("STOCK_UOM_DESC")==null?"":(String)drugDetails.get("STOCK_UOM_DESC");
						form_code			= drugDetails.get("FORM_CODE")==null?"":(String)drugDetails.get("FORM_CODE");
						 //added for CRF RUT-CRF-0063[29601]--start
						// added for CRF RUT-CRF-0063[29601]--end
						//code added for recommended doasge....on 4/5/2004
						recomm_yn			= (drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN")).trim();
						weight_rec_appl_age_group_check_flag =  drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG")== null?"":(String) drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG");
						wt_mand_yn =  drugDetails.get("WT_MAND_YN")== null?"":(String) drugDetails.get("WT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
						ht_mand_yn =  drugDetails.get("HT_MAND_YN")== null?"":(String) drugDetails.get("HT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
						interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");
						abuse_exists=(String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
						abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"N": (String) drugDetails.get("ABUSE_ACTION");
						
						drugIntraction_override	= drugDetails.get("DRUGINTRACTION_OVERRIDE")==null?"":(String)drugDetails.get("DRUGINTRACTION_OVERRIDE");
						//added for the incedent no : 27465 - Start
						atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.size()>0)
							ATC_dup_drug_code = "Y";
						else 
							ATC_dup_drug_code = "";
						//added for the incedent no : 27465 - End
						//if(recomm_yn.equals("Y")&&(sliding_scale_yn.equals("Y"))){					
						if(recomm_yn.equals("Y") && !amend_yn.equals("Y")){					
							recomm_yn_flag = true;	
							//drugDetails.put("SLIDING_SCALE_YN","N") ;
							sliding_scale_yn = "N";
						}
						if(request.getParameter("sliding_scale_yn") != null)
							sliding_scale_yn = request.getParameter("sliding_scale_yn");

						//if(weight_rec_appl_age_group_check_flag.equals("Y")){ //commented for Bru-HIMS-CRF-079 IN[029945]
						if(wt_mand_yn.equals("Y") || ht_mand_yn.equals("Y")){ //added for Bru-HIMS-CRF-079 IN[029945]
							recomm_yn_flag = true;	 
						}

						if (sliding_scale_yn.equals("Y")){
							qty_value = drugDetails.get("PRES_QTY_VALUE")==null?"":(String)drugDetails.get("PRES_QTY_VALUE");
							qty_desc = drugDetails.get("PRES_BASE_UOM_DESC")==null?"":(String)drugDetails.get("PRES_BASE_UOM_DESC");
						}
						drug_db_dosage_check_flag      =	 (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");
						drug_db_contraind_check_flag	= (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
						drug_db_interact_check_flag	=  (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");	
						drug_db_duptherapy_flag		=  (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag		=  (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_ALLERGY_FLAG");
						dsg_reason	= (String) drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");	
						dup_reason	= (String) drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
						con_reason	= (String) drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");	
						int_reason	= (String) drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");	
						alg_reason	= (String) drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");	
						if(drug_db_dosage_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){
							ext_checks="Y";
						}
						else{
							if(drug_db_dosage_check_flag.equals("")&&drug_db_contraind_check_flag.equals("")&&drug_db_interact_check_flag.equals("")&&drug_db_duptherapy_flag.equals("") && drug_db_allergy_flag.equals(""))
								ext_checks="";
							else
								ext_checks="N";

						}
						if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) ||(drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) || (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) || (drug_db_interact_check_flag.equals("Y") && (int_reason.equals("")))||  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){
							ext_checks_overrided = "N";
						}
						else
							ext_checks_overrided = "Y";

						if(!ext_prod_id.equals("") && drug_db_allergy_check_yn.equals("Y") && drug_db_allergy_flag.equals("Y")){
							allergy_yn = "N";
							drugDetails.put("ALLERGY_YN",allergy_yn);
						}
						if(!ext_prod_id.equals("") && drug_db_duptherapy_yn.equals("Y") && drug_db_duptherapy_flag.equals("Y") && ATC_dup_drug_code.equals("")){ //added ATC_dup_drug_code.equals("") for the incedent no : 27465 
							current_rx = "N";
							drugDetails.put("CURRENT_RX",current_rx);
						}
						/*provide_taper	=	"";                               //commented on 02/06/2010 -- priya
						if(drugDetails.get("PROVIDE_TAPER")!=null)   
							 provide_taper	= (String)drugDetails.get("PROVIDE_TAPER"); */

						no_refill			= (String)drugDetails.get("NO_REFILL");
						stock_available_yn  = (String)drugDetails.get("STOCK_AVAILABLE_YN");
						available_stock	    = (String)drugDetails.get("AVAILABLE_STOCK");

						allow_pres_without_stock_yn = (String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");
						scheduled_yn		= drugDetails.get("SCHEDULED_YN")==null?"":(String)drugDetails.get("SCHEDULED_YN");
						order_type_desc		= drugDetails.get("ORDER_TYPE_DESC")==null?"":(String)drugDetails.get("ORDER_TYPE_DESC");
						if(!drug_class.equals("N"))
							drug_class			= drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
						rowVal				= drugDetails.get("rowVal")==null?"":(String)drugDetails.get("rowVal");
						split_dose_yn		= drugDetails.get("SPLIT_DOSE_YN")==null?"":(String)drugDetails.get("SPLIT_DOSE_YN");
						dosage_type			= drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
						taper_up			= drugDetails.get("TAPER_UP")==null?"":(String)drugDetails.get("TAPER_UP");

						dosage_unit			= drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
 						if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0633 [IN:063271] - Start
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
						   dose_unit_desc1 =dose_unit_desc;//Added for IN:071108
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
	 						 dose_unit_desc1= dose_unit_desc;//Added for IN:071108
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
	 						} 
 						}// Added for ML-MMOH-SCF-0633 [IN:063271] - End
						stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn");						//Added forAAKH-CRF-0091
						
						parent_stat_yn  = (String)drugDetails.get( "parent_stat_yn" )==null?"":(String)drugDetails.get("parent_stat_yn");		//Added forAAKH-CRF-0091
						
						if(dosage_unit == null)
							dosage_unit="";

						prescriptionDetails=(ArrayList)bean.getpresDetails();
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
						if(codeCount_1>=1 && codeCount_2==1 && order_set_code.equals("")){
							deft_mode="tapered";
						}
						else 
							deft_mode = "modify";

						if(deft_mode.equals("tapered") && current_rx_tapered.equals("N")){
							current_rx = "N";
							drugDetails.put("CURRENT_RX",current_rx);
						}

						String tapergif				=   "";
						String allergy_override_gif	=   "";
						String overdose_override_gif=   "";
						String currrx_override_gif	=   "";
						String abuse_override_gif="";//added for aakh-crf-0140
						ArrayList schedule			=	null;
						//String freq_str				=	"";
					//Modified for TFS id:7345 start
						String tooltip				="";
						if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){
							tooltip				=	drug_desc_new+"/"+generic_name;
						}
						else{
							tooltip				=	drug_desc+"/"+generic_name;
						}
						//Modified for TFS id:7345 end
						String sliding_scale_yn_bean = drugDetails.get("sliding_scale_yn")==null?"":(String)drugDetails.get("sliding_scale_yn");
						String sliding_scale_yn_req	= request.getParameter("sliding_scale_yn")==null?"":request.getParameter("sliding_scale_yn");
						//HashMap detail				=	null;
					//AAKH-CRF-0091 
						if(parent_stat_yn.equals("Y")){
							route_code	= (String) drugDetails.get("ROUTE_CODE")==null?"":(String) drugDetails.get("ROUTE_CODE");
						}

						if(stat_yn.equals("Y")){
							ArrayList stat_freqs	=	presBean.loadStatFreqs(); // Commented for Performance ML-MMOH-SCF-00684
		//					ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performace ML-MMOH-SCF-00684
		//					if(stat_freqs !=null && stat_freqs.size()==0){ //if() Added for Performance ML-MMOH-SCF-00684
		//						stat_freqs	= (ArrayList)presBean.loadStatFreqs();
	//						}
							for(int m=0;m<stat_freqs.size();m+=2){
								freq_desc	   = ((String) stat_freqs.get(m+1));
								freq_code      = ((String) stat_freqs.get(m));
								
								break;
							}
							drugDetails.put("FREQ_CODE",freq_code);
							drugDetails.put("FREQ_DESC",freq_desc);
							drugDetails.put("AMEND_YN","Y");//added for MMS-DM-SCF-0449
							drugDetails.put("SCHEDULED_YN","N");//AAKH-SCF-0340
							drugDetails.put("FREQ_NATURE","O");
							drugDetails.put("ROUTE_CODE",route_code);
							
							//tooltip	=tooltip+ " - "+qty_value+" "+or_qty_desc+" " +freq_desc+" for 1 Day(s)";
						}
						//if the drug is scheduled  - store the values in or bean
						schedule_val				=	new Hashtable();
						if(!presBean.checkPreScheduled(freq_code).equals("0")) {
							schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
							if((schedule==null || schedule.size()==0 || !sliding_scale_yn_bean.equals(sliding_scale_yn_req)) && scheduled_yn.equals("Y") ) {
								ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject(sch_bean_id,sch_bean_name ,request);
								schedule_bean.setLanguageId(locale);
								schedule_val.put("facility_id", facility_id);
								schedule_val.put("start_time_day_param", start_date);
								schedule_val.put("module_id", "PH"); 
								schedule_val.put("split_dose_yn", split_dose_yn); 
								schedule_val.put("split_qty",qty_value);
								schedule_val.put("freq_code",  freq_code );
								schedule_val.put("code",drug_code+srl_no);
								sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
								sch_output.put("code",drug_code+srl_no);
								sch_output.put("row_value",rowVal);
								sch_output.put("start_date_time",start_date);
								bean.setScheduleFrequencyStr(sch_output);
								drugDetails.put("SCH_OVER_YN","Y");
								putObjectInBean(sch_bean_id,schedule_bean,request); 
							}
						}
					
					//Added for SRR20056-SCF7552 - Start
					if(or_qty_desc == null || or_qty_desc.equals(""))
						or_qty_desc= qty_desc ;
					if(or_qty_desc == null || or_qty_desc.equals(""))
					   or_qty_desc= drugDetails.get("PRES_BASE_UOM_DESC")==null?"":(String)drugDetails.get("PRES_BASE_UOM_DESC") ;
					//Added for SRR20056-SCF7552 - End
					if(split_dose_yn.equals("Y")) {
						schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");

						boolean split_chk	=	bean.checkSplit(schedule);
						if(dosage_type.equals("A")){
							//tooltip			=tooltip+ " - for "+durn_value+" "+or_durn_desc;
							tooltip			=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;    //""+qty_value+" '+or_qty_desc+"'Added for SRR20056-SCF7552
						}
						else if(schedule!=null && schedule.size() > 0 && split_chk) {
							tooltip			=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" (Divided) for "+durn_value+" "+or_durn_desc;
						}
						else if(schedule!=null && schedule.size() > 0) {
							tooltip	=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
						else {
							tooltip	=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
					} 
					else {
					//AAKH-CRF-0091 

						if(stat_yn.equals("Y")){
							
							tooltip	=tooltip+ " - "+qty_value+" "+or_qty_desc+" " +freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
						else{
							
							if(dosage_type.equals("A"))
								//tooltip			=tooltip+ " - "+freq_desc+" for "+durn_value+" "+or_durn_desc;
								tooltip			=tooltip+ " - "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc; //""+qty_value+" '+or_qty_desc+"'Added for SRR20056-SCF7552
							else {
								schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");

							if(schedule!=null && schedule.size() > 0) {
								/* detail	=	(HashMap)schedule.get(0);
								 qty_value		=	(String)detail.get("admin_qty");*/
								 ArrayList dose_list	= (ArrayList)schedule.get(4);
								 if(dose_list!=null && dose_list.size()>0)
										qty_value		= (String)dose_list.get(0);
							}
							tooltip	= tooltip+ " - "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
						}
					}
			/*** Tool tip ends***/ 
						
				if(patient_class.equals("IP") && dosage_type.equals("A")) {
					ArrayList QtyDescDetails		= (ArrayList)presBean.loadQtyDetails(form_code);
				
					for(int p=0; p<QtyDescDetails.size(); p+=3) {
						uom_code	= (String)QtyDescDetails.get(p);
						uom_desc	= (String)QtyDescDetails.get(p+1);
						dflt_yn		= (String)QtyDescDetails.get(p+2);

						if(dflt_yn.equals("Y")&&(uom_code.equals(qty_desc_code))) {
							drugDetails.put("QTY_DESC",uom_desc);
							drugDetails.put("QTY_DESC_CODE",uom_code);
							drugDetails.put("OR_QTY_DESC",uom_desc);
						}
					}
				}

				String dispDesc="";
				//Modified for TFS id:7345 start
				if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){
				if(drug_desc_new.length()>11){
					dispDesc=drug_desc_new.substring(0,11)+"...";
				}
				else{
					dispDesc=drug_desc_new;
				}
				}
				else{
					if(drug_desc.length()>11){
						dispDesc=drug_desc.substring(0,11)+"...";
					}
					else{
						dispDesc=drug_desc;
					}	
				}
				//Modified for TFS id:7345
				if(j==(displayList.size())-1){
 //Added for RUT-CRF-0088 [IN036978]
					
					if(dosage_type.equals("Q"))
						conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
				
				freq_chng_durn_value = durn_value;
				
				repeat_durn_type			= drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String) drugDetails.get("REPEAT_DURN_TYPE");	
				if(!freq_chng_durn_desc.equals(repeat_durn_type)){
					freq_chng_durn_value = (String)bean.getFreqDurnConvValue(repeat_durn_type,durn_value,freq_chng_durn_desc);
					repeat_durn_type = freq_chng_durn_desc;
				}
				
				if(!dosage_type.equals("A") && !freq_nature.equals("P"))
						order_qty	=	bean.getOrderQty(drugDetails,qty_value,"1",freq_chng_durn_value,"",dosage_type,conv_factor,false);
			
				else
						order_qty=qty_value;
					
				
					if(freq_nature!=null && (freq_nature.equals("O")|| freq_nature.equals("P") ) ){

						taper_yn="N";
						taper_up = "N";
					}
					if( (provide_taper.equals("Y"))  && (no_refill.equals("") || no_refill.equals("0")) )	{
						if(taper_up!=null && taper_up.equals("Y")){
							tapergif="<img src='../../ePH/images/uparrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose' "+alternateDisable+" ></img>";//added for  JD-CRF-0198 [IN:058599]
						}
						else if(taper_yn!=null && taper_yn.equals("Y")){ 
							if(taper_up!=null && (taper_up.equals("N"))){ // added if condition - priya -- modified on 14/04/2010
								tapergif="<img src='../../ePH/images/downarrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
							}
							else{
								tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
							}
						}
						else{
							tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
						}
					}
					else {
						if(!sliding_scale_yn.equals("Y")){
							if(taper_up!=null && taper_up.equals("Y")){
								tapergif="<img src='../../ePH/images/uparrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
							}
							else if(taper_yn!=null && taper_yn.equals("Y")){
								if(taper_up!=null && (taper_up.equals("N"))){ // added if condition - priya  -- modified on 14/04/2010
									tapergif="<img src='../../ePH/images/downarrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
								}
								else{
									tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose' "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
								}
							}
							else{
								
								//AAKH-CRF-0091 

								if(stat_yn.equals("Y") || parent_stat_yn.equals("Y")){
									tapergif="";
								}
								else{
									tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
								}
								
							}
						}
						else{
							tapergif="";
						}
					}
				}
				else{
					tapergif="";
				}
			//	if((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
				if(freq_nature!=null && (freq_nature.equals("O")|| freq_nature.equals("P") ) ){
						tapergif="";
				}
					if(allergy_override!=null && allergy_override.equals("N")){
						/*if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091 and commented for MMS-KH-SCF-0080
							allergy_override_gif="&nbsp;";
						}
						else{ */
						allergy_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";
						//}
					}
					else{
						allergy_override_gif="&nbsp;";
					}
					if(dose_override!=null && dose_override.equals("N")){
						/*if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091 and commented for MMS-KH-SCF-0080
							overdose_override_gif="&nbsp;";
						}
						else{ */
						overdose_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
						//}
					}
					else{
						overdose_override_gif="&nbsp;";
					}
					if(currentrx_override!=null && currentrx_override.equals("N")){
						/*if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091  and commented for MMS-KH-SCF-0080 
							currrx_override_gif="&nbsp;";
						}
						else{ */
							currrx_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";	
						//}
					}
					else{
						currrx_override_gif="&nbsp;";
					}
					if(drugIntraction_override!=null && drugIntraction_override.equals("N")  && !stat_yn.equals("N")){//added for mms-kh-scf-0186
						//if(stat_yn.equals("Y") ){ //if() added for AAKH-CRF-0091 and commented for MMS-KH-SCF-0080
							//drugIntraction_override_gif="&nbsp;";
						//}
						//else{
						drugIntraction_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
						//}
					}
					else{
						drugIntraction_override_gif="&nbsp;";
					}
					if(abuse_override!=null && abuse_override.equals("N")){//added for aakh-crf-0140
						//if(stat_yn.equals("Y") ){ 
							//drugIntraction_override_gif="&nbsp;";
						//}
						//else{
						abuse_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
						//}
					}
					else{
						abuse_override_gif="&nbsp;";
					}
			//	}

					if( Integer.parseInt(adr_count)>0){
						drug_adr_count = bean.getADRCount(patient_id,drug_code);
                        if(drug_adr_count>0){
								adr_gif="<img src='../../ePH/images/ADR.gif' height=20  width=15></img>";
						}
						else{
							adr_gif="&nbsp;";
						}
					}

						if(!(prev_order_code.equals(order_type_code))){

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_type_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

							prev_order_code=order_type_code;
						}
						if(stock_available_yn.equals("N")){
							if(allow_pres_without_stock_yn.equals("N")){
								tapergif="";
								//tooltip	= drug_desc+" - No Stock Available";
							}
						}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block32Bytes, _wl_block32);

							if(j==0){
								if(amend_yn.equals("Y")){
									classValue="AMENDEDDRUGS";
									if(patient_stock_yn!=null && patient_stock_yn.equals("Y")){//added for GHL-CRF-0482
										classValue="PATIENTSTOCKAMEND";
									}
								}
								else{
									classValue="SELECTEDRUGS";
									if(tmp_srl_no==null){
										tmp_srl_no		=	srl_no;
										tmp_drug_code	=	drug_code;
							//added for PE correction By Naveen
										tmp_sliding_scale_yn =sliding_scale_yn;
									}
								}
							}
							else{
								if(deft_mode.equals("tapered"))
									classValue="TAPERDRUGS";
								if(amend_yn.equals("Y")){//added for GHL-CRF-0482
									if(patient_stock_yn!=null && patient_stock_yn.equals("Y")){
										classValue="PATIENTSTOCKAMEND";
									}
								}
								else if(amend_yn.equals("N")){
									classValue="SELECTEDRUGS";
									if(tmp_srl_no==null){
										tmp_srl_no		=	srl_no;
										tmp_drug_code	=	drug_code;
							//added for PE correction By Naveen
										tmp_sliding_scale_yn =sliding_scale_yn;
									}
								}
							}
							if(j==(displayList.size())-1){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block34Bytes, _wl_block34);

							}
							else{
							
							//AAKH-CRF-0091 

								if(stat_yn.equals("Y") || parent_stat_yn.equals("Y")){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block34Bytes, _wl_block34);
 								}
								else{
								

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block34Bytes, _wl_block34);
								}
								
							}	
							if(stock_available_yn.equals("N")){
								if(allow_pres_without_stock_yn.equals("N")){

            _bw.write(_wl_block37Bytes, _wl_block37);
if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_desc_new));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
}//Modified for TFS id:7345 end
									if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block50Bytes, _wl_block50);

									}

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(available_stock));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(available_stock));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

								}
								else{
									classValue="NOSTOCKWARN";
									if(sch_over_yn.equals("N") ){

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block61Bytes, _wl_block61);

										if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {											

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block63Bytes, _wl_block63);

										}

            _bw.write(_wl_block64Bytes, _wl_block64);

									}
									else{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block65Bytes, _wl_block65);

									if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
										

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block63Bytes, _wl_block63);

									}

            _bw.write(_wl_block64Bytes, _wl_block64);

									}

                                    if(drug_adr_count>0){

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(adr_gif));
            _bw.write(_wl_block69Bytes, _wl_block69);
									}
									else{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
									}
									if(ext_checks.equals("Y")){

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block75Bytes, _wl_block75);

										if(ext_checks_overrided.equals("Y")){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block77Bytes, _wl_block77);

										}
										else{

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block78Bytes, _wl_block78);

										}
									}
									else{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block81Bytes, _wl_block81);

									}
									
								//	if(((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))) && allergy_yn!=null && allergy_yn.equals("Y")){
									if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);

									}
									else{

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block89Bytes, _wl_block89);

									}
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
									//if((!drug_db_dosage_check_flag.equals("Y") || !ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){


            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(mono_graph,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(overdose_override_gif));
            _bw.write(_wl_block94Bytes, _wl_block94);

									}
									else{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

									}

									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y") ){

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drugIntraction_override_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);

									}
									else{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

									}//added for aakh-crf-0140 start
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  (abuse_exists.equals("Y") && abuse_action.equals("B")) ){
										
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(abuse_override_gif));
            _bw.write(_wl_block101Bytes, _wl_block101);

																			}
																			else{
										
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block104Bytes, _wl_block104);

																			}//added for aakh-crf-0140 end
//									if(((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))) && current_rx!=null && current_rx.equals("Y")){
									if((ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y") || !drug_db_duptherapy_flag.equals("Y") || !ATC_dup_drug_code.equals("")) && current_rx!=null && current_rx.equals("Y")){ //added ATC_dup_drug_code.equals("")  for the incedent no : 27465 

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);

									}
									else{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block89Bytes, _wl_block89);

									}
								}  
							}
							else{
								if(sch_over_yn.equals("N") ){

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block113Bytes, _wl_block113);

									if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block63Bytes, _wl_block63);

									}

            _bw.write(_wl_block64Bytes, _wl_block64);

									}
									else{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block116Bytes, _wl_block116);

										if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block63Bytes, _wl_block63);

										}

            _bw.write(_wl_block118Bytes, _wl_block118);

										}
										if(drug_adr_count>0){

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(adr_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);
									    }
										else{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block121Bytes, _wl_block121);
	                                    
										}
										if(ext_checks.equals("Y")){

            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block75Bytes, _wl_block75);

											if(ext_checks_overrided.equals("Y")){

            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block124Bytes, _wl_block124);

											}
											else{

            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block125Bytes, _wl_block125);

											}
										}
										else{

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block77Bytes, _wl_block77);

										}
										//if(((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))) && allergy_yn!=null && allergy_yn.equals("Y")){
										if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name_1));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);

										}
										else{

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block134Bytes, _wl_block134);

										}
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") && !stat_yn.equals("Y")){//&& !stat_yn.equals("Y") added for mms-kh-scf-0186
										//if((!drug_db_dosage_check_flag.equals("Y") || !ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
										//stem.err.println("mono_graph  2::"+mono_graph);

            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(mono_graph,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(overdose_override_gif));
            _bw.write(_wl_block137Bytes, _wl_block137);

										}
										else{

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

										}

										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y")  && !stat_yn.equals("Y")){//&& !stat_yn.equals("Y") added for mms-kh-scf-0186

            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drugIntraction_override_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);

										}
										else{

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

										}
										//added for aakh-crf-0140 start
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  (abuse_exists.equals("Y") && abuse_action.equals("B")) ){
											
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(abuse_override_gif));
            _bw.write(_wl_block142Bytes, _wl_block142);
	
											}
											else{
												
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block144Bytes, _wl_block144);

											}//added for aakh-crf-0140 end
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y") && !stat_yn.equals("Y")){ // stat_yn added for AAKH-CRF-
										//if((ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y") ||  !drug_db_duptherapy_flag.equals("Y") || !ATC_dup_drug_code.equals(""))&& current_rx!=null && current_rx.equals("Y") ){// added  !ATC_dup_drug_code.equals("")) for the incedent no : 27465 

            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block86Bytes, _wl_block86);

										}
										else{
											

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
													
										
										}
									}

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(wt_mand_yn));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(ht_mand_yn));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(weight_rec_appl_age_group_check_flag));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(recomm_yn_flag));
            _bw.write(_wl_block160Bytes, _wl_block160);

								/*	if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
										out.println("<script>getChargeDetails_Pad('"+drug_code+"','"+srl_no+"','"+dosage_type+"','"+qty_value+"','"+qty_desc_code+"','"+durn_value+"','"+repeat_value+"');</script>");
									}*/
							//	} //commented for ICN68121 (IN008234)
//System.err.println("==drug_db_interface_yn====="+drug_db_interface_yn+"==ext_prod_id==="+ext_prod_id+"==conf_drug_code=="+conf_drug_code+"==drug_code=="+drug_code+" conf_srl_no"+conf_srl_no+" srl_no="+srl_no+"amend_yn"+amend_yn+" copied_drug_yn="+copied_drug_yn+" ext_checks="+ext_checks+"==="+(drug_db_interface_yn.equals("Y") &&!ext_prod_id.equals("") && ((conf_drug_code.equals(drug_code) && conf_srl_no.equals(srl_no))  || ext_checks.equals("") )));
								datechanged_yn 	=	drugDetails.get("DATECHANGED")==null?"":(String)drugDetails.get("DATECHANGED"); //Added for ML-BRU-SCF-1423 [IN:050857]
								if(drug_db_interface_yn.equals("Y") &&!ext_prod_id.equals("") && ((conf_drug_code.equals(drug_code) && conf_srl_no.equals(srl_no))  || ext_checks.equals("") || datechanged_yn.equals("Y") )){
									//if(curr_code.equals(drug_code)){ //if condition commented for IN25277 --06/01/2011-- priya - to perform External DB check from Copy previous orders with multiple drugs

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block162Bytes, _wl_block162);
									//} //end if(curr_code.equals(drug_code))
								} //ADDED for ICN68121 (IN008234)
								}
							}
						}

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block164Bytes, _wl_block164);
			
					}

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block168Bytes, _wl_block168);

			}// top if
//corrected for PE by Naveen
			//HashMap sliding_scale_dtls = bean.getSlidingScaleDetails(tmp_drug_code);
			if(!copied_drug_yn.equals("Y") ){
				//if(sliding_scale_dtls!=null && sliding_scale_dtls.size()>0){
					//sliding_scale_yn = (String)sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN");
					sliding_scale_yn = tmp_sliding_scale_yn;
				//}
			}
			if(request.getParameter("sliding_scale_yn")!=null)
				sliding_scale_yn =request.getParameter("sliding_scale_yn");

            _bw.write(_wl_block169Bytes, _wl_block169);

		presDetails	=(ArrayList) bean.getpresDetails();

	//mode
		if(presDetails!=null && presDetails.size()>0){
			if(tmp_srl_no!=null ){
				if(recomm_yn_flag){//modified for tapper dose 

            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(tmp_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getParameter("order_idC")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getParameter("modeC")));
            _bw.write(_wl_block171Bytes, _wl_block171);

				}
				else{
					if(!drug_code_sliding.equals("")){
						tmp_drug_code = drug_code_sliding;
						tmp_srl_no = srl_no_sliding;
					}
					/*if(!new_srl_no.equals(""))
							tmp_srl_no =new_srl_no;*///modified for tapper dose

            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(tmp_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deft_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tmp_sliding_scale_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getParameter("order_idC")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getParameter("modeC")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block174Bytes, _wl_block174);

				}
			} 
		}
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block175Bytes, _wl_block175);

		}
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block176Bytes, _wl_block176);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExternalOverrideDrug.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergyDrug.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExceedDosageLimit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateMedication.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExternalOverrideDrug.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergyDrug.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExceedDosageLimit.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateMedication.label", java.lang.String .class,"key"));
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
}
