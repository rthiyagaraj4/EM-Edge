package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.*;
import eOR.*;
import java.text.DecimalFormat;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __drugnamecommonlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugNameCommonLookupResult.jsp", 1742369299119L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n\t<head>\n\t\t<title></title> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t\t<form name=\"frmDrugNameCommonLookupResult\" id=\"frmDrugNameCommonLookupResult\" method = \"POST\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\"center\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"1%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="                                  \n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"2\">&nbsp;</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\" nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"40%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t<!--Added for NMC-JD-CRF-0001 Start -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"40%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<!--Added for NMC-JD-CRF-0001 end -->\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t <td class=\"COLUMNHEADER\" width=\"5%\"></td> \n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"3%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"18%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"12%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">&nbsp;</td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<!-- Modified for TFS id:7345 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<td onClick=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onclick=\"disableClick(event);\" class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"><font class=\'HYPERLINK\' onmouseover=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">+</font></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >&nbsp;</td>\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name = \"previligeGroupDrug_ordering_YN";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id = \"previligeGroupDrug_ordering_YN";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" value =\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" />\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'INSUFFICIENTSTOCK\'  width=\'2\' title=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'  width=\'2\'>&nbsp;</td>\t\t\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' width=\'2\'></td>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCostGreen.jpg\" style=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' height=\'15\' width=\'15\' title=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMarginGreen.jpg\" style=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" height=\'15\' width=\'15\' title=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCostRed.jpg\" style=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMarginRed.jpg\" style=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'> ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/LowCost.jpg\" title=\"Low Cost Item\" style=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" height=\'15\' width=\'15\' >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/HighMargin.jpg\" title=\"High Margin Item\" style=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Innovator.jpg\" title=\"Innovator Item\" style=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"  height=\'15\' width=\'15\' > ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t<td onclick=\"disableClick(event);\" class=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" title=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\n\t\t\t\t\t\t\t\t\t\t<td id=\"drug_name";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" onClick=\"\" class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" title=\"\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<td id=\"drug_name";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" onClick=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t<!-- Modified for TFS id:7345 end-->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"drug_code";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"><input type=\"hidden\" name=\"line_no";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"line_no";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"><input type=\"hidden\" name=\"trade_code";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"trade_code";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"><input type=\"hidden\" name=\"trade_name";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"trade_name";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =")</label>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<!--Added for NMC-JD-CRF-0001 Start -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\n\t\t\t\t\t\t\t\t\t\t<td id=\"drug_name";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t\t\t\t</font>\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t\t\t     <label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =")</label>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t\t<!--Added for NMC-JD-CRF-0001 end -->\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t\t\t <td  class=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" width =\"5%\">&nbsp;";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="<!--GHL-CRF-0618   -->\n\n\t\t\t\t\t\t\t\t\t\t\t</td> \n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" style=\'TEXT-ALIGN:center;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'diagnosis_found_yn";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' id=\'diagnosis_found_yn";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'appl_for_age_grp_yn";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'appl_for_age_grp_yn";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Passing Encode URIcomponent for strArray[1] for the incident num:25007 on 18/Nov/2010 By Sandhya -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\"  height=\'15\' width=\'15\' style=\"cursor:pointer\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\',\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\">\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;</td>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" style=\'TEXT-ALIGN:center;\'> ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" style=\'TEXT-ALIGN:center;\' title=\'\' id=\'BL_ERROR";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" style=\'TEXT-ALIGN:center;\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" style=\'TEXT-ALIGN:center;\'>&nbsp;</td>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" style=\'TEXT-ALIGN:center;\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t\t\t\t<td id=\"drug_name";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" onclick=\"disableClick(event);\" title=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"><input type=\"hidden\" name=\"drug_code\" id=\"drug_code";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"  value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"  id=\"trade_name";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">(";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<!--Added for NMC-JD-CRF-0001 Start -->\n\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"><input type=\"hidden\" name=\"drug_code\"  id=\"drug_code";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t                   <label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">(";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =")</label>\n                                            ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" \n                                            <!--Added for NMC-JD-CRF-0001 end -->\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" width =\"5%\">&nbsp;\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="<!-- GHL-CRF-0618-->\n\n\t\t\t\t\t\t\t\t\t\t\t</td> \n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" width =\"5%\">&nbsp;&nbsp;</td> \n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" style=\'TEXT-ALIGN:center;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'diagnosis_found_yn";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'appl_for_age_grp_yn";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\"  height=\'15\' width=\'15\' style=\"cursor:pointer\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\')\">\t\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" style=\'TEXT-ALIGN:center;\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t\t\t\t<td  onClick=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"><font ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =">";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="&nbsp;</font></td>\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" style=\'color:";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =";background-color:";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</td><!-- // added  style attribute for CRF RUT-CRF-0034.1[IN:037389]-end -->\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- Passing Encode URIcomponent for strArray[1] for the incident num:25007 on 18/Nov/2010 By Sandhya -->\n\t\t\t\t\t\t\t\t\t\t\t<!-- strength_value AND drug_strength_uom added for ghl-crf-0548 -->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" ><img src=\"../../ePH/images/altenate.jpg\" style=\"cursor:pointer\"  onClick=\"displayAlternateDrugs(\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\', \'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\')\" style=\"cursor:pointer;color:blue\" height=\'15\' width=\'15\' > </td>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="                                          <td class=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" align=\"right\" title=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" </td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" ><label onclick=\"displayStock(\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" </label></font></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' ><img src=\'../../ePH/images/StockUnavailable.png\'  height=\'18\' width=\'20\' ></td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' ><img src=\'../../ePH/images/StockAvailable.png\'  height=\'18\' width=\'20\' ></td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" style=\'TEXT-ALIGN:center;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"drugSelect";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" id=\"drugSelect";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" value=\"\" checked onClick=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\"  style=\'TEXT-ALIGN:center;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"drugSelect";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" value=\"\" disabled>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- Passing Encode Uri component for strArray[1] for the incident num:25007 on 18/Nov/2010 -->\n\t\t\t\t\t\t\t\t\t\t\t<!-- strength_value AND drug_strength_uom added for ghl-crf-0548 -->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" ><img src=\"../../ePH/images/altenate.jpg\"  height=\'15\' width=\'15\' style=\"cursor:pointer\"  onClick=\"displayAlternateDrugs(\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\')\" style=\"cursor:pointer;color:blue\" > </td>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="                                              <td class=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =" </td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =" </td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" ><label  onclick=\"displayStock(\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\');\">";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =" </label></font></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" </td>\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' ><img src=\'../../ePH/images/StockUnavailable.png\'  height=\'18\' width=\'20\' ></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' ><img src=\'../../ePH/images/StockAvailable.png\'  height=\'18\' width=\'20\' ></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="<!-- Added for TFS id:-16341 end -->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" style=\'TEXT-ALIGN:center;\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"drugSelect";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" value=\"\" onClick = \'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\' ";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="><!-- //added for  JD-CRF-0198 [IN:058599] -->\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"  style=\'TEXT-ALIGN:center;\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"drugSelect";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" value=\"\"  ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="><!--//Changed Disabled to strEnableDisable for MMS-QF-SCF-0686 //added for  JD-CRF-0198 [IN:058599] -->\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" id=\"pres_base_uom";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\t\t\t<input type=\"hidden\" name=\"generic_id";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" id=\"generic_id";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"><input type=\"hidden\" name=\"generic_name";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" id=\"generic_name";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" id=\"drug_desc";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_clicked";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" id=\"drug_clicked";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" value=\"N\" >\n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\t\t//\twindow.close();\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t\t\t\t\t<!-- <input type=\"hidden\" name=\"from1\" id=\"from1\" value=\"\"> -->\n\t\t\t\t\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t\t\t\t\t<!-- <input type=\"hidden\" name=\"to1\" id=\"to1\" value=\"\"> -->\n\t\t\t\t\t<input type=\"hidden\" name=\"identity\" id=\"identity\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drugorfluid\" id=\"drugorfluid\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"res_by_service\" id=\"res_by_service\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"Classification\" id=\"Classification\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"searchBasedOn\" id=\"searchBasedOn\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\t\t\t\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t\t<td class=\"white\" width=\"1%\">\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\">+</label>\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'INSUFFICIENTSTOCK\' style= \"background-color:red\" width=\'1%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'white\' width=\'1%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'white\'>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;color:red;font-weight:bold\">";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</label>\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"font-size:10;color:red;font-weight:bold\">&nbsp;</label>\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"right\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/altenate.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</td>\t\n\t\t\t\t\t\t\t\t<td align=\"right\" class=\"white\"><img src=\'../../ePH/images/Insurance.gif\'  height=\'15\' width=\'15\' ></td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\"  nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 =" </td>\n\t\t\t\t\t\t\t\t<!-- Added for IN069511 START -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t\t\t\t<td align=\"right\" class=\"white\"><img src=\'../../ePH/images/ExternalDispensing.gif\'  height=\'18\' width=\'20\' ></td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\"  nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 =" </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t\t\t\t<!-- Added for IN069511 END -->\n";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="<!-- modifiedfor GHL-CRF-0618-->\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\"><img src=\"../../ePH/images/LowCost.jpg\" height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\"><img src=\"../../ePH/images/HighMargin.jpg\" height=\'15\' width=\'15\' ></td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\"><img src=\"../../ePH/images/Innovator.jpg\" height=\'15\' width=\'15\' ></td><td class=\"white\" align=\"left\" nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\' name=\"btnSelect\" class=\"button\" onClick=\"returnAllSelectedDrugs()\" ";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'white\' width=\'1%\'></td>\t\n\t\t\t\t\t\t\t <td class=\"white\" align=\"left\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Preference1.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Preference2.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Preference3.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\">\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Preference4.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="    <!-- End of GHL-CRF-0618 -->\n\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t \n\t\t\t\t   <input type =\'hidden\' name =\'priviligeCheck_fromSearch\' id =\'priviligeCheck_fromSearch\' value =\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'>\n\t\t\t\t   <input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n\t\t\t\t   <input type=\"hidden\" name=\"disp_charge_dtl_in_drug_lkp_yn\" id=\"disp_charge_dtl_in_drug_lkp_yn\" value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n\t\t\t\t   <input type=\"hidden\" name=\"disp_price_type_in_drug_lkp\" id=\"disp_price_type_in_drug_lkp\" value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n\t\t\t\t   <input type=\"hidden\" name=\"priviligeCheck\" id=\"priviligeCheck\" value= \"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" >\n\t\t\t\t</form>\n\t\t\t</body>\n\t\t<script language=\"javascript\">\n\t\t\tdefaultSearchBy(\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\');\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n</html>\n\n";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344]
07/03/2019	        IN069337                Haribabu	     									Need to show Generic name in drug search lookup
09/04/2019	        IN069511                Haribabu	     									Available Quantity for drugs need to take from interface table
29/05/2020	IN:072092	        Manickavasagam J			     GHL-CRF-0618
30/06/2020  		IN072347				Shazana											            	GHL-CRF-0619  
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
10/11/2020	6041			Shazana       										NMC-JD-CRF-0063
04/01/2021	 TFS id:7345 Haribabu	      04/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
06/01/2021   TFS-12457              Prabha		06/01/2020	Manickavasagam J  Alpha-PH -Drug master setup in Query mode
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
24/08/2021      TFS-22422           Prabha    24/08/2021	 Manickavasagam J          SKR-SCF-1631
18/11/2021		TFS-26007		   Prabha 												GHL-SCF-1614
03/01/2022		TFS-26862		   Prabha												GHL-ICN-0090
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;   
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
     	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
     	  	boolean ext_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXT_DISP_APPL");//Added for IN069511
		boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618

		
		String	bean_id			=	request.getParameter("bean_id");
		String	bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean bean		=	(DrugSearchBean)getBeanObject( bean_id, bean_name, request ) ;
	    bean.setLanguageId(locale);
	    bean.setExt_disp_appl(ext_disp_appl);//Added for IN069511
		bean.setFormularyBlngApp(formulary_billing_app);//GHL-CRF-0618
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
		String normalRx_yn		= request.getParameter("normalRx_yn")==null?"":request.getParameter("normalRx_yn"); //GHL-CRF-0549
		String priviligeCheck_fromSearch = request.getParameter("priviligeCheck")==null?"":request.getParameter("priviligeCheck");        
		bean.setPriviligeDrugCheck(priviligeCheck_fromSearch);
		String drugorfluid		= bean.getDrugOrFluid();
		String search_by		= bean.getSearchBy();
		String title			= "";
		String title1			= "";//Added for NMC-JD-CRF-0001
		String store_desc		=	"";
		String store_code		=	"";
		String description		=	"";
		String description1		=	"";//Added for NMC-JD-CRF-0001
		String disp_charge_dtl_in_drug_lkp_yn	="";
		String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ;
		String disp_price_type_in_drug_lkp		="";
		String drug_class						="";
		String prompt_alert_check_YN			="";
		String billing_preference_check_YN		=""; 
		String preffered_drug_alert_text		="";
		String showAlert						="";
		String encounter_id						="";
		String episodeType						= "";
		String episodeId						= "";
		String visitId							= "";
		String itemCode							= "";
		String billingPrefereneBasisInd			= "";
		String billingPreferredItemCode			= "";
		String billingErrorMsg					= "";
		String practitionerId					= "";
		String promptAlertItemCheckYN			= "";
		String showAlertOncheck					= "";
		String storeSelectedDrugs				= "";
		String uomDesc1							="";
		String uomDesc2							="";
		String qtyString1						="";
		String qtyString2						="";
		String qtySymbol						="";
		//String strengthString					= "";
		String billingPriority					= "";
		String display_generic_name_yn          =CommonBean.checkForNull(bean.getDisplayGenericNameApp(facility_id));//Added for NMC-JD-CRF-0001
		String alternateDisable					= "";//added for  JD-CRF-0198 [IN:058599]
		ArrayList billingPreferenceCheckList	=null;
		bean.setNoOfDecimals();
		int noOfDecimals						=bean.getNoOfDecimals();
		ArrayList remaining_search				= new ArrayList();			
		//Added for TFS id:7345 start
		boolean pre_alloc_appl=bean.getPreAllocAppl();
		boolean disp_appl_for_pre_alloc =true;
		boolean disp_locn_select_appl =bean.getDefaultDispLocnSelectAppl();//Added for TFS id:-16341
		
		
		if(pre_alloc_appl){
			display_generic_name_yn="Y";
		}
		//Added for TFS id:7345	end
		if(search_by.equals("D")) {
			//title	=	"Drug Name";
		    title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
		    //Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("G");
			remaining_search.add("T");
			remaining_search.add("C");
		}
		else if(search_by.equals("G")) {
			//title	=	"Generic Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
			title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("T");
			remaining_search.add("C");
		}
		else if(search_by.equals("T")) {
			//title	=	"Trade Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("G");
			remaining_search.add("C");
		}
		else if(search_by.equals("C")) {
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");  //Added for ICN 30808/30804
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("G");
			remaining_search.add("T");
		}
		else if(search_by.equals("A")) {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("T");
			remaining_search.add("G");
			remaining_search.add("C");
		}
		else {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		        if(display_generic_name_yn.equals("Y")){
			title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			 }
		         //Added for NMC-JD-CRF-0001 end
			remaining_search.add("G");
			remaining_search.add("T");
			remaining_search.add("C");
		}

		if(drugorfluid==null){
			drugorfluid="";
		}

		String order_type_code  = "";
		String Classification   = "";
		String res_by_service	= "";
		String service_code		= "";
		String consider_stock	= "N";
		String patient_id		= bean.getPatientId();
		encounter_id			= bean.getEncounterId();
		
		String bean_id_2		= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name_2		= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean_2		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2, request ) ;	
		bean_2.setLanguageId(locale);

		//String or_bean_name				= "eOR.OrderEntryBean";
		//String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
		//OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		//added for NMC-JD-CRF-0063 START
		System.out.println("Presc getTakeHomeMedicationOp :"+bean_2.getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063 START
		System.out.println("Presc getOpDischMedInd :"+bean_2.getOpDischMedInd()); 
		System.out.println("bean_2.getOpHomeMedicationVal(): "+bean_2.getOpHomeMedicationVal()); //END
		bean.setTakeHomeMedicationOp(bean_2.getTakeHomeMedicationOp());  
		bean.setOpDischMedInd(bean_2.getOpDischMedInd());//END
		System.out.println("Drugbean getTakeHomeMedicationOp :"+bean.getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063 START
		System.out.println("Drugbean getOpDischMedInd :"+bean.getOpDischMedInd()); //END
       String or_bean_name				= "eOR.OrderEntryBean";
	   String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	   OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;

		orbean.setLanguageId(locale);
//String servide_code					= (String) orbean.getServiceCode();

		String resp_id                  = (String) session.getValue("responsibility_id");	   
	  
        if(bean.getcalledfrom().equals("DIRECT")){
			 practitionerId			  = bean.getPractitionerId();
		}else{			    
			 practitionerId			  = orbean.getPractitionerId();
			 bean.setPractitionerId(practitionerId);			
		}
	    String drug_priv_appln_yn		= bean.getDrugPrivilegeYN();
	

		if (identity==null){
			identity="General";
		}
		bean.setIdentity(identity);
        
		ArrayList stock_params	=	bean.validateForStock();
		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
			disp_price_type_in_drug_lkp		= (String)stock_params.get(3);
		}
					
		if (from == null)
			from = "";
		if (to == null)
			to = "";
		ArrayList arrList = new ArrayList();
		String alternateOrder = "N";//added for  JD-CRF-0198 [IN:058599]
		if(request.getParameter("alternateOrder")!=null)
			alternateOrder=request.getParameter("alternateOrder");
		
		if(alternateOrder.equals("Y"))
			alternateDisable = "disabled";//added for  JD-CRF-0198 [IN:058599]
		if(!search_by.equals("A")){
			if (searchBasedOn.equals("Drug")){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);
			}
			else if (searchBasedOn.equals("ATC")){
				Classification	= request.getParameter("Classification");
				if (identity.equals("MedicationOrder")){
					order_type_code		= request.getParameter("order_type_code");
					bean.setOrderTypeCode(order_type_code);
					res_by_service		= request.getParameter("res_by_service");
					bean.setResByService(res_by_service);
					service_code		 = request.getParameter("service_code");
					bean.setServiceCode(service_code);
				}
				//else{		
				arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
				
				bean.setInFormulary("Y");
				//}
			}
			/*else if(searchBasedOn.equals("Pharmaco")){
				Classification = request.getParameter("Classification");
				arrList		= (ArrayList)bean.searchBasedOnPharmacoClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp);
			}*/
			
			if(arrList!=null && arrList.size()<=1){
				
				bean.setSearchBy((String)remaining_search.get(0));
				search_by = (String)remaining_search.get(0);
				if (searchBasedOn.equals("Drug")){		
					arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);	
				}
				else if (searchBasedOn.equals("ATC")){
				
					Classification = request.getParameter("Classification");
					if (identity.equals("MedicationOrder")){
						order_type_code		= request.getParameter("order_type_code");
						bean.setOrderTypeCode(order_type_code);
						res_by_service		= request.getParameter("res_by_service");
						bean.setResByService(res_by_service);
						service_code		= request.getParameter("service_code");
						bean.setServiceCode(service_code);
					}		
					arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
					bean.setInFormulary("Y");
				}
				/*else if(searchBasedOn.equals("Pharmaco")){
					Classification = request.getParameter("Classification");
					arrList		= (ArrayList)bean.searchBasedOnPharmacoClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp);
				}*/
				
				if(arrList!=null && arrList.size()<=1){
					
					bean.setSearchBy((String)remaining_search.get(1));
					search_by = (String)remaining_search.get(1);
					if (searchBasedOn.equals("Drug")){		
						arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);		
					}
					else if (searchBasedOn.equals("ATC")){
						
						Classification = request.getParameter("Classification");
						if (identity.equals("MedicationOrder")){
							order_type_code = request.getParameter("order_type_code");
							bean.setOrderTypeCode(order_type_code);
							res_by_service = request.getParameter("res_by_service");
							bean.setResByService(res_by_service);
							service_code   = request.getParameter("service_code");
							bean.setServiceCode(service_code);
						}
						
						arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
						bean.setInFormulary("Y");
					}
					/*else if(searchBasedOn.equals("Pharmaco")){
						Classification = request.getParameter("Classification");
						arrList		= (ArrayList)bean.searchBasedOnPharmacoClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp);
					}*/
				}
			}
		}
		else if(search_by.equals("A")){
			
			bean.setSearchBy("A");
			if (searchBasedOn.equals("Drug")){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);		
			}
			else if (searchBasedOn.equals("ATC")){
				Classification = request.getParameter("Classification");
				if (identity.equals("MedicationOrder")){
					order_type_code = request.getParameter("order_type_code");
					bean.setOrderTypeCode(order_type_code);
					res_by_service = request.getParameter("res_by_service");
					bean.setResByService(res_by_service);
					service_code   = request.getParameter("service_code");
					bean.setServiceCode(service_code);
				}
				
				arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
				
			}
		}
		if(alternateOrder.equals("Y"))//added for  JD-CRF-0198 [IN:058599]
			search_by = "";
		Hashtable ht = (Hashtable)bean.getSelectedDrugs();
		String enableDisable="";
		String in_formulary_yn	=	bean.getInFormulary();
		if(search_by.equals("G")){ 
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
			title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
		    }
		  //Added for NMC-JD-CRF-0001 end
		}
		else {
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
		}
		if (ht.size()==0){
			enableDisable = "disabled";		
		}

            _bw.write(_wl_block9Bytes, _wl_block9);

				String decimalStringFormat = "#.";
				// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya		
				if(noOfDecimals == 0)
					decimalStringFormat = "#";
			
				for (int i=0;i<noOfDecimals;i++){
						decimalStringFormat += "#";
				}
				if (arrList.size()>1){

            _bw.write(_wl_block10Bytes, _wl_block10);

								// For display the previous/next link
								out.println(arrList.get(0));

            _bw.write(_wl_block11Bytes, _wl_block11);

							if(identity.equals("MedicationOrder")){
								if(bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){

            _bw.write(_wl_block12Bytes, _wl_block12);
		
								}
							}

            _bw.write(_wl_block13Bytes, _wl_block13);
						
						//GHL-CRF-0549  - start
							if(bl_install_yn.equals("Y") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))){	

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
	
							}
							//GHL-CRF-0549  - end

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(title));
            _bw.write(_wl_block18Bytes, _wl_block18);
if(display_generic_name_yn.equals("Y")){ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(title1));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);

							if (identity.equals("MedicationOrder") ){

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

								if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

								}
							}

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

							if (identity.equals("MedicationOrder") ){

            _bw.write(_wl_block28Bytes, _wl_block28);

								if(consider_stock.equals("Y")) { 
									if( bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("") ){

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
		
									}
								}	
								if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")&& !drugorfluid.equals("CO")) { 

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

								}
							}

            _bw.write(_wl_block31Bytes, _wl_block31);

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
						String trade_code		=	"";
						String trade_name		=	"";
						String generic_id		=	"";
						String generic_name		=	"";
						String disp_str			=	"";
						String error_code		=	"";
						String sys_message_id	=	"";
						String error_text		=	"";
						String external_product_id ="";
						String route_color      =""; // added for CRF RUT-CRF-0034.1[IN:037389]-start
						String fntColor         ="";
						String backgrndColor    ="";// added for CRF RUT-CRF-0034.1[IN:037389]-end
					//GHL-CRF-0549  - start
						String bl_grp_app		   = "";
						HashMap selected_drug	= bean.getSelectedDrug();
						//GHL-CRF-0618 - start
						String formulary_code = "";
						 String blg_grp_type   = "";
						 String formulary_value   = "";
						//GHL-CRF-0618 - end
						
						String mm_item_low_cost_yn = "";	
						String mm_item_high_margin_yn = "";
						String mm_item_Innovator_yn = "";
						boolean matched_entry_flow = false;
						String low_cost_green_style ="visibility:none";
						String high_margin_green_style ="visibility:none";
						String strength_value="";//added for ghl-crf-0548
						String drug_strength_uom="";//added for GHL-CRF-0548
						String high_margin_red_style   ="visibility:none";
						String low_cost_red_style	="visibility:none";
						String low_cost_grey_style ="visibility:none";
						String high_margin_grey_style ="visibility:none";
						String innovator_style		="visibility:none";
						String item_type = "";
						String onClick1  = "";
						if(item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")))
						bl_grp_app = bean.getItemTypeApp(); 
						if(bl_grp_app.equals(""))
							bl_grp_app = "N";

						boolean disp_alt_window_flag = false;
						boolean mm_item_type_available  = true;
						//GHL-CRF-0618  - start
						boolean disp_non_preference_rem_window =false; 
						String preference = ""; //CRF-0618
						String preference_img = ""; //CRF-0618
						boolean non_preference_flag = false; //GHL-CRF-0618
						HashMap hm = null;
						ArrayList itemGenericType = null;

						if(formulary_billing_app){
							String blng_grp_id = bean.getBillingGrpId();
							formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
							//formulary_value = bean.getFormularyBillingGrpCode("CBSN");
							if(!formulary_value.equals("")){
								formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
								blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
							}
 							if(!formulary_code.equals("")){
							 hm = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"D");//blng_grp_id added for GHL-SCF-1527
							 itemGenericType = bean.getItemGenericType();
							}
							//System.err.println("itemType=546===>"+itemGenericType);
								
						} //GHL-CRF-0618  - end
							for (int i=1;i<arrList.size();i++){
							
							String[] strArray=(String[])arrList.get(i);
							//Added for TFS id:7345 start
							 disp_appl_for_pre_alloc =true;
							if(pre_alloc_appl){
							strArray=bean.getPreAllocatedDrug(strArray[33],order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
								if(strArray[34]!=null){
									if(strArray[34].equals(""))
									{
										strArray[34] = "T";
									}
									if(!(strArray[34].equals("T"))){  //Removed condition --> && strArray[20].equals("N") Condition added for MMS-QF-SCF-0686
										disp_appl_for_pre_alloc=false;
								
									} 
								}
							}
						//Added for TFS id:7345 end	
							//System.out.println("strArray"+strArray[32]);
							drug_code		= strArray[0];
							strength_value  = strArray[2];//added for ghl-crf-0548
							strength_value=strength_value.split(" ")[0];//added for ghl-crf-0548
							drug_strength_uom=strArray[32]==null?"":strArray[32];//added for ghl-crf-0548;
							if(search_by.equals("G")) {
								description	=	strArray[8];
								// Added for NMC-JD-CRF-0001 start
								if(display_generic_name_yn.equals("Y")){
								description1	=	strArray[1];
								}
								// Added for NMC-JD-CRF-0001 end
							}
							else {
								description	=	strArray[1];
								// Added for NMC-JD-CRF-0001 start
								if(display_generic_name_yn.equals("Y")){
								description1	=	strArray[8];
								}
								// Added for NMC-JD-CRF-0001 end
							}
							//Added for TFS id:7345 start
							if(pre_alloc_appl){
								if(disp_appl_for_pre_alloc){
									description	=	strArray[1];
									description1	=	strArray[8];
								}
								else{
									description	=	"";
									description1	=	strArray[8]+" "+ strArray[35]+" "+strArray[3];
								}
								
							}
							//Added for TFS id:7345 end
							//strArray[1]	=	java.net.URLEncoder.encode(strArray[1],"UTF-8"); Commneted for the issue num:25007 on 18/Nov/2010==By Sandhya
							
							if(strArray.length >= 14){
								in_formulary	= strArray[13];
							}
							else{
								in_formulary	= "N";
							}
							trade_code= strArray[10]==null?"":strArray[10];
							//if(trade_code ==null)
								//trade_code = "";

							trade_name=strArray[11];
							drug_class=strArray[21];
//consider_stock added during PE corrections by Naveen
							if(in_formulary.equals("Y")) {
								if (identity.equals("MedicationOrder")){
									if(order_type_code==null || order_type_code.equals(""))
										order_type_code = bean.getOrderTypeCode(drug_code);
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
							//GHL-CRF-0549  - start
							low_cost_green_style ="visibility:hidden";
							high_margin_green_style ="visibility:hidden";
							high_margin_red_style   ="visibility:hidden";
							low_cost_red_style	="visibility:hidden";
							low_cost_grey_style ="visibility:hidden";
							high_margin_grey_style ="visibility:hidden";
							innovator_style		="visibility:hidden"; 
							high_margin_grey_style = "visibility:hidden"; 
							low_cost_grey_style="visibility:hidden";
							//GHL-CRF-0549  - start
							route_color=strArray[31];// added for CRF RUT-CRF-0034.1[IN:037389]-start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
							        fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								 }
							}
							else{
									fntColor= "";
									backgrndColor= "";
							}// added for CRF RUT-CRF-0034.1[IN:037389]-end
		 //commented by naveen for PE correction on 5Apr2010
							//qty_uom				=	bean.getStockUOM(strArray[0]);
							if(strArray.length>26){
								qty_uom			=  strArray[27];
							}
							else{
								qty_uom				=	bean.getStockUOM(strArray[0]);
							}
							//Added if-else condition for external_product_id regarding incident:23572 on 1/Sept/2010
							if(strArray.length>26)
							external_product_id =strArray[28];
							else
							external_product_id="";	
							//ends
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
									onClick	=	"DrugSearchModify(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
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
							if(consider_stock.equals("Y")){ // if conditino added for NMC-JD-SCF-0022 [IN071220] and not null handled for DGB issue for the same scf
								if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){
									if(Float.parseFloat(avl_qty)>0){
									  stock_yn			=	"Y";
									}else{
										stock_yn		=	"N";
									}
								}
							}
							DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
							if(avl_qty != null && !avl_qty.equals("")){
								avl_qty = dfToInteger.format(Double.parseDouble(avl_qty));
							}
														
							error_code = strArray[17]==null?"":strArray[17];    
							sys_message_id = strArray[18]==null?"":strArray[18];
							error_text = strArray[19]==null?"":strArray[19]; 
							
							if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))&&(strArray[29].equals("Y"))){
								strEnableDisable	=	"disabled";
							}

            _bw.write(_wl_block32Bytes, _wl_block32);
if(disp_appl_for_pre_alloc){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(plus_sign));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mouse_over));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
}	//Modified for TFS id:7345 end
								if(identity.equals("MedicationOrder")){

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strArray[25]));
            _bw.write(_wl_block42Bytes, _wl_block42);

                                   if(bean_2.getExternalpatient_id() == null || bean_2.getExternalpatient_id().equals("")){			
										if(consider_stock.equals("Y") && (stock_yn.equals("") || stock_yn.equals("N"))) {
										//Added for TFS id:7345 start
											if(disp_appl_for_pre_alloc){
											

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
   
										}}//Added for TFS id:7345 end
										else { 

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);

										}	
									}
								}
								//GHL-CRF-0549  - start
								if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))  ){

									disp_alt_window_flag = false;
									mm_item_type_available  = true;
									item_type= bean.getItemType(drug_code);
									
									mm_item_low_cost_yn = item_type.split("~")[0];
									mm_item_high_margin_yn = item_type.split("~")[1];
									mm_item_Innovator_yn = item_type.split("~")[2];

								//	mm_item_low_cost_yn = "Y";
								//	mm_item_high_margin_yn = "N";
								//	mm_item_Innovator_yn = "Y"; 
								if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){
								mm_item_type_available = false;
								}
								//GHL-CRF-0618  - start
								if(formulary_billing_app){
									mm_item_type_available=true;
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									
								} //GHL-CRF-0618  - end

								//System.err.println("formulary_code====656=>"+formulary_code+"==blg_grp_type===>"+blg_grp_type);
					
								if(!bl_grp_app.equals("N")){
									disp_alt_window_flag = false;
									if(mm_item_low_cost_yn.equals("Y")) {
										if(bl_grp_app.equals("L")){
												low_cost_green_style ="visibility:visible";
												low_cost_red_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												
											if(mm_item_high_margin_yn.equals("Y")){
												high_margin_red_style = "visibility:visible";
												high_margin_green_style ="visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
											}else{
												high_margin_grey_style = "visibility:hidden";
											}
										}else{
											if(bl_grp_app.equals("H")){
												low_cost_green_style ="visibility:hidden";
												low_cost_red_style = "visibility:visible";
												low_cost_grey_style = "visibility:hidden";
											}
										} 
									}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:hidden";
											low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
											if(bl_grp_app.equals("H")){
												high_margin_green_style ="visibility:visible";
												high_margin_red_style = "visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")) {
												low_cost_red_style ="visibility:visible";
												low_cost_green_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												}

											}else{
												if(bl_grp_app.equals("L")){
													high_margin_red_style = "visibility:visible";
												}
											}
									}else{
										
											high_margin_green_style ="visibility:hidden";
											high_margin_red_style = "visibility:hidden";
											high_margin_grey_style = "visibility:hidden";
									}

									if(mm_item_Innovator_yn.equals("Y")){
											innovator_style		="visibility:visible";		
										}else{
											innovator_style		="visibility:hidden";		
										}
									}
								else{
									low_cost_green_style = "visibility:hidden";
									high_margin_green_style = "visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									high_margin_red_style = "visibility:hidden";

									if(mm_item_low_cost_yn.equals("Y"))
										low_cost_grey_style = "visibility:visible";		
									else
										low_cost_grey_style = "visibility:hidden";					
	
									if(mm_item_high_margin_yn.equals("Y"))
										high_margin_grey_style = "visibility:visible";
									else
										high_margin_grey_style = "visibility:hidden";
									
									if(mm_item_Innovator_yn.equals("Y"))
										innovator_style		="visibility:visible";		
									else
										innovator_style		="visibility:hidden";		
								}
								//GHL-CRF-0618 - start
								if(formulary_billing_app){
									preference = "";
									preference_img = "";
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									if(hm!=null && hm.size()>0){
									  if(itemGenericType!=null && itemGenericType.size()>0){
										if(itemGenericType.contains("D"))
											non_preference_flag = true;
									  }
										if(hm.containsKey(drug_code) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
											non_preference_flag = true;
											preference = (String)hm.get(drug_code)==null?"":(String)hm.get(drug_code);
											
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />"; 
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
											if(non_preference_flag && disp_appl_for_pre_alloc)//Modified for TFS id:7345
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
										}

									}
								}
								//GHL-CRF-0618 - end
								if(selected_drug!=null && selected_drug.containsKey(drug_code)){
//System.err.println("DrugNameCommonLookupResult.jsp========697===>"+drug_code);									
									disp_alt_window_flag = true;
								}
								if(low_cost_green_style.equals("visibility:visible") || high_margin_green_style.equals("visibility:visible")){
								 disp_alt_window_flag = true;
								}
								
								if(!disp_alt_window_flag){
									if(low_cost_red_style.equals("visibility:visible") || high_margin_red_style.equals("visibility:visible")){
									 disp_alt_window_flag = false;
									}else{
										disp_alt_window_flag = true;
									}


								
								}


								}
								//if(low_cost_green_style.equals("visibility:visible") || high_margin_green_style.equals("visibility:visible")){
								 //disp_alt_window_flag = true;
								//}
								//added for GHL-CRF-0618 - start

								if(formulary_billing_app){
									disp_alt_window_flag = true;
									disp_non_preference_rem_window = false;
									if (identity.equals("MedicationOrder")){
										
											if(( strArray[24].equals("Y")) && strArray[30].equals("N")){
												if(blg_grp_type.equals("C")) {
													if(!preference.equals("")  && preference.equals("P1")){
														disp_alt_window_flag = true;
												
													}else{
														if((preference.equals("") && non_preference_flag  ) || preference.equals("P2") || preference.equals("P3")){
															disp_alt_window_flag = false;
												
														}
													}
												}else if(blg_grp_type.equals("R")){
													if(!preference.equals("")  && preference.equals("P1")){
														disp_alt_window_flag = true;
													}else{
														if(non_preference_flag)
														disp_alt_window_flag = false;
													}
												
												}
										
										}

										if(!disp_alt_window_flag){
											if(blg_grp_type.equals("C")){
												disp_non_preference_rem_window = true;
											}else{
												if(!preference.equals("P1"))
													disp_non_preference_rem_window = true;
												
											}
										
										}else{
											if(blg_grp_type.equals("C")){
												if(!preference.equals("P1"))
													disp_non_preference_rem_window = true;
											}else if(blg_grp_type.equals("R") && !preference.equals("P1") && non_preference_flag)
											strEnableDisable = "disabled";	
										}
									}
								}

								//added for GHL-CRF-0618 - end
								if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app  && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))){

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
if(!low_cost_green_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(low_cost_green_style));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
}
								if(!high_margin_green_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(high_margin_green_style));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}if(!low_cost_red_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(low_cost_red_style));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
}if(!high_margin_red_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(high_margin_red_style));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
} if(!low_cost_grey_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(low_cost_grey_style));
            _bw.write(_wl_block61Bytes, _wl_block61);
} if(!high_margin_grey_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(high_margin_grey_style));
            _bw.write(_wl_block61Bytes, _wl_block61);
}if(!innovator_style.equals("visibility:hidden")){
								
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(innovator_style));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
}  	//GHL-CRF-0549  - end
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(strArray[5] ));
            _bw.write(_wl_block15Bytes, _wl_block15);

								if (strEnableDisable != null){
									if(!strEnableDisable.equals("disabled")){				
										//commented by naveen for PE correction on 5Apr2010
										//prompt_alert_check_YN = bean.getAlertForPreferredDrug_YN(drug_code)==null?"":bean.getAlertForPreferredDrug_YN(drug_code);
										if(strArray.length>26)
										   prompt_alert_check_YN = strArray[26];
										else
										   prompt_alert_check_YN =	bean.getAlertForPreferredDrug_YN(drug_code)==null?"":bean.getAlertForPreferredDrug_YN(drug_code);
										
										encounter_id = bean.getEncounterId();
										episodeType = bean.returnEpisodeType();
										episodeId = bean.returnEpisodeID(episodeType,encounter_id);
										visitId = bean.returnVisitID(episodeType,encounter_id);
										itemCode = drug_code;
										if (bl_install_yn.equals("Y") && identity.equals("MedicationOrder"))
											billingPreferenceCheckList = bean.returnBillingPreferenceCheckValues(facility_id, patient_id, episodeType, episodeId, visitId, encounter_id,drug_code);
										if(billingPreferenceCheckList != null && billingPreferenceCheckList.size()>0){
											billing_preference_check_YN = billingPreferenceCheckList.get(0)==null?"":billingPreferenceCheckList.get(0).toString();
											billingPrefereneBasisInd = billingPreferenceCheckList.get(1)==null?"":billingPreferenceCheckList.get(1).toString();
											billingPreferredItemCode	= billingPreferenceCheckList.get(2)==null?"":billingPreferenceCheckList.get(2).toString();
											billingPriority	= billingPreferenceCheckList.get(3)==null?"":billingPreferenceCheckList.get(3).toString();
										}
										if (identity.equals("MedicationOrder") ){
											if (billing_preference_check_YN.equals("Y")){ 
												if (prompt_alert_check_YN.equals("Y")){
													showAlert="showAlert(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
													 onClick = "";
												}
												 else {
													showAlert = "";
													onClick	=	"DrugSearchModify(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
												 }
											}
											else{
												showAlert = "";
											}
										}	
									//GHL-CRF-0549  - start
									String patientClass= bean.getPatientClass();//added for GHL-CRF-0619
										onClick1 = onClick;
										if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")) ){
										if(!disp_alt_window_flag){
											
										onClick1	=	"allowAlternateWindow('"+drug_code+"','"+java.net.URLEncoder.encode(store_desc,"UTF-8")+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"','"+strArray[9]+"','"+strArray[6]+"','"+identity+"','"+drug_class+"','"+order_type_code+"','"+store_code+"','"+patient_id+"','"+encounter_id+"','"+strength_value+"','"+drug_strength_uom+"','Y','"+item_type_site_app+"','"+strArray[9]+"','"+i+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+strArray[24]+"','"+strArray[30]+"','"+mm_item_type_available+"','"+formulary_billing_app+"');";//formulary_billing_app added for GHL-CRF-0618
										}
										else{
											if( non_preference_flag){ //GHL-CRF-0618  - start
											System.err.println("strArray[1]==>" + strArray[1] + "==drug_code==" + drug_code + "==after encounding==" + java.net.URLEncoder.encode(strArray[1],"UTF-8"));
												//added for GHL-CRF-0619
												if(blg_grp_type.equals("C")){
													if(disp_non_preference_rem_window){ //Modified for GHL-ICN-0086
														onClick1 = "if(checkBrand('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"')){"+"if(formularyNonPreference('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id_2+"','"+bean_name_2+"')){"+onClick+"}"+"}"; //MODIFIED FOR GHL-ICN-0090
													}else{
													
														onClick1 = "if( checkBrand('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"')){"+onClick+"}"; //MODIFIED FOR GHL-ICN-0090
													} //Modified for GHL-ICN-0086
													  
												}else{//GHL-CRF-0619 END
													if(disp_non_preference_rem_window){ //MODIFIED FOR GHL-SCF-1614
														onClick1 = "if(formularyNonPreference('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id_2+"','"+bean_name_2+"')){"+onClick+"}";
													}
												}//added for GHL-CRF-0619
											
											}else{  
												onClick1 = onClick;
											}
										
										}
										}
										//GHL-CRF-0549  - end
										//Modified for TFS id:7345 start
										if(!disp_appl_for_pre_alloc){

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block71Bytes, _wl_block71);
}else{ 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(showAlert));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(onClick1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
} 
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strArray[0]));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( description ));
            _bw.write(_wl_block87Bytes, _wl_block87);

											if(!strArray[11].equals("")){
												if(!(display_generic_name_yn.equals("Y")&&search_by.equals("G")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(strArray[11]));
            _bw.write(_wl_block89Bytes, _wl_block89);

											}}

            _bw.write(_wl_block90Bytes, _wl_block90);

										
										if(display_generic_name_yn.equals("Y")){ 
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(showAlert));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(onClick1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( description1 ));
            _bw.write(_wl_block93Bytes, _wl_block93);
if(!strArray[11].equals("")){
												if(search_by.equals("G")){
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strArray[11]));
            _bw.write(_wl_block95Bytes, _wl_block95);
}} 
            _bw.write(_wl_block96Bytes, _wl_block96);
} 
            _bw.write(_wl_block97Bytes, _wl_block97);
	
										if (identity.equals("MedicationOrder") ){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(billingErrorMsg));
            _bw.write(_wl_block1Bytes, _wl_block1);

												if (billingPreferenceCheckList != null && disp_appl_for_pre_alloc){//Modified for TFS id:7345	
													if(billing_preference_check_YN.equals("Y") ){
														preffered_drug_alert_text="<img src='../../ePH/images/Insurance.gif' height='15' width='15' style='cursor:pointer' onClick = showPreferredDrugs('"+drug_code+"','"+billingPrefereneBasisInd+"','"+billingPreferredItemCode+"','"+searchBasedOn+"','"+identity+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"','"+disp_charge_dtl_in_drug_lkp_yn+"','"+disp_price_type_in_drug_lkp+"','"+bl_install_yn+"','"+billingPriority+"'); />";
														
													} 
													else{
															preffered_drug_alert_text ="";
													}
												}
                                                //Added for IN069511 start
                                                if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345 //Modified for SKR-SCF-1631
	                                                  preffered_drug_alert_text=preffered_drug_alert_text + "&nbsp;<img src='../../ePH/images/ExternalDispensing.gif' height='18' width='20'/>"; 
                                                }
                                              //Added for IN069511 end
											  
											  

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(preffered_drug_alert_text));
            out.print( String.valueOf(preference_img));
            _bw.write(_wl_block101Bytes, _wl_block101);
                                 preffered_drug_alert_text="";//Added for IN069511
										}
										if(identity.equals("MedicationOrder")){

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strArray[20]));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strArray[22]));
            _bw.write(_wl_block108Bytes, _wl_block108);
										
												if(drug_db_interface_yn.equals("Y")){
													if(external_product_id!=null && disp_appl_for_pre_alloc ){//Modified for TFS id:7345
													

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(strArray[1],"UTF-8") ));
            _bw.write(_wl_block111Bytes, _wl_block111);

													}
												}

            _bw.write(_wl_block112Bytes, _wl_block112);

												if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
													if  (strArray[29].equals("Y")){
														if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
														}
														else{
															disp_str = "&nbsp";
														}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str =strArray[16] ;
													}
													else{
														disp_str = "&nbsp";
														if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))&&(strArray[29].equals("Y")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
														}
													}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
															//out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
														String check = error_text.replace("\n","");
														out.println("<script>");
														out.println("  var errorCode = '" + error_code + "';");
														out.println("  var errorText = '" + check + "';");
														out.println("  var sysMessageId = '" + sys_message_id + "';");
														out.println("  var iValue = '" + i + "';");
														out.println("  dispTitle(errorCode, errorText, sysMessageId, iValue);");
														out.println("</script>");
														}
													}
													else{

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block121Bytes, _wl_block121);

													}
												}
											}
										}
										else{

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strArray[0]));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf( description ));
            _bw.write(_wl_block128Bytes, _wl_block128);

											if(!strArray[11].equals("")){
												if(!(display_generic_name_yn.equals("Y")&&search_by.equals("G"))){

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(strArray[11]));
            _bw.write(_wl_block89Bytes, _wl_block89);

											}}

            _bw.write(_wl_block130Bytes, _wl_block130);
if(display_generic_name_yn.equals("Y")){ 
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strArray[0]));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf( description1 ));
            _bw.write(_wl_block132Bytes, _wl_block132);
if(!strArray[11].equals("")){
												if(search_by.equals("G")){
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(strArray[11]));
            _bw.write(_wl_block134Bytes, _wl_block134);
}} 
            _bw.write(_wl_block135Bytes, _wl_block135);
}
											
										if (identity.equals("MedicationOrder") ){ // if else Added for IN069511 - DGB issues start

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block136Bytes, _wl_block136);
										
                                                
										
                                                if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345 //Modified for SKR-SCF-1631
	                                                  preffered_drug_alert_text=preffered_drug_alert_text+"&nbsp;<img src='../../ePH/images/ExternalDispensing.gif' height='18' width='20'/>";
                                                }                                             

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(preffered_drug_alert_text));
            out.print( String.valueOf(preference_img));
            _bw.write(_wl_block137Bytes, _wl_block137);
                                 preffered_drug_alert_text="";} else{ 
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block138Bytes, _wl_block138);
} // if else Added for IN069511 - DGB issues end  
											if(identity.equals("MedicationOrder")){

            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strArray[20]));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strArray[22]));
            _bw.write(_wl_block108Bytes, _wl_block108);

													if(drug_db_interface_yn.equals("Y")){
														if(external_product_id!=null && disp_appl_for_pre_alloc ){//Modified for TFS id:7345

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( java.net.URLEncoder.encode(strArray[1],"UTF-8") ));
            _bw.write(_wl_block143Bytes, _wl_block143);

														}
													}

            _bw.write(_wl_block112Bytes, _wl_block112);

												if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
													if(strArray[29].equals("Y")){
														if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
														}
														else{
															disp_str = "&nbsp";
														}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block115Bytes, _wl_block115);

													if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str =strArray[16] ;
													}
													else{
														disp_str = "&nbsp";

														if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))&&(strArray[29].equals("Y")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
														}
														else{
															disp_str = "&nbsp";
														}
													}

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block144Bytes, _wl_block144);

													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														//out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
														String check = error_text.replace("\n","");
														out.println("<script>");
														out.println("  var errorCode = '" + error_code + "';");
														out.println("  var errorText = '" + check + "';");
														out.println("  var sysMessageId = '" + sys_message_id + "';");
														out.println("  var iValue = '" + i + "';");
														out.println("  dispTitle(errorCode, errorText, sysMessageId, iValue);");
														out.println("</script>");

		
													}
												}
												else{

            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block121Bytes, _wl_block121);

												}
											}
										}										
									}
								}

								if (strArray[2] != null){
									if (!strArray[2].equals("0")){
										if(!strEnableDisable.equals("disabled")){
										str_click	=	"DrugSearchModify(eval(document.getElementById('drug_name"+i+"')),'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
											font_class	=	"class='HYPERLINK' onMouseOver='changeCursor(this);'";
										} else {
											str_click	=	"";
											font_class	=	"style='font-size:11'";
										}
										
										/* Commented By Sandhya on 20/sep/2010 for the incidents-23841,23724,23792.from line num:833 to  870
										StringTokenizer st =new StringTokenizer(strArray[2]," ");
										if (st.hasMoreTokens()){  //
											qtyString1 = st.nextToken();
										
											if(qtyString1!=null && !qtyString1.equals("") && Float.parseFloat(qtyString1) <1)
												qtyString1 = Float.parseFloat(qtyString1)+"";
											
											int cnt = st.countTokens();
											if(cnt>3){
												uomDesc1   = st.nextToken();
												qtySymbol  = st.nextToken();
												qtyString2 = st.nextToken();
												if(qtyString2!=null && !qtyString2.equals("") && Float.parseFloat(qtyString2) <1)
													qtyString2 = Float.parseFloat(qtyString2)+"";
												
												uomDesc2   = st.nextToken();
												}
												else
												{
												uomDesc1   = "";
												qtySymbol  = "";
												qtyString2 = "";
												uomDesc2   = "";
											}
										}*/
										//commented for PE by Naveen
										/* if (!(uomDesc1.equals(""))){
											  uomDesc1 = bean.getUomDisplay(facility_id,uomDesc1);						 
										}
										if (!(uomDesc2.equals(""))){
											  uomDesc2 = bean.getUomDisplay(facility_id,uomDesc2);						 
										}*/
									  
									
										if(formulary_billing_app){ //GHL-CRF-0618
											str_click = "";
										}

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(str_click));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(font_class));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(strArray[2]));
            _bw.write(_wl_block150Bytes, _wl_block150);

									}
									else{

            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block152Bytes, _wl_block152);

									}
/**
				* @Name - Krishna Kiran 
				* @Date - 15/02/2010
				* @Inc# - 
				* @Desc - added the lines of code to fix the issue as the strength value is overriding for the other drugs .
*/
									uomDesc1   = "";
									qtySymbol  = "";
									qtyString2 = "";
									uomDesc2   = "";
									qtyString1 = "";
								}

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strArray[7] ));
            _bw.write(_wl_block155Bytes, _wl_block155);

								if (identity.equals("MedicationOrder") ){
									//GHL-CRF-0618 - start
									if(formulary_billing_app){
										if((!preference.equals("") && !preference.equals("P1")) ||  ( !preference.equals("P1") && non_preference_flag) ){
											strEnableDisable  = "disabled";
										}
									} 
									//GHL-CRF-0618 - end
									if (ht.containsKey( strArray[0]+i)){
										if(( strArray[24].equals("Y")) && strArray[30].equals("N") && disp_appl_for_pre_alloc){ //strArray[30] - NPB_DRUG_YN //strArray[23].equals("Y") || Removed for ghl-crf-0548,Modified for TFS id:7345

            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc,"UTF-8")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(strArray[1],"UTF-8")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strArray[9]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strArray[6]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(identity));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( patient_id));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_strength_uom));
            _bw.write(_wl_block159Bytes, _wl_block159);
 
										}
										else{

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block160Bytes, _wl_block160);
									
										}
										if(consider_stock.equals("Y")) {
											//Modified for IN069511 START
											if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start
											if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block165Bytes, _wl_block165);
} else{
												
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(strArray[1],"UTF-8")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc)));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block15Bytes, _wl_block15);
}                                            //Modified for IN069511 END
										}
											else if(disp_locn_select_appl){ //Added for TFS id:-16341 start
												if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631
													if(avl_qty.equals("0")){
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block171Bytes, _wl_block171);
}
												else{
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block172Bytes, _wl_block172);
 }
											}else{ 
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block174Bytes, _wl_block174);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block175Bytes, _wl_block175);
}//Added for TFS id:-16341 end
											else{
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block175Bytes, _wl_block175);
}} 
											//Modified for TFS id:7345 end
										if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	
											if (prompt_alert_check_YN.equals("Y") && billing_preference_check_YN.equals("Y")){
												showAlertOncheck = "showAlertOnCheck("+i+",drug_code"+i+");";
												storeSelectedDrugs = "";
											}
											else{
												showAlertOncheck = "";
												storeSelectedDrugs = "storeSelectedDrugs("+i+",drug_code"+i+");";
											}
											if( !drugorfluid.equals("CO") ){
												if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start

            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(showAlertOncheck));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(storeSelectedDrugs));
            _bw.write(_wl_block180Bytes, _wl_block180);
} else{ 
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block182Bytes, _wl_block182);

												}}//Modified for TFS id:7345 end
										}
									}
									else{
										if(( strArray[24].equals("Y")) && strArray[30].equals("N") && disp_appl_for_pre_alloc){ //strArray[30] - NPB_DRUG_YN //strArray[23].equals("Y") || Removed for ghl-crf-0548,Modified for TFS id:7345

            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc,"UTF-8")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( java.net.URLEncoder.encode(strArray[1],"UTF-8") ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strArray[9]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strArray[6]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(identity));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( patient_id));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_strength_uom));
            _bw.write(_wl_block185Bytes, _wl_block185);
 
										}
										else{

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block160Bytes, _wl_block160);

										}
										if(consider_stock.equals("Y")) { 
											if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start
											if( bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){
												//Modified for IN069511 START
												if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631

            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block188Bytes, _wl_block188);
 }else{
												
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(strArray[1], "UTF-8")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc, "UTF-8")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block192Bytes, _wl_block192);
	}//Modified for IN069511 END
											}
										}
											else if(disp_locn_select_appl){//Added for TFS id:-16341 start
												if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631
													if(avl_qty.equals("0")){
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block194Bytes, _wl_block194);
}
													else{
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block195Bytes, _wl_block195);
 }
												}else{ 
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block174Bytes, _wl_block174);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block175Bytes, _wl_block175);
}
											else{
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block175Bytes, _wl_block175);
}//Modified for TFS id:7345 end
										}	
										if(strChecked.equals("checked")) { 
											strEnableDisable  = "disabled";
										}
										if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	
											if (prompt_alert_check_YN.equals("Y") && billing_preference_check_YN.equals("Y")){
												showAlertOncheck = "showAlertOnCheck("+i+",drug_code"+i+");";
												storeSelectedDrugs = "";
											}
											else{
												showAlertOncheck = "";
												storeSelectedDrugs = "storeSelectedDrugs("+i+",drug_code"+i+");";
											}
											if( !drugorfluid.equals("CO") ){
												if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start

            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(showAlertOncheck));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(storeSelectedDrugs));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(strEnableDisable));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(strChecked));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(alternateDisable ));
            _bw.write(_wl_block200Bytes, _wl_block200);
}else{ 
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(strEnableDisable));
            _bw.write(_wl_block204Bytes, _wl_block204);

												}}//Modified for TFS id:7345 end
										}
									}
								 }

            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strArray[12]));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(i));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strArray[9]));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(i));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(i));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strArray[8]));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(i));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(i));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(description));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block215Bytes, _wl_block215);
				
							}
						}
						else if(arrList==null || arrList.size()<1 || !arrList.get(0).equals("cancel")){

            _bw.write(_wl_block216Bytes, _wl_block216);

						}

            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(identity));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(drugorfluid));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(res_by_service));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(Classification));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block225Bytes, _wl_block225);

					if (identity.equals("MedicationOrder") && arrList.size()>1){

            _bw.write(_wl_block226Bytes, _wl_block226);

									if(consider_stock.equals("Y")) { 
										if(bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){

            _bw.write(_wl_block227Bytes, _wl_block227);

										}
										else{

            _bw.write(_wl_block228Bytes, _wl_block228);

										}

            _bw.write(_wl_block229Bytes, _wl_block229);

										if(bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){

            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

										}
										else{

            _bw.write(_wl_block232Bytes, _wl_block232);

										}

            _bw.write(_wl_block233Bytes, _wl_block233);

									}

            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);
if(ext_disp_appl && !(bean.getcalledfrom().equals("DIRECT"))){ 
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);
} 
            _bw.write(_wl_block239Bytes, _wl_block239);
								//GHL-CRF-0549  - start
								if(bl_install_yn.equals("Y") && normalRx_yn!=null && normalRx_yn.equals("Y") && 		item_type_site_app && !formulary_billing_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))){ 	 
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
} 	//GHL-CRF-0549  - end
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(enableDisable));
            _bw.write(_wl_block246Bytes, _wl_block246);
if(formulary_billing_app)  //Start of GHL-CRF-0618
						{
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);

							}
            _bw.write(_wl_block252Bytes, _wl_block252);

					}

            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(priviligeCheck_fromSearch));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(disp_charge_dtl_in_drug_lkp_yn));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(disp_price_type_in_drug_lkp));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(priviligeCheck_fromSearch));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(bean.getSearchBy()));
            _bw.write(_wl_block259Bytes, _wl_block259);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_2,bean_2,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{ 
        	if(con != null)
          		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
	}

            _bw.write(_wl_block260Bytes, _wl_block260);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ItemType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Information.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Pay.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reimburse.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.National.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitPrice.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminRoute.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Quantity/Uom.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoStockinDispenseLocation.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferredDrugs CoveredUnderPolicy.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExternalDispensing.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LowCostItem.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.HighMarginItem.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Innovator.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferedItem1.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferedItem2.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferedItem3.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NonPreferedItem.label", java.lang.String .class,"key"));
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
}
