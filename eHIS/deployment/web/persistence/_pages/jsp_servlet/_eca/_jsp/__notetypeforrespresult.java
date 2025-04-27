package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __notetypeforrespresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/NoteTypeForRespResult.jsp", 1733805533128L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- Added by Arvind @ 08-12-08 -->\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n<script language=\'javascript\' src=\'../js/NoteTypeForResp.js\'></script>\n\n<script>\n\tfunction checkNoteTypeForRes(thisObj, code, privilege_type){\n\t\t//if(thisObj.value==\"\")return;\n\n\tvar group_by = document.forms(0).group_by.value;\n\tvar grp_by_code = document.forms(0).grp_by_code.value;\n\n\tvar defaultIndex = privilege_type;\n\t\n\tvar HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link><script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></HEAD><BODY onKeyDown=\'lockKey()\' CLASS=\'MESSAGE\'><form name=\'form1\' method=\'post\' action=\'NoteTypeForRespValidate.jsp?code=\"+code+\"&grp_by_code=\"+grp_by_code+\"&obj_name=\"+thisObj.name+\"&default_index=\"+defaultIndex+\"&group_by=\"+group_by+\"\'></form></BODY></HTML>\";\n\tparent.parent.messageFrame.document.write(HTMLVal);\n\tparent.parent.messageFrame.document.forms[0].submit();\n\t\n\t}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\tif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' <= 0)\n\t\t{\n\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'common\');\t\n\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body class=\'CONTENT\' onLoad=\"\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'formNoteTypeRespResults\' id=\'formNoteTypeRespResults\'>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'80%\' align=\'center\'>\n<tr align=\'right\' width=\'10%\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<td class=\'white\' width=\'95%\'></td> \n\t\t\t<td  align=\'right\' width=\'5%\'>\n\t<A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Previous\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<td class=\'white\' width=\'95%\'></td> \n\t\t\t<td  align=\'right\' width=\'5%\'>\n\t<A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Next\");\' text-decoration=\'none\' >&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</tr>\n</table> \n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<table class=\'grid\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\'>\n<th class=\'columnHeadercenter\' align=\"left\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n<th class=\'columnHeadercenter\' align=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\n <input type=\'checkbox\' name=\'ctrlChkBox";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'ctrlChkBox";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onClick=\"javascript:perform(this,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="checked";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></th>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\n<th class=\'columnHeadercenter\' align=\"left\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n \t\n<th class=\'columnHeadercenter\' align=\"left\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<input type=\'checkbox\' name=\'ctrlChkBoxx1\' id=\'ctrlChkBoxx1\' onClick=\"javascript:performSelectAll(this,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="></th><!--IN066108_1 alpha-->\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<tr id=\'\'>\n\t\t\t<!-- onChange=\'return checkNoteTypeForRes(this,\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"); -->\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  width=\'30%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<select name=\'select_yn";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'select_yn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onchange=\'TransDisplay(this,\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\")\'><option value=\'\'>------------------------------";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="--------------------------------</option>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<option value=\"3\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t\t\t<option value=\"5\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<option value=\"1\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t<option value=\"2\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t<option value=\"3\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t<option value=\"4\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t</select>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<input type=checkbox onclick = \'chkunchk(this,\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\")\'  name=\'select_yn";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value= \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="1";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="0";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\tchecked\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">\n\t\t\t\t\n\t\t ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'  width=\'30%\'>\n\t\t\t<input type=\'hidden\' name=\'default_allow_yn";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'default_allow_yn";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\n\t\t\n\t\t    <input type=\'checkbox\' onclick = \'chkunchk1(this,\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\")\'  name=\'dflt_trans_yn";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' \n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\tchecked\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\tdisabled\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'  width=\'30%\'>\n\t\t \t\t\t    <input type=\'checkbox\' onclick = \'chkunchk2(this,\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\")\'  name=\'in_error_yn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'in_error_yn";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t \t\t\t    \t\tdisabled\n\t\t \t\t\t    \t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t</td>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<input type =\'hidden\' name=\'in_error_yn";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' value =\'0\'/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\tdisabled\n\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =">\n\t\t\t\t\t</td>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<input type=\"hidden\" name=\'valid";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'valid";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' value=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" > \n\t\t\t</td>\n\t\t</tr>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\n\t<td>\n\t</td>\n\t</table>\n\t<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" > \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t<input type=\"hidden\" name=\"group_by\" id=\"group_by\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t<input type=\"hidden\" name=\"grp_by_code\" id=\"grp_by_code\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t<input type=\"hidden\" name=\"selAllValue\" id=\"selAllValue\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<input type=\"hidden\" name=\"default_allow_yn\" id=\"default_allow_yn\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t<input type=\"hidden\" name=\"check_yn";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"check_yn";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name=\"pagecount\" id=\"pagecount\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name=\"chkCount\" id=\"chkCount\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name=\"enableCount\" id=\"enableCount\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\"hidden\" name=\"inErrorParam\" id=\"inErrorParam\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<script language=\'javascript\' src=\'../../eCA/js/NoteTypeForResp.js\'></script>\n\t<script>\n\t\tfnSelectAllChkBox(\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\");\n\t\tonLoadInErrorSelectAll();//IN06788\n\t</script>\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );
	
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

int row_count=0;

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
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------

17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
12/06/2018	  IN067886		Kamalakannan	25/01/2018		Ramesh		        CA-GHL-CRF-0497/01
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
webbeans.eCommon.RecordSet NTRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("NTRecordSet","webbeans.eCommon.RecordSet",session);

            _bw.write(_wl_block1Bytes, _wl_block1);
            eCA._ca_license_rights getLincKey= null;{
                getLincKey=(eCA._ca_license_rights)pageContext.getAttribute("getLincKey");
                if(getLincKey==null){
                    getLincKey=new eCA._ca_license_rights();
                    pageContext.setAttribute("getLincKey",getLincKey);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

Connection con			= null;
PreparedStatement pstmt = null;
ResultSet rs			= null;
HashMap hMapRecords		= null;


int row_disp=14;
int start = 0 ;
int end = 0 ;
int fm_disp=0, to_disp=0;
int count = 0;
int hdrSelCount = 0;
int chkCount = 0;//IN066108
int enableCount = 0;//IN066108
//String count1= "";

String title_desc="", group_by="", grp_by_code="", sql_query="", code="", desc="", classValue="",title_desc1="";
String from= "", to ="", dispMode="", update_val ="", valid="", associate="",dflt_transcription_yn="",dflt_trans_yn="",in_error_yn="";//IN066108
String privilege_type = "", selectOption1 = "selected", selectOption2 = "", selectOption3 = "";
String selectOption4 = "", selectOption5 = "", insUpd="", privilege_type_value ="",selAllValue="",default_allow_yn="",check_yn="";
String chk_transcription="";
String inErrorParam = "N";//IN066108
String enableInErr = "N";//IN067886
int pagecount = 0;

dispMode		=	request.getParameter("dispMode") ;
from			=	request.getParameter( "from" ) ;
to				=	request.getParameter( "to" ) ;
selAllValue	=	request.getParameter( "selAllValue" ) ;


//count1			=	request.getParameter( "count1" ) ;

if ( from == null || from=="null" || from.equals("null") )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null || to =="null" || to.equals("null") )
	end = row_disp;//7 ;
else
	end = Integer.parseInt( to ) ;

if(dispMode == null || dispMode.equals("null")) dispMode="";
if(selAllValue == null || selAllValue.equals("null")) selAllValue="0";

hdrSelCount = Integer.parseInt( selAllValue ) ;



/*if ( count1 == null || count1=="null" || count1.equals("null") )
	count = 0 ;
else
	count = Integer.parseInt( count1 ) ;*/

group_by = request.getParameter("group_by");
if(group_by == null || group_by.equals(""))group_by="";
grp_by_code = request.getParameter("grp_by_code");
if(grp_by_code == null || grp_by_code.equals(""))grp_by_code="";

//out.println("grp_by_code"+grp_by_code);
//IN066108 starts
String inError_query = "select IN_ERROR_YN from CA_NOTE_PARAM";
con = ConnectionManager.getConnection();
pstmt = con.prepareStatement(inError_query);
rs = pstmt.executeQuery();
while(rs.next()){
	inErrorParam = rs.getString("IN_ERROR_YN");
}
//IN066108 ends
if(group_by.equals("RS"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");
	chk_transcription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DfltTranscriptionNotes.label","ca_labels");
	//sql_query = "select a.note_type_desc description, a.note_type code,(select privilege_type from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id ='"+grp_by_code+"')privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id ='"+grp_by_code+"') valid,(SELECT dflt_transcription_yn FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id ='"+grp_by_code+"') dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id = '"+grp_by_code+"') in_error_yn from ca_note_type a where eff_status='E' order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180
	sql_query = "select a.note_type_desc description, a.note_type code,(select privilege_type from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id =?)privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id =?) valid,(SELECT dflt_transcription_yn FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id =?) dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id = ?) in_error_yn from ca_note_type a where eff_status='E' order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180

}
else if(group_by.equals("PR"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	chk_transcription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DfltTranscriptionNotes.label","ca_labels");
	//sql_query = "select a.note_type_desc description, a.note_type code,(select resource_type from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code ='"+grp_by_code+"') privilege_type, (select (case when resource_type is not null then 'Y' else 'N' end)from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code ='"+grp_by_code+"') valid, (SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"') dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code = '"+grp_by_code+"') in_error_yn from ca_note_type a where eff_status='E' and exists (select 1 from CA_NOTE_TYPE_FOR_RESP where RESP_ID in (select NVL(resp_id,'XX') from sm_resp_for_user ia, sm_appl_user ib where ib.func_role_id='"+grp_by_code+"' and ia.appl_user_id=ib.appl_user_id) and note_type=A.NOTE_TYPE ) order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180
	sql_query = "select a.note_type_desc description, a.note_type code,(select resource_type from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code =?) privilege_type, (select (case when resource_type is not null then 'Y' else 'N' end)from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code =?) valid, (SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?) dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code = ?) in_error_yn from ca_note_type a where eff_status='E' and exists (select 1 from CA_NOTE_TYPE_FOR_RESP where RESP_ID in (select NVL(resp_id,'XX') from sm_resp_for_user ia, sm_appl_user ib where ib.func_role_id=? and ia.appl_user_id=ib.appl_user_id) and note_type=A.NOTE_TYPE ) order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180

}else if(group_by.equals("SP"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	chk_transcription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DfltTranscriptionNotes.label","ca_labels");
	//sql_query = "SELECT a.note_type_desc description, a.note_type code,(SELECT resource_type FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"')privilege_type, (SELECT (CASE WHEN resource_type IS NOT NULL THEN 'Y' ELSE 'N' END)FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"') valid,(SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"') dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn FROM ca_note_type a WHERE eff_status='E' ORDER BY UPPER(a.note_type_desc)";//common-icn-0180
	sql_query = "SELECT a.note_type_desc description, a.note_type code,(SELECT resource_type FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?)privilege_type, (SELECT (CASE WHEN resource_type IS NOT NULL THEN 'Y' ELSE 'N' END)FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?) valid,(SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?) dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn FROM ca_note_type a WHERE eff_status='E' ORDER BY UPPER(a.note_type_desc)";//common-icn-0180

}
else if(group_by.equals("NT"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels"); 
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");
	//sql_query = "select a.resp_name description, a.resp_id code,(select privilege_type from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type='"+grp_by_code+"') privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type='"+grp_by_code+"')valid from sm_resp a where eff_status='E' order by upper(a.resp_name)";//IN066108 changed//common-icn-0180
	sql_query = "select a.resp_name description, a.resp_id code,(select privilege_type from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type=?) privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type=?)valid from sm_resp a where eff_status='E' order by upper(a.resp_name)";//IN066108 changed//common-icn-0180

}
else
{
	title_desc = "";
	title_desc1= "";
	if(!(group_by.equals("NT")))
	{
	  chk_transcription= "";
	}

}

try{

	if(dispMode.equals(""))
	{

		NTRecordSet.clearAll();
		int pstmtcount =1;//common-icn-0180
		//con = ConnectionManager.getConnection(); commented for IN066108
		pstmt = con.prepareStatement(sql_query);
		//common-icn-0180 starts
		if(group_by.equals("RS")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
		}
		else if(group_by.equals("PR")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
		}
		else if(group_by.equals("SP")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
				
		}
		else if(group_by.equals("NT")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			
		}
		//common-icn-0180 ends
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			code			= rs.getString("code");
			desc			= rs.getString("description");
			privilege_type	= rs.getString("privilege_type");
			valid			= rs.getString("valid");
			if(!(group_by.equals("NT")))
	        {
	           dflt_transcription_yn		= rs.getString("dflt_transcription_yn");
			   default_allow_yn			= rs.getString("default_allow_yn");
			   //IN066108 start
			   if(!group_by.equals("SP")){
				   in_error_yn				= rs.getString("in_error_yn");
				   if(in_error_yn == null || in_error_yn.equals("") || in_error_yn.equals("null"))in_error_yn="N";
			   }
			   //IN066108 end
			   if(dflt_transcription_yn == null || dflt_transcription_yn.equals("") || dflt_transcription_yn.equals("null"))dflt_transcription_yn="N";
			   if(default_allow_yn == null || default_allow_yn.equals("") || default_allow_yn.equals("null"))default_allow_yn="";
			   //out.println("dflt_transcription_yn"+dflt_transcription_yn);
	        }
						
			if(code == null || code.equals("null"))code="";
			if(desc == null || desc.equals("null"))desc="";
			if(privilege_type == null|| privilege_type.equals("null"))privilege_type="";
			if(valid == null || valid.equals("") || valid.equals("null"))valid="N";
			
			
			
			HashMap hMapRecs = new HashMap();
			hMapRecs.put("code"				, code);
			hMapRecs.put("desc"				, desc);
			hMapRecs.put("privilege_type"	, privilege_type);
			hMapRecs.put("associate"		, "N");
			hMapRecs.put("valid"			, valid);
			if(!(group_by.equals("NT")))
	        {
			  hMapRecs.put("dflt_transcription_yn"			, dflt_transcription_yn);
			  hMapRecs.put("default_allow_yn"			, default_allow_yn);
			 //IN066108 start
			  if(!group_by.equals("SP")){
			  hMapRecs.put("in_error_yn"			, in_error_yn);
			  }
			  //IN066108 end
			}
			hMapRecs.put("insUpd"			, "");
			NTRecordSet.putObject(hMapRecs);				
		}
	row_count	=	NTRecordSet.getSize();
		
	fm_disp	=	0;
	to_disp	=	(row_disp-1);
	if(to_disp > (row_count-1))
	to_disp=(row_count-1);

	from = ""+(start - 1);
	to   = ""+(end - 1);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	else
	{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		if(dispMode.equals("Next"))
		{
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			title_desc	= title_desc;
			title_desc1	= title_desc1;			
			hdrSelCount = hdrSelCount+1;
			if(!(group_by.equals("NT")))
	        {
			  chk_transcription = chk_transcription;
			}
		}
		else if(dispMode.equals("Previous"))
		{
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			title_desc	= title_desc;
			title_desc1	= title_desc1;		
			hdrSelCount=hdrSelCount-1;
			if(!(group_by.equals("NT")))
	        {
			  chk_transcription = chk_transcription;
			}		
		}
	
	if(to_val > (row_count-1))
		to_val=(row_count-1);
	String valid_rec = "";
	//String dflt_rec="";
	if (group_by.equals("RS")||(group_by.equals("NT"))) 
	{
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);	
			if(update_val == null || update_val.equals("null") || update_val.equals("")) update_val = "";	
			if (group_by.equals("RS"))
			{
				dflt_trans_yn = request.getParameter("dflt_trans_yn"+j);	
				//IN066108 start 
				in_error_yn = request.getParameter("in_error_yn"+j);
				//IN066108 end
				if(dflt_trans_yn == null || dflt_trans_yn.equals("null") || dflt_trans_yn.equals("")) dflt_trans_yn = "";
				//IN066108 start
				if(in_error_yn == null || in_error_yn.equals("null") || in_error_yn.equals("")) in_error_yn = "";
				//IN066108 end
			}
			
						
			HashMap hMapAlter = (java.util.HashMap)NTRecordSet.getObject(j);
			//out.println("hMapAlter"+(java.util.HashMap)NTRecordSet.getObject(j));
			
			valid_rec = (String)hMapAlter.get("valid");
			//out.println("valid_rec"+valid_rec);

			if(valid_rec.equals("Y"))
			{
				insUpd = "U" ;
			}
			else if(valid_rec.equals("N")) 
			{
				if(update_val.equals("1")||update_val.equals("2")||update_val.equals("3")||update_val.equals("4")||update_val.equals("5")||update_val.equals("P")||update_val.equals("S"))
				{
					insUpd = "I";
				}
				else
				{
					insUpd = "";
				}
			}
			if(valid_rec.equals("Y")){
				hMapAlter.put("privilege_type", update_val);
				hMapAlter.put("associate"	  , "Y");
				hMapAlter.put("insUpd"		  , insUpd);
				//IN066108 start
				if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
					in_error_yn="Y";
				}
				else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
					in_error_yn="N";
				}
				hMapAlter.put("in_error_yn"	  , in_error_yn);
				//IN066108 end
				/*if (group_by.equals("RS"))
				{
					hMapAlter.put("dflt_transcription_yn" , dflt_trans_yn);
				}*/
				NTRecordSet.setObject(j, hMapAlter);
			}else if(valid_rec.equals("N")){				
					hMapAlter.put("privilege_type", update_val);
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , insUpd);
					//IN066108 start
					if(in_error_yn.equals("1") ||in_error_yn.equals("Y")){
						in_error_yn="Y";
					}
					else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
						in_error_yn="N";
					}
					hMapAlter.put("in_error_yn"	  , in_error_yn);
					//IN066108 end				
					/*if (group_by.equals("RS"))
					{
						hMapAlter.put("dflt_transcription_yn" , dflt_trans_yn);
					}*/
					NTRecordSet.setObject(j, hMapAlter);
			}		
		}
	}
else 
	{ 			
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);	
			dflt_trans_yn = request.getParameter("dflt_trans_yn"+j);
			in_error_yn = request.getParameter("in_error_yn"+j);//IN066108 
			if(update_val == null || update_val.equals("null") || update_val.equals("")) update_val = "";
			if(dflt_trans_yn == null || dflt_trans_yn.equals("null") || dflt_trans_yn.equals("")) dflt_trans_yn = "";
			if(in_error_yn == null || in_error_yn.equals("null") || in_error_yn.equals("")) in_error_yn = "";//IN066108 start
			HashMap hMapAlter = (java.util.HashMap)NTRecordSet.getObject(j);
			
			//out.println("hMapAlter"+(java.util.HashMap)NTRecordSet.getObject(j));
		
			
			valid_rec = (String)hMapAlter.get("valid");
			/*if(valid_rec.equals("Y")) insUpd = "U" ;
				else if(valid_rec.equals("N")) insUpd = "";*/

				if(valid_rec.equals("Y"))
			{
				insUpd = "U" ;
			}
			else if(valid_rec.equals("N")) 
			{
				if(update_val.equals("1")||update_val.equals("2")||update_val.equals("3")||update_val.equals("4")||update_val.equals("5")||update_val.equals("P")||update_val.equals("S"))
				{
					insUpd = "I";
				}
				else
				{
					insUpd = "";
				}
			}
			if(valid_rec.equals("Y")){				
				hMapAlter.put("privilege_type",update_val.trim());
				hMapAlter.put("associate"	  , "Y");
				hMapAlter.put("insUpd"		  , insUpd);
				//IN066108 start
				if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
					in_error_yn="Y";
				}
				else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
					in_error_yn="N";
				}
				hMapAlter.put("in_error_yn"			, in_error_yn);
				//IN066108 end
				NTRecordSet.setObject(j, hMapAlter);
			}else if(valid_rec.equals("N")){			
				if(!update_val.equals("")) {				
					hMapAlter.put("privilege_type", update_val.trim());
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , insUpd);
					//IN066108 start
					if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
						in_error_yn="Y";
					}
					else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
						in_error_yn="N";
					}
					hMapAlter.put("in_error_yn"			, in_error_yn);
					//IN066108 end
					NTRecordSet.setObject(j, hMapAlter);
				}else if(update_val.equals("")) {									
					hMapAlter.put("privilege_type", update_val.trim());
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , "U");
					//IN066108 start
					if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
						in_error_yn="Y";
					}
					else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
						in_error_yn="N";
					}
					hMapAlter.put("in_error_yn"			, in_error_yn);
					//IN066108 end
					NTRecordSet.setObject(j, hMapAlter);
				}			
				
			} 	
		}
	
	}

	fm_disp = Integer.parseInt(from);
	to_disp	= Integer.parseInt(to);

	if(to_disp > (row_count-1))
	to_disp=(row_count-1);

	start	= Integer.parseInt(from);
	end     = Integer.parseInt(to);
}	
	

            _bw.write(_wl_block12Bytes, _wl_block12);

if ( (!(start <= 1)) && (start < row_count)){

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
}
if ( !( (start+row_disp) >= row_count ) ){

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

}

            _bw.write(_wl_block16Bytes, _wl_block16);

if(row_count > 0)
{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(title_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(title_desc1));
            _bw.write(_wl_block1Bytes, _wl_block1);

 if((group_by.equals("SP"))||(group_by.equals("PR")))
{	

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(selAllValue.equals("Y")){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

}
 
            _bw.write(_wl_block26Bytes, _wl_block26);

if(!(group_by.equals("NT")))
{	

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(chk_transcription));
            _bw.write(_wl_block28Bytes, _wl_block28);

 }
 //IN066108 start
if((group_by.equals("RS")||group_by.equals("PR"))&&(inErrorParam.equals("Y")) )
{	

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(selAllValue.equals("Y")){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

 }//IN066108 end
}

            _bw.write(_wl_block1Bytes, _wl_block1);

	
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		hMapRecords		=	(java.util.HashMap)NTRecordSet.getObject(i);
		code			=	(String)	hMapRecords.get("code");
		desc			=	(String)	hMapRecords.get("desc");
		privilege_type	=	(String)	hMapRecords.get("privilege_type");
		associate		=	(String)	hMapRecords.get("associate");
		enableInErr = "N";//IN067886
		if(!(group_by.equals("NT")))
		{
		  default_allow_yn		=	(String)	hMapRecords.get("default_allow_yn");
		  dflt_transcription_yn		=	(String)	hMapRecords.get("dflt_transcription_yn");
		  in_error_yn		=	(String)	hMapRecords.get("in_error_yn");//IN066108 start
		  if(default_allow_yn == null || default_allow_yn.equals(""))default_allow_yn="N";
		  if(dflt_transcription_yn.equals("")||dflt_transcription_yn.equals("null"))
			dflt_transcription_yn = "N"; else dflt_transcription_yn =dflt_transcription_yn;
		  //IN066108 start
		  if(in_error_yn == null || in_error_yn.equals("null") || in_error_yn.equals("")){
			  in_error_yn = "N"; 
		  }
		  else {
			  in_error_yn =in_error_yn;
		  }
		  valid 			=	(String)hMapRecords.get("valid");
		  if(valid.equals("")||valid.equals("null"))
			  valid = "N"; else valid =valid;
		//IN066108 end	  
		  //out.println("dflt_transcription_yn%%%%"+dflt_transcription_yn);
		//IN067886 start
		  if ("Y".equals(valid))			
				enableInErr = "Y";
		//IN067886 end
		}
		if(associate == null || associate.equals(""))associate="N";		
		if(privilege_type.equals("")||privilege_type.equals("null"))
			privilege_type_value = "0";	else privilege_type_value = privilege_type;
		


		if(privilege_type.equals("1")){
			selectOption1 = "selected";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "";
		}else if(privilege_type.equals("2")){
			selectOption1 = "";
			selectOption2 = "selected";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "";
		}else if(privilege_type.equals("3")){
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "selected";
			selectOption4 = "";
			selectOption5 = "";
		}else if(privilege_type.equals("4")){
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "selected";
			selectOption5 = "";
		}else if(privilege_type.equals("5")){
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "selected";
		}else{
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "";
		}
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(privilege_type_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(((equals(""))?"&nbsp;":desc)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
if((group_by.equals("RS"))||(group_by.equals("NT"))){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( i));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if((getLincKey.getKey()).equals("CABASIC") || (getLincKey.getKey()).equals("CAMINI") || (getLincKey.getKey()).equals("BASIC")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(selectOption3));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(selectOption5));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}else if((getLincKey.getKey()).equals("CACLDC")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(selectOption1));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(selectOption2));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(selectOption3));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(selectOption4));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(selectOption5));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

	}
			}else
			{
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( i));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1")){
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

				if(privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1"))
				{
				
            _bw.write(_wl_block57Bytes, _wl_block57);

				}
				
            _bw.write(_wl_block58Bytes, _wl_block58);

			}
			if(privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1")){
				count = count+1;
				enableInErr = "Y";//IN067886
			}
			
            _bw.write(_wl_block59Bytes, _wl_block59);

				if(!(group_by.equals("NT")))
		      {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(default_allow_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( i));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(dflt_transcription_yn.equals("Y")||dflt_transcription_yn.equals("1")){
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block66Bytes, _wl_block66);

					if(dflt_transcription_yn.equals("Y")||dflt_transcription_yn.equals("1"))
					{
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
				if((privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1")||privilege_type.equals("2")||privilege_type.equals("3")||privilege_type.equals("4")||privilege_type.equals("5"))&&default_allow_yn.equals("Y"))
				{
				}
				else
				{
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
//IN066108 start
            _bw.write(_wl_block68Bytes, _wl_block68);

				
				if(group_by.equals("RS") &&inErrorParam.equals("Y")){ 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(in_error_yn.equals("Y")||in_error_yn.equals("1")){
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block66Bytes, _wl_block66);

					if(in_error_yn.equals("Y")||in_error_yn.equals("1"))
					{
						++chkCount;//IN066108
					
            _bw.write(_wl_block67Bytes, _wl_block67);
}
					//IN067886 start		
		 			    	if(!privilege_type.equals("3")&&!privilege_type.equals("4")){
            _bw.write(_wl_block75Bytes, _wl_block75);
}
		 			    	else{
		 			    		
		 			    		++enableCount;//IN066108
		 			    	}
					
            _bw.write(_wl_block76Bytes, _wl_block76);
if(privilege_type.equals("3")&&privilege_type.equals("4")){
						count = count+1;
						enableInErr = "Y";
					}//IN067886 end 
            _bw.write(_wl_block77Bytes, _wl_block77);
} 
					//IN066108 start
					else if(group_by.equals("RS") && inErrorParam.equals("N"))
					{
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);

					}
					//IN066108 stop
					if(group_by.equals("PR") &&inErrorParam.equals("Y")){ 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(in_error_yn.equals("Y")||in_error_yn.equals("1")){
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block66Bytes, _wl_block66);

					if(in_error_yn.equals("Y")||in_error_yn.equals("1"))
					{
						++chkCount;
					
            _bw.write(_wl_block67Bytes, _wl_block67);
}		
		 			    //if(valid.equals("Y"))//commented for IN067886
		 			    	if("Y".equals(enableInErr))//IN067886
					{
		 			    	++enableCount;
					}
					else
					{
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
} 
					//IN066108 start
					else if(group_by.equals("PR") && inErrorParam.equals("N"))
					{
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);

					}
				
				//IN066108 stop
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block82Bytes, _wl_block82);
//IN066108 start
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(valid));
            _bw.write(_wl_block86Bytes, _wl_block86);
//IN066108 start
            _bw.write(_wl_block1Bytes, _wl_block1);

		pagecount++;
	}

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	putObjectInBean("NTRecordSet",NTRecordSet,session);

	

}catch(Exception e){
	//out.println("Exception in try :"+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(from));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(to));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(grp_by_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(default_allow_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(check_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(pagecount));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(chkCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(enableCount));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(inErrorParam));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(hdrSelCount));
            _bw.write(_wl_block105Bytes, _wl_block105);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteTypeForResponosibilityResults.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.InError.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AuthorwithAuthorizationFacility.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewonlyPrivilege.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Transcriber.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AuthorbutwithoutAuthorizationFacility.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AuthorwithAuthorizationFacility.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReviewerPrivilegeforVerifyingandAuthorization.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewonlyPrivilege.label", java.lang.String .class,"key"));
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
}
