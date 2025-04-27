package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
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
import eCommon.Common.*;
import java.util.*;

public final class __wardacknowledgeresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/WardAcknowledgeResult.jsp", 1742369834097L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title></title>\n<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\ttype=\'text/css\'></link>\n\n<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script language=\"Javascript\" src=\"../../ePH/js/WardAcknowledge.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"setfldFocus(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\")>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\n\t\t\t\t<!--Added for GHL-CRF-0399  [IN062299] start -->\n\t\t\t\t<script>\t\n\t\t\t\t\n\t\t\t\tif(document.formwardaAcknowledge == undefined){\n\t\t\t\t\tparent.wardacknowledgequeryframe.document.FormWardAcknowlegmentQueryCriteria.onch.value=\"\";\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t}</script>\n\t\t\t\t<script>\tif(document.formwardaAcknowledge == undefined){";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.parent.reset();\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t\n\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n<form name=\"formwardaAcknowledge\" id=\"formwardaAcknowledge\">\n\t<!-- <TABLE width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" commented for MMS-KH-CRF-0014 [IN:067953] - Start\n\t\tborder=\"1\"><tr>\n\t\t<th class=\"commontoolbarfunction\" align=\"left\" >&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;,&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =",&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\t\n\t</tr>\n\t<tr></tr>\n\t<tr></tr></table>\n\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\"\n\t\ttopmargin=\'0\'>\n\t\t<tr>\n\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t<td width=\"20%\" class=\"white\">&nbsp; -->";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<!-- \t</td>\n\t\t</tr>\n\t</table> commented for MMS-KH-CRF-0014 [IN:067953] - End -->\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<div  style=\"font-family:verdana;font-size:8pt;COLOR:navy;\" width=\"34%\" class=\"QRYODD\" align=\"right\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\n\t\t <input type=\"text\" style=\"text-align:right;background-color:#fde6d0;padding-left:20px\" name=\"barCodeId\" id=\"barCodeId\" onkeydown=\"if (event.keyCode==13) {barcodeScan(this)}\" maxlength=\"50\">\n\t\t <span style=\"padding-left:68px;\"></span>\n\t</div>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<div style=\"float:left;overflow-y:auto; height:428px; width:100%\"> <!-- Added for MMS-KH-CRF-0014 [IN:067953] -->\n\t<TABLE width=\"100%\" align=\"left\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\" id=\"tablePreRec\"> <!-- id=\"tablePreRec Added for MMS-KH-CRF-0014 [IN:067953] -->\t\t\t\t\t\n\t\t<TR style=\'position:relative;\' style=\'top:expression(this.offsetParent.scrollTop-1)\'>\n\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<!-- added for GHL-CRF-0451 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td> <!-- Modified for TFS-13907 -->\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td> <!-- Modified for TFS-13907 -->\n\t\t\t\t\t\t<!-- added for GHL-CRF-0451 END -->\n\t\t\t<td class=\'COLUMNHEADER\' width=5%>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td> \n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td> <!-- Modified for TFS-13907 -->\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td> <!-- Modified for TFS-13907 -->\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<td class=\'COLUMNHEADER\' width=5%>\n\t\t\t\t<input type=checkbox name=\"selectall\" id=\"selectall\" id=\"selectall\"  onClick=\"selectAll(this)\">\n\t\t\tAcknowledge</td>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n                              <tr> <!-- if else Added for MMS-KH-CRF-0014 [IN:067953] - Start -->\n\t\t                         ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t                         <th class=\"commontoolbarfunction\" align=\"left\" colspan=13 >&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</th>\n\t\t                         ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t                         <th class=\"commontoolbarfunction\" align=\"left\" colspan=12 >&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\n                              </tr>\n                             ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<TR>\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"\n\t\t\t\t\t\t\t\t\tstyle=\"font-family: verdana; font-size: 8pt;\" align=\"left\"><a href=\"#\" onclick=\"viewDrugDetails(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\" id=\'mfrLink\'> ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a>\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"\n\t\t\t\t\t\t\t\t\tstyle=\"font-family: verdana; font-size: 8pt;\" align=\"left\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"\n\t\t\t\t\t\t\t\t\tstyle=\"font-family: verdana; font-size: 8pt;\" align=\"left\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t<!-- added for GHL-CRF-0451 START -->\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<!-- added for GHL-CRF-0451 end-->\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"\n\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: verdana; font-size: 8pt;\" align=\"left\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t<td class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"chk_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"check_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value=\"Y\" checked  onclick=\'assignValue(this,";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =")\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\"\" onclick=\'assignValue(this,";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =")\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="<input type=\"hidden\" name=\"dispno";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"dispno";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"dispNoc";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"orderId";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"orderId";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"orderStatus";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"orderStatus";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"> <!-- Added for MMS-KH-CRF-0014 [IN:067953] -Start -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"orderlineNo";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"orderlineNo";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"actualRowCount";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"actualRowCount";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"> <!-- Added for MMS-KH-CRF-0014 [IN:067953] - End -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srlNo";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"srlNo";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"srlNoc";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"  value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t</TR>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//alert(\'all Selected\');\n\t\t\t\t\t\t//Added for GHL-CRF-0399  [IN062299] start\n\t\t\t\t\t\tif(document.formwardaAcknowledge == undefined){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tdocument.formwardaAcknowledge.selectall.checked =true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//Added for GHL-CRF-0399  [IN062299] end \n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n\n\n\n</TABLE>\n</div> <!-- div ended for MMS-KH-CRF-0014 [IN:067953] -->\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\"hidden\" name=\"total_count\" id=\"total_count\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<INPUT TYPE=\"hidden\" name=\"order_type\" id=\"order_type\" VALUE=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"><!-- added for MMS-KH-CRF-0039-->\n\n</form>\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );
	
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
11/10/2017	  	IN064272	        prathyusha 											GHL-CRF-0466 [IN064272] 
25/03/2019	  	IN067953	        Devindra  											MMS-KH-CRF-0014 [IN:067953] 
28/01/2021	  	12662	        	Manickavasagam J  										MMS-KH-CRF-0039
24/02/2021      TFS-13907     	   Prabha 		12/02/2021     Manickam           	   PH-eCommon label issue in various transactions		
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	    Connection con = null; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
	    boolean barcode_flag = false;
		try{ 
		   con				= ConnectionManager.getConnection(request);
		   barcode_flag = CommonBean.isSiteSpecific(con, "PH", "WARD_ACK_BARCODE_APPL");		   
	    }
	    catch(Exception e){
		   e.printStackTrace(); 
	    }
	    finally
	    {
	    	if(con != null){
	 		   ConnectionManager.returnConnection(con,request);
	 		}
	    } // MMS-KH-CRF-0014 [IN:067953] - End

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(barcode_flag));
            _bw.write(_wl_block9Bytes, _wl_block9);

			String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardAcknowledgeBean";
			String bean_name	= "ePH.WardAcknowledgeBean";
			String facility_id					= (String) session.getValue("facility_id");
                        String check_disable = ""; // Added for GHL-CRF-0399.2
			WardAcknowledgeBean bean = (WardAcknowledgeBean)getBeanObject( bean_id,bean_name,request) ;
			 HashMap		bill_data   = new HashMap();
			bill_data=bean.getCommonStoreMap();
			System.out.println(bean.getCommonStoreMap());
			String clearForm = request.getParameter("ClearForm")==null?"N":(String)request.getParameter("ClearForm");
			if(clearForm.equals("N")){
				bean.clear() ;
			}
			//bean.clear() ;
			bean.setLanguageId(locale);
			bean.setMode(mode);
			//Search Criteria's from Query Criteria page
			String	wardDateTo 			= 	CommonBean.checkForNull(request.getParameter("wardDateTo"));
			String 	wardDateFrom 		= 	CommonBean.checkForNull(request.getParameter("wardDateFrom"));
			String	patientId			=	CommonBean.checkForNull(request.getParameter("patientId"));
			String	dispNo 				= 	CommonBean.checkForNull(request.getParameter("dispno"));
			String	dispLocn 			= 	CommonBean.checkForNull(request.getParameter("dispLocn"));
			String	orderId 			= 	CommonBean.checkForNull(request.getParameter("orderid"));
			String	nursingUnitCode		=	CommonBean.checkForNull(request.getParameter("nursingUnitCode"));
			String	bedNoCode			=	CommonBean.checkForNull(request.getParameter("bedNoCode"));
			String	status				=	CommonBean.checkForNull(request.getParameter("status"));
			String	onch				=	CommonBean.checkForNull(request.getParameter("onch"));//Added for GHL-CRF-0399  [IN062299]
			String order_type			= CommonBean.checkForNull(request.getParameter("order_type"));//MMS-KH-CRF-0039
			String worksheet_id			= CommonBean.checkForNull(request.getParameter("worksheet_id")); //MMS-KH-CRF-0039
			String sql =null;
			
			String status_sql="";
			int rowCount=0;
			int actualRowCount = 0; // Added for MMS-KH-CRF-0014 [IN:067953]
			int checkCount=0;
			//String sql = "SELECT d.drug_desc, c.bed_no, b.added_date,C.LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, B.DISP_LOCN_CODE locn FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi') + 1 AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) ORDER BY b.added_date DESC";
			//Function Parameters
			if(order_type.equals("A")){ //MMS-KH-CRF-0039
				if(status.equals("A")){
					status_sql="and e.WARD_ACKNOWLEDGE = 'A'";
				}
				else{
					status_sql ="and NVL(e.WARD_ACKNOWLEDGE,'$') <> 'A'";
				}

			}else{
				if(status.equals("A")){ //MMS-KH-CRF-0039-end
					status_sql="and a.WARD_ACKNOWLEDGE = 'A'";
				}
				else{
				status_sql ="and NVL(a.WARD_ACKNOWLEDGE,'$') <> 'A'";
				}
			}
			//String sql = "SELECT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi')added_date,(SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code and locn_type = c.locn_type)LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn,am_get_desc.am_practitioner (B.MODIFIED_BY_ID,?,'1')MODIFIED_BY_ID,TO_CHAR (b.modified_date, 'DD/MM/YYYY hh24:mi')modified_date,am_get_desc.am_practitioner (a.ADDED_BY_ID,?,'1')ADDED_BY_ID FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi') + 1 AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) "+status_sql+" ORDER BY b.added_date DESC";
			//String sql = "SELECT distinct d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi')added_date,(SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code and locn_type = c.locn_type)LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no,  TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date1, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn,am_get_desc.am_practitioner (B.MODIFIED_BY_ID,?,'1')MODIFIED_BY_ID,TO_CHAR (b.modified_date, 'DD/MM/YYYY hh24:mi')modified_date,am_get_desc.am_practitioner (a.ADDED_BY_ID,?,'1')ADDED_BY_ID FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND TO_DATE (?, 'dd/mm/yyyy hh24:mi') + 1 AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) and a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id)"+status_sql+" ORDER BY disp_no DESC";
			/* below sql commented for GHL-CRF-0399.2 */
			//String sql="SELECT distinct d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi')added_date,(SELECT short_desc from ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code and locn_type = c.locn_type)LOCN_CODE, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn,TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi')ack_date,(SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id =a.acknowledge_by_id) ack_by_id,(SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id =b.modified_by_id) disp_by_id,am_get_desc.am_practitioner (c.PRES_PHYSICIAN_ID,'en','1') order_by_id FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? and b.added_date BETWEEN TO_DATE (? ||':00', 'dd/mm/yyyy hh24:mi:ss') AND TO_DATE (? ||':59','dd/mm/yyyy hh24:mi:ss') AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) and a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id)"+status_sql+" ORDER BY disp_no DESC";
			/* below sql  Added for GHL-CRF-0399.2 */
			//String sql ="SELECT DISTINCT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi') added_date, (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = a.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (c.pres_physician_id, 'en', '1' ) order_by_id, d.drug_class,(select GENRAL_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) GENRAL_DRUG_YN, (select NARCOTIC_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) NARCOTIC_DRUG_YN, (select CONTROLLED_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) CONTROLLED_DRUG_YN FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND l.patient_id = ? AND b.added_date BETWEEN TO_DATE (? || ':00', 'dd/mm/yyyy hh24:mi:ss' ) AND TO_DATE (? || ':59', 'dd/mm/yyyy hh24:mi:ss' ) AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) AND l.source_code = NVL (?, l.source_code) AND a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+" ORDER BY disp_no DESC";
			String rights_status=bean.getAckRightsDetails((String)session.getValue( "login_user"));//added for GHL-CRF-0466
			//added for mms-kh-crf-0014 start 
			String patient_required="";
		     if(!patientId.equals(""))
		    	 patient_required="AND l.patient_id = ?";
		    		
		     String soure_code_required="";
		     if(!nursingUnitCode.equals("")){
		     soure_code_required=" AND l.source_code= ?";

		     }
		     else{
		     soure_code_required="AND l.source_code = NVL (?, l.source_code)";
		     }
		   //added for mms-kh-crf-0014 end
			//a.disp_qty changed to b.disp_qty changed for IN068342
			if(order_type.equals("A")){ //if condition added for MMS-KH-CRF-0039
				sql ="SELECT DISTINCT e.MFG_UNIT drug_desc, c.bed_no, TO_CHAR (c.added_date, 'DD/MM/YYYY hh24:mi') added_date,(SELECT short_desc  FROM ip_nursing_unit WHERE facility_id = c.facility_id  AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code,  e.worksheet_id disp_no, '1' srl_no,   b.order_id,   '1' order_line_no,(SELECT short_desc  FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code  AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (e.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description  FROM sm_appl_user  WHERE appl_user_id = e.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description  FROM sm_appl_user  WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (l.ord_pract_id,  ?,'1') order_by_id, '' drug_class, 'Y' genral_drug_yn, 'Y' narcotic_drug_yn, 'Y' controlled_drug_yn, DECODE (l.priority, 'R', 'Routine', 'U', 'Urgent') priority,'' order_qty,  QTY_VOLUME dispensedqty, '' issue_uom_desc,e.QTY_UOM desped_uom_desc, l.patient_id,'' order_line_status,c.DISP_LOCN_CODE  FROM  ph_disp_dtl b, ph_disp_hdr c, ph_worksheet_hdr e, st_sal_hdr k, or_order l WHERE b.facility_id = c.facility_id  AND c.facility_id = e.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type  AND k.facility_id = c.facility_id  AND b.disp_no = c.disp_no AND c.order_id = l.order_id  AND b.order_id = c.order_id  AND b.order_id = e.order_id  AND c.order_id = e.order_id AND l.order_id = e.order_id AND l.iv_prep_yn IN ('0','2','4','6')"+patient_required+ " AND b.added_date BETWEEN TO_DATE (?|| ':00','dd/mm/yyyy hh24:mi:ss') AND TO_DATE (?|| ':59','dd/mm/yyyy hh24:mi:ss' )  AND b.facility_id = ? AND e.worksheet_id = NVL (?, e.worksheet_id)  AND l.patient_class = 'IP'" +soure_code_required+" AND b.store_code = NVL (?, b.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+"  ORDER BY e.worksheet_id DESC";
			}else{
			if(rights_status.equals("Y")){//if  else condtion is added for //added for GHL-CRF-0466
				 sql ="SELECT DISTINCT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi') added_date, (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = a.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (c.pres_physician_id, ?, '1' ) order_by_id, d.drug_class,'Y' GENRAL_DRUG_YN, 'Y' NARCOTIC_DRUG_YN, 'Y' CONTROLLED_DRUG_YN,DECODE (l.priority, 'R', 'Routine', 'U', 'Urgent') priority,ol.order_qty, b.disp_qty dispensedqty, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = ol.order_uom AND language_id = ?) issue_uom_desc,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.disp_uom_code AND language_id = ?) desped_uom_desc,l.patient_id,ol.order_line_status,c.DISP_LOCN_CODE FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND ol.order_id = l.order_id AND ol.order_id = b.order_id AND ol.order_line_num = b.order_line_no AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('8') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) "+patient_required+" AND b.added_date BETWEEN TO_DATE (? || ':00', 'dd/mm/yyyy hh24:mi:ss' ) AND TO_DATE (? || ':59', 'dd/mm/yyyy hh24:mi:ss' ) AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) "+soure_code_required+" AND a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+" ORDER BY disp_no DESC"; //modified for  GHL-CRF-0466 // in select 'l.patient_id','ol.order_line_status' & in where condition 'OR l.source_code = ?' & 'AND ol.order_line_num = b.order_line_no' Added for MMS-KH-CRF-0014 [IN:067953]
			}
			else{
			 sql ="SELECT DISTINCT d.drug_desc, c.bed_no, TO_CHAR (b.added_date, 'DD/MM/YYYY hh24:mi') added_date, (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) locn_code, DECODE (j.use_after_expiry_yn, 'Y', 'Y', 'N', DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y' ) ) valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code, a.disp_no, a.srl_no, b.doc_srl_no, b.disp_uom_code qtyuom, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, c.patient_class patient_class, (SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = l.performing_deptloc_code AND language_id = ? AND facility_id = c.facility_id) locn, TO_CHAR (a.ack_modified_date, 'DD/MM/YYYY hh24:mi') ack_date, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = a.acknowledge_by_id) ack_by_id, (SELECT appl_user_name description FROM sm_appl_user WHERE appl_user_id = b.modified_by_id) disp_by_id, am_get_desc.am_practitioner (c.pres_physician_id, ?, '1' ) order_by_id, d.drug_class,(select GENRAL_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) GENRAL_DRUG_YN, (select NARCOTIC_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) NARCOTIC_DRUG_YN, (select CONTROLLED_DRUG_YN from ph_ward_ack_rights where (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = c.locn_code AND locn_type = c.locn_type) = nursing_unit_code AND USER_ID=? ) CONTROLLED_DRUG_YN,DECODE (l.priority, 'R', 'Routine', 'U', 'Urgent') priority,ol.order_qty, b.disp_qty dispensedqty, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = ol.order_uom AND language_id = ?) issue_uom_desc,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.disp_uom_code AND language_id = ?) desped_uom_desc,l.patient_id,ol.order_line_status,c.DISP_LOCN_CODE FROM ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, ph_drug d, st_item j, st_sal_hdr k, or_order l,or_order_line ol WHERE a.facility_id = b.facility_id AND ol.order_id = l.order_id AND ol.order_id = b.order_id AND ol.order_line_num = b.order_line_no  AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND c.order_id = l.order_id AND b.order_id = c.order_id AND NVL (l.iv_prep_yn, 'X') NOT IN ('8') AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') )  "+patient_required+" AND b.added_date BETWEEN TO_DATE (? || ':00', 'dd/mm/yyyy hh24:mi:ss' ) AND TO_DATE (? || ':59', 'dd/mm/yyyy hh24:mi:ss' ) AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND l.patient_class = NVL (?, l.patient_class) AND c.bed_no = NVL (?, c.bed_no) "+soure_code_required+" AND a.store_code = NVL (?, a.store_code) AND c.order_id = NVL (?, c.order_id) "+status_sql+" ORDER BY disp_no DESC"; //modified for  GHL-CRF-0451 // in select 'l.patient_id','ol.order_line_status' & & in where condition 'OR l.source_code = ?' & 'AND ol.order_line_num = b.order_line_no' Added for MMS-KH-CRF-0014 [IN:067953]
			}
			}
			System.out.println("sql==========="+sql);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData",  sql);
			chkFields.add(locale);
			chkFields.add(locale);//Added for GHL-CRF-0451
			if(!order_type.equals("A")){ //MMS-KH-CRF-0039
			
			if(!rights_status.equals("Y")){//if   condtion is added for //added for GHL-CRF-0466
			chkFields.add((String)session.getValue( "login_user" ) ); //  Added for GHL-CRF-0399.2
			chkFields.add((String) session.getValue( "login_user" )	); //  Added for GHL-CRF-0399.2
			chkFields.add((String) session.getValue( "login_user" )	); //  Added for GHL-CRF-0399.2
			}
		    chkFields.add(locale);//ADDED FOR GHL-CRF-0451
			chkFields.add(locale);//ADDED FOR GHL-CRF-0451
			}
			if(!patientId.equals(""))
					chkFields.add(patientId);
			chkFields.add(wardDateFrom);
			chkFields.add(wardDateTo);
			chkFields.add(facility_id);

			if(order_type.equals("A"))  //MMS-KH-CRF-0039
			chkFields.add(worksheet_id);
			else
			chkFields.add(dispNo);

		if(!order_type.equals("A")) //MMS-KH-CRF-0039
			chkFields.add("IP");

		if(!order_type.equals("A")) //MMS-KH-CRF-0039
			chkFields.add(bedNoCode);
			chkFields.add(nursingUnitCode);
			chkFields.add(dispLocn);
			chkFields.add(orderId);
			displayFields.add("DISP_NO");//0
			displayFields.add("ADDED_DATE");//1
			displayFields.add("LOCN");//2
			displayFields.add("BED_NO");//3
			displayFields.add("LOCN_CODE");//4
			displayFields.add("ORDER_ID");//5
			displayFields.add("ACK_DATE");//6
			displayFields.add("ACK_BY_ID");//7
			displayFields.add("DISP_BY_ID");//8
			displayFields.add("ORDER_BY_ID");//9
			displayFields.add("SRL_NO");//10
			displayFields.add("DRUG_CLASS");//11       Added for GHL-CRF-0399.2
			displayFields.add("GENRAL_DRUG_YN");//12   Added for GHL-CRF-0399.2
			displayFields.add("NARCOTIC_DRUG_YN");//13  Added for GHL-CRF-0399.2
			displayFields.add("CONTROLLED_DRUG_YN");//14 Added for GHL-CRF-0399.2
			displayFields.add("DRUG_DESC");//15 //added for GHL-CRF-0451
			displayFields.add("ORDER_QTY");	//16//added for GHL-CRF-0451
			displayFields.add("DISPENSEDQTY");	//17//added for GHL-CRF-0451
			displayFields.add("PRIORITY");//18//added for GHL-CRF-0451
			displayFields.add("ISSUE_UOM_DESC");//19//added for GHL-CRF-0451
			displayFields.add("DESPED_UOM_DESC");//20//added for GHL-CRF-0451
			displayFields.add("PATIENT_ID");//21//added for MMS-KH-CRF-0014 [IN:067953] - Start
			displayFields.add("ORDER_LINE_STATUS");//22
			displayFields.add("ORDER_LINE_NO");//23//added for MMS-KH-CRF-0014 [IN:067953] - End		
			displayFields.add("DISP_LOCN_CODE");//added for MMS-KH-CRF-0039
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			
			//ArrayList batchDetails=bean.getWardAcknowledgeDetails(wardDateTo,wardDateFrom,patientId,dispNo,dispLocn,orderId,nursingUnitCode,bedNoCode,status);
			ArrayList batchDetails=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			//int totalRows=batchDetails.size()/6;
			boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
			if (batchDetails.size()<3){
				
            _bw.write(_wl_block10Bytes, _wl_block10);
	if(onch.equals("Y")){
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
            _bw.write(_wl_block12Bytes, _wl_block12);
if(!onch.equals("Y")){
            _bw.write(_wl_block13Bytes, _wl_block13);
	}
            _bw.write(_wl_block14Bytes, _wl_block14);
			}//Added for GHL-CRF-0399  [IN062299] end
			else{
			/*ArrayList patientDetails=new ArrayList();
			patientDetails=bean.getPatientDetails(patientId);
			String patient_name = (String)patientDetails.get(0);
			String sex	= (String)patientDetails.get(1);
			String age	= (String)patientDetails.get(2);
			
			if(sex.equalsIgnoreCase("female"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex.equalsIgnoreCase("male"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex.equalsIgnoreCase("unknown"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");*/ // commented for  MMS-KH-CRF-0014 [IN:067953]  

            _bw.write(_wl_block15Bytes, _wl_block15);
//patient_name
            _bw.write(_wl_block16Bytes, _wl_block16);
//sex
            _bw.write(_wl_block16Bytes, _wl_block16);
//age
            _bw.write(_wl_block17Bytes, _wl_block17);
//patientId
            _bw.write(_wl_block18Bytes, _wl_block18);

					// For display the previous/next link
					//out.println(batchDetails.get(1));
				
            _bw.write(_wl_block19Bytes, _wl_block19);
if(barcode_flag && !status.equals("A")){ // Added for MMS-KH-CRF-0014 [IN:067953] - Start
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
} // Added for MMS-KH-CRF-0014 [IN:067953] - End 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block27Bytes, _wl_block27);
 //MMS-KH-CRF-0039
					if(order_type.equals("A")){
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}
					
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(status.equals("A")){
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
	}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
            _bw.write(_wl_block41Bytes, _wl_block41);

					ArrayList records=new ArrayList();
 		            String sex = ""; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
 		            String age = ""; 
 		            String patient_name = "";
 		            String tmp_patientId = "";
 		            String order_id = "";
 		            String order_line_no = "";
 		            String order_status = "";
 		            boolean flag = true;
 		            ArrayList patientDetails; // Added for MMS-KH-CRF-0014 [IN:067953] - End
					String classvalue="";
					if(batchDetails!=null){	
						for (int i=2;i<batchDetails.size();i++){
							records =(ArrayList) batchDetails.get(i);

            _bw.write(_wl_block42Bytes, _wl_block42);

							for(int j=0;j<records.size();j+=records.size()){
								check_disable = "";
								sex = "";    // Added for MMS-KH-CRF-0014 [IN:067953] - Start								
			 		                        age = ""; 
			 		                        patient_name = "";
			 		                        patientDetails=new ArrayList();
			 		                        if(flag){			 		        	   			 		        	  			 		        	   
			 		        	            tmp_patientId = CommonBean.checkForNull((String)records.get(j+21));
			 		                        }
			 		                        else{
			 		                           tmp_patientId = patientId;
			 		                        }
			 		                        patientId = CommonBean.checkForNull((String)records.get(j+21));
					                        patientDetails=bean.getPatientDetails(patientId);
					                        patient_name = (String)patientDetails.get(0);
					                        sex	= (String)patientDetails.get(1);
					                        age	= (String)patientDetails.get(2); 
					                        if(sex.equalsIgnoreCase("female"))
						                   sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					                        else if(sex.equalsIgnoreCase("male"))
						                   sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					                        else if(sex.equalsIgnoreCase("unknown"))
						                   sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"); // Added for MMS-KH-CRF-0014 [IN:067953] - End

								if(!order_type.equals("A")){
								if(records.get(j+11).equals("G") && (records.get(j+12)==null || records.equals("") || records.get(j+12).equals("N"))){
									check_disable = "disabled";
								}
								else if(records.get(j+11).equals("N") && (records.get(j+12)==null || records.equals("")  || records.get(j+12).equals("N"))){ // records.get(j+11) changed to records.get(j+12) for AMS-CRF-203 
									check_disable = "disabled";
								}
								else if(records.get(j+11).equals("C") && (records.get(j+12)==null || records.equals("")  || records.get(j+12).equals("N"))){ // records.get(j+11) changed to records.get(j+12) for AMS-CRF-203
									check_disable = "disabled";
								}
								}
																System.err.println("364===============>");
                             if(flag || !tmp_patientId.equals(patientId)){ // Added for MMS-KH-CRF-0014 [IN:067953] - Start
                              flag=false;
                              actualRowCount++; // Added for MMS-KH-CRF-0014 [IN:067953] - End

            _bw.write(_wl_block43Bytes, _wl_block43);
if(status.equals("A")){ // 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block45Bytes, _wl_block45);
} 
            _bw.write(_wl_block47Bytes, _wl_block47);
} // Added for MMS-KH-CRF-0014 [IN:067953] - End
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(records.get(j)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(records.get(j+10)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(records.get(j+24)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(records.get(j)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((((String)(records.get(j+1))).trim()),"DMYHM","en",locale)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+2)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+3)==null?"":records.get(j+3)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+4)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+15)));
            _bw.write(_wl_block58Bytes, _wl_block58);

								if(!order_type.equals("A")){
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+16)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(records.get(j+19)));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
								
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+17)==null?"":records.get(j+17) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(records.get(j+20)==null?"":records.get(j+20)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+18)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+9)==null?"":records.get(j+9)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records.get(j+8)));
            _bw.write(_wl_block58Bytes, _wl_block58);
 if(status.equals("A")){
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(records.get(j+7)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((((String)(records.get(j+6))).trim()),"DMYHM","en",locale)));
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{if(bill_data.containsKey((String)records.get(j)+"_"+(String)records.get(j+10))){ checkCount++;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rowCount ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rowCount ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
} else{
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rowCount ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rowCount ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(check_disable));
            _bw.write(_wl_block77Bytes, _wl_block77);
}}
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(records.get(j)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(records.get(j+5)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(records.get(j+22)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(records.get(j+23)));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(actualRowCount+1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records.get(j+10)));
            _bw.write(_wl_block95Bytes, _wl_block95);

							}

            _bw.write(_wl_block96Bytes, _wl_block96);
         rowCount++; actualRowCount++; // actualRowCount++; Added for MMS-KH-CRF-0014 [IN:067953]
					}
				}
			}
			
			if(rowCount==checkCount){
				
            _bw.write(_wl_block97Bytes, _wl_block97);

			}
		

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( order_type ));
            _bw.write(_wl_block103Bytes, _wl_block103);

		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/WardAcknowledgeResult.jsp?ClearForm=Y", searched) );
		putObjectInBean(bean_id,bean,request); 
}catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
}


            _bw.write(_wl_block104Bytes, _wl_block104);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarCodeId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseNo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProductName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreparedQuantity.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDescription.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseQuantity.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Acknowledgedby.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Acknowledge.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
}
