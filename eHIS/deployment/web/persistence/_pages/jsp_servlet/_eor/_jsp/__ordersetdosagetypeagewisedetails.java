package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ordersetdosagetypeagewisedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetDosageTypeAgeWiseDetails.jsp", 1716354356000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n------------------------------------------------------------------------------------------------------------------------------\nDate       \tEdit History    Name        \tRev.Date\t\tRev.Name\t\tDescription\n------------------------------------------------------------------------------------------------------------------------------\n03/08/2017\tIN062992\t\tDinesh T\t\t07/08/2017\t\tRamesh G\t\tML-MMOH-CRF-0345.1\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCreated this file for this CRF\n21/08/2017\tIN065036\t\tDinesh T\t\t07/08/2017\t\tRamesh G\t\twrong age group range showing in Order Set -Age Wise \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDefinition window\n12/02/2018\tIN065713\t\tDinesh T\t\t12/02/2018\t\tRamesh G\t\tML-MMOH-CRF-0987\n09/08/2018  IN068201        Ramya Maddena    10/08/2018     Ramesh G        Ml-MMOH-SCF-1056\n------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script language=\'javascript\' src=\'../js/OrderSet.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body>\n<form name=\'orderset_dosage_age_dtl_form\' id=\'orderset_dosage_age_dtl_form\'>\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n<tr>\n<td>\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\' class=\'grid\'>\n\t<tr>\n\t\t<td class=\'clicked\' width=\'30%\' id=\'age_grp_tab\' style=\"text-align:center;valign:middle\">\n\t\t<b>Age</b>\n\t\t</td>\n\t\t<td class=\'normal\' width=\'30%\'  id=\'age_grp_add_cata_tab\' style=\"text-align:center;valign:middle\">\n\t\t<b>Additional</b>\n\t\t</td>\n\t\t<td colspan=\'9\' class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t&nbsp;\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=columnheader >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' colspan=\'10\'><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' colspan=\'11\'>&nbsp;</td>\n\t</tr>\n</table>\n</td>\n</tr>\n<tr>\n<td>\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\' align=\'center\' class=\'grid\'><!--IN065713-->\n<tr>\t\n\t<td class=columnheader width=\'1%\'>&nbsp;</td> <!--IN065713-->\n\t<td class=columnheader width=\'10%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=columnheader width=\'15%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td class=columnheader width=\'5%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t<td class=columnheader width=\'15%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td> \n\t<td class=columnheader width=\'10%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=columnheader width=\'10%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n</tr><!--IN065713-->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr>\n\n\t\t<!--<td id=\'add_cata_age_grp";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' style=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><a onclick=\'if(includeAdditionalDosageTypeAgeWise()){loadAdditionalCatalogsAgeWise(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",document.getElementById(\"freq_code\")";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =".value,document.getElementById(\"durn_value\")";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =".value,document.getElementById(\"durn_type_desc\")";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =".value,document.getElementById(\"rel_start_date_time\")";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =".value,document.getElementById(\"route_code\")";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =".value,\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\")}\' id = \'showHideDepDtls";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' href=\"#\">+</a>-->\n\t\t<td id=\'add_cata_age_grp";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",document.getElementById(\"qty_unit\")";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",document.getElementById(\"durn_type\")";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =".value,prompt_msg";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' href=\"#\">+</a>\n\t\t</td><!--IN065713-->\n\t\t<!--<td class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<input type=\'hidden\' name=\'age_group_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'age_group_code";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'/></td>-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'/></td>\n\t\n\t\t<!--IN065036, starts-->\n\t\t<!-- <td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" - ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="All";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td> -->\n\t\t<!--<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>--><!--IN065713-->\n\t\t<!--IN065036, ends-->\n\t\t<!--IN065713, starts-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t<!--IN065713, ends-->\n\t\t\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'><input type=\'text\' name=\'qty_unit";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'qty_unit";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' onKeyPress=\'return(parent.parent.parent.checkValid(this,event,6,5))\' size=\'6\' maxlength=\'6\'   ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' style=\"text-align:right\"></td>\n\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\t\t\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t<SELECT name=\"freq_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"freq_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" onchange=\'parent.parent.parent.getDurnType(this,\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\",\"orderset_dosage_age_dtl_form\")\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="><option value=\"\">--- ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" ---</option>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t \t</SELECT>\n\t\t</td>\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' nowrap>\n\t\t<!--<input type=\"text\" name=\"durn_value";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"durn_value";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" size=\'3\' maxlength=\'3\'\tclass=\"number\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="--><!--IN065713-->\n\t\t<input type=\"text\" name=\"durn_value";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" size=\'3\' maxlength=\'3\' class=\"number\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" onblur=\'parent.parent.parent.OrCheckPositiveNumber1(this)\'\n\t\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">/<input type=\"text\"  disabled name=\"durn_type_desc";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"durn_type_desc";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"\t size=\'3\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="  value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"></td>\n\t\t<input type=\'hidden\' name=\'durn_type";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'durn_type";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t<input type=\"text\" name=\"rel_start_date_time";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"rel_start_date_time";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"\tsize=\'3\'\n\t\tonblur=\'checkDecimal2(this)\'\n\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" class=\'number\' maxlength=\"3\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t<input type=\"hidden\" name=\"route_code";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"route_code";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"text\" name=\"route_desc";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"route_desc";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" size=\'8\' maxlength=\'8\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" onblur=\"parent.parent.parent.show_route_window(route_desc";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =",route_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =",";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =",\'orderset_dosage_age_dtl_form\')\" ><input type=\"button\" name=\"route_button";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"route_button";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" class=\'button\' style=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" value=\'?\' ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" onclick=\"parent.parent.parent.show_route_Lookupwindow(route_desc";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =",\'orderset_dosage_age_dtl_form\')\">\t\n\t\t</td>\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' ><input type=\'checkbox\' name=\'include";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'include";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' onclick=\"chkInclude(\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\',\'orderset_dosage_age_dtl_form\');\" value=\'Y\' ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="  ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="></td>\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' ><a class=\'gridLink\' name=\'Cmts";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' href=\'javascript:parent.parent.parent.showDialog(\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\",\"orderset_dosage_age_dtl_form\")\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</a></td>\n\t\t</tr>\t\t\t\n\t\t\t\n\t\t<INPUT type = \'hidden\' name=\'prompt_msg";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'prompt_msg";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'> \n\t\t<input type=\"hidden\" name=\"qty_uom";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"qty_uom";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t<input type=\"hidden\" name=\"qty_reqd_yn";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"qty_reqd_yn";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t<input type=\"hidden\" name=\"occ_no";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"occ_no";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\t\n<table>\n</td>\n</tr>\n</table>\n\n<input type = \'hidden\' name = \'order_catalog_code\' value = \'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'/>\n<input type = \'hidden\' name = \'order_set_seq_num\' value = \'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'/>\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n<input type=\"hidden\" name=\"age_group_size\" id=\"age_group_size\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<input type=\'hidden\' name=\'detailPageMode\' id=\'detailPageMode\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' >\n<input type = \'hidden\' name = \'order_type_desc\' value = \'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'/><!--IN065713-->\n<input type = \'hidden\' name = \'uom_desc\' value = \'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'/><!--IN065713-->\n<input type = \'hidden\' name = \'p_query_string\' value = \'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'/><!--IN065713-->\n<input type = \'hidden\' name = \'iv_prep_yn\' value = \'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'/><!--IN065713-->\n<input type = \'hidden\' name = \'order_type\' value = \'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'/><!--IN065713-->\n<input type = \'hidden\' name = \'valid\' value = \'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'/>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );
	
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


	String decode(String code)
	{
	  if(code.equalsIgnoreCase("H")) return "Hour(s)";
	  if(code.equalsIgnoreCase("D")) return "Day(s)";
	  if(code.equalsIgnoreCase("W")) return "Week(s)";
	  if(code.equalsIgnoreCase("L")) return "Month(s)";
  	  if(code.equalsIgnoreCase("M")) return "Minute(s)";
  	  if(code.equalsIgnoreCase("Y")) return "Year(s)";
	  return "";
	}

	//IN065036, starts
	String decodeForAgeGrp(String code)
	{
		if(code.equalsIgnoreCase("D")) return "Day";
		if(code.equalsIgnoreCase("H")) return "Hours";
		if(code.equalsIgnoreCase("N")) return "Minute";
		if(code.equalsIgnoreCase("M")) return "Month";
		if(code.equalsIgnoreCase("Y")) return "Year";  	  
		return "";
	}
	//IN065036, ends


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	int i = 0;

	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	String classValue ="gridData";
	String freq_code		  ="";
	String durn_value		  ="";
	String durn_type	      ="";
	String prompt_msg	      ="";
	String rel_start_date_time="";
	String include="";
	String valid   = "";
	String route_code="";
	String route_desc="";
	String dosage_type = "";
	String freq_code_updatable = "Y";
	//String qty_reqd_updatable = "Y";//check style issue
	String route_updatable = "";
	String route_style    = "" ;
	String durn_value_updatable = "y";

	bean.setSettingsAgeGroupStr();
	HashMap   settingsAgeGroupStr	 =  bean.getSettingsAgeGroupStr();	
	
	settingsAgeGroupStr.put("AGE_GROUP_DESC0","ALL");
	settingsAgeGroupStr.put("AGE_GROUP_CODE0","*A");
	settingsAgeGroupStr.put("QTY_UNIT0","");
	settingsAgeGroupStr.put("FREQ_CODE0","");
	settingsAgeGroupStr.put("DURN_VALUE0","");
	settingsAgeGroupStr.put("DURN_TYPE0","");
	settingsAgeGroupStr.put("REL_START_DATE_TIME0","");
	settingsAgeGroupStr.put("ROUTE_CODE0","");
	settingsAgeGroupStr.put("ROUTE_DESC0","");
	settingsAgeGroupStr.put("PROMPT_MSG0","");
	
	Integer	noOfRecTempAgeGroup		 = (Integer)settingsAgeGroupStr.get("noRec");
	int ageGroupSize = noOfRecTempAgeGroup.intValue() ;
	String l_order_catalog_code  = request.getParameter("p_order_catalog_code")==null?"":request.getParameter("p_order_catalog_code");
	String l_qty_uom_code  = request.getParameter("p_qty_uom_code")==null?"":request.getParameter("p_qty_uom_code");
	//String l_qty_uom_desc  = request.getParameter("p_qty_uom_desc")==null?"":request.getParameter("p_qty_uom_desc");
	String l_qty_uom_desc  = request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
	String l_order_catalog_desc  = request.getParameter("p_order_catalog_desc")==null?"":request.getParameter("p_order_catalog_desc");
	String l_order_set_seq_num  = request.getParameter("p_order_set_seq_num")==null?"":request.getParameter("p_order_set_seq_num");
	String l_qty_reqd_yn  = request.getParameter("p_qty_reqd_yn")==null?"":request.getParameter("p_qty_reqd_yn");
	String l_qty_unit  = "";
	//String l_order_type_desc = request.getParameter("p_order_type_desc")==null?"":request.getParameter("p_order_type_desc");//IN065713
	
	//if("".equals(l_order_type_desc))
	String l_order_type_desc = request.getParameter("order_type")==null?"":request.getParameter("order_type");
	
	String l_occ_no = request.getParameter("p_occ_no")==null?"":request.getParameter("p_occ_no");//IN065713
	String l_applicable_to = request.getParameter("applicable_to")==null?"":request.getParameter("applicable_to");
	valid = request.getParameter("valid")==null?"":request.getParameter("valid");
	
	HashMap hashCatalogAgeWise	= (HashMap)bean.getDBAgeWiseCatalogs();
	HashMap hashindex        = new HashMap();
	//IN065713, starts
	String l_min_age = "";		
	String l_max_age = "";
	String l_min_age_unit = "";
	String l_max_age_unit = "";		
	String l_age_group_desc = "";
	String l_age_group_code = "";
	String l_add_cata_age_grp_disp = "visibility:hidden";
	//IN065713, ends

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(l_order_catalog_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

	hashindex = (HashMap)hashCatalogAgeWise.get(l_order_catalog_code);
	for(i=0;i<=ageGroupSize;i++)
	{
		//valid = "";
		
		if(hashindex!=null && hashindex.size()>0 && hashindex.containsKey(settingsAgeGroupStr.get("AGE_GROUP_CODE"+i)))
		{
			HashMap hashindexAgeGrpWise = (HashMap)hashindex.get(settingsAgeGroupStr.get("AGE_GROUP_CODE"+i));
			include = "y";			
			
			l_add_cata_age_grp_disp = "visibility:visible";//IN065713
			
			l_qty_unit = (String)hashindexAgeGrpWise.get("qty_unit");
				if(l_qty_unit==null)l_qty_unit="";

			l_qty_uom_code = (String)hashindexAgeGrpWise.get("qty_uom");
				if(l_qty_uom_code==null)l_qty_uom_code="";	 

			freq_code = (String)hashindexAgeGrpWise.get("freq_code");
				if(freq_code==null)freq_code="";

			durn_value = (String)hashindexAgeGrpWise.get("durn_value");
				if(durn_value==null)durn_value="";

			durn_type = (String)hashindexAgeGrpWise.get("durn_type");
				if(durn_type==null)durn_type="";

			rel_start_date_time  = (String)hashindexAgeGrpWise.get("rel_start_date_time");
				if(rel_start_date_time==null)rel_start_date_time="0";	//IN068201			
			
			route_code = (String)hashindexAgeGrpWise.get("route_code");
				if(route_code==null) route_code="" ;

			route_desc = (String)hashindexAgeGrpWise.get("route_desc");
				if(route_desc==null) route_desc="" ;

			prompt_msg = (String)hashindexAgeGrpWise.get("prompt_msg");
				if(prompt_msg==null) prompt_msg="" ;							
		}
		else
		{
			include = "";	
			l_add_cata_age_grp_disp = "visibility:hidden";//IN065713
			//IN068201 Start.
			//rel_start_date_time  = "";
			  rel_start_date_time  = "0";
			//IN068201 End.
			l_qty_uom_code = "";
			route_desc = "";
			route_code = "" ;
			prompt_msg = "" ;
			freq_code = request.getParameter("p_freq_code")==null?"":request.getParameter("p_freq_code");
			durn_value = request.getParameter("p_durn_code")==null?"":request.getParameter("p_durn_code");
			durn_type = request.getParameter("p_durn_type")==null?"":request.getParameter("p_durn_type");
			l_qty_unit = request.getParameter("p_qty_unit")==null?"":request.getParameter("p_qty_unit");			
			l_qty_uom_code = request.getParameter("p_qty_unit")==null?"":request.getParameter("p_qty_uom_code");
			//l_qty_uom_desc = request.getParameter("p_qty_uom_desc")==null?"":request.getParameter("p_qty_uom_desc");
			l_qty_uom_desc = request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
			route_code = request.getParameter("p_route_code")==null?"":request.getParameter("p_route_code");
			route_desc = request.getParameter("p_route_desc")==null?"":request.getParameter("p_route_desc");
			prompt_msg = request.getParameter("prompt_msg")==null?"":request.getParameter("prompt_msg");
		}
		
		//IN065713, starts
		l_min_age = (String)(settingsAgeGroupStr.get("MIN_AGE"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE"+i));		
		l_max_age = (String)(settingsAgeGroupStr.get("MAX_AGE"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE"+i));
		l_min_age_unit = (String)(settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE_UNIT"+i));
		l_max_age_unit = (String)(settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE_UNIT"+i));
		l_age_group_code = (String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i);
		l_age_group_desc = (String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+i);		
		//IN065713, ends

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(l_add_cata_age_grp_disp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(l_order_catalog_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_qty_uom_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_qty_uom_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_order_catalog_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_order_set_seq_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_qty_unit));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_qty_reqd_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_order_type_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_age_group_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(l_age_group_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(l_add_cata_age_grp_disp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(l_order_catalog_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_qty_uom_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_qty_uom_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_order_catalog_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_order_set_seq_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(l_qty_reqd_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_order_type_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(l_age_group_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(l_age_group_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(l_occ_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(settingsAgeGroupStr.get("AGE_GROUP_DESC"+i) ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(settingsAgeGroupStr.get("AGE_GROUP_CODE"+i)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(l_age_group_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(l_age_group_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(i>0){
            out.print( String.valueOf(settingsAgeGroupStr.get("MIN_AGE"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE"+i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(decode((String)(settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)))));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(settingsAgeGroupStr.get("MAX_AGE"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE"+i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(decode((String)(settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)))));
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(i>0){
            out.print( String.valueOf(settingsAgeGroupStr.get("MIN_AGE"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE"+i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(decodeForAgeGrp((String)(settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)))));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(settingsAgeGroupStr.get("MAX_AGE"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE"+i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(decodeForAgeGrp((String)(settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)))));
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(i>0){
            out.print( String.valueOf(l_min_age));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(decodeForAgeGrp(l_min_age_unit)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(l_max_age));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(decodeForAgeGrp(l_max_age_unit)));
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(eHISFormatter.disabled("n",l_qty_reqd_yn)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(l_qty_unit));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(l_qty_uom_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

			ArrayList frequencyList = bean.getFrequency("PH",l_order_catalog_code) ;
			String[] freqRecord=null;
			for(int freqInd=0; freqInd<frequencyList.size(); freqInd++)
			{
				freqRecord = (String[])frequencyList.get(freqInd);
				
				if(!"".equals(freq_code))
					durn_value_updatable = "n";
				
				if(freq_code.equals(freqRecord[0]))
					out.println("<option value = '"+freqRecord[0]+"'  selected > "+freqRecord[1]+" ");	
				else
					out.println("<option value = '"+freqRecord[0]+"' > "+freqRecord[1]+" ");	 

				out.println("</option>");
			}
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(eHISFormatter.disabled("y",freq_code_updatable)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("A",dosage_type)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(eHISFormatter.disabled("y",durn_value_updatable)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("A",dosage_type)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(decode(durn_type.trim())));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(durn_type.trim()));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("A",dosage_type)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rel_start_date_time));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(eHISFormatter.disabled("y",route_updatable)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("A",dosage_type)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(route_style));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(eHISFormatter.disabled("y",route_updatable)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("A",dosage_type)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(eHISFormatter.disabled("y",valid)));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",include)));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(prompt_msg));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(l_qty_uom_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(l_qty_reqd_yn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(l_occ_no));
            _bw.write(_wl_block118Bytes, _wl_block118);

	}
	
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(l_order_catalog_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(l_order_set_seq_num));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(ageGroupSize));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bean.getDetailPageMode()));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(l_order_type_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(l_qty_uom_desc));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(l_applicable_to));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(l_order_type_desc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(valid));
            _bw.write(_wl_block132Bytes, _wl_block132);

	putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

            _bw.write(_wl_block133Bytes, _wl_block133);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AgeGroupDef.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DurnValue/DurnType.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.TimeFrame.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Comments.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Hrs.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Comments.label", java.lang.String .class,"key"));
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
}
