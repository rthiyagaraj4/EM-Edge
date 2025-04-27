package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __defaultsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/DefaultSearchCriteria.jsp", 1724138445025L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Developed By :  P.Sudhakaran -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eDR/js/DefaultSearchCriteria.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'>\n\t<form name=\'DefaultSearchCriteria\' id=\'DefaultSearchCriteria\' action=\'../../servlet/eDR.DefaultSearchCriteriaServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t<input type=hidden name=\'short_desc11\' id=\'short_desc11\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t<input type=hidden name=\'short_desc22\' id=\'short_desc22\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<input type=hidden name=\'short_desc33\' id=\'short_desc33\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<input type=hidden name=\'short_desc44\' id=\'short_desc44\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<input type=hidden name=\'first_name_prompt\' id=\'first_name_prompt\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type=hidden name=\'second_name_prompt\' id=\'second_name_prompt\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=hidden name=\'third_name_prompt\' id=\'third_name_prompt\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<input type=hidden name=\'family_name_prompt\' id=\'family_name_prompt\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=hidden name=\'first_name_init\' id=\'first_name_init\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=hidden name=\'second_name_init\' id=\'second_name_init\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=hidden name=\'third_name_init\' id=\'third_name_init\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=hidden name=\'family_name_init\' id=\'family_name_init\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=hidden name=\'first_name_avail\' id=\'first_name_avail\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=hidden name=\'second_name_avail\' id=\'second_name_avail\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=hidden name=\'third_name_avail\' id=\'third_name_avail\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=hidden name=\'family_name_avail\' id=\'family_name_avail\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=hidden name=\'area_name_avail\' id=\'area_name_avail\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type =\'hidden\' name =\'first_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type =\'hidden\' name =\'second_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type =\'hidden\' name =\'third_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type =\'hidden\' name =\'family_name_reqd_yn\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\n\t\t<br><br><br>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\t\t\t\t\n\t\t<tr><th class=\'columnheader\' style=\"text-align:left; color: white;\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th></tr>\t\t\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\n\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'name_loc_lang_yn\' id=\'name_loc_lang_yn\'  value=\"Y\"  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onClick=\"disable_soundex()\"></td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\n\t\t\t<td class=\'label\' width =\'50%\' colspan=\'2\'>&nbsp;</td>\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' ><select name=\'names_sndx_type\' id=\'names_sndx_type\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =">\n\t\t\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t\t\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\t\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' ><select name=\'names_sndx_type\' id=\'names_sndx_type\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\n\t\t</tr>\n\t\t\t\n\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].first_name_avail.value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t<td class=\'Fields\'  >\n\t\t\t\t<input type=\'checkbox\' name=\'first_name\' id=\'first_name\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\t\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"N\">\n\t\t\t<td class=\'label\' colspan=\'4\'>&nbsp;</td>\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].second_name_avail.value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t<td class=\'fields\' ><input type=\'checkbox\' name=\'second_name\' id=\'second_name\'  value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" \t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\"N\">\n\t\t\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].short_desc11.value = \'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t<td class=\'fields\' ><input type=\'checkbox\' name=\'short_desc1\' id=\'short_desc1\'  value=\"Y\"  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" ></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].third_name_avail.value = \'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t<td class=\'fields\' ><input type=\'checkbox\' name=\'third_name\' id=\'third_name\'  value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'third_name\' id=\'third_name\' value=\"N\">\n\t\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].short_desc22.value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t<td  class=\'fields\' ><input type=\'checkbox\' name=\'short_desc2\' id=\'short_desc2\'  value=\"Y\"  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t \n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].short_desc33.value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t<td class=\'fields\'  ><input type=\'checkbox\' name=\'short_desc3\' id=\'short_desc3\'  value=\"Y\"  ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].short_desc44.value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t<td  class=\'fields\'><input type=\'checkbox\' name=\'short_desc4\' id=\'short_desc4\'  value=\"Y\"  ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" ></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].family_name_avail.value = \'Y\';\n\t\t\t\t\t\t\n\t\t\t\t\t</script>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'family_name\' id=\'family_name\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t\t\n\t\t\t\t\t<td colspan=\'2\'><input type=\'hidden\' name=\'family_name\' id=\'family_name\' value=\"N\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t<td class=\'fields\'><select name=\'other_alt_id_type\' id=\'other_alt_id_type\'>\n\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="---</option>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</select><td>\n\t\t\t</tr>\n\t\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n</table>\n\t\t\t\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\t\n\t\t\t\t\t\t\t\n\t\t\t<tr><th class=\'columnheader\' style=\"text-align:left; color: white;\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</th></tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\t\n\t\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'nationality_code\' id=\'nationality_code\'  value=\"Y\"  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" ></td>\n\t\t\t\t<td colspan=\'2\'></td>\n\t\t\t</tr>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'sex\' id=\'sex\'  value=\"Y\" ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" >\n\t\t\t\t<td colspan=\'2\'></TD>\n\t\t\t</TR>\t\t\t\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\t\t\t\n\t\t\t<TR>\n\t\t\t\t<TD class=\'label\' width=\'145pts\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t<td class=\'label\' width=\'56pts\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'5%\'><input type=\'checkbox\' name=\'year_of_birth\' id=\'year_of_birth\'  value=\'Y\' ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'126pts\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t\t<td class=\'fields\'  width=\'5%\'><input type=\'checkbox\' name=\'month_of_birth\' id=\'month_of_birth\'   value=\'Y\' ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" onClick=\"chk_month(this)\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'215pts\'>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'day_of_birth\' id=\'day_of_birth\'  value=\'Y\' ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" onClick=\"chk_year(this)\">\n\t\t\t\t</td>\n\t\t\t</TR>\t\t\t\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\t\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t<TR>\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tdocument.forms[0].area_name_avail.value = \'Y\';\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t<TD class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</TD>\n\t\t\t\t\t<TD class=\'fields\' width=\'25%\'><INPUT type=\'checkbox\' name=\'res_area_code\' id=\'res_area_code\' value=\"Y\"  ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="></TD>\n\t\t\t\t\t<td colspan=\'2\'></TD>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\n\t\t\t<TR>\n\t\t\t\t<TD class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</TD>\n\t\t\t\t<TD class=\'fields\' width=\'25%\'><INPUT type=\'checkbox\' name=\'contact1_no\' id=\'contact1_no\'  value=\"Y\"  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" >\n\t\t\t\t</TD>\t\n\t\t\t\t<TD class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</TD>\n\t\t\t\t<TD class=\'fields\' width=\'25%\'><INPUT type=\'checkbox\' name=\'contact2_no\' id=\'contact2_no\'  value=\"Y\"  valign=\'center\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =">\n\t\t\t\t</TD>\t\t\t\t\n\t\t\t</TR>\t\n\t\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\t\t\n</TABLE>\n\n<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t\n\t\t<TR><TH class=\'columnheader\' style=\"text-align:left; color: white;\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</TH></TR>\n</table>\n<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\n\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\t\t<TR>\n\t\t\t\t<TD class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\t\n\t\t\t\t<TD class=\'fields\' colspan=\'3\'><SELECT name=\'search_type\' id=\'search_type\'>\n\t\t\t\t<OPTION value=\'A\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</OPTION>\n\t\t\t\t<OPTION value=\'L\' selected >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</OPTION><INPUT type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'></td>\t\t\t\n\t\t</TR>\t\n\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\t\t\t\n</TABLE>\n\t\t\n\t\t\t<SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\tdocument.forms[0].search_type.value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\';\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\tchk_year_month();\n\t\t</SCRIPT>\n\n\t\t<input type =\'hidden\' name =\'day_of_birth1\' value=\'\'>\n\t\t<input type =\'hidden\' name =\'month_of_birth1\' value=\'\'>\n\t\t<input type =\'hidden\' name =\'year_of_birth1\' value=\'\'>\n\t\t<input type =\'hidden\' name =\'names_in_oth_lang_yn\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\n\t\t<SCRIPT>\n\t\t\tdocument.forms[0].day_of_birth1.value   = document.forms[0].day_of_birth.value;\n\t\t\tdocument.forms[0].month_of_birth1.value = document.forms[0].month_of_birth.value;\n\t\t\tdocument.forms[0].year_of_birth1.value  = document.forms[0].year_of_birth.value;\n\t\t</SCRIPT>\n\t</form>\n\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String locale=(String)session.getAttribute("LOCALE");
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	ResultSet rs				= null;

	String str						= "";
	String name_loc_lang_yn			= "";
	String first_name 				= "";
	String second_name 				= "";
	String third_name 				= "";
	String family_name 				= "";
	String names_sndx_type			= "";
	String nationality_code			= "";
	String sex 						= "";
	String day_of_birth 			= "";
	String month_of_birth 			= "";
	String year_of_birth 			= "";
	String res_area_code 			= "";
	String contact1_no 				= "";
	String contact2_no				= "";
	String search_type 				= "";
	String first_name_init			= "";  
	String second_name_init			= "";
	String third_name_init			= "";
	String family_name_init			= "";
	String first_name_prompt		= "";	
	String second_name_prompt		= "";	
	String third_name_prompt		= "";	
	String family_name_prompt		= "";
	String dflt_sndx_type			= "";
	String area_type				= "";
	String name_loc_lang_yn_chk		= "";
	String first_name_chk 			= "";
	String second_name_chk 			= "";
	String third_name_chk 			= "";
	String family_name_chk 			= "";
	String nationality_code_chk		= "";
	String sex_chk 					= "";
	String day_of_birth_chk 		= "";
	String month_of_birth_chk 		= "";
	String year_of_birth_chk 		= "";
	String res_area_code_chk 		= "";
	String contact1_no_chk			= "";
	String contact2_no_chk			= "";
	String mode						= "";
	String disbl					= "";
	String first_name_reqd_yn		= "";
	String second_name_reqd_yn		= "";
	String third_name_reqd_yn		= "";
	String family_name_reqd_yn		= "";
	String p_sndx_n_selected		= "";
	String p_sndx_g_selected		= "";
	String short1					= "";
	String short2					= "";
	String short3					= "";
	String short4					= "";
	String alt1						= "";
	String alt2						= "";
	String alt3						= "";
	String alt4						= "";
	String short_desc1				= "";
	String short_desc2				= "";
	String short_desc3				= "";
	String short_desc4				= "";
	String p_other_alt_id_type		= "";
	String selected_val				= "";
	String names_in_oth_lang_yn		= "";
	String alt_id_type				= "";
	String short_desc				= "";
	//String str1						= "";
	String mysql					= "";
	String first_name_avail			= "N";
	String second_name_avail		= "N";	
	String third_name_avail			= "N";
	String family_name_avail		= "N";
	String area_name_avail			= "N"; 
	String short_desc11				= "N";
	String short_desc22				= "N";
	String short_desc33				= "N";
	String short_desc44				= "N";

	StringBuffer mysqlbuff = new StringBuffer();
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		str	= "";
		str = "SELECT * FROM dr_def_search_criteria";
		rs	= stmt.executeQuery(str);
		if(rs!= null && rs.next())
		{
			name_loc_lang_yn	= rs.getString("name_loc_lang_yn");
			first_name 			= rs.getString("first_name_yn");
			short1 				= rs.getString("ALT_ID1_NO_YN");
			short2 				= rs.getString("ALT_ID2_NO_YN");
			short3 				= rs.getString("ALT_ID3_NO_YN");
			short4 				= rs.getString("ALT_ID4_NO_YN");
			second_name 		= rs.getString("second_name_yn");
			third_name 			= rs.getString("third_name_yn");
			family_name 		= rs.getString("family_name_yn");
			names_sndx_type		= rs.getString("names_sndx_type");
			nationality_code	= rs.getString("nationality_code_yn");
			sex 				= rs.getString("sex_yn");
			day_of_birth 		= rs.getString("day_of_birth_yn");
			month_of_birth 		= rs.getString("month_of_birth_yn");
			year_of_birth 		= rs.getString("year_of_birth_yn");
			res_area_code 		= rs.getString("res_area_code_yn");
			contact1_no 		= rs.getString("contact1_no_yn");
			contact2_no			= rs.getString("contact2_no_yn");
			search_type 		= rs.getString("search_type");
			p_other_alt_id_type	= rs.getString("other_alt_id_type") == null?"":rs.getString("other_alt_id_type");
			
			mode 	= "update";
		}
		else
		{
			mode = "insert";
		}

		if(rs!= null) rs.close();		
		if(name_loc_lang_yn != null && name_loc_lang_yn.equals("Y")) {
			name_loc_lang_yn_chk	= "checked";
			disbl					= "disabled";
		}

		if(first_name != null && first_name.equals("Y"))  first_name_chk = "checked";
		if(second_name != null && second_name.equals("Y")) second_name_chk = "checked";
		if(third_name != null && third_name.equals("Y")) third_name_chk = "checked";
		if(family_name != null && family_name.equals("Y")) family_name_chk = "checked";
		if(nationality_code != null && nationality_code.equals("Y")) nationality_code_chk = "checked";
		if(sex != null && sex.equals("Y")) sex_chk = "checked";
		if(day_of_birth != null && day_of_birth.equals("Y")) day_of_birth_chk = "checked";
		if(month_of_birth != null && month_of_birth.equals("Y")) month_of_birth_chk = "checked";
		if(year_of_birth != null && year_of_birth.equals("Y")) year_of_birth_chk = "checked";
		if(res_area_code != null && res_area_code.equals("Y")) res_area_code_chk = "checked";
		if(contact1_no != null && contact1_no.equals("Y")) contact1_no_chk = "checked";
		if(contact2_no != null && contact2_no.equals("Y")) contact2_no_chk = "checked";
		if(short1!= null && short1.equals("Y")) short1 = "checked";
		if(short2!= null && short2.equals("Y")) short2 = "checked";
		if(short3!= null && short3.equals("Y")) short3 = "checked";
		if(short4!= null && short4.equals("Y")) short4 = "checked";
		if(search_type == null) search_type = "";

	
		str	= "";	 
		str	= "SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, nvl(first_name_prompt,'First Name')first_name_prompt, nvl(second_name_prompt,'Second Name')second_name_prompt,nvl(third_name_prompt,'Third Name')third_name_prompt,nvl(family_name_prompt,'Family Name')family_name_prompt , dflt_sndx_type, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, res_area_prompt, mp_get_desc.mp_alternate_id_type (alt_id1_type,'"+locale+"', 1) short_desc1,mp_get_desc.mp_alternate_id_type (alt_id2_type, '"+locale+"', 1) short_desc2,mp_get_desc.mp_alternate_id_type (alt_id3_type,'"+locale+"', 1) short_desc3,       mp_get_desc.mp_alternate_id_type (alt_id4_type, '"+locale+"', 1) short_desc4, ALT_ID1_TYPE, ALT_ID2_TYPE, ALT_ID3_TYPE, ALT_ID4_TYPE, names_in_oth_lang_yn FROM mp_param_lang_vw a,sm_site_param_lang_vw b  where a.language_id='"+locale+"' and b.language_id='"+locale+"'";
		
		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				 first_name_init		= rs.getString("first_name_accept_yn");
				 second_name_init		= rs.getString("second_name_accept_yn");
				 third_name_init		= rs.getString("third_name_accept_yn");
				 family_name_init		= rs.getString("family_name_accept_yn");
				 first_name_prompt		= rs.getString("first_name_prompt");
				 second_name_prompt		= rs.getString("second_name_prompt");
				 third_name_prompt		= rs.getString("third_name_prompt");
				 family_name_prompt		= rs.getString("family_name_prompt");
				 dflt_sndx_type			= rs.getString("dflt_sndx_type");
				 area_type				= rs.getString("res_area_prompt");
				 first_name_reqd_yn		= rs.getString("first_name_reqd_yn");
				 second_name_reqd_yn	= rs.getString("second_name_reqd_yn");
				 third_name_reqd_yn		= rs.getString("third_name_reqd_yn");
				 family_name_reqd_yn	= rs.getString("family_name_reqd_yn");
				 alt1					= rs.getString("ALT_ID1_TYPE");
				 alt2					= rs.getString("ALT_ID2_TYPE");
				 alt3					= rs.getString("ALT_ID3_TYPE");
				 alt4					= rs.getString("ALT_ID4_TYPE");
				 names_in_oth_lang_yn	= rs.getString("names_in_oth_lang_yn");
				 short_desc1 = rs.getString("short_desc1") == null?"":rs.getString("short_desc1"); 
				 short_desc2 = rs.getString("short_desc2") == null?"":rs.getString("short_desc2"); 
				 short_desc3 = rs.getString("short_desc3") == null?"":rs.getString("short_desc3"); 
				 short_desc4 = rs.getString("short_desc4") == null?"":rs.getString("short_desc4"); 
			}
		} if(rs!= null) rs.close();

          
		   
		if(dflt_sndx_type == null) dflt_sndx_type="";
		if(first_name_reqd_yn == null) first_name_reqd_yn="N";
		if(second_name_reqd_yn == null) second_name_reqd_yn="N";
		if(third_name_reqd_yn == null) third_name_reqd_yn="N";
		if(family_name_reqd_yn == null) family_name_reqd_yn="N";
		if(names_in_oth_lang_yn == null || names_in_oth_lang_yn.equals("null")) names_in_oth_lang_yn ="";

		//****** added by meghanath on 20/11/2004 ******//

		//mysql = "SELECT alt_id_type,short_desc short_desc FROM mp_alternate_id_type WHERE alt_id_type NOT IN (select alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT nvl(alt_id4_type,3) FROM mp_param) AND eff_status='E' order by 2";

		mysql = "SELECT alt_id_type, long_desc  FROM mp_alternate_id_type_LANG_VW WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT NVL(alt_id4_type,3) FROM mp_param) AND eff_status='E' AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	
		rs   = stmt.executeQuery(mysql);
		while(rs != null && rs.next())
		{
			alt_id_type	= rs.getString("alt_id_type");
			short_desc  = rs.getString("long_desc");

			if(alt_id_type == null || alt_id_type.equals("null")) alt_id_type = "";
			if(short_desc == null || short_desc.equals("null")) short_desc = "";

			if(alt_id_type.equals(p_other_alt_id_type)) { selected_val = "selected"; }
			else { selected_val = ""; }

			mysqlbuff.append("<option value='"+alt_id_type+"' "+selected_val+">"+short_desc+"</option>");
		} if(rs!= null) rs.close();

		//********************* end of addition ********************// 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(short_desc11));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc22));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(short_desc33));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc44));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(first_name_init));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(second_name_init));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(third_name_init));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(family_name_init));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(first_name_avail));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(second_name_avail));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(third_name_avail));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(family_name_avail));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(area_name_avail));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(first_name_reqd_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(second_name_reqd_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(third_name_reqd_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(family_name_reqd_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(names_in_oth_lang_yn.equals("Y")) { 
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(name_loc_lang_yn_chk));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } else { 
            _bw.write(_wl_block34Bytes, _wl_block34);
 } 
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
 
				if(names_sndx_type.equals("G")) 
				{
					p_sndx_n_selected = "";
					p_sndx_g_selected = "selected";
					
				}
				else if(names_sndx_type.equals("E"))
				{
					p_sndx_n_selected = "";
					p_sndx_g_selected = "";
					
				}
				else 
				{
					p_sndx_n_selected = "selected";
					p_sndx_g_selected = "";

				}
				if(dflt_sndx_type.equals("G"))
				{
					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disbl));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_sndx_n_selected));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_sndx_g_selected));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

					}
					else
					{
					
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disbl));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_sndx_n_selected));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
					
            _bw.write(_wl_block44Bytes, _wl_block44);
	
				if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block45Bytes, _wl_block45);

				}
				if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(first_name_chk));
            _bw.write(_wl_block49Bytes, _wl_block49);

				}
				else
				{
					
            _bw.write(_wl_block50Bytes, _wl_block50);

				}
				
            _bw.write(_wl_block51Bytes, _wl_block51);

				if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block52Bytes, _wl_block52);

				}
				if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(second_name_chk));
            _bw.write(_wl_block56Bytes, _wl_block56);

				}
				else
				{
					
            _bw.write(_wl_block57Bytes, _wl_block57);

				}
				if(alt1 != null)
				{
					
            _bw.write(_wl_block58Bytes, _wl_block58);
 
					}
				if(!short_desc1.equals("") && (short_desc1 != null))
				{
					
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc1));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(short1));
            _bw.write(_wl_block60Bytes, _wl_block60);
 
				}
				else
				{
					
            _bw.write(_wl_block61Bytes, _wl_block61);

				}
				
            _bw.write(_wl_block51Bytes, _wl_block51);

				if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block62Bytes, _wl_block62);

				}
				if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(third_name_chk));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
				else
				{
					
            _bw.write(_wl_block65Bytes, _wl_block65);

				}
				if(alt2 != null)
				{
					
            _bw.write(_wl_block66Bytes, _wl_block66);
 
				}
				if(!short_desc2.equals("") &&  short_desc2!=null)
				{
					
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(short_desc2));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(short2));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
				else
				{ 
					
            _bw.write(_wl_block61Bytes, _wl_block61);
 
				} 
				
            _bw.write(_wl_block69Bytes, _wl_block69);
	
				if(alt3 != null)
				{
					
            _bw.write(_wl_block70Bytes, _wl_block70);
 
				}
				if(!short_desc3.equals("") && short_desc3!=null)
				{
					
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(short_desc3));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(short3));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
				else
				{
					
            _bw.write(_wl_block61Bytes, _wl_block61);
 
				}
				
				if(alt4 != null)
				{
					
            _bw.write(_wl_block72Bytes, _wl_block72);

				}
				if(!short_desc4.equals("") && short_desc4!=null)
				{
					
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(short_desc4));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(short4));
            _bw.write(_wl_block75Bytes, _wl_block75);

				}
				else
				{
					
            _bw.write(_wl_block61Bytes, _wl_block61);

				}
				
            _bw.write(_wl_block51Bytes, _wl_block51);

				if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
				{
					
            _bw.write(_wl_block76Bytes, _wl_block76);

				}				 
				if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
				{	
					
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(family_name_chk));
            _bw.write(_wl_block79Bytes, _wl_block79);

				}
				else
				{
					
            _bw.write(_wl_block80Bytes, _wl_block80);

				}
				
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(mysqlbuff.toString()));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(nationality_code_chk));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sex_chk));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(year_of_birth_chk));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(month_of_birth_chk));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(day_of_birth_chk));
            _bw.write(_wl_block96Bytes, _wl_block96);
 
			if(area_type != null)
			{
				
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(res_area_code_chk));
            _bw.write(_wl_block99Bytes, _wl_block99);

			}
			
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(contact1_no_chk));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(contact2_no_chk));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block109Bytes, _wl_block109);

			if(!search_type.equals("")) 
			{ 
				
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(search_type));
            _bw.write(_wl_block111Bytes, _wl_block111);

			} 
			
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in DefaultSearchCriteria :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block114Bytes, _wl_block114);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.NameinLocalLanguage.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.SoundexAlgorithm.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.none.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generic.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.none.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.DemographicData.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.month.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.ResTelNo.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.OtherContactNo.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.ScopeofSearch.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.SearchType.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LoggedinFacility.label", java.lang.String .class,"key"));
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
}
