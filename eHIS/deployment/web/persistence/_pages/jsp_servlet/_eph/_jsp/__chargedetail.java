package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __chargedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ChargeDetail.jsp", 1709120640877L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--saved on 27th Oct 2005 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" <!-- java.sql.Connection,webbeans.eCommon.ConnectionManager Added for ML-BRU-CRF-0469 [IN:065426] -->\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'type=\'text/css\'></link>\n\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/ChargeDetail.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t</head>\n\t<!-- <body> -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'chargeDetailForm\' id=\'chargeDetailForm\'>\n\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'7\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'drug_code_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'drug_code_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'fluid_yn_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'fluid_yn_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'N\'>\n\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<td class=\'label\'  id=\'bl_included_IE_gif_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t<!-- <input type=\'checkbox\' name=\'bl_overide_yn_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'bl_overide_yn_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onclick=\"assignOverrideExclInclInd(this,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\"> -->\n\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"bl_overide_yn_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onchange=\"assignOverrideExclInclInd(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\"  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t\t\t\t\t\t\t\t\t   <option value=\"SEL\">---";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="---</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' readonly size=\'26\'>\n\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_reason_lkp_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"bl_overriden_reason_lkp_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'bl_override_reason_code_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_gross_amt_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_charge_amt_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_patient_payable_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'label\' id=\'bl_apprvl_reqd_gif_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'></td>\n\t\t\t\t\t\t\t\t<td class=\'label\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">\n\n\t\t\t\t\t\t\t\t\t\t   <option value=\"\">---";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="---</option>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' value=\'\' >\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'drug_code_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'fluid_yn_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' value=\'Y\'>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&nbsp;";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' id=\'bl_included_IE_gif_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- <input type=\'checkbox\' name=\'bl_overide_yn_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\"> -->\n\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\t\t\t\t\t\t\t\t\t\t\t\t   <option value=\"SEL\">---";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="---</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' readonly size=\'26\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_reason_lkp_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t        <td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_gross_amt_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t        ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_charge_amt_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_patient_payable_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' id=\'bl_apprvl_reqd_gif_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'  id=\'bl_included_IE_gif_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="---</option>\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' value=\'\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<tr height=\'2\'><td colspan=\'8\'>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'drug_code_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'fluid_yn_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' value=\'N\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'  id=\'bl_included_IE_gif_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t<!-- <input type=\'checkbox\' name=\'bl_overide_yn_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\');\"> -->\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =">\n\n\t\t\t\t\t\t\t\t\t\t\t\t   <option value=\"SEL\">---";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' readonly size=\'26\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_reason_lkp_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_gross_amt_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_charge_amt_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_patient_payable_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' id=\'bl_apprvl_reqd_gif_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n                                        <td class=\'label\'  id=\'bl_included_IE_gif_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =">\n\n\t\t\t\t\t\t\t\t\t\t\t\t   <option value=\"\">---";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="---</option>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' value=\'\' >\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t                                      \n\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <input type=\'checkbox\' name=\'bl_overide_yn_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\');\"> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =">\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <option value=\"SEL\">---";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="---</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t       ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"bl_overide_yn_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="---</option>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td> \n\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' value=\'Y\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ocurrance_num_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' id=\'ocurrance_num_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'  id=\'bl_included_IE_gif_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t<!-- \t<input type=\'checkbox\' name=\'bl_overide_yn_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' readonly size=\'26\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_reason_lkp_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_code_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t\t\t\t\t     <td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_gross_amt_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_charge_amt_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' style=\'TEXT-ALIGN:right;\' id=\'bl_patient_payable_";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' id=\'bl_apprvl_reqd_gif_";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =">\n\t\t\t\t\t\t\t\t\t\t\t\t   <option value=\"\">---";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="---</option>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t        </td>\n\t\t\t\t\t\t\t\t\t\t\t\t <td class=\'field\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_reason_desc_";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t<tr height=\'2\'><td colspan=\'8\'>&nbsp;</td></tr>\n\t\t\t\t<tr> \n\t\t\t\t\t<td colspan=\'5\' class=\'data\' align=\'right\'>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t<td class=\'data\' style=\'TEXT-ALIGN:right;\' id=\'bl_tot_gross_amt\'>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t<td class=\'data\'  style=\'TEXT-ALIGN:right;\' id=\'bl_tot_charge_amt\'>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\'data\'  style=\'TEXT-ALIGN:right;\' id=\'bl_tot_patient_payable\'>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr> \n\t\t\t\t\t<td colspan=\'8\'>&nbsp; </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr> \n\t\t\t\t\t<td colspan=\'6\'>&nbsp; </td>\n\t\t\t\t\t<td colspan=\'2\' align=\'right\'><input type=\"button\" value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' class=\"button\" onClick=\"storeOverrideDetail()\">&nbsp;&nbsp;<input type=\"button\" value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' class=\"button\" onClick=\"cancelOverrideDetail()\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"sql_ph_prescription_bl_action_select_lookup\" id=\"sql_ph_prescription_bl_action_select_lookup\" VALUE=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\t\t\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n\t\t\t<input type=\'hidden\' name=\'iv_prep_yn\' id=\'iv_prep_yn\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n\t\t\t<input type=\'hidden\' name=\'rx_order_type\' id=\'rx_order_type\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t\t\t<input type=\'hidden\' name=\'tot_drugs\' id=\'tot_drugs\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n\t\t\t<input type=\'hidden\' name=\'take_home_medication\' id=\'take_home_medication\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t<input type=\'hidden\' name=\'blErrorDrugs\' id=\'blErrorDrugs\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t<input type=\'hidden\' name=\'blErrorDrugs\' id=\'blErrorDrugs\' value=\'\'>\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
 
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		try{
		String locale				= (String) session.getAttribute("LOCALE");
		String sStyle				= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		ArrayList drugList			= new ArrayList();
		HashMap fluidDetails		= new HashMap();
		String bean_id				= request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
		String bean_name			= request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
		String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String actual_patient_class = request.getParameter("actual_patient_class")==null?"":request.getParameter("actual_patient_class");
		String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String rx_order_type		= request.getParameter("rx_order_type")==null?"":request.getParameter("rx_order_type");
		String mfr_yn				= (String)request.getParameter("MFR_YN")==null?"":request.getParameter("MFR_YN");
		String episode_type			= actual_patient_class.substring(0,1);
		String freq_nature_ivpb			= request.getParameter("freq_nature")==null?"":request.getParameter("freq_nature");
		String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		if(episode_type.equals("X"))
			episode_type = "R";

		String durn_value					= "";
		String infusion_over				= "";
		String lstInfusionRateDurnUnit		= "";
		float dur1							= 0.0f;
		HashMap drugDetails					= new HashMap();
		String item_code					= "";
		String drug_code					= "";
		String drug_desc					= "";
		String dosage_type					= "";
		String repeat_value					= "";
		String strength_per_value_pres_uom	= "";
		String strength_per_pres_uom		= "";
		String content_in_pres_base_uom		= "";
		String fract_dose					= "";
		String bl_included_IE				= "";
		String bl_incl_excl_override_value	= "";
		String bl_override_reason_code		= "";
		String bl_override_reason_desc		= "";
		String bl_charge_amt				= "";
		String bl_patient_payable			= "";
		String bl_apprvl_reqd_yn			= "";
		String bl_apprvl_reqd_gif			= "";
		String bl_override_allowed_yn		= "";
		String bl_decimal_format_string		= "#0.00";
		String bl_included_IE_gif			= "";
		String bl_override_checked			= "";
		String bl_override_disable			= "";
		String bl_error_code				= "";
		String bl_sys_message_id			= "";
		String bl_error_text				= "";
		double bl_tot_charge_amt			= 0.0;
		double bl_tot_patient_payable		= 0.0;
		String ordered_qty					= "";
		double iOrdQty						= 0;
		String totalGrossAmountStr          = ""; // Added for ML-BRU-CRF-0469 [IN:065426]
		String tot_payable_sum_str			= "";
		String pat_payable_sum_str			= "";
		String in_formulary_yn				= "";
		String fluid_code					= "";
		String fluid_name					= "";
		String qty_unit						= "";
		String ing_order_uom				= "";
		String order_uom					= "";
		String eqvl_value					= "";
		String include_selected				= "";
	    String exclude_selected				= "";
	    String billable_item_yn				= "";
		HashMap MultiFlowRecs				= new HashMap();
		DecimalFormat dfTest = dfTest = new DecimalFormat(bl_decimal_format_string);
		ArrayList blErrorDrugs				= new ArrayList();
		int drug_index						= 0;
		double totalGrossAmount             = 0.0; // Added for ML-BRU-CRF-0469 [IN:065426] - Strat
		String grossAmount                  = ""; 
		Connection con=null;
		boolean displayGrossAmtYn           = false;
		try{
			con = ConnectionManager.getConnection(request);
			displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
		}
		catch(Exception e){
			e.printStackTrace();
			displayGrossAmtYn = false;
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}  // Added for ML-BRU-CRF-0469 [IN:065426] - End

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
            _bw.write(_wl_block14Bytes, _wl_block14);
if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
} // Added for ML-BRU-CRF-0469 [IN:065426] - End 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);


				if(rx_order_type.equals("MS")){
					ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
					drugList = bean.getPresItemList();
					String selected_yn="";
					
					for (int i=0; i<drugList.size(); i++) {
						drugDetails	= (HashMap)drugList.get(i);
						selected_yn =(String)drugDetails.get("SELECTED_YN")==null?"Y":(String)drugDetails.get("SELECTED_YN");
						if(selected_yn.equals("N"))
							continue;
						item_code				 = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");         
						drug_desc				 = (String)drugDetails.get("ITEM_DESC")==null?"":(String)drugDetails.get("ITEM_DESC");        
						ordered_qty				 = (String)drugDetails.get("QTY_VALUE");
						bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
						billable_item_yn =(String)drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String)drugDetails.get("BILLABLE_ITEM_YN"); 
						if(billable_item_yn.equals("Y")){
							bl_included_IE			    = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
							bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");
							bl_override_reason_code     = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
							bl_override_reason_desc     = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
							bl_charge_amt			    = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");           
							bl_patient_payable		    = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE"); 
                                			bl_apprvl_reqd_yn		    = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
							 if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
								  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
								 } // Added for ML-BRU-CRF-0469 [IN:065426] - End       
							bl_decimal_format_string    = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
							bl_override_allowed_yn	    = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");
							bl_error_code			    = (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
							bl_sys_message_id		    = (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
							bl_error_text			    = (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");

							if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
								blErrorDrugs.add(item_code);
								blErrorDrugs.add(drug_desc);
								blErrorDrugs.add(bl_error_code);
								blErrorDrugs.add(bl_sys_message_id);
								blErrorDrugs.add(bl_error_text);
								bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
								bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
								if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
									grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
								} // Added for ML-BRU-CRF-0469 [IN:065426] - End
							}
							else{
								//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
									bl_tot_charge_amt      += Float.parseFloat(bl_charge_amt);
									bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
								//}
								if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
									totalGrossAmount       += Float.parseFloat(grossAmount); 
								} // Added for ML-BRU-CRF-0469 [IN:065426] - End
								dfTest                  = new DecimalFormat(bl_decimal_format_string);
							}

							if(bl_included_IE.equals("I"))
								bl_included_IE_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
							else if(bl_included_IE.equals("E"))
								bl_included_IE_gif = "<img src='../../eCommon/images/disabled.gif'></img>";
							else
								bl_included_IE_gif = "&nbsp;";

							//commented for BL CRF 0001     
							/*if(!bl_incl_excl_override_value.equals(""))
								bl_override_checked = "checked";
							else
								bl_override_checked = "";

							if(bl_override_allowed_yn.equals("Y"))
								bl_override_disable = "";
							else
								bl_override_disable = "disabled";
							*/

							//added for BL CRF 0001     

							if(bl_override_allowed_yn.equals(""))
								bl_override_disable = "disabled";
							else
								bl_override_disable = "";

							if(!bl_override_reason_desc.equals("")){
								if(bl_incl_excl_override_value.equals("I")){
									include_selected ="selected";
								}
								else if(bl_incl_excl_override_value.equals("E")){
									exclude_selected ="selected";
								}
							}
							// ends here

							if(bl_apprvl_reqd_yn.equals("Y"))
								bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
							else if(bl_apprvl_reqd_yn.equals("N"))
								bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
							else
								bl_apprvl_reqd_gif = "&nbsp;";
						}
						else{
							bl_included_IE		       ="";	   
							bl_incl_excl_override_value="";
							bl_override_reason_code    ="";
							bl_override_reason_desc    =""; 
							bl_charge_amt			   ="";
							bl_patient_payable		   ="";
							bl_apprvl_reqd_yn		   ="";
							bl_decimal_format_string   ="";
							bl_override_allowed_yn	   ="";
							bl_error_code			   ="";
							bl_sys_message_id		   ="";
							bl_error_text			   ="";
							bl_included_IE_gif         = "&nbsp;";
							bl_apprvl_reqd_gif         = "&nbsp;";
						}

						iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(iOrdQty));
            _bw.write(_wl_block26Bytes, _wl_block26);

							if(billable_item_yn.equals("Y")){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_included_IE_gif));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bl_override_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_incl_excl_override_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if(bl_override_allowed_yn.equals("I"))
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
if(bl_override_allowed_yn.equals("E"))
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
if(bl_override_allowed_yn.equals("B")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(grossAmount));
            _bw.write(_wl_block59Bytes, _wl_block59);
} // Added for ML-BRU-CRF-0469 - End 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_charge_amt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_patient_payable));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_apprvl_reqd_gif));
            _bw.write(_wl_block63Bytes, _wl_block63);
								}
							else{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block68Bytes, _wl_block68);
								}

            _bw.write(_wl_block69Bytes, _wl_block69);

							drug_index++;
					}

				}
				else{
					if(!iv_prep_yn.equals("") && (Integer.parseInt(iv_prep_yn)<=6)){
						rx_order_type="IV";
						String iv_calc_infuse_by = request.getParameter("iv_calc_infuse_by")==null?"":request.getParameter("iv_calc_infuse_by");
						drug_index = 0;
						IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
						if(iv_prep_yn.equals("5"))
							drugList = bean.getAllFluids();
						else
							drugList = bean.getDrugDetails();

						if(drugList!=null && drugList.size()>0){
							if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
								//IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
								fluid_code			= request.getParameter("fluid_code")==null?"":request.getParameter("fluid_code");
								//String mfr_yn = (String)request.getParameter("MFR_YN")==null?"":request.getParameter("MFR_YN");
								if(mfr_yn.equals("Y")){
									MultiFlowRecs = bean.getMFRRecs();
									if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
										durn_value= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
										//infuse over wil be same as duration in case of mfr coz flow duration is sum of the infuse over value. 
										infusion_over = durn_value;
										lstInfusionRateDurnUnit = "H";
									}
								}
								else{
									durn_value = request.getParameter("durn_value")==null?"":request.getParameter("durn_value");
									if(iv_calc_infuse_by.equals("I"))
										durn_value = request.getParameter("infusion_over")==null?"":request.getParameter("infusion_over");
									infusion_over = request.getParameter("infusion_over")==null?"":request.getParameter("infusion_over");
									lstInfusionRateDurnUnit = request.getParameter("lstInfusionRateDurnUnit")==null?"":request.getParameter("lstInfusionRateDurnUnit");
								}
								/*if(lstInfusionRateDurnUnit.equals("M")){
									//infusion_over = Float.parseFloat(infusion_over)/60+"";
								}*/
								if(!fluid_code.equals("") && !fluid_code.equals((String)((HashMap)drugList.get(0)).get("DRUG_CODE"))) {
			
									order_uom = bean.getStockUOM(fluid_code);
									fluidDetails = bean.getFluidDetails();
									item_code			= (String)fluidDetails.get("ITEM_CODE")==null?"":(String)fluidDetails.get("ITEM_CODE");
									in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");

									if(in_formulary_yn.equals("Y") /*&& !item_code.equals("")*/){
										ordered_qty		    = (String)fluidDetails.get("ORDERED_QTY");
										repeat_value		= (String)fluidDetails.get("REPEAT_VALUE");
										fluid_name			= (String)fluidDetails.get("DRUG_DESC");
										bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, fluid_code, ordered_qty,take_home_medication );
										billable_item_yn =(String)fluidDetails.get("BILLABLE_ITEM_YN")==null?"":(String)fluidDetails.get("BILLABLE_ITEM_YN"); 
                                        if(billable_item_yn.equals("Y")){
											bl_included_IE = (String)fluidDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_VALUE");          
											bl_incl_excl_override_value = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");       
											bl_override_reason_code = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
											bl_override_reason_desc = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
											if((String)fluidDetails.get("BL_CHARGE_AMT")==null || (String)fluidDetails.get("BL_CHARGE_AMT")=="")
												bl_charge_amt = "0.0";           
											else
												bl_charge_amt =(String)fluidDetails.get("BL_CHARGE_AMT");
											if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
												  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
											} // Added for ML-BRU-CRF-0469 [IN:065426] - End 
											bl_patient_payable = (String)fluidDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)fluidDetails.get("BL_PATIENT_PAYABLE"); 
											bl_apprvl_reqd_yn = (String)fluidDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)fluidDetails.get("BL_APPRVL_REQD_YN");       
											bl_decimal_format_string = (String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING");
											bl_override_allowed_yn = (String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN");
											bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
											bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
											bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");

											if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
												blErrorDrugs.add(fluid_code);
												blErrorDrugs.add(fluid_name);
												blErrorDrugs.add(bl_error_code);
												blErrorDrugs.add(bl_sys_message_id);
												blErrorDrugs.add(bl_error_text);							
												bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
												bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
												if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
													grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
												} // Added for ML-BRU-CRF-0469 [IN:065426] - End
											}
											else{
												//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
													bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
													if(!bl_patient_payable.equals(""))
														bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
												//}
													if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
														totalGrossAmount       += Float.parseFloat(grossAmount); 
													} // Added for ML-BRU-CRF-0469 [IN:065426] - End
												dfTest = new DecimalFormat(bl_decimal_format_string);
											}

											if(bl_included_IE.equals("I"))
												bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_included_IE.equals("E"))
												bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_included_IE_gif = "&nbsp;";

											/*commented for BL CRF 0001
											if(!bl_incl_excl_override_value.equals(""))
												bl_override_checked = "checked";
											else
												bl_override_checked = "";
											
											if(bl_override_allowed_yn.equals("Y"))
												bl_override_disable = "";
											else
												bl_override_disable = "disabled";
											*/
											//added for BL CRF 0001     

											if(bl_override_allowed_yn.equals(""))
												bl_override_disable = "disabled";
											else
												bl_override_disable = "";

											if(!bl_override_reason_desc.equals("")){
												if(bl_incl_excl_override_value.equals("I")){
													include_selected ="selected";
												}
												else if(bl_incl_excl_override_value.equals("E")){
													exclude_selected ="selected";
												}
											}
											// ends here

											if(bl_apprvl_reqd_yn.equals("Y"))
												bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_apprvl_reqd_yn.equals("N"))
												bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_apprvl_reqd_gif = "&nbsp;";
									}
									else{
										bl_included_IE				="";
										bl_incl_excl_override_value	="";
										bl_override_reason_code		="";
										bl_override_reason_desc		="";
										bl_patient_payable			="";
										bl_apprvl_reqd_yn			="";
										bl_decimal_format_string	="";
										bl_override_allowed_yn		="";
										bl_error_code				="";
										bl_sys_message_id			="";
										bl_error_text				="";
										bl_included_IE				="";
										bl_apprvl_reqd_gif			="";
									}
									iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
									if(!fluid_code.equals((String)((HashMap)drugList.get(0)).get("DRUG_CODE"))){

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(fluid_name));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(iOrdQty));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block75Bytes, _wl_block75);
											if(billable_item_yn.equals("Y")){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_included_IE_gif));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bl_override_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_incl_excl_override_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
if(bl_override_allowed_yn.equals("I"))
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(bl_override_allowed_yn.equals("E"))
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(bl_override_allowed_yn.equals("B")){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(grossAmount));
            _bw.write(_wl_block91Bytes, _wl_block91);
} // Added for ML-BRU-CRF-0469 - End 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_charge_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_patient_payable));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_apprvl_reqd_gif));
            _bw.write(_wl_block63Bytes, _wl_block63);

											}
											else{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block100Bytes, _wl_block100);
											
											}

            _bw.write(_wl_block101Bytes, _wl_block101);

											drug_index++;
										}
									}
								}
							}
							for (int i=0; i<drugList.size(); i++) {

								drugDetails	= (HashMap)drugList.get(i);
								HashMap freqNature = null;
								in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
								item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");

								if(item_code.equals(""))
									item_code = (String)drugDetails.get("ORDER_CATALOG_CODE");

								if(in_formulary_yn.equals("Y") && !item_code.equals("")){

									drug_code = (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
									drug_desc = (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");
									order_uom = bean.getStockUOM(drug_code);

									if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
										dosage_type = (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE"); 
										repeat_value = (String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE"); 
										strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
										strength_per_pres_uom = (String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");
										content_in_pres_base_uom = (String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");

										float ing_unit_qty		= Float.parseFloat((String)drugDetails.get("QTY_VALUE"));
										float in_tot_qty = 0.0f;
										fract_dose					=   bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));
										dur1			= Float.parseFloat(durn_value);
										if(mfr_yn.equals("Y")){
											MultiFlowRecs = bean.getMFRRecs();
										}
										if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
											//dur1=dur1/24;
											HashMap freqDet = bean.getscheduleFrequency();
											String freqDurnType = "";
											String freq_code = (String)request.getParameter("freq_code")==null?"":(String)request.getParameter("freq_code");
											freqNature			=(HashMap)bean.freqValidate(freq_code);
											if(freq_nature_ivpb.equals("I")){
												
												freqDurnType =  (String)freqNature.get("interval_durn_type");
											}
											else{
												freqDurnType = (String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"))==null?"":(String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"));
											}
											String durn_unit = (String)request.getParameter("durn_unit")==null?"":(String)request.getParameter("durn_unit");

											if(! freqDurnType.equals(durn_unit)) {
												int durn_calc = bean.getDurationCalc(durn_unit,durn_value,freqDurnType);
												dur1 = Float.parseFloat(durn_calc+"");
											}
											float interval_repeat = Float.parseFloat((String)freqNature.get("interval_value")==null?"1":(String)freqNature.get("interval_value"));
											if(freq_nature_ivpb.equals("I") || (freq_nature_ivpb.equals("F") && interval_repeat > 1 )){
												dur1 = dur1 / interval_repeat;
											}
											repeat_value			= bean.getRepeatValue();
											ing_unit_qty = Float.parseFloat(bean.getDOSAGE());
											//ing_unit_qty = Float.parseFloat(request.getParameter("drug_dosage"));
										}
										else{
											if(iv_calc_infuse_by.equals("I"))
												dur1=1;
											else
												dur1			= Float.parseFloat(Math.ceil(((Float.parseFloat(durn_value) / (Float.parseFloat(infusion_over)))*100)/100)+"");
										}
										if(MultiFlowRecs != null && MultiFlowRecs.size() > 0){
											/*durn_value= (String)MultiFlowRecs.get("totFlowDurnHrs")==null?"":(String)MultiFlowRecs.get("totFlowDurnHrs");
											dur1 = durn_value;*/
											dur1 = 1;
										}

										if(dosage_type!=null){
											if(dosage_type.equals("S")) {				
												strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
												strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");

												if(fract_dose.equals("Y")){
													in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
													//ordered_qty		=   Math.ceil((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
													ordered_qty		=	(new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue()*dur1)+"";
												}
												else if(fract_dose.equals("N")){
													in_tot_qty	= (ing_unit_qty*Float.parseFloat(strength_per_value_pres_uom))/(Float.parseFloat(strength_per_pres_uom)); 
													//ing_order_uom	= (String)drugDetails.get("STRENGTH_UOM");
													ordered_qty		=   ((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
												}
											}
											else {
												qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
												ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
												eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
												if(eqvl_value.equals(""))	eqvl_value	=	"1";	
													in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);
												if(fract_dose.equals("Y")){
													ordered_qty	=   (new Double(Math.ceil(in_tot_qty/Float.parseFloat(content_in_pres_base_uom))).floatValue()*dur1)+"";
												}
												else if(fract_dose.equals("N")){
													ordered_qty	=   ((in_tot_qty*dur1)/Float.parseFloat(content_in_pres_base_uom))+"";
												}
											}	
										}

										if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
											if(freq_nature_ivpb.equals("I")){
												ordered_qty=Math.ceil(Float.parseFloat(ordered_qty))+"";
											}
											else{
												 if(fract_dose.equals("N")){
													 ordered_qty=Math.ceil(Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value))+"";
												}
												else{
													ordered_qty=Float.parseFloat(ordered_qty) * Float.parseFloat(repeat_value)+"";
												}
											}
										}
										drugDetails.put("ORDERED_QTY",ordered_qty);
									}
									else if(iv_prep_yn.equals("5") || iv_prep_yn.equals("6")){
										ordered_qty = (String)drugDetails.get("ORDERED_QTY");
									}
									bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
									billable_item_yn =(String)drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String)drugDetails.get("BILLABLE_ITEM_YN"); 
									if(billable_item_yn.equals("Y")){
										bl_included_IE          = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE"); 
										bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE"); 
										bl_override_reason_code  = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
										bl_override_reason_desc  = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");

										bl_charge_amt            = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");
										bl_patient_payable       = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");  
										bl_apprvl_reqd_yn        = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");
										bl_decimal_format_string = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
										bl_override_allowed_yn   = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");
										if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
											  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
										} // Added for ML-BRU-CRF-0469 [IN:065426] - End 
										bl_error_code			 = (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
										bl_sys_message_id		 = (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
										bl_error_text			 = (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											blErrorDrugs.add(drug_code);
											blErrorDrugs.add(drug_desc);
											blErrorDrugs.add(bl_error_code);
											blErrorDrugs.add(bl_sys_message_id);
											blErrorDrugs.add(bl_error_text);
											bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
												grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
											} // Added for ML-BRU-CRF-0469 [IN:065426] - End
										}
										else{
											//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
												if(!bl_charge_amt.equals(""))
													bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
												if(!bl_patient_payable.equals("")) 
													bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
											//}
												if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
													totalGrossAmount       += Float.parseFloat(grossAmount); 
												} // Added for ML-BRU-CRF-0469 [IN:065426] - End
											dfTest = new DecimalFormat(bl_decimal_format_string);
										}

										if(bl_included_IE.equals("I"))
											bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_included_IE.equals("E"))
											bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_included_IE_gif = "&nbsp;";
										
										/* commented for BL CRF 0001
										if(!bl_incl_excl_override_value.equals(""))
											bl_override_checked = "checked";
										else
											bl_override_checked = "";

										if(bl_override_allowed_yn.equals("Y"))
											bl_override_disable = "";
										else
											bl_override_disable = "disabled";
										*/
									   //done for BL CRF 0001
										 if(bl_override_allowed_yn.equals(""))
												bl_override_disable = "disabled";
										 else
												bl_override_disable = "";
				  
										include_selected="";
										exclude_selected="";
										if(!bl_override_reason_desc.equals("")){
											if(bl_incl_excl_override_value.equals("I")){
												include_selected ="selected";
											}
											else if(bl_incl_excl_override_value.equals("E")){
												exclude_selected ="selected";
											}
										} 

										// ends here
										if(bl_apprvl_reqd_yn.equals("Y"))
											bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_apprvl_reqd_yn.equals("N"))
											bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_apprvl_reqd_gif = "&nbsp;";
								}
								else{
									bl_included_IE				 ="";
									bl_incl_excl_override_value ="";
									bl_override_reason_code		="";
									bl_override_reason_desc		="";
									bl_charge_amt				="";
									bl_patient_payable			="";
									bl_apprvl_reqd_yn			="";
									bl_decimal_format_string="";
									bl_override_allowed_yn="";
									bl_error_code	="";	
									bl_sys_message_id="";	
									bl_error_text	="";
									bl_included_IE_gif="";
									bl_override_disable = "";
									bl_apprvl_reqd_gif = "&nbsp;";
								}
									//Added If condition for  handling Null(Ordered_qty) ===By Sandhya on 11/JAN/2011
									if(ordered_qty==null)									{
										ordered_qty="";
									}
									ordered_qty = ordered_qty.equals("")?"0":ordered_qty;
									
									iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));
//									drugDetails.put("ORDERED_QTY",iOrdQty+"");
//									if(!fluid_code.equals(drug_code)){
//	if(true){

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(iOrdQty));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block75Bytes, _wl_block75);
									if(billable_item_yn.equals("Y")){

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_included_IE_gif));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bl_override_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_incl_excl_override_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
if(bl_override_allowed_yn.equals("I"))
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(bl_override_allowed_yn.equals("E"))
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(bl_override_allowed_yn.equals("B")){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_desc));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start 
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(grossAmount));
            _bw.write(_wl_block115Bytes, _wl_block115);
} // Added for ML-BRU-CRF-0469 - End 
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_charge_amt));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_patient_payable));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_apprvl_reqd_gif));
            _bw.write(_wl_block63Bytes, _wl_block63);
                                 
									}
									else{

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block124Bytes, _wl_block124);
                                  }

            _bw.write(_wl_block125Bytes, _wl_block125);

								//	}
									drug_index++;
								}
							}
						}
					}
					else if(iv_prep_yn.equals("9") || iv_prep_yn.equals("0")){
						OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
						HashMap CompFluidDetails = bean.getCompFluidDetails();

						rx_order_type="ONC";
						drug_index = 0;
						drugList = bean.getDrugDetails();
						String interval_value="";
						String freq_nature="";
						String pack_size="";
						String amend_repeat_value="";
						String amend_durn_value="";
						String qty_value = "";
						String ocurrance_num ="";
						for (int i=0; i<drugList.size(); i++){

							drugDetails	= (HashMap)drugList.get(i);
							if(drugDetails!=null && drugDetails.size()>0){
								in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
								item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");

								if(in_formulary_yn.equals("Y") && !item_code.equals("")){

									drug_code = (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
									ocurrance_num = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
									drug_desc = (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");
									pack_size	= bean.getPackSize(drug_code);	
									dosage_type = (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE"); 
									order_uom	= bean.getStockUOM(drug_code);			

									qty_value = (String)drugDetails.get("dose");
									if(qty_value==null || qty_value.equals(""))
										qty_value = (String)drugDetails.get("QTY_VALUE");

									repeat_value = (String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE");
									
									float ing_unit_qty		= Float.parseFloat(qty_value);
									float in_tot_qty = 0.0f;
									fract_dose					=   bean.getFractDoseRndyn((String)drugDetails.get("DRUG_CODE"));

									strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
									strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
									fract_dose     =(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");	
									interval_value     =(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");
									amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"":(String)drugDetails.get("amend_repeat_value");
									if(amend_repeat_value.equals(""))
										amend_repeat_value=(String)drugDetails.get("REPEAT_VALUE")==null?"1":(String)drugDetails.get("REPEAT_VALUE");
									amend_durn_value=(String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");	
									if(amend_durn_value.equals(""))
										amend_durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
									freq_nature=(String)drugDetails.get("FREQ_NATURE")==null?"F":(String)drugDetails.get("FREQ_NATURE");

									if(dosage_type!=null){
										if(dosage_type.equals("S")) {				

											in_tot_qty	= 0.0f;

											if(fract_dose.equals("Y")){
												in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);
											}
											else{
												//in_tot_qty	=Math.ceil(new Double (ing_unit_qty/Float.parseFloat(strength_per_pres_uom).floatValue()) * Float.parseFloat(strength_per_value_pres_uom));

												in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom) * Float.parseFloat(strength_per_value_pres_uom))).floatValue();

											}
											if (freq_nature.equals("I")) {
												in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
											}
											else if (freq_nature.equals("F") || freq_nature.equals("C")) {

												in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));


											}
											else if (freq_nature.equals("O")) {
												in_tot_qty = in_tot_qty;
											}


										   ordered_qty=in_tot_qty+"";
										   ordered_qty=(Math.ceil(Float.parseFloat(ordered_qty)/Float.parseFloat(pack_size)))+"";


										}
										else{
											qty_unit			= (String)drugDetails.get("QTY_DESC_CODE");
											ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
											eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
											if(eqvl_value.equals(""))	eqvl_value	=	"1";
											
											in_tot_qty	= 0.0f;
											if(fract_dose.equals("Y")){
												in_tot_qty	=new Double(Math.ceil(ing_unit_qty/(Float.parseFloat(pack_size)))).floatValue() * Float.parseFloat(eqvl_value);	
											}
											else{
												in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);
											}

											if (freq_nature.equals("I")) {
												in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
											}
											else if (freq_nature.equals("F") || freq_nature.equals("C")) {
												in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));
											}
											else if (freq_nature.equals("O")) {
												in_tot_qty = in_tot_qty;
											}

											

											if(!fract_dose.equals("Y")){
												in_tot_qty	=   new Double(Math.ceil((in_tot_qty)/Float.parseFloat(pack_size))).floatValue();
											}	
											ordered_qty=in_tot_qty+"";
										}

										
									}
									drugDetails.put("ORDERED_QTY",ordered_qty);

									bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
									
									billable_item_yn =(String)drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String)drugDetails.get("BILLABLE_ITEM_YN"); 
									if(billable_item_yn.equals("Y")){
										bl_included_IE				= (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
										bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");         
										bl_override_reason_code		= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
										bl_override_reason_desc		= (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
										bl_charge_amt				= (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");           
										bl_patient_payable			= (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");      
										bl_apprvl_reqd_yn			= (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
										bl_decimal_format_string	= (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
										bl_override_allowed_yn		= (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");
										bl_error_code				= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
										bl_sys_message_id			= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
										bl_error_text				= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
										if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
											  grossAmount		    = (String)drugDetails.get("BL_GROSS_AMT")==null?"0.0":(String)drugDetails.get("BL_GROSS_AMT");
										} // Added for ML-BRU-CRF-0469 [IN:065426] - End   
										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											blErrorDrugs.add("D");
											blErrorDrugs.add(drug_code);
											blErrorDrugs.add(drug_desc);
											blErrorDrugs.add(bl_error_code);
											blErrorDrugs.add(bl_sys_message_id);
											blErrorDrugs.add(bl_error_text);
											bl_charge_amt = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											bl_patient_payable = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels");
											if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
												grossAmount = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels"); // Added for ML-BRU-CRF-0469 [IN:065426] 
											} // Added for ML-BRU-CRF-0469 [IN:065426] - End
										}
										else{
											//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
												bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
												bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
											//}
												if(displayGrossAmtYn){  // Added for ML-BRU-CRF-0469 [IN:065426] - Start
													totalGrossAmount       += Float.parseFloat(grossAmount); 
												} // Added for ML-BRU-CRF-0469 [IN:065426] - End
											dfTest = new DecimalFormat(bl_decimal_format_string);
										}

										if(bl_included_IE.equals("I"))
											bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_included_IE.equals("E"))
											bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_included_IE_gif = "&nbsp;";			
										
										//commented for BL CRF 0001
										/*if(!bl_incl_excl_override_value.equals(""))
											bl_override_checked = "checked";
										else
											bl_override_checked = "";

										if(bl_override_allowed_yn.equals("Y"))
											bl_override_disable = "";
										else
											bl_override_disable = "disabled";
										*/


										 //done for BL CRF 0001
										 if(bl_override_allowed_yn.equals(""))
												bl_override_disable = "disabled";
										 else
												bl_override_disable = "";

				  
										include_selected="";
										exclude_selected="";
										if(!bl_override_reason_desc.equals("")){
											if(bl_incl_excl_override_value.equals("I")){
												include_selected ="selected";
											}
											else if(bl_incl_excl_override_value.equals("E")){
												exclude_selected ="selected";
											}
										}

										// ends here

										if(bl_apprvl_reqd_yn.equals("Y"))
											bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
										else if(bl_apprvl_reqd_yn.equals("N"))
											bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
										else
											bl_apprvl_reqd_gif = "&nbsp;";
									}
									else{
										bl_included_IE				="";		
										bl_incl_excl_override_value ="";	
										bl_override_reason_code		="";		
										bl_override_reason_desc		="";		
										bl_charge_amt				="";				
										bl_patient_payable			="";			
										bl_apprvl_reqd_yn			="";			
										bl_decimal_format_string	="";		
										bl_override_allowed_yn		="";		
										bl_error_code				="";			
										bl_sys_message_id			="";			
										bl_error_text				="";
										bl_included_IE_gif			="";
										bl_override_disable			= "";
										include_selected			="";
										exclude_selected			="";
										bl_apprvl_reqd_gif			= "&nbsp;";
									}
									iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(iOrdQty));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block75Bytes, _wl_block75);
										if(billable_item_yn.equals("Y")){

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_included_IE_gif));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bl_override_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_incl_excl_override_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
if(bl_override_allowed_yn.equals("I"))
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
if(bl_override_allowed_yn.equals("E"))
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
if(bl_override_allowed_yn.equals("B")){
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(grossAmount));
            _bw.write(_wl_block137Bytes, _wl_block137);
} // Added for ML-BRU-CRF-0469 - End 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_charge_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_patient_payable));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_apprvl_reqd_gif));
            _bw.write(_wl_block63Bytes, _wl_block63);
										}else{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block140Bytes, _wl_block140);
										}

            _bw.write(_wl_block125Bytes, _wl_block125);


									drug_index++;
								}


								fluidDetails =(HashMap) CompFluidDetails.get(drug_code+"_"+ocurrance_num);
								if(fluidDetails !=null && fluidDetails.size()>0){
									in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
									durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
									amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"1":(String)drugDetails.get("amend_repeat_value");	
									amend_durn_value=(String)drugDetails.get("amend_durn_value")==null?"1":(String)drugDetails.get("amend_durn_value");
									if(amend_durn_value.equals("")) //IN066756 ML-MMOH-CRF-1014
										amend_durn_value = "1";
									item_code = (String)fluidDetails.get("ITEM_CODE")==null?"":(String)fluidDetails.get("ITEM_CODE");

									if(in_formulary_yn.equals("Y")  && !item_code.equals("")){
										fluid_name			= (String)fluidDetails.get("DRUG_DESC");

										qty_value			= (String)drugDetails.get("amend_stock_value");
										if(qty_value==null || qty_value.equals(""))
											qty_value			= (String)fluidDetails.get("QTY_VALUE");

										fluid_code=(String)fluidDetails.get("DRUG_CODE");
										order_uom	= bean.getStockUOM(fluid_code);	
										pack_size	= bean.getPackSize(fluid_code);			

										ordered_qty		= (Math.ceil((Float.parseFloat(qty_value)) / Float.parseFloat(pack_size)))+""; 
//if(!amend_durn_value.equals("")){
										ordered_qty		= (Math.ceil((Float.parseFloat(ordered_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";
//}
										ordered_qty=new Float(ordered_qty).intValue()+"";				
										drugDetails.put("ORDERED_QTY",ordered_qty);

										bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
										billable_item_yn =(String)fluidDetails.get("BILLABLE_ITEM_YN")==null?"":(String)fluidDetails.get("BILLABLE_ITEM_YN"); 
									if(billable_item_yn.equals("Y")){

											bl_error_code				= (String)fluidDetails.get("BL_ERROR_CODE")==null?"":(String)fluidDetails.get("BL_ERROR_CODE"); 
											bl_sys_message_id			= (String)fluidDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)fluidDetails.get("BL_SYS_MESSAGE_ID");
											bl_error_text				= (String)fluidDetails.get("BL_ERROR_TEXT")==null?"":(String)fluidDetails.get("BL_ERROR_TEXT");
											drug_desc					= (String)fluidDetails.get("DRUG_DESC")==null?"":(String)fluidDetails.get("DRUG_DESC");
											bl_charge_amt				= (String)fluidDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)fluidDetails.get("BL_CHARGE_AMT");           
											bl_patient_payable			= (String)fluidDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)fluidDetails.get("BL_PATIENT_PAYABLE");      
											bl_decimal_format_string	= (String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0":(String)fluidDetails.get("BL_DECIMAL_FORMAT_STRING");
											bl_override_allowed_yn		= (String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)fluidDetails.get("BL_OVERRIDE_ALLOWED_YN");
											bl_apprvl_reqd_yn			= (String)fluidDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)fluidDetails.get("BL_APPRVL_REQD_YN");
											bl_incl_excl_override_value = (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE"); 
											bl_included_IE				= (String)fluidDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_VALUE");          
											bl_override_reason_code		= (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");
											bl_override_reason_desc		= (String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"":(String)fluidDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
											if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
												blErrorDrugs.add("F");
												blErrorDrugs.add(fluid_code);
												blErrorDrugs.add(fluid_name);
												blErrorDrugs.add(bl_error_code);
												blErrorDrugs.add(bl_sys_message_id);
												blErrorDrugs.add(bl_error_text);
											}
											else{
												//if( !bl_included_IE.equals("E") && (bl_incl_excl_override_value.equals("") || bl_incl_excl_override_value.equals("I"))){ //if condition commed for RUT-SCF-0188 [IN:039946]
													bl_tot_charge_amt += Float.parseFloat(bl_charge_amt);
													bl_tot_patient_payable += Float.parseFloat(bl_patient_payable);
												//}
												dfTest = new DecimalFormat(bl_decimal_format_string);
											}

											if(bl_included_IE.equals("I"))
												bl_included_IE_gif= "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_included_IE.equals("E"))
												bl_included_IE_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_included_IE_gif = "&nbsp;";

											/*
											//commented for BL CRF 0001
											
											if(!bl_incl_excl_override_value.equals(""))
												bl_override_checked = "checked";
											else
												bl_override_checked = "";

											if(bl_override_allowed_yn.equals("Y"))
												bl_override_disable = "";
											else
												bl_override_disable = "disabled";
											 */
											 //done for BL CRF 0001
											 if(bl_override_allowed_yn.equals(""))
													bl_override_disable = "disabled";
											 else
													bl_override_disable = "";

					  
											include_selected="";
											exclude_selected="";
											if(!bl_override_reason_desc.equals("")){
												if(bl_incl_excl_override_value.equals("I")){
													include_selected ="selected";
												}
												else if(bl_incl_excl_override_value.equals("E")){
													exclude_selected ="selected";
												}
											}
											if(bl_apprvl_reqd_yn.equals("Y"))
												bl_apprvl_reqd_gif = "<img src='../../eCommon/images/enabled.gif'></img>";
											else if(bl_apprvl_reqd_yn.equals("N"))
												bl_apprvl_reqd_gif= "<img src='../../eCommon/images/disabled.gif'></img>";
											else
												bl_apprvl_reqd_gif = "&nbsp;";
									}
									else{
										bl_error_code				="";			
										bl_sys_message_id			="";		
										bl_error_text				="";		
										drug_desc					="";			
										bl_charge_amt				="";		
										bl_patient_payable			="";		
										bl_decimal_format_string	="";
										bl_override_allowed_yn		="";	
										bl_apprvl_reqd_yn			="";			
										bl_incl_excl_override_value ="";
										bl_included_IE				="";		
										bl_override_reason_code		="";	
										bl_override_reason_desc		="";
										bl_included_IE_gif			= "&nbsp;";
										include_selected			="";
										exclude_selected			="";
										bl_apprvl_reqd_gif			= "&nbsp;";

									}
										iOrdQty = Math.ceil(Float.parseFloat(ordered_qty));

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(fluid_name));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ocurrance_num));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(iOrdQty));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block75Bytes, _wl_block75);
                                   if(billable_item_yn.equals("Y")){

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_included_IE_gif));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bl_override_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_incl_excl_override_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ocurrance_num));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
if(bl_override_allowed_yn.equals("I"))
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(bl_override_allowed_yn.equals("E"))
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(bl_override_allowed_yn.equals("B")){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_desc));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bl_override_reason_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 - Start 
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(grossAmount));
            _bw.write(_wl_block151Bytes, _wl_block151);
} // Added for ML-BRU-CRF-0469 - End 
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_charge_amt));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_patient_payable));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bl_apprvl_reqd_gif));
            _bw.write(_wl_block63Bytes, _wl_block63);
                                    }else{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bl_included_IE));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bl_override_disable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block157Bytes, _wl_block157);
										}

            _bw.write(_wl_block158Bytes, _wl_block158);

										drug_index++;
									}
								}
							}
						}
					}
				}
			/*	if((iv_prep_yn.equals("3") || iv_prep_yn.equals("4") )&& fluid_code.equals((String)((HashMap)drugList.get(0)).get("DRUG_CODE"))){
// value is being divided by 2 coz - in IV intermittent if it is ready to use iv then drug and fluid wil be same, in that case the amt wil be added twice
				bl_tot_charge_amt = bl_tot_charge_amt / 2;
					bl_tot_patient_payable = bl_tot_patient_payable / 2;
				}*/
				totalGrossAmountStr = dfTest.format(totalGrossAmount); // Added for ML-BRU-CRF-0469 [IN:065426]
				tot_payable_sum_str = dfTest.format(bl_tot_charge_amt);
				pat_payable_sum_str = dfTest.format(bl_tot_patient_payable);
				

            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
 if(displayGrossAmtYn){ // Added for ML-BRU-CRF-0469 [IN:065426] - Strat
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(totalGrossAmountStr));
            _bw.write(_wl_block162Bytes, _wl_block162);
}  // Added for ML-BRU-CRF-0469 [IN:065426] - End 
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(tot_payable_sum_str));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(pat_payable_sum_str));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(rx_order_type));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(drug_index));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(take_home_medication));
            _bw.write(_wl_block177Bytes, _wl_block177);

			if(blErrorDrugs.size()>0){

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(blErrorDrugs));
            _bw.write(_wl_block177Bytes, _wl_block177);

			}
			else{

            _bw.write(_wl_block179Bytes, _wl_block179);

			}

            _bw.write(_wl_block180Bytes, _wl_block180);

}catch(Exception e){
e.printStackTrace();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalItem.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideIncl/Excl.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprReqd.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
