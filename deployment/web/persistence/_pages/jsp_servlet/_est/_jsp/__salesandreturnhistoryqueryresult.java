package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SalesAndReturnHistoryBean;
import java.util.*;
import com.ehis.util.*;
import java.text.NumberFormat;
import java.lang.*;
import java.io.*;
import java.sql.*;
import eST.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __salesandreturnhistoryqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SalesAndReturnHistoryQueryResult.jsp", 1709122165197L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="   \n\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/SalesAndReturnHistory.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onLoad=\"FocusFirstElement()\" onKeyDown = \'lockKey()\'>\n<form name=\"formSalesAndReturnHistoryResult\" id=\"formSalesAndReturnHistoryResult\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t\t<tr id=\"heading\">\n\t\t\t\t\t\t<td width=\"80%\" class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"20%\" class=\"label\" bgcolor=\"white\">&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t<div  style=\"position:relative;height:460px;overflow:auto\">\n\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<tr style=\'position:relative\'style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=7 align=\'left\' class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" : </b> \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\"  class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\"  class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=9  class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" : </b> \n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=13 align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =":</b> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;</td>\n\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" align=\"left\" ><font size=1>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font></td>\n\t<td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" align=\"left\" style=\'WORD-BREAK:BREAK-ALL;\'><font size=1>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" align=\"right\" ><font size=1>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" align=\"center\" ><font size=1>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  style=\"TEXT-ALIGN:right\"><font \n\tsize=1>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\t<!-- <td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"  style=\"TEXT-ALIGN:right\"><font size=1>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font>&nbsp;</td> -->\n\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font>&nbsp;</td>\n\n\t<td class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</font>&nbsp;</td> \n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\t<td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" ><font size=1>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font></td>\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t<td class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" style=\'WORD-BREAK:BREAK-ALL;\'><font size=1>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"  style=\'WORD-BREAK:BREAK-ALL;\'><font size=1>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</font>&nbsp;</td>\n\t<td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</font>&nbsp;</td>\n\t<td class=\'NODISPLAY\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\t\t\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td colspan=7   class=\'ITEMSELECT\'><font size=1 width=\"60%\"><b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" : </b> </td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<tr> </tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td  colspan=7  align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" : </b></td> \n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<td colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'><font size=1><B>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</B></font>&nbsp;</td>\n\t\t\t\t<td colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'><font size=1><B>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</B></font>&nbsp;</td>\n\t\t\t\t<td colspan=2 align=\'left\' class=\'ITEMSELECT\'>&nbsp;&nbsp;</td>\n\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t\t<tr id=\"heading\">\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"20%\" class=\"label\" bgcolor=\"white\">&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t<div  style=\"position:relative;height:460px;overflow:auto\">\n\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<tr style=\'position:relative\'style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</th>\n\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=8 align=\'left\' class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" : </b> </td>\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\"  class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\"  class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\n\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td\tcolspan=9 class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" : </b> \t</td>\n\t\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=15 align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\t\t\t\t\t\n\n\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</font>&nbsp;</td>\n\t\t\n\t\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</font>&nbsp;</td> -->\n\n\t<td class=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</font>&nbsp;</td>\n\n\n\t<td class=\'NODISPLAY\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td colspan=8   class=\'ITEMSELECT\'><font size=1 width=\"60%\"><b>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t<tr> </tr>\n\n\t\t\t\t\t<!--\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td  colspan=8  align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" : </b></td> \n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t<td colspan=2 align=\'left\' class=\'ITEMSELECT\'>&nbsp;&nbsp;</td>\n\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\n\t\t\n\t\t\t</tr> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" </td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t<div  style=\"position:relative;height:460px;overflow:auto\">\n\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<tr style=\'position:relative\'style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</th>\n\t\t\t\t\t\t\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</th>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=9 align=\'left\' class=\'ITEMSELECT\' width=\"60%\"><font size=1><b>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" : </b> </td>\n\t\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=15 align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</font>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"  style=\"TEXT-ALIGN:left\"><font size=1>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td colspan=9   class=\'ITEMSELECT\'><font size=1 width=\"60%\"><b>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" : </b> \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'\t><font size=1><B>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</B></font>&nbsp;</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\n\t\t\t<tr> </tr>\n\n\t\t\t\t<!--\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td  colspan=9  align=\'left\' class=\'ITEMSELECT\'><font size=1><b>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" : </b></td> \n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<td colspan=1 style=\"TEXT-ALIGN:right\" class=\'ITEMSELECT\'><font size=1><B><\n\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</B></font>&nbsp;</td>\n\t\t\t\t<td colspan=2 align=\'left\' class=\'ITEMSELECT\'>&nbsp;&nbsp;</td>\n\t\t\t\t<td colspan=2 align=\'left\'  class=\'ITEMSELECT\'> </td>\n\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\n</form>\t\t\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n</body>\n</html>\n\n\n \n\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );
	
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
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
03/05/2016		IN0057816			B.Badmavathi					           AAKH-SCF-0220
19/04/2021      TFS id:-16213       Haribabu 							        AMS-SCF-0970
05/07/2021		TFS id:-19018       Prabha	  16/06/2021	   Manicakavasagam	AMS-CRF-0258
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
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

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		 NumberFormat nf = NumberFormat.getInstance(new Locale(locale));
		 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	String bean_id				=		"SalesAndReturnHistoryBean";
	String bean_name			=		"eST.SalesAndReturnHistoryBean";
	SalesAndReturnHistoryBean bean		=		(SalesAndReturnHistoryBean) getBeanObject(bean_id, bean_name,request  );  
	bean.clear();
	String store_code			=		request.getParameter( "p_fr_st_code")==null?"":request.getParameter( "p_fr_st_code") ;
	String from_date			=		request.getParameter( "from_date")==null?"":request.getParameter( "from_date") ;
	from_date					=		DateUtils.convertDate(from_date,"DMY",locale,"en");
	String to_date				=		request.getParameter( "to_date")==null?"":request.getParameter( "to_date") ;
	to_date						=		DateUtils.convertDate(to_date,"DMY",locale,"en");
	String item_code			=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String patient_id			=		request.getParameter( "patient_id" )==null?"":request.getParameter( "patient_id" ) ;
	String encounter_id		    =		request.getParameter( "encounter_id" )==null?"":request.getParameter( "encounter_id" ) ;
	String trn_type			    =		request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ;
	String sal_trn_type			=		request.getParameter( "sal_trn_type" )==null?"":request.getParameter( "sal_trn_type" ) ;
	//System.out.println("sal_trn_typesal_trn_type" +sal_trn_type);
	String classvalue			=		"";
	String facility_id			=		(String) session.getValue( "facility_id" ) ;
	double  subtotal			=		0.0;
	double  pre_subtotal		=		0.0;
	boolean flag				=		true;
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String grand_total			=		request.getParameter( "grand_total" )==null?"0":request.getParameter( "grand_total" ) ;
	String store_compare		=		request.getParameter( "store_compare" )==null?"0":request.getParameter( "store_compare" ) ;
	double grand_tot			=		Double.parseDouble(grand_total);
	double cost_value_sub_total     =   0.0;
	double pre_cost_value_sub_total =   0.0;
	int headercpls=7;
	
	patient_id = patient_id.toUpperCase();
	System.out.println("patient_id" + patient_id);
	
	int no_of_decimals  = bean.getNoOfDecimals();	
	String language_id  = bean.getLanguageId();	
	
	String view_cost_details_yn = (String)bean.getAccessCostDetails();
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	 nf.setMaximumFractionDigits(noOfDecimalsForCost);
	 nf.setMinimumFractionDigits(noOfDecimalsForCost);
	 String sal_doc_type	=		request.getParameter( "sal_doc_type" )==null?"":request.getParameter( "sal_doc_type" ) ;
	 String doc_no			=		request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;

	 /*GHL-CRF-0557.1 start*/
		Connection	con1=null;
		boolean site=false;
		
		try
		{
			con1	= ConnectionManager.getConnection(request);
			 site = eCommon.Common.CommonBean.isSiteSpecific(con1, "ST","ST_SAL_PRICE_CHANGE");
		}
		finally
		{
			con1.close();
		}
		/*GHL-CRF-0557.1 end*/
	 
if(trn_type.equals("SAL")) {
	try{
	
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			//store_code			=		CommonBean.checkForNull(store_code)+"%";
			store_code			=		CommonBean.checkForNull(store_code,"");
			//item_code			=		CommonBean.checkForNull(item_code)+"%";
			item_code			=		CommonBean.checkForNull(item_code,"");
			from_date			=		CommonBean.checkForNull(from_date,"");
			to_date				=		CommonBean.checkForNull(to_date,"");
			patient_id			=		CommonBean.checkForNull(patient_id);
			//encounter_id		=		CommonBean.checkForNull(encounter_id)+"%";
			encounter_id		=		CommonBean.checkForNull(encounter_id,"");
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			//sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"%");  
			//doc_no				=		CommonBean.checkForNull(doc_no,"%");  
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"");  
			doc_no				=		CommonBean.checkForNull(doc_no,"");  

			String store_code2	=		CommonBean.checkForNull(store_code,"");
			String item_code2	=		CommonBean.checkForNull(item_code,"");
			String from_date2	=		CommonBean.checkForNull(from_date,"");
			String to_date2		=		CommonBean.checkForNull(to_date,"");
			String patient_id2	=		CommonBean.checkForNull(patient_id);
			String encounter_id2=		CommonBean.checkForNull(encounter_id,"");
			String sal_trn_type2=		CommonBean.checkForNull(sal_trn_type,"%");  
			 
			String  sal_doc_type2 = CommonBean.checkForNull(sal_doc_type,"");  
			String doc_no2 = CommonBean.checkForNull(doc_no,"");  

			String strGrandTotFlag ="";

			System.out.println("patient_id" + patient_id + "" + patient_id2);
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store	=		"";
				String prev_item_store	=		"";
				String sal_trn_type_query = "";
				
				 if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and b.take_home_yn ='N'";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and b.take_home_yn ='Y'";
					  sal_trn_type = "I";
				 }

							
				//sqlMap.put("sqlData","SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,i.short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f,IP_NURSING_UNIT_LANG_VW i WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?  AND a.patient_id LIKE UPPER (?) AND a.locn_code = i.nursing_unit_code AND i.language_id='en' AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy') ");
                  
				  //commented by Rabbani #Inc no:36887 on  20/12/2012
				 // sqlMap.put("sqlData","SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?  AND a.patient_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy') ");
				 
				 //Added by Rabbani #Inc no:36887 on  20/12/2012
				//String sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' ";

				//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				//String sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT sum(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' ";
				//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed.
				//String sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,trunc(a.doc_date)))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' ";
				//Modified by suresh.r on 03-11-2014 against Inc 52256(unitcost fun passed modified_date)
				
				/*GHL-CRF-0557.1 start*/
				String sql = "";
				if(site){
					 sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty, ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code)  gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' "; //Modified for AMS-SCF-0970
				}
				else{
					 sql =  "SELECT DISTINCT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code,d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name,a.locn_code,decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ? and language_id= ?),'' )short_desc,a.added_by_id,(CASE WHEN a.sal_trn_type = 'X' THEN (SELECT patient_name  FROM  st_sal_hdr  WHERE  patient_id = a.patient_id AND DOC_NO= a.doc_no AND doc_type_code = a.doc_type_code) END) patient_name1 , b.item_qty sale_qty,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2) item_sal_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, b.take_home_yn, NVL (b.sale_req_qty, 0) sale_req_qty, (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) )   AND a.finalized_yn = 'Y' "; //Modified for AMS-SCF-0970
				}
				/*GHL-CRF-0557.1 end*/ 

				displayFields.add("store_desc"); 
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("sale_qty");
				displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("take_home_yn");
				displayFields.add("short_desc");
				displayFields.add("added_by_id");
				displayFields.add("patient_name1");
				displayFields.add("item_cost_value_new");//Added by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase

				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
				
				//chkFields.add(store_code);
				//chkFields.add(item_code);
				//chkFields.add(sal_trn_type);
				//chkFields.add(patient_id);
				
				//chkFields.add(encounter_id);
				//chkFields.add(sal_doc_type);
				//chkFields.add(doc_no);
			//Added by Rabbani #Inc no:36887 on  20/12/2012 Starts
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))	){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}
			//Added for AMS-CRF-0258			
			sql = sql + " ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')" ;

                //System.out.println("sql==>"+sql);
				//System.out.println("chkFieldschkFields=sales=>"+chkFields);
				sqlMap.put("sqlData",sql);
		//ends
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				//System.out.println("result==>"+result);
				int cnt=2;
				String no_records="";
						int grandpreviouscnt=0;
						int grandnextcnt=0;
						int int_grandpreviouscnt=0;
						int int_grandnextcnt=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{	
					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));
					
					if(((String)result.get(1)).indexOf("(")>0){
						strGrandTotFlag = "N";
					}else{
						strGrandTotFlag = "Y";
					}
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);

						no_records				=		(result.get(1).toString());					
						int_grandpreviouscnt	=		no_records.indexOf('P');
						//System.out.println("int_grandpreviouscnt==>"+int_grandpreviouscnt);
						grandpreviouscnt		=		int_grandpreviouscnt;
						int_grandnextcnt		=		no_records.indexOf('N');
						//System.out.println("int_grandnextcnt==>"+int_grandnextcnt);
						grandnextcnt			=		int_grandnextcnt;
						
						try{
							if(int_grandpreviouscnt > 0)
							{
							if((no_records.substring(int_grandpreviouscnt,(int_grandpreviouscnt+8))).equals("Previous"))
							grandpreviouscnt	=		int_grandpreviouscnt;
							else 
							grandpreviouscnt	=		int_grandpreviouscnt;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt > 0)
							{
							if((no_records.substring(int_grandnextcnt,(int_grandnextcnt+4))).equals("Next")) 
								grandnextcnt	=		int_grandnextcnt;
							}
							else
								grandnextcnt	=		int_grandnextcnt;
							}
							catch(Exception e2) { }
						
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

							ArrayList records=new ArrayList();
							
							for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								records=(ArrayList) result.get(recCount);
						
            _bw.write(_wl_block18Bytes, _wl_block18);

							curr_item_store=(String)records.get(0);
							//System.out.println("curr_item_store==>"+curr_item_store);
							if(!curr_item_store.equals(prev_item_store))
							{
								flag=true;
								if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store.equals(prev_item_store) && cnt > 3)
								{
								if(view_cost_details_yn.equals("Y")){
						
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;									
								
            _bw.write(_wl_block23Bytes, _wl_block23);
}
								else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									pre_cost_value_sub_total+=cost_value_sub_total;
									if(view_cost_details_yn.equals("Y")){
									
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
								}
            _bw.write(_wl_block28Bytes, _wl_block28);

										store_code=CommonBean.checkForNull((String)records.get(0),"");
									
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}

				String str_sales_type = CommonBean.checkForNull((String)records.get(12));
				if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(13)).equals("Y"))){
					 str_sales_type = "H";
				}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(2),"&nbsp;")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(3),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(hshSalesType.get(str_sales_type)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(4),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)));
            _bw.write(_wl_block40Bytes, _wl_block40);

		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);
		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(17),"0"));
	
            _bw.write(_wl_block3Bytes, _wl_block3);
if(view_cost_details_yn.equals("Y"))  {
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(17),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(9),"0")));
            _bw.write(_wl_block48Bytes, _wl_block48);
 if(str_sales_type.equals("X")) {
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(16),"0")));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
	else
	{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(10),"0")));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(14),"")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(15),"")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(records.get(11)));
            _bw.write(_wl_block54Bytes, _wl_block54);

		prev_item_store=curr_item_store;
	//System.out.println("prev_item_store==>"+prev_item_store);
			}	
			grand_tot = grand_tot + subtotal;
		}		
		else{	
            _bw.write(_wl_block55Bytes, _wl_block55);
}
				if(view_cost_details_yn.equals("Y")){

						if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						{
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
				}
		if(view_cost_details_yn.equals("Y")){
		if((grandnextcnt == -1  && grandpreviouscnt > 0 && (result.size() == cnt )) || (strGrandTotFlag.equals("Y")) )
		{
            _bw.write(_wl_block60Bytes, _wl_block60);
  ArrayList  result2=new ArrayList(); 
			result2=bean.queryResultDetails(facility_id,store_code2,item_code2,sal_trn_type2,patient_id2, from_date2 , to_date2,encounter_id2,sal_doc_type2,doc_no2);
		//System.out.println("result2==>"+result2);		
		if((result2.size()>0) )
			{	
						HashMap records2=new HashMap();
						for(int recCount=0; recCount<result2.size(); recCount++)
						{			

							records2=(HashMap)result2.get(recCount);
				
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
			
				String grandt=CommonBean.checkForNull((String)records2.get("grand_tot"),"0");
				String cost_grand_tot = CommonBean.checkForNull((String)records2.get("cost_grand_tot"),"0");
				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bean.setNumberFormat(cost_grand_tot,noOfDecimalsForCost)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.setNumberFormat(grandt,noOfDecimalsForCost)));
            _bw.write(_wl_block65Bytes, _wl_block65);
}	
			}		
		
		}		
	}
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
}

else if(trn_type.equals("SRT")) {

	try{

			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			store_code			=		CommonBean.checkForNull(store_code,"");
			item_code			=		CommonBean.checkForNull(item_code,"");
			from_date			=		CommonBean.checkForNull(from_date,"");
			to_date				=		CommonBean.checkForNull(to_date,"");
			patient_id			=		CommonBean.checkForNull(patient_id);
			encounter_id		=		CommonBean.checkForNull(encounter_id,"");
		 
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"");  
			doc_no				=		CommonBean.checkForNull(doc_no,"");
		
			String store_code3	=		CommonBean.checkForNull(store_code,"");
			String item_code3	=		CommonBean.checkForNull(item_code,"");
			String from_date3	=		CommonBean.checkForNull(from_date,"");
			String to_date3		=		CommonBean.checkForNull(to_date,"");
			String patient_id3	=		CommonBean.checkForNull(patient_id);
			String encounter_id3=		CommonBean.checkForNull(encounter_id,"");
			String sal_trn_type3=		CommonBean.checkForNull(sal_trn_type,"%");  
			 
			String  sal_doc_type3 = CommonBean.checkForNull(sal_doc_type,"");  
			String doc_no3 = CommonBean.checkForNull(doc_no,"");  
			String strGrandTotFlag1 ="";
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store1	=		"";
				String prev_item_store1	=		"";
				
				//Added for AMS-CRF-0258
				String sal_trn_type_query="";
				if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and p.take_home_yn ='N'";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and p.take_home_yn ='Y'";
					  sal_trn_type = "I";
				 }
				//Added for AMS-CRF-0258
				
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, p.short_desc  , a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n , IP_NURSING_UNIT_LANG_VW p WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?   AND a.patient_id LIKE   UPPER (?) AND n.locn_code=p.NURSING_UNIT_CODE	 AND p.language_id = 'en' AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' and a.encounter_id like ? AND a.doc_type_code LIKE ? and a.doc_no like ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')");			
               
			   //commented by Rabbani #Inc no:36887 on  20/12/2012
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ?   AND a.patient_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' and a.encounter_id like ? AND a.doc_type_code LIKE ? and a.doc_no like ? ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')");			
				
				//Added by Rabbani #Inc no:36887 on  20/12/2012
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";

				//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
				//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed.
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
				//Modified by B.Badmavathi against AAKH-SCF-0220 inc#57816 
				
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,  b.item_qty ret_qty,a.added_by_id, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw  where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc ,a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND /*a.sal_trn_type = n.sal_trn_type AND*/ a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND     (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?,'31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'"; //Commented for AMS-CRF-0258
				
				String sql = "SELECT a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc, a.patient_id, f.patient_name, b.item_qty ret_qty, a.added_by_id, n.locn_code, DECODE (a.sal_trn_type, 'I', (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code =n.locn_code AND facility_id = ? AND language_id = ?), 'O', (SELECT short_desc FROM op_clinic_lang_vw WHERE clinic_code =n.locn_code AND facility_id = ? AND language_id = ?), 'D', (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code =n.locn_code AND facility_id = ? AND language_id = ?), 'E', (SELECT short_desc FROM op_clinic_lang_vw WHERE clinic_code = n.locn_code AND facility_id = ? AND language_id = ?), '' ) short_desc, a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value (a.facility_id, b.doc_type_code, b.doc_no, a.patient_id, b.item_code ) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND ((  (  b.item_qty * (st_display_unit_cost (b.item_code, a.modified_date)) ) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code) ), 3 ) item_cost_value_new, a.sal_trn_type, NVL (b.item_qty, 0) sale_req_qty, 0 pen_sal_req_qty, p.take_home_yn FROM st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, st_sal_hdr n, st_sal_dtl p WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.sales_doc_no = n.doc_no AND a.patient_id = n.patient_id AND /*a.sal_trn_type = n.sal_trn_type AND*/ a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ? AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND a.finalized_yn = 'Y' AND p.facility_id = a.facility_id AND p.doc_no = n.doc_no AND p.doc_type_code = n.doc_type_code AND b.item_code = p.item_code"; //Modified for AMS-CRF-0258
				
				displayFields.add("store_desc"); //0	
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("ret_qty");
				displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("short_desc");
				displayFields.add("added_by_id");
				displayFields.add("sales_doc_no");
				displayFields.add("item_cost_value_new"); //Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				displayFields.add("take_home_yn"); //Added for AMS-CRF-0258
				
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				//chkFields.add(store_code);
				//chkFields.add(item_code);
				//chkFields.add(sal_trn_type);
				//chkFields.add(patient_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
				//chkFields.add(encounter_id);
				//chkFields.add(sal_doc_type);
				//chkFields.add(doc_no);
				
		   //Added by Rabbani #Inc no:36887 on  20/12/2012
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}
			//Added for AMS-CRF-0258	 
 			
			sql = sql + " ORDER BY a.store_code,a.doc_no,to_date(doc_date,'dd/mm/yyyy')" ;
			sqlMap.put("sqlData",sql);
				//System.out.println("sql SRT" +sql);
				//System.out.println("chkFields SRT" +chkFields);
				//ends
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				//System.out.println("result498==>"+result);
				int cnt=2;
				String no_records="";
						int grandpreviouscnt1=0;
						int grandnextcnt1=0;
						int int_grandpreviouscnt1=0;
						int int_grandnextcnt1=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{
			
					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));

	
					if(((String)result.get(1)).indexOf("(")>0) {
						
						strGrandTotFlag1 = "N";
					}else{
						strGrandTotFlag1 = "Y";
					}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block67Bytes, _wl_block67);

							
						no_records				=		(result.get(1).toString());
						int_grandpreviouscnt1	=		no_records.indexOf('P');
						grandpreviouscnt1		=		int_grandpreviouscnt1;
						int_grandnextcnt1		=		no_records.indexOf('N');
						grandnextcnt1			=		int_grandnextcnt1;
						
						try{
							if(int_grandpreviouscnt1 > 0)
							{
							if((no_records.substring(int_grandpreviouscnt1,(int_grandpreviouscnt1 +8))).equals("Previous"))
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							else 
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt1 > 0)
							{
							if((no_records.substring(int_grandnextcnt1,(int_grandnextcnt1 +4))).equals("Next")) 
								grandnextcnt1	=		int_grandnextcnt1;
							}
							else
								grandnextcnt1	=		int_grandnextcnt1;
							}
							catch(Exception e2) { }
						
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

						ArrayList records=new ArrayList();
							
							for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								records=(ArrayList) result.get(recCount);
						
            _bw.write(_wl_block18Bytes, _wl_block18);

							curr_item_store1=(String)records.get(0);
							if(!curr_item_store1.equals(prev_item_store1))
							{
								flag=true;
				
								if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store1.equals(prev_item_store1) && cnt > 3)
								{	
								if(view_cost_details_yn.equals("Y")){
					
								
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;
								
            _bw.write(_wl_block74Bytes, _wl_block74);
}
								else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									//System.out.println("pre_subtotal==>"+pre_subtotal);
									pre_cost_value_sub_total+=cost_value_sub_total;
									//System.out.println("pre_cost_value_sub_total==>"+pre_cost_value_sub_total);
									if(view_cost_details_yn.equals("Y")){
									
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
								}
            _bw.write(_wl_block78Bytes, _wl_block78);

									store_code=CommonBean.checkForNull((String)records.get(0),"");								
								
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"")));
            _bw.write(_wl_block80Bytes, _wl_block80);
}

									String str_sales_type = CommonBean.checkForNull((String)records.get(12));
									//Added for AMS-CRF-0258
									if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(17)).equals("Y"))){
										 str_sales_type = "H";
									}
									//Added for AMS-CRF-0258
				
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(2),"&nbsp;")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(3),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(hshSalesType.get(str_sales_type)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(4),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(15),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)));
            _bw.write(_wl_block82Bytes, _wl_block82);

		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);
		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(16),"0"));
	
            _bw.write(_wl_block3Bytes, _wl_block3);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(16),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(9),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(10),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(13),"")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(14),"")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(records.get(11)));
            _bw.write(_wl_block54Bytes, _wl_block54);

		prev_item_store1=curr_item_store1;
	}	
		grand_tot = grand_tot + subtotal;
		}	
		else{
		
            _bw.write(_wl_block85Bytes, _wl_block85);
}
				if(view_cost_details_yn.equals("Y")){

//						if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						if(cnt == result.size())
						{
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
				}
		/*if(view_cost_details_yn.equals("Y")){

		if((grandnextcnt1 == -1  && grandpreviouscnt1 > 0 && (result.size() == cnt )) || (strGrandTotFlag1.equals("Y")) )

		{ *///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
			
            _bw.write(_wl_block60Bytes, _wl_block60);

		/*ArrayList  result3=new ArrayList(); 
	
		result3=bean.QueryResultDetails(facility_id,store_code3,item_code3,sal_trn_type3,patient_id3, from_date3 , to_date3,encounter_id3,sal_doc_type3,doc_no3);
		//System.out.println("result3===>"+ result3);
			
		if((result3.size()>0) )
			{			
				HashMap records3=new HashMap();
				for(int recCount=0; recCount<result3.size(); recCount++)
					{			
							records3=(HashMap)result3.get(recCount);
		*///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
				
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

			/*
						String grandt1=CommonBean.checkForNull((String)records3.get("grand_tot"),"0");
						String cost_grand_tot1 = CommonBean.checkForNull((String)records3.get("cost_grand_tot"),"0");
			*///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
						
            _bw.write(_wl_block63Bytes, _wl_block63);
 /*bean.setNumberFormat(cost_grand_tot1,noOfDecimalsForCost)*/ 
            _bw.write(_wl_block64Bytes, _wl_block64);
 /*bean.setNumberFormat(grandt1,noOfDecimalsForCost)*/ 
            _bw.write(_wl_block90Bytes, _wl_block90);
 //}	//Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
			//}//Below it is commented for display, query is firing unnecessary - AMS-SCF-1073		
		
		//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073		
	//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ result3 JSP :"+e.toString());
	}
}


else if(trn_type.equals("BOT")) 
{

	try{
			
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			store_code			=		CommonBean.checkForNull(store_code,"");
			item_code			=		CommonBean.checkForNull(item_code,"");
			from_date			=		CommonBean.checkForNull(from_date,"");
			to_date				=		CommonBean.checkForNull(to_date,"");
			patient_id			=		CommonBean.checkForNull(patient_id);
			encounter_id		=		CommonBean.checkForNull(encounter_id,"");
			sal_trn_type		=		CommonBean.checkForNull(sal_trn_type,"%");
			sal_doc_type		=		CommonBean.checkForNull(sal_doc_type,"");  
			doc_no				=		CommonBean.checkForNull(doc_no,"");
	

			String store_code3	=		CommonBean.checkForNull(store_code,"");
			String item_code3	=		CommonBean.checkForNull(item_code,"");
			String from_date3	=		CommonBean.checkForNull(from_date,"");
			String to_date3		=		CommonBean.checkForNull(to_date,"");
			String patient_id3	=		CommonBean.checkForNull(patient_id);
			String encounter_id3=		CommonBean.checkForNull(encounter_id,"");
			String sal_trn_type3=		CommonBean.checkForNull(sal_trn_type,"%");  
			String  sal_doc_type3 =		CommonBean.checkForNull(sal_doc_type,"");  
			String doc_no3		=		CommonBean.checkForNull(doc_no,"");  
		

			String strGrandTotFlag1 ="";
			
				HashMap sqlMap			=		new HashMap();
				HashMap funcMap			=		new HashMap();
				ArrayList displayFields =		new ArrayList();
				ArrayList chkFields		=		new ArrayList();
				String curr_item_store1	=		"";
				String prev_item_store1	=		"";
				
				//Added for AMS-CRF-0258
				String sal_trn_type_query = "";
				String sal_trn_type_query_1 = "";
				String sal_trn="";
				if(sal_trn_type.equals("I")){
					  sal_trn_type_query = "and b.take_home_yn ='N'";
					   sal_trn="N";
				 }else if(sal_trn_type.equals("H")){
					  sal_trn_type_query = "and b.take_home_yn ='Y'";
					  sal_trn_type = "I";
					   sal_trn="Y";
				 }
				//Added for AMS-CRF-0258
				
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code,p.short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, IP_NURSING_UNIT_LANG_VW p WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id LIKE   UPPER (?) AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND  a.locn_code = p.nursing_unit_code  AND p.language_id='en'  				UNION ALL  select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, p.short_desc, a.added_by_id, b.item_qty Quantity, a.sales_doc_no, (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n , IP_NURSING_UNIT_LANG_VW p WHERE a.facility_id = b.facility_id AND a.added_by_id = b.added_by_id AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id LIKE   UPPER (?) AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND n.locn_code = p.nursing_unit_code AND p.language_id='en' ORDER BY store_code,doc_date,doc_no");			
				
				//commented by Rabbani #Inc no:36887 on  20/12/2012
				//sqlMap.put ("sqlData","SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? AND a.patient_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND a.encounter_id LIKE ? AND a.doc_type_code LIKE ? AND a.doc_no LIKE ?  ORDER BY store_code,doc_date,doc_no");	
                
				//Added by Rabbani #Inc no:36887 on  20/12/2012
				//String sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ?  AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";	
				//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed.
				/*GHL-CRF-0557.1 start*/
				String sql = "";
				if(site){
					System.out.println("site - true"); 
					sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no, ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,b.take_home_yn  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ?  AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'"; //Modified for AMS-SCF-0970 //Modified for AMS-CRF-0258
				}
				else{
					sql = "SELECT  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name,a.trn_type,a.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  a.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  a.locn_code and facility_id = ?  and language_id= ?),'' )short_desc,a.added_by_id, b.item_qty Quantity, 0 sales_doc_no,(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN ST_DISPLAY_SALE_ITEM_VALUE(a.facility_id,b.doc_type_code,b.doc_no,b.doc_srl_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_sal_value, 0), 2)  item_value, ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type, NVL (b.sale_req_qty, 0) sale_req_qty,  (CASE WHEN (NVL (b.sale_req_qty, 0) - b.item_qty) < 0 THEN 0 ELSE (NVL (b.sale_req_qty, 0) - b.item_qty) END ) pen_sal_req_qty,b.take_home_yn  FROM     st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ?  AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'"; //Modified for AMS-SCF-0970 //Added for AMS-CRF-0258
				}
				/*GHL-CRF-0557.1 start*/
			   
				
    			displayFields.add("store_desc"); //0	
				displayFields.add("item_code");	
				displayFields.add("item_desc");	
				displayFields.add("doc_type_desc");
				displayFields.add("doc_no");
				displayFields.add("doc_date");
				displayFields.add("Quantity");
				displayFields.add("item_cost_value");
				displayFields.add("gross_charge_amt");
				displayFields.add("patient_id");
				displayFields.add("patient_name");
				displayFields.add("store_code");
				displayFields.add("sal_trn_type");
				displayFields.add("added_by_id");
				displayFields.add("trn_type");
				displayFields.add("short_desc");
				displayFields.add("sales_doc_no");
				displayFields.add("item_cost_value_new");//Added by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
				displayFields.add("take_home_yn"); //Added for AMS-CRF-0258


				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
			//Added by Rabbani #Inc no:36887 on  20/12/2012
			if(!(store_code.equals(""))){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query.equals(""))	){
			sql = sql + sal_trn_type_query ;
			}
 			//Added for AMS-CRF-0258
			//sql = sql+" UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN (SELECT SUM(ROUND (NVL (h.upd_gross_charge_amt, 0), 2)) FROM  bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND  g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND  g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id = g.patient_id and h.patient_id=a.patient_id  and g.serv_item_code=b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
			//Modified by Suresh.r against TTM-SCF-0108 inc#50303 Unit_cost,sale_value logic changed. 
			//sql = sql+" UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id AND a.sal_trn_type = n.sal_trn_type AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y'";
			//Modified by B.Badmavathi against AAKH-SCF-0220 IN57816
			sql = sql+" UNION ALL select  a.doc_type_code, c.short_desc doc_type_desc, a.doc_no,b.doc_srl_no, TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.store_code, d.short_desc store_desc, b.item_code, e.short_desc item_desc,a.patient_id, f.patient_name, a.trn_type, n.locn_code, decode( a.sal_trn_type,'I',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ? and language_id= ?),'O',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ?  and language_id= ?),'D',(select short_desc from ip_nursing_unit_lang_vw where  nursing_unit_code =  n.locn_code  and facility_id = ?  and language_id= ?),'E',(select short_desc from OP_CLINIC_LANG_VW where  CLINIC_CODE =  n.locn_code and facility_id = ? and language_id= ?),'' )short_desc, a.added_by_id,-  b.item_qty Quantity, a.sales_doc_no, -(CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN  ROUND (NVL (b.gross_charge_amt, 0), 2) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) gross_charge_amt, ROUND (NVL (b.item_cost_value, 0), 2)  item_value, - ROUND (NVL (b.item_cost_value, 0), 2) item_cost_value, ROUND(((  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) item_cost_value_new, a.sal_trn_type,NVL (b.item_qty, 0) sale_req_qty ,0  pen_sal_req_qty, p.take_home_yn  FROM   st_sal_ret_hdr a, st_sal_ret_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f, ST_SAL_HDR n,ST_SAL_DTL p WHERE a.facility_id = b.facility_id AND  a.doc_type_code = b.doc_type_code AND   a.doc_no = b.doc_no  AND a.sales_doc_no = n.doc_no  AND a.patient_id = n.patient_id /*AND a.sal_trn_type = n.sal_trn_type*/ AND a.store_code = n.store_code AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND   a.facility_id = ? AND   (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012')), 'dd/mm/yyyy' ) ) AND  a.finalized_yn = 'Y' AND p.facility_id=a.facility_id AND p.doc_no = n.doc_no AND p.doc_type_code = n.doc_type_code AND b.item_code = p.item_code"; //Modified for AMS-SCF-0970 //Added for AMS-CRF-0258
				//chkFields.add(store_code);
				//chkFields.add(item_code);
				//chkFields.add(sal_trn_type);
				//chkFields.add(patient_id);
				//chkFields.add(encounter_id);
				//chkFields.add(sal_doc_type);
				//chkFields.add(doc_no);
				
			//Added for AMS-CRF-0258
			if(sal_trn.equals("N")){
				  sal_trn_type_query_1 = "and p.take_home_yn ='N'";
			 }else if(sal_trn.equals("Y")){
				  sal_trn_type_query_1 = "and p.take_home_yn ='Y'";
				  sal_trn_type = "I";
			 }
			 //Added for AMS-CRF-0258
			 
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);
				chkFields.add(facility_id);
				chkFields.add(language_id);

				chkFields.add(facility_id);
				chkFields.add(from_date);
				chkFields.add(to_date);
				 
				
			if(!(store_code.equals(""))	){
			sql = sql + " and a.store_code = ? " ;
			chkFields.add(store_code);
			}	
			if(!(item_code.equals(""))	){
			sql = sql + " and b.item_code = ?  "  ;
			chkFields.add(item_code);
			}
			if(!(sal_trn_type.equals("%"))	){
			sql = sql + " and a.sal_trn_type = ? " ;
			chkFields.add(sal_trn_type);
			}
			if(!(patient_id.equals(""))	){
			sql = sql + " and a.patient_id = ? " ;
			chkFields.add(patient_id);
			}
			if(!(encounter_id.equals(""))	){
			sql = sql + " and a.encounter_id = ? "  ;
			chkFields.add(encounter_id);
			}
			if(!(sal_doc_type.equals(""))){
			sql = sql + " and a.doc_type_code = ? " ;
			chkFields.add(sal_doc_type);
			}
			if(!(doc_no.equals(""))	){
			sql = sql + " and a.doc_no = ? " ;
			chkFields.add(doc_no);
			}
			//Added for AMS-CRF-0258
			if(!(sal_trn_type_query_1.equals(""))	){
			sql = sql + sal_trn_type_query_1 ;
			}
 			//Added for AMS-CRF-0258		
			sql = sql + " ORDER BY store_code,doc_date,doc_no" ;

                 System.out.println("sql BOTH==>"+sql);
				 System.out.println("chkFields 1007==>"+chkFields);
				 sqlMap.put("sqlData",sql);
				 //Added by Rabbani #Inc no:36887 on  20/12/2012 ends
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				int cnt=2;
				String no_records="";
						int grandpreviouscnt1=0;
						int grandnextcnt1=0;
						int int_grandpreviouscnt1=0;
						int int_grandnextcnt1=0;
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{		

					HashMap hshSalesType = new HashMap();
					hshSalesType.put("I",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inpatients.label","common_labels"));
					hshSalesType.put("O",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatients.label","common_labels"));
					hshSalesType.put("R",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Referrals.label","st_labels"));
					hshSalesType.put("H",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"));
					hshSalesType.put("X",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels"));
					hshSalesType.put("E",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
					hshSalesType.put("D",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));
					hshSalesType.put("C",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Consumption.label","st_labels"));

					if(((String)result.get(1)).indexOf("(")>0) {
						
						strGrandTotFlag1 = "N";
					}else{
						strGrandTotFlag1 = "Y";
					}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block91Bytes, _wl_block91);

						no_records				=		(result.get(1).toString());
						int_grandpreviouscnt1	=		no_records.indexOf('P');
						grandpreviouscnt1		=		int_grandpreviouscnt1;
						int_grandnextcnt1		=		no_records.indexOf('N');
						grandnextcnt1			=		int_grandnextcnt1;
						
						try{
							if(int_grandpreviouscnt1 > 0)
							{
							if((no_records.substring(int_grandpreviouscnt1,(int_grandpreviouscnt1 +8))).equals("Previous"))
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							else 
							grandpreviouscnt1	=		int_grandpreviouscnt1;
							}
						}catch(Exception e1) { }
							
							try{
							if(int_grandnextcnt1 > 0)
							{
							if((no_records.substring(int_grandnextcnt1,(int_grandnextcnt1 +4))).equals("Next")) 
								grandnextcnt1	=		int_grandnextcnt1;
							}
							else
								grandnextcnt1	=		int_grandnextcnt1;
							}
							catch(Exception e2) { }
						
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

						ArrayList records=new ArrayList();
						for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++)
							{  
								cnt ++;
								classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
								records=(ArrayList) result.get(recCount);
					
            _bw.write(_wl_block95Bytes, _wl_block95);

							curr_item_store1=(String)records.get(0);
							if(!curr_item_store1.equals(prev_item_store1))
							{
								flag=true;
								//if(cost_value_sub_total>=0 && subtotal >= 0 && !curr_item_store1.equals(prev_item_store1) && cnt > 3)
									if( !curr_item_store1.equals(prev_item_store1) && cnt > 3)
								{	
								if(view_cost_details_yn.equals("Y")){
					
					
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
									subtotal=0.0f;
									cost_value_sub_total=0.0f;
								
            _bw.write(_wl_block97Bytes, _wl_block97);
}	
								//else if(cost_value_sub_total>=0 && subtotal >= 0 && flag==false && store_compare.equals(store_code)) 
								else if(flag==false && store_compare.equals(store_code)) 
									{
									pre_subtotal +=subtotal;
									pre_cost_value_sub_total+=cost_value_sub_total;
									if(view_cost_details_yn.equals("Y")){
									
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+pre_subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block99Bytes, _wl_block99);
}
								}
            _bw.write(_wl_block78Bytes, _wl_block78);

										store_code=CommonBean.checkForNull((String)records.get(0),"");
								
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"")));
            _bw.write(_wl_block101Bytes, _wl_block101);
}

				String str_sales_type = CommonBean.checkForNull((String)records.get(12));
				
				//Added for AMS-CRF-0258
				if(str_sales_type.equals("I") && (CommonBean.checkForNull((String)records.get(18)).equals("Y"))){
					 str_sales_type = "H";
				}
				//Added for AMS-CRF-0258
				
				//System.out.println("str_sales_type==>"+str_sales_type);
				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(2),"&nbsp;")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(14),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(3),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(hshSalesType.get(str_sales_type)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(4),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(DateUtils.convertDate(CommonBean.checkForNull((String)records.get(5),"0"),"DMY","en",locale)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(((String)records.get(16)).equals("0")? "&nbsp;" :(String)records.get(16)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)));
            _bw.write(_wl_block102Bytes, _wl_block102);

		String cost_value_1=CommonBean.checkForNull((String)records.get(8),"0");
		subtotal = subtotal + Double.parseDouble(cost_value_1);
		//cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(7),"0"));
		cost_value_sub_total =cost_value_sub_total+	Double.parseDouble(CommonBean.checkForNull((String)records.get(17),"0"));
		
            _bw.write(_wl_block3Bytes, _wl_block3);
if(view_cost_details_yn.equals("Y")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(7),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(17),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumberFormat(CommonBean.checkForNull((String)records.get(8),"0"),noOfDecimalsForCost)));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(9),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(10),"0")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(15),"")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(13),"")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(records.get(11)));
            _bw.write(_wl_block104Bytes, _wl_block104);

			prev_item_store1=curr_item_store1;
			}
			grand_tot = grand_tot + subtotal;
		}
		else{
            _bw.write(_wl_block85Bytes, _wl_block85);
}
				if(view_cost_details_yn.equals("Y")){

						//if(cnt == result.size() && subtotal >= 0 && cost_value_sub_total>=0)
						if(cnt == result.size())
						{
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+cost_value_sub_total,noOfDecimalsForCost)))));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nf.format(Double.parseDouble(bean.setNumber(""+subtotal,noOfDecimalsForCost)))));
            _bw.write(_wl_block107Bytes, _wl_block107);
}
				}
	/*	if(view_cost_details_yn.equals("Y")){
		//	if((grandnextcnt1 == -1  && grandpreviouscnt1 > 0 && (result.size() == cnt )) || (strGrandTotFlag1.equals("Y")) )
			if((grandnextcnt1 == -1  && (result.size() == cnt )) || (strGrandTotFlag1.equals("Y")) )
		{ *///Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		
            _bw.write(_wl_block60Bytes, _wl_block60);

		
		//ArrayList  result4=new ArrayList(); //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		//result4=bean.QueryResultDetails(facility_id,store_code3,item_code3,sal_trn_type3,patient_id3, from_date3 , to_date3,encounter_id3,sal_doc_type3,doc_no3);  //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		//System.out.println("result4==>"+result4);
		/* if((result4.size()>0) )
			{			
				HashMap records4=new HashMap();
				for(int recCount=0; recCount<result4.size(); recCount++)
				{			
					records4=(HashMap)result4.get(recCount);
		 */
		  //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
				
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

			
				/*String grandt1=CommonBean.checkForNull((String)records4.get("grand_tot"),"0");
				String cost_grand_tot1 = CommonBean.checkForNull((String)records4.get("cost_grand_tot"),"0");
				*/  //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
			
            _bw.write(_wl_block110Bytes, _wl_block110);
/*bean.setNumberFormat(cost_grand_tot1,noOfDecimalsForCost)*/ 
            _bw.write(_wl_block64Bytes, _wl_block64);
/*bean.setNumberFormat(grandt1,noOfDecimalsForCost))*/ 
            _bw.write(_wl_block111Bytes, _wl_block111);
 // }	
		//	}		//Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		
		//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073		
	//} //Below it is commented for display, query is firing unnecessary - AMS-SCF-1073
		out.println(" </table>");
		out.println("	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ result4 JSP :"+e.toString());
	}
}
            _bw.write(_wl_block112Bytes, _wl_block112);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block113Bytes, _wl_block113);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalesType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SaleQuantity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CostValue.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SaleValue.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.nursingunit/clinic.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Createdby.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GrandTotal.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalesType.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SaleRefNo.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReturnQuantity.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CostValue.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReturnValue.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.nursingunit/clinic.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Createdby.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GrandTotal.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.TRNtype.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalesType.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SaleRefNo.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Quantity.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CostValue.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Sales/Return Value.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.nursingunit/clinic.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Createdby.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StoreSubTotal.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GrandTotal.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }
}
