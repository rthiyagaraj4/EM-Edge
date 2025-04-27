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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __comsumableorderitemlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ComsumableOrderItemLookupResult.jsp", 1742365476453L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\n\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/ConsumableOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body OnMouseDown=\'\' onKeyDown = \'lockKey()\'>\n\t\t\t<form name=\"frmItemNameCommonLookupResult\" id=\"frmItemNameCommonLookupResult\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\"center\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"1%\" class=\'COLUMNHEADER\'>&nbsp;</td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<td width=\"6%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<td  class=\"COLUMNHEADER\" width=\"2%\"  style=\"font-size:9\" >&nbsp;</td><!-- added for GHL-CRF-0618 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"50%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t <td width=\"4%\" class=\'COLUMNHEADER\'>&nbsp;</td>\n\t\t\t\t\t\t\t <td width=\"4%\" class=\'COLUMNHEADER\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"5%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"5%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="                                                   \n                            <td class=\"COLUMNHEADER\" width=\"5%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"4%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t <script>enableDisableSelectButton(\'false\')</script>\n                         \t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                         \t\t\t\t<script>enableDisableSelectButton(\'true\')</script>\n                         \t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'INSUFFICIENTSTOCK\' width=\'1%\' title=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">&nbsp;</td>\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' width=\'1%\'></td>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' width=\'1%\' align=\"right\">\n\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCostGreen.jpg\' height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' title=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t      ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCostRed.jpg\'  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCost.jpg\'  title=\"Low Cost Item\" height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t       ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/LowCost.jpg\'  title=\"Low Cost Item\" height=\'15\' width=\'15\' style=\'visibility:hidden\'>&nbsp;\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t           <img src=\'../../ePH/images/HighMarginGreen.jpg\'  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t        ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t           <img src=\'../../ePH/images/HighMarginRed.jpg\'  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'title=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/HighMargin.jpg\' title=\"High Margin Item\"  height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t          <img src=\'../../ePH/images/HighMargin.jpg\' title=\"High Margin Item\"  height=\'15\' width=\'15\' style=\'visibility:hidden\'>&nbsp;\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" \n\t\t\t\t\t\t\t\t\t\t  <img src=\'../../ePH/images/Innovator.jpg\'  title=\"Innovator Item\" height=\'15\' width=\'15\' style=\'visibility:";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>&nbsp;\n\t\t\t\t                 ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t               \t\t\t  <img src=\'../../ePH/images/Innovator.jpg\'  title=\"Innovator Item\" height=\'15\' width=\'15\' style=\'visibility:hidden\'>&nbsp;\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<td id=\"item";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" title=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" onclick=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><!-- GHL-CRF-0618-->\n\t\t\t\t\t\t\t\t\t\t<font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" </font>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" onclick=\"disableClick(event);\">\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_item_code";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"hdn_item_code";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_line_no";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"hdn_line_no";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_trade_code";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"hdn_trade_code";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_trade_name";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"hdn_trade_name";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"> \n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_tech_code";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"item_tech_code";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_need_to_open";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"alt_need_to_open";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdn_available_qty";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"hdn_available_qty";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"> <!--//Added By Himanshu for GHL-SCF-1738-->\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =")</label>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n                        <td>\n<!-- ============================================================================================================= -->\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' title=\"Image\" onclick = \"showImage(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\',\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\');\" onmouseover=\"changeCursor(this);\">\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n                  &nbsp;\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t\n<!-- ============================================================================================================= -->\n\t\t\t\t\t\t\t\t</td><td width =\"4%\">&nbsp;\n<!-- code started for Preferred Drugs Item Icon -->\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\n<!-- code ends for the preferered drugs item Icon -->\n</td>\n\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" align=\"center\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" align=\"center\"> ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" align=\"center\" title=\'\' id=\'BL_ERROR";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'> ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' width=\'5%\' align=\"right\"> <img src=\"../../ePH/images/altenate.jpg\" name=\"alt_img_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" style=\"cursor:pointer\" onClick=\"displayAlternateItem(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\');\" style=\"cursor:pointer;color:blue\" height=\'15\' width=\'15\' > </td>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" <td class=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" style=\"cursor:pointer\" onClick=\"\" style=\"visibility:hidden\" height=\'15\' width=\'15\' > </td>\n                                ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" align=\"right\" title=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\" ><label  onclick=\"displayStock(\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\');\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&nbsp;</label></font></td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" align=\"center\" >\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_itemSelect";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"chk_itemSelect";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" value=\"\" checked onClick=\"storeSelectedItem(\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\')\" ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t     <td class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" value=\"\" onClick=\"storeSelectedItem(\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t<input type=\"hidden\" name=\"hdn_from\" id=\"hdn_from\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"hdn_to\" id=\"hdn_to\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"hdn_bean_id\" id=\"hdn_bean_id\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"hdn_bean_name\" id=\"hdn_bean_name\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_disp_charge_dtl_in_drug_lkp_yn\" id=\"bl_disp_charge_dtl_in_drug_lkp_yn\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_disp_price_type_in_drug_lkp\" id=\"bl_disp_price_type_in_drug_lkp\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"take_home_medication\" id=\"take_home_medication\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"radioval\" id=\"radioval\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"search_string\" id=\"search_string\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"search_criteria\" id=\"search_criteria\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"consignment\" id=\"consignment\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Manufacturer\" id=\"Manufacturer\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"p_Item_class\" id=\"p_Item_class\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Item_analysis1\" id=\"Item_analysis1\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Item_analysis2\" id=\"Item_analysis2\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Item_analysis3\" id=\"Item_analysis3\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"store_name\" id=\"store_name\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\n\t\t\t\t<input type=\"hidden\" name=\"item_type_yn\" id=\"item_type_yn\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\n\t\t\t\t<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->\t\t\t\t\t\t\t\n\n\n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n</html>\n\n";
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
05/10/2017	  	IN064474	     	Devindra 											GHL-CRF-0467 [IN064474] 
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
14/01/2019		IN068344		    Devindra				 		                    Required indication of different item types during dispense/order 
                                                                                        according to patient billing group.
28/05/2020      	IN072995            Haribabu                                            PMG2020-NMC-JD-CRF-0001                                                                                         
22/07/2020		IN:072092	    Manickavasagam J			     GHL-CRF-0618
10/08/2020		IN:73512	        Manickavasagam J			     GHL-CRF-0618
17/08/2020      IN073688         Prabha       17/08/2020        Manickavasagam J        Medical Item Screen
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
03/12/2020		TFS:8983	        Manickavasagam J			     GHL-SCF-1533
14/07/2021		TFS:21249	        Manickavasagam J			     NMC-JD-SCF-0217
03/10/2023	  	50818  			    Himanshu 						GHL-SCF-1738 					GHL-SCF-1738 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try{
		String	bean_id				=	request.getParameter("bean_id");
		String	bean_name			=	request.getParameter("bean_name");
		String	bl_disp_charge_dtl_in_drug_lkp_yn	=	request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn");
		String	bl_disp_price_type_in_drug_lkp		=	request.getParameter("bl_disp_price_type_in_drug_lkp")==null?"":request.getParameter("bl_disp_price_type_in_drug_lkp");
		String	bl_install_yn			=	request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String	item_desc				=	request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		String	order_type_code			=	request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		String	priority				=	request.getParameter("priority")==null?"":request.getParameter("priority");
		String	take_home_medication	=	request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String 	store_name				=	request.getParameter("store_name")==null?"":request.getParameter("store_name"); //added on 08/04/2010 for IN20551-- priya
		String 	disp_locn_code			=	request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code"); //added on 08/04/2010 for IN20551-- priya
		item_desc				= item_desc+"%";

		ConsumableOrderBean bean=	(ConsumableOrderBean)getBeanObject( bean_id, bean_name, request ) ;

		String patient_id 	=""; // Added for GHL-CRF-0467 - Start
		String encounter_id ="";
		patient_id		= bean.getPatientId(); ;
		encounter_id	= bean.getEncounterId() ;
		String	drug_bean_id		=	"@DrugSearchBean"+patient_id+encounter_id;
		String	drug_bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean drug_bean		=	(DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ; // Added for GHL-CRF-0467 - End
		//String facility_id		=   (String) session.getValue("facility_id");
		String from				=	request.getParameter("hdn_from")==null?"":request.getParameter("hdn_from");
		String to				=	request.getParameter("hdn_to")==null?"":request.getParameter("hdn_to");
		String radioval			=	request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" );
		String	search_string	=	request.getParameter("search_string")==null?"":request.getParameter("search_string");
		String	search_criteria	=	request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria");
		String	consignment		=	request.getParameter("consignment")==null?"":request.getParameter("consignment");
		String	Manufacturer	=	request.getParameter("Manufacturer")==null?"":request.getParameter("Manufacturer");
		String	p_Item_class	=	request.getParameter("p_Item_class")==null?"":request.getParameter("p_Item_class");
		String	Item_analysis1	=	request.getParameter("Item_analysis1")==null?"":request.getParameter("Item_analysis1");
		String	Item_analysis2	=	request.getParameter("Item_analysis2")==null?"":request.getParameter("Item_analysis2");
		String	Item_analysis3	=	request.getParameter("Item_analysis3")==null?"":request.getParameter("Item_analysis3");
		String	CALL_FROM	=	request.getParameter("CALL_FROM")==null?"":request.getParameter("CALL_FROM");
		String	patient_class	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//patient_class  Added for GHL-CRF-0467 - Start
		String	consider_stock	=	"";
		String	allow_pres_without_stock_yn	=	"";
		ArrayList stock_params	=	drug_bean.validateForStock();
		String allow_alt_for_med_item = bean.getAllowAltForMedItem(); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
		bean.setAltItemClicked("");
		String act_patient_class = bean.getActPatientClass(); 			
		String  billing_group_type  =bean.getBillingType(act_patient_class,encounter_id);	
		Connection connection = null; 
	    boolean item_type_yn  = false;
	    boolean  alt_need_to_open = false; // Added for GHL-SCF-0549 
		boolean formulary_billing_app = false; //GHL-CRF-0618


		try {
			  connection = ConnectionManager.getConnection(request);
			  if(!"DISP".equals(CALL_FROM))
			  item_type_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ITEM_TYPE_APP");
			  boolean ext_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","EXT_DISP_APPL");//Added for IN072995
			  bean.setExtDispAppl(ext_disp_appl);//Added for IN072995
 		  	 formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","FORMULARY_BLG_GRP_APP");//GHL-CRF-0618
		}
		catch(Exception e) {
			  out.print("Exception @ Result JSP :"+e.toString());
			  e.printStackTrace();
		}
		finally{		
			if(connection != null)
			  ConnectionManager.returnConnection(connection,request);
		} // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			allow_pres_without_stock_yn		= (String)stock_params.get(1);
		} // Added for GHL-CRF-0467 - End
		ArrayList arrList		=	null;
        try{
		//arrList	= (ArrayList)bean.getItemDetailsList(item_desc,from,to, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication, priority);
			arrList	= (ArrayList)bean.getItemDetailsList(item_desc,from,to, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication,priority,search_string,search_criteria,consignment,Manufacturer,p_Item_class,Item_analysis1,Item_analysis2,Item_analysis3,radioval);

		}
		catch (Exception e){
			e.printStackTrace();
		}
		

            _bw.write(_wl_block10Bytes, _wl_block10);

				if(arrList!=null && arrList.size()>1){
					HashMap hmItemDetails= new HashMap();
					ArrayList existingList = null;
					if("DISP".equals(CALL_FROM)){
						String	disp_bean_id			   =	"DispMedicationAllStages" ;
						String	disp_bean_name			   =	"ePH.DispMedicationAllStages";
						DispMedicationAllStages disp_bean  = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name, request);
						existingList  = (ArrayList)disp_bean.getConsumableDetails();
					}
					else
						existingList = bean.getPresItemList();
					ArrayList existingCodes = new ArrayList();
					if(existingList!=null && existingList.size()>0){
						for(int i=0; i<existingList.size(); i++){
							hmItemDetails = (HashMap)existingList.get(i);
							if("DISP".equals(CALL_FROM))
								existingCodes.add(hmItemDetails.get("ORDER_CATALOG_CODE"));
							else
								existingCodes.add(hmItemDetails.get("ITEM_CODE"));
						}
						hmItemDetails = null;
					}

					String classvalue		= "";
					String disp_str			= "";
					String item_code		= "";
					String trade_code		= "";
					String trade_name		= "";
					String stock_yn			= "";
					String avl_qty			= "";
					String ext_disp_appl_yn = "";//Added for IN072995
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
					String  low_cost_item               ="";                     // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
					String  innovator_item              ="";
					String  high_margin_item            =""; 
					String low_cost_item_visibility     ="";
					String innovator_item_visibility    ="";
					String high_margin_item_visibility  ="";
					String item_tech_code               = "";                   // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
					//GHL-CRF-0618 - start
					String onClick						= ""; //GHL-CRF-0618
					String onClick1						= ""; 

					boolean disp_non_preference_rem_window =false; 
					boolean non_preference_flag		= false;
					//GHL-CRF-0618 - end

            _bw.write(_wl_block11Bytes, _wl_block11);

								// For display the previous/next link
								out.println(arrList.get(0));

            _bw.write(_wl_block12Bytes, _wl_block12);
if(item_type_yn && bl_install_yn.equals("Y")){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

							if(formulary_billing_app){	
						
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
						} // Added for GHL-CRF-0548 [IN:068345] - End - Devindra 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
  
							if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

							}
                            if(allow_alt_for_med_item.equals("Y")){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra

            _bw.write(_wl_block22Bytes, _wl_block22);

                            } // Added for GHL-CRF-0548 [IN:068345] - End - Devindra

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
							
							//GHL-CRF-0618 - start
							String preference = "";  
							String preference_img = ""; 
							String formulary_value = "";
							String formulary_code  = "";
							String blg_grp_type = "";
							HashMap hmBlgGrp = null;
							boolean alternate_flag = false;
							boolean err_flag = false;
							ArrayList itemGenericType = null;
							if(formulary_billing_app){
								String blng_grp_id = bean.getBillingGrpId();

								//formulary_value = bean.getFormularyBillingGrpCode("CBSN");
								formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
								formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
								blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
								if(!formulary_code.equals(""))
								 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"M"); //blng_grp_id added for GHL-SCF-1527
								 itemGenericType = bean.getItemGenericType();
							}
						//GHL-CRF-0618  - end
								

                                 HashMap ht=(HashMap)bean.getSelectedItems();
System.out.println("ht"+ht);
                               
                                 for (int i=1;i<arrList.size();i++){
                                	 if (ht.size()>0){
                                	
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
                         			else{
                         				 
            _bw.write(_wl_block28Bytes, _wl_block28);
}
								strEnableDisable = "";
								err_flag = false;
								hmItemDetails = (HashMap)arrList.get(i);
								item_code			= (String)hmItemDetails.get("ITEM_CODE")==null?"":(String)hmItemDetails.get("ITEM_CODE"); 
								//added for the duplication check
								if(existingCodes.contains(item_code)){
									strEnableDisable = "disabled";
								}
								//end of duplication
								item_desc			= (String)hmItemDetails.get("ITEM_DESC")==null?"":(String)hmItemDetails.get("ITEM_DESC");        
								trade_code			= (String)hmItemDetails.get("TRADE_CODE")==null?"":(String)hmItemDetails.get("TRADE_CODE");       
								trade_name			= (String)hmItemDetails.get("TRADE_NAME")==null?"":(String)hmItemDetails.get("TRADE_NAME");       
								stock_yn			= (String)hmItemDetails.get("STOCK_YN")==null?"":(String)hmItemDetails.get("STOCK_YN");          
								avl_qty				= (String)hmItemDetails.get("AVAIL_QTY")==null?"0":(String)hmItemDetails.get("AVAIL_QTY");
								ext_disp_appl_yn				= (String)hmItemDetails.get("EXT_DISP_APPL_YN")==null?"N":(String)hmItemDetails.get("EXT_DISP_APPL_YN"); //Added for IN072995
								uom_code			= (String)hmItemDetails.get("UOM_CODE")==null?"":(String)hmItemDetails.get("UOM_CODE"); 
								uom_desc			= (String)hmItemDetails.get("UOM_DESC")==null?"":(String)hmItemDetails.get("UOM_DESC"); 
								/*=============================================================================================*/
								//added on 08/04/2010 for IN20551-- priya
								// Here we are taking dispense location from dispense medication screen if it exists otherwise from PH_DISP_STOCK_LOCN function
								//store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");
								if(disp_locn_code!=null && !(disp_locn_code.equals("")))
									store_code = disp_locn_code;
								else 
									store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");
								if(store_name!=null && !(store_name.equals("")))
									store_desc = store_name;
								else
									store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC"); 
								
								//store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC");
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
								low_cost_item  = (String)hmItemDetails.get("LOW_COST_ITEM")==null?"":(String)hmItemDetails.get("LOW_COST_ITEM"); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra								
								high_margin_item = (String)hmItemDetails.get("HIGH_MARGIN_ITEM")==null?"":(String)hmItemDetails.get("HIGH_MARGIN_ITEM");
								innovator_item = (String)hmItemDetails.get("INNOVATOR_ITEM")==null?"":(String)hmItemDetails.get("INNOVATOR_ITEM");
								item_tech_code = (String)hmItemDetails.get("ITEM_TECH_CODE")==null?"":(String)hmItemDetails.get("ITEM_TECH_CODE");
								alt_need_to_open = true; // Added for GHL-CRF-0549
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
								
								// Added for GHL-CRF-0548 [IN:068345] - End - Devindra
								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										strEnableDisable = "disabled";
										err_flag = true;
									}
								}
								//GHL-CRF-0467 starts
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
							 //added for NMC-JD-SCF-0217 
							  if(avl_qty_1>0)
								stock_yn = "Y";
							  else
							    stock_yn = "N";
								
								
								//GHL-CRF-0467 ends

								//if((consider_stock.equals("Y")) &&(hmItemDetails.get("STOCK_YN").equals("") || hmItemDetails.get("STOCK_YN").equals("N"))){ //consider_stock added for GHL-CRF-0467 and commented for NMC-JD-SCF-0217
									//out.println("88888888" +hmItemDetails.get("STORE_DESC"));
									if(consider_stock.equals("Y") && (stock_yn.equals("") || stock_yn.equals("N"))){  //added for NMC-JD-SCF-0217

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
   
								}
								else { 

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);

								}
							alternate_flag = bean.altItemsAvailableYn(item_code, item_tech_code);//moved from down to up for GHL-CRF-0618
							if(item_type_yn && bl_install_yn.equals("Y")){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
								if(formulary_billing_app){//GHL-CRF-0618 - start
									billing_group_type = "";
									preference_img = "";
									disp_non_preference_rem_window = false;
									non_preference_flag = false;
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(itemGenericType!=null && itemGenericType.size()>0){
											if(itemGenericType.contains("M"))
												non_preference_flag = true;
									  }
										if(hmBlgGrp.containsKey(item_code)){
											non_preference_flag = true;
											preference = (String)hmBlgGrp.get(item_code)==null?"":(String)hmBlgGrp.get(item_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item'/>";
											}
										}else{
										if(non_preference_flag)
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
										} 

									}/*else{
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
									} */
									if(blg_grp_type.equals("C")) {
									if(!preference.equals("")  && preference.equals("P1")){
											disp_non_preference_rem_window = false;
										}else{
										if((preference.equals("") && non_preference_flag ) || preference.equals("P2") || 	preference.equals("P3")){
											disp_non_preference_rem_window = true;
										}
									 }
									}else if(blg_grp_type.equals("R")){
										if(!preference.equals("P1") || (preference.equals("") && non_preference_flag)){
											disp_non_preference_rem_window = true;
											if(!alternate_flag)
											strEnableDisable = "disabled";
										}else{
											disp_non_preference_rem_window = false;
										}
									}

									if(blg_grp_type.equals("R") && !non_preference_flag){ //added for GHL-SCF-1533
										disp_non_preference_rem_window = false;
										if(!err_flag)
										strEnableDisable = "";
									} 

								//System.err.println("==blg_grp_type===>"+blg_grp_type+"==disp_non_preference_rem_window===>"+disp_non_preference_rem_window+"==preference==>"+preference);

								}//GHL-CRF-0618 - end

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
 if(low_cost_item_visibility.equalsIgnoreCase("visible")){ 
							           if(billing_group_type.equals("L")){
							        	   alt_need_to_open = false;
							           
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(low_cost_item_visibility));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
							           else if(billing_group_type.equals("H")){							        	   
							           
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(low_cost_item_visibility));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
} else{								    	 
								     
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(low_cost_item_visibility));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
  }
							       else{ 
            _bw.write(_wl_block43Bytes, _wl_block43);
} if(high_margin_item_visibility.equalsIgnoreCase("visible")){ 
							             if(billing_group_type.equals("H")){
							             alt_need_to_open = false;
							             
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(high_margin_item_visibility));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
} 
							            else if(billing_group_type.equals("L")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(high_margin_item_visibility));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
} else{
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(high_margin_item_visibility));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
  }
							       else{ 
            _bw.write(_wl_block49Bytes, _wl_block49);
} if(innovator_item_visibility.equalsIgnoreCase("visible")){ 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(innovator_item_visibility));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{ 
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
if(formulary_billing_app){//GHL-CRF-0618 - start

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(preference_img));
            _bw.write(_wl_block56Bytes, _wl_block56);
								} //GHL-CRF-0618 - end

                 if((!billing_group_type.equals("H") && !billing_group_type.equals("L")) || (!low_cost_item_visibility.equalsIgnoreCase("visible") && !high_margin_item_visibility.equals("visible")))
                	 alt_need_to_open = false;
                            } // Added for GHL-CRF-0549 [IN:068344] --End  - Devindra

            _bw.write(_wl_block57Bytes, _wl_block57);
 
/*code starts for the preferred Item */
	/*hardcoded Values 
								bl_preference_check_YN ="Y";
								alert_for_preferred_item_YN ="Y";
								bl_preference_item_code = item_code;
								bl_preference_basis_ind ="S";
								
	hard Coded Values */
	

									if (bl_preference_check_YN .equals("Y")){
										preferred_item_text="<img src='../../ePH/images/Insurance.gif' height='15' width='15' style='cursor:pointer' onClick = showPreferredItems('"+bl_preference_item_code+"','"+bl_preference_basis_ind+"','"+bean_id+"','"+bean_name+"','"+bl_disp_charge_dtl_in_drug_lkp_yn+"','"+bl_disp_price_type_in_drug_lkp+"','"+bl_install_yn+"','"+order_type_code+"','"+take_home_medication+"','"+bl_preference_priority+"'); />";
										if (alert_for_preferred_item_YN.equals("Y"))
											 promptAlert_onclick_of_item ="Y";
										else
											 promptAlert_onclick_of_item ="";
									}else{
											preferred_item_text	= "";
										 }

									if (!(strEnableDisable.equals(""))){
										preferred_item_text="";
									}
									//Added for IN072995 start
									if(ext_disp_appl_yn.equals("Y")){
										preferred_item_text=preferred_item_text+"&nbsp;<img src='../../ePH/images/ExternalDispensing.gif' height='18' width='20'/>";
										}
									//Added for IN072995 end
								//GHL-CRF-0467 starts
								if(strEnableDisable.equals("")){
										strEnableDisable	=	allow_without_stock;
									
								}
								//alternate_flag = bean.altItemsAvailableYn(item_code, item_tech_code);//moved from down to up for GHL-CRF-0618
								//GHL-CRF-0467 ends
/*code starts for the preferred Item */
								if (strEnableDisable != null){
									if(!strEnableDisable.equals("disabled")){
										//GHL-CRF-0618 - start
										if(formulary_billing_app){

											if(alternate_flag && non_preference_flag && !preference.equals("P1")){
												onClick	= "displayAlternateItem('"+item_code+"','"+item_tech_code+"','"+act_patient_class+"');";
												
											}else{
												onClick	=	"selectItem('"+i+"','"+promptAlert_onclick_of_item+"');";
											}
											if(disp_non_preference_rem_window && !alternate_flag){
													onClick1 = "if(formularyNonPreference('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"')){"+onClick+"}";
											}else{  
													onClick1 = onClick;
											}
										}else{
											onClick1	=	"selectItem('"+i+"','"+promptAlert_onclick_of_item+"');";
										}
										//GHL-CRF-0618 - end

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(onClick1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);

								}
								else{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( item_desc ));
            _bw.write(_wl_block65Bytes, _wl_block65);

									}
								}

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(item_tech_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(alt_need_to_open));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block81Bytes, _wl_block81);

									if(!trade_name.equals("")){

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block83Bytes, _wl_block83);

									}

            _bw.write(_wl_block84Bytes, _wl_block84);

		String fileName = bean.checkImageExists(item_code);
		if(!(fileName == null || fileName == ""))
		{

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block87Bytes, _wl_block87);

		}else{


            _bw.write(_wl_block88Bytes, _wl_block88);

        }

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(preferred_item_text));
            _bw.write(_wl_block90Bytes, _wl_block90);

								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if(bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block93Bytes, _wl_block93);

									if(bl_reimburse_yn.equals("")&& bl_reimburse_yn.equals("Y")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block95Bytes, _wl_block95);

									if(bl_imported_yn.equals("") && bl_imported_yn.equals("Y")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block95Bytes, _wl_block95);

									if(!bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = (String)hmItemDetails.get("BL_UNIT_PRICE") ;
									}
									else{
										disp_str = "&nbsp";

										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
										}
									}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block95Bytes, _wl_block95);

									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										out.println("<script>dispTitle('"+bl_error_code+"','"+bl_error_text+"','"+bl_sys_message_id+"','"+i+"');</script>");
									}
								}
                                if(allow_alt_for_med_item.equals("Y") && alternate_flag){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra and modified for GHL-CRF-0618

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(item_tech_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block100Bytes, _wl_block100);

                                }  else if(allow_alt_for_med_item.equals("Y")){
                                 
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
 } // Added for GHL-CRF-0548 [IN:068345] - End - Devindra

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(java.net.URLEncoder.encode(item_desc, "UTF-8")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc, "UTF-8")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(avl_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
 // IN073688 
									if(formulary_billing_app){
										if((!preference.equals("") && !preference.equals("P1")) ||  ( !preference.equals("P1") && non_preference_flag) ){
											strEnableDisable  = "disabled";
										}
									} 
								
            _bw.write(_wl_block110Bytes, _wl_block110);
		if(ht.containsKey(item_code+i))  {  
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(strEnableDisable));
            _bw.write(_wl_block115Bytes, _wl_block115);
 } else{ 
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(strEnableDisable));
            _bw.write(_wl_block115Bytes, _wl_block115);
} 
            _bw.write(_wl_block118Bytes, _wl_block118);

						}

            _bw.write(_wl_block119Bytes, _wl_block119);
				
				
				}
			
				else if(arrList==null || arrList.size()<=1 || !arrList.get(0).equals("cancel")){
					

            _bw.write(_wl_block120Bytes, _wl_block120);

				}
				bean.setDispPriceTypeinDrugLKPYN(bl_disp_price_type_in_drug_lkp);
				bean.setDispChargeDtlInDrugLKPYN(bl_disp_charge_dtl_in_drug_lkp_yn);
				bean.setBillInstallYN(bl_install_yn);
			//	bean.setPriority(priority); //commented for IN26242 --02/02/2011-- priya
				bean.setTakeHomeMedication(take_home_medication);

            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bl_disp_charge_dtl_in_drug_lkp_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bl_disp_price_type_in_drug_lkp));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(radioval));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(search_string));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(consignment));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(Manufacturer));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(p_Item_class));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(Item_analysis1));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(Item_analysis2));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(Item_analysis3));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(store_name));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(item_type_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block145Bytes, _wl_block145);

	putObjectInBean(bean_id,bean,request); 
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Pay.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reimburse.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.National.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitPrice.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Quantity/Uom.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Matched.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotMatched.label", java.lang.String .class,"key"));
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
