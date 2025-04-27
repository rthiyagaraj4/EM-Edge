package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkbirthdetailsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkBirthDetailsMain.jsp", 1709116141357L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<!-- added by Kishore Kumar N on 10/12/2008  -->\n\t\t\n\t\t<!-- end here -->\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/RecClinicalNotesLinkBirthDetail.js\">\n\t    </script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\t//alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body onScroll=\"scrollTitle()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<form name=\"RecClinicalNotesLinkBornResultForm\" id=\"RecClinicalNotesLinkBornResultForm\">\t\n\t<!-- <div id=\'divDataTitle\' style=\'postion:relative\'>\n\t<table border=\"1\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t<tr >\n\t\t\t<td width=\'100%\' class=\'CAGROUP\' align=center><b><font size=\'2\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t</tr>\n\t\t<tr><td class=\'columnheader\' width=\"8%\" style=\"font-size:10\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<input type=\'checkbox\' name=\'ctrlChkBox\' id=\'ctrlChkBox\' onClick=\"javascript:perform(this);\" ></td>\n\t\t</tr>\n\t</table>\n\t</div> -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t<table class=\"grid\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<tr><td class=\"CAHIGHERLEVELCOLOR\" width=\'30%\' colspan=2><input type=\'checkbox\' name=\'motherChkBox\' id=\'motherChkBox\' onClick=\"javascript:perform(this);\" >&nbsp; ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td></tr>\n         \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" width=\'30%\' nowrap><input type=\"checkbox\" name=\"M";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"M";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onclick=\"Add(this);remove(this)\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td><td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B><input type=hidden name=\'LM";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'LM";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'></td></tr>\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'></td></tr>\n\t\t \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'></td></tr>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<tr><td class=\"CAHIGHERLEVELCOLOR\"  colspan=2><input type=\'checkbox\' name=\'fatherChkBox\' id=\'fatherChkBox\' onClick=\"javascript:perform(this);\" >&nbsp; ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" width=\'30%\' nowrap><input type=\"checkbox\" name=\"F";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"F";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</B><input type=hidden name=\'LF";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'LF";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'></td></tr>\n\t\t\t \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<tr><td class=\"CAHIGHERLEVELCOLOR\" colspan=2><input type=\"hidden\" name=\"B";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"B";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"\"><input type=\'checkbox\' name=\'babyChkBox";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'babyChkBox";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\"javascript:perform(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\" >&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" (";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" / ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =")</td><input type=hidden name=\'LB";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'LB";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" nowrap colspan=\'2\'><input type=\"checkbox\" name=\"demoChkBox";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"demoChkBox";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"  onclick=\"javascript:perform(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');\"><b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</b></td></tr>\n\n\t\t\t\t\t<tr><td colspan=\'2\'><table class=\'grid\' align=\'center\' width=\'100%\'>\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" width=\'30%\' nowrap><input type=\"checkbox\" name=\"D";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"D";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onclick=\"Add(this,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');remove(this,\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</B><input type=hidden name=\'LD";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'LD";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'></td></tr>\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"bdcount";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"bdcount";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t</table></td></tr>\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" nowrap colspan=\'2\'><input type=\"checkbox\" name=\"clinicalChkBox";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"clinicalChkBox";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</b></td></tr>\n\n\t\t\t\t\t<tr><td colspan=\'2\'><table class=\'grid\' align=\'center\' width=\'100%\'>\n\t\t \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" width=\'30%\' nowrap><input type=\"checkbox\" name=\"C";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"C";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</B><input type=hidden name=\'LC";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'LC";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'></td></tr>\n         \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'></td></tr> \n\t\t \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'></td></tr>\n\n\t\t\t\t\t<input type=\"hidden\" name=\"bccount";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"bccount";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" nowrap colspan=\'2\'><input type=\"checkbox\" name=\"vaccineChkBox";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"vaccineChkBox";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" onclick=\"javascript:perform(this,\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</b></td></tr>\n\t\t\t\t\t<tr><td colspan=\'2\'><table class=\'grid\' align=\'center\' width=\'100%\'>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" width=\'30%\' nowrap><input type=\"checkbox\" name=\"V";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"V";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"  value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</B><input type=hidden name=\'LV";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'LV";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'></td></tr>\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'></td></tr>\n\t\t ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\')\" >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"vcount";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"vcount";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t</table></td></tr>\n\t\t\t\t\t\n\t\t\t\t\t<!-- <tr><td class=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >Vaccine</td><td class=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >Administered Date</td><td class=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >Administered By</td><td class=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >Designation</td><td class=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" >Site</td></tr>\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" nowrap><input type=\"checkbox\" name=\"V";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">&nbsp;<B>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' value=\'Vaccin BCG\'><input type=hidden name=\'LBI";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'LBI";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'></td><td class=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >&nbsp;</td><td class=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >&nbsp;</td></tr>\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\')\">Vitamin</td><td class=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' value=\'Vaccin Vitamin\'><input type=hidden name=\'LBI";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\')\" >Hepatitis</td><td class=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' value=\'Vaccin Hepatitis\'><input type=hidden name=\'LBI";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >&nbsp;</td></tr> -->\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" nowrap colspan=\'2\'><input type=\"checkbox\" name=\"apgarChkBox";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"apgarChkBox";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" width=\'30%\' nowrap><input type=\"checkbox\" name=\"A";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"A";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\">Apgarscore in 1 mins</td><td class=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</B><input type=hidden name=\'LA";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\'LA";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' value=\'Apgarscore in 1 mins\'></td></tr>\n\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\')\">Apgarscore in 5 mins</td><td class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' value=\'Apgarscore in 5 mins\'></td></tr>\n\t\t \n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\')\">Apgarscore in 10 mins</td><td class=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' value=\'Apgarscore in 10 mins\'></td></tr>\n\t\t \n\t\t\t\t\t<input type=\"hidden\" name=\"bacount";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"bacount";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t\t</table></td></tr>\n\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t<tr><td class=\"CAHIGHERLEVELCOLOR\" width=\'30%\' colspan=2><input type=\'checkbox\' name=\'motherChkBox\' id=\'motherChkBox\' onClick=\"javascript:perform(this);\" >&nbsp; ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td></tr>\n \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'></td></tr>\n\n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'></td></tr>\n \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t<tr><td class=\"CAHIGHERLEVELCOLOR\"  colspan=2><input type=\'checkbox\' name=\'fatherChkBox\' id=\'fatherChkBox\' onClick=\"javascript:perform(this);\" >&nbsp; ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'></td></tr>\n\t \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t<tr><td class=\"CAHIGHERLEVELCOLOR\" colspan=2><input type=\"hidden\" name=\"B";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\t \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</b></td></tr>\n\n\t\t\t<tr><td colspan=\'2\'><table class=\'grid\' align=\'center\' width=\'100%\'>\n\n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'></td></tr>\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"bdcount";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t\t</table></td></tr>\n\n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</b></td></tr>\n\n\t\t\t<tr><td colspan=\'2\'><table class=\'grid\' align=\'center\' width=\'100%\'>\n \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'></td></tr> \n \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'></td></tr>\n\n\t\t\t<input type=\"hidden\" name=\"bccount";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</b></td></tr>\n\t\t\t<tr><td colspan=\'2\'><table class=\'grid\' align=\'center\' width=\'100%\'>\n\t\t\n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'></td></tr>\n\t\t\n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'></td></tr>\n\t\t \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'></td></tr>\n\t\t\n\t\t\t<input type=\"hidden\" name=\"vcount";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' value=\'Apgarscore in 1 mins\'></td></tr>\n\n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' value=\'Apgarscore in 5 mins\'></td></tr>\n \n\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' value=\'Apgarscore in 10 mins\'></td></tr>\n \n\t\t\t<input type=\"hidden\" name=\"bacount";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t</table></td></tr>\n\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t</table>\t\t\n\t<input type=\"hidden\" name=\"mcount\" id=\"mcount\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t<input type=\"hidden\" name=\"bcount\" id=\"bcount\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t<input type=\"hidden\" name=\"kcount\" id=\"kcount\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t<input type=\"hidden\" name=\"fcount\" id=\"fcount\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\"hidden\" name=\"babycount\" id=\"babycount\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\"hidden\" name=\"noofbirths\" id=\"noofbirths\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t<input type=\"hidden\" name=\"seltext\" id=\"seltext\" value=\"\">\n\t<input type=\"hidden\" name=\"return_format\" id=\"return_format\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t<input type=\"hidden\" name=\"check\" id=\"check\" value=\"\">\n\t<input type=\"hidden\" name=\"order\" id=\"order\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t<input type=\"hidden\" name=\"mother_encounter_id\" id=\"mother_encounter_id\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t<input type=\"hidden\" name=\"mother_yn\" id=\"mother_yn\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\n</form>\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet BornBean= null;synchronized(session){
                BornBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BornBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BornBean==null){
                    BornBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BornBean",BornBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");

	String gestational_period= "";
	String delivery_type= "";
	String gravida= "";
	String complications= "";
	String delyinddesc= "";
//	String remarks= "";
	String nb_sex= "";
	String relationship= "";
	String outcome= "";
	String parity= "";
	String indicator_mark= "";
	String lengthof= "";
	String weight= "";
	String bornat= "";
	String birthplace_desc= "";
	String bornwhere= "";
	String birthcertificateno= "";
	String nbbirthdate= "";
	String headcircumference= "";
	String chestcircumference= "";
	String apgarscorein1mins= "";
	String apgarscorein5mins= "";
	String apgarscorein10mins= "";
	String umbilicalcordstatus= "";
	String feedingdesc= "";
	String feeding= "";
	String patencyofanusyn= "";
	String stools= "";
	String stools1= "";
	String vaginaldelytypedesc = "";
	String procclassific = "";
	String surgicalclassify = "";
	String noofbirths = "";
	String conganomdesc = "";
	String umbcordcutby = "";
	String bcg_admin_dtls = "";
	String vitak_admin_dtls  = "";
	String hepB_admin_dtls  = "";
	String UNIT_OF_WT_NB="";
	String UNIT_OF_WT_NB_s="";
	String UNIT_OF_WT_NB_m="";
	String UNIT_OF_CIRCUM_NB="";
	String UNIT_OF_CIRCUM_NB_s="";
	String UNIT_OF_CIRCUM_NB_m="";
	String UNIT_OF_CHEST_CIRCUM_NB="";
	String UNIT_OF_CHEST_CIRCUM_NB_s="";
	String UNIT_OF_CHEST_CIRCUM_NB_m="";
	String UNIT_OF_LENGTH_NB="";
	String UNIT_OF_LENGTH_NB_s="";
	String UNIT_OF_LENGTH_NB_m="";
	String UNIT_OF_GEST_NB="";
	String UNIT_OF_GEST_NB_s="";
	String UNIT_OF_GEST_NB_m="";
	String father_patient_name = "", father_nat_desc = "", race_desc = "", father_gove_employee_yn ="", ocpn_class_desc = "";
	String ocpn_desc = "", relgn_desc = "", father_remarks = "";
	String nb_born_id = "", nb_born_name = "";
	String  multiple_birth_yn = "", compln_pregnancy_desc = "";
	String blood_grp = "", compln_nr_pregnancy_desc = "";
	String attend_physician_id = "", attend_midwife_id = "";
	String complns_1st_desc = "", complns_2nd_desc = "", complns_3rd_desc = "";
	String order = "";
	String gestational_period_in_days = "";
	String mother_yn = "";

	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
	String col_field ="";
	PreparedStatement pstmt=null;
	ResultSet rset=null;

	StringBuffer strsql1 = new StringBuffer(" ");
	StringBuffer countsql = new StringBuffer(" ");
	StringBuffer montherCountsql = new StringBuffer(" ");
	StringBuffer monthersql = new StringBuffer(" ");
	StringBuffer fathersql = new StringBuffer(" ");
	StringBuffer babysql = new StringBuffer(" ");

	String mother_encounter_id	= request.getParameter("mother_encounter_id")==null?"":request.getParameter("mother_encounter_id");
	String patient_id	= java.net.URLDecoder.decode(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String facility_id = (String)session.getValue("facility_id");
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try
	{
		con =  ConnectionManager.getConnection(request);
	  
		//shaiju new diag starts
	  
		categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
				if(order.equals(""))
					order = field_ref;
				else
					order = order + "~"+ field_ref;
			}
			while(rset.next());
		}
		else
		{
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
					if(order.equals(""))
						order = field_ref;
					else
						order = order + "~"+ field_ref;
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();
			}
		}

	  //shaiju new diag ends
	  
		stmt = con.prepareStatement("select UNIT_OF_WT_NB,UNIT_OF_CIRCUM_NB,UNIT_OF_CHEST_CIRCUM_NB,UNIT_OF_LENGTH_NB,UNIT_OF_GEST_NB from mp_param");
		rs = stmt.executeQuery();
		if(rs != null && rs.next())
		{
			//UNIT_OF_WT_NB = rs.getString(1);
			UNIT_OF_GEST_NB = rs.getString(1) == null ? "" : rs.getString(1); //Handled for Null Pointer Exception
			if(UNIT_OF_WT_NB.equalsIgnoreCase("K"))
			{
				UNIT_OF_WT_NB_s = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				UNIT_OF_WT_NB_m = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
			}
			else if(UNIT_OF_WT_NB.equalsIgnoreCase("L"))
			{
				UNIT_OF_WT_NB_s = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				UNIT_OF_WT_NB_m = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lbs.label","common_labels");
			}
			//UNIT_OF_CIRCUM_NB = rs.getString(2);
			UNIT_OF_GEST_NB = rs.getString(2) == null ? "" : rs.getString(2); //Handled for Null Pointer Exception
			if(UNIT_OF_CIRCUM_NB.equalsIgnoreCase("I"))
			{
				UNIT_OF_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inch.label","common_labels");
				UNIT_OF_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Inchs.label","ca_labels");
			}
			else if(UNIT_OF_CIRCUM_NB.equalsIgnoreCase("C"))
			{
				UNIT_OF_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cm.label","common_labels");
				UNIT_OF_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cms.label","common_labels");
			}

			//UNIT_OF_CHEST_CIRCUM_NB = rs.getString(3);
			UNIT_OF_GEST_NB = rs.getString(3) == null ? "" : rs.getString(3); //Handled for Null Pointer Exception
			if(UNIT_OF_CHEST_CIRCUM_NB.equalsIgnoreCase("I"))
			{
				UNIT_OF_CHEST_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inch.label","common_labels");
				UNIT_OF_CHEST_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Inchs.label","ca_labels");
			}
			else if(UNIT_OF_CHEST_CIRCUM_NB.equalsIgnoreCase("C"))
			{
				UNIT_OF_CHEST_CIRCUM_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cm.label","common_labels");
				UNIT_OF_CHEST_CIRCUM_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cms.label","common_labels");
			}

			//UNIT_OF_LENGTH_NB = rs.getString(4);
			UNIT_OF_GEST_NB = rs.getString(4) == null ? "" : rs.getString(4); //Handled for Null Pointer Exception
			if(UNIT_OF_LENGTH_NB.equalsIgnoreCase("I"))
			{
				UNIT_OF_LENGTH_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inch.label","common_labels");
				UNIT_OF_LENGTH_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Inchs.label","ca_labels");
			}
			else if(UNIT_OF_LENGTH_NB.equalsIgnoreCase("C"))
			{
				UNIT_OF_LENGTH_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cm.label","common_labels");
				UNIT_OF_LENGTH_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Cms.label","common_labels");
			}

			//UNIT_OF_GEST_NB = rs.getString(5);
			UNIT_OF_GEST_NB = rs.getString(5) == null ? "" : rs.getString(5); //Handled for Null Pointer Exception
			if(UNIT_OF_GEST_NB.equalsIgnoreCase("W"))
			{
				UNIT_OF_GEST_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Week.label","common_labels");
				UNIT_OF_GEST_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
			}
			else if(UNIT_OF_GEST_NB.equalsIgnoreCase("D"))
			{
				UNIT_OF_GEST_NB_s=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels");
				UNIT_OF_GEST_NB_m=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			}
		}
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in RecClinicalNotesLinkBirthMain.jsp" + e);//common-icn-0181
	}
	
	/* check for baby patient count*/
	countsql.append("SELECT COUNT(*) as total FROM mp_birth_register_vw where patient_id = ? ");
	/* check for Mother patient count*/
	montherCountsql.append("SELECT COUNT(*) as total FROM MP_BIRTH_REGISTER A  WHERE MOTHER_PATIENT_ID = ?  and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ?  /*AND TRUNC(TIME_OF_BIRTH)>   (SELECT MAX(TRUNC(TIME_OF_BIRTH))-1 FROM MP_BIRTH_REGISTER  WHERE MOTHER_PATIENT_ID = A.MOTHER_PATIENT_ID AND MONTHS_BETWEEN(SYSDATE,TIME_OF_BIRTH)<=12)*/  ");
	/*
	strsql1.append("select no_of_births noofBirths,gestational_period,parity,delivery_type,gravida,parity,(select long_desc from MP_COMPLN_DELIVERY where COMPLN_DELY_CODE=a.COMPLN_DELY_CODE) complications,DELY_IND_DESC,(select short_desc from mp_proc_classification where proc_class_code = a.PROC_CLASS_CODE) procclassific,VAGINAL_DELY_TYPE_DESC,(select short_desc from mp_dely_surg_classification where dely_surg_class_code = a.DELY_SURG_CLASS_CODE) surgicalclassify,remarks,nb_sex,(SELECT short_desc FROM MP_RELATIONSHIP WHERE RELATIONSHIP_CODE = (SELECT decode(upper(substr(nb_sex,1,1)),'M',NB_MALE_RELNSHIP,'F',NB_FEMALE_RELNSHIP ,NB_UNKNOWN_RELNSHIP) FROM MP_PARAM)) relationship,outcome,indicator_mark,nb_birth_date||' '||NB_BIRTH_TIME nb_birth_date,BIRTH_CERTIFICATE_NO,born_where,birth_place_desc,born_at,weight,length,head_circumference,chest_circumference,APGAR_SCORE_IN_1_MIN,apgar_score_in_5_mins,apgar_score_in_10_mins,umbilical_cord_status,(select short_name from am_practitioner where practitioner_id=UMB_CORD_CUT_BY) UMB_CORD_CUT_BY,decode(feeding,'T','Breast','B','Bottle','Other') feeding_desc,patency_of_anus_yn,CONG_ANOM_DESC,decode(stools,'M','Meconium','Y','Yellow Soft','Other' ) stools ");
	
	strsql1.append(",nvl2(VACCINATION_SITE,'Site:'||VACCINATION_SITE,null)||nvl2(ADMINISTERED_BY,';  Administered By:'||ADMINISTERED_BY||','||ADMINISTERED_DESIGNATION,null)||nvl2(BCG_VACC_ADMN_DATE, '  on'||to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) bcg_admin_dtls,nvl2(Vitak_vacc_site,'Site:'||Vitak_vacc_site,null) ||nvl2(Vitak_administered_by,';  Administered By:'||Vitak_administered_by||','||Vitak_administered_desig,null)||nvl2(VITK_VACC_ADMN_DATE, '  on '||to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) Vitak_admin_dtls,nvl2(HEPB_VACC_SITE,'Site:'||HEPB_VACC_SITE,null)  ||nvl2(HEPB_ADMINISTERED_BY,';  Administered By:'||HEPB_ADMINISTERED_BY||','||HEPB_ADMINISTERED_DESIG,null) 						 ||nvl2(HEPB_VACC_ADMN_DATE, '  on '||to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) HepB_admin_dtls  ");
	*/

	monthersql.append("select no_of_births noofBirths,gestational_period,GESTATIONAL_PERIOD_IN_DAYS,parity,delivery_type,gravida,parity,MP_GET_DESC.MP_COMPLN_DELIVERY(a.COMPLN_DELY_CODE,?,'2') complications,DELY_IND_DESC,MP_GET_DESC.MP_PROC_CLASSIFICATION(a.PROC_CLASS_CODE,?,'2') procclassific, VAGINAL_DELY_TYPE_DESC,MP_GET_DESC.MP_DELY_SURG_CLFN(a.DELY_SURG_CLASS_CODE,?,'2') surgicalclassify, MULTIPLE_BIRTH_YN, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_DESC, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PHYSICIAN_ID,?,'1') ATTEND_PHYSICIAN_ID, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_MIDWIFE_ID,?,'1') ATTEND_MIDWIFE_ID, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_1ST_STAGE_LABOUR_CODE and language_id = ?) complns_1st_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_2ND_STAGE_LABOUR_CODE and language_id = ?) complns_2nd_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_3RD_STAGE_LABOUR_CODE and language_id = ?) complns_3rd_desc from mp_birth_register_vw a ");

	fathersql.append("select FATHER_PATIENT_NAME, FATHER_NAT_DESC, ETH_GRP_DESC RACE_DESC, FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC, nvl(OCPN_DESC,FATHER_OCPN_DESC) OCPN_DESC, RELGN_DESC, FATHER_REMARKS from mp_birth_register_vw a ");

	babysql.append("select nb_sex,(SELECT short_desc FROM MP_RELATIONSHIP_LANG_VW WHERE LANGUAGE_ID = ?  AND RELATIONSHIP_CODE = (SELECT decode(upper(substr(nb_sex,1,1)),'M',NB_MALE_RELNSHIP,'F',NB_FEMALE_RELNSHIP ,NB_UNKNOWN_RELNSHIP) FROM MP_PARAM)) relationship,outcome,indicator_mark,nb_birth_date||' '||NB_BIRTH_TIME nb_birth_date,BIRTH_CERTIFICATE_NO,born_where,birth_place_desc,born_at,weight,length,head_circumference,chest_circumference,APGAR_SCORE_IN_1_MIN,apgar_score_in_5_mins,apgar_score_in_10_mins,umbilical_cord_status,nvl(AM_GET_DESC.AM_PRACTITIONER(UMB_CORD_CUT_BY,?,'1'),UMB_CORD_CUT_BY) UMB_CORD_CUT_BY,feeding feeding_desc,patency_of_anus_yn,CONG_ANOM_DESC, stools, a.patient_id, NB_PATIENT_NAME, nvl2(VACCINATION_SITE,'Site: '||VACCINATION_SITE||';',null)||nvl2(ADMINISTERED_BY,'&nbsp; Administered By: '||ADMINISTERED_BY||';',null)||nvl2(ADMINISTERED_DESIGNATION,'&nbsp; Designation: '||ADMINISTERED_DESIGNATION||';',null)||nvl2(BCG_VACC_ADMN_DATE, '&nbsp; Administered Date: '||to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi')||';',null) bcg_admin_dtls, nvl2(Vitak_vacc_site,'Site: '||Vitak_vacc_site||';',null) ||nvl2(Vitak_administered_by,'&nbsp; Administered By: '||Vitak_administered_by||';',null)||nvl2(Vitak_administered_desig,'&nbsp; Designation: '||Vitak_administered_desig||';',null)||nvl2(VITK_VACC_ADMN_DATE, '&nbsp; Administered Date: '||to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi')||';',null)Vitak_admin_dtls, nvl2(HEPB_VACC_SITE,'Site: '||HEPB_VACC_SITE||';',null)  ||nvl2(HEPB_ADMINISTERED_BY,'&nbsp; Administered By: '||HEPB_ADMINISTERED_BY||';',null)||nvl2(HEPB_ADMINISTERED_DESIG,'&nbsp; Designation: '||HEPB_ADMINISTERED_DESIG||';',null)||nvl2(HEPB_VACC_ADMN_DATE, '&nbsp; Administered Date: '||to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi')||';',null) HepB_admin_dtls, (select short_desc from mr_blood_grp_lang_vw where blood_grp = b.BLOOD_GRP and language_id = ?) BLOOD_GRP from mp_birth_register_vw a, MP_PAT_OTH_DTLS b ");

	//strsql1.append("select no_of_births noofBirths,gestational_period,parity,delivery_type,gravida,parity,MP_GET_DESC.MP_COMPLN_DELIVERY(a.COMPLN_DELY_CODE,?,'1') complications,DELY_IND_DESC,MP_GET_DESC.MP_PROC_CLASSIFICATION(a.PROC_CLASS_CODE,?,'2') procclassific, VAGINAL_DELY_TYPE_DESC,MP_GET_DESC.MP_DELY_SURG_CLFN(a.DELY_SURG_CLASS_CODE,?,'2') surgicalclassify,remarks,nb_sex,(SELECT short_desc FROM MP_RELATIONSHIP_LANG_VW WHERE LANGUAGE_ID = ?  AND RELATIONSHIP_CODE = (SELECT decode(upper(substr(nb_sex,1,1)),'M',NB_MALE_RELNSHIP,'F',NB_FEMALE_RELNSHIP ,NB_UNKNOWN_RELNSHIP) FROM MP_PARAM)) relationship,outcome,indicator_mark,nb_birth_date||' '||NB_BIRTH_TIME nb_birth_date,BIRTH_CERTIFICATE_NO,born_where,birth_place_desc,born_at,weight,length,head_circumference,chest_circumference,APGAR_SCORE_IN_1_MIN,apgar_score_in_5_mins,apgar_score_in_10_mins,umbilical_cord_status,AM_GET_DESC.AM_PRACTITIONER(UMB_CORD_CUT_BY,?,'2') UMB_CORD_CUT_BY,feeding feeding_desc,patency_of_anus_yn,CONG_ANOM_DESC, stools, a.patient_id, NB_PATIENT_NAME, MULTIPLE_BIRTH_YN, COMPLN_PREGNANCY_DESC, b.BLOOD_GRP, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PHYSICIAN_ID,?,'2') ATTEND_PHYSICIAN_ID, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_MIDWIFE_ID,?,'2') ATTEND_MIDWIFE_ID ");

	//strsql1.append(" ,(select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_1ST_STAGE_LABOUR_CODE) complns_1st_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_2ND_STAGE_LABOUR_CODE) complns_2nd_desc, (select SHORT_DESC from mp_compln_delivery_lang_vw where  COMPLN_DELY_CODE = a.COMPLNS_3RD_STAGE_LABOUR_CODE) complns_3rd_desc,FATHER_PATIENT_NAME, FATHER_NAT_DESC, RACE_DESC, FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC, OCPN_DESC, RELGN_DESC, FATHER_REMARKS");

	//strsql1.append(",nvl2(VACCINATION_SITE,'Site:'||VACCINATION_SITE,null)||nvl2(ADMINISTERED_BY,';  Administered By:'||ADMINISTERED_BY||','||ADMINISTERED_DESIGNATION,null)||nvl2(BCG_VACC_ADMN_DATE, '  on'||to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) bcg_admin_dtls,nvl2(Vitak_vacc_site,'Site:'||Vitak_vacc_site,null) ||nvl2(Vitak_administered_by,';  Administered By:'||Vitak_administered_by||','||Vitak_administered_desig,null)||nvl2(VITK_VACC_ADMN_DATE, '  on '||to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) Vitak_admin_dtls,nvl2(HEPB_VACC_SITE,'Site:'||HEPB_VACC_SITE,null)  ||nvl2(HEPB_ADMINISTERED_BY,';  Administered By:'||HEPB_ADMINISTERED_BY||','||HEPB_ADMINISTERED_DESIG,null) 						 ||nvl2(HEPB_VACC_ADMN_DATE, '  on '||to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi'),null) HepB_admin_dtls  ");

    //strsql1.append("from mp_birth_register_vw a "); 
	
	int j=0;
	int m=0;
	int i=1;
	int k=0;
	int lm=0;
//	int lb=0;
	int b=0;
	int f=0;
	int lf=0;
	int bd=0,  lbd=0;
	int bc=0,  lbc=0;
	int v=0,  lv=0;
	int ba=0,  lba=0;
	int maxRecord =0;
//	boolean flag = true;
	
   	try
	{
		stmt = con.prepareStatement(countsql.toString());
	   
		int st = 0;
		stmt.setString(++st,patient_id); 
		rs = stmt.executeQuery();

		if(rs!=null && rs.next())
		{
			maxRecord = rs.getInt("total");
		}
     
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();
		
 		if (maxRecord > 0)
		  strsql1.append(" where a.patient_id = ? and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ? ");
		else if (maxRecord == 0)
		{
			stmt = con.prepareStatement(montherCountsql.toString());
			stmt.setString(1,patient_id); 
			stmt.setString(2,mother_encounter_id);
			stmt.setString(3,facility_id);
			rs = stmt.executeQuery();

			if(rs!=null && rs.next())
			{
				maxRecord = rs.getInt("total");
				mother_yn = "Y";
			}
		 
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if (maxRecord == 0)
			{
				strsql1.append(" where a.patient_id = ? and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ? ");
	
            _bw.write(_wl_block8Bytes, _wl_block8);

			}	
		    else
			{
				strsql1.append(" WHERE MOTHER_PATIENT_ID=?  and MOTHER_ENCOUNTER_ID = ? and ENCOUNTER_FACILITY_ID = ? /*AND to_date(NB_BIRTH_DATE,'dd/mm/yyyy')>   (SELECT MAX(TRUNC(TIME_OF_BIRTH))-1 FROM MP_BIRTH_REGISTER  WHERE MOTHER_PATIENT_ID=a.MOTHER_PATIENT_ID AND MONTHS_BETWEEN(SYSDATE,TIME_OF_BIRTH)<=12)*/  ");
			}
		}
		
		/*st = 0;
		stmt = con.prepareStatement(strsql1.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
        
		rs = stmt.executeQuery();*/
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(maxRecord == 0)
	{

            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else
	{

            _bw.write(_wl_block13Bytes, _wl_block13);
 
	String classValue = "gridData";

	/*while(rs!=null && rs.next() )
	{
		gestational_period=rs.getString("gestational_period") == null ? " " : rs.getString("gestational_period");
		delivery_type=rs.getString("delivery_type") == null ? " " : rs.getString("delivery_type");
		noofbirths=rs.getString("noofBirths") == null ? " " : rs.getString("noofBirths");
		procclassific=rs.getString("procclassific")==null?" ":rs.getString("procclassific");
		vaginaldelytypedesc=rs.getString("vaginal_dely_type_desc")==null?" ":rs.getString("vaginal_dely_type_desc");
		surgicalclassify=rs.getString("surgicalclassify")==null?" ":rs.getString("surgicalclassify");
		gravida=rs.getString("gravida")==null?" ":rs.getString("gravida");
		complications=rs.getString("complications")==null?" ":rs.getString("complications");
		delyinddesc=rs.getString("DELY_IND_DESC")==null?" ":rs.getString("DELY_IND_DESC");
		parity=rs.getString("parity")==null?" ":rs.getString("parity");
		remarks=rs.getString("remarks")==null?" ":rs.getString("remarks");
		
		nb_sex=rs.getString("nb_sex")==null?" ":rs.getString("nb_sex");
		relationship=rs.getString("relationship")==null?" ":rs.getString("relationship");
		outcome=rs.getString("outcome")==null?" ":rs.getString("outcome");
		indicator_mark=rs.getString("indicator_mark")==null?" ":rs.getString("indicator_mark");
		lengthof=rs.getString("length")==null?" ":rs.getString("length");
		weight=rs.getString("weight")==null?" ":rs.getString("weight");
		bornat=rs.getString("born_at")==null?" ":rs.getString("born_at");
		birthplace_desc=rs.getString("birth_place_desc")==null?" ":rs.getString("birth_place_desc");
		bornwhere=rs.getString("born_where")==null?" ":rs.getString("born_where");
		birthcertificateno=rs.getString("BIRTH_CERTIFICATE_NO")==null?" ":rs.getString("BIRTH_CERTIFICATE_NO");
		nbbirthdate=rs.getString("nb_birth_date")==null?" ":rs.getString("nb_birth_date");
		headcircumference=rs.getString("head_circumference")==null?" ":rs.getString("head_circumference");
		chestcircumference=rs.getString("chest_circumference")==null?" ":rs.getString("chest_circumference");
		apgarscorein1mins=rs.getString("apgar_score_in_1_min")==null?" ":rs.getString("apgar_score_in_1_min");
		apgarscorein5mins=rs.getString("apgar_score_in_5_mins")==null?" ":rs.getString("apgar_score_in_5_mins");
		apgarscorein10mins=rs.getString("apgar_score_in_10_mins")==null?" ":rs.getString("apgar_score_in_10_mins");
		umbilicalcordstatus=rs.getString("umbilical_cord_status")==null?" ":rs.getString("umbilical_cord_status");
		umbcordcutby=rs.getString("UMB_CORD_CUT_BY")==null?" ":rs.getString("UMB_CORD_CUT_BY");
		conganomdesc=rs.getString("CONG_ANOM_DESC")==null?" ":rs.getString("CONG_ANOM_DESC");
		feeding = rs.getString("feeding_desc")==null?" ":rs.getString("feeding_desc");
		patencyofanusyn=rs.getString("patency_of_anus_yn")==null?" ":rs.getString("patency_of_anus_yn");
		stools1 = rs.getString("stools")==null?" ":rs.getString("stools");
		bcg_admin_dtls=rs.getString("bcg_admin_dtls")==null?"":rs.getString("bcg_admin_dtls");
		vitak_admin_dtls=rs.getString("Vitak_admin_dtls")==null?"":rs.getString("Vitak_admin_dtls");
		hepB_admin_dtls=rs.getString("HepB_admin_dtls")==null?"":rs.getString("HepB_admin_dtls");

		nb_born_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
		nb_born_name = rs.getString("NB_PATIENT_NAME")==null?"":rs.getString("NB_PATIENT_NAME");
		multiple_birth_yn = rs.getString("MULTIPLE_BIRTH_YN")==null?"":rs.getString("MULTIPLE_BIRTH_YN");
		compln_pregnancy_desc = rs.getString("COMPLN_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_PREGNANCY_DESC");
		blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");
		attend_physician_id = rs.getString("ATTEND_PHYSICIAN_ID")==null?"":rs.getString("ATTEND_PHYSICIAN_ID");
		attend_midwife_id = rs.getString("ATTEND_MIDWIFE_ID")==null?"":rs.getString("ATTEND_MIDWIFE_ID");
		complns_1st_desc = rs.getString("complns_1st_desc")==null?"":rs.getString("complns_1st_desc");
		complns_2nd_desc = rs.getString("complns_2nd_desc")==null?"":rs.getString("complns_2nd_desc");
		complns_3rd_desc = rs.getString("complns_3rd_desc")==null?"":rs.getString("complns_3rd_desc");

		if(feeding.equals("T"))
			feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Breast.label","mp_labels");
		else if(feeding.equals("B"))
			feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Bottle.label","mp_labels");
		else 
			feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");	 

		if(stools1.equals("M"))
			stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Meconium.label","mp_labels");
		else if(stools1.equals("Y"))
			stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.YellowSoft.label","mp_labels");
		else 
			stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");	 
		
		father_patient_name = rs.getString("FATHER_PATIENT_NAME") == null ? "" : rs.getString("FATHER_PATIENT_NAME");
		father_nat_desc = rs.getString("FATHER_NAT_DESC") == null ? "" : rs.getString("FATHER_NAT_DESC");
		race_desc = rs.getString("RACE_DESC") == null ? "" : rs.getString("RACE_DESC");
		father_gove_employee_yn = rs.getString("FATHER_GOVE_EMPLOYEE_YN") == null ? "" : rs.getString("FATHER_GOVE_EMPLOYEE_YN");
		ocpn_class_desc = rs.getString("OCPN_CLASS_DESC") == null ? "" : rs.getString("OCPN_CLASS_DESC");
		ocpn_desc = rs.getString("OCPN_DESC") == null ? "" : rs.getString("OCPN_DESC");
		relgn_desc = rs.getString("RELGN_DESC") == null ? "" : rs.getString("RELGN_DESC");
		father_remarks = rs.getString("FATHER_REMARKS") == null ? "" : rs.getString("FATHER_REMARKS");*/
		 
	if(fields.size()>0)
	{
		for(int l=0;l<fields.size();++l)
		{
			col_field = (String)fields.get(l);
			if(col_field.equals("MOTHERDETAIL"))
			{
				monthersql.append(strsql1.toString());
				st = 0;
				stmt = con.prepareStatement(monthersql.toString());
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,patient_id);
				stmt.setString(++st,mother_encounter_id);
				stmt.setString(++st,facility_id);
					
				rs = stmt.executeQuery();
				if(rs.next())
				{
					gestational_period=rs.getString("gestational_period") == null ? " " : rs.getString("gestational_period");
					gestational_period_in_days=rs.getString("GESTATIONAL_PERIOD_IN_DAYS") == null ? "" : rs.getString("GESTATIONAL_PERIOD_IN_DAYS");
					delivery_type=rs.getString("delivery_type") == null ? " " : rs.getString("delivery_type");
					noofbirths=rs.getString("noofBirths") == null ? " " : rs.getString("noofBirths");
					procclassific=rs.getString("procclassific")==null?" ":rs.getString("procclassific");
					vaginaldelytypedesc=rs.getString("vaginal_dely_type_desc")==null?" ":rs.getString("vaginal_dely_type_desc");
					surgicalclassify=rs.getString("surgicalclassify")==null?" ":rs.getString("surgicalclassify");
					gravida=rs.getString("gravida")==null?" ":rs.getString("gravida");
					complications=rs.getString("complications")==null?" ":rs.getString("complications");
					delyinddesc=rs.getString("DELY_IND_DESC")==null?" ":rs.getString("DELY_IND_DESC");
					parity=rs.getString("parity")==null?" ":rs.getString("parity");
					multiple_birth_yn = rs.getString("MULTIPLE_BIRTH_YN")==null?"":rs.getString("MULTIPLE_BIRTH_YN");
					compln_pregnancy_desc = rs.getString("COMPLN_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_PREGNANCY_DESC");
					compln_nr_pregnancy_desc = rs.getString("COMPLN_NR_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_NR_PREGNANCY_DESC");
					attend_physician_id = rs.getString("ATTEND_PHYSICIAN_ID")==null?"":rs.getString("ATTEND_PHYSICIAN_ID");
					attend_midwife_id = rs.getString("ATTEND_MIDWIFE_ID")==null?"":rs.getString("ATTEND_MIDWIFE_ID");
					complns_1st_desc = rs.getString("complns_1st_desc")==null?"":rs.getString("complns_1st_desc");
					complns_2nd_desc = rs.getString("complns_2nd_desc")==null?"":rs.getString("complns_2nd_desc");
					complns_3rd_desc = rs.getString("complns_3rd_desc")==null?"":rs.getString("complns_3rd_desc");

					if(!gestational_period_in_days.equals(""))
						gestational_period_in_days = gestational_period_in_days + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					
					if(!gestational_period.equals(""))
						gestational_period_in_days = " " + gestational_period_in_days;
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gravida));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gravida));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Gravida.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(parity));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(parity));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Parity.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gestational_period));
            out.print( String.valueOf(gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""));
            out.print( String.valueOf(gestational_period_in_days));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gestational_period));
            out.print( String.valueOf(gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""));
            out.print( String.valueOf(gestational_period_in_days));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationalPeriod.label","ca_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complications));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complications));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CompofDelivery.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(delivery_type));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(delivery_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliveryType.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(vaginaldelytypedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vaginaldelytypedesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VaginalDeliveryType.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(procclassific));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(procclassific));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ProcedureClassification.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(surgicalclassify));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(surgicalclassify));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassification.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(multiple_birth_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(multiple_birth_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MultipleBirth.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(noofbirths));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(noofbirths));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoofBirths.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(attend_physician_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attend_physician_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(attend_midwife_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attend_midwife_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AttendingNurse.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(compln_pregnancy_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(compln_pregnancy_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsofPregnancy.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(compln_nr_pregnancy_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(compln_nr_pregnancy_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsnotrelatedtoPregnancy.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complns_1st_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complns_1st_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin1stStage.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complns_2nd_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complns_2nd_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin2ndStage.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complns_3rd_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complns_3rd_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin3rdStage.label","mp_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
			}
			else if(col_field.equals("FATHERDETAIL"))
			{
				fathersql.append(strsql1.toString());
				st = 0;
				stmt = con.prepareStatement(fathersql.toString());
				stmt.setString(++st,patient_id);
				stmt.setString(++st,mother_encounter_id);
				stmt.setString(++st,facility_id);
				
				rs = stmt.executeQuery();
				if(rs.next())
				{
					father_patient_name = rs.getString("FATHER_PATIENT_NAME") == null ? "" : rs.getString("FATHER_PATIENT_NAME");
					father_nat_desc = rs.getString("FATHER_NAT_DESC") == null ? "" : rs.getString("FATHER_NAT_DESC");
					race_desc = rs.getString("RACE_DESC") == null ? "" : rs.getString("RACE_DESC");
					father_gove_employee_yn = rs.getString("FATHER_GOVE_EMPLOYEE_YN") == null ? "" : rs.getString("FATHER_GOVE_EMPLOYEE_YN");
					ocpn_class_desc = rs.getString("OCPN_CLASS_DESC") == null ? "" : rs.getString("OCPN_CLASS_DESC");
					ocpn_desc = rs.getString("OCPN_DESC") == null ? "" : rs.getString("OCPN_DESC");
					relgn_desc = rs.getString("RELGN_DESC") == null ? "" : rs.getString("RELGN_DESC");
					father_remarks = rs.getString("FATHER_REMARKS") == null ? "" : rs.getString("FATHER_REMARKS");
	
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_patient_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_patient_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.fathername.label","mp_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_nat_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_nat_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_gove_employee_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_gove_employee_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GovtEmployee.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ocpn_class_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ocpn_class_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ocpn_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ocpn_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.occupation.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_remarks));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_remarks));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
			}
			else if(col_field.equals("BABYDETAIL"))
			{
				babysql.append(strsql1.toString()+" and b.patient_id = a.patient_id order by DELIVERY_DATE");
				
				st = 0;
				stmt = con.prepareStatement(babysql.toString());
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,locale);
				stmt.setString(++st,patient_id);
				stmt.setString(++st,mother_encounter_id);
				stmt.setString(++st,facility_id);
				
				
				rs = stmt.executeQuery();
				while(rs.next())
				{					
					nb_sex=rs.getString("nb_sex")==null?" ":rs.getString("nb_sex");
					relationship=rs.getString("relationship")==null?" ":rs.getString("relationship");
					outcome=rs.getString("outcome")==null?" ":rs.getString("outcome");
					indicator_mark=rs.getString("indicator_mark")==null?" ":rs.getString("indicator_mark");
					lengthof=rs.getString("length")==null?" ":rs.getString("length");
					weight=rs.getString("weight")==null?" ":rs.getString("weight");
					bornat=rs.getString("born_at")==null?" ":rs.getString("born_at");
					birthplace_desc=rs.getString("birth_place_desc")==null?" ":rs.getString("birth_place_desc");
					bornwhere=rs.getString("born_where")==null?" ":rs.getString("born_where");
					birthcertificateno=rs.getString("BIRTH_CERTIFICATE_NO")==null?" ":rs.getString("BIRTH_CERTIFICATE_NO");
					nbbirthdate=rs.getString("nb_birth_date")==null?" ":rs.getString("nb_birth_date");
					
					headcircumference=rs.getString("head_circumference")==null?" ":rs.getString("head_circumference");
					chestcircumference=rs.getString("chest_circumference")==null?" ":rs.getString("chest_circumference");
					apgarscorein1mins=rs.getString("apgar_score_in_1_min")==null?" ":rs.getString("apgar_score_in_1_min");
					apgarscorein5mins=rs.getString("apgar_score_in_5_mins")==null?" ":rs.getString("apgar_score_in_5_mins");
					apgarscorein10mins=rs.getString("apgar_score_in_10_mins")==null?" ":rs.getString("apgar_score_in_10_mins");
					umbilicalcordstatus=rs.getString("umbilical_cord_status")==null?" ":rs.getString("umbilical_cord_status");
					umbcordcutby=rs.getString("UMB_CORD_CUT_BY")==null?" ":rs.getString("UMB_CORD_CUT_BY");
					conganomdesc=rs.getString("CONG_ANOM_DESC")==null?" ":rs.getString("CONG_ANOM_DESC");
					feeding = rs.getString("feeding_desc")==null?"":rs.getString("feeding_desc");
					patencyofanusyn=rs.getString("patency_of_anus_yn")==null?" ":rs.getString("patency_of_anus_yn");
					stools1 = rs.getString("stools")==null?"":rs.getString("stools");
					bcg_admin_dtls=rs.getString("bcg_admin_dtls")==null?"":rs.getString("bcg_admin_dtls");
					vitak_admin_dtls=rs.getString("Vitak_admin_dtls")==null?"":rs.getString("Vitak_admin_dtls");
					hepB_admin_dtls=rs.getString("HepB_admin_dtls")==null?"":rs.getString("HepB_admin_dtls");

					nb_born_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
					nb_born_name = rs.getString("NB_PATIENT_NAME")==null?"":rs.getString("NB_PATIENT_NAME");
					blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");

					if(!feeding.equals(""))
					{
						if(feeding.equals("T"))
							feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Breast.label","mp_labels");
						else if(feeding.equals("B"))
							feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Bottle.label","mp_labels");
						else 
							feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");	
					}
					else
						feedingdesc = "";

					if(!stools1.equals(""))
					{
						if(stools1.equals("M"))
							stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Meconium.label","mp_labels");
						else if(stools1.equals("Y"))
							stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.YellowSoft.label","mp_labels");
						else 
							stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
					}
					else
						stools = "";
					
					j++;
					if (maxRecord>1)
					{
						bd=0; lbd=0;
						bc=0; lbc=0;
						v=0; lv=0;
						ba=0; lba=0;
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nb_born_name.replace(" ","&nbsp;")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nb_born_name.replace("'","~")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

					} 
					else 
					{
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nb_born_name.replace(" ","&nbsp;")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nb_born_name.replace("'","~")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

					}
	
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nb_sex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nb_sex));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relationship));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(relationship));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nbbirthdate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nbbirthdate));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BirthDateTime.label","ca_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bornwhere));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bornwhere));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BornWhere.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(birthcertificateno));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(birthcertificateno));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthCertificateNo.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(birthplace_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(birthplace_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bd));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(indicator_mark));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(indicator_mark));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IndicatorMark.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(lengthof));
            out.print( String.valueOf(lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(lengthof));
            out.print( String.valueOf(lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.LengthofBaby.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(weight));
            out.print( String.valueOf(weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(weight));
            out.print( String.valueOf(weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthWeight.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(headcircumference));
            out.print( String.valueOf(headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(headcircumference));
            out.print( String.valueOf(headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HeadCircumference.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chestcircumference));
            out.print( String.valueOf(chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chestcircumference));
            out.print( String.valueOf(chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ChestCircum.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(umbilicalcordstatus));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(umbilicalcordstatus));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbilicalCord.label","mp_labels")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(umbcordcutby));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(umbcordcutby));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbCordCutBy.label","mp_labels")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(feedingdesc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(feedingdesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Feeding.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patencyofanusyn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patencyofanusyn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatencyofAnus.label","mp_labels")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(conganomdesc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(conganomdesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CongenitalAnomalies.label","mp_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stools));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(stools));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Stools.label","mp_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blood_grp));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blood_grp));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

					//if (!bcg_admin_dtls.equals(""))
					//{
		
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bcg_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bcg_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BCG.label","mp_labels")));
            _bw.write(_wl_block84Bytes, _wl_block84);

					//}
					//if (!vitak_admin_dtls.equals(""))
					//{
		
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(vitak_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vitak_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VitaminK.label","mp_labels")));
            _bw.write(_wl_block85Bytes, _wl_block85);

				//	}
					//if (!hepB_admin_dtls.equals(""))
				//	{
		
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(hepB_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hepB_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.HepatitisB.label","mp_labels")));
            _bw.write(_wl_block84Bytes, _wl_block84);

					//}
		
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(v));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bcg_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(bcg_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(m++));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(m++));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(vitak_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(vitak_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(m++));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(m++));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(hepB_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(hepB_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(m++));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(m++));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(j));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(apgarscorein1mins));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apgarscorein1mins));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(apgarscorein5mins));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apgarscorein5mins));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(apgarscorein10mins));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apgarscorein10mins));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(j));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ba));
            _bw.write(_wl_block120Bytes, _wl_block120);

				}
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
			}
		}
	}
	else
	{
		monthersql.append(strsql1.toString());
		st = 0;
		stmt = con.prepareStatement(monthersql.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
		stmt.setString(++st,mother_encounter_id);
		stmt.setString(++st,facility_id);
			
		rs = stmt.executeQuery();
		if(rs.next())
		{
			gestational_period=rs.getString("gestational_period") == null ? " " : rs.getString("gestational_period");
			gestational_period_in_days=rs.getString("GESTATIONAL_PERIOD_IN_DAYS") == null ? "" : rs.getString("GESTATIONAL_PERIOD_IN_DAYS");
			delivery_type=rs.getString("delivery_type") == null ? " " : rs.getString("delivery_type");
			noofbirths=rs.getString("noofBirths") == null ? " " : rs.getString("noofBirths");
			procclassific=rs.getString("procclassific")==null?" ":rs.getString("procclassific");
			vaginaldelytypedesc=rs.getString("vaginal_dely_type_desc")==null?" ":rs.getString("vaginal_dely_type_desc");
			surgicalclassify=rs.getString("surgicalclassify")==null?" ":rs.getString("surgicalclassify");
			gravida=rs.getString("gravida")==null?" ":rs.getString("gravida");
			complications=rs.getString("complications")==null?" ":rs.getString("complications");
			delyinddesc=rs.getString("DELY_IND_DESC")==null?" ":rs.getString("DELY_IND_DESC");
			parity=rs.getString("parity")==null?" ":rs.getString("parity");
			multiple_birth_yn = rs.getString("MULTIPLE_BIRTH_YN")==null?"":rs.getString("MULTIPLE_BIRTH_YN");
			compln_pregnancy_desc = rs.getString("COMPLN_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_PREGNANCY_DESC");
			compln_nr_pregnancy_desc = rs.getString("COMPLN_NR_PREGNANCY_DESC")==null?"":rs.getString("COMPLN_NR_PREGNANCY_DESC");
			attend_physician_id = rs.getString("ATTEND_PHYSICIAN_ID")==null?"":rs.getString("ATTEND_PHYSICIAN_ID");
			attend_midwife_id = rs.getString("ATTEND_MIDWIFE_ID")==null?"":rs.getString("ATTEND_MIDWIFE_ID");
			complns_1st_desc = rs.getString("complns_1st_desc")==null?"":rs.getString("complns_1st_desc");
			complns_2nd_desc = rs.getString("complns_2nd_desc")==null?"":rs.getString("complns_2nd_desc");
			complns_3rd_desc = rs.getString("complns_3rd_desc")==null?"":rs.getString("complns_3rd_desc");

			if(!gestational_period_in_days.equals(""))
				gestational_period_in_days = gestational_period_in_days + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");

			if(!gestational_period.equals(""))
				gestational_period_in_days = " " + gestational_period_in_days;
	
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gravida));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gravida));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Gravida.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(parity));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(parity));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Parity.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gestational_period));
            out.print( String.valueOf(gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""));
            out.print( String.valueOf(gestational_period_in_days));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gestational_period));
            out.print( String.valueOf(gestational_period.equals("1")?UNIT_OF_GEST_NB_s:(!gestational_period.equals(" "))?UNIT_OF_GEST_NB_m:""));
            out.print( String.valueOf(gestational_period_in_days));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationalPeriod.label","ca_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complications));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complications));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CompofDelivery.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(delivery_type));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(delivery_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliveryType.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(vaginaldelytypedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vaginaldelytypedesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VaginalDeliveryType.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(procclassific));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(procclassific));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ProcedureClassification.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(surgicalclassify));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(surgicalclassify));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassification.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(multiple_birth_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(multiple_birth_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MultipleBirth.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(noofbirths));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(noofbirths));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoofBirths.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(attend_physician_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attend_physician_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(attend_midwife_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attend_midwife_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AttendingNurse.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(compln_pregnancy_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(compln_pregnancy_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsofPregnancy.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(compln_nr_pregnancy_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(compln_nr_pregnancy_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ComplicationsnotrelatedtoPregnancy.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complns_1st_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complns_1st_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin1stStage.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complns_2nd_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complns_2nd_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin2ndStage.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complns_3rd_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complns_3rd_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(lm++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Complicationsin3rdStage.label","mp_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
		if(rs != null ) rs.close();
		if(stmt != null ) stmt.close();

		fathersql.append(strsql1.toString());
		st = 0;
		stmt = con.prepareStatement(fathersql.toString());
		stmt.setString(++st,patient_id);
		stmt.setString(++st,mother_encounter_id);
		stmt.setString(++st,facility_id);
		
		rs = stmt.executeQuery();
		if(rs.next())
		{
			father_patient_name = rs.getString("FATHER_PATIENT_NAME") == null ? "" : rs.getString("FATHER_PATIENT_NAME");
			father_nat_desc = rs.getString("FATHER_NAT_DESC") == null ? "" : rs.getString("FATHER_NAT_DESC");
			race_desc = rs.getString("RACE_DESC") == null ? "" : rs.getString("RACE_DESC");
			father_gove_employee_yn = rs.getString("FATHER_GOVE_EMPLOYEE_YN") == null ? "" : rs.getString("FATHER_GOVE_EMPLOYEE_YN");
			ocpn_class_desc = rs.getString("OCPN_CLASS_DESC") == null ? "" : rs.getString("OCPN_CLASS_DESC");
			ocpn_desc = rs.getString("OCPN_DESC") == null ? "" : rs.getString("OCPN_DESC");
			relgn_desc = rs.getString("RELGN_DESC") == null ? "" : rs.getString("RELGN_DESC");
			father_remarks = rs.getString("FATHER_REMARKS") == null ? "" : rs.getString("FATHER_REMARKS");
	
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_patient_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_patient_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.fathername.label","mp_labels")));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_nat_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_nat_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_gove_employee_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_gove_employee_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GovtEmployee.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ocpn_class_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ocpn_class_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ocpn_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ocpn_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.occupation.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(f++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(father_remarks));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(father_remarks));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(lf++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
		if(rs != null ) rs.close();
		if(stmt != null ) stmt.close();

		babysql.append(strsql1.toString()+" and b.patient_id = a.patient_id order by DELIVERY_DATE");
		
		st = 0;
		stmt = con.prepareStatement(babysql.toString());
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
		stmt.setString(++st,mother_encounter_id);
		stmt.setString(++st,facility_id);
		
		
		rs = stmt.executeQuery();
		while(rs.next())
		{
			nb_sex=rs.getString("nb_sex")==null?" ":rs.getString("nb_sex");
			relationship=rs.getString("relationship")==null?" ":rs.getString("relationship");
			outcome=rs.getString("outcome")==null?" ":rs.getString("outcome");
			indicator_mark=rs.getString("indicator_mark")==null?" ":rs.getString("indicator_mark");
			lengthof=rs.getString("length")==null?" ":rs.getString("length");
			weight=rs.getString("weight")==null?" ":rs.getString("weight");
			bornat=rs.getString("born_at")==null?" ":rs.getString("born_at");
			birthplace_desc=rs.getString("birth_place_desc")==null?" ":rs.getString("birth_place_desc");
			bornwhere=rs.getString("born_where")==null?" ":rs.getString("born_where");
			birthcertificateno=rs.getString("BIRTH_CERTIFICATE_NO")==null?" ":rs.getString("BIRTH_CERTIFICATE_NO");
			nbbirthdate=rs.getString("nb_birth_date")==null?" ":rs.getString("nb_birth_date");			
			headcircumference=rs.getString("head_circumference")==null?" ":rs.getString("head_circumference");
			chestcircumference=rs.getString("chest_circumference")==null?" ":rs.getString("chest_circumference");
			apgarscorein1mins=rs.getString("apgar_score_in_1_min")==null?" ":rs.getString("apgar_score_in_1_min");
			apgarscorein5mins=rs.getString("apgar_score_in_5_mins")==null?" ":rs.getString("apgar_score_in_5_mins");
			apgarscorein10mins=rs.getString("apgar_score_in_10_mins")==null?" ":rs.getString("apgar_score_in_10_mins");
			umbilicalcordstatus=rs.getString("umbilical_cord_status")==null?" ":rs.getString("umbilical_cord_status");
			umbcordcutby=rs.getString("UMB_CORD_CUT_BY")==null?" ":rs.getString("UMB_CORD_CUT_BY");
			conganomdesc=rs.getString("CONG_ANOM_DESC")==null?" ":rs.getString("CONG_ANOM_DESC");
			feeding = rs.getString("feeding_desc")==null?"":rs.getString("feeding_desc");
			patencyofanusyn=rs.getString("patency_of_anus_yn")==null?" ":rs.getString("patency_of_anus_yn");
			stools1 = rs.getString("stools")==null?"":rs.getString("stools");
			bcg_admin_dtls=rs.getString("bcg_admin_dtls")==null?"":rs.getString("bcg_admin_dtls");
			vitak_admin_dtls=rs.getString("Vitak_admin_dtls")==null?"":rs.getString("Vitak_admin_dtls");
			hepB_admin_dtls=rs.getString("HepB_admin_dtls")==null?"":rs.getString("HepB_admin_dtls");

			nb_born_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			nb_born_name = rs.getString("NB_PATIENT_NAME")==null?"":rs.getString("NB_PATIENT_NAME");
			blood_grp = rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");

			if(!feeding.equals(""))
			{
				if(feeding.equals("T"))
					feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Breast.label","mp_labels");
				else if(feeding.equals("B"))
					feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Bottle.label","mp_labels");
				else 
					feedingdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
			else
				feedingdesc = "";

			if(!stools1.equals(""))
			{
				if(stools1.equals("M"))
					stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Meconium.label","mp_labels");
				else if(stools1.equals("Y"))
					stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.YellowSoft.label","mp_labels");
				else 
					stools = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
			else
				stools = "";

			j++;
			if (maxRecord>1)
			{
				bd=0; lbd=0;
				bc=0; lbc=0;
				v=0; lv=0;
				ba=0; lba=0;
	
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nb_born_name.replace(" ","&nbsp;")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nb_born_name.replace("'","~")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

			} 
			else 
			{
	
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nb_born_name.replace(" ","&nbsp;")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nb_born_name.replace("'","~")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nb_born_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
	
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nb_sex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nb_sex));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relationship));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(relationship));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nbbirthdate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nbbirthdate));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BirthDateTime.label","ca_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bornwhere));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bornwhere));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BornWhere.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(birthcertificateno));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(birthcertificateno));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthCertificateNo.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bd++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(birthplace_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(birthplace_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbd++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bd));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(indicator_mark));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(indicator_mark));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IndicatorMark.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(lengthof));
            out.print( String.valueOf(lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(lengthof));
            out.print( String.valueOf(lengthof.equals("1")?UNIT_OF_LENGTH_NB_s:(!lengthof.equals(" "))?UNIT_OF_LENGTH_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.LengthofBaby.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(weight));
            out.print( String.valueOf(weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(weight));
            out.print( String.valueOf(weight.equals("1")?UNIT_OF_WT_NB_s:(!weight.equals(" "))?UNIT_OF_WT_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BirthWeight.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(headcircumference));
            out.print( String.valueOf(headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(headcircumference));
            out.print( String.valueOf(headcircumference.equals("1")?UNIT_OF_CIRCUM_NB_s:(!headcircumference.equals(" "))?UNIT_OF_CIRCUM_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HeadCircumference.label","common_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chestcircumference));
            out.print( String.valueOf(chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chestcircumference));
            out.print( String.valueOf(chestcircumference.equals("1")?UNIT_OF_CHEST_CIRCUM_NB_s:(!chestcircumference.equals(" "))?UNIT_OF_CHEST_CIRCUM_NB_m:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ChestCircum.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(umbilicalcordstatus));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(umbilicalcordstatus));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbilicalCord.label","mp_labels")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(umbcordcutby));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(umbcordcutby));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UmbCordCutBy.label","mp_labels")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(feedingdesc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(feedingdesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Feeding.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patencyofanusyn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patencyofanusyn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatencyofAnus.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(conganomdesc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(conganomdesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CongenitalAnomalies.label","mp_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stools));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(stools));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Stools.label","mp_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            out.print( String.valueOf(bc++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blood_grp));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blood_grp));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lbc++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bcg_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bcg_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.BCG.label","mp_labels")));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(vitak_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vitak_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.VitaminK.label","mp_labels")));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            out.print( String.valueOf(v++));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(hepB_admin_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hepB_admin_dtls));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lv++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.HepatitisB.label","mp_labels")));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(v));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(j));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(apgarscorein1mins));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apgarscorein1mins));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(apgarscorein5mins));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apgarscorein5mins));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j));
            out.print( String.valueOf(ba++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(apgarscorein10mins));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(apgarscorein10mins));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            out.print( String.valueOf(lba++));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(j));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ba));
            _bw.write(_wl_block142Bytes, _wl_block142);

		}
		if(rs != null ) rs.close();
		if(stmt != null ) stmt.close();
	}
	i++;
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
	}
}

catch(Exception e)
{
	e.printStackTrace();
	out.println("Exception cauight in RecClinicalNotesLinkBirthMain.jsp" + e);
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(k));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(b));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(m));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(f));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(j));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(noofbirths));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(return_format));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(order));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(mother_encounter_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block153Bytes, _wl_block153);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchresult.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.motherdetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Gravida.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Parity.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GestationalPeriod.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CompofDelivery.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VaginalDeliveryType.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ProcedureClassification.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliverySurgicalClassification.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MultipleBirth.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoofBirths.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AttendingNurse.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsofPregnancy.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsnotrelatedtoPregnancy.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin1stStage.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin2ndStage.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin3rdStage.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fatherdetails.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fathername.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GovtEmployee.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Baby.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BabyDetails.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.demographicdetails.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BirthDateTime.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BornWhere.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthCertificateNo.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.clinicaldetails.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicatorMark.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LengthofBaby.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthWeight.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HeadCircumference.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ChestCircum.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbilicalCord.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbCordCutBy.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Feeding.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatencyofAnus.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CongenitalAnomalies.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Stools.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.vaccinationdetails.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BCG.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VitaminK.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HepatitisB.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BCG.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApgarScore.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.motherdetails.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Gravida.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Parity.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GestationalPeriod.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CompofDelivery.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryType.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VaginalDeliveryType.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ProcedureClassification.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliverySurgicalClassification.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MultipleBirth.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoofBirths.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AttendingNurse.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsofPregnancy.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsnotrelatedtoPregnancy.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin1stStage.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin2ndStage.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin3rdStage.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fatherdetails.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fathername.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GovtEmployee.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Baby.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BabyDetails.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.demographicdetails.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BirthDateTime.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BornWhere.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthCertificateNo.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.clinicaldetails.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicatorMark.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LengthofBaby.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthWeight.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HeadCircumference.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ChestCircum.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbilicalCord.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbCordCutBy.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Feeding.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatencyofAnus.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CongenitalAnomalies.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Stools.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.vaccinationdetails.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BCG.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VitaminK.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HepatitisB.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApgarScore.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }
}
