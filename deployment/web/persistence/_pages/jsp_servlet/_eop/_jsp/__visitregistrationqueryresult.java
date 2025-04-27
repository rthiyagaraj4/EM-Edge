package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.HashMap;
import eCommon.XSSRequestWrapper;

public final class __visitregistrationqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistrationQueryResult.jsp", 1742280204166L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eOP/js/VisitRegistration1.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eOP/js/VisitRegistration.js\" language=\"JavaScript\"></Script>\n\t\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onMouseDown=\"CodeArrest();\" onKeyDown =\'lockKey();\' >\n  <form name=\'checkinresult\' id=\'checkinresult\'>\n \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(parent.frames[0].document.forms[0].search != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].search.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tvar error=getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'COMMON\')\n\t\t\t\t\talert(error);\n\t\t\t\t\t </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\n\t\t\t\t\t<p>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</td>\n</tr>\n</table>\n</p>\n\t<BR><BR>\n\t\t\t\t\n\t\t\t<table border=\"1\" cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' id=\'th_table\'>\n\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<th class=\'columnheader\' nowrap width=\'5%\'><div  id=\'head1\' class=\'myClass\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></th>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<th class=\'columnheader\' nowrap width=\'5%\'><div  id=\'head3\' class=\'myClass\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'5%\'><div  id=\'head2\' class=\'myClass\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div></th>\t\t\t\t\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'10%\'><div  id=\'head3\' class=\'myClass\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'7%\'><div  id=\'head4\' class=\'myClass\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'10%\'><div  id=\'head5\' class=\'myClass\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' width=\'15%\'><div  id=\'head6\' class=\'myClass\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'5%\'><div  id=\'head7\' class=\'myClass\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'5%\'><div  id=\'head8\' class=\'myClass\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'5%\'><div  id=\'head11\' class=\'myClass\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'15%\'><div  id=\'head9\' class=\'myClass\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div></th>\n\t\t\t\t<th class=\'columnheader\' nowrap width=\'10%\'><div  id=\'head10\' class=\'myClass\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div></th>\n\t\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<th class=\'columnheader\'width=\'1%\' nowrap><div  id=\'head1\' class=\'myClass\'>&nbsp;</div></th>\n\t\t\t\t\t<th class=\'columnheader\' width=\'5%\' nowrap><div  id=\'head2\' class=\'myClass\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div></th>\n\t\t\t\t\t<th class=\'columnheader\' width=\'5%\' nowrap><div  id=\'head3\' class=\'myClass\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div></th>\n\t\t\t\t\t<th class=\'columnheader\' width=\'13%\' nowrap><div  id=\'head4\' class=\'myClass\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div></th>\n\t\t\t\t\t<th class=\'columnheader\' width=\'10%\' nowrap><div  id=\'head5\' class=\'myClass\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div></th>\n\t\t\t\t\t<th class=\'columnheader\' width=\'12%\' nowrap><div  id=\'head6\' class=\'myClass\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</div></TD>\n\t\t\t\t\t<th class=\'columnheader\' width=\'10%\' nowrap><div  id=\'head7\' class=\'myClass\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div></th>        \n\t\t\t\t\t<th class=\'columnheader\' width=\'10%\' nowrap><div  id=\'head11\' class=\'myClass\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</div></th>        \n\t\t\t\t\t<th class=\'columnheader\' width=\'13%\' nowrap><div  id=\'head8\' class=\'myClass\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</div></th>\n\t\t\t\t\t\n\t\t\t\t\t<th class=\'columnheader\' width=\'17%\' nowrap><div  id=\'head9\' class=\'myClass\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</div></th>\n\t\t\t\t   \t<th class=\'columnheader\' width=\'14%\' nowrap><div  id=\'head10\' class=\'myClass\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</div></th>\n\t\t\t\t\t<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t   \t\t<th class=\'columnheader\' width=\'14%\' nowrap><div  id=\'head10\' class=\'myClass\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</div></th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<th class=\'columnheader\' width=\'14%\' nowrap><div  id=\'head12\' class=\'myClass\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t  <!-- order_catalog_code added by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010 -->\n\t\t\t   <tr>\n\t\t\t\t\t<td class= \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' align=\'left\' width=\'5%\' nowrap><a href=\"javascript:image_click(\'wait\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\"> ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' width=\'5%\' nowrap><font size=1>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\n\t\t\t\t\t<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' width=\'5%\' nowrap><font size=1>&nbsp;</td>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' width=\'10%\' nowrap><font size=1>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' width=\'10%\' nowrap><font size=1>&nbsp;</td>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' width=\'7%\' nowrap><font size=1>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' width=\'15%\'><font size=1>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<img border=0 src=\'../../eCommon/images/PI_VIP.gif\'></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' width=\'15%\' nowrap><font size=1>&nbsp;</td>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t   ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' width=\'15%\' nowrap><font size=1>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td> \n\t\t\t\t   ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</a></td> \t\n\t\t\t         \n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t  \n\t\t\t  \n\t\t\t ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t  \n\t\t\t\t   \n\t\t\t\t   \n\t\t\t\t   <tr>\n\t\t\t\t\t<td class= \'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' align=\'left\' width=\'1%\' nowrap><a href=\"javascript:view_appt_dtl(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\', \'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')\">+</a>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\n\t\t\t\t\t\t<input  type=\'hidden\'  name=reason_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" id=reason_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t\t\t<input  type=\'hidden\'  name=pract_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" id=pract_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td align=\'left\' class= \'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' width=\'5%\' nowrap><a href=\'javascript:tab_click_add_visit(\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\",\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\",\"\",\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\")\'>    \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t   \n\t\t\t\t\t<font size=\'1\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a></td>\n\t\t\t\t\t<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' width=\'13%\' nowrap><font size=1>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="<img border=0 src=\'../../eCommon/images/PI_VIP.gif\'></img>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' width=\'13%\' nowrap><font size=1>&nbsp;</td>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' width=\'12%\' nowrap><font size=1>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' width=\'12%\' nowrap><font size=1>&nbsp;</td>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t\t ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t \t\t\t \n\t\t\t\t ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t<!-- this condition was added by venkatesh.s on 15/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t  <td  align=\'left\' class= \'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' width=\'17%\' nowrap><font size=1>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t <td  align=\'left\' class= \'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t\t\t    ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t   ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' width=\'17%\' nowrap><font size=1>&nbsp;</td>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' width=\'14%\' nowrap><font size=1>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</a></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' width=\'14%\' nowrap><font size=1>&nbsp;</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n\n\t\t\t\t\t<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->\n\t\t\t\t\t<!--Modified by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;</td>\n\t\t\t\t  \t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="<td  align=\'left\' class= \'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' width=\'14%\' nowrap> ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" </td>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t \t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t       \n          ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n    <input type=\'hidden\' name=\'current_patient_id\' id=\'current_patient_id\' value=\'\'>\n    <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\t<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t<input type=\'hidden\' name=\'register_visit_walkin\' id=\'register_visit_walkin\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t<input type=\'hidden\' name=\'register_visit_referral\' id=\'register_visit_referral\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\'hidden\' name=\'or_install_yn\' id=\'or_install_yn\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\'hidden\' name=\'patientFlag\' id=\'patientFlag\' value=\'N\'>\n\t<input type=\'hidden\' name=\'build_episode_rule\' id=\'build_episode_rule\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\'hidden\' name=\'oa_install_yn\' id=\'oa_install_yn\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t<input type=\'hidden\' name=\'emer_regn_allow_yn\' id=\'emer_regn_allow_yn\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t<!--below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] -->\n\t<input type=\'hidden\' name=\'upt_contact_dtls_oa_yn\' id=\'upt_contact_dtls_oa_yn\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t<input type=\'hidden\' name=\'isUHID_valid_appl\' id=\'isUHID_valid_appl\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'> <!-- added by mujafar for AMRI-CRF-0357 -->\n\t\n\n    </form>\n<script>\n\t\n\t\tif(parent.frames[1].document.forms[0].search != null)\n\t\t{\n\t\t\tparent.frames[1].document.forms[0].search.disabled=false;\n\t\t}\n\t\n</script>\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet apptRecordSet= null;synchronized(session){
                apptRecordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("apptRecordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(apptRecordSet==null){
                    apptRecordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("apptRecordSet",apptRecordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
request.setCharacterEncoding("UTF-8");
	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
        Connection con = null;
		HashMap htRecord  = null ;
		ResultSet rs=null;
		ResultSet rs1=null;
        PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String endOfRes="1";
		

		
		StringBuffer where_clause_build = new StringBuffer();
		StringBuffer sql1=new StringBuffer();
		StringBuffer name_list    =new StringBuffer();
		name_list.setLength(0);
		String gender="";
		StringBuffer temp=new StringBuffer();
		String alternateIDNo[]=new String[4];
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		int start = 0 ;
		int end = 0 ;
		int incr=0;
		//int recCount=0; 
		if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from ) ;
		if ( to == null )
		end = 10 ;
		else
		end = Integer.parseInt( to ) ;
		String locale=(String)session.getAttribute("LOCALE");
		String Facility_Id  = (String) session.getValue("facility_id");
		String srchbyloc=request.getParameter("srchbyascii")==null?"":request.getParameter("srchbyascii");
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
		String upt_contact_dtls_oa_yn=request.getParameter("upt_contact_dtls_oa_yn")==null?"":request.getParameter("upt_contact_dtls_oa_yn");
		String r_area_code=request.getParameter("r_area")==null?"":request.getParameter("r_area");
		String m_area_code=request.getParameter("m_area")==null?"":request.getParameter("m_area");
		String r_region_code=request.getParameter("r_region")==null?"":request.getParameter("r_region");
		String build_episode_rule =request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
		String m_region_code=request.getParameter("m_region")==null?"":request.getParameter("m_region");
		String r_town_code=request.getParameter("r_town")==null?"":request.getParameter("r_town");
		String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
		String m_town_code=request.getParameter("m_town")==null?"":request.getParameter("m_town");
		String specCode=request.getParameter("specCode")==null?"":request.getParameter("specCode");
		String wait_list_priority=request.getParameter("wait_list_priority")==null?"":request.getParameter("wait_list_priority");
		String wait_list_inv=request.getParameter("wait_list_inv")==null?"":request.getParameter("wait_list_inv");
		String category=request.getParameter("category")==null?"":request.getParameter("category");
		String WaitListNo=request.getParameter("WaitListNo")==null?"":request.getParameter("WaitListNo");
		String waitlist_fromdate=request.getParameter("waitlist_fromdate")==null?"":request.getParameter("waitlist_fromdate");
		String waitlist_todate=request.getParameter("waitlist_todate")==null?"":request.getParameter("waitlist_todate");
		String patient_id   = (request.getParameter("Patient")== null)?"":request.getParameter("Patient");
        String where_clause     = request.getParameter("where_clause")==null?"":request.getParameter("where_clause");
		
		String oper_stn_id  = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String first_name   = request.getParameter("first_name")==null?"":request.getParameter("first_name");
        String second_name  = request.getParameter("second_name")==null?"":request.getParameter("second_name");
        String third_name   = request.getParameter("third_name")==null?"":request.getParameter("third_name");
        String family_name  = request.getParameter("family_name")==null?"":request.getParameter("family_name");
		String name_prefix  = request.getParameter("name_prefix")==null?"":request.getParameter("name_prefix");
		String sndx_type    = request.getParameter("sndx_type")==null?"":request.getParameter("sndx_type");
		String oa_install_yn= request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
        String nat_id_prompt    = request.getParameter("nat_id_prompt");
		String nationality_id    = request.getParameter("nationality_id")==null?"":request.getParameter("nationality_id");       
		
		String NRICNo = request.getParameter("NRICNo")==null?"":request.getParameter("NRICNo");
		String otherAlternateIDType = request.getParameter("otherAlternateIDType")==null?"":request.getParameter("otherAlternateIDType");
		String otherAlternateIDNo = request.getParameter("otherAlternateIDNo")==null?"":request.getParameter("otherAlternateIDNo");
		
		String register_visit_walkin=(request.getParameter("register_visit_walkin") == null)?"":request.getParameter("register_visit_walkin");
		String register_visit_referral=(request.getParameter("register_visit_referral") == null)?"":request.getParameter("register_visit_referral");
		String functionId=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");	
		
		String bl_interface_yn=(request.getParameter("bl_interface_yn") == null)?"":request.getParameter("bl_interface_yn");	
		String or_install_yn=(request.getParameter("or_install_yn") == null)?"":request.getParameter("or_install_yn");  
		String clinic_type=(request.getParameter("clinic_type") == null)?"":request.getParameter("clinic_type");
		String clinic_code=(request.getParameter("clinic_code") == null)?"":request.getParameter("clinic_code");
		String accept_dis_inv_no=(request.getParameter("accept_dis_inv_no") == null)?"":request.getParameter("accept_dis_inv_no");
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		String extApptOnly=(request.getParameter("extApptOnly") == null)?"N":request.getParameter("extApptOnly");
		String isPractoApptApplYN = (request.getParameter("isPractoApptApplYN") == null)?"false":request.getParameter("isPractoApptApplYN");
		String isPractoApptYn	= "N";
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
		/* added by lakshmanan for  ML-MMOH-CRF-1930 US007 start */
		String isVirtualConsultationVisit = (request.getParameter("isVirtualConsultationVisit") == null)?"false":request.getParameter("isVirtualConsultationVisit"); 
		String virtualConsultVisit=(request.getParameter("virtualConsultVisit") == null)?"N":request.getParameter("virtualConsultVisit"); 
		String visitTypeShortDesc="";
		String virtualConsultEnable="";
		/* added by lakshmanan for  ML-MMOH-CRF-1930 US007 end*/
		String multi_speciality_yn="";//Added for the CRF Bru-HIMS-198
		String speciality_code="";//Added for the CRF Bru-HIMS-198
		String multi_pract_sql="";//Added for the CRF Bru-HIMS-198
		PreparedStatement multiPrepdStmt=null;
		ResultSet multirset=null;

		String ext_appt_ref_no = "";
		
		/*Below lines modified by Venkatesh.S on 15/Feb/2013 against CHL-SCF-0013 [IN035559] */
		first_name=first_name.trim();
		second_name=second_name.trim();
		third_name=third_name.trim();
		family_name=family_name.trim();
		name_prefix=name_prefix.trim();
		/* end  CHL-SCF-0013 [IN035559]*/
		
		String classValue   = "";
        int row_even_or_odd = 1;
        String q_patient_id     = "";
        String q_appt_time  = "";		
		String locn_type_desc="";        
        int    lower_limit     =   0;      
     

        
		
		if(!patient_id.equals(""))
		{	where_clause_build.append(" and patient_id='"+patient_id+"'");
		}
		
		for(int i=0;i<4;i++)
		{   alternateIDNo[i]=request.getParameter("alternateIDNo"+(i+1))==null?"":request.getParameter("alternateIDNo"+(i+1));
			if(!alternateIDNo[i].equals(""))
			where_clause_build.append(" and a.alt_id"+(i+1)+"_no = '"+alternateIDNo[i]+"' "); 
		}
		if(!NRICNo.equals(""))
		where_clause_build.append(" and a.national_id_no = '"+NRICNo+"' ");			
		if(!otherAlternateIDType.equals("") && !otherAlternateIDNo.equals(""))
		where_clause_build.append(" and a.oth_alt_id_type = '"+otherAlternateIDType+"' and a.oth_alt_id_no = '"+otherAlternateIDNo+"' ");
		
		
		if(wait_list_inv.equals("Y"))
        {
		    if(!nationality_id.equals(""))  
				where_clause_build.append("and a.NATIONALITY_CODE = '"+nationality_id+"' " ) ;
			if (!clinic_type.equals("")) 
				where_clause_build.append(" and a.care_locn_type_ind='"+clinic_type+"'");	
			else 
				where_clause_build.append(" and a.care_locn_type_ind in ('C','E') ");	
			if (!clinic_code.equals("")) 
				where_clause_build.append(" and a.locn_code='"+clinic_code+"'");
			if (!specCode.equals("")) 
				where_clause_build.append(" and a.SPECIALTY_CODE='"+specCode+"'");	  
			if (!WaitListNo.equals("")) 
			    where_clause_build.append(" and a.wait_list_no='"+WaitListNo.trim()+"'");
			if	(!r_area_code.equals(""))
				where_clause_build.append(" and a.RES_AREA_CODE ='"+r_area_code+"'");
			if (!m_area_code.equals(""))
				where_clause_build.append(" and a.MAIL_AREA_CODE ='"+m_area_code+"'");
			if	(!r_town_code.equals(""))
				where_clause_build.append(" and a.RES_TOWN_CODE ='"+r_town_code+"'");
			if	(!m_town_code.equals(""))
				where_clause_build.append(" and a.MAIL_TOWN_CODE ='"+m_town_code+"'");
			if	(!r_region_code.equals(""))
				where_clause_build.append(" and a.RES_REGION_CODE ='"+r_region_code+"'");
			if	(!m_region_code.equals(""))
				where_clause_build.append(" and a.MAIL_REGION_CODE ='"+m_region_code+"'");
			if (!wait_list_priority.equals(""))
				where_clause_build.append(" and a.WAIT_LIST_PRIORITY ='"+wait_list_priority+"'");
	   		if (!category.equals(""))
				where_clause_build.append(" and a.WAITLIST_CATEGORY_CODE ='"+category+"'");
			if (!waitlist_fromdate.equals("")) 
				where_clause_build.append("  and trunc(a.invited_date_time)>=to_date('"+waitlist_fromdate+"','dd/mm/yyyy')");
			if (!waitlist_todate.equals(""))  
				where_clause_build.append(" and trunc(a.invited_date_time)<=to_date('"+waitlist_todate+"','dd/mm/yyyy')");	
		}else{
		
		if(!nationality_id.equals(""))  
        where_clause_build.append(" and a.COUNTRY_CODE = '"+nationality_id+"' " ) ;
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		if(extApptOnly.equals("Y"))
			where_clause_build.append(" and ext_appt_ref_no is not null " ) ;
		/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
		
		if (sndx_type.equals("E"))
        {
           if(srchbyloc.equals("N"))
			{
			if (!first_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.first_name)) like ethnic_soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.second_name)) like ethnic_soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.third_name)) like ethnic_soundex(upper('"+third_name+"'))||'%' ");
         	if (!family_name.equals(""))
             name_list.append(" and ethnic_soundex(upper(a.family_name)) like ethnic_soundex(upper('"+family_name+"'))||'%' ");
							
			
			}else{
			if (!first_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.first_name_loc_lang)) like ethnic_soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.second_name_loc_lang)) like ethnic_soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and ethnic_soundex(upper(a.third_name_loc_lang)) like ethnic_soundex(upper('"+third_name+"'))||'%' ");
         	if (!family_name.equals(""))
             name_list.append(" and ethnic_soundex(upper(a.family_name_loc_lang)) like ethnic_soundex(upper('"+family_name+"'))||'%' ");



			}
		}
        else if (sndx_type.equals("G"))
        {
             if(srchbyloc.equals("N"))
			{
			if (!first_name.equals(""))
            name_list.append(" and soundex(upper(a.first_name)) like soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and soundex(upper(a.second_name)) like soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and soundex(upper(a.third_name)) like soundex(upper('"+third_name+"'))||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and soundex(upper(a.family_name)) like soundex(upper('"+family_name+"'))||'%' ");
			
			}else
			{
			if (!first_name.equals(""))
            name_list.append(" and soundex(upper(a.first_name_loc_lang)) like soundex(upper('"+first_name+"'))||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and soundex(upper(a.second_name_loc_lang)) like soundex(upper('"+second_name+"'))||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and soundex(upper(a.third_name_loc_lang)) like soundex(upper('"+third_name+"'))||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and soundex(upper(a.family_name_loc_lang)) like soundex(upper('"+family_name+"'))||'%' ");
			
			}
		}
        else
        {  
			 if(srchbyloc.equals("N"))
			{
			
			if (!first_name.equals(""))
            name_list.append(" and upper(a.first_name) like upper('"+first_name+"')||'%' ");
            if (!second_name.equals(""))
            name_list.append(" and upper(a.second_name) like upper('"+second_name+"')||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and upper(a.third_name) like upper('"+third_name+"')||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and upper(a.family_name) like upper('"+family_name+"')||'%' ");
			
			
			}else{
		    
			if (!first_name.equals(""))
           	name_list.append(" and upper(a.first_name_loc_lang) like upper('"+first_name+"%') ");
            if (!second_name.equals(""))
            name_list.append(" and upper(a.second_name_loc_lang) like upper('"+second_name+"')||'%' ");
            if (!third_name.equals(""))
            name_list.append(" and upper(a.third_name_loc_lang) like upper('"+third_name+"')||'%' ");
            if (!family_name.equals(""))
            name_list.append(" and upper(a.family_name_loc_lang) like upper('"+family_name+"')||'%' ");
			
			}
		}
        name_prefix		     = (name_prefix == null)?"":name_prefix;
		
   		int cnt=0;
		while(name_prefix.indexOf("'",cnt)!=-1)
		{	
			int a=name_prefix.indexOf("'",cnt);
			temp.setLength(0);
			temp.append(name_prefix);
			temp.replace(a,a+1,"''");
			name_prefix=temp.toString();
			cnt=(a+2);
		}
		
		temp.setLength(0);
		if (!name_prefix.equals(""))
			name_list.append(" and upper(a.name_prefix) like upper('"+name_prefix+"')||'%' ");
		

		if (oper_stn_id!=null||(!oper_stn_id.equals("")))
        {            
          where_clause_build.append( "and a.clinic_code in(SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+Facility_Id+"' AND b1.oper_stn_id = '"+oper_stn_id+"'  AND b1.eff_status = 'E')");
		 			
		 					
        }
        }
	 
            _bw.write(_wl_block8Bytes, _wl_block8);

		String practname="";  
        String locn_type = "";			
		String locn_code = "";
		 boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070
		 boolean isUHID_valid_appl = false; //Added by Mujafar against ML-MMOH-CRF-1070

		 //Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		 Boolean isSlotStartMidEndAppl = false;

		try
        {
		con = ConnectionManager.getConnection(request);
		isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
		
		isUHID_valid_appl = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		
		sql1.setLength(0);
		if(wait_list_inv.equals("Y"))
        {
			/*
			String sql_inv = "select ACCEPT_DISPLAY_INV_NO from op_param where operating_facility_id='"+Facility_Id+"'";

			pstmt   = con.prepareStatement(sql_inv);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				accept_dis_inv_no = rs.getString("ACCEPT_DISPLAY_INV_NO") == null ? "":rs.getString("ACCEPT_DISPLAY_INV_NO");
			}

			if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
			*/
				
			//order_catalog_code added in the query by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010	
			sql1.append("SELECT wait_list_status, NVL(a.INVITATION_NUMBER,  '') invitation_no, a.WAIT_LIST_NO wait_list_no, a.WAIT_LIST_PRIORITY priority , NVL(a.PATIENT_ID,'') patient_id, decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, TO_CHAR(a.PREFERRED_DATE_TIME,  'dd/mm/yyyy') pref_date_time , a.care_locn_type_ind locn_type, a.RESOURCE_CLASS  resc_class,  am_get_desc.AM_PRACTITIONER(resource_id,'"+locale+"',2) pract_name,  op_get_desc.OP_CLINIC('"+Facility_Id+"',a.locn_code,'"+locale+"',1) CLINIC_SHORT_DESC, a.SPECIALTY_CODE,  a.locn_code clinic_code, a.resource_id PRACTITIONER_ID, a.resource_class,  am_get_desc.am_speciality(SPECIALTY_CODE,'"+locale+"',2) SPECIALITY_DESC, a.GENDER GENDER, get_age(a.DATE_OF_BIRTH) age, TO_CHAR(a.INVITED_DATE_TIME,'dd/mm/yyyy') INVITED_DATE_TIME , oa_get_desc.OA_WAITLIST_CATEGORY(waitlist_category_code,'"+locale+"',2) category_desc,  waitlist_category_code,a.order_catalog_code order_catlog_code,multi_speciality_yn,specialty_code,a.oth_contact_no FROM pr_wait_list a WHERE a.facility_id = '"+Facility_Id+"' AND a.rd_waitlist_yn='N' and a.wait_list_status = 'I' AND   a.patient_id IS NOT NULL  ");
			sql1.append(where_clause_build.toString());
			sql1.append("  ORDER BY a.WAIT_LIST_PRIORITY DESC, to_number(a.WAIT_LIST_NO), a.PREFERRED_DATE_TIME");
		
		} else {
		
	
			//sql1.append("SELECT   TO_CHAR(a.appt_time,'hh24:mi') appt_time,a.appt_status,decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, NVL(a.patient_id,'') patient_id, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_desc,  DECODE(a.resource_class,  'P', am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1),  'R',  a.practitioner_id,  AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2')) practitioner_name,  a.clinic_code clinic_code,  a.practitioner_id pract_id,  a.appt_ref_no,  a.appt_type_code,  NVL(a.referral_id,  '')referral_id,  TO_CHAR(a.appt_date,  'dd/mm/yyyy') appt_date,  TO_CHAR(a.appt_slab_from_time,  'hh24:mi') from_time,  TO_CHAR(a.appt_slab_to_time,  'hh24:mi') to_time,  mp_get_desc.mp_country(COUNTRY_CODE,'"+locale+"',3) nationality,  national_id_no,  a.care_locn_type_ind clinic_type,  a.resource_class resource_class,  a.resource_class  resource_desc, a.service_code service_code, a.recur_wo_sec_res recur_wo_sec_res,am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE");  
			/*Above Query Commented and Below Query modified for this CRF [RUT-CRF-0011]*/
			/* this line query was modified by venkatesh.s on 15/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version */
			sql1.append("SELECT   TO_CHAR(a.appt_time,'hh24:mi') appt_time,a.appt_status,decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, NVL(a.patient_id,'') patient_id, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_desc,  DECODE(a.resource_class,  'P', am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1),  'R',  a.practitioner_id,  AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2')) practitioner_name,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,'"+locale+"', 2) room_shor_desc,a.clinic_code clinic_code,  a.practitioner_id pract_id,  a.appt_ref_no,  a.appt_type_code,  NVL(a.referral_id,  '')referral_id,  TO_CHAR(a.appt_date,  'dd/mm/yyyy') appt_date,  TO_CHAR(a.appt_slab_from_time,  'hh24:mi') from_time,  TO_CHAR(a.appt_slab_to_time,  'hh24:mi') to_time,  mp_get_desc.mp_country(COUNTRY_CODE,'"+locale+"',3) nationality,  national_id_no,  a.care_locn_type_ind clinic_type,  a.resource_class resource_class,  a.resource_class  resource_desc, a.service_code service_code, a.recur_wo_sec_res recur_wo_sec_res, a.patient_cat_code patient_cat_code, am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE,MULTI_SPECIALITY_YN,a.SPECIALITY_CODE,a.ext_appt_ref_no,a.oth_contact_no ");  
			
			if(or_install_yn.equals("Y"))
			{
				sql1.append(",a.ordering_facility_id ordering_facility_id,  a.order_id order_id,  a.order_line_num order_line_num,  a.order_type_code order_type_code,  a.order_catalog_code order_catlog_code,  e.short_desc order_catalog_desc"); 
			}
			if(isVirtualConsultationVisit.equals("true")) {  // ML-MMOH-CRF-1930 US007
				sql1.append(", f.virtual_consultation , f.short_desc");
			}	
			sql1.append(" FROM  oa_appt a ");
			if(isVirtualConsultationVisit.equals("true")) { // ML-MMOH-CRF-1930 US007
				sql1.append(", op_visit_type f");
			}
			if(or_install_yn.equals("Y"))
			{
				sql1.append(" ,or_order_catalog e"); 
			}
			sql1.append(" WHERE   a.facility_id='"+Facility_Id+"' AND  a.appt_date = TRUNC(SYSDATE) AND rd_appt_yn = 'N' and  a.appt_status = '1'");
			if(isVirtualConsultationVisit.equals("true")) { // ML-MMOH-CRF-1930 US007
				sql1.append(" and a.appt_type_code=f.visit_type_code and a.facility_id=f.facility_id ");
				if (virtualConsultVisit.equals("Y")) {
					sql1.append("and f.virtual_consultation='E' ");
				}
			}
			if(or_install_yn.equals("Y"))
			{
				sql1.append(" and a.order_catalog_code=e.order_catalog_code(+)");
			}
			sql1.append(where_clause+where_clause_build.toString()+name_list.toString());

			if(clinic_type.equals("C"))			
				sql1.append(" and a.care_locn_type_ind = 'C' ");			
			else if(clinic_type.equals("E"))
				sql1.append(" and a.care_locn_type_ind = 'E' ");
			else 
				sql1.append(" and a.care_locn_type_ind in ('C','E') ");	  	

			sql1.append("  order by 1 ");			

		}
		    
		name_list.setLength(0);
		where_clause_build.setLength(0);      
		
		pstmt   = con.prepareStatement(sql1.toString());				
        rs = pstmt.executeQuery();
      	apptRecordSet.clearAll();
        if( rs != null )
          {                    
		for( int j=1; j<start; incr++,j++ ){
	     rs.next() ;
	     }
		while( incr<end && rs.next() )
          {      htRecord = new HashMap();                  
		if (row_even_or_odd == 1)
           {
		   row_even_or_odd = 2;
           classValue = "QRYODD";
		   }
           else
           {
			classValue = "QRYEVEN";
			row_even_or_odd = 1;
		   }  

            if(wait_list_inv.equals("Y")) 		
			{       
				 htRecord.put("invitation_no", rs.getString("invitation_no")==null?"":rs.getString("invitation_no"));
				 htRecord.put("wait_list_status",  rs.getString("wait_list_status")==null?"":rs.getString("wait_list_status"));
				
				 String priority=rs.getString("priority")==null?"":rs.getString("priority");
				 if(priority.equals("U"))
				 {				  priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels"); 
				 } else if(priority.equals("S")) {
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiurgent.label","common_labels"); 
				 } else if(priority.equals("N")) {
					   priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels"); 
				 }
				 htRecord.put("priority", priority );
               	 htRecord.put("patient_id",  rs.getString("patient_id")==null?"":rs.getString("patient_id"));
				 htRecord.put("patient_name", rs.getString("patient_name")==null?"":rs.getString("patient_name"));
				 htRecord.put("oth_contact_no", rs.getString("oth_contact_no")==null?"":rs.getString("oth_contact_no"));
				 htRecord.put("pref_date_time",  rs.getString("pref_date_time")==null?"":rs.getString("pref_date_time"));
				 htRecord.put("age",rs.getString("age")==null?"":rs.getString("age"));				 
				 locn_type = rs.getString("locn_type")==null?"":rs.getString("locn_type");				 
  			     htRecord.put("locn_type", locn_type  );		
					 
					  htRecord.put("pract_name",  (rs.getString("pract_name")==null?"":rs.getString("pract_name")) );
					  
					  gender=rs.getString("GENDER")==null?"":rs.getString("GENDER");
					  if(gender.equals("M"))
				        {
				       gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); 
						}
					  else if(gender.equals("F"))
				        {
					   gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); 
                			   }
                      else if(gender.equals("U"))
			               {
			                   gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						   }
					  
					  htRecord.put("GENDER",gender);
					  htRecord.put("CLINIC_SHORT_DESC", rs.getString("CLINIC_SHORT_DESC")==null?"":rs.getString("CLINIC_SHORT_DESC"));
					  htRecord.put("SPECIALTY_CODE", rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE"));
					 
					  htRecord.put("clinic_code", rs.getString("clinic_code")==null?"":rs.getString("clinic_code"));	
					  htRecord.put("PRACTITIONER_ID", rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID"));	
					  htRecord.put("resource_class", rs.getString("resource_class")==null?"":rs.getString("resource_class"));	
					  htRecord.put("SPECIALITY_DESC", rs.getString("SPECIALITY_DESC")==null?"":rs.getString("SPECIALITY_DESC"));	
					  htRecord.put("category_desc", rs.getString("category_desc")==null?"":rs.getString("category_desc"));	
					  htRecord.put("wait_list_no", 
					    rs.getString("wait_list_no")==null?"":rs.getString("wait_list_no"));	
					  //Added by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010
					  htRecord.put("order_catalog_code",(rs.getString("order_catlog_code") == null)?"":rs.getString("order_catlog_code"));
					 
					  String invited_date_timeconv=(rs.getString("invited_date_time")==null?"":rs.getString("invited_date_time"));
					  if(invited_date_timeconv!="")invited_date_timeconv=DateUtils.convertDate(invited_date_timeconv,"DMY","en",locale);
					  htRecord.put("invited_date_time",invited_date_timeconv );	
					//Added for the CRF - Bru-HIMS-CRF-0198 - Start
					    multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");
					    htRecord.put("multi_speciality_yn",multi_speciality_yn);
					    if(multi_speciality_yn.equals("Y")){
					    	speciality_code=rs.getString("specialty_code")==null?"":rs.getString("specialty_code");
					    	multi_pract_sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where PRIMARY_SPECIALITY_CODE='"+speciality_code+"' and language_id='"+locale+"'";
					    	multiPrepdStmt   = con.prepareStatement(multi_pract_sql);				
					    	multirset = multiPrepdStmt.executeQuery();
					    	if(multirset!=null && multirset.next()){
					    		htRecord.put("PRACTITIONER_ID",multirset.getString("practitioner_id"));
					    		htRecord.put("practitioner_name",multirset.getString("practitioner_name"));
					    	}
					    }
					  //Added for the CRF - Bru-HIMS-CRF-0198 - End
							  
			    			  
			  }else{
							   
			if (rs.getString("patient_id") == null)
			q_patient_id =  "&nbsp;";
			else
			q_patient_id =  rs.getString("patient_id");

			if (rs.getString("appt_time") == null)
			q_appt_time =   "&nbsp;";
			else
			q_appt_time =   rs.getString("appt_time");	

			locn_type = rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			locn_code = rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
	   

			
			/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
			ext_appt_ref_no = rs.getString("ext_appt_ref_no")==null?"":rs.getString("ext_appt_ref_no");
			isPractoApptYn = "N";
			if(!ext_appt_ref_no.equals(""))
				isPractoApptYn = "Y";

	   		htRecord.put("ext_appt_ref_no", ext_appt_ref_no);
	   		htRecord.put("isPractoApptYn", isPractoApptYn);
			/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
			
			/*Added by lakshmanan for ML-MMOH-CRF-1930 */
			if(isVirtualConsultationVisit.equals("true")) {
			visitTypeShortDesc=rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			virtualConsultEnable=rs.getString("virtual_consultation")==null?"":rs.getString("virtual_consultation");
			htRecord.put("visitTypeShortDesc", visitTypeShortDesc);
			htRecord.put("virtualConsultEnable", virtualConsultEnable);
			}
			/*Added by lakshmanan for ML-MMOH-CRF-1930 */
			
			htRecord.put("locn_code", locn_code);
			htRecord.put("locn_type", locn_type);
            htRecord.put("q_patient_id", q_patient_id);
            htRecord.put("q_appt_time",  q_appt_time);
         	htRecord.put("patient_name",  
			rs.getString("patient_name")==null?"":rs.getString("patient_name"));  
            htRecord.put("nationality",rs.getString("nationality")==null?"":rs.getString("nationality")); 
            htRecord.put("oth_contact_no",rs.getString("oth_contact_no")==null?"":rs.getString("oth_contact_no")); 
			htRecord.put("national_id_no",  rs.getString("national_id_no")==null?"&nbsp;":rs.getString("national_id_no")); 
         	htRecord.put("clinic_desc",  rs.getString("clinic_desc")==null?"":rs.getString("clinic_desc")); 
			
			htRecord.put("resource_class", (rs.getString("resource_class")==null?"":rs.getString("resource_class"))); 
		    multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");
		    htRecord.put("multi_speciality_yn",multi_speciality_yn);

			if(((String)htRecord.get("resource_class")).equals("P"))
			{
			htRecord.put("Pract_id",rs.getString("pract_id")==null?"":rs.getString("pract_id"));  
			htRecord.put("practitioner_name", rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
            practname= (String)htRecord.get("practitioner_name");
			htRecord.put("Rpractitioner_name",practname);

			}
			else if(((String)htRecord.get("resource_class")).equals("E")||((String)htRecord.get("resource_class")).equals("O"))
			{
			htRecord.put("Pract_id",rs.getString("pract_id")==null?"":rs.getString("pract_id"));
			htRecord.put("practitioner_name","");
			htRecord.put("Rpractitioner_name",rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
			practname= rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
			}else
			{
            htRecord.put("Pract_id","");
		    htRecord.put("practitioner_name","");
		    htRecord.put("Rpractitioner_name",rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
			/* this line was added by venkatesh.s on 15/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version */
			htRecord.put("room_desc",rs.getString("room_shor_desc")==null?"":rs.getString("room_shor_desc"));
		    practname= rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
		    //Added for the CRF - Bru-HIMS-CRF-0198 - Start
		    if(multi_speciality_yn.equals("Y")){
		    	speciality_code=rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
		    	multi_pract_sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where PRIMARY_SPECIALITY_CODE='"+speciality_code+"' and language_id='"+locale+"'";
		    	multiPrepdStmt   = con.prepareStatement(multi_pract_sql);				
		    	multirset = multiPrepdStmt.executeQuery();
		    	if(multirset!=null && multirset.next()){
		    		htRecord.put("Pract_id",multirset.getString("practitioner_id"));
		    		htRecord.put("practitioner_name",multirset.getString("practitioner_name"));
		    	}
		    }
		  //Added for the CRF - Bru-HIMS-CRF-0198 - End
			}	
			
		    if(or_install_yn.equals("Y"))
			{
			htRecord.put("ordering_facility_id",(rs.getString("ordering_facility_id") == null)?"":rs.getString("ordering_facility_id"));
			htRecord.put("order_id",(rs.getString("order_id") == null)?"":rs.getString("order_id"));
			htRecord.put("order_line_num",(rs.getString("order_line_num") == null)?"":rs.getString("order_line_num"));
			htRecord.put("order_type_code",(rs.getString("order_type_code") == null)?"":rs.getString("order_type_code"));
			htRecord.put("order_catalog_code",(rs.getString("order_catlog_code") == null)?"":rs.getString("order_catlog_code"));
			htRecord.put("order_catalog_desc",(rs.getString("order_catalog_desc") == null)?"":rs.getString("order_catalog_desc"));
			}
			else
			{
			htRecord.put("ordering_facility_id","");
			htRecord.put("order_id","");
			htRecord.put("order_line_num","");
			htRecord.put("order_type_code","");
			htRecord.put("order_catalog_code","");
			htRecord.put("order_catalog_desc","");
			}
			htRecord.put("referral_id",  rs.getString("referral_id")==null?"":rs.getString("referral_id"));
            htRecord.put("patient_id", rs.getString("patient_id")==null?"":rs.getString("patient_id"));  
            htRecord.put("clinic_code", rs.getString("clinic_code")==null?"":rs.getString("clinic_code"));
            htRecord.put("appt_ref_no", rs.getString("appt_ref_no")==null?"":rs.getString("appt_ref_no"));  
            htRecord.put("service_code", rs.getString("service_code")==null?"":rs.getString("service_code"));  
            htRecord.put("appt_type_code", rs.getString("appt_type_code")==null?"":rs.getString("appt_type_code"));  
            htRecord.put("appt_date",rs.getString("appt_date")==null?"":rs.getString("appt_date"));  
            htRecord.put("from_time", rs.getString("from_time")==null?"":rs.getString("from_time"));  
            htRecord.put("to_time", rs.getString("to_time")==null?"":rs.getString("to_time"));  
			htRecord.put("recur_wo_sec_res", rs.getString("recur_wo_sec_res")==null?"":rs.getString("recur_wo_sec_res")); 
			/*Added below Line for this CRF [RUT-CRF-0011]*/
			htRecord.put("patient_cat_code", rs.getString("patient_cat_code")==null?"":rs.getString("patient_cat_code")); 
            /*End*/
			
			   String resource_desc=(rs.getString("resource_desc")==null?"":rs.getString("resource_desc"));
               if(resource_desc.equals("P")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
			   } else if(resource_desc.equals("E")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels"); 
               } else if(resource_desc.equals("O")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
 		       } else if(resource_desc.equals("R")) {
				   resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	 		   }


			
			htRecord.put("resource_desc", resource_desc); 
    		if(((String)htRecord.get("resource_class")).equals("R"))
			 {	 htRecord.put("Room_num",rs.getString("pract_id")==null?"":rs.getString("pract_id"));
			 }
			 else
				{	htRecord.put("Room_num","");
				}
                   htRecord.put("contact_reason_code",rs.getString("CONTACT_REASON_CODE")==null?"":rs.getString("CONTACT_REASON_CODE"));
				    htRecord.put("reason",rs.getString("reason")==null?"":rs.getString("reason"));
			  
			  }
				 apptRecordSet.putObject(htRecord);
				 incr++;
					}
               
	 //rs.previous();
     if (!rs.next())
      {
       endOfRes = "0"; 
	  }
				
				
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
              //}
           
			int totalRecords = apptRecordSet.getSize();
			
			if(totalRecords == 0 )	
			{		
				
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			else
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);

				if(totalRecords != 0)
				{
				
				
            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( !(start <= 1) ){
	out.println("<A HREF='../jsp/VisitRegistrationQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&where_clause="+java.net.URLEncoder.encode(where_clause)+"&Patient="+patient_id+"&oper_stn_id="+oper_stn_id+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_prefix="+name_prefix+"&sndx_type="+sndx_type+"&nat_id_prompt="+nat_id_prompt+"&nationality_id="+nationality_id+"&NRICNo="+NRICNo+"&otherAlternateIDNo="+otherAlternateIDNo+"&register_visit_walkin"+register_visit_walkin+"&register_visit_referral"+register_visit_referral+"&function_id="+functionId+"&bl_interface_yn="+bl_interface_yn+"&or_install_yn="+or_install_yn+"&alternateIDNo1="+alternateIDNo[0]+"&alternateIDNo2="+alternateIDNo[1]+"&alternateIDNo3="+alternateIDNo[2]+"&alternateIDNo4="+alternateIDNo[3]+"&WaitListNo="+WaitListNo+"&specCode="+specCode+"&oper_stn_id="+oper_stn_id+"&function_id="+functionId+"&r_area="+r_area_code+"&m_area="+m_area_code+"&r_region="+r_region_code+"&m_region="+m_region_code+"&r_town="+r_town_code+"&m_town="+m_town_code+"&category="+category+"&wait_list_priority="+wait_list_priority+"&oa_install_yn="+oa_install_yn+"&waitlist_fromdate="+waitlist_fromdate+"&waitlist_todate="+waitlist_todate+"&bl_interface_yn="+bl_interface_yn+"&oper_stn_id="+oper_stn_id+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&or_install_yn="+or_install_yn+"&oa_install_yn="+oa_install_yn+"&build_episode_rule="+build_episode_rule+"&register_visit_referral="+register_visit_referral+"&clinic_type="+clinic_type+"&register_visit_walkin="+register_visit_walkin+"&accept_dis_inv_no="+accept_dis_inv_no+"&wait_list_inv="+wait_list_inv+"&isPractoApptApplYN="+isPractoApptApplYN+"&virtualConsultVisit="+virtualConsultVisit+"&isVirtualConsultationVisit="+isVirtualConsultationVisit+"&extApptOnly="+extApptOnly+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					}

if (endOfRes.equals("1"))
			{ 
out.println("<A HREF='../jsp/VisitRegistrationQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&where_clause="+java.net.URLEncoder.encode(where_clause)+"&Patient="+patient_id+"&oper_stn_id="+oper_stn_id+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_prefix="+name_prefix+"&sndx_type="+sndx_type+"&nat_id_prompt="+nat_id_prompt+"&nationality_id="+nationality_id+"&NRICNo="+NRICNo+"&otherAlternateIDNo="+otherAlternateIDNo+"&register_visit_walkin"+register_visit_walkin+"&register_visit_referral"+register_visit_referral+"&function_id="+functionId+"&bl_interface_yn="+bl_interface_yn+"&or_install_yn="+or_install_yn+"&alternateIDNo1="+alternateIDNo[0]+"&alternateIDNo2="+alternateIDNo[1]+"&alternateIDNo3="+alternateIDNo[2]+"&alternateIDNo4="+alternateIDNo[3]+"&WaitListNo="+WaitListNo+"&specCode="+specCode+"&oper_stn_id="+oper_stn_id+"&function_id="+functionId+"&r_area="+r_area_code+"&m_area="+m_area_code+"&r_region="+r_region_code+"&m_region="+m_region_code+"&r_town="+r_town_code+"&m_town="+m_town_code+"&category="+category+"&wait_list_priority="+wait_list_priority+"&oa_install_yn="+oa_install_yn+"&wait_list_inv="+wait_list_inv+"&waitlist_fromdate="+waitlist_fromdate+"&waitlist_todate="+waitlist_todate+"&bl_interface_yn="+bl_interface_yn+"&oper_stn_id="+oper_stn_id+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral="+register_visit_referral+"&clinic_type="+clinic_type+"&or_install_yn="+or_install_yn+"&oa_install_yn="+oa_install_yn+"&accept_dis_inv_no="+accept_dis_inv_no+"&build_episode_rule="+build_episode_rule+"&isPractoApptApplYN="+isPractoApptApplYN+"&virtualConsultVisit="+virtualConsultVisit+"&isVirtualConsultationVisit="+isVirtualConsultationVisit+"&extApptOnly="+extApptOnly+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			}

            _bw.write(_wl_block12Bytes, _wl_block12);
if(wait_list_inv.equals("Y")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 
					if( accept_dis_inv_no.equals("D") )
					{
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
					}
				
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
if(isPractoApptApplYN.equals("true")){
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(isVirtualConsultationVisit.equals("true")) { // ML-MMOH-CRF-1930 Lakshmanan 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
} 
					}
				}
				for(int i=lower_limit; i <totalRecords; i++){
				
				
            _bw.write(_wl_block42Bytes, _wl_block42);

                 
				 htRecord                =       (java.util.HashMap)   apptRecordSet.getObject(i);
				 
                  if(classValue.equals("QRYEVEN")) classValue = "QRYODD" ;
                  else    classValue = "QRYEVEN" ;
                   
			 if(wait_list_inv.equals("Y")) 		
			  {	 
                  if(htRecord.get("locn_type").equals("C"))  { 
			         locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
        				 } else if(htRecord.get("locn_type").equals("E")) { 
				    locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					} 
					
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("patient_id")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("invitation_no")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("clinic_code")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(wait_list_inv));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("clinic_code")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("locn_type")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("wait_list_status")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("SPECIALTY_CODE")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("PRACTITIONER_ID")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("practitioner_name")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("order_catalog_code")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(htRecord.get("multi_speciality_yn")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(htRecord.get("wait_list_no")));
            _bw.write(_wl_block47Bytes, _wl_block47);
 
				   	if( accept_dis_inv_no.equals("D") )
					{
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(htRecord.get("invitation_no")));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
					}
					
            _bw.write(_wl_block51Bytes, _wl_block51);
	
					if(!htRecord.get("invited_date_time").equals("")){
						
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(htRecord.get("invited_date_time")));
            _bw.write(_wl_block50Bytes, _wl_block50);
 } else{ 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("SPECIALITY_DESC").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(htRecord.get("SPECIALITY_DESC")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("category_desc").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(htRecord.get("category_desc")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("patient_id").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(htRecord.get("patient_id")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("patient_name").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

					if(isVIPimgpatfrontappl) // added by mujafar for ML-MMOH-CRF-1070
					{	String pat_id = (String)htRecord.get("patient_id");
						String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,pat_id,Facility_Id);
						if(vip_pat_yn.equals("TRUE"))
						{
					
            _bw.write(_wl_block60Bytes, _wl_block60);
}}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(htRecord.get("patient_name")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("age").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(htRecord.get("age")));
            _bw.write(_wl_block62Bytes, _wl_block62);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("GENDER").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)htRecord.get("GENDER")));
            _bw.write(_wl_block62Bytes, _wl_block62);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("locn_type").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(htRecord.get("CLINIC_SHORT_DESC")));
            _bw.write(_wl_block65Bytes, _wl_block65);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("priority").equals("")){
					
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(htRecord.get("priority")));
            _bw.write(_wl_block66Bytes, _wl_block66);
} 
					else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
}else{

				     if(htRecord.get("locn_type").equals("C"))  { 
			            locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
        			 } else if(htRecord.get("locn_type").equals("E")) {                                                				                     locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					} 
			
				   
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)htRecord.get("appt_ref_no")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)htRecord.get("appt_date")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)htRecord.get("clinic_code")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)htRecord.get("Pract_id")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)htRecord.get("from_time")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)htRecord.get("to_time")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf((String)htRecord.get("resource_class")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)htRecord.get("locn_type")));
            _bw.write(_wl_block71Bytes, _wl_block71);
      
					String referral_id=(String)htRecord.get("referral_id")==null?"":(String)htRecord.get("referral_id") ;
					String appt_ref_no=(String)htRecord.get("appt_ref_no");					
					
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(htRecord.get("reason")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(htRecord.get("Rpractitioner_name")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf((String)htRecord.get("patient_id")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("clinic_code")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("Pract_id")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("q_appt_time")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("appt_type_code")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)htRecord.get("resource_class")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("ordering_facility_id")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("order_id")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("order_line_num")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("order_type_code")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("order_catalog_code")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("order_catalog_desc")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf((String)htRecord.get("Room_num")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)htRecord.get("recur_wo_sec_res")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(htRecord.get("contact_reason_code")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(htRecord.get("locn_type")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(htRecord.get("service_code")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(htRecord.get("multi_speciality_yn")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(htRecord.get("isPractoApptYn")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(htRecord.get("virtualConsultEnable")));
            _bw.write(_wl_block81Bytes, _wl_block81);


					String anch = "<a href = \"javascript:showRefDtls('"+referral_id+"')\">" ;
					
					if(practname.equals("")) practname = "&nbsp;";

					if(referral_id.equals(""))
						anch = "&nbsp;" ;
					else
						anch = anch+referral_id;

					
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(htRecord.get("appt_ref_no")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(htRecord.get("q_appt_time")));
            _bw.write(_wl_block84Bytes, _wl_block84);
	
					
				  /*Below Line Added for this CRF [RUT-CRF-0011]*/
					
					String patcategory="";
					String patientcatcode=checkForNull((String)htRecord.get("patient_cat_code"));				
					if(!patientcatcode.equals("")){
					String patcatquery="select govt_or_pvt_ind from MP_PAT_CATEGORY where PAT_CAT_CODE='"+patientcatcode+"'";
					pstmt1   = con.prepareStatement(patcatquery);				
                    rs1 = pstmt1.executeQuery();
					if(rs1.next())
					patcategory=rs1.getString(1);
					}
				   if (rs1 != null)   rs1.close();
				   if (pstmt1 != null) pstmt1.close();
				  // if(con1!=null)con1.close();
                  //End  CRF [RUT-CRF-0011] 					
					
					if(!htRecord.get("patient_name").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
if(isVIPimgpatfrontappl){if(checkForNull(patcategory).equals("V")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}}
            out.print( String.valueOf(htRecord.get("patient_name")));
            _bw.write(_wl_block55Bytes, _wl_block55);
if(!isVIPimgpatfrontappl){if(checkForNull(patcategory).equals("V")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}}
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("q_patient_id").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(htRecord.get("q_patient_id")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("national_id_no").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(htRecord.get("national_id_no")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("nationality").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(htRecord.get("nationality")==""?"&nbsp;":htRecord.get("nationality")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("oth_contact_no").equals("")){
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(htRecord.get("oth_contact_no")==""?"&nbsp;":htRecord.get("oth_contact_no")));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
	
					if(!htRecord.get("locn_type").equals("")){
					
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(htRecord.get("clinic_desc")));
            _bw.write(_wl_block91Bytes, _wl_block91);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
	
					if(!htRecord.get("resource_desc").equals("")){ 
					
            _bw.write(_wl_block93Bytes, _wl_block93);
if(htRecord.get("resource_desc").equals("Room")){
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(htRecord.get("resource_desc")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf((String)htRecord.get("Rpractitioner_name")));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf((String)htRecord.get("room_desc")));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(htRecord.get("resource_desc")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf((String)htRecord.get("Rpractitioner_name")));
            _bw.write(_wl_block98Bytes, _wl_block98);
}
            _bw.write(_wl_block99Bytes, _wl_block99);
} else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
					
					if(!anch.equals("")){
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(anch));
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
if(isPractoApptApplYN.equals("true") && isSlotStartMidEndAppl){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
if(htRecord.get("isPractoApptYn").equals("Y")){

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block106Bytes, _wl_block106);
}else if(isPractoApptApplYN.equals("true") && !isSlotStartMidEndAppl){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
if(htRecord.get("isPractoApptYn").equals("Y")){

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block106Bytes, _wl_block106);
}
					/*Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
					 if (isVirtualConsultationVisit.equals("true")) {  // added for ML-MMOH-CRF-1930
					
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(htRecord.get("visitTypeShortDesc") ));
            _bw.write(_wl_block109Bytes, _wl_block109);

					}
					}
				} 
            _bw.write(_wl_block110Bytes, _wl_block110);
 htRecord.clear();}
			   
			}
		
            catch(Exception e) { out.println("Exception in res="+e.toString());e.printStackTrace();}
            finally 
            {
                try{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();
                if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();
				sql1.setLength(0);
				}catch(Exception e){}

                if( con != null) ConnectionManager.returnConnection(con,request);            
			
			}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(upt_contact_dtls_oa_yn));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(isUHID_valid_appl));
            _bw.write(_wl_block123Bytes, _wl_block123);
/*Below Line Added for this CRF [RUT-CRF-0011]*/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block124Bytes, _wl_block124);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.waitlistno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.invitationno.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.InvitationDate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.WaitlistCategory.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.AppointmentSource.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BruHealth.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EM.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Practo.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EM.label", java.lang.String .class,"key"));
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
}
