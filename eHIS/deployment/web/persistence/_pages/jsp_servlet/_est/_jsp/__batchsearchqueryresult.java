package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.BatchSearchBean;
import eCommon.Common.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.*;
import webbeans.eCommon.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __batchsearchqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/BatchSearchQueryResult.jsp", 1729576485641L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n<!-- \t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\t\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link> \n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t\t<script language=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" SRC=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<!--<script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n\t\t<script language=\"Javascript\" src=\"../../eST/js/BatchSearch.js\"> </script>\n \t    <script language=\"javascript\" src=\"../../eST/js/StTransaction.js\"></script>\n        <script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<form name=\"BatchsearchForm\" id=\"BatchsearchForm\">\n\t\t\t<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 62\">\n\t\t\t</div>\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=center>\n\t\t\t<tr>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  id=\'tb1\' align=center>\n\t\t\t<tr>\n\t\n\t\t\t\t<th  class=\'CAGROUP_HEADING\' ></font></th> \n\t\t\t\t<th  class=\'CAGROUP_HEADING\' ><font size=1><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></font></th>\n\t\t\t\t<th  class=\'CAGROUP_HEADING\'><font size=1><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></font></th>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<th  class=\'CAGROUP_HEADING\'><font size=1><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></font></th><!-- Added against GHL-CRF- 0499 -->\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></font></th>\n\t\t\t\t<th  class=\'CAGROUP_HEADING\'><font size=1><b>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<!-- added for MO-CRF-20175 -->\n\t\t\t\t<th  class=\'CAGROUP_HEADING\'><font size=1><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<th  class=\'CAGROUP_HEADING\'><font size=1><b>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></font></th>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n             <th  class=\'CAGROUP_HEADING\'><font size=1><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></font></th>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=30 \n\t\t\t\t\t\tclass=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" :</b> \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp\n\t\t\t\t\t\t\t\t\t;&nbsp; <b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" : </b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" : \n\t\t\t\t\t\t\t\t</b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</font></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t <tr>\n\t\t\t\t<td colspan=30  class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" :</b> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;&nbsp; <b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</b></font></td>\n\t\t\t</tr> \n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\n\t\t <tr id=\"tr_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"   bgcolor=\"#FFC6AA\" title= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \" \n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\tstyle = \"cursor:pointer\" onClick=\"showHistory1(tr_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =",";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =");\" \n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t><font  size = 1 ><B>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</B></font>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t\t\t\t\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font></td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t             <font size=1>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t   <font size=1>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</font></td>\n\t\t\t  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" ><font size=1>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t</font></td>  <!-- Added against GHL-CRF- 0499 -->\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</font>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</font></td>\n\t\t\t\t<!--Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012 -->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<!-- MO-CRF-20175 -->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font>&nbsp;</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</font>&nbsp;</td> \n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td>\n\t\t\t\t<!--\n\t\t\t\t* @Name - Priya\n\t\t\t\t* @Date - 01/02/2010\n\t\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t\t* @Desc - Modified by priya as if the value of \'QTY_ON_HAND\' & \'AVAIL_QTY\' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as \'0.000\' & so used the common method\n\t\t\t\t-->\n\t\t\t\t<!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align Quantity on hand,AVAIL_QTY .\t\t\t\t\n\t\t\t\t\t-->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" style=\"TEXT-ALIGN:right\"><font size=1>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font>&nbsp;</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t<td  class=\"NODISPLAY\"><input type=checkbox onClick=\"return checkAllowed(this);\" name=\"check";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"check";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"></font></td><input type=hidden name=\"batch_id";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"batch_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"item_code";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"item_code";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"><input type=hidden name=\"item_desc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"item_desc";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"><input type=hidden name=\"store_code";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"store_code";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"><input type=hidden name=\"store_desc";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"store_desc";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"><input type=hidden name=\"trade_id_applicable_yn";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"trade_id_applicable_yn";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"><input type=hidden name=\"expiry_date";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"expiry_date";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"><input type=hidden name=\"bin_location_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"bin_location_code";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"><input type=hidden name=\"bin_desc";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"bin_desc";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"><input type=hidden name=\"trade_id";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"trade_id";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"><input type=hidden name=\"trade_name";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"trade_name";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"><input type=hidden name=\"uom_code";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"uom_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"><input type=hidden name=\"qty_on_hand";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"qty_on_hand";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"><input type=hidden name=\"nod";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"nod";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"><input type=hidden name=\"manufacturer_id";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"manufacturer_id";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"><input type=hidden name=\"manufacturer_name";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"manufacturer_name";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"><input type=hidden name=\"avail_qty";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"avail_qty";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"><input type=hidden name=\"expiry_yn";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"expiry_yn";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=30  \n\t\t\t\t\tclass=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" :</b> \n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="&nbsp;&nbsp; <b>\n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="  : </b>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="&nbsp;&nbsp;\n\t\t\t\t<b>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" : \n\t\t\t\t</b>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t</font></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\n\t\t\t <tr>\n\t\t\t\t<td colspan=30  class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\n\t\t\t\n\t\t <tr id=\"tr_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"  bgcolor=\"#FFC6AA\" title= \"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" \n\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\tstyle = \"cursor:pointer\"    onClick=\"showHistory(tr_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =");\" \n\t\t\t\t ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t><font   size=1><B>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</B></font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</font></td>  <!-- Added against GHL-CRF- 0499 -->\n\t\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</font></td>\n\t\t\t\t<!--Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 21/11/2012 -->\n\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</font></td>\n\t\t\t\t ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</font>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</font>&nbsp;</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n                        <td class=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" ><input type=text name=\"sel_qty_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" id=\"sel_qty_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id =\"sel_qty_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" size=10 maxlength=12 class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,7,0);\" onBlur = \"checkQty(this,\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\',\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\');\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\"><input type=checkbox onClick=\"return checkAllowed(this,\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\');\" name=\"check";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="></font></td><!-- Parameters passed for TH-KW-CRF-0043 -->\n\n\t\t\t\t\t\t<input type=hidden name=\"batch_id";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"item_desc";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"store_code";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"store_desc";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"trade_id_applicable_yn";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"\tvalue=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"expiry_date";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"bin_location_code";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"\t\tvalue=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"bin_desc";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"trade_id";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"trade_name";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"uom_code";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"qty_on_hand";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"nod";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"manufacturer_id";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"manufacturer_name";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"avail_qty";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t\t\t\t<input type=hidden name=\"expiry_yn";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t<input type=\"hidden\" name=\"start\" id=\"start\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t<input type=\"hidden\" name=\"end\" id=\"end\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\"\t\t\tvalue=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t\t<input type=\"hidden\" name=\"displaySize\" id=\"displaySize\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t<input type=\"hidden\" name=\"multipleSelect\" id=\"multipleSelect\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t<input type=\"hidden\" name=\"includeSuspendedBatches\" id=\"includeSuspendedBatches\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t<input type=\"hidden\" name=\"includeZeroStockBatches\" id=\"includeZeroStockBatches\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t<input type=\"hidden\" name=\"includeExpiredBatches\" id=\"includeExpiredBatches\"\tvalue=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n            <input type=\"hidden\" name=\"includeExpiredBatches\" id=\"includeExpiredBatches\"\tvalue=\"Y\">\n\t\t\t<input type=\"hidden\" name=\"maxAllowed\" id=\"maxAllowed\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\"\t\t\t\t\tvalue=\"1\">\n\t\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\"><!-- Added for TH-KW-CRF-0043 -->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n           </script>\n  \n\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t <script>\n\t\t\t\tparent.window.close();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\n</body>\n</form>\n";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n         <script>activeLink();</script>\n ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );
	
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
---------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------------------------
15/01/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
17/1/2022	  	TFS-27751	   		Shazana     				MO-CRF-20175
-----------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 //ADDED FOR GHL-CRF-0499 
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block7Bytes, _wl_block7);

			request.setCharacterEncoding("UTF-8");
 			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String from							=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String called_from                  =        request.getParameter( "called_from" )==null?"":request.getParameter( "called_from" ) ;//Added for TH-KW-CRF-0043
	String req_batch_qty                =        request.getParameter( "item_qty" )==null?"":request.getParameter( "item_qty" ) ;//Added for TH-KW-CRF-0043
	String temp_conv                    =        request.getParameter( "temp_conv" )==null?"":request.getParameter( "temp_conv" ) ;//Added for TH-KW-CRF-0043
	String curr_key                     =        "";//Added for TH-KW-CRF-0043
	
	String stlightgreen					=		"";
	BatchSearchBean bean				=		(BatchSearchBean) getBeanObject( "batchSearchBean","eST.BatchSearchBean",request );
	bean.setLanguageId(locale);

	String searchFunction				= 		bean.getSearchFunction() ;
	String multipleSelect				=		bean.getMultipleSelect() ;
	String includeSuspendedBatches		=		bean.getIncludeSuspendedBatches() ;
	String includeExpiredBatches		= 		bean.getIncludeExpiredBatches() ;
	String includeZeroStockBatches		=		bean.getIncludeZeroStockBatches() ;
	String maxAllowed					=		bean.getMaxAllowed() ;
	String p_list_all_trades_yn			=		request.getParameter( "p_list_all_trades_yn" )==null?"":request.getParameter( "p_list_all_trades_yn" ) ;
	  

	int maxRec							=		0; 
	int start							=		0;
	int end								=		0;
	int displaySize						=		0;
	int count							=		0;	
	String expiry_yn					=		"";
	int EWDays							=		0;

	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	HashMap dataList					=		null;

	String curr_item_store				=		"";
	String prev_item_store				=		"";
	String suspended					=		"";
	String stSQL						=		"";
	String item_code_from				=		"";
	String item_code_to					=		"";
	ArrayList alParameters	=	new ArrayList();
	ArrayList listRecord	=	new ArrayList();
	HashMap selQty          = new HashMap();
	 selQty =bean.getSelectedQTY();
	//Added for GHL-CRF-0499 starts 
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_DISPLAY_CHALLAN_NO");
		bean.setSite_spec_yn(site_main);
		//Added for GHL-CRF-0499 ends
	// Added By Rams 12/15/2009 For the Decimal CRF 537.1 Begins
	/* @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display
 */
  /** @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To use common method, the previous coding has been removed
	*/
int no_of_decimals=bean.getNoOfDecimals(); 
boolean batch_search_pur_uom_qoh_appl =false;//MO-CRF-20175

try{
		batch_search_pur_uom_qoh_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","BATCH_SEARCH_QOH_DISPLAY");
		System.out.println("batch_search_pur_uom_qoh_appl: "+batch_search_pur_uom_qoh_appl); 
		if(batch_search_pur_uom_qoh_appl){
			bean.setBatchsearch_puruom_appl(batch_search_pur_uom_qoh_appl); 
			System.out.println("site value: "+bean.isBatchsearch_puruom_appl()); 
		}
   }
catch (Exception exp){
	 exp.printStackTrace();
	 System.out.println("Exception in BatchSearchQueryResult.jsp");  
}
   finally{ 
   	if(con != null)
   		ConnectionManager.returnConnection(con,request); 
   }//END
	
	// Ends
	try{
			
				EWDays					=		bean.getEntityparam_EWDays(ACC_ENTITY_ID);
				//result					=		bean.getDataList();
     // Shaiju added to show the expired batches starts				
				if((bean.getCustomerID()).equals("MC")){
				
				item_code_from = bean.getItem_code_from();
				item_code_to = bean.getItem_code_to();
				
				alParameters.add(item_code_from);
				alParameters.add(item_code_to);
				alParameters.add(bean.getStore_code_from());
				alParameters.add(bean.getStore_code_to());
				//alParameters.add("PHINPS");
				alParameters.add(bean.getManufacturer_code());
				alParameters.add(bean.getIncludeZeroStockBatches());
				alParameters.add(bean.getIncludeExpiredBatches());
				alParameters.add(bean.getCuttOffDate());
				alParameters.add(bean.getPeriod_of_expiry());
				//alParameters.add("");
				alParameters.add(bean.getIncludeSuspendedBatches());
				alParameters.add(bean.getBatch_id());
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getTrade_Code());
				alParameters.add(bean.checkForNull(((String)((HashMap)bean.fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", bean.getStore_code_from())).get("FACILITY_ID")),bean.getLoginFacilityId()));			alParameters.add(bean.getDrugType());
				alParameters.add(bean.getItemClassFrom());
				alParameters.add(bean.getItemClassTo());
				
				//Commented  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				//stSQL		=		" SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  avail_qty avail_qty,expiry_yn,batch_status,SUSPENDED_YN  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty  >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(((?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,99999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                   FROM st_item   WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  (SELECT 'X' FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!')  AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
				
				//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				stSQL		=		" SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  avail_qty avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty  >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(((?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,99999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                   FROM st_item   WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  (SELECT 'X' FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!')  AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')"; //modified against ghl-crf-0499
				
				//stSQL		=		" SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  avail_qty avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty  >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(((?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,99999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                   FROM st_item   WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  (SELECT 'X' FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!')  AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
	
				//int no_of_decimals=getNoOfDecimals();
				String allow_decimals_yn="N";

				listRecord			=		bean.fetchRecords(stSQL.toString(),alParameters);
				if(item_code_from.equals(item_code_to)){
			allow_decimals_yn=bean.getAllowDecimalsYN(item_code_from);
			}
			for(int i=0;i<listRecord.size();i++){
			HashMap dataList_new		=		(HashMap)listRecord.get(i);
			if(!item_code_from.equals(item_code_to)){
			allow_decimals_yn=bean.getAllowDecimalsYN((String)dataList_new.get("ITEM_CODE"));
			}
			if(allow_decimals_yn.equals("Y")){
			dataList_new.put("AVAIL_QTY",bean.setNumber((String)dataList_new.get("AVAIL_QTY"),no_of_decimals));
			dataList_new.put("QTY_ON_HAND",bean.setNumber((String)dataList_new.get("QTY_ON_HAND"),no_of_decimals));
			}else{
			dataList_new.put("AVAIL_QTY",bean.setNumber((String)dataList_new.get("AVAIL_QTY"),0));
			dataList_new.put("QTY_ON_HAND",bean.setNumber((String)dataList_new.get("QTY_ON_HAND"),0));
			}
			dataList_new.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
			//dataList_new.put("CHALLAN_NO",(String)dataList_new.get("CHALLAN_NO"));//Added against GHL-CRF- 0499 end
			listRecord.set(i,dataList_new); 
			}  
			result = listRecord;
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

			**/
		//	DataList			=		listRecord;
				
				}
				else
				{
// Shaiju added to show the expired batches Ends
				
					result					=		bean.getDataList();
				}
				
				maxRec					=		result.size();
			
		
		if(!searchFunction.equals("Y")){

				displaySize				=		Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
				displaySize				=		Integer.parseInt("12");
				if ( from == null || from =="" )
					start				=		0;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null || to ==""){
					end					=		displaySize ;
				}
				else{
					end					=		Integer.parseInt( to ) ;	
				}
		}
		if(result.size() > 0 ){
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				if(site_main){
				
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(batch_search_pur_uom_qoh_appl){ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
             if(searchFunction.equals("Y")){
			          if(called_from.equals("NEWSCREEN")){//Added for TH-KW-CRF-0043
 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

			count				=		start;
			int chkCount		=		0;

            if(!searchFunction.equals("Y")) {

			while ( count < maxRec && count < end)
			{
				dataList		=		(HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue  =		"QRYEVEN" ;
				else
					classvalue  =		"QRYODD" ;
					
				curr_item_store =		(String)dataList.get("ITEM_CODE")+(String)dataList.get("STORE_CODE");

			if(!curr_item_store.equals(prev_item_store))
				{
					
					        expiry_yn	=		(String)dataList.get("EXPIRY_YN");
					if(expiry_yn.equals("N")) 
							expiry_yn	=		"No";
					else if(expiry_yn.equals("Y")) 
							expiry_yn	=		"Yes";
			
            _bw.write(_wl_block22Bytes, _wl_block22);
if(searchFunction.equals("Y")){
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")));
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block35Bytes, _wl_block35);

				
				stlightgreen		=		classvalue;
				String tool			=		"";
				String description	=		"";
				String expiry_date  =		(String)dataList.get("EXPIRY_DATE");
				//added for GHL-CRF-0499
				String itemCode = (String)dataList.get("ITEM_CODE"); 
				String challanNo= "";
				//added for GHL-CRF-0499
		
			//suspended=bean.isSuspendYN((String)dataList.get("STORE_CODE"),(String)dataList.get("ITEM_CODE"),(String)dataList.get("BATCH_ID"),(String)dataList.get("BIN_LOCATION_CODE"),(String)dataList.get("EXPIRY_DATE"));

			//Below code is commented and following is added by Archana Dhal on 11/26/2010 related to incident no. IN024566
     		//suspended=(String)dataList.get("SUSPENDED_YN");
			suspended = CommonBean.checkForNull((String)dataList.get("SUSPENDED_YN"),"");
	
			if((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes")){
					stlightgreen	=		"STLIGHTCREAM";
					tool			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExpiredBatch.label","st_labels");
					//tool			=		"Expired Batch";
					description		=		"E";
				}
				else if (suspended.equals("Y")) 
					{
							
							stlightgreen	=	"STLIGHTCREAM";
							 tool			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedBatch.label","st_labels");
							//tool			=	"Suspended Batch";
							description		=	"S";
							
				}
				else if (((String)dataList.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)dataList.get("NOD")) <= EWDays){
						
						stlightgreen		=	"STLIGHTCREAM";
						String  tool_expd	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expiringin.label","st_labels");
						String tool_days	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
						tool				=	tool_expd +(String)dataList.get("NOD")+tool_days;
						description			=	"E"+(String)dataList.get("NOD");												
					}

			 	 if (((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& (suspended.equals("Y")))
					 {
					stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Suspended&ExpiredBatch.label","st_labels");
					//tool					=	"Suspended & Expired Batch";
					description				=	 "S/E";
					}
                 String stBatchStatus		=	(String)dataList.get("BATCH_STATUS") ;
				
				// if( stBatchStatus.equals("C") || suspended.equals("C")){ //Bru-HIMS-CRF-111
					if( suspended.equals("C")){
					stlightgreen			=	"STLIGHTCREAM";
					tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NotifiedBatch.label","st_labels");
					//tool					=	"Notified Batch";
					description				=	"C";
				 }

               // if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C")){
                if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& suspended.equals("C")){
					
					stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired&NotifiedBatch.label","st_labels");
					//tool					=	"Expired & Notified Batch";
					description				=	"E/C";

				 }
			// if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C"))&& (suspended.equals("Y")))
			 if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& suspended.equals("C"))&& (suspended.equals("Y")))
					 {
					 stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedExpiredNotifiedBatch.label","st_labels");
					//tool					=	"Suspended,Expired & Notified Batch";
					description				=	"S/E/C";
					}
			
            _bw.write(_wl_block36Bytes, _wl_block36);
if(description.equals("")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(stlightgreen));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tool));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!description.equals("E")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(description));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale),"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);

				String batch_id=(String)dataList.get("BATCH_ID");
				boolean value=com.ehis.util.DateUtils.validDate(batch_id,"DMY",locale);
				if(value)
				{					
				
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("BATCH_ID"),"DMY","en",locale),"&nbsp;")));
            _bw.write(_wl_block51Bytes, _wl_block51);

				}
				else
				{
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
				
            _bw.write(_wl_block36Bytes, _wl_block36);

				if(site_main){
					//added for ghl-crf-0499
					String strCode=bean.getStore_code_from();//added for GHL-ICN-0032
					challanNo = bean.getChallanNo(itemCode, batch_id, expiry_date,strCode); // MODIFIED FOR GHL-ICN-0032
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull(challanNo,"&nbsp;")));
            _bw.write(_wl_block55Bytes, _wl_block55);
 } 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("MANUFACTURER_NAME"),"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("PUR_UOM_DESC"),"&nbsp;")));
            _bw.write(_wl_block51Bytes, _wl_block51);
 if (batch_search_pur_uom_qoh_appl){ 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dataList.get("PUR_UOM_QOH")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dataList.get("PUR_UOM_AVL_QTY")));
            _bw.write(_wl_block62Bytes, _wl_block62);
} 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("UOM_DESC"),"&nbsp;")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0"),no_of_decimals)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull((String)dataList.get("AVAIL_QTY"),"0"),no_of_decimals)));
            _bw.write(_wl_block66Bytes, _wl_block66);

					if(  ! searchFunction.equals("Y"))	
					{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("BATCH_ID")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("ITEM_DESC")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("STORE_CODE")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("STORE_DESC")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("TRADE_ID_APPLICABLE_YN")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(count));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("BIN_LOCATION_CODE")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("BIN_DESC")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("TRADE_ID")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("TRADE_NAME")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("UOM_CODE")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("QTY_ON_HAND")));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(count));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("NOD")));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("MANUFACTURER_ID")));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("MANUFACTURER_NAME")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dataList.get("AVAIL_QTY")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(count));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull((String)dataList.get("EXPIRY_YN"),"N")));
            _bw.write(_wl_block106Bytes, _wl_block106);
}
				
            _bw.write(_wl_block21Bytes, _wl_block21);

				count++;
			chkCount++;
			prev_item_store		=		curr_item_store;
			}
			}
			else
            {
                while ( count < maxRec) {

				dataList		=		(HashMap)result.get(count);
				
				dataList.put("AVAIL_QTY", ((String)dataList.get("AVAIL_QTY")).replace(".", ""));
				dataList.put("QTY_ON_HAND", ((String)dataList.get("QTY_ON_HAND")).replace(".", ""));
				

				if ( count % 2 == 0 )
					classvalue	=		"QRYEVEN" ;
				else
					classvalue	=		"QRYODD" ;
					
				curr_item_store	=		(String)dataList.get("ITEM_CODE")+(String)dataList.get("STORE_CODE");
				if(!curr_item_store.equals(prev_item_store))
				{

						expiry_yn		=		(String)dataList.get("EXPIRY_YN");
					if(expiry_yn.equals("N")) 
						expiry_yn		=		"No";
					else if(expiry_yn.equals("Y")) 
						expiry_yn		=		"Yes";
			
            _bw.write(_wl_block22Bytes, _wl_block22);
if(searchFunction.equals("Y")){
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")));
            _bw.write(_wl_block113Bytes, _wl_block113);
}else{
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block115Bytes, _wl_block115);

				stlightgreen			=		classvalue;
				String tool				=		"";
				String description		=		"";
				String expiry_date		=		(String)dataList.get("EXPIRY_DATE");
				suspended               =     CommonBean.checkForNull((String)dataList.get("SUSPENDED_YN"),"");
				//added for GHL-CRF-0499
				String itemCode = (String)dataList.get("ITEM_CODE"); 
				String batchId  =		(String)dataList.get("BATCH_ID");
				String challanNo= "";
				//added for GHL-CRF-0499
				 String sel_qty ="";//Added for TH-KW-CRF-0043
				 String sel_check ="";//Added for TH-KW-CRF-0043
				 HashMap sel_record =new HashMap();
          if(called_from.equals("NEWSCREEN")){//Added for TH-KW-CRF-0043
				 curr_key = batchId+"~"+itemCode;
				  if(selQty.containsKey(itemCode)){
					  sel_record =(HashMap)selQty.get(itemCode);
					  if(sel_record.containsKey(curr_key)){
                          sel_qty = (String)sel_record.get(curr_key);
					       sel_check ="checked";
					  }
				  }
		  }

				if((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes")){

					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExpiredBatch.label","st_labels");
				//	tool				=		"Expired Batch";
					description			=		"E";
				}
				
				else if (suspended.equals("Y")) 
					{
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedBatch.label","st_labels");
				//	tool				=		"Suspended Batch";
					description			=		"S";
				}
				else if (((String)dataList.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)dataList.get("NOD")) <= EWDays){
					stlightgreen		=		"STLIGHTCREAM";
					String	 tool_exp	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expiringin.label","st_labels");
					String  tool_ds		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					tool				=		tool_exp+(String)dataList.get("NOD")+tool_ds;
					description			=		"E"+(String)dataList.get("NOD");												
					}


			 	 if (((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& (suspended.equals("Y")))
					 {
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Suspended&ExpiredBatch.label","st_labels");
				//	tool				=		"Expired & Suspended Batch";
					description			=		"S/E";
					}

				String stBatchStatus	=		(String)dataList.get("BATCH_STATUS") ;
                 
				 //if( stBatchStatus .equals("C") 
                   if(suspended.equals("C")){
					stlightgreen		=		"STLIGHTCREAM";
					 tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NotifiedBatch.label","st_labels");
					//tool				=		"Notified Batch";
					description			=		"C";

				 }
               
			// if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& stBatchStatus.equals("C")){
			if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& suspended.equals("C")){
					stlightgreen		=		"STLIGHTCREAM";
					 tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired&NotifiedBatch.label","st_labels");
					//tool				=		"Expired & Notified Batch";
					description			=		"E/C";
		 }
    //if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& stBatchStatus.equals("C"))&&(suspended.equals("Y"))) 
	 
	 if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& suspended.equals("C"))&&(suspended.equals("Y")))
					 {
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedExpiredNotifiedBatch.label","st_labels");
				//	tool				=		"Suspended,Expired & Notified Batch";
					description			=		"S/E/C";
					}
					  
					
			
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block117Bytes, _wl_block117);
if(description.equals("")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(stlightgreen));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(tool));
            _bw.write(_wl_block119Bytes, _wl_block119);
if(!description.equals("E")){
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(description));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale),"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")));
            _bw.write(_wl_block51Bytes, _wl_block51);

				if(site_main){
					//Added for GHL-CRF-0499.1 START
					String strCode=bean.getStore_code_from();//added for GHL-ICN-0032
					challanNo = bean.getChallanNo(itemCode, batchId, expiry_date, strCode);//modified for GHL-ICN-0032
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull(challanNo,"&nbsp;")));
            _bw.write(_wl_block124Bytes, _wl_block124);
 } 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("MANUFACTURER_NAME"),"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("PUR_UOM_DESC"),"&nbsp;")));
            _bw.write(_wl_block126Bytes, _wl_block126);
 if (batch_search_pur_uom_qoh_appl){ 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dataList.get("PUR_UOM_QOH")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dataList.get("PUR_UOM_AVL_QTY")));
            _bw.write(_wl_block127Bytes, _wl_block127);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("UOM_DESC"),"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(CommonBean.checkForNull((String)dataList.get("AVAIL_QTY"),"0")));
            _bw.write(_wl_block128Bytes, _wl_block128);

					if(searchFunction.equals("Y"))	
					{
					
            _bw.write(_wl_block3Bytes, _wl_block3);
                  if(called_from.equals("NEWSCREEN")){//Added for TH-KW-CRF-0043

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(count));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(count));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(count));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(temp_conv));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(sel_qty));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(count));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(sel_check));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("BATCH_ID")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("ITEM_CODE")));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("ITEM_DESC")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("STORE_CODE")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("STORE_DESC")));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(count));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf((String)dataList.get("TRADE_ID_APPLICABLE_YN")));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(count));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(count));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(count));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf((String)dataList.get("BIN_LOCATION_CODE")));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("BIN_DESC")));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("TRADE_ID")));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("TRADE_NAME")));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("UOM_CODE")));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("QTY_ON_HAND")));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(count));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf((String)dataList.get("NOD")));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(count));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(count));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf((String)dataList.get("MANUFACTURER_ID")));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(count));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf((String)dataList.get("MANUFACTURER_NAME")));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("AVAIL_QTY")));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(count));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)dataList.get("EXPIRY_YN")));
            _bw.write(_wl_block163Bytes, _wl_block163);
}
				
            _bw.write(_wl_block21Bytes, _wl_block21);

				count++;
			chkCount++;
			prev_item_store=curr_item_store;
			}
			}
		
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(start));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(end));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(multipleSelect));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(includeSuspendedBatches));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(includeZeroStockBatches));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(includeExpiredBatches));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(maxAllowed));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block175Bytes, _wl_block175);

			out.flush();
		} 
		else
		{
			
            _bw.write(_wl_block176Bytes, _wl_block176);

			 if(p_list_all_trades_yn.equals("N"))
		{
            _bw.write(_wl_block177Bytes, _wl_block177);

		}
		}
			


	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
	//ADDED FOR GHL-CRF-0499
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	
	}

            _bw.write(_wl_block178Bytes, _wl_block178);
 if(!searchFunction.equals("Y")) { 
            _bw.write(_wl_block179Bytes, _wl_block179);
 } 
            _bw.write(_wl_block180Bytes, _wl_block180);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Expiry/ReceiptDate.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ChallanNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PurchaseUOM.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PurchaseUOMQOH.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PurchaseUOMAvlQty.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.QuantityOnHand.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpiryItems.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpiryItems.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpiryItems.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpiryItems.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
}
