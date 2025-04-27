package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __caoptionredefine extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAOptionRedefine.jsp", 1731050935176L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t\t\n\t\t\n\t\t\n\t\t<script src=\"../../eCA/js/CAOptionRedefine.js\" language=\"javascript\"></script>\n\t\t\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<!--//IN035914 Starts  --> \n\t\t<script>\n\t\tfunction resetCurrentField(obj,cnt){\n\t\t\tdocument.getElementById(\"shortDesc\"+cnt).style.backgroundColor=\'#FFFFFF\';\n\t\t\tdocument.getElementById(\"shortDesc\"+cnt).style.color=\'#000000\';\n\t\t\tdocument.getElementById(\"shortDesc\"+cnt).style.fontWeight=\'\';\n\t\t\t\n\t\t\tdocument.getElementById(\"isBoldEnabled\"+cnt).style.fontWeight=\'\';\n\t\t\tdocument.getElementById(\"isBoldEnabled\"+cnt).value=\'\';\n\t\t\t\n\t\t\t//document.getElementById(\"bold\"+cnt).value=\'\';\n\t\t\tdocument.getElementById(\"bold\"+cnt).style.fontWeight = \'\';\n\t\t\t\n\t\t\tdocument.getElementById(\"routebgCol\"+cnt).value=\'#FFFFFF\';\n\t\t\tdocument.getElementById(\"routebgCol\"+cnt).style.backgroundColor=\'#FFFFFF\';\n\t\t\t\n\t\t\tdocument.getElementById(\"routeColor\"+cnt).style.color=\'#FFFFFF\';\n\t\t\tdocument.getElementById(\"routeColor\"+cnt).value=\'#000000\';\t\n\t\t\tdocument.getElementById(\"routeColor\"+cnt).style.backgroundColor=\'#000000\';\n\t\t\t\n\t\t\tdocument.getElementById(\"isColorPalletteEnabled\"+cnt).value=\"||\";\n\t\t\n\t\t}\n\t\tfunction boldTrigger(obj,cnt){\n\t\t\t\n\t\t\tif(obj.style.fontWeight==\"\"){\n\t\t\t\tdocument.getElementById(\"shortDesc\"+cnt).style.fontWeight=\'bold\';\n\t\t\t\tobj.style.fontWeight = \'bold\';\n\t\t\t\tdocument.getElementById(\"isBoldEnabled\"+cnt).value=\'bold\';\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"shortDesc\"+cnt).style.fontWeight=\'\';\n\t\t\t\tobj.style.fontWeight = \'\';\n\t\t\t\tdocument.getElementById(\"isBoldEnabled\"+cnt).value=\'\';\n\t\t\t}\n\t\t}\n\t\t\n\t\t</script>\n\t<!-- \t\n\t <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../ePH/js/prototype.js\"></SCRIPT> \n     <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/colorPicker.js\"></script>\n     <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/yahoo.color.js\"></script>\n     <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/scriptaculous.js\"></SCRIPT>-->\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script> \n   <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/prototype1.js\"></SCRIPT>\n    <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/colorPicker.js\"></script>\n     <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/yahoo.color.js\"></script>\n     <SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\" SRC=\"../../eCA/js/scriptaculous.js\"></SCRIPT> \n \n     <style type=\"text/css\">\n\t\t #colorpicker { position: absolute; width: 145px; height: 145px; overflow: hidden; background: #F9F9F9;\n\t\t\t\t\t\tborder: 2px #C0C0C0 outset;z-index: 1000;}\n\t\t #colorpicker-hue-container {position: absolute;top: 4px; left: 120px; width: 18px; height: 110px; }\n\t\t #colorpicker-hue-bg-img { width: 100%;height: 100%;}\n         #colorpicker-hue-slider { position: absolute;top: 0;left: 0; width: 100%;height: 100%;}\n         #colorpicker-hue-thumb { position: absolute;top: 0;left: 0;width: 18px;height: 18px;z-index: 1009; cursor: default;}\n         #colorpicker-bar {text-align: right;padding-right: 10px;}\n         #colorpicker-close {cursor: pointer;color: blue;font-size: 10px;font-family: Tahoma, Helvetica, Sans-Serif;\n\t\t\t\t\t\t\t  font-weight: bold;}\n\t\t #colorpicker-div {position: absolute; top: 8px;left: 8px; width: 100px;height: 100px; border: 1px solid #666;}\n\t\t #colorpicker-bg,\n\t\t #colorpicker-bg-overlay {position: absolute;top: 0;left: 0;width: 100%;height: 100%;z-index: 1001;overflow: hidden;}\n\t\t #colorpicker-selector {position: absolute;top: 0px;left: 0px;width: 11px;height: 11px; z-index: 1009;margin-top: -6px;\n\t\t\t\t\t\t\t\t margin-left: -6px;cursor: default;}\n\t\t #colorpicker-selector img {position: absolute;left: 0;top: 0;}\n         #colorpicker-footer { position: absolute; top: 114px;left: 10px; width: 127px;}\n\t\t #colorpicker-value { float: left;}\n\t\t #colorpicker-value,\n\t\t #colorpicker-value-input {font-size: 9px !important;font-family: Helvetica, Verdana, Sans-Serif;height: 15px;background: #FFFFFF;}\n         #colorpicker-value-input {width: 40px;}\n\t\t #colorpicker-okbutton {float: right;padding: 0 10px;background: #3366FF;font-size: 10px;font-family: Tahoma, Helvetica, \t\t\t\t\t\t\tSans-Serif; border: 1px solid #666666;color: #ffffff;}\n\t </style>\n\t\t<!--//IN035914 Ends  --> \n\t</head>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<script>\n\tif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' <= 0){\n\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\");\t\n\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t}\n</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body  OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n<BR>\n<!--<form name=\"\" id=\"\" > IN035914-->\n<form name=\"caOptionRedefine\" id=\"caOptionRedefine\" >  <!--IN035914 -->\n<table border=0 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<td class=\'white\' width=\'88%\'></td> \n\t\t<td  align=\'right\' >\n\t<A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Previous\");\' text-decoration=\'none\' > ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </A></td>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t<td class=\'white\' width=\'88%\'></td> \n\t<td align=\'right\'>\n\t<A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Next\");\' text-decoration=\'none\' > ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </A></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t</tr>\n</table>\n<!--IN037960<table border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=\'center\' width=\'100%\'>\n\t<tr height=\'18\'><td class=\'COLUMNHEADERCENTER\' width=\'50%\' colspan=\'2\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'50%\' colspan=\'2\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n</table>-->\n<table class=\'grid\' width=\'100%\' align=\'center\' >\n<tr height=\'18\'>\n\t\t<!-- IN037960 Starts-->\n\t\t\n\t\t\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'50%\' colspan=\'2\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'50%\' colspan=\'6\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t</tr>\n\t\t<tr height=\'18\'>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'3%\' >Bold</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'3%\' >FC</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'3%\' >BG</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'6%\' >Default</td>\n\t\t<td class=\'COLUMNHEADERCENTER\'  >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<!-- IN037960 Ends-->\n</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<tr id=\'\'>\n\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\'25%\' nowrap>\n\t\t<!--<input type=\"text\" name=\'usd";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'usd";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" size=\"20\" maxlength=\"30\" onKeyPress=\'return CheckForSpeChar(event);\'><input type=\'hidden\' name=\'opt_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'opt_id";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">-->\n\t\t<!-- IN035914 Starts-->\n\t\t<!-- <input id =\'shortDesc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' type=\"text\" name=\'usd";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\"20\" onpaste=\'return CheckForSpecCharsWithCopyPaste(event)\' maxlength=\"30\" onKeyPress=\'return CheckForSpeChar(event)\';><input type=\'hidden\' name=\'opt_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">IN037960-->\n<input id =\'shortDesc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' style=\"width: 50%;font-weight:;\" type=\"text\" name=\'usd";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" size=\"20\" onpaste=\'return CheckForSpecCharsWithCopyPaste(event)\' maxlength=\"30\" onKeyPress=\"return CheckForSpeChar(event)\">\n<input type=\'hidden\' name=\'opt_id";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' ><!--IN037960-->\n\t\t <input type=\'hidden\' name=\'uDescLegend";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'uDescLegend";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' value=\"\">\n\t\t <input type=\'hidden\' name=\'isBoldEnabled";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'isBoldEnabled";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=\"\">\n\t\t <input type=\'hidden\' name=\'isColorPalletteEnabled";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'isColorPalletteEnabled";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\"\">\n\t\t <td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' width=\'5%\' nowrap><!--IN037960-->\n\t\t <input title=\"Bold\" type=\"button\" id=\'bold";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' name=\'bold\'  value=\"B\" size=\"5\" maxlength=\"5\"  onclick=\'boldTrigger(this,";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =");\'>\n\t\t  \n\t\t <input type=\"hidden\" name=\"route_color";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"route_color";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" value=\"\">\n\t\t  <td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' width=\'5%\' nowrap> <!--IN037960-->\n\t\t <input title=\"Font Color\" type=\"text\" class=\"routecolor\" style=\"width: 20px;height: 20px;\" name=\"routeColor";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"routeColor";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  id=\"routeColor";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" onpaste=\'return CheckForSpeCharInColorPallete(event)\' onKeyPress=\'return CheckForSpeCharInColorPallete(event)\';> \n\t      <script type=\"text/javascript\" LANGUAGE=\"JavaScript\" >\n\t     \t\n\t\t\tvar formbgcolor= \"\"; \n\t\t\tformbgcolor = document.getElementById(\'routeColor";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\').value;\n\t   \t\n\t\t\tdocument.getElementById(\'shortDesc";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\').style.color=formbgcolor;\n\t\t\tnew Control.ColorPicker(\"routeColor";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\", { \"swatch\" : \"routeColor";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" });\n\t      </script>\n\t      <td class=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' nowrap> <!--IN037960-->\n\t\t  <input title=\"BackGround Color\" type=\"text\" class=\"routecolor\" style=\"width: 20px;height: 20px;\" name=\"routebgCol";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"routebgCol";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"  id=\"routebgCol";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" onpaste=\'return CheckForSpeCharInColorPallete(event)\' onKeyPress=\"return CheckForSpeCharInColorPallete(event)\";> \n\t      <script type=\"text/javascript\" LANGUAGE=\"JavaScript\" >\n\t      \n\t      var\tpercent=50;\n\t\t\tvar bckColor=\"\";\n\t\t\tvar combinedcolor=\"\";\n\t\t\tvar userDefColor = \"\";\n\t\t\tvar shtDesc = \"\";\n\t\t\tvar formcolor= \"\"; \n\t   \t\n\t      shtDesc = document.getElementById(\"shortDesc";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\").value;\n\t\t  document.getElementById(\'shortDesc";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\').style.fontWeight=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\';\n\t\t  document.getElementById(\'shortDesc";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\').style.backgroundColor=\'#";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\').style.color = \'rgb(208, 20, 20)\';\n\t\t  document.getElementById(\'routebgCol";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\').value =\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\';\n\t\t  document.getElementById(\'uDescLegend";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\').value=formcolor;\n\t\t  \n\t      new Control.ColorPicker(\"routebgCol";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\", { \"swatch\" : \"routebgCol";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" });\n\t      \n\t      </script>\n      <script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t \n\t    <script>\n\t      var textColor = \"\";\n\t      var bgColor = \"\";\n\t      bgColor = document.getElementById(\'routebgCol";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\').value;\n\t      textColor = document.getElementById(\'routeColor";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\').value;\n\t      if(textColor==\"\") textColor =\"0\";\n\t  \t  if(bgColor==\"\") bgColor =\"0\";\n\t      document.getElementById(\'isColorPalletteEnabled";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\').value = textColor+\"||\"+bgColor;\n\t\t  document.getElementById(\"isBoldEnabled";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\").value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\';\n\t    </script>\n\t\t <td class=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' width=\'6%\' nowrap><!--IN037960-->\n\t\t<input title=\"Default\" type=\"button\" name=\'reset\' id=\'reset\'  value=\"D\" size=\"2\" maxlength=\"5\" onclick=\'resetCurrentField(this,";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =");\'>\n\t\t<!-- IN035914 Ends-->\n\t\t</td>\n\t\t<!--<td class=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' width=\'25%\' align=\'left\'> [IN037960]-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' width=\'10%\' align=\'left\'><!--[IN037960]-->\n\t\t<!--<input type=\"text\" name=\'uld";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'uld";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" size=\"28\" maxlength=\"40\" onKeyPress=\'return CheckForSpeChar(event);\'>IN038002-->\n\t\t<input type=\"text\" name=\'uld";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" size=\"28\" maxlength=\"40\" onpaste=\'return CheckForSpecCharsWithCopyPaste(event)\' onKeyPress=\'return CheckForSpeChar(event);\'><!--IN038002-->\n\t\t\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n</table>\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\n<input type=\'hidden\' name=\'u_shortdesc\' id=\'u_shortdesc\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\'hidden\' name=\'u_longdesc\' id=\'u_longdesc\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\'hidden\' name=\'dispMode\' id=\'dispMode\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n</form>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );
	
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

int row_count=0;

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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035914		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be 												changed and more appealing. Keeping the display of information more clear 												 and visible.   								 
20/02/2013		IN038002		Nijitha			CRF-CA-CHL-CRF-0006/03-Redefine CA Option-> System is allowing  user to copy-paste the special characters
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet SubSecRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("SubSecRecordSet","webbeans.eCommon.RecordSet",session);

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		HashMap ht=null;
		HashMap  hm= null;
	String readOnly = ""; //IN035914
		StringBuffer sql= new StringBuffer();
		String classValue="";
		String optid="";
		String sdesc="";
		String ldesc="";
		String user_sdesc="";
		String user_ldesc="";
		//CHL_CRF_006-IN035914 Starts	
		String userDefShtDesc = "";
		String boldTrigger ="";
		String colorPallette ="";
		String bgcolor = "";
		String isBoldEna ="";
		String isColorPalletteEna="";
		String colorlegend = "";
		String legend = "";
		String  styles ="";
		String boldTriggerst="";
		String	boldTriggeret="";
		String colorPallete="";
		String bgColorPallete="";
		//CHL_CRF_006-IN035914 Ends
		//Modified by Archana @10-12-2008
	    String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
        int pageCnt = Integer.parseInt(MstQryPageCnt);
		
		int row_disp=pageCnt;
		int start = 0 ;
		int end = 0 ;
		int fm_disp=0, to_disp=0;
		String from="",to="";
		String dispMode="",update_sdesc="",update_ldesc="";
		
		dispMode=request.getParameter("dispMode");
		from=request.getParameter( "from" ) ;
		to=request.getParameter( "to" ) ;
			if (from == null ){ 
				start = 1 ;
			}
			else{
				start = Integer.parseInt(from) ;
			}
			if( to == null ){
				end = pageCnt ;
			}
			else{
				end = Integer.parseInt(to);
			}
			if(dispMode == null || dispMode.equals("null")) dispMode="";
try
{
  
  if(dispMode.equals(""))
  {
	  SubSecRecordSet.clearAll();
	  con=ConnectionManager.getConnection();
	  if(sql.length() > 0) sql.delete(0,sql.length());
	  sql.append("SELECT OPTION_ID,LPAD(' ',LEVEL*2,' ')||SHORT_DESC");  sql.append(" SHORT_DESC,LONG_DESC,USER_DEF_SHORT_DESC,");
			//IN035914 Starts 

			//  sql.append(" USER_DEF_LONG_DESC FROM CA_OPTION START WITH "); sql.append(" HEADER_OPTION_ID IS NULL CONNECT BY PRIOR "); sql.append("OPTION_ID=HEADER_OPTION_ID ORDER BY ORDER_SEQ_NO ");

			sql.append(" USER_DEF_LONG_DESC,USER_DEF_COLOR_CODE,USER_DEF_SHORT_DESC_LEGEND FROM CA_OPTION START WITH ");
			sql.append(" HEADER_OPTION_ID IS NULL CONNECT BY PRIOR ");
			sql.append("OPTION_ID=HEADER_OPTION_ID ORDER BY ORDER_SEQ_NO ");
		   //IN035914 Ends
	  pst=con.prepareStatement(sql.toString());
	  rs=pst.executeQuery();
 	
		while(rs.next())
		{
			optid=rs.getString(1);
			sdesc=rs.getString(2);
			ldesc=rs.getString(3);
			user_sdesc=rs.getString(4);
			user_ldesc=rs.getString(5);
				userDefShtDesc = rs
						.getString("USER_DEF_COLOR_CODE"); //IN035914
			colorlegend = rs
						.getString("USER_DEF_SHORT_DESC_LEGEND"); //IN035914	
			if(user_sdesc == null || user_sdesc.equals("null"))
					user_sdesc="";
			if(user_ldesc == null || user_ldesc.equals("null"))
					user_ldesc="";
			
			ht=new HashMap();
			ht.put("OPTION_ID",optid);
			ht.put("SHORT_DESC",sdesc);
			ht.put("LONG_DESC",ldesc);
			ht.put("USER_DEF_SHORT_DESC",user_sdesc);
			ht.put("USER_DEF_LONG_DESC",user_ldesc);
				ht.put("USER_DEF_COLOR_CODE", userDefShtDesc);  //IN035914
				 ht.put("USER_DEF_SHORT_DESC_LEGEND", colorlegend);//IN035914
			SubSecRecordSet.putObject(ht);
		}
		row_count=SubSecRecordSet.getSize();//IN035914
		//row_count=pageCnt;//IN035914
	
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
   
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
	
			from = ""+(start - 1);
			to   = ""+(end - 1);
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block11Bytes, _wl_block11);

  }//if disp_mode
else
{
		
		int from_val=0;
		int to_val=0;
		
		from_val=Integer.parseInt(from);
		to_val=Integer.parseInt(to);
		
		if(dispMode.equals("Next"))
		{
     		dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			
		}
		else if(dispMode.equals("Previous"))
		{
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		
		for(int j=from_val; j<=to_val; j++)
		{
			 update_sdesc = request.getParameter("usd"+j);
			 update_ldesc=request.getParameter("uld"+j);
			 
			 //CHL_CRF_006-IN035914 Starts
			 isColorPalletteEna=request.getParameter("isColorPalletteEnabled"+j);
			 isBoldEna=request.getParameter("isBoldEnabled"+j);
			 
			 if("".equals(isBoldEna))
			 {	
				isBoldEna = "0";
			 }
			 else
			 {
				boldTriggerst="<b>";
				boldTriggeret="</b>";
			 }
			 if("||".equals(isColorPalletteEna ))
			 {
			 isColorPalletteEna = "0"+"||"+"0";
			 }
			 
			 legend = isBoldEna+"||"+isColorPalletteEna;
			 StringTokenizer bgColorAndFontColor	=	new StringTokenizer(isColorPalletteEna,"||");
			 if(null!=bgColorAndFontColor)
			 {
			 colorPallete				=	bgColorAndFontColor.nextToken();
			 bgColorPallete				=	bgColorAndFontColor.nextToken();
			 }
			 
			 styles = "<font style=background-color:#"+bgColorPallete+" color=#"+colorPallete+">"+boldTriggerst+""+update_sdesc+""+boldTriggeret+"</font>";
			 //CHL_CRF_006-IN035914 Ends
			 if(update_sdesc == null || update_sdesc.equals("null") || 			update_sdesc.equals(""))update_sdesc = "";
			 if(update_ldesc == null || update_ldesc.equals("null") || 			update_ldesc.equals(""))update_ldesc = "";
			 hm = (java.util.HashMap)SubSecRecordSet.getObject(j);
			 hm.put("USER_DEF_SHORT_DESC", update_sdesc);
			 hm.put("USER_DEF_LONG_DESC", update_ldesc);
			 hm.put("USER_DEF_COLOR_CODE", legend);//IN035914
			 hm.put("USER_DEF_SHORT_DESC_LEGEND", styles);//IN035914
			 SubSecRecordSet.setObject(j,hm);
			 boldTriggerst="";
			 boldTriggeret="";
		}


		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);
  
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
		
	}//else
	
            _bw.write(_wl_block12Bytes, _wl_block12);

	if ( (!(start <= 1)) && (start < row_count)){


            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);


	}//if
	//else if ( !( (start+row_disp) >= row_count ) ){//IN035914
	if ( !( (start+row_disp) >= row_count ) ){//IN035914

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	}//if

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

StringTokenizer split_value	= null;			//IN035914

	try
	{
	for(int i=fm_disp; i<=to_disp; i++)
	{

			classValue="gridData";//( (i%2)==0 )? "QRYODD" : "QRYEVEN";
			ht=(java.util.HashMap)SubSecRecordSet.getObject(i);
            optid=(String)ht.get("OPTION_ID");
            sdesc=(String)ht.get("SHORT_DESC");
			ldesc=(String)ht.get("LONG_DESC");
            user_sdesc=(String)ht.get("USER_DEF_SHORT_DESC");
		    user_ldesc=(String)ht.get("USER_DEF_LONG_DESC"); 
			//IN035914 Starts

				userDefShtDesc = (String) ht.get("USER_DEF_COLOR_CODE");
				if("||||".equals(userDefShtDesc)){
					userDefShtDesc = "0"+"||"+"0"+"||"+"0";
				}
				
				System.out.println("CAOptionRedefine.jsp:Line:293:userDefShtDesc"+userDefShtDesc);
				if(null!=userDefShtDesc && !"null".equals(userDefShtDesc) && !"".equals(userDefShtDesc)){
					
				split_value	=	new StringTokenizer(userDefShtDesc,"||");
				
				boldTrigger				=	split_value.nextToken();
				colorPallette			=	split_value.nextToken();
					bgcolor = split_value.nextToken();
				}
				else {
					userDefShtDesc = "";
				}
				if (boldTrigger.equals("0")) {
					boldTrigger = "";
				}

				if (colorPallette.equals("0") || colorPallette.equals("") ){
					colorPallette = "#000000";
				}
				
				if (bgcolor.equals("0") || bgcolor.equals("")) {
					bgcolor = "#FFFFFF";
				}
//IN035914 Ends

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(((sdesc.equals(""))?"&nbsp;":sdesc)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(((ldesc.equals(""))?"&nbsp;":ldesc)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((user_sdesc.equals(""))?"":user_sdesc)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(optid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((user_sdesc.equals("")) ? "" : user_sdesc)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(optid));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((user_sdesc.equals("")) ? "" : user_sdesc)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(optid));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(colorPallette));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(boldTrigger));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(boldTrigger));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((user_ldesc.equals(""))?"":user_ldesc)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((user_ldesc.equals(""))?"":user_ldesc)));
            _bw.write(_wl_block88Bytes, _wl_block88);
		
	}//for
	
}//try

catch(Exception ex){

	//out.println("Exception="+ex.toString());//COMMON-ICN-0181
	ex.printStackTrace();//COMMON-ICN-0181
}

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(from));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(to));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(user_sdesc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(user_sdesc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block97Bytes, _wl_block97);
	
	if(rs!=null) rs.close();
	if(pst != null) pst.close();
	
}//try
catch(Exception eg)
{
		//out.println("Exception="+eg.toString());//common-icn-0181
		eg.printStackTrace();//COMMON-ICN-0181
}
finally
{
		
		if (con != null)ConnectionManager.returnConnection(con,request);
		 putObjectInBean("SubSecRecordSet", SubSecRecordSet,session);
}

            _bw.write(_wl_block98Bytes, _wl_block98);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChangeDescription.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SystemDefined.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UserDefined.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SystemDefined.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UserDefined.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
}
