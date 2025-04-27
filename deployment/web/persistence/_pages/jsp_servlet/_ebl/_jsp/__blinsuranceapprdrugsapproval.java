package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eBL.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blinsuranceapprdrugsapproval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInsuranceApprDrugsApproval.jsp", 1717475961859L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eBL/js/BLInsuranceApprDrugsList.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad = \"loadSelRowsToSession();\" >\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad = \"\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t<form name=\"indirect_order_status\" id=\"indirect_order_status\">\n\t\n\t\t<table  width=\'100%\' border=0 >\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'NONURGENT\' align=\"right\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =",";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'prevPage\' id=\'prevPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'nextPage\' id=\'nextPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t</table>\n\t\t<table  class=\'grid\' width=\"85%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'\' style=\"text-align:center;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'\' style=\"text-align:center;\" nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</td>\n<!--\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'\' style=\"text-align:center;\" nowrap>\n\t\t\t\t\t<input type=\'checkbox\' name=\'apprAll\' id=\'apprAll\' id=\'apprAll\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onclick=\"chkApprAndPatClass(this,\'X\',\'ApprAllDrugs\',\'X\',0);\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t\t</td>\n-->\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'\' style=\"text-align:center;\" nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'gridData\' style=\"text-align:center;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'order_status_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'order_status_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'gridData\' style=\"text-align:center;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'long_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'long_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\n\t\t\t\t\t<input type=\'hidden\' name=\'apprChk_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  id=\'apprChk_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t\t\t\t</td>\t\t\t\t\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="                   \n<!--    \n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'apprChk_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'apprChk_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  \n\t\t\t\t\tonclick=\"chkApprAndPatClass(this, order_status_code";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =",\'apprChk\', long_desc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =");\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n\t\t\t\t</td>\n-->\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chkIPPatClass_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'chkIPPatClass_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' \n\t\t\t\t\tonclick=\"chkApprAndPatClass(this, order_status_code";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =",\'IP\',long_desc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =", ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chkDCPatClass_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'chkDCPatClass_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =",\'DC\',long_desc";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chkOPPatClass_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'chkOPPatClass_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =",\'OP\',long_desc";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chkEMPatClass_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'chkEMPatClass_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =",\'EM\',long_desc";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chkAllPatClass_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'chkAllPatClass_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =",\'ALL\', long_desc";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" >\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'gridData\' style=\"text-align:center;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =">\t\n\t\t\t\t</td>\t\t\t\t\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="                       \n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' width=\'20%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chk1_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'chk1_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  value=\'\'  onclick=\'checkChk1Value(this, order_status_code";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =",\"chk1\");\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' width=\'10%\' style=\"text-align:center;\">\n\t\t\t\t\t<input type=\'checkbox\' name=\'chk1_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'  value=\'\'  onclick=\"checkChk1Value(this, order_status_code";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =",\'chk1\', long_desc";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n\t\t\t\t</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'  value=\'\' onclick=\"checkPatClass(\'IP\',\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\',this,";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =");\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'  value=\'\' onclick=\"checkPatClass(\'DC\',\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'  value=\'\' onclick=\"checkPatClass(\'OP\',\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =");\" >\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'  value=\'\' onclick=\"checkPatClass(\'EM\',\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'  value=\'\' onclick=\"checkPatClass(\'ALL\',\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =");\" >\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\t\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\t\t\n\t\t</table>\t\n\t\t<input type=\"hidden\"  name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"EBL_REST_CANC_SERVICE\">\n\t\t<input type=\"hidden\" name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t<input type=\'hidden\' name=\'sel_drug_code\' id=\'sel_drug_code\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t<input type=\'hidden\' name=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t\t<input type=\'hidden\' name=\'selectAllYN\' id=\'selectAllYN\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t\t<input type=\'hidden\' name=\'apprAll\' id=\'apprAll\' id=\'apprAll\' value=\'N\'>\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try {
	request.setCharacterEncoding("UTF-8");
	String mode	     = request.getParameter( "mode" ) ;	
	String login_user	= (String)session.getValue("login_user");
	String bean_id   = "@BLInsuranceApprDrugsBean" ;
	String bean_name = "eBL.BLInsuranceApprDrugsBean";
	String sel_drug_code = request.getParameter("sel_drug_code");
	if(sel_drug_code == null) sel_drug_code = "";
	String sel_drug_code_apprvd_YN = request.getParameter("sel_drug_code_apprvd_YN");
	if(sel_drug_code_apprvd_YN == null) sel_drug_code_apprvd_YN = "N";	
	String selectAllYN = request.getParameter("selectAllYN");
	if(selectAllYN == null) selectAllYN = "N";	
	
	String billingGrp = request.getParameter("billingGrp");
	if(billingGrp == null) billingGrp = "N";	
	
	String payerGroup = request.getParameter("payerGroup");
	if(payerGroup == null) payerGroup = "N";	
	
	String payer = request.getParameter("payer");
	if(payer == null) payer = "N";	
	
	String policyType = request.getParameter("policyType");
	if(policyType == null) policyType = "N";	
	
	String calledFrm = request.getParameter("calledFrm");
	if(calledFrm == null) calledFrm = "";	
		
	String facility_id = (String)session.getValue("facility_id");
	BLInsuranceApprDrugsBean bean = (BLInsuranceApprDrugsBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	ArrayList Pending_Order_Status = new ArrayList();
	String from	 = bean.checkForNull(request.getParameter( "from" ),"0") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"16") ;
	
 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
	int j=0;
	String slClassValue = "";
	String checked1 = "";
	String checked2 = "";
	String chkStr = request.getParameter("str")==null?"":request.getParameter("str");
	String clickedTab = request.getParameter("clickedTab")==null?"":request.getParameter("clickedTab");
	
	System.err.println("mode:"+mode);
	System.err.println("chkStr:"+chkStr);
	System.err.println("clickedTab:"+clickedTab);
	System.err.println("sel_drug_code:"+sel_drug_code);
	if(chkStr.equals("") && clickedTab.equals("SEARCH")){
		bean.clear();
		Pending_Order_Status = bean.getNewOrderStatus(sel_drug_code, facility_id, mode,billingGrp,payerGroup,payer,policyType);
	}else{
		System.err.println("Get data from getOrderSatList");
 	    Pending_Order_Status = bean.getOrderSatList();
	}
	int maxRecord = (Pending_Order_Status.size() / 8);
	System.err.println("maxRecord-"+maxRecord);
	if(maxRecord <= end)
		end = maxRecord-1;
	
	int index=(start*8);
	int l=start;
	
	if("Q".equals(calledFrm)){
	

            _bw.write(_wl_block9Bytes, _wl_block9);
 
	}else{
		

            _bw.write(_wl_block10Bytes, _wl_block10);
		
	}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end));
            _bw.write(_wl_block13Bytes, _wl_block13);

						if( start > 0 ) {

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start-16)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-1)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
						
						if(!((start+16) >= maxRecord )){

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+16)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+32)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

						}

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(selectAllYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(("Y".equals(selectAllYN) ? "checked" : "")));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		if("".equals(sel_drug_code)){
			while(l <= end){
					//System.err.println(index);
					if( (l+1)%2 == 0)  
						slClassValue="gridData";
					else
						slClassValue="gridData";
					
					String drugCode = (String)Pending_Order_Status.get(index);
					String drugDesc = (String)Pending_Order_Status.get(index+1);
					String approvalYN = (String)Pending_Order_Status.get(index+2);
					String IPYN = (String)Pending_Order_Status.get(index+3);
					String DCYN = (String)Pending_Order_Status.get(index+4);
					String OPYN = (String)Pending_Order_Status.get(index+5);
					String EMYN = (String)Pending_Order_Status.get(index+6);
					String ALLYN = (String)Pending_Order_Status.get(index+7);

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Pending_Order_Status.get(index)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(l));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(l));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drugCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(l));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(l));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drugDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(l));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(l));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Pending_Order_Status.get(index+2)));
            _bw.write(_wl_block37Bytes, _wl_block37);

					if(approvalYN.equals("Y") || approvalYN.equals("A")){
						checked1="checked";
					}
					else{
						checked1="";
					}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(l));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(l));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(l));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Pending_Order_Status.get(index+2)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(l));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(l));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(l));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(l));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(IPYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(l));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(l));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("Y".equals(IPYN)?"checked":""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(l));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(l));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DCYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(l));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(l));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("Y".equals(DCYN)?"checked":""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(l));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(l));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(OPYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(l));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(l));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("Y".equals(OPYN)?"checked":""));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(l));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(l));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(EMYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(l));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(l));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("Y".equals(EMYN)?"checked":""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(l));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(l));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ALLYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(l));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(l));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("Y".equals(ALLYN)?"checked":""));
            _bw.write(_wl_block65Bytes, _wl_block65);

					index+=8; 
					l++;
			}
		} else {
			System.err.println("In specific drug loop");
			while(l <= end){
					//System.err.println(index);
					if( (l+1)%2 == 0)  
						slClassValue="gridData";
					else
						slClassValue="gridData";
					String lcl_drug_code = (String)Pending_Order_Status.get(index);
					
				if(sel_drug_code.equals(lcl_drug_code)){
					

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Pending_Order_Status.get(index)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(l));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(l));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Pending_Order_Status.get(index)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Pending_Order_Status.get(index+1)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(l));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(l));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Pending_Order_Status.get(index+1)));
            _bw.write(_wl_block67Bytes, _wl_block67);

				}
					index = index+2;
					if(((String)Pending_Order_Status.get(index)).equals("Y")||((String)Pending_Order_Status.get(index)).equals("A")){
						checked1="checked";
					}
					else{
						checked1="";
					}
				if(sel_drug_code.equals(lcl_drug_code)){

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(l));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(l));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(l));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(l));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(l));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(l));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(l));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(l));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(l));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(l));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(l));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(l));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(l));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(l));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(l));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(l));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(l));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(l));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(l));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l));
            _bw.write(_wl_block86Bytes, _wl_block86);

				}
					index+=1; 
					l++;	
				}
			}

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(Pending_Order_Status.size()));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(j));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(sel_drug_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(selectAllYN));
            _bw.write(_wl_block96Bytes, _wl_block96);

		Pending_Order_Status=null;
		
            _bw.write(_wl_block97Bytes, _wl_block97);

putObjectInBean(bean_id,bean,request);

} catch(Exception e) {
	System.err.println("Exception in IndirectServCancel.jsp:"+e);
}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Approved.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IP.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DC.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OP.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EM.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
}
