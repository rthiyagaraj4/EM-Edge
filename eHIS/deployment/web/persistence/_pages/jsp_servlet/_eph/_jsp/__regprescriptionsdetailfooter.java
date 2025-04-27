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
import java.text.DecimalFormat;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __regprescriptionsdetailfooter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/RegPrescriptionsDetailFooter.jsp", 1731988432066L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="<!-- java.sql.Connection,webbeans.eCommon.ConnectionManager added for ML-BRU-0469 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n<!-- \t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PhMessages.js\"></script>\n -->\t\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/RegPrescriptions.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  topmargin=\"0\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<form name=\"regprescriptionsdetailfooter\" id=\"regprescriptionsdetailfooter\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' align=\"center\" border=\"1\" id=\"regprescriptionsdetailfootertable\" name=\"regprescriptionsdetailfootertable\" >\n\t\t\t\t<tr>\n\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small\"  colspan=\"7\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td><!-- colspan=\"7\" changed from colspan=\"6\" for ML-BRU-CRF-0469 -->\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> \n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n                         <!-- Added for ML-BRU-CRF-0469 start -->\n                         ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n                        <td class= \"COLUMNHEADER\" style=\"font-size:xx-small\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td> \n                        ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<!-- Added for ML-BRU-CRF-0469 end -->\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" style=\"font-size:xx-small;\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<!-- display:inline changed from display:none for Bru-HIMS-CRF-352 [IN:038516]  -->\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td style=\"font-size:xx-small\" class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' width=\"57%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="      \n\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\"></img>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t<img style=\"cursor:pointer;\" src=\"../../ePH/images/camera.gif\" height=20  width=20 onClick=\"showImage(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'   title=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'></img>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\" >\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/uparrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\" valign=\"center\" title=\'Taper Dose\' style=\"cursor:pointer\"height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/downarrow.gif\" onclick=\"showTaperDetails(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" valign=\"center\" title=\'Taper Dose\' style=\"cursor:pointer\" height=\'20\' width=\'20\'></img>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="                           <label id=\"route_desc\" style=\'color:";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =";background-color:";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =")</label> <!-- added  for CRF RUT-CRF-0034.1 [IN:037389] -->\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"   class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' width=\"33%\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" , ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" ,";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n                                 <!-- added for ML-BRU-CRF-0469 start-->\n                                   ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n                                    <td style=\"font-size:xx-small\"  id=\'gross_amount_str_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' width=\"9%\">&nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n                                    ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n                                    <!-- added for ML-BRU-CRF-0469 end-->\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  id=\'groos_pat_payable_str_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\t\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  id=\'gross_charge_amount_str_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'  class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'  >&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"override_allowed_yn_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"  value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"excl_incl_ind_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"        value=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"approval_reqd_yn_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"     value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_charge_amount_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"gross_charge_amount_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"groos_pat_payable_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"groos_pat_payable_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"   value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t\t\t\t\t<!-- added for ML-BUR-CRF-0469 start-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gross_amount_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"gross_amount_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"        value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t<!-- added for ML-BUR-CRF-0469 end -->\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  class=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' width=\"9%\"><a href=\"javascript:callIncludeExclude(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\',\';\',\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\');\" id=\"include_exclude\"  style=\"font-size:9;\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="?</a></td>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  class=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' width=\"9%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  id=\'gross_charge_amount_str_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'  >&nbsp;</td>\n\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  id=\'groos_pat_payable_str_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' width=\"9%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td style=\"font-size:xx-small\"  class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t <td class=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' width=\"0%\" style=\"background:#33CC00\"><!-- display:inline changed from display:none for Bru-HIMS-CRF-352 [IN:038516] -->\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"registeredPres";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"registeredPres";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" value=\"E\" disabled title=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' checked> \n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"prescriptionSelect";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"prescriptionSelect";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" value=\"E\" style=\"display:none\">\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' width=\"0%\" style=\"display\"><!-- display:inline changed from display:none for Bru-HIMS-CRF-352 [IN:038516] Ends -->\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"prescriptionSelect";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" value=\"E\" ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" onClick=\"storePrescriptionDetails(\'ONCLICK\')\">\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\t\t\t\t\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tstorePrescriptionDetails( \'ONLOAD\',\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\');\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t</table>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t<input type=\"hidden\" name=\"total_no_of_pres\" id=\"total_no_of_pres\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\t\t\t<input type=\"hidden\" name=\"calledfrom\" id=\"calledfrom\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"> \n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" >\n\t\t\t<input type=\"hidden\" name=\"displayGrossAmtYn\" id=\"displayGrossAmtYn\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" ><!-- added for ML-BRU-CRF-0469 -->\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t<input type=\"hidden\" name=\"bl_encounter_id\" id=\"bl_encounter_id\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"bl_patient_class\" id=\"bl_patient_class\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"bl_sysdate\" id=\"bl_sysdate\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"tot_gross_charge_amount\" id=\"tot_gross_charge_amount\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tot_groos_pat_payable\" id=\"tot_groos_pat_payable\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t\t<!--  added for ML-BRU-CRF-0469 start -->\n\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t<input type=\"hidden\" name=\"tot_gross_amount\" id=\"tot_gross_amount\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t<!--  added for ML-BRU-CRF-0469 end -->\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t</form>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t<script>\n\t\t\t\tparent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href=\'../../ePH/jsp/RegPrescriptionsButtonsFooter.jsp?enableDisable=\'+\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'+\"&total_payable=\"+\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'+\"&patient_payable=\"+\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'+\"&total_gross_amount=\"+\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\';<!--Removed displayData for//Added for ML-BRU-SCF-1199 [IN:045703]-end--><!-- added for ML-BRU-CRF-0469 +\"&total_gross_amount=\"+\'tot_gross_amount_str\'-->\n\t\t\t</script>\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'+\"&patient_payable=\"+\'\'<!--Removed displayData for //Added for ML-BRU-SCF-1199 [IN:045703]-end--><!-- added for ML-BRU-CRF-0469 +\"&total_gross_amount=\"+\'tot_gross_amount_str\'-->\n\t\t\t</script>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
			request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
			response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
			response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try{
	//	String displayData		=	request.getParameter("displayData");//Commented for //Added for ML-BRU-SCF-1199 [IN:045703]-end
		String calledfrom		=	request.getParameter("calledfrom"); 
		String encounter_id		=	request.getParameter("encounter_id");
		String enableDisable1	=	request.getParameter("enableDisable");
		String  patient_id		=	"";
		calledfrom=CommonBean.checkForNull(calledfrom);
		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		String drug_db_interface_yn			=  param_bean.getDrugDBInterface_yn(facility_id); 
		param_bean.clear();
		param_bean.setLanguageId(locale);
		/*displayData = displayData.trim(); //Commented for //Added for ML-BRU-SCF-1199 [IN:045703]-end
		StringTokenizer st = new StringTokenizer(displayData,"~");
		st.nextToken();
		st.nextToken();*/
		String drugid="";
		String qtyunit="";
		String drugname = "",qtyvalue="",qtyunitdesc="",freqdesc="",durnvalue="",durndesc="",order_line_num="",order_id="",order_status="",ext_prod_id="",bms_qty="";

		String	disp_bean_id				=	"DispMedicationAllStages" ;
		String	disp_bean_name			    =	"ePH.DispMedicationAllStages";	
		
		DispMedicationAllStages disp_bean = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name,request);
		disp_bean.setLanguageId(locale);

		String	bean_id						=	"RegPrescriptionsBean" ;
		String	bean_name					=	"ePH.RegPrescriptionsBean";
		String enableDisable				= "";
		String checkedUnchecked				= "";
		RegPrescriptionsBean bean			= (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
		//bean.setLanguageId(locale);

		String Image_bean_id				= "@DrugTradeImageBean";
		String Image_bean_name				= "ePH.DrugTradeImageBean";
		DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );

		String  billing_interface_yn		=	request.getParameter("billing_interface_yn");//disp_bean.checkforbillinginterface();
		String  dischargeIND_yn             =   request.getParameter("dischargeIND_yn");
		String patient_class                =   "";
		String width						=	"100%";
		String disp_locn_code               =   bean.getDispLocnCode();    
		String sys_date						=	bean.getTodaysDate();
		float tot_gross_charge_amount		=   0;
		float tot_groos_pat_payable			=   0; 
		float tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
		String tot_gross_charge_amount_str	=  "";
		String tot_groos_pat_payable_str	=  "";
		String tot_gross_amount_str         =	"";	// added for ML-BRU-CRF-0469
		String decimalFormatString			=  "";
		String gross_charge_amount_str		=  "";
		String groos_pat_payable_str		=  "";
		String gross_amount_str             =   ""; //added for ML-BRU-CRF-0469
		String image_path					=  "";
		String trade_code					=  "";
		String in_formulary_yn				=  "N";
		String drug_yn				        =  "";
		String route_desc  =  "", route_color="",backgrndColor="", fntColor="" ;// added for CRF RUT-CRF-0034.1[IN:037389]
		//String dischargeIND				=  "N";
		HashMap bl_override_det             =  new HashMap();
		HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
		ArrayList result = null; //Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end
		int count = 0;
		// Added for ML-BRU-CRF-0469 [IN:065426] - start
		Connection con=null;
		boolean displayGrossAmtYn           = false;
		try{
			con = ConnectionManager.getConnection(request);
			displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
		}
		catch(Exception e){
			e.printStackTrace();
			displayGrossAmtYn = false;
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}  // Added for ML-BRU-CRF-0469 [IN:065426] - End
		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(width));
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

					if(billing_interface_yn.equals("Y")){

            _bw.write(_wl_block15Bytes, _wl_block15);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 }
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 
					}

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

				result = new ArrayList(bean.getRegisteredOrders());//added for //Added for ML-BRU-SCF-1199 [IN:045703]-end--start
				if(result.size()>0) //Commented for  [IN:047547] //changed for [IN:047768]
          			result.remove(result.size()-1); //Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end //commented for  [IN:047547]
				Hashtable prescriptionDetails = bean.getPrescriptionDetails();
				patient_id= bean.getPatientID();
				
				if (prescriptionDetails.size()<1){
					enableDisable = "";
					checkedUnchecked = "checked";
				}

				int row_no = 1;
				String classval="", tapered_yn="", taper_order_id="", order_id_selected="",stock_uom="",base_uom = ""; // stock_uom,base_uom Added for ML-BRU-SCF-1798
				Enumeration v = null;
				int i=0;
				int adr_count =0;
				float base_to_disp_uom_equl = 0f;//ML-BRU-SCF-1798
				for(int res=0;res<result.size();res=res+19){ //changed from 19 - 20 for  [IN:047547]
					if(row_no % 2 == 0 )
						classval	=	"QRYEVEN";
					else
						classval	=	"QRYODD";
						drugid		=  (String)result.get(res);
					
					drugid		=  drugid.trim();
					drugname	=  (String)result.get(res+1);
					qtyvalue	= (String) result.get(res+2);
					qtyunit		= (String) result.get(res+3);	
					qtyunitdesc = (String) result.get(res+4);		
					freqdesc	=  (String)result.get(res+5);	
					durnvalue	=  (String)result.get(res+6);	
					durndesc	=  (String)result.get(res+7);		
					order_line_num	= (String)result.get(res+8);
					order_id		= (String)result.get(res+9);
					order_status	=(String) result.get(res+10);
					ext_prod_id	= (String)result.get(res+11);
					bms_qty	= (String)result.get(res+12);
					in_formulary_yn	=(String) result.get(res+13);
					drug_yn	= (String)result.get(res+14);
					tapered_yn	= (String)result.get(res+15);
					taper_order_id	=(String) result.get(res+16);
					route_desc	= (String)result.get(res+17);
					route_color	= (String)result.get(res+18);//Modified for change in Register order data retrival--end

//added for ML-BRU-SCF-1798 - start
					 stock_uom = bean.getStockUom(order_id,order_line_num,(String)result.get(res));
					 base_uom = bean.getStoreDfltBaseUOM(disp_locn_code,(String)result.get(res));
				
					if(base_uom==null)
					 base_uom = "";
					if(!base_uom.equals("")&& !base_uom.equals(stock_uom)){
						base_to_disp_uom_equl    =	bean.getEqulValue( (String)result.get(res), base_uom, stock_uom);
						bms_qty = Math.round(Float.parseFloat(bms_qty)* base_to_disp_uom_equl)+"";
					}
//added for ML-BRU-SCF-1798 - end
					fntColor= "";
					backgrndColor= "";
					if(route_color!= null && !route_color.equals("")){
						if(route_color.length()==12){
							fntColor= route_color.substring(0, 6);
							backgrndColor= route_color.substring(6, 12);
						}
					}// added for CRF RUT-CRF-0034.1[IN:037389]-end
					trade_code				= (String)bean.gettrade_codes(order_id,order_line_num,drugid);     
					image_path				=  drug_trade_bean.getImagePath(drugid,trade_code);
					row_no ++;
					adr_count = disp_bean.getADRCount(patient_id,drugid);
					v=prescriptionDetails.keys();
					while (v.hasMoreElements() ) {
						order_id_selected = (String)v.nextElement();
						if ((order_id.trim()).equals(order_id_selected.trim())){
							ArrayList arrListOrderLine = (ArrayList)prescriptionDetails.get(order_id_selected.trim());
							if (arrListOrderLine.size()>0){

								if ((((String)arrListOrderLine.get(0)).trim()).equals("*ALL")){					
									enableDisable = "";
									checkedUnchecked = "checked";
									break;
								}
								else{
								
									for (int j=0;j<arrListOrderLine.size() ; j++){
										if (((String)arrListOrderLine.get(j)).equals(order_line_num)){
											checkedUnchecked = "checked";
											enableDisable = "";
											break;
										}else{
											checkedUnchecked = "";
										}
									}
								}
							}
							break;
						}
						else{
							checkedUnchecked = "checked";
							//enableDisable = "disabled";
						}
					}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drugname));
            _bw.write(_wl_block2Bytes, _wl_block2);

						if(ext_prod_id!=null && !ext_prod_id.equals("N")&& drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(drugname,"UTF-8")));
            _bw.write(_wl_block27Bytes, _wl_block27);

						}
						if ((image_path!=null)&& !(image_path.equals(""))){

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drugid));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block29Bytes, _wl_block29);

						}
	   
						if(adr_count>0){   

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 
						}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(drugid));
            _bw.write(_wl_block33Bytes, _wl_block33);

							//int count = disp_bean.chkfortapering(order_id,drugid, order_line_num);
							taperValues=disp_bean.chkfortapering(order_id,drugid, order_line_num, patient_id);	//Modified for RUT-CRF-0088 [IN036978] 		
							count =Integer.parseInt(taperValues.get("COUNT").toString());  // Modified for RUT-CRF-0088 [IN036978]
							if(count>1){
								String taper = disp_bean.getTapervalue();
								if(taper.equals("UP")){

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drugid));
            _bw.write(_wl_block35Bytes, _wl_block35);

								}
								else if(taper.equals("DOWN")){

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drugid));
            _bw.write(_wl_block37Bytes, _wl_block37);
	
								}
							}

            _bw.write(_wl_block2Bytes, _wl_block2);
							if(route_desc!=null && route_desc.trim().length()>0)//Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end -start
                        	  {

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
							  }//Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end--end
							if(drug_yn.equals("Y")){

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(qtyvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qtyunitdesc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(freqdesc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(durnvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(durndesc));
            _bw.write(_wl_block2Bytes, _wl_block2);

							}
							else{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(qtyvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qtyunitdesc));
            _bw.write(_wl_block2Bytes, _wl_block2);

							}

            _bw.write(_wl_block47Bytes, _wl_block47);

							if(billing_interface_yn.equals("Y") ){
								if(in_formulary_yn.equals("Y")&&disp_bean.getBillableItemYN (drugid).equals("Y") &&( !tapered_yn.equals("Y") || taper_order_id.equals("N"))){ // && --> || for tappered condition for  ML-BRU-SCF-0368 [IN:034748]
									float gross_charge_amount =  0;
									float groos_pat_payable   =  0;
									 float gross_amount       = 0;//Added for ML-BRU-CRF-0469
									gross_charge_amount_str	  =  "";
									groos_pat_payable_str	  =  "";
									gross_amount_str          =  "";//added for ML-BRU-CRF-0469
									StringBuffer gross_charge_display_str  = new StringBuffer();
									StringBuffer pat_charge_display_str    = new StringBuffer(); 
									StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
									bl_override_det =new HashMap();
									bl_override_det = (HashMap)bean.getbl_override_det(order_id,order_line_num,drugid);

									if(!encounter_id.equals("")){
										patient_class                  =   bean.getEncounterPatientClass(encounter_id,(String)bl_override_det.get("ORDERING_FACILITY_ID"), patient_id); // patient_id   added for [IN:035667] 
									}
									else{
										patient_class                  =  "R";
									}

									HashMap chareg_det = bean.callItemChargeDtls(patient_id ,encounter_id,patient_class,drugid,Integer.parseInt(bms_qty),";",sys_date,disp_locn_code,(String)bl_override_det.get("BL_INCL_EXCL_OVERRIDE_VALUE"),(String)bl_override_det.get("BL_INCL_EXCL_OVERRIDE_REASON"),order_id,order_line_num,"R",(String)bl_override_det.get("ORDERING_FACILITY_ID"),dischargeIND_yn); //order_id and order_line_num added for MMS-DM-CRF-0126

									if(chareg_det.get("error_msg").equals("")){

										decimalFormatString         =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
										DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);

										/*if(!chareg_det.get("grosschargeamt").equals("null")){
											 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
										}*/ //commented for ML-BRU-SCF-0368 [IN:034748]
										if(!chareg_det.get("patnetamt").equals("null")){
											 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
										}
										if(!chareg_det.get("netchargeamt").equals("null")){
											//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
											gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); // added ML-BRU-SCF-0368 [IN:034748]
										}
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										if(!chareg_det.get("grosschargeamt").equals("null")){
											gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
										    }
										}
										//added for ML-BRU-CRF-0469 end
										gross_charge_amount_str = dfTest.format(gross_charge_amount);
										groos_pat_payable_str   = dfTest.format(groos_pat_payable);
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										gross_amount_str        = dfTest.format(gross_amount);		
										}
										//added for ML-BRU-CRF-0469 end
										gross_charge_display_str.append("<label style='font-size:9;color:black'>").append(groos_pat_payable_str).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9;color:black'>").append(gross_charge_amount_str).append("</label>");
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										      gross_disply_str.append("<label style='font-size:9;color:black'>").append(gross_amount_str).append("</label>");
										}
										//added for ML-BRU-CRF-0469 end
										tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
										tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
												//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										tot_gross_amount        = tot_gross_amount+gross_amount;
												}
												//added for ML-BRU-CRF-0469 end
									}
									else{
										gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");								
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){   
											gross_disply_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");//added for ML-BRU-SCF-0469
										}
										//added for ML-BRU-CRF-0469 end
										}

            _bw.write(_wl_block48Bytes, _wl_block48);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(gross_disply_str.toString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
} 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pat_charge_display_str.toString()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(gross_charge_display_str.toString()));
            _bw.write(_wl_block57Bytes, _wl_block57);

								if(chareg_det.get("error_msg").equals("")){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(gross_charge_amount+""));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(groos_pat_payable+""));
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(displayGrossAmtYn){ 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(gross_amount+""));
            _bw.write(_wl_block83Bytes, _wl_block83);
} 
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drugid));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

								}
								else{

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
	
								}
							}
							else{

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);

							} 
						}
						if(order_status.equals("RG")){

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);

						}
						else{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(enableDisable));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(checkedUnchecked));
            _bw.write(_wl_block104Bytes, _wl_block104);
	
							//}
							checkedUnchecked="";
							enableDisable="";

            _bw.write(_wl_block47Bytes, _wl_block47);

						}

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block107Bytes, _wl_block107);
 
					if(i==0){

            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
  
					}

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
  
					i++;
				}

            _bw.write(_wl_block112Bytes, _wl_block112);
 
			putObjectInBean(bean_id,bean,request); 
			putObjectInBean(param_bean_id,param_bean,request);

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(calledfrom));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(displayGrossAmtYn));
            _bw.write(_wl_block119Bytes, _wl_block119);

			if(billing_interface_yn.equals("Y")){

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(tot_gross_charge_amount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(tot_groos_pat_payable));
            _bw.write(_wl_block126Bytes, _wl_block126);
if(displayGrossAmtYn){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(tot_gross_amount));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block129Bytes, _wl_block129);

			}

            _bw.write(_wl_block130Bytes, _wl_block130);
  
		if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")){
			// String total_payable	            = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalChargeAmount.label","ph_labels");
			// String patient_payable	            = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalPayableAmount.label","ph_labels");
			 DecimalFormat dfTest               = new DecimalFormat(decimalFormatString);
			 tot_gross_charge_amount_str        = dfTest.format(tot_gross_charge_amount);
			 tot_groos_pat_payable_str          = dfTest.format(tot_groos_pat_payable);
			 //added for ML-BRU-CRF-0469 start
			 if(displayGrossAmtYn){
			 tot_gross_amount_str               = dfTest.format(tot_gross_amount);
			 }
			//added for ML-BRU-CRF-0469 end
			 

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(enableDisable));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tot_gross_amount_str));
            _bw.write(_wl_block135Bytes, _wl_block135);
 
		}
		else if(decimalFormatString.equals("")&&billing_interface_yn.equals("Y")){

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(enableDisable));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tot_gross_amount_str));
            _bw.write(_wl_block136Bytes, _wl_block136);
 
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block137Bytes, _wl_block137);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescriptionDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PayableAmount.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RegisteredPrescription.label", java.lang.String .class,"key"));
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
}
