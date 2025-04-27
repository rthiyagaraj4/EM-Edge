package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotessection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesSection.jsp", 1737343292999L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>RecClinicalNotesSection</title>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\n \t<style type=\'text/css\'>\n\t\n</style> \n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart4.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/prototype.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\n\tfunction makeActive(operationMode)\n\t{\n\t\t//IN058147 Start\n\t\t/*\n\t\tif(operationMode==\"ModifyAddendum\")\n\t\t\tdocument.getElementById(\"notes_view\").style.color = \'BLUE\';\t\t\t\t\n\t\telse\n\t\t*/\n\t\t//IN058147 End\n\t\t\tdocument.getElementById(\"notes_view\").style.color = \'WHITE\';\t\t\t\t\n\t}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body onLoad=\'makeActive(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onmousemove = \"\" onmouseout= \"\" class=\'CONTENT\'>\n\t<form name=\'RecClinicalNotesSectionForm\' id=\'RecClinicalNotesSectionForm\'>\n\t<table border=\'0\' cellpadding = \'3\' cellspacing = \'0\' width=\'100%\' id=\'tb1\' style=\"display:\" align=\'center\' >\n\t<tr id=\'tblrow_id0\' >\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t<td class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' colspan = \'3\'>\n\t\t<table cellpadding = \'0\' cellspacing = \'0\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' width=\"80%\">\n\t\t\t\t<a href=\"javascript:showNotes(tblrow_id0,\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'\')\" id=\'notes_view\' class=\'ACTIVE\'><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></a>\n\t\t\t\t</td>\n\t\t\t\t<!-- IN058147 Start. -->\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\"20%\" align=\"right\"> \n\t\t\t\t\t<img  class=\"imageClass1\" onclick=\"compressSectionFrames()\"  title=\'Minimize Section Pane\' src=\'../../eCA/images/Pin_Icon.png\' alt=\"Minimize Section Pane\" style=\"cursor:pointer\" />\n\t\t\t\t</td>\n\t\t\t\t<!-- IN058147 End. -->\n\t\t\t</tr>\n\t\t</table>\t\n\t</td>\n\t</tr>\n\t</table>\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<input type=\"hidden\" name=\"previousNote_accession_num\" id=\"previousNote_accession_num\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t\t<input type=\"hidden\" name=\"call_for_copy_previous_sec\" id=\"call_for_copy_previous_sec\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/><!--IN063931-->\n\t\t<input type=\"hidden\" name=\"call_for_copy_previous_note\" id=\"call_for_copy_previous_note\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/><!--IN063931-->\n\t\t<input type=\"hidden\" name=\"tempcurr_sec_hdg_code\" id=\"tempcurr_sec_hdg_code\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/><!--IN063931-->\n\t\t<input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'><!--IN072879-->\t\n\t\t<input type=\'hidden\' name=\'speciality_name\' id=\'speciality_name\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'><!--IN072879-->\n\t\t<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><!--IN072879-->\n\t\t\n\t\t<input type=\"hidden\" name=\"accession_num_auto\" id=\"accession_num_auto\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/><!--IN071264 Starts-->\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  width=\"1%\">\n\t\t\t\t\t\t\t<b class=\'gridLink\' onclick = \"javascript:expandCollapse(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" name = \"no_of_sub_sections_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_anchor\" id = \"no_of_sub_sections_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="_anchor\" style=\"visibility:hidden;cursor:pointer;color:blue\" >-</b>\n\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' colspan=\'2\'  >\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;\n\t\t\t\t\t\t\t\t<a class=\'gridLink\' id=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="_anchor\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="  href=\'javascript:showSectionDetails(";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\",\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",\"\",\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\");\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<!-- Added for IN071264 -->\n\t\t\t\t\t\t\t\t</a >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"no_of_sub_sections_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"no_of_sub_sections_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" value=\"\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'img_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'img_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\t\t\t\t\t(<B style=\"color:red\" ><I>i</I></B>)\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'img_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t\t\t\t(<B style=\"color:red\" ><I>i</I></B>)\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' style=\"color:red\"  colspan = \'2\'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&lt;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&gt;</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'><a id=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="_anchor\'  href=\'javascript:showSectionDetails(";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="<!--IN071264-->\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'img_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t\t\t\t(<B style=\"color:red\" ><I>i</I></B>)\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">(<B style=\"color:red\" ><I>i</I></B>)\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t\t\t<td style=\"background-color:#FFDEAD\" colspan=\'3\'><a id=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="_anchor\' href=\'javascript:showSectionDetails(";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =",\"*AmmendNotes*\",\"*AmmendNotes*\",\"Addendum To Note\",\"\",\"\",\"\",\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\",\"\",\"\",\"\",\"\",\"\",\"\",\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\");\'>&nbsp;&nbsp;&nbsp;<b>-&nbsp;";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</b></a></td><!--IN071264-->\n\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' id=\"sectionLineTable\" style=\"display:none\"  height=\"100%\" width=\'100%\' >\n\t\t<tr>\n\t\t\t<td  style=\"font-weight:800;font-size=15;font-family:verdana;height:345px\" class=\'CAHIGHERLEVELCOLOR\'>\n\t\t\t<!-- IN058147 Start. -->\t\t\t\n\t\t\t<img onclick=\"expandSectionFrames()\" title=\'Expand the Section Pane\' src=\'../../eCA/images/Unpin_Icon.png\' alt=\"Expand the Section Pane\" style=\"cursor:pointer\" />\n\t\t\t<br><br><br><br>\t\t\t\n\t\t\t<!-- IN058147 End. -->\n\t\t\t\n\t\t\t\t&nbsp;S&nbsp;<br><br>&nbsp;E<br><br>&nbsp;C<br><br>&nbsp;T<br><br>&nbsp;I<br><br>&nbsp;O<br><br>&nbsp;N\n\t\t\t</td>\n\t\t</tr>\n\t</table>\t\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n<script>\n\tsetTimeout(\"parent.RecClinicalNotesToolbarFrame.document.forms[0].noteCopiedYN.value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'\",500);//IN068105\n</script>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\n\t\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" \n<script>\n\t\tvar counts = \'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'.split(\"|\");\n\t\tvar sec_hdg_codes = \'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'.split(\"|\");\n\t\tvar ii = 0;\n\t\tvar sbc = counts.length;\n\t\tfor(ii=0;ii < sbc;ii++)\n\t\t{\n\t\t\tif(counts[ii] != \'\' && sec_hdg_codes[ii] != \'\')\n\t\t\t\texpandCollapse(counts[ii], sec_hdg_codes[ii]);\n\t\t}\n/*\t\tvar noOfSec = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\tvar operationMode = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t//alert(\"operationMode\"+operationMode);\n\t\t\tif ((parseInt(noOfSec) == 1) && (operationMode==\"\"))\n\t\t\t{\t\t\t\t\t\t\t\t\t\t\tshowSectionDetails(\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\");\t\t\t\n\t\t\t}\t\t*/\n</script>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
	
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


public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
private String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
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
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
?              100				?	         	?			?				created
19/09/2012	IN033677	    Dinesh T		 	?			?		CRF-Recording and signing the	addendum with new free text editor 
06/05/2013	IN039562		Chowminya G			?	     	?		Age format Changed to Y-M-D
15/05/2013  IN038439		NijithaS			?			?		Bru-HIMS-CRF-351	
19/08/2013	IN041827		Akbar									ML-BRU-SCF-0949			
05/09/2013	IN043083		Chowminya G		 	?			?		Issue With NRIC in Medical Certificate Function
08/10/2013	IN041881		NijithaS			?			?		MO-GN-5428
24/10/2013  IN043963		NijithaS			?			?		MO-INC-0001
07/02/2014	IN046648		Karthi 			07/02/2014	Ramesh		Specialty name is not displayed  completely if the specialty name contains any special characters	
30/10/2014	IN046956		Karthi									Select a patient whose specialty contains special characters>Record clinical notes>find that it displays an error message		
03/07/2015	IN052940		Ramesh G								In Clinical note there should be an option to auto fetch/Copy data from same template 
																	if filled up earlier for same patient in template format.
10/09/2015	IN057343		Ramesh G								Alpha-CA- Modify Clinical Note, System does not display Captured images in Print Preview and when modified, already captured Image is removed.															
18/12/2015	IN058147		Ramesh G								Flickering between Clinical notes section list and note content. Provide option to pin the list of section so that the screen does not flicker on mouse movement.
22/01/2018	IN063931		Prakash C	   23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
21/10/2019	IN071569		Ramesh G									ML-MMOH-SCF-1389
18/03/2020	IN071264		Nijitha S									GHL-CRF-0604
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
--------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052940
	//IN071264 Starts
	String addendum_text_temp = "";
	String auto_save_yn ="N";
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	//IN071264 Ends

//	StringBuffer traceBeanOBJ = new StringBuffer();
//	traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSection.jsp at 8  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("encounter_id")+"**patient_id**"+request.getParameter("patient_id")+"**");

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);



	Hashtable htParameter=new Hashtable();
	Hashtable htPatDet=new Hashtable();
	Hashtable htPrompt=new Hashtable();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	eCA.TemplatePromtRepParser prompt_parser = new eCA.TemplatePromtRepParser();
	
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	Connection			con				=	null;
	
	PreparedStatement	pstmt			=	null;
	PreparedStatement	pstmt1			=	null;
	PreparedStatement	pstmt2			=	null;
	
	ResultSet			rs				=	null;
	ResultSet			rs1				=	null;
	ResultSet			rs2				=	null;
		
	//oracle.sql.CLOB			clob_notes_content			= null;
	java.sql.Clob			clob_notes_content			= null;
	//oracle.sql.CLOB			clob_section_image_content	= null;
	java.sql.Clob			clob_section_image_content	= null;
	
	java.io.Reader			content_reader				= null;
	java.io.BufferedReader	bf_content_reader			= null;
	String 		section_image_height		= "400"; //IN057343
	String	section_content						=		"",		image_content						=		"";
	String	patient_id							=		"",		note_type							=		"";
	String	classValue							=		"",		doc_exists							=		"";
	String	sec_hdg_code						=		"",		sec_hdg_desc						=		"";
	String	sec_content_type					=		"",		sec_result_linked_rec_type			=		"";
	String	child_sec_hdg_code					=		"",		child_sec_hdg_desc					=		"";
	String	child_sec_content_type				=		"",		child_sec_result_link_rec_type		=		"";
	String	chief_complaint_sec_yn				=		"",		image_linked_yn						=		"";
	String	result_link_type					=		"",		content_type						=		"";
	String	tblrow_id							=		"",		cnt_ofMainSections					=		"";
	String	facility_id							=		"",		accession_num						=		"";						
	String	encounter_id						=		"",		strContentEditableYn				=		"";						
	String	prev_sec_hdg_code					=		"",		ids_of_mainSections 				=		"";						
	String	anchorColor			 				=		"",		doc_linked_yn			 			=		"";
	String	query_notes_detail					=		"",		operation_mode						=		"";
	String	edited_yn				 			=		"N",	image_edited_yn	 					=		"N";
	String	image_recorded_yn					=		"N",	result_link_yn						=		"N";		
	String	output_form_exists_yn					=		"N";		
	String	selection_type					=		"S";		
	
	int		sub_section_counter					=	0,			cnt		=	0;

	StringBuffer query_section_details = new StringBuffer();
	StringBuffer sbResult			   = new StringBuffer();

	String		note_header_code			=	"";
	String		footer_code				=	"";
	String		report_header_code		=	"";
	String		note_status								=	"";
	String		note_type_desc							=	"";
	String		performing_phy_name						=	"";
	String		event_date_time							=	"";
	String		login_user_id							=	"";
	String		visit_adm_date							=	"";
	String		discharge_date							=	"";
	String		Sex							=	"";
	String		age							=	"";
	String		med_service							=	"";
	String		attending_practitioner							=	"";
	String		speciality_name							=	"";
	String		authorized_by							=	"";
	String		last_amended_by							=	"";
	String		doc_ref_id							=	"";
	String		location_code							=	"";
	String		patient_class							=	"";
	String		patient_name							=	"";
	String		print_date_time							=	"";
	String		location_desc							=	"";
	String		note_title							=	"";
	String		event_date_caption							=	"";
	String		event_perf_by_caption							=	"";
	String		event_status_caption							=	"";
	String		event_title_caption							=	"";
	String		event_type_caption							=	"";
	String		section_content_out							=	"";
	String		sec_hdg_code_out							=	"";
	String		child_sec_hdg_code_out							=	"";
	String		regn_date							=	"";
	String		date_of_birth							=	"";
	String		mar_status							=	"";
	String		nationality							=	"";
	String		res_area_code							=	"";
	String		res_town_desc							=	"";
	String		relgn							=	"";
	String		name_prefix							=	"";
	String		region_code							=	"";
	String		encounter_id1						=	"";
	String		facility_name						=	"";
	String strKey	=	"";
	String		noteCopiedYN	=	"";//IN068105

	//Practitioner Credentials Variables

	String		practitioner_name = "";
	String		degree = "";
	String		credential_id1 = "";
	String		credential_id2 = "";
	String		credential_id3 = "";
	String		email_id = "";
	String		pref_contact_mode = "";
	String		off_tel_num = "";
	String		off_tel_ext = "";
	String		res_tel_num = "";
	String		fax_num = "";
	String		mobile_num = "";
	String		pager_num = "";
	String		room_num = "";
	String		bed_num = "";
	String		res_addr = "";
	String		credential_id  = "";
	String		blood_grp  = "";
	String		rh_factor  = "";
	String 		national_id = "";//IN043083
	StringBuffer prac_credentials = new StringBuffer();
	String 		previousNote_accession_num	=	"";  //IN052940 
	String 		call_for_copy_previous_sec	=	""; //IN063931
	String 		call_for_copy_previous_note	=	""; //IN063931
	String		tempcurr_sec_hdg_code = "";
	String image_content_tmpupdate_as="";//IN071264
	//End Practitioner Credentials Variables

	int cntSec	=	0;

	//String		accession_num							=	"";

	operation_mode		=	(request.getParameter("operation_mode")==null)		? ""	:	request.getParameter("operation_mode");

	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
	manageEmailBean.clearBean();
	

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block9Bytes, _wl_block9);

			//IN058147 Start.
			//if(operation_mode.equals("ModifyAddendum"))
			//	classValue = "QRYEVEN";
			//else
			//IN058147 End.
				classValue = "ITEMSELECT";
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);

	try
	{
		out.println("<table class='grid' width='100%' style='display' id='tbl_section' align='center' >");
		HashSet recSet	= new HashSet();

		con				=	ConnectionManager.getConnection(request);

		facility_id		=	(String) session.getValue("facility_id");
		String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN038439
		String contr_mod_accession_num = "";//IN038439
		contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num"); //IN038439
		login_user_id		=	(String)		session.getValue("login_user");
		accession_num	=	(request.getParameter("accession_num")==null)	? ""	:	request.getParameter("accession_num");
		String accession_num_auto = (request.getParameter("accession_num_auto")==null)	? ""	:	request.getParameter("accession_num_auto");//IN071264
	
		note_type		=	(request.getParameter("note_type")==null)		? ""	:	request.getParameter("note_type");
		encounter_id	=	(request.getParameter("encounter_id")==null)	? ""	:	request.getParameter("encounter_id");
		patient_id		=	(request.getParameter("patient_id")==null)		? ""	:	request.getParameter("patient_id");
		note_status		=	(request.getParameter("note_status")==null)		? ""	:	request.getParameter("note_status");
		note_title		=	(request.getParameter("event_title_desc")==null)		? ""	:	request.getParameter("event_title_desc");
		performing_phy_name		=	(request.getParameter("performed_by_pract")==null)		? ""	:	request.getParameter("performed_by_pract");
		event_date_time		=	(request.getParameter("performed_date")==null)		? ""	:	request.getParameter("performed_date");
		attending_practitioner		=	(request.getParameter("attending_practitioner")==null)		? ""	:	request.getParameter("attending_practitioner");
		//attending_practitioner = java.net.URLDecoder.decode(attending_practitioner);//IN041881 //Commented for IN043963
		speciality_name		=	(request.getParameter("speciality_name")==null)		? ""	:	request.getParameter("speciality_name"); 
		//speciality_name  = java.net.URLDecoder.decode(speciality_name,"UTF-8"); // IN046648 - Commented for IN046956
		// added for IN046956 - Start
		speciality_name = speciality_name.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
		speciality_name = speciality_name.replaceAll("\\+", "%2B");
		speciality_name = java.net.URLDecoder.decode(speciality_name);
		// IN046956 - End
		Sex		=	checkForNull(request.getParameter("Sex"));
		visit_adm_date		=	(request.getParameter("visit_adm_date")==null)		? ""	:	request.getParameter("visit_adm_date");
		discharge_date		=	(request.getParameter("discharge_date")==null)		? ""	:	request.getParameter("discharge_date");
		location_desc		=	(request.getParameter("location_desc")==null)		? ""	:	request.getParameter("location_desc");

		if(discharge_date.equals("null"))
		{
			discharge_date ="";
		}
		
		
		if(encounter_id.equals(""))
		{
			encounter_id="0";
		}
		
		med_service		=	(request.getParameter("med_service")==null)		? ""	:	request.getParameter("med_service");
		location_code		=	(request.getParameter("location_code")==null)		? ""	:	request.getParameter("location_code");
		patient_class		=	(request.getParameter("patient_class")==null)		? ""	:	request.getParameter("patient_class");
		//accession_num		=	(request.getParameter("accession_num")==null)		? ""	:	request.getParameter("accession_num");
		//IN052940 Start.
		previousNote_accession_num =checkForNull( request.getParameter("previousNote_accession_num"));  
		call_for_copy_previous_sec =checkForNull( request.getParameter("call_for_copy_previous_sec")); //IN063931 
		call_for_copy_previous_note =checkForNull( request.getParameter("call_for_copy_previous_note")); //IN063931 
		tempcurr_sec_hdg_code =checkForNull( request.getParameter("tempcurr_sec_hdg_code")); //IN063931 
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(previousNote_accession_num ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(call_for_copy_previous_sec ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_for_copy_previous_note ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tempcurr_sec_hdg_code ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(speciality_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accession_num_auto ));
            _bw.write(_wl_block24Bytes, _wl_block24);

		//IN052940 End.
		// Pat details sh starts

		if(!(patient_id.equals("")))
		{
		

		try{
		//String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN CURR_PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC from mp_patient where patient_id = ? ";
		//String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
		String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR,a.NATIONAL_ID_NO from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
			
		pstmt2	= con.prepareStatement(strPatInfoQuery);
		pstmt2.setString(1,patient_class);
		pstmt2.setString(2,facility_id);
		pstmt2.setString(3,location_code);
		pstmt2.setString(4,locale);
		pstmt2.setString(5,facility_id);
		pstmt2.setString(6,location_code);
		pstmt2.setString(7,locale);//
		pstmt2.setString(8,locale);//
		pstmt2.setString(9,locale);//
		pstmt2.setString(10,locale);//
		pstmt2.setString(11,locale);//
		pstmt2.setString(12,locale);//
		pstmt2.setString(13,facility_id);//
		pstmt2.setString(14,locale);//
		pstmt2.setString(15,patient_id);
		rs2 = pstmt2.executeQuery();

		while(rs2.next())
			{
				patient_name = rs2.getString("patient_name")==null?"":rs2.getString("patient_name");
				age = rs2.getString("patient_age")==null?"":rs2.getString("patient_age");
				Sex = rs2.getString("Gender")==null?"":rs2.getString("Gender");
				location_desc = rs2.getString("LOCN_DESC")==null?"":rs2.getString("LOCN_DESC");
				print_date_time = rs2.getString("print_date_time")==null?"":rs2.getString("print_date_time");
				regn_date = rs2.getString("regn_date")==null?"":rs2.getString("regn_date");
				date_of_birth = rs2.getString("date_of_birth")==null?"":rs2.getString("date_of_birth");
				mar_status = rs2.getString("mar_status")==null?"":rs2.getString("mar_status");
				nationality = rs2.getString("nationality")==null?"":rs2.getString("nationality");
				res_area_code = rs2.getString("res_area_code")==null?"":rs2.getString("res_area_code");
				res_town_desc = rs2.getString("res_town_desc")==null?"":rs2.getString("res_town_desc");
				relgn = rs2.getString("relgn")==null?"":rs2.getString("relgn");
				name_prefix = rs2.getString("name_prefix")==null?"":rs2.getString("name_prefix");
				region_code = rs2.getString("region_code")==null?"":rs2.getString("region_code");		
				facility_name = rs2.getString("FACILITY_NAME")==null?"":rs2.getString("FACILITY_NAME");		
				res_addr = rs2.getString("res_addr")==null?"":rs2.getString("res_addr");		
				blood_grp = rs2.getString("BLOOD_GRP")==null?"":rs2.getString("BLOOD_GRP");		
				rh_factor = rs2.getString("RH_FACTOR")==null?"":rs2.getString("RH_FACTOR");		
				national_id = rs2.getString("NATIONAL_ID_NO")==null?"":rs2.getString("NATIONAL_ID_NO");	//IN043083
	

				if(Sex.equals("M") )
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(Sex.equals("F") )
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				if(patient_class.equals("OP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

			}
			//setPatOutDetails

		
		}
		catch(Exception ee)
		{
			//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}

	}

		//// Pat details sh Ends

		// Added Code on 11/06/2008 to Append Credentials to refferal Letter OutFormat.

		try{				
					String strPracCredentialsQuery = "select PRACTITIONER_NAME,DEGREE,CREDENTIAL_ID,CREDENTIAL_ID1,CREDENTIAL_ID2,CREDENTIAL_ID3,EMAIL_ID,PREF_CONTACT_MODE,OFF_TEL_NUM,OFF_TEL_EXT,RES_TEL_NUM,FAX_NUM,MOBILE_NUM,PAGER_NUM ,ASSIGN_BED_NUM,ASSIGN_ROOM_NUM FROM AM_PRACTITIONER A, PR_ENCOUNTER B WHERE A.PRACTITIONER_ID=B.ATTEND_PRACTITIONER_ID AND FACILITY_ID=? AND ENCOUNTER_ID=?";						
					pstmt2	= con.prepareStatement(strPracCredentialsQuery);
					pstmt2.setString(1,facility_id);
					pstmt2.setString(2,encounter_id);
					
					rs2 = pstmt2.executeQuery();

					if(rs2.next())
						{
							practitioner_name = rs2.getString("PRACTITIONER_NAME")==null?"":rs2.getString("PRACTITIONER_NAME");
							degree = rs2.getString("DEGREE")==null?"":rs2.getString("DEGREE");
							credential_id = rs2.getString("CREDENTIAL_ID")==null?"":rs2.getString("CREDENTIAL_ID");
							credential_id1 = rs2.getString("CREDENTIAL_ID1")==null?"":rs2.getString("CREDENTIAL_ID1");
							credential_id2 = rs2.getString("CREDENTIAL_ID2")==null?"":rs2.getString("CREDENTIAL_ID2");
							credential_id3 = rs2.getString("CREDENTIAL_ID3")==null?"":rs2.getString("CREDENTIAL_ID3");
							email_id = rs2.getString("EMAIL_ID")==null?"":rs2.getString("EMAIL_ID");
							pref_contact_mode = rs2.getString("PREF_CONTACT_MODE")==null?"":rs2.getString("PREF_CONTACT_MODE");
							off_tel_num = rs2.getString("OFF_TEL_NUM")==null?"":rs2.getString("OFF_TEL_NUM");
							off_tel_ext = rs2.getString("OFF_TEL_EXT")==null?"":rs2.getString("OFF_TEL_EXT");
							res_tel_num = rs2.getString("RES_TEL_NUM")==null?"":rs2.getString("RES_TEL_NUM");
							fax_num = rs2.getString("FAX_NUM")==null?"":rs2.getString("FAX_NUM");
							mobile_num = rs2.getString("MOBILE_NUM")==null?"":rs2.getString("MOBILE_NUM");
							pager_num = rs2.getString("PAGER_NUM")==null?"":rs2.getString("PAGER_NUM");
							bed_num = rs2.getString("ASSIGN_BED_NUM")==null?"":rs2.getString("ASSIGN_BED_NUM");
							room_num = rs2.getString("ASSIGN_ROOM_NUM")==null?"":rs2.getString("ASSIGN_ROOM_NUM");
						
							prac_credentials.append(practitioner_name+" "+degree+"<br/>");
							
							if (!credential_id.equals(""))
								prac_credentials.append(credential_id);

							if (!credential_id.equals("") && (!credential_id1.equals("")))
								prac_credentials.append(",");
							
								prac_credentials.append(credential_id1);

							if (!credential_id1.equals("") && (!credential_id2.equals("")))
								prac_credentials.append(",");

								prac_credentials.append(credential_id2);

							if (!credential_id2.equals("") && (!credential_id3.equals("")))
								prac_credentials.append(",");
							
							prac_credentials.append(credential_id3);
							
							if (!credential_id1.equals("") || !credential_id2.equals("") || (!credential_id3.equals("")))
								prac_credentials.append("<br/>");
					
							
							if (pref_contact_mode.equals("M"))
								{
									prac_credentials.append("Mobile : "+mobile_num);
									if (!email_id.equals(""))
											prac_credentials.append("  Email : "+email_id);
								}
							else if (pref_contact_mode.equals("R"))
								{
									prac_credentials.append("Residence Tel : "+res_tel_num);
									if (!email_id.equals(""))
											prac_credentials.append("  Email : "+email_id);
								}
							else if (pref_contact_mode.equals("O"))
								{									
									prac_credentials.append("Office Tel : "+off_tel_num);
									if (!off_tel_ext.equals(""))
											prac_credentials.append("  ext : "+off_tel_ext);
									if (!email_id.equals(""))
											prac_credentials.append("  Email : "+email_id);
							}else 
								{
									if (!email_id.equals(""))
											prac_credentials.append("  Email : "+email_id);
								}

						}
						//setPatOutDetails

			}
			catch(Exception ee)
			{
				//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
		
		//End Added Code on 11/06/2008

		// prompt value changes starts

		try{
		String strEventTitles = "select  a.EVENT_DATE_CAPTION,a.EVENT_PERF_BY_CAPTION ,a.EVENT_STATUS_CAPTION,a.EVENT_TITLE_CAPTION,a.EVENT_TYPE_CAPTION from CA_NOTE_TYPE_lang_vw a where a.NOTE_TYPE =? and a.LANGUAGE_ID =? ";
		
		pstmt2	= con.prepareStatement(strEventTitles);
		pstmt2.setString(1,note_type);
		pstmt2.setString(2,locale);
		
		rs2 = pstmt2.executeQuery();

		while(rs2.next())
			{
				event_date_caption = rs2.getString("EVENT_DATE_CAPTION")==null?"":rs2.getString("EVENT_DATE_CAPTION");
				event_perf_by_caption = rs2.getString("EVENT_PERF_BY_CAPTION")==null?"":rs2.getString("EVENT_PERF_BY_CAPTION");
				event_status_caption = rs2.getString("EVENT_STATUS_CAPTION")==null?"":rs2.getString("EVENT_STATUS_CAPTION");
				event_title_caption = rs2.getString("EVENT_TITLE_CAPTION")==null?"":rs2.getString("EVENT_TITLE_CAPTION");
				event_type_caption = rs2.getString("EVENT_TYPE_CAPTION")==null?"":rs2.getString("EVENT_TYPE_CAPTION");

			}

				htPrompt.put("V$PR_DATE", event_date_caption);
				htPrompt.put("V$NT_STATUS", event_status_caption);
				htPrompt.put("V$NT_TITLE", event_title_caption);
				htPrompt.put("V$NT_TYPE", event_type_caption);
				htPrompt.put("V$PR_BY_PRACT", event_perf_by_caption);
				
			
		}
		catch(Exception ee)
		{
			//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}

		if(!(note_type.equals("")))
		{
		// new addition for report header and Notes header strats

		try{
		String head_foot_qry ="select a.NOTE_TYPE_DESC,a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";

		pstmt2	= con.prepareStatement(head_foot_qry);
		pstmt2.setString(1,note_type);
		rs2 = pstmt2.executeQuery();

		while(rs2.next())
			{
				note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
				footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
				report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
				note_type_desc = rs2.getString("NOTE_TYPE_DESC")==null?"":rs2.getString("NOTE_TYPE_DESC");
			}

		}
		catch(Exception ee)
		{
			//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		// Report Header starts
			try
			{
			
				String rpt_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(rpt_sect_query);
				pstmt2.setString(1,report_header_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					
				if(clob_notes_content!=null)
				{
				try
					{
					
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					
					}
					catch(Exception e)
					{
						//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}

			if(!accession_num.equals(""))
			{
					try
					{
						//String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,1) AUTHORIZED_BY_ID,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;//Commented for IN068105
						String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,1) AUTHORIZED_BY_ID,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name,NOTES_COPIED_YN from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;//Modified for IN068105

						pstmt2	= con.prepareStatement(athorise_by_qry);
						pstmt2.setString(1,locale);
						pstmt2.setString(2,locale);
						pstmt2.setString(3,locale);
						pstmt2.setString(4,accession_num);
						pstmt2.setString(5,patient_id);
						rs2 = pstmt2.executeQuery();
						
						while(rs2.next())
						{
							authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
							last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
							doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
							performing_phy_name		=	checkForNull( rs2.getString("performed_by_name") );
							med_service		=	checkForNull( rs2.getString("service_name") );
							noteCopiedYN		=	checkForNull( rs2.getString("NOTES_COPIED_YN") );//IN068105
							
						}
						
					}
					catch (Exception roro )

					{
						out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());
						roro.printStackTrace();

					}
					finally 
					{
					  if(rs2 != null) rs2.close();
					  if(pstmt2 != null) pstmt2.close();
					}
            }


				encounter_id1=encounter_id;
				if(encounter_id.equals("0"))
					encounter_id1="";
				htParameter.put("V$ATT_PRACT", attending_practitioner);
				htParameter.put("V$PT_SPLTY", speciality_name);
				htParameter.put("V$PT_NAME", patient_name);
				htParameter.put("V$PT_ID", patient_id);
				htParameter.put("V$SEX", Sex);
				htParameter.put("V$AGE", age);
				htParameter.put("V$ENC_ID", encounter_id1);
				htParameter.put("V$ADM_DT", visit_adm_date); 
				htParameter.put("V$DIS_DT", discharge_date); 
				htParameter.put("V$MED_SERV", med_service);
				htParameter.put("V$DOC_REF_H", doc_ref_id);
				htParameter.put("V$PT_LOCN", location_desc); 
				htParameter.put("V$PT_CLASS", patient_class);
				
				
				//sectionContentUpdatedXML = new StringBuffer();
				StringBuffer section_content_new = new StringBuffer(section_content);
		
				if(!section_content_new.toString().equals("") && !section_content_new.toString().equals("&nbsp;") && section_content_new != null)
				{
					//***************************** [CRF-118] Start *****************************					
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
					paramHash.put("#p_patient_id#",patient_id);
					paramHash.put("#p_encounter_id#",encounter_id1);
					paramHash.put("#p_accNum#",accession_num);
					paramHash.put("#p_locale#",locale);
					paramHash.put("#p_eventDate#",event_date_time); //IN039562
					paramHash.put("#p_facility_id#",facility_id);//IN038439
					tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
					if(tempParameter.size()>0){					
					htParameter.putAll(tempParameter);
					}
					//*****************************[CRF-118] Ends *****************************
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}

				
		if(!report_header_code.equals("") && report_header_code != null)
			{
				sectionBean.setSectionValues(report_header_code,report_header_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				
			}
				
		section_content ="";



		//Report Header Ends


		// notes header
		try
			{
			
				String hdr_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(hdr_sect_query);
				pstmt2.setString(1,note_header_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
				
				if(clob_notes_content!=null)
				{
				try
					{
					
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}

				
				htParameter=new Hashtable();
				htParameter.put("V$PR_DATE", event_date_time);
				htParameter.put("V$NT_STATUS", note_status);
				htParameter.put("V$NT_TITLE", note_title);
				htParameter.put("V$NT_TYPE", note_type_desc);
				htParameter.put("V$PR_BY_PRACT", performing_phy_name);
				htParameter.put("V$DOC_REF_NH", doc_ref_id); 
				htParameter.put("V$NT_MEDSRV", med_service);
				

				
				sectionContentUpdatedXML.delete(0,sectionContentUpdatedXML.length())  ;
				section_content_new = new StringBuffer(section_content);

				//changing the prompt values
		
				if(!section_content_new.toString().equals(""))
				{
					//IN041827 Start
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
				
					paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
					paramHash.put("#p_accNum#",accession_num);
					paramHash.put("#p_locale#",locale);
					paramHash.put("#p_pract_id#",clinician_id);
					tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
					
					if(tempParameter.size()>0)
					{					
						htParameter.putAll(tempParameter);
					}
					//IN041827 Ends
					
					sectionContentUpdatedXML = prompt_parser.changePromptValuesForComps(section_content_new,htPrompt,locale);
				}
				

				if(!sectionContentUpdatedXML.toString().equals("") && sectionContentUpdatedXML != null)
				{
					sectionContentUpdatedXML = parser.updateXMLContentValues(sectionContentUpdatedXML,htParameter,locale);
				}



		//new ends
		
		if(!note_header_code.equals("") && note_header_code != null)
			{
				sectionBean.setSectionValues(note_header_code,note_header_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				
			}
						
		section_content ="";

		//Notes header ends....



//			query_section_details = " select sec_hdg_code,1 DOC_EXISTS,replace(sec_hdg_desc,'''','') sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, replace(child_sec_hdg_desc,'''','') child_sec_hdg_desc, child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN, IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN,nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type,nvl(child_sec_content_type,sec_content_type) content_type  from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num ";
		

			query_section_details.append("select sec_hdg_code,1 DOC_EXISTS,");
			query_section_details.append("case when ? = 'en' then replace(sec_hdg_desc,'''','') else ");
			query_section_details.append("replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc");
			query_section_details.append(",sec_content_type,sec_result_linked_rec_type,");
			query_section_details.append("NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
			query_section_details.append("CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN ''");
			query_section_details.append("ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') ");
			query_section_details.append("else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') ");
			query_section_details.append("end end child_sec_hdg_desc ");
			query_section_details.append(",child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN");
			query_section_details.append(",IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN");
			query_section_details.append(",nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type");
		//	query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type ");  
		//query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN ");  
			query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE ");  
			query_section_details.append("from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num");



			pstmt		=	con.prepareStatement(query_section_details.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,note_type);
		
			
			
			strKey = patient_id + "~"+ encounter_id;
			strKey = strKey.trim();
			sectionBean.getPatientSection(strKey);
			
		// Test Code For Tracing Bean object added on 17/07/2008 By Sridhar Reddy
				String resultKey = sectionBean.getpropPatientSection(strKey);	
			//	traceBeanOBJ.append("patientKey Existance in Bean RecClinicalNotesSection.jsp at 803  ====>>>"+resultKey+"  sectionBean   :   "+sectionBean+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id+"**Session  :  "+session);
			//Test Code End

			rs			=	pstmt.executeQuery();
			classValue = "gridData";

			//IN033677
			//IN071569 Start.
			//String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
			String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status,addendum_clob,addendum_storage_type FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
			//IN071569 end.
			PreparedStatement addendumTextPstmt = null;
			ResultSet addendumTextRs = null;
			//IN033677,ends
			String tempDataExists = "N";//IN071264 
			String temp_addendum_existes ="N";//IN071264 
			int index = 0;//IN071264 
			while(rs.next())
			{
				/*if((cnt%2)==0)	
					classValue	=	"QRYEVEN";
				else
					classValue	=	"QRYODD";*/

				addendumTextPstmt = con.prepareStatement(addendumTextSql);//IN033677
				doc_exists									=	checkForNull(rs.getString("DOC_EXISTS"));
				sec_hdg_code								=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc								=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type							=	checkForNull( rs.getString("sec_content_type") );
				sec_result_linked_rec_type					=	checkForNull( rs.getString("sec_result_linked_rec_type") );
				child_sec_hdg_code							=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_hdg_desc							=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_content_type						=	checkForNull( rs.getString("child_sec_content_type") );
				child_sec_result_link_rec_type				=	checkForNull( rs.getString("child_sec_result_link_rec_type") );
				chief_complaint_sec_yn						=   checkForNull( rs.getString("chief_complaint_sec_yn") );
				image_linked_yn								=   checkForNull( rs.getString("image_linked_yn") );
				strContentEditableYn						=	checkForNull( rs.getString("CONTENT_EDITABLE_YN") );
				content_type								=	checkForNull( rs.getString("content_type") );
				result_link_type							=	checkForNull( rs.getString("result_link_type") );
				output_form_exists_yn							=	rs.getString("OUTPUT_FORM_EXISTS_YN") ;
				result_link_yn								=	"N";
				selection_type							= rs.getString("SELECTION_TYPE")==null?"S":rs.getString("SELECTION_TYPE"); 	
				
				//IN033677,starts				
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,sec_hdg_code);
				addendumTextPstmt.setString(3,child_sec_hdg_code);
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";

				if(addendumTextRs.next())
				{
					//IN071569 Start.
					//addendumText = addendumTextRs.getString("addendum_text");
					if("CLOB".equals((String)addendumTextRs.getString("addendum_storage_type")))
						addendumText = addendumTextRs.getString("addendum_clob");
					else
						addendumText = addendumTextRs.getString("addendum_text");
					//IN071569 End.
				}
				//IN033677,ends

				if(strContentEditableYn == null || strContentEditableYn.equals("") )
					strContentEditableYn = "Y";	

					if(content_type.equals("R"))
					{
						content_type = "F";
						result_link_yn = "Y";
					}		

					if( operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || 
						operation_mode.equals("UpdateRecord") || !accession_num.equals("") )
					{
						
						query_notes_detail = "SELECT A.NOTES_SECTION_CONTENT,A.CHIEF_COMPLAINT_SEC_YN, DECODE(B.ACCESSION_NUM,NULL,'N','Y') IMAGE_RECORDED_YN, B.IMG_CONTENT FROM CA_ENCNTR_NOTE_SECTION A , CA_ENCNTR_NOTE_SECTION_OBJ B WHERE /*A.FACILITY_ID = ? AND */A.ACCESSION_NUM = ? AND A.SEC_HDG_CODE = ?  AND  A.SUBSEC_HDG_CODE = ?  AND B.OPERATING_FACILITY_ID(+)=A.FACILITY_ID AND B.ACCESSION_NUM(+)=A.ACCESSION_NUM AND b.SEC_HDG_CODE(+) = a.SEC_HDG_CODE AND  b.SUBSEC_HDG_CODE(+) =a.SUBSEC_HDG_CODE  ";

						pstmt1			=	con.prepareStatement(query_notes_detail);
						
						//pstmt1.setString(1, facility_id);
						pstmt1.setString(1, accession_num);
						pstmt1.setString(2, sec_hdg_code);
						pstmt1.setString(3, child_sec_hdg_code);

						rs1				=	pstmt1.executeQuery();
						
						section_content		=	"";
						image_content		=	"";

						if(rs1.next())
						{
							chief_complaint_sec_yn		=	checkForNull( rs1.getString("chief_complaint_sec_yn") );
							clob_notes_content			=	(java.sql.Clob) rs1.getObject("notes_section_content");
							clob_section_image_content	=	(java.sql.Clob) rs1.getObject("img_content");
							image_recorded_yn			=	rs1.getString("image_recorded_yn");

							if(clob_notes_content!=null)
							{
								try
								{
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content = new String(arr_notes_content);
									bf_content_reader.close();
									
									if(section_content == null)
										section_content = "";
										
									if(image_recorded_yn.equals("Y"))
									{
										if(clob_section_image_content != null)
										{
											content_reader	= ((java.sql.Clob) clob_section_image_content).getCharacterStream();
											bf_content_reader = new java.io.BufferedReader(content_reader);
											arr_notes_content = new char[(int)clob_section_image_content.length()];		bf_content_reader.read(arr_notes_content,0,(int)clob_section_image_content.length());
											image_content = new String(arr_notes_content);
											//image_content = java.net.URLEncoder.encode(image_content);
											bf_content_reader.close();
										//IN057343 Start.											
											section_image_height  = checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"");  
											if("0".equals(section_image_height) && !"".equals(image_content)){ 
												BASE64Decoder decoder = new BASE64Decoder();
												byte[]  imageByte = decoder.decodeBuffer(image_content);
												ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
												BufferedImage bimg = ImageIO.read(bis);
												section_image_height         = String.valueOf(bimg.getHeight());
												
												sectionBean.setSectionImageHeight(sec_hdg_code,child_sec_hdg_code,section_image_height);
											}
											//IN057343 End.
										}
									}
								}
								catch(Exception e)
								{
									//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
									e.printStackTrace();
								}
							}
						}
						
						if(pstmt1!=null){	pstmt1.close();	}
						if(rs1!=null)	{	rs1.close();	}

						if(content_type.equals("T")  && !section_content.equals(""))
						{							
								sbResult.delete(0,sbResult.length());
								sbResult.append(section_content);
								if (!locale.equals("en")) {
									HashMap<String,String> paramMap = new HashMap<String,String>();
									paramMap.put("CURR_SEC_HDG_CODE",child_sec_hdg_code);
									paramMap.put("LOCALE",locale);						
									paramMap.put("RANGE_PASER_YN","N");
									eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,sbResult);
									sbResult = tempLangParse.getLangReplacedXML();
									tempLangParse = null;
								}
								section_content = sbResult.toString();
								
						}
						
						if(output_form_exists_yn.equals("Y"))
						{
							String query_out_det ="select NOTES_SECTION_RESULT from CA_ENCNTR_NOTE_SEC_OUTPUT where SEC_HDG_CODE =? and SUBSEC_HDG_CODE =? and ACCESSION_NUM =? and FACILITY_ID =? and rownum =1 " ;
							pstmt1		=	con.prepareStatement(query_out_det);
						
							pstmt1.setString(1, sec_hdg_code); 
							pstmt1.setString(2, child_sec_hdg_code); 
							pstmt1.setString(3, accession_num); 
							pstmt1.setString(4, facility_id); 
							
							rs1				=	pstmt1.executeQuery();


							if(rs1.next())
							{
							
							clob_notes_content			=	(java.sql.Clob) rs1.getObject("NOTES_SECTION_RESULT");
							

							if(clob_notes_content!=null)
							{
								try
								{
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content_out = new String(arr_notes_content);
									bf_content_reader.close();
									
									if(section_content_out == null)
										section_content_out = "";
																
								}
								catch(Exception e)
								{
									//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
									e.printStackTrace();
								}
							}
						}
						
						if(pstmt1!=null){	pstmt1.close();	}
						if(rs1!=null)	{	rs1.close();	}
						
						sec_hdg_code_out =sec_hdg_code+"_out";
						child_sec_hdg_code_out =child_sec_hdg_code+"_out";
						sectionBean.setSectionValues(sec_hdg_code_out,child_sec_hdg_code_out,"T","N","N","N","N","","N","N", section_content_out,"",output_form_exists_yn);

						section_content_out ="";
							
						} //end if out
						if(!"".equals(addendumText)){
						sectionBean.setAddendumText(sec_hdg_code,child_sec_hdg_code,addendumText);//IN033677
						}
					}
					else{//IN071264 Starts
						if("Y".equals(auto_save_yn)){
						StringBuffer select_ca_encntr_note_section_temp =new StringBuffer();
						select_ca_encntr_note_section_temp.append("select notes_section_content,SEC_HDG_CODE,SUBSEC_HDG_CODE,'Y' as img_edited_yn_tmp from ca_encntr_note_section_tmp where patient_id = ? and encounter_id = ? and added_by_id=? and note_type = ? and sec_hdg_code = ? and subsec_hdg_code=? and note_status IS NULL ");
						select_ca_encntr_note_section_temp.append("UNION ALL");
						select_ca_encntr_note_section_temp.append(" SELECT IMG_CONTENT as notes_section_content,SEC_HDG_CODE,SUBSEC_HDG_CODE,'N' as img_edited_yn_tmp from ca_encntr_note_section_obj_tmp where patient_id = ? and encounter_id = ? and added_by_id=? and note_type = ? and sec_hdg_code = ? and subsec_hdg_code=? and note_status IS NULL ")	;
						
						PreparedStatement pstmttemp =  null;
						ResultSet rstemp = null;
						String tempsechdgcode = "";
						String tempsubsechdgcode = "";
						String seccontent		=	"";
						java.sql.Clob sec_notes_content_temp=null;
						java.sql.Clob img_notes_content_temp=null;
						String image_content_tmp = "";
						String img_edited_yn_tmp ="";
						String img_edited_yn_as="N	";
						try {
							
							pstmttemp	=	con.prepareStatement(select_ca_encntr_note_section_temp.toString());
							System.out.println("1103==="+select_ca_encntr_note_section_temp.toString());
							pstmttemp.setString	(	1,	patient_id	);
							pstmttemp.setString	(	2,	encounter_id	);
							pstmttemp.setString	(	3,	login_user_id		);
							pstmttemp.setString	(	4,	note_type	);
							pstmttemp.setString	(	5,	sec_hdg_code	);
							pstmttemp.setString	(	6,	child_sec_hdg_code	);
							pstmttemp.setString	(	7,	patient_id	);
							pstmttemp.setString	(	8,	encounter_id	);
							pstmttemp.setString	(	9,	login_user_id		);
							pstmttemp.setString	(	10,	note_type	);
							pstmttemp.setString	(	11,	sec_hdg_code	);
							pstmttemp.setString	(	12,	child_sec_hdg_code	);
							System.out.println("sec_hdg_code"+sec_hdg_code);
							System.out.println("child_sec_hdg_code"+child_sec_hdg_code);
							
							rstemp = pstmttemp.executeQuery();
						
							while(rstemp.next()){
								tempsechdgcode = rstemp.getString("SEC_HDG_CODE");
								tempsubsechdgcode = rstemp.getString("SUBSEC_HDG_CODE");
								sec_notes_content_temp = rstemp.getClob("notes_section_content");
								img_edited_yn_tmp = rstemp.getString("img_edited_yn_tmp");
								img_edited_yn_as ="N";
								if("Y".equals(image_linked_yn))	
								{	
									//System.out.println("img_edited_yn_tmp"+img_edited_yn_tmp);
									img_notes_content_temp = sec_notes_content_temp;
									if(img_notes_content_temp != null)
									{
										if(!"Y".equals(img_edited_yn_tmp))
										{
											img_edited_yn_as = "Y";
											content_reader	= ((java.sql.Clob) img_notes_content_temp).getCharacterStream();
											//System.out.println("content_reader bimg===>"+content_reader);
											bf_content_reader = new java.io.BufferedReader(content_reader);
											char[] arr_notes_content_tmp = new char[(int)img_notes_content_temp.length()];
											arr_notes_content_tmp = new char[(int)img_notes_content_temp.length()];	
											bf_content_reader.read(arr_notes_content_tmp,0,(int)img_notes_content_temp.length());
											image_content_tmp = new String(arr_notes_content_tmp);
											
											bf_content_reader.close();
																			
												section_image_height  = checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"");  
												if("0".equals(section_image_height) && !"".equals(image_content_tmp)){ 
													BASE64Decoder decoder = new BASE64Decoder();
													byte[]  imageByte = decoder.decodeBuffer(image_content_tmp);
													ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
													BufferedImage bimg = ImageIO.read(bis);
											//	System.out.println("BufferedImage bimg===>"+bimg);
												if(null!=bimg){
													section_image_height         = String.valueOf(bimg.getHeight());
													
													
												}
												}
												sectionBean.setSectionImageHeight(sec_hdg_code,child_sec_hdg_code,section_image_height);
												//sectionBean.setSectionValues(tempsechdgcode,tempsubsechdgcode,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"",img_edited_yn_tmp,"N", seccontent,image_content_tmp,output_form_exists_yn);
										}
										else{
											if(sec_notes_content_temp!=null)
											{
												
												java.io.BufferedReader r = new java.io.BufferedReader(sec_notes_content_temp.getCharacterStream());
												
												bf_content_reader	= new java.io.BufferedReader(r);
												char[] arr_notes_content = new char[(int)sec_notes_content_temp.length()];
												bf_content_reader.read(arr_notes_content,0,(int)sec_notes_content_temp.length());
												seccontent = new String(arr_notes_content);
												bf_content_reader.close();
												
												/* String line = null;
												
												while((line=r.readLine()) != null) 
												{
													seccontent.append(line);
												} */
											}
											
											 /* if(content_type.equals("T")  && !seccontent.equals(""))
											{							
													sbResult.delete(0,sbResult.length());
													sbResult.append(seccontent);
													if (!locale.equals("en")) {
														HashMap<String,String> paramMap = new HashMap<String,String>();
														paramMap.put("CURR_SEC_HDG_CODE",child_sec_hdg_code);
														paramMap.put("LOCALE",locale);						
														paramMap.put("RANGE_PASER_YN","N");
														eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,sbResult);
														sbResult = tempLangParse.getLangReplacedXML();
														tempLangParse = null;
													}
													seccontent = sbResult;
													
											}  */
										}
										//sectionBean.setSectionValues(tempsechdgcode,tempsubsechdgcode,sec_content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"","N","N", seccontent.toString(),image_content_tmp,output_form_exists_yn);
									}
									System.out.println("tempsechdgcode==>"+tempsechdgcode);
									System.out.println("tempsubsechdgcode==>"+tempsubsechdgcode);
									sectionBean.setSectionValues(tempsechdgcode,tempsubsechdgcode,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"",img_edited_yn_as,edited_yn, seccontent,image_content_tmp,output_form_exists_yn);
								}
								else
								{
									if(sec_notes_content_temp!=null)
									{
										java.io.BufferedReader r = new java.io.BufferedReader(sec_notes_content_temp.getCharacterStream());
										
										
										bf_content_reader	= new java.io.BufferedReader(r);
										char[] arr_notes_content = new char[(int)sec_notes_content_temp.length()];
										bf_content_reader.read(arr_notes_content,0,(int)sec_notes_content_temp.length());
										seccontent = new String(arr_notes_content);
										bf_content_reader.close();
										
										
										/* if(content_type.equals("T")  && !seccontent.equals(""))
										{							
												sbResult.delete(0,sbResult.length());
												sbResult.append(seccontent);
												if (!locale.equals("en")) {
													HashMap<String,String> paramMap = new HashMap<String,String>();
													paramMap.put("CURR_SEC_HDG_CODE",child_sec_hdg_code);
													paramMap.put("LOCALE",locale);						
													paramMap.put("RANGE_PASER_YN","N");
													eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,sbResult);
													sbResult = tempLangParse.getLangReplacedXML();
													tempLangParse = null;
												}
												seccontent = sbResult;
												
										} */
									}
									sectionBean.setSectionValues(tempsechdgcode,tempsubsechdgcode,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"","N","N", seccontent,"",output_form_exists_yn);
								}

								image_content_tmp ="";
								//seccontent.append("");
								tempDataExists = "Y";
							}	
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					}
					if("Y".equals(auto_save_yn) &&(operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || 
							operation_mode.equals("UpdateRecord") ))	{	
						StringBuffer select_ca_encntr_note_section_tempupdate =new StringBuffer();
						select_ca_encntr_note_section_tempupdate.append("select notes_section_content,SEC_HDG_CODE,SUBSEC_HDG_CODE,'Y' as img_edited_yn_tmp , 'N' as addendum_text_yn from ca_encntr_note_section_tmp where patient_id = ? and encounter_id = ? and added_by_id=? and note_type = ? and sec_hdg_code = ? and subsec_hdg_code=? and note_status='UPDATE' ");
						select_ca_encntr_note_section_tempupdate.append("UNION ALL");
						select_ca_encntr_note_section_tempupdate.append(" SELECT IMG_CONTENT as notes_section_content,SEC_HDG_CODE,SUBSEC_HDG_CODE,'N' as img_edited_yn_tmp, 'N' as addendum_text_yn from ca_encntr_note_section_obj_tmp where patient_id = ? and encounter_id = ? and added_by_id=? and note_type = ? and sec_hdg_code = ? and subsec_hdg_code=? and note_status='UPDATE' ")	;
						select_ca_encntr_note_section_tempupdate.append("UNION ALL");
						select_ca_encntr_note_section_tempupdate.append(" SELECT ADDENDUM_Clob as notes_section_content,SEC_HDG_CODE,SUBSEC_HDG_CODE,'N' as img_edited_yn_tmp,'Y' as addendum_text_yn from ca_encntr_note_addendum_tmp where patient_id = ? and encounter_id = ? and added_by_id=? and note_type = ? and sec_hdg_code = ? and subsec_hdg_code=? ")	;
						
						PreparedStatement pstmttempupdate =  null;
						ResultSet rstempupdate = null;
						String tempsechdgcodeupdate = "";
						String tempsubsechdgcodeupdate = "";
						String seccontentupdate		=	"";
						StringBuffer addendumtextupdate		=	new StringBuffer();
						java.sql.Clob sec_notes_content_tempupdate=null;
						java.sql.Clob img_notes_content_tempupdate=null;
						String image_content_tmpupdate = "";
						String img_edited_yn_tmpupdate ="";
						String addendum_text_yn = "";
						//int index=0;
						try {
							
							pstmttempupdate	=	con.prepareStatement(select_ca_encntr_note_section_tempupdate.toString());
							System.out.println("1103==="+select_ca_encntr_note_section_tempupdate.toString());
							pstmttempupdate.setString	(	1,	patient_id	);
							pstmttempupdate.setString	(	2,	encounter_id	);
							pstmttempupdate.setString	(	3,	login_user_id		);
							pstmttempupdate.setString	(	4,	note_type	);
							pstmttempupdate.setString	(	5,	sec_hdg_code	);
							pstmttempupdate.setString	(	6,	child_sec_hdg_code	);
							pstmttempupdate.setString	(	7,	patient_id	);
							pstmttempupdate.setString	(	8,	encounter_id	);
							pstmttempupdate.setString	(	9,	login_user_id		);
							pstmttempupdate.setString	(	10,	note_type	);
							pstmttempupdate.setString	(	11,	sec_hdg_code	);
							pstmttempupdate.setString	(	12,	child_sec_hdg_code	);
							pstmttempupdate.setString	(	13,	patient_id	);
							pstmttempupdate.setString	(	14,	encounter_id	);
							pstmttempupdate.setString	(	15,	login_user_id		);
							pstmttempupdate.setString	(	16,	note_type	);
							pstmttempupdate.setString	(	17,	sec_hdg_code	);
							pstmttempupdate.setString	(	18,	child_sec_hdg_code	);
							System.out.println("sec_hdg_code"+sec_hdg_code);
							System.out.println("child_sec_hdg_code"+child_sec_hdg_code);
							
							rstempupdate = pstmttempupdate.executeQuery();
						
							while(rstempupdate.next()){
								tempsechdgcodeupdate = rstempupdate.getString("SEC_HDG_CODE");
								tempsubsechdgcodeupdate = rstempupdate.getString("SUBSEC_HDG_CODE");
								sec_notes_content_tempupdate = rstempupdate.getClob("notes_section_content");
								img_edited_yn_tmpupdate = rstempupdate.getString("img_edited_yn_tmp");
								addendum_text_yn = rstempupdate.getString("addendum_text_yn");
								
								if("Y".equals(image_linked_yn))	
								{	
									//System.out.println("img_edited_yn_tmp"+img_edited_yn_tmp);
									img_notes_content_tempupdate = sec_notes_content_tempupdate;
									if(img_notes_content_tempupdate != null)
									{
										if(!"Y".equals(img_edited_yn_tmpupdate))
										{
											content_reader	= ((java.sql.Clob) img_notes_content_tempupdate).getCharacterStream();
											//System.out.println("content_reader bimg===>"+content_reader);
											bf_content_reader = new java.io.BufferedReader(content_reader);
											char[] arr_notes_content_tmp = new char[(int)img_notes_content_tempupdate.length()];
											arr_notes_content_tmp = new char[(int)img_notes_content_tempupdate.length()];	
											bf_content_reader.read(arr_notes_content_tmp,0,(int)img_notes_content_tempupdate.length());
											image_content_tmpupdate = new String(arr_notes_content_tmp);
											
											bf_content_reader.close();
																			
												section_image_height  = checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"");  
												if("0".equals(section_image_height) && !"".equals(image_content_tmpupdate)){ 
													BASE64Decoder decoder = new BASE64Decoder();
													byte[]  imageByte = decoder.decodeBuffer(image_content_tmpupdate);
													ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
													BufferedImage bimg = ImageIO.read(bis);
											//	System.out.println("BufferedImage bimg===>"+bimg);
												if(null!=bimg){
													section_image_height         = String.valueOf(bimg.getHeight());
													
													
												}
												}
												sectionBean.setSectionImageHeight("temp"+sec_hdg_code,"temp"+child_sec_hdg_code,section_image_height);
										
												image_content_tmpupdate_as = image_content_tmpupdate;
										}
										else{
											if(sec_notes_content_tempupdate!=null)
											{
												java.io.BufferedReader r = new java.io.BufferedReader(sec_notes_content_tempupdate.getCharacterStream());
												bf_content_reader	= new java.io.BufferedReader(r);
												char[] arr_notes_content = new char[(int)sec_notes_content_tempupdate.length()];
												bf_content_reader.read(arr_notes_content,0,(int)sec_notes_content_tempupdate.length());
												seccontentupdate = new String(arr_notes_content);
												bf_content_reader.close();
											//	tempDataExists = "Y";//IN071264
											}
										}
										//sectionBean.setSectionValues(tempsechdgcode,tempsubsechdgcode,sec_content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"","N","N", seccontent.toString(),image_content_tmp,output_form_exists_yn);
									}
									System.out.println("tempsechdgcode1291==>"+tempsechdgcodeupdate);
									System.out.println("tempsubsechdgcode1292==>"+tempsubsechdgcodeupdate);
									
									sectionBean.setSectionValues("temp"+tempsechdgcodeupdate,"temp"+tempsubsechdgcodeupdate,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"",image_edited_yn,edited_yn, seccontentupdate,image_content_tmpupdate,output_form_exists_yn);
								}
								else
								{
									if(sec_notes_content_tempupdate!=null)
									{
										java.io.BufferedReader r = new java.io.BufferedReader(sec_notes_content_tempupdate.getCharacterStream());
										bf_content_reader	= new java.io.BufferedReader(r);
										char[] arr_notes_content = new char[(int)sec_notes_content_tempupdate.length()];
										bf_content_reader.read(arr_notes_content,0,(int)sec_notes_content_tempupdate.length());
										seccontentupdate = new String(arr_notes_content);
										bf_content_reader.close();
									}
								
									sectionBean.setSectionValues("temp"+tempsechdgcodeupdate,"temp"+tempsubsechdgcodeupdate,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,"","N","N", seccontentupdate,"",output_form_exists_yn);
								}

								image_content_tmpupdate ="";

								
								//IN071264 Starts
								if("Y".equals(addendum_text_yn)){
									java.io.BufferedReader at = new java.io.BufferedReader(sec_notes_content_tempupdate.getCharacterStream());
									String line_at = null;
									addendumtextupdate		=	new StringBuffer();
									System.out.println("");
									while((line_at=at.readLine()) != null) 
									{
										addendumtextupdate.append(line_at);
									}
									/* if(index==0)
									sectionBean.setAddendumText("temp*AmmendNotes*","temp*AmmendNotes*", seccontentupdate.toString());
									else */
									System.out.println("seccontentupdate.toString()"+addendumtextupdate.toString());
									sectionBean.setAddendumText("temp"+tempsechdgcodeupdate,"temp"+tempsubsechdgcodeupdate, addendumtextupdate.toString());	
									//index++;
									temp_addendum_existes = "Y";
								}
								
								//IN071264 Ends
							}	
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					//IN071264 Ends
					//IN063931 start					
					if(!"Y".equals(call_for_copy_previous_sec ) && "N".equals(tempDataExists))// Added for IN071264
					{
						sectionBean.setSectionValues(sec_hdg_code,child_sec_hdg_code,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,result_link_type, image_edited_yn,edited_yn, section_content, image_content,output_form_exists_yn);
					}
					
					tempDataExists = "N";//IN071264
					//IN063931 ends
					// Test Code 
					resultKey = sectionBean.getpropPatientSection(strKey);
				//	traceBeanOBJ.append("sectionBean   Object  :   "+sectionBean+"PatientSection key   ***"+resultKey+"***login_user_id  =  "+login_user_id+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id+"**SectionContent in Bean in RecClinicalNotesSection    ***"+sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code)+"***");

					//Test Code End 
					

					if(chief_complaint_sec_yn.equals("Y"))		// Only One section as Chief Complaint
					{	
						String queryChiefComplaint = "select COMPLAINT_ID from CA_ENCNTR_NOTE_SEC_COMPLAINT where facility_id = ? and accession_num = ? and SEC_HDG_CODE = ?";					
						
						try
						{
							pstmt1 = con.prepareStatement(queryChiefComplaint);
							pstmt1.setString(1, facility_id);
							pstmt1.setString(2, accession_num);
							pstmt1.setString(3, sec_hdg_code);

							rs1 = pstmt1.executeQuery();
						
							String complaint= "";

							while(rs1.next())
							{
								complaint = rs1.getString(1);
								recSet.add(complaint);
							}
						}
						catch (Exception ee2)
						{
							//out.println("Exception@2-readChiefcomplaint : "+ee2);//COMMON-ICN-0181
							ee2.printStackTrace();

						}
						finally
						{
							if(pstmt1!=null){	pstmt1.close();	}
							if(rs1!=null)	{	rs1.close();	}
						}

						if(!recSet.isEmpty())
							sectionBean.setSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code,recSet);	
					}

					if(!(sec_hdg_code.equals(prev_sec_hdg_code)))
					{
						sub_section_counter = 0;
						
						tblrow_id = "tblrow_id"+(cnt);
						cnt++;
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sec_content_type.equals("S")?"<b>":""));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(anchorColor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(image_linked_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_link_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(content_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chief_complaint_sec_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_link_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_content_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(selection_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(accession_num_auto));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((chief_complaint_sec_yn.equals("Y"))?"(<b><i style='color:red' >c</i></b>)":"" ));
            out.print( String.valueOf(sec_content_type.equals("S")?"</b>":""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block43Bytes, _wl_block43);

								if(image_linked_yn.equals("Y"))
								{//IN071264 Starts
									if("Y".equals(auto_save_yn) && ""!=image_content_tmpupdate_as){
										System.out.println("image_content_tmpupdate_as===>"+image_content_tmpupdate_as);
										
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(image_content_tmpupdate_as));
            _bw.write(_wl_block48Bytes, _wl_block48);
image_content_tmpupdate_as="";
									}else{//IN071264 Ends
								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(image_content));
            _bw.write(_wl_block50Bytes, _wl_block50);

								}//IN071264 
								}
								
            _bw.write(_wl_block51Bytes, _wl_block51);
//putting the chief complaint data into the bean
					
						prev_sec_hdg_code	=	sec_hdg_code;
					}

					if(sec_content_type.equals("S"))
					{
						tblrow_id = "tblrow_id"+(cnt);
						/*if((cnt%2)==0)	classValue	=	"QRYEVEN";
						else			classValue	=	"QRYODD";*/
						
						if(child_sec_hdg_desc.equals(""))
						{
							
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf("No Sub Section Exists"));
            _bw.write(_wl_block56Bytes, _wl_block56);

						}
						else
						{
							
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(image_linked_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_link_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(content_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chief_complaint_sec_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_link_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_content_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sub_section_counter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(output_form_exists_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(accession_num_auto ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);

							if(image_linked_yn.equals("Y"))
							{
								if("Y".equals(auto_save_yn) && ""!=image_content_tmpupdate_as){//IN071264 Starts
									
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(image_content_tmpupdate_as));
            _bw.write(_wl_block65Bytes, _wl_block65);
image_content_tmpupdate_as="";
								}else{//IN071264 Ends
								
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(image_content));
            _bw.write(_wl_block66Bytes, _wl_block66);

								}//IN071264
							}
							
            _bw.write(_wl_block67Bytes, _wl_block67);
	
								sub_section_counter++;
								out.println("<script>");							
							
								if(sub_section_counter == 1 )
								{
									
									out.println("document.RecClinicalNotesSectionForm.no_of_sub_sections_"+sec_hdg_code+"_anchor.style.visibility = ''");
									cnt_ofMainSections =cnt_ofMainSections+(cnt_ofMainSections.equals("")?((cnt) + ""):("|" + (cnt)));
									ids_of_mainSections =ids_of_mainSections+ (ids_of_mainSections.equals("")?((sec_hdg_code) + ""):("|" + (sec_hdg_code)));
								}
								
								out.println("document.RecClinicalNotesSectionForm.no_of_sub_sections_" + sec_hdg_code + ".value=" + sub_section_counter);
								out.println("</script>");
						}
						
						cnt++;
					}
					cntSec++;
			}				// end of while(rs.next())	

			//IN033677,starts
			if(addendumTextPstmt!=null)
				addendumTextPstmt.close();
			if(addendumTextRs!=null)
				addendumTextRs.close();
			//IN071264 Starts
			java.sql.Clob addendum_text_temp_clob = null;
			if("Y".equals(auto_save_yn) && operation_mode.equals("ModifyAddendum")){
				addendumTextPstmt = con.prepareStatement("SELECT ADDENDUM_CLOB FROM CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND NOTE_TYPE=? AND ADDED_BY_ID=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? ");
				addendumTextPstmt.setString(1,patient_id);
				addendumTextPstmt.setString(2,encounter_id);
				addendumTextPstmt.setString(3,note_type);
				addendumTextPstmt.setString(4,login_user_id);
				addendumTextPstmt.setString(5,"*AmmendNotes*");
				addendumTextPstmt.setString(6,"*AmmendNotes*");
				addendumTextRs	=	addendumTextPstmt.executeQuery();
				if(addendumTextRs.next())
				{
					addendum_text_temp_clob = addendumTextRs.getClob("ADDENDUM_CLOB");
				}
				if(null!=addendum_text_temp_clob){
				java.io.BufferedReader addendum_clob = new java.io.BufferedReader(addendum_text_temp_clob.getCharacterStream());
				String line_at_addendum_text = null;
				StringBuffer addendumtmp		=	new StringBuffer();
				
				while((line_at_addendum_text=addendum_clob.readLine()) != null) 
				{
					addendumtmp.append(line_at_addendum_text);
				}
				addendum_text_temp = addendumtmp.toString();
				}
			}
			if(addendumTextPstmt!=null)
				addendumTextPstmt.close();
			if(addendumTextRs!=null)
				addendumTextRs.close();
			
			if(null!=addendum_text_temp && !"".equals(addendum_text_temp)){
				sectionBean.setAddendumText("*tempAmmendNotes*","*tempAmmendNotes*",addendum_text_temp);
			}
					System.out.println("1534:"+addendum_text_temp);
			if(!accession_num.equals("&nbsp;") && !accession_num.equals("") )
			{
				addendumTextPstmt = con.prepareStatement(addendumTextSql);
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,"*AmmendNotes*");
				addendumTextPstmt.setString(3,"*AmmendNotes*");
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";

				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}

				sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
			}
			//IN033677,ends


			// putting notes footer in bean

			 if (!footer_code.equals("") && footer_code != null) 
			{
				try
				{			  
					String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
					pstmt2	= con.prepareStatement(footer_sect_query);
					pstmt2.setString(1,footer_code);
					rs2 = pstmt2.executeQuery();


					if(rs2.next())
					{
					
						clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
						
					if(clob_notes_content!=null)
					{
					try
						{
					
						content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
						bf_content_reader	= new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						section_content = new String(arr_notes_content);
						bf_content_reader.close();
										
						if(section_content == null)
							section_content = "";
						}
						catch(Exception e)
						{
							//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
							e.printStackTrace();
						}


					 }
					}
				}

				catch(Exception eee)
				{
					//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
					eee.printStackTrace();

				}
				finally
				{
					if(rs2 != null) rs2.close();
					if(pstmt2 != null) pstmt2.close();
				}
			
				
			
				htParameter=new Hashtable();
				htParameter.put("V$CUR_USR", login_user_id);
				htParameter.put("V$AT_PRACT", authorized_by);
				htParameter.put("V$LT_MODI_USR", last_amended_by);
				htParameter.put("V$PRN_DTTIME", print_date_time);
				htParameter.put("V$DOC_REF_F", doc_ref_id);
								
				section_content_new = new StringBuffer(section_content);
				//IN038439 Start
						if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
						{													
							eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
							HashMap paramHash=new HashMap();
							Hashtable tempParameter=new Hashtable();
						
							paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
							paramHash.put("#p_accNum#",accession_num);
							paramHash.put("#p_locale#",locale);
							paramHash.put("#p_pract_id#",clinician_id);
							tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);	
							if(tempParameter.size()>0)
							{					
								htParameter.putAll(tempParameter);
							}
						}
				 //IN038439 Ends
				sectionContentUpdatedXML = new StringBuffer();
			
				if(!section_content_new.toString().equals("") && section_content_new != null)
				{
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}



				
				if(!footer_code.equals("") && footer_code != null)
				{
					sectionBean.setSectionValues(footer_code,footer_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				}
			}
			section_content ="";
	
			tblrow_id = "tblrow_id"+(cnt);

			if( operation_mode.equals("ModifyAddendum"))
			{
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(output_form_exists_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(accession_num_auto));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
}
		} 
		// setting pat details in bean
		htPatDet.put("PATIENT_ID",patient_id); htPatDet.put("PATIENT_NAME",patient_name);
		htPatDet.put("REGN_DATE",regn_date);  htPatDet.put("GENDER",Sex);
		htPatDet.put("RESIDENTAIL_ADDRESS",res_addr);
		htPatDet.put("AGE",age);   	htPatDet.put("FACILITY_NAME",facility_name);
		htPatDet.put("DATE_OF_BIRTH",date_of_birth); htPatDet.put("MAR_STATUS_CODE",mar_status);
		htPatDet.put("NATIONALITY_CODE",nationality);
		htPatDet.put("RH_FACTOR",rh_factor); 	htPatDet.put("BLOOD_GRP",blood_grp);
		htPatDet.put("RES_AREA_CODE",res_area_code);	htPatDet.put("RES_TOWN_CODE",res_town_desc);
		htPatDet.put("RELGN_CODE",relgn); 	htPatDet.put("NAME_PREFIX",name_prefix);
		htPatDet.put("REGION_CODE",region_code); 
		htPatDet.put("ENCOUNTER_ID",encounter_id1);
		htPatDet.put("CURRENT_LOCATION",location_desc);
		htPatDet.put("ATTENDING_PRACTITIONER",attending_practitioner);
		htPatDet.put("ADMISSION_DATE",visit_adm_date);
		htPatDet.put("SPECIALITY",speciality_name);
		htPatDet.put("PATIENT_CLASS",patient_class);
		htPatDet.put("ROOM_NUM",room_num);
		htPatDet.put("BED_NUM",bed_num);
		htPatDet.put("SERVICE_CODE",med_service);
		htPatDet.put("ATT_PRACT_WITH_CREDENTIAL",prac_credentials.toString());
		htPatDet.put("PATIENT_NRIC",national_id);//IN043083

		sectionBean.setPatOutDetails(htPatDet,patient_id);
		
		
		// setting pat details in bean ends
		
	//	traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesSection.jsp at 1248  ====>>>"+sectionBean+"   session  :   "+session+"**PatientKey"+sectionBean.getpropPatientSection(strKey)+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id);

		putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
		putObjectInBean("sectionBean",sectionBean,session);


	out.println("</table>");
 
            _bw.write(_wl_block75Bytes, _wl_block75);

		//Added by Sridhar Reddy on 26/12/2008 for BSP30453-CRF-0064-0069 changes
		boolean isFirst = rs.first();
		//IN063931 starts
		if(call_for_copy_previous_sec.equals("Y") && operation_mode.equals(""))
		{
			do {
			


				if(tempcurr_sec_hdg_code.equals(rs.getString("sec_hdg_code")))
				{			
				doc_exists									=	checkForNull(rs.getString("DOC_EXISTS"));
				sec_hdg_code								=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc								=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type						=	checkForNull( rs.getString("sec_content_type") );
				sec_result_linked_rec_type		=	checkForNull( rs.getString("sec_result_linked_rec_type") );
				child_sec_hdg_code					=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_hdg_desc					=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_content_type				=	checkForNull( rs.getString("child_sec_content_type") );
				child_sec_result_link_rec_type	=	checkForNull( rs.getString("child_sec_result_link_rec_type") );
				chief_complaint_sec_yn				=   checkForNull( rs.getString("chief_complaint_sec_yn") );
				image_linked_yn						=   checkForNull( rs.getString("image_linked_yn") );
				strContentEditableYn					=	checkForNull( rs.getString("CONTENT_EDITABLE_YN") );
				content_type								=	checkForNull( rs.getString("content_type") );
				result_link_type							=	checkForNull( rs.getString("result_link_type") );
				output_form_exists_yn				=	rs.getString("OUTPUT_FORM_EXISTS_YN") ;
				result_link_yn								=	"N";
				selection_type							= rs.getString("SELECTION_TYPE")==null?"S":rs.getString("SELECTION_TYPE"); 	
		
				if(strContentEditableYn == null || strContentEditableYn.equals("") )
					strContentEditableYn = "Y";	

				if(content_type.equals("R"))
				{
					content_type = "F";
					result_link_yn = "Y";
				}		
			
				if(sec_content_type.equals("S")){
					//IN052940 Start.
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','"+cnt+"','0','"+output_form_exists_yn+"');</script>");				
					//IN063931 start
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','"+cnt+"','0','"+output_form_exists_yn+"','"+previousNote_accession_num+"');</script>");
				//IN052940 End.
					out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','"+cnt+"','0','"+output_form_exists_yn+"','"+previousNote_accession_num+"','"+call_for_copy_previous_sec+"','"+call_for_copy_previous_note+"');</script>");
					//IN063931 ends
					}else{
					//IN052940 Start.
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','0','','"+selection_type+"');</script>");
					//IN063931 start
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','0','','"+selection_type+"','"+previousNote_accession_num+"');</script>");
					out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','0','','"+selection_type+"','"+previousNote_accession_num+"','"+call_for_copy_previous_sec+"','"+call_for_copy_previous_note+"');</script>");
					//IN063931 ends
					//IN052940 End.
					}	
			
					//out.println("<script>alert('sec_hdg_code   :   "+sec_hdg_code+"');</script>");
				}
			} while(rs.next());
		}else{
		//IN063931 ends
			if(isFirst && operation_mode.equals(""))
			{			
				doc_exists									=	checkForNull(rs.getString("DOC_EXISTS"));
				sec_hdg_code								=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc								=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type						=	checkForNull( rs.getString("sec_content_type") );
				sec_result_linked_rec_type		=	checkForNull( rs.getString("sec_result_linked_rec_type") );
				child_sec_hdg_code					=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_hdg_desc					=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_content_type				=	checkForNull( rs.getString("child_sec_content_type") );
				child_sec_result_link_rec_type	=	checkForNull( rs.getString("child_sec_result_link_rec_type") );
				chief_complaint_sec_yn				=   checkForNull( rs.getString("chief_complaint_sec_yn") );
				image_linked_yn						=   checkForNull( rs.getString("image_linked_yn") );
				strContentEditableYn					=	checkForNull( rs.getString("CONTENT_EDITABLE_YN") );
				content_type								=	checkForNull( rs.getString("content_type") );
				result_link_type							=	checkForNull( rs.getString("result_link_type") );
				output_form_exists_yn				=	rs.getString("OUTPUT_FORM_EXISTS_YN") ;
				result_link_yn								=	"N";
				selection_type							= rs.getString("SELECTION_TYPE")==null?"S":rs.getString("SELECTION_TYPE"); 	
			
				if(strContentEditableYn == null || strContentEditableYn.equals("") )
					strContentEditableYn = "Y";	

				if(content_type.equals("R"))
				{
					content_type = "F";
					result_link_yn = "Y";
				}		
			
				if(sec_content_type.equals("S")){
					//IN052940 Start.
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','"+cnt+"','0','"+output_form_exists_yn+"');</script>");				
					//IN063931 start
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','"+cnt+"','0','"+output_form_exists_yn+"','"+previousNote_accession_num+"');</script>");
					//IN052940 End.
					out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','"+cnt+"','0','"+output_form_exists_yn+"','"+previousNote_accession_num+"','"+call_for_copy_previous_sec+"','"+call_for_copy_previous_note+"');</script>");
					//IN063931 ends
				}else{
					//IN052940 Start.
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','0','','"+selection_type+"');</script>");
					//IN063931 start
					//out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','0','','"+selection_type+"','"+previousNote_accession_num+"');</script>");
					out.println("<script>loadFirstSectionDetails('tblrow_id0','"+sec_hdg_code+"','"+child_sec_hdg_code+"','"+sec_hdg_desc+"','"+child_sec_hdg_desc+"','"+image_linked_yn+"','"+result_link_yn+"','"+operation_mode+"','"+content_type+"','"+chief_complaint_sec_yn+"','"+result_link_type+"','"+sec_content_type+"','0','','"+selection_type+"','"+previousNote_accession_num+"','"+call_for_copy_previous_sec+"','"+call_for_copy_previous_note+"');</script>");
					//IN063931 ends
					//IN052940 End.
					}
				
					//out.println("<script>alert('sec_hdg_code   :   "+sec_hdg_code+"');</script>");
				}
		
			}
//IN068105
if(noteCopiedYN.equals("Y")){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(noteCopiedYN));
            _bw.write(_wl_block77Bytes, _wl_block77);

}
//IN068105
	//end.
	}
	catch(Exception e)
	{
		//out.println("Exception@2: "+e);
		
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block78Bytes, _wl_block78);
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(cnt_ofMainSections));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(ids_of_mainSections));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(cntSec));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(image_linked_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_link_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(content_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chief_complaint_sec_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_link_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_content_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(output_form_exists_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NotesView.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AddendumToNote.label", java.lang.String .class,"key"));
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
}
