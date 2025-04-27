package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispoverridereason extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispOverrideReason.jsp", 1723113701719L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="<!-- Modified for IN:072715  -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DirectDispensing.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n\t\t<form name=\"DispQueueMgmtHoldReason\" id=\"DispQueueMgmtHoldReason\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<marquee  bgcolor=\"#CC0000\" scrollamount=\"3\"><font color=\"white\" style=\"font-weight:bold\" size=1>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" :&nbsp;&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></marquee>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th  class=\"data\">&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t<!-- Added for IN:072715 START --> \n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"allergy_remarks_code\" id=\"allergy_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'AO\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.allergy,\'allergy\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\"> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </select>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t\t\t\t\t\t<td ><label onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" style=\"cursor:pointer;color:blue;font-size:9\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </label>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"allergy\" onKeyPress=\"return checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</textarea>\t&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\"><marquee bgcolor=\"#FFCC66\" scrollamount=\"3\"><font color=\"black\" style=\"font-weight:bold\" size=1>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" : ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="-";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =",";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" -";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =": ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></marquee></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th  class=\"data\">&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;</th>\n\t\t\t\t\t\t<!-- dosage_std and dose_unit_desc added for ML-MMOH-SCF-0864 -->\n\t\t\t\t\t\t<!-- Added for IN:072715 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"dose_remarks_code\" id=\"dose_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'BD\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.exceed_dose,\'exceed_dose\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t\t\t\t\t\t<td ><label onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\" style=\"cursor:pointer;color:blue;font-size:9\">Overdose Details</label>&nbsp;&nbsp;&nbsp;</td><!-- Modified for IN:070451  -->\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"exceed_dose\" onKeyPress=\"return checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</textarea>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\"><marquee bgcolor=\"#6699FF\" scrollamount=\"3\"><font color=\"black\" style=\"font-weight:bold\" size=1>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;&nbsp;</th>\n\t\t\t\t\t\t<!-- Added for IN:072715 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"dup_drug_remarks_code\" id=\"dup_drug_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'DP\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.dup_drug,\'dup_drug\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t\t\t\t\t\t<td ><label onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\" style=\"cursor:pointer;color:blue;font-size:9\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </label>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"dup_drug\" onKeyPress=\"return checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</textarea>&nbsp;\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td colspan=\"2\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> <!-- style added for MMS-KH-CRF-0029-->\n\t\t\t\t\t\t<td colspan=\"2\"><marquee bgcolor=\"#FFD2E9\" scrollamount=\"2\"><font color=\"black\" style=\"font-weight:bold\" size=1>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font></marquee></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"><!-- style added for MMS-KH-CRF-0029-->\n\t\t\t\t\t\t<td class=\"COLUMNHEADERCENTER\"  class=\"data\">&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td>\n\t\t\t\t\t\t<!-- Added for IN:072715 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"interaction_remarks_code\" id=\"interaction_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'DD\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.interaction_remarks,\'interaction_remarks\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t\t\t\t\t\t<td class=\"label\"><label onClick=\"showInractionDtl(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\" style=\"cursor:pointer;color:blue;font-size:9;display:";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">Interaction Dtls.</label>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"> <!-- style added for MMS-KH-CRF-0029-->\n\t\t\t\t\t\t<td  colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"interaction_remarks\" onKeyPress=\"javascript:if(event.keyCode != \'32\'){ return checkMaxLimit(this,255)};\" onblur=\"checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</textarea>&nbsp;\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr><!-- added for MMS-KH-CRF-0029 - start-->\n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t\t\t<td colspan=\"2\"><marquee bgcolor=\"#FFD2E9\" scrollamount=\"2\"><font color=\"black\" style=\"font-weight:bold\" size=1>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</font></marquee></td>\n\t\t\t\t\t</tr> \n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t\t<td class=\"COLUMNHEADERCENTER\"  class=\"data\">&nbsp;";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"food_interaction_remarks_code\" id=\"food_interaction_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'DF\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.food_interaction_remarks,\'food_interaction_remarks\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\t<td  colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"food_interaction_remarks\" onKeyPress=\"javascript:if(event.keyCode != \'32\'){ return checkMaxLimit(this,255)};\" onblur=\"checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</textarea>&nbsp;\n\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" >\n\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&nbsp;</td>\n\t\t\t\t\t\t<!-- Added for IN:072715 START -->\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"lab_interaction_remarks_code\" id=\"lab_interaction_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'DL\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.lab_interaction_remarks,\'lab_interaction_remarks\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t<td  colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"lab_interaction_remarks\" onKeyPress=\"javascript:if(event.keyCode != \'32\'){ return checkMaxLimit(this,255)};\" onblur=\"checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</textarea>&nbsp;\n\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" >\n\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr> <!-- added for MMS-KH-CRF-0029 - end-->\n\t\t\t\t\t<tr style=\"display:";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;</td>\n\t\t\t\t<!-- Added for IN:072715 START -->\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"disease_interaction_remarks_code\" id=\"disease_interaction_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'DI\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.disease_interaction_remarks,\'disease_interaction_remarks\')\"> ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t\t\t<td  colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"disease_interaction_remarks\" onKeyPress=\"javascript:if(event.keyCode != \'32\'){ return checkMaxLimit(this,255)};\" onblur=\"checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</textarea>&nbsp;\n\n\t\t\t\t\t<tr><td colspan=\"2\"></td>&nbsp;</tr>\n\t\t\t\t\t<!-- added for MMS-KH-CRF-0029-start -->\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_drug_display\" id=\"drug_drug_display\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_lab_display\" id=\"drug_lab_display\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_food_display\" id=\"drug_food_display\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"> \n\t\t\t\t\t<!-- added for MMS-KH-CRF-0029 end -->\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_disease_display\" id=\"drug_disease_display\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"> <!-- MMS-DM-CRF-0229 -->\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td  colspan=\"2\" align=\"right\">\n\t\t\t\t\t<input type=\"button\" value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' class=\"button\" onClick=\"validate(document.DispQueueMgmtHoldReason)\"></td>\n\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"allergy_yn\" id=\"allergy_yn\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"current_rx\" id=\"current_rx\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"limit_ind\" id=\"limit_ind\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"interaction_exists\" id=\"interaction_exists\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t</form>\n\t\t\t<!-- Added for IN:072715  -->\n\t\t\n\t\t<script type=\"text/javascript\">\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\tif(document.DispQueueMgmtHoldReason.allergy!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.allergy.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\tif(document.DispQueueMgmtHoldReason.exceed_dose!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.exceed_dose.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\tif(document.DispQueueMgmtHoldReason.dup_drug!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.dup_drug.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\tif(document.DispQueueMgmtHoldReason.interaction_remarks!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.interaction_remarks.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\tif(document.DispQueueMgmtHoldReason.food_interaction_remarks!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.food_interaction_remarks.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\tif(document.DispQueueMgmtHoldReason.lab_interaction_remarks!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.lab_interaction_remarks.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="//Added for MMS-DM-CRF-0229\n\t\t     if(document.DispQueueMgmtHoldReason.disease_interaction_remarks!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.disease_interaction_remarks.readOnly = true;\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<!-- Added for IN:072715  -->\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
10/12/2019      IN070606           Manickavasagam                         		 MMS-KH-CRF-0029
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

try{
			String generic_id		= CommonBean.checkForNull(request.getParameter("gen_id"));
			String generic_name		= CommonBean.checkForNull(request.getParameter("gen_name"));
			String patient_id		= CommonBean.checkForNull(request.getParameter("pat_id"));
			String encounter_id		= CommonBean.checkForNull(request.getParameter("enc_id"));
			String drug_desc		= CommonBean.checkForNull(request.getParameter("drug_desc"));
			String mono_graph		= CommonBean.checkForNull(request.getParameter("mono_graph"));
			String daily_dose		= CommonBean.checkForNull(request.getParameter("daily_dose"));
			String unit_dose		= CommonBean.checkForNull(request.getParameter("unit_dose"));
			String dosage_std		= CommonBean.checkForNull(request.getParameter("dosage_std"));//Added for ML-MMOH-SCF-0864
			String dose_unit_desc   = CommonBean.checkForNull(request.getParameter("dose_unit_desc"));//Added for ML-MMOH-SCF-0864,Modified for IN:070451
			String min_daily_dose	= CommonBean.checkForNull(request.getParameter("min_daily_dose"));
			String min_unit_dose	= CommonBean.checkForNull(request.getParameter("min_unit_dose")); 
			String allergy_yn		= CommonBean.checkForNull(request.getParameter("allergy_yn"));
			String current_rx		= CommonBean.checkForNull(request.getParameter("current_rx"));
			String limit_ind		= CommonBean.checkForNull(request.getParameter("limit_ind"));
			String drug_code		= CommonBean.checkForNull(request.getParameter("drug_code"));
			String srl_no			= CommonBean.checkForNull(request.getParameter("srl_no"));
			String dosage_unit		= CommonBean.checkForNull(request.getParameter("dosage_unit"));
			String interaction_exists	= CommonBean.checkForNull(request.getParameter("interaction_exists")); // added for FD-RUT-CRF-0066.1 [IN036975]
			String interaction_remarks	= ""; // added for FD-RUT-CRF-0066.1 [IN036975]
			String food_interaction_remarks = ""; //MMS-KH-CRF-0029[IN070606]
			String lab_interaction_remarks = ""; //MMS-KH-CRF-0029[IN070606]
			String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229

			String intr_msg_content	= "";
			String allergy			= "";
			String exceed_dose		= "";
			String dup_drug			= "";
			//Added for IN:070451
			String max_daily_ceeling_dose			= CommonBean.checkForNull(request.getParameter("max_daily_ceeling_dose"));
			String min_daily_ceeling_dose			= CommonBean.checkForNull(request.getParameter("min_daily_ceeling_dose"));
			String max_unit_ceeling_dose			= CommonBean.checkForNull(request.getParameter("max_unit_ceeling_dose"));
			String min_unit_ceeling_dose			= CommonBean.checkForNull(request.getParameter("min_unit_ceeling_dose"));
			//String dose_unit_desc			= CommonBean.checkForNull(request.getParameter("dose_unit_desc"));
			String dose_unit_desc1			= CommonBean.checkForNull(request.getParameter("dose_unit_desc1"));
			//Added for IN:070451
			//Added for IN:072715 start
			String allergy_override_select	= CommonBean.checkForNull(request.getParameter("allergy_remarks_code"));
			String dose_override_select	= CommonBean.checkForNull(request.getParameter("dose_remarks_code"));
			String dup_drug_override_select	= CommonBean.checkForNull(request.getParameter("currentrx_remarks_code"));
			String inter_override_select	= CommonBean.checkForNull(request.getParameter("interaction_remarks_code"));
			String food_inter_override_select	= CommonBean.checkForNull(request.getParameter("food_interaction_remarks_code"));
			String lab_inter_override_select	= CommonBean.checkForNull(request.getParameter("lab_interaction_remarks_code"));
			String disease_inter_override_select	= CommonBean.checkForNull(request.getParameter("disease_interaction_remarks_code"));//Added for MMS-DM-CRF-0229
			//Added for IN:072715 end
			if (request.getParameter("allergy") != null){
				allergy	= java.net.URLDecoder.decode(request.getParameter("allergy"),"UTF-8");
			}

			if (request.getParameter("exceed_dose") != null){
				exceed_dose	= java.net.URLDecoder.decode(request.getParameter("exceed_dose"),"UTF-8");
			}

			if (request.getParameter("dup_drug") != null){
				dup_drug =java.net.URLDecoder.decode(request.getParameter("dup_drug"),"UTF-8");
			}
			if (request.getParameter("interaction_remarks") != null){ // added for FD-RUT-CRF-0066.1 [IN036975]
				interaction_remarks =java.net.URLDecoder.decode(request.getParameter("interaction_remarks"),"UTF-8");
			}
			//Added for IN:072715 START
			Connection con			= null; 
				con				= ConnectionManager.getConnection(request);
			boolean over_ride_remarks_select_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");
			if(con != null)
				ConnectionManager.returnConnection(con,request);
			String sql="select REASON_CODE,REASON_DESC from PH_MEDN_TRN_REASON where APPL_TRN_TYPE=? AND EFF_STATUS='E'";
			ArrayList dose_override_params= new ArrayList();
			dose_override_params.add("BD");
			ArrayList allergy_override_params= new ArrayList();
			allergy_override_params.add("AO");
			ArrayList dup_drug_override_params= new ArrayList();
			dup_drug_override_params.add("DP");
			ArrayList inter_override_params= new ArrayList();
			inter_override_params.add("DD");
			ArrayList food_inter_override_params= new ArrayList();
			food_inter_override_params.add("DF");
			ArrayList lab_inter_override_params= new ArrayList();
			lab_inter_override_params.add("DL");
			//Added for IN:072715 END
			ArrayList disease_inter_override_params= new ArrayList();//Added for MMS-DM-CRF-0229
			disease_inter_override_params.add("DI");
			String bean_id				= "DirectDispensingBean" ;
			String bean_name			= "ePH.DirectDispensingBean";
			DirectDispensingBean bean	= (DirectDispensingBean)getBeanObject( bean_id,bean_name,request);
			//bean.setLanguageId(locale);
			//String or_bean_name			= "eOR.OrderEntryBean";
			//String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
			//OrderEntryBean orbean		= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request);
			//orbean.setLanguageId(locale);
			//String called_from		=	orbean.getCalledFromFunction();
			String disable_status	=	"";

			//if(called_from!=null && called_from.equals("RENEW_ORDER")) {
				//disable_status		=	"disabled";
			//}
			String pres_bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
			String pres_bean_name		= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 Pres_bean	= (PrescriptionBean_1)getBeanObject( pres_bean_id,pres_bean_name,request);
			String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean PresBean	= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);
			PresBean.setLanguageId(locale);
			Pres_bean.setLanguageId(locale);
			HashMap ext_drugData = null;
			String ext_drug_code ="", ext_srl_no="";
	/*		if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0864 - Start
				   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
					if(dose_unit_desc==null || dose_unit_desc=="" ) {
					  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
				     if(dosage_unit.split("/").length>=2){
					   dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
					 }
					
					} 
				}*/// Added for ML-MMOH-SCF-0863 - End, commentted for IN:070451
		    

			if (request.getParameter("allergy") == null && request.getParameter("exceed_dose") == null && request.getParameter("dup_drug") == null&& request.getParameter("interaction_remarks") == null) {
				ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
				
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData	=(HashMap) prescriptionDetails.get(j);
					ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no		=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){

						if(ext_drugData.containsKey("ALLERGY_REMARKS") && ext_drugData.get("ALLERGY_REMARKS")!=null) {
							allergy	=(String)ext_drugData.get("ALLERGY_REMARKS");
							//allergy		=	java.net.URLDecoder.decode(allergy,"UTF-8");
						}

						if(ext_drugData.containsKey("DOSE_REMARKS") && ext_drugData.get("DOSE_REMARKS")!=null) {
							exceed_dose	=(String)ext_drugData.get("DOSE_REMARKS");
							//exceed_dose	=	java.net.URLDecoder.decode(exceed_dose,"UTF-8");
						}

						if(ext_drugData.containsKey("CURRENTRX_REMARKS") && ext_drugData.get("CURRENTRX_REMARKS")!=null) {
							dup_drug	=(String)ext_drugData.get("CURRENTRX_REMARKS");
							//dup_drug	=	java.net.URLDecoder.decode(dup_drug,"UTF-8");
						}
						if(ext_drugData.containsKey("INTERACTION_REMARKS") && ext_drugData.get("INTERACTION_REMARKS")!=null ) { // added for FD-RUT-CRF-0066.1 [IN036975]
							interaction_remarks	=(String)ext_drugData.get("INTERACTION_REMARKS");
							//interaction_remarks =java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
						}//MMS-KH-CRF-0029[IN070606] - start
						if(ext_drugData.containsKey("FOOD_INTERACTION_REMARKS")) {
							food_interaction_remarks	=(String)ext_drugData.get("FOOD_INTERACTION_REMARKS")==null?"":(String)ext_drugData.get("FOOD_INTERACTION_REMARKS");
						}
						if(ext_drugData.containsKey("LAB_INTERACTION_REMARKS")) {
							lab_interaction_remarks	=(String)ext_drugData.get("LAB_INTERACTION_REMARKS")==null?"":(String)ext_drugData.get("LAB_INTERACTION_REMARKS");
						}
						//MMS-KH-CRF-0029[IN070606] - End
						if(ext_drugData.containsKey("DISEASE_INTERACTION_REMARKS")) {//modified for MMS-KH-CRF-0229
							disease_interaction_remarks	=(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS")==null?"":(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS");
						}
						//Added for IN:072715 START
					if(ext_drugData.containsKey("ALLERGY_REMARKS_CODE")) { 
						allergy_override_select	=(String)ext_drugData.get("ALLERGY_REMARKS_CODE")==null?"":(String)ext_drugData.get("ALLERGY_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("DOSE_REMARKS_CODE")) { 
						dose_override_select	=(String)ext_drugData.get("DOSE_REMARKS_CODE")==null?"":(String)ext_drugData.get("DOSE_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("CURRENTRX_REMARKS_CODE")) {
						dup_drug_override_select	=(String)ext_drugData.get("CURRENTRX_REMARKS_CODE")==null?"":(String)ext_drugData.get("CURRENTRX_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("INTERACTION_REMARKS_CODE")) { 
						inter_override_select	=(String)ext_drugData.get("INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("INTERACTION_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("FOOD_INTERACTION_REMARKS_CODE")) { 
						food_inter_override_select	=(String)ext_drugData.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("FOOD_INTERACTION_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("LAB_INTERACTION_REMARKS_CODE")) { 
						lab_inter_override_select	=(String)ext_drugData.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("LAB_INTERACTION_REMARKS_CODE");
					}
					//Added for IN:072715 END
				//	System.err.println("ext_drugData@@==="+ext_drugData);
					if(ext_drugData.containsKey("DISEASE_INTERACTION_REMARKS_CODE")) { //Added for MMS-DM-CRF-0229
						disease_inter_override_select	=(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS_CODE");
					}
						break;
					}
				}
			}

            _bw.write(_wl_block11Bytes, _wl_block11);

				if(allergy_yn.equals("Y")) {
					HashMap details = null;
					String allergic_indications	= "";
					ArrayList allergyDetails = PresBean.populateAllergyDetails(generic_id,patient_id);
					if((allergyDetails==null || allergyDetails.size()==0 )){
						String ATC_allergy = PresBean.getATCAllergyAlertGeneric(patient_id,generic_id);
						if(ATC_allergy!=null && !ATC_allergy.equals("0")){
							generic_id = ATC_allergy.substring(0,ATC_allergy.indexOf('~'));
							generic_name = ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
							allergyDetails = PresBean.populateAllergyDetails(generic_id,patient_id);
						}
					}
					for(int i=0;i<allergyDetails.size();i++){
						details=(HashMap) allergyDetails.get(i);
						if(!allergic_indications.equals(""))
							allergic_indications =  allergic_indications+" - ";
						allergic_indications = allergic_indications+(String)details.get("ALLERGIC_INDICATIONS"); //added allergic_indications+ for IN24641 --29/10/2010-- priya
					}
					if(!allergic_indications.equals("")) {

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(allergic_indications));
            _bw.write(_wl_block14Bytes, _wl_block14);
	
					}	

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getOverrideListValues(sql,allergy_override_params,allergy_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allergy));
            _bw.write(_wl_block25Bytes, _wl_block25);
 
				}
				if(limit_ind.equals("N")) {

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getOverrideListValues(sql,dose_override_params,dose_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(exceed_dose));
            _bw.write(_wl_block38Bytes, _wl_block38);
 
				}
				if(current_rx.equals("Y")) {
					ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
					HashMap  dup_info		=	null;
					String dup_drug_info	=	"";
					if(curr_info.size()>=1) {
						dup_info	  =	(HashMap)curr_info.get(0);
						dup_drug_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PatientisCurrentlyOn.label", "ph_labels")+" "+drug_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Medicationtill.label", "ph_labels")+"  "+com.ehis.util.DateUtils.convertDate((String)dup_info.get("end_date"),"DMYHM","en",locale)+";\n";
						dup_drug_info +=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Hasbeenprescribedby.label", "ph_labels")+" "+" "+dup_info.get("practitioner_name")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.from.label", "common_labels")+dup_info.get("location");
					}
					//if(!dup_drug_info.equals("")) {

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dup_drug_info));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getOverrideListValues(sql,dup_drug_override_params,dup_drug_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dup_drug));
            _bw.write(_wl_block45Bytes, _wl_block45);
 
				}
				if(interaction_exists.equals("Y")) { // added for FD-RUT-CRF-0066.1 [IN036975] -Start
				//MMS-KH-CRF-0029[IN070606] start
					String interaction_type = "";
					String intr_desc = "";
					ArrayList intrType= new ArrayList();
				//MMS-KH-CRF-0029[IN070606] end	

					ArrayList alDrugIntrList = (ArrayList) ext_drugData.get("INTERACTION_DTL");
					if(alDrugIntrList!=null && alDrugIntrList.size()>2){
						HashMap hmDrugInteractionDtl = null;
						for(int intr=0; intr<(alDrugIntrList.size()-2); intr++){
							hmDrugInteractionDtl = (HashMap) alDrugIntrList.get(intr);
							intr_msg_content += (String)hmDrugInteractionDtl.get("intr_name")+", ";
							//MMS-KH-CRF-0029[IN070606] start
							interaction_type = (String)hmDrugInteractionDtl.get("INTR_TYPE2");
							intrType.add(interaction_type);

							if(interaction_type.equals("F")){
									intr_desc = "Drug-Food";
								
							}
							else if(interaction_type.equals("L")){
									intr_desc = "Drug-Lab";
									
							}else if(interaction_type.equals("I")){//Added for MMS-DM-CRF-0229
									intr_desc = "Drug-Disease";
									
							}
							else{
									intr_desc = "Drug-Drug";
							}
						//MMS-KH-CRF-0029[IN070606] end	
						}
					}
					//MMS-KH-CRF-0029[IN070606] start
						String drug_drug_display = "none";
						String drug_food_display = "none";
						String drug_lab_display = "none";
						String drug_disease_display = "none";//Added for MMS-DM-CRF-0229
						String drug_intr_lbl_display="none";
						String food_intr_lbl_display="none";
						String lab_intr_lbl_display="none";
						String disease_intr_lbl_display="none";//Added for MMS-DM-CRF-0229

						if(intrType!=null && intrType.size()>0){
						if(intrType.contains("D") || intrType.contains("G")){
							drug_drug_display = "inline";
							
						}
						if(intrType.contains("F")){
							drug_food_display = "inline";
						}
						if(intrType.contains("L")){
							drug_lab_display = "inline"; 
						}
						if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
							drug_disease_display = "inline"; 
						}
						
						if(drug_drug_display.equals("inline"))
						{
							drug_intr_lbl_display ="inline";
							
						}else{
							if(drug_lab_display.equals("inline")){
								lab_intr_lbl_display="inline";
							}else if(drug_disease_display.equals("inline")){//Added for MMS-DM-CRF-0229
								disease_intr_lbl_display="inline";
							}else {
								food_intr_lbl_display="inline";
							}
						}
						
					} //MMS-KH-CRF-0029[IN070606] end
					if(!intr_msg_content.equals(""))
						intr_msg_content = intr_msg_content.substring(0, intr_msg_content.length()-2);

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drug_drug_display));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drug_drug_display));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getOverrideListValues(sql,inter_override_params,inter_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(drug_intr_lbl_display));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_drug_display));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_food_display));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(drug_food_display));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getOverrideListValues(sql,food_inter_override_params,food_inter_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(food_intr_lbl_display));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_food_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(food_interaction_remarks));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_lab_display));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drug_lab_display));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getOverrideListValues(sql,lab_inter_override_params,lab_inter_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(lab_intr_lbl_display));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_lab_display));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(lab_interaction_remarks));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(drug_disease_display));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drug_disease_display));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean.getOverrideListValues(sql,disease_inter_override_params,disease_inter_override_select) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(disease_intr_lbl_display));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_disease_display));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disease_interaction_remarks));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(drug_drug_display));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(drug_lab_display));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(drug_food_display));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(drug_disease_display));
            _bw.write(_wl_block74Bytes, _wl_block74);
 
				} // added for FD-RUT-CRF-0066.1 [IN036975] -End

            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
if(over_ride_remarks_select_appl){
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(allergy_override_select.equals("OTHR"))){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(dose_override_select.equals("OTHR"))){
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(dup_drug_override_select.equals("OTHR"))){
            _bw.write(_wl_block88Bytes, _wl_block88);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(inter_override_select.equals("OTHR"))){
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(food_inter_override_select.equals("OTHR"))){
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(lab_inter_override_select.equals("OTHR"))){
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!(disease_inter_override_select.equals("OTHR"))){
            _bw.write(_wl_block92Bytes, _wl_block92);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,PresBean,request); 
			}catch(Exception exception) {
			       exception.printStackTrace();
			 }

            _bw.write(_wl_block94Bytes, _wl_block94);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergicDescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergicOverrideReason.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergicDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DailyDose.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minimum.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitDose.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minimum.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BeyondDoseLimitOverrideReason.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateDrugOverrideReason.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateDrugs.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-DrugInteractions.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-DrugInteractionOverrideReason.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-FoodInteractions.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-FoodInteractionOverrideReason.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-LabInteractionOverrideReason.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-LabInteractionOverrideReason.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-DiseaseOverrideReason.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-DiseaseOverrideReason.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
