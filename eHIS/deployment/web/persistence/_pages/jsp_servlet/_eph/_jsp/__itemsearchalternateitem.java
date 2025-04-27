package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.beans.Visibility;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __itemsearchalternateitem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ItemSearchAlternateItem.jsp", 1737950382687L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\n\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/ConsumableOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n        <title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</title>\n\t\t<body OnMouseDown=\'\' onKeyDown = \'lockKey()\'>\n\t\t\t<form name=\"frmAltItemSearchAlternateItemResult\" id=\"frmAltItemSearchAlternateItemResult\">\t\n\t\t<div class=\"outer-container\">\n\t\t<div class=\"top-section\">\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\n\t\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\"center\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td width=\"25%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t    \t\t\t\t\t\t   \n\t\t\t\t\t\t\t<td width=\"10%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"25%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"2%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" width=\'10%\' align=\"right\">\n\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;color:black;font-weight:normal\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</label>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\'1%\' align=\"right\">\n\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCostGreen.jpg\' height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  title=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t      ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCostRed.jpg\'  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' title=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCost.jpg\' title=\"Low Cost Item\"  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t       ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCost.jpg\' title=\"Low Cost Item\"  height=\'15\' width=\'15\' style=\'visibility:hidden\'>&nbsp;\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t           <img src=\'../../ePH/images/HighMarginGreen.jpg\'  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t        ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t           <img src=\'../../ePH/images/HighMarginRed.jpg\'  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/HighMargin.jpg\' title=\"High Margin Item\" height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/HighMargin.jpg\'  height=\'15\' width=\'15\' style=\'visibility:hidden\'>&nbsp;\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" \n\t\t\t\t\t\t\t\t\t\t  <img src=\'../../ePH/images/Innovator.jpg\' title=\"Innovator Item\"  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>&nbsp;\n\t\t\t\t                 ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t               \t\t\t  <img src=\'../../ePH/images/Innovator.jpg\' title=\"Innovator Item\" height=\'15\' width=\'15\' style=\'visibility:hidden\'>&nbsp;\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t<td id=\"item";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" title=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onclick=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"> <!-- modified for GHL-CRF-0618-->\n\t\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</font>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t<td id=\"item";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\t\t\t\t<font class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</font>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" onclick=\"disableClick(event);\">\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;color:black;font-weight:normal\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_item_code";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"hdn_item_code";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_line_no";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"hdn_line_no";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_trade_code";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"hdn_trade_code";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"trade_code";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_trade_name";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"hdn_trade_name";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =")</label>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="                                </td>     \n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n<!-- ============================================================================================================= -->\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" align=\"center\" title=\'\' id=\'BL_ERROR";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'> ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" align=\"right\"><label>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&nbsp;</label></font></td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t<input type=\"hidden\" name=\"hdn_from\" id=\"hdn_from\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"hdn_to\" id=\"hdn_to\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"hdn_bean_id\" id=\"hdn_bean_id\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"hdn_bean_name\" id=\"hdn_bean_name\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_disp_charge_dtl_in_drug_lkp_yn\" id=\"bl_disp_charge_dtl_in_drug_lkp_yn\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_disp_price_type_in_drug_lkp\" id=\"bl_disp_price_type_in_drug_lkp\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"store_name\" id=\"store_name\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n         </div>\n          ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n            <div class=\"top-section\" style=\'width:810px;height:20px;\'>\n              <table border=\"1\" width=\"100%\" cellpadding=\"1\" cellspacing=\"1\" align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t<td align=\"right\" class=\"white\"><img src=\'../../ePH/images/LowCost.jpg\'  height=\'15\' width=\'15\' ></td>\n\t\t\t\t<td class=\"white\" align=\"left\">";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t<td align=\"right\" class=\"white\"><img src=\'../../ePH/images/HighMargin.jpg\'  height=\'15\' width=\'15\' ></td>\n\t\t\t\t<td class=\"white\" align=\"left\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" </td>\n\t\t\t\t<td align=\"right\" class=\"white\"><img src=\'../../ePH/images/Innovator.jpg\'  height=\'15\' width=\'15\' ></td>\n\t\t\t\t<td class=\"white\" align=\"left\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" </td>\n\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t<td class=\'white\' ></td>\t\n\t\t\t <td class=\"white\" align=\"left\">\n\t\t\t\t\t<img src=\"../../ePH/images/Preference1.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t<td class=\"white\" align=\"left\">\n\t\t\t\t\t<img src=\"../../ePH/images/Preference2.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&nbsp;</td>\n\t\t\t\t\n\t\t\t\t<td class=\"white\" align=\"left\">\n\t\t\t\t\t<img src=\"../../ePH/images/Preference3.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&nbsp;</td>\n\t\t\t\t\n\t\t\t\t<td class=\"white\" align=\"left\">\n\t\t\t\t\t<img src=\"../../ePH/images/Preference4.jpg\"  height=\'15\' width=\'15\' >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"white\" align=\"left\" nowrap>&nbsp;";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="&nbsp;</td>\n\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t </table>         \n         </div>\n         ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n         </div>\n         \n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n</html>\n\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
07/01/2019		IN068344		    Devindra				 		                    Required indication of different item types during dispense/order 
29/05/2020	IN:072092	        Manickavasagam J			     GHL-CRF-0618                                                                                        according to patient billing group.
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try{		
		String	bl_disp_charge_dtl_in_drug_lkp_yn	=	request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn");
		String	bl_disp_price_type_in_drug_lkp		=	request.getParameter("bl_disp_price_type_in_drug_lkp")==null?"":request.getParameter("bl_disp_price_type_in_drug_lkp");
		String	bl_install_yn			=	request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String	item_code				=	request.getParameter("item_code")==null?"":request.getParameter("item_code");		
		String	priority				=	request.getParameter("priority")==null?"":request.getParameter("priority");
		String	take_home_medication	=	request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String 	store_name				=	request.getParameter("store_name")==null?"":request.getParameter("store_name"); 
		String 	disp_locn_code			=	request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");		
		String item_tech_code           =  	request.getParameter("item_tech_name")==null?"":request.getParameter("item_tech_name");
		String encounter_id             =   request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String	patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String bean_id		    = "@ConsumableOrderBean"+patient_id+encounter_id;
		String bean_name		= "ePH.ConsumableOrderBean";				
		ConsumableOrderBean bean=	(ConsumableOrderBean)getBeanObject( bean_id, bean_name, request ) ;
		
			
		
		String	drug_bean_id		=	"@DrugSearchBean";
		String	drug_bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean drug_bean		=	(DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ;
		String from				=	request.getParameter("hdn_from")==null?"":request.getParameter("hdn_from");
		String to				=	request.getParameter("hdn_to")==null?"":request.getParameter("hdn_to");	
		String	act_patient_class	=	request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");		
		String	consider_stock	=	"";
		String	allow_pres_without_stock_yn	=	"";
		ArrayList stock_params	=	drug_bean.validateForStock();
		String allow_alt_for_med_item = bean.getAllowAltForMedItem();
		String  billing_group  =bean.getBillingType(act_patient_class,encounter_id);
		Connection connection = null; 
		bean.setActPatientClass(act_patient_class);
		bean.setPatientId(patient_id);
		bean.setEncounterId(encounter_id);
	    boolean item_type_yn  = false;
	    //GHL-CRF-0618 - start
		boolean formulary_billing_app = false;
		String onClick = "";
		String onClick1 = "";
		//GHL-CRF-0618 - end
		try {
			  connection = ConnectionManager.getConnection(request);
			  item_type_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ITEM_TYPE_APP");
	  		  formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
		}
		catch(Exception e) {
			  out.print("Exception @ Result JSP :"+e.toString());
			  e.printStackTrace();
		}
		finally{		
			if(connection != null)
			  ConnectionManager.returnConnection(connection,request);
		} 
		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			allow_pres_without_stock_yn		= (String)stock_params.get(1);
		} 
		ArrayList arrList		=	null;
        try{		
			arrList	= (ArrayList)bean.searchForAltItems(from,to, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication,priority,item_code,item_tech_code,formulary_billing_app);

		}
		catch (Exception e){
			e.printStackTrace();
		}
		

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block12Bytes, _wl_block12);

				
					String classvalue		= "";
					String disp_str			= "";
					item_code		= "";
					String item_desc = "";
					String trade_code		= "";
					String trade_name		= "";
					String stock_yn			= "";
					String item_tech_name   = "";
					String avl_qty			= "";
					String uom_code			= "";
					String uom_desc			= "";
					String store_code		= "";
					String store_desc		= "";
					String bl_reimburse_yn	="";
					String bl_imported_yn	= "";
					String bl_unit_price	= "";
					String bl_sys_message_id = "";
					String bl_error_code	="";
					String bl_error_text	="";
					String strEnableDisable	="";
					String alert_for_preferred_item_YN	="";
					String bl_preference_check_YN		="";
					String bl_preference_basis_ind		="";
					String bl_preference_item_code		="";
					String promptAlert_onclick_of_item	="";
					String preferred_item_text			="";
					String bl_preference_priority		="";
					String  low_cost_item               ="";
					String  innovator_item              ="";
					String  high_margin_item            =""; 
					String low_cost_item_visibility    ="";
					String innovator_item_visibility    ="";
					String high_margin_item_visibility    ="";

            _bw.write(_wl_block13Bytes, _wl_block13);
								

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(item_type_yn && bl_install_yn.equals("Y")){  
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}   
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

								if(formulary_billing_app){	//GHL-CRF-0618 

            _bw.write(_wl_block20Bytes, _wl_block20);
								}
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

							}                            

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
							                       
							//GHL-CRF-0618 - start
							String preference = "";  
							String preference_img = ""; 
							String formulary_code  = "";
							String blg_grp_type = "";
							boolean non_preference_flag = false;
							HashMap hmBlgGrp = null;
							ArrayList itemGenericType = null;
							if(formulary_billing_app){
								String blng_grp_id = bean.getBillingGrpId();//added for GHL-SCF-1527
								billing_group = "";
								non_preference_flag = false;
								formulary_code = bean.getFormularyCode();
								blg_grp_type = bean.getFormularyBlngGrpType();
								if(!formulary_code.equals("")){
								 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"M"); //blng_grp_id added for GHL-SCF-1527
 								 itemGenericType = bean.getItemGenericType();

								}
							}
						//GHL-CRF-0618  - end
                          if(arrList!=null && arrList.size()>0){ 
                              for (int i=0;i<arrList.size();i++){ 
                            	HashMap hmItemDetails= new HashMap();              					
                            	                ArrayList existingList = null;
                            	                existingList = bean.getPresItemList();                            	                            	
            					ArrayList existingCodes = new ArrayList();            					
            					hmItemDetails = (HashMap)arrList.get(i);
            					if(existingList!=null && existingList.size()>0){
            						for(int j=0; j<existingList.size(); j++){
            							hmItemDetails = (HashMap)existingList.get(j);            							
            							existingCodes.add(hmItemDetails.get("ITEM_CODE"));
            						}
            						hmItemDetails = null;
            					}
								strEnableDisable = "";
								hmItemDetails = (HashMap)arrList.get(i);
								item_code			= (String)hmItemDetails.get("ITEM_CODE")==null?"":(String)hmItemDetails.get("ITEM_CODE"); 								
			                        if(existingCodes.contains(item_code)){
						       strEnableDisable = "disabled";
						}
								item_desc			= (String)hmItemDetails.get("ITEM_DESC")==null?"":(String)hmItemDetails.get("ITEM_DESC");        
								trade_code			= (String)hmItemDetails.get("TRADE_CODE")==null?"":(String)hmItemDetails.get("TRADE_CODE");       
								trade_name			= (String)hmItemDetails.get("TRADE_NAME")==null?"":(String)hmItemDetails.get("TRADE_NAME");       
								stock_yn			= (String)hmItemDetails.get("STOCK_YN")==null?"":(String)hmItemDetails.get("STOCK_YN");          
								avl_qty				= (String)hmItemDetails.get("AVAIL_QTY")==null?"0":(String)hmItemDetails.get("AVAIL_QTY"); 
								uom_code			= (String)hmItemDetails.get("UOM_CODE")==null?"":(String)hmItemDetails.get("UOM_CODE"); 
								uom_desc			= (String)hmItemDetails.get("UOM_DESC")==null?"":(String)hmItemDetails.get("UOM_DESC"); 
								item_tech_name      = (String)hmItemDetails.get("TECH_NAME")==null?"":(String)hmItemDetails.get("TECH_NAME");
								/*=============================================================================================*/								
								if(disp_locn_code!=null && !(disp_locn_code.equals("")))
									store_code = disp_locn_code;
								else 
									store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");
								if(store_name!=null && !(store_name.equals("")))
									store_desc = store_name;
								else
									store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC"); 
																
								/*=============================================================================================*/
								           
								bl_reimburse_yn		= (String)hmItemDetails.get("BL_REIMBURSE_YN")==null?"":(String)hmItemDetails.get("BL_REIMBURSE_YN");     
								bl_imported_yn		= (String)hmItemDetails.get("BL_IMPORTED_YN")==null?"":(String)hmItemDetails.get("BL_IMPORTED_YN");    
								bl_unit_price		= (String)hmItemDetails.get("BL_UNIT_PRICE")==null?"":(String)hmItemDetails.get("BL_UNIT_PRICE");    
								bl_sys_message_id	= (String)hmItemDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)hmItemDetails.get("BL_SYS_MESSAGE_ID"); 
								bl_error_code		= (String)hmItemDetails.get("BL_ERROR_CODE")==null?"":(String)hmItemDetails.get("BL_ERROR_CODE");       
								bl_error_text		= (String)hmItemDetails.get("BL_ERROR_TEXT")==null?"":(String)hmItemDetails.get("BL_ERROR_TEXT");    
								alert_for_preferred_item_YN		= (String)hmItemDetails.get("PROMPT_ALERT_PREFERRED_DRUG")==null?"":(String)hmItemDetails.get("PROMPT_ALERT_PREFERRED_DRUG");    
								bl_preference_check_YN		= (String)hmItemDetails.get("BL_PREFERENCE_CHECK_YN")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_CHECK_YN");    
								bl_preference_basis_ind		= (String)hmItemDetails.get("BL_PREFERENCE_BASIS_IND")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_BASIS_IND");    
								bl_preference_item_code		= (String)hmItemDetails.get("BL_PREFERENCE_ITEM_CODE")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_ITEM_CODE");  
								bl_preference_priority	= (String)hmItemDetails.get("BL_PREFERENCE_PRIORITY")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_PRIORITY");  
								low_cost_item  = (String)hmItemDetails.get("LOW_COST_ITEM")==null?"":(String)hmItemDetails.get("LOW_COST_ITEM");								
								high_margin_item = (String)hmItemDetails.get("HIGH_MARGIN_ITEM")==null?"":(String)hmItemDetails.get("HIGH_MARGIN_ITEM");
								innovator_item = (String)hmItemDetails.get("INNOVATOR_ITEM")==null?"":(String)hmItemDetails.get("INNOVATOR_ITEM");
								if(high_margin_item.equals("Y")){
								   bean.setItemTypeForSelectedDrug(item_code+"H"); 
								}
								if(low_cost_item.equals("Y")){
									   bean.setItemTypeForSelectedDrug(item_code+"L"); 
								}
								if(innovator_item.equals("Y")){ // Added for AMS-CRF-0204 - Start
									   bean.setItemTypeForSelectedDrug(item_code+"I"); 
								} // Added for AMS-CRF-0204 -End
								if(item_type_yn && bl_install_yn.equals("Y")){
									high_margin_item_visibility = "";
									low_cost_item_visibility = "";
									innovator_item_visibility = "";
									
								   if(low_cost_item.equals("Y")){
									low_cost_item_visibility = "visible";
								   }
								   if(high_margin_item.equals("Y")){
									   high_margin_item_visibility = "visible";
								   }
								   if(innovator_item.equals("Y")){
									   innovator_item_visibility="visible";
								   }
								   								  
								}
																
								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										strEnableDisable = "disabled";
									}
								}								
								double avl_qty_1=Double.parseDouble(avl_qty);
								String allow_without_stock = "";

                                if( consider_stock.equals("Y") ) {
				                   if(avl_qty_1<=0)
					                  avl_qty_1	= 0.0;
				                   if( allow_pres_without_stock_yn.equals("N") && avl_qty_1<=0)
					                    allow_without_stock="disabled";
				              else
					                    allow_without_stock="enabled";
			                   }
			                  else {
				                 allow_without_stock="enabled";
			                  }
								


            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(item_tech_name));
            _bw.write(_wl_block27Bytes, _wl_block27);

							if(item_type_yn && bl_install_yn.equals("Y")){

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(low_cost_item_visibility.equalsIgnoreCase("visible")){ 
							           if(billing_group.equals("L")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(low_cost_item_visibility));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
							           else if(billing_group.equals("H")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(low_cost_item_visibility));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
} else{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(low_cost_item_visibility));
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);
  }
							       else{ 
            _bw.write(_wl_block39Bytes, _wl_block39);
} 
							    if(high_margin_item_visibility.equalsIgnoreCase("visible")){ 
							             if(billing_group.equals("H")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(high_margin_item_visibility));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
							            else if(billing_group.equals("L")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(high_margin_item_visibility));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
} else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(high_margin_item_visibility));
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);
  }
							       else{ 
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
							    if(innovator_item_visibility.equalsIgnoreCase("visible")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(innovator_item_visibility));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
							    else{ 
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

                            } 

            _bw.write(_wl_block48Bytes, _wl_block48);
 								if(formulary_billing_app){//GHL-CRF-0618 - start
									preference_img = "";
									preference = "";
									//System.err.println("drug_code=========>"+item_code+"==hmBlgGrp===>"+hmBlgGrp);
										if(hmBlgGrp!=null && hmBlgGrp.size()>0){
											if(itemGenericType!=null && itemGenericType.size()>0){
												if(itemGenericType.contains("M"))
													non_preference_flag = true;
										  }

										if(hmBlgGrp.containsKey(item_code)){
											non_preference_flag = true;
											preference = (String)hmBlgGrp.get(item_code)==null?"":(String)hmBlgGrp.get(item_code);
											
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item'/>";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item'/>";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item'/>";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item'/>";
											}
										}/*else{
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' 	width='15' title='Non Prefered Item'/>";
										} */

									}/*else{
										preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item'/>";
									} */
								} //GHL-CRF-0618 - end
			
								if (!(strEnableDisable.equals(""))){
										preferred_item_text="";
									}								
								if(strEnableDisable.equals("")){
										strEnableDisable	=	allow_without_stock;
									
								}
								if(item_type_yn){ //GHL-CRF-0618 - start
									onClick1 =  "selectAltItem('"+i+"','"+promptAlert_onclick_of_item+"')";
										if(formulary_billing_app){
											if(non_preference_flag){
											if(blg_grp_type.equals("C")){
												if(preference.equals("") || !preference.equals("P1")){
													//onClick1 = "if(formularyNonPreference('"+item_code+"')){"+onClick1+"}";
													onClick1 = "if(formularyNonPreference('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"')){"+onClick1+"}";
												}
											}else{
												if(preference.equals("") || !preference.equals("P1")){
												strEnableDisable = "disabled";
												onClick1		=	"";
												}
											}
											}
										}
								} //GHL-CRF-0618 - end

								if (strEnableDisable != null){
									if(!strEnableDisable.equals("disabled")){
										
									if(item_type_yn){

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(onClick1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
                                      }
								}
								else{
									if(item_type_yn){

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( item_desc ));
            _bw.write(_wl_block60Bytes, _wl_block60);
} else{ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( item_desc ));
            _bw.write(_wl_block62Bytes, _wl_block62);
   }
									}
								}

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block73Bytes, _wl_block73);

									if(!trade_name.equals("")){

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block75Bytes, _wl_block75);

									}

            _bw.write(_wl_block76Bytes, _wl_block76);
								//GHL-CRF-0618 - start
									if(formulary_billing_app){

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(preference_img));
            _bw.write(_wl_block79Bytes, _wl_block79);
								} //GHL-CRF-0618 - end

            _bw.write(_wl_block80Bytes, _wl_block80);
			


								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									
									if(!bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = (String)hmItemDetails.get("BL_UNIT_PRICE") ;
									}
									else{
										disp_str = "&nbsp";

										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
										}
									}

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block84Bytes, _wl_block84);

									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										out.println("<script>dispTitle('"+bl_error_code+"','"+bl_error_text+"','"+bl_sys_message_id+"','"+i+"');</script>");
									}
								}                           

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block86Bytes, _wl_block86);

						}

            _bw.write(_wl_block87Bytes, _wl_block87);
														
	}				
				bean.setDispPriceTypeinDrugLKPYN(bl_disp_price_type_in_drug_lkp);
				bean.setDispChargeDtlInDrugLKPYN(bl_disp_charge_dtl_in_drug_lkp_yn);
				bean.setBillInstallYN(bl_install_yn);			
				bean.setTakeHomeMedication(take_home_medication);

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bl_disp_charge_dtl_in_drug_lkp_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bl_disp_price_type_in_drug_lkp));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(store_name));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(item_type_yn ){ 
            _bw.write(_wl_block100Bytes, _wl_block100);
if(!formulary_billing_app){
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

				}else{ 
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
}
				
            _bw.write(_wl_block110Bytes, _wl_block110);
} 
            _bw.write(_wl_block111Bytes, _wl_block111);

	putObjectInBean(bean_id,bean,request); 
}
catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block112Bytes, _wl_block112);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugsfor.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ItemTechname.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ItemType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitPrice.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LowCostItem.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.HighMarginItem.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Innovator.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferedItem1.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferedItem2.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreferedItem3.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NonPreferedItem.label", java.lang.String .class,"key"));
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
}
