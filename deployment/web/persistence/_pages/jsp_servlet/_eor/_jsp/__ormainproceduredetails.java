package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eOR.*;
import eCA.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ormainproceduredetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eOR/jsp/ORMainProcedureDetails.jsp", 1721794277859L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\r\n----------------------------------------------------------------------------------------------\r\nDate       \t  Edit History  Name        Description\r\n----------------------------------------------------------------------------------------------\r\n09/07/2024  63122    Twinkle Shah    09/07/2024    ML-MMOH-CRF-2114\r\n----------------------------------------------------------------------------------------------\r\n-->\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \r\n\r\n<html>\r\n<head>\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \r\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\r\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\r\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n\t<script language=\"JavaScript\" src=\"../js/ORMainProcedure.js\"></script>\r\n \t<script language=\"JavaScript\" src=\"../../eCA/js/CAOpenExternalApplication.js\"></script>\r\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\r\n \t<script>\r\n\t\tfunction alignWidth() {\r\n\t\t\tvar last=eval(document.all.detailTab.rows.length)-1;\r\n\t\t\t\tif(document.all.detailTab!=null) {\r\n\t\t\t\t\tfor(i=0;i <document.all.detailTab.rows(last).cells.length;i++) {\r\n\t\t\t\t\t\tvar wid=document.all.detailTab.rows(last).cells(i).offsetWidth;\r\n\t\t\t\t\t\tvar wid1= parent.mainProcedureCrieHeader.document.all.titleTab.rows(0).cells(i).offsetWidth;\r\n\t\t\t\t\t\tif(eval(wid1) <eval(wid)){\r\n\t\t\t\t\t\t\tparent.mainProcedureCrieHeader.document.all.titleTab.rows(0).cells(i).width=wid;\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\tdocument.all.detailTab.rows(last).cells(i).width = wid1;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t</script>\r\n\t \r\n</head>\r\n<body   onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">     \r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t<script>\r\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\r\n\t\t\tparent.mainProcedureCrieHeader.location.href = \"../../eCommon/html/blank.html\";\r\n\t\t\tparent.mainProcedureCrieResult.location.href = \"../../eCommon/html/blank.html\";\r\n\t\t\tparent.mainProcedureCrieBtn.location.href = \"../../eCommon/html/blank.html\";\t\t\r\n\t\t</script>\r\n\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n<form name=\'mainProDtlForm\' target=\'messageFrame\' action=\'../../servlet/eOR.ORMainProcedureServlet\'>\r\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" id=\'detailTab\' class=\"grid\" >\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t<tr> <Td colspan=\'9\' class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</Td></tr>\r\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n       <tr>\r\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t\t         <td width=\'21%\' class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' title = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ><font size=1>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>\r\n\t\t         <input type=\'hidden\' name=\'order_id";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'order_id";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'/>\t\t\t     \r\n \t\t\t            <input type=\'hidden\' name=\'orderLineNumbr";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'orderLineNumbr";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/>\r\n \t\t\t            <input type=\'hidden\' name=\'event_code_CatLog";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'event_code_CatLog";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'/></td>\r\n \t\t\t            <input type=\'hidden\' name=\'orderTypeCode";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'orderTypeCode";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'/>\r\n \t\t\t            <input type=\'hidden\' name=\'orderCatCode";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'orderCatCode";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'/></td> \t\t\t   \r\n \t\t\t          <input type=\'hidden\' name=\'existmainPro";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'existmainPro";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'/></td> \t\t\t       \r\n \t\t\t            <input type=\'hidden\' name=\'existOtherPro";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'existOtherPro";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'/></td> \r\n \t\t\t                   \t       \t            \r\n\t\t\t     <td width=\'18%\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\r\n\t\t\t     <td width=\'11%\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >&nbsp;<font size=1>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></td>\r\n\t   \t\t     <td width=\'19%\' class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >&nbsp;&nbsp;<font size=1>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></td>\r\n\t\t\t\t <td width=\'17%\' class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font></td>\r\n\t\t\t\t <td width=\'14%\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >&nbsp;<font size=1>\r\n\t\t\t\t <input type=checkbox id=\'chk";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'chk";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onClick=\"checkMp(this,\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');checkMPAllow(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" id=\'subgrp";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onblur=\"enableDisableMPCHK(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\r\n\t\t\t\t <input type=\'hidden\' name=\'chkMP";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'chkMP";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\'\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;&nbsp;\r\n\t\t\t     <input type=checkbox id=\'oth";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' name=\'oth";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' onClick=\"checkOtherAllow(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');disabledOtherChk();\" id=\'subgrp";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\r\n\t\t\t\t <input type=\'hidden\' name=\'chkOth";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'chkOth";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</font></td>\t\t              \r\n\t\t\t     </tr>\r\n\t\t\t\t <input type=\'hidden\' id=\'checkallDateEnable\' name=\'checkallDateEnable\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\t\r\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\r\n                  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\r\n\t\t\t\t\t<TR>\r\n\t\t\t        <TD colspan=\'9\' >\r\n                    <Font size=1>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</Font>\r\n                    </TD>\r\n                    </TR>\r\n\t\t\t        <TR>\r\n \t\t\t            <td width=\'21%\' class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font>\r\n \t\t\t            <input type=\'hidden\' name=\'order_id";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'/></td>\r\n                        <input type=\'hidden\' name=\'existmainPro";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'/></td>\t\t\t           \r\n \t\t\t            <td width=\'18%\' class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td>\r\n\t\t\t            <td width=\'11%\' class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</font></td>\r\n\t\t                <td width=\'19%\' class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font></td>\r\n\t\t\t\t\t\t<td width=\'17%\' class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font></td>\r\n\t\t\t        \t<td width=\'14%\' class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >&nbsp;<font size=1>\r\n\t\t\t        \t<input type=checkbox id=\'chk";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\r\n\t\t\t        \t<input type=\'hidden\' name=\'chkMP";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;&nbsp;\r\n\t\t\t            <input type=checkbox id=\'oth";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">\r\n\t\t\t        \t<input type=\'hidden\' name=\'chkOth";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</font></td>\t\t              \r\n\t\t\t        </TR>\r\n\t\t\t        <input type=\'hidden\' id=\'checkallDateEnable\' name=\'checkallDateEnable\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\t\r\n\t\t\t        \r\n\t\t\t        \r\n                   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\r\n                   <TR>\r\n\t\t\t            <td width=\'21%\' class=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</font>\r\n\t\t\t            <input type=\'hidden\' name=\'order_id";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'/></td> \t\t\t       \r\n\t\t\t            <td width=\'18%\' class=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\')\" id=\'subgrp";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\t\t\t\t\t        \r\n                   ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\r\n\t\t</tr>\r\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\r\n</table>\r\n<input type=hidden name=\'total_recs\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\r\n<input type=\"hidden\" name=\"patientId\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\r\n<input type=\'hidden\' name=\'encounterID\' id=\'encounterID\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"> \r\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"> \r\n<input type=hidden name=\'totalRecordCnt\' id=\'totalRecordCnt\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'/>\r\n<input type=hidden name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'/>\r\n<input type=hidden name=\'otherTolcount\' id=\'otherTolcount\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'/>\r\n<input type=hidden name=\'otherTotalCount\' id=\'otherTotalCount\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'/>\r\n<input type=hidden name=\'MPTotalCount\' id=\'MPTotalCount\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'/>\r\n<input type=hidden name=\'callingFrom\' id=\'callingFrom\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'/>\r\n<input type=hidden name=\'maxallow\' id=\'maxallow\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'/>\r\n\r\n</form>\r\n<script>\r\nif(parent.mainProcedureCrieHeader.document.all.titleTab!=null){\r\nalignWidth();\r\n}\r\n</script>\r\n<script>\r\ndisabledOtherChk();\r\ndisabledMPChk();\r\n</script>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	String bean_id = "ORMainProcedureBean" ;
	String bean_name = "eOR.ORMainProcedureBean";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
    java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    String locale = (String) p.getProperty("LOCALE");
    String facilityId = (String)session.getValue( "facility_id" ) ;
	String patientId = request.getParameter("patientId")==null ? "":request.getParameter("patientId");
	String encounter_id = request.getParameter("encounter_id")==null ? "":request.getParameter("encounter_id");
	String fromDt = request.getParameter("fromDt")==null ? "":request.getParameter("fromDt");
	String toDt = request.getParameter("toDt")==null ? "":request.getParameter("toDt");
	String ord_status = request.getParameter("ord_status")==null ? "":request.getParameter("ord_status");
	String order_category = request.getParameter("order_category")==null ? "":request.getParameter("order_category");
	String order_type = request.getParameter("order_type")==null ? "":request.getParameter("order_type");
	String priority = request.getParameter("priority")==null ? "":request.getParameter("priority");
	String option_id = request.getParameter("option_id")==null ? "":request.getParameter("option_id");
	String callingFrom = request.getParameter("callingFrom")==null ? "":request.getParameter("callingFrom");

ArrayList allValues = new ArrayList();
int m=0;
int chk_count=0;
		Connection con = null;
		int j = 1;
	try{
	con =  ConnectionManager.getConnection(request);	
	ORMainProcedureBean bean = (ORMainProcedureBean)getBeanObject( bean_id, bean_name ,  request) ;
	allValues= bean.getDetails(patientId,encounter_id,fromDt,toDt,ord_status,order_category,order_type,priority,locale);

	String checkallDateEnable="";
	String tooltip			= "";

	if(allValues.size() == 0){

            _bw.write(_wl_block8Bytes, _wl_block8);
	}
            _bw.write(_wl_block9Bytes, _wl_block9);

	String 	order_id					= "";
	String 	reported_at					= "";
    String  event_class_desc            = "";
    String  event_group_desc            = "";
	String  temp_res_event_header       = "";
	String  temp_event_group_desc       = "";
    String	temp_order_id				= "";
    String  event_code                  = "";
String order_line_num=""; 
String catalog_short_desc="";	
String contr_sys_event_code="";	
String event_date="";
String priority1="";
String order_category1="";
String ord_date_time="";
String hist_data_type="";
String reported_by="";
String performed_by_id="";
String result_line_status="";
String ordering_pract_name="";
String order_status_short_desc="";
String performed_by_name="";
String existrecord="";
String procedure_yn="";
String mainProChkd="";
String otherProChkd="";
String otherProValue="N";
String mainProValue="N";
int other_count=0;
int mp_count=0;
String main_proc_yn;
String existmainPro;
String order_proc_yn;
String existOtherPro;
String disMainPro="";
String otherDisabled="";
String order_type_short_desc="";
String order_catalog_code="";
String order_category_short_desc="";
String ord_pract_id="";
int maxallow=0;
String  order_catalog_disc="";
	String slClassValue = "";
	String[] record  = null;
	  String  order_Cat_code                 = "";
	    String  order_type_code            = "";
	for(int i=0; i<allValues.size(); i++){
		record  = (String[])allValues.get(i);
		order_line_num				=CommonBean.checkForNull(record[0]);  
		catalog_short_desc			=CommonBean.checkForNull(record[1]);  
		reported_by					=CommonBean.checkForNull(record[2]);
		order_type_code				=CommonBean.checkForNull(record[3]);
		order_id				    =CommonBean.checkForNull(record[4]);
		order_type_short_desc		=CommonBean.checkForNull(record[5]);
		priority1				    =CommonBean.checkForNull(record[6]);
		order_category1				=CommonBean.checkForNull(record[7]);
		order_catalog_code          =CommonBean.checkForNull(record[8]);
		ordering_pract_name         =CommonBean.checkForNull(record[9]);
		order_category_short_desc   =CommonBean.checkForNull(record[10]);
		result_line_status          =CommonBean.checkForNull(record[11]);	
		order_status_short_desc          =CommonBean.checkForNull(record[11]);
        ord_pract_id			    =CommonBean.checkForNull(record[12]);
        ordering_pract_name         =CommonBean.checkForNull(record[13]);
        reported_at                 =CommonBean.checkForNull(record[14]);
        order_catalog_disc			=CommonBean.checkForNull(record[16]);
        event_code                  =CommonBean.checkForNull(record[17]);
        main_proc_yn                =CommonBean.checkForNull(record[18]);
        existmainPro                =CommonBean.checkForNull(record[19]);
        order_proc_yn               =CommonBean.checkForNull(record[20]);
        existOtherPro               =CommonBean.checkForNull(record[21]); 
		
		if(main_proc_yn.equals("Y"))
		{
			mainProChkd="checked";
			mainProValue="Y";
		}
		else
		{
			mainProChkd="";
			mainProValue="";
		}
		
		if(order_proc_yn.equals("Y"))
		{
			otherProChkd="checked";
			otherProValue="Y";
		}
		else
		{
			otherProChkd="";
			otherProValue="N";
		}
		
		if(main_proc_yn.equals("Y"))
		{
			mp_count++;
		} 
		
		if(order_proc_yn.equals("Y"))
		{
			other_count++;
		}  
				
        if (!temp_res_event_header.equals(order_category_short_desc+"/"+order_type_short_desc)){

    
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_category_short_desc+"/"+order_type_short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

         temp_res_event_header =  order_category_short_desc+"/"+order_type_short_desc;
         }
       
            _bw.write(_wl_block12Bytes, _wl_block12);
if (event_group_desc.equals("")){
	   			j++;
				temp_event_group_desc="";
				temp_order_id ="";				
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_catalog_disc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(existmainPro));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(existOtherPro));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(reported_by));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ordering_pract_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_status_short_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mainProValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(mainProChkd));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(otherProValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(otherProChkd));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
			
			}else{
				
            _bw.write(_wl_block58Bytes, _wl_block58);
if ((!temp_event_group_desc.equals(event_group_desc))|| (!temp_order_id.equals(order_id))) { 
                    		j++;	
                    
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_catalog_disc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(existmainPro));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(existOtherPro));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(reported_by));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ordering_pract_name));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_status_short_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mainProValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(mainProChkd));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(otherProValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(otherProChkd));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
temp_order_id=order_id;temp_event_group_desc = event_group_desc;}else{
                   
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_catalog_disc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(existmainPro));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(existOtherPro));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(reported_by));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(reported_at));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ordering_pract_name));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_status_short_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mainProValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(mainProChkd));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(otherProValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(otherProChkd));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);

                   }                     
			}
			
            _bw.write(_wl_block79Bytes, _wl_block79);
  	                  
 
	}

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(other_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(other_count));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(mp_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(maxallow));
            _bw.write(_wl_block91Bytes, _wl_block91);

putObjectInBean(bean_id,bean,request);
} 
catch(Exception ex) {
ex.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MP.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MP.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MP.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
}
