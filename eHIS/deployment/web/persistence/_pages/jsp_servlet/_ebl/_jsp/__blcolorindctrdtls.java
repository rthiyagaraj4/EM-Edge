package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.text.SimpleDateFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcolorindctrdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLColorIndctrDtls.jsp", 1737915892365L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eBL/images/BLColorIndctr.css\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eBL/js/BLColorIndctrDtls.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onload=\"onLoadColorIndr();onPageLoad();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'BLColorIndDtls\' id=\'BLColorIndDtls\' method=\'post\' >\n\t<table cellspacing=\"0\" cellpadding=\"0\">\n\t<tr>\n\t\t<td>\n\t\t\t<label><strong>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</strong></label>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table align=\"center\" cellpadding=\"4\" class=\'mainTable\'>\n\t\t\t\t<tr>\n\t\t\t\t<td class=\'label\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t<label><strong>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</strong></label>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t<label><strong>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</strong></label>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\'  colspan=\"2\" style=\"text-align=center;\" cellpadding=\"1\">\n\t\t\t\t\t<label style=\"text-align: end;\"><strong>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</strong></label>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<input type=\"text\" name=\"reqStatus1\" id=\"reqStatus1\" style=\"width:130px;\" value=\"Pending\" readonly>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' width=\'100%\' colspan=\"3\" style=\"text-align=center;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"timeLimit1\" id=\"timeLimit1\"  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onchange=\"checkHHMM(this);\" maxlength=\"5\"></td>\n\t\t\t\t\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"color\" id=\"colInd1\" name=\"colInd1\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\"width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;\" onfocus=\"this.blur()\" readonly disabled ></td>\n\t\t\t\t\t\t\t\t<td><IMG id=\"colImg1\" onclick=\'getColor(\"colInd1\",\"colIndc1\");\' src=\"../../eBL/images/showColor.gif\"></td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"colIndc1\" id=\"colIndc1\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<input type=\"text\" name=\"reqStatus2\" id=\"reqStatus2\" style=\"width:130px;\" value=\"Sent To Insurance\" readonly>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"3\" style=\"text-align=center;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"text\"  name=\"timeLimit2\" id=\"timeLimit2\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onchange=\"checkHHMM(this);\" maxlength=\"5\"></td>\n\t\t\t\t\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"color\" id=\"colInd2\" name=\"colInd2\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;\" onfocus=\"this.blur()\" readonly disabled></td>\n\t\t\t\t\t\t\t\t<td><IMG id=\"colImg2\" onclick=\'getColor(\"colInd2\",\"colIndc2\");\' src=\"../../eBL/images/showColor.gif\"></td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"colIndc2\" id=\"colIndc2\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<input type=\"text\" name=\"reqStatus3\" id=\"reqStatus3\" style=\"width:130px;\" value=\"Hold\" readonly>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"3\" style=\"text-align=center;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"timeLimit3\" id=\"timeLimit3\"  value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onchange=\"checkHHMM(this);\" maxlength=\"5\"></td>\n\t\t\t\t\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"color\"  name=\"colInd3\" id=\"colInd3\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\"width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;\" onfocus=\"this.blur()\" readonly disabled></td>\n\t\t\t\t\t\t\t\t<td><IMG id=\"colImg3\" onclick=\'getColor(\"colInd3\",\"colIndc3\");\' src=\"../../eBL/images/showColor.gif\"></td>\n\t\t\t\t\t\t\t    <input type=\"hidden\" name=\"colIndc3\" id=\"colIndc3\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<input type=\"text\" name=\"reqStatus4\" id=\"reqStatus4\" style=\"width:130px;\" value=\"Approved\" readonly>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"3\" style=\"text-align=center;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"timeLimit4\" id=\"timeLimit4\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onchange=\"checkHHMM(this);\" maxlength=\"5\"></td>\n\t\t\t\t\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"color\" id=\"colInd4\" name=\"colInd4\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;\" onfocus=\"this.blur()\" readonly disabled></td>\n\t\t\t\t\t\t\t\t<td><IMG id=\"colImg4\" onclick=\'getColor(\"colInd4\",\"colIndc4\" );\' src=\"../../eBL/images/showColor.gif\"></td>\n\t\t\t\t\t\t\t    <input type=\"hidden\" name=\"colIndc4\" id=\"colIndc4\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<input type=\"text\" name=\"reqStatus5\" id=\"reqStatus5\" style=\"width:130px;\" value=\"Rejected\" readonly>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"3\" style=\"text-align=center;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"timeLimit5\"  id=\"timeLimit5\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onchange=\"checkHHMM(this);\" maxlength=\"5\"></td>\n\t\t\t\t\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"color\" id=\"colInd5\" name=\"colInd5\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\"width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;\" onfocus=\"this.blur()\" readonly disabled></td>\n\t\t\t\t\t\t\t\t<td><IMG id=\"colImg5\" onclick=\'getColor(\"colInd5\",\"colIndc5\");\' src=\"../../eBL/images/showColor.gif\"></td>\n\t\t\t\t\t\t\t <input type=\"hidden\" name=\"colIndc5\" id=\"colIndc5\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<input type=\"text\" name=\"reqStatus6\" id=\"reqStatus6\"  style=\"width:130px;\" value=\"Clarification\" readonly>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' colspan=\"3\" style=\"text-align=center;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"timeLimit6\" id=\"timeLimit6\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onchange=\"checkHHMM(this);\" maxlength=\"5\"></td>\n\t\t\t\t\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'  colspan=\"2\" style=\"text-align=center;\">\n\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><input type=\"color\" id=\"colInd6\" name=\"colInd6\"  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" style=\"width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;\" onfocus=\"this.blur()\" readonly disabled></td>\n\t\t\t\t\t\t\t\t<td><IMG id=\"colImg6\" onclick=\'getColor(\"colInd6\",\"colIndc6\");\' src=\"../../eBL/images/showColor.gif\"></td>\n\t\t\t\t\t\t\t    <input type=\"hidden\" name=\"colIndc6\" id=\"colIndc6\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n    </table>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n<input type=\"hidden\" name=\"modeType\" id=\"modeType\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"loginUser\" id=\"loginUser\"  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"WS_NO\" id=\"WS_NO\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"finArrIds\" id=\"finArrIds\" value=\"\">\n<input type=\"hidden\" name=\"mul_fact_ded_rule_YN\" id=\"mul_fact_ded_rule_YN\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"is_mul_fact_ded_rule_mod\" id=\"is_mul_fact_ded_rule_mod\"  value=\"N\">\n<input type=\"hidden\" name=\"isMFDRApplicableForSite\" id=\"isMFDRApplicableForSite\"  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\"hidden\" name=\"drug_cat_YN\" id=\"drug_cat_YN\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"diag_cat_YN\" id=\"diag_cat_YN\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\"hidden\" name=\"service_items_YN\" id=\"service_items_YN\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> <!-- V230210 -->\n\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
20/07/2020 	  		       Ram kumar S											NMC-JD-CRF-0042
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
------------------------------------------------------------------------------------------------------------------------------
1			 V210504			 17598			Common-ICN-0034				Mohana Priya K
2			 V230210							MMS-DM-CRF-0209.5			Namrata Charate
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	Connection colCon = null;
	PreparedStatement colPstmt = null;
	ResultSet colRs = null;
	String modeType="insert";
	String facilityId  = (String) session.getValue("facility_id");
	String loginUser   = (String) session.getValue("login_user");
	HashMap colorTimeValues = new HashMap();
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String WS_NO =p.getProperty("client_ip_address");
	boolean isMFDRApplicableForSite = false; 
	String mul_fact_ded_rule_YN = "N";
	String drug_cat_YN = "N";
	String diag_cat_YN = "N";
	String service_items_YN = "N"; //V230210
    
	try{		
			colCon=ConnectionManager.getConnection();
			
			try
			{
				isMFDRApplicableForSite = eCommon.Common.CommonBean.isSiteSpecific(colCon, "BL","DISP_MULTI_FACT_DED_RULE");	
			}catch(Exception e){
				e.printStackTrace();
			}
			System.err.println("isMFDRApplicableForSite "+isMFDRApplicableForSite);
			String mul_fact_ded_rule_YN_Qry = "SELECT NVL(MULTI_FACTOR_DED_RULE_APPL_YN,'N') MULTI_FACTOR_DED_RULE_APPL_YN, NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN, NVL(MFDR_SERV_ITEM_CAT_APPL_YN,'N') MFDR_SERV_ITEM_CAT_APPL_YN FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facilityId+"'";   //V230210
			
			colPstmt=colCon.prepareStatement(mul_fact_ded_rule_YN_Qry);
			colRs= colPstmt.executeQuery();
			while(colRs.next()) { 
				mul_fact_ded_rule_YN = colRs.getString("MULTI_FACTOR_DED_RULE_APPL_YN");
				drug_cat_YN = colRs.getString("MFDR_DRUG_CAT_APPL_YN");
				diag_cat_YN = colRs.getString("MFDR_DIAG_CAT_APPL_YN");
				service_items_YN = colRs.getString("MFDR_SERV_ITEM_CAT_APPL_YN"); //V230210
			}
			
			colRs.close();
			colPstmt.close();			
		
			String colorPopulateQuery="SELECT REQUEST_STATUS,TIME_LIMIT,COLOR_CODE FROM BL_COLOR_INDICATOR_RULE_STATUS WHERE FACILITY_ID='"+facilityId+"'";

			colPstmt=colCon.prepareStatement(colorPopulateQuery);
			colRs= colPstmt.executeQuery();
			ResultSetMetaData colRsmd = colRs.getMetaData();
			int colColorNumber = colRsmd.getColumnCount();
			while(colRs.next()) { 
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
			}
			String penTimeLimit="",  penColorCode="";
			String insTimeLimit="",  insColorCode="";
			String holdTimeLimit="", holdColorCode="";
			String appTimeLimit="",  appColorCode="";
			String rejTimeLimit="",  rejColorCode="";
			String clarTimeLimit="", clarColorCode="";
			String []pensplit= new String[100];
			String []inssplit= new String[100];
			String []holdsplit= new String[100];
			String []appsplit= new String[100];
			String []rejsplit= new String[100];
			String []clarsplit= new String[100];
			if(colorTimeValues.size()!=0){
				modeType="update";
				//Getting Pending Status values
				String penValues=(String) colorTimeValues.get("P");
				pensplit=penValues.split("~~");
				penTimeLimit=pensplit[0];
				penColorCode=pensplit[1];
				//Getting Sent To Insurance Status values
				String insValues=(String) colorTimeValues.get("S");
				inssplit=insValues.split("~~");
				insTimeLimit=inssplit[0];
				insColorCode=inssplit[1];
				//Getting Hold Status values
				String holdValues=(String) colorTimeValues.get("H");
				holdsplit=holdValues.split("~~");
				holdTimeLimit=holdsplit[0];
				holdColorCode=holdsplit[1];
				//Getting Approved Status values
				String appValues=(String) colorTimeValues.get("A");
				appsplit=appValues.split("~~");
				appTimeLimit=appsplit[0];
				appColorCode=appsplit[1];
				//Getting Rejected Status values
				String rejValues=(String) colorTimeValues.get("R");
				rejsplit=rejValues.split("~~");
				rejTimeLimit=rejsplit[0];
				rejColorCode=rejsplit[1];
				//Getting Clarification Status values
				String clarValues=(String) colorTimeValues.get("C");
				clarsplit=clarValues.split("~~");
				clarTimeLimit=clarsplit[0];
				clarColorCode=clarsplit[1];
			}
			else{
				modeType="insert";
				penTimeLimit="00:00";  penColorCode="#FFFFFF";
				insTimeLimit="00:00";  insColorCode="#FFFFFF";
				holdTimeLimit="00:00"; holdColorCode="#FFFFFF";
				appTimeLimit="00:00";  appColorCode="#FFFFFF";
				rejTimeLimit="00:00";  rejColorCode="#FFFFFF";
				clarTimeLimit="00:00"; clarColorCode="#FFFFFF";
			}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(penTimeLimit));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(penColorCode.toUpperCase()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(penColorCode.toUpperCase()));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(insTimeLimit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(insColorCode.toUpperCase()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(insColorCode.toUpperCase()));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(holdTimeLimit));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(holdColorCode.toUpperCase()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(holdColorCode.toUpperCase()));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appTimeLimit));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appColorCode.toUpperCase()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(appColorCode.toUpperCase()));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rejTimeLimit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rejColorCode.toUpperCase()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rejColorCode.toUpperCase()));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(clarTimeLimit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clarColorCode.toUpperCase()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(clarColorCode.toUpperCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);

	//V210504 Starts
		if(colPstmt != null) 	
			{
			colPstmt.close(); 	
			}
		if(colRs != null) 	
		{
			colRs.close(); 	
		}
		if(colCon!=null)
			{
				ConnectionManager.returnConnection(colCon, request);
			} //V210504 Ends
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Exception in BLColorIndctrDtls.jsp==>"+e);
	}
	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(modeType));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(WS_NO));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mul_fact_ded_rule_YN));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(isMFDRApplicableForSite?"Y":"N"));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_cat_YN));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(diag_cat_YN));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(service_items_YN));
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Record_Approval.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Request_Status.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Time_Limit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Color_Indicaotr.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HH_MM.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HH_MM.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HH_MM.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HH_MM.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HH_MM.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HH_MM.label", java.lang.String .class,"key"));
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
}
