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
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyappointmentdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AddModifyAppointmentDetails.jsp", 1742300858512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> \t\t\t\t\t\t\t\t\t\t \n---------------------------------------------------------------------------------------------------------------\n-->\n\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="   \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>  \n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eOA/js/AppointmentDetails.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));parent.window.close();</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body onLoad=\'sh_focus();\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onUnLoad=\"clearSession()\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\n<center>\n<form name=\'apptdetails_form\' id=\'apptdetails_form\' action=\'../../servlet/eOA.AppointmentDetailsServlet\' method=\'post\' target=\'messageFrame\'>\n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'CANCEL_APPOINTMENT\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'98%\' align=\'center\' valign=\'top\' >\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\n\t<tr>\n\t\t<td colspan=\'2\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<td class=\'COLUMNHEADER\'  nowrap colspan=\'2\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td  class=\'COLUMNHEADER\'  nowrap colspan=\'2\'>&nbsp;</td>\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</tr>\n\n\t\n\t<tr>\n    \t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n    \t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n    \t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" - ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t</tr>\t\n\n\t\n\n\t<tr>\t\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\n\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t<!--<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\n\t\t<td  class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>-->\n      \t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\n\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t\t\t\t\n\t</tr>\n\n    <tr>\n\t\t<!--<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\n\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>-->\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n      \t\n\t\t<td  class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t<td  class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\t \n\t</tr>\n\t\t\t\t\t\n\n\t\n\t<!--<tr>\t\n\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n      \t\n\t\t<td  class=\'label\'  nowrap colspan=\'2\'>&nbsp;</td>\t\t\t\n\n\t</tr>-->\n\n\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<tr>\n    \t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\n\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td   class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t</tr>\t\t\t\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\n\t\t\t\t\t<td   class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n      \t\t\t\t\n\t\t\t\t\t\n    \t\t</tr>\n\n\n\t\t<tr>\n\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t</tr>\n\n\t\t\t<tr>\n      \t\t\t\t<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td  class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t</tr>\n\t\n    \t\t<tr>\n    \t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'QUERYDATA\'nowrap>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t<tr><td class=\'label\'  colspan=\'4\' nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td> </tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n    \t\t\n  \t\n\t<tr> \n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t</tr>\n\t\t\n    \t<tr>\n    \t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\n\t\t\t<td  class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\n\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td> \n\n\t\t\t<td  class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n      \n\t\t</tr>\n    \t\t\t\n    \t<tr>\n    \t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t\n\t\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\n\t\t\t\t<td align=\'right\' class=\'label\' width=\'16%\' nowrap>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\n\t\t\t\t\t<td  class=\'QUERYDATA\'nowrap>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t<input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'  size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"> - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\'   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" size=\'3\' maxlength=\'5\'  value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' onBlur=\'CheckTime(this,\"TO\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\">\n\t\t\t\t\t</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n\t\t\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t<td  class=\'label\'  nowrap colspan=\'4\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\n\t\n\t<td width=\'100%\'  colspan = 4 nowrap>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</th>\n\t\t\t\t\t\n\n\t<tr><td   class=\'QUERYDATA\' nowrap colspan = 4>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td></tr>\n\t<tr><td   class=\'QUERYDATA\' nowrap colspan = 4>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td></tr>\t\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\n  <tr><td colspan = 4 class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" </td></tr>\n  \n \n    \t<tr>\n    \t\t<td class=\'label\'  nowrap> ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n    \t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n    \t</tr>\n\n\t\t<tr>\n\t\t\t\t<td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t<td  class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr colspan=\'4\'>\n\t\t<tr>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t\t<td   class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t<td class=\'label\' colspan =2>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n\t\t   <tr>\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t\t<td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<td  class=\'label\'  colspan =2></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\t\t\t\t<td class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t<td  class=\'label\' colspan =2></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t<td class=\'label\' colspan=2></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'QUERYDATA\' nowrap >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t</tr>\n\t\t\t\n\n\n\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t\t\n\t\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t\t\n\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t\t<td   class=\'label\' nowrap>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="Y&nbsp;";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="M&nbsp;";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="D&nbsp;</td>\n\t\t\t\t<td   class=\'label\'  nowrap>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t\t\t\t<td  class=\'QUERYDATA\' >\n\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\t<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\t\n\t\t\t\t\t</td>\n\t\t\t\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t\t\t\t\t<td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\n\t\t\t\t\t\t<td class=\'label\'  nowrap >";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n\t\t\t\t\t\t<td  class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t<td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n\t\t\t\t\t\t<td   class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\'  nowrap >";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="   \n\t\t\t</tr>\t\t\t\n\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\n\n\t\t\t\t\t\n\t\t\n\t\t\t<tr>\n\t             <td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t\t\t\t <td  class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\n\t\t\t\t <td class=\'button\' colspan=\'2\' align=\'right\'>\n\t\t\t\t \t<input type=\'button\' name=\'ContactDetails\' id=\'ContactDetails\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' onClick=\'Modal_Contact_Details()\' class=\"BUTTON\" >\n\t\t\t\t\n\t\t\t\t </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t    ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n                <td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t\t\t\t<td class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n            </tr>\n\t\t\t\n\n\n<tr><td colspan =4 class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td></tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t   <td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n\t\t\t   <td class=\'QUERYDATA\' nowrap colspan = 3>";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  nowrap>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n\t\t\t\t<td  class=\'QUERYDATA\' style=\'word-wrap: break-word;width:930px\' colspan =3>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</td><!--Modified by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058-->\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\n\t\t\t\t<td  class=\'QUERYDATA\'   nowrap>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</td>\n\n\t\t\t\t<td align=\'right\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n\n\t\t\t\t<td class=\'QUERYDATA\'  nowrap>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</td>\n\t\t\t</tr>\n\t\t\t\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' nowrap id=\"RecordedByID\">";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n\n\t\t\t\t<td   class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</td>\n\t\t\t\t\t\n\t\t\t\t<td align=\'right\' class=\'label\'  nowrap>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\n\t\t\t\t<td align=\'left\'  class=\'QUERYDATA\'nowrap>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t\t\t</tr>\t\t\t\n\t\n\t<tr>\n\t\t<td colspan =4 class=\'WHITE\' ></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t</table>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t<script>\n\t\tvar err_age3 = getMessage( \"CURRENTLY_IN_PATIENT\",\"Common\");\n        alert(err_age3);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\n\n\n\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' id=\'revisetxt\' >\n\t<tr>\n\t   <td width=\"100%\" >\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\n\t\t<tr>\n\t\t\t\t<td  class=\'label\'  width=\'20%\' nowrap>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t\t\t<input type=\'text\' name=\'reason_code_cancel\' id=\'reason_code_cancel\' value=\'\' onblur=\'reasonlookup_blur(this);displayRemarksForOtherReason(reason_for_cancellation);\' size=30 maxlength=30 ><input type=\'button\' value=\'?\' onclick=\'reasonlookup();displayRemarksForOtherReason(reason_for_cancellation);\' class=\'button\' name=\'reasonclick\' id=\'reasonclick\'><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\t\n\n\t\t\t\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t\t\t<td class=label id=\'remarks_labl\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t\t\t\t<td class=\"fields\" id=\'remarks_fld\' style=\'visibility:hidden\'><textarea rows=2 cols=45 name=\"other_remarks\" onkeyPress=\'checkMaxLimit(this,100)\' onBlur=\"SPCheckMaxLen(\'Remarks\',this,100)\"></textarea><img src=\'../../eCommon/images/mandatory.gif\' id=\'remarks_img\' style=\'visibility:hidden\'></td>\n\t\t\t\t<!--End ML-MMOH-CRF-1114-->\n         </tr>\n\t\t \t\t\t\t\t\n\t\t\t\t   <input type=\'hidden\' name=\'reason_for_cancellation\' id=\'reason_for_cancellation\' value=\'\'>\n\t\t \n\t\t <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t <tr>\n\t\t\t<td class=\'label\' colspan=4>&nbsp;</td>\n\t\t </tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t</table>\n\n\n ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'center\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="<input type =checkbox name=\'CnfmyesOrNo\' id=\'CnfmyesOrNo\' value =\'Y\' onClick=\'checkBoxValue(this)\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n   </table>\n ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\n\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\t\n\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'right\' id=\'allbuttons\'>\n\t\t\t\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'right\' id=\'allbuttons\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t<tr><td class = label colspan = 5></td></tr>\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t<td width=\'90%\'><input type=\'button\' name=\'patInsbutton\' id=\'patInsbutton\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' onclick=\"show_patinstructions(\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\')\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t<td width=\'90%\'>&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t<td width=\'90%\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\t\t\t\t\n\t\t\t\t<td>\n\t\t\t\t<input type=\'button\' name=\'vaudittria\' id=\'vaudittria\'  value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' class=\"BUTTON\" onclick=\'audittrial(\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\",\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\")\' >\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t<td   align=\'right\' >\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'button\' name=\'revappt\' id=\'revappt\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' class=\"BUTTON\" onclick=\'sh_layer1(\"trans\")\' id=\'hid\'>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'revappt\' id=\'revappt\' value=\'\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'revappt\' id=\'revappt\' value=\'\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'revappt\' id=\'revappt\' value=\'\'>\n\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\t\n\t\t\t\t\t\t\t<td   align=\'right\' >\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'button\' name=\'cancelappt\' id=\'cancelappt\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'  class=\"BUTTON\" onclick=\'sh_layer()\' id=\'canhid\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t<td colspan=6 align=right nowrap class=\'label\'><input type=\'button\' name=\'sec res\' id=\'sec res\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'  class=\"BUTTON\" onclick=\"javascript:show_Reference_details(\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\',\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\')\" ></td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t<td  align=\'right\' ><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'  class=\"BUTTON\" onclick=\'exitwin_normal(); \'>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'5%\' align=\'right\' id=\'allbuttons\'>\n\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\n\t\t\t\t\n\t\t\t\t\t<td colspan=6 align=right nowrap class=\'label\'><input type=\'button\' name=\'sec res\' id=\'sec res\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\')\" ></td>\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t<td  align=\'right\'><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'  class=\"BUTTON\" onclick=\'exitwin_normal()\'>\n\t\t\t<input type=\'hidden\' name=\'cancelappt\' id=\'cancelappt\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'revappt\' id=\'revappt\' value=\'\'>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\n\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'right\' id=\'ip_button\' class=\'white\'>\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\n\t\t\t\t\t\t\t<td  align=right nowrap class=\'white\'><input type=\'button\' name=\'sec res\' id=\'sec res\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\')\" ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  align=\'right\' class=\'white\'><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'  class=\"BUTTON\" onclick=\'exitwin_normal()\'>\n\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'right\' id=\'reg_button\' class=\'white\'>\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\')\" ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'  class=\"BUTTON\" onclick=\'exitwin_normal()\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\n                \n\n\t\t\t\t\t\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'middle\' id=\'cancelbuttons\'>\n\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' class=\'WHITE\' width=\'75%\'>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t\n                   \n\t\t\t\t\t<td   align=\'right\' class=\'BODYCOLORFILLED\'><input type=\'button\' name=\'confcancel\' id=\'confcancel\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' class=\"BUTTON\" onclick=\'valcheck1(this)\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t<td   align=\'right\' class=\'BODYCOLORFILLED\'><input type=\'button\' name=\'abcancel\' id=\'abcancel\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'  class=\"BUTTON\" onclick=\'sh_focus()\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\n\n\t\t\t\t\t<td  align=\'right\' class=\'BODYCOLORFILLED\'><input type=\'button\' name=\'cancelclose\' id=\'cancelclose\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'  class=\"BUTTON\" onclick=\'exitwin();\' >\n\t\t\t\t\t</td>\n\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t</table>\n\t<BR>\n\t\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' id=\'revisetxt1\' >\n\t\t<tr>\n\t\t\t<td  class=\'label\'nowrap width=\'23%\'>";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</td>\n\t\t\t\n\t\t\t<!--displayRemarksForRev() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t\t<td class=\'fields\' colspan=\'3\'>\t\t\t\n\t\t\t<input type=\'text\' name=\'reason_for_revision\' id=\'reason_for_revision\' value=\'\' onblur=\'reasonlookup_revise_blur(this);displayRemarksForRev(reason_code_revision);\' size=30 maxlength=30 ><input type=\'button\' value=\'?\' onclick=\'reasonlookup_revise();displayRemarksForRev(reason_code_revision);\' class=\'button\' name=\'reasonclick\' id=\'reasonclick\'><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t<input type=\'hidden\' name=\'reason_code_revision\' id=\'reason_code_revision\' value=\'\'></td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\n\t\t\t<!--displayRemarksForOvr() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t\t<td  class=\'label\'nowrap width=\'23%\'>";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</td>\t\t\t\n\t\t\t<td class=\'fields\'>\t\t\t\n\t\t\t<input type=\'text\' name=\'pract_override_reason_desc\' id=\'pract_override_reason_desc\' value=\'\' onblur=\"reasonForOverride(this,pract_override_reason_desc,\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\');displayRemarksForOvr(pract_override_reason);\" size=\'35\' maxlength=\'30\'><input type=\'button\' class=\'button\' value=\'?\'  name=\'search_reason\' id=\'search_reason\' onClick=\"reasonForOverrideLookup(this,pract_override_reason_desc,\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\');displayRemarksForOvr(pract_override_reason);\"><img id = \'pract_override_reason_img\' src = \'../../eCommon/images/mandatory.gif\'></img><input type=\'hidden\' name=\'pract_override_reason\' id=\'pract_override_reason\' value=\'\'></td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t</tr>\n\t\t\n\t\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t<tr>\n\t\t\t<td class=label id=\'rev_remarks_labl\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</td>\n\t\t\t<td class=\"fields\" id=\'rev_remarks_fld\' style=\'visibility:hidden\'><textarea rows=2 cols=45 name=\"rev_other_remarks\" onkeyPress=\'checkMaxLimit(this,100)\' onBlur=\"SPCheckMaxLen(\'Remarks\',this,100)\"></textarea><img src=\'../../eCommon/images/mandatory.gif\' id=\'rev_remarks_img\' style=\'visibility:hidden\'></td>\n\n\t\t\t<td class=label id=\'ovr_remarks_labl\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="</td>\n\t\t\t<td class=\"fields\" id=\'ovr_remarks_fld\' style=\'visibility:hidden\'><textarea rows=2 cols=45 name=\"ovr_other_remarks\" onkeyPress=\'checkMaxLimit(this,100)\' onBlur=\"SPCheckMaxLen(\'Remarks\',this,100)\"></textarea><img src=\'../../eCommon/images/mandatory.gif\' id=\'ovr_remarks_img\' style=\'visibility:hidden\'></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=4>&nbsp;</td>\n\t\t</tr>\n\t\t<!--End ML-MMOH-CRF-1114-->\n</table>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'center\' id=\'allbuttons\'>\n\t<tr>\n\t<td><input type=\'button\' name=\'confrev\' id=\'confrev\' value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\' class=\"BUTTON\" onclick=\'PatInsModalWindow(\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\")\' style=\'visibility:";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =";display:";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'></td>\n\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t\t<td><input type=\'button\' name=\'secres\' id=\'secres\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\' class=\"BUTTON\" onclick=\"show_second()\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t<td   class=\'button\' align=\'right\'>\t\t\t\t\t\t\n\t\t<input type=\'button\' name=\'confrev\' id=\'confrev\' value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\' class=\"BUTTON\" onclick=\'valcheck()\'>&nbsp;\n\t\t<input type=\'button\' name=\'cancelclose\' id=\'cancelclose\' value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'  class=\"BUTTON\" onclick=\'parent.window.close()\'>\n\t</td><!-- Transfer Appointment Ends-->\n";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'right\' id=\'allbuttons\'>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\t\n\t\t\t<td width=\'99%\'><input type=\"button\" class=\"BUTTON\" name=\"pat_ins\" id=\"pat_ins\" value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\')\"></td>\n\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t<td width=\'75%\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\n\t\t\t\t\n\t\t\t\t\t\t<td colspan=6 align=right nowrap class=\'label\'><input type=\'button\' name=\'sec res\' id=\'sec res\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\')\" ></td>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t\t\t<td  align=\'right\' class=\'BODYCOLORFILLED\'><input type=\'button\' name=\'reviseclose\' id=\'reviseclose\' value=\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\'  class=\"BUTTON\" onclick=\'exitwin()\' style=\"margin-right: 15px;\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\n<script>\nif(document.getElementById(\'cancelappt\'))\n\tdocument.getElementById(\'cancelappt\').disabled=true;\n</script>\n";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n<script>\nif(document.getElementById(\'cancelappt\'))\n\tdocument.getElementById(\'cancelappt\').disabled=false;\n</script>\n";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n<script>\nif(document.getElementById(\'revappt\'))\n\tdocument.getElementById(\'revappt\').disabled=true;\n</script>\n";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n<script>\nif(document.getElementById(\'revappt\'))\n\tdocument.getElementById(\'revappt\').disabled=false;\n</script>\n";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\n\n\n\n\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t<input type=\'hidden\' name=\'apptstatus\' id=\'apptstatus\' value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'>\n\t<input type=\'hidden\' name=\'function1\' id=\'function1\' value=\'\'>\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t<input type=\'hidden\' name=\'transfer\' id=\'transfer\' value=";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 =" >\n\t<input type=\'hidden\' name=\'value13\' id=\'value13\' value=";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 =" >\n\t<input type=\'hidden\' name=\'new_from_time\' id=\'new_from_time\' value=";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =" >\n\t<input type=\'hidden\' name=\'new_to_time\' id=\'new_to_time\' value=";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =" >\n\t<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\'  value=";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 =" >\n\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 =" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =" >\n\t<input type=\'hidden\' name=\'dateapd\' id=\'dateapd\' value=";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 =" >\n\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =" >\n\t<input type=\'hidden\' name=\'overbooked_yn\' id=\'overbooked_yn\' value=";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 =" >\n\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'>\n\t<input type=\'hidden\' name=\'ServerTime\' id=\'ServerTime\' value=\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\' >\n\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'>\n\t<input type=\'hidden\' name=\'visitind\' id=\'visitind\' value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\' >\n\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\' >\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\' > <!--Added for the CRF Bru-HIMS-CCRF-169 -->\n\t<input type=\'hidden\' name=\'old_from_time\' id=\'old_from_time\' value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\' >\n\t<input type=\'hidden\' name=\'old_to_time\' id=\'old_to_time\' value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\' >\n\t<input type=\'hidden\' name=\'pre_alcn_criteria\' id=\'pre_alcn_criteria\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\' >\n\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\' >\n\t<input type=\'hidden\' name=\'pre_pat_alcn_catg_code\' id=\'pre_pat_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\' >\n\t<input type=\'hidden\' name=\'alcn_catg_code\' id=\'alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\' >\n\t<input type=\'hidden\' name=\'disp_date\' id=\'disp_date\' value=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\' >\n\t<input type=\'hidden\' name=\'contactvals\' id=\'contactvals\' value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" >\n\t<input type=\'hidden\' name=\'disp_fromtime\' id=\'disp_fromtime\' value=\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\' >\n\t<input type=\'hidden\' name=\'disp_totime\' id=\'disp_totime\' value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\' >\n\t<input type=\'hidden\' name=\'i_time_table_type\' id=\'i_time_table_type\' value=\'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\' >\n\t<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\' >\n\t<input type=\'hidden\' name=\'obook_appt_yn\' id=\'obook_appt_yn\' value=\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\' >\n\t<input type=\'hidden\' name=\'team_id\' id=\'team_id\' value=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\' >\n\t<input type=\'hidden\' name=\'cancel_flag\' id=\'cancel_flag\' value=\"\">\n\t<input type=\'hidden\' name=\'resaddrl1\' id=\'resaddrl1\' value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t<input type=\'hidden\' name=\'resaddrl2\' id=\'resaddrl2\' value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\">\n\t<input type=\'hidden\' name=\'resaddrl3\' id=\'resaddrl3\' value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n\t<input type=\'hidden\' name=\'resaddrl4\' id=\'resaddrl4\' value=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\">\n\t<input type=\'hidden\' name=\'postalcode\' id=\'postalcode\' value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t<input type=\'hidden\' name=\'countrycode\' id=\'countrycode\' value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n\t<input type=\'hidden\' name=\'Forced\' id=\'Forced\' value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n\t<input type=\'hidden\' name=\'call_function_ip\' id=\'call_function_ip\' value=\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\n\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t<input type=\"hidden\" name=\"referral_id\" id=\"referral_id\" value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\">\n\t<input type=\"hidden\" name=\"referral_value\" id=\"referral_value\" value=\"\">\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'>\n\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'>\n\t<input type=\'hidden\' name=\'order_id1\' id=\'order_id1\' value=\'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'> <!--[IN027165]-->\n\t<input type=\"hidden\" name=\"sec_resources\" id=\"sec_resources\" value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t<input type=\"hidden\" name=\"sec_sel\" id=\"sec_sel\" value=\"\">\n\t<input type=\'hidden\' name=\'modified_date_time\' id=\'modified_date_time\' value=\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\'>\n\t<input type=\'hidden\' name=\'no_of_slots\' id=\'no_of_slots\' value=\'";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\' >\n\t<input type=\'hidden\' name=\'inpatient_yn\' id=\'inpatient_yn\' value=\'";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\' >\n\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\' >\n\t<input type=\'hidden\' name=\'visitshortdesc\' id=\'visitshortdesc\' value=\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\'>\n\t<input type=\"hidden\" name=\"appttypecode\" id=\"appttypecode\" value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\t<input type=\'hidden\' name=\'clinic_name_sec\' id=\'clinic_name_sec\' value=\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'>\n\t<input type=\'hidden\' name=\'care_locn_desc_sec\' id=\'care_locn_desc_sec\' value=\'";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\'>\n\t<input type=\'hidden\' name=\'res_pri_class_desc\' id=\'res_pri_class_desc\' value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'>\n\t<input type=\'hidden\' name=\'pract_name_pri\' id=\'pract_name_pri\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'>\n\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'>\n\t<input type=\'hidden\' name=\'sec_value_count\' id=\'sec_value_count\' value=\'\'>\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'>\n\t<input type=\'hidden\' name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\'>\n\t<input type=\'hidden\' name=\'email_appl_yn\' id=\'email_appl_yn\' value=\'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\'>\n\t<input type=\'hidden\' name=\'email_appl_for_appt_wo_pid_yn\' id=\'email_appl_for_appt_wo_pid_yn\' value=\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\'>\n\t<input type=\'hidden\' name=\'emailid\' id=\'emailid\' value=\'";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\'>\n\t<input type=\'hidden\' name=\'pat_email_appl_yn\' id=\'pat_email_appl_yn\' value=\'";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\'>\n\t<input type=\'hidden\' name=\'send_email_yn\' id=\'send_email_yn\' value=\'N\'>\n\t<input type=\"hidden\" name=\"sec_sel222\" id=\"sec_sel222\" value=\"\">\n\t<input type=\"hidden\" name=\"sec_resources_number\" id=\"sec_resources_number\" value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\n\t<input type=\"hidden\" name=\"sec_resources_selected\" id=\"sec_resources_selected\" value=\"\">\n\t<input type=\"hidden\" name=\"sec_resources_selected_222\" id=\"sec_resources_selected_222\" value=\"\">\n\t<input type=\'hidden\' name=\'reason_for_cancel\' id=\'reason_for_cancel\' value=\'\'>\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'count_wait_list\' id=\'count_wait_list\' value=\'";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\'>\n\t<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\' value=\'";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\'>\n\t<input type=\'hidden\' name=\'to_clinic_alcn\' id=\'to_clinic_alcn\' value=\'";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\'>\n\t<input type=\'hidden\' name=\'to_pat_alcn_cat\' id=\'to_pat_alcn_cat\' value=\'\'>\n\t<input type=\'hidden\' name=\'transfer_alcn_yn\' id=\'transfer_alcn_yn\' value=\'N\'>\n\t<input type=\'hidden\' name=\'tfr_alcn_override_yn\' id=\'tfr_alcn_override_yn\' value=\'N\'>\n\t<input type=\'hidden\' name=\'appointment_ref\' id=\'appointment_ref\' value=\'";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\'>\n\t<input type=\'hidden\' name=\'to_over_book_yn\' id=\'to_over_book_yn\' value=\'";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\'>\n\t<input type=\"hidden\" name=\'clinicInsYN\' id=\'clinicInsYN\' value=\'";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\'>\n\t<input type=\"hidden\" name=\'orderInsYN\' id=\'orderInsYN\' value=\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\'>\n\t<input type=\"hidden\" name=\'patInsSelectYN\' id=\'patInsSelectYN\' value=\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\'>\n\t<input type=\"hidden\" name=\'procInsSelectYN\' id=\'procInsSelectYN\' value=\'";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\'>\n\t<input type=\"hidden\" name=\'i_appt_date_display\' id=\'i_appt_date_display\' value=\'";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\'>\n\t<input type=\'hidden\' name=\'starttime\' id=\'starttime\' value=\'";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\'>\n\t<input type=\'hidden\' name=\'endtime\' id=\'endtime\' value=\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'>\n\t<input type=\'hidden\' name=\'calling_mode\' id=\'calling_mode\' value=\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'>\n\t<input type=\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\'>\n\t<!--<input type=\"hidden\" name=\'orderInsStandardYN\' id=\'orderInsStandardYN\' value=\'\'>--> \n\t<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t<!--Below code was added by Venkatesh S on 11.06.2011 for SRR20056-SCF-7292 [IN:027301] -->\n\t\n\t<input type=\'hidden\' name=\'apptslabfmtime\' id=\'apptslabfmtime\' value=\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\'>\n\t<input type=\'hidden\' name=\'apptslabtotime\' id=\'apptslabtotime\' value=\'";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\'>\n\t<input type=\'hidden\' name=\'rule_based_tr\' id=\'rule_based_tr\' value=\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\'>\n\t<input type=\'hidden\' name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\'";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'>\n\t<input type=\'hidden\' name=\'frm_clinic_code\' id=\'frm_clinic_code\' value=\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'>\n\t<input type=\'hidden\' name=\'frm_pract_id\' id=\'frm_pract_id\' value=\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'>\n\t<input type=\'hidden\' name=\'wtListControl\' id=\'wtListControl\' value=\'";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\'>\n\t<input type=\'hidden\' name=\'rd_oa_integration_yn\' id=\'rd_oa_integration_yn\' value=\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\'>\n\t<input type=\'hidden\' name=\'orderCatMapped\' id=\'orderCatMapped\' value=\'";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\'>\n\t<input type=\'hidden\' name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\'>\n\t<input type=\'hidden\' name=\'group_id\' id=\'group_id\' value=\'";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\'>\n\t<!--Added for the CRF Bru-HIMS-CRF-169 start -->\n\t<input type=\'hidden\' name=\'pat_cncl_count\' id=\'pat_cncl_count\' value=\'";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\'>\n\t<input type=\'hidden\' name=\'pat_cancel_reason\' id=\'pat_cancel_reason\' value=\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\'>\n\t<input type=\'hidden\' name=\'max_cancel_appt\' id=\'max_cancel_appt\' value=\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'>\n\t<!--Added for the CRF Bru-HIMS-CRF-169 end -->\n\t<!--Added for this incident ML-BRU-SCF-1602 [IN:055253]-->\n\t<input type=\'hidden\' name=\'new_resource_class\' id=\'new_resource_class\' value=\'";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\'>\n\t<input type=\'hidden\' name=\'function_mode\' id=\'function_mode\' value=\'";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\'> \n\t<!--End ML-BRU-SCF-1602 [IN:055253]-->\n\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\"><!--Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601-->\n\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t<input type=\'hidden\' name=\'others_id\' id=\'others_id\' value=\'";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\'>\n\n<!-- Code Ends -->\n\t\n";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\n\t\n</form>\n";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.HashMap patInstructionsMap= null;synchronized(session){
                patInstructionsMap=(java.util.HashMap)pageContext.getAttribute("patInstructionsMap",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(patInstructionsMap==null){
                    patInstructionsMap=new java.util.HashMap();
                    pageContext.setAttribute("patInstructionsMap",patInstructionsMap,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
            java.util.HashMap prcInstructionMap= null;synchronized(session){
                prcInstructionMap=(java.util.HashMap)pageContext.getAttribute("prcInstructionMap",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(prcInstructionMap==null){
                    prcInstructionMap=new java.util.HashMap();
                    pageContext.setAttribute("prcInstructionMap",prcInstructionMap,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
 


patInstructionsMap.clear();
prcInstructionMap.clear();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patInsSelectYN="";
String procInsSelectYN="";
long transfer_schedule_total_time_interval=0;
//double t_t_sche=0;
String flag=request.getParameter("flag");
if(flag == null || flag.equals("undefined")) flag="";

webbeans.op.PatientData patdata = new webbeans.op.PatientData();
String order_catalog_code="";
String rd_appt_yn="";
String group_id="";
String pat_alcn_catg_code="";
String pre_alcn_catg_code="";
String pre_alcn_criteria="";
String pre_pat_alcn_catg_code="";
String team_short_desc="";
String contactvals="";
String nationality="";
String pre_cat_grp_desc="";
String receiving_date_time_display="";
String service_code="";
String SPECIALITY_CODE="";
//String facilityid=(String)session.getValue("facility_id");
String locale=(String)session.getAttribute("LOCALE");
String clinicInsYN="N";
String orderInsYN="N";
//String orderInsStandardYN="N";

//added forBru-HIMS-CRF-380 Start
String facilityid	= request.getParameter("facility_id") ;
if(facilityid==null)
	facilityid = (String) session.getValue("facility_id");
//added forBru-HIMS-CRF-380 End



//String bl_operational= (String)session.getValue("bl_operational");
String t_from_time_arry[]=new String[2];
//String t_to_time_arry[]=new String[2];
int t_from_hour=0;
int t_from_sec=0;

Statement stmt=null;
Statement stmt1=null;
Statement stmt2=null;
Statement stmt3=null;
Statement stmt4=null;
Statement stmtgrp=null;
Statement stmt_reason=null;
PreparedStatement pstmt_pat =	null;
PreparedStatement pstmt =	null;
ResultSet Rset_Nat_Id=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
ResultSet rs4=null;
ResultSet rs_pat=null;
ResultSet rs_reason=null;
ResultSet rsgrp=null;
ResultSet rs_next=null;

Connection conn = null;
Statement stmtsd=null;
Statement stmt_next=null;
ResultSet rssd=null;
String referral_line="";
String referral_line1="";
//String to_clinic_alcYN="";
String frm_clinic_code="";
String starttime="";
String endtime="";

//String pat_alcn_catg_desc ="";
String call_function_ip =request.getParameter("call_function_ip");
if(call_function_ip==null) call_function_ip="";
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
String Forced=request.getParameter("Forced");
if(Forced==null || Forced.equals("null"))
		Forced="N";

String performing_facility_id=request.getParameter("performing_facility_id");
String calling_mode=request.getParameter("calling_mode");
if(calling_mode==null) calling_mode="";
StringBuffer contactAddress=new StringBuffer();


if (alcn_catg_code==null) alcn_catg_code="";
if (performing_facility_id==null) performing_facility_id="";
if (!performing_facility_id.equals("")){
	facilityid=performing_facility_id;
}
	
try{
conn = ConnectionManager.getConnection(request);

/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(conn, "OA","REMARKS_FOR_OTHERS");
String others_id	= (String)hashdata.get("value1");
if(others_id == null) others_id = "";
/*End ML-MMOH-CRF-1114*/

String clinic_code="";
String practitioner_id="";
String over_readonly="";
String to_over_book_yn=request.getParameter("to_over_book_yn");
if(to_over_book_yn == null || to_over_book_yn.equals("")) to_over_book_yn="N";
if(to_over_book_yn.equals("Y"))
	over_readonly="readOnly";
else
	over_readonly="";
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

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(i_to_time.equals("00:00")){
	i_to_time = "23:59";
}

String order_line_num = "";
String order_id1=request.getParameter("order_id");
if(order_id1 == null) order_id1=""; //--[IN027165]--
String value13=request.getParameter("value13");
if(value13 == null) value13="";
String i_appt_date=request.getParameter("i_appt_date");
if(i_appt_date ==null ) i_appt_date="";
String over_booked=request.getParameter("over_booked");
if(over_booked == null) over_booked="";

String i_time_table_type=request.getParameter("i_time_table_type");
if(i_time_table_type == null) i_time_table_type="";
String old_date=(String)request.getParameter("old_date");
if(old_date  == null || old_date.equals("null")) old_date="";
if(apptrefno.equals("hjjh")) { apptrefno=value13; }
String old_from_time = (String)request.getParameter("old_from_time");

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
String resource_class="";
String new_resource_class="";
String new_res_class_desc="";
int xsec_res=0;
/*Above Line commented for this incident [35078]*/
// Added for this incident ML-BRU-SCF-1602 [IN:055253]
if(res_type.equals("P")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}else if(res_type.equals("B")){
	new_res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
}
// Added for this incident ML-BRU-SCF-1602 [IN:055253]

String function_mode=request.getParameter("function_mode");
if(function_mode ==null) function_mode="";

if(!function_mode.equals("")&&function_mode.equals("transfer"))new_resource_class=res_type;


String sec_resources="";
String title = request.getParameter("title")==null?"Cancellation":request.getParameter("title");
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
String apptstatus="";
String visitshortdesc="";
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
String ALCN_CRITERIA_YN="";
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
String postal_desc="";
String mail_postal_desc="";
String order_id="";
String str13="";
String str14="";
String modified_date_time="";
String inpatient_yn ="N";
String capture_fin_dtls_yn="N";
String email_appl_yn="";
String rd_oa_integration_yn="N";
String orderCatMapped="N";
String email_appl_for_appt_wo_pid_yn="";
String pat_email_appl_yn="";
String slot_appt_ctrl="";
String to_clinic_alcn="";
String entitlement_by_pat_cat_yn="";
String rule_appl_yn="N";
String rule_based_tr 	= request.getParameter("rule_based_tr")==null?"N":request.getParameter("rule_based_tr");
String prefPractYN		= request.getParameter("prefPractYN")==null?"Y":request.getParameter("prefPractYN");
/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
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
 
String wtListControl			= request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");

int sec_cnt=0;
stmt1=conn.createStatement();
stmt_next=conn.createStatement();

ALCN_CRITERIA_YN="None";

int no_of_slots=0;

//Bru-HIMS-CRF 169 changes start
String pat_cncl_count=request.getParameter("pat_cncl_count"); 

int max_cancel_appt=0;
String pat_cancel_reason="";
//Bru-HIMS-CRF 169 changes end

if(i_time_table_type!=null && i_time_table_type.equals("1")){
String no_slots="select to_char((to_date(to_char(a.appt_slab_to_time,'dd/mm/yyyy')||'"+i_to_time+"','dd/mm/yyyy hh24:mi')-to_date(to_char(a.appt_slab_from_time,'dd/mm/yyyy')||'"+i_from_time+"','dd/mm/yyyy hh24:mi'))*a.no_of_slots+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+i_from_time+"','dd/mm/yyyy hh24:mi'),'hh24:mi') to_time, a.no_of_slots from oa_appt a  where a.facility_id='"+facilityid+"' and a.appt_ref_no='"+apptrefno+"' ";

if (rs1!=null) rs1.close();
rs1   = stmt1.executeQuery(no_slots) ;
while (rs1 !=null && rs1.next()){
no_of_slots=rs1.getInt("no_of_slots");

if (no_of_slots>1)
	i_to_time = rs1.getString("to_time");
}
}

// String sql="select (select count(appt_ref_no) seccnt from oa_resource_for_appt where appt_ref_no ='"+apptrefno+"' and FACILITY_ID='"+facilityid+"') seccnt,b.appl_user_name,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, a.facility_id, a.appt_ref_no, a.clinic_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC,a.practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, a.appt_date, to_char(a.appt_time,'hh24:mi') appt_time, to_char(a.appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(a.appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(a.appt_duration,'hh24:mi') appt_duration, a.appt_slots, a.patient_id ,a.name_prefix, a.first_name, a.second_name, a.third_name,a.family_name, a.name_suffix,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender, a.date_of_birth, a.res_tel_no res_tel_no,a.oth_contact_no, a.national_id_no, a.res_addr_line1, a.res_addr_line2, a.res_addr_line3,  a.res_addr_line4, a.postal_code, a.country_code,MP_GET_DESC.MP_COUNTRY(a.COUNTRY_CODE,'"+locale+"','1') nationality, a.appt_type_code,( SELECT visit_type_ind  FROM op_visit_type WHERE visit_type_code = a.appt_type_code AND facility_id = a.facility_id) VISIT_TYPE_IND,a.overbooked_yn,a.referral_id, a.mode_of_contact,a.contact_reason_code,AM_GET_DESC.AM_CONTACT_REASON(a.CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,a.appt_remarks, a.appt_status, a.inpatient_yn, a.encounter_id,a.email_id,a.alcn_criteria,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3) day1 ,a.alcn_catg_code,a.referral_id,a.team_id,null team_desc,a.pat_alcn_catg_code, MP_GET_DESC.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(a.RACE_CODE,'"+locale+"','1') RACE_DESC, CITIZEN_YN, LEGAL_YN, MP_GET_DESC.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,to_char(a.receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,a.RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, a.RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, a.RES_REGION_CODE, MP_GET_DESC.MP_REGION(a.RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC, a.RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2, a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4, a.MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, a.MAIL_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC, a.MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC, a.MAIL_POSTAL_CODE, a.MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,a.ALT_ID1_TYPE,a.ALT_ID1_NO,to_char(a.ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,a.ALT_ID2_TYPE,a.ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,a.ALT_ID3_TYPE,a.ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,a.ALT_ID4_TYPE,a.ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,a.OTH_ALT_ID_TYPE,a.OTH_ALT_ID_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"','2') alt_type_desc,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_type_desc,AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"',2)service_code, a.order_id order_id,a.order_line_num,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm ,(SELECT nat_id_prompt FROM mp_param_lang_vw where module_id='MP' and language_id='"+locale+"') nat_id_prompt,to_char (a.modified_date,'dd/mm/yyyy hh24:mi') modified_date ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,'"+locale+"','1') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','1') mail_postal_desc, SPECIALITY_CODE,resource_class,order_catalog_code,rd_appt_yn,group_id from oa_appt a ,SM_APPL_USER_LANG b where a.facility_id='"+facilityid+"' and a.appt_ref_no='"+apptrefno+"' and b.language_id='"+locale+"' and a.added_by_id =b.appl_user_id";
/* 'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') Added for HSA-SCF-0054 By Dharma */

StringBuffer sql=new StringBuffer();
sql.append("select (select count(appt_ref_no) seccnt from oa_resource_for_appt where appt_ref_no ='"+apptrefno+"' and FACILITY_ID='"+facilityid+"') seccnt,b.appl_user_name,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time, a.facility_id, a.appt_ref_no, a.clinic_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC,a.practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, a.appt_date, to_char(a.appt_time,'hh24:mi') appt_time, to_char(a.appt_slab_from_time,'hh24:mi') appt_slab_from_time, to_char(a.appt_slab_to_time,'hh24:mi') appt_slab_to_time, to_char(a.appt_duration,'hh24:mi') appt_duration, a.appt_slots, a.patient_id ,a.name_prefix, a.first_name, a.second_name, a.third_name,a.family_name, a.name_suffix,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender, a.date_of_birth, a.res_tel_no res_tel_no,a.oth_contact_no, a.national_id_no, a.res_addr_line1, a.res_addr_line2, a.res_addr_line3,  a.res_addr_line4, a.postal_code, a.country_code,MP_GET_DESC.MP_COUNTRY(a.COUNTRY_CODE,'"+locale+"','1') nationality, a.appt_type_code,( SELECT visit_type_ind  FROM op_visit_type WHERE visit_type_code = a.appt_type_code AND facility_id = a.facility_id) VISIT_TYPE_IND,a.overbooked_yn,a.referral_id, a.mode_of_contact,a.contact_reason_code,AM_GET_DESC.AM_CONTACT_REASON(a.CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON,a.appt_remarks, a.appt_status, a.inpatient_yn, a.encounter_id,a.email_id,a.alcn_criteria,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) year1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) month1,calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3) day1 ,a.alcn_catg_code,a.referral_id,a.team_id,null team_desc,a.pat_alcn_catg_code, MP_GET_DESC.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC,MP_GET_DESC.MP_RACE(a.RACE_CODE,'"+locale+"','1') RACE_DESC, CITIZEN_YN, LEGAL_YN, MP_GET_DESC.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC,to_char(a.receiving_date_time,'dd/mm/yyyy HH24:mi') receiving_date_time,a.RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"','1') RES_AREA_DESC, a.RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, a.RES_REGION_CODE, MP_GET_DESC.MP_REGION(a.RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC, a.RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME,a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2, a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4, a.MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, a.MAIL_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC, a.MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC, a.MAIL_POSTAL_CODE, a.MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME,a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc, a.ALT_ID1_TYPE,a.ALT_ID1_NO,to_char(a.ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE ,a.ALT_ID2_TYPE,a.ALT_ID2_NO,to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE,a.ALT_ID3_TYPE,a.ALT_ID3_NO,to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE,a.ALT_ID4_TYPE,a.ALT_ID4_NO,to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE,a.OTH_ALT_ID_TYPE,a.OTH_ALT_ID_NO,");
sql.append("MP_GET_DESC.MP_ALTERNATE_ID_TYPE(OTH_ALT_ID_TYPE,'"+locale+"','2') alt_type_desc,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_type_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_type_desc,AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"',2)service_code, a.order_id order_id,a.order_line_num,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm ,(SELECT nat_id_prompt FROM mp_param_lang_vw where module_id='MP' and language_id='"+locale+"') nat_id_prompt,to_char (a.modified_date,'dd/mm/yyyy hh24:mi') modified_date ,MP_GET_DESC.mp_postal_code(POSTAL_CODE,'"+locale+"','2') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','2') mail_postal_desc, SPECIALITY_CODE,resource_class,order_catalog_code,rd_appt_yn,group_id from oa_appt a ,SM_APPL_USER_LANG b where a.facility_id='"+facilityid+"' and a.appt_ref_no='"+apptrefno+"' and b.language_id='"+locale+"' and a.added_by_id =b.appl_user_id");//Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601

rs1=stmt1.executeQuery(sql.toString());
if(rs1 != null) 
{
	if(rs1.next()) //this block woke
	{  
		  sec_cnt=rs1.getInt("seccnt");	

		  frm_clinic_code=rs1.getString("CLINIC_CODE");
		  team_id=rs1.getString("team_id");
		  if(team_id==null)team_id="";
		  user_name=rs1.getString("appl_user_name");
		  if(user_name==null)user_name="";
		  record_date=rs1.getString("added_date");
		  if(record_date==null)record_date="";
		  team_short_desc=rs1.getString("team_desc");
		  if(team_short_desc==null)team_short_desc="";
		  referral_id=rs1.getString("referral_id");
		  if(referral_id==null)referral_id="";
		  nationality=rs1.getString("nationality");
		  if(nationality==null) nationality="";
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

			modified_date_time=rs1.getString("modified_date");
			if(modified_date_time ==null) modified_date_time="";

		 visitshortdesc=rs1.getString("visit_type_short_desc");
		 if(visitshortdesc == null) visitshortdesc="";
	
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
		 if(alt_type_desc == null) alt_type_desc="";

			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
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
     SPECIALITY_CODE=rs1.getString("SPECIALITY_CODE");
     order_catalog_code=rs1.getString("order_catalog_code")==null?"":rs1.getString("order_catalog_code");
     rd_appt_yn=rs1.getString("rd_appt_yn")==null?"N":rs1.getString("rd_appt_yn");
     group_id=rs1.getString("group_id")==null?"":rs1.getString("group_id");
	
	 /*Above Line Added for this incident[35078]*/
	 resource_class=rs1.getString("resource_class");
	 if(resource_class == null) resource_class="P";	 
	 res_type=resource_class;
	 if(resource_class.equals("P")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
     }else if(resource_class.equals("E")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
     }else if(resource_class.equals("R")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
     }else if(resource_class.equals("O")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
     }else if(resource_class.equals("B")){
	 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
     }
	 
	 //End incident[35078]
	 
     ALT_ID1_Desc=rs1.getString("alt_id1_type_desc");
	 ALT_ID2_Desc=rs1.getString("alt_id2_type_desc");
	 ALT_ID3_Desc=rs1.getString("alt_id3_type_desc");
	 ALT_ID4_Desc=rs1.getString("alt_id4_type_desc");
	 service_code=rs1.getString("service_code");
	 if(service_code==null)service_code="&nbsp;";
	 nat_id_prompt=rs1.getString("nat_id_prompt");
	 if (nat_id_prompt == null)
		{
		  nat_id_prompt= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
		}

	 if (SPECIALITY_CODE==null) SPECIALITY_CODE="";
	 if (ALT_ID1_Desc==null) ALT_ID1_Desc="";
	 if (ALT_ID2_Desc==null) ALT_ID2_Desc="";
	 if (ALT_ID3_Desc==null) ALT_ID3_Desc="";
	 if (ALT_ID4_Desc==null) ALT_ID4_Desc="";
     ALT_ID1_Desc=ALT_ID1_Desc.trim();
	 ALT_ID2_Desc=ALT_ID2_Desc.trim();
	 ALT_ID3_Desc=ALT_ID3_Desc.trim();
	 ALT_ID4_Desc=ALT_ID4_Desc.trim();

	 str13=rs1.getString("sysdt");
	  str14=rs1.getString("systm");

		order_line_num=rs1.getString("order_line_num")==null?"":rs1.getString("order_line_num");
		order_id=rs1.getString("order_id");
		if(order_id ==null) order_id="";
		receiving_date_time=rs1.getString("receiving_date_time");
		 if(receiving_date_time == null) receiving_date_time="";
		 receiving_date_time_display=DateUtils.convertDate(receiving_date_time,"DMYHM","en",locale);

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
		 stmt2=conn.createStatement(); 	

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
		contactAddress.append(RES_COUNTRY_NAME+"^^");
		contactAddress.append(MAIL_COUNTRY_NAME+"^^");
		contactAddress.append(postal_desc+"^^");
		contactAddress.append(mail_postal_desc+"^^");
		/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
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
    pre_alcn_catg_code=rs1.getString("alcn_catg_code");
   if(pre_alcn_catg_code == null)pre_alcn_catg_code="";
	mode=rs1.getString("mode_of_contact");
	if(mode==null) 
	{
		mode="";
	}
	else 
	{
		if(mode.equals("E")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
		}
		else if(mode.equals("T")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.telephone.label","common_labels");
		}
		else if(mode.equals("F")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
		}
		else if(mode.equals("I")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InPerson.label","common_labels");
	    }
	    else if(mode.equals("W")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Web.label","common_labels");
	    }
	    else if(mode.equals("O")) {
			modedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
		}
	}

	reasoncode=rs1.getString("contact_reason_code");
	if(reasoncode == null) reasoncode="";
	reasondesc=rs1.getString("contact_reason");
	if(reasondesc == null) reasondesc="";
	apptremarks=rs1.getString("appt_remarks");
	if(apptremarks==null)
	apptremarks="";
	apptstatus=rs1.getString("appt_status");
	pre_alcn_criteria=rs1.getString("alcn_criteria");
	pat_alcn_catg_code=rs1.getString("pat_alcn_catg_code");
	
	} // end of if rs.next()
	else{
            _bw.write(_wl_block11Bytes, _wl_block11);

	
	}
}

if(rs1 !=null) rs1.close();

 

String Bl_sql="select RULE_APPL_YN,CAPTURE_FIN_DTLS_YN,EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,SLOT_APPT_CTRL,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN ,(select 'Y' from op_catalog_for_clinic where clinic_code = '"+frm_clinic_code+"' and order_catalog_code = '"+order_catalog_code+"' and facility_id = '"+facilityid+"') orderCatMapped,rd_oa_integration_yn,PAT_CANCEL_REASON,MAX_CANCEL_APPT FROM oa_param where module_id='OA'";

if (rs1!=null) rs1.close();
rs1   = stmt1.executeQuery(Bl_sql) ;

while (rs1 !=null && rs1.next()){
rule_appl_yn=rs1.getString("RULE_APPL_YN")==null?"N":rs1.getString("RULE_APPL_YN");
capture_fin_dtls_yn=rs1.getString("CAPTURE_FIN_DTLS_YN");
slot_appt_ctrl=rs1.getString("SLOT_APPT_CTRL");
entitlement_by_pat_cat_yn=rs1.getString("ENTITLEMENT_BY_PAT_CAT_YN");
email_appl_yn=rs1.getString("EMAIL_APPL_YN")==null?"N":rs1.getString("EMAIL_APPL_YN");
email_appl_for_appt_wo_pid_yn=rs1.getString("email_appl_for_appt_wo_pid_yn")==null?"N":rs1.getString("email_appl_for_appt_wo_pid_yn");
orderCatMapped=rs1.getString("orderCatMapped")==null?"N":rs1.getString("orderCatMapped");
rd_oa_integration_yn=rs1.getString("rd_oa_integration_yn")==null?"N":rs1.getString("rd_oa_integration_yn");
//Bru-HIMS-CRf 169 changes start
pat_cancel_reason=rs1.getString("PAT_CANCEL_REASON")==null?"N":rs1.getString("PAT_CANCEL_REASON");
max_cancel_appt=rs1.getInt("max_cancel_appt");
//Bru-HIMS-CRf 169 changes End
}

if(rs1 !=null) rs1.close();

if(patientid!=null && !patientid.equals("")){
	String emailsql="select  b.EMAIL_APPL_YN PAT_EMAIL_APPL_YN, (select APPT_CANCELLED_COUNT from OA_PAT_CNCL_APPT_SUMMARY where patient_id='"+patientid+"' and facility_id='"+facilityid+"') appt_cancelled_count from mp_patient a, mp_pat_ser_grp b where  a.patient_id=? and a.pat_ser_grp_code=b.pat_ser_grp_code";//query modified for Bru-HIMS-CRF-169
	pstmt=conn.prepareStatement(emailsql) ;
	pstmt.setString(1,patientid);
	rs=pstmt.executeQuery() ;
	if(rs!=null && rs.next()){
		pat_email_appl_yn=rs.getString("PAT_EMAIL_APPL_YN");
		//BruHIMS CRf - 169 changes start
		if(pat_cncl_count==null){
		int pcnclcount=rs.getInt("appt_cancelled_count");
		pat_cncl_count=String.valueOf(pcnclcount);		
		//Bru-HIMS-CRF 169 changes end
		}
	}

}else{
}
String i_appt_date_display="";
	String record_date_display=DateUtils.convertDate(record_date,"DMYHM","en",locale);

	String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);

	 i_appt_date_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);

	String dateofbirth_display=DateUtils.convertDate(dateofbirth,"DMY","en",locale);

	if (rs1 != null) rs1.close();
	
	 if(pre_alcn_criteria==null) pre_alcn_criteria="";
	 if(pat_alcn_catg_code==null) pat_alcn_catg_code="";
	 if(pre_pat_alcn_catg_code.equals("")){
		pre_pat_alcn_catg_code=pat_alcn_catg_code;
	 }
    stmtsd=conn.createStatement();

if(rssd !=null)rssd.close();
	
	 if(!(referral_id.equals(""))){
	 String sql_refral="select substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),3,70) ref_line1,substr(get_referral_detail_line('"+referral_id+"','FROM','"+locale+"'),73) ref_line2 from dual";
	 rssd=stmtsd.executeQuery(sql_refral);
	 rssd.next();
	 referral_line=rssd.getString("ref_line1");
	  referral_line1=rssd.getString("ref_line2");
	   if(referral_line1 ==null) referral_line1="";
	 }else{
	 
	 }

String practitionerName="";
	
if (practitioner_id!=""){
	String ss="";
   //Added for this incident ML-BRU-SCF-1602 [IN:055253]
  if(!function_mode.equals("")&&function_mode.equals("transfer")){
	    if(new_resource_class.equals("P")){
			ss="select practitioner_name from am_practitioner_LANG_VW where practitioner_id = '"+practitioner_id+"' AND language_id='"+locale+"'";
		}else if(new_resource_class.equals("R")){
			ss="select short_desc descrip from am_facility_room_LANG_VW where room_num ='"+practitioner_id+"' and OPERATING_FACILITY_ID='"+facilityid+"'  AND language_id='"+locale+"'";
		}else {
			ss="select short_desc descrip from am_resource_LANG_VW where resource_id = '"+practitioner_id+"' and facility_id= '"+facilityid+"' and resource_Class='"+res_type+"'  AND language_id='"+locale+"' ";
		}   
   }else{
		if(res_type.equals("P")){
			ss="select practitioner_name from am_practitioner_LANG_VW where practitioner_id = '"+practitioner_id+"' AND language_id='"+locale+"'";
		}else if(res_type.equals("R")){
			ss="select short_desc descrip from am_facility_room_LANG_VW where room_num ='"+practitioner_id+"' and OPERATING_FACILITY_ID='"+facilityid+"'  AND language_id='"+locale+"'";
		}else {
			ss="select short_desc descrip from am_resource_LANG_VW where resource_id = '"+practitioner_id+"' and facility_id= '"+facilityid+"' and resource_Class='"+res_type+"'  AND language_id='"+locale+"' ";
		}
	}
	//End ML-BRU-SCF-1602 [IN:055253]
 
	

rs_next   = stmt_next.executeQuery(ss) ;
while (rs_next !=null && rs_next.next())
	practitionerName = rs_next.getString(1);

}

if (rs_next!=null) rs_next.close();
int count=0;
String sql_wait_list="select count(*) count from pr_wait_list where facility_id='"+facilityid+"' and PREFERRED_DATE_TIME=to_date('"+i_appt_date+"','dd/mm/yyyy') and LOCN_CODE ='"+clinic_code+"' and RESOURCE_ID='"+practitioner_id+"'";
rs_next   = stmt_next.executeQuery(sql_wait_list) ;
if (rs_next !=null && rs_next.next())
	{
	count = rs_next.getInt(1);
}




if (rs_next!=null) rs_next.close();
if(stmt_next !=null) stmt_next.close();

            _bw.write(_wl_block2Bytes, _wl_block2);
 

// Below code was added by Venkatesh S on 11.06.2011 for SRR20056-SCF-7292 [IN:027301]
 int incr=0;
/* usage for find out interval time between two time for current appoinment.*/
 SimpleDateFormat format = new SimpleDateFormat("HH:mm"); 
java.util.Date c_date1 = format.parse(apptslabfmtime); 
 java.util.Date c_date2 = format.parse(apptslabtotime);
 long c_app_interval=(c_date2.getTime() - c_date1.getTime());

 // Code ends.

if(!flag.equals("Visit_Reg") && !flag.equals("Trans")) {   
            _bw.write(_wl_block12Bytes, _wl_block12);
 } else
{

            _bw.write(_wl_block13Bytes, _wl_block13);

}
            _bw.write(_wl_block14Bytes, _wl_block14);

			out.println("<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='" + apptrefno +"'>");

            _bw.write(_wl_block15Bytes, _wl_block15);
if(function_mode.equals("")) {
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(overbookedyn.equals("Y")) {
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apptrefno1));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(apptslabfmtime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visitshortdesc));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visitshortdesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else {
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(visitshortdesc));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(apptslabfmtime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block56Bytes, _wl_block56);
if(overbookedyn.equals("Y")) {
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
}  else { 
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
if(!function_mode.equals("")&&function_mode.equals("transfer")){
            out.print( String.valueOf(new_res_class_desc));
}else{
            out.print( String.valueOf(res_class_desc));
}
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i_appt_date_display));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
if(flag.equals("Visit_Reg")) {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(apptslabfmtime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block70Bytes, _wl_block70);
}else
				{

//Below code was added by Venkatesh S on 25.06.2011 for SRR20056-SCF-7292 [IN:027301]
				
				
String t_from_time=i_from_time;
StringTokenizer t_st1 = new StringTokenizer(t_from_time,":");
 incr=0;
 while(t_st1.hasMoreTokens())
{
t_from_time_arry[incr]=t_st1.nextToken();
incr++;
}
t_from_hour=Integer.parseInt(t_from_time_arry[0]);
t_from_sec=Integer.parseInt(t_from_time_arry[1]);
/* usage of below code find out interval time between two time for transfer schedule.*/
 SimpleDateFormat format2 = new SimpleDateFormat("HH:mm"); 
 java.util.Date date_t1 = format2.parse(i_from_time); 
 java.util.Date date_t2 = format2.parse(i_to_time);
transfer_schedule_total_time_interval=date_t2.getTime()-date_t1.getTime();
 int m=  (int)(c_app_interval/60000)%60; //to calculate minutes
int hourss   = (int) (( c_app_interval/ 1000) / 3600); // to calculate hours

//end





				
				
				if(i_time_table_type.equals("3") && ! (apptrefno == null || apptrefno.equals("null") || apptrefno.equals(""))) 
				{  
				// Below code was added by Venkatesh S on 25.06.2011 for SRR20056-SCF-7292 [IN:027301]
				
			
				
				if( c_app_interval<=transfer_schedule_total_time_interval)
                {
           java.util.Calendar calendar = new GregorianCalendar(2007,Calendar.JANUARY,2, t_from_hour, t_from_sec);
          calendar.add(Calendar.HOUR,hourss );
          calendar.add(Calendar.MINUTE,m);
		  String correct_time=format2.format(calendar.getTime());
	     i_to_time=correct_time;
// end


}

				
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(over_readonly));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i_from_time ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(over_readonly));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i_to_time));
            _bw.write(_wl_block75Bytes, _wl_block75);
 } else { 
            _bw.write(_wl_block76Bytes, _wl_block76);
 if(i_to_time == null && i_from_time == null)  { 
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i_from_time));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i_to_time));
            _bw.write(_wl_block68Bytes, _wl_block68);
 } else {
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i_from_time));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i_to_time));
            _bw.write(_wl_block79Bytes, _wl_block79);
	 } 
				    }
				  }	
            _bw.write(_wl_block80Bytes, _wl_block80);
if(to_over_book_yn.equals("Y")) {
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
}  else { 
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block2Bytes, _wl_block2);

	if((referral_line!=null && !(referral_line.equals(""))) || (referral_line1 !=null && !(referral_line1.equals("")))){
	
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(referral_line));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(referral_line1));
            _bw.write(_wl_block88Bytes, _wl_block88);

	}
	
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(nationalid));
            _bw.write(_wl_block96Bytes, _wl_block96);


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

            _bw.write(_wl_block97Bytes, _wl_block97);
if(!ALT_ID1_Desc.equals("")){
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(ALT_ID1_Desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(ALT_ID1_NO));
            _bw.write(_wl_block100Bytes, _wl_block100);
if(!ALT_ID1_EXP_DATE.equals("")) {
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(ALT_ID1_EXP_DATE_display));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else {
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(ALT_ID2_Desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(ALT_ID2_NO));
            _bw.write(_wl_block107Bytes, _wl_block107);
if(!ALT_ID2_EXP_DATE.equals("")) {
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(ALT_ID2_EXP_DATE_display));
            _bw.write(_wl_block109Bytes, _wl_block109);
}else {
            _bw.write(_wl_block110Bytes, _wl_block110);
}
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(ALT_ID3_Desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(ALT_ID3_NO));
            _bw.write(_wl_block109Bytes, _wl_block109);
if(!ALT_ID3_EXP_DATE.equals("")) {
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(ALT_ID3_EXP_DATE_display));
            _bw.write(_wl_block109Bytes, _wl_block109);
}else {
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(ALT_ID4_Desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(ALT_ID4_NO));
            _bw.write(_wl_block109Bytes, _wl_block109);
if(!ALT_ID4_EXP_DATE.equals("")) {
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(ALT_ID4_EXP_DATE_display));
            _bw.write(_wl_block109Bytes, _wl_block109);
}else {
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(alt_type_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(OTH_ALT_ID_NO));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(BIRTH_PLACE_DESC));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(genderdesc));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(dateofbirth_display));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
if(CITIZEN_YN.equals("Y")){
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
}else{
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
if(LEGAL_YN.equals("Y")){
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
}else{
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
if(!(nationalid.equals(""))){
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(RACE_DESC));
            _bw.write(_wl_block109Bytes, _wl_block109);
}else{
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(RACE_DESC));
            _bw.write(_wl_block109Bytes, _wl_block109);
}
            _bw.write(_wl_block138Bytes, _wl_block138);
 
				//String sql1="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+i_appt_date+"','dd/mm/yyyy')";
				/*String sql1="select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+frm_clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitionerid+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+apptdate+"','dd/mm/yyyy')";
				rs1=stmt1.executeQuery(sql1);
				if(rs1!=null){
					if(rs1.next()){
						alcn=rs1.getString("alcn_criteria") ;
						if(alcn==null) alcn="";
                    }
				}*/
				String sql1="select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time, alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+i_appt_date+"','dd/mm/yyyy')";
				//out.println("<script>alert('pre_alcn_criteria:"+pre_alcn_criteria+"')</script>");
				//out.println("<script>alert('pre_alcn_catg_code:"+pre_alcn_catg_code+"')</script>");
				if(rs1!=null)rs1.close();
				rs1=stmt1.executeQuery(sql1);
				if(rs1!=null){
					if(rs1.next()){
						to_clinic_alcn=rs1.getString("alcn_criteria") ;
						starttime=rs1.getString("start_time") ;
						endtime=rs1.getString("end_time") ;
						if(to_clinic_alcn==null) to_clinic_alcn="";
                    }
				}
				if((pre_alcn_criteria!=null)&&(pre_alcn_criteria!="")){
					if(pre_alcn_catg_code!=null && pre_alcn_catg_code.equals("*O")){
						pre_cat_grp_desc="Others";
					}else{
						String statGrp_sql="select STAT_GRP_DESC from AM_STAT_GROUP where STAT_GRP_ID='"+pre_alcn_catg_code+"'";
						if(rs1!=null)rs1.close();
						rs1=stmt1.executeQuery(statGrp_sql);
						if(rs1!=null&&rs1.next())
							pre_cat_grp_desc=rs1.getString("STAT_GRP_DESC");
						if(rs1!=null)rs1.close();
					}
				}
				//out.println("<script>alert('pre_cat_grp_desc:"+pre_cat_grp_desc+"')</script>");
			   
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ETHNIC_GROUP_DESC));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
if((pre_alcn_criteria!=null)&&(pre_alcn_criteria!="")){
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(pre_cat_grp_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(reasondesc));
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(apptremarks));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(modedesc));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(receiving_date_time_display));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(record_date_display));
            _bw.write(_wl_block159Bytes, _wl_block159);

	String showInstructionsYN="N";
	ResultSet qsRs=null;
	String sql4="select count(APPT_REF_NO)count from oa_appt_pat_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+apptrefno1+"'";
	qsRs = stmtsd.executeQuery(sql4);
	if ( qsRs != null ){
		if(qsRs!=null && qsRs.next()){
			int patInscount =	qsRs.getInt("count");
			if(patInscount>0)			
				showInstructionsYN="Y";					
		}
	}
	if(qsRs !=null)qsRs.close();
	if(showInstructionsYN.equals("N")){
		sql4="select  count(APPT_REF_NO)count from oa_appt_proc_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+apptrefno1+"'";
		qsRs = stmtsd.executeQuery(sql4);
		if ( qsRs != null ){
			if(qsRs!=null && qsRs.next()){
				int prcInscount =	qsRs.getInt("count");	
				if(prcInscount>0)
					showInstructionsYN="Y";					
			}
		}
		if(qsRs !=null)qsRs.close();
	}


            _bw.write(_wl_block160Bytes, _wl_block160);


   if (patientid!="")
	{
	 String In_patient_status =  patdata.CheckInPatient(conn,patientid,facilityid);
	  if (In_patient_status.equals("CURRENTLY_IN_PATIENT"))
      {
		inpatient_yn="Y";
		
            _bw.write(_wl_block161Bytes, _wl_block161);

      }
	  else
      {
		inpatient_yn="N";
      }
	}

            _bw.write(_wl_block162Bytes, _wl_block162);

String tmp_ref_no=apptrefno;
if(tmp_ref_no.equals("~")) tmp_ref_no="";

	if(!flag.equals("Visit_Reg") && !flag.equals("Trans") && (!wtListControl.equals("B")))
	{       title=title.trim();
			if ((title.equalsIgnoreCase("Cancel") || title.equalsIgnoreCase("Cancellation")))
	       {
	
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
} else {
  
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
 }
	 String ref_id="";
	ref_id=(String) session.getValue("ref_id");
	if(ref_id==null) ref_id="N";
            _bw.write(_wl_block168Bytes, _wl_block168);
if(ref_id.equals("N")){
            _bw.write(_wl_block169Bytes, _wl_block169);
if(sec_cnt > 0) { 
            _bw.write(_wl_block170Bytes, _wl_block170);
} else {
            _bw.write(_wl_block171Bytes, _wl_block171);
}
            _bw.write(_wl_block172Bytes, _wl_block172);

				stmt=conn.createStatement();
				if(rs!=null)rs.close();
				boolean patInsFlag=false;
				boolean procInsFlag=false;
				String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno1+"' ORDER BY display_order";
				rs=stmt.executeQuery(appt_pat_ins);
				if(rs!=null && rs.next()){
					patInsFlag=true;
				} 
				//Modified against PMG20089-CRF-0885.3 - Removed the OrderID Validations on Radiology Appointment without PatientID:
				/****Below "IF" Condition Description: 
				If it is Radiology appointment with patientid, OR If it is Normal appointment, 
				then it will check if orderid exists to show instructions button.
				If it is Radiology appointment without patientid, then it will show instructions button
				*****/
				//if(order_id.equals("")){ 
				if( (("Y".equalsIgnoreCase(rd_appt_yn)) && (patientid != "") && order_id.equals("")) || ("N".equalsIgnoreCase(rd_appt_yn) && order_id.equals("")) )
				{
				}else{
						if(rs!=null)rs.close();
						String appt_prc_ins="SELECT instruction_desc FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno1+"'";
						rs=stmt.executeQuery(appt_prc_ins);
						if(rs!=null && rs.next()){
							procInsFlag=true;
						}						
					}
				 	if(group_id.equals("")){
					if(patInsFlag || procInsFlag){
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(apptrefno1));
            _bw.write(_wl_block175Bytes, _wl_block175);
}else{
            _bw.write(_wl_block176Bytes, _wl_block176);
}
					}else{
            _bw.write(_wl_block177Bytes, _wl_block177);
}
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(apptrefno1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(apptslabfmtime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(URLEncoder.encode(practname)));
            _bw.write(_wl_block181Bytes, _wl_block181);
 

				if(group_id.equals("")){
				if(Forced.equals("N") && !calling_mode.equals("CAChange") || calling_mode.equals("OP") ){
					if(!calling_mode.equals("OR")|| calling_mode.equals("OP")) {
						if(!calling_mode.equals("IP")) {
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
}else {
            _bw.write(_wl_block184Bytes, _wl_block184);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block185Bytes, _wl_block185);
}
				}else{
            _bw.write(_wl_block186Bytes, _wl_block186);
}					

				//if(Forced.equals("N") && !calling_mode.equals("CAChange")|| calling_mode.equals("OP") ) {should cancel forced appointment from day schedule page.Added by sudhakar
				if(!calling_mode.equals("CAChange")|| calling_mode.equals("OP") ) {
					if(!calling_mode.equals("OR") || calling_mode.equals("OP")) {
						if(!calling_mode.equals("IP")) {
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
}
					}
				}
            _bw.write(_wl_block189Bytes, _wl_block189);
if(sec_cnt>0){
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block193Bytes, _wl_block193);
}
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);
}else{
            _bw.write(_wl_block196Bytes, _wl_block196);
if(sec_cnt>0){
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
}
            _bw.write(_wl_block201Bytes, _wl_block201);
	if(call_function_ip.equals("admit"))
				{	
            _bw.write(_wl_block202Bytes, _wl_block202);
if(sec_cnt>0){
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block204Bytes, _wl_block204);
}
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);
	}	
            _bw.write(_wl_block128Bytes, _wl_block128);
	if(apptstatus.equals("A"))
					{	
            _bw.write(_wl_block207Bytes, _wl_block207);
if(sec_cnt>0){
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block208Bytes, _wl_block208);
}
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
	}	
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);
if(!flag.equals("cancel_appt") ){
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
}
            _bw.write(_wl_block214Bytes, _wl_block214);
if(sec_cnt>0){
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
}else if(!function_mode.equals("") && flag.equals("Trans")){//Transfer Appointment Starts
	HashMap patInstructionsMapResult=new java.util.HashMap();
	HashMap prcInstructionsMapResult=new java.util.HashMap();
	String instructionID="";
	String instructionDesc="";
	String valueObject="";
	String default_linked_yn="";
	int countPatInstructions=1;
	int countProcInstructions=1;
	String clinicInstr="";
	Integer tempInteger=null;
	String visibilityStr="hidden";
	String displayStr="None";
	if(frm_clinic_code.equals(clinic_code)){
		patInsSelectYN="Y";
		procInsSelectYN="Y";
		clinicInstr="SELECT a.instruction_id,a.display_order,a.default_linked_yn,b.instruction_desc FROM op_clinic_pat_instructions a, am_pat_instructions_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND a.clinic_code = '"+frm_clinic_code+"' AND a.instruction_id = b.instruction_id AND b.language_id = '"+locale+"' AND a.instruction_id not in(SELECT  INSTRUCTION_ID FROM OA_APPT_PAT_INSTRUCTIONS WHERE facility_id = '"+facilityid+"' AND appt_ref_no='"+apptrefno+"') ORDER BY display_order";
		String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"' ORDER BY display_order";
		stmt=conn.createStatement();
		if(rs!=null)rs.close();
		rs=stmt.executeQuery(appt_pat_ins);
		while(rs!=null && rs.next()){
			instructionID=rs.getString("instruction_id");
			instructionDesc=rs.getString("instruction_desc");
			valueObject=instructionID+"|~"+instructionDesc+"|~Y";
			tempInteger=new Integer(countPatInstructions);
			patInstructionsMapResult.put(tempInteger.toString(),valueObject);
			countPatInstructions++;
		}
		if(rs!=null)rs.close();
		rs=stmt.executeQuery(clinicInstr);
		while(rs!=null && rs.next()){
			instructionID=rs.getString("instruction_id");
			instructionDesc=rs.getString("instruction_desc");
			default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
			valueObject=instructionID+"|~"+instructionDesc+"|~N";
			tempInteger=new Integer(countPatInstructions);
			patInstructionsMapResult.put(tempInteger.toString(),valueObject);
			countPatInstructions++;
		}
		if(rs!=null)rs.close();
		if(countPatInstructions > 1){
			clinicInsYN="Y";
			session.setAttribute("patInstructionsMap", patInstructionsMapResult);
		}
	}else{//Transferring Appointment to a different clinic
		clinicInstr="Select a.INSTRUCTION_ID,a.DISPLAY_ORDER,a.DEFAULT_LINKED_YN,b.INSTRUCTION_DESC from op_clinic_pat_instructions a,am_pat_instructions_lang_vw b where a.facility_id='"+facilityid+"' and a.clinic_code='"+clinic_code+"' and a.INSTRUCTION_ID =b.INSTRUCTION_ID and b.language_id='"+locale+"' order by DISPLAY_ORDER";
		patInsSelectYN="N";
		procInsSelectYN="N";
		if(rs!=null)rs.close();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(clinicInstr);
		while(rs!=null && rs.next()){
			instructionID=rs.getString("instruction_id");
			instructionDesc=rs.getString("instruction_desc");
			default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
			valueObject=instructionID+"|~"+instructionDesc+"|~"+default_linked_yn;
			tempInteger=new Integer(countPatInstructions);
			patInstructionsMapResult.put(tempInteger.toString(),valueObject);
			countPatInstructions++;
		}
		if(rs!=null)rs.close();
		if(countPatInstructions > 1){
			clinicInsYN="Y";
			session.setAttribute("patInstructionsMap", patInstructionsMapResult);
			patInsSelectYN="Y";
		}
	}
	//Getting order catalog instructions  from DB Start
	//Modified against PMG20089-CRF-0885.3 - Removed the OrderID Validations on Radiology Appointment without PatientID:
	/****Below "IF" Condition Description: 
	If it is Radiology appointment with patientid, OR If it is Normal appointment, 
	then it will check if orderid exists to show instructions button.
	If it is Radiology appointment without patientid, then it will show instructions button
	*****/
	//if(order_id.equals("")){
	if( (("Y".equalsIgnoreCase(rd_appt_yn)) && (patientid != "") && order_id.equals("")) || ("N".equalsIgnoreCase(rd_appt_yn) && order_id.equals("")) ){
	}else{
		if(rs!=null)rs.close();
		String appt_prc_ins="SELECT instruction_desc FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"'";
		rs=stmt.executeQuery(appt_prc_ins);
		if(rs!=null && rs.next()){
			String order_stand_ins=rs.getString("INSTRUCTION_DESC");
			prcInstructionsMapResult.put("prcIns",order_stand_ins);
			prcInstructionsMapResult.put("patient_id",patientid);
			prcInstructionsMapResult.put("checked","Y");
			countProcInstructions++;
		}
		if(countProcInstructions>1){
			orderInsYN="Y";
			procInsSelectYN="Y";
			session.setAttribute("prcInstructionMap", prcInstructionsMapResult);
		}
	}
	//Getting order catalog instructions  from DB End
	if(countPatInstructions > 1 || countProcInstructions >1){
		visibilityStr="visible";
		displayStr="";
	}

            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
if(rule_based_tr.equals("Y") && prefPractYN.equals("N")){
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block222Bytes, _wl_block222);
}
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(frm_clinic_code));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(visibilityStr));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(displayStr));
            _bw.write(_wl_block229Bytes, _wl_block229);

		if(sec_cnt>0){
			if(to_over_book_yn.equals("N")){
				String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+appttypecode+"' and resource_class !='"+res_type+"'  order by resource_class ";
				if (rs1!=null) rs1.close();
				rs1 = stmt1.executeQuery(secsql);
				while(rs1!=null && rs1.next()){
					 sec_resources=sec_resources+rs1.getString("resource_class");
					 sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
				}
				if(sec_resources.length()>1)
					sec_resources=sec_resources.substring(0,sec_resources.length()-1);
				}
				if(! sec_resources.equals("")){
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
}
		}
	
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
}else{
	
            _bw.write(_wl_block235Bytes, _wl_block235);
	
	
		if(showInstructionsYN.equals("Y")){
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(apptrefno1));
            _bw.write(_wl_block237Bytes, _wl_block237);
}else{
            _bw.write(_wl_block238Bytes, _wl_block238);
}
					
				
				if(sec_cnt>0){
					if(to_over_book_yn.equals("N")){
						String secsql="select visit_type_code,resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityid+"' and visit_type_code='"+appttypecode+"' and resource_class !='"+res_type+"'  order by resource_class ";
						if (rs1!=null) rs1.close();
							rs1 = stmt1.executeQuery(secsql);
						while(rs1!=null && rs1.next()){
							 sec_resources=sec_resources+rs1.getString("resource_class");
							 sec_resources=sec_resources+"*"+rs1.getString("resource_criteria")+"-";
						 }
						 if(sec_resources.length()>1)
							 sec_resources=sec_resources.substring(0,sec_resources.length()-1);
					}
					if(! sec_resources.equals("")){
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block240Bytes, _wl_block240);
}
						
				}
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
 } 
            _bw.write(_wl_block2Bytes, _wl_block2);

if(!flag.equals("Visit_Reg") )
 {

if(canc_appt_yn.equalsIgnoreCase("N")){
if(!calling_mode.equals("CA")) {
	if(!calling_mode.equals("OR")) {
		if(!calling_mode.equals("")){
            _bw.write(_wl_block243Bytes, _wl_block243);

		}
} 
}
}else if(canc_appt_yn.equalsIgnoreCase("Y") && !calling_mode.equals("CA") ){
if(!calling_mode.equals("OR")) {
	if(!calling_mode.equals("")){
            _bw.write(_wl_block244Bytes, _wl_block244);

	}
}
}
 }

if(tfr_appt_yn.equalsIgnoreCase("N")){
if(!flag.equals("Visit_Reg") && function_mode.equals("") )
{
	if(!calling_mode.equals("CA")) {
if(!calling_mode.equals("OR")) { 
            _bw.write(_wl_block245Bytes, _wl_block245);

}
}
}		
}else{
if(!flag.equals("Visit_Reg") && function_mode.equals("") )
{
	if(!calling_mode.equals("CA")) {
if(!calling_mode.equals("OR")) {
            _bw.write(_wl_block246Bytes, _wl_block246);

}
	}
}
}

            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(apptstatus));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf( transfer ));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf( value13 ));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(i_from_time ));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(i_to_time ));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(i_appt_date));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(over_booked));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(overbookedyn ));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(str14));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(visitind));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(pre_alcn_criteria));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(alcn_catg_code));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(contactvals));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(disp_fromtime));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(disp_totime));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(i_time_table_type));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(resaddrl1));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(resaddrl2));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(resaddrl3));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(resaddrl4));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(postalcode));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(countrycode));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(call_function_ip));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(order_id1));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(sec_resources));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(inpatient_yn));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(visitshortdesc));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(appttypecode));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(clinicshortdesc));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(SPECIALITY_CODE));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(email_appl_yn));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(email_appl_for_appt_wo_pid_yn));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(emailid));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(pat_email_appl_yn));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(xsec_res));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(count));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(to_clinic_alcn));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(apptrefno1));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(to_over_book_yn));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(clinicInsYN));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(orderInsYN));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(patInsSelectYN));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(procInsSelectYN));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(i_appt_date_display));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf( starttime));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(endtime));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(contactAddress.toString()));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(c_app_interval));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(transfer_schedule_total_time_interval));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(rule_based_tr));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(frm_clinic_code));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(rd_oa_integration_yn));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(orderCatMapped));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(pat_cncl_count));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(pat_cancel_reason));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(max_cancel_appt));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(new_resource_class));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(function_mode));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(others_id));
            _bw.write(_wl_block346Bytes, _wl_block346);
contactAddress.setLength(0);
            _bw.write(_wl_block347Bytes, _wl_block347);

	if (rs1 != null) rs1.close();
	if (rs2 != null) rs2.close();
	if (rs3 != null) rs3.close();
	if (rs4 != null) rs4.close();
    if (rs!= null) rs.close();
	if (rs_pat!= null) rs_pat.close();
	if(rs_reason !=null)rs_reason.close();
	if(rsgrp !=null)rsgrp.close();
	if ( rssd !=null) rssd.close();
	if (Rset_Nat_Id!= null) Rset_Nat_Id.close();
	if(stmtgrp!=null) stmtgrp.close();	
	if(stmtsd!=null) stmtsd.close();				
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if (stmt2 != null) stmt2.close();
	if (stmt3 != null) stmt3.close();
	if (stmt4 != null) stmt4.close();
	if(stmt_reason !=null)stmt_reason.close();
	if (pstmt_pat != null) pstmt_pat.close();
	if (pstmt != null) pstmt.close();

}catch(Exception e) { 

	//out.println(e.toString());
	e.printStackTrace();

}finally{

	ConnectionManager.returnConnection(conn,request);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block348Bytes, _wl_block348);
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.CurrentAppointmentDetails.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TransferingAppointmentDetails.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Allocation.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactReason.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contactmode.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivingDateTime.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedOn.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ConfirmAppointment.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Viewaudittrial.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.RescheduleAppointment.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelAppointment.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cancellation.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Abort.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cancellation.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforRevision.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ReasonForOverride.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.EditInstructructions.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmRevision.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }
}
