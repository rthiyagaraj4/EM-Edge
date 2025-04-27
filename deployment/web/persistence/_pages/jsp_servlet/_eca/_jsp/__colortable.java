package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __colortable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ColorTable.jsp", 1722252628721L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n  <title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title> \n  <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\'></link>\n\t</head>\t\n\t<script>\n\tfunction getFontColor(object)\n\t{\n\t\twindow.returnValue = object.style.backgroundColor;\n\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();\n\t}\n\t</script>\n\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<table BGCOLOR=\"#000000\" BORDER=\"0\" CELLSPACING=3 CELLPADDING=0 WIDTH=\'380px\' HEIGHT=\'380px\'>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:antiquewhite\" ALIGN=CENTER width=\'auto\'></td> \n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:aqua\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:aquamarine\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:azure\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:beige\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:bisque\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkturquoise\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:blanchedalmond\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:blue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:blueviolet\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:burlywood\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:cadetblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:chartreuse\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:chocolate\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t \t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:coral\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:yellowgreen\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:cornsilk\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:crimson\" ALIGN=CENTER width=\'auto\'></td>\t\t\t \t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:cyan\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkcyan\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:teal\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkgoldenrod\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:yellow\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkgray\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkkhaki\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkolivegreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkorange\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkorchid\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkseagreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:tomato\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:darkviolet\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:deeppink\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:deepskyblue\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:dimgray\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:firebrick\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:forestgreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:gainsboro\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:gold\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:violet\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:thistle\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:goldenrod\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:gray\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:green\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:greenyellow\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:honeydew\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:hotpink\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:indianred\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:khaki\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lavender\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lavenderblush\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lemonchiffon\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightcoral\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightcyan\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightgoldyellow\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightgreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightgrey\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightpink\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightsalmon\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightseagreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightsteelblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Cl";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="ick inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightyellow\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lime\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:limegreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:linen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:magenta\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:medaquamarine\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumorchid\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumpurple\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumseagreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumslateblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumspringgrn\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumturquoise\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mediumvioletred\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mintcream\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:mistyrose\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:moccasin\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightslategray\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\t\n \t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:navajowhite\" ALIGN=CENTER width=\'auto\'></td> \n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:olivedrab\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:orange\" ALIGN=CENTER width=\'auto\'></td>\t\t\t\t\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:orangered\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:orchid\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:palegoldenrod\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:palegreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:paleturquoise\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:palevioletred\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:papayawhip\" ALIGN=CENTER width=\'auto\'></td>\n \t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:peachpuff\" ALIGN=CENTER width=\'auto\'></td> \n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:peru\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:pink\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:plum\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:powderblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:red\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:rosybrown\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:royalblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:salmon\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:sandybrown\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:seagreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:silver\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:skyblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:slateblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:slategray\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:springgreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:steelblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:tan\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:turquoise\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lightskyblue\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t\t<td title=\'Click inside a color box to choose the particular color\' onClick=\'getFontColor(this)\' STYLE=\"background-color:lawngreen\" ALIGN=CENTER width=\'auto\'></td>\n\t\t\t</tr>\n\t  </table> \n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

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

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Module		: IP
// Created By   : SRIDHAR R 
// Created Date : 28 APR 2004

// Function		: This page is called to display colors in a modal Window & return the 					  ColorCode.. 

// CAlling Page : "../../eIP/jsp/addModifyPriority.jsp"
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


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
