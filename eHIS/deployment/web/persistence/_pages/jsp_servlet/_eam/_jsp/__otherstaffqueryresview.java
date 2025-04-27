package jsp_servlet._eam._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __otherstaffqueryresview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/OtherStaffQueryResView.jsp", 1711963150348L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n <head>\n      \t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eAM/js/ViewOtherStaffQueryRes.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\t\n\t\t\n\n      \t<script language=\'javascript\'>\n\t\tvar currentLink = new String();\n      \tcurrentLink = \"identity_link\";\n\n\tfunction tab_click2(id){\n\t\t\tselectTab(id);\n\t\t\tobjClick(id);\n\t}\n\t\t      \t\n   \tfunction objClick(objName)\n      \t{\n      \t\t\n\t\t\tchangeLink(objName);\n      \t\tif (objName == \'identity_link\')\n      \t\t\tmoveToLink(1);\n      \t\telse if(objName == \'contactno_link\')\n      \t\t\tmoveToLink(2);\n\n      \t}\n\n\n      \tfunction changeLink(LinkName) {\n\t\t\tif (currentLink==\'identity_link\')\n\t\t\t\tdocument.getElementById(\'identity_link\').src=\'../../eAM/images/Identity_click.gif\';\n\t      \telse if (currentLink==\'contactno_link\')\n\t\t  \t\tdocument.getElementById(\'contactno_link\').src = \'../../eAM/images/Contact_Addr_click.gif\';\n\n\t\t\tif(LinkName==\'identity_link\')\n\t\t\t\tdocument.getElementById(\'identity_link\').src=\'../../eAM/images/Identity.gif\';\n\t\t\telse if(LinkName==\'contactno_link\')\n\t\t\t\tdocument.getElementById(\'contactno_link\').src=\'../../eAM/images/Contact_Addr.gif\';\n\t\t\tcurrentLink = LinkName;\n\n\t\t}\n\n\n\n\n</script>\n      </head>\n\n\t <body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\n     ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n   \t     \t     \t  \n   \t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\'practitioner_form\' id=\'practitioner_form\' >\n\t<a name=\'identitylink\' id=\'identitylink\'></a>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t<td nowrap  align=\'right\' nowrap  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td nowrap>&nbsp;</td>\n\t<td nowrap>&nbsp;</td>\n</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td nowrap >&nbsp;</td>\n\t<td nowrap >&nbsp;</td>\n</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td nowrap  align=\'right\' class=\'label\'  >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;</td>\n\t<td nowrap  align=\'left\' colspan=\'1\' class=\'queryData\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\n</tr>\n\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td>\n\t<td nowrap  align=\'left\'>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<img src=\'../../eCommon/images/enabled.gif\'></img>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<img src=\'../../eCommon/images/RRnwd.gif\'></img>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n\t<td nowrap  colspan=\'2\'>&nbsp;</td>\n</tr>\n\n<tr>\n        <td nowrap  colspan=\'4\'>&nbsp;</td>\n\n</tr>\n</table>\n\n<table name=\'insert_tab\' id=\'insert_tab\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\'>\n<tr>\n<!--<td nowrap  align=\'left\'  colspan=\'4\'>\n<a href=\"javascript:objClick(\'identity_link\') \"  alt=\'Identity\'><img name=\'identity_link\' border=\'0\' src=\'../../eAM/images/Identity.gif\' alt=\'Identity\' ></img></a><a href=\"javascript:objClick(\'contactno_link\') \" alt=\'ContactNumber\'><img name=\'contactno_link\' border=\'0\' src=\'../../eAM/images/Contact_Addr_click.gif\' alt=\'ContactNumber\' ></img></a>\n</td>-->\n<a name=\'demo\'></a>\n<td width= \"100%\" class=\"white\" colspan=\'4\'>\n<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"identity\">\n\t\t\t\t<a onclick=\"tab_click2(\'identity_link\')\" class=\"tabClicked\" id=\"identity_link\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"identity_linkspan\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"contactno\">\n\t\t\t\t<a onclick=\"tab_click2(\'contactno_link\')\" class=\"tabA\" id=\"contactno_link\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"contactno_linkspan\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\n\t\t\t\t</a>\n\t\t\t</li> \n</ul>\n</td>\n\n</tr>\n\n</table>\n\n<table name=\'insert_tab\' id=\'insert_tab\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\'>\n<th colspan=\'4\'>&nbsp;</th>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;&nbsp;</td>\n\t<td nowrap  class=\'queryData\' align=\'left\'>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t&nbsp;&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;Y&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;M&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;D&nbsp;\n\t</td>\n\t<td nowrap  align=\'right\' class=\'label\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n</tr>\n\n<tr><td colspan=\'4\'>&nbsp</td></tr>\n\n<tr>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;\t</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t<td nowrap  align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</td>\n</tr>\n<tr><td nowrap  colspan=\'4\'>&nbsp</td></tr>\n<tr><th colspan=\'4\'>&nbsp</th></tr>\n<tr>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t<td nowrap  align =\'right\'  class=\'label\' >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</td>\n</tr>\n\n<tr><td nowrap  colspan=\'4\'>&nbsp;</td></tr>\n<!--End HAS-CRF-160 -->\n<tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n    \n\t<!--Below line added for this CRF HAS-CRF-160 -->\n\t<td nowrap  align=\'right\'  class=\'label\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;</td>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<!--Below line added for this CRF HAS-CRF-160 -->\t\n\t\t<td nowrap  align=\'right\'  class=\'label\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;</td>\n\t<td nowrap  align=\'right\'  class=\'label\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\n\t<!--HAS-CRF-160  -->\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</tr>\n\n<tr><td nowrap  colspan=\'4\'>&nbsp;</td></tr>\n\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t<td nowrap  align=\'right\'  class=\'label\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td></tr>\n\n<tr><td nowrap  colspan=\'4\'>&nbsp</td></tr>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\' class= \'queryData\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\t\n\t</td>\n\t<td nowrap  align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<img src=\'../../eCommon/images/RRnwd.gif\'></img>\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n</tr>\n\n<tr><td nowrap  colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\'>\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t</td>\n\t<td nowrap  colspan=\'2\'>&nbsp;</td>\n</tr>\n\n</table>\n\t\n\t<br><br><br><br><br><br><BR><BR><BR>\n<a name=\'contactnolink\' id=\'contactnolink\'></a>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t<td nowrap  align=\'right\' nowrap  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t<td nowrap >&nbsp;</td>\n\t<td nowrap >&nbsp;</td>\n</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\t<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t<td nowrap >&nbsp;</td>\n\t<td nowrap >&nbsp;</td>\n</tr>\n\n<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\n</tr>\n\t\n<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t</td>\n\t<td nowrap  colspan=\'2\'>&nbsp;</td>\n</tr>\n\n<tr>\n        <td nowrap  colspan=\'4\'>&nbsp;</td>\n\n</tr>\n</table>\n\n<table name=\'insert_tab\' id=\'insert_tab\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\'>\n<tr>\n<!--<td nowrap  align=\'left\'  colspan=\'4\'>\n<a href=\"javascript:objClick(\'identity_link\') \"  alt=\'Identity\'><img name=\'identity_link\' border=\'0\' src=\'../../eAM/images/Identity_click.gif\' alt=\'Identity\' ></img></a><a href=\"javascript:objClick(\'contactno_link\') \" alt=\'ContactNumber\'><img name=\'contactno_link\' border=\'0\' src=\'../../eAM/images/Contact_Addr.gif\' alt=\'ContactNumber\' ></img></a>\n</td>-->\n\n<a name=\'addr\'  id=\'addr\' ></a>\n<td width= \"100%\" class=\"white\" colspan=\'4\'>\n<ul id=\"tablist\" class=\"tablist\" >\n\t\t<li class=\"tablistitem\" title=\"identity\">\n\t\t\t\t<a onclick=\"tab_click2(\'identity_link\')\" class=\"tabA\" id=\"identity_link\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"identity_linkspan\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>  \n\t\t\t<li class=\"tablistitem\" title=\"contactno\">\n\t\t\t\t<a onclick=\"tab_click2(\'contactno_link\')\" class=\"tabClicked\" id=\"contactno_link\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"contactno_linkspan\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n</ul>\n\n\n</td>\n\n<script>prevTabObj=\'identity_link\'</script>\n\n\n</tr>\n</table>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\' >\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t</td>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t</td>\n</tr>\n\n<tr><td nowrap  colspan=\'6\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\'  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t</td>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&nbsp;</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;</td>\n\t<td nowrap  align=\'left\' class=\'queryData\'>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t</td>\n</tr>\n\n<tr><td nowrap  colspan=\'6\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\' colspan=\'5\' class=\'queryData\'>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t</td>\n</tr>\n<tr><td nowrap  colspan=\'6\'>&nbsp;</td></tr>\n\t\n\t<tr>\n\t<td nowrap  align=\'right\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\' colspan=\'5\' class=\'queryData\' >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t</tr>\n\t\t<tr><td colspan=\'6\'>&nbsp;</td></tr>\n</table>\n\t<!--<br>-->\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td nowrap  align=\'right\' width=\'20%\' class=\'label\'>&nbsp;</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\t<tr>\n\t<td nowrap  align=\'right\' width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&nbsp;&nbsp;</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\' >\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n</tr>\n\n<tr>\n\t<td nowrap  align=\'right\' width=\'20%\'> </td>\n\t<td nowrap  align=\'left\'  class=\'queryData\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n</tr>\n<tr>\n\t<td nowrap  align=\'right\' width=\'20%\'> </td>\n\t<td nowrap  align=\'left\'  class=\'queryData\' >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" </td>\n\t<td nowrap  align=\'left\'  class=\'queryData\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n</tr>\n<tr>\n\t<td nowrap  align=\'right\' width=\'20%\'> </td>\n\t<td nowrap  align=\'left\'  class=\'queryData\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\' >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\' width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="&nbsp;</td>\n\t<td nowrap  align=\'left\'  class=\'queryData\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n</tr>\n\t\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n\t<td nowrap  align=\'right\' width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n</tr>\n</table>\n\t<br><br><br><br><br><br>\n\t<br><br><br><br><br><br>\n\n\n\n\n \t      ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n</html>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString; 
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	 String locale =((String)session.getAttribute("LOCALE")); //Added for this CRF HSA-CRF-160
	 request.setCharacterEncoding("UTF-8");
      		Connection conn = null; 
		conn = ConnectionManager.getConnection(request);	

		String natIdyn="";
		String strt="";
		String practtype="";
		String practtypedesc="";
		
		String practitionerid="";
		String practitionername="";
		String shortname="";
		String effstatus="";
   		String str2="";
		
		String sex="";
		String sex1="";
		String emplstatus="";
		String emplstatus1="";
		String prefmode="";
		String prefmode1="";
		String birthdate="";

		String birthplace="";
		String maritalstatus="";
		String maritaldesc="";
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String citizen1="";
		String citizendesc1="";
		String nationalidno="";
		String credentialid="";
		String jobtitle="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";

		String restelnum="";
		String offtelnum="";
		String offtelext="";
		String pagernum="";
		String faxnum="";
		String mobilenum="";
		String emailid="";
		String resaddln1="";
		String resaddln2="";
		String resaddln3="";
		String resaddln4="";
		String offaddln1="";
		String offaddln2="";
		String offaddln3="";
		String offaddln4="";
		String mailaddln1="";
		String mailaddln2="";
		String mailaddln3="";
		String mailaddln4="";
		String respostalcode="";
	
	
		String offpostalcode="";
		String mailpostalcode="";
		String rescountrycode="";
		String rescountrydesc="";

		String offcountrycode="";
		String offcountrydesc="";
		String offcountrycode1="";
		String offcountrydesc1="";
		String mailcountrycode="";
		String mailcountrydesc="";
		String mailcountrycode1="";
		String mailcountrydesc1="";
		String sql11="";
		String bage="";
		String bmonths="";
		String bdays="";
		String fcall="";		
		String cnc = "";
		
		//Added for this CRF HSA-CRF-160
		String other_alt_type_desc="";
        String other_alt_type_no="";

		//Added by Ashwini for IN:073030
        String all_facilities_yn = "";
		
	try{
      		
		ArrayList postal_code = new ArrayList(); 
   	 	fcall = request.getParameter("fcall"); 
		if (fcall == null) fcall="";
			 	
     	 
            _bw.write(_wl_block9Bytes, _wl_block9);

   	 	practitionerid=request.getParameter("other_staff_id");
		if(practitionerid==null) practitionerid = "null";
   	 	
   	 	if(practitionerid!=null && practitionerid.equals("null")) {
   	 		practitionerid = "";
			practitionername="";
			shortname="";
   	 	

			birthdate="";
			birthplace="";
			
			
   	 		PreparedStatement pstmtty = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1= null;
			PreparedStatement pstmt2= null;
   	 		PreparedStatement pstmt4=null;
			PreparedStatement pstmt6=null;
			PreparedStatement pstmt8=null;
			PreparedStatement pstmt10=null;
			PreparedStatement pstmtf=null;
			PreparedStatement pstmtc=null;

			ResultSet rst = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs4= null;
			ResultSet rs6=null;
			ResultSet rs8=null;
			ResultSet rs10=null;
			ResultSet rsf=null;
			ResultSet rsc=null;
			

		try{
			String sqlf="select count(*) as total from sm_facility_param";
			pstmtf=conn.prepareStatement(sqlf);
			rsf=pstmtf.executeQuery();
			
		    }catch(Exception e) {
		     out.println("errors="+e);
		     }
		     finally {
		      if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();
		      }




		try {

		  	String sqlt = "select other_staff_type,short_desc  from am_other_staff_type where eff_status = 'E' order by short_desc";
		  	pstmtty=conn.prepareStatement(sqlt);
		  	rst=pstmtty.executeQuery();
		  	strt="<select name='pract_type' id='pract_type'><option value=''> -----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------";
		  	 while(rst.next()) 
		  	 {
		  		practtype=rst.getString("other_staff_type");
		  		practtypedesc=rst.getString("short_desc");
		  		strt=strt+"<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc;

		  	 }
		  	 
		  	strt=strt+"</select>";


			String sql="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' order by short_desc ";
		  	pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			str2="<select name='marital_status' id='marital_status'><option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----";
			 while(rs.next())
			 {
				maritalstatus=rs.getString("mar_status_code");
				maritaldesc=rs.getString("short_desc");
				str2=str2+"<option value='"+maritalstatus+"'>"+maritaldesc+"</option>";
			 }
			
			str2=str2+"</select>";



			String sqlc="select citizen_nationality_code from mp_param";
			pstmtc=conn.prepareStatement(sqlc);
			rsc=pstmtc.executeQuery();
			if(rsc != null)
			{		
				while(rsc.next())
				{
					cnc=rsc.getString("citizen_nationality_code");
				}	
			}


			String sql1="select country_code,long_desc from mp_country where eff_status = 'E' and short_desc is not null order by long_desc ";
			pstmt1=conn.prepareStatement(sql1);
			rs1=pstmt1.executeQuery();
			 while(rs1.next())
			 {
				citizen=rs1.getString("country_code");
				citizendesc=rs1.getString("long_desc");
				if(citizen==null) citizen = "";
				if(citizendesc==null) citizendesc = "";
				if(cnc==null) cnc = "";

			 }
			
			
			String sql2="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name ";
			pstmt2=conn.prepareStatement(sql2);
			rs2=pstmt2.executeQuery();
			
			 while(rs2.next())
			 {
				repfacility=rs2.getString("facility_id");
				repfacilityname=rs2.getString("facility_name");
			 }
			 
			String sql4="select country_code,short_name from mp_country where eff_status = 'E' and  order by short_name";
			pstmt4=conn.prepareStatement(sql4);
			rs4=pstmt4.executeQuery();
			while(rs4.next())
			{
				rescountrycode=rs4.getString("country_code");
				rescountrydesc=rs4.getString("short_name");
			}
			 
			
			
			String sql6="select country_code,short_name from mp_country where eff_status = 'E' and order by short_name";
			pstmt6=conn.prepareStatement(sql6);
			rs6=pstmt6.executeQuery();
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("short_name");
		  	 } 

		  	String sql8="select country_code,short_name from mp_country where eff_status = 'E' and order by short_name";
			pstmt8=conn.prepareStatement(sql8);
		  	rs8=pstmt8.executeQuery();

			 while (rs8.next())
		  	 {
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("short_name");
		  	 }
		  	 
		  	  	
		  
		try{
		  	String sql10="select accept_national_id_no_yn from mp_param";
		  	pstmt10=conn.prepareStatement(sql10);
		  	rs10=pstmt10.executeQuery();
		  	
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			natIdyn=rs10.getString(1);
		  		}	
		  	}	
		  }catch(Exception e ){out.println("National ID "+ e);}	

		}catch(Exception e)
		{
			out.println("ERROR is -->"+e);
		}
		finally
		{
			if (pstmtty != null) pstmtty.close();
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs4 != null) rs4.close();
			if (rs6 != null) rs6.close();
			if (rs8 != null) rs8.close();
			if (rs10 != null) rs10.close();
			if (rsc != null) rsc.close();

			if (pstmt != null) pstmt.close();
			if (pstmt1 != null) pstmt1.close();
			if (pstmt2 != null) pstmt2.close();
			if (pstmt4 != null) pstmt4.close();
			if (pstmt6 != null) pstmt6.close();
			if (pstmt8 != null) pstmt8.close();
			if (pstmt10 != null) pstmt10.close();
			if (pstmtc != null) pstmtc.close();


		}

		
		
		effstatus="E";
		bage="0";
				
		}
	else
	{
		//Object pcode[] = postal_code.toArray();
		PreparedStatement pstmt11=null;
		PreparedStatement pstmt14=null;
		PreparedStatement pstmt15=null;
		PreparedStatement pstmt17=null;
		PreparedStatement pstmt19=null;
		PreparedStatement pstmt21=null;
		PreparedStatement pstmt25=null;
		PreparedStatement pstmt26=null;
		PreparedStatement pstmt27=null;
		PreparedStatement pstmtp=null;
		PreparedStatement pstmtm=null;
		PreparedStatement pstmtc=null;
		PreparedStatement pstmtr=null;
		PreparedStatement pstmtrec=null;
		PreparedStatement pstmtofc=null;
		PreparedStatement pstmtmac=null;
		PreparedStatement pstmtf=null;

		ResultSet rset=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs19=null;
		ResultSet rs21=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrec=null;
		ResultSet rsofc=null;
		ResultSet rsmac=null;
		ResultSet rsf=null;
		

		try{
						
					
					String sqlf="select count(*) as total from sm_facility_param";
					pstmtf=conn.prepareStatement(sqlf);
					rsf=pstmtf.executeQuery();
					

				    }catch(Exception e) {
				     out.println("errors="+e);
				     }
				     finally {
				      if(pstmtf != null) pstmtf.close();
				      if(rsf != null) rsf.close();
		      }


		try {
            //Modified  for this CRF HSA-CRF-160
			sql11 ="select other_staff_id,other_staff_name,short_name,other_staff_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,position_desc,empl_status,employee_id,degree,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,am_other_staff.eff_status eff_status1,mp_get_desc.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"',1) OTH_ALT_ID_TYPE,OTH_ALT_ID_NO from am_other_staff, am_position where other_staff_id=? and am_other_staff.position_code = am_position.position_code(+)";
           			
			pstmt11 = conn.prepareStatement(sql11);
			pstmt11.setString(1,practitionerid);
			rset=pstmt11.executeQuery();
			rset.next();
			practitionerid=rset.getString("other_staff_id");
			practitionername=rset.getString("other_staff_name");
			shortname=rset.getString("short_name");
			sex=rset.getString("gender");
			
			all_facilities_yn = rset.getString("all_facilities_yn");//Added by Ashwini for IN:073030

			//Added for this CRF HSA-CRF-160
			other_alt_type_desc=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
			other_alt_type_no=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");
			if(other_alt_type_desc.equals(""))other_alt_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAlternateNo.label","mp_labels");
			
				
			if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}
			else if (sex.equals("F")) 
			{
				sex1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}
			else if (sex.equals("U")) 
			{
				sex1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}
				emplstatus=rset.getString("empl_status");
				

				if(emplstatus.equals("F")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
				}
				else if (emplstatus.equals("P")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
				}
				else if (emplstatus.equals("V")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
				
				}
				else if(emplstatus.equals("S")) 
				{
				emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
				}
			
			prefmode=rset.getString("pref_contact_mode");

				if(prefmode != null) 
				{
				 if (prefmode.equals("R")) 
				 {	
					 prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
				}
				else if (prefmode.equals("O")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");

				}
				else if(prefmode.equals("F")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");

				}
				else if(prefmode.equals("M")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels");

				}
				else if(prefmode.equals("P")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
				}
				else if(prefmode.equals("E")) 
				{
					prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
				}
				else if(prefmode.equals(" ") || prefmode.equals("null")) 
				{
					prefmode1=" ";

				}
			     }
			 else
			     {
					prefmode=" ";
					prefmode1=" ";

			      }



			java.util.Date date2 = rset.getDate("date_of_birth");

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			birthdate=formatter1.format(date2);
			formatter1 = null;
			String sqldb="select calculate_age(?,1) from dual";
			pstmt25=conn.prepareStatement(sqldb);
			pstmt25.setString(1,birthdate);
			rs25=pstmt25.executeQuery();
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}	
			if(bage==null) bage="0";
			String sqldb1="select calculate_age(?,2) from dual";
			pstmt26=conn.prepareStatement(sqldb1);
			pstmt26.setString(1,birthdate);
			rs26=pstmt26.executeQuery();
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}	
			if(bmonths==null) bmonths="0";
			String sqldb2="select calculate_age(?,3) from dual";
			pstmt27=conn.prepareStatement(sqldb2);
			pstmt27.setString(1,birthdate);
			rs27=pstmt27.executeQuery();
			if(rs27 != null )
			{
				while(rs27.next())	
				{
					bdays=rs27.getString(1);
				}	
			}	
			if(bdays==null) bdays="0";
			birthplace=rset.getString("place_of_birth");
			if(birthplace == null) birthplace=" ";

			aliasname=rset.getString("alias_name");

			if(aliasname == null) aliasname=" ";

			nationalidno=rset.getString("national_id_num");


			if(nationalidno == null || nationalidno.equals("") || nationalidno.equals(" ")) nationalidno="";

			credentialid="";
			if(credentialid==null) credentialid="";

			jobtitle=rset.getString("position_desc");
			if(jobtitle==null) jobtitle="";
			
			degree=rset.getString("degree");
			if(degree == null) degree="";
			
			restelnum=rset.getString("res_tel_num");
			if(restelnum==null) restelnum="";
			
			pagernum=rset.getString("pager_num");
			if(pagernum==null) pagernum="";
			
			mobilenum=rset.getString("mobile_num");
			if(mobilenum==null) mobilenum="&nbsp;";
			
			offtelnum=rset.getString("off_tel_num");
			if(offtelnum==null) offtelnum="&nbsp;";
			
			offtelext=rset.getString("off_tel_ext");
			if(offtelext==null) offtelext="&nbsp;";
			
			faxnum=rset.getString("fax_num");
			if(faxnum==null) faxnum="&nbsp;";
			
			emailid=rset.getString("email_id");
			if(emailid==null) emailid="&nbsp;";
			
        /* below lines moidified by Venkatesh.S agasint 57984 on 07-01-2015 */
		
			resaddln1=checkForNull(rset.getString("res_add_ln1")); 
		

			resaddln2=checkForNull(rset.getString("res_add_ln2"));
			

			resaddln3=checkForNull(rset.getString("res_add_ln3"));
			

			resaddln4=checkForNull(rset.getString("res_add_ln4"));
			

			offaddln1=checkForNull(rset.getString("off_add_ln1"));
		
			offaddln2=checkForNull(rset.getString("off_add_ln2"));
		

			offaddln3=checkForNull(rset.getString("off_add_ln3"));
			
			
			offaddln4=checkForNull(rset.getString("off_add_ln4"));
		
			mailaddln1=checkForNull(rset.getString("mail_add_ln1"));
		
			
			mailaddln2=checkForNull(rset.getString("mail_add_ln2"));
			

			mailaddln3=checkForNull(rset.getString("mail_add_ln3"));
			
			
			mailaddln4=checkForNull(rset.getString("mail_add_ln4"));
		
      		/*End 57984 */
			
			effstatus=rset.getString("eff_status1");

			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="&nbsp;";


			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)

			{
				String sqlrec="select short_name from mp_country where country_code=?";
				pstmtrec=conn.prepareStatement(sqlrec);
				pstmtrec.setString(1,rescountrycode);
				rsrec=pstmtrec.executeQuery();
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("short_name");
					}	
				}	
			}
			else
			{
				rescountrydesc=" ";
			}

			
		
			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="&nbsp;";

			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					String sqlofc="select short_name from mp_country where country_code=? ";
					pstmtofc=conn.prepareStatement(sqlofc);
					pstmtofc.setString(1,offcountrycode);
					rsofc=pstmtofc.executeQuery();
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("short_name");
						}	
					}	
			}
			else
			{
					offcountrydesc= " ";
			}


			String sql19="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			pstmt19=conn.prepareStatement(sql19);
			rs19=pstmt19.executeQuery();
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				offcountrycode1=rs19.getString("country_code");
				offcountrydesc1=rs19.getString("short_name");
				if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
				}
				
			 }
			}
		
			

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode == null) mailpostalcode="";

			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			String sqlmac="select short_name from mp_country where country_code=? ";
			pstmtmac=conn.prepareStatement(sqlmac);
			pstmtmac.setString(1,mailcountrycode);
			rsmac=pstmtmac.executeQuery();
			
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("short_name");
			 	}	
			  }	
			}
			else
			{
				mailcountrydesc=" ";
			}
			String sql21="select country_code,short_name from mp_country where eff_status = 'E'  order by short_name";
			pstmt21=conn.prepareStatement(sql21);
			rs21=pstmt21.executeQuery();

			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					mailcountrycode1=rs21.getString("country_code");
					mailcountrydesc1=rs21.getString("short_name");
					if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
					}
					

			 }
			} 
			
			
		

repfacility=rset.getString("reporting_facility_id");

			if(repfacility != null)
			{
				String sqlr="select facility_name from sm_facility_param where facility_id=? ";
				pstmtr = conn.prepareStatement(sqlr);
				pstmtr.setString(1,repfacility);
				rsr=pstmtr.executeQuery();
				if(rsr != null )
				{
					while(rsr.next())
					{
						repfacilityname=rsr.getString("facility_name");
					}	
				}	
			}
			else
				{
					repfacilityname=" ";
				}


				String sql15="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";
				pstmt15=conn.prepareStatement(sql15);

				rs15=pstmt15.executeQuery();
				if(rs15 != null)
				{
				 while (rs15.next())
				 {
					repfacility1=rs15.getString("facility_id");
					repfacilityname1=rs15.getString("facility_name");
					if((repfacility1.equals(repfacility)) && (repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
					}
					else if((!repfacility1.equals(repfacility)) && (!repfacilityname1.equals(repfacilityname)) && (repfacility != null) && (!repfacilityname.equals(" ")))
					{
					}
					
				 }
				}
				

			practtype=rset.getString("other_staff_type");
			String sqlp="select short_desc from am_other_staff_type where other_staff_type=? ";
			pstmtp=conn.prepareStatement(sqlp);
			pstmtp.setString(1,practtype);
			rsp=pstmtp.executeQuery();
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					practtypedesc=rsp.getString("short_desc");
				}	
			}	

			maritalstatus=rset.getString("mar_status_code");

 			if(maritalstatus != null)
 			{

 				String sqlm="select short_desc from mp_marital_status where mar_status_code=?";
 				pstmtm=conn.prepareStatement(sqlm);
				pstmtm.setString(1,maritalstatus);
 				rsm=pstmtm.executeQuery();
 				
 				if(rsm != null)
 				{
 					while(rsm.next())
 					{
 						maritaldesc=rsm.getString("short_desc");
 					}	
 				}	
 			}
 			else
 			{
 				maritaldesc=" ";
 			}

 			
			citizen=rset.getString("citizenship_code");if (citizen == null) citizen="";
			if(citizen != null)
 			{
 				String sqlc="select long_desc from mp_country where country_code=? ";
  				pstmtc=conn.prepareStatement(sqlc);
				pstmtc.setString(1,citizen);
				rsc=pstmtc.executeQuery();
 				if(rsc != null )
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");if(citizendesc==null)citizendesc="";
 					}	
 				}	
 			}
 			else
 			{
 				citizendesc="";
 			}
 			String sql14="select country_code,long_desc from mp_country where eff_status = 'E'  and short_desc is not null order by long_desc";
 			pstmt14=conn.prepareStatement(sql14);
 			rs14=pstmt14.executeQuery();
 			if(rs14 != null)
 			{
				while (rs14.next())
				{
					citizen1=rs14.getString("country_code");
					if(citizen1 == null) citizen1="";
					citizendesc1=rs14.getString("long_desc");
					if (citizendesc1==null)citizendesc1="";
					
					
				 }
			}

///////////////
 			
 		
			
 			

		}catch(Exception e) {
					out.println("Query Error"+e);
				    }
			finally     {
								if(pstmt11 != null)pstmt11.close();
								if(pstmt14 != null) pstmt14.close();
								if(pstmt15 != null) pstmt15.close();
								if(pstmt17 != null) pstmt17.close();
								if(pstmt19 != null) pstmt19.close();
								if(pstmt21 != null) pstmt21.close();
								if(pstmt25 != null) pstmt25.close();
								if(pstmt26 != null) pstmt26.close();
								if(pstmt27 != null) pstmt27.close();
								if(pstmtp != null) pstmtp.close();
								if(pstmtm != null) pstmtm.close();
								if(pstmtc != null) pstmtc.close();
								if(pstmtr != null) pstmtr.close();
								if(pstmtrec != null)pstmtrec.close();
								if(pstmtofc != null) pstmtofc.close();
					 			if(pstmtmac != null) pstmtmac.close();

								if(rset != null) rset.close();
								if(rs14 != null) rs14.close();
								if(rs15 != null) rs15.close();
								if(rs19 != null) rs19.close();
								if(rs21 != null) rs21.close();
								if(rs25 != null) rs25.close();
								if(rs26 != null) rs26.close();
								if(rs27 != null) rs27.close();

								if(rsp != null) rsp.close();
								if(rsm != null) rsm.close();
								if(rsc != null) rsc.close();
								if(rsr != null) rsr.close();
								if(rsrec != null) rsrec.close();
								if(rsofc != null) rsofc.close();
					 			if(rsmac != null) rsmac.close();


			}


			
			
 			

		}		
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practtypedesc));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(shortname));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(effstatus.equals("E")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
 } 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
if(effstatus.equals("E")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sex1));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else if(effstatus.equals("D")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sex1));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bage));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bmonths));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bdays));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(birthdate));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(birthplace));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
if(effstatus.equals("E")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(maritaldesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(maritaldesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(aliasname));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
if(effstatus.equals("E")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(citizendesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(citizendesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
 
if(natIdyn.equals("Y")) { 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(other_alt_type_no));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nationalidno));
            _bw.write(_wl_block43Bytes, _wl_block43);
 }else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(other_alt_type_no));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(jobtitle));
            _bw.write(_wl_block47Bytes, _wl_block47);

}
            _bw.write(_wl_block48Bytes, _wl_block48);
if(natIdyn.equals("Y")) {

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block11Bytes, _wl_block11);
if(natIdyn.equals("Y")) {
            out.print( String.valueOf(jobtitle));
}else{
            out.print( String.valueOf(degree));
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(natIdyn.equals("Y")) {

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block11Bytes, _wl_block11);
if(natIdyn.equals("Y")) {
            out.print( String.valueOf(degree));
}else{if(effstatus.equals("E")){
            out.print( String.valueOf(emplstatus1));
}else if(effstatus.equals("D")){
            out.print( String.valueOf(emplstatus1));
}}
            _bw.write(_wl_block50Bytes, _wl_block50);
if(natIdyn.equals("Y")) {

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block51Bytes, _wl_block51);
if(natIdyn.equals("Y")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
if(effstatus.equals("E")) {
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(emplstatus1));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
		else if(effstatus.equals("D")) {
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(emplstatus1));
            _bw.write(_wl_block24Bytes, _wl_block24);
}}else{
            out.print( String.valueOf(repfacilityname));
}
            _bw.write(_wl_block53Bytes, _wl_block53);
if(natIdyn.equals("Y")) {

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block11Bytes, _wl_block11);
if(natIdyn.equals("Y")) {
            out.print( String.valueOf(repfacilityname));
}else{
	if(all_facilities_yn.equals("Y")) {
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block54Bytes, _wl_block54);
}}
            _bw.write(_wl_block55Bytes, _wl_block55);
if(natIdyn.equals("Y")) {

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block56Bytes, _wl_block56);
if(natIdyn.equals("Y")) {
	if(all_facilities_yn.equals("Y")) {
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block54Bytes, _wl_block54);
}
	}
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practtypedesc));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(shortname));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(effstatus.equals("E")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
 } 
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(restelnum));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(offtelnum));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(offtelext));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(faxnum));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(mobilenum));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pagernum));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if (effstatus.equals("E")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prefmode1));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prefmode1));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(emailid));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(resaddln1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(offaddln1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mailaddln1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(resaddln2));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(offaddln2));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mailaddln2));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(resaddln3));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(offaddln3));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(mailaddln3));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(resaddln4));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(offaddln4));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(mailaddln4));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(respostalcode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(offpostalcode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mailpostalcode));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rescountrydesc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(offcountrydesc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mailcountrydesc));
            _bw.write(_wl_block90Bytes, _wl_block90);
 	postal_code.clear();}catch(Exception e){
		  e.printStackTrace();}
  	       	
		finally{
			ConnectionManager.returnConnection(conn,request);
		}
            _bw.write(_wl_block91Bytes, _wl_block91);
            _bw.write(_wl_block92Bytes, _wl_block92);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortname.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Identity.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactNoAddr.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.maritalstatus.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Citizenship.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.NationalIDNo.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Degree.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Degree.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmplStatus.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmplStatus.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RepFacility.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RepFacility.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllFacilities.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllFacilities.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullName.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortname.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Identity.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactNoAddr.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ResTelNo.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ext.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FaxNo.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PagerNo.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PrefMode.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residence.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.office.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mail.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Address.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.postalcode.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
