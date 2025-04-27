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

public final class __associatemultipleconsentforms extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/AssociateMultipleConsentForms.jsp", 1709119632000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="- ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</title>\n<style>\nTD.QRYEVEN1{\n    BACKGROUND-COLOR: #F0F0F2;  \n\tBORDER-STYLE: none;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\theight:18px;\tfont-family: Verdana, Arial, Helvetica, sans-serif;\tfont-size: 8pt;\tfont-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;\n\n       }\n\nTD.QRYODD1{\n    BACKGROUND-COLOR: #E2E3F0;  \n\tBORDER-STYLE: none;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\theight:18px;\tfont-family: Verdana, Arial, Helvetica, sans-serif;\tfont-size: 8pt;\tfont-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;\n\t\n    }\n</style>\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ConsentOrder.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form method=\"post\" name=\"multiple_consent_form\" id=\"multiple_consent_form\">\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center class=\"grid\">\n\t<!-- Fixed List Case -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<!-- <tr>\n\t\t\t<td  class=\'label\' align=\'left\' colspan=\'3\' > <B>Required Consent Form</B> </td>\n\t\t\t\n\t\t</tr> -->\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t\t <tr>\n\t\t\t\t\t\t<td  class=\'CAHIGHERLEVELCOLOR\' align=\'left\' colspan=\'3\'><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></td>\n\t\t\t\t\t</tr> \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' style=\'border-right:0px\' width=\'30% \'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' colspan=\'2\' align=\"left\" width=\'70% \' style=\'border-left:0px\'><!-- Consent Label --><B><font COLOR=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =". ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font></B></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<input type=\'hidden\' value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"consent_chk";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" name=\"consent_form_id";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\"consent_stage";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t\t\t\t<!-- Variable List Case -->\n\t\t\t\t<!-- Multiple Consent Required Case --><!-- Associated List Exists -->\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<!-- <tr>\n\t\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' style=\'border-right:0px\' colspan=\'\'><B>Required Count :</B></td>\n\t\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' style=\'border-right:0px;border-left:0px\' align=\'center\' colspan=\'\'><B>Before Order Release&nbsp;<label id=\'before_release\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</label></B></td>\n\t\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' style=\'border-left:0px\' align=\'left\' colspan=\'\'><B>Before Order Registration&nbsp;<label id=\'before_regist\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</label></B></td>\n\n\t\t\t\t\t\n\t\t\t\t</tr>\t\n\t\t\t\t<tr>\n\t\t\t\t\t<th>Select</th>\n\t\t\t\t\t<th>Consent Form</th>\n\t\t\t\t\t<th>Stage</th>\n\t\t\t\t</tr> -->\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' align=\'center\' width=\'20%\'><input type=\"checkbox\" name=\"consent_chk";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onclick=\'consentEntered(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",this,\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\")\'></td>\n\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\'40%\' style=\"cursor:";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" title=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><B><label style=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label></B></td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' align=\'center\' width=\'40%\'><select name=\'consent_stage";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'consent_stage";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t\t\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="  style=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t\t\t<option value=\'R\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" style=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\n\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" name=\"consent_form_stage";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" name=\"form_confirmed";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" name=\"form_dflt_chk";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<!-- Associated List not Exists  -->\n\t\t\t<!-- <tr>\n\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' style=\'border-right:0px\' colspan=\'\'><B>Required Count :</B></td>\n\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' style=\'border-right:0px;border-left:0px\' align=\'center\' colspan=\'\' nowrap><B>Before Order Release&nbsp;<label id=\'before_release\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</label></B></td>\n\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' style=\'border-left:0px\' align=\'center\' colspan=\'\'><B>Before Order Registration&nbsp;<label id=\'before_regist\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</label></B></td>\n\t\t\t\t\t\t\t\n\t\t\t</tr>\t -->\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t<tr style=\'border-top:0px;border-bottom:0px\'>\n\t\t\t\t<td class=\'label\'colspan=\"3\"><B>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</B></td>\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<tr style=\'border-top:0px;border-bottom:0px\'>\n\t\t\t\t\n\t\t\t\t<!-- <td class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' align=\'right\'><B>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</B>&nbsp;</td>\t -->\t\n\t\t\t\t<td id=\'assign_consent";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' colspan=\'3\' style=\'border-top:0px;border-bottom:0px\' align=\'center\'><B>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;.&nbsp;</B><input type=\"text\" name=\"consent_form_desc";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"consent_form_desc";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" onclick=\'consentEntered(";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =",this,\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\")\' onBlur=\"showConsent(consent_form_desc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =",consent_form_id";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =");clearID(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\')\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">&nbsp;<input class=\"button\" type=\"button\" name=\"consent_id_lookup";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"consent_id_lookup";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"  value=\"?\" onClick=\"showConsent(consent_form_desc";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =")\" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">\n\t\t\t\t<input type=\"hidden\" name=\"consent_form_id";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"consent_form_id";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >&nbsp;</td>\n\t\t\t\t<input type=\"hidden\" name=\"consent_stage";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"consent_stage";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"consent_text";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"consent_text";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" >\n\t\t\t</tr>\n\t\t\t\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<!-- end -->\n\t\t<!-- Single Consent Required Case -->\n\t\t<input type=\"hidden\" value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' name=\"consent_stage0\">\n\t\t<!-- <tr>\n\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' colspan=\'3\'><B>Consent Form for Before Order ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</B></td>\n\t\t</tr> -->\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\'label\'  colspan=\'3\' id=\'assign_consent0\'><B>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" :</B>\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" \n\t\t\t<B>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</B></td>\n\t\t\t<input type=\"hidden\" value=\'Y\' name=\"consent_chk0\" id=\"consent_chk0\">\n\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" name=\"consent_form_id0\">\n\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" name=\"consent_stage0\">\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" \n\t\t\t\t\t<B>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</B></td>\n\t\t\t\t\t<input type=\"hidden\" value=\'Y\' name=\"consent_chk0\" id=\"consent_chk0\">\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" name=\"consent_form_id0\">\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" name=\"consent_stage0\">\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" \n\t\t<!-- Associated List Exists -->\n\t\t\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="<select name=\'consent_form_id0\' id=\'consent_form_id0\' onchange=\'consentEntered(0,this,\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\")\'>\n\t\t\t<option value=\"\">-----";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="-----</option>\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' style=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =">";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</option>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t</select>\n\t\t\t\t\n\t\t<script>\n\t\t\tdefaultSelect(\'0\');\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t<!-- Associated List Not Exists -->\n\t\t\t<input type=\"text\" name=\"consent_form_desc0\" id=\"consent_form_desc0\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" onclick=\'consentEntered(0,this,\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\")\' onBlur=\"showConsent(consent_form_desc0,consent_form_id0);clearID(\'0\')\">&nbsp;<input class=\"button\" type=\"button\" name=\"consent_id_lookup\" id=\"consent_id_lookup\"  value=\"?\" onClick=\"showConsent(consent_form_desc0,consent_form_id0)\">\n\t\t\t<input type=\"hidden\" name=\"consent_form_id0\" id=\"consent_form_id0\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t\t\t<input type=\"hidden\" name=\"consent_text0\" id=\"consent_text0\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t</td>\n\t\t\n\t</tr>\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t<tr>\n\t\t<td class=\'label\' colspan=\'3\'>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\n\t<!-- <tr style=\'border-top:0px;border-bottom:0px\'>\n\t\t\n\t\t<td class=\'label\' align=\'right\' colspan=\'3\'>\n\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t<input class=\"button\" type=\"button\" name=\"record\" id=\"record\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" onClick=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">&nbsp;<input class=\"button\" type=\"reset\" name=\"clear\" id=\"clear\"  value=\"Clear\" onClick=\"document.forms[0].reset();\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="&nbsp;<input class=\"button\" type=\"button\" name=\"cancel\" id=\"cancel\"  value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" onClick=\"window.close()\"></td>\n\t</tr> -->\n\t\t<script>\n\t\t\t\tparent.multi_btn.location.href = \"../../eOR/jsp/AssociateMultipleConsentButtons.jsp?&buttn_label=\"+\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"+\"&consent_form_list=\"+\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"\n\t\t</script>\n\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\t\n</table>\n\n<input type=\'hidden\' name=\"num_of_consent_req_bo\" id=\"num_of_consent_req_bo\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n<input type=\'hidden\' name=\"num_of_consent_req_br\" id=\"num_of_consent_req_br\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n<input type=\"hidden\" name=\"consent_form_id_sql\" id=\"consent_form_id_sql\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n<Input type=\'hidden\'name=\'function_from\' value=\'MULTI_CONSENT\'>\n<Input type=\'hidden\' name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n<Input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n<Input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n<Input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n<Input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n<Input type=\'hidden\' name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n<Input type=\'hidden\' name=\'ord_catalog_code\' id=\'ord_catalog_code\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n<Input type=\'hidden\' name=\'index\' id=\'index\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n<Input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'1\'>\n\n<Input type=\'hidden\' name=\'beanOr_id\' id=\'beanOr_id\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n<Input type=\'hidden\' name=\'beanOr_name\' id=\'beanOr_name\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\n\n<Input type=\'hidden\' name=\'localeName\' id=\'localeName\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\n</form>\n</body>\n\n</html>\n\t\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
String order_catalog_desc=request.getParameter("order_catalog_desc")==null?"":request.getParameter("order_catalog_desc");

            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

try{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//out.println("<script>alert('"+requet.getQueryString()+"')</script>");
	String order_catalog_code = request.getParameter("order_catalog_code");
	order_catalog_code = (order_catalog_code == null) ? "":order_catalog_code;
	//String order_catalog_desc = request.getParameter("order_catalog_desc");
	//order_catalog_desc = (order_catalog_desc == null) ? "":order_catalog_desc;
	String order_category = request.getParameter("order_category");
	order_category = (order_category == null) ? "":order_category;
	String index = request.getParameter("index");
	index = (index == null) ? "":index;

	String function_from = request.getParameter("function_from");	
	function_from = (function_from == null) ? "":function_from;
	String order_id = request.getParameter("order_id");
	order_id = (order_id == null) ? "":order_id;
	String order_line_num = request.getParameter("order_line_num");
	order_line_num = (order_line_num == null) ? "1":order_line_num;
	String buttn_label = request.getParameter("buttn_label");
	buttn_label = (buttn_label == null) ? "":buttn_label;
	String consent_form_id = request.getParameter("consent_form_id");
	consent_form_id = (consent_form_id == null) ? "":consent_form_id;
	
	HashMap bean_consentDtl = null;
	
	if(buttn_label.equals("Orders")){
		OrderEntryBean beanObj		= (OrderEntryBean)getBeanObject( request.getParameter("bean_id"),request.getParameter("bean_name"), request ) ;
		beanObj.setLanguageId(localeName);
		bean_consentDtl = beanObj.getConsentFormDtl(index+order_catalog_code+order_category);
		//out.println("<script>alert('bean_consentDtl="+bean_consentDtl.size()+"');</script>");
	}

	//out.println("<script>alert('function_from="+function_from+"');</script>");
	//out.println("<script>alert('ord_typ_code="+ord_typ_code+"');</script>");
	//out.println("<script>alert('order_line_num="+request.getParameter("order_line_num")+"');</script>");
	ArrayList multiConsentList = new ArrayList();
	String[] multiConsentValues = null;
	String[] multiConsentDtls = null;
	String consent_req_bef_order = "";//added for SRR20056-SCF-2009  Id:  3736 05/06/2008
	String consent_req_bef_regn = ""; //added for SRR20056-SCF-2009  Id:  3736 05/06/2008


	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	//Properties properties			= (Properties) session.getValue( "jdbc" );
	//String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
	String multiConsentLine[] = new String[4];
	multiConsentLine=bean.MultiListConsentsLine(order_id,order_line_num);
	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/
	multiConsentDtls		= bean.MultiListDtls(order_catalog_code,practitioner_id);
	multiConsentList		= bean.MultiListConsentsdtl(order_catalog_code,order_id,order_line_num, practitioner_id);

	if(multiConsentList==null || multiConsentList.size()==0)
	{
		
		multiConsentList		= bean.MultiListConsents(order_catalog_code,order_id,order_line_num, practitioner_id);
		consent_req_bef_order = (String) multiConsentDtls[1];
		consent_req_bef_regn = (String) multiConsentDtls[2];
	}else{//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
	
		consent_req_bef_order = (String) multiConsentLine[2];//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
		consent_req_bef_regn = (String) multiConsentLine[3];//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
	}//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
	

	//}

//	out.println("<script>alert('@@@"+multiConsentDtls[0].size+"')</script>");

            _bw.write(_wl_block11Bytes, _wl_block11);

	String consent_before_ord_release = "0"; 
	String consent_before_ord_regis = "0";
	String consent_header="";
	String disp_count = "0";
	String slClassValue = "";
	String consent_req_bo= "";
	String consent_req_br= "";
	String consent_stage="";
	int num_consent_bo=0;
	int num_consent_br=0;
	int temp_count=0;
	int total_recs = 0;
	boolean header_disp = true;
	boolean consentflag = false;
	if(multiConsentDtls != null){	
	//if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 1 ) )){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
	if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1 ) || ( (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn)) > 1 ) )){
	 
            _bw.write(_wl_block12Bytes, _wl_block12);

		for(int i=0;i<multiConsentList.size();i++)
		{
			slClassValue="gridData";
			
			multiConsentValues = (String[])multiConsentList.get(i);
			consent_before_ord_release = multiConsentValues[7];
			consent_before_ord_regis  = multiConsentValues[8];
			if(multiConsentValues[6].equals("F"))
			{
				//if(i == 0)
				//{
					
					//if(consent_before_ord_release.equals("0"))
					if(multiConsentValues[3].equalsIgnoreCase("R"))
					{
						consent_header= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrderRegistration.label","or_labels")+":" ;
						disp_count = multiConsentValues[8];
					}else if(multiConsentValues[3].equalsIgnoreCase("A"))
					{
						disp_count = multiConsentValues[7];
						consent_header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrderRelease.label","or_labels")+":" ;
					}
				//}
				if(!(multiConsentValues[3]).equals(consent_stage))
				{
					header_disp=true;
					consent_stage=multiConsentValues[3];
				}
				else
				{
					header_disp=false;
				}
				if(header_disp)
				{
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(consent_header));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disp_count));
            _bw.write(_wl_block15Bytes, _wl_block15);
		//header_disp = false;
				 }
				 if(multiConsentValues[3].equals("A"))
				{
					if(Integer.parseInt(consent_before_ord_release)!=num_consent_bo)
					{
						num_consent_bo++;
						temp_count++;
						consentflag = true;
					}
				}
				else if(multiConsentValues[3].equals("R"))
				{
					if(Integer.parseInt(consent_before_ord_regis)!=num_consent_br)
					{
						num_consent_br++;
						temp_count++;
						consentflag = true;
					}
				}
				if(consentflag)
				{
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(multiConsentValues[10].equals("Y")?"#CC3300;":""));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(temp_count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(multiConsentValues[2]));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
						consentflag = false;
				}
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
	//temp_count++; 
				//if(temp_count == Integer.parseInt(consent_before_ord_release)){
					//header_disp = true;
					//consent_header = //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrderRegistration.label","or_labels")+":" ;
					//disp_count = multiConsentValues[8];
				//}
			}
			if(multiConsentDtls[0].equals("V")){
            _bw.write(_wl_block28Bytes, _wl_block28);
if(i==0){
			/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**start**/
				//	consent_req_bo = multiConsentDtls[1];
				//	consent_req_br = multiConsentDtls[2];
					consent_req_bo = consent_req_bef_order;
					consent_req_br = consent_req_bef_regn;	
			/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**end**/
					
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(multiConsentDtls[1]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(multiConsentDtls[2]));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
				if(bean_consentDtl !=null && bean_consentDtl.size() >0){
					if(((String)bean_consentDtl.get("consent_chk"+i)).equals("Y")){
						multiConsentValues[9]	= (String)bean_consentDtl.get("consent_chk"+i);
						multiConsentValues[1]	= (String)bean_consentDtl.get("consent_form_id"+i);
						multiConsentValues[3]	= (String)bean_consentDtl.get("consent_stage"+i);
						
					}
					multiConsentValues[4]		= "N";
				}
								
				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(((multiConsentValues[4].equals("Y") && buttn_label.equals("Orders"))|| multiConsentValues[9].equals("Y") || multiConsentValues[10].equals("Y"))? "checked":""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")? "disabled":"")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(consent_form_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")?"hand":(multiConsentValues[9].equals("Y")? "crosshair":"default"))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")?"Recorded Consent":(multiConsentValues[9].equals("Y")? "Confirmed Consent":"Consent to Be Confirmed"))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")?"COLOR:#CC3300;":(multiConsentValues[9].equals("Y")? "COLOR:#009933":""))));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((multiConsentValues[9].equals("Y")? "":"label")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(multiConsentValues[2]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")? "disabled":"")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((multiConsentValues[3].equals("A")? "selected":"")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")?"background-color:#CC3300;color:#FFFFFF":((multiConsentValues[9].equals("Y") && multiConsentValues[3].equals("A"))? "background-color:#009933;color:#FFFFFF":""))));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((multiConsentValues[3].equals("R")? "selected":"")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((multiConsentValues[10].equals("Y")?"background-color:#CC3300;color:#FFFFFF":((multiConsentValues[9].equals("Y") && multiConsentValues[3].equals("R"))? "background-color:#009933;color:#FFFFFF":""))));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(multiConsentValues[9]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(multiConsentValues[4]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
} total_recs++;
		}
		if(multiConsentDtls[0].equals("V")){
			out.println("<script>defaultChk("+total_recs+")</script>");
		}
		
            _bw.write(_wl_block59Bytes, _wl_block59);
}else if( multiConsentDtls[0].equals("V") && ((Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn) > 1) ) ){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(multiConsentDtls[1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(multiConsentDtls[2]));
            _bw.write(_wl_block62Bytes, _wl_block62);
 
				/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008***start*/
				//consent_req_bo = multiConsentDtls[1];
			   //consent_req_br = multiConsentDtls[2];
			   consent_req_bo = consent_req_bef_order;
			   consent_req_br = consent_req_bef_regn;
				
			//int count= Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]);
			/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**end**/
			int count= Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn);
			int i =0,tmp_count=0;
			String consent_stg = "";

			String form_id = "",form_label = "", consent_recd="";
			
			multiConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,order_id,order_line_num, practitioner_id);
			ArrayList arraylistseq = new ArrayList();
			HashMap hashmap = new HashMap();int tmp_cnt=0;
			while(i < count){
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN1";
				}else{
					slClassValue = "QRYODD1";
				}*/
				slClassValue="gridData";
				if(i == 0){
					//if(multiConsentDtls[1].equals("0")){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
					if(consent_req_bef_order.equals("0")){
						consent_header= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormforBeforeOrderRegistration.label","or_labels");
						consent_stg = "R";
					}else{
						consent_header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormforBeforeOrderRelease.label","or_labels");
						consent_stg = "A";
					}
					
				}
				
				if(i < multiConsentList.size()){
					
					multiConsentValues = (String[])multiConsentList.get(i);
					if(consent_stg.equals(multiConsentValues[3])){
						form_id			= multiConsentValues[1];
						form_label		= multiConsentValues[2];
						//consent_stg		= multiConsentValues[3];
						consent_recd	= multiConsentValues[10];
					}else{
						hashmap.put("form_id" , multiConsentValues[1]);
						hashmap.put("form_label" , multiConsentValues[2]);
						hashmap.put("consent_recd" , multiConsentValues[10]);
						arraylistseq.add(hashmap);
						tmp_cnt++;

						form_id			= "" ;
						form_label		= "" ;
						consent_recd	= "" ;

					}
				}else{
					if(tmp_cnt>0 ){
						form_id = (String)((HashMap)arraylistseq.get(--tmp_cnt)).get("form_id");
						form_label = (String)((HashMap)arraylistseq.get(tmp_cnt)).get("form_label");
						consent_recd =(String)((HashMap)arraylistseq.get(tmp_cnt)).get("consent_recd");

					}else{
						form_id			= "" ;
						form_label		= "" ;
						consent_recd	= "" ;
					}
				}

				if(bean_consentDtl !=null && bean_consentDtl.size() >0){
					if( bean_consentDtl.containsKey("consent_chk"+i) && ( ((String)bean_consentDtl.get("consent_chk"+i)).equals("Y") ) ){
						
						form_id	= (String)bean_consentDtl.get("consent_form_id"+i);
						form_label	= (String)bean_consentDtl.get("consent_form_desc"+i);
					}
				}
				
				if(header_disp){
					header_disp = false;
				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(consent_header));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
//=++tmp_count
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(++tmp_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(form_label));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(consent_form_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(consent_recd.equals("Y")?"disabled" :""));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(consent_recd.equals("Y")?"disabled" :""));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(form_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(consent_stg));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(form_label));
            _bw.write(_wl_block88Bytes, _wl_block88);
			i++;
			//if(i == Integer.parseInt(multiConsentDtls[1])){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
			if(i == Integer.parseInt(consent_req_bef_order)){
				header_disp = true;
				tmp_count = 0;
				consent_header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormforBeforeOrderRegistration.label","or_labels");
				consent_stg = "R";
				
			}
		}total_recs = i;
	}
	else
	{
		/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**start**/							//consent_req_bo = multiConsentDtls[1];
		//consent_req_br = multiConsentDtls[2];
		consent_req_bo = consent_req_bef_order;
		consent_req_br = consent_req_bef_regn;
		/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**end**/		
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(multiConsentDtls[4]));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

		if(multiConsentDtls[0].equals("F"))
		{
			if(!multiConsentDtls[5].equals("")&&!multiConsentDtls[5].equals(""))
			{
			
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(multiConsentDtls[5]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(multiConsentDtls[3]));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(multiConsentDtls[4]));
            _bw.write(_wl_block96Bytes, _wl_block96);

			}
			else 
			{
				if(multiConsentList.size()==1)
				{
						multiConsentValues = (String[])multiConsentList.get(0);
				
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(multiConsentValues[2]));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block100Bytes, _wl_block100);

				}
			}
		}
		if(multiConsentDtls[0].equals("V"))
		{
		
			String form_id = "",form_label = "";
		
            _bw.write(_wl_block101Bytes, _wl_block101);
if(multiConsentList.size() > 0){
			if(bean_consentDtl !=null && bean_consentDtl.size() >0){
				if( bean_consentDtl.containsKey("consent_chk0") && ( ((String)bean_consentDtl.get("consent_chk0")).equals("Y") ) ){
					form_id	= (String)bean_consentDtl.get("consent_form_id0");
				}
			}
			
			
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(consent_form_id));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
		for(int i=0;i<multiConsentList.size();i++){
				multiConsentValues = (String[])multiConsentList.get(i);
				if( !form_id.equals("") && form_id.equals(multiConsentValues[1])){
					multiConsentValues[9] = "Y";
					multiConsentValues[4] = "N";
				}
				if(multiConsentValues[9].equals("Y"))
					multiConsentValues[4] = "N";
		
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf((multiConsentValues[9].equals("Y")? "background-color:#009933;color:#FFFFFF":"")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(((multiConsentValues[4].equals("Y") || multiConsentValues[9].equals("Y"))? "selected":"")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(multiConsentValues[2]));
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
}else{
				
				multiConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,order_id,order_line_num, practitioner_id);
				if(multiConsentList.size() >0){
					for(int i=0;i<multiConsentList.size();i++){
						multiConsentValues = (String[])multiConsentList.get(i);
						form_id = multiConsentValues[1];
						form_label = multiConsentValues[2];
					}
				}
				if(bean_consentDtl !=null && bean_consentDtl.size() >0){
					if( bean_consentDtl.containsKey("consent_chk0") && ( ((String)bean_consentDtl.get("consent_chk0")).equals("Y") ) ){
						form_id	= (String)bean_consentDtl.get("consent_form_id0");
						form_label	= (String)bean_consentDtl.get("consent_form_desc0");
					}
				}
				
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(form_label));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(consent_form_id));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(form_id));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(form_label));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block116Bytes, _wl_block116);
 total_recs++; // here it will be always 1 in this loop since its a single consent
		}
            _bw.write(_wl_block117Bytes, _wl_block117);
 if(!multiConsentDtls[0].equals("F")){
			
			
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(buttn_label.equals("Consent")?"Apply":"OK"));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(buttn_label.equals("Consent")?"RecordValues()":"StoreValues()"));
            _bw.write(_wl_block120Bytes, _wl_block120);
}
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(multiConsentDtls[0].equals("F")?"Close":"Cancel"));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(buttn_label));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block124Bytes, _wl_block124);
 
	}else{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')); window.close()</script>");
		
	}//end 
	
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(consent_req_bo));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(consent_req_br));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_NON_IND")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(index));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(request.getParameter("bean_id")));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(request.getParameter("bean_name")));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block139Bytes, _wl_block139);

	putObjectInBean(bean_id,bean,request);

}catch(Exception e){
	out.println(e.toString());
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ConsentRequiredfor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BeforeOrderRelease.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BeforeOrderRegistration.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConsentForm.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
