package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;

public final class __blviewtrmtpkghdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLViewTrmtPkgHdr.jsp", 1744006387765L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n<script>\n\tfunction call_pkg_dtl(price_class_code, pack_seq_no,row_id)\n\t{\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar encounter_date = document.forms[0].encounter_date.value;\n\t\n\t\tvar pkg_rw_disp = document.getElementById(\"pkg_rw_\"+row_id);\n//\t\tvar pkg_exp_comp_disp = eval(\"document.getElementById(\"pkg_exp_comp\")\"+row_id);\t\t\n\t\tvar pkg_exp_comp_disp = document.getElementById(\"pkg_exp_comp_\"+row_id);\t\t\n\t\n\t\tvar pkg_dtl_show_hide = eval(\"document.forms[0].pkg_dtl_show_hide_\"+row_id);\n\n\t\tif(pkg_dtl_show_hide.value == \"H\")\n\t\t\tpkg_dtl_show_hide.value = \"S\";\n\t\telse\n\t\t\tpkg_dtl_show_hide.value = \"H\";\n\n\t\tif(pkg_dtl_show_hide.value == \"S\")\n\t\t{\n\t\t\tpkg_rw_disp.style.display=\"inline\";\n\t\t\tpkg_exp_comp_disp.src=\"../../eCommon/images/minusbottom.gif\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tpkg_rw_disp.style.display=\"none\";\n\t\t\tpkg_exp_comp_disp.src=\"../../eCommon/images/plusbottom.gif\";\n\t\t}\n\t\t\n//\t\tparent.frames[1].location.href = \"../../eBL/jsp/BLViewTrmtPkgDtl.jsp?facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&encounter_date=\"+encounter_date+\"&price_class_code=\"+price_class_code+\"&pack_seq_no=\"+pack_seq_no;\n\n\t}\n\n\tfunction ret_blng_grp(row_id)\n\t{\n\t\tvar cust_grp_code = \"\", cust_code = \"\";\n\n\t\tvar total_records = document.forms[0].total_records.value;\n\n\t\tvar blng_grp_id = eval(\"document.forms[0].blng_grp_id_\"+row_id);\n\t\tblng_grp_id = blng_grp_id.value;\n\n\t\tvar blng_grp_desc = document.getElementById(\"blng_grp_desc_\"+row_id);\n\t\tblng_grp_desc = blng_grp_desc.innerText;\n\n\t\tvar blng_grp_short_desc = eval(\"document.forms[0].blng_grp_short_desc_\"+row_id);\n\t\tblng_grp_short_desc = blng_grp_short_desc.value;\t\t\n\n\t\tfor(var i=0;i<total_records;i++)\n\t\t{\n\t\t\tvar blng_grp_id_temp = eval(\"document.forms[0].blng_grp_id_\"+i);\n\t\t\tvar cust_grp_code_temp = eval(\"document.forms[0].cust_grp_code_\"+i);\n\t\t\tvar cust_code_temp = eval(\"document.forms[0].cust_code_\"+i);\n\n\t\t\tif(blng_grp_id_temp.value == blng_grp_id)\n\t\t\t{\n\t\t\t\tif(i != (total_records-1)) \n\t\t\t\t\tcust_grp_code = cust_grp_code+cust_grp_code_temp.value+\"@@\";\n\t\t\t\telse\n\t\t\t\t\tcust_grp_code = cust_grp_code+cust_grp_code_temp.value;\n\t\t\t\t\n\t\t\t\tif(i != (total_records-1)) \n\t\t\t\t\tcust_code = cust_code+cust_code_temp.value+\"@@\";\n\t\t\t\telse\n\t\t\t\t\tcust_code = cust_code+cust_code_temp.value;\n\t\t\t}\n\t\t}\n\t\t\t\n\t\tvar retVal = blng_grp_id+\"||\"+blng_grp_short_desc+\"||\"+cust_grp_code+\"||\"+cust_code+\"||\";\n\n\t\tparent.window.returnValue = retVal;\n\t\tparent.window.close();\n\t}\n/*\n\tfunction call_1st_pkg_dtl()\n\t{\n\t\tvar total_records = document.forms[0].total_records.value;\n\n\t\tif(total_records >0)\n\t\t{\n\t\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\tvar encounter_date = document.forms[0].encounter_date.value;\n\n\t\t\tvar price_class_code = eval(\"document.forms[0].price_class_code_\"+0);\n\t\t\tprice_class_code = price_class_code.value;\n\n\t\t\tvar pack_seq_no = eval(\"document.forms[0].pack_seq_no_\"+0);\n\t\t\tpack_seq_no = pack_seq_no.value;\n\n\t\t\tparent.frames[1].location.href = \"../../eBL/jsp/BLViewTrmtPkgDtl.jsp?facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&encounter_date=\"+encounter_date+\"&price_class_code=\"+price_class_code+\"&pack_seq_no=\"+pack_seq_no;\n\t\t}\n\n\t}\n*/\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"package_dtls\" id=\"package_dtls\" method=post action=\"\">\n<DIV id=\'tbl-container\' style=\'width: 1020px;height: 550px;overflow: auto;\' >\n\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\' border=1>\n<thead>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'8\' align=\'left\' style=\"position:relative;top: expression(document.getElementById(\'tbl-container\').scrollTop-2);z-index: 20\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'100%\' colspan=\'8\'></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\'15%\' style=\"position:relative;top: expression(document.getElementById(\'tbl-container\').scrollTop-2);z-index: 20\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\n\t\t<td class=\'COLUMNHEADER\' width=\'15%\' style=\"position:relative;top: expression(document.getElementById(\'tbl-container\').scrollTop-2);z-index: 20\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" / ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\n\t\t<td class=\'COLUMNHEADER\' width=\'8%\' style=\"position:relative;top: expression(document.getElementById(\'tbl-container\').scrollTop-2);z-index: 20\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\n\t\t<td class=\'COLUMNHEADER\' width=\'13%\' style=\"position:relative;top: expression(document.getElementById(\'tbl-container\').scrollTop-2);z-index: 20\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t</tr>\n</thead>\n<tbody>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t<tr>\n\t\t<td class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" width=\'15%\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<A href=\"javascript:ret_blng_grp(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\"><B><div id=\"blng_grp_desc_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div></B></A>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<B><div id=\"blng_grp_desc_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div></B>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</td>\n\t\t<td class=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<A href=\"javascript:call_pkg_dtl(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\"><img name=\'pkg_exp_comp_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' src=\"../../eCommon/images/minusbottom.gif\"></img></A>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' src=\"../../eCommon/images/plusbottom.gif\"></img></A>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<div id=\"pkg_desc_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div></B>\n\t\t</td>\n\t\t<td class=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" width=\'15%\'><div id=\"cust_grp_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t&nbsp;\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</div></td>\n\t\t\n\t\t<td class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\'8%\'><div id=\"eff_date_from_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</div></td>\n\t\t<td class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\'8%\'><div id=\"eff_date_to_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" width=\'13%\'><div id=\"package_amt_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" style=\'text-align:right\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" width=\'13%\'><div id=\"deposit_amt_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" width=\'13%\'><div id=\"availed_amt_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</div></td>\n\t\t<input type=\"hidden\" name=\"pack_seq_no_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"pack_seq_no_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name=\"price_class_code_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"price_class_code_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"blng_grp_id_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"blng_grp_id_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\" name=\"blng_grp_short_desc_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"blng_grp_short_desc_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"hidden\" name=\"cust_grp_code_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"cust_grp_code_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\" name=\"cust_code_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"cust_code_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<input type=\"hidden\" name=\"pkg_dtl_show_hide_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"pkg_dtl_show_hide_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" value=\"S\">\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\"H\">\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t</tr>\n<tr>\n\n<td colspan=\'8\' >\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n<div id=\'pkg_rw_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' style=\'display:inline\'>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' style=\'display:none\'>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n<DIV id=\'tbl-comp-container_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' style=\'width: 1000px;height: 100px;overflow: auto;\' >\n\t<table cellpadding=3 cellspacing=0  width=\"95%\" align=\'right\' border=1>\n<thead>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'9\' align=\'left\'  style=\"position:relative;top: expression(document.getElementById(\'tbl-comp-container_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\').scrollTop-2);z-index: 20\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'100%\' colspan=\'7\'></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\'15%\' style=\"position:relative;top: expression(document.getElementById(\'tbl-comp-container_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\n\t\t<td class=\'COLUMNHEADER\' width=\'15%\' style=\"position:relative;top: expression(document.getElementById(\'tbl-comp-container_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t</tr>\n</thead>\n\n<tbody>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t<tr>\n\t\t<td class=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" width=\'32%\'><div id=\"serv_short_desc_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</div></td>\n\t\t\n\t\t<td class=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" width=\'17%\'><div id=\"serv_limit_qty_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" width=\'17%\'><div id=\"serv_availed_qty_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" width=\'17%\'><div id=\"serv_limit_amt_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" width=\'17%\'><div id=\"serv_availed_amt_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</div></td>\n\t</tr>\n\t\t\t\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n</tbody>\n</table>\n</div>\n</div>\n</td>\n</tr>\n\n\t<tr>\n\t\t<td width=\'100%\' colspan=\'6\'></td>\n\t</tr>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n</tbody>\n</table>\n</div>\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n<input type=\'hidden\' name=\'encounter_date\' id=\'encounter_date\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con = null;
	PreparedStatement pstmt= null, pstmt1= null, pstmt_pack = null, pstmt_serv=null ;
	ResultSet rs=null, rs1=null, rs_pack =null, rs_serv= null;	

	String str_pack_seq_no="", str_price_class_code="", str_pack_long_desc="", str_eff_date_from="", str_eff_date_to="", str_package_amt="", str_availed_amt="", str_deposit_amt="", str_blng_grp_short_desc = "", str_blng_grp_long_desc= "";
	String str_cust_grp_code="", str_cust_code="", str_cust_grp_desc="", str_cust_desc="";

	String str_serv_short_desc="", str_serv_limit_qty="", str_serv_availed_qty="", str_serv_limit_amt="", str_serv_availed_amt="";
	String classval="", str_cald_for_is="", str_cald_frm="", str_cald_with_bg_YN="N", str_ordr_by_blng_grp_id="";
	int i=0, j=0, noofdecimal=2, total_records=0;
	
	try
	{
		request.setCharacterEncoding("UTF-8");	
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		String locale	= (String)session.getAttribute("LOCALE");
		CurrencyFormat cf = new CurrencyFormat();
		String str_facility_id = (String)httpSession.getValue("facility_id");

//		System.out.println("Query String:"+request.getQueryString());

		String str_patient_id = request.getParameter("patient_id");
		if (str_patient_id==null) str_patient_id="";

		String str_blng_grp_id = request.getParameter("blng_grp_id");
		if (str_blng_grp_id==null) str_blng_grp_id="";

		str_cald_for_is = request.getParameter("cald_for_is");
		if (str_cald_for_is==null) str_cald_for_is="";

		str_cald_frm = request.getParameter("cald_frm");
		if (str_cald_frm==null) str_cald_frm="";

		str_cald_with_bg_YN = request.getParameter("cald_with_bg_YN");
		if (str_cald_with_bg_YN==null) str_cald_with_bg_YN="N";		

		String encounter_date = request.getParameter("encounter_date");
		if (encounter_date==null) encounter_date="";

		String str_episode_type = request.getParameter("episode_type");
		if (str_episode_type==null) str_episode_type="";

		String str_episode_id = request.getParameter("episode_id");
		if (str_episode_id==null) str_episode_id="";

		String str_visit_id = request.getParameter("visit_id");
		if (str_visit_id==null) str_visit_id="";

		String str_citizen_yn = request.getParameter("citizen_yn");
		if (str_citizen_yn==null) str_citizen_yn="";		

		String str_ext_billing_group = request.getParameter("ext_billing_group");
		if (str_ext_billing_group==null) str_ext_billing_group="";		

		String str_blnggrp = request.getParameter("blnggrp");
		if (str_blnggrp==null) str_blnggrp="";	

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);		
			}		
			rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("noofdecimal="+e.toString());
		}

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		String sql_pkg_dtl_hdr_qry="SELECT A.BLNG_GRP_ID, A.PACKAGE_SEQ_NO, A.PRICE_CLASS_CODE, B.LONG_DESC, to_char(A.EFF_DATE_FROM,'DD/MM/YYYY'), to_char(A.EFF_DATE_TO,'DD/MM/YYYY'), A.PACKAGE_AMT, A.AVAILED_AMT, A.DEPOSIT_AMT, C.SHORT_DESC, C.LONG_DESC ,A.CUST_GROUP_CODE,A.CUST_CODE FROM bl_patient_package_hdr A, BL_PRICE_CLASS_LANG_VW B, BL_BLNG_GRP_LANG_VW C WHERE A.operating_facility_id = '"+str_facility_id+"' AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"' and B.LANGUAGE_ID = C.LANGUAGE_ID and  A.PRICE_CLASS_CODE = B.PRICE_CLASS_CODE AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND A.patient_id = '"+str_patient_id+"' AND to_date('"+encounter_date+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+encounter_date+"','DD/MM/YYYY')) AND A.status = 'O'";
		
		if(str_cald_frm.equals("REG"))
		{
			sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and ( NVL(c.category,'UNRESTRICTED') IN ( DECODE('"+str_citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) ";	

			if(str_blnggrp.equals("1"))
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ref_yn,'N')='Y' and nvl(c.hcare_only_yn,'N') = 'N' and nvl(c.status,'X' )!='S' ";
			}
			else if (str_blnggrp.equals("2")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ref_yn,'N')='Y' and nvl(c.ref_valid_for_regn_yn,'N')='Y' and nvl(c.status,'X' )!='S' and nvl(c.hcare_only_yn,'N') = 'N' " ;	
			}
			else if (str_blnggrp.equals("3")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.op_yn,'N')='Y' and nvl(c.status,'X' )!='S' and  nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N' ";
			}
			else if (str_blnggrp.equals("4")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ip_yn,'N')='Y' and nvl(c.status,'X' )!='S' and nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N'";
			}
			else if (str_blnggrp.equals("5")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.status,'X' ) != 'S' and nvl(c.health_card_appl_yn,'N')= 'N' and nvl(c.hcare_only_yn,'N')='N'";
			}
			else if (str_blnggrp.equals("6")) 
			{	
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.status,'X' )!='S' and c.blng_grp_id = '" + str_ext_billing_group + "' ";
			}
			else if (str_blnggrp.equals("7")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ae_yn,'N')='Y' and nvl(c.status,'X' )!='S' and  nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N' ";
			}
			else if (str_blnggrp.equals("8"))  
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.dy_yn,'N')='Y' and nvl(c.status,'X' )!='S' and  nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N' ";
			}

			if(str_cald_with_bg_YN.equals("Y"))
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry + " AND A.BLNG_GRP_ID='"+str_blng_grp_id+"'";
			}
		}

		if(str_cald_for_is.equals("E"))
		{
			 sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry + " and A.PACKAGE_SEQ_NO in ( select PACKAGE_SEQ_NO from bl_patient_charges_folio where operating_facility_id = '"+str_facility_id+"' and patient_id = '"+str_patient_id+"' and package_trx_yn = 'Y' and (('"+str_episode_type+"' in ('I','D') and episode_id = '"+str_episode_id+"')  or ('"+str_episode_type+"' in ('E','O') and episode_id = '"+str_episode_id+"' and visit_id = '"+str_visit_id+"')))";
		}
		 sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry + " ORDER BY A.blng_grp_id,A.package_seq_no";

		
//		System.out.println("sql_pkg_dtl_hdr_qry:"+sql_pkg_dtl_hdr_qry);

		pstmt_pack = con.prepareStatement(sql_pkg_dtl_hdr_qry);
		rs_pack = pstmt_pack.executeQuery() ;

		if( rs_pack != null) 
		{
			while( rs_pack.next() )
			{  
				str_blng_grp_id  = rs_pack.getString(1);
				if(str_blng_grp_id == null) str_blng_grp_id=""; 

				str_pack_seq_no = rs_pack.getString(2);
				if(str_pack_seq_no == null) str_pack_seq_no="";

				str_price_class_code = rs_pack.getString(3);
				if(str_price_class_code == null) str_price_class_code="";

				str_pack_long_desc = rs_pack.getString(4);
				if(str_pack_long_desc == null) str_pack_long_desc="";

				str_eff_date_from = rs_pack.getString(5);
				if(str_eff_date_from == null) str_eff_date_from="";
				if(!str_eff_date_from.equals(""))
				{
					str_eff_date_from=com.ehis.util.DateUtils.convertDate(str_eff_date_from,"DMY","en",locale);
				}

				str_eff_date_to = rs_pack.getString(6);
				if(str_eff_date_to == null) str_eff_date_to="";
				if(!str_eff_date_to.equals(""))
				{
					str_eff_date_to=com.ehis.util.DateUtils.convertDate(str_eff_date_to,"DMY","en",locale);
				}

				str_package_amt = rs_pack.getString(7);
				if(str_package_amt == null) str_package_amt="0";
				str_package_amt = cf.formatCurrency(str_package_amt, noofdecimal);

				str_availed_amt = rs_pack.getString(8);
				if(str_availed_amt == null) str_availed_amt="0";
				str_availed_amt = cf.formatCurrency(str_availed_amt, noofdecimal);

				str_deposit_amt = rs_pack.getString(9);
 				if(str_deposit_amt == null) str_deposit_amt="0";
				str_deposit_amt = cf.formatCurrency(str_deposit_amt, noofdecimal);

				str_blng_grp_short_desc = rs_pack.getString(10);
 				if(str_blng_grp_short_desc == null) str_blng_grp_short_desc="";

				str_blng_grp_long_desc = rs_pack.getString(11);
 				if(str_blng_grp_long_desc == null) str_blng_grp_long_desc="";

				str_cust_grp_code=rs_pack.getString(12);
 				if(str_cust_grp_code == null) str_cust_grp_code="";

				str_cust_code=rs_pack.getString(13);
 				if(str_cust_code == null) str_cust_code="";
				
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}
				
				str_cust_grp_desc = "";
				String sql_cust_grp_desc = "select long_desc from ar_cust_group_lang_vw where cust_group_code = '"+str_cust_grp_code+"' and language_id='"+locale+"'";
				pstmt1 = con.prepareStatement(sql_cust_grp_desc);
				rs1 = pstmt1.executeQuery() ;
				
				if( rs1 != null) 
				{
					while( rs1.next() )
					{  
						str_cust_grp_desc=rs1.getString(1);
						if(str_cust_grp_desc == null) str_cust_grp_desc="";
					}
				}
				if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();
	
				str_cust_desc = "";
				String sql_cust_desc = "select long_name from ar_customer_lang_vw where cust_code = '"+str_cust_code+"' and language_id='"+locale+"'";
				pstmt1 = con.prepareStatement(sql_cust_desc);
				rs1 = pstmt1.executeQuery() ;

				if( rs1 != null) 
				{
					while( rs1.next() )
					{  
						str_cust_desc=rs1.getString(1);
						if(str_cust_desc == null) str_cust_desc="";
					}
				}
				if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block16Bytes, _wl_block16);
		
		if(!str_blng_grp_id.equals(str_ordr_by_blng_grp_id))
		{
			if(str_cald_with_bg_YN.equals("N") && str_cald_frm.equals("REG"))
			{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_blng_grp_long_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			else
			{

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_blng_grp_long_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block16Bytes, _wl_block16);

		if(i==0)
		{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_price_class_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str_pack_seq_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
		else
		{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_price_class_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str_pack_seq_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_pack_long_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);

		if(!str_cust_grp_code.equals("") && !str_cust_code.equals(""))
		{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((str_cust_grp_desc==null || str_cust_grp_desc.equals(""))?"&nbsp;":str_cust_grp_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((str_cust_desc==null || str_cust_desc.equals(""))?"&nbsp;":str_cust_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);

		}
		else
		{

            _bw.write(_wl_block34Bytes, _wl_block34);

		}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_eff_date_from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_eff_date_to));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_package_amt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_deposit_amt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_availed_amt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_pack_seq_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_price_class_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_blng_grp_short_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_cust_grp_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str_cust_code));
            _bw.write(_wl_block56Bytes, _wl_block56);

		if(i==0)
		{

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
		else
		{

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);

		}

            _bw.write(_wl_block61Bytes, _wl_block61);

		if(i==0)
		{

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);

		}
		else
		{

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);

		}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(str_pack_long_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

		String sql_pkg_dtl_qry="SELECT  DECODE(LENGTH(A.BLNG_SERV_CODE),3,(SELECT LONG_DESC FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE SERV_CLASSIFICATION_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"'),2,(SELECT LONG_DESC FROM BL_BLNG_SERV_GRP_LANG_VW WHERE SERV_GRP_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"') ,  (SELECT LONG_DESC FROM BL_BLNG_SERV_LANG_VW WHERE BLNG_SERV_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"')) SHORT_DESC ,SERV_LIMIT_QTY SERV_QTY_LIMIT, availed_qty AVAILED_QTY,SERV_LIMIT_AMT SERV_AMT_LIMIT,a.availed_amt AVAILED_AMT FROM bl_patient_package_dtl a, bl_patient_package_hdr b WHERE a.operating_facility_id = b.operating_facility_id AND a.patient_id = b.patient_id AND a.package_seq_no = b.package_seq_no AND a.blng_grp_id = b.blng_grp_id AND a.operating_facility_id = '"+str_facility_id+"' AND a.patient_id = '"+str_patient_id+"' AND A.PRICE_CLASS_CODE = '"+str_price_class_code+"' AND A.PACKAGE_SEQ_NO = '"+str_pack_seq_no+"' AND to_date('"+encounter_date+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+encounter_date+"','DD/MM/YYYY')) AND b.status = 'O'";	

		if(str_cald_for_is.equals("E"))
		{
			 sql_pkg_dtl_qry = sql_pkg_dtl_qry + " and (A.PACKAGE_SEQ_NO,A.BLNG_SERV_CODE) in ( select PACKAGE_SEQ_NO,BLNG_SERV_CODE from bl_patient_charges_folio where operating_facility_id = '"+str_facility_id+"' and patient_id = '"+str_patient_id+"' and package_trx_yn = 'Y' and (('"+str_episode_type+"' in ('I','D') and episode_id = '"+str_episode_id+"')  or ('"+str_episode_type+"' in ('E','O') and episode_id = '"+str_episode_id+"' and visit_id = '"+str_visit_id+"')))";
		}
		
//		System.out.println("sql_pkg_dtl_qry:"+sql_pkg_dtl_qry);

		pstmt_serv = con.prepareStatement(sql_pkg_dtl_qry);
		rs_serv = pstmt_serv.executeQuery() ;

		if( rs_serv != null) 
		{
			while( rs_serv.next() )
			{  
				str_serv_short_desc = rs_serv.getString(1);
				if(str_serv_short_desc == null) str_serv_short_desc="";

				str_serv_limit_qty = rs_serv.getString(2);
				if(str_serv_limit_qty == null) str_serv_limit_qty="";

				str_serv_availed_qty = rs_serv.getString(3);
				if(str_serv_availed_qty == null) str_serv_availed_qty="";

				str_serv_limit_amt = rs_serv.getString(4);
				if(str_serv_limit_amt == null) str_serv_limit_amt="";

				str_serv_availed_amt = rs_serv.getString(5);
				if(str_serv_availed_amt == null) str_serv_availed_amt="";

				if(j % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(str_serv_short_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((str_serv_limit_qty==null || str_serv_limit_qty.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_limit_qty, noofdecimal)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((str_serv_availed_qty==null || str_serv_availed_qty.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_availed_qty, noofdecimal)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((str_serv_limit_amt==null || str_serv_limit_amt.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_limit_amt, noofdecimal)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((str_serv_availed_amt==null || str_serv_availed_amt.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_availed_amt, noofdecimal)));
            _bw.write(_wl_block78Bytes, _wl_block78);
			
				j++;		
			}
		}
				if (rs_serv != null)   rs_serv.close();
				if (pstmt_serv != null) pstmt_serv.close();

            _bw.write(_wl_block79Bytes, _wl_block79);

				i++;
				str_ordr_by_blng_grp_id = str_blng_grp_id;
			}
		}
		if (rs_pack != null)   rs_pack.close();
		if (pstmt_pack != null) pstmt_pack.close();
		total_records = i;

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(str_facility_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(encounter_date));
            _bw.write(_wl_block84Bytes, _wl_block84);

	}
	catch(Exception e) 
	{ 
		System.out.println("Main Exception in BLViewTrmtPkgDtls.jsp"+e.toString());
	}
	finally 
	{
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block85Bytes, _wl_block85);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SUBS_OPEN_PACKAGE_DTL.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PKG_DESC.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveTo.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PKG_AMT.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DEPOSIT_AMT.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVAILD_AMT.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PKG_COMPONENT.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ServiceDescription.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.QTY_LMT.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVAILD_QTY.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMT_LMT.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVAILD_AMT.label", java.lang.String .class,"key"));
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
}
