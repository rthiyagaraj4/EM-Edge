package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultentrydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultEntryDetail.jsp", 1735051282000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate       \tEdit History      \tName        \t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?             \t100            \t?           \t\tcreated\n26/10/2012    IN032816       Chowminya G     Result Reporting > Record Clinical Note > Mark Error\n04/06/2013    IN001679       Chowminya G\t PACS LIVE issue\n--------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History    Name        \t\tRev.Date\t\tRev.Name \t\tDescription\n--------------------------------------------------------------------------------------------------------------\n05/05/2014\t\tIN048091\t\tKarthi L\t\t\t06/05/2014\t\tRamesh\t\t\tOrders>Existing Orders>Open results \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tscreen>System shows the last modified comments even though the comments were removed.\n08/09/2015\t\tIN057248\t\tVijayakumar K \t\t08/09/2015\t\tRamesh\t\t\tSKR-SCF-1105 [IN:057248]\n15/05/2017\tIN064122\t\tDinesh T\t\t\t\t\t\t\t\t\t\t\t\tHeader Format is missing when header is not having any mandatory fields\n13/06/2021\t  15305\t\t\tNijithaS\t\t\t\t02/04/2021\t\t\t\t\t\tMOHE-SCF-0087-TF\n16/05/2021\t  29803\t\t\tRamesh\t\t\t\t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0635\n--------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/ResultEntry.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCA/js/CAOpenExternalApplication.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onScroll=\"processScroll()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\'checkOnBodyLoad()\'>\n<form name=result_entry_dtl>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<div id=\"divHeadSep\" style=\"position: absolute; width: 100vw\">\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" height=\"\" id=\"tableresult\" class=\"grid\">\n<tr id=\"heading\">\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap colspan=\"2\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td class=columnheader width=\'\' nowrap>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n        ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t<!-- To Show the  Group Record for the Panel  Records-->\n\t\t\n\t\t<tr>\n\t\t\t<!-- Event -->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'><font size=1>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t<img src=\"../images/Authorization.gif\" id=\'id_auth_img_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<img src=\"../images/Authorized.gif\" id=\'id_auth_img_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"getFile(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'OR\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\"><img src=\"../../eCA/images/";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =".gif\" width=\'16\' height=\'16\' border=0 alt=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'></a>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</font>\n\t\t\t</td>\n\n\t\t\t<!-- Result -->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'><font size=1>&nbsp;</font></td>\n\n\t\t\t <!-- Unit -->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><font size=1>&nbsp;</font></td>\n\n\t\t\t<!-- Low Value -->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ><font size=1>&nbsp;</font></td>\n\n\t\t\t<!-- High Value -->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ><font size=1>&nbsp;</font></td>\t\t\t\n\t\t\t<!-- Event  Status -->\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t<select name=\'result_status";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'result_status";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onchange=\'checkStatusChange()\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t</select>\n\t\t\t\t\t\n\t\t\t</td>\n\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'><font size=1 >&nbsp;</font></td>\n\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><font size=1>&nbsp;</font></td>\n\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n\t\t<!-- Show the Events Desc under the  panels(Z) -->\n\t\t\t<tr>\n\t\t\t<!-- Events -->\n\t\t\t\t <td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"><font size=1>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></td>\n\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\t\t<!-- Show the Events Desc under the  panels (Not Z) -->\n\t\t\t<tr>\n\t\t\t<!-- Event -->\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" rowspan=\'2\'><font size=1>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'hidden_auth_reqd_yn";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'hidden_auth_reqd_yn";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' value=\'N\'>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<img src=\"../images/Authorized.gif\" id=\'id_auth_img_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'hidden_auth_reqd_yn";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' value=\'Y\'>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\"><img src=\"../../eCA/images/";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'></a>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t</font></td>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\n\t\t<!-- Record Showing Different <td> both for panel(z ant not Z)\n\t\texcept Record for Group where Panel is Z-->\n\n\n\t\t<!-- Result Type(\"Numeric,List..etc\") -->\n\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"><font size=1>\n\t\t\t\t<input type=\'hidden\' name=\'rslt_type_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'rslt_type_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t<input type=\'hidden\' name=\'mandatory_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'mandatory_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t<input type=\'hidden\' name=\'mandatory_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t</font>\n\t\t</td>\n\n\t\t <!-- If result type is Numeric Paint others <tds> Columns Acc.-->\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\n\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font></td>\n\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"><font size=1>\n\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</font></td>\n\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><font size=1>\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t </font>\n\t\t\t</td>\n\n\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'result_num_uom_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'result_num_uom_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_crit_low_points_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'num_crit_low_points_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_crit_high_points_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'num_crit_high_points_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_crit_low_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'num_crit_low_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_crit_high_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'num_crit_high_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'min_value_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'min_value_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'max_value_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'max_value_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t <!-- If result type is Not Numeric Paint other Columns Acc.-->\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"><font size=1>&nbsp;</font></td>\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\n\n\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n \t\t\t\t ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t <select name=\'result_status";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' onchange=\'checkStatusChange();setPractitionerID(";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =");updateindex(";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =",this)\' ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t</select>\n\n\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'result_status";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' value=\'1\'>\n\t\t\t\t\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t<input type=\'hidden\' name=\'forOT";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'forOT";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t\t</td>\n\n\t\t\t<!-- Event Status-->\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t</td>\n\n\n\t\t\t<!-- Cmts td -->\n\t\t\t<td width=\'\' nowrap class=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t<font size=1>\n\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:viewOrderFormatLineCmts(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\', \'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\')\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t</font>\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<input type=\'hidden\' name=\'result_comments_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'result_comments_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_digits_max_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'num_digits_max_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_digits_min_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' id=\'num_digits_min_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'num_digits_dec_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'num_digits_dec_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'auth_reqd_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' id=\'auth_reqd_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' value=\'N\'>\t<!-- hidden variable to be set when link clicked. -->\n\t\t\t\t<input type=\'hidden\' name=\'auth_reqd_db_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' id=\'auth_reqd_db_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'line_srl_num_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' id=\'line_srl_num_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'parent_srl_no_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' id=\'parent_srl_no_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'msr_panel_id_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' id=\'msr_panel_id_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'msr_id_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' id=\'msr_id_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'order_catalog_code_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' id=\'order_catalog_code_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\n\t\t\t\t<input type=\'hidden\' name=\'proc_link_applicable";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' id=\'proc_link_applicable";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'proc_link_resulting_option";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' id=\'proc_link_resulting_option";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'procedure_code_scheme";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' id=\'procedure_code_scheme";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' value=\'1\'>\n\t\t\t\t<input type=\'hidden\' name=\'term_set_id";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' id=\'term_set_id";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'term_code";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' id=\'term_code";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t\t\t\t<Input type=\'hidden\' name=\'accession_num";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' id=\'accession_num";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n\t\t\t\t<Input type=\'hidden\' name=\'resulted_yn";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id=\'resulted_yn";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t\t\t\n\t\t\t\t\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t<td nowrap class=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t<a class=\'gridLink\' href=\'#\' onclick=\'uploadDocuments(\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\")\'>Upload</a>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t</tr>\n\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t\t<td width=\'\' class=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" wrap colspan=\'8\'>\n\t\t\t\t\t  <label class=\'label\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</label><input type=\'text\' name=\'practitioner_desc";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' id=\'practitioner_desc";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' onBlur=\'clearpractID(\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\");\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' size=26 maxlength=40 onFocus=\'\' ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="  readOnly";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =">\n\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="<input type=\'button\' name=\'practitioner_button";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' id=\'practitioner_button";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' class=\'button\' value=\'?\' onClick=\'show_practitioner_window(practitioner_desc";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =",\"Y\",\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\")\' ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t<input type=\"hidden\" name=\"practitioner_id";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" id=\"practitioner_id";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t\t</td> \n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n<input type=hidden name=\'child_order_index\' id=\'child_order_index\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n<input type=hidden name=\'child_reporting_date\' id=\'child_reporting_date\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n<input type=hidden name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n<input type=hidden name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n<input type=hidden name=\'order_type_code\' id=\'order_type_code\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n<input type=hidden name=\'report_srl_no\' id=\'report_srl_no\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n<input type=hidden name=\'total_auth_imgs\' id=\'total_auth_imgs\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n<input type=hidden name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\n <input type=\"hidden\" name=\"reporting_date\" id=\"reporting_date\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n <input type=\"hidden\" name=\"proc_link_applicable_result\" id=\"proc_link_applicable_result\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n <input type=\"hidden\" name=\"proc_link_resulting_option_result\" id=\"proc_link_resulting_option_result\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n <input type=\"hidden\" name=\"chk_val\" id=\"chk_val\" value=\"\">\n <input type=\"hidden\" name=\"proc_scheme_code\" id=\"proc_scheme_code\" value=\"\">\n\n<Input type=\'hidden\' name=\'requestFrom\' id=\'requestFrom\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n\n<input type=hidden name=\'rpt_pract_id\' id=\'rpt_pract_id\' value=\'\'>\t<!-- report form data -->\n<input type=hidden name=\'rpt_authreq_yn\' id=\'rpt_authreq_yn\' value=\'\'>\t<!-- report form data -->\n<input type=hidden name=\'rpt_authreq_yn_db\' id=\'rpt_authreq_yn_db\' value=\'\'>\t<!-- report form data -->\n<input type=hidden name=\'rpt_result_status\' id=\'rpt_result_status\' value=\'\'>\t<!-- report form data -->\n<input type=hidden name=\'rpt_result_type\' id=\'rpt_result_type\' value=\'\'>\t<!-- report form data -->\n<input type=\"hidden\" name=\'rpt_Order_Status\' id=\'rpt_Order_Status\' value=\'\'>\t<!-- report form data -->\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\t<!-- data required for bean -->\n<input type=hidden name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'>\t<!-- data required for bean -->\n<input type=hidden name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\t\t<!-- data required for bean -->\n<input type=hidden name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>\t\t<!-- data required for bean -->\n<input type=hidden name=\'parent_order_id\' id=\'parent_order_id\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\t<!-- parent_order_id used only in the case refered from Task List it\'s value is setted from the js -->\n<Input type=\'hidden\' name=\'order_set_id\' id=\'order_set_id\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n<Input type=\'hidden\' name=\'order_set_bill_yn\' id=\'order_set_bill_yn\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n<Input type=\'hidden\' name=\'ordCatLinked\' id=\'ordCatLinked\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n<Input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n<Input type=\'hidden\' name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n<!--Added By Sridhar Reddy on 01/060/2010 for PMG20089-CRF-0804-->\n<Input type=\'hidden\' name=\'result_modify_yn\' id=\'result_modify_yn\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n<!--End-->\n</table>\n</div>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\n<script>\n\t/*if(parent.ResultEntryHeader.document.getElementById(\"tableheader\")==null)\n\t{\n\t\tsetTimeout(\"alignHeading();\",300);\n\t}\n\telse \n\t\talignHeading();*/\n</script>\n\n</form>\n</body>\n<script>\ncheckStatusChange();\n//alignWidth();\n</script>\n</html>\n";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String option_id = request.getParameter( "option_id" ) ;
	if (option_id == null) 
	option_id = "";
	/* Mandatory checks start */
	String disab="";
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String facility_id = (String)session.getValue("facility_id");	
	String practitioner_id = (String)session.getValue("ca_practitioner_id");	
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
	//String task_type=request.getParameter("task_type");
	String orderId = request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num")==null?"1":request.getParameter("order_line_num");
	int index= Integer.parseInt(order_line_num)-1;
	if((order_line_num==null)||(order_line_num.equals("null"))) order_line_num="";	 

	/**
		modified by Deepa on 13/05/2010 for IN021020
		added sex,dob to handle multiple reference range
	**/	
	String sex = request.getParameter("sex") == null ? "A" : request.getParameter("sex");	
	String dob = request.getParameter("dob")== null ? "" : request.getParameter("dob");	

//	out.println("<script>alert('sex from res reporting ="+sex+"=');</script>");
	//out.println("<script>alert('dob from res reporting ="+dob+"=');</script>");

	String[] resportsrlno =null;
	String order_type_code = "";
	String patient_class = "";
	String requestFrom = request.getParameter("requestFrom");	
	String reportSrlNo = request.getParameter("report_srl_no");
	String child_order_index = request.getParameter("child_order_index");
	String child_reporting_date = request.getParameter("child_reporting_date");
	String patient_id = request.getParameter("patient_id");	
	String pat_class = request.getParameter("patient_class");
	String encounter_id = request.getParameter("encounter_id");
	String order_category=request.getParameter("order_category");	
	String order_status=request.getParameter("order_status");//--[IN032816]
	 
	String from=request.getParameter("from");
	String result_modify_yn = "N";
	if (from == null) 
	from = "";
	//String resultReportingURL = request.getQueryString();
	// String freqExplApplies = request.getParameter("freqExplApplies");
	//String pract_idfrom_db=request.getParameter("pract_idfrom_db");
	String performed_only = request.getParameter("performed_only")==null?"":request.getParameter("performed_only");	
	
	String parent_order_id=request.getParameter("parent_order_id")==null?"":request.getParameter("parent_order_id");
	String current_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
	String func_type	= request.getParameter("func_type");
	if (func_type == null) func_type = "";
	int total_auth_imgs = 0;

	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id,bean_name ,request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	//bean.setFunc_type(func_type);	
	//bean.setRequestResponse(request,response);
	bean.setSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
	Boolean uploadFuncTrOrders = bean.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS") && "TR".equals(order_category);
	
	bean.setSiteSpecific("CRIT_ABNOR_TR_DP_CATEGORY");  //29803
	Boolean citicalAbrnobalYN = bean.isSiteSpecific("CRIT_ABNOR_TR_DP_CATEGORY") && ("TR".equals(order_category)|| "RX".equals(order_category)); //29803
	
	bean.setSiteSpecific("PRELIM_RESULT_STATUS");  //29803
	Boolean prelimResultYN  = bean.isSiteSpecific("PRELIM_RESULT_STATUS") && ("TR".equals(order_category)|| "RX".equals(order_category)); //29803

	if(child_order_index==null)
	{
		child_order_index =    request.getParameter("TLchild_order_index")==null?"":request.getParameter("TLchild_order_index");    
		child_reporting_date = request.getParameter("TLchild_reporting_date")==null?current_date:request.getParameter("TLchild_reporting_date"); 
		child_order_index="";
	}
	//if(child_reporting_date==null || child_reporting_date.equals(null) || child_reporting_date.equals("")){
		child_reporting_date = current_date;
	//}

	if(requestFrom==null)	requestFrom="";
	if(reportSrlNo==null)
	{
			resportsrlno = bean.getReportSrlNo(orderId,order_line_num);
		
		reportSrlNo = resportsrlno[0];
		if(resportsrlno[1].equals("3") && !requestFrom.trim().equalsIgnoreCase("FE"))
		{			
			int temp = Integer.parseInt(reportSrlNo);
			temp++;
			reportSrlNo = Integer.toString(temp);
	
		}
	}
		allValues = bean.getSearchDetails(orderId,order_line_num);
		
	bean.CultureTestRecordSync(orderId, order_line_num);
	String slClassValue = "";
	String proc_link_applicable				= "";
	String reporting_date					= "";
	String proc_link_resulting_option       = "";
	String note_status 			= "";
//	String chart_result_type		= "";
//	String chart_result_type_desc	= "";
//	String procedure_code			= "";
	//Gives the result status
	String[] headerDetails = new String[5];
	headerDetails = bean.getHeaderLineDetails(orderId, order_line_num);
	String readonly = "";	// for making the elements readonly if reports result_status is 3 (completed)
	String disabled = "";	// for making the elements readonly if reports result_status is 3 (completed)
//	String readonly2 = "";	// for making result_status and type readonly if the request comes from Report Authorization.
	String disabled2 = "";	// for making result_status and type readonly if the request comes from Report Authorization.
	if(requestFrom.trim().equalsIgnoreCase("RA"))
	{	// Since the request is comming from Report Authorization so only this rule will apply and no other readonly rule will apply.
//		readonly2 = "readonly";
		disabled2 = "disabled";
	}
	else if(headerDetails[1].equals("3"))
	{	// Reports result status is completed so make all the elements readonly
		readonly = "";
		disabled = "";
	}
	if(requestFrom.trim().equalsIgnoreCase("RA"))
		mode = "2";
	else
		mode = bean.returnMode(orderId,order_line_num);

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		if(uploadFuncTrOrders)
		{
		
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		
            _bw.write(_wl_block15Bytes, _wl_block15);

	boolean showedGroup = false;
	int groupItem = 0;
	String strPanels = null;
	String order_set_bill_yn="";
	String order_set_id="";
	String default_value = "";
	String ordCatLinked="";
	String normabnormind = "";
    int flag[] = new int[allValues.size()];

	for(int i=0; i<allValues.size(); i++){
		
		String[] record = new String[36];
		record = (String [])allValues.get(i);
		if(record[23] == null) record[23] = "";
		if(record[23].equals("M"))
		{	if(ordCatLinked.equals("")){
			ordCatLinked=record[21]+"||";//+"~"+record[23];
			}
			else{
			ordCatLinked = ordCatLinked+record[21]+"||";//+"~"+record[23];
			}
		}
		if(!(order_line_num.equals("")) && from.equals("OHResultEntry"))
		{
			if(record[33].equals(order_line_num))
				disab = "";
			else
				disab = "disabled";
		}
		String msr_id = "";
		msr_id = record[3];
		
		slClassValue="gridData";
		String readonly1 = "";	// for making the elements readonly if elements result_status is 3 (completed)
		String disabled1 = "";	// for making the elements readonly if elements result_status is 3 (completed)
		if(record[0] == null) record[0] = "";
		if(record[1] == null) record[1] = "";
		if(record[2] == null) record[2] = "";
		if(record[3] == null) record[3] = "";
		if(record[4] == null) record[4] = "";
		if(record[5] == null) record[5] = "20";
		if(record[6] == null) record[6] = "";
		if(record[7] == null) record[7] = "";
		if(record[8] == null) record[8] = "";
		if(record[9] == null) record[9] = "";
		if(record[10] == null) record[10] = "";
		if(record[14] != null) order_type_code = record[14];
		if(record[15] == null) record[15] = "";
		if(record[16] == null) record[16] = "";
		if(record[17] == null) record[17] = "";
		if(record[18] == null) record[18] = "1";
		if(record[19] == null) record[19] = "";
		if(record[20] == null) record[20] = "";
		if(record[21] == null) record[21] = "";
		if(record[22] == null) record[22] = "";
		if(record[23] == null) record[23] = "";
		if(record[24] == null) record[24] = "";
		if(record[25] == null) record[25] = "";
		if(record[26] == null) record[26] = "";
		reporting_date = record[26];
		if(record[27] == null) record[27] = "";
		if(record[28] == null) record[28] = "";
		if(record[29] == null) record[29] = "";
		if(record[30] == null) record[30] = "";
		if(record[31] == null) record[31] = "";
		if(record[32] == null) record[32] = "N";
		if(record[33] == null) record[33] = "";
		if(record[34] == null) record[34] = "";
		if(record[35] == null) record[35] = "";
		//Added by Sridhar Reddy on 01/060/2010 For PMG20089-CRF-0804
			if(record[18].trim().equals("3"))
			{
				result_modify_yn = "Y";
			}
		//End 
		order_set_id=(String)record[35];
		order_set_bill_yn=(String)bean.getOrderSetDetails(record[35]);
		//--[IN032816]
				
		note_status = bean.getNtStat(record[27]);
		// 15305 Start.
		//order_status = bean.getOrderStat(orderId);
		order_status = bean.getOrderStat(orderId,order_line_num);
		// 15305 End.
		//--[IN032816]

		if((!record[22].equals("")) && (!record[22].equals("X")) && (!record[22].equals("P")) && (!record[22].equals("C"))) 
		{
			proc_link_applicable		= record[22];
		}
		if((!record[23].equals("")) && (!record[23].equals("O")))
		{
			proc_link_resulting_option	= record[23];
		}
		if(proc_link_applicable==null) proc_link_applicable="";
		if(proc_link_resulting_option==null) proc_link_resulting_option="";

//		String [] chartRecord		= bean.getProcedureCode(orderId,record[12].trim());
//		chart_result_type			= bean.checkForNull(chartRecord[0],"");
//		chart_result_type_desc		= bean.checkForNull(chartRecord[1],"");
//		procedure_code				= bean.checkForNull(chartRecord[2],"");

		if(record[18].equals("3") && !requestFrom.trim().equalsIgnoreCase("RA") && !performed_only.equals("Y"))
		{
			readonly1 = "readonly";
			disabled1 = "disabled";
		}
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);

		
		String temp_img=bean.getValueForImg(((String)session.getValue("facility_id")),orderId,record[13].trim());
		String histrectype=""; 
		if (order_category.equals("TR"))
			histrectype="TRET";
		else if(order_category.equals("NC"))
			histrectype="NCIN";
		else if(order_category.equals("PC"))
			histrectype="PTCR";
		else if(order_category.equals("RX"))
			histrectype="RXIN";
		else if(order_category.equals("RD"))
			histrectype="RDIN";
		else if(order_category.equals("LB"))
			histrectype="LBIN";
	
		if(record[0].equals("Z")) {//i:e it is Panel
			groupItem++; //No of Child items for that panel

		showedGroup = false;
		if (strPanels == null) {
        	strPanels = record[1];
        } else {
        	java.util.StringTokenizer stoken = new StringTokenizer(strPanels,",");
        	while (stoken.hasMoreTokens()) {
        		if ((stoken.nextToken()).equals(record[1])) {
        			showedGroup = true;
        			break;
        		}
        	}
        	strPanels = strPanels + "," + record[1];
        }

		//Show the Group Record
		if(!showedGroup){
	 			showedGroup=true;
	 			flag[i] = 1;
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(record[11].equalsIgnoreCase("Y")){
					if(record[32].equalsIgnoreCase("N")){
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(total_auth_imgs));
            _bw.write(_wl_block22Bytes, _wl_block22);
		total_auth_imgs++;
					}else if(record[32].equalsIgnoreCase("Y")){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(total_auth_imgs));
            _bw.write(_wl_block22Bytes, _wl_block22);
  }
				}
				if (!temp_img.equals("null") && disab.equals(""))//Added encounter_id in getfile IN001679
				{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(histrectype));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(record[28]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(temp_img));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[29]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(temp_img));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(temp_img));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block34Bytes, _wl_block34);

			if(record[18].equals("3"))
			{
				readonly1 = "readonly";
				disabled1 = "disabled";
			}
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled2));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disab));
            _bw.write(_wl_block40Bytes, _wl_block40);

				if(record[18].trim().equals("1"))
					out.println("<option value='1' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+" </option>");
				else 
					out.println("<option value='1'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+"</option>");
				  
				if(record[18].trim().equals("2"))
					out.println("<option value='2' selected >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				else 
					out.println("<option value='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				if(record[18].trim().equals("3"))
					out.println("<option value='3' selected style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
				else 
					out.println("<option value='3' style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
				//29803 Start.
				if(prelimResultYN){
					if(record[18].trim().equals("4"))
						out.println("<option value='4' selected >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Prelim.label","or_labels")+"</option>");
					else 
						out.println("<option value='4' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Prelim.label","or_labels")+"</option>");
				}
				//29803 End.
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
}//End Show the Group Record for the  Panel
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(record[8].trim().equals("")?"&nbsp;":record[8].trim()));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
			showedGroup=false;
			groupItem=0;
			//msr_id = record[1];
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(record[2].equals("")?"&nbsp;":record[2]));
            _bw.write(_wl_block49Bytes, _wl_block49);
if(record[11].equalsIgnoreCase("Y")){
				if(record[32].equalsIgnoreCase("N")){	
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(total_auth_imgs));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);

					total_auth_imgs++;
				}else if(record[32].equalsIgnoreCase("Y")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(total_auth_imgs));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
 }
			}
			if (!temp_img.equals("null") && disab.equals(""))//Added encounter_id in getfile IN001679
			{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(histrectype));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(record[28]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(temp_img));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[29]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(temp_img));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(temp_img));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block63Bytes, _wl_block63);


				//Numeric
				if(record[4].equals("N") || record[4].trim().equalsIgnoreCase("I")){

					int maxlength = 1;
					if(record[5]==null || record[5].trim().equals(""))
						record[5] = "20";
					/*Added kishore kumar N on Sept-24-09 for ICN 14360*/
					maxlength = Integer.parseInt(record[5]);
					if(record[7].equals("") || record[7].equals("0")) {						
						record[7] = "0";
					} 

					if((record[4].trim().equalsIgnoreCase("I"))||(record[4].trim().equalsIgnoreCase("N")))
					{
						String[] dft_value = new String[8];
						dft_value = bean.getNumericResultTypeDetails(msr_id,sex,dob);
						default_value = bean.checkForNull(dft_value[5]);
					}
					if(record[4].trim().equalsIgnoreCase("I"))
					{
						record[15] = bean.checkForNull(record[15]);			
						if(record[15].equals("")){record[15]=default_value;}
						if(record[15].length() > Integer.parseInt(record[5]))
							record[15] = "";
						out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' maxLength='"+record[5]+"' value='"+record[15].trim()+"' onKeyPress=\"return checkValid(this,window.event,"+record[5]+","+record[7]+")\" size='5' class='NUMBER' onblur=\"checkNumericResult('"+i+"','"+record[2]+"');setPractitionerID("+i+");\" "+readonly+" "+readonly1+" "+disab+">");
					}
					else if(record[4].trim().equalsIgnoreCase("N"))
					{
						record[15] = bean.checkForNull(record[15]);						
						if(record[15].equals("")){record[15]=default_value;}
						if(record[15].length() > Integer.parseInt(record[5]))
							record[15] = "";
						//IN064122, starts
						int l_max_length  = Integer.parseInt(record[5])+1+Integer.parseInt(record[7]);
						//out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' maxLength='"+record[5]+"' value='"+record[15].trim()+"' onKeyPress=\"return checkValid(this,window.event,"+record[5]+","+record[7]+")\" size='5' class='NUMBER' onblur=\"checkNumericResult('"+i+"','"+record[2]+"');setPractitionerID("+i+");\" "+readonly+" "+readonly1+" "+disab+">");
						out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' maxLength='"+l_max_length+"' value='"+record[15].trim()+"' onKeyPress=\"return checkValid(this,window.event,"+l_max_length+","+record[7]+")\" size='5' class='NUMBER' onblur=\"checkNumericResult('"+i+"','"+record[2]+"');setPractitionerID("+i+");\" "+readonly+" "+readonly1+" "+disab+">");
						//IN064122, ends
					}

					/*ends here.*/

				}
				else if(record[4].equals("L")){//List
					boolean notselected = true;
					ArrayList listItems = bean.getListResultTypeDetails(record[3]);
					out.println("<select name='result_"+i+"' id='result_"+i+"' onchange='onListChange("+i+");setPractitionerID("+i+");' "+disabled+" "+disabled1+" "+disab+">");
					out.println("<option>-- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --</option>");
					if(listItems!=null)
					for(int k=0; k<listItems.size(); k++)
					{
						String[] listValues = new String[4];
						listValues = (String[])listItems.get(k);
						if(record[16].trim().equalsIgnoreCase(listValues[0].trim()))
						{
							out.println("<option value='"+listValues[0]+"' selected>"+listValues[0]+"</option>");
							notselected = false;
						}
						else if(listValues[1]!=null && listValues[1].equalsIgnoreCase("Y") && notselected)
							out.println("<option value='"+listValues[0]+"' selected>"+listValues[0]+"</option>");
						else
							out.println("<option value='"+listValues[0]+"'>"+listValues[0]+"</option>");
					}
					out.println("</select>");

				}else if(record[4].equals("T")){ //Time
					out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[16]+"' onKeyPress=\"enterCheck()\" onblur=\"checkTime(this,' "+i+" ');setPractitionerID(' "+i+" ');\" ' size='5' maxlength='5' "+readonly+" "+readonly1+" "+disab+">");

				}else if(record[4].equals("F") && disab.equals("")) {//Hyper Link
		
					//out.println("<script>alert('"+(!(chart_result_type.equals("D") || chart_result_type.equals("P")))+","+record[4]+"')</script>");
					//if (!(chart_result_type.equals("D") || chart_result_type.equals("P") || chart_result_type.equals(""))) {
					//	out.println("<a href=\"javascript:viewCultureTest('"+record[10]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"','"+orderId+"','"+reportSrlNo+"','"+chart_result_type+"','"+chart_result_type_desc+"')\">"+chart_result_type_desc+"</a>");
					//} else {
						//out.println("<script>alert('in')</script>");
						out.println("<a class='gridLink' href=\"javascript:viewResultTemplate('"+record[10]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels")+"</a>");
						
				
					//}
					out.println("<input type='hidden' name='result_"+i+"' id='result_"+i+"' value='"+record[17]+"'>");

				/*} else if(record[4].equals("K")) {//result_type --> K --> Template
  						out.println("<a href=\"javascript:viewTemplate('"+record[10]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"','"+orderId+"','"+reportSrlNo+"','"+record[4]+"')\">Result</a>");
						out.println("<input type='hidden' name='result_"+i+"' id='result_"+i+"' value='"+record[17]+"'>");
				*/
				 
				}else if(record[4].equals("Q") && disab.equals("")) {//result_type --> Q --> Matrix Hyper Link
						//out.println("<script>alert('record[4] ="+record[4]+"')</script>");
						//out.println("<script>alert('"+record[8]+"')</script>");

						out.println("<a class='gridLink' href=\"javascript:viewCultureTest('"+record[3]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"','"+orderId+"','"+order_line_num+"','"+record[3]+"','"+sex+"','"+dob+"','"+index+"')\">"+record[8]+"</a>");
						out.println("<input type='hidden' name='result_"+i+"' id='result_"+i+"' value='"+record[17]+"'>");
				
				}else if(record[4].equals("C")) {//Check Box
					if(record[16].equalsIgnoreCase("Y"))
						out.println("<input type='checkbox' name='result_"+i+"' id='result_"+i+"' value='Y' checked onchange=\"javascript:onCheckBoxResultChange('"+i+"');setPractitionerID('"+i+"');\" "+disabled+" "+disabled1+" "+disab+">");
					else out.println("<input type='checkbox' name='result_"+i+"' id='result_"+i+"' value='Y' onclick=\"javascript:onCheckBoxResultChange('"+i+"');setPractitionerID('"+i+"');\""+disabled+" "+disabled1+" "+disab+">");

				}else if(record[4].equals("E")){//Text Date-time
					out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[16]+"' onKeyPress=\"enterCheck()\" onblur=\"checkreDateTime(this,'"+i+"');setPractitionerID('"+i+"');\" size='9' maxlength='16' "+readonly+" "+readonly1+" "+disab+">");

				}else if(record[4].equals("D")){ //Text Date
					out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[16]+"' onKeyPress=\"enterCheck()\" onblur=\"checkDate(this,'"+i+"');setPractitionerID('"+i+"');\" size='9' maxlength='10' "+readonly+" "+readonly1+" "+disab+">");
				}else if(record[4].equals("X") && disab.equals("")) {//result_type --> X --> Clinical Notes Hyper Link //--[IN032816]
						out.println("<a class='gridLink' id='note_hyper"+i+"' href=\"javascript:callClinicalNotes('"+record[3]+"','"+patient_id+"','"+pat_class+"','"+encounter_id+"','"+orderId+"','"+order_status+"','"+i+"','"+record[27]+"','"+note_status+"','"+performed_only+"','"+facility_id+"','"+practitioner_id+"','"+response.encodeURL("../../eCA/jsp/RecClinicalNotesModal.jsp")+"',document.all)\">"+record[8]+"</a>");
						//out.println("<a class='gridLink' id='note_hyper"+i+"' href=\"javascript:callClinicalNotes('"+record[3]+"','"+patient_id+"','"+pat_class+"','"+encounter_id+"','"+orderId+"','"+i+"','"+record[27]+"','"+performed_only+"','"+facility_id+"','"+practitioner_id+"','"+response.encodeURL("../../eCA/jsp/RecClinicalNotesModal.jsp")+"',document.all)\">"+record[8]+"</a>");
						
				}else if(record[4].equals("*")) 
				{//result_type --> * --> Charting Hyper Link
					
  						out.println("<a class='gridLink' id='chart_hyper"+i+"' href=\"javascript:callCharting('"+record[3]+"','"+patient_id+"','"+pat_class+"','"+encounter_id+"','"+orderId+"','"+i+"','"+record[27]+"','"+record[33]+"','"+record[34]+"','"+response.encodeURL("../../eCA/jsp/ChartRecording.jsp")+"')\">"+record[8]+"</a>");
				}

			if(record[9].equalsIgnoreCase("Y")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
}else{
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block67Bytes, _wl_block67);

			if(record[4].trim().equalsIgnoreCase("N") || record[4].trim().equalsIgnoreCase("I"))
			{
				String[] record1 = new String[8];
				record1 = bean.getNumericResultTypeDetails(msr_id,sex,dob);

				for(int j=0; j<record1.length; j++)
					if(record1[j]== null) record1[j]="";
					double max_val	= 0;
					double min_val	= 0;
					if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
					if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);
					
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.chkReturn(record1[0].trim(),"",
			 "&nbsp;",record1[0].trim())));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
//if(record1[1].trim().equals("0") && record1[2].trim().equals("0"))
				if((max_val == 0.0) && (min_val == 0.0))
				out.print("&nbsp;");
			  else out.print(record1[1].trim());
			
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
//if(record1[1].trim().equals("0") && record1[2].trim().equals("0"))
				if((max_val == 0.0) && (min_val == 0.0))
					out.print("&nbsp;");
				else 
					out.print(record1[2].trim());
			
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[0].trim()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[1].trim()));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[2].trim()));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[3].trim()));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[4].trim()));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[6].trim()));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record1[7].trim()));
            _bw.write(_wl_block88Bytes, _wl_block88);
	if(!record[15].trim().equals(""))
				{
					if((!record1[1].equals("") && Float.parseFloat(record1[1]) != 0) && (!record1[2].equals("") && Float.parseFloat(record1[2]) != 0) && (!record1[3].equals("") && Float.parseFloat(record1[3]) != 0) &&  (!record1[4].equals("") && Float.parseFloat(record1[4]) != 0))
					{
						if(Float.parseFloat(record[15]) >= Float.parseFloat(record1[3]) && Float.parseFloat(record[15]) < Float.parseFloat(record1[1]))
						{
							normabnormind = "L";
						}
						else if(Float.parseFloat(record[15]) > Float.parseFloat(record1[4]))
						{
							normabnormind = "I";
						}
						else if(Float.parseFloat(record[15]) < Float.parseFloat(record1[3]))
						{
							normabnormind = "K";
						}
						else if(Float.parseFloat(record[15]) > Float.parseFloat(record1[2]) && Float.parseFloat(record[15]) <= Float.parseFloat(record1[4]))
						{
							normabnormind = "H";
						}
					}
					else
					{
						if(!record1[1].equals("") && Float.parseFloat(record1[1]) != 0)
						{	
							if(!record1[3].equals("") && Float.parseFloat(record1[3]) != 0)
							{
								if(Float.parseFloat(record[15]) < Float.parseFloat(record1[3])) 											normabnormind = "K";
								else if((Float.parseFloat(record[15]) >= Float.parseFloat(record1[3]))&&(Float.parseFloat(record[15]) < Float.parseFloat(record1[1])))
									normabnormind = "L";
							}
							else if(Float.parseFloat(record[15]) < Float.parseFloat(record1[1])) normabnormind = "L";
						}

						if(!record1[2].equals("") && Float.parseFloat(record1[2]) != 0)
						{	
							if(!record1[4].equals("") && Float.parseFloat(record1[4]) != 0)
							{
								if(Float.parseFloat(record[15]) > Float.parseFloat(record1[4])) 
									normabnormind = "I";
								else if((Float.parseFloat(record[15]) <= Float.parseFloat(record1[4]))&&(Float.parseFloat(record[15]) > Float.parseFloat(record1[2])))
									normabnormind = "H";	
							}
							else if(Float.parseFloat(record[15]) > Float.parseFloat(record1[2])) normabnormind = "H";					
						}
					}	
					
					if(normabnormind.equals(""))
					{
						if((!record1[1].equals("") && Float.parseFloat(record1[1]) != 0) && (!record1[2].equals("") && Float.parseFloat(record1[2]) != 0))
						{
							if((Float.parseFloat(record[15]) >= Float.parseFloat(record1[1])) && (Float.parseFloat(record[15]) <= Float.parseFloat(record1[2]))) 
								normabnormind = "N";
						}
						else if((!record1[1].equals("") && Float.parseFloat(record1[1]) != 0) && (record1[2].equals("")))
						{
							if(Float.parseFloat(record[15]) >= Float.parseFloat(record1[1])) 
								normabnormind = "N";
						}
						if((record1[1].equals("")) && (!record1[2].equals("") &&  Float.parseFloat(record1[2]) != 0))
						{
							if(Float.parseFloat(record[15]) <= Float.parseFloat(record1[2]))
								normabnormind = "N";
						}
					}
				}
			}
			else
			{
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
            _bw.write(_wl_block49Bytes, _wl_block49);

			if(record[18].equals("3"))
			{
				readonly1 = "readonly";
				disabled1 = "disabled";
			}
			
			if(!showedGroup)//Records other than Panel equal to Z
			{
			
            _bw.write(_wl_block93Bytes, _wl_block93);
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(record[33]));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled2));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disab));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(record[18].trim().equals("1"))
					out.println("<option value='1' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+"</option>");
				  else 
					  out.println("<option value='1'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+"</option>");
				  
				  if(record[18].trim().equals("2") && !record[27].equals("")){
					out.println("<option value='2' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
					//out.println("<script>document.result_entry_dtl.result_status"+i+".disabled = true;</script>");
				  }else if(record[18].trim().equals("2")) 
					  out.println("<option value='2' selected >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				  else out.println("<option value='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				  
				  if(record[18].trim().equals("3"))
					out.println("<option value='3' selected style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
					else out.println("<option value='3' style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
				//29803 Start.
				if(prelimResultYN){
					if(record[18].trim().equals("4"))
						out.println("<option value='4' selected >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Prelim.label","or_labels")+"</option>");
					else 
						out.println("<option value='4' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Prelim.label","or_labels")+"</option>");
				}
				//29803 End.
				
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if (flag[i] != 1) {//if(groupItem!=1)
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
}else{
            _bw.write(_wl_block101Bytes, _wl_block101);
}
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(record[33]));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(record[33]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[18]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);

			if(record[4].equals("N") || record[4].trim().equalsIgnoreCase("I"))
			{
				out.println("<select disabled onChange='checkSrvStatusChange()' name=srv_stat_"+i+" "+disabled+" "+disabled1+" "+disab+">");
				out.println("<option value='' selected></option>");
				if(record[19].trim().equalsIgnoreCase("N") || normabnormind.equals("N"))
					out.println("<option value='N' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
				else	
					out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("L") || normabnormind.equals("L"))
					out.println("<option value='L' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalLow.label","or_labels")+"</option>");
				else	
					out.println("<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalLow.label","or_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("K") || normabnormind.equals("K"))
					out.println("<option value='K' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalLow.label","or_labels")+"</option>");
				else	
					out.println("<option value='K'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalLow.label","or_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("H") || normabnormind.equals("H"))
					out.println("<option value='H' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalHigh.label","or_labels")+"</option>");
				else	
					out.println("<option value='H'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalHigh.label","or_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("I") || normabnormind.equals("I"))
					out.println("<option value='I' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalHigh.label","or_labels")+"</option>");
				else	
					out.println("<option value='I'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalHigh.label","or_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("A"))
					out.println("<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
				else	
					out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
				out.println("</select>");

			}
			else if(record[4].equals("L"))
			{
				disabled = "";
				out.println("<select  onChange='checkSrvStatusChange()' name=srv_stat_"+i+" "+disabled+" "+disabled1+" "+disab+">");
				if(record[19].trim().equalsIgnoreCase("N"))
					out.println("<option value='N' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
				else	
					out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("A"))
					out.println("<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
				else	
					out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("C"))
					out.println("<option value='C' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels")+"</option>");
				else	
					out.println("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels")+"</option>");
				out.println("</select>");
			}
			else
			{
				disabled = "";
				out.println("<select  onChange='checkSrvStatusChange()' name=srv_stat_"+i+" "+disabled+" "+disabled1+" "+disab+">");
				out.println("<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+"</option>"); // selected
				if(record[19].trim().equalsIgnoreCase("N"))
					out.println("<option value='N'  selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
				else	
					out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
				if(record[19].trim().equalsIgnoreCase("A"))
					out.println("<option value='A'  selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
				else	
					out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
				//29803 Start.
				if(citicalAbrnobalYN){
					if(record[19].trim().equalsIgnoreCase("C"))
						out.println("<option value='C' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels")+"</option>");
					else	
						out.println("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels")+"</option>");
				}
				//29803 End.
				out.println("</select>");
			}

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);

				String readonlyFlag="";
				if(!performed_only.equals("Y")){
				 readonlyFlag = readonly+" "+readonly1;
				}
				
            _bw.write(_wl_block107Bytes, _wl_block107);
if(disab.equals("")){
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(readonlyFlag));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
} else {
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block112Bytes, _wl_block112);
String strResultComments 	= "";
					if (record[20] != null && !record[20].equals("")) {
						//strResultComments	= record[20].replace('\"','\n'); // commented for IN048091
						strResultComments	= java.net.URLEncoder.encode(record[20]);// modified for IN048091
					}
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strResultComments));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[5].trim()));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[6].trim()));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[7].trim()));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[11].trim()));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[12].trim()));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[13].trim()));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[1].trim()));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[3].trim()));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[21].trim()));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[27]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((!record[30].equals(""))?"Y":"N"));
            _bw.write(_wl_block149Bytes, _wl_block149);

			if(uploadFuncTrOrders)
			{
			
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);

			}
			
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(record[31]));
            _bw.write(_wl_block159Bytes, _wl_block159);
if(record[18].trim().equals("3")){
            _bw.write(_wl_block160Bytes, _wl_block160);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disab));
            _bw.write(_wl_block161Bytes, _wl_block161);
if(!record[18].trim().equals("3")){
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(disab));
            _bw.write(_wl_block161Bytes, _wl_block161);
}
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(record[30]));
            _bw.write(_wl_block170Bytes, _wl_block170);

}
//IN057248 starts
try 
{
	if(("TaskList").equals(from))
	{
		if((child_order_index == null|| "".equals(child_order_index)) && (parent_order_id == null || "".equals(parent_order_id)))
			child_order_index = bean.getChildOrderIndex(orderId,order_line_num);
			
	}
}
catch(Exception exp_childOrdIndex)
{
	exp_childOrdIndex.printStackTrace();
}
//IN057248 ends

            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(child_order_index));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(child_reporting_date));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(total_auth_imgs));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(reporting_date));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(proc_link_applicable));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(proc_link_resulting_option));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(requestFrom));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf((String)session.getValue("ca_practitioner_id")));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf((String)session.getValue("facility_id")));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(parent_order_id));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(order_set_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(ordCatLinked));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(from));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(result_modify_yn));
            _bw.write(_wl_block199Bytes, _wl_block199);

	if(allValues.size() == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
		
	}else{ 
		
	}

            _bw.write(_wl_block200Bytes, _wl_block200);

putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Result.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LowValue.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighValue.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventStatus.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Comments.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Comments.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReportingPractitioner.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
