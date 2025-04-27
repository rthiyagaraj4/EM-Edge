package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __maintreatmentpackageservicedtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MainTreatmentPackageServiceDtls.jsp", 1742877789508L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n--------------------------------------------------------------------------------------\n1            V210504            16777\t      PMG2021-COMN-CRF-0076      Ram kumar S\n2\t\t\t\t\t\t\t\t30618\t\t  PMG2021-COMN-CRF-0076.2    Manivel N\n -->\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n<style>\n#table-wrapper {\n  position:relative;\n}\n#table-scroll {\n  height:410px; \n  overflow:auto;  \n  margin-top:20px;\n}\n#table-wrapper table {\n  width:100%;\n}\n#table-wrapper table  {\n  background:white;\n  color:black;\n}\n#table-wrapper table thead tr {\n  position:relative; \n  top: expression(offsetParent.scrollTop);\n  z-index:2;\n  height:20px;\n  width:35%;\n}\t\n\n</style>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/MaintainTreamentPackage.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/MaintainTreamentPackageExclude.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<title>Package Exclusions</title>\n<body onload=\"disableExclForAuthorisation(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\">\n<form name=\"MaintainTreatmentPkgExclForm\" id=\"MaintainTreatmentPkgExclForm\" id=\"MaintainTreatmentPkgExclForm\"\taction=\"\" target=\"messageFrame\" onload=\"disableExclForAuthorisation(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div id=\"table-wrapper\">\n\t\t\t\t\t\t\t\t<div id=\"table-scroll\" style=\"width:100vw;overflow-x: scroll;overflow-y: scroll;\">\n\t\t\t\t\t\t\t\t<table width=\'100%\' align=\"center\" cellpadding=\"4\" class=\'grid\'  cellspacing=\"0\" id=\"maintainTrtPkgExclDtls\">\n\t\t\t\n\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Service Ind</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Service Code</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Rate/Charge</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Exclude all </td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Qty Limit</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Limit Ind</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Amount Limit</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Home Medication</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Replaceable</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Replaceable Service</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Daily Limit Indicator</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Daily Qty Limit</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Daily Amount Limit </td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Refund</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Refund Rate</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Auto Refund</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Split Allowed</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Appl Factor</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Utilized Qty</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Utilized Amount</td>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"text-align:center;\">Delete</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t<tbody>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t<tr id=\'row1";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  onclick=\"showExclPackageServiceDesc(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width: 150px;\"\n\t\t\t\t\t\t\t\t\t\t\t\tname=\"pkg_serv_ind";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  id=\'pkg_serv_ind";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\tonChange=\'onCustServiceTypeChange(this,\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");\'\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input name=\"pkg_serv_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"pkg_serv_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" type=\"text\" id=\"pkg_serv_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" size=\"20\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' onblur=\'if(this.value!=\"\"){exclServLookup(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",this,pkg_serv";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =");}\'> \n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkg_serv";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'pkg_serv";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_pkg_serv_code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  id=\"button_pkg_serv_code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" value=\"?\" onClick=\'exclServLookup(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =",pkg_serv_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",pkg_serv";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =");\' >\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t  >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  size=\'10\'  style=\"text-align:center;\"  name=\"rate_charge_ind";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"rate_charge_ind";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" readonly />\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" size=\'20\' style=\"text-align:center;\"  name=\"chk_exclude_all";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"chk_exclude_all";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onClick=\'handleExclAll(this,\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\");\'/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t>\n\t\t\t\t\t\t\t\t\t\t\t\t   <input type=\"text\" size=\'10\'  style=\"text-align:center;\"  name=\"qty_limit";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"qty_limit";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"  value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' onBlur=\'validateExclFactorLmt(document.forms[0].rate_charge_ind";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =",this,";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =",2);\' onkeypress=\'return ChkNumberInput(this,event,\"0\");\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" >\n\t\t\t\t\t\t\t\t\t\t\t</td>\t\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t<td  align=\"left\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'amt_limit_ind";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'amt_limit_ind";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onChange=\'validateExclFactorLmt(document.forms[0].rate_charge_ind";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =",3);\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\'  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <option value=\'U\'  ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</option> -->\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"amt_limit";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"   id=\"amt_limit";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =",4);\' onkeypress=\'return allowValidNumber(this,event,10,\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\")\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" >\n\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"incl_home_medication_yn";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"incl_home_medication_yn";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" onClick=\'chkExclHomeMed(";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =")\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"home_med_enable_yn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"home_med_enable_yn";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'   nowrap><input type=\"checkbox\" name=\"replaceable_yn";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"replaceable_yn";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" onClick=\'chkExclReplacable(this,";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =");enableExclReplc(this,";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =");\'/></td>\n\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \tnowrap>   \n\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"replaceable_serv_code";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"replaceable_serv_code";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" type=\"text\" id=\"replaceable_serv_code";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" size=\"10\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onblur=\'if(this.value!=\"\"){repExclServLookup(";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =",this,rep_pkg_serv";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =")}\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" > \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rep_pkg_serv";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'rep_pkg_serv";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'  value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_rep_pkg_serv_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"  id=\"button_rep_pkg_serv_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" value=\"?\" onClick=\'repExclServLookup(";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =",replaceable_serv_code";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =",rep_pkg_serv";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =")\' ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap >\n\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:150px;\" name=\'daily_limit_ind";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'daily_limit_ind";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'  ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" onchange=\'dailyExclLmtIndicatorOnChange(this,";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =")\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\" name=\"daily_qty_limit";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"daily_qty_limit";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" onkeypress=\'return ChkNumberInput(this,event,\"0\");\'/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  style=\"text-align:center;\" name=\"daily_amt_limit";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"daily_amt_limit";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" onkeypress=\'return allowValidNumber(this,event,10,\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\")\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'GrossNet";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'GrossNet";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'  onChange=\'validateGrossNetInd(this,\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\");\' ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\'  ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" onkeypress=\'return ChkNumberInput(this,event,\"0\");\'/>\n\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  style=\"text-align:center;\" name=\"daily_amt_limit";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"refund_yn";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"refund_yn";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' onClick=\'exclRefundChk(this,";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" /></td>\n\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\"  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\" maxlength=\'4\' name=\"refund_rate";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\"refund_rate";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" onkeypress=\'return ChkNumberInput(this,event,\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\")\' onBlur=\'validPercentageForRefund(this,\"auto_refund_yn";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\")\'/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'   nowrap><input type=\"checkbox\" name=\"auto_refund_yn";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" id=\"auto_refund_yn";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' checked   onClick=\'exclAutoRefundChk(";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" /></td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" \tnowrap><input type=\"checkbox\" name=\"auto_refund_yn";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' onClick=\'exclAutoRefundChk(";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" />&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"split_allowed_yn";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"split_allowed_yn";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" onClick=\'exclSplitChk(";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =")\' checked /></td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" \t nowrap><input type=\"checkbox\" name=\"split_allowed_yn";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =")\' />\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap><input type=\"checkbox\" name=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" onClick=\'applExclFactChk(";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =")\' disabled ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" nowrap/></td>\n\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"utilized_serv_qty";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"utilized_serv_qty";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" disabled/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"utilized_serv_amt";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" id=\"utilized_serv_amt";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" disabled/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"radio";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" id=\"radio";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"  onClick=\"markRowForDel(this,";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =",this)\" ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_is_newly_added_row_YN_";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" name=\"hdn_is_newly_added_row_YN_";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_row_marked_for_del_";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" name=\"hdn_row_marked_for_del_";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_pkg_serv_ind";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" \t\t\tname=\"hdn_pkg_serv_ind";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"   value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_pkg_serv_code";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" \t\t\tname=\"hdn_pkg_serv_code";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_rate_charge_ind";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" \t\t\tname=\"hdn_rate_charge_ind";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_order_catalog_code";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" \t\t\tname=\"hdn_order_catalog_code";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'/>\n\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_qty_limit";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" \t\t\tname=\"hdn_qty_limit";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_amt_limit_ind";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" \t\t\tname=\"hdn_amt_limit_ind";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_amt_limit";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" \t\t\tname=\"hdn_amt_limit";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_incl_home_medication_yn";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" \t\t\tname=\"hdn_incl_home_medication_yn";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_replaceable_yn";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" \t\t\tname=\"hdn_replaceable_yn";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_replaceable_serv_code";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" \t\t\tname=\"hdn_replaceable_serv_code";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_limit_ind";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" \t\t\tname=\"hdn_daily_limit_ind";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_qty_limit";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" \t\t\tname=\"hdn_daily_qty_limit";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_amt_limit";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" \t\t\tname=\"hdn_daily_amt_limit";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_amt_limit_gross_net";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" \t\t\tname=\"hdn_daily_amt_limit_gross_net";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_refund_yn";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" \t\t\tname=\"hdn_refund_yn";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_refund_rate";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" \t\t\tname=\"hdn_refund_rate";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_auto_refund_yn";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" \t\t\tname=\"hdn_auto_refund_yn";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_utilized_serv_qty";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" \t\t\tname=\"hdn_utilized_serv_qty";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_utilized_serv_amt";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" \t\t\tname=\"hdn_utilized_serv_amt";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" \t\t\tname=\"hdn_apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'/>\n\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_split_allowed_yn";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" \t\t\tname=\"hdn_split_allowed_yn";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'/>\n\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_rowid";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" \t\t\tname=\"hdn_rowid";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_package_code";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" \t\t\tname=\"hdn_package_code";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_package_seq_no";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" \t\t\tname=\"hdn_package_seq_no";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"pkg_service_long_desc";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" \t\t\tname=\"pkg_service_long_desc";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'/>   \n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'index\' id=\'index\' id=\'index\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\' >\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<tr id=\'row1";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\');\">\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<select style=\"width: 150px;\"\n\t\t\t\t\t\t\t\t\t\t\tname=\"pkg_serv_ind";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'\n\t\t\t\t\t\t\t\t\t\t\tonChange=\'onCustServiceTypeChange(this,\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\");\'\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 =">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</option>\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t\t\t<input name=\"pkg_serv_code";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\"  type=\"text\" id=\"pkg_serv_code";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =");checkExclDuplicate(";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =");}\'> \n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkg_serv";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'  id=\'pkg_serv";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_pkg_serv_code";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =");\' >\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t        \n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t  >\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  size=\'10\'  style=\"text-align:center;\"  name=\"rate_charge_ind";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\"  id=\"rate_charge_ind";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" readonly />\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" size=\'20\' style=\"text-align:center;\"  name=\"chk_exclude_all";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\"   id=\"chk_exclude_all";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\");\'/>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t>\n\t\t\t\t\t\t\t\t\t\t\t   <input type=\"text\" size=\'10\'  style=\"text-align:center;\"  name=\"qty_limit";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\"   id=\"qty_limit";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 =" >\n\t\t\t\t\t\t\t\t\t\t</td>\t\n";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t\t\t\t\t\t<td  align=\"left\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'amt_limit_ind";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 =">\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'P\'  ";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</option><!--\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'U\'  ";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</option>-->\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"amt_limit";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\")\' ";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 =" >\n\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"incl_home_medication_yn";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\"  id=\"incl_home_medication_yn";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 =")\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"home_med_enable_yn";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\"  id=\"home_med_enable_yn";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\"\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'   nowrap><input type=\"checkbox\" name=\"replaceable_yn";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\"  id=\"replaceable_yn";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =");\'/></td>\n\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \tnowrap>   \n\t\t\t\t\t\t\t\t\t\t\t<input name=\"replaceable_serv_code";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"  type=\"text\" id=\"replaceable_serv_code";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 =" > \n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rep_pkg_serv";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'  id=\'rep_pkg_serv";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button_rep_pkg_serv_code";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 =">\n\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap >\n\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:150px;\" name=\'daily_limit_ind";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\'  id=\'daily_limit_ind";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\' ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =")\' >\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\" name=\"daily_qty_limit";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\"  id=\"daily_qty_limit";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 =" onkeypress=\'return ChkNumberInput(this,event,\"0\");\'/>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  style=\"text-align:center;\" name=\"daily_amt_limit";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\"  id=\"daily_amt_limit";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\")\' />\n\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'GrossNet";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\' onChange=\'validateGrossNetInd(this,\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 =" >\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'S\'  ";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 =" onkeypress=\'return ChkNumberInput(this,event,\"0\");\'/>\n\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  style=\"text-align:center;\" name=\"daily_amt_limit";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\")\'/>\n\t\t\t\t\t\t\t\t\t\t\t<select style=\"width:100px;\" name=\'GrossNet";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\'  id=\'GrossNet";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"refund_yn";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\"  id=\"refund_yn";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 =" /></td>\n\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\"  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\" maxlength=\'4\' name=\"refund_rate";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\"  id=\"refund_rate";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\")\'/>\n\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'   nowrap><input type=\"checkbox\" name=\"auto_refund_yn";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\"  id=\"auto_refund_yn";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 =" /></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" \tnowrap><input type=\"checkbox\" name=\"auto_refund_yn";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 =" />&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"split_allowed_yn";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\"  id=\"split_allowed_yn";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 =")\' checked /></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" \t nowrap><input type=\"checkbox\" name=\"split_allowed_yn";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 =")\' />\n\t\t\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap><input type=\"checkbox\" name=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\"  id=\"apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 =" nowrap/></td>\n\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"utilized_serv_qty";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\"  id=\"utilized_serv_qty";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" disabled/>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" \t nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" style=\"text-align:center;\"  name=\"utilized_serv_amt";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\"  id=\"utilized_serv_amt";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" disabled/>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"radio";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 =" />\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_is_newly_added_row_YN_";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_row_marked_for_del_";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\" value=\'N\'/>\n\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_pkg_serv_ind";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" name=\"hdn_pkg_serv_ind";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_pkg_serv_code";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" name=\"hdn_pkg_serv_code";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_rate_charge_ind";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" name=\"hdn_rate_charge_ind";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_order_catalog_code";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" name=\"hdn_order_catalog_code";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\'/>\n\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_qty_limit";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" name=\"hdn_qty_limit";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_amt_limit_ind";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" name=\"hdn_amt_limit_ind";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_amt_limit";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" name=\"hdn_amt_limit";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_incl_home_medication_yn";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" name=\"hdn_incl_home_medication_yn";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_replaceable_yn";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" name=\"hdn_replaceable_yn";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_replaceable_serv_code";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" name=\"hdn_replaceable_serv_code";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_limit_ind";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" name=\"hdn_daily_limit_ind";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_qty_limit";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" name=\"hdn_daily_qty_limit";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_amt_limit";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\" name=\"hdn_daily_amt_limit";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_daily_amt_limit_gross_net";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" name=\"hdn_daily_amt_limit_gross_net";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_refund_yn";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" name=\"hdn_refund_yn";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_refund_rate";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" name=\"hdn_refund_rate";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_auto_refund_yn";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" name=\"hdn_auto_refund_yn";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_utilized_serv_qty";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" name=\"hdn_utilized_serv_qty";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_utilized_serv_amt";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\" name=\"hdn_utilized_serv_amt";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\" name=\"hdn_apply_fact_for_srv_lmt_yn";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\'/>\n";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_split_allowed_yn";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" name=\"hdn_split_allowed_yn";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\'/>\n\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_rowid";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" name=\"hdn_rowid";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_package_code";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" name=\"hdn_package_code";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdn_package_seq_no";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\" name=\"hdn_package_seq_no";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"pkg_service_long_desc";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\" name=\"pkg_service_long_desc";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\'/>   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'  value=\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'dbcnt\' id=\'dbcnt\'  value=\'";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'cnt\' id=\'cnt\'  value=\'";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'index\' id=\'index\'  value=\'";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\' >\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"hdn_pack_code\" id=\"hdn_pack_code\" value=\'";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"hdn_pack_seq_no\" id=\"hdn_pack_seq_no\" value=\'";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"parent_pkg_serv_ind\" id=\"parent_pkg_serv_ind\" value=\'";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"parent_pkg_serv_code\" id=\"parent_pkg_serv_code\" value=\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\'/>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'indicatorFldDisabled\' id=\'indicatorFldDisabled\'  value=\'";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\'> \n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'amtFldDisabled\' id=\'amtFldDisabled\'  value=\'";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'qtyFldDisabled\' id=\'qtyFldDisabled\'  value=\'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'grossNetDisabled\' id=\'grossNetDisabled\'  value=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\'  value=\'";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkg_serv_lmt_YN\' id=\'pkg_serv_lmt_YN\'  value=\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'daily_pkg_lmt_yn\' id=\'daily_pkg_lmt_yn\'  value=\'";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'p_daily_pkg_serv_lmt\' id=\'p_daily_pkg_serv_lmt\'  value=\'";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'p_daily_pkg_serv_lmt_ind\' id=\'p_daily_pkg_serv_lmt_ind\'  value=\'";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\'>\n\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rowcount\' id=\'rowcount\'   value=\'\' >\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pkgServLmtDtlsPrivYN\'  id=\'pkgServLmtDtlsPrivYN\' value=\'";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\' >\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"15%\" >Package Service Details</td>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<span class=\"txtgray\">\n\t\t\t\t\t\t\t\t\t\t\t<input name=\"pkg_service_long_desc\"  type=\"text\" id=\"pkg_service_long_desc\" value=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\" size=\"50\" readonly />\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"button6\" id=\"button6\"  value=\"Replace Service\" disabled/>\n\t\t\t\t\t\t\t\t\t\t</span>\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"Add\"  id=\"Add\" value=\"Add\" onClick=\"addExclRow(); \" />\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"Save\"  id=\"Save\" value=\"Save\" onClick=\"sendBackExclValues();\" />\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"Close\"  id=\"Close\" value=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\" onClick=\"window.close()\" />\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\t\t\n\n";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );
	
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

private String checkForNull(String inputString) {
	return (inputString == null) ? "" : inputString;
}
public String PkgAmtPriceFormat(String str) {
	if (str == null || str.equals("")) {
		str = "0.00";
	} else {
		str = String.format("%.2f", Float.parseFloat(str));
	}
	return str;
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	
	int index = 0;
	
	Connection con = null;

	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	PreparedStatement pstmt4 = null;
	ResultSet rst4 = null;

	String patientid = request.getParameter("patientid");
	if(patientid == null) patientid = "";
	System.err.println("200--servv "+patientid);
	
	String facility_id = request.getParameter("facility_id");
	if(facility_id == null) facility_id = "";	
	
	String package_code = request.getParameter("sel_package_code");
	if(package_code == null) package_code = "";
	
	String package_seq_no = request.getParameter("sel_package_seq_no");
	if(package_seq_no == null) package_seq_no = "";
	
	String parent_pkg_serv_ind = request.getParameter("parent_pkg_serv_ind");
	if(parent_pkg_serv_ind == null) parent_pkg_serv_ind = "";
	
	String parent_pkg_serv_code = request.getParameter("parent_pkg_serv_code");
	if(parent_pkg_serv_code == null) parent_pkg_serv_code = "";
	
	int noofdecimal = Integer.parseInt(request.getParameter("noofdecimal")!=null ? request.getParameter("noofdecimal") : "2");
	
	String pkgServLmtDtlsPrivYN = request.getParameter("pkgServLmtDtlsPrivYN");
	if(pkgServLmtDtlsPrivYN == null) pkgServLmtDtlsPrivYN = "N";
	System.err.println("pkgServLmtDtlsPrivYN:"+pkgServLmtDtlsPrivYN);	
	
	String pkg_short_desc = "";
	String classval="fields";
	String pkg_service_long_desc = "";
	String pkg_service_long_des = "";
	String modifyStatus = "";

	String pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "",
			qtyFldDisabled = "", indicatorFldDisabled = "", grossNetDisabled="";	

	String eff_from_date = "";
	String eff_to_date = "";
	String package_amt = "";
	String deposit_amt = "";
	String utilized_amt = "";
	String blng_class_code = "";
	String cust_group_code = "";
	String cust_code = "";
	String cust_price = "";
	String encounter_associate_yn = "";
	String prac_name = "";
	String addl_chg_value = "";
	String operating_facility_id = "";
	String total_disc = "";
	
	String pkg_serv_ind = "";
	String pkg_serv_code = "";
	String rate_charge_ind = "";
	String order_catalog_code = "";
	int factor_rate_int = 0;//
	int qty_limit_int = 0;//
	String amt_limit_ind = "";
	int amt_limit_int = 0;//

	String incl_home_medication_yn = "";
	String incl_home_medication_yn1 = "";
	String home_med_enable_yn="";
	String home_med_enbl_disbl="";
	String replaceable_yn = "";
	String replaceable_yn1 = "";
	String daily_limit_ind = "";
	int daily_qty_limit_int;
	int daily_amt_limit_int;//
	String daily_amt_limit_gross_net = "";
	String replaceable_serv_code = "";
	String rep_serv_ord_cat_code = "";
	String refund_yn = "";
	int refund_rate_int = 0;//
	String apply_fact_for_srv_lmt_yn = "";

	int utilized_serv_qty_int = 0;//
	int utilized_serv_amt1_int = 0;//
	String auto_refund_yn1 = "";
	String split_allowed_yn = "";
	String encounter_name = "";
	String utilized_serv_qty_intg="";
	String encounter_id = "";

	String useraccess = "N";

	String episode_id = "";
	String visit_id = "";
	String episode_type = "";
	String long_desc = "";
	String factor_YN = "";
	String qty_limit = "";
	String amt_limit = "";
	String daily_qty_limit = "";
	String refund_rate = "";
	String utilized_serv_qty = "";
	String utilized_serv_amt = "";
	String auto_refund_yn = "";
	String daily_amt_limit = "";
	int utilized_serv_amt_int = 0;
	String exclude_all = "N";
	String hdn_is_newly_added_row_YN = "N";
	String hdn_row_marked_for_del = "N";
	
	String rowid = "";
	String tableid = "maintainTrtPkgDtls";
	String defaultPkgCode = "";
	String order_catalog_yn ="N";
	String across_enc_YN="";
	String defaultPkgSeq = "";
	String defaultEffFromDate = "";
	String refundchck="";
	String refndYNdisable="";
	ArrayList<String> pkgServiceDetailsCombination = new ArrayList<String>();
	String pkgDetailsCombinationString =request.getParameter("pkgDetailsCombinationString") == null ? "" :request.getParameter("pkgDetailsCombinationString");
	System.err.println("queryString->"+request.getQueryString());
	int count = 0;
	int cnt = 0, dbcnt = 0;

	boolean pkg_serv_ind_lmt=false;
	String PKG_LIMIT_IND_BY="";
	String pkg_serv_lmt_YN="N";
	boolean pkg_serv_lmt=false;
	String daily_pkg_lmt_yn="N";
	String p_daily_pkg_serv_lmt="N";
	String p_daily_pkg_serv_lmt_ind="N";
	
	String chk_exclude_all_YN = "N";
	String is_rec_mod_YN = "N";
	String exclString = "";
	String excludeAllDisabled = "";
	String excludeAllReadonly = "";
	
	
	is_rec_mod_YN = request.getParameter("is_excl_mod_YN") == null ? "N" :request.getParameter("is_excl_mod_YN");
	exclString = request.getParameter("excl_string") == null ? "N" :request.getParameter("excl_string");
	order_catalog_yn = request.getParameter("order_catalog_yn") == null ? "N" :request.getParameter("order_catalog_yn");
	across_enc_YN = request.getParameter("across_enc_YN") == null ? "N" :request.getParameter("across_enc_YN");

	pkg_serv_lmt_YN = request.getParameter("pkg_serv_lmt_YN") == null ? "N" :request.getParameter("pkg_serv_lmt_YN");
	daily_pkg_lmt_yn = request.getParameter("daily_pkg_lmt_yn") == null ? "N" :request.getParameter("daily_pkg_lmt_yn");
	p_daily_pkg_serv_lmt = request.getParameter("p_daily_pkg_serv_lmt") == null ? "" :request.getParameter("p_daily_pkg_serv_lmt");
	p_daily_pkg_serv_lmt_ind = request.getParameter("p_daily_pkg_serv_lmt_ind") == null ? "" :request.getParameter("p_daily_pkg_serv_lmt_ind");
	
	try {
			con = ConnectionManager.getConnection(request);
			HttpSession httpSession = request.getSession(false);
			
			System.err.println("pkg_serv_lmt_YN,536===>>"+pkg_serv_lmt_YN);
			if(pkg_serv_lmt_YN.equals("Y"))
			{
				try 
				{
					pstmt4 = con.prepareStatement("SELECT NVL (daily_pkg_lmt_yn, 'N') p_daily_limit_chk_yn,pkg_serv_lmt_by p_daily_pkg_serv_lmt_ind,daily_pkg_lmt_by p_daily_pkg_serv_lmt FROM bl_parameters WHERE operating_facility_id = ?");
				
					System.err.println("facility_id,395==>>"+facility_id);
					pstmt4.setString(1,facility_id); 
					rst4 = pstmt4.executeQuery() ;

					if( rst4 != null ) 
					{	
						while( rst4.next() )
						{  
							daily_pkg_lmt_yn = rst4.getString("p_daily_limit_chk_yn");							
							p_daily_pkg_serv_lmt_ind  = rst4.getString("p_daily_pkg_serv_lmt_ind");
							p_daily_pkg_serv_lmt = rst4.getString("p_daily_pkg_serv_lmt");

							if(daily_pkg_lmt_yn.equals("")){
								daily_pkg_lmt_yn="N";
							}
							if("".equals(p_daily_pkg_serv_lmt)){
								p_daily_pkg_serv_lmt="B";
							}
							if("".equals(p_daily_pkg_serv_lmt_ind)){
								p_daily_pkg_serv_lmt_ind="R";
							}
							System.err.println("daily_pkg_lmt_yn===>>"+daily_pkg_lmt_yn);
							System.err.println("p_daily_pkg_serv_lmt===>>"+p_daily_pkg_serv_lmt);
							System.err.println("p_daily_pkg_serv_lmt_ind===>>"+p_daily_pkg_serv_lmt_ind);
						}
					}
				}
				catch(Exception exe){
					exe.printStackTrace();
				}
			}
			else
			{
				indicatorFldDisabled="disabled";
				amtFldDisabled = "disabled";
				qtyFldDisabled = "disabled"; 
				grossNetDisabled="disabled";
			}
			
			System.err.println("daily_pkg_lmt_yn,577===>>"+daily_pkg_lmt_yn);
			System.err.println("order_catalog_yn,577===>>"+order_catalog_yn);

			if(daily_pkg_lmt_yn.equals("Y") && order_catalog_yn.equals("N") && across_enc_YN.equals("N"))
			{
				if(!p_daily_pkg_serv_lmt.equals("")){
					if(p_daily_pkg_serv_lmt_ind.equals("Q")){
						indicatorFldDisabled="";
						amtFldDisabled = "disabled";
						qtyFldDisabled = ""; 
						grossNetDisabled="";
					}else if(p_daily_pkg_serv_lmt_ind.equals("A")){
						indicatorFldDisabled="";
						amtFldDisabled = "";
						qtyFldDisabled = "disabled"; 
						grossNetDisabled="";
					}else if(p_daily_pkg_serv_lmt_ind.equals("B")){
						indicatorFldDisabled="";
						amtFldDisabled = "";
						qtyFldDisabled = ""; 
						grossNetDisabled="";
					}else{
						indicatorFldDisabled="disabled";
						amtFldDisabled = "disabled";
						qtyFldDisabled = "disabled"; 
						grossNetDisabled="disabled";
					}
				}else
				{
					indicatorFldDisabled="disabled";
					amtFldDisabled = "disabled";
					qtyFldDisabled = "disabled"; 
					grossNetDisabled="disabled";
				}
			}
			else
			{
				indicatorFldDisabled="disabled";
				amtFldDisabled = "disabled";
				qtyFldDisabled = "disabled"; 
				grossNetDisabled="disabled";
			}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block10Bytes, _wl_block10);

			if("Y".equals(is_rec_mod_YN)){
				if(!"".equals(exclString)){
					String[] exclRecordsArr = exclString.split("::");
					System.err.println("exclRecordsArr:"+exclRecordsArr.length);
					for(int i=0;i<exclRecordsArr.length;i++){
						System.err.println("exclRecordsArr:"+exclRecordsArr[i]);
						String[] exclRow = exclRecordsArr[i].split("~~");
						
						index++;	
						rate_charge_ind = exclRow[0];
						System.err.println("rate_charge_ind====>>488 " + rate_charge_ind);
						
						pkg_serv_ind = exclRow[2];
						System.err.println("pkg_serv_ind====>>488 " + pkg_serv_ind);
						pkg_serv_code = exclRow[1];
						System.err.println("pkg_serv_code====>>488 " + pkg_serv_code);

						order_catalog_code = "";
						System.err.println("order_catalog_code====>>488 " + order_catalog_code);
						
						amt_limit_ind = exclRow[4];
						System.err.println("amt_limit_ind====>>488 " + amt_limit_ind);
						
						incl_home_medication_yn1 = exclRow[14];
						home_med_enable_yn = exclRow[24];
						
						replaceable_yn = exclRow[7];
						
						daily_limit_ind = exclRow[18];
						if(daily_limit_ind == null || " ".equals(daily_limit_ind)) daily_limit_ind = "";

						System.err.println("replaceable_yn ====>> " + replaceable_yn);
						if(("Y").equals(home_med_enable_yn)){
							home_med_enbl_disbl="";
							if(("Y").equals(incl_home_medication_yn1)){
									incl_home_medication_yn="checked readonly";
							}
							else{
								incl_home_medication_yn="unchecked";
							}
							
								//replaceable_yn="checked";
							}
							else{	
								home_med_enbl_disbl="disabled";
								//replaceable_yn="unchecked";
							}
							
							System.err.println("incl_home_medication_yn1-->"+incl_home_medication_yn1);
							if(("Y").equals(replaceable_yn)){
								replaceable_yn="checked";
							}
							else{	
								replaceable_yn="unchecked";
							}
						System.err.println("replaceable_yn====>> " + replaceable_yn);
						
						System.err.println("daily_limit_ind====>>" + daily_limit_ind);
						
						daily_amt_limit_gross_net = exclRow[17];
						System.err.println("daily_amt_limit_gross_net====>>" + daily_amt_limit_gross_net);
						
						replaceable_serv_code = exclRow[8];
						if(replaceable_serv_code == null || " ".equals(replaceable_serv_code)) replaceable_serv_code = "";
						System.err.println("replaceable_serv_code====>>" + replaceable_serv_code);
						
						refund_yn = exclRow[9];
						System.err.println("refund_yn====>>" + refund_yn);
						
						apply_fact_for_srv_lmt_yn = exclRow[12];
						System.err.println("apply_fact_for_srv_lmt_yn====>>" + apply_fact_for_srv_lmt_yn);
						
						auto_refund_yn = exclRow[11];
						if(auto_refund_yn == null || auto_refund_yn.equals(" ")) auto_refund_yn = "N";
						
						split_allowed_yn = exclRow[13];
						
						daily_qty_limit = exclRow[19];
						
						qty_limit = exclRow[5];
						if(qty_limit == null || qty_limit.equals(" ")) qty_limit = "";
						
						amt_limit = exclRow[6];
						if(amt_limit == null || amt_limit.equals(" ")) amt_limit = "";
						
						daily_amt_limit = exclRow[16];
						if(daily_amt_limit == null || daily_amt_limit.equals(" ")) daily_amt_limit = "";
						
						refund_rate = exclRow[10];
						if(refund_rate == null || " ".equals(refund_rate)) refund_rate = "";
						
						System.err.println("refund_rate=="+refund_rate);
							
						utilized_serv_qty_intg = exclRow[25];
						utilized_serv_amt = exclRow[26];	
						System.err.println("utilized_serv_qty_int :: " + utilized_serv_qty_intg);
					
						rowid = exclRow[22];
						pkg_service_long_desc = exclRow[27];
						
						exclude_all = exclRow[3];	
						if(exclude_all == null || exclude_all.equals(" ")) exclude_all = "N";
						if("Y".equals(exclude_all)){
							excludeAllDisabled = "disabled";
							excludeAllReadonly = "readonly";
						} else {
							excludeAllDisabled = "";
							excludeAllReadonly = "";						
						}

						hdn_is_newly_added_row_YN = exclRow[20];
						if(hdn_is_newly_added_row_YN == null || hdn_is_newly_added_row_YN.equals(" ")) hdn_is_newly_added_row_YN = "N";
						
						hdn_row_marked_for_del = exclRow[21];
						if(hdn_row_marked_for_del == null || hdn_row_marked_for_del.equals(" ")) hdn_row_marked_for_del = "N";					

						System.err.println("order_catalog_code :: ======================>855>" + order_catalog_code);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);

						System.err.println("amt_limit_ind :: " + amt_limit_ind);
						System.err.println("daily_amt_limit_gross_net :: " + daily_amt_limit_gross_net);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);
						System.err.println("amt_limit :: " + amt_limit);
						System.err.println("daily_qty_limit :: " + daily_qty_limit);
						System.err.println("daily_amt_limit :: " + daily_amt_limit);
						System.err.println("pkg_service_long_desc :: "+pkg_service_long_desc);
						System.err.println("rowid ::=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "+ rowid);
						System.err.println("classval :: "+classval+" index="+index);
						System.err.println("pkg_service_long_des-->"+pkg_service_long_desc);
						String disable="";
						String disabled="";
						
						if(replaceable_yn.equals("unchecked")) {
							disable="disabled";
							replaceable_yn1="N";
						}else if(replaceable_yn.equals("checked") && rep_serv_ord_cat_code.equals("")){
							replaceable_yn1="Y";
							disabled="disabled";
						}else{
							replaceable_yn1="Y";
							disable="";
							disabled="";
						}
						System.err.println("replaceable_yn1-"+replaceable_yn1);
						System.err.println("replaceable_yn-"+replaceable_yn);
						if(("Y").equals(refund_yn)){
							refundchck="checked";
							refndYNdisable="";
						}
						else{	
							refundchck="unchecked";
							refndYNdisable="disabled";
						}					
						
						System.err.println(disabled);
						System.err.println(disable);
						cnt++;
						if("N".equals(hdn_is_newly_added_row_YN))
							dbcnt++;
						System.err.println("cnt-->"+cnt);
						if(i==0){
							System.err.println("cnt1-->1");
							pkg_service_long_des=exclRow[27];
							System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
						}
						System.err.println("pkg_service_long_des-->"+pkg_service_long_des);					
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(index));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(index));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(index));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(index));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);

													if(!"G".equals(parent_pkg_serv_ind) && !"C".equals(parent_pkg_serv_ind)){
												
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pkg_serv_ind.equals("G") ? "selected" : ""));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

													}
													if(!"C".equals(parent_pkg_serv_ind)){
												
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_serv_ind.equals("C") ? "selected" : ""));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

													}
												
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pkg_serv_ind.equals("S") ? "selected" : ""));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(pkg_serv_ind.equals("P") ? "selected" : ""));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pkg_serv_ind.equals("M") ? "selected" : ""));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(index));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(index));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rate_charge_ind));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(exclude_all));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(("Y".equals(exclude_all)) ? "checked" : ""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(excludeAllReadonly));
            _bw.write(_wl_block54Bytes, _wl_block54);
 System.err.println("Check1"); 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(index));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((amt_limit_ind.equals("A")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((amt_limit_ind.equals("P")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((amt_limit_ind.equals("U")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(excludeAllReadonly));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(incl_home_medication_yn1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(incl_home_medication_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(home_med_enbl_disbl));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(index));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(home_med_enable_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(replaceable_yn1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(replaceable_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(index));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(index));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(index));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(replaceable_serv_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(index));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(index));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(index));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(index));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(index));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
if(!daily_limit_ind.equals("")){
												if("G".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) { 
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf("G".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
 } if("I".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) {
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf("I".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
 }
												}else{ 
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf("G".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf("I".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
 }
            _bw.write(_wl_block104Bytes, _wl_block104);
	if(!daily_limit_ind.equals("")){
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("G")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("N")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
}else{
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("G")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("N")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block119Bytes, _wl_block119);
 System.err.println("Check2"); 
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(refund_yn));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(refundchck));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(index));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(refund_rate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
 if(!auto_refund_yn.equals("") && auto_refund_yn.equals("Y")){
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block131Bytes, _wl_block131);
}else{
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
 if(!split_allowed_yn.equals("") && split_allowed_yn.equals("Y")){
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(index));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block139Bytes, _wl_block139);
}else{
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(index));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(index));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(("Y".equals(apply_fact_for_srv_lmt_yn)) ? "checked" : "" ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(index));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(utilized_serv_qty_intg));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(index));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(utilized_serv_amt));
            _bw.write(_wl_block150Bytes, _wl_block150);
 System.err.println("Check3"); 
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(index));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(index));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(("Y".equals(hdn_row_marked_for_del)) ? "checked" : ""));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(index));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(index));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(pkg_serv_ind));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(index));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(index));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rate_charge_ind));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(index));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(index));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(index));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amt_limit_ind));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(index));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(index));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(incl_home_medication_yn1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(index));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(replaceable_yn1));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(index));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(replaceable_serv_code));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(index));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_limit_ind));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(index));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(index));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(index));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_amt_limit_gross_net));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(index));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(refund_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(index));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(refund_rate));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(index));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(index));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(utilized_serv_qty_intg));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(index));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(utilized_serv_amt));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(index));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
 System.err.println("Check4"); 
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(index));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(index));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(index));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(defaultPkgCode));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(index));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(defaultPkgSeq));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(index));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(index));
            _bw.write(_wl_block212Bytes, _wl_block212);

					}
				} 
			}
			else 
			{
			
				String sqlstr1 = "select EXCL_SERV_IND pack_serv,EXCL_SERV_CODE pkg_serv_code,rate_charge_ind,null order_catalog_code,"
				+" qty_limit, amt_limit_ind,amt_limit,incl_home_medication_yn,replaceable_yn,daily_limit_ind,"
				+" daily_qty_limit, daily_amt_limit, daily_amt_limit_gross_net, replaceable_serv_code, refund_yn,refund_rate,"
				+" apply_fact_for_srv_lmt_yn,round(utilized_serv_qty,2) utilized_serv_qty, utilized_serv_amt,auto_refund_yn," 
				+" split_allowed_yn,rowid,blpackage.get_description(EXCL_SERV_IND,EXCL_SERV_CODE,'"+ locale + "') pkg_service_long_desc,"
				+" blcommonproc.bl_pharm_service_yn ('en',EXCL_SERV_IND,EXCL_SERV_CODE) home_medication_enable_yn, EXCLUDE_YN "
				+" from bl_package_sub_excl where OPERATING_FACILITY_ID = '" + facility_id + "' AND PATIENT_ID = '"+ patientid + "'"
				+" AND PACKAGE_CODE = '"+ package_code +"' AND PACKAGE_SEQ_NO = '"+ package_seq_no +"' AND PKG_SERV_CODE = '"+ parent_pkg_serv_code +"'";
				
				System.err.println("sqlstr excl:"+sqlstr1);
				pstmt1 = con.prepareStatement(sqlstr1);
				rs1 = pstmt1.executeQuery();
				if (rs1 != null) {
					while (rs1.next()){
						index = rs1.getRow();	
						pkg_serv_ind = checkForNull(rs1.getString("pack_serv"));
						System.err.println("pkg_serv_ind====>>488 " + pkg_serv_ind);
						pkg_serv_code = checkForNull(rs1.getString("pkg_serv_code"));
						System.err.println("pkg_serv_code====>>488 " + pkg_serv_code);
						rate_charge_ind = checkForNull(rs1.getString("rate_charge_ind"));
						System.err.println("rate_charge_ind====>>488 " + rate_charge_ind);
						order_catalog_code = checkForNull(rs1.getString("order_catalog_code"));
						System.err.println("order_catalog_code====>>488 " + order_catalog_code);
						
						amt_limit_ind = checkForNull(rs1.getString("amt_limit_ind"));
						System.err.println("amt_limit_ind====>>488 " + amt_limit_ind);
						
						incl_home_medication_yn1 = checkForNull(rs1.getString("incl_home_medication_yn"));
						home_med_enable_yn = checkForNull(rs1.getString("home_medication_enable_yn"));
						replaceable_yn = checkForNull(rs1.getString("replaceable_yn"));
						daily_limit_ind = checkForNull(rs1.getString("daily_limit_ind"));
						System.err.println("replaceable_yn ====>> " + replaceable_yn);
						if(("Y").equals(home_med_enable_yn)){
							home_med_enbl_disbl="";
							if(("Y").equals(incl_home_medication_yn1)){
									incl_home_medication_yn="checked readonly";
							}
							else{
								incl_home_medication_yn="unchecked";
							}
							
								//replaceable_yn="checked";
							}
							else{	
								home_med_enbl_disbl="disabled";
								//replaceable_yn="unchecked";
							}
							
							System.err.println("incl_home_medication_yn1-->"+incl_home_medication_yn1);
							if(("Y").equals(replaceable_yn)){
								replaceable_yn="checked";
							}
							else{	
								replaceable_yn="unchecked";
							}
						System.err.println("replaceable_yn====>> " + replaceable_yn);
						
						System.err.println("daily_limit_ind====>>" + daily_limit_ind);
						
						daily_amt_limit_gross_net = checkForNull(rs1.getString("daily_amt_limit_gross_net"));
						System.err.println("daily_amt_limit_gross_net====>>" + daily_amt_limit_gross_net);
						replaceable_serv_code = checkForNull(rs1.getString("replaceable_serv_code"));
						System.err.println("replaceable_serv_code====>>" + replaceable_serv_code);
						
						refund_yn = checkForNull(rs1.getString("refund_yn"));
						System.err.println("refund_yn====>>" + refund_yn);
						
						apply_fact_for_srv_lmt_yn = checkForNull(rs1.getString("apply_fact_for_srv_lmt_yn"));
						System.err.println("apply_fact_for_srv_lmt_yn====>>" + apply_fact_for_srv_lmt_yn);
						
						auto_refund_yn = checkForNull(rs1.getString("auto_refund_yn"));
						split_allowed_yn = checkForNull(rs1.getString("split_allowed_yn"));
						
						daily_qty_limit = checkForNull(rs1.getString("daily_qty_limit"));
						qty_limit = checkForNull(rs1.getString("qty_limit"));
						amt_limit = checkForNull(rs1.getString("amt_limit"));
						daily_amt_limit = checkForNull(rs1.getString("daily_amt_limit"));
						refund_rate = checkForNull(rs1.getString("refund_rate"));
						
						System.err.println("refund_rate=="+refund_rate);
							
						utilized_serv_qty_intg = checkForNull(rs1.getString("utilized_serv_qty"));
						utilized_serv_amt = checkForNull(rs1.getString("utilized_serv_amt"));	
						System.err.println("utilized_serv_qty_int :: " + utilized_serv_qty_intg);
					
						rowid = checkForNull(rs1.getString("rowid"));
						pkg_service_long_desc = checkForNull(rs1.getString("pkg_service_long_desc"));
						
						exclude_all = checkForNull(rs1.getString("EXCLUDE_YN"));
						if("Y".equals(exclude_all)){
							excludeAllDisabled = "disabled";
							excludeAllReadonly = "readonly";
						}						

						System.err.println("order_catalog_code :: ======================>855>" + order_catalog_code);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);

						System.err.println("amt_limit_ind :: " + amt_limit_ind);
						System.err.println("daily_amt_limit_gross_net :: " + daily_amt_limit_gross_net);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);
						System.err.println("amt_limit :: " + amt_limit);
						System.err.println("daily_qty_limit :: " + daily_qty_limit);
						System.err.println("daily_amt_limit :: " + daily_amt_limit);
						System.err.println("pkg_service_long_desc :: "+pkg_service_long_desc);
						System.err.println(
								"rowid ::=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "
										+ rowid);
						System.err.println("classval :: "+classval+" index="+index);
						System.err.println("pkg_service_long_des-->"+pkg_service_long_desc);
						String disable="";
						String disabled="";
						
						if(replaceable_yn.equals("unchecked")) {
							disable="disabled";
							replaceable_yn1="N";
						}else if(replaceable_yn.equals("checked") && rep_serv_ord_cat_code.equals("")){
							replaceable_yn1="Y";
							disabled="disabled";
						}else{
							replaceable_yn1="Y";
							disable="";
							disabled="";
						}
						System.err.println("replaceable_yn1-"+replaceable_yn1);
						System.err.println("replaceable_yn-"+replaceable_yn);
						if(("Y").equals(refund_yn)){
								refundchck="checked";
								refndYNdisable="";
							}
							else{	
								refundchck="unchecked";
								refndYNdisable="disabled";
							}					
						
						System.err.println(disabled);
						System.err.println(disable);
						cnt++;
						dbcnt++;
						System.err.println("cnt-->"+cnt);
						if(cnt==1){
							System.err.println("cnt1-->1");
							pkg_service_long_des=checkForNull(rs1.getString("pkg_service_long_desc"));
							System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
						}
						System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
					

            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(index));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(index));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(index));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(index));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block217Bytes, _wl_block217);

												if(!"G".equals(parent_pkg_serv_ind)){
											
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(pkg_serv_ind.equals("G") ? "selected" : ""));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);

												}
												if(!"C".equals(parent_pkg_serv_ind)){
											
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(pkg_serv_ind.equals("C") ? "selected" : ""));
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);

												}
											
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(pkg_serv_ind.equals("S") ? "selected" : ""));
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(pkg_serv_ind.equals("P") ? "selected" : ""));
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(pkg_serv_ind.equals("M") ? "selected" : ""));
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(index));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(index));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(index));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(index));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(index));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(index));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(index));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rate_charge_ind));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(exclude_all));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(("Y".equals(exclude_all)) ? "checked" : ""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(index));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(excludeAllReadonly));
            _bw.write(_wl_block238Bytes, _wl_block238);
 System.err.println("Check1"); 
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(index));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf((amt_limit_ind.equals("A")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf((amt_limit_ind.equals("P")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf((amt_limit_ind.equals("U")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(excludeAllReadonly));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(incl_home_medication_yn1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(incl_home_medication_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(home_med_enbl_disbl));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(index));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(home_med_enable_yn));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(replaceable_yn1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(replaceable_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(index));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(index));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(replaceable_serv_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(index));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(index));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(index));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( disable));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(index));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(index));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
if(!daily_limit_ind.equals("")){
											if("G".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) { 
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf("G".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
 } if("I".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) {
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf("I".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
 }
											}else{ 
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf("G".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf("I".equals(daily_limit_ind)?" selected ":""));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
 }
            _bw.write(_wl_block265Bytes, _wl_block265);
	if(!daily_limit_ind.equals("")){
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(index));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(index));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(index));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("G")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("N")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
}else{
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(index));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(index));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(index));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(index));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(index));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(excludeAllDisabled));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("G")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf((daily_amt_limit_gross_net.equals("N")?"selected":"") ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
 System.err.println("Check2"); 
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(refund_yn));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(refundchck));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(index));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(refund_rate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block282Bytes, _wl_block282);
 if(!auto_refund_yn.equals("") && auto_refund_yn.equals("Y")){
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block285Bytes, _wl_block285);
}else{
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(refndYNdisable));
            _bw.write(_wl_block287Bytes, _wl_block287);
}
            _bw.write(_wl_block288Bytes, _wl_block288);
 if(!split_allowed_yn.equals("") && split_allowed_yn.equals("Y")){
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(index));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block291Bytes, _wl_block291);
}else{
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(index));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block293Bytes, _wl_block293);
}
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(index));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(index));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(("Y".equals(apply_fact_for_srv_lmt_yn)) ? "checked" : "" ));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(index));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(utilized_serv_qty_intg));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(index));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(utilized_serv_amt));
            _bw.write(_wl_block300Bytes, _wl_block300);
 System.err.println("Check3"); 
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(index));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(index));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(("Y".equals(hdn_row_marked_for_del)) ? "checked" : ""));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(index));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(index));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(pkg_serv_ind));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(index));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pkg_serv_code));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(index));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rate_charge_ind));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(index));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(index));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(index));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amt_limit_ind));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(index));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(index));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(incl_home_medication_yn1));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(index));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(replaceable_yn1));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(index));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(replaceable_serv_code));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(index));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_limit_ind));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(index));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_qty_limit));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(index));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_amt_limit));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(index));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(daily_amt_limit_gross_net));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(index));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(refund_yn));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(index));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(refund_rate));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(index));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(auto_refund_yn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(index));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(utilized_serv_qty_intg));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(index));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(utilized_serv_amt));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(index));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(apply_fact_for_srv_lmt_yn));
            _bw.write(_wl_block344Bytes, _wl_block344);
 System.err.println("Check4"); 
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(index));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(split_allowed_yn));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(index));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(index));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(defaultPkgCode));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(index));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(defaultPkgSeq));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(index));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pkg_service_long_desc));
            _bw.write(_wl_block355Bytes, _wl_block355);

									}
								}	
			}

            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(dbcnt));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(index));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(package_code));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(parent_pkg_serv_ind));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(parent_pkg_serv_code));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(grossNetDisabled));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(pkg_serv_lmt_YN));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(daily_pkg_lmt_yn));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(p_daily_pkg_serv_lmt));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(p_daily_pkg_serv_lmt_ind));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(pkgServLmtDtlsPrivYN));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(pkg_service_long_des));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block377Bytes, _wl_block377);

		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in MainTreatmentPackageServiceDtls.jsp:"+e);
			
		}
		finally 
		{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			if(rst4 != null) rst4.close();
			if(pstmt4 != null) pstmt4.close();
			ConnectionManager.returnConnection(con, request);
		}

            _bw.write(_wl_block378Bytes, _wl_block378);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Items.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNLIMITED.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageGrouping.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Items.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNLIMITED.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
