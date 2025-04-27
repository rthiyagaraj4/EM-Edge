package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __linksecondarydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/LinkSecondaryDetails.jsp", 1729083265107L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
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

    private final static java.lang.String  _wl_block6 ="\n       \n<html>  \n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eOA/js/AppointmentDetails.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n<center>\n<form name=\'sec_link_form\' id=\'sec_link_form\' action=\'../../servlet/eOA.BookAppointmentServlet\' method=\'post\' target=\'dummyFrame\'>\n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'CANCEL_APPOINTMENT\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'98%\' align=\'center\' valign=\'top\' >\n\t\t\t\t\n\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan =\'2\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\'  nowrap colspan=\'2\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\n\t\t\t\t<td  class=\'COLUMNHEADER\'  nowrap colspan=\'2\'>&nbsp;</td>\t\t\t\t\t\t\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</tr>\n\t\t\t\n\n\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\n\t\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" - ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t</tr>\t\t\t\n\n\t\t<tr>\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\n\t\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\n\t\t</tr>\n\t\t\t\t\t\n\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\n\t\t\t\t<td  class=\'label\'  nowrap colspan=\'2\'>&nbsp;</td>\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t</tr>\n\t\n\n<tr><td class=\'COLUMNHEADER\'colspan = 4  >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t<td  class=\'label\' nowrap> ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</td>\n\t\t\t<td   class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t</td>\n\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t</td>\n\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t\t\n\n\n\n<tr>\n\n\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t<td  class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" </td>\n\t<td  class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\n</tr>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\n\t\t<tr>\n\t\t\t<td  class=\'label\'nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td   class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t<td class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\n\t\t</tr>\n\n\n\n\t\t<tr>\n\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t<td  class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n\t\t\t<td  class=\'label\'nowrap>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\n\t\t</tr>\n\n\n\t\t<tr>\t\n\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t</tr>\n\n\n<tr>\n\t<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\n\t<td   class=\"label\"  nowrap>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\n\n</tr>\n\n\n\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="Y&nbsp;";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="M&nbsp;";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="D&nbsp;</td>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t</tr>\n\n<tr>\n<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t<td class=\'QUERYDATA\' >\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t</td>\n\t<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t<td  class=\'QUERYDATA\' >\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\t\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t</td>\n</tr>\n\n\n\n\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t<td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\n\t\t\t\t\t\t<td class=\'label\'  nowrap >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t\t\t<td  class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t<td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t\t<td   class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\'  nowrap >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="   \n\t\t\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t<td  class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\n\t<td class=\'button\' colspan=\'2\'><input type=\'button\' name=\'ContactDetails\' id=\'ContactDetails\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' onClick=\'Modal_Contact_Details()\' class=\"BUTTON\" >\n\t\t\t\t</td>\n    </tr>\n\n\t<tr><td  class=\'COLUMNHEADER\' colspan =4 >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t   <td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t</td>\n\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap colspan = 3>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'QUERYDATA\' colspan =3>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\n\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'QUERYDATA\'   nowrap>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'QUERYDATA\'nowrap>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\n\t\n\t<td class=\'COLUMNHEADER\' colspan =4 nowrap>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\n\n\n\n\t<tr><td class=\'QUERYDATA\' nowrap colspan =4>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td></tr>\t\n\t\t<tr><td  class=\'QUERYDATA\' nowrap colspan =4>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td></tr>\t\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\n\t\n\t</table>\n\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'5%\' align=\'right\' id=\'allbuttons\'>\n\n<tr>\n\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t<td  align=\'right\'>\n\t<input type=\'button\' name=\'secres\' id=\'secres\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' class=\"BUTTON\" onclick=\"show_second1()\"></td>\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n<td  align=\'right\'><input type=\'button\' name=\'Apply\' id=\'Apply\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'  class=\"BUTTON\" onclick=\'valcheck2()\'></td>\n\n\n<td  align=\'right\'><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'  class=\"BUTTON\" onclick=\'exitwin_normal()\'>\n<input type=\'hidden\' name=\'cancelappt\' id=\'cancelappt\' value=\'\'>\n<input type=\'hidden\' name=\'revappt\' id=\'revappt\' value=\'\'>\n</td>\n</tr>\n</table>\n\n<BR>\n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t<input type=\"hidden\" name=\"sec_resources\" id=\"sec_resources\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t<input type=\"hidden\" name=\"sec_sel\" id=\"sec_sel\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sec_sel222\" id=\"sec_sel222\" value=\"\">\n\t\t<input type=\"hidden\" name=\"appttypecode\" id=\"appttypecode\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t<input type=\'hidden\' name=\'no_of_slots\' id=\'no_of_slots\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' >\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'Link\' >\n\t\t<input type=\'hidden\' name=\'function1\' id=\'function1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t<input type=\'hidden\' name=\'transfer\' id=\'transfer\' value=";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" >\n\t\t<input type=\'hidden\' name=\'value13\' id=\'value13\' value=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" >\n\t\t<input type=\'hidden\' name=\'new_from_time\' id=\'new_from_time\' value=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" >\n\t\t<input type=\'hidden\' name=\'new_to_time\' id=\'new_to_time\' value=";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" >\n\t\t<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\'  value=";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" >\n\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" >\n\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" >\n\t\t<input type=\'hidden\' name=\'dateapd\' id=\'dateapd\' value=";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" >\n\t\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" >\n\t\t<input type=\'hidden\' name=\'overbooked_yn\' id=\'overbooked_yn\' value=";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" >\n\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t<input type=\'hidden\' name=\'ServerTime\' id=\'ServerTime\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' >\n\t\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t<input type=\'hidden\' name=\'visitind\' id=\'visitind\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' >\n\t\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' >\n\t\t<input type=\'hidden\' name=\'old_from_time\' id=\'old_from_time\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' >\n\t\t<input type=\'hidden\' name=\'old_to_time\' id=\'old_to_time\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' >\n\t\t<input type=\'hidden\' name=\'pre_pat_alcn_criteria\' id=\'pre_pat_alcn_criteria\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' >\n\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' >\n\t\t<input type=\'hidden\' name=\'pre_pat_alcn_catg_code\' id=\'pre_pat_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' >\n\t\t<input type=\'hidden\' name=\'alcn_catg_code\' id=\'alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' >\n\t\t<input type=\'hidden\' name=\'disp_date\' id=\'disp_date\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' >\n\t\t<input type=\'hidden\' name=\'contactvals\' id=\'contactvals\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" >\n\t\t<input type=\'hidden\' name=\'disp_fromtime\' id=\'disp_fromtime\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' >\n\t\t<input type=\'hidden\' name=\'disp_totime\' id=\'disp_totime\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' >\n\t\t<input type=\'hidden\' name=\'i_time_table_type\' id=\'i_time_table_type\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' >\n\t\t<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' >\n\t\t<input type=\'hidden\' name=\'obook_appt_yn\' id=\'obook_appt_yn\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' >\n\t\t<input type=\'hidden\' name=\'team_id\' id=\'team_id\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' >\n\t\t<input type=\'hidden\' name=\'cancel_flag\' id=\'cancel_flag\' value=\"\">\n\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t<input type=\'hidden\' name=\'Forced\' id=\'Forced\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\t\n\t\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'sec_value_count\' id=\'sec_value_count\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'clinic_name_sec\' id=\'clinic_name_sec\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t\t<input type=\'hidden\' name=\'care_locn_desc_sec\' id=\'care_locn_desc_sec\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t\t<input type=\'hidden\' name=\'res_pri_class_desc\' id=\'res_pri_class_desc\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t\t<input type=\'hidden\' name=\'pract_name_pri\' id=\'pract_name_pri\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t\t<input type=\'hidden\' name=\'visitshortdesc\' id=\'visitshortdesc\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"><!--Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601-->\n\t\n\t\n\t</form>\n\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
		String flag=request.getParameter("flag");
		if(flag == null || flag.equals("undefined")) flag="";

	
            _bw.write(_wl_block9Bytes, _wl_block9);

			String pat_alcn_criteria="";
			String pat_alcn_catg_code="";
			String pat_alcn_catg_code1="";
			String pre_pat_alcn_criteria="";
			String pre_pat_alcn_catg_code="";
			String contactvals="";
			String nationality="";
			String time_tab_val1="";
			String facilityid=(String)session.getValue("facility_id");
			String locale=(String)session.getAttribute("LOCALE");

			PreparedStatement pstmt=null;
			//Statement stmtgrp=null;
			//Statement Stmt_Nat_Id=null;
			//ResultSet Rset_Nat_Id=null;
			//ResultSet rstt=null;
			ResultSet rs1=null;
			ResultSet rsSet=null;
			Statement stMent= null;

			//ResultSet rssd=null;
			//ResultSet rsgrp=null;
			Connection conn = null;
			//Statement stmtsd=null;
			String referral_line="";
			String referral_line1="";
			String book_appt_yn = request.getParameter("book_appt_yn");
			if (book_appt_yn==null) book_appt_yn="";
			String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
			if (book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
			String obook_appt_yn = request.getParameter("obook_appt_yn");
			if (obook_appt_yn==null) obook_appt_yn="";
			String book_appt_across_catg_yn = request.getParameter("book_appt_across_catg_yn");
			if (book_appt_across_catg_yn==null) book_appt_across_catg_yn="";
			String tfr_appt_yn = request.getParameter("tfr_appt_yn");
			if (tfr_appt_yn==null) tfr_appt_yn="";
			String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
			if (tfr_appt_across_catg_yn==null) tfr_appt_across_catg_yn="";
			String canc_appt_yn = request.getParameter("canc_appt_yn");
			if (canc_appt_yn==null) canc_appt_yn="";
			String alcn_criteria = request.getParameter("alcn_criteria");
			if (alcn_criteria==null) alcn_criteria="";
			String alcn_catg_code= request.getParameter("pre_pat_alcn_catg_code");
			if (alcn_catg_code==null) alcn_catg_code="";

			String Forced=request.getParameter("Forced");
			if(Forced==null || Forced.equals("null"))
					Forced="N";

			StringBuffer contactAddress=new StringBuffer();


try
{
		conn = ConnectionManager.getConnection(request);

		String clinic_code="";
		String practitioner_id="";

		clinic_code=request.getParameter("i_clinic_code");
		practitioner_id=request.getParameter("i_practitioner_id");
		String apptrefno=request.getParameter("i_appt_ref_no");
		if(apptrefno == null || apptrefno.equals("undefined")) apptrefno="";
		String disp_fromtime="";
		String disp_totime="";
		String transfer=request.getParameter("transfer");
		if(transfer == null) transfer="";
		String i_from_time=request.getParameter("i_from_time");
		if(i_from_time == null) i_from_time="";
		String i_to_time=request.getParameter("i_to_time");
		if(i_to_time == null) i_to_time="";
		String value13=request.getParameter("value13");
		if(value13 == null) value13="";
		String i_appt_date=request.getParameter("i_appt_date");
		String over_booked=request.getParameter("over_booked");
		if(over_booked == null) over_booked="";
		String i_time_table_type=request.getParameter("i_time_table_type");
		if(i_time_table_type == null) i_time_table_type="";
		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";
		if(apptrefno.equals("hjjh")) { apptrefno=value13; }
		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";
		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";

		String clinic_type=request.getParameter("clinic_type");
		String res_type=request.getParameter("res_type");
		if (clinic_type==null) clinic_type = "C";
		if (res_type==null) res_type = "P";

		String care_locn_ind_desc="";
		
if(clinic_type.equals("C")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
}else if(clinic_type.equals("E")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
}else if(clinic_type.equals("D")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
}
		String res_class_desc="";
	
if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}else if(res_type.equals("B")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
}

		String apptrefno1="";
		String clinicshortdesc="";
		String practitionerid="";
		String practname="";
		String apptdate="";
		String appttime="";
		String apptslabfmtime="";
		String apptslabtotime="";
		String apptduration="";
		String patientid="";
		String prefix="";
		String firstname="";
		String secondname="";
		String thirdname="";
		String familyname="";
		String suffix="";
		String patientname="";
		String gender="";
		String genderdesc="";
		String dateofbirth="";
		String agey="";
		String agem="";
		String aged="";
		String restelno="";
		String othtelno="";
		String emailid="";
		String nationalid="";
		String nat_id_prompt="";
		String alternateid="";
		String resaddrl1="";
		String resaddrl2="";
		String resaddrl3="";
		String resaddrl4="";
		String postalcode="";
		String countrycode="";
		String appttypecode="";
		String overbookedyn="";
		String referralcode="";
		String mode="";
		String modedesc="";
		String reasoncode="";
		String reasondesc="";
		String apptremarks="";
		String visitshortdesc="";
		String appt_date1="";
		String visitind="";
		String referral_id="";
		String user_name="";
		String record_date="";
		String team_id="";
		String ETHNIC_GROUP_DESC="";
		String RACE_DESC="";
		String CITIZEN_YN="";
		String LEGAL_YN="";
		String BIRTH_PLACE_DESC="";
		String receiving_date_time="";
		String RES_AREA_CODE="";
		String RES_AREA_DESC="";
		String RES_TOWN_CODE="";
		String RES_TOWN_DESC="";
		String RES_REGION_CODE="";
		String RES_REGION_DESC="";
		String RES_COUNTRY_CODE="";
		String RES_COUNTRY_NAME="";
		String MAIL_ADDR_LINE1="";
		String MAIL_ADDR_LINE2="";
		String MAIL_ADDR_LINE3="";
		String MAIL_ADDR_LINE4="";
		String MAIL_AREA_CODE="";
		String MAIL_AREA_DESC="";
		String MAIL_TOWN_CODE="";
		String MAIL_TOWN_DESC="";
		String MAIL_REGION_CODE="";
		String MAIL_REGION_DESC="";
		String MAIL_POSTAL_CODE="";
		String MAIL_COUNTRY_CODE="";
		String MAIL_COUNTRY_NAME="";
		String ALT_ID1_TYPE="";
		String ALT_ID1_NO="";
		String ALT_ID1_EXP_DATE="";
		String ALT_ID2_TYPE="";
		String ALT_ID2_NO="";
		String ALT_ID2_EXP_DATE="";
		String ALT_ID3_TYPE="";
		String ALT_ID3_NO="";
		String ALT_ID3_EXP_DATE="";
		String ALT_ID4_TYPE="";
		String ALT_ID4_NO="";
		String ALT_ID4_EXP_DATE="";
		String ALT_ID1_EXP_DATE_display="";
		String ALT_ID2_EXP_DATE_display="";
		String ALT_ID3_EXP_DATE_display="";
		String ALT_ID4_EXP_DATE_display="";
		String OTH_ALT_ID_TYPE="";
		String OTH_ALT_ID_NO="";
		String ALT_ID1_Desc="";
		String ALT_ID2_Desc="";
		String ALT_ID3_Desc="";
		String ALT_ID4_Desc="";
		String alt_type_desc="";
		String no_of_slots="";
		String str13="";
		String str14="";
		String postal_desc="";
		String mail_postal_desc="";
		/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		String alt_addr_line1	= "";
		String alt_addr_line2	= "";
		String alt_addr_line3	= "";
		String alt_addr_line4	= "";
		String alt_postal_code  = "";
		String alt_postal_desc  = "";
		String alt_country_code = "";
		String alt_country_desc = "";
		String alt_area_code	= "";
		String alt_area_desc	= "";
		String alt_town_code	= "";
		String alt_town_desc	= "";
		String alt_region_code	= "";
		String alt_region_desc	= "";
		boolean isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","ALTERNATE_ADDRESS_APPLICABLE");
		/*End*/
	
		if(rs1 !=null) rs1.close();

		 //String sql="select sm_get_desc.sm_appl_user(added_by_id, '"+locale+"', '1') appl_user_name,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, facility_id, appt_ref_no, clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC,practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, appt_date, to_char(appt_time,'hh24:mi') appt_time, to_char(appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(appt_duration,'hh24:mi') appt_duration, appt_slots, patient_id, name_prefix, first_name, second_name, third_name,family_name, name_suffix, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, gender, date_of_birth, res_tel_no res_tel_no,oth_contact_no, national_id_no, res_addr_line1, res_addr_line2, res_addr_line3,  res_addr_line4, postal_code, country_code, appt_type_code, (SELECT visit_type_ind  FROM op_visit_type b WHERE b.visit_type_code = appt_type_code AND b.facility_id = facility_id) VISIT_TYPE_IND,overbooked_yn,referral_id, mode_of_contact,contact_reason_code, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,appt_remarks, appt_status, inpatient_yn, encounter_id,email_id,alcn_criteria,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) day1 ,alcn_catg_code,referral_id,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+locale+"','1') nationality,team_id,alcn_criteria,pat_alcn_catg_code,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1') RACE_DESC,CITIZEN_YN,LEGAL_YN,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,to_char(receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC,RES_REGION_CODE,MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC,RES_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,ALT_ID1_TYPE,ALT_ID1_NO,to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,ALT_ID2_TYPE,ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,ALT_ID3_TYPE,ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,ALT_ID4_TYPE,ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,OTH_ALT_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"','2') alt_type_desc,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,no_of_slots ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,'"+locale+"','1') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','1') mail_postal_desc from oa_appt  where  facility_id='"+facilityid+"' and appt_ref_no='"+apptrefno+"' ";
		
		String sql="select sm_get_desc.sm_appl_user(added_by_id, ?, '1') appl_user_name,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, facility_id, appt_ref_no, clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') CLINIC_SHORT_DESC,practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,?,'2') visit_type_short_desc, appt_date, to_char(appt_time,'hh24:mi') appt_time, to_char(appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(appt_duration,'hh24:mi') appt_duration, appt_slots, patient_id, name_prefix, first_name, second_name, third_name,family_name, name_suffix, decode(?,'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, gender, date_of_birth, res_tel_no res_tel_no,oth_contact_no, national_id_no, res_addr_line1, res_addr_line2, res_addr_line3,  res_addr_line4, postal_code, country_code, appt_type_code, (SELECT visit_type_ind  FROM op_visit_type b WHERE b.visit_type_code = a.appt_type_code AND b.facility_id = a.facility_id) VISIT_TYPE_IND,overbooked_yn,referral_id, mode_of_contact,contact_reason_code, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,?,'1') CONTACT_REASON,appt_remarks, appt_status, inpatient_yn, encounter_id,email_id,alcn_criteria,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) day1 ,alcn_catg_code,referral_id,MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,?,'1') nationality,team_id,alcn_criteria,pat_alcn_catg_code,MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,?,'1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(RACE_CODE,?,'1') RACE_DESC,CITIZEN_YN,LEGAL_YN,MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,?,'1') BIRTH_PLACE_DESC,to_char(receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,?,'1') RES_AREA_DESC,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,?,'1') RES_TOWN_DESC,RES_REGION_CODE,MP_GET_DESC.MP_REGION(RES_REGION_CODE,?,'1') RES_REGION_DESC,RES_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,?,'1') RES_COUNTRY_NAME,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,?,'1') MAIL_AREA_DESC,MAIL_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,?,'1') MAIL_TOWN_DESC,MAIL_REGION_CODE,MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,?,'1') MAIL_REGION_DESC,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,?,'1') MAIL_COUNTRY_NAME, a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,ALT_ID1_TYPE,ALT_ID1_NO,to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,ALT_ID2_TYPE,ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,ALT_ID3_TYPE,ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,ALT_ID4_TYPE,ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,OTH_ALT_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,?,'2') alt_type_desc,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,no_of_slots ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,?,'1') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,?,'1') mail_postal_desc,TIME_TABLE_TYPE, to_char(sysdate,'dd/mm/yyyy')sys_date ,to_char(sysdate,'hh24:mi')sys_time from oa_appt a where facility_id=? and appt_ref_no=? ";//Modified by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601

		 pstmt=conn.prepareStatement(sql);

		 pstmt.setString(1,locale);
		 pstmt.setString(2,locale);
		 pstmt.setString(3,locale);
		 pstmt.setString(4,locale);
		 pstmt.setString(5,locale);
		 pstmt.setString(6,locale);
		 pstmt.setString(7,locale);
		 pstmt.setString(8,locale);
		 pstmt.setString(9,locale);
		 pstmt.setString(10,locale);
		 pstmt.setString(11,locale);
		 pstmt.setString(12,locale);
		 pstmt.setString(13,locale);
		 pstmt.setString(14,locale);
		 pstmt.setString(15,locale);
		 pstmt.setString(16,locale);
		 pstmt.setString(17,locale);
		 pstmt.setString(18,locale);
		 pstmt.setString(19,locale);
		 pstmt.setString(20,locale);
		 pstmt.setString(21,locale);
		 pstmt.setString(22,locale);
		 pstmt.setString(23,locale);
		 pstmt.setString(24,facilityid);
		 pstmt.setString(25,apptrefno);
		


		 rs1=pstmt.executeQuery();

		 
		if(rs1 != null) 
		{
			if(rs1.next())
			{
				  no_of_slots=rs1.getString("no_of_slots");
				  if(no_of_slots==null)no_of_slots="0";
				  team_id=rs1.getString("team_id");
				  if(team_id==null)team_id="";
				  user_name=rs1.getString("appl_user_name");
				  if(user_name==null)user_name="";
				  record_date=rs1.getString("added_date");
				  if(record_date==null)record_date="";
				  referral_id=rs1.getString("referral_id");
				  if(referral_id==null)referral_id="";
				  nationality=rs1.getString("nationality");
				  i_to_time=rs1.getString("appt_slab_to_time");
				  if(nationality==null)nationality="";
				  agey=rs1.getString("year1");
				  if(agey==null)agey="";
				  agem=rs1.getString("month1");
				  if(agem==null)agem="";
				  aged=rs1.getString("day1");	  
				  if(aged==null)aged="";
				 apptrefno1=rs1.getString("appt_ref_no");
				 if(apptrefno1 == null )apptrefno1="";
				 clinicshortdesc=rs1.getString("clinic_short_desc");
				 if(clinicshortdesc == null) clinicshortdesc="";
				 practitionerid=rs1.getString("practitioner_id");
				 if(practitionerid == null)practitionerid="";
				 practname=rs1.getString("practitioner_short_name");
				 if(practname == null) practname="";
				 visitshortdesc=rs1.getString("visit_type_short_desc");
				 if(visitshortdesc == null) visitshortdesc="";
				 appt_date1=rs1.getString("appt_date");
				 if(appt_date1 == null) appt_date1="";
				 visitind=rs1.getString("VISIT_TYPE_IND");
				 if(visitind == null) visitind="";
				 java.util.Date dateapd=rs1.getDate("appt_date");
				 SimpleDateFormat formatterapd = new SimpleDateFormat("dd/MM/yyyy");
				 apptdate=formatterapd.format(dateapd);
				 formatterapd = null;
				 appttime=rs1.getString("appt_time");
				 if(appttime == null) appttime="";
				 apptslabfmtime=rs1.getString("appt_slab_from_time");
				 if(apptslabfmtime == null) apptslabfmtime="";
				 apptslabtotime=rs1.getString("appt_slab_to_time");
				 if(apptslabtotime == null) apptslabtotime="";
				 disp_fromtime=apptslabfmtime;
				 disp_totime=apptslabtotime;
				 apptduration=rs1.getString("appt_duration");
				 if(apptduration == null) apptduration="";
				 patientid=rs1.getString("patient_id");
				 if(patientid == null) patientid="";
				 prefix=rs1.getString("name_prefix");
				 if( prefix == null) prefix="";
				 firstname=rs1.getString("first_name");
				 if(firstname== null) firstname="";
				 secondname=rs1.getString("second_name");
				 if(secondname == null) secondname="";
				 thirdname=rs1.getString("third_name");
				 if(thirdname == null) thirdname="";
				 familyname=rs1.getString("family_name");
				 if(familyname == null) familyname="";
				 suffix=rs1.getString("name_suffix");
				 if(suffix == null) suffix="";
				 patientname=rs1.getString("patient_name");
				 if(patientname == null) patientname="";
				ETHNIC_GROUP_DESC=rs1.getString("ETHNIC_GROUP_DESC");
				 if(ETHNIC_GROUP_DESC == null) ETHNIC_GROUP_DESC="";
				RACE_DESC=rs1.getString("RACE_DESC");
				 if(RACE_DESC == null) RACE_DESC="";
				CITIZEN_YN=rs1.getString("CITIZEN_YN");
				 if(CITIZEN_YN == null) CITIZEN_YN="";
				LEGAL_YN=rs1.getString("LEGAL_YN");
				 if(LEGAL_YN == null) LEGAL_YN="";
				BIRTH_PLACE_DESC=rs1.getString("BIRTH_PLACE_DESC");
				 if(BIRTH_PLACE_DESC == null) BIRTH_PLACE_DESC="";
				
				RES_AREA_CODE=rs1.getString("RES_AREA_CODE");
				 if(RES_AREA_CODE == null) RES_AREA_CODE="";
				RES_AREA_DESC=rs1.getString("RES_AREA_DESC");
				 if(RES_AREA_DESC == null) RES_AREA_DESC="";
				RES_TOWN_CODE=rs1.getString("RES_TOWN_CODE");
				 if(RES_TOWN_CODE == null) RES_TOWN_CODE="";
				RES_TOWN_DESC=rs1.getString("RES_TOWN_DESC");
				 if(RES_TOWN_DESC == null) RES_TOWN_DESC="";
				RES_REGION_CODE=rs1.getString("RES_REGION_CODE");
				 if(RES_REGION_CODE == null) RES_REGION_CODE="";
				RES_REGION_DESC=rs1.getString("RES_REGION_DESC");
				 if(RES_REGION_DESC == null) RES_REGION_DESC="";
				RES_COUNTRY_CODE=rs1.getString("RES_COUNTRY_CODE");
				 if(RES_COUNTRY_CODE == null) RES_COUNTRY_CODE="";
				RES_COUNTRY_NAME=rs1.getString("RES_COUNTRY_NAME");
				 if(RES_COUNTRY_NAME == null) RES_COUNTRY_NAME="";
				MAIL_ADDR_LINE1=rs1.getString("MAIL_ADDR_LINE1");
				 if(MAIL_ADDR_LINE1 == null) MAIL_ADDR_LINE1="";
				MAIL_ADDR_LINE2=rs1.getString("MAIL_ADDR_LINE2");
				 if(MAIL_ADDR_LINE2 == null) MAIL_ADDR_LINE2="";
				MAIL_ADDR_LINE3=rs1.getString("MAIL_ADDR_LINE3");
				 if(MAIL_ADDR_LINE3 == null) MAIL_ADDR_LINE3="";
				MAIL_ADDR_LINE4=rs1.getString("MAIL_ADDR_LINE4");
				 if(MAIL_ADDR_LINE4 == null) MAIL_ADDR_LINE4="";
				MAIL_AREA_CODE=rs1.getString("MAIL_AREA_CODE");
				 if(MAIL_AREA_CODE == null) MAIL_AREA_CODE="";
				MAIL_AREA_DESC=rs1.getString("MAIL_AREA_DESC");
				 if(MAIL_AREA_DESC == null) MAIL_AREA_DESC="";
				MAIL_TOWN_CODE=rs1.getString("MAIL_TOWN_CODE");
				 if(MAIL_TOWN_CODE == null) MAIL_TOWN_CODE="";
				MAIL_TOWN_DESC=rs1.getString("MAIL_TOWN_DESC");
				 if(MAIL_TOWN_DESC == null) MAIL_TOWN_DESC="";
				MAIL_REGION_CODE=rs1.getString("MAIL_REGION_CODE");
				 if(MAIL_REGION_CODE == null) MAIL_REGION_CODE="";
				MAIL_REGION_DESC=rs1.getString("MAIL_REGION_DESC");
				 if(MAIL_REGION_DESC == null) MAIL_REGION_DESC="";
				MAIL_POSTAL_CODE=rs1.getString("MAIL_POSTAL_CODE");
				 if(MAIL_POSTAL_CODE == null) MAIL_POSTAL_CODE="";
				MAIL_COUNTRY_CODE=rs1.getString("MAIL_COUNTRY_CODE");
				 if(MAIL_COUNTRY_CODE == null) MAIL_COUNTRY_CODE="";
				MAIL_COUNTRY_NAME=rs1.getString("MAIL_COUNTRY_NAME");
				 if(MAIL_COUNTRY_NAME == null) MAIL_COUNTRY_NAME="";
				ALT_ID1_TYPE=rs1.getString("ALT_ID1_TYPE");
				 if(ALT_ID1_TYPE == null) ALT_ID1_TYPE="";
				ALT_ID1_NO=rs1.getString("ALT_ID1_NO");
				 if(ALT_ID1_NO == null) ALT_ID1_NO="";
				ALT_ID1_EXP_DATE=rs1.getString("ALT_ID1_EXP_DATE");
				 if(ALT_ID1_EXP_DATE == null) ALT_ID1_EXP_DATE="";
				ALT_ID2_TYPE=rs1.getString("ALT_ID2_TYPE");
				 if(ALT_ID2_TYPE == null) ALT_ID2_TYPE="";
				ALT_ID2_NO=rs1.getString("ALT_ID2_NO");
				 if(ALT_ID2_NO == null) ALT_ID2_NO="";
				ALT_ID2_EXP_DATE=rs1.getString("ALT_ID2_EXP_DATE");
				 if(ALT_ID2_EXP_DATE == null) ALT_ID2_EXP_DATE="";
				ALT_ID3_TYPE=rs1.getString("ALT_ID3_TYPE");
				 if(ALT_ID3_TYPE == null) ALT_ID3_TYPE="";
				ALT_ID3_NO=rs1.getString("ALT_ID3_NO");
				 if(ALT_ID3_NO == null) ALT_ID3_NO="";
				ALT_ID3_EXP_DATE=rs1.getString("ALT_ID3_EXP_DATE");
				 if(ALT_ID3_EXP_DATE == null) ALT_ID3_EXP_DATE="";
				ALT_ID4_TYPE=rs1.getString("ALT_ID4_TYPE");
				 if(ALT_ID4_TYPE == null) ALT_ID4_TYPE="";
				ALT_ID4_NO=rs1.getString("ALT_ID4_NO");
				 if(ALT_ID4_NO == null) ALT_ID4_NO="";
				ALT_ID4_EXP_DATE=rs1.getString("ALT_ID4_EXP_DATE");
				 if(ALT_ID4_EXP_DATE == null) ALT_ID4_EXP_DATE="";
				OTH_ALT_ID_TYPE=rs1.getString("OTH_ALT_ID_TYPE");
				 if(OTH_ALT_ID_TYPE == null) OTH_ALT_ID_TYPE="";
				OTH_ALT_ID_NO=rs1.getString("OTH_ALT_ID_NO");
				 if(OTH_ALT_ID_NO == null) OTH_ALT_ID_NO="";
				alt_type_desc=rs1.getString("alt_type_desc");

				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1		= checkForNull(rs1.getString("alt_addr_line1"));
				alt_addr_line2		= checkForNull(rs1.getString("alt_addr_line2"));
				alt_addr_line3		= checkForNull(rs1.getString("alt_addr_line3"));
				alt_addr_line4		= checkForNull(rs1.getString("alt_addr_line4"));
				alt_area_code		= checkForNull(rs1.getString("alt_area_code"));
				alt_area_desc		= checkForNull(rs1.getString("alt_area_desc"));
				alt_town_code		= checkForNull(rs1.getString("alt_town_code"));
				alt_town_desc		= checkForNull(rs1.getString("alt_town_desc"));
				alt_region_code		= checkForNull(rs1.getString("alt_region_code"));
				alt_region_desc		= checkForNull(rs1.getString("alt_region_desc"));
				alt_postal_code		= checkForNull(rs1.getString("alt_postal_code"));
				alt_postal_desc		= checkForNull(rs1.getString("alt_postal_desc"));
				alt_country_code	= checkForNull(rs1.getString("alt_country_code"));
				alt_country_desc	= checkForNull(rs1.getString("alt_country_desc"));
				/*End*/

				time_tab_val1=rs1.getString("TIME_TABLE_TYPE");
				 if(time_tab_val1 == null) time_tab_val1="";
				str13=rs1.getString("sys_date");
				 if(str13 == null) str13="";
				str14=rs1.getString("sys_time");
				 if(str14 == null) str14="";

		 if(alt_type_desc == null) alt_type_desc="";
	
				receiving_date_time=rs1.getString("receiving_date_time");
				 if(receiving_date_time == null) receiving_date_time="";

				 gender=rs1.getString("gender");
			if(gender.equals("M")) 
				{
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender.equals("F")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender.equals("U")) {
				genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}
			 java.util.Date date1 = rs1.getDate("date_of_birth");
			 if(date1 != null )
			{
				 SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				 dateofbirth=formatter1.format(date1);
				 formatter1 = null;
			 }
			 else
				 dateofbirth="";

				restelno=rs1.getString("res_tel_no");
				if (restelno==null)
				restelno="";
				othtelno=rs1.getString("oth_contact_no");
				if(othtelno==null)
				othtelno="";
				emailid=rs1.getString("email_id");
				if(emailid==null)
				emailid="";
				nationalid=rs1.getString("national_id_no");
				if(nationalid == null) nationalid="";
				alternateid=rs1.getString("alt_id1_no");
				if(alternateid == null) alternateid="";
				resaddrl1=rs1.getString("res_addr_line1");
				if(resaddrl1 == null) resaddrl1="";
				resaddrl2=rs1.getString("res_addr_line2");
				if(resaddrl2 == null) resaddrl2="";
				resaddrl3=rs1.getString("res_addr_line3");
				if(resaddrl3 == null) resaddrl3="";
				resaddrl4=rs1.getString("res_addr_line4");
				if(resaddrl4 == null) resaddrl4="";
				postalcode=rs1.getString("postal_code");
				if(postalcode == null) postalcode="";
				postal_desc=rs1.getString("postal_desc");
				if(postal_desc == null) postal_desc="";
				mail_postal_desc=rs1.getString("mail_postal_desc");
				if(mail_postal_desc == null) mail_postal_desc="";


				contactAddress.append(""+"^^");
				contactAddress.append(resaddrl1+"^^");
				contactAddress.append(resaddrl2+"^^");
				contactAddress.append(resaddrl3+"^^");
				contactAddress.append(resaddrl4+"^^");
				contactAddress.append(RES_TOWN_CODE+"^^");
				contactAddress.append(RES_AREA_CODE+"^^");
				contactAddress.append(postalcode+"^^");
				contactAddress.append(RES_REGION_CODE+"^^");
				contactAddress.append(RES_COUNTRY_CODE+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(MAIL_ADDR_LINE1+"^^");
				contactAddress.append(MAIL_ADDR_LINE2+"^^");
				contactAddress.append(MAIL_ADDR_LINE3+"^^");
				contactAddress.append(MAIL_ADDR_LINE4+"^^");
				contactAddress.append(MAIL_TOWN_CODE+"^^");
				contactAddress.append(MAIL_AREA_CODE+"^^");
				contactAddress.append(MAIL_POSTAL_CODE+"^^");
				contactAddress.append(MAIL_REGION_CODE+"^^");
				contactAddress.append(MAIL_COUNTRY_CODE+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(restelno+"^^");
				contactAddress.append(othtelno+"^^");
				contactAddress.append(emailid+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(RES_TOWN_DESC+"^^");
				contactAddress.append(RES_AREA_DESC+"^^");
				contactAddress.append(RES_REGION_DESC+"^^");
				contactAddress.append(MAIL_TOWN_DESC+"^^");
				contactAddress.append(MAIL_AREA_DESC+"^^");
				contactAddress.append(MAIL_REGION_DESC+"^^");
				contactAddress.append(MAIL_COUNTRY_NAME+"^^");
				contactAddress.append(RES_COUNTRY_NAME+"^^");
				contactAddress.append(postal_desc+"^^");
				contactAddress.append(mail_postal_desc+"^^");
				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				contactAddress.append(alt_addr_line1+"^^");
				contactAddress.append(alt_addr_line2+"^^");
				contactAddress.append(alt_addr_line3+"^^");
				contactAddress.append(alt_addr_line4+"^^");
				contactAddress.append(alt_town_code+"^^");
				contactAddress.append(alt_area_code+"^^");
				contactAddress.append(alt_postal_code+"^^");
				contactAddress.append(alt_region_code+"^^");
				contactAddress.append(alt_country_code+"^^");
				contactAddress.append(alt_town_desc+"^^");
				contactAddress.append(alt_area_desc+"^^");
				contactAddress.append(alt_postal_desc+"^^");
				contactAddress.append(alt_region_desc+"^^");
				contactAddress.append(alt_country_desc);
				/*End*/

				countrycode=rs1.getString("country_code");
				if(countrycode == null) countrycode="";
				contactvals=resaddrl1+"^"+resaddrl2+"^"+resaddrl3+"^"+resaddrl4+"^"+postalcode+"^"+countrycode;
				appttypecode=rs1.getString("appt_type_code");
				if(appttypecode == null) appttypecode="";
				overbookedyn=rs1.getString("overbooked_yn");
				if(overbookedyn == null) overbookedyn="";
				referralcode=rs1.getString("referral_id");
				if(referralcode == null) referralcode="";
				pat_alcn_catg_code1=rs1.getString("alcn_catg_code");
			    if(pat_alcn_catg_code1 == null)pat_alcn_catg_code1="";
			    mode=rs1.getString("mode_of_contact");
				if(mode==null) 
				{
					mode="";
				}
				else 
				{
					if(mode.equals("E")) {
						modedesc="E-mail";
				}
				else if(mode.equals("T")) {
					modedesc="Telephone";
				}
				else if(mode.equals("F")) {
					modedesc="Fax";
				}
				else if(mode.equals("I")) {
					modedesc="In person";
				}
				else if(mode.equals("W")) {
					modedesc="Web";
				}
				else if(mode.equals("O")) {
					modedesc="Other";
				}
			}

				reasoncode=rs1.getString("contact_reason_code");
				if(reasoncode == null) reasoncode="";
				reasondesc=rs1.getString("contact_reason");
				if(reasondesc == null) reasondesc="";
				apptremarks=rs1.getString("appt_remarks");
				if(apptremarks==null)
				apptremarks="";
				pat_alcn_criteria=rs1.getString("alcn_criteria");
				pat_alcn_catg_code=rs1.getString("pat_alcn_catg_code");
	
		} // end of if rs.next()
	} // end if if rs != null 
	
		 if(rs1 !=null) rs1.close();
		 if(pat_alcn_criteria==null) pat_alcn_criteria="";
		 if(pat_alcn_catg_code==null) pat_alcn_catg_code="";
		 if(pre_pat_alcn_criteria.equals("")){
		 pre_pat_alcn_criteria=pat_alcn_criteria;
		 }
		 if(pre_pat_alcn_catg_code.equals("")){
		 pre_pat_alcn_catg_code=pat_alcn_catg_code;
		 }
	
			 //stmtsd=conn.createStatement();

			//String time_tab_type="select a.TIME_TABLE_TYPE,b.nat_id_prompt from oa_clinic_schedule_slot_slab a, mp_param b  where a.facility_id='"+facilityid+"' and  a.pri_appt_ref_no='"+apptrefno+"'  and  a.resource_class='"+res_type+"' and  a.clinic_code='"+clinic_code+"' and  a.care_locn_type_ind='"+clinic_type+"' and trunc( a.clinic_date)=to_date('"+i_appt_date+"','dd/mm/yyyy') and  a.facility_id= b.added_facility_id";

			/*String time_tab_type="select a.TIME_TABLE_TYPE, to_char(sysdate,'dd/mm/yyyy')sys_date ,        to_char(sysdate,'hh24:mi')sys_time from oa_clinic_schedule_slot_slab a   where a.facility_id='"+facilityid+"' and  a.pri_appt_ref_no='"+apptrefno+"'  and         a.resource_class='"+res_type+"' and  a.clinic_code='"+clinic_code+"' and         a.care_locn_type_ind='"+clinic_type+"' and trunc( a.clinic_date)=to_date('"+i_appt_date+"','dd/mm/yyyy')       ";
			
			rstt=stmtsd.executeQuery(time_tab_type);
			if(rstt !=null && rstt.next())
			{
					time_tab_val1=rstt.getString("TIME_TABLE_TYPE");
					str13=rstt.getString("sys_date");
					str14=rstt.getString("sys_time");
			}

			if(rstt !=null) rstt.close();
			*/
		 if(!(referral_id.equals(""))){
	 		stMent=conn.createStatement();

			 String sql_refral="select substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),3,70) ref_line1,substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),73)ref_line2 from dual";
			 rsSet=stMent.executeQuery(sql_refral);
			 rsSet.next();
			 referral_line=rsSet.getString("ref_line1");
			 referral_line1=rsSet.getString("ref_line2");
			 if(referral_line1 ==null) referral_line1="";
	 		 if(rsSet!=null) rsSet.close();
			 if(stMent!=null) stMent.close();

		 }





		
		stMent=conn.createStatement();
	
		rsSet=stMent.executeQuery("select MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_desc,nat_id_prompt FROM mp_param where module_id = 'MP'");
		if (rsSet!=null)
		{
			if(rsSet.next())
			{
				 ALT_ID1_Desc=rsSet.getString("alt_id1_desc");
				 ALT_ID2_Desc=rsSet.getString("alt_id2_desc");
				 ALT_ID3_Desc=rsSet.getString("alt_id3_desc");
				 ALT_ID4_Desc=rsSet.getString("alt_id4_desc");
				nat_id_prompt=rsSet.getString("nat_id_prompt");
				if (nat_id_prompt == null) nat_id_prompt="National Id No.";

				 if (ALT_ID1_Desc==null) ALT_ID1_Desc="";
				 if (ALT_ID2_Desc==null) ALT_ID2_Desc="";
				 if (ALT_ID3_Desc==null) ALT_ID3_Desc="";
				 if (ALT_ID4_Desc==null) ALT_ID4_Desc="";
				 ALT_ID1_Desc=ALT_ID1_Desc.trim();
				 ALT_ID2_Desc=ALT_ID2_Desc.trim();
				 ALT_ID3_Desc=ALT_ID3_Desc.trim();
				 ALT_ID4_Desc=ALT_ID4_Desc.trim();
	 		}
		}
/*******************************************************************************************************/

            _bw.write(_wl_block10Bytes, _wl_block10);

			out.println("<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='" + apptrefno +"'>");

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(overbookedyn.equals("Y")) {
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(apptrefno1));
            _bw.write(_wl_block18Bytes, _wl_block18);

					String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
					
				
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apptslabfmtime));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(visitshortdesc));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nationalid));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block40Bytes, _wl_block40);

	if(!ALT_ID1_EXP_DATE.equals(""))
	{
	 ALT_ID1_EXP_DATE_display=DateUtils.convertDate(ALT_ID1_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID2_EXP_DATE.equals(""))
	{
	 ALT_ID2_EXP_DATE_display=DateUtils.convertDate(ALT_ID2_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID3_EXP_DATE.equals(""))
	{
	 ALT_ID3_EXP_DATE_display=DateUtils.convertDate(ALT_ID3_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID4_EXP_DATE.equals(""))
	{
	 ALT_ID4_EXP_DATE_display=DateUtils.convertDate(ALT_ID4_EXP_DATE,"DMY","en",locale);
	}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ALT_ID1_Desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ALT_ID1_NO));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ALT_ID1_EXP_DATE_display));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ALT_ID2_Desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ALT_ID2_NO));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ALT_ID2_EXP_DATE_display));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ALT_ID3_Desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ALT_ID3_NO));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ALT_ID3_EXP_DATE_display));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(ALT_ID4_Desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ALT_ID4_NO));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ALT_ID4_EXP_DATE_display));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alt_type_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(OTH_ALT_ID_NO));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(BIRTH_PLACE_DESC));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(genderdesc));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block61Bytes, _wl_block61);

String dateofbirth_display=DateUtils.convertDate(dateofbirth,"DMY","en",locale);	

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dateofbirth_display));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(CITIZEN_YN.equals("Y")){
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
if(LEGAL_YN.equals("Y")){
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
if(!(nationalid.equals(""))){
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(RACE_DESC));
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(RACE_DESC));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(ETHNIC_GROUP_DESC));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(reasondesc));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(apptremarks));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(modedesc));
            _bw.write(_wl_block89Bytes, _wl_block89);

		String receiving_date_time_display=DateUtils.convertDate(receiving_date_time,"DMYHM","en",locale);

            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(receiving_date_time_display));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block94Bytes, _wl_block94);

		String record_date_display=DateUtils.convertDate(record_date,"DMYHM","en",locale);

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(record_date_display));
            _bw.write(_wl_block97Bytes, _wl_block97);

	if((referral_line!=null && !(referral_line.equals(""))) || (referral_line1 !=null && !(referral_line1.equals("")))){
	
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(referral_line));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(referral_line1));
            _bw.write(_wl_block101Bytes, _wl_block101);

	}
	
            _bw.write(_wl_block102Bytes, _wl_block102);


		String sec_resources="";
		if(!overbookedyn.equals("Y"))
		{
			//String secsql="select resource_class,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+appttypecode+"' and resource_class !='"+res_type+"'  order by resource_class ";
			String secsql="select resource_class,resource_criteria from op_resource_type_for_appt where facility_id=? and visit_type_code=? and resource_class !=?  order by resource_class ";

			if(pstmt !=null) pstmt.close();
			pstmt=conn.prepareStatement(secsql);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,appttypecode);
			pstmt.setString(3,res_type);



			rs1 = pstmt.executeQuery();

			while(rs1!=null && rs1.next())
			{
				 sec_resources=sec_resources+rs1.getString("resource_class");
				 sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
			}
			 
			 if(sec_resources.length()>1)
			 sec_resources=sec_resources.substring(0,sec_resources.length()-1);
			 if(rs1 !=null) rs1.close();
	   }


            _bw.write(_wl_block103Bytes, _wl_block103);
if(! sec_resources.equals("")){
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
}	
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
 


            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(sec_resources));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(appttypecode));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( transfer ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( value13 ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i_from_time ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i_to_time ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i_appt_date));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(over_booked));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(overbookedyn ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(str14));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(visitind));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(pre_pat_alcn_criteria));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(alcn_catg_code));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(contactvals));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(disp_fromtime));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(disp_totime));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(time_tab_val1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(contactAddress.toString()));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(visitshortdesc));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block153Bytes, _wl_block153);

	if (rs1 != null) rs1.close();
	//if (rssd !=null) rssd.close();
	if(rsSet !=null)rsSet.close();
	//if (Rset_Nat_Id!= null) Rset_Nat_Id.close();
	//if (rsgrp !=null) rsgrp.close();
	//if (rstt !=null) rstt.close();
	//if (stmtgrp!=null) stmtgrp.close();	
	if(stMent !=null)stMent.close();
	//if (stmtsd!=null) stmtsd.close();				
	if (pstmt != null) pstmt.close();
	//if (Stmt_Nat_Id !=null) Stmt_Nat_Id.close();
 }catch(Exception e) { 
	 e.printStackTrace();
 }
	finally
	{
		if(conn != null) ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block154Bytes, _wl_block154);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AppointmentDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AppointmentDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactReason.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contactmode.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivingDateTime.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedOn.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apply.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }
}
