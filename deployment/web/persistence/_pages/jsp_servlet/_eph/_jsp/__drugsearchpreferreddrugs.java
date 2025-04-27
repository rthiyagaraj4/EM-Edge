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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __drugsearchpreferreddrugs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugSearchPreferredDrugs.jsp", 1741325663816L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History\t\tName\t\tRev.Date\t\tRev.Name\t\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?           created\n05/11/2020      IN074347           Prabha      05/11/2020     Manickavasagam J          SKR-SCF-1462\n-------------------------------------------------------------------------------------------------------------\n---->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t\t<form name=\"frmDrugNameCommonLookupResult\" id=\"frmDrugNameCommonLookupResult\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<br>\n\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"1%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="                                  \n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"2\">&nbsp;</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"40%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"3%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"18%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"12%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">&nbsp;</td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t\t<td onClick=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onclick=\"disableClick(event);\" class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><font class=\'HYPERLINK\' onmouseover=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">+</font></td>\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t  <input type =\"hidden\" name = \"previligeGroupDrug_ordering_YN";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" value =\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" />\n                                 ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'INSUFFICIENTSTOCK\' width=\'2\' title=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">&nbsp;</td>\t\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' width=\'2\'></td>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t<td onclick=\"disableClick(event);\" class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" title=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t<td id=\"drug_name";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onClick=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"drug_code";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"><input type=\"hidden\" name=\"line_no";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"line_no";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"><input type=\"hidden\" name=\"trade_code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"trade_code";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"><input type=\"hidden\" name=\"trade_name";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"trade_name";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =")</label>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" style=\'TEXT-ALIGN:center;\'>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'diagnosis_found_yn";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'diagnosis_found_yn";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'appl_for_age_grp_yn";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'appl_for_age_grp_yn";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\"  height=\'15\' width=\'15\' style=\"cursor:pointer\" onClick=\'showDrugInfo(\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\",\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\")\'>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" style=\'TEXT-ALIGN:center;\'> ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" style=\'TEXT-ALIGN:center;\' title=\'\' id=\'BL_ERROR";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'> ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t<td id=\"drug_name";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" onclick=\"disableClick(event);\" title=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"><input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" id=\"drug_code";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">(";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<!--  <td  class=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" width =\"5%\">&nbsp;&nbsp;</td>  -->\n\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" style=\'TEXT-ALIGN:center;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'diagnosis_found_yn";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\"  height=\'15\' width=\'15\' style=\"cursor:pointer\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\',\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\')\">\t\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;</td>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t<td  onClick=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"><font ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="&nbsp;</font></td>\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td onclick=\"disableClick(event);\" class=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" ><img src=\"../../ePH/images/altenate.jpg\" style=\"cursor:pointer\"  onClick=\"displayAlternateDrugs(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\', \'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\')\" style=\"cursor:pointer;color:blue\" height=\'15\' width=\'15\' > </td>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" align=\"right\" title=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" ><label onclick=\"displayStock(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\');\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</label></font></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" ><img src=\"../../ePH/images/altenate.jpg\"  height=\'15\' width=\'15\' style=\"cursor:pointer\"  onClick=\"displayAlternateDrugs(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\')\" style=\"cursor:pointer;color:blue\" > </td>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" ><label  onclick=\"displayStock(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</label></font></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"pres_base_uom";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\t\t\t\t\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t <script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t window.close();\n\t\t\t\t\t</script> \n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"identity\" id=\"identity\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drugorfluid\" id=\"drugorfluid\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"res_by_service\" id=\"res_by_service\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Classification\" id=\"Classification\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"searchBasedOn\" id=\"searchBasedOn\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\t\t\t<br>\n\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t<td class=\"white\" width=\"1%\">\n\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\">+</label>\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'INSUFFICIENTSTOCK\' width=\'1%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'white\' width=\'1%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t<td class=\'white\'>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;color:red;font-weight:bold\">";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</label>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;color:red;font-weight:bold\">&nbsp;</label>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t<td class=\"white\" align=\"right\">\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/altenate.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"white\" align=\"left\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<br><br>\n\t\t\t\t\t<table  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD COLSPAN=\"2\"  class=\"white\" align=\"right\" ><input type=\"button\" value=\"Close\"  class=\"button\"\tonClick=\"parent.window.close()\"></TD>\n\t\t\t\t\t</TR>\n\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t       \n\t\t\t</form>\n\t\t\t\n\t\t\t\n\t\t</body>\n\t</html>\n\t\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		String billing_preference_basis = request.getParameter("billing_preference_basis");
		String drugDesc			= request.getParameter("drugDesc");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		if (billing_preference_basis.equals("G")){					

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else{				

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

		//String drugDesc			="";
		try{

		String	bean_id			=	request.getParameter("bean_id");
		String	bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean bean		=	(DrugSearchBean)getBeanObject( bean_id, bean_name, request ) ;
	    bean.setLanguageId(locale);
	    String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		param_bean.setLanguageId(locale);
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id); 
	

		String from				=	request.getParameter("from");
		String to				=	request.getParameter("to");
		String searchBasedOn	=	request.getParameter("searchBasedOn");
		String identity			= request.getParameter("identity");
	
		String drugorfluid		= bean.getDrugOrFluid();
		String search_by		= bean.getSearchBy();
		String title			= "";
		String store_desc		=	"";
		String store_code		=	"";
		String description		=	"";
		String disp_charge_dtl_in_drug_lkp_yn="";
		String disp_price_type_in_drug_lkp="";
		String disp_charge_dtl_in_drug_lkp_yn1 ="";
		String disp_price_type_in_drug_lkp1 ="";
		disp_charge_dtl_in_drug_lkp_yn	=	request.getParameter("disp_charge_dtl_in_drug_lkp_yn");
		disp_price_type_in_drug_lkp	=	request.getParameter("disp_price_type_in_drug_lkp");
		String bl_install_yn	=	request.getParameter("bl_install_yn");
		String billingPriority	=	request.getParameter("billingPriority");
		String drug_class="";
		String prompt_alert_check_YN="";
		String billing_preference_check_YN=""; 
		String preffered_drug_alert_text="";
		String showAlert ="";
		String encounter_id ="";
		String episodeType = "";
		String episodeId = "";
		String visitId = "";
		String itemCode = "";
		String billingPrefereneBasisInd= "";
		String billingPreferredItemCode = "";
		String billingErrorMsg = "";
		String item_code = request.getParameter("item_code");
		String prev_drug_code = request.getParameter("drugCode");
		String generic_id = "";
		//String billing_preference_basis = request.getParameter("billing_preference_basis");
		String patient_id				= bean.getPatientId();
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		orbean.setLanguageId(locale);
		//String resp_id					= orbean.getResponsibilityId();
		String resp_id                  = (String) session.getValue("responsibility_id");	
		bean.setRespId(resp_id);
		String practitionerId			= orbean.getPractitionerId();
		String drug_priv_appln_yn		= (String) session.getValue("PrivilegeApplicability");
		
		if(billing_preference_basis.equals("S")){
			item_code = item_code;	
		}
		else{
			item_code = prev_drug_code;
		}
		ArrayList remaining_search = new ArrayList();			
		if(search_by.equals("D")) {
			//title	=	"Drug Name";
		    title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			remaining_search.add("G");
			remaining_search.add("T");
		}
		else if(search_by.equals("G")) {
			//title	=	"Generic Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			remaining_search.add("D");
			remaining_search.add("T");
		}
		else if(search_by.equals("T")) {
			//title	=	"Trade Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeName.label","common_labels");
			remaining_search.add("D");
			remaining_search.add("G");
		}
		else if(search_by.equals("A")) {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			remaining_search.add("D");
			remaining_search.add("T");
			remaining_search.add("G");
		}
		else {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			remaining_search.add("G");
			remaining_search.add("T");
		}

		if(drugorfluid==null){
			drugorfluid="";
		}

		String order_type_code = "";
		String Classification = "";
		String res_by_service	= "";
		String service_code		= "";
		String consider_stock	=	"N";
		String bean_id_2		= "@PrescriptionBean_1"+patient_id;
		String bean_name_2		= "ePH.PrescriptionBean_1";

		PrescriptionBean_1 bean_2		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2, request ) ;	
		bean_2.setLanguageId(locale);
		if (identity==null){
			identity="General";
		}
		bean.setIdentity(identity);
		ArrayList stock_params	=	bean.validateForStock();

		if(stock_params.size() > 1) {
			consider_stock	=	(String)stock_params.get(0);
			disp_charge_dtl_in_drug_lkp_yn=(String)stock_params.get(2);
			disp_price_type_in_drug_lkp = (String)stock_params.get(3);
		}

		if (from == null)
			from = "";
		if (to == null)
			to = "";
		ArrayList arrList = new ArrayList();
		generic_id = bean.getGenericId(item_code);

		if(!search_by.equals("A")){
			if ((searchBasedOn.equals("Drug"))||(searchBasedOn.equals("ATC"))){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected_preferred(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,generic_id,item_code,billing_preference_basis,drug_priv_appln_yn,billingPriority);	
			}
		}
		else if(search_by.equals("A")){
			bean.setSearchBy("A");
			if ((searchBasedOn.equals("Drug"))||(searchBasedOn.equals("ATC"))){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected_preferred(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,generic_id,item_code,billing_preference_basis,drug_priv_appln_yn,billingPriority);
			}
		}

		Hashtable ht = (Hashtable)bean.getSelectedDrugs();
		String enableDisable="";
		String in_formulary_yn	=	bean.getInFormulary();
		if (ht.size()==0){
			enableDisable = "disabled";		
		}

            _bw.write(_wl_block12Bytes, _wl_block12);

				if (arrList.size()>=1){

            _bw.write(_wl_block13Bytes, _wl_block13);

							if(identity.equals("MedicationOrder")){
								if(((bean_2.getExternalpatient_id()==null)||   (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */

            _bw.write(_wl_block14Bytes, _wl_block14);
		
								}
							}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title));
            _bw.write(_wl_block17Bytes, _wl_block17);

							if (identity.equals("MedicationOrder") ){

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

								if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

								}
							}

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

							if (identity.equals("MedicationOrder") ){

            _bw.write(_wl_block25Bytes, _wl_block25);

	
								if(consider_stock.equals("Y")) { 
									if( ( (bean_2.getExternalpatient_id()==null)|| (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
		
									}
								}	
								if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) { 

            _bw.write(_wl_block28Bytes, _wl_block28);

								}
							}

            _bw.write(_wl_block29Bytes, _wl_block29);

							String strEnableDisable =	"";
							String strChecked		=	"";
							String classvalue		=	"";
							Hashtable htDisableDrugs = bean.getDrugsAsDisabled();	

							String onClick			=	"";
							String plus_sign		=	"";
							String mouse_over		=	"";
							ArrayList stock_dtls	=	null;
							String stock_yn			=   "";
							String avl_qty			=	"";
							String qty_uom			=	"";
							String drug_code		=	"";
							String in_formulary		=	"";
							String str_click		=	"";
							String font_class		=	"";
							String trade_code="";
							String trade_name ="";
							String disp_str ="";
							String error_code = "";
							String sys_message_id = "";
							String error_text = "";

							for (int i=0;i<arrList.size();i++){
								String[] strArray=(String[])arrList.get(i);

								drug_code		= strArray[0];
								if(search_by.equals("G")) {
									description	=	strArray[8];
								} 
								else {
									description	=	strArray[1];
								}

								strArray[1]	=	java.net.URLEncoder.encode(strArray[1],"UTF-8");
								if(strArray.length >= 14){
									in_formulary	= strArray[13];
								}
								else{
									in_formulary	= "N";
								}
								trade_code= strArray[10];
								if(trade_code ==null)
									trade_code = "";
								trade_name=strArray[11];
								drug_class=strArray[21];

								if(in_formulary.equals("Y")) {
									if (identity.equals("MedicationOrder")){
										//consider_stock added during PE corrections by Naveen
										stock_dtls		= bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
									}
								}

								classvalue		 =	"";
								strEnableDisable =	"";
								stock_yn		 =   "";
								avl_qty			 =	"";
								qty_uom			 =	"";
								store_desc		 =  "";
								store_code		 =  "";

								qty_uom				=	bean.getStockUOM(strArray[0]);
								qty_uom = qty_uom==null?"&nbsp;":qty_uom;

								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								plus_sign	=	"callDrugDetailsDisplay('"+strArray[0]+"')";
								mouse_over	=	"changeCursor(this);";

								if(htDisableDrugs !=null){
									if (htDisableDrugs.contains(strArray[0])){
										strEnableDisable = "disabled";
										strChecked	="checked";
										onClick		=	"";
										//plus_sign	=	"";
										//mouse_over	=	"";
									}
									else{
										strEnableDisable = "";
										strChecked="";
										onClick	=	"preferredDrugSearchModify(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
										//plus_sign	=	"callDrugDetailsDisplay('"+strArray[0]+"')";
										//mouse_over	=	"changeCursor(this);";
									}
								}
							if(consider_stock.equals("Y")  && (in_formulary.equals("Y"))) {
									if(stock_dtls!=null && stock_dtls.size() > 0) {
										stock_yn			=	(String)stock_dtls.get(0);
										avl_qty				=	(String)stock_dtls.get(1);
										store_desc			=	(String)stock_dtls.get(2)==null?"":(String)stock_dtls.get(2);
										if(store_desc.indexOf('|') != -1)
											store_desc = store_desc.substring(0,store_desc.indexOf('|'));
										if(strEnableDisable.equals(""))
											strEnableDisable	=	(String)stock_dtls.get(3);						
										store_code			=	(String)stock_dtls.get(4)==null?"":(String)stock_dtls.get(4);
									}
									
									if(identity.equals("MedicationOrder") && stock_params.size() > 1 ) {
										String allow_yn	=	(String)stock_params.get(1);
										
										if(allow_yn.equals("N") && (stock_dtls.size()==0 || avl_qty.equals(""))) {
											strEnableDisable	=	"disabled";
										} 
									}
								} 
								else {
									if(stock_dtls!=null && stock_dtls.size() > 0) {
										avl_qty				=	(String)stock_dtls.get(1);
										store_desc			=	(String)stock_dtls.get(2)==null?"":(String)stock_dtls.get(2);	
										if(store_desc.indexOf('|') != -1)
											store_desc = store_desc.substring(0,store_desc.indexOf('|'));
										store_code			=	(String)stock_dtls.get(4)==null?"":(String)stock_dtls.get(4);	
										if(avl_qty.equals("") || avl_qty.equals("0"))
											stock_yn			=	"N";
										else					
											stock_yn			=	"Y";
									}
								}

								if(avl_qty.equals("") || avl_qty.equals("0")) {
									avl_qty	=	"0";
								}
								error_code = strArray[17]==null?"":strArray[17];    
								sys_message_id = strArray[18]==null?"":strArray[18];
								error_text = strArray[19]==null?"":strArray[19]; 

								if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
									strEnableDisable	=	"disabled";
								}

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(plus_sign));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mouse_over));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
									
                                  if(identity.equals("MedicationOrder")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strArray[25]));
            _bw.write(_wl_block36Bytes, _wl_block36);
  if( ( (bean_2.getExternalpatient_id()==null)||  (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()==""))){			/*Modified For SKR-SCF-1642 */
										if(consider_stock.equals("Y") && (stock_yn.equals("") || stock_yn.equals("N"))) { 

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
   
										}
										else { 

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);

										}	
									}
								  }

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( strArray[5] ));
            _bw.write(_wl_block19Bytes, _wl_block19);

	
									if (strEnableDisable != null){
										if(!strEnableDisable.equals("disabled")){								
									


            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(onClick));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strArray[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( description ));
            _bw.write(_wl_block57Bytes, _wl_block57);

											if(!strArray[11].equals("")){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strArray[11]));
            _bw.write(_wl_block59Bytes, _wl_block59);

											}

            _bw.write(_wl_block60Bytes, _wl_block60);
   
										if(identity.equals("MedicationOrder")){

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strArray[20]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strArray[22]));
            _bw.write(_wl_block67Bytes, _wl_block67);
										
												  if(drug_db_interface_yn.equals("Y")){
													if(bean.getExternalProductId(strArray[0])!=null  ){

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean.getExternalProductId(strArray[0])));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(java.net.URLEncoder.encode(strArray[1],"UTF-8")));
            _bw.write(_wl_block70Bytes, _wl_block70);

													}
												 }

            _bw.write(_wl_block71Bytes, _wl_block71);

											if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block74Bytes, _wl_block74);

												if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block76Bytes, _wl_block76);

												if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block76Bytes, _wl_block76);

												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str =strArray[16] ;
												}
												else{
													disp_str = "&nbsp";
													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
														disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
													}
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block76Bytes, _wl_block76);

												if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
													out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
												}
											}
										}
									}
									else{

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strArray[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( description ));
            _bw.write(_wl_block83Bytes, _wl_block83);

										if(!strArray[11].equals("")){

            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strArray[11]));
            _bw.write(_wl_block59Bytes, _wl_block59);

										}

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block86Bytes, _wl_block86);
   
										if(identity.equals("MedicationOrder")){

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strArray[20]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strArray[22]));
            _bw.write(_wl_block67Bytes, _wl_block67);

											  if(drug_db_interface_yn.equals("Y")){
												if(bean.getExternalProductId(strArray[0])!=null ){

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bean.getExternalProductId(strArray[0])));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( strArray[1] ));
            _bw.write(_wl_block90Bytes, _wl_block90);

												}
										    }

            _bw.write(_wl_block91Bytes, _wl_block91);

											if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block74Bytes, _wl_block74);

												if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block76Bytes, _wl_block76);

												if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block76Bytes, _wl_block76);

												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str =strArray[16] ;
												}
												else{
													disp_str = "&nbsp";

													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
														disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
													}
												}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block76Bytes, _wl_block76);

												if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
													out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
												}
											}
										}										
									}
								}

								if (strArray[2] != null){
									if (!strArray[2].equals("0")){
										if(!strEnableDisable.equals("disabled")){
										//str_click	=	"preferredDrugSearchModify(eval(document.getElementById("drug_name"+i+"')),'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
										str_click = "preferredDrugSearchModify(eval(document.getElementById('drug_name' + i)), '" + 
												    strArray[8] + "', '" + 
												    strArray[9] + "', '" + 
												    strArray[2] + "', '" + 
												    strArray[3] + "', '" + 
												    strArray[4] + "', '" + 
												    strArray[6] + "', '" + 
												    strArray[12] + "', '" + 
												    strArray[0] + "', '" + 
												    strArray[10] + "', '" + 
												    java.net.URLEncoder.encode(strArray[11], "UTF-8") + "', '" + 
												    i + "');";
													
										font_class	=	"class='HYPERLINK' onMouseOver='changeCursor(this);'";
										} else {
											str_click	=	"";
											font_class	=	"style='font-size:11'";
										}					

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(str_click));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(font_class));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( strArray[2] ));
            _bw.write(_wl_block95Bytes, _wl_block95);

									}
									else{

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block97Bytes, _wl_block97);

									}
								}

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( strArray[7] ));
            _bw.write(_wl_block19Bytes, _wl_block19);

							if (identity.equals("MedicationOrder") ){
								if (ht.containsKey( strArray[0]+i)){
									if((strArray[23].equals("Y") || strArray[24].equals("Y")) && strArray[26].equals("N")){ //strArray[26] - NPB_DRUG_YN 

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc,"UTF-8")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[1]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[9]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[6]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(identity));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( patient_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
 
									}
									else{

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block102Bytes, _wl_block102);
									
									}
									if(consider_stock.equals("Y")) { 

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[1]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc)));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block19Bytes, _wl_block19);

									}

									//if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	

            _bw.write(_wl_block107Bytes, _wl_block107);
	
									//}
								}
								else{
									if((strArray[23].equals("Y") || strArray[24].equals("Y"))&& strArray[26].equals("N")){ //strArray[26] - NPB_DRUG_YN 

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc,"UTF-8")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( strArray[1] ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[9]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[6]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(identity));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( patient_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
 
									}
									else{

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block102Bytes, _wl_block102);

									}
									if(consider_stock.equals("Y")) { 
										if( ( (bean_2.getExternalpatient_id()==null)||  (bean_2.getExternalpatient_id()).equals("") || (bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strArray[1]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc, "UTF-8")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
										}
									}	
									if(strChecked.equals("checked")) { 
										strEnableDisable  = "disabled";
									}
									//if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	

            _bw.write(_wl_block107Bytes, _wl_block107);

									//}
								}
							 }

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strArray[12]));
            _bw.write(_wl_block114Bytes, _wl_block114);
				
						}
					}
					else if(arrList==null || arrList.size()<1 || !arrList.get(0).equals("cancel")){
				

            _bw.write(_wl_block115Bytes, _wl_block115);

					} 

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(identity));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(drugorfluid));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(res_by_service));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(Classification));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block124Bytes, _wl_block124);

				if (identity.equals("MedicationOrder") && arrList.size()>=1){
	
            _bw.write(_wl_block125Bytes, _wl_block125);

								if(consider_stock.equals("Y")) { 
									if( ( (bean_2.getExternalpatient_id()==null)||  (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */

            _bw.write(_wl_block126Bytes, _wl_block126);

									}
									else{

            _bw.write(_wl_block127Bytes, _wl_block127);

									}

            _bw.write(_wl_block128Bytes, _wl_block128);

									if( ( (bean_2.getExternalpatient_id()==null)|| (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()==""))){   /*Modified For SKR-SCF-1642 */

            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

									}
									else{

            _bw.write(_wl_block131Bytes, _wl_block131);

									}

            _bw.write(_wl_block132Bytes, _wl_block132);

							}

            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

				}		
	
            _bw.write(_wl_block135Bytes, _wl_block135);


	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_2,bean_2,request);
}
catch(Exception e){
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferredDrugsByGenericfor.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferredDrugsBySpecficfor.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Information.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Pay.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reimburse.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.National.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitPrice.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminRoute.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Quantity/Uom.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoStockinDispenseLocation.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
}
