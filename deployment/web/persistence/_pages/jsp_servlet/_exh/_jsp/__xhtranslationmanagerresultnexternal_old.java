package jsp_servlet._exh._jsp;

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
import eXH.*;;

public final class __xhtranslationmanagerresultnexternal_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHTranslationManagerResultNExternal_OLD.jsp", 1709122424099L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n<script>/* parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\' */</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n\t<head>\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\'\n\t\t\thref=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\'\n\t\t\thref=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\'\n\t\t\tlanguage=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../js/XHTranslationManagerN.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\n\t</head>\n\t<body onLoad=\'FocusFirstElement()\' OnMouseDown=\'CodeArrest()\'\n\t\tonKeyDown=\'lockKey()\'>\n\t\t<form name=\"TranslationResult\" id=\"TranslationResult\" method=post\n\t\t\taction=\'../../servlet/eXH.XHTranslationManagerServletN\'\n\t\t\ttarget=\"messageFrame\">\n\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>parent.Search.document.forms[0].exportdata.disabled=false; \t\t\t\t    \n\t   </script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script> parent.Search.document.forms[0].uploaddata.disabled=false;\t \n\t   </script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t<p>\n\t\t\t<table align=\'center\' border=0 width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</p>\n\n\t\t\t<table cellspacing=0 cellpadding=0 width=\"100%\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=data align=center\n\t\t\t\t\t\tstyle=\"BACKGROUND-COLOR:white;font:12pt\">\n\t\t\t\t\t\t<B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t</b>\n\t\t\t\t\t</td>\n\t\t\t\t\t</td>\n\t\t\t</table>\n\t\t\t<table cellspacing=0 cellpadding=0 width=\"100%\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<th align=left>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<th align=left>\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<th align=left>\n\t\t\t\t\t\tLabel\n\t\t\t\t\t</th>\n\t\t\t\t\t<th align=left>\n\t\t\t\t\t\teHIS Value\n\t\t\t\t\t</th>\n\t\t\t\t\t<th align=left>\n\t\t\t\t\t\tTranslated Value\n\t\t\t\t\t</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\n\n\n\t\t\t\t<tr>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<!--\t\t\t\t\t <td class=data style=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >&nbsp;</td>  -->\n\t\t\t\t\t<td class=data style=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t\t<b> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<td class=\'fields\' style=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"pkVal";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"pkVal";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\n\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'\n\t\t\t\t\t\t\tmaxlength=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=20>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--  ext_pk1_value\n\t\t\t\t <td class=\'fields\' style=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n \t\t\t\t <INPUT TYPE=\"text\" name=\"pkVal";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"   onblur=\'return makeValidString(this);\'\n\t\t\t\t maxlength=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' size=40 > </td> \n\t\t\t\t -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<input type=hidden name=\"pk";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"pk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"\n\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td class=data>\n\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t</b>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td class=data>\n\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t</b>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\t\t\t\t\t\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"desc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="0\" id=\"desc";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="0\"\n\t\t\t\t\t\t\tonblur=\'return makeValidString(this);\'\n\t\t\t\t\t\t\tmaxlength=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'\n\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'\n\t\t\t\t\t\t\tsize=60>\n\t\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t\t<td class=data style=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t\t\t<b>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t</td>\n\t\t\t\t<input type=\"hidden\" name=\"engLang";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"engLang";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"\n\t\t\t\t\tid=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<td class=\'fields\' style=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t<INPUT TYPE=\"text\" name=\"desc";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"desc";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"\n\t\t\t\t\t\tonblur=\'return makeValidString(this);\'\n\t\t\t\t\t\tmaxlength=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'\n\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'\n\t\t\t\t\t\tsize=50>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\n\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<input type=hidden name=\"pk";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'language_direction\' id=\'language_direction\'\n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'module_id\' id=\'module_id\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'masterName\' id=\'masterName\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'language\' id=\'language\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'application\' id=\'application\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'display\' id=\'display\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'Searchbymod\' id=\'Searchbymod\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'SearchbyFunct\' id=\'SearchbyFunct\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'start_ends_contains\' id=\'start_ends_contains\'\n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'searchText\' id=\'searchText\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'master_table_id\' id=\'master_table_id\'\n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'trans_tab_id\' id=\'trans_tab_id\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'cnt\' id=\'cnt\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'pkDataCnt\' id=\'pkDataCnt\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'flag\' id=\'flag\' value=\"\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'table_or_from\' id=\'table_or_from\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'colsize\' id=\'colsize\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'outbound_yn\' id=\'outbound_yn\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'searchpk2\' id=\'searchpk2\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\'searchpk3\' id=\'searchpk3\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t<input type=\"hidden\" name=\'sqlQuery\' id=\'sqlQuery\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].document.forms[0].sqlQuery.value= this.document.forms[0].sqlQuery.value;\n\t\t\t\t</script>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

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

	Connection con = null;
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	sStyle = "IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	try {
		Properties p = (Properties) session.getValue("jdbc");
		String loggedUser = p.getProperty("login_user");
		StringBuffer sql = new StringBuffer();
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String lang = "";
		//String facilityId = (String) session.getValue("facility_id");	    
		String module_id = request.getParameter("module_id") == null ? ""
		: request.getParameter("module_id");
//		System.out.println("XHTranslationManagerResultN.jsp module_id : "	+ module_id);
		String masterName = request.getParameter("masterName") == null ? ""
		: request.getParameter("masterName");

//		System.out.println("XHTranslationManagerResultN.jsp masterName : "	+ masterName);
		String language = request.getParameter("language") == null ? ""
		: request.getParameter("language");
		String language_direction = request
		.getParameter("language_direction") == null ? ""
		: request.getParameter("language_direction");

		String appl = request.getParameter("application") == null ? ""
		: request.getParameter("application");

//		System.out.println("XHTranslationManagerResultN.jsp application : "+ appl);

		String display = request.getParameter("display") == null ? ""
		: request.getParameter("display");
		//System.out.println("XHTranslationManagerResultN.jsp display : "	+ display);

		String searchText = request.getParameter("searchText") == null ? ""
		: request.getParameter("searchText");
//		System.out.println("XHTranslationManagerResultN.jsp searchText : "+ searchText);
		String searchText1 = searchText;
		String Searchbymod = request.getParameter("Searchbymod") == null ? ""
		: request.getParameter("Searchbymod");
//		System.out.println("XHTranslationManagerResultN.jsp Searchbymod : "+ Searchbymod);
		String SearchbyFunct = request.getParameter("SearchbyFunct") == null ? ""
		: request.getParameter("SearchbyFunct");
//		System.out.println("XHTranslationManagerResultN.jsp SearchbyFunct : "+ SearchbyFunct);
		String start_ends_contains = request
		.getParameter("start_ends_contains") == null ? ""
		: request.getParameter("start_ends_contains");
//		System.out.println("XHTranslationManagerResultN.jsp start_ends_contains : "+ start_ends_contains);
		String outbound_yn = "X";
		//request.getParameter("outbound_yn");			   
		//		System.out.println("outbound_yn : "+outbound_yn);
		String searchpk2 = request.getParameter("searchpk2") == null ? ""
		: request.getParameter("searchpk2");
//		System.out.println("XHTranslationManagerResultN.jsp searchpk2 : "	+ searchpk2);
		String searchpk2Val = searchpk2;
		String searchpk3 = request.getParameter("searchpk3") == null ? ""
		: request.getParameter("searchpk3");
//		System.out.println("XHTranslationManagerResultN.jsp searchpk3 : "	+ searchpk3);
		String searchpk3Val = searchpk3;
		String external_yn = XHDBAdapter.checkNullForCheckBox(request
		.getParameter("external_yn"));
//		System.out.println("XHTranslationManagerResultNExternal.jsp external_yn : "+ external_yn);
		if (start_ends_contains.equals("S")) {
			searchText = searchText + "%";
			searchpk2 = searchpk2 + "%";
			searchpk3 = searchpk3 + "%";

		} else if (start_ends_contains.equals("E")) {
			searchText = "%" + searchText;
			searchpk2 = "%" + searchpk2;
			searchpk3 = "%" + searchpk3;
		} else if (start_ends_contains.equals("C")) {
			searchText = "%" + searchText + "%";
			searchpk2 = "%" + searchpk2 + "%";
			searchpk3 = "%" + searchpk3 + "%";
		}
		String table_or_form = "";

		String table_desc = "";
		int startVal = 0;
		String pk2 = "";
		int colCount = 0;
		String classValue = "";
		String trans_table_id = "";
		String master_table_id = "";
		String pk1 = "";
		String temppk2 = "";
		String from = request.getParameter("from");
		String to = request.getParameter("to");

		String trans_tbl_type = "";

		ArrayList pkval = new ArrayList();
		ArrayList pkValue = new ArrayList();

		ArrayList pkLen = new ArrayList();
		ArrayList pkPrompt = new ArrayList();
		ArrayList columnPrompt = new ArrayList();
		ArrayList columnVal = new ArrayList();

		ArrayList colValue = new ArrayList();
		ArrayList columnLen = new ArrayList();
		int start = 0;
		int end = 0;
		int maxRecord = 0;

		if (from == null)
			start = 1;
		else
			start = Integer.parseInt(from);

		if (to == null)
			end = 20;
		else
			end = Integer.parseInt(to);

		//	System.out.println("trans_table_id : "+trans_table_id);
		//	System.out.println("start : "+start+" end : "+end);

            _bw.write(_wl_block3Bytes, _wl_block3);

		sql.setLength(0);

		sql.append("select * from xh_mapping  where  MASTER_TABLE_ID='"
		+ masterName + "' order by SRL_NO ");

		

		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			table_desc = rs.getString("table_desc") == null ? "" : rs
			.getString("table_desc");
			table_or_form = rs.getString("table_or_form") == null ? ""
			: rs.getString("table_or_form");
			if (rs.getString("pk_yn").equals("Y")) {

		pkval.add(rs.getString("COLUMN_ID") == null ? "" : rs
				.getString("COLUMN_ID"));
		pkLen.add(rs.getString("COLUMN_LENGTH") == null ? ""
				: rs.getString("COLUMN_LENGTH"));
		pkPrompt.add(rs.getString("COLUMN_PROMPT") == null ? ""
				: rs.getString("COLUMN_PROMPT"));
		pkValue
				.add(rs.getString("TRANS_COLUMN_ID") == null ? ""
				: rs.getString("TRANS_COLUMN_ID"));
		count++;
			}
			// else
			else if (!(rs.getString("COLUMN_ID").equals("LONG_DESC"))) {
		columnLen
				.add(rs.getString("COLUMN_LENGTH") == null ? ""
				: rs.getString("COLUMN_LENGTH"));
		columnVal.add(rs.getString("COLUMN_ID") == null ? ""
				: rs.getString("COLUMN_ID"));
		columnPrompt
				.add(rs.getString("COLUMN_PROMPT") == null ? ""
				: rs.getString("COLUMN_PROMPT"));
		colValue
				.add(rs.getString("TRANS_COLUMN_ID") == null ? ""
				: rs.getString("TRANS_COLUMN_ID"));
		count++;
			}
			trans_table_id = rs.getString("trans_table_id") == null ? ""
			: rs.getString("trans_table_id");
			master_table_id = rs.getString("master_table_id") == null ? ""
			: rs.getString("master_table_id");

			int trans_tbl_len = trans_table_id.length();
			trans_tbl_type = trans_table_id.substring(
			trans_tbl_len - 4, trans_tbl_len);
			if (count == 0) {
			}

			//	count++;
		}
		//		System.out.println("Count : "+count);

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

					sql.setLength(0);

					sql
					.append("Select count(*)  total from (Select 'en' APPLICATION_ID, 1 seq_no,");

					if (!masterName.equals("SM_MASTER_CODE")) {
						for (startVal = 0; startVal < pkValue.size(); startVal++) {
							sql.append(pkValue.get(startVal));
							if (startVal < pkValue.size() ) {
								sql.append(",");
							}
						}
					} // end of !SM_MASTER_CODE 
					else {
						sql.append("MODULE_ID,to_char(MASTER_CODE),");
					}

					if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
					|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")
					|| trans_tbl_type.equals("APPL")) {
						for (startVal = 0; startVal < columnVal.size(); startVal++) {
							sql.append("desc" + (startVal + 2) + "_Value");
							if (startVal < columnVal.size() - 1) {
								sql.append(",");
							}
						}
					} // added on 12th March 2009
					else {
						for (startVal = 0; startVal < colValue.size(); startVal++) {
							sql.append(colValue.get(startVal));
							if (startVal < (colValue.size() - 1)) {
								sql.append(",");
							}
						}
					}
					//		System.out.println(" trans_table_id sql 264 : "+sql);

					// Non-Translated
					if (display.equals("N")) {

						sql.append(" from  " + trans_table_id + "  where ");
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
						sql
								.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "'   and OUTBOUND_YN='" + outbound_yn
								+ "'  ");
								if (columnVal.size() > 0) {
									sql
									.append("	 and (desc2_value is null AND ext_pk_id is null ) /* ) */ AND UPPER(NVL("
											+ pkValue.get(0)
											+ ",'*')) like upper('"
											+ searchText + "')");
								} else {
									sql.append(" and ext_pk_id is null AND UPPER(NVL("
									+ pkValue.get(0) + ",'*')) like upper('"
									+ searchText + "')) ");
								}
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
						sql
								.append("table_id='"
								+ masterName
								+ "' and APPLICATION_ID='"
								+ appl
								+ "' and OUTBOUND_YN='"
								+ outbound_yn
								+ "'  and (desc2_value is null AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) /* ) */ AND UPPER(NVL("
								+ pkValue.get(0) + ",'*')) like upper('"
								+ searchText + "')  AND UPPER(NVL("
								+ pkValue.get(1) + ",'*')) like upper('"
								+ searchpk2 + "') ");
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
						|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");

						} else if (trans_tbl_type.equals("APPL")) {
							sql
									.append(" APPLICATION_ID='"
									+ appl
									+ "'  and OUTBOUND_YN='"
									+ outbound_yn
									+ "'  and (desc2_value is null AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL  AND ext_pk3_value IS  NULL) ) AND UPPER(NVL("
									+ pkval.get(0) + ",'*')) like upper('"
									+ searchText + "')  AND UPPER(NVL("
									+ pkval.get(1) + ",'*')) like upper('"
									+ searchpk2 + "')  and  UPPER(NVL("
									+ pkval.get(2) + ",'*')) like upper('"
									+ searchpk3 + "')");
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");
						} else {

					// code added on 25th Dec - Name Prefix - only for Code
					//   sql.append("APPLICATION_ID='"+appl+"'  and "+columnVal.get(0)+" is null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
					sql.append("APPLICATION_ID='" + appl + "' ");
					sql.append(" ) AND UPPER(NVL(" + pkval.get(0)
							+ ",'*')) like upper('" + searchText
							+ "' )  and  UPPER(NVL(" + pkval.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "') and  UPPER(NVL(" + pkval.get(2)
							+ ",'*')) like upper('" + searchpk3 + "')");
					// end of code added

					sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							// code added on 24th Dec - Name Prefix - only for Code
							// sql.append("pk_value,");
							if (columnVal.size() > 0) {
								sql.append("pk_value,");
							} else {
								sql.append("pk_value");
							}
							// end of code added 
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//	     	Cmmnt on Oct16 sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");

								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("pk1_value,pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_tbl_type.equals("APPL")) {
							sql.append("pk1_value,pk2_value,pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else {
								for (startVal = 0; startVal < pkval.size(); startVal++) {
									sql.append(pkval.get(startVal) + ",");
								}

								for (startVal = 0; startVal < columnVal.size(); startVal++) {
									sql.append(columnVal.get(startVal));
									if (startVal < columnVal.size() - 1) {
										sql.append(",");
									}

								}
						}

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							sql.append("   FROM  " + trans_table_id
									+ "  WHERE APPLICATION_ID = '" + appl
									+ "' and table_id='" + masterName
									+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

							if (columnVal.size() > 0) {
								sql
								.append("   and  (desc2_value is null AND ext_pk_id is null ) ");
							} else {
								sql.append("   and  ext_pk_id is null ");
							}

							sql.append(" AND /* pk_value IN (SELECT "
							+ pkval.get(0) + "  from " + masterName
							+ "  where */ UPPER(NVL(" + pkValue.get(0)
							+ ",'*')) LIKE upper('" + searchText
							+ "')) /*) */ ");
						}// end of XH_OTH_APPL_DATA_SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
									.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS NULL AND ext_pk2_value IS NULL) and APPLICATION_ID = '"
									+ appl + "' and table_id='"
									+ masterName + "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

							//	sql.append(pkval.get(1) + "  from " + masterName
							sql.append("AND UPPER(NVL(" + pkValue.get(0)
								+ ",'*')) like upper('" + searchText
								+ "')  AND UPPER(NVL(" + pkValue.get(1)
								+ ",'*')) like upper('" + searchpk2
								+ "') ) /*) */ ");

						} // end of  XH_OTH_APPL_DATA_DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
									.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS NULL AND ext_pk2_value IS NULL AND ext_pk3_value IS NULL) and APPLICATION_ID = '"
									+ appl + "' and OUTBOUND_YN='"
									+ outbound_yn + "' ");
							sql
									.append(" AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));

							sql.append("  from " + masterName
									+ "  where  UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "')  AND UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "')  and  UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3 + "') ))");

						} // end of APPL
						else {
							sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl + "' ");
							sql.append(" and  (");
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}
							sql.append(" ) IN (SELECT ");
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}
						sql.append(" from " + masterName + "  where UPPER(NVL("
								+ pkval.get(0) + ",'*')) LIKE upper('"
								+ searchText + "')  and  UPPER(NVL("
								+ pkval.get(1) + ",'*')) like upper('"
								+ searchpk2 + "') and  UPPER(NVL("
								+ pkval.get(2) + ",'*')) like upper('"
								+ searchpk3 + "')))");

						} // end of !(SKEY ,DKEY)

					} // end of Non-Translated

					// 	 Translated
					else if (display.equals("T")) {

						sql.append(" from  " + trans_table_id + "  where ");

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "' 	 and OUTBOUND_YN='" + outbound_yn + "' ");
							if (columnVal.size() > 0) {
								sql
								.append("and (desc2_value is not null OR ext_pk_id is not null ) /* )*/ ");
							} else {
								sql.append(" AND ext_pk_id is not null /* )*/ ");
							}
							sql.append(" AND UPPER(NVL(" + pkValue.get(0)
									+ ",'*')) like upper('" + searchText + "') ");
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
						sql
							.append("table_id='"
							+ masterName
							+ "' and APPLICATION_ID='"
							+ appl
							+ "'  and OUTBOUND_YN='"
							+ outbound_yn
							+ "' and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL) /* )*/ AND UPPER(NVL("
							+ pkValue.get(0) + ",'*')) like upper('"
							+ searchText + "')  AND UPPER(NVL("
							+ pkValue.get(1) + ",'*')) like upper('"
							+ searchpk2 + "') ");
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
						|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");

						} else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("APPLICATION_ID='"
							+ appl
							+ "'  and OUTBOUND_YN='"
							+ outbound_yn
							+ "'  and (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL OR ext_pk3_value IS NOT NULL)  ) AND UPPER(NVL("
							+ pkval.get(0) + ",'*')) like upper('"
							+ searchText + "')  AND UPPER(NVL("
							+ pkval.get(1) + ",'*')) like upper('"
							+ searchpk2 + "')  and  UPPER(NVL("
							+ pkval.get(2) + ",'*')) like upper('"
							+ searchpk3 + "') ");
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");
						} else {

							sql.append("APPLICATION_ID='" + appl + "' ) ");
							sql.append(" AND UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "' )  and  UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') and  UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3 + "')");

							sql.append(" union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO,");

						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							// code added on 24th Dec - Name Prefix - only for Code
							// sql.append("pk_value,");
							if (columnVal.size() > 0) {
								sql.append("pk_value,");
							} else {
								sql.append("pk_value");
							}
							// end of code added 

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// Cmmntd Oct16 	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("pk1_value,pk2_value,");
							//		 sql.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_tbl_type.equals("APPL")) {
							sql.append("pk1_value,pk2_value,pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}

							}
						}

					if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("   FROM  " + trans_table_id
								+ "  WHERE APPLICATION_ID = '" + appl
								+ "' and table_id='" + masterName
								+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

							if (columnVal.size() > 0) {
								sql
								.append("   AND  (DESC2_VALUE is not null OR ext_pk_id is not null ) ");
							} else {
								sql.append("   AND  ext_pk_id is not null  ");
							}

							sql.append(" AND  UPPER(NVL(" + pkValue.get(0)
							+ ",'*')) LIKE upper('" + searchText
							+ "')) /*)*/");

						}// end of XH_OTH_APPL_DATA_SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
						sql
							.append("   FROM  "
							+ trans_table_id
							+ "  WHERE  (DESC2_VALUE IS not NULL OR ext_pk1_value IS not NULL OR ext_pk2_value IS not NULL) and APPLICATION_ID = '"
							+ appl + "' and table_id='"
							+ masterName + "'  and OUTBOUND_YN='"
							+ outbound_yn + "' ");

							sql.append("AND UPPER(NVL(" + pkValue.get(0)
							+ ",'*')) like upper('" + searchText
							+ "')  AND UPPER(NVL(" + pkValue.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "') ) /*) */");
						} // end of  XH_OTH_APPL_DATA_DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
								.append("   FROM  "
								+ trans_table_id
								+ "  WHERE  (DESC2_VALUE IS not NULL OR ext_pk1_value IS not NULL OR ext_pk2_value IS not NULL OR ext_pk3_value IS not NULL) and APPLICATION_ID = '"
								+ appl + "'  and OUTBOUND_YN='"
								+ outbound_yn + "'  ");

							sql
								.append(" AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
								+ pkval.get(0)
								+ ","
								+ pkval.get(1)
								+ "," + pkval.get(2));

							sql.append("  from " + masterName
									+ "  where UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "')  AND UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') and  UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3 + "') ))");

						} else {

					// sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is not null and APPLICATION_ID = '"+appl+"' " ); 
					sql.append("   FROM  " + trans_table_id
							+ "  WHERE APPLICATION_ID = '" + appl + "' ");

					sql.append(" and  (");
					for (startVal = 0; startVal < pkValue.size(); startVal++) {
						sql.append(pkValue.get(startVal));
						if (startVal < pkValue.size() - 1) {
							sql.append(",");
						}
					}

					sql.append(" ) IN (SELECT ");

					for (startVal = 0; startVal < pkValue.size(); startVal++) {
						sql.append(pkValue.get(startVal));
						if (startVal < pkValue.size() - 1) {
							sql.append(",");
						}
					}
					sql.append(" from " + masterName + "  where UPPER(NVL("
							+ pkval.get(0) + ",'*')) LIKE upper('"
							+ searchText + "')  and  UPPER(NVL("
							+ pkval.get(1) + ",'*')) like upper('"
							+ searchpk2 + "') and  UPPER(NVL("
							+ pkval.get(2) + ",'*')) like upper('"
							+ searchpk3 + "')))");

						} // end of !(SKEY ,DKEY)

					} // end of Translated
					else {

						//	 System.out.println("663");
						sql.append(" from  " + trans_table_id + "  where ");
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
						|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "' 	and OUTBOUND_YN='" + outbound_yn
								+ "' /*)*/ ");

					if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
						sql
						.append("AND UPPER(NVL(pk_value,'*')) like upper('"
								+ searchText + "')");
					} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
						sql
						.append("AND UPPER(NVL(PK1_VALUE,'*')) like upper('"
								+ searchText + "')  AND UPPER(NVL(PK2_VALUE,'*')) like upper('" + searchpk2
								+ "') ");
					}

					// end of  code added on Dec 24th for Name Prefix

					sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} else if (trans_tbl_type.equals("APPL")) {
							sql
									.append(" APPLICATION_ID='" + appl
									+ "' 	and OUTBOUND_YN='" + outbound_yn
									+ "' ) ");
							sql.append("AND UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "')  AND UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') AND UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3 + "')");
							sql.append("  union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO, ");
						}

						else {
							sql.append("APPLICATION_ID='" + appl
									+ "'  )  AND UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "' )  and  UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') and  UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3 + "') ");

							sql.append(" union	 SELECT  '" + appl
									+ "' APPLICATION_ID,2 SEQ_NO,");

						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							if (columnVal.size() > 0) {
								sql.append("pk_value,");
							} else {
								sql.append("pk_value");
							}
							// end of code added 

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//	 		System.out.println("712");
								//	     	sql.append("desc"+(startVal+1)+"_Value"); cmmntd on Aug 8
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("pk1_value,pk2_value,");
							// 	 		System.out.println("724");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else if (trans_tbl_type.equals("APPL")) {
							sql.append("pk1_value,pk2_value,pk3_value,");

							// 	 		System.out.println("724");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								//	     	sql.append("desc"+(startVal+2)+"_Value");
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
						} else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}

							}
						}

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
						sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl
								+ "' and table_id='" + masterName
								+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

						sql
						.append("  AND /* pk_value IN (SELECT "
								+ pkval.get(0)
								+ "  from "
								+ masterName
								+ "  where */ UPPER(NVL(PK_VALUE,'*')) LIKE upper('"
								+ searchText + "')) /*) */");

						}// end of XH_OTH_APPL_DATA_SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql.append("   FROM  " + trans_table_id
									+ "  WHERE  APPLICATION_ID = '" + appl
									+ "' and table_id='" + masterName
									+ "'  and OUTBOUND_YN='" + outbound_yn + "' ");

	//						sql.append(pkval.get(1) + "  from " + masterName
							sql.append("AND UPPER(NVL(PK1_VALUE,'*')) like upper('" + searchText
							+ "')  AND UPPER(NVL(PK2_VALUE,'*')) like upper('" + searchpk2
							+ "') ) /*) */");
						} // end of  XH_OTH_APPL_DATA_DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
									.append("   FROM  " + trans_table_id
									+ "  WHERE  APPLICATION_ID = '" + appl
									+ "'  and OUTBOUND_YN='" + outbound_yn
									+ "'   ");

							sql
									.append(" AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));
							//	sql.append(" AND ("+pkval.get(0)+","+pkval.get(1)+","+pkval.get(2)+") IN (SELECT "+pkval.get(0)+",");

							sql.append("  from " + masterName
									+ "  where UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "')  AND UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') AND UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3
									+ "')   ))");

						} // end of  APPL
						else {

							sql.append("   FROM  " + trans_table_id
									+ "  WHERE  APPLICATION_ID = '" + appl + "' ");

							sql.append(" and  (");
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}

							sql.append(" ) IN (SELECT ");

							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal));
								if (startVal < pkValue.size() - 1) {
									sql.append(",");
								}
							}
							sql.append(" from " + masterName + "  where UPPER(NVL("
									+ pkval.get(0) + ",'*')) LIKE upper('"
									+ searchText + "')  and  UPPER(NVL("
									+ pkval.get(1) + ",'*')) like upper('"
									+ searchpk2 + "') and  UPPER(NVL("
									+ pkval.get(2) + ",'*')) like upper('"
									+ searchpk3 + "') ))");

						} // end of !(SKEY ,DKEY)

					} // end of ALL
					
					pstmt = con.prepareStatement(sql.toString());
					rs = pstmt.executeQuery();

					rs.next();
					maxRecord = rs.getInt("total");

					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();

					if (maxRecord == 0) {
						out
						.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.Search.document.forms[0].synchronize.disabled=false;parent.dummyFrame.location.href='../../eCommon/html/blank.html';</script>");
					} else {
						String export_data_yn = "N";
						String upload_data_yn = "N";
						String authSql = "SELECT export_data_yn,upload_data_yn FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"
						+ loggedUser + "')";

						ResultSet authRS = null;

						try {

					authRS = con.createStatement().executeQuery(authSql);
					if (authRS.next()) {
						export_data_yn = authRS.getString(1);
						upload_data_yn = authRS.getString(2);
					}
						} catch (Exception e) {
					System.out
							.println("Exception in XHTranslationMangerResult :"
							+ e);
						}
						if (authRS != null)
					authRS.close();

						if (export_data_yn.equals("Y")) {
			
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			if (upload_data_yn.equals("Y")) {
			
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			
            _bw.write(_wl_block10Bytes, _wl_block10);

									// System.out.println("951 start : "+start);
									//	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
									if (!(start <= 1))
								out
										.println(" <A HREF='javascript:recordPrevData()'  text-decoration='none'>"
										+ "Previous" + "</A>");

									if (!((start + 20) > maxRecord))
								out
										.println(" <A href='javascript:recordNextData()' text-decoration='none'>"
										+ "Next" + "</A>");

						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(table_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

							if (!table_or_form.equals("F")) {
							for (int startval = 0; startval < pkPrompt.size(); startval++) {
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkPrompt.get(startval)));
            _bw.write(_wl_block14Bytes, _wl_block14);

							}

							for (int startval = 0; startval < columnPrompt.size(); startval++) {
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(columnPrompt.get(startval)));
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
					
            _bw.write(_wl_block16Bytes, _wl_block16);

					} else {
					
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
					
            _bw.write(_wl_block18Bytes, _wl_block18);

							sql.setLength(0);
							/*
							 if(display.equals("N") || display.equals("T"))
							 {
							 */
							sql.append("Select 'en'  APPLICATION_ID,1 SEQ_NO,");
							/*	
							 }else
							 {
							 sql.append("Select a.APPLICATION_ID,2 SEQ_NO," ); 
							 // cmnntd on J17 sql.append("Select a.APPLICATION_ID, b.SEQ_NO," ); 

							 }
							 */
							if (!masterName.equals("SM_MASTER_CODE")) {

							for (startVal = 0; startVal < pkValue.size(); startVal++) {
								sql.append(pkValue.get(startVal)+" "+pkval.get(startVal));
								if (startVal < pkValue.size() ) {
									sql.append(",");
								}
							}
						// Oct 16
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							//		   System.out.println("919 :pkval.get(0) "+pkval.get(0));
							//    sql.append("a.");
							// modified on Dec 24 for Name Prefix - only for code
							if (columnVal.size() > 0) {
								sql.append("PK_VALUE ext_pk_id,");
							} else {
								sql.append("PK_VALUE ext_pk_id");
							}
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							//   		   System.out.println("925 DKEY");		  

							// added on Oct15
							int pkCnt = 1;
							for (startVal = 0; startVal < pkValue.size(); startVal++) {
							//	sql.append("a.");
								sql.append(pkValue.get(startVal) + " ext_pk"
								+ pkCnt + "_value,");
								pkCnt++;
							}
						}
						if (trans_tbl_type.equals("APPL")) {
							//   		   System.out.println("925 DKEY");

							// added on Oct15
							int pkCnt = 1;
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append("a.");
								sql.append(pkval.get(startVal) + " ext_pk"
								+ pkCnt + "_value,");
								pkCnt++;
							}
						}
						//            System.out.println("sql 934 : "+sql);
							} 

							if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
							|| trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")
							|| trans_tbl_type.equals("APPL")) {

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 1) + "_Value ");
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
									sql.append(",");
								}
							}
							} // added on 12th March 2009
							else {
								int pkCnt = 1;
								int startVal1 = 0;
								for (startVal = 0; startVal < colValue.size(); startVal++, startVal1++) {
									sql.append("a.");
									if (((String) columnVal.get(startVal)).substring(0,
									3).equals("EXT")) {

										sql.append(colValue.get(startVal) + " EXT_"
										+ (String) colValue.get(startVal));
									} else {
										sql.append(colValue.get(startVal));
									}
									pkCnt++;
									if (startVal < (colValue.size() - 1)) {
										sql.append(",");
									}
								}
							}
							//		} // end of 730 else

							// Non Translated
							if (display.equals("N")) {

							sql.append(" from  " + trans_table_id + "  where ");
							// Added on Oct16
							if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
								sql
								.append("table_id='"
										+ masterName
										+ "' and APPLICATION_ID='"
										+ appl
										+ "' and  OUTBOUND_YN='"
										+ outbound_yn
										+ "' and	 (DESC2_VALUE IS  NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) /*)*/ AND UPPER(NVL("
										+ pkValue.get(0)
										+ ",'*')) like upper('"
										+ searchText + "')  AND UPPER(NVL("
										+ pkValue.get(1)
										+ ",'*')) like upper('" + searchpk2
										+ "') ");
							}
							if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
								sql.append("table_id='" + masterName
								+ "' and APPLICATION_ID='" + appl
								+ "'   and OUTBOUND_YN='" + outbound_yn
								+ "' ");

								if (columnVal.size() > 0) {
									sql
									.append(" and (desc2_value IS NULL AND ext_pk_id IS  NULL) /*) */ ");
								} else {
									sql.append(" and ext_pk_id IS  NULL /*)*/ ");
								}
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)
								+ ",'*')) like upper('" + searchText
								+ "') ");
								// end of code added 
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
								|| trans_table_id
								.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} // SKEY/DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append(" APPLICATION_ID='"
									+ appl
									+ "' and OUTBOUND_YN='"
									+ outbound_yn
									+ "'  and	 (DESC2_VALUE IS  NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL AND ext_pk3_value IS  NULL) ) AND UPPER(NVL("
									+ pkval.get(0)
									+ ",'*')) like upper('"
									+ searchText + "')  AND UPPER(NVL("
									+ pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "')  and  UPPER(NVL("
									+ pkval.get(2)
									+ ",'*')) like upper('" + searchpk3
									+ "')");
							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} else {

							sql.append("APPLICATION_ID='" + appl
							+ "'  )  AND UPPER(NVL(" + pkval.get(0)
							+ ",'*')) like upper('" + searchText
							+ "' )  and  UPPER(NVL(" + pkval.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "') and  UPPER(NVL(" + pkval.get(2)
							+ ",'*')) like upper('" + searchpk3 + "')");
							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))
							&& (!Searchbymod.equals(""))) {

								sql.append(" and module_id='" + Searchbymod
								+ "'");
							}
							if (masterName.equals("SM_FUNCTION_LEGEND")) {
								if (!SearchbyFunct.equals("")) {

							sql.append(" and function_id like upper('"
									+ SearchbyFunct + "%')  ");
								}
							}

							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} // OTH !(SKEY,DKEY)
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							if (columnVal.size() > 0) {
								sql.append("pk_value,ext_pk_id,");
							} else {
								sql.append("pk_value,ext_pk_id");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//     Cmmntd Oct16	sql.append("desc"+(startVal+1)+"_Value");

								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}

						}// end of SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql
							.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("pk1_value,pk2_value, pk3_value,ext_pk1_value,ext_pk2_value,ext_pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of APPL
						else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}
						}// !(SKEY,DKEY)

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' and table_id='" + masterName
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' ");
							if (columnVal.size() > 0) {
								sql
								.append("    and  	(desc2_value IS NULL AND ext_pk_id IS NULL) ");
							} else {
								sql.append("    and  ext_pk_id IS NULL ");
							}
							// end of code added 	 

								// modified on Dec 24 for Name Prefix - only for code
								// cmmntd on jan6th 	if(columnVal.size()>0){
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "') /*) */");
								//	}
								// end of code added 
		
						}// SKEY
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL) and APPLICATION_ID = '"
									+ appl + "' and table_id='"
									+ masterName
									+ "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

									sql.append("AND  UPPER(NVL("
										+ pkValue.get(0) + ",'*')) like upper('"
										+ searchText + "')  AND UPPER(NVL("
										+ pkValue.get(1) + ",'*')) like upper('"
										+ searchpk2 + "') /* )*/ ");
		
						} // DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NULL AND ext_pk1_value IS  NULL AND ext_pk2_value IS  NULL AND ext_pk3_value IS  NULL) and APPLICATION_ID = '"
									+ appl + "'  and OUTBOUND_YN='"
									+ outbound_yn + "'  ");

							sql
							.append("  AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));

							sql.append("  from " + masterName
							+ "  where  UPPER(NVL(" + pkval.get(0)
							+ ",'*')) like upper('" + searchText
							+ "')  AND UPPER(NVL(" + pkval.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "')  and  UPPER(NVL(" + pkval.get(2)
							+ ",'*')) like upper('" + searchpk3
							+ "') )");

						} // APPL
						else {

							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' ");
							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))) {
								if (!Searchbymod.equals("")) {

							sql.append(" and module_id='" + Searchbymod
									+ "'");
								}
								if (masterName.equals("SM_FUNCTION_LEGEND")) {
							if (!SearchbyFunct.equals("")) {
								sql
								.append(" and function_id like upper('"
										+ SearchbyFunct
										+ "%')  ");
							}
								}

								sql.append(" and  (");
								for (startVal = 0; startVal < pkValue.size(); startVal++) {
							sql.append(pkValue.get(startVal));
							if (startVal < pkValue.size() - 1) {
								sql.append(",");
							}
								}
								sql.append(" ) IN (SELECT ");

								for (startVal = 0; startVal < pkValue.size(); startVal++) {
							sql.append(pkValue.get(startVal));
							if (startVal < pkValue.size() - 1) {
								sql.append(",");
							}
								}
								sql.append(" from " + masterName
								+ "  where UPPER(NVL(" + pkval.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "'))");

							} else {
								sql.append(" AND " + pkval.get(0)
								+ " IN (SELECT " + pkval.get(0)
								+ "  from " + masterName
								+ "  where UPPER(NVL(" + pkval.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "'))  and  UPPER(NVL(" + pkval.get(1)
								+ ",'*')) like upper('" + searchpk2
								+ "') and  UPPER(NVL(" + pkval.get(2)
								+ ",'*')) like upper('" + searchpk3
								+ "')");
							}

						}

						} // end of Non-Translated

						//Translated

						else if (display.equals("T")) {

						sql.append(" from  " + trans_table_id + "  where ");

						// Added on Oct16
						if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("table_id='"
									+ masterName
									+ "' and APPLICATION_ID='"
									+ appl
									+ "'  and OUTBOUND_YN='"
									+ outbound_yn
									+ "'  and 		 (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL) /* )*/ AND UPPER(NVL("
									+ pkValue.get(0)
									+ ",'*')) like upper('"
									+ searchText + "')  AND UPPER(NVL("
									+ pkValue.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') ");
						}
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("table_id='" + masterName
							+ "' and APPLICATION_ID='" + appl
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "'  ");

							if (columnVal.size() > 0) {
								sql
								.append(" and (desc2_value IS NOT NULL OR ext_pk_id IS NOT NULL) /*)*/ ");
							} else {
								sql.append("AND ext_pk_id IS NOT NULL /*)*/  ");
							}
							sql.append(" AND UPPER(NVL(" + pkValue.get(0)
							+ ",'*')) like upper('" + searchText
							+ "') ");

						}

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
								|| trans_table_id
								.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} // SKEY/DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append(" APPLICATION_ID='"
									+ appl
									+ "'   and OUTBOUND_YN='"
									+ outbound_yn
									+ "'  and 		 (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS NOT NULL OR ext_pk2_value IS NOT NULL OR ext_pk3_value IS NOT NULL) ) AND UPPER(NVL("
									+ pkval.get(0)
									+ ",'*')) like upper('"
									+ searchText + "')  AND UPPER(NVL("
									+ pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "')  and  UPPER(NVL("
									+ pkval.get(2)
									+ ",'*')) like upper('" + searchpk3
									+ "') ");
							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");
						} else {

							sql.append("APPLICATION_ID='" + appl
							+ "'  )  AND UPPER(NVL(" + pkval.get(0)
							+ ",'*')) like upper('" + searchText
							+ "' )  and  UPPER(NVL(" + pkval.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "') and  UPPER(NVL(" + pkval.get(2)
							+ ",'*')) like upper('" + searchpk3 + "')");
							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))
							&& (!Searchbymod.equals(""))) {

								sql.append(" and module_id='" + Searchbymod
								+ "'");
							}
							if (masterName.equals("SM_FUNCTION_LEGEND")) {
								if (!SearchbyFunct.equals("")) {

							sql.append(" and function_id like upper('"
									+ SearchbyFunct + "%')  ");
								}
							}

							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} // OTH !(SKEY,DKEY)
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {

							if (columnVal.size() > 0) {
								sql.append("pk_value,ext_pk_id,");
							} else {
								sql.append("pk_value,ext_pk_id");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//	     	sql.append("desc"+(startVal+1)+"_Value");

								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}

						}// end of SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("pk1_value,pk2_value, pk3_value,ext_pk1_value,ext_pk2_value,ext_pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								// cmmntd on jan6th	     	sql.append("desc"+(startVal+1)+"_Value");
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of APPL
						else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append(columnVal.get(startVal));
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}
						}// !(SKEY,DKEY)

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' and table_id='" + masterName
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' ");

							if (columnVal.size() > 0) {
								sql
								.append("   AND (desc2_value IS NOT NULL OR ext_pk_id IS NOT NULL) ");
							} else {
								sql.append("    AND ext_pk_id IS NOT NULL ");
							}

								// modified on Dec 24 for Name Prefix - only for code
								// cmmntd on jan 6th	if(columnVal.size()>0){
								sql.append(" AND UPPER(NVL(" + pkValue.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "') /*) */");
								//		}
						}// SKEY
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS  NOT NULL OR ext_pk2_value IS  NOT NULL) and APPLICATION_ID = '"
									+ appl + "' and table_id='"
									+ masterName
									+ "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

								sql.append("AND  UPPER(NVL("
									+ pkValue.get(0) + ",'*')) like upper('"
									+ searchText + "')  AND UPPER(NVL("
									+ pkValue.get(1) + ",'*')) like upper('"
									+ searchpk2 + "') /*)*/");
						} // DKEY
						else if (trans_tbl_type.equals("APPL")) {

							sql
							.append("   FROM  "
									+ trans_table_id
									+ "  WHERE  (DESC2_VALUE IS NOT NULL OR ext_pk1_value IS  NOT NULL OR ext_pk2_value IS  NOT NULL OR ext_pk3_value IS  NOT NULL) and APPLICATION_ID = '"
									+ appl + "'  and OUTBOUND_YN='"
									+ outbound_yn + "' ");

							sql
							.append("  AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0)
									+ ","
									+ pkval.get(1)
									+ "," + pkval.get(2));

							sql.append("  from " + masterName
							+ "  where  UPPER(NVL(" + pkval.get(0)
							+ ",'*')) like upper('" + searchText
							+ "')  AND UPPER(NVL(" + pkval.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "') and  UPPER(NVL(" + pkval.get(2)
							+ ",'*')) like upper('" + searchpk3
							+ "') )");

						} // APPL
						else {

							// sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is not null and APPLICATION_ID = '"+appl+"' " ); 
							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' ");

								sql.append(" and  (");
								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" ) IN (SELECT ");

								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" from " + masterName
								+ "  where UPPER(NVL(" + pkval.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "')) ");

						//	} else {
								sql.append(" AND " + pkval.get(0)
								+ " IN (SELECT " + pkval.get(0)
								+ "  from " + masterName
								+ "  where UPPER(NVL(" + pkval.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "'))  and  UPPER(NVL(" + pkval.get(1)
								+ ",'*')) like upper('" + searchpk2
								+ "') and  UPPER(NVL(" + pkval.get(2)
								+ ",'*')) like upper('" + searchpk3
								+ "')");
							}

				//		}

						} // end of Translated

						else {

						sql.append(" from  " + trans_table_id + "  where ");
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")
								|| trans_table_id
								.equals("XH_OTH_APPL_DATA_DKEY")) {
							// code added on Dec 24 - Name Prefix
							sql.append("table_id='" + masterName
							+ "' and APPLICATION_ID='" + appl
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' /*) */ ");

							if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
								sql
								.append("AND UPPER(NVL(PK_VALUE,'*')) like upper('"
								+ searchText + "')");
							} else if (trans_table_id
							.equals("XH_OTH_APPL_DATA_DKEY")) {
								sql.append("AND UPPER(NVL(" + pkValue.get(0)
								+ ",'*')) like upper('" + searchText
								+ "')  AND UPPER(NVL(" + pkValue.get(1)
								+ ",'*')) like upper('" + searchpk2
								+ "') ");

							}

							sql.append("  union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO, ");

						} // SKEY/DKEY
						else {

							sql.append("APPLICATION_ID='" + appl
							+ "' )  AND UPPER(NVL(" + pkval.get(0)
							+ ",'*')) like upper('" + searchText
							+ "' ) and  UPPER(NVL(" + pkval.get(1)
							+ ",'*')) like upper('" + searchpk2
							+ "') and  UPPER(NVL(" + pkval.get(2)
							+ ",'*')) like upper('" + searchpk3 + "')");

							sql.append(" union	 SELECT  '" + appl
							+ "' APPLICATION_ID,2 SEQ_NO,");

						} // OTH !(SKEY,DKEY)
						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							/* Cmmnt Oct16
							 sql.append("pk_value,"); */
							// code added on dec 24th - Name Prefix
							if (columnVal.size() > 0) {
								sql.append("pk_value,ext_pk_id,");
							} else {
								sql.append("pk_value,ext_pk_id");
							}
							// end code added 
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}

						}// end of SKEY 
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {
							sql
							.append("pk1_value,pk2_value, ext_pk1_value,ext_pk2_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of DKEY
						else if (trans_tbl_type.equals("APPL")) {
							sql
							.append("pk1_value,pk2_value,pk3_value,ext_pk1_value,ext_pk2_value,ext_pk3_value,");
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								sql.append("desc" + (startVal + 2) + "_Value");
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}
							}
						}// end of APPL
						else {
							for (startVal = 0; startVal < pkval.size(); startVal++) {
								sql.append(pkval.get(startVal) + ",");
							}

							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								String NwCol = (String) columnVal.get(startVal);
								if (!NwCol.substring(0, 3).equals("EXT")) {
							NwCol = "EXT_" + NwCol;
							sql.append(NwCol);
								} else {
							sql.append(columnVal.get(startVal));
								}
								if (startVal < columnVal.size() - 1) {
							sql.append(",");
								}

							}
						}// !(SKEY,DKEY)

						if (trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")) {
							//         System.out.println("1644");
							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' and table_id='" + masterName
							+ "'  and OUTBOUND_YN='" + outbound_yn
							+ "' ");
							if ((masterName.equals("SM_FUNCTION")
							|| masterName.equals("SM_REPORT")
							|| masterName.equals("SM_FUNCTION_LEGEND")
							|| masterName.equals("SM_LABEL_ITEM")
							|| masterName.equals("SM_LIST_ITEM") || masterName
							.equals("SM_RECORD_TRANS"))) {
								if (!Searchbymod.equals("")) {

							sql.append(" and pk_value='" + Searchbymod
									+ "'");
								}
							} else {
								sql
								.append(" AND /* pk_value IN (SELECT "
								+ pkval.get(0)
								+ "  from "
								+ masterName
								+ "  where */ UPPER(NVL(PK_VALUE,'*')) LIKE upper('"
								+ searchText + "') /*) */");
							}

						}// SKEY
						else if (trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")) {

							sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl
								+ "' and table_id='" + masterName
								+ "'  and OUTBOUND_YN='" + outbound_yn
								+ "' ");

							sql.append("AND UPPER(NVL("
								+ pkValue.get(0) + ",'*')) like upper('"
								+ searchText + "')  AND UPPER(NVL("
								+ pkValue.get(1) + ",'*')) like upper('"
								+ searchpk2 + "') /*)*/ ");

						} // DKEY
						else if (trans_tbl_type.equals("APPL")) {

							sql.append("   FROM  " + trans_table_id
								+ "  WHERE  APPLICATION_ID = '" + appl
								+ "'  and OUTBOUND_YN='" + outbound_yn
								+ "'  ");

							sql
							.append("  AND (pk1_value,pk2_value,pk3_value) IN (SELECT "
									+ pkval.get(0) + ",");

							sql.append(pkval.get(1) + "," + pkval.get(2)
									+ "  from " + masterName
									+ "  where  UPPER(NVL(" + pkval.get(0)
									+ ",'*')) like upper('" + searchText
									+ "')  AND UPPER(NVL(" + pkval.get(1)
									+ ",'*')) like upper('" + searchpk2
									+ "') AND UPPER(NVL(" + pkval.get(2)
									+ ",'*')) like upper('" + searchpk3
									+ "') )");
						} // APPL
						else {

							sql.append("   FROM  " + trans_table_id
							+ "  WHERE  APPLICATION_ID = '" + appl
							+ "' ");

							sql.append(" and  (");
								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" ) IN (SELECT ");

								for (startVal = 0; startVal < pkValue.size(); startVal++) {
									sql.append(pkValue.get(startVal));
									if (startVal < pkValue.size() - 1) {
										sql.append(",");
									}
								}
								sql.append(" from " + masterName
								+ "  where UPPER(NVL(" + pkval.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "'))");

				//			} else {
								sql.append(" AND " + pkval.get(0)
								+ " IN (SELECT " + pkval.get(0)
								+ "  from " + masterName
								+ "  where UPPER(NVL(" + pkval.get(0)
								+ ",'*')) LIKE upper('" + searchText
								+ "'))  and  UPPER(NVL(" + pkval.get(1)
								+ ",'*')) like upper('" + searchpk2
								+ "') and  UPPER(NVL(" + pkval.get(2)
								+ ",'*')) like upper('" + searchpk3
								+ "')");
				//			}

						}

							} // end of ALL

							// added the condition on Mar 12th
							/*    if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){	 */
							sql.append(" order by  ");
							for (startVal = 0; startVal < pkval.size(); startVal++) {
						sql.append(pkval.get(startVal));
						if (startVal < pkval.size() - 1)
							sql.append(",");
							}
							//	   sql.append("PK_VALUE");
							sql.append(",seq_no");
							/*	 }
							 else{
							 sql.append(" order by  ");
							 sql.append("seq_no");	
							 } */

						//	System.out.println("XHTranslationManagerResultN.jsp 1701 sql : "+ sql.toString());

							pstmt = con.prepareStatement(sql.toString(),
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
							rs = pstmt.executeQuery();

							String temppk1 = "";
							int l = 0;
							int m = 0;
							int i = 0, j = 0;
							int colDispCount = 0;
							int pkDataCnt = pkval.size();

							if (start != 1)
						for (m = 1; m < start; l++, m++) {
							rs.next();
						}
							String pkData[] = new String[pkval.size()];
							String pkData1[] = new String[pkval.size()];

							for (startVal = 0; startVal < pkval.size(); startVal++) {
						pkData1[i] = "";
							}
							boolean maxrecallow = false;

							if (!table_or_form.equals("F")) {
						maxrecallow = l < end;

							} else {
						maxrecallow = true;
							}
							//	 while(rs.next() && maxrecallow)	 
							while (rs.next() && maxrecallow) {

						lang = rs.getString(1);
						//	System.out.println("lang @ 1263 : "+lang);

						for (startVal = 0; startVal < pkval.size(); startVal++) {
							//pkData[startVal]=rs.getString((String)pkval.get(startVal));
							pkData[startVal] = rs.getString((String) pkval
							.get(startVal));
						}

						if (i % 2 == 0)
							classValue = "BACKGROUND-COLOR:#F0F0F2";
						else
							classValue = "BACKGROUND-COLOR:#E2E3F0;";
				
            _bw.write(_wl_block19Bytes, _wl_block19);

								if (!table_or_form.equals("F")) {
								int pkCnt = 1;
								for (startVal = 0; startVal < pkval.size(); startVal++) {
									String keyName = "";
									if (lang.equals("en")) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkData[startVal]));
            _bw.write(_wl_block23Bytes, _wl_block23);

								} else {
								if (trans_table_id
										.equals("XH_OTH_APPL_DATA_DKEY")) {
									keyName = "ext_pk" + pkCnt + "_value";
									//		 System.out.println("keyName :"+keyName);
								} else if (trans_tbl_type.equals("APPL")) {
									keyName = "ext_pk" + pkCnt + "_value";
									//		 System.out.println("keyName :"+keyName);
								} else if (trans_table_id
										.equals("XH_OTH_APPL_DATA_SKEY")) {
									keyName = "ext_pk_id";
									//		 System.out.println("keyName :"+keyName);
								}
								//		 System.out.println("pkLen.get(startVal) :"+pkLen.get(startVal));
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(startVal));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(startVal));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs
															.getString((String) keyName) == null ? ""
													: rs
															.getString((String) keyName)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pkLen.get(startVal)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(startVal));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(startVal));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pkLen.get(startVal)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs
															.getString((String) pkval
																	.get(startVal)) == null ? ""
													: rs
															.getString((String) pkval
																	.get(startVal))));
            _bw.write(_wl_block33Bytes, _wl_block33);

									pkCnt++;
									}
								}
								for (startVal = 0; startVal < pkval.size(); startVal++) {
									pkData1[startVal] = pkData[startVal];
								}
							} // end of !Form -  Table
					
            _bw.write(_wl_block16Bytes, _wl_block16);

							int colCount1 = 0;
							int engColCount = 0;

							if (table_or_form.equals("F")) {

								/*		if(display.equals("N")){
								 if(rs.getString((String)columnVal.get(colDispCount))==null){
								 */
								for (startVal = 0; startVal < pkval.size(); startVal++) {
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(colCount));
            out.print( String.valueOf(startVal));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(colCount));
            out.print( String.valueOf(startVal));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pkData[startVal]));
            _bw.write(_wl_block37Bytes, _wl_block37);

					}
					
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(columnPrompt.get(colDispCount)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((rs.getString((String) colValue
											.get(colDispCount)) == null) ? ""
									: (rs.getString((String) colValue
											.get(colDispCount)))));
            _bw.write(_wl_block40Bytes, _wl_block40);

            _bw.write(_wl_block41Bytes, _wl_block41);

								engColCount++;
								rs.next();
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(colDispCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(colDispCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(columnLen.get(colDispCount)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rs.getString((String) columnVal
											.get(colDispCount)) == null ? ""
									: rs.getString((String) columnVal
											.get(colDispCount))));
            _bw.write(_wl_block46Bytes, _wl_block46);

							colDispCount = colDispCount + 1;
							//colCount++;
							colCount = 1;
						} // end of Form
						else {

							if (colCount == 0) {
								//		System.out.println("1907");
							}
							for (startVal = 0; startVal < columnVal.size(); startVal++) {
								//
				
            _bw.write(_wl_block47Bytes, _wl_block47);

							if (columnVal.size() > 0) {
							if (lang.equals("en")) {
				
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rs
																.getString((String) columnVal
																		.get(startVal)) == null ? ""
														: rs
																.getString((String) columnVal
																		.get(startVal))));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(engColCount));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(engColCount));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf("engLang"
												+ (engColCount) + (colCount)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rs
																.getString((String) columnVal
																		.get(startVal)) == null ? ""
														: rs
																.getString((String) columnVal
																		.get(startVal))));
            _bw.write(_wl_block54Bytes, _wl_block54);

							engColCount++;
							} else {
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(colCount1++));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(colCount1++));
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(columnLen.get(startVal)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rs
																.getString((String) columnVal
																		.get(startVal)) == null ? ""
														: rs
																.getString((String) columnVal
																		.get(startVal))));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}
								}// end of columnVal chk
							} // end of for
				
            _bw.write(_wl_block61Bytes, _wl_block61);

							temppk1 = pk1;
							temppk2 = pk2;
						} // end of else Form
						if (!lang.equals("en")) {
							//		System.out.println(" 1379 !lang.equals('en') ");

							for (startVal = 0; startVal < pkval.size(); startVal++) {
				
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(colCount));
            out.print( String.valueOf(startVal));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(colCount));
            out.print( String.valueOf(startVal));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(pkData[startVal]));
            _bw.write(_wl_block64Bytes, _wl_block64);

							}
							i++;
							colCount++;
						} else {
						}
						j++;
						l++;

						if (!table_or_form.equals("F")) {
							maxrecallow = l < end;

						}
						// modified on Dec 24 - Name Prefix
						if (columnPrompt.size() > 0) {
							if (colDispCount >= columnPrompt.size()) {
								//		System.out.println("1960");
								break;
							}
						}
						// end of code added 
						if (table_or_form.equals("F")) {
							rs.beforeFirst();

						}
							} // end of while 

							if (rs != null)
						rs.close();
							if (pstmt != null)
						pstmt.close();
				
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(start));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(end));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(masterName));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(language));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(appl));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(display));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Searchbymod));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(SearchbyFunct));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(start_ends_contains));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(searchText1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(master_table_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(trans_table_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(colCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(pkDataCnt));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(table_or_form));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(columnVal.size()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(outbound_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(searchpk2Val));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(searchpk3Val));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(sql.toString()));
            _bw.write(_wl_block87Bytes, _wl_block87);

		} // end of max rec !=0
		pkval.clear();
		pkValue.clear();
		pkLen.clear();
		pkPrompt.clear();
		columnPrompt.clear();
		columnVal.clear();
		colValue.clear();
		columnLen.clear();
	} catch (Exception e) {
		System.out.println("(XHTranslationManagerResultNExternal.jsp Error)" + e);
		e.printStackTrace();
	} finally {

		ConnectionManager.returnConnection(con, request);
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
}
