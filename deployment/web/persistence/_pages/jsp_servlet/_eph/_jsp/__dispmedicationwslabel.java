package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import eST.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationwslabel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationWSLabel.jsp", 1709120752676L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\t   \n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/dchk.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/DateUtils.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- Added for RollForward from SRR - SRR20056-SCF-9422 -->\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!-- <body topmargin=\"0\"> -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<form name=\"fromDispMedicationWSLabel\" id=\"fromDispMedicationWSLabel\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"103%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" style =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td  style =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">&nbsp;&nbsp;\n\t\t\t\t\t\t<select name=\"OrderType\" id=\"OrderType\" onchange=\"resetProductName()\">\n\t\t\t\t\t\t\t<option value=\"CR\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </option>\n\t\t\t\t\t\t\t<option value=\"IV\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t\t\t\t<option value=\"OA\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td >&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"mfg_unit\" id=\"mfg_unit\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" size=\"40\" maxlength=\"40\">\n\t\t\t\t\t\t<input type=\"button\" name=\"searchPrdName\" id=\"searchPrdName\" onclick=\"searchPrdCode()\" class=\"button\" value=\"?\" style =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" ></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  >&nbsp;&nbsp;\n\t\t\t\t\t\t<select name=\"batch_id\" id=\"batch_id\" id=\"batch_id\" onchange=\"bachChange(this)\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t<td >&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"batch_id\" id=\"batch_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" size=\"10\" maxlength=\"10\" onKeyPress=\"return  CheckForSpecialChars(event,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\" onblur=\"changeToSingleQuotes(this)\"><!--changed restrictAMP to CheckForSpecialChars for MMS-KH-CRF-0017-->\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<td >&nbsp;&nbsp;\n\t\t\t\t\t\t<select name=\"expiry_date\" id=\"expiry_date\"  id =\"expiry_date\" disabled >\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" ></img> <!-- <img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" ></img> Added for IN64820-->\n\t\t\t\t\t</td>\n\t\t\t\t</tr>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t<td >&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"expiry_date\" id=\"expiry_date\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" size=\"16\" maxlength=\"16\" onBlur=\"if(CheckDateLeap(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')) validateExpiryDate(this,today,\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\"> <!--CheckDateLeap Added RollForward from SRR - SRR20056-SCF-9422 -->\n\t\t\t\t\t\t<img SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'expiry_date\',null,\'hh:mm\',true);document.fromDispMedicationWSLabel.expiry_date.focus();return false;\" >\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"today\" id=\"today\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" size=\"16\" maxlength=\"16\" >\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t\t<td  class=\"label\">&nbsp;\n\t\t\t\t\t\t\t<input type=\"text\" name=\"qty_volume\" id=\"qty_volume\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" size=\"7\" maxlength=\"11\" onkeyPress=\'return allowValidNumber(this,event,6,4)\' onBlur=\"if(CheckNum(this)){return validateNumbers(this,6,4);}\" >&nbsp;<input type=\"text\" name=\"qty_uom\" id=\"qty_uom\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=\"6\" maxlength=\"6\"  onkeypress=\"return restrictAMP(event)\" onblur=\"changeToSingleQuotes(this)\"> <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 -->\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>&nbsp;&nbsp;\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<label class=\"label\" id=\"flow_rate\" name=\"flow_rate\" value=\"\"><b>&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp; ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/Hour</b></label> <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 -->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t\t<td  class=\"label\">&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<input type=\"text\" name=\"qty_volume\" id=\"qty_volume\" disabled value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" size=\"7\" maxlength=\"11\" onkeyPress=\'return allowValidNumber(this,event,6,4)\'  onBlur=\"if(CheckNum(this)){return validateNumbers(this,6,4);};\" >&nbsp;<input disabled  type=\"text\" name=\"qty_uom\" id=\"qty_uom\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" size=\"6\" maxlength=\"6\"   onkeypress=\"return restrictAMP(event)\" onblur=\"changeToSingleQuotes(this)\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>&nbsp;&nbsp; <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 --> \n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t <input type=\"text\" name=\"qty_volume\" id=\"qty_volume\"  value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" size=\"7\" maxlength=\"11\" onkeyPress=\'return allowValidNumber(this,event,6,4)\'  onBlur=\"if(CheckNum(this)){return validateNumbers(this,6,4);};\" >&nbsp;<input type=\"text\" name=\"qty_uom\" id=\"qty_uom\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" size=\"6\" maxlength=\"6\"   onkeypress=\"return restrictAMP(event)\" onblur=\"changeToSingleQuotes(this)\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>&nbsp;&nbsp; <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="/Hour</b></label> <!-- qty_uom Changed to beanAs.getUOMDesc(qty_uom) for ML-MMOH-SCF-1041  Modified for TBMC-SCF-0015 -->\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t    ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="/Hour</b></label> <!-- qty_uom Changed to beanAs.getUOMDesc(qty_uom) for ML-MMOH-SCF-1041  Modified for TBMC-SCF-0015 -->\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t<!-- <tr>\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td >&nbsp;&nbsp;\n\t\t\t<input type=\"text\" name=\"qty_uom\" id=\"qty_uom\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" size=\"15\" maxlength=\"15\">\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img> \n\t\t</td>\n\t</tr> -->\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t\t<td >&nbsp;&nbsp;\n\t\t\t\t\t\t<textarea cols=\"31\" rows=\"2\" name=\"Admin_Inst\" onkeypress=\"return restrictAMP(event);\" onblur=\"changeToSingleQuotes(this);return ChkMaxLen(\'Administration Instruction\',this,60,\'\'); \" >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</textarea>\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<Td   class=\"label\" >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</Td>\n\t\t\t\t\t\t<Td   colspan=1>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t<SELECT name=\"infusion_line\" id=\"infusion_line\" id=\"infusion_line\" disabled>\n\t\t\t\t\t\t\t\t<OPTION value=\"C\" Selected>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</OPTION>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t   <SELECT name=\"infusion_line\" id=\"infusion_line\" id=\"infusion_line\">\n\t\t\t\t\t\t   <OPTION value=\"C\" >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</OPTION>\n\t\t\t\t\t\t   <OPTION value=\"P\" Selected>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t</SELECT>\n\t\t\t\t\t\t</Td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" style=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'><b>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" ?</b></td>\n\t\t\t\t\t<td style=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"finalise_yn\" id=\"finalise_yn\"  value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" onclick=\"assignValue(this)\" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"white\" colspan=\"2\" align=\'right\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"btnOK\" id=\"btnOK\" value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' class=\"button\" onClick=\"saveMFGLabelDetails(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t</table>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn\" id=\"disp_locn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"worksheet_id\" id=\"worksheet_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"prep_qty_volume\" id=\"prep_qty_volume\"\t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name=\"overage_volume\" id=\"overage_volume\"\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\"hidden\" name=\"infuse_over\" id=\"infuse_over\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\'hidden\' name=\"ord_type\" id=\"ord_type\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t<!--    <input type=\'hidden\' name=\"language_id\" id=\"language_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"> Commented for RollForward from SRR - SRR20056-SCF-9422 -->\n\t\t\t<input type=\"hidden\" name=\"searchSQL\" id=\"searchSQL\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" >\n\t\t\t<input type=\"hidden\" name=\"UpdateMFGDetails\" id=\"UpdateMFGDetails\"\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t\t\n\t\t</form>\n\t</body>\n</html>\n<script>\n\tdocument.fromDispMedicationWSLabel.OrderType.selectedIndex = ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =";\n</script>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );
	
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


	public String roundTwoDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3){
					bb=a.substring(0,a.indexOf(".")+3);
				}
				else{
					bb=a;
				}
			}
			return bb;
		}
		catch (Exception e){
			return a;
		}
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

/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);

Connection con			= null;  // Added for ML-MMOH-crf-0468 

		try{
		//String params = request.getQueryString();
		con				= ConnectionManager.getConnection(request);  // Added for ML-MMOH-crf-0468 
        boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468
		boolean verify_adm_drug = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VERIFY_ADM_DRUG");// added for MMS-KH-CRF-0017
		verify_adm_drug = true;
		String mode				= "";
		String order_id1	    = request.getParameter( "order_id" );
		if(order_id1 == null) 
		order_id1 = "";
		String ord_type			= "";

		String	bean_id			=	"DispMedicationBean" ;
		String	bean_name		=	"ePH.DispMedicationBean";
		DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);
		//bean.setLanguageId(locale);

		String	bean_id1				=	"DispMedicationAllStages" ;
		String	bean_name1				=	"ePH.DispMedicationAllStages";
		DispMedicationAllStages beanAs	= (DispMedicationAllStages)getBeanObject( bean_id1, bean_name1, request);
		//beanAs.setLanguageId(locale);

		String bean_id2			 = "TPNWorkSheetBean";
		String bean_name2		 = "ePH.TPNWorkSheetBean";
		TPNWorkSheetBean bean_ws = (TPNWorkSheetBean)getBeanObject(bean_id2,bean_name2,request);
		bean_ws.setLanguageId(locale);

		ord_type	=	bean.getOrderType();
		mode		=	bean.getDispStage();
		String disp_locn1	=	bean.getDispLocnCode();
		String today		=	bean.getTodaysDateTime();
		String order_id		=	bean.getOrderID();	

		if(order_id.equals("")){
			order_id = bean.getOrderID1();
		}

		String sUpdateMFGDetails = "N";
		String disp_locn_catg	 = bean.getDispLocnCatg();
		if(( (bean.getDispStage().equals("F") && bean.getFillingStatus().equals("A"))|| (bean.getDispStage().equals("A") && bean.getFillingStatus().equals("B")))&&(!disp_locn_catg.equals("I"))){
			 sUpdateMFGDetails ="Y";
		}

		String product_name		 = "";
		String batch_id			 = "";
		String expire_date		 = "";
		String qty_value		 = "";
		String qty_uom			 = "";
		String stability_hrs	 = "";
		String tmp_stb_hrs		 = "";
		String facility_id		 = "";
		String disp_locn		 = "";
		String worksheet_id		 = "";
		String admin_remarks	 = "";
		String infusion_line	 = "";
		String batch_wrksht_id	 = "";
		String overage_volume    ="";
		String flow_rate		 = "";
		String infuse_over		 = "";
		String batchIpOptions="";//Added for ml-mmoh-crf-0468
		String expieryDateOptions="";//Added for ml-mmoh-crf-0468
		ArrayList manfctr_dtls = new ArrayList();
		ArrayList drugDtls = new ArrayList();
		HashMap drugValues = new HashMap();
		String finalise_yn_deli =  "";
		String finalise_yn_val  =  "N";
		String finalised_style="";
		String tpn_param_expiary_date ="";
		String display_legends ="visibility:visible";

		if(mode.equals("D")||disp_locn_catg.equals("O")){
			finalise_yn_deli = "checked disabled"; 
			//if((bean.getDispStage().equals("F") && (bean.getFillingStatus().equals("A")  ))|| (bean.getDispStage().equals("A") && (bean.getFillingStatus().equals("B")  ))||(bean.getDispStage().equals("D"))){
				finalise_yn_val  = "Y";
			//}
		}
		if(disp_locn_catg.equals("O")){
			finalised_style  ="Display:none";
		}
		if(!mode.equals("D")){
			if(ord_type.equals("IVAD")||ord_type.equals("IVAA") || ord_type.equals("IVID")||ord_type.equals("IVIA") || ord_type.equals("CA") || ord_type.equals("CO")){
				batch_wrksht_id = bean.getWorksheetID();
					if(batch_wrksht_id.equals("")) { 
						batch_wrksht_id = bean.getNxtWrkshtId("IVRCA",disp_locn1);
					} 
				batch_id = batch_wrksht_id +"/"+today.substring(6,10);
			}
			else if(ord_type.equals("TA")  || (ord_type.equals("TD") && tpn_mf_label) ) {//modified for ml-mmoh-crf-0468
				batch_wrksht_id = bean.getTPNWorksheetID(order_id);
				if(batch_wrksht_id.equals("")) { 
					batch_wrksht_id = bean.getNxtWrkshtId("TPN",disp_locn1);
				} 
				batch_id = batch_wrksht_id +"/"+today.substring(6,10);
			}
		}

		if(ord_type.equals("IVAA")||ord_type.equals("IVAD") || ord_type.equals("IVIA")||ord_type.equals("IVID") || ord_type.equals("CA") || ord_type.equals("CO")){

			if(!mode.equals("D")){
				manfctr_dtls = bean.getManufactureDetails(order_id);
				if(!ord_type.equals("CO")){
					product_name = product_name + "Mixture of ";
					product_name = product_name + (String)manfctr_dtls.get(1);
					product_name = product_name + " injection";
				}

				if(manfctr_dtls.size()>1){	
					drugDtls =(ArrayList)manfctr_dtls.get(2);

					for(int i=0; i<drugDtls.size(); i++){
						drugValues = (HashMap)drugDtls.get(i);
						tmp_stb_hrs	= (String)drugValues.get("STABILITY_HRS");
					
						if(tmp_stb_hrs != null && !tmp_stb_hrs.equals("0") ){
						  if(stability_hrs.equals("")) stability_hrs = 	(String)drugValues.get("STABILITY_HRS");
						  tmp_stb_hrs = (String)drugValues.get("STABILITY_HRS");
						  if(Integer.parseInt(tmp_stb_hrs) < Integer.parseInt(stability_hrs)) stability_hrs = tmp_stb_hrs;
						}else{
							stability_hrs="0";
						}
					}
				}
				if(Integer.parseInt(stability_hrs) >0) 
					expire_date = bean.getExpireDateMixture(stability_hrs);
				drugDtls	=(ArrayList)manfctr_dtls.get(0); 
				String fluid_line =(String)drugDtls.get(1);
				if(!ord_type.equals("CO")){
					if(fluid_line.equals("1")) qty_value = (String)drugDtls.get(2);
				}
				drugDtls =(ArrayList)manfctr_dtls.get(2); 
				drugValues = (HashMap)drugDtls.get(0);
				if(!ord_type.equals("CO")){
					qty_uom = (String)drugValues.get("PRES_BASE_UOM");
				}

			   manfctr_dtls = bean.getMfctrLabelDtls(order_id);	
			   if(manfctr_dtls.size() > 0){
					facility_id		= (String)manfctr_dtls.get(0);
					disp_locn		= (String)manfctr_dtls.get(1);
					worksheet_id	= (String)manfctr_dtls.get(2);
					product_name	= (String)manfctr_dtls.get(3);
					batch_id		= (String)manfctr_dtls.get(4);
					expire_date		= (String)manfctr_dtls.get(5);
					qty_value		= (String)manfctr_dtls.get(6);
					qty_uom			= (String)manfctr_dtls.get(7);
					admin_remarks	= (String)manfctr_dtls.get(8);

					if(facility_id==null || facility_id=="null") 
						facility_id="";

					if(disp_locn==null || disp_locn=="null")
						disp_locn="";

					if(worksheet_id==null || worksheet_id=="null")
						worksheet_id="";

					if(product_name==null || product_name=="null")
						product_name="";

					if(batch_id==null || batch_id=="null")
						batch_id="";

					if(expire_date==null || expire_date=="null") 
						expire_date="";

					if(qty_value==null || qty_value=="null")
						qty_value="1";

					if(qty_uom==null || qty_uom=="null") 
						qty_uom="";

					if(admin_remarks==null || admin_remarks=="null") 
						admin_remarks="";			
				}
			}
			else{
				manfctr_dtls = bean.getMfctrLabelDtls(order_id1);	
				worksheet_id=bean.getWorksheetID();

				if(manfctr_dtls.size() > 0){
					facility_id		= (String)manfctr_dtls.get(0);
					disp_locn		= (String)manfctr_dtls.get(1);
					worksheet_id	= (String)manfctr_dtls.get(2);
					product_name	= (String)manfctr_dtls.get(3);
					batch_id		= (String)manfctr_dtls.get(4);
					expire_date		= (String)manfctr_dtls.get(5);
					qty_value		= (String)manfctr_dtls.get(6);
					qty_uom			= (String)manfctr_dtls.get(7);
					admin_remarks	= (String)manfctr_dtls.get(8);

					if(facility_id==null || facility_id=="null") 
						facility_id="";

					if(disp_locn==null || disp_locn=="null")
						disp_locn="";

					if(worksheet_id==null || worksheet_id=="null")
						worksheet_id="";

					if(product_name==null || product_name=="null")
						product_name="";

					if(batch_id==null || batch_id=="null")
						batch_id="";

					if(expire_date==null || expire_date=="null") 
						expire_date="";

					if(qty_value==null || qty_value=="null")
						qty_value="1";

					if(qty_uom==null || qty_uom=="null") 
						qty_uom="";

					if(admin_remarks==null || admin_remarks=="null") 
						admin_remarks="";			
				}
			}
			infuse_over		= bean_ws.getInfuseOver(order_id);
			if(!ord_type.equals("CO")){
				flow_rate		= (Float.parseFloat(qty_value) /Float.parseFloat(infuse_over))+"";
				flow_rate		= roundTwoDigits(flow_rate); 
			}
			tpn_param_expiary_date="";
		}
		else if(ord_type.equals("TA")) {
			manfctr_dtls = bean.getManufactureDetailsTPN(order_id,disp_locn1);	
			expire_date = bean_ws.getTPNExpDate();
			tpn_param_expiary_date =expire_date;
			if(manfctr_dtls.size() > 0){
				facility_id		= (String)manfctr_dtls.get(0);
				disp_locn		= (String)manfctr_dtls.get(1);
				worksheet_id	= (String)manfctr_dtls.get(2);
				product_name	= (String)manfctr_dtls.get(3);
				batch_id		= (String)manfctr_dtls.get(4);
				expire_date		= (String)manfctr_dtls.get(5);
				qty_value		= (String)manfctr_dtls.get(6);
				qty_uom			= (String)manfctr_dtls.get(7);
				admin_remarks	= (String)manfctr_dtls.get(8);
				infusion_line	= (String)manfctr_dtls.get(9);
				if(facility_id==null || facility_id=="null")
					facility_id="";

				if(disp_locn==null || disp_locn=="null") 
					disp_locn="";

				if(worksheet_id==null || worksheet_id=="null") 
					worksheet_id="";

				if(product_name==null || product_name=="null") 
					product_name="";

				if(batch_id==null || batch_id=="null") 
					batch_id="";

				if(expire_date==null || expire_date=="null") 
					expire_date="";

				if(qty_value==null || qty_value=="null")
					qty_value="1";

				if(qty_uom==null || qty_uom=="null") 
					qty_uom="";
				if(admin_remarks==null || admin_remarks=="null") 
					admin_remarks="";
			}
			
			if(qty_value.equals("")) //Added for ICN-35047[ReOpen]-Start
				qty_value	= beanAs.getTPNQty();
			if(qty_value.equals(""))
				qty_value = "0";   //Added for ICN-35047[ReOpen]-end

			if(!mode.equals("D")){
				if(qty_value.equals("")){
					qty_value		= beanAs.getTPNQty();
				}

				qty_uom	= bean_ws.getPrescBaseUnit();

				if(product_name.equals("")){
					product_name	= bean.getTPNNonStdRegimenDesc(order_id);
				}
				if(infusion_line.equals("")){
					infusion_line   = bean.getInfusionLine(order_id);
				}
			}
			overage_volume	= beanAs.getOverageVol();
			if(overage_volume == null || overage_volume.equals("")){
				overage_volume = "";
				bean_ws.setOverageVolume(order_id);
				overage_volume	= bean_ws.getOverageVolume();
						if(overage_volume == null || overage_volume.equals("")){ overage_volume = "0";}
			}
			infuse_over		= bean_ws.getInfuseOver(order_id);
			flow_rate		= ((Float.parseFloat(qty_value) - Float.parseFloat(overage_volume))/Float.parseFloat(infuse_over))+"";
			flow_rate		= roundTwoDigits(flow_rate);
			display_legends  ="visibility:hidden";
		}
		//Added for ml-mmoh-crf-0468 start
	if( ord_type.equals("TD") && tpn_mf_label)	{ 
		System.out.println("order_id1"+order_id1);
		System.out.println("helllooooooooooo"+ bean.getManufactureDetailsTPN(order_id1,disp_locn1));	
		
		//prathyusha
		System.out.println("label page -->"+beanAs.getDrugDetail(bean.getPatientID(), order_id1, "1"));
		manfctr_dtls = bean.getManufactureDetailsTPN(order_id,disp_locn1);	
		
//label page -->[TPN, EWQ, 30/12/2017, 10, ML, , ALPRANAX, 02, 0.0, ML, TPN, SFSFS, 25/04/2018, 29, ML, , ALPRANAX, 02, 0.0, ML]
		ArrayList BatchDetails = new ArrayList();
BatchDetails = beanAs.getDrugDetail(bean.getPatientID(), order_id1 , "1");
System.out.println("helllooooooooooo2BatchDetails"+ BatchDetails);	
int batch_size = BatchDetails.size();
int tc=batch_size/10;
int temp_qty=0;
manfctr_dtls = bean.getManufactureDetailsTPN(order_id1,disp_locn1);	
expire_date = bean_ws.getTPNExpDate();
tpn_param_expiary_date =expire_date;
if(manfctr_dtls.size() > 0 && batch_size == 0){
	facility_id		= (String)manfctr_dtls.get(0);
	disp_locn		= (String)manfctr_dtls.get(1);
	worksheet_id	= (String)manfctr_dtls.get(2);
	product_name	= (String)manfctr_dtls.get(3);
	batch_id		= (String)manfctr_dtls.get(4);
	expire_date		= (String)manfctr_dtls.get(5);
	qty_value		= (String)manfctr_dtls.get(6);
	qty_uom			= (String)manfctr_dtls.get(7);
	admin_remarks	= (String)manfctr_dtls.get(8);
	infusion_line	= (String)manfctr_dtls.get(9);
	if(facility_id==null || facility_id=="null")
		facility_id="";

	if(disp_locn==null || disp_locn=="null") 
		disp_locn="";

	if(worksheet_id==null || worksheet_id=="null") 
		worksheet_id="";

	if(product_name==null || product_name=="null") 
		product_name="";

	if(batch_id==null || batch_id=="null") 
		batch_id="";

	if(expire_date==null || expire_date=="null") 
		expire_date="";

	if(qty_value==null || qty_value=="null")
		qty_value="1";

	if(qty_uom==null || qty_uom=="null") 
		qty_uom="";
	if(admin_remarks==null || admin_remarks=="null") 
		admin_remarks="";
	
	batchIpOptions  =batchIpOptions+"<option value='"+batch_id+"' selected>"+batch_id+"</option>";
    expieryDateOptions  =expieryDateOptions+"<option value='"+expire_date+"' selected>"+expire_date+"</option>"; 
    temp_qty = Integer.parseInt(qty_value);
}
else{
System.out.println("if  batch_size"+batch_size);
for(int i=1;i<batch_size;i=i+10){
	if(i==1){
		batchIpOptions  =batchIpOptions+"<option value='"+(String) BatchDetails.get(i)+"' selected>"+(String) BatchDetails.get(i)+"</option>";
		expieryDateOptions  =expieryDateOptions+"<option value='"+(String) BatchDetails.get(i+1)+"' selected>"+(String) BatchDetails.get(i+1)+"</option>";
	   
	}
	else{
		
		batchIpOptions  =batchIpOptions+"<option value='"+(String) BatchDetails.get(i)+"'>"+(String) BatchDetails.get(i)+"</option>";
		expieryDateOptions  =expieryDateOptions+"<option value='"+(String) BatchDetails.get(i+1)+"'>"+(String) BatchDetails.get(i+1)+"</option>";
	}
	
	qty_value =(String) BatchDetails.get(i+2);
	
	temp_qty +=Integer.parseInt(qty_value);  
	qty_uom = (String) BatchDetails.get(i+3);
	
}
}

            qty_value = ""+temp_qty;

				if(!mode.equals("D")){
			if(qty_value.equals("")){
				qty_value		= beanAs.getTPNQty();
			}

			//qty_uom	= bean_ws.getPrescBaseUnit();//commented for ML-MMOH-SCF-1303

			if(product_name.equals("")){
				product_name	= bean.getTPNNonStdRegimenDesc(order_id1);
			}
			if(infusion_line.equals("")){
				infusion_line   = bean.getInfusionLine(order_id1);
			}
		}
		overage_volume	= beanAs.getOverageVol();
		if(overage_volume == null || overage_volume.equals("")){
			overage_volume = "";
			bean_ws.setOverageVolume(order_id);
			overage_volume	= bean_ws.getOverageVolume();
					if(overage_volume == null || overage_volume.equals("")){ overage_volume = "0";}
		}
		infuse_over		= bean_ws.getInfuseOver(order_id1);
		flow_rate		= ((Float.parseFloat(qty_value) - Float.parseFloat(overage_volume))/Float.parseFloat(infuse_over))+"";
		flow_rate		= roundTwoDigits(flow_rate);
		display_legends  ="visibility:hidden";
		}
				//Added for ml-mmoh-crf-0468 end
		boolean showHideExtraColumns = true;
		int iSelectedIndex	=	2;
	   if(ord_type.equals("CO"))
			iSelectedIndex	=	0;
		else if(ord_type.equals("CA"))
			iSelectedIndex	=	2;
		else
			iSelectedIndex	=	1;
//out.println("=== ord_type $"+ord_type+"$ "+ ord_type.equals("CO") + " == iSelectedIndex "+ iSelectedIndex);

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(display_legends));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_legends));
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

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(product_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(display_legends));
            _bw.write(_wl_block20Bytes, _wl_block20);
	if( ord_type.equals("TD") && tpn_mf_label )	{//IF condtion added for ml-mmoh-crf-0468 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(batchIpOptions));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
				else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(verify_adm_drug));
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
				
            _bw.write(_wl_block28Bytes, _wl_block28);
if(ord_type.equals("TD") && tpn_mf_label){ //IF condtion added for ml-mmoh-crf-0468  
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(expieryDateOptions));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
				else{
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expire_date,"DMYHM","en",locale)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tpn_param_expiary_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(today));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(ord_type.equals("TA")){

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(flow_rate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)));
            _bw.write(_wl_block44Bytes, _wl_block44);

				}
				else{

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
	 if( ord_type.equals("TD") && tpn_mf_label)	{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)));
            _bw.write(_wl_block48Bytes, _wl_block48);

                             }
							 else{ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)));
            _bw.write(_wl_block51Bytes, _wl_block51);
	}
						if(!ord_type.equals("CO")){if( ord_type.equals("TD") && tpn_mf_label)	{//ADDED FOR ML-MMOH-SCF-1303

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(flow_rate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(beanAs.checkForNull(beanAs.getUOMDesc(bean_ws.getPrescBaseUnit()),bean_ws.getPrescBaseUnit())));
            _bw.write(_wl_block53Bytes, _wl_block53);

						}else{
	
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(flow_rate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)));
            _bw.write(_wl_block55Bytes, _wl_block55);
						
						}}

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block58Bytes, _wl_block58);

				}

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(admin_remarks));
            _bw.write(_wl_block60Bytes, _wl_block60);

				if(ord_type.equals("TA") || ( ord_type.equals("TD") && tpn_mf_label )  ) { //modified for ml-mmoh-crf-0468

            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
 
						if (infusion_line.equals("C")){

            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

						}
						else{

            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

						}

            _bw.write(_wl_block67Bytes, _wl_block67);
 
				}

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(finalised_style));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(finalised_style));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(finalise_yn_val));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(finalise_yn_deli));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block75Bytes, _wl_block75);
 
			String searchSQL = "SELECT product_code code, short_desc description  FROM ph_admixture_products_lang_vw WHERE UPPER (product_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) AND language_id = '"+bean.getLanguageId()+"' AND eff_status = 'E' AND admixture_type IN "; 

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(disp_locn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(worksheet_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(overage_volume));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bean.getLanguageId()));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(searchSQL));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sUpdateMFGDetails));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(iSelectedIndex));
            _bw.write(_wl_block90Bytes, _wl_block90);

//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id1,beanAs,request);
putObjectInBean(bean_id2,bean_ws,request);
}catch(Exception e){
	e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-0468 start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-SCF-0468 end


            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ManufacturingLabelDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CompoundingOrder.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IVAdmixture.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OncologyAdmixture.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProductName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExpiryDate/Time.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ExpiryDate/Time.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreparedQty/UOM.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreparedQty.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyUOM.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationInstruction.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionLine.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Peripheral.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Finaliseworksheet.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
}
