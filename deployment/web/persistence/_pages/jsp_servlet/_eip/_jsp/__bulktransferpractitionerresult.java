package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bulktransferpractitionerresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BulkTransferPractitionerResult.jsp", 1742368725387L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/BulkTransferPractitioner.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t</head>\n\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' >\n\t\t<!--<form name = \"BulkTransferPractitionerResult\" method = \"post\" action =\"../../eIP/jsp/BulkTransferPractitionerResult.jsp\" target = \"parent.frames[1]\"> target = \'messageFrame\'>-->\n\t<form name = \"BulkTransferPractitionerResult\" method = \"post\" action = \"../../servlet/eIP.BulkTransferPractitionerServlet\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<input type=hidden name=\'pages\' id=\'pages\' value=\'multiple\'>\n\t\t\t\t\t<input type=hidden name=\'totChecked\' id=\'totChecked\' value=\'\"+j+\"\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<table align=\'right\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=hidden name=from id=from value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=to id=to value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\t\t\t\t<!--previous & next-->\n\t\t\t\t\t\t\t\t<!--<td align=\'right\' id=\'prev\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td> \n\t\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>-->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<!--<td align=\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>-->\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<br><BR>\n\n\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\'  width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0 >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"columnheadercenter\" >&nbsp;</td>\n\t\t\t\t\t\t<td class=\"columnheadercenter\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"columnheadercenter\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"columnheadercenter\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<!--<td class=\"columnheadercenter\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t</td>-->\n\t\t\t\t\t\t<td class=\"columnheadercenter\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"columnheadercenter\"  checked>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t<!--</table>\n\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\'  width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0 >-->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<td class=\'CAGROUPHEADING\' colspan=\'13\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\'dbspeciality_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\'service_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\'team_id";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\'bed_type_code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\'bed_class_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\'patient_class";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t<a href=\"javascript:closeWin(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'N\')\">+</a>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'plus ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'admission_date_time";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t\t\t\t<input type = \"hidden\" name = \'encounter_id";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\t\t\t\t<input type = \"hidden\" name = \'patient_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'patient_name\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'Sex\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'nursing_unit_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'bed_class";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'bed_no";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'room_no";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \'nursing_unit_desc\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t\t\t\t<!--<input type=\'checkbox\' name=\"Check";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"Check";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  \n\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>-->\n\t\t\t\t\t\t\t\t<!--<input type = \"hidden\" name = \'chkAttribute";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>-->\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"Check";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"  value=\'Y\' onclick=\'getchkvalues(this)\' checked>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"Check";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"  value=\'N\' disabled>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"Check\" id=\"Check\"  value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' checked>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"Check\" id=\"Check\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' disabled>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="-->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<!--\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"checkNoSelect(this,";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =")\" checked></td>-->\n\t\t\t\t\t\t\t<!--<td  class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>-->\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\t\n\t\t\t\t</table>\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'whereclause\' id=\'whereclause\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'e1\' id=\'e1\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'e2\' id=\'e2\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'nursing_unit_code_from\' id=\'nursing_unit_code_from\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'trans_type\' id=\'trans_type\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_id_from\' id=\'practitioner_id_from\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_id_to\' id=\'practitioner_id_to\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'counter\' id=\'counter\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t\t</form>\n\t\t\n\t</body>\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<!--<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t//document.getElementById(\"next\").style.visibility=\'visible\';\t\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>-->\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<!--<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t//document.getElementById(\"next\").style.visibility=\'hidden\';\t\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n-->\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//alert(\"\"+sql);\t\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t//parent.frames[3].location.href= \'../../eIP/jsp/BulkTransferPractitionerResult.jsp\';\n\t\t\t\t\t//parent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t//history.go(-1);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t<!--<script>\n\t\t\t\t\t\tparent.frames[3].location.href= \'../../eIP/jsp/BulkTransferPractitionerResult.jsp?";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\';\n\t\t\t\t\t</script>-->\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}

	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
try	
{
	con				= ConnectionManager.getConnection(request);	
	Statement stmt	= null;
	ResultSet rs	= null;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		try
		{
			request.setCharacterEncoding("UTF-8");
			String locale						= (String)session.getAttribute("LOCALE");
			String loginUser=session.getAttribute("login_user") == null ? "" : (String) session.getAttribute("login_user");
			StringBuffer where_criteria			= new StringBuffer();
			StringBuffer sql					= new StringBuffer();
			String encounter_id					= "";
			String class_val					= "QRYEVENSMALL";
			String whereClause					= request.getParameter("whereclause");
			String from							= request.getParameter( "from" ) ;
			String to							= request.getParameter( "to" ) ;
			String checkedOnes					= "";			
			String facility_id					= checkForNull((String)session.getValue("facility_id"));
			//String p_practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
			String nursing_unit_code_from			= checkForNull(request.getParameter("nursing_unit"));
			String speciality_code				= checkForNull(request.getParameter("Splcode"));
			String practitioner_id_from			= checkForNull(request.getParameter("practid_from"));
			String practitioner_id				= "";
			String practitioner_id_to			= checkForNull(request.getParameter("practid_to"));
			String trans_type				= checkForNull(request.getParameter("trans_type"));

			

			String nursing_unit_code="";
			String nursing_unit_desc="";
			String dbspeciality_code="";
			String service_code="";
			String team_id="";
			String bed_type_code="";
			String patient_class="";
			String bed_class_code="";
			
			
			String from_date					= checkForNull(request.getParameter("fromdate"));
			

			if(!(from_date.equals("") || from_date == null))
					from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 	
	
						
		
			String to_date						= checkForNull(request.getParameter("todate"));
						
			if(!(to_date.equals("") || to_date == null))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 			
	
		
			String e1							= checkForNull(request.getParameter("e1"));
			String e2							= checkForNull(request.getParameter("e2"));
			String patient_name					= "";
			String bed_no						= "";
			String room_no						= "";
			String bed_class					= "";
			String bed_type						= "";
			String specialty_short_desc			= "";
			String practitioner_name			= "";
			String prev_val						= "";
			String Sex							= "";
			String admission_date_time			= "";
			//String allow_bed_swap_yn			= "";
			String patient_id					= "";
			//String hid_gender1					= "";
			String admission_date_time_converted= "";
			String curr_loc						= "";
			//String frpractdesc					= "";
			String opstn_id					    = "";
			String SELECT_CHK_BOX				= "";
			String SELECT_CHK_BOX1				= "";
			String chkAttribute					= "";
			

			int start							= 0;
			int end								= 0;
			int i								= 1;
			int maxRecord						= 0;
			int cnt								= 0;
			
			if ( from == null )
			
			start								= 1 ;		
			
			else
			start								= Integer.parseInt( from ) ;
			
			if ( to == null )
			end									= 12 ;
			
			else
			end									= Integer.parseInt( to ) ;
			
			String req_start					= checkForNull(request.getParameter("start"),"0");
			String req_end						= checkForNull(request.getParameter("end"),"0");

			//out.println(whereClause);
			
			if(whereClause == null)
			{
				//out.println("cmg 1");
				//where_criteria.append(" where a.facility_id='"+facility_id+"' ");
				if(nursing_unit_code_from!=null && !nursing_unit_code_from.equals(""))
					where_criteria.append( " and a.nursing_unit_code='"+nursing_unit_code_from+"' ");
				if(speciality_code!=null && !speciality_code.equals(""))
					where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
				if(practitioner_id_from!=null && !practitioner_id_from.equals(""))
					where_criteria.append( " and a.attend_practitioner_id = '"+practitioner_id_from+"' ");
				if(from_date!=null && !from_date.equals(""))
					where_criteria.append(" and trunc(admission_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
				if(to_date!=null && !to_date.equals(""))
					where_criteria.append(" and trunc(admission_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				
			}
			else
			{
				where_criteria.append( whereClause );
			}
			//out.println(where_criteria.toString());
			

            _bw.write(_wl_block8Bytes, _wl_block8);

			
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("Check"+(i-1)) != null)
					{
						checkedOnes = request.getParameter("Check"+(i-1));						
						
						j++;
					}
					else
					{
					}
				}

            _bw.write(_wl_block9Bytes, _wl_block9);
      
			}
			i = 1 ;

			
			sql.append("Select AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+loginUser+"','N','','PRACT_TRANSFER_YN')login_user FROM dual");
			//out.println(sql);
			stmt	= con.createStatement();
			rs		= stmt. executeQuery(sql.toString());
			if(rs!=null && rs.next()){
			opstn_id=rs.getString("login_user");
			}
			
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			sql.append("select a.specialty_code dbspeciality_code, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.attend_practitioner_id practitioner_id,to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,a.encounter_id encounter_id,a.patient_id patient_id,decode('"+locale+"','"+locale+"',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name,b.sex gender,a.nursing_unit_code,ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, a.bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc,   a.bed_num bed_no,a.room_num room_no, DECODE (pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (facility_id, pat_curr_locn_code, '"+locale+"', 2 ), 'R', pat_curr_locn_code, op_get_desc.op_clinic (facility_id, pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,A.SERVICE_CODE SERVICE_CODE, A.TEAM_ID,(CASE WHEN (SELECT COUNT(*) FROM IP_NURSING_UNIT_FOR_PRACT WHERE FACILITY_ID = A.FACILITY_ID AND NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND  PRACTITIONER_ID  = '"+practitioner_id_to+"') > 0 and (SELECT COUNT(*) FROM AM_PRACT_ALL_SPLTY_VW WHERE FACILITY_ID = A.FACILITY_ID AND PRACTITIONER_ID  = '"+practitioner_id_to+"' and SPECIALTY_CODE=A.SPECIALTY_CODE) > 0 THEN 'Y' ELSE 'N' END) SELECT_CHK_BOX from IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id='"+facility_id+"' and a.patient_id = b.patient_id and a.attend_practitioner_id is not null and a.attend_practitioner_id<>'"+practitioner_id_to+"' and a.nursing_unit_code in (SELECT locn_code FROM AM_OS_USER_LOCN_ACCESS_VW WHERE facility_id='"+facility_id+"' and locn_type = 'N' AND oper_stn_id = '"+opstn_id+"' AND appl_user_id = '"+loginUser+"' AND PRACT_TRANSFER_YN = 'Y')"); 
			
			sql.append(where_criteria);
			sql.append("order by specialty_short_desc,practitioner_short_name");
			
			//out.println("SQL-->"+sql.toString());

			//out.println("<script>alert(\""+sql.toString()+"\");</script>");
			
			stmt	= con.createStatement();
			rs		= stmt. executeQuery(sql.toString());

			int recSelect = 0;
			if ( start != 1 )
			{
				for( int j=1; j<start; i++,j++ )
				{
					rs.next() ;
				}
					recSelect +=start;
					--recSelect;
			}
			
//			while ( i<=end && rs.next() ) 
			while ( rs.next() ) 
			{
				
			if(maxRecord==0)
			{
			

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);

							if ( !(start <= 1)) 
							{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

							}
							

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

			}//end of if(maxRecord==0)
				
						
					admission_date_time			= checkForNull(rs.getString("ADMISSION_DATE_TIME"),"");
						
						
						if(!(admission_date_time.equals("") || admission_date_time == null))
							admission_date_time_converted = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 			
						
						dbspeciality_code		= checkForNull(rs.getString("dbspeciality_code"));
						service_code			= checkForNull(rs.getString("SERVICE_CODE"));
						team_id					= checkForNull(rs.getString("TEAM_ID"));
						bed_type_code			= checkForNull(rs.getString("BED_TYPE_CODE"));
						bed_class_code			= checkForNull(rs.getString("bed_class_code"));
						patient_class			= checkForNull(rs.getString("PATIENT_CLASS"));
						encounter_id			= checkForNull(rs.getString("ENCOUNTER_ID"));
						patient_id				= checkForNull(rs.getString("PATIENT_ID"));
						patient_name			= checkForNull(rs.getString("PATIENT_NAME"),"");
						Sex						= checkForNull(rs.getString("GENDER"));
						nursing_unit_code		= checkForNull(rs.getString("NURSING_UNIT_CODE"),"");
						nursing_unit_desc		= checkForNull(rs.getString("NURSING_UNIT_SHORT_DESC"),"");
						bed_class				= checkForNull(rs.getString("BED_CLASS_SHORT_DESC"),"");
						bed_type				= checkForNull(rs.getString("BED_TYPE_SHORT_DESC"));
						bed_no					= checkForNull(rs.getString("BED_NO"));
						room_no					= checkForNull(rs.getString("ROOM_NO"));
						curr_loc				= checkForNull(rs.getString("NURSING_UNIT_SHORT_DESC"),"");
						specialty_short_desc	= checkForNull(rs.getString("SPECIALTY_SHORT_DESC"),"");
						practitioner_id			= checkForNull(rs.getString("PRACTITIONER_ID"));
						//practitioner_id			= checkForNull(rs.getString("attend_practitioner_id"));
						practitioner_name		= checkForNull(rs.getString("PRACTITIONER_SHORT_NAME"),"");
						SELECT_CHK_BOX			= checkForNull(rs.getString("SELECT_CHK_BOX"));
						//out.println(SELECT_CHK_BOX);
						if(Sex.equals ("M"))
                         Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(Sex.equals ("F"))
							Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else
							Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";

            _bw.write(_wl_block27Bytes, _wl_block27);
		
							
						String val				= specialty_short_desc+"/"+practitioner_name;
						if(!prev_val.equals(val))
							{ 

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(val));
            _bw.write(_wl_block29Bytes, _wl_block29);
	
							}

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dbspeciality_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i++));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(admission_date_time_converted));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(SELECT_CHK_BOX));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i++));
            _bw.write(_wl_block60Bytes, _wl_block60);

								
			if(SELECT_CHK_BOX.equals("Y"))
			 {
				chkAttribute = "CHECKED";
				SELECT_CHK_BOX1="true";

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block62Bytes, _wl_block62);

			 }
			 else
			 {
				chkAttribute = "DISABLED";
				SELECT_CHK_BOX1="false";

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block64Bytes, _wl_block64);

			 }

            _bw.write(_wl_block65Bytes, _wl_block65);
	if(SELECT_CHK_BOX.equals("Y")) {
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(SELECT_CHK_BOX));
            _bw.write(_wl_block67Bytes, _wl_block67);
}else {
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(SELECT_CHK_BOX));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block73Bytes, _wl_block73);
	
						prev_val=val;
						recSelect++;				
						i++;
						cnt++;
						maxRecord++;
			}// end of while
					
				
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(where_criteria.toString()));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((recSelect-1)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(e1));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(e2));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(nursing_unit_code_from));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(trans_type));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(practitioner_id_from));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(practitioner_id_to));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block87Bytes, _wl_block87);
	
		
			if(maxRecord<12 || (!rs.next()))
				{
            _bw.write(_wl_block88Bytes, _wl_block88);
}
				else
				{
            _bw.write(_wl_block89Bytes, _wl_block89);
}


		
				if(maxRecord == 0)
				{
            _bw.write(_wl_block90Bytes, _wl_block90);

				}
				else
				{
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block92Bytes, _wl_block92);

				}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
				
		}catch(Exception e)
		{
			out.println(e);
			e.printStackTrace();
		}

	}catch(Exception e)
	{
		out.println("Exception:"+e.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}	

            _bw.write(_wl_block93Bytes, _wl_block93);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
