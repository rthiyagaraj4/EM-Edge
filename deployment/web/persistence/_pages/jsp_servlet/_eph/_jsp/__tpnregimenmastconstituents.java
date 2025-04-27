package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import ePH.*;
import eCommon.Common.*;
import ePH.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnregimenmastconstituents extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegimenMastConstituents.jsp", 1709121517420L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n<!-- \t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/messages.js\"></SCRIPT>\n -->\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhCommon.js\"></SCRIPT>\n<!-- \t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhMessages.js\"></SCRIPT>\n -->\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/TPNRegimenMast.js\"></SCRIPT>\n    <script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY TOPMARGIN=\"0\" onKeyDown=\"lockKey()\" onMouseDown=\"CodeArrest()\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<FORM name=\"TPNRegimenMastConsForm\" id=\"TPNRegimenMastConsForm\">\n\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t<TR>\n\t\t<TH COLSPAN=\"4\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</TH>\n\t</TR>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t<TR>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<!-- this is for non single emulsion -->\n\t\t<TD CLASS=\"LABEL\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TD>\n          ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t   <TD CLASS=\"LABEL\">&nbsp;<INPUT TYPE=\"text\" ID=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="_label\" SIZE=\"4\" MAXLENGTH=\"6\" CLASS=\"number\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onblur =\" return fluid_max(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\">&nbsp;<LABEL ID=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="_unit_label\" STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</LABEL>\n\t   ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<TD CLASS=\"LABEL\"><LABEL ID=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="_label\" STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</LABEL>&nbsp;<LABEL ID=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<INPUT TYPE=\"hidden\" name=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" VALUE=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"><INPUT TYPE=\"hidden\" name=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_unit\" id=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="_unit\" VALUE=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="_rel_value\" id=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="_rel_value\" VALUE=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></TD>\n\n\t\t<TD CLASS=\"LABEL\" nowrap>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\n\t\t<INPUT TYPE=\"text\" SIZE=\"4\" MAXLENGTH=\"6\" CLASS=\"number\" name=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="_perc\" id=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="_perc\" VALUE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  onKeyPress=\"return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,2)); \" onblur =\" return percent_max(this,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\">&nbsp;%&nbsp;</TD>\n\t\t<TD CLASS=\"LABEL\">\n\t\t\t<INPUT TYPE=\"text\" SIZE=\"4\" MAXLENGTH=\"6\" CLASS=\"number\" name=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="_vol\" id=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="_vol\" onKeyPress=\"return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,2)); \" onBlur=\"defaultPerc(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');totalEnergy(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');defaultFluidBalance(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');npcRatio(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\"   VALUE=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" onBlur=\"Calc_Percentage(this, \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\">&nbsp;<LABEL STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" name=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="_actuom\" /><!-- added for ML-MMOH-SCF-1303 -->\n\t\t\t</LABEL>\n\t\t\t\n\t\t\t</TD>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n        \n\t\t<TD CLASS=\"LABEL\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</TD>\n\t\t<TD COLSPAN=\"2\">&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<INPUT TYPE=\"text\" MAXLENGTH=\"6\" name=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" SIZE=\"4\" CLASS=\"number\" VALUE=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onBlur=\"enableLipidEmulsion(this); final_check(this,\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\');\" onKeyPress=\"return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,2));\">\t<LABEL STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</LABEL>\n\t\t<INPUT TYPE=\"hidden\" name=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"></td>\n\t\t\t<TD>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\n\t\t<INPUT TYPE=\"text\" MAXLENGTH=\"6\" name=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onBlur=\"enableLipidEmulsion(this); Calc_Percentage(this, \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\', \'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\',2);npcRatio(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\',2);\" onKeyPress=\"return allowValidNumber(this,event,6,2);  return(ChkNumberInput(this,event,2));\">&nbsp;<LABEL STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<INPUT TYPE=\"text\" MAXLENGTH=\"6\" name=\"des_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"des_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"SIZE=\"4\" CLASS=\"number\" onBlur=\" Calc_Value(this, \'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',2)\" onKeyPress=\"return allowValidNumber(this,event,6,2); return(ChkNumberInput(this,event,0));\">\n<LABEL STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">%W/V</LABEL>\t\n\n </TD>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\n\t</TR>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t<TR>\n\t\t<TD CLASS=\"LABEL\"><B>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</B></TD>\n\t\t<TD  CLASS=\"LABEL\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<LABEL ID=\"total_energy\" STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</LABEL>&nbsp;\n\t\t<LABEL ID=\"total_energy_uom\" STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</LABEL><INPUT TYPE=\"hidden\" name=\"ttl_energy\" id=\"ttl_energy\" VALUE=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"><INPUT TYPE=\"hidden\" name=\"ttl_energy_uom\" id=\"ttl_energy_uom\" VALUE=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<TD CLASS=\"LABEL\" nowrap> \n\t\t\t&nbsp;&nbsp;\n\t\t\t ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\t\t\t \n\t\t&nbsp;&nbsp;</TD>\n\t\t<TD CLASS=\"LABEL\">\n\t\t\t\t <select name=\"lipid_emulsion_type\" id=\"lipid_emulsion_type\" disabled>\t\n\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="---</option>\n\t\t\t<option value=\"L\" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</option>\n\t\t\t<option value=\"B\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</option>\n\t\t\t</select> \n\t\t </TD>\n\t</TR>\t\n\t\n<TR height=\"2\" colspan=\"4\"><TD CLASS=\"LABEL\"><LABEL ID=\"npc_nam\" STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</LABEL></TD>\n\t<TD CLASS=\"LABEL\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<LABEL ID=\"npc_ratio\" STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="   :   1</LABEL><INPUT TYPE=\"hidden\" name=\"npc_ratio_val\" id=\"npc_ratio_val\" VALUE=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"></TD><TD></TD><TD></TD></TR>\t\t\n\t<TR height=\"3\" ><TD CLASS=\"LABEL\"></TD><TD></TD><TD></TD><TD></TD></TR>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n\t\t<TD CLASS=\"LABEL\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</TD>\n\t\t<TD>&nbsp;&nbsp;\n\t\t\n\t\t<INPUT TYPE=\"text\" name=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" SIZE=\"4\" MAXLENGTH=\"5\" CLASS=\"number\" VALUE=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" onBlur=\"validNumber(this)\" onKeyPress=\"return(ChkNumberInput(this,event,2));\">&nbsp;<LABEL STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</LABEL><INPUT TYPE=\"hidden\" name=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"></TD>\n\n\t\t<TD CLASS=\"LABEL\" >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"></TD>\n\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</TD>\n\t\t<td colspan=\"3\">&nbsp;&nbsp;\n\t\t\n\t\t<INPUT TYPE=\"text\" name=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" SIZE=\"4\" MAXLENGTH=\"5\" VALUE=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" CLASS=\"number\" onBlur=\"validNumber(this)\" onKeyPress=\"return(ChkNumberInput(this,event,2));\">&nbsp;<LABEL STYLE=\"font-size:9;font-weight:bold;color:navy;font-family:verdana\">";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"></td>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\n\t</TABLE>\n\n\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name=\"all_fields\" id=\"all_fields\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name=\"micro_nut_enterable_yn\" id=\"micro_nut_enterable_yn\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"> <!-- Added for ML-MMOH-CRF-1266 [IN:068728] -->\n</FORM>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );
	
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


public String roundTwoDigits(String a)
{
	try
	{
		String bb			= "";
		String last			= "";
		double final_value	= 0f;
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3){
					last = a.substring(a.indexOf(".")+3,a.indexOf(".")+4);	
					bb=a.substring(0,a.indexOf(".")+3);

					if(Integer.parseInt(last) >=5){
						final_value = Double.parseDouble(bb)+0.01;
						bb = final_value+"";
					}
				}else{
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 /*
Date       		Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				 ?				 ?				    ?			    ?								   ?
29/01/2019		    IN068728		 Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	/* Mandatory checks start */
	String bean_id		= "TPNRegimenMastBean";
	String bean_name	= "ePH.TPNRegimenMastBean";
	/* Mandatory checks end */

	/* Initialize Function specific start */
	TPNRegimenMastBean bean	= (TPNRegimenMastBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList display_list	= bean.displayConsGroup();
	/* Initialize Function specific end */

	String single_emul	= request.getParameter("single_emul");
	String group_code	= "";
	String group_name	= "";
	String unit			= "";
	String unit_desc	= "";
	String code			= "";
	String desc			= "";
	String code_1		= "";
	String desc_1		= "";
	String code_2		= "";
	String desc_2		= "";
	String unit_1		= "";
	String unit_2		= "";
	String unit_desc1		= "";
	String unit_desc2		= "";
	String label_unit	= "";
	ArrayList legends	= null;
	String totval="";
	String label_double_emul = "";
	String temp_code = "";
	String recalval = "";
	float recalval1 = 0.0f;
	String test="";

	String lctSelect = "";
	String mctSelect = "";
	String lctmctSelect = "";
	String lipid_emulsion_type = "";
	String total_energy	 =  "";
	String npc_ratio	= "0";
	String temp_label_double_emul = "";//added for ml-mmoh-scf-1303


            _bw.write(_wl_block9Bytes, _wl_block9);

     boolean micro_nut_enterable_yn  = false; // Added for ML-MMOH-CRF-1266 [IN:068728] - Start     
     Connection connection = null;
     try {
    	 connection = ConnectionManager.getConnection(request);	     
	     micro_nut_enterable_yn = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","MACRO_ENTERABLE_YN");
     }
     catch(Exception e) {
	    out.print("Exception @ Result JSP :"+e.toString());
	    e.printStackTrace();
     }
     finally{		
	  if(connection != null)
	   ConnectionManager.returnConnection(connection,request);
     } // Added for ML-MMOH-CRF-1266 [IN:068728]  - End

	HashMap engval = bean.getEnergyValues();
	lipid_emulsion_type = bean.getLipidEmulsion();
		if(lipid_emulsion_type == null) lipid_emulsion_type = "";
	
	if(lipid_emulsion_type.equals("L")){
		lctSelect = "SELECTED";
		mctSelect = "";
		lctmctSelect = "";
	}else if(lipid_emulsion_type.equals("M")){
		mctSelect = "SELECTED";
		lctmctSelect = "";
		lctSelect = "";
	}else if(lipid_emulsion_type.equals("B")){
		lctmctSelect = "SELECTED";
		mctSelect = "";
		lctSelect = "";
	}
	
	for(int i=0; i<display_list.size(); i+=2) {
		group_code	= (String)display_list.get(i);
		group_name	= (String)display_list.get(i+1);

		legends		= bean.getLegends(group_code);

		if(legends.size() >=1 ) {
			

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(group_name));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}

		if(group_code.equals("FL") || group_code.equals("MN")) {

		
			for(int j=0; j<legends.size(); j+=4){
				code = (String)legends.get(j);
				test = test + "~" +  code;
				
			}
			
			for(int j=0; j<legends.size(); j+=4) {
				recalval1 = 0f;
				code = (String)legends.get(j);
				desc = (String)legends.get(j+1);
				unit = (String)legends.get(j+2);
				unit_desc = (String)legends.get(j+3);
				
				if (i==0){
					totval = code;
					if( bean.getValue(code) != null && bean.getValue(code) != "")
					{
					recalval = bean.getValue(code);
					}
					label_double_emul = unit_desc;
					temp_label_double_emul=unit;//added for ml-mmoh-scf-1303
				}
				

            _bw.write(_wl_block12Bytes, _wl_block12);


				if(group_code.equals("MN") && single_emul.equals("N")) {
	               if(!bean.getValue(code).equals("")){
						label_unit = unit;
				   }
					else
						label_unit = "";
					temp_code = temp_code + code;
					

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);
if(micro_nut_enterable_yn){// Added for ML-MMOH-CRF-1266 [IN:068728] - Start 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.getValue(code)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(label_unit));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.getValue(code)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(label_unit));
            _bw.write(_wl_block22Bytes, _wl_block22);
} // Added for ML-MMOH-CRF-1266 [IN:068728] - End 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.getValue(code)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(engval.get(code)));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(code.equals("LIPID")) {
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getPerc(code)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(test));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getVolume(code)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(label_double_emul));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(temp_label_double_emul));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(code));
            _bw.write(_wl_block51Bytes, _wl_block51);

				

				}
				else {

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block53Bytes, _wl_block53);

	if(group_code.equals("FL")){
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.getValue(code)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(single_emul));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(unit_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(unit));
            _bw.write(_wl_block61Bytes, _wl_block61);

	}
	else {
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.getValue(code)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(test));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(test));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(test));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(unit_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(engval.get(code)));
            _bw.write(_wl_block61Bytes, _wl_block61);
			if (recalval != "" && bean.getValue(code) != null && bean.getValue(code) != ""){
				recalval1 = (Float.parseFloat(bean.getValue(code)) * 100)/Float.parseFloat(recalval);
			}


            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(roundTwoDigits(recalval1+"")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(test));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(test));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(test));
            _bw.write(_wl_block71Bytes, _wl_block71);

		}
	}

            _bw.write(_wl_block72Bytes, _wl_block72);

			}

	if(group_code.equals("MN") ){
		
	total_energy = bean.getTtlEnrgy();
	     if(total_energy == null) total_energy = "";

	npc_ratio = bean.getNpcRatio();
	     if(npc_ratio == null) npc_ratio = "";


            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(total_energy));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean.getEnergyUnit()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(total_energy));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.getEnergyUnit()));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(lctSelect));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mctSelect));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(lctmctSelect));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(npc_ratio));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(npc_ratio));
            _bw.write(_wl_block87Bytes, _wl_block87);

		}
	}
		else {
			for(int j=0; j<legends.size(); j+=8) {

            _bw.write(_wl_block12Bytes, _wl_block12);

				if(j+5 <= legends.size()) {
					code_1 = (String)legends.get(j);
					desc_1 = (String)legends.get(j+1);
					unit_1 = (String)legends.get(j+2);
					unit_desc1 = (String)legends.get(j+3);
					code_2 = (String)legends.get(j+4);
					desc_2 = (String)legends.get(j+5);
					unit_2 = (String)legends.get(j+6);
					unit_desc2 = (String)legends.get(j+7);
					

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(desc_1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bean.getValue(code_1)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(unit_desc1));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(unit_1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(desc_2));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(code_2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_2));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bean.getValue(code_2)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(unit_desc2));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(code_2));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code_2));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(unit_2));
            _bw.write(_wl_block94Bytes, _wl_block94);

				}
				else {
					code_1	= (String)legends.get(j);
					desc_1	= (String)legends.get(j+1);
					unit	= (String)legends.get(j+2);
					unit_desc = (String)legends.get(j+3);

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(desc_1));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(bean.getValue(code_1)));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(unit_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code_1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(unit));
            _bw.write(_wl_block98Bytes, _wl_block98);

				}

            _bw.write(_wl_block72Bytes, _wl_block72);

			}
		}
	}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(test));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(micro_nut_enterable_yn));
            _bw.write(_wl_block103Bytes, _wl_block103);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block104Bytes, _wl_block104);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalEnergy.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Lipid-EmulsionType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LCT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MCT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MixtureofMCTandLCT.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NPC:NRatio.label", java.lang.String .class,"key"));
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
}
