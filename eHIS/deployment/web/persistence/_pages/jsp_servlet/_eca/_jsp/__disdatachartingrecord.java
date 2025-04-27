package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.io.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __disdatachartingrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DisDataChartingRecord.jsp", 1739188181380L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\'../../eCA/js/DisDataCharting.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<!-- added below code for IN035857\tPMG2012-CRF-0017 START -->\n<script>\nfunction loadMainPageFirst(check)\n\t\t\t{\t\n\t\t\t\tvar qs = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tqs = qs+\'&out_mode=showpage\';\n\t\t\t\tif(check == \'Error\')\n\t\t\t\t\tqs += \'&new_last_record_date=\'+document.forms[0].date.value+\' \'+document.forms[0].time.value;\n\t\t\t\t\tlocation.href = \'../../eCA/jsp/DisDataChartingRecord.jsp?\'+qs\n\t\t\t}\n</SCRIPT>\n<!-- added below code for IN035857\tPMG2012-CRF-0017 END -->\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onKeyPress=\'\' >\n<form name=\'DisDataCharting_form\' id=\'DisDataCharting_form\' action=\'../../servlet/eCA.VitalSignRecordServlet\' method=\'post\' target=\'messageFrame\'> \n<table  id=\'detailTab\' width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' border=0 align=\'center\'>\n<!-- added below code for IN035857\tPMG2012-CRF-0017 START -->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<tr>\n\t\t\t<td class=label ><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =":</td>\n\t\t\t<td  class=label id=td1 colspan=4><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t</tr>\t\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'30%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'8%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'16%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'36%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =".</font></td>\t\n\t\t</tr>\n<!-- added below code for IN035857\tPMG2012-CRF-0017 END -->\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<tr>\n\t\t<td>\n\t\t\t<table class=\'grid\' border=0 width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'gridData\' width=\'25%\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td> \n\t\t\t\t<td width=\'25%\' class=\'gridData\'><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td> \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\n\t\t\t\t<td  colspan=2 width=\'50%\' id=\'spanning\'  class=\'gridData\'><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<td  colspan=2  id=\'spanning\'   width=\'50%\' class=\'gridData\'><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<td  colspan=2  id=\'spanning\' width=\'50%\' class=\'gridData\'></td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'10%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="1</font></td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'20%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'20%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'15%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'10%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\t\n\t\t\t\t<td class=\'columnheadercenter\'></td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'10%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnheadercenter\'   width=\'30%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'25%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n \t\t\t\t<td class=\'columnheadercenter\'></td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'11%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t<td class=\'columnheadercenter\'   width=\'13%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font></td>\t\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'2%\'></td>\n\t\t\t\t<td class=\'columnheadercenter\'  width=\'4%\' colspan=2><input type=\'checkbox\' name=chkAll onclick=\'checkAll(this)\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"30%\" id=\"short_desc_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<!-- <td width=\"30%\" colspan=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"> -->\n\t\t\t\t<td width=\"10%\" colspan=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> <!--  modified for IN035857\tPMG2012-CRF-0017 -->\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<Select name=\'str_id_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'str_id_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onChange=\"javascript:chkNormalAbnormal(this,\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t\t\t\t\t\t<option value=\'\'>&nbsp; -----Select------&nbsp;</option>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t</Select>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t</td>\n\t\t\t\t\n\t<!-- \t\t<td nowrap id=\'abcd\'> -->  <!-- commented for PMG2012-CRF-0017 -->\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<td nowrap id=\'abcd\'> ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<input type=\'checkbox\' name=errorChk";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" onclick=\'callRemarksBox(this,\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\",\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\",";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =");\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<Select name=\'str_id1_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'str_id1_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\')\" >\n\t\t\t\t\t\t<option value=\'\'>&nbsp; -----Select------&nbsp;</option>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t</td>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<td width=\"10%\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t<td width=\"13%\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t<td width=\"11%\" id=\'nor_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t<td  width=\'2%\'>\n\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'remarks";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'remarks";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' value=\'\'><input type=\'hidden\' name=\'flag";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'flag";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' value=\'N\'></td>\n\t\t\t<td id=\'remID";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' align =\'left\' width=\'4%\'>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</td>\n\t\t\t<!--<td>-->  <!-- commented for PMG2012-CRF-0017 -->\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<!-- </td> -->  <!-- commented for PMG2012-CRF-0017 -->\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t<td align =\'left\' width=\'2%\'><input type=\'checkbox\' name=errorChk";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\");\' ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'remarks";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t<td width=\"15%\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t<td width=\"15%\" id=\'nor_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\n\t\t\t<td id=\'remID";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t</td>\n\t\t\t<!--<td> -->  <!-- commented for PMG2012-CRF-0017 -->\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\n\t\t<input type=\"hidden\" name=\"item_id_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"item_id_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t<input type=\"hidden\" name=\"uom_id_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"uom_id_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t\t<input type=\"hidden\" name=\"normal_low_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"normal_low_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t<input type=\"hidden\" name=\"normal_high_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"normal_high_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t<input type=\"hidden\" name=\"num_digits_dec_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"num_digits_dec_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\t\n\t\t<input type=\"hidden\" name=\"op_type_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"op_type_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t<input type=\"hidden\" name=\"result_type_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"result_type_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t\t<input type=\"hidden\" name=\"num_crit_low_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"num_crit_low_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\t\t\t\t\t\n\t\t<input type=\"hidden\" name=\"num_crit_high_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"num_crit_high_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\t\n\t\t<input type=\"hidden\" name=\"accession_num_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"accession_num_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t<input type=\"hidden\" name=\"def_data_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"def_data_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' >\t\n\t\t<input type=\"hidden\" name=\"norm_abnorm_ind_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"norm_abnorm_ind_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' >\t\t\n\t\t<input type=\"hidden\" name=\"mandatory_yn_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"mandatory_yn_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' >\t\t\t\n\t\t<!--</td>-->  <!-- commented for PMG2012-CRF-0017 -->\n\t</tr>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n    </table>\n\t<input type=\"hidden\" name=\"no_of_rec\" id=\"no_of_rec\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t<input type=\"hidden\" name=\"last_record_date\" id=\"last_record_date\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\n\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" >\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >\n\t<input type=\"hidden\" name=\"clinician_id\" id=\"clinician_id\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" >\n\t<input type=\"hidden\" name=\"adm_dt_time\" id=\"adm_dt_time\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n\t<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" >\n\t<input type=\"hidden\" name=\"low_str\" id=\"low_str\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\n\t<input type=\"hidden\" name=\"high_str\" id=\"high_str\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n\t<input type=\"hidden\" name=\"abn_str\" id=\"abn_str\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >\n\t<input type=\"hidden\" name=\"crit_low_str\" id=\"crit_low_str\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t<input type=\"hidden\" name=\"crit_high_str\" id=\"crit_high_str\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\n\t<input type=\"hidden\" name=\"crit_abn_str\" id=\"crit_abn_str\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t<input type=\"hidden\" name=\"battery_id\" id=\"battery_id\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >\t\n\t<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n\t<input type=\"hidden\" name=\"in_error\" id=\"in_error\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t<input type=\"hidden\" name=\"in_replace\" id=\"in_replace\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" >\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' >\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' >\n\t<input type=\"hidden\" name=\"replaceError_count\" id=\"replaceError_count\" value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' >\n\t<input type=\"hidden\" name=\"patsex\" id=\"patsex\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" >\n\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" >\n\t<!--IN034536 Starts-->\n\t<input type=\"hidden\" name=\"isPatientEncMovement\" id=\"isPatientEncMovement\" value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' >\n\t<input type=\"hidden\" name=\"p_queue_date\" id=\"p_queue_date\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" >\n\t<input type=\"hidden\" name=\"Sydate\" id=\"Sydate\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" >\n\t<!--IN034536 Ends -->\n\t<!-- IN037701 start -->\n\t<input type=\"hidden\" name=\"disc_id\" id=\"disc_id\" value=\'\'>\n\t<input type=hidden name=qs value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=hidden name=dup_yn value=\'\'>\n\t<!-- IN037701 - end-->\n</form>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n<script>\n\t\t//resetForm(\"pageload\");\n</script>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
04/12/2012		IN036440		ChowminyaG		 Default value of discrete measure do not show the default value in vital sign battery
10/12/2012		IN036447		ChowminyaG		 Multiple Reference Range of integer numeric discrete measure do not display in Vital sign battery 
14/02/2013		IN036756		ChowminyaG		 Record Vital Signs->Defined Discrete Measure Components are not displayed 
11/12/2013      IN034536		Nijitha S		Bru-HIMS-CRF-133
03/06/2014	  	IN037701		Chowminya		 SKR-CRF-0036
13/07/2021		21303			Ramesh Goli		 SKR-SCF-1623
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    Connection con = null;
    try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = p.getProperty( "login_user" ) ;

		con = ConnectionManager.getConnection(request);
		PreparedStatement stmt  = null;
		PreparedStatement stmt1 = null;
		ResultSet rset = null ;
		ResultSet rset1 = null ;
		
		String clinicianid		=	(String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String episodetype = request.getParameter("episode_type")==null?"I":request.getParameter("episode_type");
		String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
		if(visitid.equals("") && episodetype.equals("I")) visitid = "1";
		String batteryid = request.getParameter("battey_id")==null?"":request.getParameter("battey_id");
		batteryid = batteryid.trim();
		String patientid = request.getParameter("patient_id");
		String admdttime = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
		String locncode = request.getParameter("location_code")==null?"": request.getParameter("location_code");

		String patsex = request.getParameter("patsex")==null?"U": request.getParameter("patsex");//[IN036447]
		String amerepMode=request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
		//IN034536 Starts
		String isPatientEncMovement = request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		String	p_queue_date = request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
		String	Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		//IN034536 Ends

		/*if(patsex.equals("Male")) patsex = "M";
		else if(patsex.equals("Female")) patsex = "F";
		else patsex = "U";*///[IN036447]

		String out_mode = request.getParameter("out_mode")==null?"": request.getParameter("out_mode");
		String dob = request.getParameter("dob")==null?"": request.getParameter("dob");
		String lastrecorddate = request.getParameter("last_record_date")==null?"":request.getParameter("last_record_date");
		String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
		String replaceMode = request.getParameter("replaceMode")==null?"":request.getParameter("replaceMode");
		String newlastrecorddate = request.getParameter("new_last_record_date")==null?"":request.getParameter("new_last_record_date");
		String module_id = request.getParameter("module_id")==null?"": request.getParameter("module_id");
		String location_type = request.getParameter("location_type")==null?"": request.getParameter("location_type");
		    
		String readOnly = "";
		String listDisabled = "";
		String disabled = "";
		String errorRemarks = "";
		String longTextVal = "";
		String called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");//IN037701
		
		if(amendMode.equals("Y"))
		{
			lastrecorddate = newlastrecorddate;
			readOnly = "readOnly";
			listDisabled = "disabled";
		}

		if(replaceMode.equals("Y"))
		{
			lastrecorddate = newlastrecorddate;
			readOnly = "readOnly";
			listDisabled = "disabled";
		}

		String accessionnum = "" ;                  
		String discrmsrid = "" ;                   
		String discrmsrresulttype = "" ;          

		String colspanvalue = "";
		int numdigitsdec = 0;

		String defnum =  "" ;
		String defstr =  "" ;
		String defdata =  "" ;
		Clob defaultdata = null;
		String chkType =  "" ;
		String shortdesc = "";
		int defseq = 0; //IN036756
		int crtseq = 0; //IN036756

		String	normabnormind = "";
		String refrangetype = "";
		String range = "";
		String optype = "";
		String chartId = ""; //21303
		String mandatoryyn = "";
		String sysdatetime = "";

		int maxsize = 8;
		int i = 0;
		int count = 0;
		
		String dat = "";
		String sel = "";

		String highstr = "";
		String lowstr = "";
		String abnstr = "";
		String critstr = "";
		String crithighstr = "";
		String critlowstr = "";
		String critabnstr = "";
  
		String highstr_desc = "";
		String lowstr_desc = "";
		String abnstr_desc = "";
		String critstr_desc = "";
		String crithighstr_desc = "";
		String critlowstr_desc = "";
		String dateStatus = "";
		int numdigitsmax = 0;
		int numdigitsmin = 0;
		String numuom = "";
		String numreflow = "";
		String numrefhigh = "";
		String numcritlow = "";
		String numcrithigh = "";
		int min_value = 0;
		int max_value = 0;
		String qs = request.getQueryString();

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block9Bytes, _wl_block9);

		
	if(amerepMode.equals("N"))
	{
		if(lastrecorddate.equals(""))
			dateStatus = "New";
		else
			dateStatus = "<a href='javascript:loadMainPageFirst()' >"+lastrecorddate+"</a>";
			

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dateStatus));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 
}else if(amerepMode.equals("Y"))
	{ 

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(newlastrecorddate));
            _bw.write(_wl_block20Bytes, _wl_block20);
 
			if (amendMode.equals("Y"))
			{

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 
			}
			else if (replaceMode.equals("Y"))
			{

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
			else
			{

            _bw.write(_wl_block24Bytes, _wl_block24);

			}

            _bw.write(_wl_block25Bytes, _wl_block25);
 
	}

	if(amerepMode.equals("Y"))
	{
		if (!amendMode.equals("Y"))
		{ 

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 
		}
		else
		{ 

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 
		} 
	} 

    try 
	{
		if(clinicianid.equals(""))
		{
			stmt = con.prepareStatement("select func_role_id from sm_appl_user a where appl_user_id = ? and func_role ='P'");
			stmt.setString(1,login_user);
			rset = stmt.executeQuery();
			
			if(rset != null && rset.next())
				clinicianid = rset.getString("func_role_id") == null ? "" : rset.getString("func_role_id");
			
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
		
		StringBuffer sql = new StringBuffer();
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select HIGH_STR,LOW_STR,ABN_STR,CRIT_STR,CRIT_HIGH_STR,CRIT_LOW_STR,HIGH_STR_DESC,LOW_STR_DESC,ABN_STR_DESC,CRIT_HIGH_STR_DESC ");
		sql.append(" ,CRIT_LOW_STR_DESC,CRIT_STR_DESC from cr_clin_event_param ");
			
		stmt = con.prepareStatement(sql.toString());
		rset = stmt.executeQuery();

		if(rset != null && rset.next())
		{
			highstr = rset.getString("HIGH_STR") == null ? "" : rset.getString("HIGH_STR");
			lowstr = rset.getString("LOW_STR") == null ? "" : rset.getString("LOW_STR");
			abnstr = rset.getString("ABN_STR") == null ? "" : rset.getString("ABN_STR");
			critstr = rset.getString("CRIT_STR") == null ? "" : rset.getString("CRIT_STR");
			crithighstr = rset.getString("CRIT_HIGH_STR") == null ? "" : rset.getString("CRIT_HIGH_STR");
			critlowstr = rset.getString("CRIT_LOW_STR") == null ? "" : rset.getString("CRIT_LOW_STR");
							
			highstr_desc = rset.getString("HIGH_STR_DESC") == null ? "" : rset.getString("HIGH_STR_DESC");
			lowstr_desc = rset.getString("LOW_STR_DESC") == null ? "" : rset.getString("LOW_STR_DESC");
			abnstr_desc = rset.getString("ABN_STR_DESC") == null ? "" : rset.getString("ABN_STR_DESC");
			crithighstr_desc = rset.getString("CRIT_HIGH_STR_DESC") == null ? "" : rset.getString("CRIT_HIGH_STR_DESC");
			critlowstr_desc = rset.getString("CRIT_LOW_STR_DESC") == null ? "" : rset.getString("CRIT_LOW_STR_DESC");
			critstr_desc = rset.getString("CRIT_STR_DESC") == null ? "" : rset.getString("CRIT_STR_DESC");
		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		
		if(!out_mode.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			//if else condition added IN037701 start
			if("CA_SPC".equals(called_from))
			{
				sql.append(" SELECT   a.discr_msr_id, a.short_desc, a.unit_of_measure, a.result_type, a.num_digits_max, a.num_digits_min, a.num_digits_dec, a.mandatory_yn, DECODE (NVL (b.discr_msr_id, 'Y'), 'Y', 'I', 'U') operation_type, b.discr_msr_result_num default_num, b.discr_msr_result_str default_str, b.discr_msr_result_data default_data, b.norm_abnorm_ind, b.error_remarks error_remarks, accession_num, ref_range_type, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sysdatetime,(SELECT DECODE (b.norm_abnorm_ind, high_str, high_symbol_icon, low_str, low_symbol_icon, crit_str, crit_symbol_icon,abn_str, abn_symbol_icon, crit_high_str, crit_high_symbol_icon, crit_low_str, crit_low_symbol_icon, '' )FROM cr_clin_event_param) normal_range_symbol, (SELECT DECODE (b.norm_abnorm_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code, abn_str, abn_color_code, crit_high_str, crit_high_color_code,crit_low_str, crit_low_color_code,'')FROM cr_clin_event_param) normal_range_color,b.chart_id FROM am_discr_msr_battery_spc_view a, ca_encntr_discr_msr b WHERE a.discr_msr_battery_id = ?   AND ? = b.facility_id(+)  AND a.discr_msr_id = b.discr_msr_id(+)AND b.encounter_id(+) = ?  AND NVL (b.error_yn(+), 'N') = 'N' /* and  b.visit_id(+)= ?             */ AND b.test_observ_dt_tm(+) = TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss') ORDER BY a.order_srl_no"); //b.chart_id added for 21303
			}
			else
			{
				sql.append(" SELECT  a.discr_msr_id ");
				sql.append(" ,a.short_desc ");
				sql.append(" ,a.unit_of_measure ");
				sql.append(" ,a.result_type ");
				sql.append(" ,a.num_digits_max ");
				sql.append(" ,a.num_digits_min ");
				sql.append(" ,a.num_digits_dec ");
				sql.append(" ,a.mandatory_yn ");
				sql.append(" ,decode(nvl(b.discr_msr_id,'Y'),'Y','I','U') operation_type ");				
				sql.append(" ,b.DISCR_MSR_RESULT_NUM default_num ");          
				sql.append(" ,b.DISCR_MSR_RESULT_STR  default_str ");          
				sql.append(" ,b.DISCR_MSR_RESULT_DATA default_data ");   
				sql.append(" ,b.NORM_ABNORM_IND ");
				sql.append(" ,b.ERROR_REMARKS error_remarks ");
				sql.append(" ,ACCESSION_NUM,REF_RANGE_TYPE, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
				sql.append(" ,b.chart_id "); //21303
				sql.append(" FROM am_discr_msr_battery_view a,ca_encntr_discr_msr b ");
				sql.append(" WHERE a.DISCR_MSR_BATTERY_ID	= ?  ");
				sql.append(" and ? = b.facility_id(+)  ");
				sql.append(" and a.discr_msr_id = b.discr_msr_id(+) ");
				sql.append(" and b.ENCOUNTER_ID   (+) = ? AND nvl(b.ERROR_YN (+),'N' )='N' /* and  b.visit_id(+)= ? 			*/");
				sql.append(" and b.TEST_OBSERV_DT_TM(+)= to_date(?,'dd/mm/yyyy hh24:mi:ss') ");	
				sql.append(" order by  a.ORDER_SRL_NO ");
			}
			//IN037701 end
			stmt = con.prepareStatement(sql.toString());
					
			stmt.clearParameters();
			stmt.setString(1,batteryid);
			stmt.setString(2,facilityId);
			stmt.setString(3,episodeid);
			stmt.setString(4,lastrecorddate);
		}
		else
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT  a.discr_msr_id ");
			//sql.append(" SELECT  discr_msr_id "); //commentted--[IN036440]
			sql.append(" , short_desc ");
			sql.append(" ,unit_of_measure ");
			sql.append(" ,result_type ");
			sql.append(" ,num_digits_max ");
			sql.append(" ,num_digits_min ");
			sql.append(" ,num_digits_dec ");
			sql.append(" ,mandatory_yn ");
			sql.append(" ,'I' operation_type ");
			sql.append(" ,NUM_DFLT_RESULT default_num ");          
			sql.append(" ,null  default_str ");          
			sql.append(" ,null default_data ");    
			sql.append(" ,NULL NORM_ABNORM_IND ");
			sql.append(" ,null error_remarks ");
			sql.append(" ,null ACCESSION_NUM ");
			sql.append(" , REF_RANGE_TYPE, ref_range_seq, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");//IN036756
			sql.append(" ,'' chart_id "); //21303
			//sql.append(" FROM am_discr_msr_battery_view "); //commentted--[IN036440]
			//sql.append(" where DISCR_MSR_BATTERY_ID = ?  order by ORDER_SRL_NO ");
			sql.append(" FROM am_discr_msr_battery_view a, AM_DISCR_MSR_REF_RNG_NUM b "); //--[IN036440]
			//sql.append(" where DISCR_MSR_BATTERY_ID = ? and a.discr_msr_id = b.discr_msr_id(+)    AND patient_sex in ('A',?) AND (TO_DATE (?, 'dd/mm/yyyy') <= DECODE (start_age_units,'D', TRUNC (SYSDATE) - start_age,'M', ADD_MONTHS (TRUNC (SYSDATE), -1 * start_age),'Y', ADD_MONTHS (TRUNC (SYSDATE), -12 * start_age) )) AND (TO_DATE (?, 'dd/mm/yyyy') >= DECODE (end_age_units,'D', TRUNC (SYSDATE) - end_age, 'M', ADD_MONTHS (TRUNC (SYSDATE), -1 * end_age),'Y', ADD_MONTHS (TRUNC (SYSDATE), -12 * end_age) )) ORDER BY order_srl_NO ");//--[IN036440]--[IN036447]
			sql.append(" where DISCR_MSR_BATTERY_ID = ? and a.discr_msr_id = b.discr_msr_id(+)   ORDER BY order_srl_NO ");//--[IN036440]--[IN036447]
			stmt = con.prepareStatement(sql.toString());
			stmt.clearParameters();
			stmt.setString(1,batteryid);
			//stmt.setString(2,patsex); //--[IN036447]
		        //stmt.setString(3,dob);
			//stmt.setString(4,dob);
		}

		rset=stmt.executeQuery();
			
		while (rset.next())
		{
			errorRemarks = "";
			sysdatetime = "";
			discrmsrid = "";
			shortdesc = "";
			discrmsrresulttype = "";
			optype = "";
			chartId = ""; //21303
			defnum = "";
			defstr = "";
			longTextVal = "";
			min_value = 0;
			max_value = 0;
			i++;
			
			errorRemarks= rset.getString("error_remarks")==null?"�":rset.getString("error_remarks"); 
			sysdatetime = rset.getString("sysdatetime");
			discrmsrid = rset.getString("discr_msr_id");
			shortdesc = rset.getString("short_desc");
			discrmsrresulttype = rset.getString("result_type");
			optype = rset.getString("operation_type");
			chartId = rset.getString("chart_id"); //21303
			if("DRUG".equals(chartId)) //21303 
				optype="I";   //21303
			defnum = rset.getString("default_num")==null?"":rset.getString("default_num");
			defstr = rset.getString("default_str")==null?"":rset.getString("default_str");

			if(!out_mode.equals(""))
			{
				defaultdata = rset.getClob(12);
				if(defaultdata != null)
				{
					BufferedReader rd = new BufferedReader(defaultdata.getCharacterStream());
					char[] longTextContent = new char[(int)defaultdata.length()];

					rd.read(longTextContent,0,(int)defaultdata.length());
					longTextVal = new String(longTextContent);

					rd.close();
				}
			}
			else
			{
				defseq = rset.getInt("ref_range_seq");//IN036756
			}
			mandatoryyn = rset.getString("mandatory_yn")==null?"N":rset.getString("mandatory_yn");
			refrangetype = rset.getString("ref_range_type")==null?"":rset.getString("ref_range_type");
			normabnormind = rset.getString("NORM_ABNORM_IND")==null?"":rset.getString("NORM_ABNORM_IND");
						
			if(normabnormind.equals(highstr))
				normabnormind = highstr_desc;
			else if(normabnormind.equals(lowstr))
				normabnormind = lowstr_desc;
			else if(normabnormind.equals(abnstr))
				normabnormind = abnstr_desc;
			else if(normabnormind.equals(critstr))
				normabnormind = critstr_desc; 
			else if(normabnormind.equals(crithighstr))
				normabnormind = crithighstr_desc;
			else if(normabnormind.equals(critlowstr))
				normabnormind = critlowstr_desc; 

			numdigitsmax = rset.getInt("num_digits_max");
			numdigitsmin = rset.getInt("num_digits_min");
			numdigitsdec = rset.getInt("num_digits_dec");
			maxsize = numdigitsmax;
			accessionnum = rset.getString("ACCESSION_NUM")==null?"":rset.getString("ACCESSION_NUM");
			numuom = "";
			numreflow = "";    
			numrefhigh = "";   
			numcritlow = "";   
			numcrithigh = "";  
			
			range = "";
			
			StringBuffer valsql = new StringBuffer();
			
			valsql.append(" select num_uom, num_ref_low,num_ref_high,num_crit_low,num_crit_high ");
			valsql.append(" ,ref_range_seq, min_value, max_value from am_discr_msr_ref_rng_num a, am_discr_msr b");
			valsql.append(" WHERE a.discr_msr_id = b.discr_msr_id AND a.discr_msr_id = ?");
			
			if(refrangetype.equals("M"))
			{
				valsql.append( " and patient_sex in ('A',?) "); //--[IN036447]
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') <= ");				
				valsql.append("decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE))) ");
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') >= ");
				valsql.append("decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )");
			}
			stmt1 = con.prepareStatement(valsql.toString());
			
			stmt1.clearParameters();
			stmt1.setString(1,discrmsrid);
			if(refrangetype.equals("M"))
			{
				stmt1.setString(2,patsex);
				stmt1.setString(3,dob);
				stmt1.setString(4,dob);
			}
			rset1=stmt1.executeQuery();

			if(rset1.next())
			{
				numuom = rset1.getString("num_uom") == null ? "" : rset1.getString("num_uom");
				numreflow = rset1.getString("num_ref_low") == null ? "" : rset1.getString("num_ref_low");
				numrefhigh = rset1.getString("num_ref_high") == null ? "" : rset1.getString("num_ref_high");
				numcritlow = rset1.getString("num_crit_low") == null ? "" : rset1.getString("num_crit_low");
				numcrithigh = rset1.getString("num_crit_high") == null ? "" : rset1.getString("num_crit_high");
				min_value = rset1.getInt("min_value");
				max_value = rset1.getInt("max_value");
				crtseq = rset1.getInt("ref_range_seq");//IN036756
			}
			if(!out_mode.equals(""))
			{
				defseq = crtseq;
			}

			if(rset1 != null)rset1.close();
			if(stmt1 != null)stmt1.close();

			if(!numreflow.equals("") && !numrefhigh.equals("") )
				range = numreflow+" - "+numrefhigh;
			else if(!numreflow.equals(""))
				range = "(>="+numreflow+")";
			else if(!numrefhigh.equals(""))
				range = "(<="+numrefhigh+")";

			if(discrmsrresulttype.equals("F")) colspanvalue = "8";
			else colspanvalue = "";
		
			if (!errorRemarks.equals("�"))
			{
				readOnly = "readOnly";
				listDisabled = "disabled";
			}
			if(refrangetype.equals("M") && defseq != crtseq ) //IN036756
			{
			} else{

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(colspanvalue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(colspanvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);

				shortdesc = java.net.URLEncoder.encode(shortdesc,"UTF-8"); // ADDED BY LK
				if(discrmsrresulttype.equals("L"))
				{
					int k = i;

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(listDisabled));
            _bw.write(_wl_block47Bytes, _wl_block47);

					stmt1 = con.prepareStatement(" select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN from am_discr_msr_ref_rng_list where  discr_msr_id= ?");
					stmt1.clearParameters();
					stmt1.setString(1,discrmsrid);
					rset1=stmt1.executeQuery();
					if(rset1 != null)
					{
						while(rset1.next())
						{
							dat = rset1.getString("ref_rng_desc").trim();
							String normal = rset1.getString("NORM_ABNORM_IND")==null?"N":rset1.getString("NORM_ABNORM_IND");
							String dfltyn = rset1.getString("DFLT_YN")==null?"N":rset1.getString("DFLT_YN");
							if(dfltyn.equals("Y"))
								sel="selected";
							if(dat.equals(defstr))
							{
								if(normal.equals("A")) normabnormind = abnstr_desc;
								else if(normal.equals("C")) normabnormind = critstr_desc  ;
								sel = "selected";
							}
							else
								sel = "";
								out.println("<option class='"+normal+"' value='"+dat+"' "+sel+" >"+dat+"</option>");
								k++;
						}
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();

            _bw.write(_wl_block48Bytes, _wl_block48);

					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					out.println("<input type='checkbox' name='str_id_"+i+"' id='str_id_"+i+"' value='Y' "+chk+" "+readOnly+">");
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					out.println("<textarea name='str_id_"+i+"' rows='3' cols='71'>"+longTextVal+"</textarea>");
				}
				else if(discrmsrresulttype.equals("N"))
				{
					if (numdigitsmax==0) { numdigitsmax=22 ; maxsize=22;}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"','"+numdigitsdec+"')\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"','"+min_value+"','"+max_value+"')\"  "+readOnly+">");
					if(defnum.equals(""))
					{
						disabled="disabled";
					}
				}
				else if(discrmsrresulttype.equals("I"))
				{
					if(numdigitsmax == 0) maxsize = 3;
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"',0)\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\" "+readOnly+">"); 
				}
				else if(discrmsrresulttype.equals("H"))
				{
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='60' maxlength='4000' value = '"+defstr+"' "+readOnly+ " >");
				}
				
				else
				{
					if(discrmsrresulttype.equals("E"))
					{
						maxsize = 16;
						chkType = "return CheckForSpecCharsForDateTime(event)";
					}
					else if(discrmsrresulttype.equals("D"))
					{
						 maxsize = 10;
						 chkType = "return CheckForSpecCharsForDate(event)";
					}
					else if(discrmsrresulttype.equals("T"))
					{
						 maxsize =5;
						 chkType = "return CheckForSpecChars(event)";
					}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defstr+"' OnKeyPress =\""+chkType+"\" onblur= \" return validateDateTime(this,'"+discrmsrresulttype+"'); \"  "+readOnly+">");
					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}

				if(mandatoryyn.equals("Y") && !discrmsrresulttype.equals("C"))
					out.println("<img align=center src='../../eCommon/images/mandatory.gif'></img>");

            _bw.write(_wl_block49Bytes, _wl_block49);

			}
			if(replaceMode.equals("Y") && disabled.equals(""))
			{
				
            _bw.write(_wl_block50Bytes, _wl_block50);
 //for PMG2012-CRF-0017
				if (errorRemarks.equals("�"))
				{ 

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(count));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(errorRemarks));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block56Bytes, _wl_block56);

				}
				if(discrmsrresulttype.equals("L")  && !(defstr.equals("")) && errorRemarks.equals("�"))
				{
					int k = i; 

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);


					stmt1 = con.prepareStatement(" select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN from am_discr_msr_ref_rng_list where  discr_msr_id= ?");
					stmt1.clearParameters();
					stmt1.setString(1,discrmsrid);
					rset1 = stmt1.executeQuery();
					if(rset1 != null)
					{
						while(rset1.next())
						{
							dat = rset1.getString("ref_rng_desc").trim();
							String normal = rset1.getString("NORM_ABNORM_IND")==null?"N":rset1.getString("NORM_ABNORM_IND");
							String dfltyn = rset1.getString("DFLT_YN")==null?"N":rset1.getString("DFLT_YN");
							if(dfltyn.equals("Y"))
								sel = "selected";
							if(dat.equals(defstr))
							{
								if(normal.equals("A")) normabnormind = abnstr_desc;
								else if(normal.equals("C")) normabnormind = critstr_desc  ;
								sel = "selected";
							}
							else
								sel = "";
							out.println("<option class='"+normal+"' value='"+dat+"' "+sel+" >"+dat+"</option>");
							k++;
						}
					}
					if(rset1 != null)rset1.close();	
					if(stmt1 != null)stmt1.close();

            _bw.write(_wl_block48Bytes, _wl_block48);

					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					out.println("<input type='checkbox' name='str_id1_"+i+"' id='str_id1_"+i+"' value='Y' "+chk+">");
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					out.println("<textarea name='str_id1_"+i+"' rows='3' cols='71'>"+display+"</textarea>");
				}
				else if(discrmsrresulttype.equals("N") &&  !(defnum.equals("")) && errorRemarks.equals("�") )
				{
					out.println("<input type='text' name='str_id1_"+i+"' id='str_id1_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"','"+numdigitsdec+"')\" onBlur=\" if(this.value!= '') validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\"  disabled >");

					if(defnum.equals(""))
					{
						disabled="disabled";
					}
				}
				else if (!(defstr.equals("")) && errorRemarks.equals("�"))
				{
					if(discrmsrresulttype.equals("E"))
						maxsize = 16;
					else if(discrmsrresulttype.equals("D"))
						 maxsize = 10;
					else if(discrmsrresulttype.equals("T"))
						 maxsize =5;
					out.println("<input type='text' name='str_id1_"+i+"' id='str_id1_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defstr+"' onblur= \" return validateDateTime(this,'"+discrmsrresulttype+"'); \" >");
					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}

				if(!errorRemarks.equals("�"))//means null so no comments should come
				{
					disabled = "checked disabled";
				}

            _bw.write(_wl_block60Bytes, _wl_block60);

		if(!discrmsrresulttype.equals("F"))
		{

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(numuom));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(range));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(normabnormind));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);

			if(errorRemarks.equals("�"))//means null so no comments should come
			{
				out.println("&nbsp;");
			}
			else	
			{
				out.println("<a href='javascript:showRemarks(\""+errorRemarks+"\",\"y\",\""+count+"\")' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</b></a>");
			}

            _bw.write(_wl_block71Bytes, _wl_block71);

		}
		count++;
	} 
	else if(amendMode.equals("Y") )
	{
		if(!errorRemarks.equals("�"))//means null so no comments should come
		{
			disabled="checked disabled";
		}

            _bw.write(_wl_block72Bytes, _wl_block72);

		if(!discrmsrresulttype.equals("F"))
		{

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(numuom));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(range));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(normabnormind));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);

			if(errorRemarks.equals("�"))//means null so no comments should come
			{
				out.println("&nbsp;");
			}
			else
			{
				out.println("<a href='javascript:showRemarks(\""+errorRemarks+"\",\"y\",\""+count+"\")' ><b>!</b></a>");
			}

            _bw.write(_wl_block71Bytes, _wl_block71);

		}
		count++;
	}
	else
	{
		if(!discrmsrresulttype.equals("F"))
		{
		if(refrangetype.equals("M") && defseq != crtseq) //IN036756
		{
		} else
		{

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(numuom));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(range));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(normabnormind));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);

			if(errorRemarks.equals("�"))//means null so no comments should come
			{
				out.println("&nbsp;");
			}
			else
			{
				out.println("<a href='javascript:showRemarks(\""+errorRemarks+"\",\"y\",\""+count+"\")' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels")+"</b></a>");
			}

            _bw.write(_wl_block79Bytes, _wl_block79);

		}
		}
	}

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(discrmsrid));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(numuom));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(numreflow));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(numrefhigh));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(numdigitsdec));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(optype));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(discrmsrresulttype));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(numcritlow));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(numcrithigh));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(accessionnum));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(defdata));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(normabnormind));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(mandatoryyn));
            _bw.write(_wl_block108Bytes, _wl_block108);

		disabled = ""; //reinitializing
	}

	if(rset != null) rset.close();
	if(stmt != null) stmt.close();

	String batteryDesc = "";

	stmt = con.prepareStatement("SELECT SHORT_DESC FROM AM_DISCR_MSR WHERE DISCR_MSR_ID = ?");
	stmt.setString(1,batteryid);
	rset = stmt.executeQuery();

	while(rset.next())
	{
		batteryDesc = rset.getString("SHORT_DESC") == null ? "": rset.getString("SHORT_DESC");
	}
			
    if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(rset1!=null) rset1.close();
	if(stmt1!=null) stmt1.close();

	if(!(batteryid.equals("")) && i == 0)
	{				
		out.println("<script>var msg = getMessage('NO_DISCR_MSR','CA');</script>");
		out.println("<script>msg = msg.replace('$$',',"+batteryDesc+", ');</script>");
		out.println("<script>alert(msg);</script>");
		out.println("<script>window.close();</script>");
	}
	else if(batteryid.equals(""))
	{
		out.println("<script>alert(getMessage('NO_BATTERY','CA'))</script>");
		out.println("<script>window.close();</script>");
	}
	}
	catch(Exception e)
	{
		//out.println("Inqq   "+e.toString());//common-icn-0181
		e.printStackTrace();
	}

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(lastrecorddate));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(episodeid));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(episodetype));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(visitid));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(clinicianid));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(admdttime));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(lowstr_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(highstr_desc));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(abnstr_desc));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(critlowstr_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(crithighstr_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(critabnstr));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(batteryid));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(sysdatetime));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(amendMode));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(replaceMode));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(count));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(patsex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(qs ));
            _bw.write(_wl_block139Bytes, _wl_block139);

	if(out_mode!=null && out_mode.equals("showpage"))
	{} 
	else
	{

            _bw.write(_wl_block140Bytes, _wl_block140);

	}

            _bw.write(_wl_block141Bytes, _wl_block141);

	}
	catch ( Exception e)
	{
		//out.println("Out "+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LastRecordedDateTime.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Variable.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Units.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalRange.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalInd.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.recordeddatetime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MarkError.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReplaceValue.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Variable.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OldValue.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewValue.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Units.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalRange.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalInd.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Error.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Variable.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Units.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalRange.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalInd.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Error.label", java.lang.String .class,"key"));
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
}
