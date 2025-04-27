package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __mergepossiblepatidquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergePossiblePatIdQueryCriteria.jsp", 1742295048592L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped By       :  P.Sudhakaran\n\tDeveloped on   \t   :  22/02/2002\n\tReDeveloped on\t   :  22/02/2002\n\tModule Name \t   :  eHIS/eDR\n\tFunction Name\t   :  \n\tFunction ID        :  \n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergeDuplicatePatient.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<!-- <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n\t<script>\n\tfunction EnbDsbChkbox()\n\t{\n\t\tif(document.getElementById(\'other_alt_id_type\').value == \'\')\n\t\t{\n\t\t\tdocument.getElementById(\'other_alt_id_chk\').checked = \'\';\n\t\t\tdocument.getElementById(\'other_alt_id_chk\').disabled = true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'other_alt_id_chk\').disabled = false;\n\t\t\tdocument.getElementById(\'other_alt_id_chk\').checked = \'\';\n\t\t}\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\terrors = getMessage(\"SEARCH_ALL_FACILITY\",\"DR\");\n\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\terrors = getMessage(\"SHD_NOT_BE_BLANK\",\"DR\");\n\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\terrors = getMessage(\"NO_RECORD\",\"DR\");\n\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\t\terrors = getMessage(\"DECEASED_PATIENT\",\"DR\");\n\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<form name=\'Search_criteria_form\' id=\'Search_criteria_form\' action=\'../../servlet/eDR.MergeDuplicateForPatientServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<input type=\'hidden\' name=\'first_name_avail\' id=\'first_name_avail\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=\'hidden\' name=\'second_name_avail\' id=\'second_name_avail\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'third_name_avail\' id=\'third_name_avail\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<input type=\'hidden\' name=\'family_name_avail\' id=\'family_name_avail\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<input type=\'hidden\' name=\'area_name_avail\' id=\'area_name_avail\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t<input type=\'hidden\' name=\'generic_sndx_first\' id=\'generic_sndx_first\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<input type=\'hidden\' name=\'generic_sndx_second\' id=\'generic_sndx_second\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t<input type=\'hidden\' name=\'generic_sndx_third\' id=\'generic_sndx_third\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t<input type=\'hidden\' name=\'generic_sndx_family\' id=\'generic_sndx_family\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t<input type=\'hidden\' name=\'generic_sndx_first_second\' id=\'generic_sndx_first_second\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'generic_sndx_first_family\' id=\'generic_sndx_first_family\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ethnic_sndx_first\' id=\'ethnic_sndx_first\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ethnic_sndx_second\' id=\'ethnic_sndx_second\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ethnic_sndx_third\' id=\'ethnic_sndx_third\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ethnic_sndx_family\' id=\'ethnic_sndx_family\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ethnic_sndx_first_second\' id=\'ethnic_sndx_first_second\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ethnic_sndx_first_family\' id=\'ethnic_sndx_first_family\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'first_name_loc_lang\' id=\'first_name_loc_lang\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'second_name_loc_lang\' id=\'second_name_loc_lang\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'third_name_loc_lang\' id=\'third_name_loc_lang\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'family_name_loc_lang\' id=\'family_name_loc_lang\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'all_facil\' id=\'all_facil\' value=\'\'>\n\n\t\t\t\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n\t\t\t\t\t\n\t\t<tr><th class=\'columnheader\' colspan=\'4\' style=\"text-align:left;\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</th></tr>\n\t\t<tr><td class=\'label\' colspan=\'4\'>&nbsp;</td></tr>\n\t</table>\n\n\t<table border=\'0\' cellpadding=\'1\' cellspacing=\'0\' width=\'100%\' >\t\t\t\t\n\t\t<tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\n\t\t\t<td  width=\'25%\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t\t\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'name_loc_lang_yn\' id=\'name_loc_lang_yn\'  value=\'\' align=\'left\' onClick=\"disable_soundex()\"></td>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\n\t\t\t<td class=\'label\' colspan=\'2\' width=\'50%\'>&nbsp;</td>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\n\t\t\t<td  width=\'25%\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'nationality_desc\' id=\'nationality_desc\' size=\'20\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' readonly><input type=\'hidden\' name=\'nationality\' id=\'nationality\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\'checkbox\' name=\'nationality_chk\' id=\'nationality_chk\'  disabled checked value=\'\' align=\'left\' ></td>\t\n\t\t</tr>\n\t\t\t\t\n\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.getElementById(\'first_name_avail\').value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\'  class=\'label\'  nowrap  >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'first_name\' id=\'first_name\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' readonly><input type=\'checkbox\' name=\'first_name_chk\' id=\'first_name_chk\'  value=\'\'></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\n\t\t\t\t\t<td colspan=\'2\' width=\'50%\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.getElementById(\'second_name_avail\').value=\'Y\';\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\'   class=\'label\'  nowrap >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'second_name\' id=\'second_name\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' readonly><input type=\'checkbox\' name=\'second_name_chk\' id=\'second_name_chk\' value=\'\' ></td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<td class=\'label\' colspan=\'2\' width=\'50%\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t           document.getElementById(\'third_name_avail\').value=\'Y\';\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td  width=\'25%\' class=\'label\'  nowrap >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'third_name\' id=\'third_name\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' readonly ><input type=\'checkbox\' name=\'third_name_chk\' id=\'third_name_chk\'  value=\'\' align=\'left\' ></td>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' colspan=\'2\' width=\'50%\'></td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'family_name_avail\').value=\'Y\';\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  width=\'25%\'   class=\'label\'  nowrap >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'family_name\' id=\'family_name\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' readonly><input type=\'checkbox\' name=\'family_name_chk\' id=\'family_name_chk\'  value=\'\' align=\'left\' ></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td colspan=\'2\' width=\'50%\'></td>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\n\t\t\t</tr>\n\t\t\t<tr>\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td  class=\'fields\' width=\'25%\'><input type=\'text\' name=\'gender\' id=\'gender\' size=\'20\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' readonly><input type=\'hidden\' name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'><input type=\'checkbox\' name=\'sex_chk\' id=\'sex_chk\'  value=\'\' align=\'left\' ></td>\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.getElementById(\'all_facil\').value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\'><input type=\'checkbox\' name=\'search_all_chk\' id=\'search_all_chk\'  value=\'\' align=\'left\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" ></td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t<td colspan=\'2\' width=\'50%\'><input type=hidden name=\'\' id=\'\' value=\'\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\'  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'dob\' id=\'dob\' size=\'20\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' readonly ><input type=\'checkbox\' name=\'dob_chk\' id=\'dob_chk\'  value=\'\' align=\'left\' onclick=\"active_by();\"></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\'  class=\'label\' nowrap >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\"25%\"><Select name=\"by_date\" id=\"by_date\" disabled>\t\t\t\t\t\t\n\t\t\t\t\t<Option value=\"Y\" Selected>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t<Option value=\"MY\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="& ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t<Option value=\"D\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</Select>\n\t\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'contact1_no\' id=\'contact1_no\' size=\'20\' maxlength=\'18\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' readonly><input type=\'checkbox\' name=\'contact1_no_chk\' id=\'contact1_no_chk\'  value=\'\'></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'contact2_no\' id=\'contact2_no\' size=\'20\' maxlength=\'18\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' readonly><input type=\'checkbox\' name=\'contact2_no_chk\' id=\'contact2_no_chk\' value=\'\'></td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tdocument.forms[0].area_name_avail.value=\'Y\';\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\'label\'  nowrap>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'area_type_desc\' id=\'area_type_desc\' size=\'20\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' readonly><input type=\'hidden\' name=\'area_type\' id=\'area_type\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'><input type=\'checkbox\' name=\'area_chk\' id=\'area_chk\'  value=\'\' align=\'left\'></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t<td class=\'label\' colspan=\'2\' width=\'50%\'></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  class=\'fields\' width=\'25%\'><Select name=\"names_sndx_type\" id=\"names_sndx_type\">\n\t\t\t\t\t\t\t\t<Option value=\"N\" selected >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<Option value=\"E\"  >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<Option value=\"G\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t</Select>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'other_alt_id_type\' id=\'other_alt_id_type\' onChange=\'EnbDsbChkbox();\'>\n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="---</option>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</select>\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'other_alt_id_chk\' id=\'other_alt_id_chk\'  value=\'\' align=\'left\' disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\'2\' width=\'50%\'>&nbsp;</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- //********************* end ********************// -->\n\t\t\t\t</tr>\n\t\t</table>\n\t\t\t\t\t\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr><td class=\'label\' colspan=\'4\' width=\'100%\'>&nbsp;</td></tr>\n\t\t\t\t\t\t\n\t\t\t\t<tr>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td colspan=\'2\' class=\'fields\' width=\'50%\'>\n\t\t\t\t\t\t\t<input type=\'button\' name=\'accept\' id=\'accept\' class=\'button\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' disabled onclick=\'invoke_access();\'><input type=\'button\' name=\'identify\' id=\'identify\' class=\'button\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' disabled onclick=\'invoke_identify();\'><input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' name=\'start_now\' disabled onClick=\'start_nowClick();\' ><input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' disabled name=\'start_later\' onClick=\'later_Click();\' ></td>\n\n\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\' colspan=\'1\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="&";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\t\n\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'1\'>\n\t\t\t\t\t\t\t<input type=\'text\' size=\'20\' disabled name=\'start_later_time\' id=\'start_later_time\'  id=\"startlater\" value=\'\' onBlur=\"validDateObj(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\');\" ><input type=\'image\' id=\"datepicker\" disabled  name=\"calendertime\" id=\"calendertime\"  src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.getElementById(\'start_later_time\').focus(); return showCalendar(\'startlater\',null,\'hh:mm\');\"><!-- <input type=\'button\' name=\'identify\' id=\'identify\' class=\'button\' value=\'Identify Dup\' disabled onclick=\'invoke_identify()\';></input> --><!-- <input type=\'button\' name=\'merge\' id=\'merge\' class=\'button\' value=\'Merge Dup\' disabled onclick=\'invoke_merge()\';></input> --></td>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</tr>\t\n\t\t\t\t<tr><td class=\'label\' colspan=\'4\' width=\'100%\'>&nbsp;</td></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'3\' width=\'75%\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'button\' width=\'25%\' colspan=\'1\'>\n\t\t\t\t\t\t\t<!-- <input type=\'button\' name=\'previous\' id=\'previous\' class=\'button\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' onClick=\"call_previous(\'1\',\'10\');\" disabled><input type=\'button\' name=\'next\' id=\'next\' class=\'button\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' onClick=\"call_next(\'1\',\'10\');\" disabled> --><input type=\'button\' name=\'search\' id=\'search\' class=\'button\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' onclick=\"bulid_query();\"></input>\n\t\t\t\t\t</td>\t\n\t\t\t\t</tr>\t\n\t\t\t\t<tr><td class=\'label\' colspan=\'4\' width=\'100%\'>&nbsp;</td></tr>\n\t\t</table>\n\t\t\t\t\t<input type=hidden name=\'final_query\' id=\'final_query\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'count_record\' id=\'count_record\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'p_p_line\' id=\'p_p_line\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'day_of_birth_yn\' id=\'day_of_birth_yn\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'month_of_birth_yn\' id=\'month_of_birth_yn\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'year_of_birth_yn\' id=\'year_of_birth_yn\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'patient_id_for\' id=\'patient_id_for\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'name_loc_lang_ser\' id=\'name_loc_lang_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'first_name_ser\' id=\'first_name_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'second_name_ser\' id=\'second_name_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'third_name_ser\' id=\'third_name_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'family_name_ser\' id=\'family_name_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'names_sndx_ser\' id=\'names_sndx_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'nationality_ser\' id=\'nationality_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'sex_ser\' id=\'sex_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'area_ser\' id=\'area_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'contact1_no_ser\' id=\'contact1_no_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'contact2_no_ser\' id=\'contact2_no_ser\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'search_all_ser\' id=\'search_all_ser\' value=\'\'>\n\t\t\t\t\t<input type =\'hidden\' name =\'names_in_oth_lang_yn\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t\t\t\t<input type=hidden name =\'process_start\' value=\'\'>\n\t\t\t\t\t<input type=hidden name =\'modal\' value=\'Y\'>\n\t\t\t\t\t<input type=hidden name =\'p_line1\' value=\'Y\'>\n\t\t\t\t</form>\n\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con				= null;
	java.sql.Statement stmt	= null;
	ResultSet rs				= null;

	
	String str							= "";
	String first_name 					= "";
	String second_name 					= "";
	String third_name 					= "";
	String family_name 					= "";
	String nationality_code				= "";
	String sex 							= "";
	String res_area_code 				= "";
	String contact1_no 					= "";
	String contact2_no					= "";
	String first_name_init				= "";  
	String second_name_init				= "";
	String third_name_init				= "";
	String family_name_init				= "";
	String first_name_prompt			= "";	
	String second_name_prompt			= "";	
	String third_name_prompt			= "";	
	String family_name_prompt			= "";
	String dflt_sndx_type				= "";
	String area_type					= "";
	String name_in_loc_lang				= "";
	String hit_limit					= "";
	String date_of_birth				= "";
	String generic_sndx_first			= "";	           
	String generic_sndx_second			= "";	           
	String generic_sndx_third			= "";	           
	String generic_sndx_family			= "";	           
	String generic_sndx_first_second	= "";	     
	String generic_sndx_first_family	= "";	      
	String ethnic_sndx_first			= "";	              
	String ethnic_sndx_second			= "";	            
	String ethnic_sndx_third			= "";	             
	String ethnic_sndx_family			= "";	            
	String ethnic_sndx_first_second		= "";	       
	String ethnic_sndx_first_family		= "";
	String first_name_loc_lang			= "";
	String second_name_loc_lang			= "";
	String third_name_loc_lang			= "";
	String family_name_loc_lang			= "";
	String check_dr_param	= "";
	String check_user_rights	= "";
	String sel_gen						= "";
	String deceased_yn					= "";
	String search_all					= "";
	String nationality_desc				= "";
	String res_area_desc				= "";
	String gender						= "";
	String names_in_oth_lang_yn			= "";
	String alt_id_type					= "";
	String short_desc					= "";
	String mysql						= "";
	String select_value					= "";
	String first_name_avail				= "N";
	String second_name_avail			= "N";	
	String third_name_avail				= "N";
	String family_name_avail			= "N";
	String area_name_avail				= "N"; 
	String record_avail					= "N";
    String locale=(String)session.getAttribute("LOCALE");
	Properties p		= (Properties) session.getValue("jdbc");
	String addedById	= p.getProperty("login_user");
	StringBuffer mysqlbuff = new StringBuffer();

	String patient_id		= request.getParameter("patient_id");

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		
		str="";
		str="SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, NVL(first_name_prompt,'First Name') first_name_prompt,NVL(second_name_prompt,'Second Name') second_name_prompt ,NVL(third_name_prompt,'Third Name') third_name_prompt , NVL(family_name_prompt,'Family Name') family_name_prompt , dflt_sndx_type, res_area_prompt,search_threshold_records, names_in_oth_lang_yn FROM mp_param_lang_vw a, sm_site_param_lang_vw b WHERE a.language_id = '"+locale+"' AND b.language_id = '"+locale+"'";
		
		rs	    =stmt.executeQuery(str);
		if(rs!=null)
		{
			if(rs.next())
			{

				first_name_init			=rs.getString("first_name_accept_yn");
				second_name_init		=rs.getString("second_name_accept_yn");
				third_name_init			=rs.getString("third_name_accept_yn");
				family_name_init		=rs.getString("family_name_accept_yn");
				first_name_prompt		=rs.getString("first_name_prompt");
				second_name_prompt		=rs.getString("second_name_prompt");
				third_name_prompt		=rs.getString("third_name_prompt");
				family_name_prompt		=rs.getString("family_name_prompt");
				dflt_sndx_type			=rs.getString("dflt_sndx_type");
				area_type				=rs.getString("res_area_prompt");
				hit_limit				=rs.getString("search_threshold_records");	 	
				names_in_oth_lang_yn	=rs.getString("names_in_oth_lang_yn");

				
			}
		
			if(dflt_sndx_type !=null && dflt_sndx_type.equals("G")) sel_gen="selected";
			if(names_in_oth_lang_yn == null || names_in_oth_lang_yn.equals("null")) 						names_in_oth_lang_yn="";

		} if(rs != null) rs.close();

		if(hit_limit==null) hit_limit="";
		
		String str_mp="";
		
		str_mp=	"SELECT  a.*, a.sex gender, TO_CHAR(a.date_of_birth, 'dd/mm/yyyy')date_of_birth_for, mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc, mp_get_desc.MP_Country(a.nationality_code,'"+locale+"',3) nationality_desc FROM mp_patient a WHERE  patient_id = '"+patient_id+"'";
		
		//str_mp="SELECT a.*, decode(a.sex,'F','Female','M','Male','Unknown') gender, to_char(a.date_of_birth,'dd/mm/yyyy')date_of_birth_for, res.short_desc res_area_desc, cntry.long_desc nationality_desc FROM mp_patient a, mp_country cntry, mp_res_area res WHERE patient_id = '"+patient_id+"' AND a.res_area_code = res.res_area_code(+) AND a.nationality_code = cntry.country_code(+)";

		rs	= stmt.executeQuery(str_mp);
		if(rs != null)
		{
			if(rs.next())
			{
				record_avail="Y";

				first_name					= rs.getString("first_name");
				second_name					= rs.getString("second_name");
				third_name					= rs.getString("third_name");
				family_name					= rs.getString("family_name");
				nationality_code			= rs.getString("nationality_code");
				sex							= rs.getString("sex");
				gender						= rs.getString("gender");

			if(gender.equals("M"))					gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(gender.equals("F"))						  							gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(gender.equals("U"))						  							gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				date_of_birth				= rs.getString("date_of_birth_for");
				date_of_birth=DateUtils.convertDate(date_of_birth,"DMY","en",locale);
				contact1_no					= rs.getString("contact1_no");
				res_area_code				= rs.getString("res_area_code");
				contact2_no					= rs.getString("contact2_no");
				name_in_loc_lang			= rs.getString("patient_name_loc_lang");
				generic_sndx_first			= rs.getString("generic_sndx_first");	 
				generic_sndx_second			= rs.getString("generic_sndx_second");
				generic_sndx_third			= rs.getString("generic_sndx_third");	 
				generic_sndx_family			= rs.getString("generic_sndx_family");
				generic_sndx_first_second	= rs.getString("generic_sndx_first_second");
				generic_sndx_first_family	= rs.getString("generic_sndx_first_family");
				ethnic_sndx_first			= rs.getString("ethnic_sndx_first");
				ethnic_sndx_second			= rs.getString("ethnic_sndx_second");
				ethnic_sndx_third			= rs.getString("ethnic_sndx_third");
				ethnic_sndx_family			= rs.getString("ethnic_sndx_family");
				ethnic_sndx_first_second	= rs.getString("ethnic_sndx_first_second");
				ethnic_sndx_first_family	= rs.getString("ethnic_sndx_first_family");
				first_name_loc_lang			= rs.getString("first_name_loc_lang");
				second_name_loc_lang		= rs.getString("second_name_loc_lang");
				third_name_loc_lang			= rs.getString("third_name_loc_lang");
				family_name_loc_lang		= rs.getString("family_name_loc_lang");
				deceased_yn					= rs.getString("deceased_yn");
				nationality_desc			= rs.getString("nationality_desc");
				res_area_desc				= rs.getString("res_area_desc");

				if(nationality_desc==null) nationality_desc = "";
				if(res_area_desc==null) res_area_desc = "";
			}
		} if(rs != null) rs.close();
		
		if(name_in_loc_lang ==null) name_in_loc_lang="";
		if(first_name ==null) first_name="";
		if(second_name ==null) second_name="";
		if(third_name ==null) third_name="";
		if(family_name ==null) family_name="";
		if(nationality_code ==null) nationality_code="";
		if(sex ==null) sex="";
		if(date_of_birth ==null) date_of_birth="";
		if(contact1_no ==null) contact1_no="";
		if(res_area_code ==null) res_area_code="";
		if(contact2_no ==null) contact2_no="";
		if(name_in_loc_lang ==null) name_in_loc_lang="";
		if(generic_sndx_first ==null) generic_sndx_first="";
		if(generic_sndx_second ==null) generic_sndx_second="";
		if(generic_sndx_third ==null) generic_sndx_third="";
		if(generic_sndx_family ==null) generic_sndx_family="";
		if(generic_sndx_first_second ==null) generic_sndx_first_second="";
		if(generic_sndx_first_family ==null) generic_sndx_first_family="";
		if(ethnic_sndx_first ==null) ethnic_sndx_first="";
		if(ethnic_sndx_second ==null) ethnic_sndx_second="";
		if(ethnic_sndx_third ==null) ethnic_sndx_third="";
		if(ethnic_sndx_family ==null) ethnic_sndx_family="";
		if(ethnic_sndx_first_second ==null) ethnic_sndx_first_second="";
		if(ethnic_sndx_first_family ==null) ethnic_sndx_first_family="";
		if(first_name_loc_lang ==null) first_name_loc_lang="";
		if(second_name_loc_lang ==null) second_name_loc_lang="";
		if(third_name_loc_lang ==null) third_name_loc_lang="";
		if(family_name_loc_lang ==null) family_name_loc_lang="";

		String str_dr = "SELECT search_across_facility_yn FROM dr_param"; 	
	
		rs = stmt.executeQuery(str_dr);
		if(rs!=null)
		{
			if(rs.next())
			{
				check_dr_param = rs.getString("search_across_facility_yn")==null?"":rs.getString("search_across_facility_yn");				 			
			} 
		} if(rs != null) rs.close();
	
		String str_user_rights = "SELECT search_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' "; 
		
		rs = stmt.executeQuery(str_user_rights);
		if(rs!=null)
		{
			if(rs.next())
			{
				check_user_rights = rs.getString("search_privilege_level")==null?"":rs.getString("search_privilege_level"); 							
			} 
		} if(rs != null) rs.close(); 
		
		if(check_dr_param.equals("Y") && check_user_rights.equals("A"))
		{
			search_all="checked";
			
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		
		if(record_avail.equals("N"))
		{
			if(patient_id.equals("")){
            _bw.write(_wl_block10Bytes, _wl_block10);
} else {
            _bw.write(_wl_block11Bytes, _wl_block11);
}
		}
		else
		{
			if(deceased_yn !=null && deceased_yn.equals("Y")){
			
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		else
		{ 
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(first_name_avail));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(second_name_avail));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(third_name_avail));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(family_name_avail));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(area_name_avail));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(generic_sndx_first));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(generic_sndx_second));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(generic_sndx_third));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(generic_sndx_family));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(generic_sndx_first_second));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(generic_sndx_first_family));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ethnic_sndx_first));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ethnic_sndx_second));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ethnic_sndx_third));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ethnic_sndx_family));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ethnic_sndx_first_second));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ethnic_sndx_first_family));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
	if(first_name_prompt != null && !(first_name_prompt.equals("")) && first_name_init != null && first_name_init.equals("Y"))
					{
							
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);

							}
					
						
            _bw.write(_wl_block47Bytes, _wl_block47);
	if(second_name_prompt != null && !(second_name_prompt.equals("")) && second_name_init != null && second_name_init.equals("Y"))
							{
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);

							}
						
            _bw.write(_wl_block52Bytes, _wl_block52);

							
							
							if(third_name_prompt != null && !(third_name_prompt.equals("")) && third_name_init != null && third_name_init.equals("Y"))
							{
						
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block55Bytes, _wl_block55);
} else { 
            _bw.write(_wl_block56Bytes, _wl_block56);
  } 

						
							

						if(family_name_prompt != null && !(family_name_prompt.equals("")) && family_name_init != null && family_name_init.equals("Y"))
							{
								
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{ 
            _bw.write(_wl_block60Bytes, _wl_block60);

							}
							
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block64Bytes, _wl_block64);

					if(check_dr_param.equals("Y") && check_user_rights.equals("A")) {
					
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(search_all));
            _bw.write(_wl_block67Bytes, _wl_block67);

					} else {
					
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

							String contact1_no_prompt = "";
							String contact2_no_prompt = "";

							String csql = "SELECT short_desc,contact_mode FROM mp_contact_mode_lang_vw WHERE contact_mode IN ('PRN','ORN') AND EFF_STATUS ='E' and language_id='"+locale+"' ORDER BY contact_mode desc";
							rs = stmt.executeQuery(csql);
							if (rs.next())
							{
								contact1_no_prompt = rs.getString(1);
							}
							
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(contact1_no_prompt));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(contact1_no));
            _bw.write(_wl_block79Bytes, _wl_block79);

							if (rs.next())
							{
								contact2_no_prompt = rs.getString(1);
							} if(rs != null) rs.close();
							
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(contact2_no_prompt));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
 if(area_type != null && !(area_type.equals(""))) { 
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block86Bytes, _wl_block86);

								}else{
							
            _bw.write(_wl_block87Bytes, _wl_block87);

								}
							
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
	if(dflt_sndx_type !=null && dflt_sndx_type.equals("E")) { 
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
 } else if(dflt_sndx_type !=null && dflt_sndx_type.equals("G")) { 
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(sel_gen));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
 } 
            _bw.write(_wl_block95Bytes, _wl_block95);

							//****** abbed by meghanath on 24/11/2004 ******//
							mysql = "SELECT alt_id_type,long_desc  FROM mp_alternate_id_type_lang_vw WHERE alt_id_type NOT IN (select alt_id1_type FROM mp_param UNION SELECT NVL(alt_id2_type,1) FROM mp_param UNION SELECT NVL(alt_id3_type,2) FROM mp_param UNION SELECT nvl(alt_id4_type,3) FROM mp_param) and language_id='"+locale+"' AND eff_status='E' order by 2";
							
							rs   = stmt.executeQuery(mysql);
							while(rs != null && rs.next())
							{
								alt_id_type = rs.getString("alt_id_type");
								short_desc = rs.getString("long_desc");
								if(alt_id_type == null || alt_id_type.equals("null")) alt_id_type = "";
								if(short_desc == null || short_desc.equals("null")) short_desc = "";
								
								mysqlbuff.append("<option value='"+alt_id_type+"' "+select_value+">"+short_desc+"</option>");
							} if(rs != null) rs.close();
							
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(mysqlbuff.toString()));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);

			}
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e);
	}
	finally
	{
		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block111Bytes, _wl_block111);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.DuplicateSearchCriteria.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.SearchinallFacilities.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.month.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.soundex.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.none.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ethnic.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generic.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.IdentifyDuplicate.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.StartNow.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.StartLater.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
