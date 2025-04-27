package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;
import java.io.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __changehomephonenumber extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ChangeHomePhoneNumber.jsp", 1709118594964L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<Script src=\"../../eMP/js/json02.js\"></Script>\n<Script src=\"../../eMP/js/jquery.min.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<form name=\'ChangePatPhone\' id=\'ChangePatPhone\' method=\'post\'\n\t\taction=\'../../servlet/eMP.PatientRegistrationServlet\'\n\t\ttarget=\'messageFrame\'>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\"100%\"\n\t\t\talign=\"center\">\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'24%\'>Patient Id</td>\n\t\t\t\t<td class=\'data\' width=\'24%\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t<td class=\'data\' width=\'24%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t<td class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' width=\'24%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td colspan=2 class=\'data\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\'data\' width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td class=\'data\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td colspan=2>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\n\t\t\t\t<td class=\'data\' width=\'24%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t<td class=\'data\' width=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' style=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" <!-- ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t <td colspan=1 align=\'left\' class=\'data\' >\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t  <td colspan=2 align=\'left\' class=\'data\' >\n\t\t\t   ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" --> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 class=\'data\' width=\'45%\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"BORDER\" colspan=\'4\'>\n\t\t\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\"100%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'6\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"24%\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t<td class=\'data\' width=\"24%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" width=\"24%\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="/";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t<td class=\'data\' width=\"24%\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" /";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"24%\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t<td width=\"24%\" class=\"label\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"label\"><b>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span\n\t\t\t\t\t\tid=\"hiji_date_display\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</span></b> ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t</tr>\n\t\t\t<!--above line added for this CRF MMS-QH-CRF-0145 -->\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"24%\" class=\"label\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t<td class=\'data\' width=\"15%\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t<td class=\'data\' width=\"25%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t<td class=\"data\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t<td class=\"data\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<td class=\"label\" colspan=\'2\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t</tr>\n\n\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="&nbsp;</td>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&nbsp;</td>\n\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&nbsp;</td>\n\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>Contact Modes</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"24%\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<td class=\'data\' width=\"24%\"><input type=\'text\'\n\t\t\t\t\tname=\'contact1_no\' id=\'contact1_no\' size=\'20\' maxlength=\'20\'\n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"></td>\n\t\t\t\t<td class=\"label\" width=\"24%\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t\t<td class=\'data\' width=\"24%\"><input type=\'text\'\n\t\t\t\t\tname=\'contact2_no\' id=\'contact2_no\' size=\'20\' maxlength=\'20\'\n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"></td>\n\n\t\t\t</tr>\n\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'update_phone_no\'>\n\t\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t<input type=\'hidden\' name=\'Patient_id\' id=\'Patient_id\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t<input type=\'hidden\' name=\'old_contact1_no\' id=\'old_contact1_no\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t\t<input type=\'hidden\' name=\'old_contact2_no\' id=\'old_contact2_no\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
try{
	 con = ConnectionManager.getConnection(request);
} catch(Exception e)
{
	e.printStackTrace();

}
String locale			= (String)session.getAttribute("LOCALE");
String patient			= request.getParameter("Patient_ID");
String function_id		= request.getParameter("function_id");
String Facility_Id = (String) session.getValue("facility_id"); 


String disp_dup_pat_dtls=checkForNull(request.getParameter("disp_dup_pat_dtls"));
String group_status=checkForNull(request.getParameter("group_status")) ; 

String Patient_id="";

String Pat_Ser_Grp_Desc ="";
String Pref_Facility_Name ="";
String accept_national_id_no_yn ="";
String nat_id_prompt ="";
String National_Id_No ="";
String accept_oth_alt_id_yn ="";
String demo_oth_alt_id_desc ="";
String demo_oth_alt_id_no ="";
String Alt_Id1_Type ="";
String Alt_Id1_No ="";
String alt_id1_exp_date_accept_yn ="";
String Alt_Id1_Exp_Date ="";
String Alt_Id2_Type ="";
String Alt_Id2_No ="";
String alt_id2_exp_date_accept_yn="";
String Alt_Id2_Exp_Date ="";
String Alt_Id3_Type ="";
String Alt_Id3_No ="";
String alt_id3_exp_date_accept_yn ="";
String Alt_Id3_Exp_Date ="";
String Alt_Id4_Type ="";
String Alt_Id4_No ="";
String alt_id4_exp_date_accept_yn ="";
String Alt_Id4_Exp_Date ="";
String family_org_id_accept_yn ="";
String MembershipType ="";
String header_width="25%";	
String data_width ="25%";
String data_word_wrap="";
String Orgsubname ="";
String Orgname ="";
String Family_No_Link_Yn="";
String Family_Link_No="";
String head_patient_name="";
String Relationship_Name="";

String First_Name_Accept_Yn ="";
int First_Name_Order=0;
String First_Name_Prompt ="";
String Second_Name_Accept_Yn ="";
int Second_Name_Order =0;
String Second_Name_Prompt ="";
String Third_Name_Accept_Yn ="";
int Third_Name_Order =0;
String Third_Name_Prompt ="";
String Family_Name_Accept_Yn ="";
int Family_Name_Order =0;
String Family_Name_Prompt ="";
String Name_Suffix_Accept_Yn ="";
String Name_Suffix_Prompt ="";
String Name_Prefix_Accept_Yn = "";
String Name_Prefix_Prompt = "";

String Name_Prefix     ="";
String First_Name      ="";
String Second_Name    ="";
String Third_Name     ="";
String Family_Name    ="";
String Name_Suffix   ="";

String names_in_oth_lang_yn="";
String language_direction="";

String name_prefix_loc_lang_prompt  ="" ;
String first_name_loc_lang_prompt   ="" ;
String second_name_loc_lang_prompt  ="" ;
String third_name_loc_lang_prompt   ="" ;
String family_name_loc_lang_prompt  ="" ;
String name_suffix_loc_lang_prompt  ="" ;

String name_prefix_loc_lang  =""   ;
String first_name_loc_lang      =""  ;
String second_name_loc_lang=""    ; 
String third_name_loc_lang    =""    ;
String family_name_loc_lang  =""   ;
String name_suffix_loc_lang   =""  ;
String patient_name_loc_lang=""    ;

String Sex          ="";
String blood_grp_desc="";
String rh_factor_desc="";
String age_value = "";
String Date_Of_Birth  ="";
String Place_Of_Birth ="";
String hijri_birth_date="";
Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");

String Mar_Status_Desc="";
String birth_place_code="";
String birth_place_desc="";
String Pat_Cat_Desc="";
String entitlement_by_pat_cat_yn="";
String patexpirtydate="";
String citizen_yn="";
String legal_yn="";
String Nationality_Desc="";
String race_long_desc="";
String ethnic_long_desc="";
String Relgn_Desc="";
String language_name="";
String Alias_Name="";

String data_source="";
String Age="";

String Prn_Tel_No="";
String Orn_Tel_No="";
String contactModeOne="";
String contactModeTwo="";
String old_Prn_Tel_No="";
String old_Orn_Tel_No="";

StringBuffer sql=new StringBuffer();
PreparedStatement pstmt = null;
ResultSet rs=null;

sql.append("SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type, Alt_Id2_type, Alt_Id3_type, Alt_Id4_type, nvl(First_Name_Accept_Yn,'N') First_Name_Accept_Yn , nvl(First_Name_Order,'0') First_Name_Order, nvl(First_Name_Prompt,'First Name') First_Name_Prompt, nvl(Second_Name_Accept_Yn,'N') Second_Name_Accept_Yn, nvl(Second_Name_Order,'0') Second_Name_Order, nvl(Second_Name_Prompt,'Second Name') Second_Name_Prompt, nvl(Third_Name_Accept_Yn,'N') Third_Name_Accept_Yn, nvl(Third_Name_Order,'0') Third_Name_Order, nvl(Third_Name_Prompt,'Third Name') Third_Name_Prompt, nvl(Family_Name_Accept_Yn,'N') Family_Name_Accept_Yn, nvl(Family_Name_Order,'0') Family_Name_Order, nvl(Family_Name_Prompt,'Family Name') Family_Name_Prompt, name_dervn_logic, nvl(Alt_Id1_length,'0') Alt_Id1_length, nvl(Alt_Id2_length,'0') Alt_Id2_length, nvl(Alt_Id3_length,'0') Alt_Id3_length, nvl(Alt_Id4_length,'0') Alt_Id4_length, nvl(name_suffix_accept_yn,'N') name_suffix_accept_yn, nvl(name_prefix_accept_yn,'N') name_prefix_accept_yn, nvl(name_suffix_prompt,'Name Suffix') name_suffix_prompt, nvl(name_prefix_prompt,'Name Prefix') name_prefix_prompt, nvl(first_name_reqd_yn,'N') first_name_reqd_yn, nvl(second_name_reqd_yn,'N') second_name_reqd_yn, nvl(third_name_reqd_yn,'N') third_name_reqd_yn, nvl(family_name_reqd_yn,'N') family_name_reqd_yn, nvl(name_suffix_reqd_yn,'N') name_suffix_reqd_yn, nvl(name_prefix_reqd_yn,'N') name_prefix_reqd_yn, nvl(family_no_link_yn,'N') family_no_link_yn, nvl(patient_id_length,0) patient_id_length, nvl(citizen_nationality_code,'') citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N') Alt_Id1_Unique_yn, nvl(Alt_Id2_Unique_yn,'N') Alt_Id2_Unique_yn, nvl(Alt_Id3_Unique_yn,'N') Alt_Id3_Unique_yn, nvl(Alt_Id4_Unique_yn,'N') Alt_Id4_Unique_yn, nat_id_length, nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N') ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, alt_id1_routine_yn, alt_id1_data_source_id alt_id1_routine, alt_id2_routine_yn, alt_id2_data_source_id alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NAT_ID_PAT_SER_GRP, nvl(ID_CHANGE_ALLOWED_FOR_SERIES,'*') ID_CHANGE_ALLOWED_FOR_SERIES, nvl(ADDL_FIELD1_PROMPT,'') ADDL_FIELD1_PROMPT, nvl(ADDL_FIELD1_LENGTH,'0') ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'') ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'') ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0') ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'') ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'') ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0') ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'') ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'') ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0') ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'') ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'') ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0') ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'') ADDL_FIELD5_SECTION, nvl(nat_id_prompt,'National Id No') nat_id_prompt, nvl(NAT_ID_CHK_LEN,'N') NAT_ID_CHK_LEN, nat_id_check_digit_id,  alt_id1_chk_digit_scheme, alt_id2_chk_digit_scheme, alt_id3_chk_digit_scheme, alt_id4_chk_digit_scheme, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'&nbsp;') FIRST_NAME_LOC_LANG_PROMPT, nvl(SECOND_NAME_LOC_LANG_PROMPT,'&nbsp;') SECOND_NAME_LOC_LANG_PROMPT, nvl(THIRD_NAME_LOC_LANG_PROMPT,'&nbsp;') THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'&nbsp;') FAMILY_NAME_LOC_LANG_PROMPT, nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_SUFFIX_LOC_LANG_PROMPT, accept_national_id_no_yn, alt_id1_accept_oth_pat_ser_yn, alt_id1_accept_alphanumeric_yn, invoke_routine, nat_data_source_id, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn, nat_id_reqd_all_series, Accept_oth_alt_id_yn, alt_id1.long_desc alt_id1_desc, alt_id2.long_desc alt_id2_desc, alt_id3.long_desc alt_id3_desc, alt_id4.long_desc alt_id4_desc, ext_system_interface_yn, default_race_code, names_in_oth_lang_yn, to_char(sysdate,'dd/mm/yyyy') ServerDate, dflt_alt_id1_in_emp_id_yn, nb_mother_cutoff_age,create_file_yn,maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn FROM mp_param_lang_vw, mp_alternate_id_type_lang_vw alt_id1, mp_alternate_id_type_lang_vw alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id(+) = '"+locale+"' and alt_id2.language_id(+) = '"+locale+"' and alt_id3.language_id(+) = '"+locale+"' and alt_id4.language_id(+) = '"+locale+"' and mp_param_lang_vw.language_id = '"+locale+"'" );

pstmt = con.prepareStatement(sql.toString());
rs=pstmt.executeQuery(); 

if(rs != null) {
    if(rs.next()) {
        Alt_Id1_Type = rs.getString("Alt_Id1_Type")==null ? "" : rs.getString("alt_id1_desc");
        Alt_Id2_Type = rs.getString("Alt_Id2_Type")==null ? "" : rs.getString("alt_id2_desc");
        Alt_Id3_Type = rs.getString("Alt_Id3_Type")==null ? "" : rs.getString("alt_id3_desc");
        Alt_Id4_Type = rs.getString("Alt_Id4_Type")==null ? "" : rs.getString("alt_id4_desc");
		
		alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn")==null ? "" : rs.getString("alt_id1_exp_date_accept_yn");

		alt_id2_exp_date_accept_yn = rs.getString("alt_id2_exp_date_accept_yn")==null ? "" : rs.getString("alt_id2_exp_date_accept_yn");
			
		alt_id3_exp_date_accept_yn = rs.getString("alt_id3_exp_date_accept_yn")==null ? "" : rs.getString("alt_id3_exp_date_accept_yn");

		alt_id4_exp_date_accept_yn = rs.getString("alt_id4_exp_date_accept_yn")==null ? "" : rs.getString("alt_id4_exp_date_accept_yn");

		accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "" : rs.getString("accept_oth_alt_id_yn");
		names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null ? "N" : rs.getString("names_in_oth_lang_yn");

		First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
        First_Name_Order = rs.getInt("First_Name_Order");
        First_Name_Prompt = rs.getString("First_Name_Prompt") == null ? "" : rs.getString("First_Name_Prompt");
        Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
        Second_Name_Order = rs.getInt("Second_Name_Order");
        Second_Name_Prompt = rs.getString("Second_Name_Prompt") == null ? "" : rs.getString("Second_Name_Prompt");
        Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
        Third_Name_Order = rs.getInt("Third_Name_Order");
        Third_Name_Prompt = rs.getString("Third_Name_Prompt") == null ? "" : rs.getString("Third_Name_Prompt");
        Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
        Family_Name_Order = rs.getInt("Family_Name_Order");
        Family_Name_Prompt = rs.getString("Family_Name_Prompt")== null ? "" : rs.getString("Family_Name_Prompt");

        Name_Prefix_Accept_Yn = rs.getString("Name_Prefix_Accept_Yn");
        Name_Suffix_Accept_Yn = rs.getString("Name_Suffix_Accept_Yn");
        Name_Prefix_Prompt = rs.getString("Name_Prefix_Prompt");
        Name_Suffix_Prompt = rs.getString("Name_Suffix_Prompt");

        Family_No_Link_Yn = rs.getString("family_no_link_yn");
        
        /* cust_fields[0] = rs.getString("addl_field1_section")+"`"+rs.getString("ADDL_FIELD1_PROMPT");
        cust_fields[1] = rs.getString("addl_field2_section")+"`"+rs.getString("ADDL_FIELD2_PROMPT");
        cust_fields[2] = rs.getString("addl_field3_section")+"`"+rs.getString("ADDL_FIELD3_PROMPT");
        cust_fields[3] = rs.getString("addl_field4_section")+"`"+rs.getString("ADDL_FIELD4_PROMPT");
        cust_fields[4] = rs.getString("addl_field5_section")+"`"+rs.getString("ADDL_FIELD5_PROMPT"); */
        nat_id_prompt = rs.getString("nat_id_prompt");
        
        name_prefix_loc_lang_prompt     =rs.getString("name_prefix_loc_lang_prompt");
        first_name_loc_lang_prompt      =rs.getString("first_name_loc_lang_prompt");
        second_name_loc_lang_prompt     =rs.getString("second_name_loc_lang_prompt");
        third_name_loc_lang_prompt      =rs.getString("third_name_loc_lang_prompt");
        family_name_loc_lang_prompt     =rs.getString("family_name_loc_lang_prompt");
        name_suffix_loc_lang_prompt     =rs.getString("name_suffix_loc_lang_prompt");
        /* doc_or_file						=rs.getString("maintain_doc_or_file"); */
		
		//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
		/* create_file_yn					=rs.getString("create_file_yn"); */
		
		
        accept_national_id_no_yn		=rs.getString("accept_national_id_no_yn");
        family_org_id_accept_yn			=rs.getString("family_org_id_accept_yn")==null?"":rs.getString("family_org_id_accept_yn");
        entitlement_by_pat_cat_yn		=rs.getString("entitlement_by_pat_cat_yn")==null?"":rs.getString("entitlement_by_pat_cat_yn");	
    }
}

StringBuffer sql2=new StringBuffer();
sql2.append("SELECT patient.patient_name Patient_Name, patient.MYHIX_ID unique_no , patient.pat_ser_grp_code pat_ser_grp_code, (CASE WHEN patient.pat_ser_grp_code IS NOT NULL THEN (mp_get_desc.mp_pat_ser_grp(patient.pat_ser_grp_code,'"+locale+"',2)) END ) pat_ser_grp_desc, NVL(pat_ser_grp.ID_TYPE, '') ID_TYPE, pat_ser_grp.allow_family_no_yn, pat_ser_grp.pat_name_in_loc_lang_reqd_yn, patient.national_id_no national_id_no, patient.pref_facility_id pref_facility_id, (CASE WHEN patient.pref_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.pref_facility_id, '"+locale+"', 1)) END ) pref_facility_name, patient.regn_facility_id regn_facility_id, (CASE WHEN patient.regn_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.regn_facility_id, '"+locale+"', 1)) END ) regn_facility_name, patient.alt_id1_type alt_id1_type, (CASE WHEN patient.alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id1_type,'"+locale+"',1)) END ) alt_id1_desc, patient.alt_id1_no alt_id1_no, to_char(patient.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, patient.alt_id2_type alt_id2_type, (CASE WHEN patient.alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id2_type,'"+locale+"',2)) END ) alt_id2_desc, patient.alt_id2_no alt_id2_no, to_char(patient.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, patient.alt_id3_type alt_id3_type, (CASE WHEN patient.alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id3_type,'"+locale+"',2)) END ) alt_id3_desc, patient.alt_id3_no alt_id3_no, to_char(patient.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, patient.alt_id4_type alt_id4_type, (CASE WHEN patient.alt_id4_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id4_type,'"+locale+"',2)) END ) alt_id4_desc, patient.alt_id4_no alt_id4_no, to_char(patient.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, patient.oth_alt_id_type oth_alt_id_type, (CASE WHEN patient.oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.oth_alt_id_type,'"+locale+"',1)) END ) demo_oth_alt_id_desc, patient.oth_alt_id_no demo_oth_alt_id_no, patient.family_link_no family_link_no, (CASE WHEN patient.family_link_no IS NOT NULL THEN (mp_get_desc.mp_patient(patient.family_link_no,1)) END ) head_patient_name, patient.relationship_to_head relationship_to_head, (CASE WHEN patient.relationship_to_head IS NOT NULL THEN (mp_get_desc.mp_relationship(patient.relationship_to_head,'"+locale+"',2)) END ) relationship_name, patient.name_prefix name_prefix, patient.first_name first_name, patient.second_name second_name, patient.third_name third_name, patient.family_name family_name, patient.name_suffix name_suffix, patient.name_prefix_loc_lang name_prefix_loc_lang, patient.first_name_loc_lang first_name_loc_lang, patient.second_name_loc_lang second_name_loc_lang, patient.third_name_loc_lang third_name_loc_lang, patient.family_name_loc_lang family_name_loc_lang, patient.name_suffix_loc_lang name_suffix_loc_lang, patient.patient_name_loc_lang patient_name_loc_lang, patient.sex sex, to_char(patient.date_of_birth, 'dd/mm/yyyy') date_of_birth, patient.calculated_age_yn calculated_age_yn, patient.birth_place_code birth_place_code, (CASE WHEN patient.birth_place_code IS NOT NULL THEN (mp_get_desc.mp_birth_place(patient.birth_place_code,'"+locale+"',1))  END ) birth_place_desc, patient.place_of_birth place_of_birth, patient.mar_status_code mar_status_code, (CASE WHEN patient.mar_status_code IS NOT NULL THEN (mp_get_desc.mp_marital_status(patient.mar_status_code,'"+locale+"',2)) END ) mar_status_desc, patient.alias_name alias_name, patient.relgn_code relgn_code, (CASE WHEN patient.relgn_code IS NOT NULL THEN (mp_get_desc.mp_religion(patient.relgn_code,'"+locale+"',2)) END ) relgn_desc, patient.ethnic_grp_code ethnic_grp_code, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',2)) END ) ethnic_short_desc, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',1)) END ) ethnic_long_desc, patient.race_code race_code, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',2)) END ) race_short_desc, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',1)) END ) race_long_desc, patient.citizen_yn CITIZEN_YN, patient.legal_yn LEGAL_YN, patient.nationality_code nationality_code, (CASE WHEN patient.nationality_code IS NOT NULL THEN (mp_get_desc.mp_country(patient.nationality_code,'"+locale+"',3)) END ) nationality_desc, patient.mother_maiden_name mother_maiden_name, patient.pat_cat_code pat_cat_code, (CASE WHEN patient.pat_cat_code IS NOT NULL THEN (mp_get_desc.mp_pat_category(patient.pat_cat_code,'"+locale+"',2)) END ) pat_cat_desc, patient.referral_facility_id referral_facility_id, patient.ref_source_code ref_source_code, NULL ref_source_desc, pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal1_code,'"+locale+"',2) resi_postal_code, pat_addr.country1_code resi_country_code, (CASE WHEN pat_addr.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country1_code,'"+locale+"',1)) END ) resi_country_name, pat_addr.invalid1_yn resi_invalid1_yn, pat_addr.contact1_name resi_contact1_name, patient.res_area_code res_area_code, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',2)) END ) res_area_desc, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',1)) END ) res_area_long_desc, patient.res_town_code res_town_code, (CASE WHEN patient.res_town_code IS NOT NULL  THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',2)) END ) res_town_desc, (CASE WHEN patient.res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',1)) END ) res_town_long_desc, patient.region_code region_code, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',2)) END ) region_desc, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',1)) END ) region_long_desc, pat_addr.addr2_line1 mail_addr_line1, pat_addr.addr2_line2 mail_addr_line2, pat_addr.addr2_line3 mail_addr_line3, pat_addr.addr2_line4 mail_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal2_code,'"+locale+"',2) mail_postal_code, pat_addr.country2_code mail_country_code, (CASE WHEN pat_addr.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country2_code,'"+locale+"',1)) END ) mail_country_name, pat_addr.invalid2_yn mail_invalid1_yn, pat_addr.contact2_name mail_contact1_name, pat_addr.res_area2_code mail_res_area, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',2)) END ) mail_res_area_desc, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',1)) END ) mail_res_area_long_desc, pat_addr.res_town2_code mail_res_town, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',2)) END ) mail_res_town_desc, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',1))            END ) mail_res_town_long_desc, pat_addr.region2_code mail_region_code, (CASE WHEN pat_addr.region2_code IS NOT NULL  THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',2)) END ) mail_region_desc, (CASE WHEN pat_addr.region2_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',1)) END ) mail_region_long_desc, patient.contact1_no prn_tel_no, patient.contact2_no orn_tel_no, patient.email_id email_id, patient.contact3_mode contact3_mode, (CASE WHEN patient.contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact3_mode,'"+locale+"',2)) END ) contact3_mode_desc, patient.contact3_no contact3_no, patient.contact4_mode contact4_mode, (CASE WHEN patient.contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact4_mode,'"+locale+"',2)) END ) contact4_mode_desc, patient.contact4_no contact4_no, patient.contact5_mode contact5_mode, (CASE WHEN patient.contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact5_mode,'"+locale+"',2)) END ) contact5_mode_desc, patient.contact5_no contact5_no, pat_rl_con.contact1_name nkin_contact_name, pat_rl_con.job1_title nkin_job_title, pat_rl_con.contact1_relation nkin_contact_relation, (CASE WHEN pat_rl_con.contact1_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact1_relation,'"+locale+"',2)) END ) nkin_contact_relation_desc,  to_char(pat_rl_con.contact1_birth_date, 'dd/mm/yyyy') contact1_birth_date, pat_rl_con.contact1_nat_id_no, pat_rl_con.contact1_alt_id1_type, (CASE WHEN pat_rl_con.contact1_alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id1_type,'"+locale+"',2)) END ) nkin_alt_id1_desc, pat_rl_con.contact1_alt_id1_no, pat_rl_con.contact1_alt_id2_type, (CASE WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id2_type,'"+locale+"',2)) END ) nkin_alt_id2_desc, pat_rl_con.contact1_alt_id2_no, pat_rl_con.contact1_alt_id3_type, (CASE WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id3_type,'"+locale+"',2)) END ) nkin_alt_id3_desc,  pat_rl_con.contact1_alt_id3_no, pat_rl_con.contact1_alt_id4_type, (CASE WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id4_type,'"+locale+"',2)) END ) nkin_alt_id4_desc, pat_rl_con.contact1_alt_id4_no, pat_rl_con.contact1_oth_alt_id_type, (CASE WHEN pat_rl_con.contact1_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_oth_alt_id_type,'"+locale+"',1)) END ) nkin_oth_alt_desc, pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no, pat_rl_con.addr1_line1 nkin_addr_line1,  pat_rl_con.addr1_line2 nkin_addr_line2, pat_rl_con.addr1_line3 nkin_addr_line3, pat_rl_con.addr1_line4 nkin_addr_line4, pat_rl_con.contact1_res_town_code, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',2)) END ) nkin_town_desc, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',1)) END ) nkin_town_long_desc, pat_rl_con.contact1_res_area_code, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',2)) END ) nkin_area_desc, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',1)) END ) nkin_area_long_desc, pat_rl_con.contact1_region_code, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',2)) END ) nkin_region_desc, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',1)) END ) nkin_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal1_code,'"+locale+"',2)  nkin_postal_code, pat_rl_con.country1_code nkin_country_code, (CASE WHEN pat_rl_con.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country1_code,'"+locale+"',1))  END ) nkin_country_name, pat_rl_con.res1_tel_no nkin_res_tel_no, pat_rl_con.off1_tel_no nkin_off_tel_no, pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no, pat_rl_con.contact1_email_id nkin_email_id, pat_rl_con.contact2_relation fton_contact_relation, (CASE WHEN pat_rl_con.contact2_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact2_relation,'"+locale+"',2)) END ) fton_contact_relation_desc,  pat_rl_con.contact2_name fton_contact_name, pat_rl_con.contact2_nat_id_no fton_nat_id_no, pat_rl_con.contact2_oth_alt_id_type, (CASE WHEN pat_rl_con.contact2_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact2_oth_alt_id_type,'"+locale+"',1)) END ) fton_alt_desc, pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no, pat_rl_con.job2_title fton_job_title, pat_rl_con.addr2_line1 fton_addr_line1, pat_rl_con.addr2_line2 fton_addr_line2, pat_rl_con.addr2_line3 fton_addr_line3, pat_rl_con.addr2_line4 fton_addr_line4, pat_rl_con.contact2_res_town_code, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',2)) END ) fton_town_desc, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',1)) END ) fton_town_long_desc, pat_rl_con.contact2_res_area_code, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',2)) END ) fton_area_desc, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',1)) END ) fton_area_long_desc, pat_rl_con.contact2_region_code, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',2)) END ) fton_region_desc, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',1)) END ) fton_region_long_desc, mp_get_desc.mp_postal_code(pat_rl_con.postal2_code,'"+locale+"',2) fton_postal_code, pat_rl_con.country2_code fton_country_code,          (CASE WHEN pat_rl_con.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country2_code,'"+locale+"',1)) END ) fton_country_name, pat_rl_con.contact2_mob_tel_no fton_mob_tel_no, pat_rl_con.contact2_email_id fton_email_id, pat_rl_con.res2_tel_no fton_res_tel_no, pat_rl_con.off2_tel_no fton_off_tel_no, pat_rl_con.organization_name,   pat_rl_con.patient_employee_id patient_employee_id,pat_rl_con.employment_status employment_status, pat_rl_con.contact3_name emplr_contact_name, pat_rl_con.job3_title emplr_job_title, pat_rl_con.contact3_relation emplr_contact_relation, (CASE WHEN pat_rl_con.contact3_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact3_relation,'"+locale+"',2)) END ) emplr_contact_relation_desc,           pat_rl_con.ocpn_class_code, (CASE WHEN pat_rl_con.ocpn_class_code IS NOT NULL THEN (mp_get_desc.mp_occupation_class(pat_rl_con.ocpn_class_code,'"+locale+"',1)) END ) emplr_ocpn_class_desc,           pat_rl_con.ocpn_code ocpn_code, (CASE WHEN pat_rl_con.ocpn_code IS NOT NULL THEN (mp_get_desc.mp_occupation(pat_rl_con.ocpn_code,'"+locale+"',2))  ELSE ocpn_desc END ) occupation_desc,   pat_rl_con.addr3_line1 emplr_addr_line1, pat_rl_con.addr3_line2 emplr_addr_line2, pat_rl_con.addr3_line3 emplr_addr_line3,  pat_rl_con.addr3_line4 emplr_addr_line4, pat_rl_con.contact3_res_town_code, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',2)) END ) emplr_town_desc, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',1)) END ) emplr_town_long_desc, pat_rl_con.contact3_res_area_code, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',2)) END ) emplr_area_desc, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',1)) END ) emplr_area_long_desc, pat_rl_con.contact3_region_code, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',2)) END ) emplr_region_desc, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',1))    END ) emplr_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal3_code,'"+locale+"',2)  emplr_postal_code, pat_rl_con.country3_code emplr_country_code, (CASE WHEN pat_rl_con.country3_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country3_code,'"+locale+"',1))            END ) emplr_country_name, pat_rl_con.off3_tel_no emplr_off_tel_no, pat_rl_con.res3_tel_no emplr_res_tel_no, pat_rl_con.off_fax_no off_fax_no,pat_oth_dtls.living_dependency living_dependency, pat_oth_dtls.living_arrangement living_arrangement, mr_get_desc.mr_blood_grp(pat_oth_dtls.blood_grp,'"+locale+"',2) blood_grp_desc, mr_get_desc.mr_rhesus_factor(pat_oth_dtls.rh_factor,'"+locale+"',2) rh_factor_desc, pat_oth_dtls.education_level education_level, (CASE WHEN pat_oth_dtls.education_level IS NOT NULL THEN (mp_get_desc.mp_education_level(pat_oth_dtls.education_level,'"+locale+"',2)) END ) educ_level_desc, pat_oth_dtls.regn_informant informant, pat_oth_dtls.regn_comments informant_remarks, pat_oth_dtls.general_remarks general_remarks, patient.suspend_yn suspend_yn ,patient.hijri_birth_date hijri_birth_date, patient.status_reason_code status_reason_code, (CASE WHEN patient.status_reason_code IS NOT NULL THEN (mp_get_desc.mp_pat_susp_reason(patient.status_reason_code,'"+locale+"',2)) END ) status_reason_desc, patient.status_remarks status_remarks, patient.active_yn active_yn, to_char(patient.last_contact_date,'dd/mm/yyyy') last_contact_date, patient.deceased_yn deceased_yn, to_char(patient.deceased_date,'dd/mm/yyyy') deceased_date, patient.death_status_remarks death_status_remarks, patient.primary_language_id primary_language_id, patient.language_id pat_language_id,(CASE WHEN patient.language_id IS NOT NULL THEN (mp_get_desc.mp_language(patient.language_id,'"+locale+"',1)) END ) language_name,  pat_oth_dtls.addl_field1 addl_field1, (CASE WHEN pat_oth_dtls.addl_field1 IS NOT NULL THEN (SELECT addl_field1_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field1_prompt, (CASE WHEN pat_oth_dtls.addl_field2 IS NOT NULL THEN (SELECT addl_field2_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field2_prompt, pat_oth_dtls.addl_field2 addl_field2, (CASE WHEN pat_oth_dtls.addl_field3 IS NOT NULL THEN (SELECT addl_field3_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field3_prompt, pat_oth_dtls.addl_field3 addl_field3, (CASE WHEN pat_oth_dtls.addl_field4 IS NOT NULL THEN (SELECT addl_field4_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field4_prompt, pat_oth_dtls.addl_field4 addl_field4, (CASE WHEN pat_oth_dtls.addl_field5 IS NOT NULL THEN (SELECT addl_field5_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field5_prompt, pat_oth_dtls.addl_field5 addl_field5, patient.added_by_id, (CASE WHEN patient.added_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.added_by_id,'"+locale+"',1)) END ) added_user_name, TO_CHAR (patient.added_date, 'DD/MM/YYYY HH24:MI') added_date, patient.added_at_ws_no, patient.added_facility_id, (CASE WHEN patient.added_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.added_facility_id, '"+locale+"', 1))  END ) added_facility_name, patient.modified_by_id, (CASE WHEN patient.modified_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.modified_by_id,'"+locale+"',1)) END ) modified_user_name, TO_CHAR (patient.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, patient.modified_at_ws_no, patient.modified_facility_id, (CASE WHEN patient.modified_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.modified_facility_id, '"+locale+"', 1))END ) modified_facility_name, patient.pat_dtls_unknown_yn, patient.inhouse_birth_yn, patient.data_source data_source, MP_GET_AGE_YMDH(patient.date_of_birth,patient.deceased_date) age,/*  CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),1)||'Y'|| CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),2)||'M'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),3)||'D'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),4)||'H' age,*/ patient.FAMILY_ORG_MEMBERSHIP MembershipType, ( case when patient.FAMILY_ORG_SUB_ID is not null then (select FAMILY_ORG_SUB_NAME from mp_family_org_sub_lang_vw where FAMILY_ORG_ID = patient.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID= patient.FAMILY_ORG_SUB_ID and language_id = '"+locale+"') end) Orgsubname, (case when patient.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_lang_vw where FAMILY_ORG_ID= patient.FAMILY_ORG_ID and language_id = '"+locale+"') end) Orgname, to_char(patient.PAT_CAT_CODE_EXP_DATE,'dd/mm/yyyy') patexpirtydate, ");  

if(group_status.equals("")) {   
	  if(disp_dup_pat_dtls.equals("Duplicate")) {
		    sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	  } else {
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
			sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");
	  }
} else if(!group_status.equals("")) {
	if(disp_dup_pat_dtls.equals("Duplicate") && group_status.equals("S") ) {
			 sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	} else {
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
		  sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f  WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");	
	       
	}
}

 pstmt = con.prepareStatement(sql2.toString());
 pstmt.setString(1, patient); 
rs=pstmt.executeQuery(); 

if(rs != null) {
    if(rs.next()) {
   	Patient_id=rs.getString("Patient_id");
 	  //Added for MMS-QH-CRF-0145
 	  
	hijri_birth_date =rs.getString("hijri_birth_date"); 
	if(hijri_birth_date==null)hijri_birth_date=""; 
  	
  	citizen_yn=rs.getString("CITIZEN_YN");
	legal_yn=rs.getString("LEGAL_YN");

	if (citizen_yn == null) citizen_yn="&nbsp; ";
	if (legal_yn == null) legal_yn="&nbsp; ";
	
	Pat_Ser_Grp_Desc  =rs.getString("pat_ser_grp_desc") ;
	
	National_Id_No  =rs.getString("national_id_no");
	National_Id_No = eXH.XHUtil.getNationalID(Patient_id);
	if(National_Id_No ==null)National_Id_No ="&nbsp; ";

	Pref_Facility_Name =rs.getString("pref_facility_name");
    if(Pref_Facility_Name==null)Pref_Facility_Name="&nbsp; "; 

     Alt_Id1_No    =rs.getString("alt_id1_no") ;
    if(Alt_Id1_No ==null){Alt_Id1_No ="&nbsp; ";}

    Alt_Id1_Exp_Date  =rs.getString("alt_id1_exp_date");
	if(Alt_Id1_Exp_Date!=null){
		Alt_Id1_Exp_Date=DateUtils.convertDate(Alt_Id1_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id1_Exp_Date="&nbsp;";
		
		
	Alt_Id2_No   =rs.getString("alt_id2_no");
    if(Alt_Id2_No==null){Alt_Id2_No="&nbsp; ";}

    Alt_Id2_Exp_Date =rs.getString("alt_id2_exp_date");
  	if(Alt_Id2_Exp_Date!=null){
		Alt_Id2_Exp_Date=DateUtils.convertDate(Alt_Id2_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id2_Exp_Date="&nbsp;";

    Alt_Id3_No     =rs.getString("alt_id3_no");
    if(Alt_Id3_No ==null){Alt_Id3_No ="&nbsp; ";}

    Alt_Id3_Exp_Date  =rs.getString("alt_id3_exp_date");

	if(Alt_Id3_Exp_Date!=null){
		Alt_Id3_Exp_Date=DateUtils.convertDate(Alt_Id3_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id3_Exp_Date="&nbsp;";

    Alt_Id4_No     =rs.getString("alt_id4_no");
    if(Alt_Id4_No  ==null){Alt_Id4_No  ="&nbsp; ";}
	

    Alt_Id4_Exp_Date =rs.getString("alt_id4_exp_date");
	if(Alt_Id4_Exp_Date!=null){
		Alt_Id4_Exp_Date=DateUtils.convertDate(Alt_Id4_Exp_Date,"DMY","en",locale); 
	}
	else
		Alt_Id4_Exp_Date="&nbsp;"; 
		
	Family_Link_No    =rs.getString("family_link_no");
    if(Family_Link_No ==null)Family_Link_No ="&nbsp; ";
    
    Relationship_Name  =rs.getString("relationship_name");
    if(Relationship_Name==null)Relationship_Name="&nbsp; ";
    
    Name_Prefix     =rs.getString("name_prefix");
    if(Name_Prefix ==null)Name_Prefix ="&nbsp; ";

    First_Name      =rs.getString("first_name");
    if(First_Name==null)First_Name="&nbsp; ";

    Second_Name    =rs.getString("second_name");

    if(Second_Name==null)Second_Name="&nbsp; ";

    Third_Name     =rs.getString("third_name");
    if(Third_Name ==null)Third_Name ="&nbsp; ";

    Family_Name    =rs.getString("family_name");
    if(Family_Name==null)Family_Name="&nbsp; ";

    Name_Suffix   =rs.getString("name_suffix");
    if(Name_Suffix ==null)Name_Suffix ="&nbsp; ";

    name_prefix_loc_lang   =rs.getString("name_prefix_loc_lang");
    if(name_prefix_loc_lang ==null)name_prefix_loc_lang ="&nbsp; ";

    first_name_loc_lang   =rs.getString("first_name_loc_lang");
    if(first_name_loc_lang ==null)first_name_loc_lang =" &nbsp;";

    second_name_loc_lang   =rs.getString("second_name_loc_lang");
    if(second_name_loc_lang ==null)second_name_loc_lang =" &nbsp;";

    third_name_loc_lang   =rs.getString("third_name_loc_lang");
    if(third_name_loc_lang ==null)third_name_loc_lang =" &nbsp;";

    family_name_loc_lang   =rs.getString("family_name_loc_lang");
   
	if(family_name_loc_lang ==null)family_name_loc_lang ="&nbsp; ";

    name_suffix_loc_lang   =rs.getString("name_suffix_loc_lang");
    if(name_suffix_loc_lang ==null)name_suffix_loc_lang =" &nbsp;";

    patient_name_loc_lang   =rs.getString("patient_name_loc_lang");
    if(patient_name_loc_lang ==null)patient_name_loc_lang =" &nbsp;";
    
    head_patient_name = rs.getString("head_patient_name");
    if(head_patient_name == null)   head_patient_name = "&nbsp;" ;
    
    race_long_desc = rs.getString("race_long_desc");
    if(race_long_desc == null)   race_long_desc = "&nbsp;" ;
    
    ethnic_long_desc = rs.getString("ethnic_long_desc");
    if(ethnic_long_desc == null)   ethnic_long_desc = "&nbsp;" ;
    
    Sex          =rs.getString("sex");
    if(Sex==null)Sex="";

	blood_grp_desc = rs.getString("blood_grp_desc");
	if(blood_grp_desc==null)
		blood_grp_desc="&nbsp; ";
		
	rh_factor_desc = rs.getString("rh_factor_desc");
	if(rh_factor_desc==null)
		rh_factor_desc="&nbsp; ";


    Date_Of_Birth  =rs.getString("date_of_birth");
    if(Date_Of_Birth==null){
		Date_Of_Birth=""; 
    }
	else 
	{
		Date_Of_Birth=Date_Of_Birth.substring(0,10);
		Date_Of_Birth=DateUtils.convertDate(Date_Of_Birth,"DMY","en",locale); 
	}
    
    Place_Of_Birth =rs.getString("place_of_birth");
    if(Place_Of_Birth==null)Place_Of_Birth="";

	birth_place_code = rs.getString("birth_place_code");
	if(birth_place_code==null)birth_place_code="";

	birth_place_desc = rs.getString("birth_place_desc");
	if(birth_place_desc==null) birth_place_desc="";
	
	Alias_Name   =rs.getString("alias_name");
    if(Alias_Name ==null)Alias_Name ="";

    Relgn_Desc   =rs.getString("relgn_desc");
    if(Relgn_Desc ==null)Relgn_Desc ="";

    Nationality_Desc  =rs.getString("nationality_desc");
    if(Nationality_Desc ==null)Nationality_Desc ="";

	language_name = rs.getString("language_name");
	if(language_name==null)language_name="";

    Pat_Cat_Desc    =rs.getString("pat_cat_desc");
    if(Pat_Cat_Desc  ==null)Pat_Cat_Desc  ="";

    data_source = rs.getString("data_source");
	if (data_source==null) data_source="";
	Age = rs.getString("age");
	if (Age==null) Age="";

    
	
	if(!Age.equals("")) {

		StringTokenizer st = new StringTokenizer(Age," ");

			while ( st.hasMoreTokens() ) {

						String date_elmnt = st.nextToken();						

						char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);							

						String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));				

						if(ymdh_char=='Y') {
							if(!ymdh_elmnt.equals("0"))
								age_value = age_value+ymdh_elmnt+"Y ";								
						} else if (ymdh_char=='M') {
							if(!ymdh_elmnt.equals("0"))
								age_value = age_value+ymdh_elmnt+"M ";								
						} else if (ymdh_char=='D') {
							if(!ymdh_elmnt.equals("0"))
								age_value = age_value+ymdh_elmnt+"D ";								
						} else if (ymdh_char=='H') {
								age_value = age_value+ymdh_elmnt+"H ";
						}
					}	
	}
	
	MembershipType=rs.getString("MembershipType");
    if(MembershipType==null)MembershipType="";
    
	Orgsubname=rs.getString("Orgsubname");
    if(Orgsubname==null)Orgsubname="";
	
    Orgname=rs.getString("Orgname");
    if(Orgname==null)Orgname="";
	
    patexpirtydate=rs.getString("patexpirtydate");
    if(patexpirtydate!=null)
	{
		patexpirtydate=DateUtils.convertDate(patexpirtydate,"DMY","en",locale);
	}
	else
		patexpirtydate="";
    
    Prn_Tel_No=rs.getString("prn_tel_no");
    if(Prn_Tel_No==null)Prn_Tel_No="";
	old_Prn_Tel_No = Prn_Tel_No;
	

    Orn_Tel_No=rs.getString("orn_tel_no");
    if(Orn_Tel_No==null)Orn_Tel_No="";
	old_Orn_Tel_No = Orn_Tel_No;
	
    
	
    }
}

String sql_sel="select short_desc,contact_mode from mp_contact_mode_lang_vw where language_id='"+locale+"' and contact_mode in ('PRN','ORN') order by contact_mode desc";
		  pstmt = con.prepareStatement(sql_sel);
		  rs=pstmt.executeQuery();
		  while (rs.next()) {
			  if(rs.getString("contact_mode").equals("PRN")) {
				  contactModeOne = rs.getString("short_desc");
			  } else if(rs.getString("contact_mode").equals("ORN")) {
				  contactModeTwo = rs.getString("short_desc");
			  }
		  }
          if(pstmt != null) pstmt.close();
		  if(rs != null) rs.close();

            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Pat_Ser_Grp_Desc ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Pref_Facility_Name));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(accept_national_id_no_yn.equals("Y")){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(National_Id_No));
            _bw.write(_wl_block13Bytes, _wl_block13);
} else {
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
if(accept_oth_alt_id_yn.equals("Y")) {
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(demo_oth_alt_id_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(demo_oth_alt_id_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
} else {
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Alt_Id1_Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id1_No));
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(alt_id1_exp_date_accept_yn.equals("Y")) {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id1_Exp_Date));
            _bw.write(_wl_block13Bytes, _wl_block13);
 } else{
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(Alt_Id2_Type != "") { 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Alt_Id2_Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id2_No));
            _bw.write(_wl_block13Bytes, _wl_block13);
if(alt_id2_exp_date_accept_yn.equals("Y")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id2_Exp_Date));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(Alt_Id3_Type != "") { 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Alt_Id3_Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id3_No));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(alt_id3_exp_date_accept_yn.equals("Y"))
			 {  
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id3_Exp_Date));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
 if(Alt_Id4_Type != "") {	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Alt_Id4_Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id4_No));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(alt_id4_exp_date_accept_yn.equals("Y")) {  
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alt_Id4_Exp_Date));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(family_org_id_accept_yn.equals("Y")) {
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
if(MembershipType.equals("1")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else if (MembershipType.equals("2")){
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else if(MembershipType.equals("3")){
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else if(MembershipType.equals("4")){
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(header_width));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(data_width));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(data_word_wrap));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Orgname));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(!Orgname.equals("") && !Orgsubname.equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            out.print( String.valueOf(Orgsubname));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(Family_No_Link_Yn.equals("Y"))
		 {
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Family_Link_No));
            _bw.write(_wl_block42Bytes, _wl_block42);
if(family_org_id_accept_yn.equals("Y"))
				{
            _bw.write(_wl_block43Bytes, _wl_block43);
}
				else 
				{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(head_patient_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Relationship_Name));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
		 else
		 {
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix_Prompt+"</td>");

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix_Prompt+"</td>");

            _bw.write(_wl_block50Bytes, _wl_block50);
 if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix+"</td>");

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix+"</td>");


            _bw.write(_wl_block51Bytes, _wl_block51);


try
{
	if(names_in_oth_lang_yn.equals("Y")) {  
            _bw.write(_wl_block52Bytes, _wl_block52);
 if(!language_direction.equals("R")) {
       
		 if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }

//start
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//3
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//2
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//1
		 if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");
       
        
            _bw.write(_wl_block50Bytes, _wl_block50);

          
			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+name_prefix_loc_lang+"</td>");        

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }

//start
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//3
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//1
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
			
			  if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data'  style=\"border-right-style: solid; border-right-color: white\">"+name_suffix_loc_lang+"</td>");

		}
		else if(language_direction.equals("R"))
		{

	
		if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");


	  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


			

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


		if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");
		
       
        
            _bw.write(_wl_block50Bytes, _wl_block50);

          
			if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_suffix_loc_lang+"</b></td>");

			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }



			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }


			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }

			

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }

			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_prefix_loc_lang+"</b></td>"); 

		}
            
		}
}
catch(Exception e){
	//out.println(e);
e.printStackTrace();
}

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if(Sex.equals("M"))
			{  
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if(Sex.equals("F")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else if(Sex.equals("U")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(blood_grp_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rh_factor_desc));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(age_value));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(Date_Of_Birth));
            _bw.write(_wl_block63Bytes, _wl_block63);
if(hijirisitespecifApplicable){

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(hijri_birth_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(Mar_Status_Desc));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

			if(!(Place_Of_Birth==null))	
			out.println(Place_Of_Birth);
			if(!(birth_place_code==null))
			out.println(birth_place_desc);	
			
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Pat_Cat_Desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
if(entitlement_by_pat_cat_yn.equals("Y")){
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
if(!patexpirtydate.equals("")){
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            out.print( String.valueOf(patexpirtydate));
            _bw.write(_wl_block73Bytes, _wl_block73);
}else {
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

					if(citizen_yn.equals("Y")) { 

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 }
					else if(citizen_yn.equals("N")) { 

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

					if(legal_yn.equals("Y")){ 

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 }
					else if(legal_yn.equals("N")){ 

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Nationality_Desc));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(race_long_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(ethnic_long_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Relgn_Desc));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(language_name));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Alias_Name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(contactModeOne));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( Prn_Tel_No));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(contactModeTwo));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( Orn_Tel_No));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(National_Id_No));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(Patient_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(old_Prn_Tel_No));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(old_Orn_Tel_No));
            _bw.write(_wl_block91Bytes, _wl_block91);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PrefFacility.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.identitydetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.headfamilydetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.membership.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.organizationmember.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmemberfamily.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmembernonfamily.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.nonorganizationmember.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HeadPatientID.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RelationshiptoHeadofFamily.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.names.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.personaldetails.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RhFactor.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Hijri.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.maritalstatus.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
