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
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __tpnregnonstdregdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegNonStdRegDetails.jsp", 1743130259370L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHReports.js\"></SCRIPT>\n\t\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/TPNNonStdRegimen.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<BODY>\n\t<FORM name=\"TpnNonStandardRegimen\" id=\"TpnNonStandardRegimen\"> \n\t<input type=\"hidden\" id=\"bean_id\" name=\"bean_id\" id=\"bean_id\" value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" >\n    <input type=\"hidden\" id=\"bean_name\" name=\"bean_name\" id=\"bean_name\" value=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >\n    <input type=\"hidden\" id=\"mode\" name=\"mode\" id=\"mode\" value=\"\">\n<div id=\"MN\" name=\"MN\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4 align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th><TH colspan=2 align=\"center\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th><th colspan=2 >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\n</Tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t<tr>\n\t<Td   class=\"label\" align=\"right\" width=\"12%\" nowrap ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" title=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="  id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  value=\"MN\">\n\t\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\n\t\t\t\t\n\t</Td>\n\t<!-- checkMaxLimit(this,6) -->\n\t\n\t<Td   class=\"label\" align=\"left\" width=\"8%\">&nbsp;<input type=text title=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onkeypress=\"return allowValidNumber(this,event,4,2);\" onBlur=\"CheckPositiveNumber(this);checkMand(this,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');calculateValue(document.TpnNonStandardRegimen,";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",this.value);CheckRange(this,";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\" name=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" maxlength=6 size=6  value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">&nbsp;</Td>\n   \t<Td   class=\"label\" align=\"left\" width=\"5%\" name=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;</td>\n\t<td width=\"18%\" align=\'left\'><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" STYLE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" ID=\"return_mandate";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></IMG><label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\' style=\"visibility:visible\"\tid=\'overrid";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\"showreason(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\" nowrap > &nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label></Td>\n    <Td   class=\"label\" align=\"right\" width=\"7%\" name=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</Td>\n    <Td   class=\"label\" align=\"left\" width=\"5%\" name=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >&nbsp;&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</Td>\n\n\t<Td   class=\"label\" align=\"right\" width=\"10%\">&nbsp;&nbsp;<input type=text size=6 maxlength=6 id=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' name=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onkeypress=\'return allowValidNumber(this,event,4,4);\' onchange=\"CheckPositiveNumber(this);if (this.value==0){this.value=\'\'};checkMand(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');calculateFrmStrngth(document.TpnNonStandardRegimen,";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",this.value);\">\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t</Td>\n\t<Td   class=\"label\" align=\"left\" width=\"5%\">&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</Td>\n\t<Td   class=\"label\" width=\"9%\" align=\"right\"  id=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" name=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t <Td   class=\"label\"  width=\"5%\" align=\"left\" >&nbsp;<b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</Td>\n\t ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t <td colspan=2 align=\'left\' width=\'6%\'>&nbsp;&nbsp;&nbsp;&nbsp;<select name=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" onchange=\"populateVolume(this,\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\')\"><option value=\" \">-------------------";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="------------------</option>\n\t ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</option>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t  \n\t </select></td>\n\t ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t <td colspan=2>&nbsp;</td>\n\t ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t <td class=label colspan=6 align=\'center\' name=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =">&nbsp;</td>\n</tr>\n   \n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n<tr><td class=\"label\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\n<tr><td class=\"white1\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\n<tr><td class=\"label\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\t\n  <tr>\n   <Td   class=\"label\" colspan=\"2\"align=\"right\" ><b>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</b></td>\n\t<Td   class=\"label\">&nbsp;&nbsp;&nbsp;<label class=\"label\" id=\"npc_label\" name=\"npc_label\" align=\"left\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</label>:1</label></Td>\n\t<Td   class=\"label\" colspan=\"5\"align=\"right\" >&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</b></td>\n\t<Td   class=\"label\" align=\"RIGHT\" colspan=\"1\" id=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="><label class=\"label\" id=\"tot_label\" name=\"tot_label\"> ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="<label></td>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" \n\t<Td   class=\"label\" align=\"left\" colspan=10>&nbsp;<b>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</b></Td>\n \n  </tr>  \n\t  <tr><td class=\"label\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\n\t  \n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\n\n</table>\n</div>\n<div id=\"EL\" name=\"EL\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4 align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</th><th colspan=2>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</th><th colspan=4>&nbsp;</th>\n\t\n\n</Tr>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\n\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="  value=\"EL\">\n\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\n\t</Td>\n\t<Td   class=\"label\" align=\"left\" width=\"8%\">&nbsp;\n\t<input type=text   ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="  title=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" onBlur=\"CheckPositiveNumber(this);checkMand(this,\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');CheckRange(this,";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" maxlength=5 size=5  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">&nbsp;</Td>\n\t<Td   class=\"label\"  width=\"5%\"align=\"left\" name=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t</IMG><label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\'\tstyle=\"visibility:hidden\"\tid=\'overrid";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\')\"> &nbsp;";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</label></Td>\n    <Td   class=\"label\"  width=\"9%\"align=\"right\" name=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&nbsp;</Td>\n    <Td   class=\"label\"  width=\"8%\"align=\"left\" name=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" >&nbsp;";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</Td>\n\t\t\n\t<Td   class=\"label\"  width=\"10%\"align=\"right\"><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =",this.value);\">\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\n\t</Td>\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n                  <td colspan=2 align=\'left\' width=\'10%\'>&nbsp;&nbsp;&nbsp;<select   name=";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="><option value=\" \">----------------------------";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="--------------------------</option>\n\t\t\t\t ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t </select></td>\n\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t <td colspan=2>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t<td colspan=2>&nbsp;</td>\n \n\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</table>\n</div>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n<div id=\"TR\" name=\"TR\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n<TR>\n\t<TH colspan=4 align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</th><TH colspan=2 align=\'left\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</th><th colspan=2 align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</th>\n\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\n</Tr>\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\t\n\t<Td   class=\"label\" align=\"right\" width=\"12%\" nowrap ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="  value=\"TR\">\n\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t</Td>\n\t<Td   class=\"label\" align=\"right\" width=\"8%\">&nbsp;<input type=text title=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="  onBlur=\"CheckPositiveNumber(this);checkMand(this,\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =");\"  name=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">&nbsp;</Td>\n\t<Td class=\"label\" align=\"left\" width=\"5%\" name=";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"></IMG><label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\'\tstyle=\"visibility:hidden\"\tid=\'overrid";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</label></Td>\n    <Td class=\"label\" align=\"right\" width=\"4%\" name=";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</Td>\n    <Td class=\"label\" align=\"left\" width=\"6%\" name=";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</Td>\n\n\n\t<Td   class=\"label\" align=\"right\" width=\"8%\"><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\n\t</Td>\n\t<Td   class=\"label\" align=\"left\">&nbsp;";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="&nbsp;";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</Td>\n\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t <td colspan=2 align=\'left\' width=\"8%\">&nbsp;&nbsp;&nbsp;<select name=";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\')\"><option value=\" \">----------------------------";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="--------------------------</option>\n\t ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t</select></td>\n\t ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t <td class=label colspan=2 align=\'center\' name=";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =">&nbsp;</td>\n</tr>\n\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t</table>\n\t</div>\n\n\n<div id=\"VT\" name=\"VT\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=5 ALIGN=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</th><th colspan=2 align=\'center\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</th><th colspan=2 align=\'left\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n\t\t<Td   class=\"label\" align=\"right\" width=\"12%\" nowrap ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="  value=\'VT\'>\n\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t</Td>\n\t\t<Td   class=\"label\" align=\"left\" width=\"5%\">&nbsp;<input type=text ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =")\"  name=";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">&nbsp;</Td>\n\t\t<Td   class=\"label\" align=\"left\" width=\"5%\" name=";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="&nbsp;<td>\n\t\t<td width=\"18%\" align=\'left\'><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" STYLE=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\')\" nowrap > ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</label></Td>\n        <Td class=\"label\" align=\"right\" width=\"6%\" name=";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</Td>\n        <Td class=\"label\" align=\"left\" width=\"6%\" name=";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</Td>        \n\t\t<Td   class=\"label\" align=\"right\" width=\"10%\">&nbsp;&nbsp;<input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\n\t\t</Td>\n\t\t<Td   class=\"label\" align=\"left\">&nbsp;";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</Td>\n\t\t \n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t <td colspan=2 align=\'left\' width=\"15%\">&nbsp;&nbsp;&nbsp;<select name=";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</select></td>\n\t ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =">&nbsp;</td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t</table>\n\t</div>\n\n\n\n<div id=\"OT\" name=\"OT\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4 align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</th><TH colspan=2>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\n</Tr>\n\n\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\t\n\t\t<Td   class=\"label\" align=\"right\" width=\"12%\" nowrap style=\"color=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'\" title=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="  value=\"OT\">\n\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\n\t\t</Td>\n\t\t<Td   class=\"label\" align=\"left\" title=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" width=\"8%\" >&nbsp;<input type=text  ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =" onBlur=\"CheckPositiveNumber(this);checkMand(this,\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="&nbsp;</td>\n\t\t<td width=\"18%\" align=\'left\'><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" STYLE=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\"></IMG><label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\'\t\tstyle=\"visibility:hidden\" id=\'overrid";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</Td>  \n\t\t<Td   class=\"label\" align=\"right\"><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\n\t\t</Td>\n\t\t<Td   class=\"label\">\n\t\t\t<!-- <label class=\"label\" id=\"npc_label1\" name=\"npc_label1\" align=\"left\">";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</label> -->\n\t\t\t<label id=\"s1\">&nbsp;";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</label></Td>\n\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t <td colspan=2 align=\'left\' width=\"12%\">&nbsp;&nbsp;&nbsp;<select name=";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t </select></td>\n\t ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t</table>\n\t</div>\n<!-- <script>showDiv(\'MN\',\'document\');</script> -->\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n<BODY>\n\t<FORM name=\"TpnNonStandardRegimen\" id=\"TpnNonStandardRegimen\"> \n\t   <input type=\"hidden\" id=\"bean_id\" name=\"bean_id\" id=\"bean_id\" value=";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =" >\n       <input type=\"hidden\" id=\"bean_name\" name=\"bean_name\" id=\"bean_name\" value=";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" > \n\t   <input type=\"hidden\" id=\"mode\" name=\"mode\" id=\"mode\" value=";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" >\n\t\t\t\t\t\t\t\t\t\t <!--  Macro Nutrient -->\n<div id=\"MN\" name=\"MN\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</th><th colspan=1 align=\'left\'>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\n\n</Tr>\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t<tr>\n\t<Td   CLASS=\"label\" align=\"right\" width=\"12%\" nowrap ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"><font color=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t    <input type=\"hidden\" name=";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t\t\n\t</Td>\n\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\n\t<Td   CLASS=\"label\" align=\"left\" width=\"8%\">&nbsp;<input type=text title=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" maxlength=3 size=5  value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">&nbsp;</Td>\n\n\t<Td   CLASS=\"label\" align=\"left\" width=\"2%\" name=";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="&nbsp;</td>\n\t<td width=\"21%\" align=\'left\'><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" STYLE=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"><label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\'\tstyle=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"\tid=\'overrid";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</label></IMG></Td>\n\n    <Td   CLASS=\"label\" align=\"center\" width=\"8%\" name=";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</Td>\n\n\t<Td   CLASS=\"label\" align=\"right\"  width=\"10%\"><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\n\t</Td>\n\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t<Td   CLASS=\"label\" align=\"left\" width=\"5%\">&nbsp;";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</Td>\n\t<Td   CLASS=\"label\" align=\"right\"  width=\"8%\" id=";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td>\n\t <Td  CLASS=\"label\" align=\"left\"  width=\"10%\">&nbsp;<b>";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</b>&nbsp;";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t <td colspan=2 align=\'left\' width=\"8%\"><select name=";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\')\" disabled ><option value=\" \">----------------------------";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t\t\t\t\t\t\t <option value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" selected>";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</option>\n\t\t\t\t\t\t\t\t\t <!-- <input type=\'hidden\' name=\'def_code\' id=\'def_code\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'> -->\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t\t         <option value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</option> \t\t\t\t\t\t\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" nowrap>&nbsp;</td>\n</tr>\n   <script>populateVolume(\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\')</script>\n";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\n<tr><td class=\"label\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\n<tr><td class=\"white1\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\n<tr><td class=\"label\" colspan=\"18\">&nbsp;&nbsp;</td></tr>\t\n  <tr>\n   <Td   class=\"label\" colspan=\"2\"align=\"right\" ><b>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</b></td>\n\t<Td   class=\"label\" width=\"2%\"><label class=\"label\" id=\"npc_label\" name=\"npc_label\" align=\"left\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</label>:1</label></Td>\n\t<Td   class=\"label\" colspan=\"4\"align=\"right\" >&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="<label></td>\n\t<Td   class=\"label\" align=\"left\" colspan=\"10\">&nbsp;<b>";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\n                                    <!-- ElctroLytes -->\n</table>\n</div>\n<div id=\"EL\" name=\"EL\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4>";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</th><th colspan=2 align=\'right\'>";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</th><th colspan=2 align=\"center\">";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</th>\n<!--\t<td class=\'white\'>&nbsp;</td>\n\t<TH colspan=3>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="<th colspan=2 >Strength/kg</th>-->\n</Tr>\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t</Td>\n\t<Td   class=\"label\" align=\"left\" width=\"8%\">&nbsp;\n\t<input type=text   ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">&nbsp;</Td>   \n\t<Td   class=\"label\" align=\"left\" width=\"5%\"  name=";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"></IMG><label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\'\tstyle=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</label></Td>\n    <Td   class=\"label\" align=\"right\" width=\"15%\"  name=";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</Td>\n   <Td   class=\"label\" align=\"left\" width=\"5%\"  name=";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</Td>\n    \n\t<Td   class=\"label\" align=\"right\" ><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t</Td>\n\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n                                        <!--  , Elements -->\n<div id=\"TR\" name=\"TR\">\n\t\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n<TR>\n\t<TH colspan=4>";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</th><TH colspan=2 align=\'right\'>";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n        <input type=\"hidden\" name=";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n\t\t\n\t</Td>\n\t<Td   class=\"label\" align=\"right\" width=\"8%\">&nbsp;<input type=text title=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">&nbsp;</Td>\n\t<Td   class=\"label\" align=\"left\" width=\"5%\" name=";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</label></Td>\n   <Td   class=\"label\" align=\"right\" width=\"5%\" name=";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</Td>\n   <Td   class=\"label\" align=\"left\" width=\"6%\" name=";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</Td>\n\n\t<Td   class=\"label\" align=\"right\"  width=\"8%\" ><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t</Td>\n\t<Td   class=\"label\" width=\"6%\" align=\"left\">&nbsp;";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t <td colspan=2 align=\'left\' width=\"11%\"><select name=";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</option>\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =">&nbsp;</td>\n</tr>\n<script>populateVolume(\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\')</script>\n\t\t";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t</table>\n\t</div>\n\n                                               <!--  Vitamins -->\n<div id=\"VT\" name=\"VT\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4>";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</th><th colspan=2 align=\'left\' >&nbsp;&nbsp;";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"><font color=";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="  value=\"VT\">\n\t\t\t<input type=\"hidden\" name=";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n\t\t</Td>\n\t\t<Td   class=\"label\" align=\"left\" width=\"8%\">&nbsp;<input type=text ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">&nbsp;</Td>\n\t\t<Td   class=\"label\" width=\"5%\"align=\"left\" name=";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="</td>\n\t\t<td width=\"18%\" align=\'left\'><IMG SRC=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" STYLE=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"></IMG>\n\t\t<label align=\'left\'  style=\'cursor:pointer;color:blue\' name=\'overrid\'\tstyle=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</label></Td>\n        <Td   class=\"label\" width=\"8%\"align=\"right\" name=";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</Td> \n\t\t<Td   class=\"label\" width=\"8%\"align=\"left\" name=";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</Td>\n\t\t<Td   class=\"label\" width=\"9%\"align=\"right\" ><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="</Td>\n\t\t<Td   class=\"label\"width=\"10%\" align=\"left\">&nbsp;";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</Td>\n\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 =">&nbsp;</td>\n\t</tr>\n\t<script>populateVolume(\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t</table>\n\t</div>\n\n\t\t\t\t\t\t\t\t\t\t <!-- Othere Components -->\n\n<div id=\"OT\" name=\"OT\">\n<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n<TR>\n\t<TH colspan=4>";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</th><th colspan=2 align=\'left\'>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</th>";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\n\t\t</Td>\n\t\t<Td   class=\"label\" align=\"right\" title=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="</label></Td>\n        <Td   class=\"label\" width=\"4%\"align=\"right\" name=";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="</Td>\n\t\t<Td   class=\"label\" width=\"6%\"align=\"left\" name=";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</Td>\n\n\t\t<Td   class=\"label\" align=\"right\" width=\"8%\" ><input type=text size=6 maxlength=6 id=";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</Td>\n\t\t<Td   class=\"label\"><label class=\"label\"width=\"8%\" id=\"npc_label1\" name=\"npc_label1\" align=\"left\">&nbsp;";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="</label><label width=\"8%\" id=\"s1\">&nbsp;";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</label></Td>\n\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t</table>\n</div>   \n";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n<input type=\"hidden\" id=\"totalrows\" name=\"totalrows\" id=\"totalrows\" value=";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =" >\n\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" >\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" > \n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n<input type=\"hidden\" name=\"height\" id=\"height\"\t\tvalue=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n<input type=\"hidden\" name=\"weight\" id=\"weight\"\t\tvalue=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\"> \n<input type=\"hidden\" name=\"order_date\" id=\"order_date\"\tvalue=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n<input type=\"hidden\" name=\"priority\" id=\"priority\"\t\tvalue=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n<input type=\"hidden\" name=\"freqNature\" id=\"freqNature\"\t\t\t>\n<input type=\"hidden\" name=\"NPC\" id=\"NPC\"\t\t\tvalue=\"\">\n<input type=\"hidden\" name=\"total\" id=\"total\"\t\t\tvalue=\"\"> \n<input type=\"hidden\" name=\"NPC_N_val\" id=\"NPC_N_val\"\t\tvalue=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n<input type=\"hidden\" name=\"carbo_ener\" id=\"carbo_ener\"\tvalue=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n<input type=\"hidden\" name=\"lipid_ener\" id=\"lipid_ener\"\tvalue=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n<input type=\"hidden\" name=\"prot_ener\" id=\"prot_ener\"\t\tvalue=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\">\n\n</FORM>\n<label id=\"tool_tip\" style=\"visibility:hidden\"></label>\n\t\t<DIV  name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:50%; visibility:visible;\" bgcolor=\"yellow\" align=\"left\">\n\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"right\" bgcolor=\"yellow\">\n\t\t<tr><td width=\"100%\" id=\"t\"></td></tr></div>\n";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n<script>\n\tshowDiv(\'MN\',\'document\');  \n\t//colorTabs(\"parent.DetailFrame.document\");\n\tparent.HeaderFrame.TpnNonStandardRegimen.name1.click(); \n</script> \n</html>\n\n";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );
	
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
		
		String bb = "";
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}
			else
			{   
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3)
				{
					bb=a.substring(0,a.indexOf(".")+4);
				}
				else
				{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e)
	{
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);

   
	String mode1=request.getParameter("mode");
	if(mode1 == null || mode1.equals("undefined")){mode1="";}
	String order_id								= request.getParameter("order_id");
	if(order_id == null){order_id="";}
	String patient_id							= request.getParameter("patient_id");
	String encounter_id						    = request.getParameter("encounter_id");
	String location_type						= request.getParameter("location_type");
	String location_code						= request.getParameter("location_code");
	String pract_id								= request.getParameter("pract_id");
	String act_patient_class					= request.getParameter("act_patient_class");
	String patient_class                        = request.getParameter("patient_class");
	String height								= request.getParameter("height");
	String weight								= request.getParameter("weight");
	String start_date							= request.getParameter("start_date");
	String priority	 							= request.getParameter("priority");
	String disch_medn_yn                        =request.getParameter("take_home_medication");
	String iv_prep_yn			                = "8";
	//String facility                             =(String)session.getValue("facility_id");
	String npc_n_val	= ""; 
	String carbo_ener	= "";
	String lipid_ener	= "";
	String prot_ener	= "";
	//String drug_class   =null;
	//String drug_code    =null;
	//String order_type   =null;
	String volm         =request.getParameter("volm");
	//String order_id     =null;
/*
	if(mode1.equals("amend"))
	{
		location_type=request.getParameter("amend_loc_type");
		location_code=request.getParameter("amend_loc_code");
		priority=request.getParameter("amend_priority");
		patient_class=request.getParameter("amend_pat_class");
		disch_medn_yn=request.getParameter("amend_take_home_medication");
	}*/

	String bean_id	= "@TPNNonStandardRegimenBean"+patient_id+encounter_id;
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);
	
	bean.setLanguageId(locale);
	
	String bean_id1	= "@TPNStandardRegimenBean"+patient_id+encounter_id;
	String bean_name1	 = "ePH.TPNStandardRegimenBean";
	
	TPNStandardRegimenBean bean1 = (TPNStandardRegimenBean)getBeanObject(bean_id1,bean_name1,request);
	//ArrayList freqlist=bean1.getFrequencies();
	bean1.clear();	

	ArrayList MNEnergies = bean.getMNEnergies();
	
	ArrayList regmnDtls						    =   bean.getRegimenDetails();
	String regimen_code                         =   (String)regmnDtls.get(0);
	
	if(MNEnergies.size()>0){
		carbo_ener = (String)MNEnergies.get(1);
		lipid_ener = (String)MNEnergies.get(3);
		prot_ener  = (String)MNEnergies.get(5);
	}

	String bean_id2				= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name2			= "ePH.TPNRegimenBean";
	TPNRegimenBean bean2	= (TPNRegimenBean)getBeanObject(bean_id2,bean_name2,request);

	//String ph_bean_name		= "ePH.PrescriptionBean_1";
	//String ph_bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
	//PrescriptionBean_1 phbean = (PrescriptionBean_1)mh.getBeanObject(ph_bean_id, request, ph_bean_name);
	//bean.setPresRemarks(phbean.getPresRemarks());

	String cho						=bean2.getCabohydrateOrderQuantity();
	String protein					=bean2.getProteinOrderQuantity();
	String lipid					=bean2.getLipidOrderQuantity();
	String MNunit					=bean1.getUnit();
	String Stremgth_unit			=bean.getenergyunit();
	//out.println("===Stremgth_unit==="+Stremgth_unit+"===== MNunit===="+ MNunit);
	
	if	 (cho==null || (!regimen_code.equals("NON_STANDARD")))
	{
		//.out.println("entered");
		cho="";
	}
	if	 (protein==null || (!regimen_code.equals("NON_STANDARD")))
	{
		protein="";
	}
	if	 (lipid==null || (!regimen_code.equals("NON_STANDARD")))
	{
		lipid="";
	}
	if	 (MNunit==null || (!regimen_code.equals("NON_STANDARD")))
	{
		MNunit="";
	}


	//get values for all groups and populate
	ArrayList MNResults=bean.getTPNGenerics("MN",patient_id,regimen_code);
	ArrayList ELResults=bean.getTPNGenerics("EL",patient_id,regimen_code);
	ArrayList TRResults=bean.getTPNGenerics("TR",patient_id,regimen_code);
	ArrayList VTResults=bean.getTPNGenerics("VT",patient_id,regimen_code);
	ArrayList OTResults=bean.getTPNGenerics("OT",patient_id,regimen_code);
	String MNdesc=bean.getDesc("MN");
	String ELdesc=bean.getDesc("EL");
	String TRdesc=bean.getDesc("TR");
	String VTdesc=bean.getDesc("VT");
	String OTdesc=bean.getDesc("OT");
	//for preferred fluid/item header


    ArrayList tpnparam_vals =(ArrayList)bean.getTpnParams();
	String item_fluid_appl_yn=(String)tpnparam_vals.get(5);
	String header ="";
	String header2="";
	String header3="";
	String header4="";
	String disp_locn_code="";
	String disp_locn ="";
	if(item_fluid_appl_yn.equals("Y"))
	{
	header="<TH align='left' colspan=2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Preferred Fluid/Drug    </th>";
	header2="<TH align='center' colspan=2>Energy    </th>";
	header3="<TH align='center' colspan=2>Volume    </th>";
	}
	else
	{
	header2="<TH align='center' colspan=2>Energy    </th>";
    header4="<TH align='center' colspan=4></th>";
	header3="<TH align='center' colspan=4></th>";
	}

	 //disp_locn_code=CommonBean.checkForNull((String)bean.getDispLocn(location_type,location_code,patient_class,disch_medn_yn,priority));
	
	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocationForTPN(location_type,location_code,disch_medn_yn,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for  MMS-QH-CRF-0048 [IN:037704]
   	/*if(ord_disp_location != null & ord_disp_location.size()>0){ 
		disp_locn_code	= (String)ord_disp_location.get(0); 
		if(disp_locn_code == null) disp_locn_code ="";
	}*/
	  disp_locn_code	= (String)ord_disp_location.get(0);
	 /*if(!disp_locn_code.equals("")){
	 disp_locn = CommonBean.checkForNull(disp_locn_code.substring(0,disp_locn_code.indexOf("|")));
	 }*/
	
	int runningCounter=1;
	String code			="";
	String desc			="";
	String unit			="";
	String max			="";
	String min			="";
	String std			="";
	String dflt			="";
	String default_std	="";
	String def_relvalue ="";
	String AbOrWt		="";
	String cho_energy	="";
	String pro_energy	="";
	String li_energy	="";
	String tot_energy	="";
	String tot_chi_li	="";
	String NPC			="";
	String amend_color	="";

// added for usage_ind,remarks,ceil values

    String ceil         ="";
	String usage_ind    ="";
	String remarks      ="";
	String temponmouseover="";

	float wt=Float.parseFloat(weight);
	//int wt=Integer.parseInt(weight);

	float stdno		=1;
	float def_stdno =1;
	float calc		=0;
	int i			=0;
	
if (mode1.equals("")){
	//out.println("<script> alert('in this');</script>");
	order_id="X";
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( MNdesc));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(header2));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            out.print( String.valueOf(header4));
            _bw.write(_wl_block16Bytes, _wl_block16);

if(MNResults.size() != 0){
for ( i=0;i<MNResults.size();i+=11)
{
	code		=(String)MNResults.get(i);
	desc		=(String)MNResults.get(i+1);
	unit		=(String)MNResults.get(i+2);
	String tot_unit=unit;
	String unit1     ="";
	if(!unit.equals(""))
	{
		unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
		unit		= unit.substring(0,(unit.indexOf("!"))) ;
	}
	AbOrWt      =(String)MNResults.get(i+3); 
	max		    =(String)MNResults.get(i+4);
	min		    =(String)MNResults.get(i+5);
	std		    =(String)MNResults.get(i+6);
	dflt		=(String)MNResults.get(i+7);

	ceil	    =(String)MNResults.get(i+8);
	usage_ind   =(String)MNResults.get(i+9);
	remarks		=(String)MNResults.get(i+10);
	
	String ovrrde_reason      ="";

	// for preferred fluid/item listbox---line level
     
     HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	 String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
    
    ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
    
	String	relvalue="";
	String strength="";
	String N2="";
	

	if (code.equals("CHO"))	{
		//cho= "";
		// if assessment has been done, we display that value and the mn unit
		if (!cho.equals(""))
		{
			relvalue=cho;	
		}
		else //assessment has not been done and so we rever to the standard value and unit if the default is "Y" otherwise the value will be null
		{
			if (dflt.equals("Y"))
			{
				if(AbOrWt.equals("A"))
					relvalue=std;
				else
					relvalue=(Float.parseFloat(std) * wt) + "";
				MNunit=unit;
			}
			else
			{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		def_relvalue     =relvalue;
		cho_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(carbo_ener)+"";
		//tot_energy=tot_energy+cho_energy+"";
	}
	//Repeat the same logic as of above for protiens and lipids
	if (code.equals("PROTEIN"))
	{
		if (!protein.equals(""))
		{
			relvalue=protein;	
			
		}
		else
		{   
			if (dflt.equals("Y"))
			{
				if(AbOrWt.equals("A"))
					relvalue=std;
				else
					relvalue=(Float.parseFloat(std) * wt) + "";

				MNunit=unit;
			}
			else
			{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		def_relvalue     =relvalue;
		N2				 =Float.parseFloat(relvalue)*(16.0/100.0)+"";
		pro_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(prot_ener)+"";
		
	}
	if (code.equals("LIPID"))
	{ 
		if (!lipid.equals(""))
		{
			relvalue=lipid;	
		}
		else
		{
			if (dflt.equals("Y"))
			{   
				
				if(AbOrWt.equals("A"))
				{
					relvalue=std;
					
				}
				else
				{
					relvalue=(Float.parseFloat(std) * wt) + "";
					
				}

				MNunit=unit;
				
			}
			else
			{
				relvalue="";	
				MNunit=unit;
				
			}
			
		}
		def_relvalue =relvalue;
		
		li_energy	 =Float.parseFloat(relvalue)*Float.parseFloat(lipid_ener)+"";
		
	}
	if (!relvalue.equals("")){
		if(code.equals("CHO")){
			strength		 = cho_energy;
		}else if(code.equals("PROTEIN")){
			strength		 = pro_energy;
		}else if(code.equals("LIPID")){
			strength		 = li_energy;
		}
	}

	if( !li_energy.equals("") && !cho_energy.equals("")&& !pro_energy.equals(""))
	{
     tot_energy
	=((Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+(Float.parseFloat(pro_energy)))+"";

     tot_chi_li=(Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+"";
	 //stdno			 =Math.round(new Float(relvalue).floatValue());
	 if(!N2.equals(""))
	 NPC=(Math.round((Float.parseFloat(tot_chi_li))/(Float.parseFloat(N2))))+"";

	}
	
	
	if (!relvalue.equals(""))
	{
		stdno			 =Math.round(new Float(relvalue).floatValue());
		calc			 =(float)stdno/wt;
	}

	String MNdisabled="",MNwarning="",MNcolor="";
    
	//String overrid_ind="visibility:hidden";
		//"<label align='left'  style='cursor:pointer;color:blue' name='overrid'		id='remarks' onClick=''> &nbsp;Remarks</label>";


      String img_ret_mand = "";
	if(usage_ind.equals("") || usage_ind.equals("B") )
		 img_ret_mand = "visibility:hidden";
	else if(usage_ind.equals("O"))
	     img_ret_mand = "visibility:visible";

	String remarks_ind="";
	    if(remarks.equals(""))
	{
		 remarks_ind="";
	}
	else {  
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";
	}
    
	  
	if(!remarks.equals(""))
		{
			
			temponmouseover="onMouseOver='displayToolTip(\""+remarks+"\")' onMouseOut =hideToolTip()";
			// tempString = tempString + tempOnMouseOver;
		}
	  	
	 
	if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	{


            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(MNcolor));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(MNwarning));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ovrrde_reason));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(MNwarning));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(MNdisabled));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(roundTwoDigits(relvalue)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roundTwoDigits(def_relvalue)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block51Bytes, _wl_block51);

		/*if (!relvalue.equals(""))
		{
			out.println(roundTwoDigits(calc+""));
		}
		else
		{
			out.println("---");
		}*/
	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf("STRENGTH_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("STRENGTH_"+runningCounter));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(roundTwoDigits(strength)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Stremgth_unit));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block58Bytes, _wl_block58);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
 
						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}	
            _bw.write(_wl_block65Bytes, _wl_block65);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block68Bytes, _wl_block68);

		runningCounter++;	
	}
}
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(NPC));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf("TOT_STRENGTH_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("TOT_ENERGY_"+runningCounter));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(tot_energy));
            _bw.write(_wl_block74Bytes, _wl_block74);
 npc_n_val="NPC:N  Ratio "+NPC+" :1      Total Energy: "+tot_energy+" "+Stremgth_unit; 
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(Stremgth_unit));
            _bw.write(_wl_block76Bytes, _wl_block76);
}

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ELdesc));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

for ( i=0;i<ELResults.size();i+=11)
{
	
	code			=(String)ELResults.get(i);
	desc			=(String)ELResults.get(i+1);
	unit			=(String)ELResults.get(i+2);
	String tot_unit=unit;
	String unit1    ="";
	String Ab_wt_lit="";
	if(!unit.equals("")){
	unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
	unit		= unit.substring(0,(unit.indexOf("!"))) ;}
	
	AbOrWt			=(String)ELResults.get(i+3); 
	
	if(AbOrWt.equals("P"))
     Ab_wt_lit    ="/L";
	else
     Ab_wt_lit    ="/Kg";

	max				=(String)ELResults.get(i+4);
	min				=(String)ELResults.get(i+5);
	std				=(String)ELResults.get(i+6);
	dflt			=(String)ELResults.get(i+7);
	
	ceil	    =(String)ELResults.get(i+8);
	usage_ind   =(String)ELResults.get(i+9);
	remarks		=(String)ELResults.get(i+10);
    
	String ovrrde_reason      ="";

	 HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	 String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

	 item_fluid ="N" ;   // hardcoded irrespective of DB value to remove listbox(preferred/fluid drug) for                              electrolytes

	 ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
   
	if ( std != null && !std.equals("") )
	{
		if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
		else if(AbOrWt.equals("P"))
		{
			stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			std = stdno+"";
		}
		else{
					stdno=(Float.parseFloat(std) * wt);
					std = stdno+"";
		}

//		stdno		=Integer.parseInt(std);
	}
	default_std     =std;
	//calc			=(float)stdno/wt;
	if(AbOrWt.equals("P"))
		calc        = (((float)stdno*1000)/Float.parseFloat(volm));

	else
		calc        =  (float)stdno/wt;

	String ELdisabled="",ELwarning="",ELcolor="";

		if (unit==null || unit.equals("") )
		{
			ELdisabled	 =" readonly style='background-color:#E2E2E2' ";
			ELwarning		 ="Constituent Limits not present for  "+desc+" !!! ";
			ELcolor			 = "style=\"color:'red'\"";
		}

     String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {

	if (i%2==0)
	{
		
		//if its even we have to start a row
		out.println("<TR>");
		out.println("<Td  class='label' width='12%' title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap>"+desc);
	}
	else
	{
		out.println("<TR>");
	out.println("<Td  class='label' title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap>"+desc);
	}

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ovrrde_reason));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(ELdisabled));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(ELwarning));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?roundTwoDigits(std):""));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roundTwoDigits(default_std)));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);

			/*	if (!std.equals(""))
				out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		
            _bw.write(_wl_block97Bytes, _wl_block97);

		
/*			if ((i%2==0)&&(i+2==ELResults.size()-4))
			{
					out.println("	<Td  colspan=6  class=\"label\" align=\"right\">&nbsp;"+unit+"here</Td>");
			}
			else
			{*/

					out.println("	<Td  colspan=1  class=\"label\"  width=\"8%\" align=\"left\">&nbsp;&nbsp;"+unit1+Ab_wt_lit+remarks_ind+"</Td>");
                   
					if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}	
            _bw.write(_wl_block101Bytes, _wl_block101);
 }else {
            _bw.write(_wl_block102Bytes, _wl_block102);
 }
            _bw.write(_wl_block103Bytes, _wl_block103);
		if (i%2!=0)
			{
					//if its an odd number, we have to close the row
					out.println("</TR>");
			}

			runningCounter++;
	  }
	}

	
            _bw.write(_wl_block104Bytes, _wl_block104);

/*
if (5==5)
{
	return;
}*/

            _bw.write(_wl_block105Bytes, _wl_block105);
 
	if (TRResults.size() > 0 ){ 
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(TRdesc));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            _bw.write(_wl_block110Bytes, _wl_block110);

	}
for ( i=0;i<TRResults.size();i+=11)
{
		code			=(String)TRResults.get(i);
		desc			=(String)TRResults.get(i+1);
		unit			=(String)TRResults.get(i+2);
		String tot_unit=unit;
		String unit1    ="";
		String Ab_wt_lit="";
	if(!unit.equals("")){
	    unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
		unit		= unit.substring(0,(unit.indexOf("!"))) ;}
		AbOrWt		=(String)TRResults.get(i+3); 
		if(AbOrWt.equals("P"))
			Ab_wt_lit    ="/L";
		else
			Ab_wt_lit    ="/Kg";
		max			=(String)TRResults.get(i+4);
		min			=(String)TRResults.get(i+5);
		std			=(String)TRResults.get(i+6);
		dflt			=(String)TRResults.get(i+7);
		
		ceil	    =(String)TRResults.get(i+8);
	    usage_ind   =(String)TRResults.get(i+9);
	    remarks		=(String)TRResults.get(i+10);

		String ovrrde_reason      ="";

		HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	    String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

		ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
		

		if (!std.equals(""))
		{
			if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
			else if(AbOrWt.equals("P"))
		     {
			stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			std = stdno+"";
		     }
			else{
					stdno=(Float.parseFloat(std) * wt);
					std = stdno+"";
			}

        }
//			stdno	 =Integer.parseInt(std);
            default_std=std;
		
		String TRdisabled="";
		String TRwarning="";
		String TRcolor="";
		if (unit==null || unit.equals("") )
		{
			TRdisabled	 =" readonly style='background-color:#E2E2E2' '";
			TRwarning		 ="Constituent Limits not present for  "+desc+" !!!";
			TRcolor			 = "style=\"color:'red'\"";
		}
		if(AbOrWt.equals("P"))
		     calc        = (float)stdno*1000/Float.parseFloat(volm);
	    else
		     calc			=(float)stdno/wt;

		String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";
		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(TRcolor));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(TRwarning));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ovrrde_reason));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(TRwarning));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(TRdisabled));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?roundTwoDigits(std):""));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf("Default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Default_value_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(roundTwoDigits(default_std)));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf("Default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Default_unit_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block51Bytes, _wl_block51);

		/*	if (!std.equals(""))
					
					out.println(roundTwoDigits(calc+""));
			else
					out.println("---");
		*/
	
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Ab_wt_lit));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block125Bytes, _wl_block125);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}	
            _bw.write(_wl_block129Bytes, _wl_block129);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block131Bytes, _wl_block131);

			runningCounter++;	
	   }
	}

	
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(VTdesc));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            _bw.write(_wl_block110Bytes, _wl_block110);

		for ( i=0;i<VTResults.size();i+=11)
		{
			code			=(String)VTResults.get(i);
			desc			=(String)VTResults.get(i+1);
			unit			=(String)VTResults.get(i+2);
			String tot_unit=unit;
			String unit1    ="";
			String Ab_wt_lit ="";
	     if(!unit.equals("")){
	         unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
			unit		= unit.substring(0,(unit.indexOf("!"))) ;}
			AbOrWt			=(String)VTResults.get(i+3);
            if(AbOrWt.equals("P"))
			  Ab_wt_lit    ="/L";
		    else
			  Ab_wt_lit    ="/Kg";
			max				=(String)VTResults.get(i+4);
			min				=(String)VTResults.get(i+5);
			std				=(String)VTResults.get(i+6);
			dflt			=(String)VTResults.get(i+7);
			
		   ceil	    =(String)VTResults.get(i+8);
	       usage_ind   =(String)VTResults.get(i+9);
	       remarks		=(String)VTResults.get(i+10);

		   String ovrrde_reason      ="";

		   HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	       String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

		   ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
		   

			if (!std.equals(""))
			{
				if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
				else if(AbOrWt.equals("P"))
		          {
			       // stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
					stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			        std = stdno+"";
		           }
				else{
					stdno=(Float.parseFloat(std) * wt);
					std = stdno+"";
				}
                
	//			stdno		=Integer.parseInt(std);
			}
			default_std       =std;
			String VTdisabled ="";
			String VTwarning  ="";
			String VTcolor    ="";
			if (unit==null || unit.equals("") )
			{
				VTdisabled	 =" readonly style='background-color:#E2E2E2' '";
				VTwarning		 ="Constituent Limits not present for  "+desc+" !!!";
				VTcolor			 = "style=\"color:'red'\"";
			}
			if(AbOrWt.equals("P"))
		        //calc        = (float)stdno/1000;
			    calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	        else
			    calc	=(float)stdno/wt;
            
		String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {
		
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(VTcolor));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(VTwarning));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ovrrde_reason));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(VTdisabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(VTwarning));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?roundTwoDigits(std):""));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf("Default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Default_value_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roundTwoDigits(default_std)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf("Default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Default_unit_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);

			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Ab_wt_lit));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block148Bytes, _wl_block148);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}	
            _bw.write(_wl_block150Bytes, _wl_block150);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block151Bytes, _wl_block151);

			runningCounter++;	
	   }
	}
	
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(OTdesc));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            _bw.write(_wl_block154Bytes, _wl_block154);
 
		for ( i=0;i<OTResults.size();i+=11)
		{
				code		=(String)OTResults.get(i);
				desc		=(String)OTResults.get(i+1);
				unit		=(String)OTResults.get(i+2);
				String tot_unit=unit;
				String unit1    ="";
				String Ab_wt_lit="";
	           if(!unit.equals("")){
	            unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
				unit		= unit.substring(0,(unit.indexOf("!"))) ;}
				AbOrWt		=(String)OTResults.get(i+3);

				if(AbOrWt.equals("P"))
			       Ab_wt_lit    ="/L";
		        else
			       Ab_wt_lit    ="/Kg";

				max			=(String)OTResults.get(i+4);
				min			=(String)OTResults.get(i+5);
				std			=(String)OTResults.get(i+6);
				dflt		=(String)OTResults.get(i+7);
				
				ceil	    =(String)OTResults.get(i+8);
	            usage_ind   =(String)OTResults.get(i+9);
	            remarks		=(String)OTResults.get(i+10);

				String ovrrde_reason      ="";

				HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	            String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");

				ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
				

				if (!std.equals(""))
				{
					if(AbOrWt.equals("A"))
						stdno=Float.parseFloat(std);
					else if(AbOrWt.equals("P"))
		           {
			          //stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
					  stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			          std = stdno+"";
		           }
					else
					{
						stdno=(Float.parseFloat(std) * wt);
						std = stdno+"";	
					}
			//		stdno=Integer.parseInt(std);
				}
				default_std=std;

				if(AbOrWt.equals("P"))
		           //calc        = (float)stdno/1000;
				   calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	            else
				   calc		=(float)stdno/wt;

				String OTdisabled="";
				String warning="";
				String color="";
				if (unit==null || unit.equals("") )
				{
					OTdisabled	 =" readonly style='background-color:#E2E2E2' '";
					warning		 ="Constituent Limits not present for  "+desc+" !!!";
					color			 = "red";
				}
		String img_ret_mand = "";
	      if(usage_ind.equals("") || usage_ind.equals("B") )
		     img_ret_mand = "visibility:hidden";
	     else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

		 String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		  if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	       {
          	
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(color));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(warning));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ovrrde_reason));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(warning));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(OTdisabled));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?roundTwoDigits(std):""));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf("Default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Default_value_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(roundTwoDigits(default_std)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf("Default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("Default_unit_"+runningCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);

			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(NPC));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Ab_wt_lit));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block166Bytes, _wl_block166);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

						for (int k=0;k<fluidvalues.size();k=k+2){
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
						
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}	
            _bw.write(_wl_block168Bytes, _wl_block168);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block151Bytes, _wl_block151);

			runningCounter++;	
		   }
	}
	
            _bw.write(_wl_block169Bytes, _wl_block169);
} else if(mode1.equals("amend")){ 
	
		HashMap OrderDetails=new HashMap();
		OrderDetails=bean.getOrderDetails2(order_id); 
		//ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("ORREASON_FLUID");
		//String ovrrde_reason="";
		
		
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(mode1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( MNdesc));
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(header2));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            out.print( String.valueOf(header4));
            _bw.write(_wl_block175Bytes, _wl_block175);

if(MNResults.size() != 0){
for ( i=0;i<MNResults.size();i+=11)
{
	code		=(String)MNResults.get(i);
	desc		=(String)MNResults.get(i+1);
	unit		=(String)MNResults.get(i+2);
	String tot_unit=unit;
	String unit1     ="";
	if(!unit.equals("")){
	unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
	unit		= unit.substring(0,(unit.indexOf("!"))) ;}
	AbOrWt      =(String)MNResults.get(i+3); 
	max		    =(String)MNResults.get(i+4);
	min		    =(String)MNResults.get(i+5);
	std		    =(String)MNResults.get(i+6);
	dflt		=(String)MNResults.get(i+7);

	ceil	    =(String)MNResults.get(i+8);
	usage_ind   =(String)MNResults.get(i+9);
	remarks		=(String)MNResults.get(i+10);
	
	//String ovrrde_reason      ="";

	 HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	 String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
      ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
	  
  	default_std =std;
	if(OrderDetails.containsKey(code))
	{
		
	  //String def_std=((Float.parseFloat((String)OrderDetails.get(code)))/ wt) + "";
	 String def_std=((Float.parseFloat((String)OrderDetails.get(code)))) + "";
	  std=def_std;	
	  
	  amend_color="red";
		  
	}else{       
	   amend_color="black";       
	   std="0";
	   	
	}
	ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
	
	int index=fld_ovrrd_values.indexOf(code);
	String amend_remarks="";
      if(index!= -1)
	    amend_remarks=(String)fld_ovrrd_values.get(index+2);
	String amend_remarks_visible="";
	if(amend_remarks==null)
		amend_remarks="";

	if(amend_remarks.equals(""))
		amend_remarks_visible="visibility:hidden";
	else
		amend_remarks_visible="visibility:visible";
	

	String	relvalue="";
	String strength="";
	String N2="";
	
	if (code.equals("CHO")){
		// if assessment has been done, we display that value and the mn unit
		if (!cho.equals("")){
			relvalue=(String)OrderDetails.get(code);
			def_relvalue=(String)OrderDetails.get(code);
		}
		else{ //assessment has not been done and so we rever to the standard value and unit if the default is "Y" otherwise the value will be null
			if (dflt.equals("Y")){
				if(AbOrWt.equals("A")){
					relvalue=std;
				    def_relvalue=std;
				}
				else{
//					relvalue		=Math.round((Float.parseFloat(std) * wt)) + "";
//					relvalue		=Math.round((Float.parseFloat(std) / wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(default_std) * wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(std) / wt)) + "";
					relvalue=std;
				    def_relvalue=std;
				}
				MNunit			=unit;
			}
			else{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		cho_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(carbo_ener)+"";
		//tot_energy=tot_energy+cho_energy+"";

	}
	//Repeat the same logic as of above for protiens and lipids

	if (code.equals("PROTEIN")){
		if (!protein.equals("")){
			relvalue=(String)OrderDetails.get(code);
			def_relvalue=(String)OrderDetails.get(code); 
		}
		else{
			if (dflt.equals("Y")){
				if(AbOrWt.equals("A")){
					relvalue=std;
				    def_relvalue=std;  
				}
				else{
//					relvalue		=Math.round((Float.parseFloat(std) * wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(default_std) * wt)) + "";
//					relvalue		=Math.round((Float.parseFloat(std) / wt)) + "";
//				    def_relvalue	= Math.round((Float.parseFloat(std) / wt)) + "";

					relvalue=std;
				    def_relvalue=std;
				}

				MNunit=unit;
			}
			else
			{
				relvalue="";	
				MNunit=unit;
			}
			
		}
		N2=Float.parseFloat(relvalue)*(16.0/100.0)+"";
		//out.println("N2"+N2);
        pro_energy		 =Float.parseFloat(relvalue)*Float.parseFloat(prot_ener)+"";
	
	}
	if (code.equals("LIPID")){		
		if (!lipid.equals("")){			
			relvalue=(String)OrderDetails.get(code);	
			def_relvalue=(String)OrderDetails.get(code);
		}
		else{
			if (dflt.equals("Y")){  
				if(AbOrWt.equals("A")){
					relvalue=std;
				    def_relvalue=std;  
					
                }
				else{
//					relvalue	=Math.round((Float.parseFloat(std) * wt)) + "";
//				    def_relvalue= Math.round((Float.parseFloat(default_std) * wt)) + "";
//					relvalue	=Math.round((Float.parseFloat(std) / wt)) + "";
//				    def_relvalue= Math.round((Float.parseFloat(std) / wt)) + "";

					relvalue=std;
				    def_relvalue=std;
				}
				MNunit=unit;
			}
			else{
				relvalue="";	
				MNunit=unit;
			}
		}

		li_energy	 =Float.parseFloat(relvalue)*Float.parseFloat(lipid_ener)+"";
	}
	if (!relvalue.equals("")){
		if(code.equals("CHO")){
			strength		 = cho_energy;
		}
		else if(code.equals("PROTEIN")){
			strength		 = pro_energy;
		}
		else if(code.equals("LIPID")){
			strength		 = li_energy;
		}
	}

/*	if (!relvalue.equals("") && code.equals("LIPID"))
	{
		strength		 =Float.parseFloat(relvalue)*9.0+"";
		
	}
	else{
		strength		 =Float.parseFloat(relvalue)*4.0+"";
		}*/
	if( !li_energy.equals("") && !cho_energy.equals("")&& !pro_energy.equals(""))
	{
     tot_energy
	=((Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+(Float.parseFloat(pro_energy)))+"";

     tot_chi_li=(Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+"";
	 //stdno			 =Math.round(new Float(relvalue).floatValue());
	 if(!N2.equals(""))
	 NPC=(Math.round((Float.parseFloat(tot_chi_li))/(Float.parseFloat(N2))))+"";

	}
	if (!relvalue.equals("")){
		stdno			 =Math.round(new Float(relvalue).floatValue());
		calc			 =(float)stdno/wt;
	}

	String MNdisabled="",MNwarning="",MNcolor="";
	npc_n_val="NPC:N  Ratio "+NPC+" :1     Total Energy: "+tot_energy+" "+Stremgth_unit; 
    
	String img_ret_mand = "";
	if(usage_ind.equals("") || usage_ind.equals("B") )
		img_ret_mand = "visibility:hidden";
	else if(usage_ind.equals("O"))
	     img_ret_mand = "visibility:visible";
	  
    String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";		

	if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	{


            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(MNcolor));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(MNwarning));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(amend_color));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_remarks));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block180Bytes, _wl_block180);

		//out.println("desc- 1547--->" +desc);
		//out.println("runningCounter- 1548--->" +runningCounter);
		
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(MNwarning));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(MNdisabled));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(relvalue));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(amend_remarks_visible));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf("default_strength_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_strength_"+runningCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(def_relvalue));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block51Bytes, _wl_block51);

	/*	if (!relvalue.equals(""))
		{
			out.println(roundTwoDigits(calc+""));
		}
		else
		{
			out.println("---");
		}*/
	
            _bw.write(_wl_block189Bytes, _wl_block189);
//out.println("strength-----1565---->" +strength);
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf("STRENGTH_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("STRENGTH_"+runningCounter));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(roundTwoDigits(strength)));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(Stremgth_unit));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block58Bytes, _wl_block58);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
		
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

						for (int k=0;k<fluidvalues.size();k=k+2){
							
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1)==null?"":(String)fld_ovrrd_values.get(index+1);

							   if(default_fluid.equals(fluid_code)){

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block199Bytes, _wl_block199);
 
                                	}else{

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block201Bytes, _wl_block201);
                                  } 
								 }

            _bw.write(_wl_block168Bytes, _wl_block168);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block203Bytes, _wl_block203);

		runningCounter++;
	}
	
}
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(NPC));
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf("TOT_STRENGTH_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("TOT_ENERGY_"+runningCounter));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(tot_energy));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(Stremgth_unit));
            _bw.write(_wl_block76Bytes, _wl_block76);
}

            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ELdesc));
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ELdesc));
            _bw.write(_wl_block212Bytes, _wl_block212);

for ( i=0;i<ELResults.size();i+=11)
{
	code			=(String)ELResults.get(i);
	desc			=(String)ELResults.get(i+1);
	unit			=(String)ELResults.get(i+2);
	String tot_unit=unit;
	String unit1    ="";
	String Ab_wt_lit="";
	if(!unit.equals("")){
	unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
	unit		= unit.substring(0,(unit.indexOf("!"))) ;}
	AbOrWt			=(String)ELResults.get(i+3); 
	if(AbOrWt.equals("P"))
     Ab_wt_lit    ="/L";
	else
     Ab_wt_lit    ="/Kg";
	max				=(String)ELResults.get(i+4);
	min				=(String)ELResults.get(i+5);
	std				=(String)ELResults.get(i+6);
	dflt			=(String)ELResults.get(i+7);

	ceil	    =(String)ELResults.get(i+8);
	usage_ind   =(String)ELResults.get(i+9);
	remarks		=(String)ELResults.get(i+10);
	

    //String ovrrde_reason      ="";
	
	if (!std.equals("") && std != null)
	{

		if(AbOrWt.equals("A"))
			stdno=Float.parseFloat(std);
		else if(AbOrWt.equals("P"))
		{
			
			//stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
			stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			std = stdno+"";
		}
		else{
				stdno=(Float.parseFloat(std) * wt);
				std = stdno+"";
		   }

//		stdno		=Integer.parseInt(std);
	}
    default_std=std;
	if(OrderDetails.containsKey(code)){
		//std=(String)OrderDetails.get(code);
		//stdno=(Float.parseFloat(std));
	    amend_color="red";
		  
	}else{       
	   amend_color="black";
	   stdno=0;
	   std="0";	   	
	}
        
      ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
		
	  int index=fld_ovrrd_values.indexOf(code);
	  String amend_remarks="";
      if(index!= -1)
	  amend_remarks=(String)fld_ovrrd_values.get(index+2);
	  String amend_remarks_visible="";
	if(amend_remarks==null)
		amend_remarks="";

	if(amend_remarks.equals(""))
		amend_remarks_visible="visibility:hidden";
	else
		amend_remarks_visible="visibility:visible";


	//calc			=(float)stdno/wt;
	if(AbOrWt.equals("P"))
		//calc        = (float)stdno/1000;
	    calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	else
		calc        =  (float)stdno/wt;

	String ELdisabled="",ELwarning="",ELcolor="";

		if (unit==null || unit.equals("") )
		{
			ELdisabled	 =" readonly style='background-color:#E2E2E2' ";
			ELwarning		 ="Constituent Limits not present for  "+desc+" !!! ";
			ELcolor			 = "style=\"color:'red'\"";
		}
       
	   String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {
	if (i%2==0)
	{
		//if its even we have to start a row
		out.println("<TR>");
		out.println("<Td  class='label' width='12%'  title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap> <font color='"+amend_color+"'>"+desc);
	}
	else
	{
		out.println("<TR>");
	out.println("<Td  class='label' title='"+ELwarning+"'"+ ELcolor+"   align=\"right\" nowrap><font color='"+amend_color+"'>"+desc);
	}


            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_remarks));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(ELdisabled));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(ELwarning));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?roundTwoDigits(std):""));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(amend_remarks_visible));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf("default_sterngth_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_sterngth_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(roundTwoDigits(default_std)));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);

			/*	if (!std.equals(""))
				out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		
            _bw.write(_wl_block219Bytes, _wl_block219);

		
/*			if ((i%2==0)&&(i+2==ELResults.size()-4))
			{
					out.println("	<Td  colspan=6  class=\"label\" align=\"right\">&nbsp;"+unit+"here</Td>");
			}
			else
			{*/

					out.println("	<Td  colspan=1  class=\"label\" align=\"left\">&nbsp;"+unit1+Ab_wt_lit+remarks_ind+"</Td>");
			//}

			if (i%2!=0)
			{
					//if its an odd number, we have to close the row
					out.println("</TR>");
			}
			runningCounter++;
	   }
	}

	
            _bw.write(_wl_block104Bytes, _wl_block104);

/*
if (5==5)
{
	return;
}*/

            _bw.write(_wl_block220Bytes, _wl_block220);
 
	if (TRResults.size() > 0 ){ 
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(TRdesc));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            _bw.write(_wl_block110Bytes, _wl_block110);

	}
for ( i=0;i<TRResults.size();i+=11)
{
		code			=(String)TRResults.get(i);
		desc			=(String)TRResults.get(i+1);
		unit			=(String)TRResults.get(i+2);
		String tot_unit=unit;
	    String unit1    ="";
	    String Ab_wt_lit="";
		if(!unit.equals("")){
		unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
		unit		= unit.substring(0,(unit.indexOf("!"))) ;}
		AbOrWt			=(String)TRResults.get(i+3); 
		if(AbOrWt.equals("P"))
		 Ab_wt_lit    ="/L";
		else
		 Ab_wt_lit    ="/Kg";
		max				=(String)TRResults.get(i+4);
		min				=(String)TRResults.get(i+5);
		std				=(String)TRResults.get(i+6);
		dflt			=(String)TRResults.get(i+7);
   
		ceil	    =(String)TRResults.get(i+8);
	    usage_ind   =(String)TRResults.get(i+9);
	    remarks		=(String)TRResults.get(i+10);
		
		HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	    String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
        ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
		 

		//String ovrrde_reason      ="";
		
	   default_std=std;
		if(OrderDetails.containsKey(code)){
			std=(String)OrderDetails.get(code);
		   amend_color="red";	
		  
	    }else{       
	      amend_color="black";	      
	      std="";	   	
	   }
	   ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
	   int index=fld_ovrrd_values.indexOf(code);
	   String amend_remarks="";
        if(index!= -1)
	        amend_remarks=(String)fld_ovrrd_values.get(index+2);
	   String amend_remarks_visible="";
		if(amend_remarks==null)
			amend_remarks="";

		if(amend_remarks.equals(""))
			amend_remarks_visible="visibility:hidden";
		else
			amend_remarks_visible="visibility:visible";

		if (!std.equals(""))
		{
			if(AbOrWt.equals("A"))
					stdno=Float.parseFloat(std);
		   else if(AbOrWt.equals("P"))
		       {
			       //stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
				   stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			       std = stdno+"";
		       }
			else{
//					stdno       =(Float.parseFloat(std) * wt);
//					def_stdno   =(Float.parseFloat(default_std) * wt);

					stdno		=  Math.round((Float.parseFloat(std) / wt));
				    def_stdno	=  Math.round((Float.parseFloat(default_std) / wt));

					std         = stdno+"";
					

			}
             default_std = def_stdno+""; 
//			stdno	 =Integer.parseInt(std);
		}
		String TRdisabled="";
		String TRwarning="";
		String TRcolor="";
		if (unit==null || unit.equals("") )
		{
			TRdisabled	 =" readonly style='background-color:#E2E2E2' '";
			TRwarning		 ="Constituent Limits not present for  "+desc+" !!!";
			TRcolor			 = "style=\"color:'red'\"";
		}
		
		//calc			=(float)stdno/wt;

		if(AbOrWt.equals("P"))
		   //calc        = (float)stdno/1000;
		   calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	    else
		   calc        =  (float)stdno/wt;

		String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	   {

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(TRcolor));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(TRwarning));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(amend_color));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_remarks));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(TRwarning));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(TRdisabled));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?std:""));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(amend_remarks_visible));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(default_std));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block51Bytes, _wl_block51);

/*			if (!std.equals(""))
					
					out.println(roundTwoDigits(calc+""));
			else
					out.println("---");
*/
	
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Ab_wt_lit));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block125Bytes, _wl_block125);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

						for (int k=0;k<fluidvalues.size();k=k+2){
		                    
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1);
							   if(default_fluid.equals(fluid_code)){

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block231Bytes, _wl_block231);
 
                                	}else{

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block201Bytes, _wl_block201);
                                  } 
								 }

            _bw.write(_wl_block168Bytes, _wl_block168);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block233Bytes, _wl_block233);

			runningCounter++;
	   }
	}

	
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(VTdesc));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            _bw.write(_wl_block110Bytes, _wl_block110);

		for ( i=0;i<VTResults.size();i+=11)
		{
			code			=(String)VTResults.get(i);
			desc			=(String)VTResults.get(i+1);
			unit			=(String)VTResults.get(i+2);
			String tot_unit=unit;
			String unit1    ="";
			String Ab_wt_lit="";
			if(!unit.equals("")){
			unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
			unit		= unit.substring(0,(unit.indexOf("!"))) ;}
			AbOrWt			=(String)VTResults.get(i+3);
			if(AbOrWt.equals("P"))
			 Ab_wt_lit    ="/L";
			else
			 Ab_wt_lit    ="/Kg";
			max				=(String)VTResults.get(i+4);
			min				=(String)VTResults.get(i+5);
			std				=(String)VTResults.get(i+6);
			dflt			=(String)VTResults.get(i+7);
			ceil	    =(String)VTResults.get(i+8);
	        usage_ind   =(String)VTResults.get(i+9);
	        remarks		=(String)VTResults.get(i+10);
			
			HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	        String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
            ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);

			//String ovrrde_reason      ="";

			default_std     =std;
			if(OrderDetails.containsKey(code)){
				std=(String)OrderDetails.get(code);
			    amend_color="red";		  
	       }else{       
	           amend_color="black";	      
	           std="";	   	
	         }

			ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
			int index=fld_ovrrd_values.indexOf(code);
			  String amend_remarks="";
               if(index!= -1)
        		  amend_remarks=(String)fld_ovrrd_values.get(index+2);
			String amend_remarks_visible="";
				if(amend_remarks==null)
					amend_remarks="";

				if(amend_remarks.equals(""))
					amend_remarks_visible="visibility:hidden";
				else
					amend_remarks_visible="visibility:visible";

			if (!std.equals(""))
			{
				if(AbOrWt.equals("A"))
					stdno		=Float.parseFloat(std);
				else if(AbOrWt.equals("P"))
		          {
			        //  stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
					stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			          std = stdno+"";
		          }
				else{
					//stdno		=(Float.parseFloat(std) * wt);
					stdno		=(Float.parseFloat(std));
					def_stdno   =(Float.parseFloat(default_std) * wt);
					std			= stdno+"";
					default_std = def_stdno+"";
					 
				}

	//			stdno		=Integer.parseInt(std);
			}
			String VTdisabled="";
			String VTwarning="";
			String VTcolor="";
			if (unit==null || unit.equals("") )
			{
				VTdisabled	 =" readonly style='background-color:#E2E2E2' '";
				VTwarning		 ="Constituent Limits not present for  "+desc+" !!!";
				VTcolor			 = "style=\"color:'red'\"";
			}
			
			//calc	=(float)stdno/wt;
            
			if(AbOrWt.equals("P"))
		       //calc        = (float)stdno/1000;
			   calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	        else
		       calc        =  (float)stdno/wt;

			String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	   else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	    {
		
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(VTcolor));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(VTwarning));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(amend_color));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_remarks));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(VTdisabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(VTwarning));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?std:""));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(amend_remarks_visible));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(default_std));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);

			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Ab_wt_lit));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block246Bytes, _wl_block246);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

						for (int k=0;k<fluidvalues.size();k=k+2){
		                    
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1);
							   if(default_fluid.equals(fluid_code)){

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block231Bytes, _wl_block231);
 
                                	}else{

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block201Bytes, _wl_block201);
                                  } 
								 }
	
            _bw.write(_wl_block168Bytes, _wl_block168);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block233Bytes, _wl_block233);

			runningCounter++;
		}
	}
	
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(OTdesc));
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(header));
            out.print( String.valueOf(header3));
            _bw.write(_wl_block154Bytes, _wl_block154);
 	
		for ( i=0;i<OTResults.size();i+=11)
		{
				code		=(String)OTResults.get(i);
				desc		=(String)OTResults.get(i+1);
				unit		=(String)OTResults.get(i+2);
				String tot_unit=unit;
				String unit1    ="";
				String Ab_wt_lit="";
				if(!unit.equals("")){
				unit1		= unit.substring((unit.indexOf("!"))+1,unit.length()) ;
				unit		= unit.substring(0,(unit.indexOf("!"))) ;}
				AbOrWt		=(String)OTResults.get(i+3);
				if(AbOrWt.equals("P"))
				 Ab_wt_lit    ="/L";
				else
				 Ab_wt_lit    ="/Kg";
				max			=(String)OTResults.get(i+4);
				min			=(String)OTResults.get(i+5);
				std			=(String)OTResults.get(i+6);
				dflt		=(String)OTResults.get(i+7);
                
				ceil	    =(String)OTResults.get(i+8);
	            usage_ind   =(String)OTResults.get(i+9);
	            remarks		=(String)OTResults.get(i+10);
				                
				HashMap Genr_details=(HashMap)bean.getConsGenericDetails(code);
	            String item_fluid=(String)Genr_details.get("ITEM_FLUID_REQ_YN");
                ArrayList fluidvalues=(ArrayList)bean.getFluidValues(order_id,disp_locn_code,code);
				

				//String ovrrde_reason      ="";
				
				default_std =std;
				if(OrderDetails.containsKey(code)){
					std=(String)OrderDetails.get(code);
				    amend_color="red";		  
	           }else{       
	                amend_color="black";	      
	                std="";	   	
	           }

			  ArrayList fld_ovrrd_values=(ArrayList)OrderDetails.get("OVRREASON_FLUID");
			  int index=fld_ovrrd_values.indexOf(code);
			  String amend_remarks="";
                if(index!= -1)
			      amend_remarks=(String)fld_ovrrd_values.get(index+2);
			  String amend_remarks_visible="";
					if(amend_remarks==null)
						amend_remarks="";

					if(amend_remarks.equals(""))
						amend_remarks_visible="visibility:hidden";
					else
						amend_remarks_visible="visibility:visible";

				if (!std.equals(""))
				{
					if(AbOrWt.equals("A")){
						stdno		=Float.parseFloat(std);
						def_stdno   =Float.parseFloat(default_std);

					}
					else if(AbOrWt.equals("P"))
		             {
			              // stdno=((Float.parseFloat(std) * 1000)/Float.parseFloat(volm));
						  stdno=((Float.parseFloat(std) * Float.parseFloat(volm))/1000);
			               std = stdno+"";
		              }
			   else{
						//stdno		=(Float.parseFloat(std) * wt);
						stdno		=(Float.parseFloat(std));
						def_stdno	=(Float.parseFloat(default_std) * wt);

					}
					std			= stdno+"";
					default_std = default_std+"";

			//		stdno=Integer.parseInt(std);
				}
				
				//calc		=(float)stdno/wt;

				if(AbOrWt.equals("P"))
		              // calc        = (float)stdno/1000;
				       calc        = (((float)stdno*1000)/Float.parseFloat(volm));
	            else
		               calc        =  (float)stdno/wt;

				String OTdisabled="";
				String warning="";
				String color="";
				if (unit==null || unit.equals("") )
				{
					OTdisabled	 =" readonly style='background-color:#E2E2E2' '";
					warning		 ="Constituent Limits not present for  "+desc+" !!!";
					color			 = "red";
				}
				String img_ret_mand = "";
	    if(usage_ind.equals("") || usage_ind.equals("B") )
		   img_ret_mand = "visibility:hidden";
	   else if(usage_ind.equals("O"))
	       img_ret_mand = "visibility:visible";

	   String remarks_ind="";
	    if(remarks.equals(""))
		 remarks_ind="";
	    else 
	     remarks_ind="<img src=../../ePH/images/Remarks.gif onclick='showRemarks(\""+remarks+"\")'>";

		if(usage_ind.equals("O") || usage_ind.equals("") || usage_ind.equals("B") )
	    {

			
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(color));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(warning));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(amend_color));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("GROUPCODE_"+runningCounter));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CODE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMIN_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QMAX_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("DESC_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("CEIL_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ceil));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("OVERRIDE_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_remarks));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QUNIT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tot_unit));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ABORWT_"+runningCounter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(warning));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(OTdisabled));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AbOrWt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("QVALUE_"+runningCounter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt.equals("Y")?std:""));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("UNIT_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf( img_ret_mand ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(amend_remarks_visible));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_value_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(default_std));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("default_unit_"+runningCounter));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("QCALC_"+runningCounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(roundTwoDigits(calc+"")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block96Bytes, _wl_block96);

			/*	if (!std.equals(""))
					out.println(roundTwoDigits(calc+""));
				else
					out.println("---");
			*/
		
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(NPC));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(unit1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Ab_wt_lit));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(remarks_ind));
            _bw.write(_wl_block257Bytes, _wl_block257);
 if(item_fluid_appl_yn.equals("Y") && item_fluid.equals("Y")){
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
for (int k=0;k<fluidvalues.size();k=k+2){
		                   
							String fluid_code		=(String)fluidvalues.get(k);
							String fluid_desc		=(String)fluidvalues.get(k+1);
                            String default_fluid    =(String)fld_ovrrd_values.get(index+1);
							   if(default_fluid.equals(fluid_code)){

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block231Bytes, _wl_block231);
 
                                	}else{

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fluid_desc));
            _bw.write(_wl_block201Bytes, _wl_block201);
                                  }
								 }

            _bw.write(_wl_block168Bytes, _wl_block168);
 }else {
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf("VOLUME_"+runningCounter));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf("ITEMFLUID_"+runningCounter));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(runningCounter));
            _bw.write(_wl_block233Bytes, _wl_block233);

			runningCounter++;
		}
	}
	
            _bw.write(_wl_block258Bytes, _wl_block258);
}
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(runningCounter-1));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(act_patient_class.trim()));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(height));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(npc_n_val));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(carbo_ener));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(lipid_ener));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(prot_ener));
            _bw.write(_wl_block274Bytes, _wl_block274);
 
	putObjectInBean(bean_id,bean,request); 
	putObjectInBean(bean_id1,bean1,request); 
	putObjectInBean(bean_id2,bean2,request); 
	

            _bw.write(_wl_block275Bytes, _wl_block275);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Strength/kg.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NPCNRatio.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalEnergy.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Strength/kg.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NPCNRatio.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalEnergy.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
