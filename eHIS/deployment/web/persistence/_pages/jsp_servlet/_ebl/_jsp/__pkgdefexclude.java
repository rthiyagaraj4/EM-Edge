package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __pkgdefexclude extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefExclude.jsp", 1737917372332L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/PkgDef.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\t\n\t<script>\n\t$(document).ready(function(){\n\t//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated.\n\tif($(\'#dailyLimitSiteSpec\').val() == true || $(\'#dailyLimitSiteSpec\').val() == \"true\") { \n\t\tif(parent.parent.PkgDefHeader.frmPkgDefHeader.orderAssociated.checked) {\n\t\tvar formObj=document.srvLimit_rate_based_dtl;\n\t\tfor(var cnt = 0; cnt < $(\'#totalRecords\').val(); cnt++) {\n\t\t\teval(\"formObj.dailyLmtChkBx\"+cnt).checked = false;\n\t\t\t\t\t\n\t\t\teval(\"formObj.dailyLmtChkBx\"+cnt).value = \'N\';\n\t\t\teval(\"formObj.dailyLmtAmt\"+cnt).value = \'\';\n\t\t\teval(\"formObj.dailyLmtGrossNetList\"+cnt).value = \'G\';\n\t\t\teval(\"formObj.dailyLmtIndicator\"+cnt).value = \'*\';//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\teval(\"formObj.dailyLmtQty\"+cnt).value = \'\';//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\t\t\t\n\t\t\teval(\"formObj.dailyLmtChkBx\"+cnt).disabled = true;\n\t\t\teval(\"formObj.dailyLmtAmt\"+cnt).disabled = true;\n\t\t\teval(\"formObj.dailyLmtGrossNetList\"+cnt).disabled = true;\n\t\t\teval(\"formObj.dailyLmtIndicator\"+cnt).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\teval(\"formObj.dailyLmtQty\"+cnt).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\t}\n\t\t}\n\t}//Ends\n\t\t\n\t/* if($(\'#modifyStatus\').val() == \"\") {\n\t\tfor(var ind = 0; ind < $(\'#totalRecords\').val(); ind++) {//Added V190409-Aravindh/MMS-DM-CRF-0129\n\t\t\tvar formObj=document.srvLimit_rate_based_dtl;\n\t\t\tdailyLmtChkBxClickPharma(eval(\"formObj.srvLimit_service_code\"+ind),eval(\"formObj.srvLimit_type\"+ind),ind);\n\t\t}\n\t} *///Commented V190626-Aravindh/MMS-DM-CRF-0129.1/No need to check for PH service or not\n\t});\n\t</script>\n</head>\n<!-- Function name(moveFrame_Exclude()) is changed by Nmuthu against 32308 on 13-4-12 -->\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onscroll=\'moveFrame_Exclude()\' onLoad=\'chkExludeServiceonload();includeHomeMedicationEnable();\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<form name=\'srvLimit_rate_based_dtl\' id=\'srvLimit_rate_based_dtl\'  target=\'messageFrame\' >\n\n\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"parent_type\" id=\"parent_type\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"parent_service_code\" id=\"parent_service_code\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"parent_service_ind\" id=\"parent_service_ind\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"> <!--Added by lakshmi against the lookup issue -->\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<input type=\'hidden\' name=\'parent_indx\' id=\'parent_indx\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\'  id=\'fromDate\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" />\n\t<INPUT TYPE=\"hidden\" name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\'hidden\' name=\'authorized\' id=\'authorized\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" />\n\t<input type=\'hidden\' name=\'pkgApprovedYN\' id=\'pkgApprovedYN\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" />\n\t<input type=\"hidden\" name=\"order_associated\" id=\"order_associated\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\t <!-- Added V190404-dhananjay/MMS-DM-CRF-0129 -->\n<!--<table id=\"tableheader\" border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<table id=\"srvLimit_rate_based_tbl\" border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>-->\n\n<table class = \'grid\' width=\'100%\' id=\"srvLimit_rate_based_tbl\"  cellpadding=\'3\' cellspacing=\'0\' border=\"1\" height=\"\">\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t   \n<tr>\n<td class=\'fields\' nowrap WIDTH=\'\'> \n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<select name=\'srvLimit_type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'srvLimit_type";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onChange=\'onSrvLimitServiceTypeChange(this,\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\")\'>\n\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\n\t<!-- Added By Muthukumar on 18-11-11 Reg Balaraman Issue  -->\n\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</option>\n\t<!-- Added By Muthukumar on 18-11-11 Reg Balaraman Issue  -->\n\n\t<!-- Above line is Added by Muthu against CRF on 22-2-12 -->\n\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t<!-- Above line is Added by Muthu against CRF on 22-2-12 -->\n\t</select>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'type";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t</option>\n\t\t<option value=\'G\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t</option>\n\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t</option>\n\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t</option>\n\t\t<option value=\'T\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t</option>\n\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t</option>\n\t</select>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\")\'>\t\n\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</td>\n\n<!-- Added Newly on 13-3-12 by Muthukumar -->\t\t\t\t\t\n<td class=\'fields\' nowrap WIDTH=\'\'>\n<!-- Removed V190626-Aravindh/MMS-DM-CRF-0129.1/ removed calling new function dailyLmtChkBxClickPharma -->\n<input type=\'text\' name=\'srvLimit_service_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'srvLimit_service_code";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' size=\'10\' onBlur=\"srvLimitCodeLookUp(srvLimit_service_desc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =",this,srvLimit_type";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =",\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'); IncludeHomeMedicationCheck(srvLimit_service_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",srvLimit_type";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\">\n\n<input type=\'text\' name = \'srvLimit_service_desc";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' size=\'10\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" maxlength=\'10\' onBlur=\"before_srvLimitServiceLookUp(this,srvLimit_service_code";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');IncludeHomeMedicationCheck(srvLimit_service_code";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\n<INPUT type=\'hidden\' name=\'srvLimit_service_code_temp";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'srvLimit_service_code_temp";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' value=\'\'>\n<INPUT type=\'hidden\' name=\'srvLimit_service_desc_temp";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'srvLimit_service_desc_temp";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\'\'>\n<!-- Removed V190626-Aravindh/MMS-DM-CRF-0129.1/ removed calling new function dailyLmtChkBxClickPharma -->\n<input type=\'button\' name=\'srvLimit_service_button";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'srvLimit_service_button";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' class=\'button\' value=\'?\' onclick=\"srvLimitServiceLookUp(srvLimit_service_desc";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =",srvLimit_service_code";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =", \'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\');\">\n</td>\n\n<td class=\'fields\' nowrap WIDTH=\'55\' ><input type=\'checkbox\' name=\'exludeService";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'exludeService";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" onClick=\'chkExludeService(this,\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\");changeSplitReqd(this,\"exclude\",\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\");IncludeHomeMedicationExclude(this,srvLimit_service_code";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =",\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\");\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" /></td>\n\t\t\t\n<td class=\'fields\' nowrap WIDTH=\'\'><input type=\'text\'    name=\'srvLimit_qty_limit";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'srvLimit_qty_limit";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="   size=\'8\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" onBlur=\'chkSrvLimitQtyLimit(this);\' onkeypress=\'return allowValidNumber1_temp(this,event,\"2\");\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" /></td>\n\n<td  class=\'fields\' nowrap WIDTH=\'\'>\n<select name=\'srvLimit_amt_limit_ind";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'srvLimit_amt_limit_ind";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" onChange=\'validateInd(this,\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\",\"srvLimit_amt_limit\",\"srvLimit_factor_appl\",\"srvLimit_qty_limit\")\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =">\n<option value=\'\' ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">--";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="--</option>\n<option value=\'A\' ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>\n<option value=\'P\' ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</option>\n</select>\n</td>\n\n<td class=\'fields\' nowrap WIDTH=\'\'><input type=\'text\' name=\'srvLimit_amt_limit";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'srvLimit_amt_limit";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="   size=\'6\' maxlength=\'13\'  onBlur=\'chkSrvLimitAmtLimit(this,\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\",\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\")\' onkeypress=\'return allowValidNumber(this,event,\"10\",\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/></td>\n<td  class=\'fields\' ><input type=\'text\' name=\'srvLimit_roundTo";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' id=\'srvLimit_roundTo";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' size=\'6\' ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="   value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" onkeypress=\" return (allowValidNumber1(this,event));\"  /></td>\n<td  class=\'fields\' nowrap WIDTH=\'\'>\n<select name=\'srvLimit_roundInd";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'srvLimit_roundInd";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="   onChange=\"\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =">\n<option value=\'U\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\n<option value=\'D\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</option>\n</select>\n</td>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n<!-- \t//sarathkumar InclHmeMedi  -->\n<td class=\'fields\' WIDTH=\'75\' nowrap ><input type=\'checkbox\' ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" name=\'includeHomeMedication";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'includeHomeMedication";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" onclick=\'checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,\"rateexclude\",\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\");\' > </td> \n<input type=\'hidden\'  ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" name=\'enableDisParam";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'enableDisParam";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'> </td>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t<td><input type=\'hidden\'   name=\'includeHomeMedication";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'  value=\'Y\' >\n\t<input type=\'hidden\'   name=\'enableDisParam";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' value=\'Y\' </td>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->\n<!-- Modified V190626-Aravindh/MMS-DM-CRF-0129.1 -->\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\n\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t<select name=\'dailyLmtIndicator";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'dailyLmtIndicator";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" onchange = \'dailyLmtIndicatorOnChange(this,";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =",document.srvLimit_rate_based_dtl)\' >\n\t\t\t<option value=\"*\">";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" >";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t</select>\n\t\t<input type=\'hidden\' name = \'dailyLmtChkBx";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' id = \'dailyLmtChkBx";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' value = \'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' />\n\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t</td>\n\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t<input type=\'text\' name = \'dailyLmtAmt";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id = \'dailyLmtAmt";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' size=\'8\' maxlength=\'13\' onBlur=\'return checkForNegetiveNumber(this,\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\",\"BL8540\");\' \n\t\t\t\tonkeypress=\'return allowValidNumber(this,event,10,\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\");\' ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =" \n\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =" />\n\t\t<select name=\'dailyLmtGrossNetList";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' id=\'dailyLmtGrossNetList";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" >\n\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</option>\n\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</option>\n\t\t</select>\n\t</td>\n\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t<input type=\'text\' name = \'dailyLmtQty";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' id = \'dailyLmtQty";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' size=\'8\' maxlength=\'3\' onBlur=\'return checkForNegetiveNumber(this,0,\"BL8538\");\' \n\t\t\t\tonkeypress=\'return allowValidNumber(this,event,10,0);\' ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" />\n\t</td>\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t<input type=\'hidden\' name = \'dailyLmtChkBx";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' value = \'N\' />\n\t\t<input type=\'hidden\' name = \'dailyLmtIndicator";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id = \'dailyLmtIndicator";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' value = \'\' />\n\t</td>\n\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t<input type=\'hidden\' name = \'dailyLmtAmt";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' value = \'\' />\n\t\t<input type=\'hidden\' name = \'dailyLmtGrossNetList";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' value = \'\' />\n\t</td>\n\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t<input type=\'hidden\' name = \'dailyLmtQty";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' value = \'\' />\n\t</td>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\n\t<td  class=\'fields\' nowrap WIDTH=\'60\'>\n\t<input type=\'checkbox\'   ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" name=\'srvLimit_replace";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="onClick=\'srvLimitChkReplace(this,\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\")\' value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"/>\n\t<a name=\'srvLimit_replace_dtls";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' id=\'srvLimit_replace_dtls";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' href=\'#\'\tstyle =\'display:";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' onClick=\'srvLimitShowReplaceDtls(\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\")\'>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</a><input type=\"hidden\" name=\"srvLimit_replaceSrv_code";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" id=\"srvLimit_replaceSrv_code";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"><input type=\"hidden\" name=\"srvLimit_replaceSrv_desc";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" id=\"srvLimit_replaceSrv_desc";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"/>\n\t</td>\n\n\t<td class=\'fields\' nowrap WIDTH=\'60\'><input type=\'checkbox\'   ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" name=\'srvLimit_refund";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" onClick=\'srvLimitChkRefund(this,\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"/><input type=\'text\' name=\'srvLimit_refundAmt";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' id=\'srvLimit_refundAmt";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'   ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" style =\'display:";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' onkeypress=\'return ChkNumberInput(this,event,\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\")\' onBlur=\'validPercentageForRefund(this,\"srvLimit_autoRefund";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\")\' size=\'2\' maxlength =\'4\' ></td>\n\t<td align=\"left\" nowrap WIDTH=\'80\'><input type=\'checkbox\'   ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =" name=\'srvLimit_autoRefund";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =" onClick=\'chkautoRefund(this,\"srvLimit_refundAmt";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"/></td>\n\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t<input type=\'checkbox\' name=\'srvLimit_factor_appl";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' id=\'srvLimit_factor_appl";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" onClick=\'srvLimitFactorAppl(this,\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" /></td>\n\t<td class=\'fields\' nowrap WIDTH=\'60\'><input type=\'checkbox\'   ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" name=\'split_reqd";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' id=\'split_reqd";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" onclick=\"checkSplitReqd(this);\" ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =" ></td>\n\t<td class=\'fields\' nowrap WIDTH=\'50\'><input type=\'checkbox\'  ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =" name=\'srvLimit_deleteService";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' onClick=\'chkSrvLimitDeleteService(this,\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\");\' value=\'N\'/></td>\n\n</tr>\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t</table>\n\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" >\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' id=\'from_date\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n\t<input type=\"hidden\" id=\"totalRecords\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"> <!-- saraa -->\n\t<input type=\'hidden\' name=\'siteSpecf\' id=\'siteSpecf\'  id=\'siteSpecf\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'> <!-- saraa -->\n\t<input type=\'hidden\' name=\'dailyLimitSiteSpec\' id=\'dailyLimitSiteSpec\'  id=\'dailyLimitSiteSpec\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' ><!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->\n\t<input type=\'hidden\' name=\'modifyStatus\' id=\'modifyStatus\'  id=\'modifyStatus\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' ><!-- Added V190409-Aravindh/MMS-DM-CRF-0129 -->\n\t<input type=\'hidden\' name=\'pkgServLimit\' id=\'pkgServLimit\'  id=\'pkgServLimit\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'dailyPkgLmt\' id=\'dailyPkgLmt\'  id=\'dailyPkgLmt\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'dailyLmtChkYN\' id=\'dailyLmtChkYN\'  id=\'dailyLmtChkYN\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'amtFldDisabled\' id=\'amtFldDisabled\'  id=\'amtFldDisabled\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'qtyFldDisabled\' id=\'qtyFldDisabled\'  id=\'qtyFldDisabled\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'indicatorFldDisabled\' id=\'indicatorFldDisabled\'  id=\'indicatorFldDisabled\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'parDailyLmtInd\' id=\'parDailyLmtInd\'  id=\'parDailyLmtInd\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' >\n\t<input type=\'hidden\' name=\'servGrpLimitSiteSpec\' id=\'servGrpLimitSiteSpec\'  id=\'servGrpLimitSiteSpec\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' ><!-- Added V190731-Aravindh/MMS-DM-CRF-0129.1 --> \n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" >\n\t<script>updateNoofExcln(";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =",\'1\');</script>\n\t<script>alignHeading_Exclude();</script><!-- Function name is changed by Nmuthu against 32308 on 13-4-12 -->\n\t</form> \n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n </body>\n ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n</html>\n\n";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
	
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	boolean servGrpLimitSiteSpec = false;//21-10-2020
	//sarathkumar added code to make as siteSpecific saraa
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 

	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	Connection con = null;
	Connection con1 = null;//21-10-2020
	boolean dailyLimitSiteSpec = false;
	try {
		con = ConnectionManager.getConnection(request);
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
	} catch(Exception ex) {
		System.err.println("Error in PkgDefExclude.jsp con: "+ex);
		ex.printStackTrace();
	}
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
	try {	//21-10-2020
		con1 = ConnectionManager.getConnection(request);	
		servGrpLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL", "BL_ENABLE_PKG_SERV_IND_LIMIT");//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 
	} catch(Exception ex) {
		System.err.println("Error in PkgDefExclude.jsp con1: "+ex);
		ex.printStackTrace();
	}//21-10-2020

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
	String locale			= (String)session.getAttribute("LOCALE");
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		
	//Added By Vijay for GHL-SCF
	String newDateAddedFlag= request.getParameter("new_date_added")==null ? "" :request.getParameter("new_date_added") ;	
	String type=request.getParameter("type");
	String service_code=request.getParameter("service_code");
	int totalRecords=1;
	String disabled="disabled";
	String disabledAll="";
	String packageCode		=	"" ;
	String copyFrm_pkgCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
	String parent_indx		=	request.getParameter("parent_indx") == null ? "" :request.getParameter("parent_indx") ;
	String      dtlsDisp = "none";
	String      refndDisp = "none";
	String uSelect = "";
	String dSelect ="";
	String	amtLmtIndNullDisplay	= "";
	String	amtLmtIndAmtDisplay		= "";
	String	amtLmtIndPerDisplay		= "";
	String	perAmt_limitStatus		= "";
	String		splitReqd = "Y";	//Split reqd
	String      includeHomeMedication = "N";  //sarathkumar InclHmeMedi
	String      enableDisParam = "N";  //sarathkumar InclHmeMedi
	String 		dailyLmtChkYN = "N";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "", qtyFldDisabled = "", indicatorFldDisabled = "";//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	
	String bean_id		= "bl_PkgDefBean" ;
	String bean_name	= "eBL.PkgDefBean";
	PkgDefBean bean		= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;	
	String order_associated = request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated"); // Added V190404-dhananjay/MMS-DM-CRF-0129
		
	try
	{
	int noofdecimal = Integer.parseInt(bean.getNoOfDecimal());

	HashMap excludedItems_RB    =   new HashMap();
	HashMap excludedItemsFD_RB  =   new HashMap();
	//HashMap excludedItemsSR_RB  =   new HashMap();

	String deletedStatusRBLt = bean.getDeletedStatusRBLt();

	excludedItems_RB    =  bean.getExcludedItems_RB();	
   
	if(excludedItems_RB.size()>0 && excludedItems_RB.containsKey(fromDate))
	{
		excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
  	}
   
	if(mode.equals("modify") && deletedStatusRBLt.equals("N") && !(excludedItemsFD_RB.containsKey(service_code)))
	{	
		//Added By Vijay FOr GHL-SCF
		bean.setNewDateAddedFlag(newDateAddedFlag);
		//ends
		System.out.println("bean.getNewDateAddedFlag "+bean.getNewDateAddedFlag());
		bean.setDBValues("SRVLIMIT_RATE_BASED",packageCode,locale,facilityId,service_code,"",fromDate); //set database values to bean.
		bean.setModifyRateSrvLimits("Y");	
		excludedItems_RB    =  bean.getExcludedItems_RB();
	}

	//HashMap includedItems_RB = bean.getIncludedItems_RB();// unused variable.
	/*HashMap includedItemsFD_RB = new HashMap();
	if(includedItems_RB.containsKey(packageCode))
		includedItemsFD_RB = (HashMap)includedItems_RB.get(packageCode);  */
   
	String srvLimit_type		="";
	String 		srvLimit_service_code			="";
	String 	    srvLimit_service_desc		="";
	String 		exludeService			="N";
	String 		srvLimit_qty_limit		="";
	String 		srvLimit_amt_limit			="";
	String 		srvLimit_factor_appl			="";	
	String 		srvLimit_amt_limit_ind	="";
	String 	    srvLimit_replace		="N";
//	String 		srvLimit_replaceSrv_code="N"; COMMENTED FOR IN020833 AND ADDED BELOW
	String 		srvLimit_replaceSrv_code="";
	String		srvLimit_replaceSrv_desc = "";
	String 		srvLimit_refund		="N";
	String 		srvLimit_refundAmt		="";
	String 		srvLimit_auto_refund			="N";
	String      srvLimit_roundTo = "";
	String      srvLimit_roundInd = "";

	ArrayList	srvLimit_type_list	    =	new ArrayList();
	ArrayList	srvLimit_service_code_list    =	new ArrayList();
	ArrayList	srvLimit_service_desc_list	    =	new ArrayList();
	ArrayList	exludeService_list		    =	new ArrayList();
	ArrayList	srvLimit_qty_limit_list		    =	new ArrayList();
	ArrayList	srvLimit_amt_limit_list		    =	new ArrayList();
	ArrayList	srvLimit_factor_appl_list		    =	new ArrayList();
	ArrayList   amt_limit_ind_list			=	new ArrayList();
	ArrayList	srvLimit_replace_list				=	new ArrayList();
	ArrayList	srvLimit_replaceSrv_code_list		=	new ArrayList();
	ArrayList   srvLimit_refund_list					=	new ArrayList();
	ArrayList   srvLimit_refundAmt_list				=	new ArrayList();
	ArrayList   srvLimit_auto_refund_list			=	new ArrayList();
	ArrayList	srvLimit_roundTo_list			=	new ArrayList();
	ArrayList	srvLimit_roundInd_list		 =	new ArrayList();
	ArrayList	srvLimit_replaceSrv_desc_list		=	new ArrayList();
	ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
	ArrayList   includeHomeMedication_list= new ArrayList();//sarathkumar InclHmeMedi
	ArrayList   enableDisParam_list= new ArrayList();//sarathkumar InclHmeMedi
	ArrayList	rBServiceLimits    =	new ArrayList();
	ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	
	if(excludedItems_RB.size()>0 && excludedItems_RB.containsKey(fromDate))
	{
		excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
	
		if(excludedItemsFD_RB.size()>0 && excludedItemsFD_RB.containsKey(service_code) )
		{
			rBServiceLimits =(ArrayList)excludedItemsFD_RB.get(service_code);
			
			if(rBServiceLimits.size()>0)
			{
				srvLimit_type_list		= (ArrayList)rBServiceLimits.get(0);
				srvLimit_service_code_list		= (ArrayList)rBServiceLimits.get(1);
				srvLimit_service_desc_list	= (ArrayList)rBServiceLimits.get(2);
				exludeService_list		= (ArrayList)rBServiceLimits.get(3);
				srvLimit_qty_limit_list			= (ArrayList)rBServiceLimits.get(4);
				srvLimit_amt_limit_list		= (ArrayList)rBServiceLimits.get(5);	
				srvLimit_factor_appl_list		= (ArrayList)rBServiceLimits.get(6);
				amt_limit_ind_list		= (ArrayList)rBServiceLimits.get(7);	
				srvLimit_replace_list		= (ArrayList)rBServiceLimits.get(8);
				srvLimit_replaceSrv_code_list	= (ArrayList)rBServiceLimits.get(9);	
				srvLimit_refund_list		= (ArrayList)rBServiceLimits.get(10);
				srvLimit_refundAmt_list		= (ArrayList)rBServiceLimits.get(11);
				srvLimit_auto_refund_list		= (ArrayList)rBServiceLimits.get(12);	
				srvLimit_roundTo_list		= (ArrayList)rBServiceLimits.get(13);
				srvLimit_roundInd_list		= (ArrayList)rBServiceLimits.get(14);
				srvLimit_replaceSrv_desc_list		= (ArrayList)rBServiceLimits.get(15);
				split_reqd_list	=	(ArrayList)rBServiceLimits.get(16);//Split reqd
				
				includeHomeMedication_list =(ArrayList)rBServiceLimits.get(17); //sarathkumar InclHmeMedi
				enableDisParam_list =(ArrayList)rBServiceLimits.get(18);
				if(rBServiceLimits.size()>19){
					dailyLmtChkBxList = (ArrayList)rBServiceLimits.get(19); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServiceLimits.size()>20){
					dailyLmtAmtList = (ArrayList)rBServiceLimits.get(20); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServiceLimits.size()>21){
					dailyLmtGrossNetList = (ArrayList)rBServiceLimits.get(21); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServiceLimits.size()>=22){
					dailyLmtIndicatorList = (ArrayList)rBServiceLimits.get(22); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				if(rBServiceLimits.size()>=23){
					dailyLmtQtyList = (ArrayList)rBServiceLimits.get(23); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				
				if(srvLimit_service_code_list.size()>0){
						totalRecords=srvLimit_service_code_list.size();
						disabled	="";	
					}
				}
			}
		}
		
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
		String parDailyLmtInd = request.getParameter("dailyLmtInd") == null ? "*" : request.getParameter("dailyLmtInd");//Added V190731-Aravindh/MMS-DM-CRF-0129.1

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(parent_indx));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(authorized));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pkgApprovedYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_associated));
            _bw.write(_wl_block22Bytes, _wl_block22);

	/* Added V190625-Aravindh/MMS-DM-CRF-0129.1/Starts */
	String blParametersqry = "SELECT NVL(PKG_SERV_LMT_BY,'*') PKG_SERV_LMT_BY, NVL(DAILY_PKG_LMT_YN,'N') DAILY_PKG_LMT_YN, NVL(DAILY_PKG_LMT_BY,'*') DAILY_PKG_LMT_BY FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facilityId+"'";
	PreparedStatement pstmt = con.prepareStatement(blParametersqry);
	ResultSet rst = pstmt.executeQuery();
	while(rst.next()) {
		pkgServLimit = rst.getString("PKG_SERV_LMT_BY");
		dailyLmtChkYN = rst.getString("DAILY_PKG_LMT_YN");
		dailyPkgLmt = rst.getString("DAILY_PKG_LMT_BY");
	}
	
	if(null != pkgServLimit && !"*".equals(pkgServLimit))
	{
		if("Q".equals(pkgServLimit)) {
			amtFldDisabled = " disabled ";
		} else if("A".equals(pkgServLimit)) {
			qtyFldDisabled = " disabled ";
		}
	}
	
	if(null == dailyLmtChkYN || !"Y".equals(dailyLmtChkYN)) {
		indicatorFldDisabled = " disabled ";
	}
	/* Added V190625-Aravindh/MMS-DM-CRF-0129.1/Ends */

	for(int i=0; i<totalRecords; i++)
	{	 
		if(srvLimit_service_code_list.size()>0)
		{
			srvLimit_type		= (String)srvLimit_type_list.get(i);
			srvLimit_service_code		= (String)srvLimit_service_code_list.get(i);
		    	srvLimit_service_desc	=(String) srvLimit_service_desc_list.get(i);
			exludeService		=(String) exludeService_list.get(i);
			srvLimit_qty_limit		= (String)srvLimit_qty_limit_list.get(i);
			srvLimit_amt_limit		= (String)srvLimit_amt_limit_list.get(i);
			srvLimit_factor_appl	= (String)srvLimit_factor_appl_list.get(i);
			srvLimit_amt_limit_ind	= (String)amt_limit_ind_list.get(i);		
			srvLimit_replace= (String)srvLimit_replace_list.get(i);				
			srvLimit_replaceSrv_code= (String)srvLimit_replaceSrv_code_list.get(i);		
			srvLimit_refund	= (String)srvLimit_refund_list.get(i);				
			srvLimit_refundAmt	= (String)srvLimit_refundAmt_list.get(i);			
			srvLimit_auto_refund= (String)srvLimit_auto_refund_list.get(i);			
			srvLimit_roundTo		= (String)srvLimit_roundTo_list.get(i);
			
			srvLimit_roundInd		= (String)srvLimit_roundInd_list.get(i);
			srvLimit_replaceSrv_desc		= (String)srvLimit_replaceSrv_desc_list.get(i);
			splitReqd	= 	(String)split_reqd_list.get(i);
			includeHomeMedication	= 	(String)includeHomeMedication_list.get(i); //sarathkumar InclHmeMedi
			enableDisParam	= 	(String)enableDisParam_list.get(i); //sarathkumar InclHmeMedi
			/* Commented V190819-Aravindh/MMS-DM-CRF-0129.1/Below line */
			//dailyLmtChkYN = (String) dailyLmtChkBxList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtAmt = (String) dailyLmtAmtList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtInd = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			if("".equals(dailyLmtInd)){
				dailyLmtInd = "*";
			}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		}
		
		if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
			exludeService="N";
			if(exludeService.equals("Y"))
			disabledAll="disabled";
		else
		   disabledAll="";
		if(srvLimit_replace.equals("Y"))
			  dtlsDisp = "inline";
		if(srvLimit_refund.equals("Y"))
			refndDisp = "inline";
	
		uSelect = srvLimit_roundInd.equals("U")? " selected "	 :"";
		dSelect = srvLimit_roundInd.equals("D")? " selected "	 :"";

		if(srvLimit_amt_limit_ind.equals("A"))
		{
			amtLmtIndNullDisplay    = "";
			amtLmtIndAmtDisplay		= " selected";
			amtLmtIndPerDisplay		= "";
			perAmt_limitStatus      ="";
		}
		else if(srvLimit_amt_limit_ind.equals("P"))
		{
			amtLmtIndNullDisplay    = "";
			amtLmtIndAmtDisplay		= "";
			amtLmtIndPerDisplay		= "selected";
			perAmt_limitStatus      ="";
		}
		else
		{
			amtLmtIndNullDisplay = "selected";
			amtLmtIndAmtDisplay		= "";
			amtLmtIndPerDisplay		= "";
			perAmt_limitStatus      =" disabled";
		}
		if(disabledAll.equals("disabled"))
			   perAmt_limitStatus = " disabled";
		
		
            _bw.write(_wl_block23Bytes, _wl_block23);

if(type.equals("G")){

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srvLimit_type.equals("C")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(srvLimit_type.equals("S")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(srvLimit_type.equals("M")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(srvLimit_type.equals("P")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
  
}
else if(type.equals("P")){

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srvLimit_type.equals("C")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(srvLimit_type.equals("G")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(srvLimit_type.equals("S")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(srvLimit_type.equals("M")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(srvLimit_type.equals("T")?"selected":""));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(srvLimit_type.equals("P")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

}
else{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(srvLimit_type.equals("S")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(srvLimit_service_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(srvLimit_service_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(exludeService.equals("Y")?"checked":""));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(exludeService));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(srvLimit_qty_limit));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(amtLmtIndNullDisplay));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(amtLmtIndAmtDisplay));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(amtLmtIndPerDisplay));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(perAmt_limitStatus));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srvLimit_amt_limit));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(srvLimit_roundTo));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(uSelect));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(dSelect));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
if(ss){ 

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(includeHomeMedication ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf("Y".equals(includeHomeMedication)?" checked ":""));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf("Y".equals(enableDisParam)?"":"disabled"));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(enableDisParam ));
            _bw.write(_wl_block113Bytes, _wl_block113);
 } else{
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
} 
            _bw.write(_wl_block117Bytes, _wl_block117);
if(dailyLimitSiteSpec) { 
            _bw.write(_wl_block118Bytes, _wl_block118);
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
 if("G".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) { 
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf("G".equals(dailyLmtInd)?" selected ":""));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
 } if("I".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) {
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf("I".equals(dailyLmtInd)?" selected ":""));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
 } 
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(dailyLmtChkYN));
            _bw.write(_wl_block130Bytes, _wl_block130);
            _bw.write(_wl_block131Bytes, _wl_block131);
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(dailyLmtAmt ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" readOnly ":""));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" disabled ":""));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf("G".equals(dailyLmtGrossNet)?" selected ":""));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf("N".equals(dailyLmtGrossNet)?" selected ":""));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(dailyLmtQty ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" readOnly ":""));
            _bw.write(_wl_block145Bytes, _wl_block145);
 } else { 
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);
 } 
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(srvLimit_type.equals("S")?"":" disabled "));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(srvLimit_replace.equals("Y")?" checked ":""));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(srvLimit_replace));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(dtlsDisp));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(srvLimit_replaceSrv_code));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(srvLimit_replaceSrv_desc));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(srvLimit_type.equals("S")?"":" disabled "));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srvLimit_refund.equals("Y")?" checked":""));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(srvLimit_refund));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(srvLimit_refundAmt));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(refndDisp));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(srvLimit_refundAmt.equals("")?" disabled ":""));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srvLimit_auto_refund.equals("Y")?" checked ":""));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(srvLimit_auto_refund));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disabledAll));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(srvLimit_factor_appl.equals("Y")?" checked ":""));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(srvLimit_amt_limit_ind.equals("A")?"":" disabled "));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(srvLimit_factor_appl));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf("Y".equals(exludeService)?"disabled":"" ));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(splitReqd ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf("Y".equals(splitReqd)?" checked ":""));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf( !"*".equals(dailyLmtInd)?" disabled ":"" ));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block190Bytes, _wl_block190);

}

            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(from));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(fromDate ));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(siteSpecf));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(dailyLimitSiteSpec));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(pkgServLimit));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(dailyPkgLmt));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(dailyLmtChkYN));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(parDailyLmtInd));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(servGrpLimitSiteSpec));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block208Bytes, _wl_block208);
}
	catch(Exception e)
	{
		System.out.println("Exception from package definition  Rate based exclusions:"+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block209Bytes, _wl_block209);
putObjectInBean(bean_id,bean,request);
            _bw.write(_wl_block210Bytes, _wl_block210);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageGrouping.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SalesCategory.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageGrouping.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Up.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOWN.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Dtls.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
