package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eMR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __addnoteparam extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/addNoteParam.jsp", 1742377233009L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../js/NoteParameter.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n</head>\n<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\' onLoad=\"Focusing(\'days_back_date\')\">\n<form name=\"note_param_form\" id=\"note_param_form\" action=\"../../servlet/eCA.NoteParamServlet\" method=\"post\" target=\"messageFrame\">\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<BR><BR><BR><BR><BR>\n\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'75%\' align=\'center\'>\n\t\n\t\n\t<tr>\n\t  <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t  <td width=\"50%\" colspan=\"2\" class=\'fields\'>&nbsp;<input type=\"text\" name=\"days_back_date\" id=\"days_back_date\" size=\"2\" maxlength=\"2\" onKeyPress=\"return (allowValidNumber(this,event,2,0))\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" value = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" OnBlur=\"checkSequence(this);CheckNum(this)\" >&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<img src=\'../../eCommon/images/mandatory.gif\'>\n\t  </td>\n\t</tr>\n\n\t<tr>\n\t  <td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t  <td width=\"50%\"  colspan=\"2\" class=\'fields\'>&nbsp;<input type=\'text\'  name=\'xsl_flder\' id=\'xsl_flder\'  value =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' size=\'50\' maxlength=\'200\'></td>\n\t</tr>\n\n\t<tr>\n\t  <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t  <td width=\"50%\" colspan=\"2\" class=\'fields\'>&nbsp;<input type=\"text\" name=\"file_size\" id=\"file_size\" size=\"8\" maxlength=\"8\" onKeyPress=\"return (allowValidNumber(this,event,2,0))\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" OnBlur=\"checkSequence(this);CheckNum(this);checkRange(this)\" >\n\t  \n\t  \n\n\t\t  <select name=\"email_size_unit\" id=\"email_size_unit\" onchange=\'checkRange()\'>\n\n\t\t\t  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t  <option value=\'K\' selected>KB</option>\n\t\t   <option value=\'M\'>MB</option></select></td>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t  <option value=\'K\' >KB</option>\n\t\t  <option value=\'M\'selected>MB</option></select></td>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</tr>\n\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"print_discharge\" id=\"print_discharge\" value =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="   onclick=\"OndischargeChange(this)\" ></td>\n \t</tr>\n\t<!-- Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t<td colspan=\"2\" class=\'fields\'>&nbsp;<input type=\"text\" name=\'txtMaxNoImgAllowed\' id=\'txtMaxNoImgAllowed\' size=\'3\' maxlength=\'2\' onkeypress=\'return (allowValidNumber(this,event,2,0))\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onblur=\'checkNumber(this)\'></td>\n \t</tr>\n\t<!--IN029312 Starts-->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"print_eventheader\" id=\"print_eventheader\" value =\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="   onclick=\"OnclinicalEvthdrChange(this)\" ></td>\n \t</tr>\n\t<!--IN029312 Ends-->\n\t<!-- ends here. -->\n\t<!--[IN031116] Starts-->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"hdrfoot_margin\" id=\"hdrfoot_margin\" value =\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="   onclick=\"OnHdrFooterChange(this)\" ></td>\n \t</tr>\n\t<!--[IN031116] Ends-->\n\t<!-- IN030419 Starts -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"LogoHeaderForAllPages\" id=\"LogoHeaderForAllPages\" value =\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="   onclick=\"OnlogoHdrChange(this)\" ></td>\n \t</tr>\n \t<!-- IN068669 starts -->\n \t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>&nbsp;\n\t\t<td colspan=\"2\" align=\'left\'>\n\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'250px\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"15%\" class=\"label\" align=\'left\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t<td width=\"20%\" align=\'left\'>\n\t\t\t\t\t\t<input type=\"text\" name=\"logo_header_hght\" id=\"logo_header_hght\"  size=\'2\' maxlength=\'2\' onKeyPress=\"return (allowValidNumber(this,event,2,0))\" value = \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onclick=\"OnlogoHdrChange(this)\" onblur=\"checkNumberRange(this)\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"10%\" class=\"label\" align=\'left\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\t\n\t\t\t\t\t<td width=\"10%\">&nbsp;&nbsp;</td>\t\t\t\n\t\t\t\t\t<td width=\"15%\" class=\"label\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td> \n\t\t\t\t\t<td colspan=\"20%\" align=\'left\'>\n\t\t\t\t\t\t<input type=\"text\" name=\"logo_header_width\" id=\"logo_header_width\"  size=\'2\' maxlength=\'2\' onKeyPress=\"return (allowValidNumber(this,event,2,0))\" value =\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t</tr>\n\t\t\t</table>\t\t\t\n\t\t</td>\n\t</tr>\n \t<!-- IN068669ends -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"ReportHeaderForAllPages\" id=\"ReportHeaderForAllPages\" value =\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="   onclick=\"OnRptHdrChange(this)\" ></td>\n \t</tr>\n \t<!-- IN029712 Starts -->\n \t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"SpellChecker\" id=\"SpellChecker\" value = ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" onclick =\"OnSpellCheckerChange(this)\"></td>\n\t</tr>\t\n\t<tr id=\"SpellCheckDefOptId\" style=\"display:none\">\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<td colspan=\"2\" align=\'left\' class=\"label\"><input type=\"radio\" name=\"SpellCheckDefOpt\" id=\"SpellCheckDefOpt\" value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" id=\"pop\" name=\"pop\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" onclick=\"spellCheckerDefaultChange(this)\"> ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t</tr>\n\t<tr id=\"SpellCheckDefOptId1\" style=\"display:none\">\n\t\t<td width=\"25%\" class=\"label\"></td>\n\t\t<td colspan=\"1\" align=\'left\' class=\"label\"><input type=\"radio\" name=\"SpellCheckDefOpt\" id=\"SpellCheckDefOpt\" value= ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" id=\"inl\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" onclick=\"spellCheckerDefaultChange(this)\" >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t</tr>\n\t<!-- IN029712 Ends -->\n\t<!-- IN030419 Ends -->\n\t<!-- IN039182 Start-->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"ResultLinkSensitiveDia\" id=\"ResultLinkSensitiveDia\" value = ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" onclick =\"linkSensitiveChange(this)\"></td>\n\t</tr>\t\n\t<!-- IN039182 Ends -->\n\t\n\t<!-- IN043031 -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"text\" name=\"vw_PREV_NOTE_DAYS\" id=\"vw_PREV_NOTE_DAYS\" size=\'3\' maxlength=\'2\' onkeypress=\'return (allowValidNumber(this,event,2,0))\' value = ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" onblur=\'CheckPositiveNumber(this)\'></td>\n\t</tr>\t\n\t<!-- IN043031 Ends -->\n\t\n\t<!-- IN041284 Start -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"display_result_linkin_HTML\" id=\"display_result_linkin_HTML\" value = ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" onclick =\"DisplayResultLinkinHTMLChange(this)\"></td>\n\t</tr>\n\t<!-- IN004500 Start -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t <td width=\"50%\"  colspan=\"2\" class=\'fields\'>&nbsp;<input type=\'text\' name=\'display_disclaimer_text_print\' id=\'display_disclaimer_text_print\'  value =\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' size=\'50\' maxlength=\'250\'></td>\n\t</tr>\t\n\t<!-- IN004500 Ends -->\n\t<!-- IN041284 Ends -->\n\t<!--  MO_CRF_20102[IN055439]  Start --> \t\t\n\t<tr> \n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"text_format_default_yn\" id=\"text_format_default_yn\" value = ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" onclick =\"checkTextFormatDflt(this)\"></td>\n\t</tr>\n\t<!--  MO_CRF_20102[IN055439]  End -->\n\n\t<!-- JD-CRF-0199 [IN059747] - Start -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"amend_result_note_yn\" id=\"amend_result_note_yn\" value =";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" onclick =\"checkAmendClinResultNote(this)\"></td>\n\t</tr>\n\t<!-- JD-CRF-0199 [IN059747] - End -->\n\t<!-- ML-MMOH-CRF-0534 [IN061882] - Start -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"disable_ref_range_yn\" id=\"disable_ref_range_yn\" value =";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" onclick =\"checkDispRefRange(this)\"></td>\n\t</tr>\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"disable_spec_type_yn\" id=\"disable_spec_type_yn\" value =";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" onclick =\"checkDispSpecType(this)\"></td>\n\t</tr>\t\t\n\t<!-- ML-MMOH-CRF-0534 [IN061882] - End -->\n\t<!-- ML-MMOH-CRF-0534.1 [IN063865] - Start -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"datetime_format_yn\" id=\"datetime_format_yn\" value =";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" onclick =\"checkDateTimeFormat(this)\"></td>\n\t</tr>\n\t<!-- ML-MMOH-CRF-0534.1 [IN063865] - End -->\n\t<!-- KDAH-CRF-0431 [IN063931] - starts -->\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t<td width=\"50%\"  colspan=\"2\" class=\'fields\'>&nbsp;<input type=\'text\' name=\'noofenc_copyprevnotes\' id=\'noofenc_copyprevnotes\'  value =\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' size=\'1\' maxlength=\'1\' onkeypress=\'return (allowValidNumber(this,event,1,0))\' onblur=\'checkNumber(this)\'></td>\n\t</tr>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<!-- ML-MMOH-CRF-0807 [IN063798] - Start -->\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n<!-- IN066108 start -->\n\t\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"access_inError_yn\" id=\"access_inError_yn\" value =";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" onclick =\"checkInError(this)\"></td>\n\t</tr>\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" name=\"accessRightsUnsignedNotes_yn\" id=\"accessRightsUnsignedNotes_yn\" value =";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" onclick =\"checkUnsign(this)\"></td>\n\t</tr>\n\t\n\t<!-- IN071264 starts -->\n\t\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t<td colspan=\"2\" align=\'left\'><input type=\"checkbox\" id=\"allowAutoSaveInNotes_yn\" name=\"auto_Save_YN\" id=\"auto_Save_YN\" value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' onclick =\"checkAutoSave(this)\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="></td>\n\t</tr>\n\t\n\t<tr id=\'allowAutoSaveForEvery\' style=\"display:none;\">\n\t  <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t  <td width=\"50%\" colspan=\"2\" class=\'fields\'>&nbsp;<input type=\"text\" name=\"auto_Save_Time\" id=\"auto_Save_Time\" value= \'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' size=\"1\" maxlength=\"1\" onKeyPress=\"return isValidInteger();return allowValidNumber(this, event,1,0)\" onBlur=\"copyPasteChk(this);checkForMandatory(this);\" >&nbsp;";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="<img src=\'../../eCommon/images/mandatory.gif\'>\n\t  </td>\n\t</tr>\n\t<!-- IN071264 ends -->\n\t<tr><!--7605 starts-->\n\t  <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t  <td width=\"50%\" colspan=\"2\" class=\'fields\'>&nbsp;<input type=\"checkbox\" name=\"disp_note_description\" id=\"disp_note_description\" value= \'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" onclick=\"SelectBox(this);\" >\n\t  </td>\n\t</tr><!--7605 ends-->\n\t<!-- 6484 starts -->\n\t<tr> \n\t  <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t  <td width=\"50%\" colspan=\"2\" class=\'fields\'>&nbsp;<input type=\"checkbox\" name=\"comp_note_content_YN\" id=\"comp_note_content_YN\" value= \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" onclick=\"checkBox(this);\" >\n\t  </td>\n\t</tr> \n\t<!-- 6484 ends -->\n\t\n\t\n\t\n\n<!-- IN066108 end -->\t\n\t<!-- KDAH-CRF-0431 [IN063931] - End -->\n\t<!-- ML-MMOH-CRF-0807 [IN063798] - End -->\n\t</table>\n\t<input type=hidden name=\'notes_select_criteria\' id=\'notes_select_criteria\' value=\'D\'>\n\t<input type=hidden name=\"note_img_ref_folder1\" id=\"note_img_ref_folder1\" value=\"\">\n\t<!--<input type=hidden name=\"print_dischar\" id=\"print_dischar\" value=\'Y\'>--><!-- IN038468 -->\n\t<input type=hidden name=\"print_dischar\" id=\"print_dischar\" value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'><!-- IN038468 -->\n\t<!--<input type=hidden name=\"print_clinical_evt_hrd\" id=\"print_clinical_evt_hrd\" value=\'Y\'>--><!-- IN029312 -->\n\t<input type=hidden name=\"print_clinical_evt_hrd\" id=\"print_clinical_evt_hrd\" value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'><!-- IN038468 -->\n\t<!--<input type=hidden name=\"hdrfoot_margin_val\" id=\"hdrfoot_margin_val\" value=\'N\'> --><!-- [IN031116] -->\n\t<input type=hidden name=\"hdrfoot_margin_val\" id=\"hdrfoot_margin_val\" value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t<!--<input type=hidden name=\"print_logo_hdr_in_all_pages\" id=\"print_logo_hdr_in_all_pages\" value=\'Y\'>--><!-- IN030419 -->\n\t<input type=hidden name=\"print_logo_hdr_in_all_pages\" id=\"print_logo_hdr_in_all_pages\" value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'><!-- IN038468 -->\n\t<!--<input type=hidden name=\"print_rpt_hdr_in_all_pages\" id=\"print_rpt_hdr_in_all_pages\" value=\'Y\'>--><!-- IN030419 -->\n\t<input type=hidden name=\"print_rpt_hdr_in_all_pages\" id=\"print_rpt_hdr_in_all_pages\" value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'><!-- IN038468 -->\n\t<input type=hidden name=\"spell_checker_yn\" id=\"spell_checker_yn\" value=";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="><!-- IN029712 -->\n\t<input type=hidden name=\"spell_chk_def_opt\" id=\"spell_chk_def_opt\" value=";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="><!-- IN029712 -->\n\t<input type=hidden name=\"rstl_lnk_sensidiag_yn\" id=\"rstl_lnk_sensidiag_yn\" value=";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="><!-- IN039182 -->\n\t<input type=hidden name=\"display_result_linkin_HTML_yn\" id=\"display_result_linkin_HTML_yn\" value=";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="><!-- IN041284 -->\n\t<input type=hidden name=\"display_disclaimer_text_print\" id=\"display_disclaimer_text_print\" value=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="><!-- IN004500 -->\n\t<input type=hidden name=\"logo_header_hght\" id=\"logo_header_hght\" value=";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="><!-- IN068669 -->\n\t<input type=hidden name=\"logo_header_width\" id=\"logo_header_width\" value=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="><!-- IN068669 -->\n\t<input type=hidden name=\"auto_Save_Time\" id=\"auto_Save_Time\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"><!--IN071264-->\n\t<input type=hidden id=\"disp_note_description\" name=\"disp_note_desc\" id=\"disp_note_desc\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"><!--Exception-PMG2020-COMN-CRF-0085-->\n\t<input type=hidden id=\"comp_note_content_YN\" name=\"comp_note_cont\" id=\"comp_note_cont\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"><!--6484-->\n</form>\n<!-- IN029712 Starts-->\n<script>\nvar spell_cheker_ = document.note_param_form.SpellChecker.value;\nvar spell_chk_opt_   = document.note_param_form.spell_chk_def_opt.value;\nif(spell_cheker_ == \'Y\'){\t\n\tdocument.getElementById(\'SpellCheckDefOptId\').style.display=\'\';\n\t/* document.getElementById(\'SpellCheckDefOptId1\').style.display=\'\'; */\n\tif(spell_chk_opt_ == \'P\')\n\t\tdocument.getElementById(\"SpellCheckDefOpt\").checked=true;\n\t/* else if(spell_chk_opt_ == \'I\')\t\n\t\tdocument.getElementById(\"inl\").checked=true; */\n}\n//IN071264 starts\nif(\"Y\"==\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\')\n\tdocument.getElementById(\"allowAutoSaveForEvery\").style=\'display\';\nelse\n\t\tdocument.getElementById(\"allowAutoSaveForEvery\").style.display=\'none\';\n//IN071264 ends\n</script>\n<!-- IN029712 Ends-->\n</body>\n</html>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
15/12/2011    IN029312      Menaka V 	    Incident No: IN029312 - <Report is printed either through
											order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. >
24/02/2012	 IN031116	  Ramesh G	  		Report header is overlapping the hospital letter heads & deliverable.
15/03/2012	 IN030419	  Menaka V	  		Clinical Note Logo Header and Report Header .
15/09/2012   IN029712	  Nijithas			Spell check functionality implemented for section templates.
12/03/2013	 IN038468	  Nijithas			Alpha-CA-Note Parameter settings are not saved properly	 	
05/04/2013	 IN039182	  Chowminya G		Restrict all users from result linking all diagnosis which are sensitive only ?in the clinical notes
15/09/2012   IN043031	  Nijithas		 ML-BRU-SCF-0998.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory? results in a clinical note section template does not display neatly .	
05/02/2016	  IN004500		 Raja S										    GHL-SCF-1000
23/05/2016	  IN055439		 Karthi L										MO_CRF_20102
28/07/2016	  IN059747		 Karthi L										JD-CRF-0199
20/02/2017	  IN061882		 Karthi L										ML-MMOH-CRF-0534 [IN061882]
10/05/2017    IN063865		 Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
18/05/2017    IN063798		 Raja S		22/05/2017		Ramesh Goli			ML-MMOH-CRF-0807
12/02/2018	  IN063931		Prakash C	25/01/2018		Ramesh		        KDAH-CRF-0431
17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
10/10/2018	  IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
18/03/2020	  IN071264		Nijitha S	 18/03/2020			Ramesh G	   GHL-CRF-0604
18/11/2020	  7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
19/04/2021	  6484			Durga Natarajan		19/04/2021		RAMESH G	MO-CRF-20147.7 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	boolean isSiteSpecific  = false;//IN063931

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

//String chekval	=(request.getParameter("chekval")==null)?"":request.getParameter("chekval");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

try
{
		conlCon = ConnectionManager.getConnection(request);
		StringBuffer sblQry = new StringBuffer();
		String module_id = "";
		// Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 
		String maxNoImgAllowed = "";
		// ends here.
		int days_backdate   = 0;
		
		String  note_img_ref_folder    = "";

		int file_size = 0;
		String mail_unit ="",xsl_flder="",print_hdr_in_ds_yn="Y",print_hdr_in_ds_checked = "checked";
		String print_hdr_in_ceh_yn="Y",print_hdr_in_ceh_checked = "checked";//IN029312
		//IN030419 Starts
		String print_logo_hdr_in_all_yn="Y",print_logo_hdr_in_all_checked = "checked";
		String print_rpt_hdr_in_all_yn="Y",print_rpt_hdr_in_all_checked = "checked";
		// IN029712 Starts
		String spell_checker_yn = "N", spell_checker_checked = "";
		String spell_checker_popup = "P";
		String spell_checker_inline = "I";
		String spell_checker_popup_checked = "";
	    String spell_checker_inline_checked = "";
	    String spell_chk_def_opt = null;
	 	// IN029712 Ends
		//IN030419 Ends
		String rstl_lnk_sensidiag_yn = "Y";//IN039182
		String lnk_sensidiag_checked = "";//IN039182
		String display_result_linkin_HTML_yn = "N";//IN041284
		String display_dis_text_print = ""; //IN004500
		String display_result_linkin_HTML_checked = ""; //IN041284
		String hdr_foot_mergin_yn="N",hdr_foot_mergin_checked = "";//[IN031116]
		String text_format_default_yn = ""; // MO_CRF_20102[IN055439]				
		String text_format_default_checked = "N"; // MO_CRF_20102[IN055439]	
		int vw_PREV_NOTE_DAYS=0;//IN043031		
		String amend_result_note_yn = "N"; //JD-CRF-0199 [IN059747]
		String amend_result_note_checked = ""; //JD-CRF-0199 [IN059747]
		//ML-MMOH-CRF-0534 [IN061882] - Start
		String disable_spec_type_yn = "N";
		String disable_spec_type_checked = "";	
		String disable_ref_range_yn = "N";
		String disable_ref_range_checked = "";
		String dateTimeFormat_yn = "N"; //Added for IN063865
		String dateTimeFormat_checked = ""; //Added for IN063865
		int noOfEncounters = 1; //Added for IN063798
		String access_inError_yn = "N";	 //IN066108
		String inError_checked = ""; //IN066108
		String accessRightsUnsignedNotes_yn = "N"; //IN066108
		String accessRightsUnsignedNotes_yn_checked = ""; //IN066108
		String logo_header_width="40";//IN068669
		String logo_header_hght="40"; //IN068669
		String autoSaveChk = "";//IN071264
		String auto_Save_YN = "";//IN071264
		String auto_Save_Time ="";//IN071264
		String display_note_description="";//7605
		String checknote="";//7605
		//ML-MMOH-CRF-0534 [IN061882] - End
		String compress_note_content_YN="";//6484
		String checkcompress="";//6484
		/* Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500
				added a new column for select query MAX_NO_IMG_ALLOWED */	
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN  FROM ca_note_param ");	//IN029312
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN FROM ca_note_param ");//IN030419		//CRF -001//IN039182 included LINK_SENST_DIAG_YN
		//IN041284 Start.
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS FROM ca_note_param ");//IN030419		//CRF -001//IN039182 included LINK_SENST_DIAG_YN				
		//IN041284 End.

		//IN004500 Start.
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN FROM ca_note_param ");
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT FROM ca_note_param ");	// commented for MO_CRF_20102[IN055439]			
		//IN004500 End.
		/*sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN FROM ca_note_param "); // MO_CRF_20102[IN055439]  */ //Commented for IN059747
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN ,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN FROM ca_note_param "); // modified for JD-CRF-0199 [IN059747] - Commented for ML-MMOH-CRF-0534 [IN061882]
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN FROM ca_note_param "); // modified for ML-MMOH-CRF-0534 [IN061882]
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN FROM ca_note_param "); // modified for ML-MMOH-CRF-0534.1[IN063865]
		//sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS FROM ca_note_param "); // modified for ML-MMOH-CRF-0807[IN063798]// 
		 //sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS,IN_ERROR_YN,UNSIGNED_ACCESS_YN FROM ca_note_param ");//IN066108
		  //sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS,IN_ERROR_YN,UNSIGNED_ACCESS_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT, AUTO_SAVE_YN, AUTO_SAVE_TIME FROM ca_note_param ");//IN068669//IN71264
		   sblQry.append("SELECT module_id, days_backdate, NOTE_IMAGE_REP_FOLDER,NVL(NOTE_LINKED_FILE_LIMIT,2048) NOTE_LINKED_FILE_LIMIT, NVL(NOTE_LINKED_FILE_LIMIT_UNIT,'K') NOTE_LINKED_FILE_LIMIT_UNIT,XML_PARSER_FOLDER,PRINT_HDR_IN_DS_YN, MAX_NO_IMG_ALLOWED,PRINT_HDR_IN_CEH_YN,HDR_FT_MARGIN_IN_NOTE_YN,LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,SPELL_CHK_REQ_YN,SPELL_CHK_DEF_OPT,LINK_SENST_DIAG_YN,VW_PREV_NOTE_DAYS,DISP_RES_LINK_HTML_YN,CEH_DISC_TEXT, TEXT_FORMAT_DEFAULT_YN, AMEND_RESULT_NOTE_YN, DISABLE_SPEC_TYPE_YN, DISABLE_REF_RANGE_YN, DIS_REP_DATETIME_YN, NO_OF_ENCOUNTERS,IN_ERROR_YN,UNSIGNED_ACCESS_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT, AUTO_SAVE_YN, AUTO_SAVE_TIME,DISP_NOTE_DESC,COMPRESS_NOTE_CONTENT_YN FROM ca_note_param ");//IN068669//IN71264//7605//6484

		pstmt = conlCon.prepareStatement( sblQry.toString());
		rslRst = pstmt.executeQuery();
		if(rslRst.next())
		{
			do
			{
				module_id = rslRst.getString("module_id");
				// Added by Kishore kumar N, on 08/01/2010 for SRR200910-CRF-0500 
				maxNoImgAllowed = rslRst.getString("MAX_NO_IMG_ALLOWED")==null?"":rslRst.getString("MAX_NO_IMG_ALLOWED");
				logo_header_width=rslRst.getString("LOGO_HDR_WIDTH")==null?"40":rslRst.getString("LOGO_HDR_WIDTH");//IN068669
				logo_header_hght=rslRst.getString("LOGO_HDR_HEIGHT")==null?"40":rslRst.getString("LOGO_HDR_HEIGHT");//IN068669
				// ends here.
				auto_Save_YN				= rslRst.getString("AUTO_SAVE_YN")==null?"N":rslRst.getString("AUTO_SAVE_YN");//IN071264
				auto_Save_Time =        rslRst.getString("AUTO_SAVE_TIME")==null?"":rslRst.getString("AUTO_SAVE_TIME");//IN071264
				display_note_description=rslRst.getString("DISP_NOTE_DESC")==null?"":rslRst.getString("DISP_NOTE_DESC");//7605
				compress_note_content_YN=rslRst.getString("COMPRESS_NOTE_CONTENT_YN")==null?"":rslRst.getString("COMPRESS_NOTE_CONTENT_YN");//6484
				if(module_id == null) 
				{
					module_id = "";
				}
				days_backdate= rslRst.getInt("days_backdate");
				file_size= rslRst.getInt("NOTE_LINKED_FILE_LIMIT");
				mail_unit = rslRst.getString("NOTE_LINKED_FILE_LIMIT_UNIT");
				if(mail_unit == null) 
				{
					mail_unit = "";
				}
				note_img_ref_folder=rslRst.getString("NOTE_IMAGE_REP_FOLDER")==null?"":rslRst.getString("NOTE_IMAGE_REP_FOLDER");

				xsl_flder=rslRst.getString("XML_PARSER_FOLDER")==null?"":rslRst.getString("XML_PARSER_FOLDER");
					print_hdr_in_ds_yn=rslRst.getString("PRINT_HDR_IN_DS_YN");
					print_hdr_in_ceh_yn=rslRst.getString("PRINT_HDR_IN_CEH_YN");//IN029312
					//out.println("<script>alert('print_hdr_in_ds_yn"+print_hdr_in_ds_yn+"')</script>");
					if (print_hdr_in_ds_yn==null ||print_hdr_in_ds_yn.equals("N"))
								print_hdr_in_ds_checked="";
					else
							print_hdr_in_ds_checked="checked";	
					//IN029312 starts
					if (print_hdr_in_ceh_yn==null ||print_hdr_in_ceh_yn.equals("N"))
								print_hdr_in_ceh_checked="";
					else
							print_hdr_in_ceh_checked="checked";
					//IN029312 Ends

					//[IN031116] Start
					hdr_foot_mergin_yn=(rslRst.getString("HDR_FT_MARGIN_IN_NOTE_YN")==null)?"":rslRst.getString("HDR_FT_MARGIN_IN_NOTE_YN");
					if (hdr_foot_mergin_yn==null ||hdr_foot_mergin_yn.equals("N"))
							hdr_foot_mergin_checked="";
					else
							hdr_foot_mergin_checked="checked";	

					//[IN031116] Ends
					//IN030419 Starts
					print_logo_hdr_in_all_yn=rslRst.getString("LOGO_HDR_ALL_PAGE_YN");
					if (print_logo_hdr_in_all_yn==null ||print_logo_hdr_in_all_yn.equals("N"))
						print_logo_hdr_in_all_checked="";
					else
						print_logo_hdr_in_all_checked="checked";
					print_rpt_hdr_in_all_yn=rslRst.getString("RPT_HDR_ALL_PAGE_YN");
					if (print_rpt_hdr_in_all_yn==null ||print_rpt_hdr_in_all_yn.equals("N"))
						print_rpt_hdr_in_all_checked="";
					else
						print_rpt_hdr_in_all_checked="checked";
					//IN030419 Ends
					//IN029712 Starts
					spell_checker_yn = rslRst.getString("SPELL_CHK_REQ_YN");
					if(spell_checker_yn==null || spell_checker_yn.equals("N"))
						spell_checker_checked = "";
					else
						spell_checker_checked = "checked";
					spell_chk_def_opt = rslRst.getString("SPELL_CHK_DEF_OPT");
					if("P".equals(spell_chk_def_opt)){
						spell_checker_popup_checked = "checked";
					}else {
						spell_checker_popup_checked = "";
					}
					if("I".equals(spell_chk_def_opt))
						spell_checker_inline_checked = "checked";
					else
						spell_checker_inline_checked = "";
					//IN029712 Ends
					//IN039182 - Start
					rstl_lnk_sensidiag_yn=rslRst.getString("LINK_SENST_DIAG_YN");
					if (rstl_lnk_sensidiag_yn==null ||rstl_lnk_sensidiag_yn.equals("N"))
						lnk_sensidiag_checked="";
					else
						lnk_sensidiag_checked="checked";
					//IN039182 - End
					//IN071264 starts
					if(auto_Save_YN.equals("Y"))
						autoSaveChk="checked";
					if(auto_Save_YN.equals("N")){
						auto_Save_Time="";
					}
					//IN071264 ends
					
					//IN041284 Start.
					display_result_linkin_HTML_yn = rslRst.getString("DISP_RES_LINK_HTML_YN");
					if (display_result_linkin_HTML_yn==null ||display_result_linkin_HTML_yn.equals("N"))
						display_result_linkin_HTML_checked="";
					else
						display_result_linkin_HTML_checked="checked";
					//IN041284 End.
					//IN043031 Starts
					vw_PREV_NOTE_DAYS = rslRst.getInt("VW_PREV_NOTE_DAYS");
					//IN043031 Ends

					display_dis_text_print = rslRst.getString("CEH_DISC_TEXT")==null?"":rslRst.getString("CEH_DISC_TEXT");//IN004500
					// MO_CRF_20102[IN055439] - Start
					text_format_default_yn =  rslRst.getString("TEXT_FORMAT_DEFAULT_YN")==null ? "": rslRst.getString("TEXT_FORMAT_DEFAULT_YN");
					if("Y".equals(text_format_default_yn)){
						text_format_default_checked = "checked";
					} else {
						text_format_default_checked = "";
					} // MO_CRF_20102[IN055439]	- End
					
					//JD-CRF-0199 [IN059747] - Start
					amend_result_note_yn = rslRst.getString("AMEND_RESULT_NOTE_YN")==null?"N":rslRst.getString("AMEND_RESULT_NOTE_YN");
					if("Y".equals(amend_result_note_yn))
						amend_result_note_checked = "checked";
					else
						amend_result_note_checked = "";
					//JD-CRF-0199 [IN059747] - End	
					//ML-MMOH-CRF-0534 [IN061882] - Start
					
					disable_spec_type_yn = rslRst.getString("DISABLE_SPEC_TYPE_YN")==null?"N":rslRst.getString("DISABLE_SPEC_TYPE_YN");
					disable_ref_range_yn = rslRst.getString("DISABLE_REF_RANGE_YN")==null?"N":rslRst.getString("DISABLE_REF_RANGE_YN");
					if("Y".equals(disable_spec_type_yn))
						disable_spec_type_checked = "checked";
					else
						disable_spec_type_checked = "";
					if("Y".equals(disable_ref_range_yn))
						disable_ref_range_checked = "checked";
					else
						disable_ref_range_checked = "";	
					//ML-MMOH-CRF-0534 [IN061882] - End
					// ML-MMOH-CRF-0534.1[IN063865] Starts
					dateTimeFormat_yn = rslRst.getString("DIS_REP_DATETIME_YN")==null?"N":rslRst.getString("DIS_REP_DATETIME_YN");
					if("Y".equals(dateTimeFormat_yn))
						dateTimeFormat_checked = "checked";
					else
						dateTimeFormat_checked = "";	
					// ML-MMOH-CRF-0534.1[IN063865] Ends
					// ML-MMOH-CRF-0807[IN063798] Starts
					noOfEncounters = rslRst.getInt("NO_OF_ENCOUNTERS");
					// ML-MMOH-CRF-0807[IN063798] Ends
					//IN066108 starts
					access_inError_yn = rslRst.getString("IN_ERROR_YN")==null?"N":rslRst.getString("IN_ERROR_YN");
					if("Y".equals(access_inError_yn))
						inError_checked = "checked";
					else
						inError_checked = "";	
					accessRightsUnsignedNotes_yn = rslRst.getString("UNSIGNED_ACCESS_YN")==null?"N":rslRst.getString("UNSIGNED_ACCESS_YN");
					if("Y".equals(accessRightsUnsignedNotes_yn))
						accessRightsUnsignedNotes_yn_checked = "checked";
					else
						accessRightsUnsignedNotes_yn_checked = "";	
					//IN066108 ends
					//7605 starts
					if(display_note_description.equals("Y"))
						checknote="checked";
					else
						checknote="";
						//7605 ends
	  //6484 starts
					if(compress_note_content_YN.equals("Y"))
						checkcompress ="checked";
					else
						checkcompress ="";
	//6484 ends  
			}
			while(rslRst.next());
			out.println("<input type='hidden' name='mode' id='mode' value='update'>");
		}
		else
		{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
		}		
			if(rslRst!=null) rslRst.close();
			if(pstmt!=null) pstmt.close();		


            _bw.write(_wl_block10Bytes, _wl_block10);

//IN063931 starts	
	try{
	isSiteSpecific = CommonBean.isSiteSpecific(conlCon, "CA","COPY_FROM_PREV_SECTION");
	}
	 catch(Exception e) {
        System.out.println("error:"+e.getMessage());
		e.printStackTrace();
    }
//IN063931 ends

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 if(days_backdate != 0) {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( days_backdate ));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(xsl_flder));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 if(file_size != 0) {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( file_size ));
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block20Bytes, _wl_block20);
if(mail_unit.equalsIgnoreCase("") ){
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
if(mail_unit.equalsIgnoreCase("K") ){
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mail_unit.equalsIgnoreCase("M") ){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(print_hdr_in_ds_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(print_hdr_in_ds_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(maxNoImgAllowed));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(print_hdr_in_ceh_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(print_hdr_in_ceh_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(hdr_foot_mergin_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(hdr_foot_mergin_checked));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(print_logo_hdr_in_all_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(print_logo_hdr_in_all_checked));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( logo_header_hght ));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(logo_header_width));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(print_rpt_hdr_in_all_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(print_rpt_hdr_in_all_checked));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(spell_checker_yn ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(spell_checker_checked ));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(spell_checker_popup ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(spell_checker_popup_checked ));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(spell_checker_inline ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(spell_checker_inline_checked));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rstl_lnk_sensidiag_yn ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(lnk_sensidiag_checked ));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(vw_PREV_NOTE_DAYS ));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(display_result_linkin_HTML_yn ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(display_result_linkin_HTML_checked ));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(display_dis_text_print ));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(text_format_default_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(text_format_default_checked ));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(amend_result_note_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(amend_result_note_checked));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disable_ref_range_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disable_ref_range_checked));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disable_spec_type_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disable_spec_type_checked));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(dateTimeFormat_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dateTimeFormat_checked));
            _bw.write(_wl_block71Bytes, _wl_block71);

	if(isSiteSpecific){
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(noOfEncounters));
            _bw.write(_wl_block74Bytes, _wl_block74);
}else{
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(noOfEncounters));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(access_inError_yn ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(inError_checked));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(accessRightsUnsignedNotes_yn ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(accessRightsUnsignedNotes_yn_checked));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(auto_Save_YN));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(autoSaveChk));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(auto_Save_Time));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(display_note_description));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checknote));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(compress_note_content_YN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkcompress));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(print_hdr_in_ds_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(print_hdr_in_ceh_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(hdr_foot_mergin_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(print_logo_hdr_in_all_yn));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(print_rpt_hdr_in_all_yn));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(spell_checker_yn ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(spell_chk_def_opt ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(rstl_lnk_sensidiag_yn ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(display_result_linkin_HTML_yn ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(display_dis_text_print ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(logo_header_hght));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(logo_header_width));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(auto_Save_Time));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(display_note_description));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(compress_note_content_YN));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(auto_Save_YN));
            _bw.write(_wl_block106Bytes, _wl_block106);

		
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in addNoteParam.jsp:"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Noteparameter.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Backdate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.XSLfolder.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.FileSizeLimit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PrintDischargeSummaryHeader.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MaxNoImgAllowed.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PrintEventHeaderinClinicalEventHistory.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HeaderFooterMargin.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LogoHeaderForAllPages.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LogoHeadersizeDimensions.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Height.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Px.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Width.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Px.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReportHeaderForAllPages.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpellChecker.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DefaultSpellChecker.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpellCheckerPopUp.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpellCheckerInLine.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResultLinkSensitiveDia.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MaxDaysViewPreviousNotes.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DisplayResultLinkInHTML.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DisplayDisPrintText.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TextFormatDflt.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.amendResultNote.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.disprefrange.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.dispspectype.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.datetimeformat.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.noofenccopyprevnotessec.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.noofenccopyprevnotes.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AccessRightsApplicabilityForInError.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AccessRightsApplicabilityForUnsignedNotes.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllowAutoSaveInNotes.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllowAutoSaveForEvery.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.minutes.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DisplayNoteDescription.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteContentCompressionRequired.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
