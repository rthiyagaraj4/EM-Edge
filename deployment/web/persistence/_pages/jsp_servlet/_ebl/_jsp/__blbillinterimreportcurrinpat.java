package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __blbillinterimreportcurrinpat extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillInterimReportCurrInPat.jsp", 1709114417103L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<!-- Added By Rajesh V -->\n\t\t<script language=\'javascript\' src=\'../js/BLInterimBillReport.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<!-- Added By Rajesh V -->\n\t\t<style>\n\t\tthead td, thead td.locked\t{\n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\n\t\tTD.YELLOW \n\t\t{\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t</style>\n\t</HEAD> \n\n\t<script>\n\t\tfunction selected(i)\n\t\t{\t\t\t\t\n\t\t\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\t\t\n\t\t\tif(selected_row.checked==false)\n\t\t\t{\t\n\t\t\tselected_row.checked=false;\n\t\t\tdocument.resultForm.checked_row.value=\"\";\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\t\t\t\n\t\t\t\tvar total_records=document.forms[0].total_records.value;\t\t\t\t\t\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{ \n\t\t\t\t\tvar temp=eval(\"document.resultForm.selected_row\"+j);\t\t\t\t\t\n\t\t\t\t\ttemp.checked=false;\n\t\t        }\n\t\t\tselected_row.checked=true;\t\t\t\t\n\t\t\tdocument.forms[0].checked_row.value=i;\n\t\t\t}\n\t\t\tif(selected_row.checked)\n\t\t\t{\n\t\t\t  selected_row.value=\"1\";\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tselected_row.value=\"1\";\t\n\t\t\t}\n\t\t}\t\n\n\t\tfunction no_record_check()\n\t\t{\n\t\t\tvar total_records=document.forms[0].total_records.value;\n\t\t\tif(total_records==0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n//\t\t\t\thistory.go(-1);\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t//parent.frames[1].document.forms[0].compute_bed_charge_flag.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].submit_but.disabled=true;\n\n\t\t\t}\n\t\t\tparent.frames[0].document.forms[0].total_records.value=total_records;\n\t\t\t\n\t\t}\n\n\t\tfunction assign_value()\n\t\t{\n\t\t\tparent.frames[0].document.forms[0].group_by.value = document.forms[0].group_by.value;\n\t\t}\n\n\t</script>\n\t\n\t\n\t<body onLoad=\"no_record_check();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n\t<form name=\'resultForm\' id=\'resultForm\' method=\'post\' action=\'../../servlet/eBL.BLInterimBillBedChargeComputeServlet\' scrolling=no target=\'dummy_frame\'>\t\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<div>\n\t\t\t<table  cellpadding=\'3\' cellspacing=\'0\' align = \'center\' id=\'bill_interim_det\' width=\'100%\'>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" colspan=\"7\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td class=\"fields\" colspan=\"7\">\n\t\t\t\t\t<select name=\'group_by\' id=\'group_by\' value=\"\" onChange=\'assign_value();\'>\n\t\t\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\t \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td> \n\t\t\t</tr>\n\t\t\t</table> \n\t\t</div>\t\n\t\t<div>\n\t\t\t<table  cellpadding=\'3\' cellspacing=\'0\' align = \'center\' id=\'bill_interim_det\' width=\'100%\'>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"14\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\t \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</td> \n\t\t\t</tr>\n\t\t\t</table> \n\t\t</div>\n\t\t\n\t\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 100%; height: 390px;   padding:3px; margin: 0px\">\n\t\t\t<table border=\'\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t\t\t<thead>\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\n\t\t\t\t<td width=\"10%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t\t\n\t\t\t\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\n\t\t\t\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td> <!--22-09-2020-->\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t</tr>\n\t\t\t</thead>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<tbody>\n\t\t\t<!-- Added By Rajesh V -->\n\t\t\t\t<tr id=row";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onclick=\'highlightRow(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =",\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")\'>\n\t\t\t<!-- Added By Rajesh V -->\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_col1\' class=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" width=\"5%\"><INPUT TYPE=\"TEXT\" name=\'patient_id";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'patient_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' SIZE=\"10\" MAXLENGTH=\"20\" \tVALUE=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" readonly> </td>\t\t\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="_col2\' class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\"5%\" ><input type=\'text\' name=\'patient_name";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'patient_name";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\'10\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" readonly></td>\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="_col3\' class=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'episode_type";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'episode_type";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' size=\'10\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" readonly> </td>\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="_col4\' class=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'adm_no";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'adm_no";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="_col5\' class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'adm_date";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'adm_date";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="_col6\' class=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'last_bed_chr_date";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'last_bed_chr_date";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="_col7\' class=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'ward";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'ward";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" readonly> </td>\n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="_col8\' width=\"5%\" class=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="><input type=\'text\' name=\'bed_no";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'bed_no";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' size=\'8\' maxlength=\'10\' readonly value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></td>\t\t\t\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="_col9\' class=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" width=\"5%\" ><input type=\'text\' name=\'blng_grp_id";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'blng_grp_id";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' size=\'8\' maxlength=\'20\' readonly value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="_col10\' class=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" width=\"5%\" ><input type=\'text\' name=\'cust_desc";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'cust_desc";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="_col11\' class=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'policy";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'policy";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="_col12\' width=\"5%\" class=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="><input type=\'text\' readonly name=\'unbill_amt";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'unbill_amt";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' maxlength=\'30\' size=\'10\'   value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' readonly style=\'text-align:right\'></td>\n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="_col13\' width=\"5%\" class=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" ><input type=\'text\' name=\'unadjust_dep";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'unadjust_dep";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' readonly></td>\t\t\n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="_col14\' class=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" width=\"5%\"><input type=\'text\' readonly name=\'outstand_amt";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'outstand_amt";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' maxlength=\'60\' size=\'10\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' readonly style=\'text-align:right\'></td>  \n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="_col15\' class=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" width=\"5%\"><input type=\'text\' readonly name=\'total_amt";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'total_amt";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' style=\'text-align:right\'></td>  \n\n\t\t\t\t\t<input type=\'hidden\' name=\'cust_code";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' id=\'cust_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'episode_id";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' id=\'episode_id";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t\t\t\t</tr> \n ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\t\t</tbody>\n\t\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<script></script>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\t\n\t\t<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'bed_chr_date\' id=\'bed_chr_date\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' >\n\t\t<!-- Hidden Fields Added by Rajesh V -->\n\t\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'patientName\' id=\'patientName\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'admissionNo\' id=\'admissionNo\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'admissionDate\' id=\'admissionDate\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'lastBedChrgDt\' id=\'lastBedChrgDt\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'wardNo\' id=\'wardNo\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'bedNo\' id=\'bedNo\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'billingGroup\' id=\'billingGroup\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'payer\' id=\'payer\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'policy\' id=\'policy\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'unbilledAmt\' id=\'unbilledAmt\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'unAdjustAmt\' id=\'unAdjustAmt\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'outStandBillAmt\' id=\'outStandBillAmt\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'totalAmt\' id=\'totalAmt\' value = \'\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'inpatientText\' id=\'inpatientText\' value = \'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n\t\t<input type=\'hidden\' name=\'outpatientText\' id=\'outpatientText\' value = \'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t\t<input type=\'hidden\' name=\'externalText\' id=\'externalText\' value = \'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t<input type=\'hidden\' name=\'emergencyText\' id=\'emergencyText\' value = \'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t<input type=\'hidden\' name=\'daycareText\' id=\'daycareText\' value = \'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t<!-- Hidden Fields Added by Rajesh V -->\n\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t<script>parent.frames[3].location.href=\'../../eCommon/html/blank.html\';</script>\t\n\t\t<script>\n\t\t\tif(document.forms[0].sys_date.value!=\'\')\n\t\t\t{\n\t\t\t\tparent.frames[0].document.forms[0].search_but.value=getLabel(\"Common.Ason.label\",\"common_labels\")+\" \"+document.forms[0].sys_date.value;\n\t\t\t}\n\t\t</script>\n\t</form>\n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	String locale="";
	String p_facility_id="";
	//int totalRecords=0; 
	String classval="";
	int total_records=0;
	String p_from_nursing_unit_code="",p_to_nursing_unit_code="",p_from_adm_no="",p_to_adm_no="";
	String strFacilityId="",strCurWardCode="",strTotUnadjDepAmt="",strCurBedClassCode="";//strInhBillgenDate="",strCurBedClassCode="";
	String p_payer_code="";
	String p_patient_id="";
	String p_payer_type="";
	String p_pay_amt_exce="";
	String strPatientId=""; String strPatientName=""; String strPatientNameLocLang="";
	String strEpisodeType=""; String strOpenEpisodeId=""; String strAdmDateTime="";
	String strCurrRoomNum=""; String strCurrBedNum=""; String strCustCode="";
	String strUnBldAmt=""; String strOutstdAmt="";String strTotAmt="";String str_no_of_deci="",strPolicyTypeCode="",strCustDesc="",strPolicyDesc="",strLastBedChargeDate="",strBlngGrpId="",blng_grp_desc="";
	String int_bill_gen_freq="";//int count=0;
	int  no_of_decimals=0;
	String sys_date="";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	
	try
	{	
		HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);		
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_from_nursing_unit_code=request.getParameter("from_nursing_unit_code");
		if(p_from_nursing_unit_code==null || p_from_nursing_unit_code.equals("")) p_from_nursing_unit_code="";		
		p_to_nursing_unit_code=request.getParameter("to_nursing_unit_code");
		if(p_to_nursing_unit_code==null || p_to_nursing_unit_code.equals("")) p_to_nursing_unit_code="";
		p_from_adm_no=request.getParameter("from_adm_no");
		if(p_from_adm_no==null || p_from_adm_no.equals("")) p_from_adm_no="";
		p_to_adm_no=request.getParameter("to_adm_no");
		if(p_to_adm_no==null || p_to_adm_no.equals("")) p_to_adm_no="";
//		System.out.println("p_from_nursing_unit_code"+p_from_nursing_unit_code);
//		System.out.println("p_to_nursing_unit_code"+p_to_nursing_unit_code);
//		System.out.println("p_from_adm_no"+p_from_adm_no);
//		System.out.println("p_to_adm_no"+p_to_adm_no);
		p_payer_code=request.getParameter("payer_code");
		if(p_payer_code==null || p_payer_code.equals("")) p_payer_code="";
		p_patient_id=request.getParameter("patient_id");
		if(p_patient_id==null || p_patient_id.equals("")) p_patient_id="";
		p_payer_type=request.getParameter("payer_type");
		if(p_payer_type==null || p_payer_type.equals("")) p_payer_type="";
		p_pay_amt_exce=request.getParameter("pay_amt_exce");
		if(p_pay_amt_exce==null || p_pay_amt_exce.equals("")) p_pay_amt_exce="";
		str_no_of_deci=request.getParameter("no_of_deci");
		if(str_no_of_deci==null || str_no_of_deci.equals("")) str_no_of_deci="";
		no_of_decimals=Integer.parseInt(str_no_of_deci);		
		int_bill_gen_freq=request.getParameter("int_bill_gen_freq");
		if(int_bill_gen_freq==null) int_bill_gen_freq="";
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}


            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		try
		{
			System.out.println("163");//lakshmi
/*
			String query_refresh="SELECT a.facility_id FACILITY_ID, a.patient_id PATIENT_ID, patient_name PATIENT_NAME, patient_name_loc_lang PATIENT_NAME_LOC_LANG, b.episode_type EPISODE_TYPE, open_episode_id OPEN_EPISODE_ID,to_char(a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code CUR_WARD_CODE, cur_room_num CUR_ROOM_NUM,cur_bed_num CUR_BED_NUM, cur_bed_class_code CUR_BED_CLASS_CODE, a.cust_code CUST_CODE, a.policy_type_code POLICY_TYPE_CODE, NVL (unbld_amt, 0) UNBLD_AMT,NVL (outst_amt, 0) OUTST_AMT,NVL (unbld_amt, 0) + NVL (outst_amt, 0) TOTAL,DECODE (a.policy_type_code, NULL, (NVL (b.tot_unadj_dep_amt, 0)+nvl(b.TOT_UNADJ_PREP_AMT,0)), 0) TOT_UNADJ_DEP_AMT, to_char(b.LAST_BED_BILL_DATE_TIME ,'DD/MM/YYYY HH24:MI:SS') LAST_BED_CHARGE_COMPUTATION,a.BLNG_GRP_ID BILLING_GRP_ID FROM bl_unbld_outst_vw a, bl_episode_fin_dtls b WHERE a.facility_id = b.operating_facility_id  AND a.open_episode_id = b.episode_id AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b  WHERE a.facility_id = b.facility_id AND a.open_episode_id = b.episode_id AND NVL (dis_adv_status, ' ') != '9') and a.facility_id = '"+p_facility_id+"' AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', '~~~~')  AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', 999999999999) AND ((NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) OR  (NVL ('"+p_payer_type+"', 'I') = 'I'  AND a.cust_code IS NOT NULL AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code)) OR  (NVL ('"+p_payer_type+"', 'I') = 'B') ) AND NVL(UNBLD_AMT,0)+ NVL(OUTST_AMT,0)-DECODE(a.POLICY_TYPE_CODE,NULL,(NVL(b.TOT_UNADJ_DEP_AMT,0)+NVL(b.TOT_UNADJ_PREP_AMT,0)),0)>NVL('"+p_pay_amt_exce+"',0) ORDER BY patient_id";
*/
			/* The below query is commented and replaced with a new query by karthik on 8/July/2013 for AMS-CRF-0047 */
			/*
			String query_refresh="SELECT a.facility_id FACILITY_ID, a.patient_id PATIENT_ID, patient_name PATIENT_NAME, patient_name_loc_lang PATIENT_NAME_LOC_LANG, b.episode_type EPISODE_TYPE, open_episode_id OPEN_EPISODE_ID,to_char(a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code CUR_WARD_CODE, cur_room_num CUR_ROOM_NUM,cur_bed_num CUR_BED_NUM, cur_bed_class_code CUR_BED_CLASS_CODE, a.cust_code CUST_CODE, a.policy_type_code POLICY_TYPE_CODE, NVL (unbld_amt, 0) UNBLD_AMT,NVL (outst_amt, 0) OUTST_AMT,NVL (unbld_amt, 0) + NVL (outst_amt, 0) TOTAL,DECODE (a.policy_type_code, NULL, (NVL (b.tot_unadj_dep_amt, 0)+nvl(b.TOT_UNADJ_PREP_AMT,0)), 0) TOT_UNADJ_DEP_AMT, to_char(b.LAST_BED_BILL_DATE_TIME ,'DD/MM/YYYY HH24:MI:SS') LAST_BED_CHARGE_COMPUTATION,a.BLNG_GRP_ID BILLING_GRP_ID FROM bl_unbld_outst_vw a, bl_episode_fin_dtls b WHERE a.facility_id = b.operating_facility_id  AND a.open_episode_id = b.episode_id AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b  WHERE a.facility_id = b.facility_id AND a.open_episode_id = b.episode_id AND NVL (dis_adv_status, ' ') != '9') and a.facility_id = '"+p_facility_id+"' AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', '~~~~')  AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', 999999999999) AND ((NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) OR  (NVL ('"+p_payer_type+"', 'I') = 'I'  AND a.cust_code IS NOT NULL AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code)) OR  (NVL ('"+p_payer_type+"', 'I') = 'B') ) ORDER BY patient_id";
			*/
			
			String query_refresh=
				" SELECT a.facility_id facility_id, a.patient_id patient_id, patient_name patient_name, "+
		                  " patient_name_loc_lang patient_name_loc_lang, b.episode_type episode_type, open_episode_id open_episode_id, "+
		                  " TO_CHAR (a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code cur_ward_code, "+
		                  " cur_room_num cur_room_num, cur_bed_num cur_bed_num, cur_bed_class_code cur_bed_class_code, a.cust_code cust_code, "+
		                  " a.policy_type_code policy_type_code,  "+
		                  " NVL (unbld_amt, 0) unbld_amt, NVL (outst_amt, 0) outst_amt, "+
		                  " NVL (unbld_amt, 0) + NVL (outst_amt, 0) total, "+
		                  " DECODE (a.policy_type_code, "+
		                          " NULL, NVL (b.tot_unadj_dep_amt, 0), "+
		                          " 0 "+
		                         " ) tot_unadj_dep_amt, "+
		                  " TO_CHAR (b.last_bed_bill_date_time, "+
		                  " 'DD/MM/YYYY HH24:MI:SS' "+
		                 " ) last_bed_charge_computation, a.blng_grp_id billing_grp_id "+
		             " FROM bl_unbld_outst_vw a, "+
		                  " bl_episode_fin_dtls b, "+
		                  " bl_encounter_payer_priority c "+
		            " WHERE a.facility_id = b.operating_facility_id "+
		              " AND a.open_episode_id = b.episode_id "+
		              " AND b.operating_facility_id = c.operating_facility_id "+
		              " AND b.episode_id = c.episode_id "+
		              " AND b.cur_acct_seq_no = c.acct_seq_no "+
		              " AND c.blng_grp_id = a.blng_grp_id "+
		              " AND NVL (a.cust_code, '!!!') = NVL (c.cust_code, '!!!') "+
		              " AND NVL (a.policy_type_code, '!!!') = "+
		                   " NVL (c.policy_type_code, '!!!') "+
		              " AND facility_id = '"+p_facility_id+"' "+
		              " AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', "+
		                                                                    " '~~~~' "+
		                                                                   " ) "+
		              " AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', "+
		                                                               " 999999999999 "+
		                                                              " ) "+
		              " AND (   (NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) "+
		                   " OR (    NVL ('"+p_payer_type+"', 'I') = 'I' "+
		                       " AND a.cust_code IS NOT NULL "+
		                       " AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code) "+
		                      " ) "+
		                   " OR (NVL ('"+p_payer_type+"', 'I') = 'B') "+
		                  " ) "+
		              " AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) >= "+
		                              " NVL ('', NVL (unbld_amt, 0) + NVL (outst_amt, 0)) "+
		              " AND (   (    'N' = NVL ('N', 'N') "+
		                       " AND NOT EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                   " OR (    'Y' = NVL ('N', 'N') "+
		                       " AND EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                  " ) "+
		          " UNION ALL "+
		          " (SELECT a.facility_id facility_id, a.patient_id patient_id, patient_name patient_name, "+
		                  " patient_name_loc_lang patient_name_loc_lang, b.episode_type episode_type, open_episode_id open_episode_id, "+
		                  " TO_CHAR (a.admission_date_time,'DD/MM/YYYY HH24:MI:SS') admission_date_time, cur_ward_code cur_ward_code, "+
		                  " cur_room_num cur_room_num, cur_bed_num cur_bed_num, cur_bed_class_code cur_bed_class_code, c.cust_code cust_code, "+
		                  " c.policy_type_code policy_type_code, "+
		                    " 0 unbld_amt, "+
		                  " 0 outst_amt, 0 total, "+
		                  " DECODE (c.policy_type_code, "+
		                          " NULL, NVL (b.tot_unadj_dep_amt, 0), "+
		                          " 0 "+
		                         " ) tot_unadj_dep_amt, "+
						" TO_CHAR (b.last_bed_bill_date_time, "+
							" 'DD/MM/YYYY HH24:MI:SS' "+
							" ) last_bed_charge_computation, c.blng_grp_id billing_grp_id "+
		             " FROM ip_open_episode a, "+
		                  " bl_episode_fin_dtls b, "+
		                  " bl_encounter_payer_priority c, "+
		                  " mp_patient d "+
		            " WHERE a.facility_id = b.operating_facility_id "+
		              " AND a.open_episode_id = b.episode_id "+
		              " AND b.operating_facility_id = c.operating_facility_id "+
		              " AND b.episode_id = c.episode_id "+
		              " AND b.cur_acct_seq_no = c.acct_seq_no "+
		              " AND NOT EXISTS (SELECT 1 "+
		                                " FROM bl_unbld_outst_vw e "+
		                               " WHERE e.open_episode_id = a.open_episode_id) "+
		              " AND a.patient_id = d.patient_id "+
		              " AND facility_id = '"+p_facility_id+"' "+
		              " AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', "+
		                                                                    " '~~~~' "+
		                                                                   " ) "+
		              " AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', "+
		                                                               " 999999999999 "+
		                                                              " ) "+
		              " AND (   (NVL ('"+p_payer_type+"', 'I') = 'P' AND c.cust_code IS NULL) "+
		                   " OR (    NVL ('"+p_payer_type+"', 'I') = 'I' "+
		                       " AND c.cust_code IS NOT NULL "+
		                       " AND c.cust_code = NVL ('"+p_payer_code+"', c.cust_code) "+
		                      " ) "+
		                   " OR (NVL ('"+p_payer_type+"', 'I') = 'B') "+
		                  " ) "+
		              " AND (   (    'N' = NVL ('N', 'N') "+
		                       " AND NOT EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                   " OR (    'Y' = NVL ('N', 'N') "+
		                       " AND EXISTS ( "+
		                              " SELECT 'x' "+
		                                " FROM ip_discharge_advice_his_vw b "+
		                               " WHERE facility_id = b.facility_id "+
		                                 " AND open_episode_id = b.episode_id "+
		                                 " AND NVL (dis_adv_status, ' ') != '9') "+
		                      " ) "+
		                  " ))	";						  
			
			System.err.println("query_refresh :" +query_refresh);
		
			HashMap sqlMap = new HashMap();

			sqlMap.put("sqlData",query_refresh);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("FACILITY_ID");			
			displayFields.add("PATIENT_ID");
			displayFields.add("PATIENT_NAME");
			displayFields.add("PATIENT_NAME_LOC_LANG");
			displayFields.add("EPISODE_TYPE");						
			displayFields.add("OPEN_EPISODE_ID");						
			displayFields.add("admission_date_time");						
			displayFields.add("CUR_WARD_CODE");						
			displayFields.add("CUR_ROOM_NUM");						
			displayFields.add("CUR_BED_NUM");						
			displayFields.add("CUR_BED_CLASS_CODE");						
			displayFields.add("CUST_CODE");						
			displayFields.add("POLICY_TYPE_CODE");						
			//displayFields.add("inh_bill_gen_date");						
			displayFields.add("UNBLD_AMT");						
			displayFields.add("OUTST_AMT");						
			displayFields.add("TOTAL");						
			displayFields.add("TOT_UNADJ_DEP_AMT");
			displayFields.add("LAST_BED_CHARGE_COMPUTATION");
			displayFields.add("BILLING_GRP_ID");
						
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("resutl==>"+result);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
			// commented by DhanasekarV against 43674	out.println(result.get(1));
//				System.out.println("resutl==>"+result.get(1));

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
				out.println(result.get(1));
//				System.out.println("resutl==>"+result.get(1));

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
				int i=1;	//Modified by Rajesh V from 0 to 1
				ArrayList records=new ArrayList();
				for(int j=2; j<result.size(); j++)
				{			
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
					records=(ArrayList) result.get(j);
						//System.out.println("@@==>"+records);						
					strFacilityId=(String)records.get(0);
					if ( strFacilityId== null || strFacilityId.equalsIgnoreCase("null")){
							strFacilityId="";}

					strPatientId=(String)records.get(1);
					if ( strPatientId== null || strPatientId.equalsIgnoreCase("null")){
							strPatientId="";}
//					System.out.println("strPatientId=@@==>"+strPatientId);

					strPatientName=(String)records.get(2);
					if ( strPatientName== null || strPatientName.equalsIgnoreCase("null")){
							strPatientName="";}
//					System.out.println("strPatientName=@@==>"+strPatientName);					
					
					strPatientNameLocLang=(String)records.get(3);
					if ( strPatientNameLocLang== null || strPatientNameLocLang.equalsIgnoreCase("null")){
						strPatientNameLocLang="";}
//					System.out.println("strPatientNameLocLang=@@==>"+strPatientNameLocLang);
					strEpisodeType=(String)records.get(4);
					if ( strEpisodeType== null || strEpisodeType.equalsIgnoreCase("null")){
						strEpisodeType="";}
//					System.out.println("strEpisodeType=@@==>"+strEpisodeType);
					strOpenEpisodeId=(String)records.get(5);
					if ( strOpenEpisodeId== null || strOpenEpisodeId.equalsIgnoreCase("null")){
						strOpenEpisodeId="";}
//						System.out.println("strOpenEpisodeId=@@==>"+strOpenEpisodeId);
					strAdmDateTime=(String)records.get(6);
					if ( strAdmDateTime== null || strAdmDateTime.equalsIgnoreCase("null")){
						strAdmDateTime="";}
//					System.out.println("strAdmDateTime=@@==>"+strAdmDateTime);

					strCurWardCode=(String)records.get(7);
					if ( strCurWardCode== null || strCurWardCode.equalsIgnoreCase("null")){
						strCurWardCode="";}
//					System.out.println("strCurWardCodee=@@==>"+strCurWardCode);

					strCurrRoomNum=(String)records.get(8);
					if ( strCurrRoomNum== null || strCurrRoomNum.equalsIgnoreCase("null")){
						strCurrRoomNum="";}
//					System.out.println("strCurrRoomNum=@@==>"+strCurrRoomNum);
					strCurrBedNum=(String)records.get(9);
					if ( strCurrBedNum== null || strCurrBedNum.equalsIgnoreCase("null")){
						strCurrBedNum="";}
//					System.out.println("strCurrBedNum=@@==>"+strCurrBedNum);

					strCurBedClassCode=(String)records.get(10);
					if ( strCurBedClassCode== null || strCurBedClassCode.equalsIgnoreCase("null")){
						strCurBedClassCode="";}
//					System.out.println("strCurBedClassCode=@@==>"+strCurBedClassCode);

					strCustCode=(String)records.get(11);
					if ( strCustCode== null || strCustCode.equalsIgnoreCase("null")){
						strCustCode="";}
//					System.out.println("strCustCode=@@==>"+strCustCode);

					strPolicyTypeCode=(String)records.get(12);
					if ( strPolicyTypeCode== null || strPolicyTypeCode.equalsIgnoreCase("null")){
						strPolicyTypeCode="";}
//					System.out.println("strPolicyTypeCode=@@==>"+strPolicyTypeCode);
					
					/*strInhBillgenDate=(String)records.get(13);
					if ( strInhBillgenDate== null || strInhBillgenDate.equalsIgnoreCase("null")){
						strInhBillgenDate="";}
					System.out.println("strInhBillgenDate=@@==>"+strInhBillgenDate);*/
					
					strUnBldAmt=(String)records.get(13);
					if ( strUnBldAmt== null || strUnBldAmt.equalsIgnoreCase("null")){
					strUnBldAmt="";}
					System.out.println("strUnBldAmt=@@==>"+strUnBldAmt);//lakshmi
					strOutstdAmt=(String)records.get(14);
					if ( strOutstdAmt== null || strOutstdAmt.equalsIgnoreCase("null")){
						strOutstdAmt="";}
//					System.out.println("strOutstdAmt=@@==>"+strOutstdAmt);
					strTotAmt=(String)records.get(15);
					if ( strTotAmt== null || strTotAmt.equalsIgnoreCase("null")){
						strTotAmt="";}
					System.out.println("strTotAmt=@@==>"+strTotAmt);//lakshmi

					strTotUnadjDepAmt=(String)records.get(16);
					if ( strTotUnadjDepAmt== null || strTotUnadjDepAmt.equalsIgnoreCase("null")){
						strTotUnadjDepAmt="";}
//					System.out.println("strTotUnadjDepAmt=@@==>"+strTotUnadjDepAmt);

					strLastBedChargeDate=(String)records.get(17);
					if ( strLastBedChargeDate== null || strLastBedChargeDate.equalsIgnoreCase("null")){
						strLastBedChargeDate="";}
//					System.out.println("strLastBedChargeDate=@@==>"+strLastBedChargeDate);

					strBlngGrpId=(String)records.get(18);
					if ( strBlngGrpId== null || strBlngGrpId.equalsIgnoreCase("null")){
						strBlngGrpId="";}
//					System.out.println("strBlngGrpId=@@==>"+strBlngGrpId);

					strCustDesc="";
					String sqlcc="select SHORT_NAME from ar_customer_lang_vw where CUST_CODE='"+strCustCode+"' and language_id='"+locale+"'";
					pstmt=con.prepareStatement(sqlcc);
				//	System.out.println("sqlcc :" +sqlcc); 
					rs2=pstmt.executeQuery();
					while(rs2.next())
					{
						strCustDesc =rs2.getString(1);
						if ( strCustDesc == null || strCustDesc.equalsIgnoreCase("null")) 
						 strCustDesc = "";	
					}
					rs2.close();
					pstmt.close();
//					System.out.println("strCustDesc"+strCustDesc);
					strPolicyDesc="";
					String sqlpc="select SHORT_DESC from  bl_ins_policy_types_lang_vw where POLICY_TYPE_CODE='"+strPolicyTypeCode+"' and language_id='"+locale+"'";
					pstmt=con.prepareStatement(sqlpc);
					//System.out.println("sqlpc :" +sqlpc); 
					rs3=pstmt.executeQuery();
					while(rs3.next())
					{
						strPolicyDesc =rs3.getString(1);
						if ( strPolicyDesc == null || strPolicyDesc.equalsIgnoreCase("null")) 
						strPolicyDesc = "";	
					}
					rs3.close();
					pstmt.close();
//					System.out.println("strPolicyDesc"+strPolicyDesc);

					blng_grp_desc="";
					String sqlBG="select SHORT_DESC from  BL_BLNG_GRP_LANG_VW where BLNG_GRP_ID='"+strBlngGrpId+"' and language_id='"+locale+"'";
					pstmt=con.prepareStatement(sqlBG);
					//System.out.println("sqlBG :" +sqlBG); 
					rs4=pstmt.executeQuery();
					while(rs4.next())
					{
						blng_grp_desc =rs4.getString(1);
						if ( blng_grp_desc == null || blng_grp_desc.equalsIgnoreCase("null")) 
						blng_grp_desc = "";	
					}
					rs4.close();
					pstmt.close();
//					System.out.println("blng_grp_desc"+blng_grp_desc);

					CurrencyFormat cf1 = new CurrencyFormat();
					strUnBldAmt = cf1.formatCurrency(strUnBldAmt,no_of_decimals);
					cf1 = new CurrencyFormat();
					strOutstdAmt = cf1.formatCurrency(strOutstdAmt,no_of_decimals);
					cf1 = new CurrencyFormat();
					strTotAmt = cf1.formatCurrency(strTotAmt,no_of_decimals);

					cf1 = new CurrencyFormat();
					strTotUnadjDepAmt = cf1.formatCurrency(strTotUnadjDepAmt,no_of_decimals);

					if(strEpisodeType.equals("I"))
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
					}
					else if(strEpisodeType.equals("O"))	
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
					}
					else if(strEpisodeType.equals("E"))
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
					}
					else if(strEpisodeType.equals("D"))	
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
					}
					else if(strEpisodeType.equals("R"))	
					{
						strEpisodeType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
					}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strOpenEpisodeId));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(strAdmDateTime,"DMYHMS","en",locale)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(strLastBedChargeDate,"DMYHMS","en",locale)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strCurWardCode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strCurrBedNum));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strCustDesc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPolicyDesc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(strUnBldAmt));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strTotUnadjDepAmt));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strOutstdAmt));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strTotAmt));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strOpenEpisodeId));
            _bw.write(_wl_block96Bytes, _wl_block96);

					i++;
					total_records++; 
 				}//while

            _bw.write(_wl_block97Bytes, _wl_block97);

				out.flush();
				try
				{
					String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
					stmt1 = con.createStatement();
					rs4 = stmt1.executeQuery(query_date) ;
					if( rs4 != null ) 
					{
						while( rs4.next() )
						{  
							sys_date = rs4.getString(1);
						}
					}
					if(rs4 !=null) rs4.close();
					stmt1.close();

					if(!locale.equals("en"))
					{
						sys_date = com.ehis.util.DateUtils.convertDate(sys_date,"DMYHMS","en",locale) ;
					}
				}
				catch(Exception e)
				{
					out.println("Exception @ sysdate"+e);
				}
			}
			else 
			{

            _bw.write(_wl_block98Bytes, _wl_block98);

			}

//to insert the total records into the table
			try
			{
				System.out.println("520");//lakshmi
				String query_refresh1="SELECT DISTINCT a.facility_id , a.patient_id,b.episode_type,open_episode_id	FROM bl_unbld_outst_vw a, bl_episode_fin_dtls b WHERE a.facility_id = b.operating_facility_id  AND a.open_episode_id = b.episode_id AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b WHERE a.facility_id = b.facility_id AND a.open_episode_id = b.episode_id AND NVL (dis_adv_status, ' ') != '9') and a.facility_id = '"+p_facility_id+"' AND cur_ward_code BETWEEN NVL ('"+p_from_nursing_unit_code+"', '!!!!') AND NVL ('"+p_to_nursing_unit_code+"', '~~~~') AND a.patient_id = NVL ('"+p_payer_code+"', a.patient_id) AND open_episode_id BETWEEN NVL ('"+p_from_adm_no+"', 0) AND NVL ('"+p_to_adm_no+"', 999999999999) AND ((NVL ('"+p_payer_type+"', 'I') = 'P' AND a.cust_code IS NULL) OR  (NVL ('"+p_payer_type+"', 'I') = 'I'  AND a.cust_code IS NOT NULL AND a.cust_code = NVL ('"+p_payer_code+"', a.cust_code)) OR  (NVL ('"+p_payer_type+"', 'I') = 'B') ) AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) - nvl(tot_unadj_dep_amt,0) > NVL ('"+p_pay_amt_exce+"', 0) ORDER BY patient_id";
//				System.out.println("query_refresh1 :"+query_refresh1);
			//	String strtemp ="";String strtemp2="";
				//int count1=0;
				ArrayList total_records_array=new ArrayList();
				
				String[] output1=new String[4];
				pstmt = con.prepareStatement(query_refresh1);
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
				{
					String[] records=new String[4];

					records[0] =  rs1.getString(1);	
					if ( records[0]== null || records[0].equalsIgnoreCase("null")){
						records[0]="";}
						//System.out.println("records[0] :" +records[0]);

					records[1] =  rs1.getString(2);
					if ( records[1]== null || records[1].equalsIgnoreCase("null")){
						records[1]="";}
						//System.out.println("records[1] :" +records[1]);

					records[2] =  rs1.getString(3);		
					if ( records[2]== null || records[2].equalsIgnoreCase("null")){
						records[2]="";}
						//System.out.println("records[2] :" +records[2]);

					records[3] =  rs1.getString(4);
					if ( records[3]== null || records[3].equalsIgnoreCase("null")){
						records[3]="";}
						//System.out.println("records[3] :" +records[3]);
						
					
					total_records_array.add(records);	
				}
				session.setAttribute("total_records_array",total_records_array);	
						
				for(int j=0; j<total_records_array.size(); j++)
				{			
					output1=(String[])total_records_array.get(j);
					for(int k=0; k<output1.length; k++)
					{
						System.out.println("strtemp2 testing:" +output1[k]);
					}
				}
						
				rs1.close();
				pstmt.close();
			}
			catch(Exception e) 
			{
				System.out.println("insert qry="+e.toString());
			}
			//out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLBillInterimCurrInPat.jsp",searched));
		}
		catch(Exception eX)
		{		
			out.println("Error= "+eX);			
		}
		finally
		{
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels")));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")));
            _bw.write(_wl_block106Bytes, _wl_block106);

			//Added By Rajesh - V
				if(total_records>0){
					out.println("<script>");
					out.println("highlightRow(1,'"+classval+"')");
					out.println("</script>");
				}
				//Added By Rajesh - V
		 
            _bw.write(_wl_block107Bytes, _wl_block107);
out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLBillInterimReportCurrInPat.jsp",searched));
            _bw.write(_wl_block108Bytes, _wl_block108);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.groupby.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CURR_IPS.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionNo.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.LAST_BED_CHARGE_DATE.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ward.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNBILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNADJUST_AMT.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OUTSTANDING_BILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
}
