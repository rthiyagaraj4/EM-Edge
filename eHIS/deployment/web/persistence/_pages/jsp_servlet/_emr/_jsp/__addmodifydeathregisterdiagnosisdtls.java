package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;

public final class __addmodifydeathregisterdiagnosisdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp", 1742295145987L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\"../../eMR/js/DeathRegister.js\"></script>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\n\t\t<style>\n\t\t.dropdownFix \n\t\t\t{ \n\t\t\t\tbehavior:expression(this.style.visibility = this.offsetParent.offsetParent.offsetParent.scrollTop >\n\t\t\t\t(this.offsetParent.offsetTop - this.parentElement.parentElement.parentElement.firstElementChild.offsetHeight) ? \'hidden\' : \'visible\'); \n\t\t\t}\n\t\t</style>\n\t</head>\n\t<body>\n\t\t<form name=\"DR_DiagnosisDtls_Form\" id=\"DR_DiagnosisDtls_Form\">\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<table width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' border=\'0\' >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"6\" class=\'PANELTOOLBAR\' id=\"Diag_icon\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr></tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<div  style=\"position:relative;height:185px;overflow:auto\">\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t\t<thead id=\"TabHead\">\n\t\t\t\t\t\t\t<tr style=\"position:relative;top:expression(this.offsetParent.scrollTop)\" >\n\t\t\t\t\t\t\t\t<th align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t\t\t\t<th align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr></tr>\n\t\t\t\t\t</thead>\n\n\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\n\t\t\t\t\t <tbody id=\"PrimaryTab\" >\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t<td colspan=\"6\"><font  size=\"1.5px\"><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></font></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<td colspan=\"6\"><font  size=\"1.5px\"><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t\t<td class=\'griddata\'><input type=\"checkbox\" name=\"primary_chk";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"primary_chk";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></td>\n\t\t\t\t\t\t\t<td class=\'griddata\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<td class=\'griddata\' style=\'WORD-BREAK:BREAK-ALL;\'  width=\'20%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<td class=\'griddata\'><input type=\"text\" name=\"onset_date_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"onset_date_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" size=\'18\' maxlength=\'18\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" Onblur=\"validateDatetime(this,getLabel(\'Common.onsetdate.label\',\'Common\'),";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="/><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'onset_date_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'dd/mm/yyyy\',\'hh:24mi\');\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="/></td>\n\t\t\t\t\t\t\t<!-- \n\t\t\t\t\t\t\t\tF.Y.I:\n\t\t\t\t\t\t\t\t1.The populating theDuration Of illness value is done by JS function paintValue(); in the same JSP page; \n\t\t\t\t\t\t\t\t2.The above statement was enhanced to dispaly Duration Of illness aganist each diagnosis.\n\t\t\t\t\t\t\t\t3.For  gap CRF ADD-SRR20056-CRF-450.xls Modified On 1/7/2010.\n\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t<td class=\'griddata\'  id=\"illnes_decease_date_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"><input type=\"text\" name=\"duration_of_illnes_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"duration_of_illnes_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" readonly/></td>\n\t\t\t\t\t\t\t<!-- The populating the seq-no is done by JS function populateSeqNOs() in the same JSP page; -->\n\t\t\t\t\t\t\t<td class=\'griddata\'>\n\t\t\t\t\t\t\t<select name=\'seqdiag";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'seqdiag";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' class=\"dropdownFix\"  onchange=\"validate_duplicate_diag(this,";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =")\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =">\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t</tbody>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t <tbody id=\"OthersTab\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t<td colspan=\"6\"><font  size=\"1.5px\"><b>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></font></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'griddata\'><input type=\"checkbox\" name=\"others_chk";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"others_chk";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<td class=\'griddata\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t<td class=\'griddata\'   style=\'WORD-BREAK:BREAK-ALL;\'  width=\'20%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t<td  colspan=\'3\' class=\'griddata\'>&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t</tbody>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t<tbody id=\"GenaralTab\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"6\"><font size=\"1.5px\"><b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b></font></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\'10%\' class=\'griddata\'><input type=\"checkbox\" name=\"slctd_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"slctd_code";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"  ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t<td width=\'10%\' class=\'griddata\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td  class=\'griddata\' style=\'WORD-BREAK:BREAK-ALL;\'  width=\'20%\' >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\'50%\' colspan=\'3\' class=\'griddata\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div style=\"display:";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t<table width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' border=\'0\' scrolling=\"no\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t<td class =\'fields\' width=\'13%\' >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t\t\t<select name=\"move_to_grp\" id=\"move_to_grp\" onchange=\"buildGroups(this,\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')\">\n\t\t\t\t\t\t\t\t\t<option>----------";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="----------</option>\n\t\t\t\t\t\t\t\t\t<option value=\"C\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"O\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"R\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t<td class =\'fields\' width=\'13%\'></td>\n\t\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\n\t\t\t\t\t\t<td colspan=\'3\' width=\'50%\'></td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'10%\'><input type=\'button\' name=\'newdiag_btn\' id=\'newdiag_btn\' Value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' onclick=\"AddNewDiagnosis(\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\',\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\')\" /></td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'34%\'><input type=\'button\' name=\'seq_btn\' id=\'seq_btn\' Value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' onclick=\"sort(\'PrimaryTab\');\" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="/></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<input type=\'hidden\' name=\'dumy_onset\' id=\'dumy_onset\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\'hidden\' name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\t\t\n\t\t\t<input type=\'hidden\' name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\t \t\t\t\t\n\t\t\t<input type=\'hidden\' name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\t\t\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\t\n\t\t\t<input type=\'hidden\' name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\t\t\t\n\t\t\t<input type=\'hidden\' name=\"practitioner_type\" id=\"practitioner_type\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\t\t\n\t\t\t<input type=\'hidden\' name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<input type=\'hidden\' name=\"call_from\" id=\"call_from\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\t\t\n\t\t\t<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\'hidden\' name=\"temp_code\" id=\"temp_code\" value=\"\">\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\"seq_no\" id=\"seq_no\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t<input type=\'hidden\' name=\"other_cause_death\" id=\"other_cause_death\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<input type=\'hidden\' name=\"max_pri_diag\" id=\"max_pri_diag\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t<input type=\'hidden\' name=\"max_oth_dis\" id=\"max_oth_dis\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<input type=\'hidden\' name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<input type=\'hidden\' name=\"totalRecords1\" id=\"totalRecords1\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\'hidden\' name=\'currentdate\' id=\'currentdate\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t\t\t<input type=\'hidden\' name=\'isDeceasedDiagClassDeathRegAppl\' id=\'isDeceasedDiagClassDeathRegAppl\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t\t<input type=\'hidden\' name=\'primary_diag_class\' id=\'primary_diag_class\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t<input type=\'hidden\' name=\'secondary_diag_class\' id=\'secondary_diag_class\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script LANGUAGE=\"JavaScript\">\n\t\t\t\tpopulateSeqNOs();// To populate Sequence nos this function was used.\n\t\t\t\t/*\n\t\t\t\t\tF.Y.I:\n\t\t\t\t\t1.The below function was commented for GAP CRF ADD-SRR20056-CRF-450.xls.\n\t\t\t\t\t2.Modified On 1/7/2010 9:37 AM.\n\t\t\t\t*/\n\t\t//\t\tpaintValue();// To Paint the Value of the duration of illness this function was used\n\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

		public static String getDesc(String Code,String term_set_id,String occur_srlno,String FacilityId,String patient_id,String encounter_id,HttpServletRequest req){
		Code=checkForNull(Code);
		term_set_id=checkForNull(term_set_id);
		occur_srlno=checkForNull(occur_srlno);
		String short_desc="";
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try{
		conn = ConnectionManager.getConnection(req);
		String DESC_CODES_SQL="SELECT TERM_CODE_SHORT_DESC FROM PR_DIAGNOSIS_ENC_DTL WHERE TERM_CODE='"+Code+"' AND TERM_SET_ID='"+term_set_id+"' AND OCCUR_SRL_NO='"+occur_srlno+"' AND PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+FacilityId+"'  ";
		pstmt=conn.prepareStatement(DESC_CODES_SQL);
		rs=pstmt.executeQuery();
		while(rs.next()){
			short_desc =	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
		}

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(conn,req);

	}
return short_desc;
}


	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
	String sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));
	String FacilityId					= checkForNull((String) session.getValue( "facility_id" ));
	String patient_id				=	checkForNull(request.getParameter("patient_id"));
	String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	String locn_code				=	checkForNull(request.getParameter("locn_code"));
	String gender	 					=	checkForNull(request.getParameter("gender"));
	String dob							=	checkForNull(	request.getParameter("dob"));
	String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
	String episode_id				=	checkForNull(request.getParameter("episode_id"));
	String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
	String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
	String patient_class			=	checkForNull(request.getParameter("patient_class"));
	String call_from					=	checkForNull(request.getParameter("call_from"));
	String episode_type			=	checkForNull(request.getParameter("episode_type"));
	String mode						=	checkForNull(request.getParameter("mode"));
	String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"),"N");
	String totalRecords			=	checkForNull(request.getParameter("totalRecords"),"0");
	String increment_records	=	checkForNull(request.getParameter("increment_records"),"N");

	int totalRecords1				=	Integer.parseInt(totalRecords);
	String max_pri_diag			=	"";
	String max_oth_dis			=	"";
	String hid_illnes_date		="";
	int maxRecords					=0;
	int maxRecords1				=0;
	String currentdateTime		="";
//	String currentdate				="";
//	String currentTime				="";
	String disable_btns			="";
	String disable_fields			="";
	String dis_seq_btn			="";

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String secondary_diag_class = "";
	String diag_class_code = "";
	String primary_diag_class_LD = "";
	String secondary_diag_class_LD = "";

	Connection conn =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

					if(finalize_yn.equals("Y")){
						disable_btns="none";
						disable_fields="disabled";
					}else if(call_from.equals("VIEW_DEATH_REG")){
						disable_btns="none";
					}else{
						disable_btns="inline";
						disable_fields="";
					}
						//int seq_no=1;
						int j=0;
						int k=0;
				try{
						conn = ConnectionManager.getConnection(request);

						isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

						/*
						Commented For PE5/17/2010
						String getDate = "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual" ;
						pstmt=conn.prepareStatement(getDate);
						rs	  = pstmt.executeQuery();
						if (rs.next()){
							currentdateTime	= rs.getString("sdate");
//							currentdate		= currentdateTime.substring(0,10);
							currentdateTime	=DateUtils.convertDate(currentdateTime,"DMYHM","en",locale);
//							currentTime		= currentdateTime.substring(11);
						}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();*/

						String MR_PARAM_SETUP_SQL= "SELECT MAX_PRI_DIAG_INDICATE_CO_DEATH, MAX_OTH_DIS_COMP_INDI_CO_DEATH,TO_CHAR(SYSDATE,'DD/MM/RRRR HH24:MI') SDATE, PRIMARY_DIAG_CLASS, SECONDARY_DIAG_CLASS FROM MR_PARAMETER";
						pstmt=conn.prepareStatement(MR_PARAM_SETUP_SQL);
						rs=pstmt.executeQuery();
						while(rs.next()){
							max_pri_diag	=	checkForNull(rs.getString("MAX_PRI_DIAG_INDICATE_CO_DEATH"));
							max_oth_dis		=	checkForNull(rs.getString("MAX_OTH_DIS_COMP_INDI_CO_DEATH"));
							currentdateTime	= rs.getString("SDATE");
//							currentdate		= currentdateTime.substring(0,10);
							currentdateTime	=DateUtils.convertDate(currentdateTime,"DMYHM","en",locale);
//							currentTime		= currentdateTime.substring(11);
							
							//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
							primary_diag_class = checkForNull(rs.getString("PRIMARY_DIAG_CLASS"));
							secondary_diag_class = checkForNull(rs.getString("SECONDARY_DIAG_CLASS"));

						}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
						
						/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
						String descSql = "SELECT diag_class_code, long_desc FROM mr_diag_class_lang_vw WHERE diag_class_code = ? AND language_id = ? AND eff_status = 'E' ORDER BY 2";

						if(!primary_diag_class.equals("")){

							pstmt = conn.prepareStatement(descSql);
							pstmt.setString(1,primary_diag_class);
							pstmt.setString(2,locale);
							rs = pstmt.executeQuery();

							if(rs!=null){
								while(rs.next()){
									primary_diag_class_LD = checkForNull(rs.getString("long_desc"));
								}
							}

							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
						}

						if(!secondary_diag_class.equals("")){

							pstmt = conn.prepareStatement(descSql);
							pstmt.setString(1,secondary_diag_class);
							pstmt.setString(2,locale);
							rs = pstmt.executeQuery();

							if(rs!=null){
								while(rs.next()){
									secondary_diag_class_LD = checkForNull(rs.getString("long_desc"));
								}
							}

							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
						}
						/*End ML-MMOH-CRF-1742*/

						HashMap	diag_dates_map	=	new HashMap();
						HashMap	diag_desc_map		=	new HashMap();
						HashMap combined_map		= new HashMap();
						HashMap db_diagdates_map	= new HashMap();
//						HashMap db_diagdesc_map		= new HashMap();
						//HashMap data_base_map	= new HashMap();
						combined_map						=	(HashMap)session.getAttribute("combined_map");
						diag_dates_map					=	(HashMap)session.getAttribute("diag_dates_map");
						diag_desc_map	 					=	(HashMap)session.getAttribute("diag_desc_map");
						//ArrayList data_base_list	=	new ArrayList();
						//ArrayList data_base_list1	=	new ArrayList();
						ArrayList primaryList		=	new ArrayList();
						ArrayList OthersList			=	new ArrayList();
						ArrayList general_list		=	new ArrayList();
						//String ClassValue="";
						int i=0;
						String code					="";
						String term_set_id			="";
						String occur_srl_no		="";
						String diag_dtl_record	="";
						String code_short_desc	="";
						String code_onset_date ="";
						//int death_reg_cnt			=0;
//						String ACT_CODES_SQL="SELECT TERM_CODE,TERM_SET_ID, OCCUR_SRL_NO FROM PR_DIAGNOSIS_ENC_DTL  WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+FacilityId+"' ";
							String diagnosis_group="";
							mode="MODIFY";
/*
	FYI:
	1.When  MDR  window is opened freshly or clear the values then the maps will be null.
	2.if maps are null then data will be updated into the combined_map if the data is already there for the patient in MR_detail table.
	3. For that ACT_CODES_SQL is used and the status of the diag_dtl_record will be 'E' getting from MR_DTL table.
	4.Same time ACT_CODES_SQL1 will be executed and the  status of the diag_dtl_record will be 'A' data getting from PR_Diagnosis table.
	5.Based upon the 'A' and 'E' the MR_DTL table will Insert or update.
	5.Last item in the String is indicates that wheather the code is added from the Add New Diag Button ('I') added ('X') not added.
	6. The below code works in the same way.

*/
				if(combined_map==null && diag_dates_map==null ){
							String ACT_CODES_SQL="SELECT SRL_NO,TERM_CODE,TERM_CODE_SHORT_DESC,TERM_SET_ID,OCCUR_SRL_NO, DIAGNOSIS_GROUP,TO_CHAR(ONSET_DATE,'DD/MM/YYYY hh24:MI')ONSET_DATE FROM MR_DEATH_REGISTER_DIAG_DTL WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+FacilityId+"' GROUP BY DIAGNOSIS_GROUP,OCCUR_SRL_NO,ONSET_DATE,TERM_CODE,TERM_CODE_SHORT_DESC,TERM_SET_ID,SEQ_NO,SRL_NO ORDER BY SEQ_NO,TERM_CODE";
							pstmt=conn.prepareStatement(ACT_CODES_SQL);
							rs=pstmt.executeQuery();
							int index=1;
							maxRecords=0;
							maxRecords1=0;
							String status="";
							while(rs.next()){
								status="E";
								//boolean disp=false ;
								index						=	rs.getInt("SRL_NO");
								code							=	checkForNull(rs.getString("TERM_CODE"));
								term_set_id				=	checkForNull(rs.getString("TERM_SET_ID"));
								occur_srl_no				=	checkForNull(rs.getString("OCCUR_SRL_NO"));
								code_short_desc		=	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
								code_onset_date		=	checkForNull(rs.getString("ONSET_DATE"));
								code_onset_date		= DateUtils.convertDate(code_onset_date,"DMYHM" ,"en",locale);
								diagnosis_group		=	checkForNull(rs.getString("DIAGNOSIS_GROUP"));
								if(diagnosis_group.equals("C")){
									diag_dtl_record		=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
									primaryList.add(diag_dtl_record);
								}
								if(diagnosis_group.equals("O")){
									diag_dtl_record		=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
									OthersList.add(diag_dtl_record);
								}
								if(diagnosis_group.equals("R")){
									diag_dtl_record	=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
									general_list.add(diag_dtl_record);
								}
								db_diagdates_map.put(diag_dtl_record,code_onset_date);
//								db_diagdesc_map.put(diag_dtl_record,code_short_desc);
//								data_base_list.add(diag_dtl_record);
								maxRecords++;
							}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();

							String ACT_CODES_SQL1="SELECT  A.TERM_SET_ID, A.TERM_CODE,A.OCCUR_SRL_NO, TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY HH24:MI') ONSET_DATE,A.TERM_CODE_SHORT_DESC, E.DIAG_CLASS_CODE FROM PR_DIAGNOSIS A , MR_TERM_SET B, MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E  WHERE  A.PATIENT_ID = '"+patient_id+"' AND E.ENCOUNTER_ID='"+encounter_id+"' AND E.FACILITY_ID='"+FacilityId+"' AND E.STATUS='A' AND A.CURR_STATUS=E.STATUS AND A.PATIENT_ID=E.PATIENT_ID AND A.TERM_SET_ID=E.TERM_SET_ID AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO AND  A.TERM_CODE  =E.TERM_CODE AND A.ONSET_FACILITY_ID=E.FACILITY_ID  AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID='"+FacilityId+"' AND TERM_SET_ID=A.TERM_SET_ID)  AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+encounter_id+"') AND TERM_SET_ID=A.TERM_SET_ID) AND NOT EXISTS (SELECT 1 FROM MR_DEATH_REGISTER_DIAG_DTL WHERE FACILITY_ID= A.ONSET_FACILITY_ID AND ENCOUNTER_ID=E.ENCOUNTER_ID AND  TERM_SET_ID = A.TERM_SET_ID AND TERM_CODE = A.TERM_CODE  AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) AND B.TERM_SET_ID(+) = A.TERM_SET_ID  AND C.TERM_SET_ID(+) =A.TERM_SET_ID AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY A.TERM_CODE  ";
							pstmt=conn.prepareStatement(ACT_CODES_SQL1);
							rs=pstmt.executeQuery();
							maxRecords1=0;
							while(rs.next()){
								status="A";
//								index	= maxRecords+1;
								index						=	 maxRecords+1;
								code							=	checkForNull(rs.getString("TERM_CODE"));
								term_set_id				=	checkForNull(rs.getString("TERM_SET_ID"));
								occur_srl_no				=	checkForNull(rs.getString("OCCUR_SRL_NO"));
								code_short_desc		=	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
								diag_class_code		=	checkForNull(rs.getString("DIAG_CLASS_CODE"));//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
								code_onset_date		=	checkForNull(rs.getString("ONSET_DATE"));
								code_onset_date		= DateUtils.convertDate(code_onset_date,"DMYHM" ,"en",locale);
								diag_dtl_record		=	index+"#"+status+"#"+code+"#"+term_set_id+"#"+occur_srl_no+"#"+code_short_desc+"#"+"X";
								
								/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
								if(isDeceasedDiagClassDeathRegAppl){
									if(!primary_diag_class.equals("") && secondary_diag_class.equals("")){
										if(diag_class_code.equals(primary_diag_class)){
											primaryList.add(diag_dtl_record);
										}else{
											general_list.add(diag_dtl_record);
										}
									}else if(primary_diag_class.equals("") && !secondary_diag_class.equals("")){
										if(diag_class_code.equals(secondary_diag_class)){
											OthersList.add(diag_dtl_record);
										}else{
											general_list.add(diag_dtl_record);
										}
									}else if(!primary_diag_class.equals("") && !secondary_diag_class.equals("")){
										if(diag_class_code.equals(primary_diag_class)){
											primaryList.add(diag_dtl_record);
										}else if(diag_class_code.equals(secondary_diag_class)){
											OthersList.add(diag_dtl_record);
										}else{
											general_list.add(diag_dtl_record);
										}
									}else{
										general_list.add(diag_dtl_record);
									}
								}else{
									general_list.add(diag_dtl_record);
								}
								/*End ML-MMOH-CRF-1742*/

								db_diagdates_map.put(diag_dtl_record,code_onset_date);
//								db_diagdesc_map.put(diag_dtl_record,code_short_desc);
								maxRecords=index;
//								maxRecords1++;
							}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();

							if(combined_map==null){
								combined_map =new HashMap();
	//							data_base_map.put("Y",data_base_list);
								combined_map.put("C",primaryList);
								combined_map.put("O",OthersList);
								combined_map.put("R",general_list);
								session.setAttribute("combined_map",combined_map);
							}
							if(diag_dates_map==null){
								diag_dates_map =new HashMap();
								diag_dates_map =db_diagdates_map;
								session.setAttribute("diag_dates_map",diag_dates_map);

							}
							/*if(diag_desc_map==null){
								diag_desc_map =new HashMap();
								diag_desc_map =db_diagdesc_map;
								session.setAttribute("diag_desc_map",diag_desc_map);
							}*/
							totalRecords1=(maxRecords);
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
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

//				combined_map=null;
/*
	FYI:
	1.When  MDR  window is reloded.
	2.The maps are getting from the session. The updated then data will be painted as in the groups .
	3.Last item in the String is indicates that wheather the code is added from the Add New Diag Button ('I') added ('X') not added.
	4. The below code works in the same way.
*/

				if(combined_map!=null){
					if(combined_map.containsKey("C")){
						primaryList=(ArrayList)combined_map.get("C");
					}
					if(combined_map.containsKey("O")){
						OthersList=(ArrayList)combined_map.get("O");
					}
					if(combined_map.containsKey("R")){
						general_list=(ArrayList)combined_map.get("R");
					}
					if(increment_records.equals("Y")){
						totalRecords1=(totalRecords1+1);
					}

					 if(primaryList!=null&&primaryList.size()>0){
						 String diag_onset_date="";
				
            _bw.write(_wl_block12Bytes, _wl_block12);
if(isDeceasedDiagClassDeathRegAppl){
								if(!primary_diag_class.equals("")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(primary_diag_class_LD));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

							String primary_diag_record="";
							String diag_illnes_date="";
							 while(j<primaryList.size()){
								StringTokenizer st_prime_tkn	 = new StringTokenizer((String)primaryList.get(j),"#");
								Integer.parseInt(st_prime_tkn.nextToken());
								st_prime_tkn.nextToken() ;
								String prime_code				 = st_prime_tkn.nextToken();
								st_prime_tkn.nextToken();
								st_prime_tkn.nextToken();
								primary_diag_record=(String)primaryList.get(j);
								diag_onset_date=(String)diag_dates_map.get(primary_diag_record);
//								out.println("diag_onset_date========1=======>" +diag_onset_date);

								//diag_onset_date		= DateUtils.convertDate(diag_onset_date,"DMYHM" ,"en",locale);
//								out.println("diag_onset_date===============>" +diag_onset_date);

						
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(primary_diag_record));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prime_code));
            _bw.write(_wl_block25Bytes, _wl_block25);

								String prime_desc	=  st_prime_tkn.nextToken();

							
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(prime_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

								String diag_dates_records1=diag_onset_date;
								String th_date			= "";
								String DATE_SQL	= "";
								/*
									F.Y.I:
									1.The populating theDuration Of illness value is done by JS function paintValue(); in the same JSP page; 
									2.The above statement was enhanced to dispaly Duration Of illness aganist each diagnosis.
									3.The below Query wil be executed based upon the Finalize_YN value.
									3.For gap CRF ADD-SRR20056-CRF-450.xls Modified On 1/7/2010.
								*/
								if(!diag_dates_records1.equals("")){
									th_date=DateUtils.convertDate(diag_dates_records1,"DMYHM" ,locale,"en");
									diag_illnes_date="to_date('"+th_date+"','dd/mm/yyyy hh24:mi')";
									if(finalize_yn.equals("Y")){
										 DATE_SQL="SELECT MP_CALCULATE_AGE_YMD(LEAST("+diag_illnes_date+"),'YMDH',MODIFIED_DATE) ILLNESS_DATE FROM MR_DEATH_REGISTER_HDR WHERE FACILITY_ID='"+FacilityId+"' AND PATIENT_ID = '"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' ";
									}else{
										 DATE_SQL="SELECT MP_CALCULATE_AGE_YMD(LEAST("+diag_illnes_date+"),'YMDH',SYSDATE) ILLNESS_DATE FROM DUAL";
									}
									pstmt=conn.prepareStatement(DATE_SQL);
									rs=pstmt.executeQuery();
									while(rs.next()){
										hid_illnes_date=checkForNull(rs.getString("ILLNESS_DATE"));
									}
									if(pstmt!=null)pstmt.close();
									if(rs!=null)rs.close();
								}
								String onset_date	=	diag_dates_records1;
							
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(hid_illnes_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block42Bytes, _wl_block42);
j++;}
						if(j==0||j==1){
							dis_seq_btn	="disabled";
						}
					
            _bw.write(_wl_block43Bytes, _wl_block43);

					}else{
						dis_seq_btn	="disabled";
					}
					if(OthersList!=null && OthersList.size()>0){
						
            _bw.write(_wl_block44Bytes, _wl_block44);
if(isDeceasedDiagClassDeathRegAppl){
									if(!secondary_diag_class.equals("")){
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(secondary_diag_class_LD));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block48Bytes, _wl_block48);

							 while(k<OthersList.size()){
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(k));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(OthersList.get(k)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block51Bytes, _wl_block51);

								StringTokenizer st_others_tkn	 = new StringTokenizer((String)OthersList.get(k),"#");
								 Integer.parseInt(st_others_tkn.nextToken());
								 st_others_tkn.nextToken() ;
								String othr_code			= st_others_tkn.nextToken();
								 st_others_tkn.nextToken();
								 st_others_tkn.nextToken();
								String othr_desc	=  st_others_tkn.nextToken();
							
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(othr_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(othr_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
k++;}
            _bw.write(_wl_block55Bytes, _wl_block55);
}
					if(general_list!=null && general_list.size()>0){
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								while(i<general_list.size()){
									boolean disp=false ;
									boolean disp1=false ;
									if(primaryList!=null && OthersList!=null ){
										disp= primaryList.contains(general_list.get(i));
										disp1= OthersList.contains(general_list.get(i));
									}
									if(disp || disp1){
										general_list.remove(general_list.get(i));
										continue;
									}
								
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(general_list.get(i)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disable_fields));
            _bw.write(_wl_block62Bytes, _wl_block62);

										StringTokenizer st_genaral_tkn	 = new StringTokenizer((String)general_list.get(i),"#");
										Integer.parseInt(st_genaral_tkn.nextToken());
										st_genaral_tkn.nextToken() ;
										String gen_code		 = st_genaral_tkn.nextToken();
										 st_genaral_tkn.nextToken();
										 st_genaral_tkn.nextToken();
//										String gen_desc=getDesc(gen_code,gen_tm_set_id,gen_ocur_srlno,FacilityId,patient_id,encounter_id,request);
//										String gen_desc=(String)diag_desc_map.get((String)general_list.get(i));
										String gen_desc	=  st_genaral_tkn.nextToken();

										
									
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(gen_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(gen_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
i++;}
            _bw.write(_wl_block66Bytes, _wl_block66);
}
			}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disable_btns));
            _bw.write(_wl_block68Bytes, _wl_block68);
if((!isDeceasedDiagClassDeathRegAppl) || (isDeceasedDiagClassDeathRegAppl && primary_diag_class.equals("") && secondary_diag_class.equals(""))){
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.addnewdiagnosis.label","mr_labels")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Sequence.label","mr_labels")));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(dis_seq_btn));
            _bw.write(_wl_block82Bytes, _wl_block82);
}catch(Exception ex){
				ex.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(conn,request);
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

		}
		
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(j));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(k));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(max_pri_diag));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(max_oth_dis));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(totalRecords1));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(currentdateTime));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(isDeceasedDiagClassDeathRegAppl));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(primary_diag_class));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(secondary_diag_class));
            _bw.write(_wl_block107Bytes, _wl_block107);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Select.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.durationofillness.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.otherdiseasecomplication.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.otherdiseasecomplication.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.generaldiaglist.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.moveto.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.otherdiseasecomplication.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.generaldiaglist.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
