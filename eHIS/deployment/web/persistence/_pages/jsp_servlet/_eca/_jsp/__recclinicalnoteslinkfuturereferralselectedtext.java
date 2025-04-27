package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkfuturereferralselectedtext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp", 1709116155622L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesLinkFutureEvent.js\'></script>\n\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\"scrollTitle1()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\t\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n\n<form name=\"RecClinicalNotesLinkFutureApptSelectedTextForm\" id=\"RecClinicalNotesLinkFutureApptSelectedTextForm\">\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr ><td colspan=2 class=\'CAGROUP\' ><b><font size=\'2\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b></td></tr>\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n<tr>\n<!-- <th nowrap width=\"32%\" style=\"font-size:10\">Drug Name</th>\n<th nowrap width=\"30%\" style=\"font-size:10\">Dosage Details</th>\n<th nowrap width=\"19%\" style=\"font-size:10\">Start Date</th>\n<th nowrap style=\"font-size:10\">End Date</th> -->\n</tr>\n</table>\n</div>\n\n\n\n<div id=\"finalDiv1\">\n<table class=\'grid\' width=\"100%\" align=\'center\'>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<tr>\t\t\t\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" ><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"chkbox";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" checked  onClick=\"selText(this)\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><font size=2><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" : </b></font>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<input type=hidden name=\'clear";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'clear";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  ><font size=2><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" colspan=2><font size=2><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" : </b></font>&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n                    \n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" colspan=4><font size=2><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></font>&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td> \n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" colspan=\"4\">\n                   <table border=\"1\"  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n                   <tr>\n                   <td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">&nbsp;</td> \n        \t\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t   \n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</b></font></td> \n        \t\t   \n\t\t\t\t  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" colspan=\"2\"><font size=2><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</b></font></td> \n                   \n\t\t\t\t   \n\t\t\t\t   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t   \n\t\t\t\t\t   <tr> <td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></font></td>    \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;</td>   \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" colspan=\"2\">&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;</td>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</tr>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="  \n\t\t\t\t\t   \n\t\t\t\t\t   <tr>\t\n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</b></font></td>  \n\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;</td> \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td>   \n\t\t\t\t\t   \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t   </tr>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t   \n\t\t\t\t\t   <tr>\t\n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t   \n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;</td>   \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;</td>   \n\t\t\t\t\t   \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</b></font></td>    \n\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&nbsp;</td>   \n\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n               \n\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<tr>\n\t\t\t\t    <!--Below colon is added after each header names by Archana Dhal on 11/10/2010 related to incident no. IN024868 -->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n                    <td class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"></td>\n                    \n                 </tr>\n                  <tr>\n                 <td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td> \n                 </tr>\n                 <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">&nbsp;</td> \n        \t\t   <td class=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</b></font></td> \n        \t\t   <td class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</b></font></td> \n                   </tr>\n\t\t\t\t   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</b></font></td>    \n                   <td class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;</td>   \n                   <td class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&nbsp;</td>   \n\t\t\t\t   </tr>\n\t\t\t\t   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;</td>   \n\t\t\t\t   </tr>\t\n                   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&nbsp;</td>   \n\t\t\t\t   </tr>\n                   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&nbsp;</td>   \n\t\t\t\t   </tr>\n                </table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<!-- <td class=\"label\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>  -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t   \t\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n</td>\n</tr>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t<tr>\t\t\t\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</b></font>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td> \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" colspan=\"4\">\n\t\t\t\t\t   <table border=\"1\"  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t   <tr>\n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">&nbsp;</td> \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</b></font></td> \n\t\t\t\t\t   \n\t\t\t\t\t  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" \n\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</b></font></td> \n\t\t\t\t\t   \n\t\t\t\t\t   \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t   \n\t\t\t\t\t\t   <tr> <td class=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</b></font></td>    \n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="&nbsp;</td>   \n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&nbsp;</td>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="  \n\t\t\t\t\t\t   \n\t\t\t\t\t\t   <tr>\t\n\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</b></font></td>  \n\t\t\t\t\t\t   \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&nbsp;</td> \n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&nbsp;</td>   \n\t\t\t\t\t\t   \n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t   </tr>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t   \n\t\t\t\t\t\t   <tr>\t\n\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t   \n\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;</td>   \n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&nbsp;</td>   \n\t\t\t\t\t\t   \n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</b></font></td>    \n\t\t\t\t\t\t   \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\n\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="&nbsp;</td>   \n\t\t\t\t\t\t   \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\n\n\t\t\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t   \n\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<tr>\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"></td>\n                   \n                 </tr>\n                 <tr>\n                 <td class=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td> \n                 </tr> \n                 <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" colspan=\"4\">\n                   <table border=\"1\"  cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n                   <tr>\n                   <td class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>   \n                   <td class=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>   \n\t\t\t\t   </tr>\n\t\t\t\t   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>   \n\t\t\t\t   </tr>\t\n                   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>   \n\t\t\t\t   </tr>\n                   <tr>\t\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>   \n\t\t\t\t   </tr>\n                </table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\n</tr>\n</table>\n</div>\n<input type=\"hidden\" name=\"temp\" id=\"temp\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n<input type=\"hidden\" name=\"innerhtml\" id=\"innerhtml\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\n</body>\n</form>\n\n\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet EventBean= null;synchronized(session){
                EventBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("EventBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(EventBean==null){
                    EventBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("EventBean",EventBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

//shaiju new diag starts
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		ArrayList  fields			=	new ArrayList();
		String categ_sec_qry ="";
		String field_ref ="";
		/*String col_field ="";
		//String col_val ="";
		String		width			=	"";
		double		col_width		=	0.0;
		int col_span=0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer temp_new = new StringBuffer();*/

		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

		
	try
	{
		
		con =  ConnectionManager.getConnection(request);
	
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='RFRL' order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		//pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='RFRL' order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			//pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();

			}
		

		}

}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagSelectedText.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}




            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";

	String refid=""; 
	String referdate=""; 
	String refpriority=""; 
	String refreason="";  
	String refpractfrom="";  
	String refpractto="";  
	String refspecfrom="";  
	String refspecto= "";   
	String reflocfrom="";  
	String reflocto= "";
	String reffacfrom= "";  
	String reffacto= "";  
	
	String classValue="";
	String classValue1="";
	int w=0;
	return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	
	String formet="";
					//out.println("return_format :" +return_format);
					if(return_format.equals("TEXT"))
					{
						formet="\n";
					}else
					{
						formet="<br>";
					}

	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	StringBuffer innerhtml= new StringBuffer();
	StringBuffer textbuffer= new StringBuffer();
	StringBuffer textbuffer1= new StringBuffer();
	StringBuffer textbuffer2= new StringBuffer();
	

	if(sel_all.equals("select"))
	{	
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	String cat = "";
	int i=0;
   if(flag.equals("clear"))
	{
		
      
		EventBean.clearAll();
	}
	
	if(!removebean.equals("Y"))
	{
		
		if(ret_str!=null && ret_str!="")
		{
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"@");
   
			while(strtCodes.hasMoreTokens())
			{
			   
				temp= (String) strtCodes.nextToken();
			   StringTokenizer tempCodes = new StringTokenizer(temp,"~");
 				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();

				 EventBean.putObject(key);
				 EventBean.putObject(value);
				 
			}
 					
		}
		 
	}		
				
				for(i=1;i<EventBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 ){
		          classValue = "CAGROUP" ;
		          classValue1 = "gridData" ;
				 }else{
		           classValue = "CAGROUP" ;
		           classValue1 = "gridData" ;
				}
				w++;
				//out.println("<script>alert('classValue"+classValue+"')</script>");
		
					disbean=EventBean.getObject(i).toString();

										
					//code added by Shaiju 
						String strs[] = disbean.split("\\|");
												
						if(strs.length>0)
						{
						
						   refid		=	strs[0]; 
						   referdate	=	strs[1];  
						   refpriority	=	strs[2];  
						   refreason	=	java.net.URLDecoder.decode(strs[3]);   
						   refpractfrom	=	java.net.URLDecoder.decode(strs[4]);  
						   refpractto	=	java.net.URLDecoder.decode(strs[5]);
						   refspecfrom	=	java.net.URLDecoder.decode(strs[6]);  
						   refspecto	=	java.net.URLDecoder.decode(strs[7]);   
						   reflocfrom	=	java.net.URLDecoder.decode(strs[8]);  
						   reflocto		=	java.net.URLDecoder.decode(strs[9]);  
						   reffacfrom	=	java.net.URLDecoder.decode(strs[10]);  
						   reffacto		=	java.net.URLDecoder.decode(strs[11]);
						 
								

						//code added by Shaiju  ends


				/*	StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
	 
				   refid=valCodes.nextToken(); 
	               referdate=valCodes.nextToken();  
 	               refpriority=valCodes.nextToken();  
				   refreason= valCodes.nextToken();   
				   refpractfrom= valCodes.nextToken();  
				   refpractto= valCodes.nextToken();
				   refspecfrom= valCodes.nextToken();  
				   refspecto= valCodes.nextToken();   
				   reflocfrom= valCodes.nextToken();  
				   reflocto= valCodes.nextToken();  
				   reffacfrom= valCodes.nextToken();  
				   reffacto= valCodes.nextToken();  */
					
					if(fields.size()>0)
					{
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(refid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(EventBean.getObject(i-1).toString()));
            _bw.write(_wl_block18Bytes, _wl_block18);

						if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" :" +refid+"\n");
						}
						else
						{
							textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
						}
						innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td>");
					
					
						if(fields.contains("DATE"))
						{

							if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" :" +referdate+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
						}
						innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td>");

					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(referdate));
            _bw.write(_wl_block21Bytes, _wl_block21);

						}
						if(fields.contains("PRIORITY"))
						{
							if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" :" +refpriority+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td>");
					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(refpriority));
            _bw.write(_wl_block24Bytes, _wl_block24);

						}innerhtml.append("</tr>");
					
            _bw.write(_wl_block25Bytes, _wl_block25);


						if(fields.contains("REASONFORREFERRAL"))
						{

								if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" :" +refreason+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>");
						}
						innerhtml.append("<tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr>");

					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(refreason));
            _bw.write(_wl_block29Bytes, _wl_block29);

					}
					
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block32Bytes, _wl_block32);


				   if(fields.contains("REFERREDFROM"))
				   {
					   	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"\n");
						}
						else
						{
							textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>");
						}
						innerhtml.append("<tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td>");

				  
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

					}
					if(fields.contains("REFERREDTO"))
					{
							if(return_format.equals("TEXT"))
						{
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+" :" +referdate+"\n");
						}
						else
						{
							textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td>");

					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

					}innerhtml.append(" </tr>");
					
            _bw.write(_wl_block38Bytes, _wl_block38);

					if(fields.contains("PRACTITIONER"))
					{

					   	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
							textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b></font></td> ");

					
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

						if(fields.contains("REFERREDFROM"))
						{
						   	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +refpractfrom+"\n");
						}
						else
						{
							textbuffer1.append(" : "+refpractfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td>");

					  
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refpractfrom));
            _bw.write(_wl_block43Bytes, _wl_block43);

																
						}
						if(fields.contains("REFERREDTO"))
						{
								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +refpractto+"\n");
						}
						else
						{
							textbuffer2.append(" : "+refpractto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td>");

					   
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refpractto));
            _bw.write(_wl_block45Bytes, _wl_block45);

																
						}innerhtml.append("</tr>");
						
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
				   
					if(fields.contains("SPECIALITY"))
					{ 
							if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
							textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b></font></td>");

						
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

						if(fields.contains("REFERREDFROM"))
						{ 
								if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +refspecfrom+"\n");
						}
						else
						{
							textbuffer1.append(" : "+refspecfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td>");

						
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refspecfrom));
            _bw.write(_wl_block49Bytes, _wl_block49);

											
						}
						if(fields.contains("REFERREDTO"))
						{ 
								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +refspecto+"\n");
						}
						else
						{
							textbuffer2.append(" : "+refspecto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

						
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refspecto));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
					  innerhtml.append("</tr>");
					   
            _bw.write(_wl_block51Bytes, _wl_block51);

															
					}
					if(fields.contains("LOCATION"))
					{ 

							if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></font></td>");

						
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

						if(fields.contains("REFERREDFROM"))
						{ 
						  	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +reflocfrom+"\n");
						}
						else
						{
							textbuffer1.append("</b> : "+reflocfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td>");

						
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reflocfrom));
            _bw.write(_wl_block54Bytes, _wl_block54);

																
						}
						if(fields.contains("REFERREDTO"))
						{ 
								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +reffacto+"\n");
						}
						else
						{
							textbuffer2.append("</b> : "+reffacto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

						
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reflocto));
            _bw.write(_wl_block55Bytes, _wl_block55);

						innerhtml.append("</tr>");										
						}
						
            _bw.write(_wl_block46Bytes, _wl_block46);

												
				    }
					if(fields.contains("SOURCE"))
					{ 
							if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</font></td>");

						
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

						if(fields.contains("REFERREDFROM"))
						{
								if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +reffacfrom+"\n");
						}
						else
						{
							textbuffer1.append("</b> : "+reffacfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td> ");

						
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reffacfrom));
            _bw.write(_wl_block58Bytes, _wl_block58);

																
						}
						if(fields.contains("REFERREDTO"))
						{

								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +reffacto+"\n");
						}
						else
						{
							textbuffer2.append("</b> : "+reffacto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td>");
						
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reffacto));
            _bw.write(_wl_block58Bytes, _wl_block58);

																
						}
						innerhtml.append("</tr>");
						
            _bw.write(_wl_block46Bytes, _wl_block46);

															
					}
					//innerhtml.append("</table></td></tr>");	
					
            _bw.write(_wl_block60Bytes, _wl_block60);

						

					textbuffer.append(textbuffer1.toString() + textbuffer2.toString());

					cat=formet+textbuffer.toString();
					cat=cat.replace('|' , ',');
					
					}
					else
					{

					
			
				
					if(return_format.equals("TEXT"))
					{
                     textbuffer.append(" Referral ID : "+refid+"\n");
					 textbuffer.append(" Date : "+referdate+"\n");
					 textbuffer.append(" Priority : "+refpriority+"\n");
					 textbuffer.append(" Reason for Referral : "+ refreason+"\n"); 
					 textbuffer.append(" Referred From\n"); 
					 textbuffer.append(" Practioner : "+refpractfrom+"\n");
					 textbuffer.append(" Specialty : "+refspecfrom+"\n");					
					 textbuffer.append(" Location : "+reflocfrom+"\n");					
					 textbuffer.append(" Source : "+reffacfrom+"\n");
					 textbuffer.append(" Referred To \n"); 
  				     textbuffer.append(" Practioner : "+refpractto+"\n");
 				     textbuffer.append(" Specialty : "+refspecto+"\n");
				     textbuffer.append(" Location : "+reflocto+"\n");
					 textbuffer.append(" Source : "+reffacto+"\n");
					 textbuffer.append("\n\n"); 
					}
					else
					{
				   textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b> : "+refpractfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> : "+refspecfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>  : "+reflocfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>  : "+reffacfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>"); 
  				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b> : "+refpractto+"<br>");
 				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> : "+refspecto+"<br>");
				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b> : "+reflocto+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>   : "+reffacto+"<br>");
					 textbuffer.append("<br><br></font>"); 
					}
						
						

					innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td><td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td></tr><tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr><tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td><td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td></tr>	<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b></font></td>        <td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refspecto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td>  <td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td></tr></table></td></tr>");
				
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(refid));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(referdate));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(refpriority));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(EventBean.getObject(i-1).toString()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(refreason));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refpractfrom));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refpractto));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refspecfrom));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refspecto));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reflocfrom));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reflocto));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reffacfrom));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reffacto));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disbean));
            _bw.write(_wl_block75Bytes, _wl_block75);

				
					cat=formet+textbuffer.toString();
					cat=cat.replace('|' , ',');
                    //cat=cat.replace('|' , '');  
				}
				}
				}
				
            _bw.write(_wl_block76Bytes, _wl_block76);

	}

				


            _bw.write(_wl_block77Bytes, _wl_block77);


	if(removebean.equals("Y"))
	{
	 String beankey="";
	  for(int l=0;l<EventBean.getSize();l++)
	   {
			beankey=EventBean.getObject(l).toString();  


			if(remval.equalsIgnoreCase(beankey))
			{
					EventBean.removeObject(l);
					EventBean.removeObject(l);
					break;
			}
		}

				/*ArrayList d=new ArrayList();
				d=EventBean.getRecordSetHandle();
				int size=0;
				size=d.size();
				d.clear();*/
				w=0;
				for( i=1;i<EventBean.getSize();i+=2)
				{
					
					//beanval=d.get(i).toString();
				    if ( w % 2 == 0 )
		          classValue = "Label" ;
		        else
		           classValue = "CAGROUP" ;
				 w++;

					beanval=EventBean.getObject(i).toString();  

					//code added by Shaiju 
						String strs[] = beanval.split("\\|");
												
						if(strs.length>0)
						{
						
						   refid		=	strs[0]; 
						   referdate	=	strs[1];  
						   refpriority	=	strs[2];  
						   refreason	=	java.net.URLDecoder.decode(strs[3]);   
						   refpractfrom	=	java.net.URLDecoder.decode(strs[4]);  
						   refpractto	=	java.net.URLDecoder.decode(strs[5]);
						   refspecfrom	=	java.net.URLDecoder.decode(strs[6]);  
						   refspecto	=	java.net.URLDecoder.decode(strs[7]);   
						   reflocfrom	=	java.net.URLDecoder.decode(strs[8]);  
						   reflocto		=	java.net.URLDecoder.decode(strs[9]);  
						   reffacfrom	=	java.net.URLDecoder.decode(strs[10]);  
						   reffacto		=	java.net.URLDecoder.decode(strs[11]);
						 
								

						//code added by Shaiju  ends
					
				/*	StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
				   refid=valCodes.nextToken(); 
	               referdate=valCodes.nextToken();  
 	               refpriority=valCodes.nextToken();  
				   refreason= valCodes.nextToken();   
				   refpractfrom= valCodes.nextToken();  
				   refpractto= valCodes.nextToken();
				   refspecfrom= valCodes.nextToken();  
				   refspecto= valCodes.nextToken();   
				   reflocfrom= valCodes.nextToken();  
				   reflocto= valCodes.nextToken();  
				   reffacfrom= valCodes.nextToken();  
				   reffacto= valCodes.nextToken();   */


					if(fields.size()>0)
					{
						

							
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(refid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(EventBean.getObject(i-1).toString()));
            _bw.write(_wl_block80Bytes, _wl_block80);

							if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" :" +refid+"\n");
							}
							else
							{
								textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td>");
						
						
							if(fields.contains("DATE"))
							{

								if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" :" +referdate+"\n");
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td>");

						
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(referdate));
            _bw.write(_wl_block82Bytes, _wl_block82);

							}
							if(fields.contains("PRIORITY"))
							{
								if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" :" +refpriority+"\n");
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td>");
						
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(refpriority));
            _bw.write(_wl_block83Bytes, _wl_block83);

							}innerhtml.append("</tr>");
						
            _bw.write(_wl_block84Bytes, _wl_block84);


							if(fields.contains("REASONFORREFERRAL"))
							{

									if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" :" +refreason+"\n");
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr>");

						
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(refreason));
            _bw.write(_wl_block86Bytes, _wl_block86);

						}
						
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);


					   if(fields.contains("REFERREDFROM"))
					   {
							if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"\n");
							}
							else
							{
								textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>");
							}
							innerhtml.append("<tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td>");

					  
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

						}
						if(fields.contains("REFERREDTO"))
						{
								if(return_format.equals("TEXT"))
							{
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+" :" +referdate+"\n");
							}
							else
							{
								textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td>");

						
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

						}innerhtml.append(" </tr>");
						
            _bw.write(_wl_block93Bytes, _wl_block93);

						if(fields.contains("PRACTITIONER"))
						{

							if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
								textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b></font></td> ");

						
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

							if(fields.contains("REFERREDFROM"))
							{
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +refpractfrom+"\n");
							}
							else
							{
								textbuffer1.append(" : "+refpractfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td>");

						  
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refpractfrom));
            _bw.write(_wl_block97Bytes, _wl_block97);

																	
							}
							if(fields.contains("REFERREDTO"))
							{
									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +refpractto+"\n");
							}
							else
							{
								textbuffer2.append(" : "+refpractto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td>");

						   
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refpractto));
            _bw.write(_wl_block98Bytes, _wl_block98);

																	
							}innerhtml.append("</tr>");
							
            _bw.write(_wl_block46Bytes, _wl_block46);

						}
					   
						if(fields.contains("SPECIALITY"))
						{ 
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
								textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b></font></td>");

							
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

							if(fields.contains("REFERREDFROM"))
							{ 
									if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +refspecfrom+"\n");
							}
							else
							{
								textbuffer1.append(" : "+refspecfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td>");

							
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refspecfrom));
            _bw.write(_wl_block101Bytes, _wl_block101);

												
							}
							if(fields.contains("REFERREDTO"))
							{ 
									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +refspecto+"\n");
							}
							else
							{
								textbuffer2.append(" : "+refspecto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

							
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refspecto));
            _bw.write(_wl_block102Bytes, _wl_block102);

							}
						  innerhtml.append("</tr>");
						   
            _bw.write(_wl_block103Bytes, _wl_block103);

																
						}
						if(fields.contains("LOCATION"))
						{ 

								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
								textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></font></td>");

							
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

							if(fields.contains("REFERREDFROM"))
							{ 
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +reflocfrom+"\n");
							}
							else
							{
								textbuffer1.append("</b> : "+reflocfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td>");

							
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reflocfrom));
            _bw.write(_wl_block106Bytes, _wl_block106);

																	
							}
							if(fields.contains("REFERREDTO"))
							{ 
									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +reffacto+"\n");
							}
							else
							{
								textbuffer2.append("</b> : "+reffacto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

							
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reflocto));
            _bw.write(_wl_block107Bytes, _wl_block107);

							innerhtml.append("</tr>");										
							}
							
            _bw.write(_wl_block46Bytes, _wl_block46);

													
						}
						if(fields.contains("SOURCE"))
						{ 
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
								textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</font></td>");

							
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

							if(fields.contains("REFERREDFROM"))
							{
									if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +reffacfrom+"\n");
							}
							else
							{
								textbuffer1.append("</b> : "+reffacfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td> ");

							
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reffacfrom));
            _bw.write(_wl_block110Bytes, _wl_block110);

																	
							}
							if(fields.contains("REFERREDTO"))
							{

									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +reffacto+"\n");
							}
							else
							{
								textbuffer2.append("</b> : "+reffacto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td>");
							
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reffacto));
            _bw.write(_wl_block110Bytes, _wl_block110);

																	
							}
							innerhtml.append("</tr>");
							
            _bw.write(_wl_block46Bytes, _wl_block46);

																
						}
						//innerhtml.append("</table></td></tr>");	
						
            _bw.write(_wl_block112Bytes, _wl_block112);



						textbuffer.append(textbuffer1.toString() + textbuffer2.toString());

						cat=formet+textbuffer.toString();
						cat=cat.replace('|' , ',');


					}
					else
					{

				
					if(return_format.equals("TEXT"))
					{
                     textbuffer.append(" Referral ID : "+refid+"\n");
					 textbuffer.append(" Date : "+referdate+"\n");
					 textbuffer.append(" Priority : "+refpriority+"\n");
					 textbuffer.append(" Reason for Referral : "+ refreason+"\n"); 
					 textbuffer.append(" Referred From\n"); 
					 textbuffer.append(" Practioner : "+refpractfrom+"\n");
					 textbuffer.append(" Specialty : "+refspecfrom+"\n");					
					 textbuffer.append(" Location : "+reflocfrom+"\n");					
					 textbuffer.append(" Source : "+reffacfrom+"\n");
					 textbuffer.append(" Referred To \n"); 
  				     textbuffer.append(" Practioner : "+refpractto+"\n");
 				     textbuffer.append(" Specialty : "+refspecto+"\n");
				     textbuffer.append(" Location : "+reflocto+"\n");
					 textbuffer.append(" Source : "+reffacto+"\n");
					 textbuffer.append("\n\n"); 
					}
					else
					{
				    textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>  : "+refpractfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b>  : "+refspecfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>  : "+reflocfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>  : "+reffacfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>"); 
  				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>  : "+refpractto+"<br>");
 				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b>  : "+refspecto+"<br>");
				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>   : "+reflocto+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>   : "+reffacto+"<br>");
					 textbuffer.append("<br><br></font>"); 
					}
						
							 
					innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td><td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td></tr><tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr><tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td><td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td></tr>	 <tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+" </b></font></td>        <td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" </b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refspecto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" </b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td>  <td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td></tr></table></td></tr>");
				
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(refid));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(referdate));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(refpriority));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(EventBean.getObject(i-1).toString()));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(refreason));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refpractfrom));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refpractto));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(refspecfrom));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(refspecto));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reflocfrom));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reflocto));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reffacfrom));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reffacto));
            _bw.write(_wl_block121Bytes, _wl_block121);

						cat=formet+textbuffer.toString();
						cat=cat.replace('|' , ',');
                       // cat=cat.replace('|' , ' ');  
					}

				}
		
	}
}

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(cat));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i-2));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(innerhtml.toString()));
            _bw.write(_wl_block125Bytes, _wl_block125);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelectedItems.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforReferral.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.source.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforReferral.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.source.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforReferral.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.source.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforReferral.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.source.label", java.lang.String .class,"key"));
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
}
