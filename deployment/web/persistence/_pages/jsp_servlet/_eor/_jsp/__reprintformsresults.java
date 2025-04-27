package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __reprintformsresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ReprintFormsResults.jsp", 1709119976000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="   \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--  -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ReprintForms.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t\n\t<STYLE TYPE=\"text/css\">\n       \tA:link\n       \t {\n       \t     COLOR: blue;\n       \t }\n     \tA:visited\n     \t {\n             COLOR: blue ;\n         }\n        A:active\n         {\n             COLOR: red;\n         }\n       \n\t</STYLE>\n\t<SCRIPT>\n\tfunction alignHeading()\n\t{\n\t\t\n\t\tif(parent.ReprintFormsHeader.document.getElementById(\"TitleTab\") != null) \n\t\t{\n\t\t\t\n\t\t\tparent.ReprintFormsHeader.document.getElementById(\"TitleTab\").width =\teval(document.getElementById(\"reprint_table\").offsetWidth);\n\t\t\t\t\n\t\t\tvar last_row = eval(document.getElementById(\"reprint_table\").rows.length)-1;\n\t\t\tfor (j=0; j < document.getElementById(\"reprint_table\").rows(last_row).cells.length; j++) \n\t\t\t{\n\t\t\t\tvar wid=eval(document.getElementById(\"reprint_table\").rows(last_row).cells(j).offsetWidth);\n\t\t\t\tif(parent.ReprintFormsHeader.document.getElementById(\"TitleTab\").rows(0).cells(j) != null)\n\t\t\t\t{\n\t\t\t\t\tparent.ReprintFormsHeader.document.getElementById(\"TitleTab\").rows(0).cells(j).width=wid;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tsetTimeout(\"alignHeading();\",300);\n\t\t}\n\t}\n\t</SCRIPT>\n\n</head>\n<body onload=\'alignHeading();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.ReprintFormsSearch.document.reprint_forms_search.search_btn.disabled = false;\n\t\t\tparent.ReprintFormsHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.ReprintFormsResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.ReprintFormsBtn.location.href = \"../../eCommon/html/blank.html\"\n\t\t</script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\'reprint_forms_dtl\' id=\'reprint_forms_dtl\'  method=\"post\" action=\"../../eOR/jsp/ReprintFormsResults.jsp\">\n<table cellpadding=0 cellspacing=0 border=1 width=\"101%\" class=\"grid\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<TR>\n\t\t\t<!--<td width=\'6%\' class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' wrap> <font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>-->\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></td>\n\t\t\t<td width=\'25%\' class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' wrap> <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></font></td>\n\t\t\t<td width=\'40%\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font></td>\n\t\t\t<td width=\'9%\' class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font></td>\n\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' align=\'center\'> <input type=\'checkbox\' name=\'chk";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'chk";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'N\' onClick=\'changeCheckValue(this,\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" style=\"display:";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<A class=\'gridLink\' HREF=\"#\" title=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onClick=\"callConsent(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\"><FONT SIZE=\"1\" ><B>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</B></FONT></A><br>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\n\t\t\t</td>\n\n\n\t\t\t<input type=\'hidden\' name=\'ord_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'ord_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ord_cat";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'ord_cat";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pat_class";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'pat_class";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pat_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'pat_id";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'encounter_id";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'encounter_id";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_date_time";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'order_date_time";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\'catalog_code";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'catalog_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t<input type=\'hidden\' name=\'source_types";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'source_types";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\'source_code";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'source_code";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t<input type=\'hidden\' name=\'priority";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'priority";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_type";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'order_type";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_type_desc";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'order_type_desc";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ord_pract_id";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'ord_pract_id";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_status";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'order_status";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_line_num";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'order_line_num";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t<input type=\'hidden\' name=\'cont_order_ind";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'cont_order_ind";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t<input type=\'hidden\' name=\'facility_id";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'facility_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t<input type=\'hidden\' name=\'location_type";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'location_type";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\t<input type=\'hidden\' name=\'location_code";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'location_code";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t<input type=\'hidden\' name=\'report_srl_no";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'report_srl_no";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t</TR>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t<input type=\'hidden\' name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t<!-- Next, Prev --> \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n<!-- Next, Prev Till here--> \n\n\t<input type=\'hidden\' name=\'report_type\' id=\'report_type\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>  ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t<input type=\'hidden\' name=\'date_from\' id=\'date_from\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t<input type=\'hidden\' name=\'date_to\' id=\'date_to\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t<input type=\'hidden\' name=\'locn2\' id=\'locn2\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<input type=\'hidden\' name=\'locn1\' id=\'locn1\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t<input type=\'hidden\' name=\'order_type\' id=\'order_type\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t<input type=\'hidden\' name=\'encntr_id\' id=\'encntr_id\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\'hidden\' name=\'rep_type\' id=\'rep_type\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n\t<input type=\'hidden\' name=\'ord_cat\' id=\'ord_cat\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n\n\t<input type=\'hidden\' name=\'ord_type\' id=\'ord_type\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n\t<input type=\'hidden\' name=\'source_from\' id=\'source_from\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t<input type=\'hidden\' name=\'source_to\' id=\'source_to\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t<input type=\'hidden\' name=\'locntype\' id=\'locntype\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t<input type=\'hidden\' name=\'locn\' id=\'locn\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\n</Table>\n<script>\nparent.ReprintFormsSearch.document.reprint_forms_search.search_btn.disabled = false;\n</script>\n</Form>\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String mode			= "1";//request.getParameter( "mode" ) ;

	String report_type	= request.getParameter("rep_type");
	String ord_cat 		= request.getParameter( "ord_cat" ) ;
	String ord_type 	= request.getParameter( "ord_type" ) ;
	String source_type 	= request.getParameter( "source_type" ) ;
	String source_from	= request.getParameter("source_from");
	String source_to	= request.getParameter("source_to");
	String locntype		= request.getParameter("locntype");
	String locn 		= request.getParameter( "locn" ) ;
	String patient_id 	= request.getParameter( "patientId" ) ;
	String encntr_id 	= request.getParameter( "encntr_id" ) ;
	String order_id 	= request.getParameter( "order_id" ) ;
	String date_from 	= request.getParameter( "date_from" ) ;
	String date_to 		= request.getParameter( "date_to" ) ;
	String total_query_records="0";

	report_type			= (report_type == null) ? "":report_type.trim();
	ord_cat 			= (ord_cat == null)? "":ord_cat.trim();
	ord_type 			= (ord_type == null)?"":ord_type.trim();
	source_type 		= (source_type == null)?"":source_type.trim();
	source_from 		= (source_from == null)?"":source_from.trim();
	locn 				= (locn == null)?"":locn.trim();
	patient_id 			= (patient_id == null)?"":patient_id.trim();
	encntr_id 			= (encntr_id == null)?"":encntr_id.trim();
	order_id 			= (order_id == null)?"":order_id.trim();
	date_from 			= (date_from == null)?"":date_from.trim();
	date_to 			= (date_to == null)?"":date_to.trim();

	/*System.out.println("#####report_type"+report_type);
	System.out.println("#####ord_cat"+ord_cat);
	System.out.println("#####ord_type"+ord_type);
	System.out.println("#####source_type"+source_type);
	System.out.println("#####source_from"+source_from);
	System.out.println("#####locn"+locn);
	System.out.println("#####patient_id"+patient_id);
	System.out.println("#####encntr_id"+encntr_id);
	System.out.println("#####order_id"+order_id);
	System.out.println("#####date_from"+date_from);
	System.out.println("#####date_to"+date_to);*/
	
	//String function_id 	= request.getParameter( "function_id" ) ;
	String bean_id 		= "ReprintFormsBean" ;
	String bean_name 	= "eOR.ReprintFormsBean";

	String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id");

	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";
//out.println("facility_id:"+facility_id);
//out.println(">"+practitioner_id+"<<br>");
//out.println(">"+resp_id+"<");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	ReprintFormsBean bean = (ReprintFormsBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
 
	allValues		= bean.getSearchDetails(report_type,ord_cat,ord_type,order_id,date_from,date_to,source_type,source_from,source_to,patient_id,encntr_id,facility_id,start,end);

	//out.println("<script>alert("+allValues.size()+")</script>");
	 
/* Initialize Function specific end */
//out.println("<script>alert('allValues.size()="+allValues.size()+"');</script>");
//out.println("<script>alert('report_type="+report_type+"');</script>");

	if(allValues.size() == 0){

            _bw.write(_wl_block10Bytes, _wl_block10);
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

	String slClassValue = "";
		//int i = 0;
	for(int i=0; i<allValues.size(); i++){
			String[] reprint_details = (String[])allValues.get(i);
		if(i==0){
			if(report_type.equalsIgnoreCase("R")){
				if(reprint_details[25] != null)
				total_query_records=bean.checkForNull((String)reprint_details[25],"0");}
			else if (report_type.equalsIgnoreCase("C")){
				if(reprint_details[27] != null)
				total_query_records=bean.checkForNull((String)reprint_details[27],"0");}
			else if (report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))
				{
				if(reprint_details[28] != null)
				total_query_records=bean.checkForNull((String)reprint_details[28],"0");}
			else{
				if(reprint_details[24] != null)
				total_query_records=bean.checkForNull((String)reprint_details[24],"0");
			}
			
//			out.println("<script>alert('total_query_records="+total_query_records+"');</script>");
            _bw.write(_wl_block12Bytes, _wl_block12);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("reprint_forms_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block14Bytes, _wl_block14);
}
		
		reprint_details[0] = (reprint_details[0] == null)?"":reprint_details[0];
		reprint_details[1] = (reprint_details[1] == null)?"":reprint_details[1];
		reprint_details[2] = (reprint_details[2] == null)?"":reprint_details[2];
		reprint_details[3] = (reprint_details[3] == null)?"":reprint_details[3];
		reprint_details[4] = (reprint_details[4] == null)?"":reprint_details[4];
		reprint_details[5] = (reprint_details[5] == null)?"":reprint_details[5];
		reprint_details[6] = (reprint_details[6] == null)?"":reprint_details[6];
		reprint_details[7] = (reprint_details[7] == null)?"":reprint_details[7];
		reprint_details[8] = (reprint_details[8] == null)?"":reprint_details[8];
		reprint_details[9] = (reprint_details[9] == null)?"":reprint_details[9];
		reprint_details[10] = (reprint_details[10] == null)?"":reprint_details[10];
		reprint_details[11] = (reprint_details[11] == null)?"":reprint_details[11];
		reprint_details[12] = (reprint_details[12] == null)?"":reprint_details[12];
		reprint_details[13] = (reprint_details[13] == null)?"":reprint_details[13];
		reprint_details[14] = (reprint_details[14] == null)?"":reprint_details[14];
		reprint_details[15] = (reprint_details[15] == null)?"":reprint_details[15];
		reprint_details[16] = (reprint_details[16] == null)?"":reprint_details[16];
		reprint_details[17] = (reprint_details[17] == null)?"":reprint_details[17];
		reprint_details[18] = (reprint_details[18] == null)?"":reprint_details[18];
		reprint_details[19] = (reprint_details[19] == null)?"":reprint_details[19];
		reprint_details[20] = (reprint_details[20] == null)?"":reprint_details[20];
		reprint_details[21] = (reprint_details[21] == null)?"":reprint_details[21];
		reprint_details[22] = (reprint_details[22] == null)?"":reprint_details[22];
		reprint_details[23] = (reprint_details[23] == null)?"":reprint_details[23];
		//out.println("<script>alert("+reprint_details[23]+")</script>");
		if (report_type.equalsIgnoreCase("R"))
			reprint_details[24] = (reprint_details[24] == null)?"":reprint_details[24];
		//out.println("<script>alert("+reprint_details[24]+")</script>");
		else if (report_type.equalsIgnoreCase("C")) {

			reprint_details[24] = (reprint_details[24] == null)?"":reprint_details[24];
			reprint_details[25] = (reprint_details[25] == null)?"":reprint_details[25];
			reprint_details[26] = (reprint_details[26] == null)?"":reprint_details[26];
			//out.println("<script>alert("+reprint_details[24]+")</script>");
		}
	
		else if (report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X")) {
			reprint_details[24] = (reprint_details[24] == null)?"":reprint_details[24];
			reprint_details[25] = (reprint_details[25] == null)?"":reprint_details[25];
			reprint_details[26] = (reprint_details[26] == null)?"":reprint_details[26];
			reprint_details[27] = (reprint_details[27] == null)?"":reprint_details[27];
			//out.println("<script>alert("+reprint_details[27]+")</script>");
		}
		

		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
		
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))?reprint_details[27]:(report_type.equalsIgnoreCase("R")?reprint_details[24]:"")));
            _bw.write(_wl_block17Bytes, _wl_block17);
if (reprint_details[10]== null || reprint_details[10] == "null") reprint_details[10]="";
			String ReprintDate;
			if ( !localeName.equals("en") )
			{ 
				 ReprintDate 	=com.ehis.util.DateUtils.convertDate(reprint_details[10],"DMYHM","en",localeName);
			}
			else
			{
					ReprintDate=reprint_details[10];
			}

			if(reprint_details[11].indexOf("$$RD##")!=-1)
			{
				String[] str = (String[])reprint_details[11].split("!~!");
				String order_detail ="";
				String[] strtitle = null;
				for(int s=0;s<str.length;s++)
				{
					if(str[s].indexOf("$$RD##")!=-1)
					{
						String line_order = (String)str[s];
						strtitle  =line_order.split("::");
						String titleText = "";
						if(strtitle[1].length()>0)
						{
							titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
						}
						else
						{
							titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
						}
						strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
						order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
					}
					else
					{
						order_detail = order_detail+str[s]+", ";
					}
				}
				reprint_details[11] = order_detail;
				if(reprint_details[11].lastIndexOf(",") ==((reprint_details[11].length())-2))
				{
					reprint_details[11] = reprint_details[11] .substring(0,((reprint_details[11].length())-2));
				}
			}
			if(reprint_details[11].indexOf("!~!")!=-1)
			{
				reprint_details[11] =reprint_details[11].replace("!~!",",");
			}
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ReprintDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(reprint_details[2]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reprint_details[7]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reprint_details[23]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reprint_details[8]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reprint_details[11]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(reprint_details[3]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(reprint_details[20]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((report_type.equals("L"))?"disabled":""));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((report_type.equals("C"))?"none":"inline"));
            _bw.write(_wl_block31Bytes, _wl_block31);

				if(report_type.equals("C")){ 	
					//System.out.println("========="+reprint_details[7]+"======="+reprint_details[25]+"==="+reprint_details[24]);
					ArrayList Consents = bean.getConsents(reprint_details[7],reprint_details[25],reprint_details[24]);
					for(int j=0;j<Consents.size();j++){
						String[] record = (String[])Consents.get(j);
						//System.out.println("========="+reprint_details[7]+"======="+reprint_details[25]+"==="+record[2]);
						
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(reprint_details[7]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reprint_details[25]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(Consents.size()!=1)out.println(j+1+". ");
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block35Bytes, _wl_block35);

					}
				}
			
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[7]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[0]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[5]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[8]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[9]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[10]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((report_type.equalsIgnoreCase("C")|| report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))?reprint_details[24]:""));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[12]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[13]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[14]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[15]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[16]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[17]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[19]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((report_type.equalsIgnoreCase("C")|| report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))?reprint_details[25]:""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reprint_details[22]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((report_type.equalsIgnoreCase("R")?reprint_details[24]:(report_type.equalsIgnoreCase("X")||report_type.equalsIgnoreCase("S"))?reprint_details[27]:"")));
            _bw.write(_wl_block77Bytes, _wl_block77);

				}

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(from));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(to));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(report_type));
            _bw.write(_wl_block82Bytes, _wl_block82);
            _bw.write(_wl_block83Bytes, _wl_block83);
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(source_from));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(source_to));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(encntr_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block98Bytes, _wl_block98);
//=bean.getFunctionId()
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(request.getParameter("rep_type")));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(request.getParameter("ord_cat")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(request.getParameter("ord_type")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(request.getParameter("source_from")));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(request.getParameter("source_to")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(request.getParameter("patientId")));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(request.getParameter("locntype")));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(request.getParameter("source_type")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(request.getParameter("locn")));
            _bw.write(_wl_block108Bytes, _wl_block108);

		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ClickLinkToPrintConsentDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
