package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __recurringdaystime extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/RecurringDaysTime.jsp", 1729083541049L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<Script src=\"../../eOA/js/SecondaryResource.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t -->\t\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\'displayresults\' id=\'displayresults\'>\n\t\t\n<table  border=\'0\' width=\'100%\' cellspacing=\'0\' cellpadding=\'2\' valign=\'top\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t\t<td class=\'fields\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t</tr>\n\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td  class=\'fields\'><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></td>\n\t</tr>\n\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </b></td> \n\t</tr>\n\t\t\n\t\n\t\t\n</table>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results\'>\n\t\n\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'23%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'2%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'11%\' nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\n\n\n<tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onClick=\'col(this)\'><a  href= javascript:moveNext()>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" <input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'o_appt_ref_no";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' > </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" class=\"OARED\" onClick=\'col(this)\' title=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onclick = \"col()\"><a href= \"javascript:cols(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" class=\"OARED\" onClick=\'col(this)\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' ></td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" class=\"OAFORCED\" ><a href= javascript:col()>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onClick=\'col(this)\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\n\t\t<td width=5% ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" class=\'oablock\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' ></td>\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\n\t\t<td width=5% ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<td width=5% ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" class=\'oared\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' ></td>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<td width=5% ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" class=\"OARED\" title=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" class=\"OAFORCED\" Title=\"Forced Appointment\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" class=\'OARED\'  title =\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t<td width=5% ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t<td width=23% ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<td width=23% ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"></td>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" class=\'OARED\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<td width=23% class=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">Block Reason:&nbsp;<b>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t \n\t\t\t\t<td width=23% class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t  \n\t\t\t   <td width=5% ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" nowrap style=\"background-color:";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t   ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t      <td width=5% class=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">&nbsp;";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t \n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t<td width=5% class=\'OARED\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<td width=5% class=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t</TR>\n</table>\n\t<table>\n<tr>\n<td>\n\t\n\n\t\n</td>\n</tr>\n</table>\n\n\t\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' >\n\t\t\t<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' >\n\t\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' >\n\t\t\t<input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' >\n\t\t\t<input type=\'hidden\' name=\'from_time\' id=\'from_time\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' >\n\t\t\t<input type=\'hidden\' name=\'to_time\' id=\'to_time\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t\t\t<input type=\'hidden\' name=\'clinic_date\' id=\'clinic_date\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n\t\t\t<input type=\"hidden\" name =\"care_locn_ind\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<input type=\"hidden\" name =\"res_class\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\n\t\t\t<!-- Added for ML-BRU-CRF-0628.1 -->\n\t\t\t<input type=\"hidden\" name=\"p_o_ext_slot_status\" id=\"p_o_ext_slot_status\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_o_reserved_slot_dtls\" id=\"p_o_reserved_slot_dtls\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_o_appt_slot_dtls\" id=\"p_o_appt_slot_dtls\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_o_block_slot_dtls\" id=\"p_o_block_slot_dtls\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_o_break_slot_dtls\" id=\"p_o_break_slot_dtls\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=\"hidden\" name=\"isSlotStartMidEndAppl\" id=\"isSlotStartMidEndAppl\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<!-- End ML-BRU-CRF-0628.1 -->\n\n</form>\n\n<script>\n\t\n\t/* Added for ML-BRU-CRF-0628.1 */\n\tif (document.forms[0].isSlotStartMidEndAppl.value==\'true\'){\n\t\n\t\tvar ext_slt=document.forms[0].p_o_ext_slot_status.value;\n\t\tvar res_slt=document.forms[0].p_o_reserved_slot_dtls.value;\n\t\tvar appt_slt=document.forms[0].p_o_appt_slot_dtls.value;\n\t\tvar blk_slt=document.forms[0].p_o_block_slot_dtls.value;\n\t\tvar brk_slt=document.forms[0].p_o_break_slot_dtls.value;\n\n\n\t\tvar ext_slot_arr=ext_slt.split(\"|\");\n\t\tvar res_slot_arr=res_slt.split(\"|\");\n\t\tvar appt_slot_arr=appt_slt.split(\"|\");\n\t\tvar blk_slot_arr=blk_slt.split(\"|\");\n\t\tvar brk_slot_arr=brk_slt.split(\"|\");\n\n\n\t\tfor(var i=0;i<=ext_slot_arr.length;i++){\n\t\t\t\n\t\t\tif(ext_slot_arr[i]==\'Y\') {\n\n\t\t\t\tif(blk_slot_arr[i]==\'N\' && brk_slot_arr[i]==\'N\') {\n\t\t\t\t\tif(res_slot_arr[i] !=\'N\'){\n\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(0).style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(1).style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(0).style.Color = \"Black\";\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(1).style.Color = \"Black\";\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(2).style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(2).innerText = \"BRU Health Reservation : \"+res_slot_arr[i];\n\n\t\t\t\t\t}else {\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(0).style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(1).style.backgroundColor = \"Bisque\";\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t}\n\t}\n\t/* End ML-BRU-CRF-0628.1 */\n\t</script>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n   \n\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\n\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con = null; 
			CallableStatement statement=null;
			ResultSet rs = null;
			Statement stmtsd=null;
			PreparedStatement stmtps=null;
			ResultSet rsps=null;
			CallableStatement cstmt = null;

			String blkStatus="";
			String blkRemark="";
			String clinic_date="";
			String nowarp1 ="";
			//jit
			String holdArr[]=new String[5];
			ArrayList arrLst=new ArrayList();
			String tmp_Hld_var="";
	
			//Below variable declare for this  [Bru-HIMS-CRF-177]	
	String colour_indicator="",  vist_code=""; 

	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	String schedule_extend_yn="N";

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	 Boolean isSlotStartMidEndAppl = false;
	 String p_o_ext_slot_status = "";
	 String p_o_reserved_slot_dtls = "";
	 String p_o_appt_slot_dtls = "";
	 String p_o_block_slot_dtls = "";
	 String p_o_break_slot_dtls = "";

try
{

			con=ConnectionManager.getConnection(request);

			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			String date=(String)request.getParameter("Date");
			String clinic_code=(String)request.getParameter("clinic_code");
			String pat_id1=request.getParameter("patient_id");
			String locale = (String)session.getAttribute("LOCALE");
			String care_locn_ind=request.getParameter("care_locn_ind");
			String res_class=request.getParameter("res_class");
			
			

			String care_locn_ind_desc="";
			if(care_locn_ind.equals("C")){
				care_locn_ind_desc="Clinic";
			}else if(care_locn_ind.equals("E")){
				care_locn_ind_desc="Procedure Unit";
			}else if(care_locn_ind.equals("D")){
				care_locn_ind_desc="Day Care Unit";
			}

			String res_class_desc="";
			if(res_class.equals("P")){
				res_class_desc="Practitioner";
			}else if(res_class.equals("E")){
				res_class_desc="Equipment";
			}else if(res_class.equals("R")){
				res_class_desc="Room";
			}else if(res_class.equals("O")){
				res_class_desc="Others";
			}else if(res_class.equals("B")){
				res_class_desc="Bed";
			}


			String practitioner_id=(String)request.getParameter("practitioner_id");
				if( practitioner_id == null|| practitioner_id.equals("null")) practitioner_id="";
			String facilityid=(String)session.getValue("facility_id");

			String P_O_CLINIC             ="";
			String P_O_PRACTITIONER       ="";
			String P_O_MAX_PAT            ="";
			String P_O_MAX_OVER_BOOK      ="";
			String P_O_BOOKED             ="";
			String P_O_OVER_BOOKED        ="";
			String P_O_OVER_BOOKING       ="";
			String P_O_TIME_TAB_TYPE     ="";
			String P_O_STATUS             ="";
			String P_O_FROM_TIME          ="";
			String P_O_TO_TIME            ="";
			String P_O_APPT_REF_NO        ="";
			String P_O_PATIENT_NAME       ="";
			String P_O_PATIENT_ID       ="";
			String P_O_END_TIME= "";
			String P_O_VISIT_TYPE_IND     ="";
			String P_O_NO_OF_SLOTS= "";
			String P_O_Max_Forced= "";
			String P_O_Total_Forced= "";
			String P_O_Max_Global= "";
			String P_O_Total_Global= "";
			String P_APPT_OTH_DTL="";
			
			String P_O_VISIT_TYPE_CODE="";  //Added Bru-HIMS- CRF-177

			String u="";
			String u1="";
	
				PreparedStatement pstmtststus=null;
				ResultSet rsststus=null;
				//String sqlStat="SELECT NVL(Schedule_status,'A') Schedulestatus,Remarks, schedule_extend_yn FROM OA_CLINIC_SCHEDULE WHERE care_locn_type_ind='"+care_locn_ind+"' and resource_class='"+res_class+"' and Facility_id=? AND clinic_date=TO_DATE(?,'dd/mm/yyyy') AND clinic_code=? AND nvl(practitioner_id,'x')=nvl(?,'x')";
				String sqlStat="SELECT NVL(Schedule_status,'A') Schedulestatus,Remarks, schedule_extend_yn FROM OA_CLINIC_SCHEDULE WHERE care_locn_type_ind=? and resource_class=? and Facility_id=? AND clinic_date=TO_DATE(?,'dd/mm/yyyy') AND clinic_code=? AND nvl(practitioner_id,'x')=nvl(?,'x')";

				pstmtststus=con.prepareStatement(sqlStat);
				pstmtststus.setString( 1, care_locn_ind);
				pstmtststus.setString( 2, res_class);
				pstmtststus.setString( 3, facilityid);
				pstmtststus.setString( 4, date);
				pstmtststus.setString( 5, clinic_code);
				pstmtststus.setString( 6, practitioner_id);

				rsststus = pstmtststus.executeQuery();
				if(rsststus !=null)
				{
					rsststus.next();
					blkStatus= rsststus.getString("Schedulestatus");
					blkRemark=rsststus.getString("Remarks");
					schedule_extend_yn=rsststus.getString("schedule_extend_yn");
					if(schedule_extend_yn==null) schedule_extend_yn="N";
				} 

				if(pstmtststus!=null) pstmtststus.close();
				if(rsststus!=null) rsststus.close();

				/* Added for ML-BRU-CRF-0628.1 */
				if(isSlotStartMidEndAppl){
					cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, facilityid );
					cstmt.setString( 2, clinic_code );
					cstmt.setString( 3, practitioner_id );
					cstmt.setString( 4, date );
					cstmt.registerOutParameter( 5, Types.VARCHAR );
					cstmt.registerOutParameter( 6, Types.VARCHAR );
					cstmt.registerOutParameter( 7, Types.VARCHAR );
					cstmt.registerOutParameter( 8, Types.VARCHAR );
					cstmt.registerOutParameter( 9, Types.VARCHAR );

					cstmt.execute() ;

					p_o_ext_slot_status = cstmt.getString( 5 ); 
					if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
					
					p_o_reserved_slot_dtls = cstmt.getString( 6 );
					if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

					p_o_appt_slot_dtls = cstmt.getString( 7 );
					if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

					p_o_block_slot_dtls = cstmt.getString( 8 );
					if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

					p_o_break_slot_dtls = cstmt.getString( 9 );
					if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
				}
				/* End ML-BRU-CRF-0628.1 */


				statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				statement.setString( 1, facilityid);
				statement.setString( 2, date);
				statement.setString( 3, clinic_code);
				statement.setString( 4, practitioner_id);
				statement.setString( 5, care_locn_ind);
				statement.setString( 6, res_class);

				
				statement.registerOutParameter(7, Types.VARCHAR );
				statement.registerOutParameter(8, Types.VARCHAR );
				
				/*
				statement.registerOutParameter(7, Types.CLOB );
				statement.registerOutParameter(8, Types.CLOB );
				*/

				statement.registerOutParameter(9, Types.INTEGER);
				statement.registerOutParameter(10, Types.INTEGER);
				statement.registerOutParameter(11, Types.INTEGER);
				statement.registerOutParameter(12, Types.INTEGER);

				statement.registerOutParameter(13, Types.VARCHAR );
				statement.registerOutParameter(14, Types.VARCHAR );
				statement.registerOutParameter(15, Types.VARCHAR );
				statement.registerOutParameter(16, Types.VARCHAR );
				statement.registerOutParameter(17, Types.VARCHAR );
				statement.registerOutParameter(18, Types.VARCHAR );
				statement.registerOutParameter(19, Types.VARCHAR );
				statement.registerOutParameter(20, Types.VARCHAR );
				statement.registerOutParameter(21, Types.VARCHAR );
				statement.registerOutParameter(22, Types.VARCHAR );
				statement.registerOutParameter(23, Types.VARCHAR );
				statement.registerOutParameter(24 ,Types.VARCHAR );
				statement.registerOutParameter(25 ,Types.VARCHAR );
				statement.registerOutParameter(26 ,Types.VARCHAR );
				statement.registerOutParameter(27 ,Types.VARCHAR );
				statement.registerOutParameter(28 ,Types.VARCHAR );
				statement.registerOutParameter(29 ,Types.VARCHAR );
				statement.registerOutParameter(30 ,Types.VARCHAR );
				statement.registerOutParameter(31 ,Types.VARCHAR );
				statement.registerOutParameter(32 ,Types.VARCHAR );
				statement.registerOutParameter(33 ,Types.VARCHAR );
				
				/*
				statement.registerOutParameter(13, Types.CLOB );
				statement.registerOutParameter(14, Types.CLOB );
				statement.registerOutParameter(15, Types.CLOB );
				statement.registerOutParameter(16, Types.CLOB );
				statement.registerOutParameter(17, Types.CLOB );
				statement.registerOutParameter(18, Types.CLOB );
				statement.registerOutParameter(19, Types.CLOB );
				statement.registerOutParameter(20, Types.CLOB );
				statement.registerOutParameter(21, Types.CLOB );
				statement.registerOutParameter(22, Types.CLOB );
				statement.registerOutParameter(23, Types.CLOB );
				statement.registerOutParameter(24 ,Types.CLOB );
				statement.registerOutParameter(25 ,Types.CLOB );
				statement.registerOutParameter(26 ,Types.CLOB );
				statement.registerOutParameter(27 ,Types.CLOB );
				statement.registerOutParameter(28 ,Types.INTEGER );
				statement.registerOutParameter(29 ,Types.INTEGER);
				statement.registerOutParameter(30 ,Types.INTEGER );
				statement.registerOutParameter(31 ,Types.INTEGER );
				statement.registerOutParameter(32 ,Types.CLOB );
				statement.registerOutParameter(33 ,Types.CLOB );
				*/
				statement.setString( 34, locale);
				
				statement.registerOutParameter(35 ,Types.VARCHAR );
				statement.registerOutParameter(36 ,Types.VARCHAR );
				statement.registerOutParameter(37 ,Types.VARCHAR );
				statement.registerOutParameter(38 ,Types.VARCHAR );
				statement.registerOutParameter(39 ,Types.VARCHAR );
				statement.registerOutParameter(40 ,Types.VARCHAR );
				statement.registerOutParameter(41 ,Types.VARCHAR );
				
				/*
				statement.registerOutParameter(35 ,Types.CLOB );
				statement.registerOutParameter(36 ,Types.CLOB );
				statement.registerOutParameter(37 ,Types.CLOB );
				statement.registerOutParameter(38 ,Types.CLOB );
				statement.registerOutParameter(39 ,Types.CLOB );
				statement.registerOutParameter(40 ,Types.CLOB );
				*/

				statement.execute() ;


				P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
				P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
				P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
				P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
				P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
				P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
				P_O_OVER_BOOKING         =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) 
				P_O_OVER_BOOKING="";
				P_O_TIME_TAB_TYPE          =statement.getString( 14 );if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";
				P_O_STATUS                    =statement.getString(15);if(P_O_STATUS == null) P_O_STATUS="";
				P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

				P_O_TO_TIME                   =statement.getString( 17 );
				if(P_O_TO_TIME == null) P_O_TO_TIME="";


				P_O_APPT_REF_NO         =statement.getString(18 );      
				if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
				P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";

				tmp_Hld_var                       =statement.getString( 20 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[0]=tmp_Hld_var;

				tmp_Hld_var                    =statement.getString( 21 );	if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[1]=tmp_Hld_var;

				tmp_Hld_var    =statement.getString( 22 );        if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[2]=tmp_Hld_var;

				tmp_Hld_var                =statement.getString( 23 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[3]=tmp_Hld_var;

				tmp_Hld_var       =statement.getString( 24 );		if(tmp_Hld_var == null) tmp_Hld_var="";
				holdArr[4]=tmp_Hld_var;
				P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
				P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
				P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

				P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
				P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";

				P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
				P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";

				P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
				
					/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
	P_O_VISIT_TYPE_CODE = statement.getString(35);
	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";	
	//End[Bru-HIMS-CRF-177]
				
				
				
				P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";




			StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
			int counter=token.countTokens();

			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_TO_TIME, "|");

			String to_time[]=new String[counter];
			String end_time ="";
			int tot_token= token.countTokens();

			while (token.hasMoreTokens())
			{
				end_time=token.nextToken();

				if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

					if (tot_token-track == 1) {					
						end_time="00:00";
					}
				}
				
				to_time[track]=end_time;

				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_NAME, "|");
			String patient_name[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_name[track]=token.nextToken();
				track++;
				}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_ID, "|");
			String patient_id[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_id[track]=token.nextToken();
				track++;
				}


			

			// code opt by Jith

			for(int ij=0;ij<holdArr.length;ij++){
				token=null;
				track=0;
				String popArr[]=new String[counter];
				token = new StringTokenizer(holdArr[ij], "|");

				while (token.hasMoreTokens()){
					popArr[track]=token.nextToken();
					track++;
				}
				 arrLst.add(popArr);				 
			}

			// end jith

			token=null;
			track=0;
			token = new StringTokenizer(P_O_APPT_REF_NO, "|");
			String o_appt_ref_no[]=new String[counter];
			while (token.hasMoreTokens())
			{
			o_appt_ref_no[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_STATUS, "|");
			String status[]=new String[counter];
			String status1[]=new String[counter];
			while (token.hasMoreTokens())
			{
			status[track]=token.nextToken();
			status1[track]=status[track];
			track++;
			}
			

			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
			String visit_type_ind[]=new String[counter];
			while (token.hasMoreTokens())
			{
			visit_type_ind[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
			track++;
			}
			
			
			/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");
			String visit_type_code[]=new String[counter];
			while (token.hasMoreTokens())
			{   
				visit_type_code[track]=token.nextToken();
				track++;
				
			}
		//End [Bru-HIMS-CRF-177]	

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String date_val_display =DateUtils.convertDate(date,"DMY","en",locale);
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(date_val_display));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block16Bytes, _wl_block16);


	/*Below Code Added for this CRF [Bru-HIMS-CRF-177] */   
        java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid);			
       // End [Bru-HIMS-CRF-177] 	
		
int maxval=0; String appt_ref_assign_value="";
for (int maxchk = 0; maxchk < o_appt_ref_no.length; maxchk++) 
{
   appt_ref_assign_value=o_appt_ref_no[maxchk];   
   if(!appt_ref_assign_value.equals("~")){
       while(Integer.parseInt(appt_ref_assign_value)>maxval)
       { 
          maxval=Integer.parseInt(appt_ref_assign_value);
       }
   } 
}
// End [Bru-HIMS-CRF-177] 




String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
for(int init=0;init<counter;init++)
{

same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];
}

if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;
if(init==0){
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

u=from_time[init];
u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

String z=status[init];
String z1=status1[init];
String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;


String chk_blank_row_patient=patient_name[init];


if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")){
				if(chk_blank_row_patient.equals("~"))
					{ 
					if(slots > 0)
					 {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( u));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block32Bytes, _wl_block32);
slots--;
						same_appt = "Y";
							}
							else
							{
								if(blkStatus.equals("B")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(u));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
							}
					}
			else
					{

					{
            _bw.write(_wl_block42Bytes, _wl_block42);
if(z1.equals("OL*F")){
						if(blkStatus.equals("B")){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
							if(blkStatus.equals("B")){
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
pat_name = patient_name[init];
						slots--;
					}
					
					}


		}
	else if (z.equals("RN")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(u));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block55Bytes, _wl_block55);
}else
			if (z.equals("VT")){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(u));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block55Bytes, _wl_block55);
} else { 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(u));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(init));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block59Bytes, _wl_block59);
 }

if( ! u1 .equals("~"))

{
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT"))
	{
		if(blkStatus.equals("B")){
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
if(z1.equals("OL*F")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
}
	else
	if(z.equals("RN"))
	{
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
	else
	if(z.equals("BN"))
	{
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
}
else{
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
}


String u2=patient_name[init];//patient name

String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";

	if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(u2));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else	{
			if(same_appt.equals("Y")){
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
		}
	} else {
		if(same_appt.equals("Y")){
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block62Bytes, _wl_block62);
}	else{
			if(z.equals("BN")){
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block79Bytes, _wl_block79);
}else{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
			
		}
	}



for(int kkk=0;kkk<arrLst.size();kkk++){
	String dispArr[]=(String []) arrLst.get(kkk);

	String u3=dispArr[init];
	if( ! u3 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		if(kkk==3){
		 vist_code=checkForNull(visit_type_code[init]);       //this line Added for this CRF [Bru-HIMS-CRF-177]        
		   colour_indicator =checkForNull((String)hm.get(vist_code)); 			
			
			 //if(colour_indicator.equals("") && o_appt_ref_no[init].equals(Integer.toString(maxval))){
			   //  colour_indicator="ORANGE";
			 //  }
			 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block85Bytes, _wl_block85);

		      }else{
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block88Bytes, _wl_block88);
 }		
		}
		else{
            _bw.write(_wl_block89Bytes, _wl_block89);
}
		}
		else{
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
}


            _bw.write(_wl_block2Bytes, _wl_block2);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( clinic_code ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(practitioner_id ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(u));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(clinic_date));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(pat_id1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(care_locn_ind));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(p_o_ext_slot_status));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(p_o_reserved_slot_dtls));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(p_o_appt_slot_dtls));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(p_o_block_slot_dtls));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(p_o_break_slot_dtls));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(isSlotStartMidEndAppl));
            _bw.write(_wl_block108Bytes, _wl_block108);

	if (rs != null) rs.close();
	if (rsps != null) rsps.close();
	if (stmtsd != null) stmtsd.close();
	if (stmtps != null) stmtps.close();
	if (statement != null) statement.close();
	if (cstmt != null) cstmt.close();
	arrLst.clear();
}catch(Exception e) {
	///out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
} 

            _bw.write(_wl_block109Bytes, _wl_block109);
            _bw.write(_wl_block110Bytes, _wl_block110);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contact.label", java.lang.String .class,"key"));
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
}
