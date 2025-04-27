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
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptionform_2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionForm_2.jsp", 1742386294641L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--saved on 27th Oct 2005 -->\n<!--saved on 25th Oct 2005 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t\t<head>\n\t\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t\t<script language=\"JavaScript\" src=\"../js/Prescription_1.js\"></script>\n\t\t\t\t <script language=\"JavaScript\" src=\"../js/Prescription_2.js\"></script>\n\t\t\t\t<script language=\"JavaScript\" src=\"../js/PrescriptionTest.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t\t</head>\n\t\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<form name=\"prescription_form\" id=\"prescription_form\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" id=\"Selected_drugs\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"8\"  >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t<tr  id=\'row";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\"  title=\'Tappered\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" colspan=\"\" NOWRAP width=\"64%\" title=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onClick=\"modifyDrug(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'modify\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\"  id=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"><font class=\'HYPERLINK\' size=\'1\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>&nbsp;&nbsp;</td><!-- Modified for IN:073769-->\n\t\t\t\t\t\t\t\t\t\t<td style=\"background-color:red;font-weight:bold;font-size:11;cursor:pointer;height:20\" NOWRAP  colspan=\"3\" title=\"Available Qty:&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><marquee scrollamount=\"3\"><font style=\"font-weight:bold;color:white\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =":&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></marquee></td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<tr  id=\'row";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"6%\"  title=\'Tappered\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onmouseover=\"changeCursor(this);\"><font class=\'HYPERLINK\' size=\'1\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font>&nbsp;&nbsp;</td><!-- Modified for IN:073769-->\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" colspan=\"\"  width=\"3%\"  title=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ><img src=\'../../ePH/images/ADR.gif\' height=20  width=15></img></td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >&nbsp;</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"SHIFTTOTAL\" width=\"6%\" title=\"External Override Drug\" id=\'ext_ddb_override_indc";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\"extDosageCheckFromPad(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'PAD\');\" onmouseover=\"changeCursor1(this);\">\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\t<img name=\'ext_ddb_override_img";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'display:none;\' ></img>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'display:inline;\' ></img>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" width=\"6%\" title=\"External Override Drug\" id=\'ext_ddb_override_indc";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'PAD\');\" onmouseover=\"changeCursor1(this);\"><img name=\'ext_ddb_override_img";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'display:none;\' ></img>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' src=\'../../ePH/images/exceed1.gif\' style=\'display:none;\' ></img>\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"ALLERGY\" width=\"6%\" title=\"Allergy Drug\">&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n<!---Below onClickEvent  is added by sureshkumar T for the ICN No :32596 on 08/05/2012 --->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"ALLERGY\" width=\"6%\" title=\"Allergy Drug\" onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\">&nbsp;</td>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" width=\"6%\" title=\"Allergy Drug\">&nbsp;</td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT\" width=\"6%\" title=\"Exeed Dosage Limit\">&nbsp;</td>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" width=\"6%\" title=\"Exeed Dosage Limit\">&nbsp;</td>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\" width=\"6%\" title=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onclick=\"showInractionDtl(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',\'\',\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\');\">&nbsp;</td><!--showInractionDtl added for MMS-KH-CRF-0029 and order_id , order_line_no added for MMS-KH-CRF-0034.4-->\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" width=\"6%\" title=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"DOSELIMIT1\" style=\"BACKGROUND-COLOR:purple;\" width=\"3%\" title=\'Drug Abuse\' onclick=\"showAbuseDtl(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" width=\"6%\" title=\'Drug Abuse\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"CURRENTRX\" width=\"6%\" title=\"Duplicate Medication\" id=\"currentrx";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">&nbsp;";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"CURRENTRX\" width=\"6%\" title=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\"currentrx";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\textDosageCheckFromPad(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\',\'PADLOAD\');\n\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_yn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"sliding_scale_yn";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" name=\"presBean_id\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" name=\"presBean_name\">\n\t\t\t\t<input type=\"hidden\" name=\"dup_drug_code\" id=\"dup_drug_code\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dup_srl_no\" id=\"dup_srl_no\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dup_drug_desc\" id=\"dup_drug_desc\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" name=\"patient_id\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\"encounter_id\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" name=\"bean_id\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\"bean_name\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" name=\"patient_class\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" name=\"mode\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" name=\"amended_yn\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" name=\"all_amended\">\n\t\t\t\t<!-- code Added for ML-BRU-SCF-0190[32621]  -Start -->\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" name=\"any_amend\">\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" name=\"tmp_patient_class\">\n\t\t\t\t<!-- code Added for ML-BRU-SCF-0190[32621]  -End -->\n\t\t\t</form>\n\t\t</body>\n\t\t<script>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\tgetBLErrorDrugs();\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n//\t\t\t\tvar sliding_scale_yn = document.prescription_form.sliding_scale_yn1.value;\n\t\t\t\tvar sliding_scale_yn_tmp = eval(document.prescription_form.sliding_scale_yn";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =").value;\n\n\t\t\t\tmodifyDrug(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\',sliding_scale_yn_tmp,\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\');\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\tenableRelease();\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t</script>\n\t\t</html>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
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
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------	
28/04/2020  IN:071537        B Haribabu                                         GHL-CRF-0614
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
24/08/2020      IN073769		   B Haribabu                                           PHIS-PH-Alpha - Exceed Dosage Limit Icon not opening in CA place order
02/09/2020  	IN073795                Manickavasagam J                       MMS-KH-CRF-0034.4[73844]
13/05/2021  	TFS id:-16701	     Manickavasagam J                                    RBU-GHL-CRF-0004 
-------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
Connection con			= null;
	try{
		con				= ConnectionManager.getConnection(request);
		String classValue		= ""; 
		String prev_order_code	= "";
		String patient_id		= request.getParameter("patient_id"); 
		String encounter_id		= request.getParameter("encounter_id");
		String patient_class	= request.getParameter("patient_class");
		String mode				= CommonRepository.getCommonKeyValue( "MODE_INSERT" );

		String drug_db_interface_yn      =  request.getParameter("DRUG_DB_INTERFACE_YN")==null?"":request.getParameter("DRUG_DB_INTERFACE_YN");//Modified for IN:071537
		String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id, bean_name,request );
		String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
		bean.setCalExtDBYN("Y");//Added for TFS id:-16701
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;

		String called_from		=	orbean.getCalledFromFunction();
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
        
		String adr_count	    = request.getParameter("adr_count")==null?"":request.getParameter("adr_count");
   		int drug_adr_count = 0;

		String drug_db_duptherapy_check_yn = request.getParameter("DRUG_DB_DUPTHERAPY_YN")==null?"":request.getParameter("DRUG_DB_DUPTHERAPY_YN");//Modified for IN:071537
		String drug_db_allergy_check_yn = request.getParameter("DRUG_DB_ALLERGY_CHECK_YN")==null?"":request.getParameter("DRUG_DB_ALLERGY_CHECK_YN");//Modified for IN:071537
		String conf_drug_code	    = request.getParameter("conf_drug_code")==null?"":request.getParameter("conf_drug_code");
		String conf_srl_no  = request.getParameter("conf_srl_no")==null?"":request.getParameter("conf_srl_no");
		boolean isAmendTaper = false;  //Added for ML-MMOH-CRF-2155.1
		isAmendTaper		= eCommon.Common.CommonBean.isSiteSpecific(con,"PH","JOB_QUEUE_REPORT"); //Added for ML-MMOH-CRF-2155.1		

            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
				String locale = (String) session.getAttribute("LOCALE");
				bean.setLanguageId(locale);

				String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

				ArrayList presDetails	= (ArrayList) bean.getpresDetails();

				String tmp_srl_no		=	null;
				String tmp_drug_code	=	null;
				HashMap drugDetails		=	null;
				String drug_code		=	null;
				String srl_no			=	null;
				String drug_desc		=	null;
				String generic_name		=	null, drug_name="";
				//Below generic_id is added by sureshkumar T for the ICN No :32596 on 08/05/2012
				String generic_id       =   null;
				String qty_value		=	null;
				String qty_desc			=	null;
				String freq_desc		=	null;
				String durn_value		=	null;
				String durn_desc		=	null;
				String tapered_yn		=	null;
				String order_type_code	=	null;
				String order_type_desc	=	null;
				String scheduled_yn		=	null;
				String amended_yn		=	null;
				ArrayList duplicate_dates	=	null;
				String drug_start_date		=	"";
				String drug_end_date		=	"";
				String dup_start_date		=	"";
				String dup_end_date			=	"";
				String dup_drug_code		=	"";
				String dup_srl_no			=	"";
				String dup_drug_desc		=	"";

				String order_id			= (String) orbean.getOrderId();
				String tapergif			= "";
				String alg_reason		= "";
				String dsg_reason	    = "";
				String dup_reason	    = "";
				String tooltip				= "";
				String available_stock		= "";
				String stock_available_yn	= "";
				String allow_pres_without_stock_yn	=	"";
				String stock_uom					=	"";
				String con_reason ="";
				String int_reason ="";
				String ext_prod_id="";
				String drug_db_dosage_check_flag    = "";
				String drug_db_duptherapy_flag		= "";
				String drug_db_contraind_check_flag	= "";
				String drug_db_interact_check_flag	= "";
				String drug_db_allergy_flag			= "";
				String ext_checks					="";
				String ext_checks_overrided			="";
				String sliding_scale_yn				="";
				String recomm_yn					="";
				String current_rx					="";
				String allergy_yn					="";
				String limit_ind					="";
				String allergy_override				="";
				String currentrx_override			="";
				String dose_override				="";
				String currrx_override_gif			="";
				String allergy_override_gif			="";
				String durn_type					="";
				boolean all_amended					=true;
				/* code Added for ML-BRU-SCF-0190[32621] -- Start*/
				boolean any_amended					=false;  
				String order_line_number			= "";				
				HashSet<Integer> amend_order_line_number = new HashSet<Integer>(); 
				String temp_patient_class	= "";
				String taper				= "";				
				String order_line_no		= "";				
				String taper_drug_code		= "";
				boolean contain_taper_drug 	= false;	
			    String interaction_exists=""; 
			    String abuse_exists	=	"", abuse_action="U",abuse_restric_trn="N", abuse_msg_content="", abuse_override ="",abuse_reason="" ;//added for AAKH-CRF-140
				String abuse_override_remarks="";
				HashMap drugDetail			= null;
				HashMap taperDetail			= new HashMap();
				HashSet taper_drug_count	= new HashSet();
				for(int i=0;i<presDetails.size();i++){
					drugDetail			= (HashMap) presDetails.get(i);
					temp_patient_class	=  (String)drugDetail.get("PATIENT_CLASS")==null?"":(String)drugDetail.get("PATIENT_CLASS");
					taper				= (String)drugDetail.get("TAPERED_YN")==null?"":(String)drugDetail.get("TAPERED_YN"); 
					order_line_no		=  (String)drugDetail.get("ORDER_LINE_NUM")==null?"":(String)drugDetail.get("ORDER_LINE_NUM");					
					taper_drug_code		=  (String)drugDetail.get("DRUG_CODE")==null?"":(String)drugDetail.get("DRUG_CODE");
					
					if(	(temp_patient_class.equals("OP") || temp_patient_class.equals("XT"))&& taper.equals("Y") ){
						taperDetail.put(order_line_no,taper_drug_code);	
						contain_taper_drug = true;
					}	
				}
				/* code Added for ML-BRU-SCF-0190[32621] -- End*/

            _bw.write(_wl_block9Bytes, _wl_block9);

                //commented during PE By Naveen added in drug details
					/*ArrayList stock_params	=	bean.validateForStock(patient_class);
					if(stock_params.size()==2) {
						allow_pres_without_stock_yn	=	(String)stock_params.get(1);
					}*/
					if(presDetails.size()>0){
						classValue="SELECTEDRUGS";

            _bw.write(_wl_block10Bytes, _wl_block10);

						for(int i=0;i<presDetails.size();i++){
							classValue	=	"SELECTEDRUGS";
							drugDetails		= (HashMap) presDetails.get(i);
							allow_pres_without_stock_yn	=	CommonBean.checkForNull((String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN"));
							drug_code			= CommonBean.checkForNull((String)drugDetails.get("DRUG_CODE"));
							srl_no				= CommonBean.checkForNull((String)drugDetails.get("SRL_NO"));
							drug_desc			= CommonBean.checkForNull((String)drugDetails.get("CATALOG_DESC"));
							drug_name			= CommonBean.checkForNull((String)drugDetails.get("CATALOG_DESC"));
							generic_name		= CommonBean.checkForNull((String)drugDetails.get("GENERIC_NAME"));
							//Below generic_id is added by sureshkumar T for the ICN No :32596 on 08/05/2012
							generic_id          = CommonBean.checkForNull((String)drugDetails.get("GENERIC_ID"));
							qty_value			= CommonBean.checkForNull((String)drugDetails.get("QTY_VALUE"));
							if(called_from.equals("RENEW_ORDER")) //if block added for Bru-HIMS-CRF-400 [IN:044502]
								order_id		= (String) drugDetails.get("ORDER_ID");

							qty_desc			= CommonBean.checkForNull((String)drugDetails.get("QTY_UNIT"));
							freq_desc			= CommonBean.checkForNull((String)drugDetails.get("FREQ_DESC"));
							freq_desc			= freq_desc.replaceAll("%26","&");
							freq_desc			= freq_desc.replaceAll("%40","@");
							freq_desc			= freq_desc.replaceAll("%20"," "); 

							durn_value			= CommonBean.checkForNull((String)drugDetails.get("DURN_VALUE"));
							durn_desc			= CommonBean.checkForNull((String)drugDetails.get("DURN_DESC"));
							durn_type			= CommonBean.checkForNull((String)drugDetails.get("DURN_TYPE"));
							tapered_yn			= CommonBean.checkForNull((String)drugDetails.get("TAPERED_YN"));
							order_type_code	= CommonBean.checkForNull((String)drugDetails.get("ORDER_TYPE_CODE"));
							order_type_desc	= CommonBean.checkForNull((String)drugDetails.get("ORDER_TYPE_DESC"));
							scheduled_yn		= CommonBean.checkForNull((String) drugDetails.get("SCHEDULED_YN"));
							amended_yn			= (String) drugDetails.get("AMENDED_YN")==null?"":(String) drugDetails.get("AMENDED_YN");
							available_stock	= CommonBean.checkForNull((String) drugDetails.get("AVAILABLE_STOCK"));
							stock_available_yn	= CommonBean.checkForNull((String) drugDetails.get("STOCK_AVAILABLE_YN"));
							stock_uom			= CommonBean.checkForNull((String) drugDetails.get("STOCK_UOM_DESC"));
							alg_reason		= CommonBean.checkForNull((String)drugDetails.get("ALLERGY_REMARKS"));
							dsg_reason		= CommonBean.checkForNull((String)drugDetails.get("DOSE_REMARKS"));
							dup_reason	= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
							sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN");
							
							allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
							current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
							limit_ind = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
							if(dup_reason.equals("")){
								currentrx_override = "N";
								drugDetails.put("CURRENTRX_OVERRIDE","N");
							}
							else{
								currentrx_override = "Y";
								drugDetails.put("CURRENTRX_OVERRIDE","Y");
							}
							if(alg_reason.equals("")){
								allergy_override = "N";
								drugDetails.put("ALLERGY_OVERRIDE","N");
							}
							else{
								allergy_override = "Y";
								drugDetails.put("ALLERGY_OVERRIDE","Y");
							}
							if(dsg_reason.equals("")){
								dose_override = "N";
								drugDetails.put("DOSE_OVERRIDE","N");
							}
							else{
								dose_override = "Y";
								drugDetails.put("DOSE_OVERRIDE","Y");
							}

							if(currentrx_override!=null && currentrx_override.equals("N")){
								currrx_override_gif="<img src='../../ePH/images/exceed1.gif' id=currentrx"+srl_no+"></img>";
							}
							else{
								currrx_override_gif="&nbsp;";
							}
							if(allergy_override!=null && allergy_override.equals("N")){
								allergy_override_gif="<img src='../../ePH/images/exceed1.gif' id=allergy"+srl_no+"></img>";
							}
							else{
								allergy_override_gif="&nbsp;";
							}

							recomm_yn	= (String)drugDetails.get("RECOMM_YN");

							ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
							con_reason = (String) drugDetails.get("CONTRAIND_OVERRIDE_REASON") == null?"": (String) drugDetails.get("CONTRAIND_OVERRIDE_REASON");
							int_reason = (String) drugDetails.get("INTERACTION_OVERRIDE_REASON") == null?"": (String) drugDetails.get("INTERACTION_OVERRIDE_REASON");
							//Added for IN:073485 
							if(int_reason.equals(""))
								int_reason = (String) drugDetails.get("LAB_INTERACTION_REMARKS") == null?"": (String) drugDetails.get("LAB_INTERACTION_REMARKS");
							if(int_reason.equals(""))
								int_reason = (String) drugDetails.get("FOOD_INTERACTION_REMARKS") == null?"": (String) drugDetails.get("FOOD_INTERACTION_REMARKS");
						        //Added for IN:073485 
							if(int_reason.equals(""))//Added for MMS-DM-CRF-0229
								int_reason = (String) drugDetails.get("DISEASE_INTERACTION_REMARKS") == null?"": (String) drugDetails.get("DISEASE_INTERACTION_REMARKS");
							interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");
							abuse_exists	= (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
							 abuse_restric_trn=(String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
							  abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"U": (String) drugDetails.get("ABUSE_ACTION");
													String ext_beanid = "@ExternalProductLinkBean";
							String ext_beanname = "ePH.ExternalProductLinkBean";
							ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
							
							drug_db_dosage_check_flag      =	 (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");		
							drug_db_contraind_check_flag	= (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");		
							drug_db_interact_check_flag	=  (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");		
							drug_db_duptherapy_flag		=  (String)drugDetails.get("DRUG_DB_DUPTHERAPY_YN")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_YN");	//Modified for IN:071537	
							drug_db_allergy_flag		=  (String)drugDetails.get("DRUG_DB_ALLERGY_CHECK_YN")==null?"":(String)drugDetails.get("DRUG_DB_ALLERGY_CHECK_YN");//Modified for IN:071537	
							
							order_line_number		=  (String)drugDetails.get("ORDER_LINE_NUM")==null?"":(String)drugDetails.get("ORDER_LINE_NUM");// code Added for ML-BRU-SCF-0190[32621]
							if(temp_patient_class.equals("OP")||temp_patient_class.equals("XT")|| temp_patient_class.equals("EM"))
								bean.setDispLocnCatg("O");	// code Added for ML-BRU-SCF-0190[32621] -- temp_patient_class
							else
								bean.setDispLocnCatg("I");	// code Added for ML-BRU-SCF-0190[32621] -- temp_patient_class
							
							/* Commented for Perfomence 
							if(!drugDetails.get("EXTERNAL_PRODUCT_ID").equals("")){
								if(drug_db_allergy_check_yn.equals("Y") ){
									ArrayList ex_prod_ids =new ArrayList();
									ex_prod_ids.add(ext_prod_id);
									ext_beanObj.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
									HashMap drug_alergies =(HashMap)ext_beanObj.getDrugAlergies();
									if(drug_alergies.containsKey(ext_prod_id)){
										drug_db_allergy_flag="Y";
										drugDetails.put("DRUG_DB_ALLERGY_FLAG","Y");
									}	
								}
								if(drug_db_duptherapy_check_yn !=null &&  drug_db_duptherapy_check_yn.equals("Y")){ 
								   String dup_drug_det			= ext_beanObj.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
								   if(dup_drug_det!=null && !dup_drug_det.equals(""))
										drug_db_duptherapy_flag="Y";
										drugDetails.put("DRUG_DB_DUPTHERAPY_FLAG","Y");
								}
							}*/
							if(drugDetails.get("EXTERNAL_PRODUCT_ID")!=null && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals("")){
								HashMap extDBCheckResults = null;
								if(drug_db_allergy_check_yn.equals("Y") ||  drug_db_duptherapy_check_yn.equals("Y")){
									extDBCheckResults = ext_beanObj.getExternalDBCheckResult( ext_prod_id, srl_no);
									if(extDBCheckResults!=null && drug_db_allergy_check_yn.equals("Y")){
										if(ext_beanObj!=null && ext_beanObj.getProdID()!=null && (ext_beanObj.getProdID()).equals("CIMS")){ // for CIMS)
											String allergy_alert			= (String)extDBCheckResults.get("ALLERGYCHECK");
											if(allergy_alert!=null && !allergy_alert.equals(""))
												drug_db_allergy_flag="Y";
										} 
										else{
											HashMap drug_alergies =(HashMap)extDBCheckResults.get("ALLERGYCHECK");
											if(drug_alergies!=null && drug_alergies.containsKey(ext_prod_id))
												drug_db_allergy_flag="Y";
										}
										drugDetails.put("DRUG_DB_ALLERGY_CHECK_YN",drug_db_allergy_flag);//Modified for IN:071537
									}	
									if(extDBCheckResults!=null && drug_db_duptherapy_check_yn !=null &&  drug_db_duptherapy_check_yn.equals("Y")){ 
										String dup_drug_det			= (String)extDBCheckResults.get("DUPCHECK");
										if(dup_drug_det!=null && !dup_drug_det.equals(""))
											drug_db_duptherapy_flag="Y";
										drugDetails.put("DRUG_DB_DUPTHERAPY_YN","Y");//Modified for IN:071537
									}
								}
							}
							if(drug_db_dosage_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){
								ext_checks="Y";
							}
							else{
								if(drug_db_dosage_check_flag.equals("") && drug_db_contraind_check_flag.equals("") && drug_db_interact_check_flag.equals("") && drug_db_duptherapy_flag.equals("") && drug_db_allergy_flag.equals(""))
									ext_checks="";
								else
									ext_checks="N";
							}
							if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) && (drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) && (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) && (drug_db_interact_check_flag.equals("Y") && (int_reason.equals(""))) &&  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){//Modified for IN:071537
								ext_checks_overrided = "N";
							}
							else
								ext_checks_overrided = "Y";

							if(drug_db_duptherapy_flag.equals("Y")){
								current_rx = "N";
								drugDetails.put("CURRENT_RX","N");
							}
							else if(!(dup_reason.equals(""))){
								current_rx = "Y";
								drugDetails.put("CURRENT_RX","Y");
							}

							if(drug_db_allergy_flag.equals("Y")){
								allergy_yn = "N";
								drugDetails.put("ALLERGY_YN","N");
							}
							else if(!(alg_reason.equals(""))){
								allergy_yn = "Y";
								drugDetails.put("ALLERGY_YN","Y");
							}

							if(drug_db_dosage_check_flag.equals("Y")){
								limit_ind = "Y";
								drugDetails.put("LIMIT_IND","Y");
								
							}
							else if(!(dsg_reason.equals(""))){
								limit_ind = "N";
								drugDetails.put("LIMIT_IND","N");
							}
							if(drug_db_interact_check_flag.equals("Y")){
								interaction_exists = "N";
								drugDetails.put("INTERACTION_EXISTS","N");
							}
							else if(!(int_reason.equals(""))){
								interaction_exists = "Y";
								drugDetails.put("INTERACTION_EXISTS","Y");
							}
							/* code Added for ML-BRU-SCF-0190[32621]  -Start */
							if(amended_yn.equals("Y"))  {
								
								
							System.err.println("contain_taper_drug    "+contain_taper_drug);
								if( temp_patient_class.equals("OP") && contain_taper_drug == true && !isAmendTaper ){ //Modified for ML-MMOH-CRF-2155.1
									if( taperDetail.containsKey(order_line_number) ){
										taper_drug_count.add(taperDetail.get(order_line_number) );
										System.err.println("taper_drug_count "+taper_drug_count);
										taperDetail.remove(order_line_number);										
									 }										
										boolean flag = false;	
										Iterator itr = taper_drug_count.iterator();
										while(itr.hasNext()){
											flag=taperDetail.containsValue(itr.next());
											System.err.println("flag   "+flag);
											if(flag == true)
												break;
										}										
										if(flag == false)
											any_amended	= true;	
										else 
											any_amended	= false;	
								}
								else 								
									any_amended	= true; 			
								//Added for ML-MMOH-CRF-2155.1 - start
								if(temp_patient_class.equals("OP") && contain_taper_drug == true && isAmendTaper){
									any_amended	= true; 						
								}
								//Added for ML-MMOH-CRF-2155.1 - end
								amend_order_line_number.add(new Integer(Integer.parseInt(order_line_number)) ) ;
								bean.setAmendOrderLineNumber(amend_order_line_number);								
											
							}
							/* code Added for ML-BRU-SCF-0190[32621]  -End */

							if((!amended_yn.equals("Y")) && tmp_srl_no==null) {
								tmp_srl_no		=	srl_no;
								tmp_drug_code	=	drug_code;				
							}
							else if(amended_yn!=null && amended_yn.equals("Y")){
								classValue	= "AMENDEDDRUGS";	
							}

							if((!amended_yn.equals("Y")) && all_amended) {
								all_amended		=	false;
							}
						
							String dispDesc			= "";
							if(drug_desc!=null && drug_desc.length()>11){
								dispDesc	=	drug_desc.substring(0,11)+"...";
							}
							else {
								dispDesc	=	drug_desc;
							}

							if( tapered_yn!=null && tapered_yn.equals("Y") ){				
								tapergif="<img src='../../ePH/images/taper.gif' title='Tapper Dose' ></img>";					
							}
							else{
								tapergif="";
							} 

							if(!(prev_order_code.equals(order_type_code))){

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_type_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

								prev_order_code=order_type_code;
							}
							
							tooltip	= drug_desc+"/"+generic_name+" - "+qty_value+" "+qty_desc+" "+freq_desc+" for "+durn_value+" "+durn_desc;

							if(stock_available_yn.equals("N")){
								if(allow_pres_without_stock_yn.equals("N")){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(available_stock));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(available_stock));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block27Bytes, _wl_block27);
			
								}
							} 
							else {				

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tapergif));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_code));
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block32Bytes, _wl_block32);

									//if(drug_db_interface_yn.equals("Y") &&  (!ext_prod_id.equals(""))){
                                if( Integer.parseInt(adr_count)>0){
									drug_adr_count = bean.getADRCount(patient_id,drug_code);
									if(drug_adr_count>0){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
									}
									else{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

									}
								}	

								if(ext_checks.equals("Y")){
									if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block39Bytes, _wl_block39);

										if(ext_checks_overrided.equals("Y")){

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

										}
										else{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);

										}
									}
									else { 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block46Bytes, _wl_block46);

									}
								}
								else{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block48Bytes, _wl_block48);

								}
							//		else{
								//	if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !(alg_reason.equals("") || ext_checks.equals("Y"))) {	
									
									if(allergy_yn != null && allergy_yn.equals("Y") && (alg_reason == null || alg_reason.equals(""))){

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block50Bytes, _wl_block50);
										
									} 
									else if(allergy_yn != null && allergy_yn.equals("Y") && !drug_db_allergy_flag.equals("Y")){

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_name,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
									}
									else { 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);

									}				
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !(dsg_reason.equals("") || ext_checks.equals("Y"))) {	

            _bw.write(_wl_block54Bytes, _wl_block54);
 
									} 
									else { 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);

									}
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !int_reason.equals("") && interaction_exists.equals("Y")) {	

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_number));
            _bw.write(_wl_block59Bytes, _wl_block59);
 
									} 
									else { 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

									}if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && abuse_exists.equals("Y")&& abuse_action.equals("B")) {	//added for AAKH-CRF-0140

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_number));
            _bw.write(_wl_block59Bytes, _wl_block59);
 
									} 
									else { 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);

									}
									//if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !(dup_reason.equals("") || ext_checks.equals("Y"))) {
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals(""))||drug_db_duptherapy_check_yn.equals("N") ) {//Added for Duplicate button
										if(current_rx != null && current_rx.equals("Y") &&  dup_reason.equals("")  && !drug_db_duptherapy_flag.equals("Y")){

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block50Bytes, _wl_block50);
  
										}
										else if(current_rx != null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y") && !dup_reason.equals("")){

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
										}
										else { 

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);

										}	
									}
									else { 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);

									}	

            _bw.write(_wl_block70Bytes, _wl_block70);

							}		
							if(drugDetails!=null && drugDetails.get("AMENDED_YN")==null) {
								ArrayList renew_dates	=	(bean.getRenewDates(durn_value,order_id,drug_code));
								if(renew_dates.size()==2) {
									drug_start_date	=	(String)renew_dates.get(0);
									drug_end_date	=	(String)renew_dates.get(1);
								}
							}
							//Start Duplicate- check
							duplicate_dates		=	presBean.getDuplicateDates(patient_id,drug_code,drug_start_date);
							if(duplicate_dates.size()==2) {
								dup_start_date	=	(String)duplicate_dates.get(0);
								dup_end_date	=	(String)duplicate_dates.get(1);
							}
						// End Duplicate Dates
							if(presBean.duplicateRecord(dup_start_date,dup_end_date,drug_start_date,drug_end_date)) {
								dup_drug_code	=	drug_code;
								dup_srl_no		=	srl_no;
								dup_drug_desc	=	drug_desc;
							 }

							if(called_from.equals("RENEW_ORDER")) {
								//bean.setOldOrder(drug_code,order_id+","+presBean.getLineNo(order_id,drug_code)); //Commneted for Bru-HIMS-CRF-400 [IN:044502]
								bean.setOldOrder(drug_code, order_id+","+order_line_number); //Added for Bru-HIMS-CRF-400 [IN:044502]
							}
							//if(drug_db_interface_yn.equals("Y") &&(!ext_prod_id.equals("")) ){
							if(drug_db_interface_yn.equals("Y") &&!ext_prod_id.equals("") && ((conf_drug_code.equals(drug_code) && conf_srl_no.equals(srl_no))  || ext_checks.equals("") )){

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block72Bytes, _wl_block72);

						}

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);

					}

            _bw.write(_wl_block77Bytes, _wl_block77);

				}

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(dup_drug_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(dup_srl_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(dup_drug_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(amended_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(all_amended));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(any_amended));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(temp_patient_class));
            _bw.write(_wl_block94Bytes, _wl_block94);
 
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block95Bytes, _wl_block95);

			}
			 if( tmp_srl_no!=null ) {

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tmp_drug_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);

			}
			if(all_amended) { 

            _bw.write(_wl_block100Bytes, _wl_block100);

			}	

            _bw.write(_wl_block101Bytes, _wl_block101);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
 		putObjectInBean(presBean_id,presBean,request);
	} 
	catch(Exception e) {
		e.printStackTrace();
	}

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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateMedication.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateMedication.label", java.lang.String .class,"key"));
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
}
