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
import eBL.PkgDefBean;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eBL.BLReportIdMapper;
import java.util.*;
import com.ehis.util.*;

public final class __pkgdefblnggrpratebased extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefBlngGrpRateBased.jsp", 1737917251125L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/PkgDef.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/PkgDefBlngGrp.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\t$(document).ready(function(){\n\t\t//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated.\n\t\tif($(\'#dailyLimitSiteSpec\').val() == true || $(\'#dailyLimitSiteSpec\').val() == \"true\") { \n\t\t\tif(document.forms[0].order_associated.value == \"Y\") {\n\t\t\t\tvar formObj=document.blng_grp_rate_based_dtl;\n\t\t\t\tfor(var cnt = 0; cnt < document.forms[0].totalRecords.value; cnt++) {\n\t\t\t\t\teval(\"formObj.dailyLmtChkBx\"+cnt).checked = false;\n\t\t\t\t\t\n\t\t\t\t\teval(\"formObj.dailyLmtChkBx\"+cnt).value = \'N\';\n\t\t\t\t\teval(\"formObj.dailyLmtAmt\"+cnt).value = \'\';\n\t\t\t\t\teval(\"formObj.dailyLmtGrossNetList\"+cnt).value = \'G\';\n\t\t\t\t\teval(\"formObj.dailyLmtIndicator\"+cnt).value = \'*\';//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\t\t\teval(\"formObj.dailyLmtQty\"+cnt).value = \'\';//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\t\t\t\n\t\t\t\t\teval(\"formObj.dailyLmtChkBx\"+cnt).disabled = true;\n\t\t\t\t\teval(\"formObj.dailyLmtAmt\"+cnt).disabled = true;\n\t\t\t\t\teval(\"formObj.dailyLmtGrossNetList\"+cnt).disabled = true;\n\t\t\t\t\teval(\"formObj.dailyLmtIndicator\"+cnt).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\t\t\teval(\"formObj.dailyLmtQty\"+cnt).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1\n\t\t\t\t}\n\t\t\t}\n\t\t}//Ends\n\t\t\t\t\n\t});\n\tfunction alignHeading()\n\t{\t\t\t\t\n\t\tif(parent.blng_grp_rate_based_dtl_hdr.document.getElementById(\"tableheader1\")!=null)\n\t\t{\t\t\t\t\t\n\t\t\tparent.blng_grp_rate_based_dtl_hdr.document.getElementById(\"tableheader1\").width =\teval(parent.frames[1].document.getElementById(\"blng_grp_rate_based_tbl\").offsetWidth);\n\t\t\tfor (j=0; j < parent.frames[1].document.getElementById(\"blng_grp_rate_based_tbl\").rows(2).cells.length; j++) \n\t\t\t{\t\t\t\n\t\t\t\tvar  wid=eval(parent.frames[1].document.getElementById(\"blng_grp_rate_based_tbl\").rows(2).cells(j).offsetWidth);\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(parent.blng_grp_rate_based_dtl_hdr.document.getElementById(\"tableheader1\").rows(1).cells(j) != null)\n\t\t\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tparent.blng_grp_rate_based_dtl_hdr.document.getElementById(\"tableheader1\").rows(1).cells(j).width=wid;\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction moveFrame()\n\t{\t\n\t\tvar temp=document.body.scrollLeft;\n\t\tscrollValue=temp;\n\n\t\tif(parent.blng_grp_rate_based_dtl_hdr.location.href.indexOf(\".jsp\") != -1)\n\t\t{\n\t\t\tparent.blng_grp_rate_based_dtl_hdr.document.body.scrollLeft=temp;\n\t\t}\n\t}\n</script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onscroll=\'moveFrame()\' onLoad=\'includeHomeMedicationEnableBlngGrp();\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\'blng_grp_rate_based_dtl\' id=\'blng_grp_rate_based_dtl\'  target=\'messageFrame\' >\t\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" height=\"\" class=\'grid\'  id=\"blng_grp_rate_based_tbl\">\n<tr></tr><tr></tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<tr>\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'> \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<select name=\'type";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'type";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" onChange=\'onBlngGrpServiceTypeChange(this,\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\'>\n\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</option>\n\t\t\t</select>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\'>\n\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</option>\n\t\t\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t</option>\n\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</option>\t\n\t<!-- Modified by Muthu against KDAH-SCF-0057 on 27-4-12 -->\n\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t</option>\n\t<!-- Modified by Muthu against KDAH-SCF-0057 -->\n\t\t\t</select>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</td>\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'hidden\' name=\'service_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'service_code";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<input type=\'text\' name = \'service_desc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" size=\'10\' maxlength=\'10\' onBlur=\"before_blngGrpServiceLookUp(this,service_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",type";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<INPUT type=\'hidden\' name=\'service_desc_temp";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'service_desc_temp";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'\'>\n\t\t\t<input type=\'button\' name=\'service_button";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'service_button";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' class=\'button\'   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" value=\'?\' onclick=\"blngGrpServiceLookUp(service_desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",service_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\">\n\t\t\t<input type=\'hidden\' name=\'oldSrvKey";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'oldSrvKey";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t</td>\n\t\t\t\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'hidden\' name=\'catalog_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'catalog_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'text\' name = \'catalog_desc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'   ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" size=\'10\' maxlength=\'10\' onBlur=\"before_blngGrpCatalogLookUp(this,catalog_code";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t<INPUT type=\'hidden\' name=\'catalog_desc_temp";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'catalog_desc_temp";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' value=\'\'>\n\t\t\t<input type=\'button\'   ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" name=\'catalog_button";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="  class=\'button\' value=\'?\' onclick=\"blngGrpCatalogLookUp(catalog_desc";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =",catalog_code";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\">\n\t\t</td>\n\t\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<select name=\'ind";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'ind";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onChange=\'onblngGrpIndChange(this,\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\")\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =">\n\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t\t\t\t<option value=\'R\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\n\t\t\t<select name=\'ind";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' onChange=\'onBlngGrpIndChange(this,\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</option>\n\t\t\t\t<option value=\'U\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</option>\n\t\t\t\t<option value=\'X\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" ></option>\n\t\t\t</select>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\' name=\'factorOrRate";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'factorOrRate";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' size=\'12\'  ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  maxlength=\'13\'  onBlur=\'checkForNegetiveNumber(this,\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\",\"BL8665\");\' onkeypress=\'return allowValidNumber(this,event,\"10\",\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\")\'; value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" />\n\t\t</td>\n\t\t\t\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\'    name=\'qty_limit";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'qty_limit";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'   size=\'8\'  ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="  ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" onBlur=\'chkBlngGrpQtyLimit(this,\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\");\' onkeypress=\'return allowValidNumber(this,event,noofdecimal.value)\'; value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" />\n\t\t</td>\n\n<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<select name=\'amt_limit_ind";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'amt_limit_ind";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' onChange=\'validateBlngGrpInd(this,\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\");changeSplitReqd(this,\"amt_limit\",\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\",\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\",dailyLmtIndicator";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =")\'  ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">\n\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =">--";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="--</option>\n\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</option>\n\t\t\t\t<option value=\'P\'  ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\' name=\'perAmt_limit";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' id=\'perAmt_limit";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' size=\'8\' maxlength=\'13\'  ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" onBlur=\'blngGrpValidForAmtPerUnltd(document.forms[0].amt_limit_ind";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =",this,\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\",\"\",\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\")\' onkeypress=\'return allowValidNumber(this,event,\"10\",\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t</td>\n\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\' name=\'roundTo";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'roundTo";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' size=\'6\'  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" maxlength=\"3\"  value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"  onkeypress=\" return (allowValidNumber(this,event,noofdecimal.value));\"  />\n\t\t</td>\n\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<select name=\'roundInd";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' id=\'roundInd";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'    onChange=\"\"   ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =">\n\t\t\t\t<option value=\'U\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</option>\n\t\t\t\t<option value=\'D\' ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\t\n\t\t<td class=\'fields\' nowrap WIDTH=\'75\'><input type=\'checkbox\'   ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" name=\'includeHomeMedication";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'includeHomeMedication";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="  onclick=\"checkInclHomeMedi(this);\">\n\t\t<input type=\'hidden\' name=\'enableDisParam";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\'enableDisParam";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"> </td>\n\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<td class=\'fields\' nowrap WIDTH=\'\'><input type=\'hidden\'   ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\tname=\'includeHomeMedication";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' value=\'Y\' >\n\t\t\t<input type=\'hidden\' name=\'enableDisParam";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' value=\"Y\"> </td>\n\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->\n\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\t\t\t\n\t\t\t<td class=\'fields\' WIDTH=\'80\' nowrap >\n\t\t\t\t<select name=\'dailyLmtIndicator";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' id=\'dailyLmtIndicator";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" onchange=\'dailyLmtIndicatorOnChange(this,";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =",document.blng_grp_rate_based_dtl)\' >\n\t\t\t\t\t<option value=\"*\">";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t</select>\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtChkBx";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' id = \'dailyLmtChkBx";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' value = \'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' />\n\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t\t\t<input type=\'text\' name = \'dailyLmtAmt";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id = \'dailyLmtAmt";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' size=\'8\' maxlength=\'13\' onBlur=\'return checkForNegetiveNumber(this,\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\",\"BL8540\");\' \n\t\t\t\t\t\tonkeypress=\'return allowValidNumber(this,event,10,\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\");\' ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =" \n\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =" />\n\t\t\t\t<select name=\'dailyLmtGrossNetList";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' id=\'dailyLmtGrossNetList";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" >\n\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</option>\n\t\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</option>\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t\t\t<input type=\'text\' name = \'dailyLmtQty";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' id = \'dailyLmtQty";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' size=\'8\' maxlength=\'3\' onBlur=\'return checkForNegetiveNumber(this,0,\"BL8538\");\' \n\t\t\t\t\t\tonkeypress=\'return allowValidNumber(this,event,10,0);\' ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" />\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtChkBx";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' value = \'N\' />\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtIndicator";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id = \'dailyLmtIndicator";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' value = \'\' />\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtAmt";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' value = \'\' />\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtGrossNetList";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' value = \'\' />\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtQty";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' value = \'\' />\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t<td  class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'   ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" name=\'replace";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" onClick=\'chkBlngGrpReplace(this,\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\")\' value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"/>\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t<a name=\'replace_dtls";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' href=\'#\' onClick=\'showBlngGrpReplaceDtls(\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\")\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</a>\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\t\t\t<input type=\"hidden\" name=\"replaceSrv_code";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" id=\"replaceSrv_code";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_desc";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" id=\"replaceSrv_desc";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_cat_code";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" id=\"replaceSrv_cat_code";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_cat_desc";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" id=\"replaceSrv_cat_desc";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"> \n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'   ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\t  ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" name=\'refund";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" onClick=\'chkBlngGrpRefund(this,\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t<input type=\'text\' name=\'refundAmt";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' id=\'refundAmt";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' onBlur=\'validPercentageForRefundBlngGrp(this,\"autoRefund";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\")\' onkeypress=\'return allowValidNumber(this,event,noofdecimal.value)\' size=\'2\' maxlength=\'4\'  >\n";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'   ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\t   ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" name=\'autoRefund";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" onClick=\'chkBlngGrpAutoRefund(this,\"refundAmt";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\"/>\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'    name=\'factor_appl";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' id=\'factor_appl";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'\t ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" onClick=\'blngGrpFactorAppl(this,\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"/>\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'radio\' name=\'closePkg\' id=\'closePkg\'  ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =" onClick=\"blngGrpAssignClosePkgVal(this,\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\')\"/>\n\t\t\t<input type=\'hidden\' name=\'closePkg";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' id=\'closePkg";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" />\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'80\'>\n\t\t\t<a name=\'service_limit_dtls";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' href=\'#\' onClick=\'blngGrpServiceLimitDtls(\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\")\' >";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</a>\n\t\t</td>\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'><input type=\'checkbox\'   ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\tname=\'split_reqd";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' id=\'split_reqd";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =" value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =" onclick=\"checkSplitReqd(this);\" ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="></td>\n\t\t<td class=\'fields\'  nowrap WIDTH=\'50\'>\n\t\t\t<input type=\'checkbox\'  name=\'deleteService";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' id=\'deleteService";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'\t  ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" onClick=\'chkBlngGrpDeleteService(this,\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\")\' value=\"N\"/>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t<select name=\'type0\' id=\'type0\' onChange=\'onBlngGrpServiceTypeChange(this,\"0\")\'  ";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 =">\n\t\t\t\t<option value=\'S\'  >";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</option>\n\t\t\t</select>\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 =">\n\t\t\t\t<option value=\'G\' >";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</option>\n\t\t\t\t<option value=\'C\' >";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</option>\n\t\t\t\t<option value=\'S\' >";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</option>\n\t<!-- Modified by Muthu against KDAH-SCF-0057 on 27-4-12 -->\n\t\t\t\t<option value=\'P\' >";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'hidden\' name=\'service_code0\' id=\'service_code0\' value=\'\'>\n\t\t\t<input type=\'text\' name = \'service_desc0\' size=\'10\' maxlength=\'10\'  ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 =" onBlur=\"before_blngGrpServiceLookUp(this,service_code0,type0,\'0\')\" value=\"\">\n\t\t\t<INPUT type=\'hidden\' name=\'service_desc_temp0\' id=\'service_desc_temp0\' value=\'\'>\n\t\t\t<input type=\'button\' name=\'service_button0\' id=\'service_button0\' class=\'button\' value=\'?\'\t ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 =" onclick=\"blngGrpServiceLookUp(service_desc0,service_code0,type0,\'0\')\">\n\t\t\t<input type=\'hidden\' name=\'oldSrvKey0\' id=\'oldSrvKey0\' value=\'\'>\n\t\t</td>\n\t\t\t\t\t\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'hidden\' name=\'catalog_code0\' id=\'catalog_code0\' value=\'\'>\n\t\t\t<input type=\'text\' name = \'catalog_desc0\'  ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 =" size=\'10\' maxlength=\'10\'\t  ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" onBlur=\"before_blngGrpCatalogLookUp(this,catalog_code0,service_code0,\'0\')\" value=\'\'>\n\t\t\t<INPUT type=\'hidden\' name=\'catalog_desc_temp0\' id=\'catalog_desc_temp0\' value=\'\'>\n\t\t\t<input type=\'button\' name=\'catalog_button0\' id=\'catalog_button0\'  ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="  class=\'button\' value=\'?\'\t  ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 =" onclick=\"blngGrpCatalogLookUp(catalog_desc0,catalog_code0,service_code0,\'0\')\">\n\t\t</td>\n\t\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t<select name=\'ind0\' id=\'ind0\' onChange=\'onBlngGrpIndChange(this,\"0\")\'  ";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 =">\n\t\t\t\t<option value=\'S\' >";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</option>\n\t\t\t\t<option value=\'R\'  >";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="</option>\n\t\t\t\t<option value=\'P\'  >";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\t\n\t\t\t<select name=\'ind0\' id=\'ind0\' onChange=\'onBlngGrpIndChange(this,\"0\")\'  ";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</option>\n\t\t\t\t<option value=\'R\' >";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</option>\n\t\t\t\t<option value=\'U\' >";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="</option>\n\t\t\t\t<option value=\'X\'  ></option>\n\t\t\t</select>\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t</td>\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\' name=\'factorOrRate0\' id=\'factorOrRate0\' size=\'12\' ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 =" maxlength=\"13\"  onBlur=\'checkForNegetiveNumber(this,\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\")\'; value=\"\" />\n\t\t</td>\n\t\t\t\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\'    name=\'qty_limit0\' id=\'qty_limit0\'   size=\'8\'\t  ";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =" onBlur=\'chkBlngGrpQtyLimit(this,\"0\");\' onkeypress=\'return allowValidNumber(this,event,noofdecimal.value)\'; value=\"\" />\n\t\t</td>\n\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<select name=\'amt_limit_ind0\' id=\'amt_limit_ind0\' onChange=\'validateBlngGrpInd(this,\"0\");changeSplitReqd(this,\"amt_limit\",\"0\",\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\",dailyLmtIndicator0)\'  ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</option>\n\t\t\t</select>\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\' name=\'perAmt_limit0\' id=\'perAmt_limit0\' size=\'8\' maxlength=\'13\'   ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =" onBlur=\'blngGrpValidForAmtPerUnltd(document.forms[0].amt_limit_ind0,this,\"0\",\"\",\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\")\'; value=\"\"/>\n\t\t</td>\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<input type=\'text\' name=\'roundTo0\' id=\'roundTo0\' size=\'6\' maxlength=\"3\"   ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =" value=\"\"  onkeypress=\" return (allowValidNumber(this,event,noofdecimal.value));\"  />\n\t\t</td>\n\n\t\t<td  class=\'fields\' nowrap WIDTH=\'\'>\n\t\t\t<select name=\'roundInd0\' id=\'roundInd0\'    onChange=\"\"   ";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t<td class=\'fields\' nowrap WIDTH=\'75\'>\n\t\t\t\t<input type=\'checkbox\'   ";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\tname=\'includeHomeMedication0\' id=\'includeHomeMedication0\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="onclick=\"checkInclHomeMedi(this);\">\n\t\t\t\t<input type=\'hidden\' name=\'enableDisParam0\' id=\'enableDisParam0\' id=\'enableDisParam0\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t<td class=\'fields\' nowrap WIDTH=\'\' style=\"visibility: hidden;\">\n\t\t\t\t<input type=\'hidden\' \t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 =" name=\'includeHomeMedication0\' id=\'includeHomeMedication0\' value=\'Y\' >\n\t\t\t\t<input type=\'hidden\' name=\'enableDisParam0\' id=\'enableDisParam0\' id=\'enableDisParam0\' value=\"Y\"> </td>\n\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t<td class=\'fields\' WIDTH=\'80\' nowrap >\n\t\t\t\t<select name=\'dailyLmtIndicator0\' id=\'dailyLmtIndicator0\' id=\'dailyLmtIndicator0\' ";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 =" onchange=\'dailyLmtIndicatorOnChange(this,0,document.blng_grp_rate_based_dtl)\' >\n\t\t\t\t\t<option value=\"*\">";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t\t\t<option value=\"G\">";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t\t\t\t<option value=\"I\">";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t\t\t</select>\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtChkBx0\' id = \'dailyLmtChkBx0\' value = \'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\' />\n\t\t\t\t<!-- <input type=\'hidden\' name = \'dailyLmtGrossNetList0\' id=\'dailyLmtGrossNetList0\' value = \'\' /> -->\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t\t\t<input type=\'text\' name = \'dailyLmtAmt0\' id = \'dailyLmtAmt0\' size=\'8\' maxlength=\'13\' onBlur=\'return checkForNegetiveNumber(this,\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 =" \n\t\t\t\t\t\tvalue=\'\' readOnly />\n\t\t\t\t<select name=\'dailyLmtGrossNetList0\' id=\'dailyLmtGrossNetList0\' id=\'dailyLmtGrossNetList0\' ";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</option>\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap >\n\t\t\t\t<input type=\'text\' name = \'dailyLmtQty0\' id = \'dailyLmtQty0\' size=\'8\' maxlength=\'3\' onBlur=\'return checkForNegetiveNumber(this,0,\"BL8538\");\' \n\t\t\t\t\t\tonkeypress=\'return allowValidNumber(this,event,10,0);\' ";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 =" \n\t\t\t\t\t\tvalue=\'\' readOnly />\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtChkBx0\' id = \'dailyLmtChkBx0\' value = \'N\' />\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtIndicator0\' id = \'dailyLmtIndicator0\' value = \'\' />\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtAmt0\' id = \'dailyLmtAmt0\' value = \'\' />\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtGrossNetList0\' id=\'dailyLmtGrossNetList0\' value = \'\' />\n\t\t\t</td>\n\t\t\t<td class=\'fields\' WIDTH=\'\' nowrap  Display:none >\n\t\t\t\t<input type=\'hidden\' name = \'dailyLmtQty0\' id = \'dailyLmtQty0\' value = \'\' />\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =" name=\'replace0\'  ";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =" onClick=\'chkBlngGrpReplace(this,\"0\")\' value=\"\"/>\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_code0\" id=\"replaceSrv_code0\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_desc0\" id=\"replaceSrv_desc0\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_cat_code0\" id=\"replaceSrv_cat_code0\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"replaceSrv_cat_desc0\" id=\"replaceSrv_cat_desc0\" value=\"\">\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'   ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 =" name=\'refund0\'  ";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 =" onClick=\'chkBlngGrpRefund(this,\"0\")\' value=\"\"/>\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'  ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =" name=\'autoRefund0\'  onClick=\'chkBlngGrpAutoRefund(this,\"refundAmt0\")\' value=\"\"/>\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'checkbox\'    name=\'factor_appl0\' id=\'factor_appl0\' \t  ";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 =" onClick=\'blngGrpFactorAppl(this,\"0\")\' value=\"\"/>\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'60\'>\n\t\t\t<input type=\'radio\' name=\'closePkg\' id=\'closePkg\'  ";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =" onClick=\"blngGrpAssignClosePkgVal(this,\'0\')\"/>\n\t\t\t<input type=\'hidden\' name=\'closePkg0\' id=\'closePkg0\' value=\"\" />\n\t\t</td>\n\n\t\t<td class=\'fields\' nowrap WIDTH=\'80\'>\n\t\t\t<a name=\'service_limit_dtls0\' href=\'#\' onClick=\'blngGrpServiceLimitDtls(\"0\")\' >";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\tname=\'split_reqd0\' id=\'split_reqd0\' ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =" ></td>\n\t\t<td class=\'fields\' nowrap WIDTH=\'50\'>\n\t\t\t<input type=\'checkbox\'  name=\'deleteService0\' id=\'deleteService0\'\t   ";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 =" onClick=\'chkBlngGrpDeleteService(this,\"0\")\' value=\"N\"/>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n</table>\n<INPUT TYPE=\"hidden\" name=\'packageCode\' id=\'packageCode\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n<INPUT TYPE=\"hidden\" name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<INPUT TYPE=\"hidden\" name=\'copyFrm_pkgCode\' id=\'copyFrm_pkgCode\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n<input type=\"hidden\" name=\"order_associated\" id=\"order_associated\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\t\n<input type=\"hidden\" name=\"acrossEncounters\" id=\"acrossEncounters\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\t\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\' value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" />\n<input type=\'hidden\' name=\'fromDateTemp\' id=\'fromDateTemp\' value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" />\n<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" >\n<input type=\'hidden\' name=\'blng_grp_code\' id=\'blng_grp_code\' value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" >\n<input type=\'hidden\' name=\'blng_grp_desc\' id=\'blng_grp_desc\' value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" >\n<input type=\'hidden\' name=\'parent_index\' id=\'parent_index\' value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" />\n<input type=\'hidden\' name=\'authorized\' id=\'authorized\' value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" />\n<input type=\'hidden\' name=\'pkgApprovedYN\' id=\'pkgApprovedYN\' value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\" />\n<input type=\'hidden\' name=\'blngGrpChgBasedRcdSize\' id=\'blngGrpChgBasedRcdSize\' value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'/> <!-- Added By Vijay For MMS-SCF-DM-0357 -->\n<input type=\'hidden\' name=\'siteId\' id=\'siteId\' id =\'siteId\' value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\' />\n<input type=\'hidden\' name=\'dailyLimitSiteSpec\' id=\'dailyLimitSiteSpec\'  id=\'dailyLimitSiteSpec\' value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\' ><!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->\n<input type=\'hidden\' name=\'modifyStatus\' id=\'modifyStatus\'  id=\'modifyStatus\' value=\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\' ><!-- Added V190409-Aravindh/MMS-DM-CRF-0129 -->\n<input type=\'hidden\' name=\'pkgServLimit\' id=\'pkgServLimit\'  id=\'pkgServLimit\' value=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n<input type=\'hidden\' name=\'dailyPkgLmt\' id=\'dailyPkgLmt\'  id=\'dailyPkgLmt\' value=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n<input type=\'hidden\' name=\'dailyLmtChkYN\' id=\'dailyLmtChkYN\'  id=\'dailyLmtChkYN\' value=\'";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n<input type=\'hidden\' name=\'amtFldDisabled\' id=\'amtFldDisabled\'  id=\'amtFldDisabled\' value=\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n<input type=\'hidden\' name=\'qtyFldDisabled\' id=\'qtyFldDisabled\'  id=\'qtyFldDisabled\' value=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> \n<input type=\'hidden\' name=\'indicatorFldDisabled\' id=\'indicatorFldDisabled\'  id=\'indicatorFldDisabled\' value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 -->\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\"> <!--V211130--> \n</form>\n<script>\n\talignHeading();initializeBlngGrpRateForm();updateCurrentForm(\"BLNG_GRP_RATE_BASED\",\"parent.frames[4].frames[1].document.forms[0]\",\"parent.frames[4].frames[2].document.blng_grp_srvLimit_rate_based_dtl\",\"parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader\",";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 =");\n</script>\n</body>\n";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\n</html>\n\n";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );
	
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

	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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

 /*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
*/

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 
	System.out.println("siteSpecf pkgdefblnggrpratebased" + ss);
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	Connection con = null;
	boolean dailyLimitSiteSpec = false;
	try {
		con = ConnectionManager.getConnection(request);
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
	} catch(Exception ex) {
		System.err.println("Error in PkgDefBlngGrpRateBased.jsp: "+ex);
		ex.printStackTrace();
	}
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


	String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
	String fromDateTemp = "";
	String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String locale			= (String)session.getAttribute("LOCALE");
	String		splitReqd = "Y";	//Split reqd
	String		includeHomeMedication = "N";	
	String enableDisParam="N";
	String order_associated=request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated");
	String acrossEncounters=request.getParameter("acrossEncounters") == null ? "N" : request.getParameter("acrossEncounters");

	String disabled="disabled";
	int totalRecords=1;
	
	String ordCatDisabled="disabled";
	if(order_associated.equals("Y"))
	{	
		ordCatDisabled="";
	}
	
	String packageCode		=	"" ;
	String copyFrm_pkgCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
	String blng_grp_code		=	request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;
	String blng_grp_desc		=	request.getParameter("blng_grp_desc") == null ? "" :request.getParameter("blng_grp_desc") ;	
	String parent_index		=	request.getParameter("parent_index") == null ? "" :request.getParameter("parent_index") ;
	
	String bean_id		= "bl_PkgDefBlngGrpBean" ;
	String bean_name	= "eBL.PkgDefBlngGrpBean";
	PkgDefBlngGrpBean bean			= (PkgDefBlngGrpBean)getBeanObject( bean_id, bean_name, request ) ;

	String		type			="";
	String 		service_code	="";
	String 	    service_desc	="";
	String 		catalog_code	="";
	String 		catalog_desc	="";
	String 		ind				="";
	String 		factorOrRate	="";
	String 		qty_limit		="";
	String 		amt_limit_ind	="";
	String 		amt_limit		="";	
	//String 		unlimited			="N";
	String 		replace			="N";
	String 		replaceSrv_code	="";
	String 		replaceSrv_desc	="";
	String 		replaceSrv_cat_code	="";
	String 		replaceSrv_cat_desc	="";
	String 		refund			="N";
	String		autoRefund		= "N";
	String 		refundAmt		="";
	String 		factor_appl		="";
	String 	    roundTo	  = "";
	String      roundInd  = "";
	String      closePkg = "N";
	String     	closePkgVal = "N";
	String      closePkgStat = "disabled";
	String      uSelect = "";
	String      dSelect = "";
	String		noofdecimal=bean.getNoOfDecimal();
	String 		blngGrpChgBasedRcdSize="";  // Added By Vijay For MMS-SCF-0357
	String 		SiteID="";
	String 		dailyLmtChkYN = "N";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "", qtyFldDisabled = "", indicatorFldDisabled = "";//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	String 		facilityId = (String) session.getValue( "facility_id" ) ;//Added V190625-Aravindh/MMS-DM-CRF-0129.1

	ArrayList fromDateList = new ArrayList();
	ArrayList fromDateFoundList = new ArrayList();

	bean.setModifyBlngGrpRateSrv("Y");	
	System.err.println("Query String:"+request.getQueryString());
	HashMap blng_grp_rate_srv		= new HashMap();		
	ArrayList blng_grp_rate_srv_list	     =	new ArrayList();
	blng_grp_rate_srv	=  (HashMap)bean.getBlngGrpRateSrv();
	blngGrpChgBasedRcdSize=Integer.toString(bean.getBlngGrpChargeSrv().size()); //Added By Vijay For MMS-SCF-0357
	fromDateTemp = fromDate;
	if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0)
	{
		int i = 0;
		int j = 0;
		if(blng_grp_rate_srv.containsKey(blng_grp_code.trim()+"~~"+fromDateTemp.trim()))
		{
			blng_grp_rate_srv_list=(ArrayList)blng_grp_rate_srv.get(blng_grp_code.trim()+"~~"+fromDateTemp.trim());
		}
		else
		{
			StringTokenizer st = new StringTokenizer(fromDateVals,"|");
			while(st.hasMoreElements())
			{	
				String strTempDate = st.nextToken();

				if(blng_grp_rate_srv.containsKey(blng_grp_code.trim()+"~~"+strTempDate.trim()))
				{
					fromDateFoundList.add(strTempDate);
				}
				else
				{
					fromDateFoundList.add("");
				}
				if(fromDate.equals(strTempDate))
				{
					j=i;
				}
				i++;
			}

			int k=j;
			for(int l=0;l<j;l++)
			{
				k=k-1;
				if(!fromDateFoundList.get(k).equals(""))
				{
					fromDateTemp = (String)fromDateFoundList.get(k);
					break;
				}					
			}
			blng_grp_rate_srv_list=(ArrayList)blng_grp_rate_srv.get(blng_grp_code.trim()+"~~"+fromDateTemp.trim());
		}
	}
	if(blng_grp_rate_srv_list!=null &&  blng_grp_rate_srv_list.size()>0)
	{
		totalRecords=blng_grp_rate_srv_list.size();	
		disabled="";
	}

	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";

            _bw.write(_wl_block10Bytes, _wl_block10);

	/* Added V190625-Aravindh/MMS-DM-CRF-0129.1/Starts */
	String blParametersqry = "SELECT NVL(PKG_SERV_LMT_BY,'*') PKG_SERV_LMT_BY, NVL(DAILY_PKG_LMT_YN,'N') DAILY_PKG_LMT_YN, NVL(DAILY_PKG_LMT_BY,'*') DAILY_PKG_LMT_BY FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facilityId+"'";
	PreparedStatement pstmt = con.prepareStatement(blParametersqry);
	ResultSet rst = pstmt.executeQuery();
	while(rst.next()) {
		pkgServLimit = rst.getString("PKG_SERV_LMT_BY");
		dailyLmtChkYN = rst.getString("DAILY_PKG_LMT_YN");
		dailyPkgLmt = rst.getString("DAILY_PKG_LMT_BY");
	}
	
	pstmt.close();
	rst.close();
	
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
	String[] 	record;
	if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0)
	{
	for(int i=0;i<totalRecords;i++)
	{
		System.out.println("for looppppppp ** blng_grp_rate_srv_list ");
		//record=new String[25];//Split Reqd
		/* Commented V190320-Aravindh/MMS-DM-CRF-0129/Above line, added below line */
		record=new String[30];//Modified V190702-Aravindh/MMS-DM-CRF-0129.1/String[28] -> String[30]
		record=(String[])(blng_grp_rate_srv_list.get(i));
			
		type		= record[0];
		service_code		= record[1];
		service_desc	=record[2];
		catalog_code		=record[3];
		catalog_desc			= record[4];
		ind		= record[5];
		factorOrRate		= record[6];
		qty_limit		=record[7];
		amt_limit_ind	=record[8];
		amt_limit		= record[9];
		replace		= record[10];
		if(replace==null || replace.equals("") || replace.equals("null"))
			replace="N";
		replaceSrv_code= record[11];
		replaceSrv_desc		= record[12];
		replaceSrv_cat_code		=record[13];
		replaceSrv_cat_desc	= record[14];
		refund		=record[15];
		if(refund==null || refund.equals("") || refund.equals("null"))
			refund="N";
		refundAmt		= record[16];
		if(refundAmt==null || refundAmt.equals("") || refundAmt.equals("null"))
			refundAmt="";
		autoRefund		= record[17];
		factor_appl		= record[18];	
		roundTo			= record[19];
		roundInd		= record[20];
		closePkg		=record[21];
		splitReqd		= record[22];
		includeHomeMedication		= record[23];
		enableDisParam		= record[24];
		/* Commented V190819-Aravindh/MMS-DM-CRF-0129.1/Below line */
		//dailyLmtChkYN = record[25];//Added V190320-Aravindh/MMS-DM-CRF-0129
		dailyLmtAmt = record[26];//Added V190320-Aravindh/MMS-DM-CRF-0129
		dailyLmtGrossNet = record[27];//Added V190320-Aravindh/MMS-DM-CRF-0129
		dailyLmtInd = record[28];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		if("".equals(dailyLmtInd)){
			dailyLmtInd = "*";
		}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		dailyLmtQty = record[29];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		
			//System.out.println("@@ amt_limit_ind="+amt_limit_ind);
		uSelect = roundInd.equals("U")? "selected"	 :"";
		dSelect = roundInd.equals("D")? "selected"	 :"";
		closePkgStat = type.equals("S")?"":"disabled";
		closePkgVal = closePkg.equals("Y") ? "on" :"off";

            _bw.write(_wl_block11Bytes, _wl_block11);

		if(order_associated.equals("Y"))
		{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(type.equals("S")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		else
		{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(type.equals("G")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(type.equals("C")?"selected":""));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(type.equals("S")?"selected":""));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(type.equals("P")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

		}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((blng_grp_code+"~~"+fromDate+"~~"+service_code)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ordCatDisabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ordCatDisabled));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);

		if(type.equals("G") || type.equals("C"))
		{ 

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ind.equals("S")?"selected":""));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ind.equals("R")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ind.equals("P")?"selected":""));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		else
		{

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ind.equals("S")?"selected":""));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ind.equals("R")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ind.equals("U")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ind.equals("P")?"selected":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(ind.equals("X")?"selected":""));
            _bw.write(_wl_block68Bytes, _wl_block68);
		}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(factorOrRate));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(qty_limit));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dailyLimitSiteSpec));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((amt_limit_ind.equals("")?"selected":"")));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((amt_limit_ind.equals("A")?"selected":"")));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((amt_limit_ind.equals("P")?"selected":"")));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((amt_limit_ind.equals("U")?"selected":"")));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(((amt_limit_ind.equals("")||amt_limit_ind.equals("U"))?" disabled":"")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(amt_limit));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(roundTo));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(uSelect));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(dSelect));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
if(ss){
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(includeHomeMedication ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf("Y".equals(includeHomeMedication)?" checked ":""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("Y".equals(enableDisParam)?"":"disabled" ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(enableDisParam));
            _bw.write(_wl_block115Bytes, _wl_block115);
}else{
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
} 
            _bw.write(_wl_block120Bytes, _wl_block120);
if(dailyLimitSiteSpec) { 
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
 if("G".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) { 
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf("G".equals(dailyLmtInd)?" selected ":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
 } if("I".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) {
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf("I".equals(dailyLmtInd)?" selected ":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(dailyLmtChkYN));
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
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(dailyLmtAmt ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" readOnly ":""));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" disabled ":""));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf("G".equals(dailyLmtGrossNet)?" selected ":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf("N".equals(dailyLmtGrossNet)?" selected ":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(dailyLmtQty ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" readOnly ":""));
            _bw.write(_wl_block145Bytes, _wl_block145);
 } else { 
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
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
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(replace.equals("Y")?"checked ":""));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(replace));
            _bw.write(_wl_block157Bytes, _wl_block157);

		if(replace.equals("Y"))
		{

            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(replaceSrv_code));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(replaceSrv_desc));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(replaceSrv_cat_code));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(replaceSrv_cat_desc));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(refund.equals("Y")?"checked":""));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(refund));
            _bw.write(_wl_block157Bytes, _wl_block157);
	
		if(refund.equals("Y"))
		{

            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(i));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(refundAmt));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);

		}

            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(autoRefund.equals("Y")?"checked":""));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(autoRefund));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(factor_appl.equals("Y")?"checked":""));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(factor_appl));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(closePkg.equals("Y")?" checked ":""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(closePkgStat));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(closePkg));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf("U".equals(amt_limit_ind)?" disabled ":"" ));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(splitReqd ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf("Y".equals(splitReqd)?" checked ":""));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf( !"*".equals(dailyLmtInd)?" disabled ":"" ));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(i));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(i));
            _bw.write(_wl_block203Bytes, _wl_block203);

	}
	}
	else
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

		if(order_associated.equals("Y"))
		{

            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);

		}
		else
		{

            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

		}

            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(ordCatDisabled));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(ordCatDisabled));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block217Bytes, _wl_block217);

		if(type.equals("G") || type.equals("C"))
		{ 

            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);
		
		}
		else
		{

            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);

		}

            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(dailyLimitSiteSpec));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((amt_limit_ind.equals("")?"selected":"")));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((amt_limit_ind.equals("A")?"selected":"")));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((amt_limit_ind.equals("P")?"selected":"")));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((amt_limit_ind.equals("U")?"selected":"")));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(((amt_limit_ind.equals("")||amt_limit_ind.equals("U"))?" disabled":"")));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(uSelect));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(dSelect));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
if(ss){
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(includeHomeMedication ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf("Y".equals(includeHomeMedication)?" checked ":""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("Y".equals(enableDisParam)?"":"disabled" ));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(enableDisParam));
            _bw.write(_wl_block115Bytes, _wl_block115);
 } else{
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block240Bytes, _wl_block240);
} 
            _bw.write(_wl_block241Bytes, _wl_block241);
if(dailyLimitSiteSpec) { 
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block243Bytes, _wl_block243);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
 if("G".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) { 
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
 } if("I".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) {
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(dailyLmtChkYN));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("*".equals(dailyLmtInd)?" disabled ":""));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf("G".equals(dailyLmtGrossNet)?" selected ":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf("N".equals(dailyLmtGrossNet)?" selected ":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block250Bytes, _wl_block250);
 } else { 
            _bw.write(_wl_block251Bytes, _wl_block251);
 } 
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(closePkgStat));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf("U".equals(amt_limit_ind)?" disabled ":"" ));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(splitReqd ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf("Y".equals(splitReqd)?" checked ":""));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf( !"*".equals(dailyLmtInd)?" disabled ":"" ));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block261Bytes, _wl_block261);
	
	}

            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(packageCode));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(copyFrm_pkgCode));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(order_associated));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(acrossEncounters));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(fromDateTemp));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(blng_grp_code));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(parent_index));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(authorized));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(pkgApprovedYN));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf( blngGrpChgBasedRcdSize));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(ss ));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(dailyLimitSiteSpec));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(pkgServLimit));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(dailyPkgLmt));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(dailyLmtChkYN));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(amtFldDisabled));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(qtyFldDisabled));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(indicatorFldDisabled));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block291Bytes, _wl_block291);
putObjectInBean(bean_id,bean,request);
            _bw.write(_wl_block292Bytes, _wl_block292);
            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageGrouping.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Standard.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AsPerRule.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Standard.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AsPerRule.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UserDefined.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNLIMITED.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Up.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOWN.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Dtls.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Dtls.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageGrouping.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Standard.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AsPerRule.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Standard.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AsPerRule.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UserDefined.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNLIMITED.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Up.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOWN.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PIPD.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Dtls.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
