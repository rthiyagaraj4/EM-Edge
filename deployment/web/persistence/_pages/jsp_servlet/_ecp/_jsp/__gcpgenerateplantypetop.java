package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __gcpgenerateplantypetop extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGeneratePlanTypeTop.jsp", 1744026286886L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n</title>\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCP/html/GCPStyle.css\"></link>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n<script language=\"JavaScript\" src=\"../../eCP/js/GCPGenerateCarePlan.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\" Onload=\'\'>\n<script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"generate_libraires\" id=\"generate_libraires\"  method =\'post\' target=\'\' action=\'\'>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<table border=\'0\' cellspacing=\'1\' cellpadding=\'1\' width=\'100%\'  align=\'center\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<tr>\n\t\t<th colspan=\'4\' height=\'1\' class=\'PLANHEAD\' align=\'left\'><font size=\"1.5\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </font></th>\n\t\t<!-- <th colspan=\'4\'>Library</th> -->\n\t</tr>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t\t<th colspan=\'\' height=\'1\' class=\'PLANSUBHEAD\' width=\'18%\'><font size=\"1\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></th>\n\t\t<th colspan=\'\' height=\'1\' class=\'PLANSUBHEAD\' width=\'25%\'><font size=\"1\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></th>\n\t\t<th colspan=\'\' height=\'1\' class=\'PLANSUBHEAD\' width=\'20%\'><font size=\"1\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></th>\n\t\t<th colspan=\'\' height=\'1\' class=\'PLANSUBHEAD\' width=\'2%\'><font size=\"1\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></th>\n\t\t\n\t</tr>\n\t</table>\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<table border=\'1\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\n\t\t\t<td colspan=\'5\' class=\'CAGROUPHEADING\' height=\'1%\'><font size=\"1\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<th colspan=\'\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></th>\n\t\t\t\t<th colspan=\'\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font></th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\'25%\' height=\'1\'><font size=\"1\" color=\"\"> ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =": ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =")</font></td>\t\t\n\t\t<input type =\'hidden\' name=\'casetype_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'casetype_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t\t\n\t\t<input type =\'hidden\' name=\'casetype_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'casetype_desc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type =\'hidden\' name=\'library_code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'library_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type =\'hidden\' name=\'version_no";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'version_no";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type =\'hidden\' name=\'lib_short_desc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'lib_short_desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\n\t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' width=\'10%\' height=\'1\'><font size=\"1\" color=\"\"> \n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font>\t\t\t\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' width=\'40%\' height=\'1\' align=\'center\'>\n\t<textarea name=\"\" rows=\"3\" cols=\"60\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</textarea>\n\t\t\t\t\n\t</td>\n\t\n\t<td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' width=\'5%\' height=\'1\' align=\'center\'>\n\t<input type=\"checkbox\" name=\'chk_library";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'chk_library";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onClick=\'populateLibDetails(\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\")\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="> </td>\n\t</tr>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n</table>\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type =\'hidden\' name=\'finalStr\' id=\'finalStr\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\' >\n<tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<tr>\n\t\t\t\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' width=\'20%\' height=\'1\'><font size=\"1\" color=\"\"> \n\t\t<B>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =")</B></font></td>\t\t\t\n<input type =\'hidden\' name=\'term_set_id";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'term_set_id";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\t\t\n<input type =\'hidden\' name=\'term_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'term_code";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input type =\'hidden\' name=\'library_code";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type =\'hidden\' name=\'version_no";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type =\'hidden\' name=\'lib_short_desc";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' width=\'25%\' height=\'1\' align=\'left\' ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="><font size=\"1\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</FONT>\n\t\t\t\t\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' width=\'20%\' height=\'1\'><font size=\"1\" color=\"\"> \n\t<B>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</B></font>\t\t\t\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' width=\'3%\' height=\'1\' align=\'center\'>\n\t <input type=\"checkbox\" name=\'chk_library";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" onClick=\'populateLibDetails1(\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t<tr>\n\t\t<td colspan=\'4\' height=\'\' class=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>&nbsp;</td>\n\t</tr>\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n</table>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\' >\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\'chk_spanlib\' + (";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =")).rowSpan = ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =";\n\t\t\t</script>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' colspan=\'4\' align=\'center\'>&nbsp;</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t<script>\n\t\t\t\t\teval(\"document.generate_libraires.term_code\"+\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\").value = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t</script>\t\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' width=\'20%\' height=\'1\' valign=\'top\'><font size=\"1\" color=\"\"> \n\t\t<b>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&nbsp;</b></font></td>\t\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n<input type =\'hidden\' name=\'casetype_code";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type =\'hidden\' name=\'term_set_id";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\t\n<input type =\'hidden\' name=\'term_code";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<td class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' width=\'25%\' height=\'1\' valign=\'top\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&nbsp;&nbsp;<!-- ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" --> </font>\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' width=\'20%\' height=\'1\' valign=\'top\'><font size=\"1\" color=\"\"> \n\t<b>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</b></font>\t\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\' >\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<tr>\n\t\t<td width=\'30%\' class=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>&nbsp;<td>\n\t\t<td width=\'70%\' class=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'><font size=\"1\" color=\"navy\"><b>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</b></font><td>\n\t\t<tr>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t<script>\n\t\teval(\"document.generate_libraires.term_code\"+\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t<script>\n\t\t\teval(\"document.generate_libraires.term_set_id\"+\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\teval(\"document.generate_libraires.term_code\"+\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t</script>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t</table>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t</td>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' width=\'3%\' height=\'1\' align=\'center\' id=\'chk_spanlib";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\t\t\n\t<input type=\"checkbox\" name=\'chk_library";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'onClick=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =">\n\t </td>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" \n\t</tr>\n\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t<script>\n\t\t\tdocument.getElementById(\'chk_spanlib\' + (";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =";\n\t\t</script>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t<tr>\n\t<td class=\'GRPEVEN\' colspan=\'4\' align=\'center\'>&nbsp;</td>\n\t</tr> \n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n<input type =\'hidden\' name=\'encounterId\'  id=\'encounterId\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'><!-- 60772 -->\n\n</table>\n<script>\ncheckExistingDiags();\n</script>\n\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t<table border=\'1\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\n\t\t\t<td colspan=\'5\' class=\'CAGROUPHEADING\' height=\'1%\'><font size=\"1\" >&nbsp;";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</font></th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<input type =\'hidden\' name=\'i";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'i";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' width=\'25%\' height=\'1\'><font size=\"1\" color=\"\"> \n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</font></td>\t\n<input type =\'hidden\' name=\'casetype_code";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</textarea>\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' onClick=\'populateLibDetails2(\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\",\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =" ></td>\n\t</tr>\n\t\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n<input type =\'hidden\' name=\'i";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n<input type =\'hidden\' name=\'j\' id=\'j\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n</table>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\'  align=\'center\'>\n<tr>\n\t<td colspan=\'2\' height=\'1\' align=\'center\' class=\'GRPEVEN\'><font size=\"1\"><b> ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</b></font></td>\n\t<!-- <th colspan=\'4\'>Library</th> -->\n</tr>\n<tr>\n\t<td colspan=\'\' height=\'1\'align=\'left\' width=\'97%\'  class=\'GRPEVEN\'><font size=\"1\" >\n\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="&nbsp;</font>\n\t</td>\n\t<td colspan=\'\' height=\'1\' align=\'right\'  class=\'GRPEVEN\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="<input type=\"checkbox\" name=\"\" id=\"\">";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t</td>\n</tr> \n</table>\t\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'><!-- 60772 -->\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

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
Date       		Edit History      	Name			Rev.Date		Rev.Name			DescriptionDescription
--------------------------------------------------------------------------------------------------------------
?             	100            		?           										created
19/04/2020    	IN072876	    	Ramesh Goli		19/04/2020		Ramesh G			MMS-KH-SCF-0063
05/06/2024   60772      Twinkle Shah    05/06/2024	    Ramesh Goli      MMS-JU-SCF-0267
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCP.GCPGeneratePlanBean GCPGenerateBean= null;synchronized(session){
                GCPGenerateBean=(eCP.GCPGeneratePlanBean)pageContext.getAttribute("GCPGenerateBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(GCPGenerateBean==null){
                    GCPGenerateBean=new eCP.GCPGeneratePlanBean();
                    pageContext.setAttribute("GCPGenerateBean",GCPGenerateBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String read_only =(String)request.getParameter("read_only") == null ? "" : request.getParameter("read_only");
String disabled ="";
if(read_only.equals("readonly")){
	read_only ="readonly";disabled = "disabled";

            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

}else{
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

  
Connection con = null;
PreparedStatement ps = null,pstmt=null;
ResultSet rs = null,rst=null;

con = ConnectionManager.getConnection(request);

String patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String encounterId		= request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");	 ///60772

String case_type_code	= (String)request.getParameter("casetype_code") == null ? "" : request.getParameter("casetype_code");
String casetype_desc	= (String)request.getParameter("casetype_desc") == null ? "" : request.getParameter("casetype_desc");
String patient_class	= (String)request.getParameter("patient_class");
String term_set_id		= (String)request.getParameter("termset_id") == null ? "" : request.getParameter("termset_id");
String term_code		= (String)request.getParameter("term_code") == null ? "" : request.getParameter("term_code");
String term_code_desc	= (String)request.getParameter("term_code_desc") == null ? "" : request.getParameter("term_code_desc");
String Library			= (String)request.getParameter("Library") == null ? "" : request.getParameter("Library");
String lib_id			= (String)request.getParameter("lib_id") == null ? "" : request.getParameter("lib_id");
String vers_no			= (String)request.getParameter("versn_no") == null ? "" : request.getParameter("versn_no");

String show_diag		= (String)request.getParameter("show_diag") == null ? "" : request.getParameter("show_diag");
	
StringBuffer sql = new StringBuffer();
String classValue="";
String case_type_code1="",term_code1="";
HashMap codeKeyValue = new HashMap();
String checked = ""; 
int i=0;
try
{   
	eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(!read_only.equals("readonly")){


            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	if(!case_type_code.equals(""))
	{

//	sql.append("SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE=? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO )");
	sql.append("SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY_LANG_VW B ,CP_CASE_TYPE_LANG_VW C WHERE A.CASE_TYPE_CODE=? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID");

	//case_type_code="";
	ps = con.prepareStatement(sql.toString());
	ps.setString(1, case_type_code);
	ps.setString(2, patient_class);
	ps.setString(3, locale);
	rs = ps.executeQuery();

            _bw.write(_wl_block20Bytes, _wl_block20);

	while(rs.next())
	{	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		
		case_type_code = rs.getString(1);
		if(!case_type_code.equals(case_type_code1)){

            _bw.write(_wl_block21Bytes, _wl_block21);
out.println(rs.getString(2));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

			case_type_code1=case_type_code;			
		}
		codeKeyValue = bean.getCaseCode();
		String temp_chk= "";
		temp_chk =(String)codeKeyValue.get(case_type_code)== null?"":(String)codeKeyValue.get(case_type_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "";
		

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
out.println(rs.getString(4));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
out.println(rs.getString(6));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block49Bytes, _wl_block49);

		i++;
	}	
	rs.close();
	ps.close();

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
	}
		else if(!term_set_id.equals("") && !term_code.equals("")){
//			con = ConnectionManager.getConnection(request);
//			sql.append("SELECT A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE A.LIBRARY_ID = ? AND B.VERSION_NO = ? AND A.TERM_SET_ID=? AND A.TERM_CODE  =? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO )");
			sql.append("SELECT A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY_LANG_VW B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE A.LIBRARY_ID = ? AND B.VERSION_NO = ? AND A.TERM_SET_ID=? AND A.TERM_CODE  =? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) AND B.LANGUAGE_ID = ?");
	
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, lib_id);
			ps.setString(2, vers_no);
			ps.setString(3, term_set_id);
			ps.setString(4, term_code);
			ps.setString(5, patient_class);
			ps.setString(6, locale);
			rs = ps.executeQuery();


            _bw.write(_wl_block53Bytes, _wl_block53);

	while(rs.next())
	{	if ( i % 2 == 0 )
			classValue = "GRPEVEN" ;
		else
			classValue = "GRPOD" ;
		
		term_code = rs.getString(3);
		if(!term_code.equals(term_code1)){

            _bw.write(_wl_block54Bytes, _wl_block54);

			term_code1=term_code;			
			
		}
		String tmp_term_code ="";
		tmp_term_code = rs.getString(5)+"~"+rs.getString(6)+"~"+rs.getString(1)+"~"+rs.getString(3)+"~";
		codeKeyValue = bean.getTermCode();
		String temp_chk= "";
		//Set s=codeKeyValue.keySet();
		temp_chk =(String)codeKeyValue.get(tmp_term_code)== null?"":(String)codeKeyValue.get(tmp_term_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "checked";
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
out.println(rs.getString(7));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(7)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(read_only));
            _bw.write(_wl_block65Bytes, _wl_block65);
out.println(rs.getString(8));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block67Bytes, _wl_block67);
out.println(rs.getString(4));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block49Bytes, _wl_block49);

		i++;
	}	
	
	rs.close();
	ps.close();

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block74Bytes, _wl_block74);

	}
if(Library.equals("EntireLibrary") && !show_diag.equals("showall")){
	
	patient_id			= bean.getPatientId();
	String library_id	="",tmp_library_id="",library_desc="",version_no="",tmp_version_no="";
	String termsetid	= "";
	String termcode		= "";
	String record1		= "";
	String chk_tid="",chk_tid1="";String sql_query="";
	String recordKey = "";

	codeKeyValue = bean.getLimitLib();
	Set s=codeKeyValue.keySet();
	Collection ct = codeKeyValue.values();
	
	Object[] record =  s.toArray();
	for(int c=0;c<record.length;c++){
		record1 = record[c].toString();
	}
	
	StringTokenizer stk=new StringTokenizer(record1,",");
	while(stk.hasMoreTokens()){
		chk_tid = stk.nextToken();
		if(!chk_tid1.equals(chk_tid)){
			recordKey = recordKey +""+chk_tid+"";
			termsetid =termsetid +"'"+chk_tid+"',";
			chk_tid1=chk_tid;
		}
	}
	if(termsetid.length()>0)
		termsetid = termsetid.substring(0,termsetid.length()-1);
	else
		termsetid ="''";
	record =  ct.toArray();
	for(int c=0;c<record.length;c++){
		record1 = record[c].toString();
	}
	
	String sel_diags = "";
	sel_diags = bean.getDiags();
	if(!sel_diags.equals("")){
	sel_diags = sel_diags.substring(0,sel_diags.length()-1);
	}else
		sel_diags = "('','')";

	StringTokenizer stk1=new StringTokenizer(record1,",");
	while(stk1.hasMoreTokens()){
		termcode =termcode +"'"+stk1.nextToken()+"',";
			
	}
	if(termcode.length()>0)
		termcode = termcode.substring(0,termcode.length()-1);
	else
		termcode = "''";

	codeKeyValue = bean.getDgCaseCode();
	s=codeKeyValue.keySet();
	record =  s.toArray();
	String case_code = "";
	for(int c=0;c<record.length;c++){
		
		record1 = record[c].toString();
		case_code = case_code +"'"+record1+"',"; 
	}

//	con = ConnectionManager.getConnection(request);
	if(case_code.length()>0){
		case_code = case_code.substring(0,case_code.length()-1);//to remove last ',' char

		//sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC ,'00' CATEG_CODE, 'CASE_TYPE' CATEG_DESC, A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE in (");
		sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC ,'00' CATEG_CODE, 'CASE_TYPE' CATEG_DESC, A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY_LANG_VW B ,CP_CASE_TYPE_LANG_VW C WHERE A.CASE_TYPE_CODE in (");
		//sql.append(case_code);
		sql.append(case_code);
		//sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO  AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE ))) ");
		sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND B.LANGUAGE_ID = '");
		sql.append(locale);
		//IN072876 Start.
		//sql.append("' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND C.LANGUAGE_ID = B.LANGUAGE_ID AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO  AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE ))) ");
		sql.append("' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND C.LANGUAGE_ID = B.LANGUAGE_ID AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO  AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND ((TRUNC (SYSDATE) - IB.DATE_OF_BIRTH BETWEEN DECODE (IA.AGE_UNIT, 'D', IA.MIN_AGE, 'M', 30 * IA.MIN_AGE, 'Y', 365 * IA.MIN_AGE ) AND DECODE (IA.AGE_UNIT, 'D', IA.MAX_AGE, 'M', 30 * IA.MAX_AGE, 'Y', 365 * IA.MAX_AGE )) OR ((SYSDATE - IB.DATE_OF_BIRTH)*24 BETWEEN DECODE (IA.AGE_UNIT,'H', IA.MIN_AGE) AND DECODE (IA.AGE_UNIT,'H', IA.MAX_AGE ))))) ");
		//IN072876 End.
	}
	else{

		//sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC, A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE (A.TERM_SET_ID,A.TERM_CODE) IN (");
		sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC, A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY_LANG_VW B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE (A.TERM_SET_ID,A.TERM_CODE) IN (");
		//sql.append(sel_diags);
		sql.append(sel_diags);
		//sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE )))  ORDER  BY 5,1,2");
		sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.LANGUAGE_ID ='");
		sql.append(locale);
		//IN072876 Start.
		//sql.append("' AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE )))  ORDER  BY 5,1,2");
		sql.append("' AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND ((TRUNC (SYSDATE) - IB.DATE_OF_BIRTH BETWEEN DECODE (IA.AGE_UNIT, 'D', IA.MIN_AGE, 'M', 30 * IA.MIN_AGE, 'Y', 365 * IA.MIN_AGE ) AND DECODE (IA.AGE_UNIT, 'D', IA.MAX_AGE, 'M', 30 * IA.MAX_AGE, 'Y', 365 * IA.MAX_AGE )) OR ((SYSDATE - IB.DATE_OF_BIRTH)*24 BETWEEN DECODE (IA.AGE_UNIT,'H', IA.MIN_AGE) AND DECODE (IA.AGE_UNIT,'H', IA.MAX_AGE ))) ))  ORDER  BY 5,1,2");
		//IN072876 End.
	}
	
//	sql_query = "SELECT DISTINCT C.CASE_TYPE_CODE , C.SHORT_DESC CASE_TYPE_DESC, D.TERM_SET_DESC, E. SHORT_DESC TERM_DESC,B.TERM_SET_ID,B.TERM_CODE FROM PR_DIAGNOSIS A, CP_TERM_CODE_FOR_CASE_TYPE B, CP_CASE_TYPE C, MR_TERM_SET  D , MR_TERM_CODE E WHERE A.PATIENT_ID = ? AND  A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B') AND B.CASE_TYPE_CODE= ? AND B.TERM_SET_ID=A.TERM_SET_ID AND B.TERM_CODE  =A.TERM_CODE AND D.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_CODE  =B.TERM_CODE AND C.EFF_STATUS='E' AND C.CASE_TYPE_CODE=B.CASE_TYPE_CODE ORDER BY C.SHORT_DESC, D.TERM_SET_DESC, E. SHORT_DESC  ";
	sql_query = "SELECT DISTINCT C.CASE_TYPE_CODE , C.SHORT_DESC CASE_TYPE_DESC, D.TERM_SET_DESC, E. SHORT_DESC TERM_DESC,B.TERM_SET_ID,B.TERM_CODE FROM PR_DIAGNOSIS A, CP_TERM_CODE_FOR_CASE_TYPE B, CP_CASE_TYPE_LANG_VW C, MR_TERM_SET  D , MR_TERM_CODE E WHERE A.PATIENT_ID = ? AND  A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B') AND B.CASE_TYPE_CODE= ? AND B.TERM_SET_ID=A.TERM_SET_ID AND B.TERM_CODE  =A.TERM_CODE AND D.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_CODE  =B.TERM_CODE AND C.EFF_STATUS='E' AND C.CASE_TYPE_CODE=B.CASE_TYPE_CODE AND C.LANGUAGE_ID = ? ORDER BY C.SHORT_DESC, D.TERM_SET_DESC, E. SHORT_DESC  ";
	
	ps = con.prepareStatement(sql.toString());
	ps.setString(1, patient_class);
	ps.setString(2, patient_id);
	rs = ps.executeQuery();
	pstmt = con.prepareStatement(sql_query);


            _bw.write(_wl_block75Bytes, _wl_block75);
String diag_desc="",diag_desc1="";int k=0,h=0,cs_cnt=1;
	while(rs.next())
	{	
		if ( i % 2 == 0 )
			classValue = "GRPEVEN" ;
		else
			classValue = "GRPOD" ;

		String temp_chk= "",temp_chk1="";String term_desc="";
		String version_desc="";String clkvalue="";
		String tmp_term_code ="";
		tmp_term_code = rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(5)+"~"+rs.getString(7)+"~";
		codeKeyValue = bean.getTermCode();
		
		temp_chk =(String)codeKeyValue.get(tmp_term_code)== null?"":(String)codeKeyValue.get(tmp_term_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "";
		if(rs.getString(5).equals("00")){	
		codeKeyValue = bean.getCaseCode();
		temp_chk1 =(String)codeKeyValue.get(rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(7))== null?"":(String)codeKeyValue.get(rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(7));
		if(!temp_chk1.equals("") && temp_chk1.equals("Y"))
			checked = "checked";
		else
			checked = "";
		}
		library_id = rs.getString(1);
		version_no = rs.getString(2);

		if(!tmp_library_id.equals(library_id)){
			library_desc= rs.getString(3)+"&nbsp;(Version No:&nbsp;"+version_no+"&nbsp;)";
			tmp_version_no="";
		}else if(tmp_library_id.equals(library_id) && !tmp_version_no.equals(version_no))
			library_desc= rs.getString(3)+"&nbsp;(Version No:&nbsp;"+version_no+"&nbsp;)";
		else
			library_desc = "";
			
		if(!library_desc.equals("")){
			if(h>1){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( (i - 1) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( h ));
            _bw.write(_wl_block78Bytes, _wl_block78);

				}

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);

			h=0;
		}
		
		if(!tmp_version_no.equals(version_no)){
				if(k>0){k=i-1;

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(k));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block83Bytes, _wl_block83);

			}
			diag_desc="";k=0;
			diag_desc = rs.getString(7)+"|";
			version_desc= rs.getString(4);
				
		}
		else{
			version_desc =  "";k++;
			diag_desc =diag_desc+rs.getString(7)+"|";
		}
		tmp_library_id = library_id;
		tmp_version_no = version_no;

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(library_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);

	if(!version_desc.equals("")){

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(5).equals("00")?rs.getString(7):""));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(7)==null?"":rs.getString(7)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block89Bytes, _wl_block89);

	}		

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(version_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rs.getString(8)));
            _bw.write(_wl_block95Bytes, _wl_block95);

		clkvalue="populateLibDetails1("+i+")";
		if(rs.getString(5).equals("00")){
		
		clkvalue="populateLibDetails("+i+")";
		

	pstmt.setString(1, patient_id);
	pstmt.setString(2, rs.getString(7));
	pstmt.setString(3,locale);
	rst = pstmt.executeQuery();
				

            _bw.write(_wl_block96Bytes, _wl_block96);

	if(!library_desc.equals("") && !version_desc.equals("")){
				diag_desc1="";term_desc = "";cs_cnt=1;
		 }
			while(rst.next()){
			
				k=0;
				term_desc = rst.getString(5);
				diag_desc1 =diag_desc1 + rst.getString(6)+"|";
						
			
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rst.getString(4)));
            _bw.write(_wl_block100Bytes, _wl_block100);

		}
		rst.close();
		pstmt.close();

		if(library_desc.equals("") && version_desc.equals("")){

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf((i-cs_cnt)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(diag_desc1));
            _bw.write(_wl_block83Bytes, _wl_block83);
			
		cs_cnt++;
		}else{

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(diag_desc1));
            _bw.write(_wl_block104Bytes, _wl_block104);

		}

            _bw.write(_wl_block105Bytes, _wl_block105);

	}

            _bw.write(_wl_block106Bytes, _wl_block106);

	if(!version_desc.equals("")){

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(clkvalue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block110Bytes, _wl_block110);

		i++; 
	}

            _bw.write(_wl_block111Bytes, _wl_block111);

	h++;	
	}	

	rs.close();
	ps.close();

	if(h>1){

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( (i - 1) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( h ));
            _bw.write(_wl_block113Bytes, _wl_block113);

	}
	

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block116Bytes, _wl_block116);
	
	}
if(show_diag.equals("showall")){
	
	int j=0;
	codeKeyValue = bean.getLimitLib();
	Set ss=codeKeyValue.keySet();
	Object[] record =  ss.toArray();
	if(record.length>0){
		term_set_id = record[0].toString();
		term_code = (String)codeKeyValue.get(term_set_id);
	}
	
	StringTokenizer stk=new StringTokenizer(term_set_id,",");
	term_set_id="";
	while(stk.hasMoreTokens()){
		term_set_id = term_set_id +"'"+stk.nextToken()+"',";
	}
	StringTokenizer stk1=new StringTokenizer(term_code,",");
	term_code="";
	while(stk1.hasMoreTokens()){
		term_code = term_code +"'"+stk1.nextToken()+"',";
	}
	if(term_set_id.length()>0)
		term_set_id = term_set_id.substring(0,term_set_id.length()-1);
	else
		term_set_id="''";
	if(term_code.length()>0)
		term_code = term_code.substring(0,term_code.length()-1);
	else
		term_code="''";

	case_type_code = "''";	
//	con = ConnectionManager.getConnection(request);
	/*sql.append("SELECT TO_CHAR(NULL) CASE_TYPE_CODE ,TO_CHAR(NULL) CASE_TYPE_DESC ,A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE A.TERM_SET_ID IN(");
	sql.append(term_set_id);
	sql.append(") AND A.TERM_CODE IN(");
	sql.append(term_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID  AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) UNION ALL SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,TO_CHAR(NULL) TERM_SET_ID ,TO_CHAR(NULL) TERM_SET_DESC ,TO_CHAR(NULL) TERM_CODE ,TO_CHAR(NULL) TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE IN(");
	sql.append(case_type_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE  AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO) ORDER BY TERM_CODE");
	*/
	sql.append("SELECT TO_CHAR(NULL) CASE_TYPE_CODE ,TO_CHAR(NULL) CASE_TYPE_DESC ,A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY_LANG_VW B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE B.LANGUAGE_ID = '");
	sql.append(locale);
	sql.append("' AND A.TERM_SET_ID IN(");
	sql.append(term_set_id);
	sql.append(") AND A.TERM_CODE IN(");
	sql.append(term_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID  AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) UNION ALL SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,TO_CHAR(NULL) TERM_SET_ID ,TO_CHAR(NULL) TERM_SET_DESC ,TO_CHAR(NULL) TERM_CODE ,TO_CHAR(NULL) TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE IN(");
	sql.append(case_type_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE  AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO) ORDER BY TERM_CODE");
	

	ps = con.prepareStatement(sql.toString());
	ps.setString(1, patient_class);
	ps.setString(2, patient_class);
	rs = ps.executeQuery();


            _bw.write(_wl_block117Bytes, _wl_block117);

	while(rs.next())
	{	
		
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		
		if(rs.getString(3)!= null){
		String tmp_term_code ="";
		tmp_term_code = rs.getString(7)+"~"+rs.getString(8)+"~"+rs.getString(3)+"~"+rs.getString(5)+"~";
		codeKeyValue = bean.getTermCode();
		String temp_chk= "";
		//Set s=codeKeyValue.keySet();
		temp_chk =(String)codeKeyValue.get(tmp_term_code)== null?"":(String)codeKeyValue.get(tmp_term_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "";
		}
		if(rs.getString(1)!= null){
			codeKeyValue = bean.getCaseCode();
			case_type_code = rs.getString(1);
			String temp_chk= "";
			temp_chk =(String)codeKeyValue.get(case_type_code)== null?"":(String)codeKeyValue.get(case_type_code);
			if(!temp_chk.equals("") && temp_chk.equals("Y"))
				checked = "checked";
			else
				checked = "";
		}
		term_code = rs.getString(5);
		if(!term_code.equals(term_code1)){

            _bw.write(_wl_block118Bytes, _wl_block118);
out.println(rs.getString(6)==null?rs.getString(2):rs.getString(6));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(j));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
//out.println("<script>alert('i::"+i+"-j::"+j+"--')</script>");
			i=0;
			term_code1=term_code; j++;		
		}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block122Bytes, _wl_block122);
out.println(rs.getString(9));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(1)==null?"":rs.getString(1)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(3)==null?"":rs.getString(3)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(5)==null?"":rs.getString(5)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(7)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(8)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
out.println(rs.getString(8));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
out.println(rs.getString(10));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block127Bytes, _wl_block127);

		i++;
	}	

	rs.close();
	ps.close();

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(j));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(j));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block131Bytes, _wl_block131);
	
	}
	if(i==0){out.println("<script>alert(getMessage('NO_STD_CP_AVAIL','CP'))</script>");	

            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
if(!term_code_desc.equals(""))
			 out.println(term_code_desc);
		  else if(!casetype_desc.equals(""))
			 out.println(casetype_desc);
            _bw.write(_wl_block134Bytes, _wl_block134);
if(!term_code_desc.equals("") || !casetype_desc.equals("") ){
            _bw.write(_wl_block135Bytes, _wl_block135);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block137Bytes, _wl_block137);
}
}
catch(Exception ee)
{
	out.println("Exception while populating the values of case type r diagnosis Module "+ee.toString());
	System.out.println("Exception while populating the values of case type r diagnosis Module "+ee.toString());
	ee.printStackTrace();
}
finally
{
	try{
			if(rs != null) rs.close();
			if(rst != null) rst.close();
			if(ps != null) ps.close();
			if(pstmt != null) pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
		}
}


            _bw.write(_wl_block138Bytes, _wl_block138);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryDescription.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.StandardCarePlans.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.StandardCarePlans.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Library.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Guideline.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryDescription.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.VersionNo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Guideline.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.VersionNo.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.VersionNo.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryDescription.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.VersionNo.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Guideline.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.NoStandardCarePlanAvailable.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
