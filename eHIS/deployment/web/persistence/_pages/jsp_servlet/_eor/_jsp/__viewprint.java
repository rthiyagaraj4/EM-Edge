package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewPrint.jsp", 1738149602000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script Language=\"vbscript\">\n\t\tDim WSHShell\n\t\tDim myHeader\n\t\tDim myFooter\n\t\tDim myMarginleft \n\t\tDim myMarginright \n\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\n\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&bPage &p of &P\"\n\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b&d\"\n\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"0.5\"\n\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"0.3\"\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<STYLE>\n\t\tPRE.RESULTTEXTAREAEVEN\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/* IN043895 Start*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\t\t/*IN049424 Start.*/\t\t\t\n\t\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/\n\t\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t\t/*IN049424 End.*/\n\t\t\t/* IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #F0F0F2;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\tword-break: break-all; /* webkit */\n\t\t\tword-wrap: break-word;\n\t\t\twhite-space: pre;\n\t\t\twhite-space: -moz-pre-wrap; /* fennec */\n\t\t\twhite-space: pre-wrap;\n\t\t\twhite-space: pre\\9; /* IE7+ */\t\n\t\t\tmargin:0;\n\t\t\tpadding:0;\n\t\t}\t\n\t\t\n\t\tPRE.RESULTTEXTAREAODD\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/* IN043895 Start*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\t\t/*IN049424 Start.*/\t\t\t\n\t\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/\n\t\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t\t/*IN049424 End.*/\n\t\t\t/* IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\tword-break: break-all; /* webkit */\n\t\t\tword-wrap: break-word;\n\t\t\twhite-space: pre;\n\t\t\twhite-space: -moz-pre-wrap; /* fennec */\n\t\t\twhite-space: pre-wrap;\n\t\t\twhite-space: pre\\9; /* IE7+ */\n\t\t\tmargin:0;\n\t\t\tpadding:0;\n\t\t}\t\n\t\tPRE\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/* IN043895 Start*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\t\t/*IN049424 Start.*/\t\t\t\n\t\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/\n\t\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t\t/*IN049424 End.*/\n\t\t\t/* IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\tword-break: break-all; /* webkit */\n\t\t\tword-wrap: break-word;\n\t\t\twhite-space: pre;\n\t\t\twhite-space: -moz-pre-wrap; /* fennec */\n\t\t\twhite-space: pre-wrap;\n\t\t\twhite-space: pre\\9; /* IE7+ */\n\t\t\tmargin:0;\n\t\t\tpadding:0;\n\t\t}\t\n\t\t\n\t\tTD.LABEL1\n\t\t{\n\t\t  COLOR:#444444;\n\t\t  background-color:#FFFFFF;\n\t\t  FONT-SIZE: 8pt;\n\t\t  TEXT-ALIGN: CENTER;\n\n\t\t}\n\t\t/* IN043895 Start*/\n\t\t\t/* IN049424 Start.*/\n\t\t\t\t/*ADDRESS\t{ \n\t\t\t\t\tFONT-FAMILY: \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\" ;\n\t\t\t\t\tFONT-SIZE: 10pt ; \n\t\t\t\t\tFONT-STYLE: NORMAL; \n\t\t\t\t\tCOLOR: BLACK; \n\t\t\t\t}*/\n\t\t\t\tADDRESS\t{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t\t\t/* IN049424 End.*/\t\t\t\n\t\t/* IN043895 End.*/\n\t</STYLE>\n\n</head>\n<body onLoad=\'\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<Form name=\'view_order_prn\' id=\'view_order_prn\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\">\n<tr><td>\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" class=\"grid\"> <!--Made changes to the table tag content for header center alignment - IN037045  -->\n\t<tr>\n\t\t<tr>\n\t\t<!--<td align=\'left\' width=\'5%\' rowspan=\"4\">--><!--IN068669-->\n\t\t\t<td align=\'left\' width=\'5%\' rowspan=\"5\"><!--IN068669-->\n\t\t\t<!-- <img valign=\'top\' src=\'../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\' width=\'40\' height=\'40\'  border=\'0\'></img>-->\n\t\t\t<img valign=\'top\' src=\'../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\' width=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" height=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" border=\'0\'></img><!-- IN068669 -->\n\t\t</td>\n\t\t</tr>\n\t\t<td  class=\"label1\" width=\'88%\' nowrap align=\"center\"><Font size=\'3\'><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></Font></td>\n\t\t<td class=\"label1\" width=\'\'></td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label1\' width=\'88%\' align=\"center\"><Font size=\'3\'><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></Font></TD>\n\t\t<td class=\"label1\" width=\'\'></td>\n\t</TR>\n\t<TR>\n\t\t<TD class=\'label1\' width=\'88%\' align=\"center\"><Font size=\'3\'><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></Font></TD>\n\t\t<td class=\"label1\" width=\'\'></td>\n\t</TR>\n\t<TR>\n\t\t<!--<td class=\"label1\" width=\'6%\' nowrap></td>--><!--IN068669-->\n\t\t<!--<td class=\"label1\" width=\'32%\'></td> -->\n\t\t<TD class=\'label1\' width=\'88%\' nowrap align=\"center\"><Font size=\'3\'><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></Font></TD>\n\t\t<td class=\"label1\" width=\'\'></td>\n\t</TR>\n\n</table>\n</TD></TR>\n<TR><TD>\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=\"center\">\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'label\' width=\"25%\"><B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<!-- IN037725  Changed Alignement of elements-->\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td class=\'label\' wrap width=\"25%\"><B>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B></td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td> <!-- IN037725 -->\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></td>\n\t\t\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td><!-- IN058811 New Label-->\n\t\t<td class=\'label\' width=\"25%\"><B>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</B></td><!-- IN058811 New Label -->\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td> <!-- IN058811 changed order-->\n\t\t<td class=\'label\' width=\"25%\"><B>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</B></td> <!-- IN058811 changed order-->\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</B></td>\n\t\t<!-- IN058811 start changed order-->\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<td class=\'label\' width=\"25%\"><B>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</B></td> \n\t<!-- IN058811 Ends changed order-->\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td> <!-- IN058811 changed order-->\n\t\t<td class=\'label\' width=\"25%\" title=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><B>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</B></td><!-- IN058811 changed order--> \n\n\t</tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<tr>\n\t\t<td class=\"label\" colspan=\"4\"><hr color=thickblue height=1></td>\n\t</tr> \t\n\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<td class=\'label\'  colspan=3 wrap style=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\n<table cellpadding=3 cellspacing=0 border=0 align=center width=\'100%\' class=\'label\'>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<td class=\"label\"  width=\"36%\"><font size=1>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<td class=\"fields\" width=\"64%\"><font size=1><B>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</B></td>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td class=label   width=\'36%\'><font size=1>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<td  width=\'64%\'><font size=1><B>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<td class=label  width=\'36%\'><font size=1>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<td width=\'64%\' class=label><font size=1><B>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t</table>\n\t\t</td>\n\t\t</tr>\t\n\t\t<tr>\n\t\t\t<td class=\"label\" colspan=\"4\"><hr color=thickblue height=1></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\" wrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =":</td>\n\t\t<td class=\'label\' colspan=\"3\" width=\"75%\" wrap>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"25%\" wrap>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t<td class=\'label\' colspan=\"3\" width=\"75%\" wrap><B>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</B></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n</table>\n</TD></TR>\n<TR><TD>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"  style=\"word-wrap:break-word;\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</PRE>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\n\t\t\t\t\t\t\t\t\t\t<textarea rows=\"4\" cols=\"90\"  CLASS = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" READONLY>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</textarea>\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</PRE>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" style=\"word-wrap:break-word;\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</PRE>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</PRE>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!--<PRE CLASS=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</PRE>-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewResultComment(escape(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'))\">C</a>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<img src=\'../../eCA/images/";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =".gif\' width=\'16\' height=\'16\' border=0 alt=\'Result\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n</TD></TR></TABLE>\n<!-- 35142 Start. -->\n<input type=hidden id=\"pkiSiteSpecificYN\" name=\"pkiSiteSpecificYN\" id=\"pkiSiteSpecificYN\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"/>\n<input type=hidden id=\"quePkiStatus\" name=\"quePkiStatus\" id=\"quePkiStatus\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"/>\n<input type=hidden id=\"quePkiStatusText\" name=\"quePkiStatusText\" id=\"quePkiStatusText\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"/>\n<input type=hidden id=\"quePkiId\" name=\"quePkiId\" id=\"quePkiId\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"/>\t\n<input type=hidden id=\"quePkiToken\" name=\"quePkiToken\" id=\"quePkiToken\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"/>\n<input type=hidden id=\"quePkiNumber\" name=\"quePkiNumber\" id=\"quePkiNumber\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"/>\n<input type=hidden id=\"quePkiIsueDateTime\" name=\"quePkiIsueDateTime\" id=\"quePkiIsueDateTime\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"/>\n<input type=hidden id=\"quePkiCallDateTime\" name=\"quePkiCallDateTime\" id=\"quePkiCallDateTime\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"/>\t\n\n<input type=hidden id=\"ordFacilityId\" name=\"ordFacilityId\" id=\"ordFacilityId\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"/>\n<input type=hidden id=\"patientId\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"/>\n<input type=hidden id=\"encounterId\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"/>\n<input type=hidden id=\"referenceId\" name=\"referenceId\" id=\"referenceId\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"/>\n<input type=hidden id=\"userId\" name=\"userId\" id=\"userId\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/>\n<!-- 35142 End. -->\n</Form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );
	
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
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------
?             100            ?           	created
10/10/2011	  IN29171		 DineshT	 	Changes done to show some of the missing records in the thai language
15/10/2011	  IN29171		 MenakaV	 	OR>Existing Order>Result Print Preview webpage.
											In English screen after click print preview, some result disappear.
27/01/2012	  INO30714		Menaka V		THAI screen>View Clinical Event History>View>In the Recorded
											Clinical Note the name is not displayed in THAI
08/02/2012	  IN030996		Menaka V	 	CA>Patient Chart>Clinical event history>When the already recorded details
											are accessed we get Java Lang null pointer exception Script Error. 	
12/09/2012    IN033152      Chowminya G  	Changed 'ext_image_appl_id' to 'Result' in alt 	
17/10/2012    IN029203		Ramesh G		Result reporting > Print preview > Result is not good alignment. 
											It happened in both Thai and English language.		
29/10/2012	  IN029396	
14/12/2012	  IN031684		Ramesh G		Group test name is not showing in from Order management function.	
07/01/2012	  IN032246		Ramesh G 		Result view from Existing Orders, doesn't show the similar format as it's shows on the Print Preview 
											and LIS (View/Print Draft Copy).	
25/02/2013	  IN037045	    Chowminya G		CA Report logo/header alignment
09/04/2013    IN039067      Ramesh G        RD result aligment  
03/06/2013	  ConnProb	 	Ramesh G	    Connection Closed								
07/06/2013    IN037725	    Chowminya G     Age n Gender of the patient is displaying on the same line as the patient ID
11/06/2013    IN039361      Ramesh G        RD result aligment 	
12/06/2013    IN040745		Chowminya G     Resulted Values are not displaying in Result - Laboratory Order Webpage 
11/10/2013	  IN043940		Ramesh G		Place an Order Set for which single order ID to be generated-
											Register-Do Result reporting for Placed Order Set.
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality	
-----------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
18/04/2013	IN041256		Ramesh G		18/04/2014		Akbar S			The entered text is displayed with more spacing available for each  line. 
																				Click on print ->Some part of data is trimmed in print out page.
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
01/12/2014	IN052367		ChowminyaG 										Signature not published in Result linked clinical notes
17/12/2014	IN053047		Ramesh G		17/12/2014		Akbar S			In Order Tracking , when user try to print the Radiology report like below , it gets truncated in print out....
20/03/2015	IN054648		Ramesh G		20/03/2015		Akbar S			RESULTED REPORT RANGE COMMENTS ARE DISPLAYING IN OR.NOTE: REPORT RANGE COMMENT SETUP IS <REPORT RANGE COMMENT>
21/07/2015  IN056353		Ramesh G		21/07/2015      Akbar S			GHL-SCF-942 : Radilogy report blank page printout
24/3/2016	IN058811		Raja S			24/03/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable (ALL 																				Order Categories) is a national requirement.
07/08/2017	IN062473		Raja S			07/08/2017		Ramesh g		SKR-SCF-1144
07/02/2018	IN065970		Vijayakumar K		07/02/2018		RameshGo	ML-BRU-SCF-1611.1 [IN:065970]
14/03/2018	IN066982		Kamalakannan G	14/03/2018		Ramesh G		report practitioner name is not displaying
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
06/01/2020	IN072011		Sivabagyam		06/01/2020		Ramesh G		Common-ICN-0015
21/02/2020	IN072540	SIVABAGYAM M		21/02/2020		RAMESH G		MO-GN-5553
12/05/2020	IN072988	Ramesh Goli			12/05/2020		RAMESH G		OR-PMG2020-TECH-CRF-0005/01-Print Preview Result
06/06/2020	IN071753		Abhishek M		09/06/2020		Ramesh G		SKR-SCF-1298
02/11/2022  35142           Krishna Pranay  03/11/2022  Ramesh G        TH-KW-CRF-0020.6
-----------------------------------------------------------------------------------------------------------------------------------------------------
*/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String mode	   = "1";
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String bean_id1 = "Or_ViewOrder" ; 
	String bean_name1 = "eOR.ViewOrder";
	String orderId = request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");
	String patient_id = request.getParameter("patient_id");
	String ord_cat = request.getParameter("ord_cat");
	String order_status = request.getParameter("order_status");
	String pract_reln_id = request.getParameter("pract_reln_id");
	String screen_width = request.getParameter("screen_width");
	String view_by = request.getParameter("view_by");//IN061961
	String event_code1=request.getParameter("event_code"); //IN061961
	//int detail_text_width=900;//commented for IN061961
	int colswidth = Integer.parseInt(screen_width)/4;
	int colwidth = Integer.parseInt(screen_width)/2;
	colswidth =150;
	colwidth = 400;		
	String facility_id = (String)session.getValue("facility_id");
	String resp_id		= (String)session.getValue("responsibility_id");
	//String toolTipTextArea = "Double Click to Zoom";Commented by Uma on 4/28/2010 for IN020979
	if(resp_id== null)	
		resp_id = "";

	if(order_line_num.equals("") || order_line_num == null)	
		order_line_num = "";

	if (order_status == null) 
		order_status = "";

	String[] allValues = new String[43];
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	allValues		= bean.viewPrintDetails(orderId);
	String order_type_code = bean.checkForNull(allValues[39]);
	ArrayList allValues1 = new ArrayList();
	ViewOrder bean1 = (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean1.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean1.clear() ;
	bean1.setMode(mode) ;
	String result_data[] = (String[])bean1.getAbnormalCondition();	
	String high_str			= result_data[0];
	String low_str			= result_data[1];
	String abn_str			= result_data[2];
	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String location="";
	String patient_details="";				 
	String slClassValue = "", textClassValue= "";	
	String encounterdate = "";
	String sex1 = "";
	//IN042552 Start.
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
	//allValues1		= bean1.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status, pract_reln_id);
	allValues1		= bean1.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status, pract_reln_id,clinician_id,event_code1,view_by);//IN061961
	//IN042552 End.
	TreeMap first_map = null;
	ArrayList 	 panels		= 	bean1.panels ;
	String header_time="";
	TreeMap header_all_times = (TreeMap)bean1.getAllTimes(9,allValues1);	
	Set header_all_times_set = (Set)header_all_times.keySet();
	Iterator header_itr_times = (Iterator)header_all_times_set.iterator() ;			
	header_itr_times = (Iterator)header_all_times_set.iterator() ;
	
	while(header_itr_times.hasNext())
	{
		//Iterate Time values of header
		header_time = (String)header_itr_times.next();
	}
	//INO30714 Starts
	java.util.Properties pr = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) pr.getProperty("LOCALE");
	String		performed_by_id	=	"" ;
	String accession_num			= "";
	String		patient_class		=	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String		encounter_id	=	request.getParameter("encounter_id");
	String		facility_name	=	"" ;
	String		visit_adm_date	=	"" ;
	String		attending_practitioner	=	"" ;
	String		admitting_practitioner	=	"" ;
	String		bed_number	=	"" ;
	String		performing_phy_name	=	"" ;
	String		age	=	"" ;
	String		gender	=	"" ;
	String		patient_name	=	"" ;
	String		speciality_name	=	"" ;
	String		printDateTime	=	"" ;
	String		site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String		query_privilege_type	=	"" ;
	Connection			con			=	null;
	PreparedStatement	pstmt2			=	null;
	ResultSet			rs2				=	null;
	PreparedStatement	pstmt			=	null;
	ResultSet			rs				=	null;
	String  url1					=	"";
	String  url						=	"";
	String footer_code = null;
	String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	//url   = HttpUtils.getRequestURL(request).toString(); //IN072011
	//url = url.substring(0,url.indexOf("jsp/"));	
	url	= application.getRealPath("/eOR")+"/";//ADDED FOR COMMON-ICN-0015
	url = url.substring(0,url.indexOf("eOR/")); //IN072988
	url1 = url + "eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	url =url+"eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String	login_user_id		=	(String)session.getValue("login_user");
	String  sect_template_query		=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String acc_for_notefooter = "";//IN052367
	//IN066982 Changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN066982 changes ends
	HashMap<String,String> paramMap = null;
	
	try
	{
	con	= ConnectionManager.getConnection();
	//sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
	isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");//IN066982
	if(	episode_type.equals("O") )
			{
				
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
			}
			else
			{ 
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
			}
			pstmt	=	con.prepareStatement(query_privilege_type);
			pstmt.setString	(	1,	locale	);
			pstmt.setString	(	2,	locale	);
			pstmt.setString	(	3,	locale	);
			pstmt.setString	(	4,	locale	);
			pstmt.setString	(	5,	performed_by_id	);
			pstmt.setString	(	6,	locale	);
			pstmt.setString	(	7,	locale	);			
			pstmt.setString	(	8,	locale	);			
			pstmt.setString	(	9,	locale	);			
			pstmt.setString	(	10,	locale	);			
			pstmt.setString	(	11,	facility_id	);
			pstmt.setString	(	12,	encounter_id);

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				patient_class	=	rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
				facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
				med_service			=	rs.getString("service_name")==null?"":rs.getString("service_name");
				discharge_date		=	rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
				admitting_practitioner	=	rs.getString("admitting_practitioner")==null?"":rs.getString("admitting_practitioner");
				bed_number	=	rs.getString("bed_number")==null?"":rs.getString("bed_number");	  //--[IN:029839]--
				performing_phy_name	=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
				age				=	rs.getString("AGE")==null?"":rs.getString("AGE");
				gender					=	rs.getString("gender")==null?"":rs.getString("gender");
				//locationDesc			=	rs.getString("location");
				location_code			=	rs.getString("location_code")==null?"":rs.getString("location_code");
				patient_name			=	rs.getString("patient_name")==null?"":rs.getString("patient_name");
				speciality_name			=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
				printDateTime			=	rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
				site_name			=	rs.getString("site_name")==null?"":rs.getString("site_name");
				//performed_by_desc			=	rs.getString("performed_by_desc");


			
			}

				if(gender.equals("M"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				if(discharge_date==null)
				{
					discharge_date="";
				}
				if(patient_class.equals("OP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null)	rs.close();
				if(pstmt!=null)	pstmt.close();
			}
			
	//INO30714 ends
	ArrayList 	 discrete	=	bean1.discrete ;
	String [] print_details = {"","","","","","",""};
    print_details = (String[])bean.getOrderDetails(orderId);
    order_status = print_details[6];
	/*ADDED BY Deepa */
	ArrayList repPractList = new ArrayList();
	String textToolTip = "";
	String repPract = "";
	String repPractName = "";
	String status = "";
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40"; //IN068669
	try
	{
		repPractList = (ArrayList) bean1.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,request.getParameter("ord_cat"),order_status,cont_order_ind);
	
		if(repPractList.size() > 0)
		{
			repPract = (String) repPractList.get(0);	
			repPractName = (String) bean1.getRepPractName(repPract, localeName);

			if(repPractList.size() == 1) 
			{
				repPractName = repPractName;
				textToolTip = "";
			}
			else 
			{
				repPractName = repPractName + " * ";
				textToolTip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.multipleRepPract.label","or_labels");;
			}
		}
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	/*ADDED BY Deepa */
	
	ArrayList practitionerDetails = new ArrayList();	
	practitionerDetails = bean.getPractitionerDetails(orderId,cont_order_ind,facility_id,request.getParameter("ord_cat"),order_type_code);	
	int timeHeader = 0;

	if (practitionerDetails.size() == 2) 
		timeHeader = 1;

	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals(""))
	{
		allValues[2] = "R";
	}

	if(allValues[2].compareTo("R")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	}
	else if(allValues[2].compareTo("U")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
	}
	else if(allValues[2].compareTo("S")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
	}	

	if(allValues[3] == null) 
		allValues[3] = "";
	
	if(allValues[3].equalsIgnoreCase("M"))
	{
		sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	}
	else if(allValues[3].equalsIgnoreCase("F"))
	{
		sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	}
	
	if(allValues[36] == null) 
		allValues[36] = "";

	if(allValues[36].equalsIgnoreCase("C"))
	{
		location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N"))
	{
		location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("R"))
	{
		location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}

	//patient_details = allValues[35]+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"/"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+" "+allValues[34]+"/"+sex1;
	//Commentted IN037725
	patient_details = allValues[35]; //IN037725
	//IN068669 STARTS
	try
	{	
		con	= ConnectionManager.getConnection();
		pstmt =	con.prepareStatement("select LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT FROM ca_note_param");
		rs	=	pstmt.executeQuery();
		if(rs.next())
		{
			LOGO_HDR_WIDTH	= rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH");
			LOGO_HDR_HEIGHT	= rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT");
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
    }
	catch(Exception e)
	{
		//out.println("Exception@111 - in getting logo and report header: "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
//IN068669 ENDS

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(LOGO_HDR_WIDTH));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(LOGO_HDR_HEIGHT));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((bean.printSiteName()==null)?"":bean.printSiteName()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((bean1.getFacilityName() == null)? "" : bean1.getFacilityName()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((allValues[0] == null)? "" : allValues[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((allValues[1] == null)? "" : allValues[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[6] == null)? "" : allValues[6]));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[4]==null)?"":allValues[4]));
            _bw.write(_wl_block20Bytes, _wl_block20);

	encounterdate = allValues[12];

	if(encounterdate == null) 
		encounterdate = "";

	if(encounterdate.contains("/"))
	{
		if(encounterdate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(encounterdate,"DMYHMS",localeName))
			{
				encounterdate = com.ehis.util.DateUtils.convertDate(encounterdate,"DMYHMS","en",localeName);
			}
		}
		else if(encounterdate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(encounterdate,"DMYHM",localeName))
			{
				encounterdate = com.ehis.util.DateUtils.convertDate(encounterdate,"DMYHM","en",localeName);
			}
		}
		else if(encounterdate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
		{
			 if(com.ehis.util.DateUtils.validDate(encounterdate,"DMY",localeName))
			{
				encounterdate = com.ehis.util.DateUtils.convertDate(encounterdate,"DMY","en",localeName);
			}
		}
	}
	
	if(header_time == null) 
		header_time = "";

	if(header_time.contains("/"))
	{
		if(header_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(header_time,"DMYHMS",localeName))
			{
				header_time = com.ehis.util.DateUtils.convertDate(header_time,"DMYHMS","en",localeName);
			}
		}
		else if(header_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(header_time,"DMYHM",localeName))
			{
				header_time = com.ehis.util.DateUtils.convertDate(header_time,"DMYHM","en",localeName);
			}
		}
		else if(header_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
		{
			if(com.ehis.util.DateUtils.validDate(header_time,"DMY",localeName))
			{
				header_time = com.ehis.util.DateUtils.convertDate(header_time,"DMY","en",localeName);
			}
		}
	}

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((patient_details== null)? "" : patient_details));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[12]==null)?"":encounterdate));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[34]==null)?"":allValues[34]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((sex1== null)? "" : sex1));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((orderId==null)?"":orderId));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[39]== null)? "" :allValues[39]));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((allValues[40]== null)? "" :allValues[40]));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[40]== null)? "" :allValues[40]));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((allValues[12]==null)?"":encounterdate));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(location));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allValues[38]));
            _bw.write(_wl_block31Bytes, _wl_block31);

	if(allValues[41].equalsIgnoreCase("IBARL"))
	{

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

	}
	else
	{

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

	}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((header_time==null)?"":header_time));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((allValues[7]== null)? "" :allValues[7]));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(textToolTip));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(repPractName));
            _bw.write(_wl_block38Bytes, _wl_block38);

	if(allValues[10] == null) 
		allValues[10] = "";

	ArrayList order_format_dtl = bean1.getOrderFormatDetail( orderId ) ;

	if(order_format_dtl.size()>0)
	{

            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
if(order_format_dtl.size() > 0)out.println("BACKGROUND-COLOR: #637BBD ;");
            _bw.write(_wl_block41Bytes, _wl_block41);

	}

            _bw.write(_wl_block42Bytes, _wl_block42);

	int j=0;
	String checked = "";
	
	for(int i=0; i<order_format_dtl.size(); i++)
	{
		String ordr_record[] = (String[])order_format_dtl.get(i);

		if(ordr_record[2] == null) 
			ordr_record[2] = "";

		if(!ordr_record[2].equals(""))
		{
			if(i%1 == 0)
			{
				out.println("<tr>");
				j++;
			}

			if(ordr_record[0].equals("A"))
			{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ordr_record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);

				if(ordr_record[2] == null) 
					ordr_record[2] = "";

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ordr_record[2]));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
			else if(ordr_record[0].equals("C"))
			{
 				if((ordr_record[2].trim()).equalsIgnoreCase("N") || (ordr_record[2].trim()).equals(""))
					checked = "No";
				else 
					checked = "yes";

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ordr_record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);

				if(ordr_record[2] == null) 
					ordr_record[2] = "";

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
			else
			{

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ordr_record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);

				if(ordr_record[2] == null) 
					ordr_record[2] = "";

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ordr_record[2]));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
		}
	}
	
	if(order_format_dtl.size()>0)
	{

            _bw.write(_wl_block50Bytes, _wl_block50);

	}

	String max_num = "0";
	String reportingTime = "";
	String max_action_seq_num		= allValues[29];
	
	if(max_action_seq_num == null)
		max_action_seq_num = "";
	else 
		max_action_seq_num = max_action_seq_num.trim();
		
	max_num = max_action_seq_num;

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean1.getComments(orderId,max_num)));
            _bw.write(_wl_block53Bytes, _wl_block53);

	if(allValues[41].equalsIgnoreCase("IBARL"))
	{
		/*Added by Uma on 12/1/2010 for IN025168*/
		reportingTime = (String)allValues[42];
		reportingTime = com.ehis.util.DateUtils.convertDate(reportingTime,"DMYHM","en",localeName);
		/*Ends Here*/

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reportingTime));
            _bw.write(_wl_block56Bytes, _wl_block56);

	}

            _bw.write(_wl_block57Bytes, _wl_block57);
	
	if(allValues1.size() == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
	}
	else 
	{
		first_map = (TreeMap)bean1.traverseList(1,allValues1,first_map);
		TreeMap second_map = (TreeMap)bean1.traverseList(2,allValues1,first_map);
		TreeMap third_map = (TreeMap)bean1.traverseList(9,allValues1,second_map);
		TreeMap all_times = (TreeMap)bean1.getAllTimes(9,allValues1);
		HashMap key_value_map1 = (HashMap)bean1.getKeyValueData1();
		HashMap key_value_map2 = (HashMap)bean1.getKeyValueData2();
		Set all_times_set = (Set)all_times.keySet();
		Iterator itr_times = (Iterator)all_times_set.iterator() ;
		//int panel=0;//commented for checkstyleIN061961
		int header=0;
		String reporting_practitioner = "";
		out.println("<table cellpadding=0 cellspacing=0 border=1 width='100%'>");
		String dup_time="";			
		int i = 1;
		//boolean main_hdr = true;//commeneted for checkstyleIN061961
		String temp_panel_key="";  //[32119]
		for(int K = 0 ; K < panels.size() ; K++)
		{
			// panel Iteration
			String ext_image_obj_id		= "";
			String ext_image_appl_id	= "";
			String hist_rec_type			= "";//IN066982
			String panel_key = (String)panels.get(K);
			TreeMap dscr_map = (TreeMap)third_map.get(panel_key);			
			itr_times = (Iterator)all_times_set.iterator() ;
			
			while(itr_times.hasNext())
			{
				//Iterate Time values of header
				String hdr_time = (String)itr_times.next();
				//boolean hdr_req = true;//commented for checkstyleIN061961
			
				for(int l = 0; l < discrete.size(); l++)
				{ 
					// descr iteration
					//Added by Siva Kumar on 10/9/2003
					String color = "";
					String toolTipText = "";
					reporting_practitioner = "";
					//End of Addition
					if(i % 2 == 0)
					{
						slClassValue = "QRYEVEN";
						textClassValue = "RESULTTEXTAREAEVEN";
					}
					else
					{
						slClassValue = "QRYODD";
						textClassValue = "RESULTTEXTAREAODD";
					}
					String dscr_key =  (String)discrete.get(l);

					if(!dscr_map.containsKey(dscr_key.trim()))
						continue ;
					//Added by Siva Kumar on 10/9/2003
			        TreeMap time_val_map = (TreeMap)dscr_map.get(dscr_key);
								
					Object obj = time_val_map.get(hdr_time);
					
					
					if(obj != null)
					{
						String value_arr[] = (String[]) obj;
            _bw.write(_wl_block58Bytes, _wl_block58);

							//if (value_arr.length == 33)   Ramesh 
							//IN040745 changed array length from 34 to 35
							//if (value_arr.length == 36) IN064132
							if (value_arr.length == 39)//IN066982 changes 36-37 
							{
								if (value_arr[22] != null && (!(value_arr[22]).equals(""))) 
								{
									if (value_arr[22].equals("*LB_REFLEX_REG*")) 
									{
										color = "LIGHTYELLOW";
										textClassValue = "RESULTTEXTAREAYELLOW";
										toolTipText = "This test is ordered at the time of Registration";
									}
									else if (value_arr[22].equals("*LB_REFLEX_RES*")) 
									{
										color = "TAN";
										textClassValue = "RESULTTEXTAREATAN";
										toolTipText = "This test is ordered at the time of Resulting based on Reflex Test";
									}
									else if (!value_arr[22].equals(request.getParameter("practitioner_id"))) 
									{
										color = "Gray";
										textClassValue = "RESULTTEXTAREAGRAY";
										toolTipText = "ordered by : " + value_arr[22];
									}
								}
								ext_image_obj_id = (value_arr[23]==null)?"":value_arr[23];
								ext_image_appl_id = (value_arr[24]==null)?"":value_arr[24];

								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/
								
								reporting_practitioner  = value_arr[25];
								if(reporting_practitioner == null){ //IN066982
									reporting_practitioner = "";
								} 
								/*commtented for IN066982
								if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									if(!repPract.equals(reporting_practitioner) && !reporting_practitioner.equals(""))
										reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean1.getRepPractName(reporting_practitioner,localeName);
									else
										reporting_practitioner = "";
								}
								else
								{							
									reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :"; 
								}*/
								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/

							hist_rec_type			= (value_arr[26]==null)?"":value_arr[26];//IN066982
									/*IN066982 starts*/
									if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
									{
										resulted_practitioner = (value_arr[35]==null)?"":value_arr[35];
										if(resulted_practitioner != null && !resulted_practitioner.equals(""))
										{
											reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean1.getRepPractName(resulted_practitioner,localeName);
											
										}
									}
									else{
										if(reporting_practitioner != null && !reporting_practitioner.equals(""))
										{
											reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean1.getRepPractName(reporting_practitioner,localeName);
										}
										
									}
									/*IN066982 ends*/
							} 
							//else if (value_arr.length == 35) //IN064132 changes to 34 //IN066982//IN070610
							else if (value_arr.length == 37) //IN064132 changes to 34 //IN066982//IN070610
							{
								//INO30714 Starts
								accession_num			= (value_arr[27]==null)?"":value_arr[27];
								try
								{
									
									//String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
									String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE_DESC=?";
									pstmt2	= con.prepareStatement(head_foot_qry);
									
									//pstmt2.setString(1,"2345");
									pstmt2.setString(1,(String)key_value_map2.get(dscr_key));
									rs2 = pstmt2.executeQuery();

									while(rs2.next())
									{
										//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
										footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
										report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
									}

			
								}
								catch(Exception ee)
								{
								//	out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
									ee.printStackTrace();
								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//if(con!=null) con.close();
								}
								
								try
								{
									sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
									pstmt2	= con.prepareStatement(sect_template_query);
									pstmt2.setString(1,report_header_code);
									rs2 = pstmt2.executeQuery();


									if(rs2.next())
									{
										clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
										
										if(clob_notes_content!=null)
										{
											try
											{
												//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
												content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
												bf_content_reader	= new java.io.BufferedReader(content_reader);
												char[] arr_notes_content = new char[(int)clob_notes_content.length()];
												bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
												section_content = new String(arr_notes_content);
												bf_content_reader.close();
												if(section_content == null)
													section_content = "";
											}
											catch(Exception e)
											{
												//out.println("Exception@1-readCLOB : "+e);/COMMON-ICN-0181
												e.printStackTrace();
											}


										}
									}
								}

								catch(Exception eee)
								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
									eee.printStackTrace();

								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//if(con!=null) con.close();
								}
							if(!accession_num.equals(""))
							{
								ext_image_obj_id		= (value_arr[22]==null)?"":value_arr[22];//IN052367
								try
								{
									String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

									pstmt2	= con.prepareStatement(athorise_by_qry);
									pstmt2.setString(1,locale);
									pstmt2.setString(2,locale);
									pstmt2.setString(3,locale);
									pstmt2.setString(4,locale);
									//IN052367 - Start
									if(accession_num.contains("!"))
										acc_for_notefooter = ext_image_obj_id;
									else
										acc_for_notefooter = accession_num;
										
									pstmt2.setString(5,acc_for_notefooter);
									//pstmt2.setString(5,accession_num);
									//IN052367 - End
									pstmt2.setString(6,patient_id);
									rs2 = pstmt2.executeQuery();
									while(rs2.next())
									{
										//authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
										//last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
										//doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
										//authorized_by		=	rs2.getString("AUTHORIZED_BY_ID") ;
										//last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID");
										//doc_ref_id		=	 rs2.getString("DOC_REF_ID") ;
										authorized_by		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
										last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
										doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996
										
									}
								}
								catch (Exception roro )

								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());//COMMON-ICN-0181
									roro.printStackTrace();

								}
								finally 
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//if(con!=null) con.close();
								}
							}
							encounter_id1 = encounter_id ;
							if(encounter_id.equals("0"))
							{
								encounter_id1 ="";
							}
				
							if(!visit_adm_date.equals(""))
							{
								visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
							}
				
							if(!discharge_date.equals(""))
							{
								discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
							}



							//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
							htParameter.put("V$ATT_PRACT", attending_practitioner);
							htParameter.put("V$ADM_PRACT", admitting_practitioner);
							htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
							htParameter.put("V$PT_SPLTY", speciality_name);
							//--[IN029296]  - Start
							if(patient_name.trim().equals(""))
								htParameter.put("V$PT_NAME", default_pat_name);
							else
								htParameter.put("V$PT_NAME", patient_name);
							//--[IN029296]  - End
							htParameter.put("V$PT_ID", patient_id);
							htParameter.put("V$SEX", Sex);
							htParameter.put("V$AGE", age);
							htParameter.put("V$ENC_ID", encounter_id1);
							htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
							htParameter.put("V$DIS_DT", discharge_date); //discharge_date
							htParameter.put("V$MED_SERV", med_service);
							htParameter.put("V$DOC_REF_H", doc_ref_id);
							htParameter.put("V$PT_LOCN", location_code); //patient_loc
							htParameter.put("V$PT_CLASS", patient_class);//patient_class
				
							//sectionContentUpdatedXML = new StringBuffer();
							StringBuffer section_content_new = new StringBuffer(section_content);
				
							if (! locale.equals("en") )
							{
								if(!section_content_new.toString().equals(""))
								{
									paramMap = new HashMap<String,String>();
									paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
									paramMap.put("LOCALE",locale);						
									paramMap.put("RANGE_PASER_YN","N");
									eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
									section_content_new = tempLangParse.getLangReplacedXML();
									tempLangParse = null;
								}


							}
				
							if(!section_content_new.toString().equals(""))
							{
								sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
							}

							if(!(sectionContentUpdatedXML.toString().equals("")))
							{								
								section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
								//section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
								
							}
						//Report Header Ends
						
						// changes notes footer starts
						section_content= "";

						try
						{
			
							//String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
							pstmt2	= con.prepareStatement(sect_template_query);
							pstmt2.setString(1,footer_code);
							rs2 = pstmt2.executeQuery();


							if(rs2.next())
							{
				
								clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
								if(clob_notes_content!=null)
								{
									try
									{
										//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
										content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
										bf_content_reader	= new java.io.BufferedReader(content_reader);
										char[] arr_notes_content = new char[(int)clob_notes_content.length()];
										bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
										section_content = new String(arr_notes_content);
										bf_content_reader.close();
									
										if(section_content == null)
										section_content = "";
									}
									catch(Exception e)
									{
										//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
										e.printStackTrace();
									}


								}
							}
						}

						catch(Exception eee)
						{
							//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
							eee.printStackTrace();

						}
						finally
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();
						}

						if(!printDateTime.equals(""))
						{
							printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
						}

						htParameter=new Hashtable();
						htParameter.put("V$CUR_USR", login_user_id);
						htParameter.put("V$AT_PRACT", authorized_by);
						htParameter.put("V$LT_MODI_USR", last_amended_by);
						htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
						htParameter.put("V$DOC_REF_F", doc_ref_id);
						htParameter.put("V$LT_PT_P_C_D", pract_sign);

						section_content_new = new StringBuffer(section_content);
						sectionContentUpdatedXML = new StringBuffer();
				
						if (! locale.equals("en") )
						{
							if(!section_content_new.toString().equals(""))
							{
								paramMap = new HashMap<String,String>();
								paramMap.put("CURR_SEC_HDG_CODE",footer_code);
								paramMap.put("LOCALE",locale);						
								paramMap.put("RANGE_PASER_YN","N");
								eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
								section_content_new = tempLangParse.getLangReplacedXML();
								tempLangParse = null;
							}


						}
						
				
						if(!section_content_new.toString().equals(""))
						{
							sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
						}

				
						if(!(sectionContentUpdatedXML.toString().equals("")))
						{								
						
							section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

						}
						//Footer Ends
					//INO30714 Ends
					
						if(value_arr.length == 39)
						{
							ext_image_obj_id	= (value_arr[23]==null)?"":value_arr[23];
							ext_image_appl_id	= (value_arr[24]==null)?"":value_arr[24];
						}else if(value_arr.length == 37)//IN070610
						{
							ext_image_obj_id	= (value_arr[22]==null)?"":value_arr[22];
							ext_image_appl_id	= (value_arr[23]==null)?"":value_arr[23];
						}
								

								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/
								reporting_practitioner = value_arr[24]==null?"":value_arr[24];
								/*IN066982 starts*/
								if(reporting_practitioner == null){ //IN066982 changes
									reporting_practitioner = "";
								}
								
								/* commented for IN066982 if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									if(!repPract.equals(reporting_practitioner))
										reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean1.getRepPractName(reporting_practitioner,localeName);
									else
										reporting_practitioner = "";
								}
								else
								{
									reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :"; 
								} commented for IN066982 */
								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/
								hist_rec_type			= (value_arr[25]==null)?"":value_arr[25];
							if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
							{
								resulted_practitioner = (value_arr[33]==null)?"":value_arr[33];
								if(resulted_practitioner != null && !resulted_practitioner.equals(""))
								{
									reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR>  "+bean1.getRepPractName(resulted_practitioner,localeName);
								}
							}
							else{
								if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean1.getRepPractName(reporting_practitioner,localeName);
								}
								
							}
							/*IN066982 ends*/
							}
						
						}
						if (!color.equals(""))
							slClassValue = color;
						//End of Addition
						String disp_hdr_time="";//IN29171

						if(hdr_time == null) 
							hdr_time = "";
						
						if(hdr_time.contains("/"))
						{
							if(hdr_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
							{
								if(com.ehis.util.DateUtils.validDate(hdr_time,"DMYHMS",localeName))
								{
									disp_hdr_time = com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHMS","en",localeName);//IN29171
								}
							}
							else if(hdr_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
							{
								if(com.ehis.util.DateUtils.validDate(hdr_time,"DMYHM",localeName))
								{
									disp_hdr_time = com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHM","en",localeName);//IN29171
								}
							}
							else if(hdr_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
							{
								if(com.ehis.util.DateUtils.validDate(hdr_time,"DMY",localeName))
								{
									disp_hdr_time = com.ehis.util.DateUtils.convertDate(hdr_time,"DMY","en",localeName);//IN29171
								}
							}
						} 

						if(obj != null)
						{
							
							String value_arr[] = (String[]) obj;
							
							if(header==0){
								out.println("<tr><td class='columnheader' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","common_labels")+"</td>");
								out.println("<td class='columnheader' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Results.label","or_labels")+"</td>");
								out.println("<td  class='columnheader' >Result Status</td></tr>");
							header++;
							}
							if((!dup_time.equalsIgnoreCase(hdr_time))){
								//out.println("<tr><td colspan=3 class='OR_QRYEVENBORDER'></td></tr>");									
								out.println("<tr><td class='columnheader' wrap>&nbsp;</td>");
								out.println("<td class='columnheader' wrap>"+disp_hdr_time+"</td>");
								dup_time=hdr_time;
								out.println("<td class='columnheader' wrap>&nbsp;</td></tr>");	
							}
							
							String panel_value = (key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key));
							if(!panel_value.equalsIgnoreCase(temp_panel_key)){
								//[IN031684]if(dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's
								//[IN031684]{
									out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><b><font size='2'>"+(key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key))+"</font></b></td></tr>"); 
									temp_panel_key = panel_value;
								//[IN031684]}							
							}
							if(dscr_map.size()>1)
							{
								out.println("<tr VALIGN='TOP'><td wrap title = '"+toolTipText+"' class = '"+slClassValue+"'>"+(key_value_map2.get(dscr_key)==null?"&nbsp;":(String)key_value_map2.get(dscr_key))+" <BR> "+reporting_practitioner+" </td>");								
								i++;
							}
							else
							{																	
								out.println("<tr VALIGN='TOP'><td  wrap title = '"+toolTipText+"'  class = '"+slClassValue+"'>"+(key_value_map2.get(dscr_key)==null?"&nbsp;":(String)key_value_map2.get(dscr_key))+"<BR> "+reporting_practitioner+"</td>");
								i++;
							}
							String normalcy_ind = value_arr[4];
							String normalcy_ind_disp = "&nbsp;";
							

							//if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
							//	normalcy_ind_disp = "<FONT COLOR='RED' >Abnormal</FONT>";
							//else
							normalcy_ind 		= value_arr[15];
					
							/*if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
								normalcy_ind_disp = "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"</FONT>";
							else if(normalcy_ind != null)
								normalcy_ind_disp = "<FONT COLOR='RED' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<b></FONT>";*/
							//Commented by Jyothi and added the below logic to fix IN021191

							if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(high_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(low_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(abn_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(crit_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(crit_high_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(crit_low_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equals(".")) //Added by Jyothi to fix IN023229
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
							else
							{
								if(!(CommonBean.checkForNull(value_arr[11]).trim()).equals("") && !(CommonBean.checkForNull(value_arr[12]).trim()).equals(""))
								{
									if(!(CommonBean.checkForNull(value_arr[5]).trim()).equals(""))
									{
										if(Float.parseFloat(value_arr[5]) > 0)
										{
											if((Float.parseFloat(value_arr[5]) >= Float.parseFloat(value_arr[11])) && (Float.parseFloat(value_arr[5]) <= Float.parseFloat(value_arr[12])))
											{
												normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
											}
										}
									}
								}
								else
									normalcy_ind_disp = "";
							}
							//End
							String result_str = value_arr[7];
							if(result_str == null) 
								result_str = "";
							
							//IN054648 Start.
							result_str  = result_str.replaceAll("<","&lt;");
							result_str  = result_str.replaceAll(">","&gt;");
							//IN054648 End.

							if(result_str.contains("/"))
							{
								if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
								{
									if(com.ehis.util.DateUtils.validDate(result_str,"DMYHMS",localeName))
									{
										result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMYHMS","en",localeName);
									}
								}
								else if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
								{
									if(com.ehis.util.DateUtils.validDate(result_str,"DMYHM",localeName))
									{
										result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMYHM","en",localeName);
									}
								}
								else if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
								{
									if(com.ehis.util.DateUtils.validDate(result_str,"DMY",localeName))
									{
										result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMY","en",localeName);
									}
								}
							}

							value_arr[7]=result_str;
							//IN040745 changed array length from 34 to 35
							//IN066982 changes array length 35->37 & 33->35 
							if(value_arr.length == 39)
							{
								status = CommonBean.checkForNull(value_arr[31]);
							}
							//else if(value_arr.length == 35)//IN070610
							else if(value_arr.length == 37)//IN070610
							{
								status = CommonBean.checkForNull(value_arr[30]);
							}
							
							out.println("<td title = '"+toolTipText+"' class = '"+slClassValue+"'><font size=1><table width='100%'><tr>");
							out.println("<td>");							
							//IN040745 changed array length from 34 to 35	
							//IN066982 changes array length 35->37 & 33->35 
							//if(value_arr.length == 37){//IN072540
								if(value_arr.length == 39){//IN072540
								if(!(CommonBean.checkForNull(value_arr[33],"").trim()).equals("") && (CommonBean.checkForNull(value_arr[33],"").trim()).equals("Y") && !(CommonBean.checkForNull(value_arr[5],"").trim()).equals("")){
									out.println("<table width='100%'><tr><td>");									
									out.println(CommonBean.checkForNull(value_arr[30]));
									out.println("&nbsp;"+CommonBean.checkForNull(value_arr[5]));			
									if(!CommonBean.checkForNull(value_arr[6]).equals(""))
									{   
									   out.println("&nbsp;"+value_arr[6]);				
									}
									if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
									{									
										out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
									}
									out.println("</td></tr></table>");
								}									
							//}else if(value_arr.length == 35){//IN070610
							}else if(value_arr.length == 37){//IN070610
								if(!(CommonBean.checkForNull(value_arr[32],"").trim()).equals("") && (CommonBean.checkForNull(value_arr[32],"").trim()).equals("Y") && !(CommonBean.checkForNull(value_arr[5],"").trim()).equals("")){
									out.println("<table width='100%'><tr><td>");									
									out.println(CommonBean.checkForNull(value_arr[29]));
									out.println("&nbsp;"+CommonBean.checkForNull(value_arr[5]));			
									if(!CommonBean.checkForNull(value_arr[6]).equals(""))
									{   
									   out.println("&nbsp;"+value_arr[6]);				
									}
									if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
									{									
										out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
									}
									out.println("</td></tr></table>");
								}
							}	
							if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("NUM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("TXT") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("HTM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR")){
											
								if(result_str!=null && !result_str.equals(""))
								{
									out.println("<table width='100%'><tr><td>");
									//[IN032246] Start.
										
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block61Bytes, _wl_block61);

										/*if(result_str.length() > 40)
										{
										
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block64Bytes, _wl_block64);

										}else{
										
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block61Bytes, _wl_block61);

										}*/
									//[IN032246] End.
									out.println("</td></tr></table>");
								}
							}else{
								if(result_str!=null && !result_str.equals(""))
								{
									out.println("<table width='100%'><tr><td>");
									//[IN032246] Start.
										
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block61Bytes, _wl_block61);

										/*if(result_str.length() > 40)
										{
										
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block64Bytes, _wl_block64);

										}else{
										
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block61Bytes, _wl_block61);

										}	*/	
									//[IN032246] End.
										//IN040745 changed array length from 34 to 35
										//IN066982 changes array length 35->37 & 33->35 
										//if(value_arr.length == 37 && value_arr[31]!=null){//IN072540
										if(value_arr.length == 39 && value_arr[31]!=null){//IN072540
										out.println("<font color=blue>( Normal Value : "+value_arr[31]+" )</font>"); 
										}
										//else if(value_arr.length == 35 && value_arr[30]!=null)//IN070610
										else if(value_arr.length == 37 && value_arr[30]!=null)//IN070610
										{
										out.println("<font color=blue>( Normal Value : "+value_arr[30]+" )</font>");
										}
									out.println("</td></tr></table>");
								}							
							}
								
//================================================================
				/*if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR")){	
					if(value_arr[8] != null && (!(value_arr[8].equals("")))){
							String temp = CommonBean.checkForNull(value_arr[8]);			
							String tempsplit[] = temp.split("\n");							
							int indicate=0;
							int indicator=0;

							for(int n = 0; n < tempsplit.length; n++){
								String tempRow=tempsplit[n];
								if(n>0 && n < (tempsplit.length -1) && indicate==0){
									if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
									{
										indicate=indicate++;
										indicator=n;
									}
								}
								if(!(tempRow.length()>100)){	//[IN029203] Start.									
									
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tempRow));
            _bw.write(_wl_block66Bytes, _wl_block66);

									//[IN029203] End.
									if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
									out.println("\n");	
								}else{
									StringBuffer br = new StringBuffer(tempRow);
									int k = 0;
									for(int p = 0; p < br.length(); p++)
									{
										if( p == (k+100))
										{
											String st = br.substring(k,p);
											//[IN029203] Start.
											//out.println("<PRE>"+st+"</PRE>");  
											
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(st));
            _bw.write(_wl_block69Bytes, _wl_block69);

											//[IN029203] End.
											k += 100;
										}
									}	
									//[IN029203] Start.
									//out.println("<PRE >"+br.substring(k, br.length())+"</PRE>");
									
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(br.substring(k, br.length())));
            _bw.write(_wl_block66Bytes, _wl_block66);

									//[IN029203] End.
									if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
										out.println("\n");
								}

							}

					}
				}*/
//============================================================================	
							if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("HTM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR"))
							{	
								String txt= CommonBean.checkForNull(value_arr[8]);
								if(txt.indexOf("</ADDRESS></table>") != -1)
									txt = txt.replaceAll("</ADDRESS></table>","</ADDRESS>");
								txt = txt.replaceAll("</TD></TR><tr><td>&nbsp;</td></tr></table></BODY></HTML>","");
								txt = txt.replaceAll("<HTML><BODY>","");
								txt = txt.replaceAll("</BODY></HTML>","");	
								txt = txt.replaceAll("<HTML>","");
								txt = txt.replaceAll("</HTML>","");
								txt = txt.replaceAll("<BODY>","");
								txt = txt.replaceAll("</BODY>","");
								txt = txt.replaceAll("<HEAD>","");
								txt = txt.replaceAll("</HEAD>","");
								txt = txt.replaceAll("<TITLE></TITLE>","");
								txt = txt.replaceAll("font-family:Courier New;FONT-SIZE:9pt","font-family:Courier New;FONT-SIZE:8pt");
								txt = txt.replaceAll("<TR><TD colspan=","<TR><TD style='word-wrap:break-word;width:40em;' colspan=");//IN039067
								txt = txt.replaceAll("<TD> ","<TD style='word-wrap:break-word;width:40em;'> "); //IN039067
								txt = txt.replaceAll("<td","<td style='word-wrap:break-word;'  "); 
								txt = txt.replaceAll("LINE-HEIGHT: 100%;","LINE-HEIGHT:");             //[IN056353]
								txt = txt.replaceAll("line-height: 100%;","line-height:");            //[IN056353]
								//txt = txt.replaceAll("100%","550"); //Commented for IN062473
								txt = txt.replaceAll("width='100%'","width='550'"); //Added for IN062473
								txt = txt.replaceAll("PAGE-BREAK-BEFORE: always;","");         //[IN056353]
								out.println("<table width='500'> <tr><td CLASS='"+textClassValue+"' >");
								//[IN032246] Stat.
								//out.println(txt);
								//IN039067 Start
								
								
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(txt));
            _bw.write(_wl_block71Bytes, _wl_block71);

								
								/*if(txt.indexOf("<TR>") != -1){	
								
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(txt));
            _bw.write(_wl_block72Bytes, _wl_block72);

								}else{								
									String tempsplit[] = txt.split("\n");							
									int indicate=0;
									int indicator=0;
									for(int n = 0; n < tempsplit.length; n++){
										String tempRow=tempsplit[n];
										if(n>0 && n < (tempsplit.length -1) && indicate==0){
											if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
											{
												indicate=indicate++;
												indicator=n;
											}
										}
										 //if(!(tempRow.length()>72))//	//[IN029203] Start.	 //[IN039361]
										if(!(tempRow.length()>60)){//[IN039361]								
											
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tempRow));
            _bw.write(_wl_block69Bytes, _wl_block69);

											//[IN029203] End.
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
											out.println("\n");	
										}else{
											StringBuffer br = new StringBuffer(tempRow);
											StringBuffer tempStr = new StringBuffer();
											int k = 0;
											for(int p = 0; p < br.length(); p++)
											{
												//if( p == (k+72))//[IN039361]
												if( p == (k+60))//[IN039361]												
												{
													String st = br.substring(k,p);
													//[IN029203] Start.
													//out.println("<PRE>"+st+"</PRE>");
													tempStr.append(st);
													tempStr.append("\n");
													
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(st));
            _bw.write(_wl_block74Bytes, _wl_block74);

													//[IN029203] End.
													//k += 72; //[IN039361]
													k += 60; //[IN039361]
												}
											}	
											//[IN029203] Start.
											//out.println("<PRE >"+br.substring(k, br.length())+"</PRE>");
											
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tempStr));
            out.print( String.valueOf(br.substring(k, br.length())));
            _bw.write(_wl_block69Bytes, _wl_block69);

											//[IN029203] End.
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
												out.println("\n");
										}
									}
								}*/
								//IN039067 End.
								out.println("</td></tr></table>");								
								//out.println("<table border='2'cellpadding='0' cellspacing='2' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table>");
								out.println("<table border='2'cellpadding='0' cellspacing='2' width='500'><tr><td>");
								
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(section_content_ftr));
            _bw.write(_wl_block72Bytes, _wl_block72);

								//[IN032246] End.
								out.println("</td></tr></table>");
							}else
							{	
						System.out.println("==========ViewPrint.jsp============>"+value_arr[8]+"<========>"+value_arr[21]);
						System.out.println("==========ViewPrint.jsp============>"+value_arr[16]+"<========>"+value_arr[20]);
								//IN053047 Start.
								if(value_arr[8] != null && (!(value_arr[8].equals("")))){
									StringBuffer displayData = new StringBuffer();
									bean1.setClobData(value_arr[8], value_arr[21]);
									String txt =CommonBean.checkForNull(value_arr[8]);
									txt = txt.replaceAll("font-family:Courier New;FONT-SIZE:9pt","font-family:Courier New;FONT-SIZE:8pt");
									txt = txt.replaceAll("PAGE-BREAK-BEFORE: always;","");       //[IN056353]
									txt = txt.replaceAll("LINE-HEIGHT: 100%;","LINE-HEIGHT:");          //[IN056353]
									String tempsplit[] = txt.split("\n");							
									int indicate=0;
									int indicator=0;
									for(int n = 0; n < tempsplit.length; n++){
										String tempRow=tempsplit[n];
										if(n>0 && n < (tempsplit.length -1) && indicate==0){
											if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
											{
												indicate=indicate++;
												indicator=n;
											}
										}
										if(!(tempRow.length()>80)){								
											
											displayData.append("<PRE  style='word-wrap:break-word;'>"+tempRow+"</PRE>");
																						
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
												displayData.append("\n");	
										}else{
											StringBuffer br = new StringBuffer(tempRow);
											StringBuffer tempStr = new StringBuffer();
											int k = 0;
											for(int q = 0; q < br.length(); q++)
											{
												if( q == (k+80))											
												{
													String st = br.substring(k,q);													
													tempStr.append(st);
													tempStr.append("\n");			//IN071753										
													k += 80; 
												}
											}
											displayData.append("<PRE  style='word-wrap:break-word;'>"+tempStr+br.substring(k, br.length())+"</PRE>");
																						
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
												displayData.append("\n");
										}
									}
									out.println(displayData);
								}							
								//IN053047 End.
							}
						
							if(value_arr[16] != null)
							{
							
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(value_arr[16]));
            _bw.write(_wl_block77Bytes, _wl_block77);

							}							
						out.println("</td></tr></table>");
						if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
						{ 								
						
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block79Bytes, _wl_block79);

						}
						//IN040745 changed array length from 34 to 35
						//IN066982 changes array length 35->37 & 33->35 
						if(value_arr.length == 39)
						{
							status = CommonBean.checkForNull(value_arr[31]);
						//}else if(value_arr.length == 35)//IN070610
						}else if(value_arr.length == 37)//IN070610
						{
							status = CommonBean.checkForNull(value_arr[30]);
						}
						if(status.equals("P"))
							out.println("<font color='red'>(Preliminary)</font>");
							
						
            _bw.write(_wl_block80Bytes, _wl_block80);

						out.println("<td class = '"+slClassValue+"'>");
						if(!normalcy_ind_disp.equals(""))
							out.println("&nbsp;"+normalcy_ind_disp);
						else
							out.println("&nbsp;");
						out.println("</td>");
					}										
				}
			}
		}		
		out.println("</tr>");
		out.println("</table>");	
		if(con!=null) con.close(); //IN043940 
	}

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(request.getParameter("pkiSiteSpecificYN")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(request.getParameter("quePkiStatus")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(request.getParameter("quePkiStatusText")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(request.getParameter("quePkiId")));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(request.getParameter("quePkiToken")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(request.getParameter("quePkiNumber")));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(request.getParameter("quePkiIsueDateTime")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(request.getParameter("quePkiCallDateTime")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(request.getParameter("ordFacilityId")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(request.getParameter("patientId")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(request.getParameter("encounterId")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(request.getParameter("referenceId")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(request.getParameter("userId")));
            _bw.write(_wl_block94Bytes, _wl_block94);

	putObjectInBean(bean_id1,bean1,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Printing.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ResultReports.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderNo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NationalId.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderLocation.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SpecimenCollectedTime.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReportingDate.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPractitioner.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReportingPractitioner.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderFormat.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReportingTime.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
