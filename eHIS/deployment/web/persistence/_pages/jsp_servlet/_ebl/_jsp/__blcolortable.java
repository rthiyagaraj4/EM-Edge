package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcolortable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLColorTable.jsp", 1732903136810L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title> \n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\'></link>\n <style type=\"text/css\">\ntd\n{\nheight: 10px;\n\twidth: 10px;\n}\n</style>\n\n<script>\n\t/*function getFontColor(object)\n\t{\n\t\t//window.returnValue = object.style.backgroundColor;\n\t\tlet dialogBody = parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = object.style.backgroundColor;\n\t\talert(\"returnValue :\" +object.style.backgroundColor);\n\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();\n\t}*/\n\tfunction getFontColor(object)\n\t{\n\t\t//alert(\"object.style.backgroundColor:\"+object.style.backgroundColor);\n\t\t//window.returnValue = object.style.backgroundColor;\n\t\t    const rgb = object.style.backgroundColor;\n \n    // Convert RGB to HEX\n    const rgbValues = rgb.match(/\\d+/g);\n\t\t const hex = rgbValues ? \'#\' + rgbValues.map(value => {\n        const hexValue = parseInt(value).toString(16);\n        return hexValue.length === 1 ? \'0\' + hexValue : hexValue; // Ensure two digits\n    }).join(\'\') : rgb; // Fallback to original value if parsing fails\n \n    //alert(\"Hex color: \" + hex);\n\t\tlet dialogBody = parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = hex;\n\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();\n\t}\n\t</script>\n</head>\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<table BGCOLOR=\"#ffffff\" BORDER=\"0\" CELLSPACING=2 CELLPADDING=1 WIDTH=\'250px\' HEIGHT=\'250px\' border=0 margin-bottom=\"25px\";>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FAEBD7\" ALIGN=CENTER width=\'auto\'></TD> \n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00FFFF\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#7FFFD4\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F0FFFF\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F5F5DC\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFE4C4\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00CED1\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFEBCD\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#0000FF\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#8A2BE2\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DEB887\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#5F9EA0\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#7FFF00\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#D2691E\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t \t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF7F50\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#9ACD32\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFF8DC\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DC143C\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t \t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00FFFF\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#008B8B\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#008080\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#B8860B\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFFF00\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#A9A9A9\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#BDB76B\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#556B2F\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF8C00\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#9932CC\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#8FBC8B\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF6347\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#9400D3\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF1493\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00BFFF\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#696969\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#B22222\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#228B22\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DCDCDC\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFD700\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#EE82EE\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#D8BFD8\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DAA520\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#808080\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#008000\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#ADFF2F\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F0FFF0\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF69B4\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#CD5C5C\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F0E68C\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#E6E6FA\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFF0F5\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFFACD\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#ADD8E6\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F08080\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#E0FFFF\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FAFAD2\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choo";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="se the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#90EE90\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#D3D3D3\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFB6C1\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFA07A\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#20B2AA\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#B0C4DE\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFFFE0\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00FF00\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#32CD32\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FAF0E6\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF00FF\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#66CDAA\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#0000CD\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#BA55D3\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#9370DB\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#3CB371\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#7B68EE\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00FA9A\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#48D1CC\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#C71585\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F5FFFA\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFE4E1\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFE4B5\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#778899\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\t\n \t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFDEAD\" ALIGN=CENTER width=\'auto\'></TD> \n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#6B8E23\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFA500\" ALIGN=CENTER width=\'auto\'></TD>\t\t\t\t\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF4500\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DA70D6\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#EEE8AA\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#98FB98\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#AFEEEE\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DB7093\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFEFD5\" ALIGN=CENTER width=\'auto\'></TD>\n \t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFDAB9\" ALIGN=CENTER width=\'auto\'></TD> \n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#CD853F\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FFC0CB\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#DDA0DD\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#B0E0E6\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FF0000\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#BC8F8F\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#4169E1\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#FA8072\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#F4A460\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#2E8B57\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#C0C0C0\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#87CEEB\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#6A5ACD\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#708090\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#00FF7F\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#4682B4\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#D2B48C\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#40E0D0\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#87CEFA\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t\t<TD title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:#7CFC00\" ALIGN=CENTER width=\'auto\'></TD>\n\t\t\t</tr>\n\t  </table> \n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
27/07/2020 	  		       Ram kumar S											NMC-JD-CRF-0042
-------------------------------------------------------------------------------------------------
*/ 

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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block9Bytes, _wl_block9);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ColorSchemeTable.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
