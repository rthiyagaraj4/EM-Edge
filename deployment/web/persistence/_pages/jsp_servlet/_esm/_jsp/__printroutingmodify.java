package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __printroutingmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/PrintRoutingModify.jsp", 1723443844866L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t<html>\n\t\t\t<head>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n            <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n\t\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t\t<script src=\"../../eSM/js/PrintRouting.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t\t</head>\n\n\t\t\t<body OnMouseDown=\"CodeArrest()\"   onLoad=\'initialLoad();FocusFirstElement()\' onKeyDown = \'lockKey()\'>\n\t\t\t<form name=\"printrouting_form\" id=\"printrouting_form\" action=\"../../servlet/eSM.PrintRoutingServlet\" method=\"post\" target=\"messageFrame\">\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"95%\" align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'20%\'>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\n\t\t\t\t\t<td colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'module_name\' id=\'module_name\' size=\'30\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t\t\t<input type=\'hidden\' name=\'module_id\' id=\'module_id\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n\t\t\t\t\n\t\t\t\t</tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\n\t\t\t\t\t<td nowrap colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'report_name\' id=\'report_name\' size=\'60\' maxlength=\'60\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' readonly><input type=\'hidden\' name=\'report_id\' id=\'report_id\' size=\'60\' maxlength=\'60\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t\n\t\t\t\t</tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\n\t\t\t\t<td nowrap colspan=\'2\' class=\'fields\'><!--width=\'77%\'-->\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'  value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t</tr> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=\"label\"><!--width=\"23%\"-->";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\n\t\t\t\t \t\t   \n\t\t\t\t <td nowrap class=\'fields\' colspan=\'2\'><input type=\'text\'  name=\'dest_locn_type1\' id=\'dest_locn_type1\'  value =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\t    \t \n\t\t\t\t<input type=\'hidden\' name=\'dest_locn_type\' id=\'dest_locn_type\'  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\n\t\t\t\t <!--<td nowrap class=\'fields\'> width=\'67%\'-->&nbsp;<input type=\'text\'  name=\'dest_locn_code1\' id=\'dest_locn_code1\' size=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' maxlength=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value =\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' readonly><input type=\'hidden\'  name=\'dest_locn_code\' id=\'dest_locn_code\' size=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' readonly>\n\t\t\t\t</td></tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t</tr> \t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr> \n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td nowrap class=\"label\"><!--width=\"23%\"-->";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</td>\n\t\t\t\t\t\t<td colspan=\"2\" class=\'fields\'><!--width=\"77%\"--><select disabled name=\"dflt_report_mode\" id=\"dflt_report_mode\"  >\n\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<option value=\'B\' selected>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<option value=\'C\' >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<option value=\'C\' selected>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<option value=\'B\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t  </td>\n\t\t\t\t </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td nowrap class=\"label\"><!--width=\"23%\"-->";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\n\t\t\t\t\t<td nowrap colspan=\'2\' class=\'fields\'><!--width=\'77%\'--><input type=\'text\' name=\'no_of_copies\' id=\'no_of_copies\' size=\'2\' maxlength=\'2\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'onBlur=\'CheckPositiveNumber1(this)\'  onKeyPress=\'return ChkNumberInput1(this,event)\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t\t\n\t\t\t\t</tr> \n\t\t\t <tr>\n\t\t\t\t<td colspan=3>&nbsp;</td>\n\t\t\t  </tr>\n\t\t\t</table>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"95%\" align=\'center\'>\n\t\t\t<tr class=\"black\" width=\"100\">\n\t\t\t\t\t<td class=\'columnheader\' colspan=\'4\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4>&nbsp;</td>\n\t\t\t  </tr>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td nowrap class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="1</td>\n\t\t\t\t\t\t<td nowrap class=\'fields\'><INPUT TYPE=\"text\" name=\"printer_id1desc\" id=\"printer_id1desc\"  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onblur=\'selectPrinter1(printer_id1desc,printer_id);disableTime1(this);\'   value=\'\' size=60><input type=\'button\' class=\'button\' value=\'?\'  name=\'printer1\' id=\'printer1\' onClick=\'selectPrinter(printer_id1desc,printer_id);\' >\n         \t <!-- <select name=\"printer_id\" id=\"printer_id\" onChange=\'disableTime1(this)\'>\n \t       \t<option value=\"\">-------------------------- Select ---------------------------\n \t \t </select> -->\n \t    \t<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  name=\'reportclass\' id=\'reportclass\'>\n\t\t\t\n\t\t\t<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"  name=\'printer_id\' id=\'printer_id\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"from_time\" id=\"from_time\" size=\"5\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onBlur=\'CheckTime(this)\'    maxlength=\"5\" ></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="2</td>\n\t\t\t\t\t<td nowrap class=\'fields\'><INPUT TYPE=\"text\" name=\"printer_id2desc\" id=\"printer_id2desc\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onblur=\'selectPrinter1(printer_id2desc,printer_id2);disableTime2(this);\'   value=\'\' size=60><input type=\'button\' class=\'button\' value=\'?\'  name=\'printer2\' id=\'printer2\' onClick=\'selectPrinter(printer_id2desc,printer_id2);\' >\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"from_2time\" id=\"from_2time\" size=\"5\" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'   onBlur=\'CheckTime(this);\'  maxlength=\"5\" ></td>\n\t\t\t\t\t<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"  name=\'printer_id2\' id=\'printer_id2\'>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="3</td>\n\t\t\t\t\t<td nowrap class=\'fields\'><INPUT TYPE=\"text\" name=\"printer_id3desc\" id=\"printer_id3desc\"  value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" onblur=\'selectPrinter1(printer_id3desc,printer_id3);disableTime3(this)\'   value=\'\' size=60><input type=\'button\' class=\'button\' value=\'?\'  name=\'printer3\' id=\'printer3\' onClick=\'selectPrinter(printer_id3desc,printer_id3);\' >\n\t\t\t\t\t<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"  name=\'printer_id3\' id=\'printer_id3\'></td>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"from_3time\" id=\"from_3time\" size=\"5\"  onBlur=\'CheckTime(this)\'  value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' maxlength=\"5\" ></td>\n\t\t\t\t\n\t\t\t\t</tr>\n\n\t\t\t  </table>\n\n\t\t\t<input type=\'hidden\' name=\'srl_no\' id=\'srl_no\'  value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t<input type=\"hidden\" name=\"function\" id=\"function\" value=\"modify\">\n\t\t\t<input type=\"hidden\" name=\"eff_date_from\" id=\"eff_date_from\" >\n\t\t\t<input type=\"hidden\" name=\"eff_date_to\" id=\"eff_date_to\" >\n\t\t\t<input type=\"hidden\" name=\"sys\" id=\"sys\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n\t\t\t<input type=\"hidden\" name=\"function1\" id=\"function1\" value=\"modify\">\n\t\t\t<input type=\"hidden\" name=\"from_timeinsert1\" id=\"from_timeinsert1\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n\t\t\t<input type=\"hidden\" name=\"from_timeinsert2\" id=\"from_timeinsert2\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >\n\t\t\t<input type=\"hidden\" name=\"from_timeinsert3\" id=\"from_timeinsert3\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t<input type=\"hidden\" name=\"from_time1\" id=\"from_time1\" >\n\t\t\t<input type=\"hidden\" name=\"from_time2\" id=\"from_time2\" >\n\t\t\t<input type=\"hidden\" name=\"from_time3\" id=\"from_time3\" >\n\n\t\t\t</form>\n\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n</body>\n</html>\n\n<script>\n\nasync function selectPrinter1(desc,code)\n{\n\tif(desc.value == \"\")\n\t{desc.value=\"\";\n\t code.value=\"\";\n\t  \tif(desc.name==\"printer_id1desc\")\n\t\t\t {\n\t\t\t\tdisableTime1(desc)\n\t\t\t \n\t\t\t }else if(desc.name==\"printer_id2desc\")\n\t\t\t {\n\t\t\t disableTime2(desc)\n\t\t\t }else if(desc.name==\"printer_id3desc\")\n\t\t\t {\n\t\t\t disableTime3(desc)\n\t\t\t }\n\t  return ;\n\t}\t\t\nawait selectPrinter(desc,code)\n}\n\tasync function selectPrinter(desc,code)\n\t{\n\t\t\ttar=desc.value\n\t\t\t\t\n\t\t\n\t\tvar retVal =    new String();\n\t\tvar argumentArray  = new Array() ;\n\t\tvar dataNameArray  = new Array() ;\n\t\tvar dataValueArray = new Array() ;\n\t\tvar dataTypeArray  = new Array() ;\n\t\tvar tit=getLabel(\"eSM.Printers.label\",\"SM\");\t\n\t\tvar reportclass=document.forms[0].reportclass.value\n\t\t\t\n\t\t\tsql=\"Select printer_id code,printer_name description from sm_printer where eff_status=\'E\' and upper(printer_id) like upper(?) and upper(printer_name) like upper(?) order by 2\";\n\t\n\n\t\targumentArray[0] =sql;\n\t\targumentArray[1] = dataNameArray ;\n\t\targumentArray[2] = dataValueArray ;\n\t\targumentArray[3] = dataTypeArray ;\n\t\targumentArray[4] = \"1,2\";\n\t\targumentArray[5] = tar;\n\t\targumentArray[6] = DESC_LINK  ;\n\t\targumentArray[7] = DESC_CODE ;\n\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\tif(retVal != null && retVal != \"\" )\n\t\t  {\n\t\t\t\n\t\t   // var ret1=unescape(retVal);\n\t\t\t//arr=ret1.split(\",\");\n\t\t\t//desc.value=arr[1];\n\t\t\t//code.value=arr[0];\n\t\t\tvar ret1=unescape(retVal);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\n\t\t\tdesc.value=arr[1];\n\t\t\tcode.value=arr[0]\n\t\t\t//desc.focus();\n\t\t\t\tif(desc.name==\"printer_id1desc\")\n\t\t\t {\n\t\t\t\tdisableTime1(desc)\n\t\t\t \n\t\t\t }else if(desc.name==\"printer_id2desc\")\n\t\t\t {\n\t\t\t disableTime2(desc)\n\t\t\t }else if(desc.name==\"printer_id3desc\")\n\t\t\t {\n\t\t\t disableTime3(desc)\n\t\t\t }\n\t\t\t\n\t\t\t}else\n\t\t{\n\t\tdesc.value=\"\";\n\t\tcode.value=\"\";\n\t\t}\n\t}\t\t\t\n\t\t\t\n\t\t\tfunction CheckPositiveNumber1(obj)\n\t\t\t\t\t{\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {\t\t\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tif ( obj.value.length > 0 ) {\n\t\t\t\t\t\talert(getMessage(\'COPY_GR_ZERO\',\'SM\'));\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction ChkNumberInput1(fld, e)\n\t\t\t{\n\t\t\t   var strCheck = \'0123456789\';\n\t\t\t\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\t\t\t\tif (whichCode == 13) return true;  // Enter\n\t\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\t}\n\n\n\n\t\t\t function CheckTime(obj) \n\t\t\t {\n\t\t\t\t  if (obj.value.length > 0 )\n\t\t\t\t {\n\t\t\t\t\tif(ValidateTime(obj)==false) \n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'INVALID_TIME_FMT\',\'SM\'));\n\t\t\t\t\t\tobj.value=\'\'\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.readOnly=false;\n\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t }\n\t\t\t}\n\t\t\tfunction ValidateTime(obj)\n\t\t\t{\n\t\t\t\ttime = obj.value\n\t\t\t\tif (time.indexOf(\":\") > -1) {\n\t\t\t\tif  (time.length<5) return false;\n\t\t\t\tvar a=  time.split(\":\")\n\t\t\t\tsplithrs=a[0];\n\t\t\t\tsplitmin=a[1]\n\t\t\t\t\n\t\t\t\tif (splithrs >23 || splithrs <0) \n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'HR_LESS_TWENTYFOUR\',\'SM\'));\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\tif (splitmin >59 || splitmin <0) \n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'MI_LESS_SIXTY\',\'SM\'));\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t} else return false;\n\t\t\t\treturn true\n\t\t\t}\n\t\t\n\n\t\t\tfunction disableTime1(obj){\n\t\t\t\tvar fieldval = obj.value;\n\t\t\t\tif(fieldval != \'\')\n\t\t\t\t{   \n\t\t\t\t\tdocument.forms[0].printer_id2desc.disabled = false;\n\t\t\t\t\tdocument.forms[0].from_time.readOnly = false;\n\t\t\t\t\tdocument.forms[0].from_time.value = \"\";\n\t\t\t\t\tdocument.forms[0].printer_id2.disabled = false;\n\t\t\t\t\tdocument.forms[0].printer_id3.value = \"\";\n\t\t\t\t\tdocument.forms[0].printer_id3desc.disabled = true;\n\t\t\t\t\tdocument.forms[0].from_time3.readonly= true;\n\t\t\t\t    document.forms[0].printer2.disabled = false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\tdocument.forms[0].printer_id2desc.value=\"\";\n\t\t\t\t    document.forms[0].printer_id3desc.value=\"\";\n\t\t\t\t\tdocument.forms[0].from_time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_time.readOnly=true;\n\t\t\t\t\tdocument.forms[0].from_2time.value=\'\';\n\t\t\t\t\tdocument.forms[0].printer_id2.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_3time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_3time.readonly=true;\n\t\t\t\t\tdocument.forms[0].printer_id3.value=\'\';\n\t\t\t\t\tdocument.forms[0].printer_id3.disabled=true;\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer_id2.disabled = true;\n\t\t\t\t    document.forms[0].printer_id2desc.disabled = true;\n\t\t\t\t\tdocument.forms[0].printer2.disabled = true;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\t}\n\t\t\t}\n\n\n\t\t\tfunction disableTime2(obj){\n\t\t\t\tvar fieldval = obj.value;\n\t\t\t\t\n\t\t\t\tif(fieldval != \'\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = false;\n\t\t\t\t\tdocument.forms[0].from_2time.value = \"\";\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = false;\n\t\t\t\t\t//document.forms[0].printer_id3.disabled = false;\n\t\t\t\t\tdocument.forms[0].printer_id3desc.disabled = false;\n\t\t\t\t\tdocument.getElementById(\"printer3\").disabled=false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\tdocument.forms[0].printer_id3desc.value=\"\";\n\t\t\t\t\tdocument.forms[0].from_2time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_3time.value=\'\';\n\t\t\t\t\tdocument.forms[0].printer_id3.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = true;\n\t\t\t\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = true;\n\t\t\t\t\tdocument.forms[0].printer_id3desc.disabled = true;\n\t\t\t\t\tdocument.getElementById(\"printer3\").disabled=true;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction disableTime3(obj){\n\t\t\t\tif(obj.value != \'\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = false;\n\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_3time.value=\'\';\n\t\t\t\t\tdocument.forms[0].from_2time.readOnly = true;\n\t\t\t\t\tdocument.forms[0].from_3time.readOnly = true;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction initialLoad()\n\t\t\t{\n\t\t\t\tif(document.forms[0].printer_id.value!=\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id2desc.disabled = false;\n\t\t\t\t\tdocument.forms[0].printer2.disabled = false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id2desc.disabled = true;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].printer_id2.value!=\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id3desc.disabled = false;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = false;\n\t\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].printer_id3desc.disabled = true;\n\t\t\t\t\tdocument.forms[0].printer3.disabled = true;\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t\t</script>\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

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

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block1Bytes, _wl_block1);
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
	String module_id=request.getParameter("module_id");
	String report_id=request.getParameter("report_id");
	String srl_no=request.getParameter("srl_no");
	

	

	String codedesc = "";
	String size="6";
	String sdate ="";
	String report_class="";

	Connection con=null;
	try{
	con = ConnectionManager.getConnection(request);
	Statement stmt=null ;
	ResultSet rs=null ;
	ResultSet rset=null;
	Statement stmt2=null;
	
	stmt = con.createStatement();

	//String ddesc[] = {"Location","Clinic","Nursing Unit","Pharmacy","Store"};
	//String dcode[] = {"L","C","N","P","S"};

	String sysdate="Select to_char(sysdate,'dd/mm/rrrr') from dual ";
	ResultSet rsdate=stmt.executeQuery(sysdate);
	while (rsdate.next())
		{
	      sdate=rsdate.getString(1);
		}
	if( rsdate != null) rsdate.close();
	String sql="select a.*, b.printer_name printer_name1, c.printer_name printer_name2,d.printer_name printer_name3,to_char(from_time1,'hh24:mi')from_1time,to_char(from_time2,'hh24:mi')from_2time,to_char(from_time3,'hh24:mi')from_3time,to_char(from_time1,'dd/mm/yyyy hh24:mi')from_timeinsert1,to_char(from_time2,'dd/mm/yyyy hh24:mi')from_timeinsert2,to_char(from_time3,'dd/mm/yyyy hh24:mi')from_timeinsert3 from sm_print_routing_vw a,sm_printer b,sm_printer c,sm_printer d where  a.printer_id1= b.printer_id (+)  and  a.printer_id2= c.printer_id (+)  "+" and a.printer_id3=d.printer_id (+) and  module_id='"+module_id+"'"+"and report_id='"+report_id+"'" + "and srl_no='"+srl_no+"'";
	

	rset = stmt.executeQuery(sql);
	rset.next();

	//String printer_id1 = rset.getString("printer_id1")==null?"":rset.getString("printer_id1");
	String printer_id1desc = rset.getString("printer_name1")==null?"":rset.getString("printer_name1");
	String printer_id2 = rset.getString("printer_id2")==null?"":rset.getString("printer_id2");
	String printer_id2desc = rset.getString("printer_name2")==null?"":rset.getString("printer_name2");
	String printer_id3 = rset.getString("printer_id3")==null?"":rset.getString("printer_id3"); 
	String printer_id3desc = rset.getString("printer_name3")==null?"":rset.getString("printer_name3");
			
	String printerId=rset.getString("printer_id1");
	String facilityname=rset.getString("facility_name");
	if(facilityname == null  || facilityname.equals(""))
		facilityname="";
	
	String code=rset.getString("dest_locn_code") ;
	
	String from_1time = rset.getString("from_1time")==null?"": rset.getString("from_1time");
	String from_2time = rset.getString("from_2time")==null?"": rset.getString("from_2time");
	String from_3time = rset.getString("from_3time")==null?"": rset.getString("from_3time");
	String from_timeinsert1 = rset.getString("from_timeinsert1");
	String from_timeinsert2 = rset.getString("from_timeinsert2")==null?"": rset.getString("from_timeinsert2");
	String from_timeinsert3 = rset.getString("from_timeinsert3")==null?"": rset.getString("from_timeinsert3");
	String desttypedesc = rset.getString("dest_locn_type_desc")==null?"": rset.getString("dest_locn_type_desc");
	if(code == null || code.equals(""))
		code="";
	

			try{
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rset.getString("module_name")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rset.getString("module_id")));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rset.getString("REPORT_DESC")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset.getString("REPORT_ID")));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
					out.println("<input type='text' name='facility_id1' id='facility_id1' size='70' maxlength='35' value='");
					if(rset.getString("facility_id")==null || rset.getString("facility_id").equals("null") ||rset.getString("facility_id").equals("") )
						out.println(" ' readonly>");
					else
						
						out.print(facilityname+"' readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img> " );
						
					String fid = rset.getString("facility_id");
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fid));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(desttypedesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset.getString("dest_locn_type")));
            _bw.write(_wl_block19Bytes, _wl_block19);

					 if(code== null || code.equals("null"))
						 codedesc ="";
					 else  if(rset.getString("dest_locn_type").equals("L")){
						 codedesc=rset.getString("dest_locn_code")==null?"":rset.getString("dest_locn_code");
					 }
					 else{
						codedesc=rset.getString("dest_locn_desc")==null?"":rset.getString("dest_locn_desc");
						size="15";
					 }
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(size));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(size));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(codedesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(size));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(size));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(code));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

					out.println("<td nowrap colspan='2' class='fields'><!--width='77%'--><input type='text' name='ws_no' id='ws_no' size='32' maxlength='30'  value='");		
					if(rset.getString("ws_no")==null || rset.getString("ws_no").equals("null") ||rset.getString("ws_no").equals("") )
							out.println(" ' readonly>");
						else
						out.println(rset.getString("ws_no")+"' readonly>" );
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

							String dfltrptmode = rset.getString( "dflt_report_mode" ) ;	
							if ( dfltrptmode.equals("B") )
							{
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}	
							else
							{
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}
			 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rset.getInt("no_of_copies")));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

				if(rset!=null)rset.close();
	           if(stmt!=null)stmt.close();	
				  stmt = con.createStatement();
					 sql= "select report_class from sm_report where module_id='" + module_id + "'and report_id='"+ report_id +"'";
					 rs = stmt.executeQuery(sql);
					if(rs.next())
				{	
				report_class=rs.getString("report_class")==null?"":rs.getString("report_class");
				
				}
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
				
				
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(printer_id1desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(report_class));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(printerId));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(from_1time));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(printer_id2desc));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(from_2time));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(printer_id2));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(printer_id3desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(printer_id3));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_3time));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(from_timeinsert1));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(from_timeinsert2));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_timeinsert3));
            _bw.write(_wl_block58Bytes, _wl_block58);

				if(rset!=null)rset.close();
				if(rs!=null)rs.close();
				if(stmt2!=null)stmt2.close();
				
				if(stmt!=null)stmt.close();

				}
	catch(Exception  ce){out.print(ce+"here");}
	
	}catch(Exception e){out.println(e);}
finally { 

	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block59Bytes, _wl_block59);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Destination.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.workstation.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.DefaultReportMode.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Bitmap.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Character.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Character.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Bitmap.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.NumberofCopies.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PrinterDetails.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Printer.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Printer.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Printer.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
}
